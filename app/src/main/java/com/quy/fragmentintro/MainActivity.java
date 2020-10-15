package com.quy.fragmentintro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements VersionAndroidFragmentListener {

    private FrameLayout frameLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragment_container);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        DemoFragment demoFragment = new DemoFragment();
        fragmentTransaction.add(frameLayout.getId(),demoFragment);

        fragmentTransaction.commit();

    }

    @Override
    public void onVersion(String version) {
        Toast.makeText(this, version, Toast.LENGTH_SHORT).show();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("version",version);
        detailFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_detail_container,detailFragment).commit();

    }
}