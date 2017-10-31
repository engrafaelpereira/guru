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
            openGuruFragment();
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
                openAboutFragment();
                return true;

            default:
                Log.i(TAG, "about selected");
                return super.onOptionsItemSelected(item);
        }
    }

    private void openGuruFragment() {
        GuruFragment guruFragment = GuruFragment.newInstance();
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, guruFragment).commit();
    }

    private void openAboutFragment() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            return;
        }

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(android.R.id.content, new AboutFragment())
                .addToBackStack(null)
                .commit();
    }
}
