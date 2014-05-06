package com.example.listviewpratice;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactViewHolder extends BaseViewHolder {
	private Context mContext;

	public ContactViewHolder(Context context, int typedArrayId) {
		super(context, typedArrayId);
		mContext = context;
	}

	@Override
	public void setListItemWith(Object item) {
	}

	@Override
	public void setListItemIn(int position) {

		// TypedArray drawableResArray = mArrayParseUtil
		// .getDrawableArray(R.array.contact_list_drawable);
		//
		// String[] nameStrArray = mArrayParseUtil
		// .getTextArray(R.array.contact_list_text);
		View convertView = getConvertView();
		ImageView imageView = (ImageView) convertView
				.findViewById(R.id.item_icon);
		TextView textView = (TextView) convertView.findViewById(R.id.item_text);

		ArrayAttributeExtractor arrayParseUtil = getArrayAttributeExtractor();
		textView.setText(arrayParseUtil.getTextIn(position));
		imageView.setBackgroundResource(arrayParseUtil
				.getDrawableIdIn(position));

		if (arrayParseUtil.getTextIn(position).equals("我的收藏")) {
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					Toast.makeText(mContext, "我的收藏", 2000).show();
				}
			});
		}

		// imageView.setBackgroundResource(drawableResArray.getResourceId(
		// mPosition, -1));
		// textView.setText(nameStrArray[mPosition]);

		// drawableResArray.recycle();

	}
}
