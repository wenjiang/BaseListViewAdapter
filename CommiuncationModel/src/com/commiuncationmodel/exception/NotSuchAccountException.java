package com.commiuncationmodel.exception;

public class NotSuchAccountException extends Exception {
	private static final long serialVersionUID = 8620640560836552862L;

	private String mErrorInfo;

	public NotSuchAccountException(String error) {
		this.mErrorInfo = error;
	}

	public String getErrorInfo() {
		return mErrorInfo;
	}
}
