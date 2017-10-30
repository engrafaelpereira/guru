package com.rpereira.guru;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            GuruFragment guruFragment = GuruFragment.newInstance();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, guruFragment).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.about:
                Log.i(TAG, "about selected");
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .replace(android.R.id.content, new AboutFragment())
                        .addToBackStack(null)
                        .commit();
                return true;

            default:
                Log.i(TAG, "about selected");
                return super.onOptionsItemSelected(item);
        }
    }
}
