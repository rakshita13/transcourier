package com.example.rantsonli;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.rantsonli.Models.addressDto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap map;
    public MapView mapView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_mapscheck, container, false);
        try {
            mapView = (MapView) v.findViewById(R.id.mapview);

            mapView.onCreate(savedInstanceState);
            mapView.onResume();
            // Gets to GoogleMap from the MapView and does initialization stuff
            mapView.getMapAsync(this::onMapReady);

            // Changing map type
            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


            // Enable / Disable zooming controls
            map.getUiSettings().setZoomControlsEnabled(true);

            // Enable / Disable my location button
            map.getUiSettings().setMyLocationButtonEnabled(true);

            // Enable / Disable Compass icon
            map.getUiSettings().setCompassEnabled(true);

            // Enable / Disable Rotate gesture
            map.getUiSettings().setRotateGesturesEnabled(true);

            // Enable / Disable zooming functionality
            map.getUiSettings().setZoomGesturesEnabled(true);

            MapsInitializer.initialize(this.getActivity());


        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng jaipurA = new LatLng(27.0238, 74.2179);
//        map.addMarker(new MarkerOptions()
//                .position(jaipurA)
//                .title("Marker in Jaipur"));
////                .setIcon(BitmapFromVector(getContext(), R.drawable.car_topview));
//
//        LatLng jaipurB = new LatLng(27.0239, 74.2179);
//        map.addMarker(new MarkerOptions()
//                .position(jaipurB)
//                .title("Marker in Jaipur"));
//        LatLng jaipurC = new LatLng(27.0240, 74.2179);
//        map.addMarker(new MarkerOptions()
//                .position(jaipurC)
//                .title("Marker in Jaipur"));
//
//        map.moveCamera(CameraUpdateFactory.newLatLng(jaipurA));
//        map.moveCamera(CameraUpdateFactory.newLatLng(jaipurB));
//        map.moveCamera(CameraUpdateFactory.newLatLng(jaipurC));

        List<addressDto> addressList = new ArrayList<>();
        addressDto addressDto = new addressDto();
        addressDto.setLatitude(27.0250);
        addressDto.setLongitude(74.2190);
        addressList.add(addressDto);

        addressDto SecondaddressDto = new addressDto();
        SecondaddressDto.setLatitude(19.0760);
        SecondaddressDto.setLongitude(72.8777);
        addressList.add(SecondaddressDto);

        addressDto Thirdaddress = new addressDto();
        Thirdaddress.setLatitude(26.8467);
        Thirdaddress.setLongitude(80.9462);
        addressList.add(Thirdaddress);
        Double latitude;
        Double longitude;

        List<String> namesList = new ArrayList<>();
        namesList.add("PLot 14 Vaishali Nagar");
        namesList.add("H/5 Banipark");
        namesList.add("Shiv Enclave");

        List<String> snippetsList = new ArrayList<>();
        snippetsList.add("Going To Lucknow via Car");
        snippetsList.add("Going To Lucknow via plane \n Weight limit= 10Kg");
        snippetsList.add("Need to deliver urgent package weight 5kg \n To Lucknow");

        for (int i = 0; i < addressList.size(); i++) {
            try {
                addressDto addressDtocheck = new addressDto();
                addressDtocheck = addressList.get(i);
                System.out.println(addressDto);
                latitude = addressDtocheck.getLatitude();
                longitude = addressDtocheck.getLongitude();
                map.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude, longitude))
                        .title(namesList.get(i))
                        .snippet(snippetsList.get(i))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .alpha(0.7f)
                );
                map.animateCamera(CameraUpdateFactory.zoomTo(20.0f));
                map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude)));


            } catch (Exception e) {
                e.printStackTrace();
            } // end catch
        }
    }




    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);
        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}