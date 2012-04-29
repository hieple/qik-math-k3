package multiDiv.Math;

import java.util.ArrayList;
import multiDiv.Math.Comp.TextViewMa;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReportView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		final Button button1 = (Button) findViewById(R.id.rHme);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite1 = new Intent(ReportView.this,
						MultiDivActivity.class);
				ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite1);
			}
		});

		final Button button2 = (Button) findViewById(R.id.rCfg);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite4 = new Intent(ReportView.this, ConfigMath.class);
				ite4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite4);
			}
		});

		final Button button3 = (Button) findViewById(R.id.rPrc);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite3 = new Intent(ReportView.this, MainWork.class);
				ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite3);
			}
		});

		final Button button4 = (Button) findViewById(R.id.rClr);
		button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ClearReport();
			}
		});
		LoadReport();
	}

	void ClearReport() {
		/*
		 * ConfigGame.ClearData(this); TableLayout tl = (TableLayout)
		 * findViewById(R.id.tInfo); tl.removeAllViews(); LoadReport();
		 */
	}

	void LoadReport() {

		// GridView Gv = (GridView) findViewById(R.id.gDetail);
		// Gv.setAdapter(new ResultAdapter(this));

		ListView Lv = (ListView) findViewById(R.id.vDetail);
		Lv.setAdapter(new ResultAdapter(this));
		/*
		 * 
		 * ArrayList<String> s = ConfigGame.GetResult(this);
		 * 
		 * TableLayout tl = (TableLayout) findViewById(R.id.gDetail);
		 * 
		 * // Do not make header when no data if (s.size() == 1) { String[] sa =
		 * s.get(0).split("\\|"); if (sa.length > 1) SetTableHeader(tl); } else
		 * SetTableHeader(tl);
		 * 
		 * for (int c = 0; c < s.size(); c++) { TableRow tr = new
		 * TableRow(this);
		 * 
		 * String[] sa = s.get(c).split("\\|"); for (int e = 0; e < sa.length;
		 * e++) {
		 * 
		 * TextViewMa labelTV = new TextViewMa(this); labelTV.setText(sa[e]);
		 * 
		 * labelTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
		 * labelTV.setPadding(10, 10, 10, 10);
		 * labelTV.setGravity(Gravity.RIGHT);
		 * 
		 * tr.addView(labelTV); }
		 * 
		 * tl.addView(tr, new TableLayout.LayoutParams(
		 * LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)); }
		 */
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

}

class ResultAdapter extends BaseAdapter {

	ArrayList<String> _content;
	Context _context;

	public ResultAdapter(Context xHost) {
		_context = xHost;
		_content = ConfigGame.GetResult(xHost);
	}

	public int getCount() {
		return _content.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View _view = convertView;
		if (convertView == null) {
			LayoutInflater lIn = (LayoutInflater) _context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			_view = lIn.inflate(R.layout.result_detail, null);
			TextView tv0 = (TextView) _view.findViewById(R.id.rdDate);
			TextView tv1 = (TextView) _view.findViewById(R.id.rdTime);
			TextView tv2 = (TextView) _view.findViewById(R.id.rdETime);
			TextView tv3 = (TextView) _view.findViewById(R.id.rdCorrect);
			TextView tv4 = (TextView) _view.findViewById(R.id.rdWrong);
			TextView tv5 = (TextView) _view.findViewById(R.id.rdAverage);
			TextView tv6 = (TextView) _view.findViewById(R.id.rdMode);

			String[] s = _content.get(position).split("\\|");
			tv0.setText(s[0]);
			tv1.setText(s[1]);

			tv2.setText(s[2]);
			tv3.setText(s[3]);
			tv4.setText(s[4]);
			tv5.setText(s[5]);
			tv6.setText(s[6]);
		}
		return _view;
	}

}
