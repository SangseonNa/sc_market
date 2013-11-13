package net.scselab.sc_sub_location;

import net.scselab.sc_market.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class location extends Activity{
	private WebView location_web;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		location_web = (WebView) findViewById(R.id.location_web);
		
//		location_web.getSettings().setJavaScriptEnabled(true);
//		location_web.loadUrl("http://jyo.scselab.net/mapTest/index.html");
		
		WebChromeClient client = new WebChromeClient();
		
		location_web.setWebChromeClient(client);
	}
}