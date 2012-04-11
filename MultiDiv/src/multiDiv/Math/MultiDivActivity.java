package multiDiv.Math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MultiDivActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.mreport:
			Intent ite1 = new Intent(MultiDivActivity.this, ReportView.class);
			ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite1);
			return true;
		case R.id.mconfig:
			Intent ite2 = new Intent(MultiDivActivity.this, ConfigMath.class);
			ite2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite2);
			return true;
		case R.id.mpractice:
			Intent ite3 = new Intent(MultiDivActivity.this, MainWork.class);
			ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite3);
			return true;		
		default:
			return true;
		}
	}

}