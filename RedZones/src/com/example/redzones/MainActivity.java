package com.example.redzones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	GoogleMap mapMine;
	Location location;
	Database db = new Database();

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
        try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapMine.setMyLocationEnabled(true);
        mapMine.getUiSettings().setMyLocationButtonEnabled(false);
        mapMine.getUiSettings().setCompassEnabled(true);
        
//        mapMine.getMyLocation();
        location = this.getMyLocation();
        
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(location.getLatitude(), location.getLongitude())).zoom(12).build();
 
        mapMine.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        

    }
    
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (mapMine == null) {
            mapMine = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (mapMine == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
    
    private Location getMyLocation() {
        // Get location from GPS if it's available
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // Location wasn't found, check the next most accurate place for the
        // current location
        if (myLocation == null) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            // Finds a provider that matches the criteria
            String provider = lm.getBestProvider(criteria, true);
            // Use the provider to get the last known location
            myLocation = lm.getLastKnownLocation(provider);
        }
        return myLocation;
    }
    
    public void pushSomething(View view)
    {
    	Context context = getApplicationContext();
     	Toast.makeText(context, "Pushing Alarm Now!", Toast.LENGTH_SHORT).show();
     	
     	EditText editText = (EditText) findViewById(R.id.alarm_message);
     	String alarmMessage = editText.getText().toString();
     	double lng = location.getLongitude();
     	double ltd = location.getLatitude();
     	MarkerOptions marker = new MarkerOptions().position(new LatLng(ltd, lng)).title(alarmMessage);
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        // adding marker
        mapMine.addMarker(marker);
        
        UserProfile uf = new UserProfile(((EditText) findViewById(R.id.username)).getText().toString());
        PinObject newPin = new PinObject();
        newPin.setLattitude(ltd);
        newPin.setLongtitude(lng);
        newPin.setPid(Double.toString(ltd+lng));
        newPin.setStatus(1);
        newPin.setTime(System.currentTimeMillis());
        uf.setPins(newPin);
        //do database stuff here
        db.addProfile(uf);
        
        TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setText(uf.toString());
        setContentView(textView);
    }
    
//    public void writeToServer(ArrayList a) throws IOException{
//		File file = new File("server.txt");
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
//		
//		for(int i =0; i<a.size(); i++){
//			
//		bw.write((Integer) a.get(i)+"+");
//		}
//		bw.close();
//
//	}
//	
//	public void readServer() throws IOException{
//		File f=new File("server.txt");
//		BufferedReader br = new BufferedReader(new FileReader(f));
//		String s = br.readLine();
//		while(s!=null){
//			String[] result = s.split("+");
//			//TODO deal with data
//			s = br.readLine();
//		}
//		br.close();
//	}
}