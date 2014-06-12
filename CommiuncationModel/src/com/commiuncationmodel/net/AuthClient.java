package com.commiuncationmodel.net;

import com.commiuncationmodel.exception.ErrorAccountException;
import com.commiuncationmodel.exception.NotSuchAccountException;

public class AuthClient {
	private static final int NOT_SUCH_ACCOUNT = 0;
	private static final int ERROR_NAME = 1;
	private static final int ERROR_PASSWORD = 2;

	public static boolean auth(String name, String password)
			throws NotSuchAccountException, ErrorAccountException {
		boolean isAuthSuccess = true;
		int authCode = checkAccount(name, password);

		if (NOT_SUCH_ACCOUNT == authCode) {
			isAuthSuccess = false;
			throw new NotSuchAccountException("该用户尚未注册");
		} else if (ERROR_NAME == authCode) {
			isAuthSuccess = false;
			throw new ErrorAccountException("用户名错误");
		} else if (ERROR_PASSWORD == authCode) {
			isAuthSuccess = false;
			throw new ErrorAccountException("用户密码错误");
		}

		return isAuthSuccess;
	}

	private static int checkAccount(String name, String password) {
		return -1;
	}
}
