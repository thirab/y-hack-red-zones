//package com.example.redzones;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.SupportMapFragment;
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.support.v4.app.FragmentActivity;
//import android.view.Menu;
//
//public class MainActivity extends FragmentActivity {
//	
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        SupportMapFragment fragment = new SupportMapFragment();
////        GoogleMap map = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        SupportMapFragment fragment = new SupportMapFragment();
//        getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
//    }
//    
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.main, menu);
////        return true;
////    }
//    
//}

package com.example.redzones;

import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	GoogleMap map;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeCircleButton();

    }
    
    private void makeCircleButton() {
        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                newCircle();
            }
        };

        Button button = (Button) findViewById(R.id.add_circular_area);
        button.setOnClickListener(onClickListener);
    }

    public void newCircle() {
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        // Instantiates a new CircleOptions object and defines the center and
        // radius
        CircleOptions circleOptions = new CircleOptions().center(
                new LatLng(37.4, -122.1)).radius(1000); // In meters
        mMap.addCircle(circleOptions);

        // Get back the mutable Circle
        // Circle circle = mMap.addCircle(circleOptions);
    }
}