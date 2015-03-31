package ro.pub.cs.systems.pdsd.practicaltest01;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class PracticalTestActivity extends Activity {
	
	private EditText upEditText;
	private EditText downEditText;

	private CheckBox upCheckBox;
	private CheckBox downCheckBox;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test);
		
		upEditText = (EditText)findViewById(R.id.editText1);
		downEditText = (EditText)findViewById(R.id.editText2);
		
		upCheckBox = (CheckBox) findViewById(R.id.checkBox1);
		downCheckBox = (CheckBox) findViewById(R.id.checkBox2);
		
		upEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				 
				Is_Valid_Email(upEditText);
				
			}
			
			public void Is_Valid_Email(EditText edt) {
	            if (edt.getText().toString() == null) {
	                upCheckBox.setChecked(false);
	            } else if (isEmailValid(edt.getText().toString()) == false) {
	                upCheckBox.setChecked(false);
	     
	            } else {
	                upCheckBox.setChecked(true);
	            }
	        }

	        boolean isEmailValid(CharSequence email) {
	            return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
	                    .matches();
	        }
		});
		
		
		downEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String text = downEditText.getText().toString();
				if (text.matches("[0-9]+") && text.length() > 5) {
					downCheckBox.setChecked(true);
				} else {
					downCheckBox.setChecked(false);
				}
				
			}
		});
		
		if (savedInstanceState != null ) {
			String upEditText = savedInstanceState.getString("upEdittext");
			String downEditText = savedInstanceState.getString("downEditText");
			boolean upCheck = savedInstanceState.getBoolean("upCheckBox1");
			boolean downCheck = savedInstanceState.getBoolean("downCheckBox1");
			if (upEditText != null) {
				this.upEditText.setText(upEditText);
				upCheckBox.setChecked(upCheck);
			}
			
			if(downEditText != null) {
				this.downEditText.setText(downEditText);
				downCheckBox.setChecked(downCheck);
			}
			
		} else {
			upEditText.setText("");
			downEditText.setText("");
			upCheckBox.setChecked(false);
			downCheckBox.setChecked(false);
			
		}
		
		
	}

	 @Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
		 savedInstanceState.putString("upEdittext", upEditText.getText().toString());
		 savedInstanceState.putString("downEdittext", downEditText.getText().toString());
		 savedInstanceState.putBoolean("upCheckBox1", upCheckBox.isChecked());
		 savedInstanceState.putBoolean("downCheckBox1", downCheckBox.isChecked());
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
