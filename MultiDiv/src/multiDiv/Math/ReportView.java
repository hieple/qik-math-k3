package multiDiv.Math;

import java.util.ArrayList;

import multiDiv.Math.Comp.TextViewMa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ReportView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		LoadReport();
	}

	void ClearReport() {
		ConfigGame.ClearData(this);
		TableLayout tl = (TableLayout) findViewById(R.id.tInfo);
		tl.removeAllViews();
		LoadReport();
		
	}

	void LoadReport() {

	
		ArrayList<String> s = ConfigGame.GetResult(this);

		TableLayout tl = (TableLayout) findViewById(R.id.tInfo);

		// Do not make header when no data
		if (s.size() == 1) {
			String[] sa = s.get(0).split("\\|");
			if (sa.length > 1)
				SetTableHeader(tl);
		} else
			SetTableHeader(tl);

		for (int c = 0; c < s.size(); c++) {
			TableRow tr = new TableRow(this);

			String[] sa = s.get(c).split("\\|");
			for (int e = 0; e < sa.length; e++) {

				TextViewMa labelTV = new TextViewMa(this);
				labelTV.setText(sa[e]);

				labelTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
				labelTV.setPadding(10, 10, 10, 10);
				labelTV.setGravity(Gravity.RIGHT);

				tr.addView(labelTV);
			}

			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		}

	}

	void SetTableHeader(TableLayout tl) {
		String[] Header = { "Date", "Time", "Elapsed Time", "Correct", "Wrong",
				"Average", "Mode" };
		TableRow tr = new TableRow(this);

		for (int i = 0; i < Header.length; i++) {

			TextViewMa Title = new TextViewMa(this);
			Title.setText(Header[i]);
			Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
			Title.setPadding(5, 5, 5, 5);
			Title.setTextColor(Color.BLUE);
			tr.addView(Title);
		}
		tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_report, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.mrhome:
			Intent ite1 = new Intent(ReportView.this, MultiDivActivity.class);
			ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite1);
			return true;
		case R.id.mrclear:
			ClearReport();
			return true;
		case R.id.mrconfig:
			Intent ite4 = new Intent(ReportView.this, ConfigMath.class);
			ite4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite4);
			return true;
		case R.id.mrpractice:
			Intent ite3 = new Intent(ReportView.this, MainWork.class);
			ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(ite3);
			return true;
		default:
			return true;
		}
	}

}
