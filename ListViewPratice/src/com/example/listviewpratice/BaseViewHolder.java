package com.example.listviewpratice;

import android.content.Context;
import android.view.View;

public abstract class BaseViewHolder {
	protected View mConvertView;
	protected ArrayParseUtil mArrayParseUtil;

	public void setConvertView(View convertView) {
		this.mConvertView = convertView;
	}

	public BaseViewHolder() {

	}

	public BaseViewHolder(Context context, int typedArrayId) {
		this.mArrayParseUtil = new ArrayParseUtil(context, typedArrayId);
	}

	public int getCount() {
		return mArrayParseUtil.getCount();
	}

	public abstract void setListItem(Object item);
}
