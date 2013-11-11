package net.scselab.sc_market;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
public class splash extends Activity {

	protected void onCreate(Bundle savedIntanceState) {
		
		Bundle savedInstanceState = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash); // 띄어질 스플래시 xml 설정 부분
		Handler handle = new Handler() {
			public void handleMessage(Message msg) {
				finish();
			}
		};
		handle.sendEmptyMessageDelayed(0, 1000); // 시간 설정 부분 3000 = 3초
	}
}
