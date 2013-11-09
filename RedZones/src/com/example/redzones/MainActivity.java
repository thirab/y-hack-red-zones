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

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}