package net.scselab.sc_sub_location;

import net.scselab.sc_market.MainActivity;
import net.scselab.sc_market.R;
import net.scselab.sc_market.splash;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapCompassManager;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapLocationManager.OnLocationChangeListener;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapMyLocationOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay.OnStateChangeListener;

public class location extends NMapActivity implements OnMapStateChangeListener,
		OnMapViewTouchEventListener, LocationListener {
	public static final String API_KEY = "1e1bab863a8b08b749543e8c7fc58714";
	NMapView mMapView = null;
	NMapController mMapController = null;
	LinearLayout MapContainer;
	// /위에까지 기본적인 지도 작성
	NMapViewerResourceProvider mMapViewerResourceProvider = null;
	NMapOverlayManager mOverlayManager;
	OnStateChangeListener onPOIdataStateChangeListener = null;
	NMapPOIdataOverlay poiDataOverlay;
	NMapPOIdata poiData;
	//gps 부분
	NMapLocationManager mMapLocationManager;
	NMapCompassManager mMapCompassManager;
	// 이부분은 까지는 오버레이
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.location);
		
		//home 버튼 이벤트
		ImageButton home = (ImageButton)findViewById(R.id.Menu_Top_home);
		home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intro = new Intent(location.this, MainActivity.class);
				startActivity(intro);
				finish();
			}
		});
		/*
		 * 아래 까지는 지도 초기화 작업임
		 */
		MapContainer = (LinearLayout) findViewById(R.id.mapview);
		mMapView = new NMapView(this);
		mMapView.setApiKey(API_KEY);
		mMapView.setClickable(true);
		mMapView.setOnMapStateChangeListener(this);
		mMapView.setOnMapViewTouchEventListener(this);
		mMapController = mMapView.getMapController();
		mMapView.setBuiltInZoomControls(true, null);
		mMapController.setZoomLevelConstraint(7, 15);
		/*
		 * 여기까지 초기화 생성끝
		 */

		/*
		 * 아래 부터는 마커 할당임
		 */
		// 오버래이 리소스 관리객체 할당
		mMapViewerResourceProvider = new NMapViewerResourceProvider(this);
		// 오버래이 관리자 추가
		mOverlayManager = new NMapOverlayManager(this, mMapView,
				mMapViewerResourceProvider);
		// 오버래이에 표시하기 위한 마커 이미지의 id값 생성
		int markerId = NMapPOIflagType.PIN;
		// 표시할 위치 데이터를 지정한다. -- 마지막 인자가 오버래이를 인식하기 위한 id값
		poiData = new NMapPOIdata(2, mMapViewerResourceProvider);
		poiData.beginPOIdata(2);
		poiData.addPOIitem(127.4942264, 34.9460118, "아랫장", markerId, 0);
		poiData.endPOIdata();
		// 위치 데이터를 사용하여 오버래이 생성
		poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
		// id값이 0으로 지정된 모든 오버레이가 표시되고 있는 위치로
		// 지도의 중심과 ZOOM을 재설정
		// poiDataOverlay.showAllPOIdata(1);
		/*
		 * 아래는 최종적으로 MapContainer 에 mMapView 추가 하는 것
		 */
		NMapLocationManager MapLocationManager = new NMapLocationManager(this);
		OnLocationChangeListener onMyLocationChangeListener = null;
		mMapLocationManager.setOnLocationChangeListener(onMyLocationChangeListener);

		// compass manager
		mMapCompassManager = new NMapCompassManager(this);

		// create my location overlay
		NMapMyLocationOverlay mMyLocationOverlay = mOverlayManager.createMyLocationOverlay(mMapLocationManager, mMapCompassManager); 
		


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
		if (errorInfo == null) {
			mMapController.setMapCenter(new NGeoPoint(127.4942264, 34.9460118),
					14);
		} else {
			android.util.Log.e("NMAP",
					"onMapInitHandler: error=" + errorInfo.toString());
		}

	}

	@Override
	public void onZoomLevelChange(NMapView arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

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
