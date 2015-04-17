package pl.wlabuda.fortranalpha;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements TabListener {

	List<Fragment> fragList = new ArrayList<Fragment>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        Tab tab0 = bar.newTab();
        tab0.setText("Podgląd");
        tab0.setTabListener(this);
        bar.addTab(tab0);
        Tab tab1 = bar.newTab();
        tab1.setText("Dane");
        tab1.setTabListener(this);
        bar.addTab(tab1);
        Tab tab2 = bar.newTab();
        tab2.setText("Rozwiązanie");
        tab2.setTabListener(this);
        bar.addTab(tab2);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment f = null;
		TabFragment tf = null;
		
		if (fragList.size() > tab.getPosition())
				fragList.get(tab.getPosition());
		
		if (f == null) {
			tf = new TabFragment();
			Bundle data = new Bundle();
			data.putInt("idx",  tab.getPosition());
			tf.setArguments(data);
			fragList.add(tf);
		}
		else
			tf = (TabFragment) f;
		
		ft.replace(android.R.id.content, tf);
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}
		
	}

}
