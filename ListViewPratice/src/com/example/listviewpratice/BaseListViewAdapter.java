package com.example.listviewpratice;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BaseListViewAdapter extends BaseAdapter {
	private List<? extends Object> mBaseList;
	private Context mContext;
	private int mItemLayoutId;
	private BaseViewHolder mViewHolder;

	public BaseListViewAdapter(Context context, BaseViewHolder viewHolder,
			int id, List<? extends Object> list) {
		this.mContext = context;
		this.mViewHolder = viewHolder;
		this.mItemLayoutId = id;
		this.mBaseList = list;
	}

	public BaseListViewAdapter(Context context, BaseViewHolder viewHolder,
			int id) {
		this(context, viewHolder, id, null);
	}

	public void setItemLayoutId(int id) {
		this.mItemLayoutId = id;
	}

	public void setViewHolder(BaseViewHolder viewHolder) {
		this.mViewHolder = viewHolder;
	}

	public BaseViewHolder getViewHolder() {
		return mViewHolder;
	}

	@Override
	public int getCount() {
		if (mBaseList == null) {
			return mViewHolder.getCount();
		}

		return mBaseList.size();
	}

	@Override
	public Object getItem(int position) {
		return mBaseList != null ? mBaseList.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(mItemLayoutId,
					null);
			mViewHolder.setConvertView(convertView);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (BaseViewHolder) convertView.getTag();
		}

		if (mBaseList == null) {
			mViewHolder.setListItemIn(position);
			return convertView;
		}

		Object item = mBaseList.get(position);
		mViewHolder.setListItemWith(item);
		return convertView;
	}
}
