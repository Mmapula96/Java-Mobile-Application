package za.unisa.s61384380_a3;

/**
 * Full Name: Mmapula Rammutla
 * Student Number: 61384380
 * Module Code: ICT2612
 * Assignment No: 3
 * Purpose: The purpose of this app is to give them a “one-stop” interface 
 * with the minimum number of buttons. These buttons will be the most essential 
 * buttons required when using a smart phone. The application should also 
 * have an “EMERGENCY” button that will send an SMS to a pre-defined mobile number 
 * with a short message and the GPS location of the person in distress.
 */



//imports
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.*;
import android.widget.*;
import android.app.Activity;
import android.content.*;

public class MainActivity extends Activity {
	
	//declaring variable for widgets
	Button butExit, butUpdate, butDial, butCont, butAnsw, butDecl, butEme;

	//links the java file to the xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    //code the exit button
    butExit = (Button)findViewById(R.id.btnExit);
    butExit.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(View v) {
		    //Finish method is used to close all open activities.
		    finish();
		    System.exit(0);
	    }
	 });       
    //end code of exit button 
    
    //code the update button
    butEme = (Button)findViewById(R.id.btnEmer);
    butEme.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(View v) {
	    	 try {
	    		 Intent callIntent = new Intent(Intent.ACTION_CALL);
	    		    callIntent.setData(Uri.parse("tel:10111"));
	    		    startActivity(callIntent);
             }catch(Exception e) {
                 Toast.makeText(getApplicationContext(),"Your call has failed...",
                     Toast.LENGTH_LONG).show();
                 e.printStackTrace();
             }
	    }
	 });             
    //end code of update button 
    
    //code the emergency button
    butUpdate = (Button)findViewById(R.id.btnUpdate);
    butUpdate.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(View v) {
		    //open another activity/screen.
	    	Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
	    	  startActivity(intent);
	    }
	 });       
    //end code of emergency button 
    
   
  //code the answer call button
    butAnsw = (Button)findViewById(R.id.btnAnsw);
    butAnsw.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(final View v) {
	    	 Intent intent = new Intent("android.intent.action.ANSWER");
	            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(intent);
	    }
	 });       
    //end code of answer call button 
    
  //code the decline call button
    butDecl = (Button)findViewById(R.id.btnDecl);
    butDecl.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(final View v) {
	    	 Intent intent = new Intent("android.intent.action.DECLINE");
	            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(intent);
	    }
	 });       
    //end code of decline call button
    
  //code the dial button
    butDial = (Button)findViewById(R.id.btnCall);
    butDial.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(View v) {
	    	 try {
	    		 Intent callIntent = new Intent(Intent.ACTION_CALL);
	    		    callIntent.setData(Uri.parse("tel:0721201062"));
	    		    startActivity(callIntent);
             }catch(Exception e) {
                 Toast.makeText(getApplicationContext(),"Your call has failed...",
                     Toast.LENGTH_LONG).show();
                 e.printStackTrace();
             }
	    }
	 });       
    //end code of dial button 
    
  //code the contact button
    butCont = (Button)findViewById(R.id.btnContact);
    butCont.setOnClickListener(new View.OnClickListener() { 
	    @Override
	    public void onClick(View v) {
	    	Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

	        startActivityForResult(intent, 1);
	    }
	 });       
    //end code of contact button 
        
    }
    
}
