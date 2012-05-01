package multiDiv.Math;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReportView extends Activity {

	Resources res;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		res = getResources();

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

		final Button button5 = (Button) findViewById(R.id.rMov);
		button5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				TableLayout tl = (TableLayout) findViewById(R.id.tDetail);
				TextView v1 = (TextView) findViewById(R.id.rdTmLb);
				TextView v2 = (TextView) findViewById(R.id.rdEtmLb);
				TextView v3 = (TextView) findViewById(R.id.rdCorrectLb);

				boolean b = tl.isColumnCollapsed(2);

				tl.setColumnCollapsed(1, !b);
				tl.setColumnCollapsed(2, !b);
				tl.setColumnCollapsed(3, !b);

				if (b) {
					v1.setVisibility(View.VISIBLE);
					v2.setVisibility(View.VISIBLE);
					v3.setVisibility(View.VISIBLE);
					button5.setText(res.getText(R.string.cfg_go_right));
				} else {
					v1.setVisibility(View.GONE);
					v2.setVisibility(View.GONE);
					v3.setVisibility(View.GONE);
					button5.setText(res.getText(R.string.cfg_go_left));
				}

			}
		});

		LoadReport();
	}

	void ClearReport() {
		ConfigGame.ClearData(this);
		LoadReport();
	}

	void LoadReport() {

		ArrayList<String> s = ConfigGame.GetResult(this);

		TableLayout tl = (TableLayout) findViewById(R.id.tDetail);
		
		if (s.size() == 0) {
			tl.removeAllViews();
			TableRow tr = new TableRow(this);
			TextView labelTV = new TextView(this);
			labelTV.setText(res.getString(R.string.rpt_nf));
			tr.addView(labelTV);
			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			return;
		}

		float wSize = 0;
		for (int c = 0; c < s.size(); c++) {
			TableRow tr = new TableRow(this);

			String[] sa = s.get(c).split("\\|");

			for (int e = 0; e < sa.length; e++) {

				TextView labelTV = new TextView(this);
				labelTV.setText(sa[e]);
				switch (e) {
				case 0:
					wSize = res.getDimension(R.dimen.rpt_w_dt);
					break;
				case 1:
					wSize = res.getDimension(R.dimen.rpt_w_tm);
					break;
				case 2:
					wSize = res.getDimension(R.dimen.rpt_w_etm);
					labelTV.setGravity(Gravity.CENTER);
					break;
				case 3:
					wSize = res.getDimension(R.dimen.rpt_w_ct);
					labelTV.setGravity(Gravity.CENTER);
					break;
				case 4:
					wSize = res.getDimension(R.dimen.rpt_w_wg);
					labelTV.setGravity(Gravity.CENTER);
					break;
				case 5:
					wSize = res.getDimension(R.dimen.rpt_w_avg);
					labelTV.setGravity(Gravity.RIGHT);
					labelTV.setPadding(0, 0, 10, 0);
					break;
				case 6:
					wSize = res.getDimension(R.dimen.rpt_w_md);
					labelTV.setGravity(Gravity.RIGHT);
					labelTV.setPadding(0, 0, 10, 0);
					break;
				default:
					break;
				}

				labelTV.setWidth((int) wSize);
				tr.addView(labelTV);
			}

			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}

	}
}
