package com.example.listviewpratice;

import android.widget.TextView;

public class PeopleViewHolder extends BaseViewHolder {

	@Override
	public void setListItem(Object item) {
		People book = (People) item;
		TextView nameText = (TextView) mConvertView
				.findViewById(R.id.center_top_text);
		nameText.setText(book.getName());
	}

}
