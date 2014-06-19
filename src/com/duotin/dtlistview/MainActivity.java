package com.duotin.dtlistview;

import com.duotin.dtlistview.widget.BaseView;
import com.duotin.dtlistview.widget.DTListView;
import com.duotin.dtlistview.widget.DTListViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	private DTListView mListView;
	private String s="develop";
	private DTListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mAdapter = new DTListViewAdapter();
		
		for(int i=0; i< 200; i++){
			BaseView view = (BaseView) getLayoutInflater().inflate(R.layout.test_single, null);
			mAdapter.addView(view);
		}
		
		mListView.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mListView = (DTListView) findViewById(R.id.lv_main);
	}
}
