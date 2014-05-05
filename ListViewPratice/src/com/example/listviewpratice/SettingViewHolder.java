package com.example.listviewpratice;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingViewHolder extends BaseViewHolder {

	public SettingViewHolder(Context context) {
		super(context);
	}

	@Override
	public void setListItemWith(Object item) {

	}

	@Override
	public void setListItemIn(int position) {
		TextView textView = (TextView) getConvertView().findViewById(
				R.id.tv_setting);

		ArrayAttributeExtractor arrayAttributeExtractor = getArrayAttributeExtractor();
		arrayAttributeExtractor.initTextArray(R.array.setting_list_text);
		textView.setText(arrayAttributeExtractor.getTextIn(position));
	}
}
