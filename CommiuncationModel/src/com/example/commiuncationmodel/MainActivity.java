package com.example.commiuncationmodel;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.commiuncation.chat.ChatActivity;
import com.commiuncationmodel.model.User;
import com.commiuncationmodel.store.AccountStore;

public class MainActivity extends Activity implements OnClickListener {
	private EditText mAccountInputText;
	private EditText mPasswordInputText;
	private Button mLoginButton;
	private Button mRegisterButton;
	private boolean mIsRegister = false;
	private boolean mIsLogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
                AccountStore account = AccountStore.newInstance();
                String name = account.getName();
                String date = account.getDate();
                String imageUrl = account.getImageUrl();
                List<String> message = account.getLastMessage();
                
                User user = new User();
                user.setName(name);
                user.setDate(date);
                user.serImageUrl(imageUrl);
                user.setMessage(message);
			}
			
		});
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

	private boolean registerEvent() {
		return false;
	}

	private boolean loginEvent() {
		return false;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.login_bt:
			mIsLogin = loginEvent();
			if (mIsLogin) {
				Intent intent = new Intent(MainActivity.this,
						ChatActivity.class);
				startActivity(intent);
				break;
			}

			Toast.makeText(MainActivity.this, "登录失败", 2000).show();
			break;
		case R.id.register_bt:
			mIsRegister = registerEvent();
			if (mIsRegister) {
				Toast.makeText(MainActivity.this, "注册成功", 2000).show();
				break;
			}

			Toast.makeText(MainActivity.this, "注册失败", 2000).show();
			break;
		default:
			break;
		}
	}
}
