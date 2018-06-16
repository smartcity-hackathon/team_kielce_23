package mprzenzak.com.drivewith;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    public void onSearch(View view) {
        EditText location_tf = (EditText) findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }



    public void changeType(View view) {
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMapAsync(this);
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(20.586736, 50.898478)).title("Marker"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap = googleMap;
        LatLng targi = new LatLng(50.898730, 20.586705);
        mMap.addMarker(new MarkerOptions().position(targi).title("Here you are").icon(BitmapDescriptorFactory.fromResource(R.drawable.wot)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(targi));
        mMap.setMaxZoomPreference(20);
        mMap.setMinZoomPreference(10);


        // Enabling MyLocation Layer of Google Map
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);


    }}



//mycode


//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.FragmentActivity;
//import android.view.View;
//import android.widget.EditText;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import java.io.IOException;
//import java.util.List;
//
//class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        setUpMapIfNeeded();
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        setUpMapIfNeeded();
//    }
//
//
//    public void onSearch(View view) {
//        EditText location_tf = (EditText) findViewById(R.id.TFaddress);
//        String location = location_tf.getText().toString();
//        List<Address> addressList = null;
//        if (location != null || !location.equals("")) {
//            Geocoder geocoder = new Geocoder(this);
//            try {
//                addressList = geocoder.getFromLocationName(location, 1);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Address address = addressList.get(0);
//            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//
//        }
//    }
//
//
//
//    public void changeType(View view) {
//        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
//            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        } else
//            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//    }
//
//    private void setUpMapIfNeeded() {
//        // Do a null check to confirm that we have not already instantiated the map.
//        if (mMap == null) {
//            // Try to obtain the map from the SupportMapFragment.
//            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
//                    .getMapAsync(this);
//            // Check if we were successful in obtaining the map.
//            if (mMap != null) {
//                setUpMap();
//            }
//        }
//    }
//
//    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//
//
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//
//
//        mMap = googleMap;
//        LatLng targi = new LatLng(50.898730, 20.586705);
//        mMap.addMarker(new MarkerOptions().position(targi).title("Here you are").icon(BitmapDescriptorFactory.fromResource(R.drawable.wot)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(targi));
//        mMap.setMaxZoomPreference(20);
//        mMap.setMinZoomPreference(10);
//
//
//        // Enabling MyLocation Layer of Google Map
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        googleMap.setMyLocationEnabled(true);
//
//
//    }}
//
//
////mycode
//
//
////import android.Manifest;
////import android.content.pm.PackageManager;
////import android.location.Address;
////import android.location.Geocoder;
////import android.support.v4.app.ActivityCompat;
////import android.support.v4.app.FragmentActivity;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.EditText;
////
////import com.google.android.gms.maps.CameraUpdateFactory;
////import com.google.android.gms.maps.GoogleMap;
////import com.google.android.gms.maps.OnMapReadyCallback;
////import com.google.android.gms.maps.SupportMapFragment;
////import com.google.android.gms.maps.model.BitmapDescriptorFactory;
////import com.google.android.gms.maps.model.LatLng;
////import com.google.android.gms.maps.model.MarkerOptions;
////
////import java.io.IOException;
////import java.util.List;
////
////public class MapsActivityTest extends FragmentActivity implements OnMapReadyCallback {
////
////    private GoogleMap mMap;
////
//////    @Override
//////    protected void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////        setContentView(R.layout.activity_maps_test);
//////        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//////                .findFragmentById(R.id.map);
//////        mapFragment.getMapAsync(this);
//////    }
//////    public void onSearch(View view) {
//////        EditText location_tf = (EditText) findViewById(R.id.findAddress);
//////        String location = location_tf.getText().toString();
//////        List<Address> addressList = null;
//////        if (location != null || !location.equals("")) {
//////            Geocoder geocoder = new Geocoder(this);
//////            try {
//////                addressList = geocoder.getFromLocationName(location, 1);
//////
//////
//////            } catch (IOException e) {
//////                e.printStackTrace();
//////            }
//////
//////            Address address = addressList.get(0);
//////            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//////            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//////            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//////
//////        }
//////    }
//////
//////    /**
//////     * Manipulates the map once available.
//////     * This callback is triggered when the map is ready to be used.
//////     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//////     * we just add a marker near Sydney, Australia.
//////     * If Google Play services is not installed on the device, the user will be prompted to install
//////     * it inside the SupportMapFragment. This method will only be triggered once the user has
//////     * installed Google Play services and returned to the app.
//////     */
//////    @Override
//////    public void onMapReady(GoogleMap googleMap) {
//////        mMap = googleMap;
//////
//////        // Add a marker in Sydney and move the camera
//////        LatLng sydney = new LatLng(-34, 151);
//////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//////        mMap.setMinZoomPreference(13);
//////    }
//////}
////
////
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_maps);
////        setUpMapIfNeeded();
////
////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
////                .findFragmentById(R.id.map);
////        mapFragment.getMapAsync(this);
////    }
////
////    @Override
////    protected void onResume() {
////        super.onResume();
////        setUpMapIfNeeded();
////    }
////
////
////    public void onSearch(View view) {
////        EditText location_tf = (EditText) findViewById(R.id.TFaddress);
////        String location = location_tf.getText().toString();
////        List<Address> addressList = null;
////        if (location != null || !location.equals("")) {
////            Geocoder geocoder = new Geocoder(this);
////            try {
////                addressList = geocoder.getFromLocationName(location, 1);
////
////
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////
////            Address address = addressList.get(0);
////            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
////            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
////            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
////
////        }
////    }
////
////
////
////    public void changeType(View view) {
////        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
////            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
////        } else
////            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
////    }
////
////    private void setUpMapIfNeeded() {
////        // Do a null check to confirm that we have not already instantiated the map.
////        if (mMap == null) {
////            // Try to obtain the map from the SupportMapFragment.
////            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
////                    .getMapAsync(this);
////            // Check if we were successful in obtaining the map.
////            if (mMap != null) {
////                setUpMap();
////            }
////        }
////    }
////
////    private void setUpMap() {
////        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
////        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            // TODO: Consider calling
////            //    ActivityCompat#requestPermissions
////            // here to request the missing permissions, and then overriding
////            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////            //                                          int[] grantResults)
////            // to handle the case where the user grants the permission. See the documentation
////            // for ActivityCompat#requestPermissions for more details.
////            return;
////        }
////        mMap.setMyLocationEnabled(true);
////
////
////    }
////
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////
////
////
////        mMap = googleMap;
////        LatLng targi = new LatLng(50.898730, 20.586705);
////        mMap.addMarker(new MarkerOptions().position(targi).title("Here you are").icon(BitmapDescriptorFactory.fromResource(R.drawable.wot)));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(targi));
////        mMap.setMaxZoomPreference(20);
////        mMap.setMinZoomPreference(10);
////
////
////        // Enabling MyLocation Layer of Google Map
////        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            // TODO: Consider calling
////            //    ActivityCompat#requestPermissions
////            // here to request the missing permissions, and then overriding
////            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////            //                                          int[] grantResults)
////            // to handle the case where the user grants the permission. See the documentation
////            // for ActivityCompat#requestPermissions for more details.
////            return;
////        }
////        googleMap.setMyLocationEnabled(true);
////
////
////    }}
