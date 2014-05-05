package com.example.listviewpratice;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactViewHolder extends BaseViewHolder {

	public ContactViewHolder(Context context, int typedArrayId) {
		super(context, typedArrayId);
	}

	@Override
	public void setListItem(Object item) {
		// TypedArray drawableResArray = mArrayParseUtil
		// .getDrawableArray(R.array.contact_list_drawable);
		//
		// String[] nameStrArray = mArrayParseUtil
		// .getTextArray(R.array.contact_list_text);
		int position = (Integer) item;
		ImageView imageView = (ImageView) mConvertView
				.findViewById(R.id.item_icon);
		TextView textView = (TextView) mConvertView
				.findViewById(R.id.item_text);
		
		textView.setText(mArrayParseUtil.getTextIn(position));
		imageView.setBackgroundResource(mArrayParseUtil
				.getDrawableIdIn(position));
		// imageView.setBackgroundResource(drawableResArray.getResourceId(
		// mPosition, -1));
		// textView.setText(nameStrArray[mPosition]);

		// drawableResArray.recycle();
	}
}
