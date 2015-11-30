package com.lee.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

public class MainActivity extends Activity {
    private PullToRefreshScrollView ptr_scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
