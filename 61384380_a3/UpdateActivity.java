package za.unisa.s61384380_a3;

//imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.*;
import android.widget.*;
import java.util.*;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;

public class UpdateActivity extends Activity implements OnItemSelectedListener{

	//declaring variables 
	Button butPrev, butSaveUpd;
	// Spinner element
	Spinner spnTitle;
	EditText edtName, edtSurname, edtPhone, edtSMS;
	static final int READ_BLOCK_SIZE = 100;
	
	//links the java file to the xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        
        //assigning variables to values from the widgets
        edtName = (EditText)findViewById(R.id.edName);
        edtSurname = (EditText)findViewById(R.id.edSurname);
        edtPhone = (EditText)findViewById(R.id.etDecMobNum);
        edtSMS = (EditText)findViewById(R.id.edMessage);
        spnTitle = (Spinner)findViewById(R.id.spTitle);	
        
        // Spinner click listener
        spnTitle.setOnItemSelectedListener(this);
        
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select Title");
        categories.add("Mr");
        categories.add("Mrs");
        categories.add("Ms");
        categories.add("Prof");
        categories.add("Dr");
        categories.add("Pastor");
        
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // attaching data adapter to spinner
        spnTitle.setAdapter(dataAdapter);

    
        //code the back button
        butPrev = (Button)findViewById(R.id.btnPrev2);
        butPrev.setOnClickListener(new View.OnClickListener() { 
    	    @Override
    	    public void onClick(View v) {
    		    //open another activity/screen.
    	    	Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
    	    	  startActivity(intent);
    	    }
    	 });       
        //end code of back button 
        
      //code the save and update button
        butSaveUpd = (Button)findViewById(R.id.btnSaveUpd2);
        butSaveUpd.setOnClickListener(new View.OnClickListener() { 
        	// add-write text into file
    	    public void onClick(View v) {
    	    	// add-write text into file
    	    	//error handling within the text file
    	        try {
    	        	//file output stream and creates a new file
    	           FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
    	           OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
    	           outputWriter.write(edtPhone.getText().toString() + "/n");
    	           outputWriter.write(edtName.getText().toString() + "/n");
    	           outputWriter.write(edtSurname.getText().toString() + "/n");
    	           outputWriter.write(edtSMS.getText().toString() + "/n");
    	           //outputWriter.write(spnTitle.getText().toString());
    	           //close the file
    	           outputWriter.close();
    	           //display file saved message
    	           Toast.makeText(getBaseContext(), "File saved successfully!",
    	           Toast.LENGTH_SHORT).show();
    	        } //catch method
    	        catch (Exception e) {
    	           e.printStackTrace();
    	        }
    	    }
    	 });       
        //end code of save and update button 
        
    
    }
    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // On selecting a spinner item
       String item = parent.getItemAtPosition(position).toString();
       
       // Showing selected spinner item
       Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    
    public void onNothingSelected(AdapterView<?> arg0) {
       // TODO Auto-generated method stub
    }

}
