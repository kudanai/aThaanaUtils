package com.kudanai.athaanautilsdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.athaanautils.ThaanaTextWatcher;
import com.athaanautils.ThaanaUtils;

import java.io.IOException;


public class MainActivity2 extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //flip the whole thing to RTL
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }


        //how to set a custom view in the actionbar to show thaana
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.top);

        NavigationDrawerFragment mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new PlaceholderFragment())
                .commit();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_main, container, false);

            try {
                ThaanaUtils.thaanafyTextViewSubclass(v.findViewById(R.id.btn1), "fonts/elaaf.ttf");
                ThaanaUtils.thaanafyTextViewSubclass(v.findViewById(R.id.check1), "fonts/elaaf.ttf");

                // we use this method to retain widget tinting in v21 and AppCompat
                EditText edit1 = (EditText)v.findViewById(R.id.edit1);
                ThaanaUtils.thaanafyTextViewSubclass(edit1, "fonts/elaaf.ttf");

                // also assign either an inputfilter or textwatcher to transpose to thaana
                // unless using a custom keyboard layout. In which case this won't matter
                edit1.addTextChangedListener(new ThaanaTextWatcher());

            } catch (IOException e){
                e.printStackTrace();
            }
            return v;
        }
    }

}
