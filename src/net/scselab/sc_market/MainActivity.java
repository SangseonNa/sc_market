package net.scselab.sc_market;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		startActivity(new Intent(this, splash.class)); // 스플래시 class 먼저
		setContentView(R.layout.menu); // 핸들러에 의해 종료 된후 activity 시작
		ImageButton MenuBtn1 = (ImageButton) findViewById(R.id.Menu_btn_1);
		ImageButton MenuBtn2 = (ImageButton) findViewById(R.id.Menu_btn_2);
		ImageButton MenuBtn3 = (ImageButton) findViewById(R.id.Menu_btn_3);
		ImageButton MenuBtn4 = (ImageButton) findViewById(R.id.Menu_btn_4);
		MenuBtn1.setOnClickListener(this);
		MenuBtn2.setOnClickListener(this);
		MenuBtn3.setOnClickListener(this);
		MenuBtn4.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Menu_btn_1:
			//1번 토스트 테스트
			Toast toast1 = Toast.makeText(this, "1", Toast.LENGTH_SHORT);
			toast1.show();
			break;
		case R.id.Menu_btn_2:
			//2번 토스트 테스트
			Toast toast2 = Toast.makeText(this, "2", Toast.LENGTH_SHORT);
			toast2.show();
			break;
		case R.id.Menu_btn_3:
			//3번 토스트 테스트
			Toast toast3 = Toast.makeText(this, "3", Toast.LENGTH_SHORT);
			toast3.show();
			break;
		case R.id.Menu_btn_4:
			//4번 토스트 테스트
			Toast toast4 = Toast.makeText(this, "4", Toast.LENGTH_SHORT);
			toast4.show();
			break;
		}

	}

	
	
	
	
	
	
	
	
	@Override
	/*
	 * 아래 메뉴 나중에 정할것.
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
}
