package com.example.listviewpratice;

import android.content.Context;
import android.widget.TextView;

public class PeopleViewHolder extends BaseViewHolder {

	public PeopleViewHolder(Context context) {
		super(context);
	}

	@Override
	public void setListItemWith(Object item) {
		People book = (People) item;
		TextView nameText = (TextView) getConvertView().findViewById(
				R.id.center_top_text);
		nameText.setText(book.getName());
	}

	@Override
	public void setListItemIn(int position) {

	}

}
