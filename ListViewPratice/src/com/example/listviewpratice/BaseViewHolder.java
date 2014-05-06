package com.example.listviewpratice;

import android.content.Context;
import android.view.View;

public abstract class BaseViewHolder {
	private View mConvertView;
	private ArrayAttributeExtractor mArrayAttributeExtractor;

	public void setConvertView(View convertView) {
		this.mConvertView = convertView;
	}

	public BaseViewHolder(Context context) {
		this.mArrayAttributeExtractor = new ArrayAttributeExtractor(context);
	}

	public BaseViewHolder(Context context, int typedArrayId) {
		this.mArrayAttributeExtractor = new ArrayAttributeExtractor(context,
				typedArrayId);
	}

	public int getCount() {
		return mArrayAttributeExtractor.getCount();
	}

	public void initTextArray(int textArrId) {
		mArrayAttributeExtractor.initTextArray(textArrId);
	}

	public void initDrawableArray(int drawableArrId) {
		mArrayAttributeExtractor.initDrawableArray(drawableArrId);
	}

	public View getConvertView() {
		return mConvertView;
	}

	protected ArrayAttributeExtractor getArrayAttributeExtractor() {
		return mArrayAttributeExtractor;
	}

	public abstract void setListItemWith(Object item);

	public abstract void setListItemIn(int position);
}
