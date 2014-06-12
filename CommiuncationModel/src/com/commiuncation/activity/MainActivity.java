package com.commiuncation.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.commiuncation.chat.ChatActivity;
import com.commiuncationmodel.constant.Constant;
import com.commiuncationmodel.model.User;
import com.commiuncationmodel.store.AccountStore;
import com.example.commiuncationmodel.R;

public class MainActivity extends Activity implements OnClickListener,
		TextWatcher {
	private EditText mAccountInputText;
	private EditText mPasswordInputText;
	private Button mLoginButton;
	private Button mRegisterButton;
	private List<User> mUsers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		// TODO 应该将数据的获取放到AsnyTask中
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				AccountStore accountStore = AccountStore.newInstance();

				// TODO accountStore的getUsers方法实现应该是将AccountStore从网上获取到的数据取出来
				mUsers = accountStore.getUsers();
			}
		});
		thread.start();
	}

	private void initView() {
		mAccountInputText = (EditText) this
				.findViewById(R.id.account_input_text);
		mPasswordInputText = (EditText) this
				.findViewById(R.id.password_input_text);
		mLoginButton = (Button) this.findViewById(R.id.login_bt);
		mRegisterButton = (Button) this.findViewById(R.id.register_bt);
		mLoginButton.setOnClickListener(this);
		mRegisterButton.setOnClickListener(this);
	}

	private boolean isRegisterSuccess() {
		String name = mAccountInputText.getText().toString();
		String password = mPasswordInputText.getText().toString();

		boolean isAccountValid = checkAccountAlive(name, password);
		return isAccountValid;
	}

	private boolean checkAccountAlive(String name, String password) {
		return false;
	}

	private boolean checkAccountInfo(String name, String password) {
		return false;
	}

	private boolean isLoginSuccess() {
		String name = mAccountInputText.getText().toString();
		String password = mPasswordInputText.getText().toString();

		boolean isAccountValid = checkAccountInfo(name, password);
		return isAccountValid;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.login_bt:
			if (isLoginSuccess()) {
				Intent intent = new Intent(MainActivity.this,
						ChatActivity.class);
				intent.putExtra(Constant.USERS_KEY, (Serializable) mUsers);
				startActivity(intent);
				break;
			}

			Toast.makeText(MainActivity.this, "登录失败", 2000).show();
			break;
		case R.id.register_bt:
			if (isRegisterSuccess()) {
				Toast.makeText(MainActivity.this, "注册成功", 2000).show();
				break;
			}

			Toast.makeText(MainActivity.this, "注册失败", 2000).show();
			break;
		default:
			break;
		}
	}

	@Override
	public void afterTextChanged(Editable arg0) {

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

	}
}
