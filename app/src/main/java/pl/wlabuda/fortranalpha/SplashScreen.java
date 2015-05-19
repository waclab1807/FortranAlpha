package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class SplashScreen extends Activity {

	private static final int CZAS = 50;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashscreen);

		// Start timer and launch main activity
		ActivityStarter starter = new ActivityStarter();
		starter.start();
	}

	private class ActivityStarter extends Thread {
		@Override
		/**
		 * Sleep for some time and than start new activity.
		 */
		public void run() {
			try {
				Thread.sleep(CZAS);
			} catch (Exception e) {
				Log.e("SplashScreen", e.getMessage());
			}

			// Start main activity
			Intent intent = new Intent(SplashScreen.this, ListViewMain.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
		}
	}

}
