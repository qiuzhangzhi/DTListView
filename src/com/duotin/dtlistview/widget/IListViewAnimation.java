package com.duotin.dtlistview.widget;

public interface IListViewAnimation {
	
	public enum Edge{
		TOP,
		BOTTOM
	}

	void OnAppear(Edge edge);
	
	/**
	 * @param edge
	 * @param factor 出现的比率， 0-1 0为完全可视，1为完全不可视
	 */
	void OnMoving(Edge edge, float factor);
	
	void OnDisappear(Edge edge);
	
}
