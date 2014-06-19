package com.duotin.dtlistview.widget;

import com.duotin.dtlistview.widget.IListViewAnimation.Edge;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class DTListView extends ListView {

	private int oldFirstItem = 0;
	private int oldLastItem = 0;
	
	private boolean isFling = false;

	public DTListView(Context context) {
		super(context);
		setOnScrollListener(mOnScrollListener);
	}

	public DTListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnScrollListener(mOnScrollListener);
	}

	public DTListView(Context context, AttributeSet attrs, int theme) {
		super(context, attrs, theme);
		setOnScrollListener(mOnScrollListener);
	}

	private OnScrollListener mOnScrollListener = new OnScrollListener() {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// TODO Auto-generated method stub
			switch (scrollState) {
			case OnScrollListener.SCROLL_STATE_FLING:
				isFling = true;
				break;

			default:
				isFling = false;
				break;
			}
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			// TODO Auto-generated method stub
			// 第一个可视item
			int firstChildIndex = getFirstVisiblePosition();
			View firstVisableView = getChildAt(0);

			if (firstVisableView != null) {
				int firstTop = firstVisableView.getTop();
				float firstHeight = firstVisableView.getHeight();
				float factor = Math.abs(firstTop) / firstHeight;
				if (firstVisibleItem < oldFirstItem) {
					// OnAppear只需调用一次
					((BaseView) firstVisableView).OnAppear(Edge.TOP);
				} else if(firstVisibleItem > oldFirstItem){
					((BaseView) firstVisableView).OnDisappear(Edge.TOP);
				}
				if(!isFling){
					Log.d(VIEW_LOG_TAG, "isNotfling,,,");
					((BaseView) firstVisableView).OnMoving(Edge.TOP, factor);
				}

			}
			oldFirstItem = firstVisibleItem;

			// 最后一个可视item
			int lastVisibleItem = firstVisibleItem + visibleItemCount;
			View lastVisiableView = getChildAt(lastVisibleItem);
			if (lastVisiableView != null) {
				// 相对位置
				// FIXME 如果有footer view
				int lastBottom = lastVisiableView.getBottom() - getBottom();
				float lastHeight = lastVisiableView.getHeight();
				float lastFactor = Math.abs(lastBottom) / lastHeight;
				if (lastVisibleItem < oldLastItem) {
					((BaseView) lastVisiableView).OnDisappear(Edge.BOTTOM);
				} else if (lastVisibleItem > oldLastItem){
					((BaseView) lastVisiableView).OnAppear(Edge.BOTTOM);
				}
				if(!isFling){
					Log.d(VIEW_LOG_TAG, "isNotfling,,,");
					((BaseView) lastVisiableView).OnMoving(Edge.BOTTOM, lastFactor);
				}
			}
			oldLastItem = lastVisibleItem;
		}
	};
	
	

}
