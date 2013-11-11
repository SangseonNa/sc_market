package net.scselab.sc_market;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, splash.class)); //스플래시 class 먼저
        setContentView(R.layout.activity_main); //핸들러에 의해 종료 된후 activity 시작 
        
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
