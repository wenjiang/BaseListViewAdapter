package com.commiuncation.chat;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.commiuncationmodel.model.User;
import com.commiuncationmodel.store.AccountStore;
import com.commiuncationmodel.ui.ColleagueAdapter;
import com.example.commiuncationmodel.R;

public class ColleagueActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private ListView mColleagueListView;
	private Button mSearchButton;
	private List<User> mColleagueList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colleague_layout);

		initView();

		// TODO 将通讯录人员数据的获取放在AsnyTask中
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				AccountStore accountStore = AccountStore.newInstance();
				mColleagueList = accountStore.getColleagues();
			}
		});
		thread.start();
	}

	private void initView() {
		mSearchButton = (Button) this.findViewById(R.id.search_button);
		mSearchButton.setOnClickListener(this);
		mColleagueListView = (ListView) this.findViewById(R.id.colleague_list);
		ColleagueAdapter adapter = new ColleagueAdapter(mColleagueList);
		mColleagueListView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.search_button:
			mColleagueList = searchEvent();
			break;
		default:
			break;
		}
	}

	private List<User> searchEvent() {
		return null;
	}
}
