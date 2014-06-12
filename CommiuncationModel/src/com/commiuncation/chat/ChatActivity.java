package com.commiuncation.chat;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.commiuncationmodel.constant.Constant;
import com.commiuncationmodel.model.User;
import com.commiuncationmodel.ui.FriendListAdapter;
import com.example.commiuncationmodel.R;

public class ChatActivity extends Activity implements OnClickListener {
	private Button mColleagueButton;
	private ListView mFriendListView;
	private List<User> mUserList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_layout);

		if (savedInstanceState != null) {
			mUserList = (List<User>) savedInstanceState
					.getSerializable(Constant.USERS_KEY);
		}

		initView();
	}

	private void initView() {
		mColleagueButton = (Button) this.findViewById(R.id.colleague_text);
		mColleagueButton.setOnClickListener(this);
		mFriendListView = (ListView) this.findViewById(R.id.friend_list);
		FriendListAdapter adapter = new FriendListAdapter(mUserList);
		mFriendListView.setAdapter(adapter);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.colleague_text:
			openColleague();
			break;
		default:
			break;
		}
	}

	private void openColleague() {
		Intent intent = new Intent(this, ColleagueActivity.class);
		startActivity(intent);
	}
}
