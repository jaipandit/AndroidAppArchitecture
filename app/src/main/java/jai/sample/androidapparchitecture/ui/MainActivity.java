package jai.sample.androidapparchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jai.sample.androidapparchitecture.R;

public class MainActivity extends AppCompatActivity {

    private static final String userDetailFragmentTag = "user.detail.fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            UserListFragment userListFragment = new UserListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, userListFragment, userDetailFragmentTag)
                    .commitNow();
        }
    }
}
