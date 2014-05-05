package com.example.listviewpratice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

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
		BaseListViewAdapter adapter = new BaseListViewAdapter(this, holder,
				R.layout.colleague_list_item);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					Toast.makeText(MainActivity.this, "组织架构",
							Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(MainActivity.this, "多人会话",
							Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(MainActivity.this, "公共账号",
							Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, "我的收藏",
							Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
