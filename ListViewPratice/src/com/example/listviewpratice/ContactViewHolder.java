package com.example.listviewpratice;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactViewHolder extends BaseViewHolder {

	public ContactViewHolder(Context context) {
		super(context);
	}

	@Override
	public void setListItemWith(Object item) {
		// TypedArray drawableResArray = mArrayParseUtil
		// .getDrawableArray(R.array.contact_list_drawable);
		//
		// String[] nameStrArray = mArrayParseUtil
		// .getTextArray(R.array.contact_list_text);
		int position = (Integer) item;
		View convertView = getConvertView();
		ImageView imageView = (ImageView) convertView
				.findViewById(R.id.item_icon);
		TextView textView = (TextView) convertView.findViewById(R.id.item_text);

		ArrayAttributeExtractor arrayParseUtil = getArrayAttributeExtractor();
		textView.setText(arrayParseUtil.getTextIn(position));
		imageView.setBackgroundResource(arrayParseUtil
				.getDrawableIdIn(position));
		// imageView.setBackgroundResource(drawableResArray.getResourceId(
		// mPosition, -1));
		// textView.setText(nameStrArray[mPosition]);

		// drawableResArray.recycle();
	}

	@Override
	public void setListItemIn(int position) {

	}
}
