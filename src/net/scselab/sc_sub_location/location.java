package net.scselab.sc_sub_location;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;
import net.scselab.sc_market.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class location extends Activity implements
		MapView.OpenAPIKeyAuthenticationResultListener,
		MapView.MapViewEventListener, MapView.CurrentLocationEventListener,
		MapView.POIItemEventListener {

	private MapView mapView; //맵뷰 생성
	private String API_KEY ="61d4a27182019f17407c7045f7a36d85b5dc5d7c";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
//		LinearLayout linearLayout = new LinearLayout(this);
		LinearLayout mapview = (LinearLayout)findViewById(R.id.mapview);
		mapView = new MapView(this);

		mapView.setDaumMapApiKey(API_KEY);
		mapView.setOpenAPIKeyAuthenticationResultListener(this);
		mapView.setMapViewEventListener(this);
		mapView.setCurrentLocationEventListener(this);
		mapView.setPOIItemEventListener(this);
		mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(34.94623653649619, 127.49423234870194), true);
		mapView.setZoomLevel(3, true);
		mapView.setMapType(MapView.MapType.Standard);

		mapview.addView(mapView);

		
	}

	@Override
	public void onCalloutBalloonOfPOIItemTouched(MapView arg0, MapPOIItem arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraggablePOIItemMoved(MapView arg0, MapPOIItem arg1,
			MapPoint arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPOIItemSelected(MapView arg0, MapPOIItem arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCurrentLocationDeviceHeadingUpdate(MapView arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCurrentLocationUpdate(MapView arg0, MapPoint arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCurrentLocationUpdateCancelled(MapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCurrentLocationUpdateFailed(MapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapViewCenterPointMoved(MapView arg0, MapPoint arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapViewDoubleTapped(MapView arg0, MapPoint arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapViewInitialized(MapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapViewLongPressed(MapView arg0, MapPoint arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapViewSingleTapped(MapView arg0, MapPoint arg1) {
		// TODO Auto-generated method stub
		mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(34.94623653649619, 127.49423234870194), true);
		mapView.setZoomLevel(-2, true);
	}

	@Override
	public void onMapViewZoomLevelChanged(MapView arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDaumMapOpenAPIKeyAuthenticationResult(MapView arg0, int arg1,
			String arg2) {
		// TODO Auto-generated method stub
		
	}
}