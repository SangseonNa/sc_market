package net.scselab.sc_sub_around;

import net.scselab.sc_market.MainActivity;
import net.scselab.sc_market.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class around extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.around);
		ImageButton home = (ImageButton)findViewById(R.id.Menu_Top_home);
		home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intro = new Intent(around.this, MainActivity.class);
				startActivity(intro);
				finish();				
			}
		});
	}
}