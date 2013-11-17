package net.scselab.sc_sub_location;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;
import net.scselab.sc_market.MainActivity;
import net.scselab.sc_market.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class backup_location extends Activity implements
		MapView.OpenAPIKeyAuthenticationResultListener,
		MapView.MapViewEventListener, MapView.CurrentLocationEventListener,
		MapView.POIItemEventListener, LocationListener {
	private MapPOIItem poiItem;
	private MapView mapView; // 맵뷰 생성
	private String API_KEY = "61d4a27182019f17407c7045f7a36d85b5dc5d7c"; // api
	MapPOIItem market; // 아랫장 위치 마커 객체 선언
	String MARKET_NAME = "아랫장";
	Criteria criteria = null;
	LocationManager locationManager = null;
	Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		// LinearLayout linearLayout = new LinearLayout(this);
		RelativeLayout map = (RelativeLayout) findViewById(R.id.mapview);
		mapView = new MapView(this);
		mapView.removeAllPOIItems();
		mapView.setDaumMapApiKey(API_KEY);
		mapView.setOpenAPIKeyAuthenticationResultListener(this);
		mapView.setMapViewEventListener(this);
		mapView.setCurrentLocationEventListener(this);
		mapView.setPOIItemEventListener(this);
		mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(
				34.94623653649619, 127.49423234870194), true); // 초기화 설정
		mapView.setZoomLevel(1, true);
		mapView.setMapType(MapView.MapType.Standard);
		/*
		 * 전통시장 마커 표시
		 */
		poiItem = new MapPOIItem();
		poiItem.setItemName("City on a Hill");
		poiItem.setMapPoint(MapPoint.mapPointWithGeoCoord(34.94623653649619,
				127.49423234870194));
		poiItem.setMarkerType(MapPOIItem.MarkerType.BluePin);
		poiItem.setShowAnimationType(MapPOIItem.ShowAnimationType.DropFromHeaven);
		poiItem.setTag(1);
		mapView.addPOIItem(poiItem);
		//
		// Button button = new Button(this);
		// button.setLayoutParams(new
		// LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		// button.setText("button");

		RelativeLayout rl = new RelativeLayout(this);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		rl.setLayoutParams(params);

		/** 중간 버튼 추가 */
		Button middleButton = new Button(this);
		middleButton.setId(2);
		middleButton.setText("내위치");
		RelativeLayout.LayoutParams middleButtonParams = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		// addRule : RelativeLayout의 lign 속성을 설정해 준다.
		// middleButtonParams.addRule(verb, anchor)
		// verb : 적용될 속성
		// anchor : 기준이될 View
		middleButtonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM); // 아래쪽
																		// 설정
		middleButtonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT); // 아래쪽 설정

		middleButton.setLayoutParams(middleButtonParams);

		/** 하단 버튼 추가 */
		Button bottomButton = new Button(this);
		bottomButton.setId(3);
		bottomButton.setText("아랫장");
		RelativeLayout.LayoutParams bottomButtonParams = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		bottomButtonParams.addRule(RelativeLayout.ALIGN_BOTTOM, 2);
		bottomButtonParams.addRule(RelativeLayout.LEFT_OF, 2);

		bottomButton.setLayoutParams(bottomButtonParams);

		// RelativeLayout에 차일드 View 추가
		rl.addView(middleButton);
		rl.addView(bottomButton);
		//여기 까지 버튼 추가 끝
		
		
		
		
		
		
		map.addView(mapView); // 최종적으로 맵 보여주는것이고
		map.addView(rl);
		
		
		
		
		
		
		middleButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
				
			}
		});
		bottomButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mapView.setMapCenterPointAndZoomLevel(
						MapPoint.mapPointWithGeoCoord(34.94623653649619,
								127.49423234870194), 2, true);
			}
		});
		
		
	
		
		
		// map.addView(button);
		ImageButton home = (ImageButton) findViewById(R.id.Menu_Top_home);
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intro = new Intent(backup_location.this, MainActivity.class);
				startActivity(intro);
				finish();
			}
		});

	}

	@Override
	public void onCalloutBalloonOfPOIItemTouched(MapView mapView,
			MapPOIItem poiItem) {
		// TODO Auto-generated method stub
		if (poiItem.getTag() == 1) {
			Toast toast3 = Toast.makeText(this, "3", Toast.LENGTH_SHORT);
			toast3.show();

		}
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
	public void onCurrentLocationDeviceHeadingUpdate(MapView mapView,
			float headingAngle) {
		Log.i("ERROR",
				String.format(
						"MapView onCurrentLocationDeviceHeadingUpdate: device heading = %f degrees",
						headingAngle));
	}

	@Override
	public void onCurrentLocationUpdate(MapView mapView,
			MapPoint currentLocation, float accuracyInMeters) {
		MapPoint.GeoCoordinate mapPointGeo = currentLocation
				.getMapPointGeoCoord();

		Log.i("ERROR", String.format(
				"MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)",
				mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
	}

	@Override
	public void onCurrentLocationUpdateCancelled(MapView arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCurrentLocationUpdateFailed(MapView arg0) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage("Current Location Update Failed!");
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();

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

	@Override
	public void onLocationChanged(Location location) {

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}