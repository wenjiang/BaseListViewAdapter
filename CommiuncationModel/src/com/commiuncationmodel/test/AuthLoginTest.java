package com.commiuncationmodel.test;

import com.commiuncationmodel.exception.ErrorAccountException;
import com.commiuncationmodel.exception.NotSuchAccountException;
import com.commiuncationmodel.net.AuthClient;

import junit.framework.TestCase;

public class AuthLoginTest extends TestCase {

	// 测试默认用户是否能够通过验证
	public void defaultAuthTest() {
		String name = "郑文彪";
		String password = "168168";

		try {
			boolean isAuthSuccess = AuthClient.auth(name, password);

			assertEquals(true, isAuthSuccess);
		} catch (NotSuchAccountException e) {
			e.printStackTrace();
		} catch (ErrorAccountException e) {
			e.printStackTrace();
		}
	}

	// 测试还没注册过的用户是否能够通过验证以及是否能够抛出相应的异常
	public void errorAuthTest() {
		String name = "陈骏";
		String password = "00830084";

		try {
			boolean isAuthSuccess = AuthClient.auth(name, password);

			assertEquals(false, isAuthSuccess);
		} catch (NotSuchAccountException e) {
			assertEquals("该用户尚未注册", e.getErrorInfo());
		} catch (ErrorAccountException e) {
			e.printStackTrace();
		}
	}

	// 测试用户名填写错误的情况是否能够通过验证以及是否能够抛出相应的异常
	public void nameAuthTest() {
		String name = "郑文标";
		String password = "168168";

		try {
			boolean isAuthSuccess = AuthClient.auth(name, password);

			assertEquals(false, isAuthSuccess);
		} catch (ErrorAccountException e) {
			assertEquals("用户名错误", e.getErrorInfo());
		} catch (NotSuchAccountException e) {
			e.printStackTrace();
		}
	}

	// 测试用户密码填写错误的情况是佛能够通过验证以及是否能够抛出相应的异常
	public void passwordTest() {
		String name = "郑文彪";
		String password = "167168";

		try {
			boolean isAuthSuccess = AuthClient.auth(name, password);

			assertEquals(false, isAuthSuccess);
		} catch (ErrorAccountException e) {
			assertEquals("用户密码错误", e.getErrorInfo());
		} catch (NotSuchAccountException e) {
			e.printStackTrace();
		}
	}
}
