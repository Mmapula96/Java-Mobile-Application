package za.unisa.s61384380_a3;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GPSActivity extends Activity {

   Button btnShowLocation;
   //private static final int REQUEST_CODE_PERMISSION = 2;
   String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

   // GPSTracker class
   GPSTracker gps;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
		
     
      //btnShowLocation = (Button) findViewById(R.id.button);

      // show location button click event
      btnShowLocation.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View arg0) {
            // create class object
            gps = new GPSTracker(GPSActivity.this);

            // check if GPS enabled
            if(gps.canGetLocation()){

               double latitude = gps.getLatitude();
               double longitude = gps.getLongitude();

               // \n is for new line
               Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                  + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            }else{
               // can't get location
               // GPS or Network is not enabled
               // Ask user to enable GPS/network in settings
               gps.showSettingsAlert();
            }

         }
      });
   
      }
}