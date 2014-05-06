package com.example.listviewpratice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) this.findViewById(R.id.list);
		People people = new People("发现美");
		People people1 = new People("中国人");
		List<People> peoples = new ArrayList<People>();
		peoples.add(people);
		peoples.add(people1);
		// PeopleViewHolder holder = new PeopleViewHolder();
		// BaseListViewAdapter adapter = new BaseListViewAdapter(this, holder,
		// R.layout.common_list_item, peoples);

		ContactViewHolder holder = new ContactViewHolder(this,
				R.array.contact_attr);
		// SettingViewHolder settingViewHolder = new SettingViewHolder(this);
		// settingViewHolder.initTextArray(R.array.setting_list_text);
		BaseListViewAdapter adapter = new BaseListViewAdapter(this, holder,
				R.layout.colleague_list_item);
		// BaseListViewAdapter adapter = new BaseListViewAdapter(this,
		// settingViewHolder, R.layout.colleague_list_item);
		listView.setAdapter(adapter);
	}
}
