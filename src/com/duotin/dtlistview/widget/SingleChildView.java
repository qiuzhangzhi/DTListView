package com.duotin.dtlistview.widget;

import com.duotin.dtlistview.widget.IListViewAnimation.Edge;

import android.R.bool;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SingleChildView extends BaseView {
	
	private View mChildView;
	
	private boolean appearFlag = false;
	private boolean disappearFlag = false;
	
	private int lastTop;
	private int lastBottom;

	public SingleChildView(Context context) {
		super(context);
	}

	public SingleChildView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SingleChildView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			mChildView = getChildAt(0);
		}
	}

	@Override
	public void OnAppear(Edge edge) {
		if(mChildView != null && !appearFlag){
			ObjectAnimator animator = ObjectAnimator.ofFloat(mChildView, "alpha", 1, 0.2f);
			animator.setDuration(800);
			
			animator.addListener(new AnimatorListener() {
				
				@Override
				public void onAnimationStart(Animator animation) {
					// TODO Auto-generated method stub
					disappearFlag = true;
					appearFlag = true;
				}
				
				@Override
				public void onAnimationRepeat(Animator animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animator animation) {
					// TODO Auto-generated method stub
					disappearFlag = false;
				}
				
				@Override
				public void onAnimationCancel(Animator animation) {
					// TODO Auto-generated method stub
					
				}
			});
//			animator.start();
		}
	}

	@Override
	public void OnMoving(Edge edge, float factor) {
		// TODO Auto-generated method stub
		if(mChildView != null){
			Log.d(VIEW_LOG_TAG, "factor" + factor);
			int left = (int) (0 - factor * mChildView.getWidth());
			float alpha = 1 - factor;
			mChildView.setLeft(left);
			mChildView.setAlpha(alpha);
		}
	}

	@Override
	public void OnDisappear(Edge edge) {
		// TODO Auto-generated method stub
		if(mChildView != null && !disappearFlag){
			ObjectAnimator animator = ObjectAnimator.ofFloat(mChildView, "alpha", 0.2f, 1f);
			animator.setDuration(800);
			animator.addListener(new AnimatorListener() {
				
				@Override
				public void onAnimationStart(Animator animation) {
					// TODO Auto-generated method stub
					disappearFlag = true;
					appearFlag = true;
				}
				
				@Override
				public void onAnimationRepeat(Animator animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animator animation) {
					// TODO Auto-generated method stub
					appearFlag = false;
				}
				
				@Override
				public void onAnimationCancel(Animator animation) {
					// TODO Auto-generated method stub
					
				}
			});
//			animator.start();
			
		}
	}

}
