package net.scselab.sc_sub_location;

import net.scselab.sc_market.R;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;


public class location extends NMapActivity implements OnMapStateChangeListener, OnMapViewTouchEventListener {
	public static final String API_KEY = "1e1bab863a8b08b749543e8c7fc58714";
	NMapView mMapView = null;
	NMapController mMapController = null;
	LinearLayout MapContainer;
	///위에까지 기본적인 지도 작성
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		MapContainer = (LinearLayout)findViewById(R.id.mapview);
		mMapView = new NMapView(this);
		mMapView.setApiKey(API_KEY);
		mMapView.setClickable(true);
		mMapView.setOnMapStateChangeListener(this);
		mMapView.setOnMapViewTouchEventListener(this);
		mMapController = mMapView.getMapController();
		mMapView.setBuiltInZoomControls(true, null);
		
		
		
		
		
		
		
		
		
		
		
		
		MapContainer.addView(mMapView);
		
		
	}
	@Override
	public void onLongPress(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLongPressCanceled(NMapView arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScroll(NMapView arg0, MotionEvent arg1, MotionEvent arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSingleTapUp(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTouchDown(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTouchUp(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAnimationStateChange(NMapView arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMapCenterChange(NMapView arg0, NGeoPoint arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMapCenterChangeFine(NMapView arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMapInitHandler(NMapView mapview, NMapError errorInfo) {
		// TODO Auto-generated method stub
		if(errorInfo == null) {
			mMapController.setMapCenter(new NGeoPoint(126.978371,37.5666091), 11);
		} else {
			android.util.Log.e("NMAP", "onMapInitHandler: error=" + errorInfo.toString());
		}
		
	}
	@Override
	public void onZoomLevelChange(NMapView arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
