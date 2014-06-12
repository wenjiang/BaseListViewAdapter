package com.commiuncationmodel.exception;

public class ErrorAccountException extends Exception {
	private static final long serialVersionUID = -6258403373269975525L;

	private String mErrorInfo;

	public ErrorAccountException(String error) {
		this.mErrorInfo = error;
	}

	public String getErrorInfo() {
		return mErrorInfo;
	}
}
