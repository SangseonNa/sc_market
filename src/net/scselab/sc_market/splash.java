package net.scselab.sc_market;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
public class splash extends Activity {

	@Override
	protected void onCreate(Bundle savedIntanceState) {
		/*
		 * 지금은 기본적인 핸들로 조작을 통한 splash 만 있지만 후에는 버전 체크 핸들러를 추가 할것임
		 */
		Bundle savedInstanceState = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash); // 띄어질 스플래시 xml 설정 부분
		Handler handle = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				Intent intro = new Intent(splash.this, MainActivity.class);
				startActivity(intro);
				finish();
			}
		};
		handle.sendEmptyMessageDelayed(0, 2000); // 시간 설정 부분 3000 = 3초
	}
}
