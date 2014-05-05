package com.example.listviewpratice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

public class ArrayAttributeExtractor {
	private Resources mResources;
	private TypedArray mTextArray;
	private TypedArray mDrawableArray;

	// 适合字符串和图像的二维数组，这时候该二维数组的第一个元素必须是字符串数组
	public ArrayAttributeExtractor(Context context, int typedArrayId) {
		mResources = context.getResources();
		TypedArray typedArray = mResources.obtainTypedArray(typedArrayId);
		mTextArray = mResources.obtainTypedArray(typedArray
				.getResourceId(0, -1));
		mDrawableArray = mResources.obtainTypedArray(typedArray.getResourceId(
				1, -1));
		typedArray.recycle();
	}

	// 适合只有字符串数组或者图像数组的情况
	public ArrayAttributeExtractor(Context context) {
		mResources = context.getResources();
	}

	public String getTextIn(int position) {
		return mTextArray.getString(position);
	}

	public int getDrawableIdIn(int position) {
		return mDrawableArray.getResourceId(position, -1);
	}

	public int getCount() {
		if (mTextArray == null && mDrawableArray != null) {
			return mDrawableArray.length();
		}

		if (mDrawableArray == null && mTextArray != null) {
			return mTextArray.length();
		}

		if (mTextArray == null && mDrawableArray == null) {
			return 0;
		}

		return mTextArray.length() > mDrawableArray.length() ? mTextArray
				.length() : mDrawableArray.length();
	}

	// 如果只有字符串数组或者图像数组，就调用这两个方法来初始化对应的数组
	public void initTextArray(int textArrId) {
		mTextArray = mResources.obtainTypedArray(textArrId);
	}

	public void initDrawableArray(int drawableArrId) {
		mDrawableArray = mResources.obtainTypedArray(drawableArrId);
	}
}
