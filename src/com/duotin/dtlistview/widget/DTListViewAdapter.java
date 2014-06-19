package com.duotin.dtlistview.widget;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DTListViewAdapter extends BaseAdapter {
	
	private ArrayList<BaseView> mDataViews;
	
	public DTListViewAdapter() {
		// TODO Auto-generated constructor stub
		mDataViews = new ArrayList<BaseView>();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDataViews.size();
	}

	@Override
	public BaseView getItem(int position) {
		if(mDataViews != null && mDataViews.size() > position){
			return mDataViews.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// 暂时没考虑重用问题
		if(mDataViews != null && mDataViews.size() > position){
			return mDataViews.get(position);
		}
		return null;
	}

	public void setDataViews(ArrayList<BaseView> views){
		this.mDataViews = views;
	}
	
	public void addView(BaseView view){
		if(mDataViews == null){
			mDataViews = new ArrayList<BaseView>();
		}
		mDataViews.add(view);
	}
}
