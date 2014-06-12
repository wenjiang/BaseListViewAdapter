package com.commiuncationmodel.ui;

import java.util.List;

import com.commiuncationmodel.model.User;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FriendListAdapter extends BaseAdapter {
	private List<User> mUserList;

	public FriendListAdapter(List<User> userList) {
		this.mUserList = userList;
	}

	@Override
	public int getCount() {
		return mUserList.size();
	}

	@Override
	public Object getItem(int position) {
		return mUserList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup group) {
		return null;
	}
}
