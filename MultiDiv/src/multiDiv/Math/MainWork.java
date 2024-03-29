package multiDiv.Math;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import multiDiv.Math.Comp.ToggleMa;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainWork extends Activity {

	CountDownTimer Cdt;
	ArrayList<MathText> Test;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.work);

		final ToggleMa s = (ToggleMa) findViewById(R.id.bOnOff);
		s.setBgReversed();
		s.toggle();
		s.setChecked(false);

		final Button button1 = (Button) findViewById(R.id.wRpt);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				PauseTest();
				Intent ite1 = new Intent(MainWork.this, ReportView.class);
				ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite1);
			}
		});

		final Button button2 = (Button) findViewById(R.id.wCfg);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				PauseTest();
				Intent ite2 = new Intent(MainWork.this, ConfigMath.class);
				ite2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite2);
			}
		});

		final Button button3 = (Button) findViewById(R.id.wHme);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				PauseTest();
				Intent ite3 = new Intent(MainWork.this, MultiDivActivity.class);
				ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite3);
			}
		});

		ConfigGame.ReadConfig(this);

		final TextView v = (TextView) findViewById(R.id.tCounter);
		v.setText(ConfigGame.HourMinuteSecond(ConfigGame.durationOfTest
				- ConfigGame.elapseTime));

		s.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {

				s.switchButton(isChecked);

				if (isChecked) {

					ClearOnStartUp();

					Cdt = new CountDownTimer(
							(ConfigGame.durationOfTest + 1) * 1000, 1000) {

						@Override
						public void onTick(long millisUntilFinished) {
							if (ConfigGame.gameStart) {
								ConfigGame.elapseTime = ConfigGame.durationOfTest
										- (int) millisUntilFinished / 1000;
								v.setText(ConfigGame
										.HourMinuteSecond(ConfigGame.durationOfTest
												- ConfigGame.elapseTime));
							} else {
								Cdt.cancel();
							}
						}

						@Override
						public void onFinish() {

							if (ConfigGame.gameStart) {
								ConfigGame.elapseTime = ConfigGame.durationOfTest;
								v.setText(ConfigGame
										.HourMinuteSecond(ConfigGame.durationOfTest
												- ConfigGame.elapseTime));
								ConfigGame.gameStart = false;
								ShowReport();
							}
						}
					}.start();

				} else {
					ConfigGame.gameStart = false;
					if (Cdt != null)
						Cdt.cancel(); // quit
				}
			}

		});

		final Button ok = (Button) findViewById(R.id.bOK);
		ok.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				if (!ConfigGame.gameStart)
					return;
				if (ConfigGame.Result == "") {
					ConfigGame.badResult += 1;
				} else {
					int r = Integer.parseInt(ConfigGame.Result);
					int c = ConfigGame.goodResult + ConfigGame.badResult;
					MathText Mt = Test.get(c);
					if (Mt.ans == r)
						ConfigGame.goodResult += 1;
					else
						ConfigGame.badResult += 1;
				}

				SetCounter();
				FillTest();

				ConfigGame.Result = "";
			}
		});

		final Button c = (Button) findViewById(R.id.bC);
		c.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				if (ConfigGame.gameStart) {
					ConfigGame.Result = "";
					final TextView ans = (TextView) findViewById(R.id.tAns);
					ans.setText(ConfigGame.Result);
				}
			}
		});

		final Button b0 = (Button) findViewById(R.id.b0);
		b0.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("0");
			}
		});

		final Button b1 = (Button) findViewById(R.id.b1);
		b1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("1");
			}
		});

		final Button b2 = (Button) findViewById(R.id.b2);
		b2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("2");
			}
		});

		final Button b3 = (Button) findViewById(R.id.b3);
		b3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("3");
			}
		});

		final Button b4 = (Button) findViewById(R.id.b4);
		b4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("4");
			}
		});

		final Button b5 = (Button) findViewById(R.id.b5);
		b5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("5");
			}
		});

		final Button b6 = (Button) findViewById(R.id.b6);
		b6.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("6");
			}
		});

		final Button b7 = (Button) findViewById(R.id.b7);
		b7.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("7");
			}
		});

		final Button b8 = (Button) findViewById(R.id.b8);
		b8.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("8");
			}
		});

		final Button b9 = (Button) findViewById(R.id.b9);
		b9.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				EnterResult("9");
			}
		});

	}

	void PauseTest() {
		final ToggleMa s = (ToggleMa) findViewById(R.id.bOnOff);
		if (s.isChecked())
			s.setChecked(false);
	}

	void ClearOnStartUp() {
		// at least we have something to run
		if (!ConfigGame.addGame && !ConfigGame.subGame && !ConfigGame.mulGame
				&& !ConfigGame.divGame)
			ConfigGame.addGame = true;
		Test = TestList();
		ConfigGame.goodResult = 0;
		ConfigGame.badResult = 0;
		ConfigGame.gameStart = true;

		SetCounter();
		FillTest();
	}

	void SetCounter() {
		final TextView goo = (TextView) findViewById(R.id.tcCorrect);
		goo.setText(String.format("%d", ConfigGame.goodResult));
		final TextView bad = (TextView) findViewById(R.id.tcWrong);
		bad.setText(String.format("%d", ConfigGame.badResult));
		final TextView cur = (TextView) findViewById(R.id.tcCurrent);
		int c = ConfigGame.goodResult + ConfigGame.badResult + 1;
		if (c < ConfigGame.numOfTest + 1)
			cur.setText(String.format("%d/%d", c, ConfigGame.numOfTest));
	}

	void EnterResult(String b) {
		if (!ConfigGame.gameStart)
			return;
		final TextView ans = (TextView) findViewById(R.id.tAns);
		if (ConfigGame.Result == "") {
			ConfigGame.Result += b;
			ans.setText(ConfigGame.Result);
		} else {
			ConfigGame.Result += b;
			ans.setText(ConfigGame.Result);
		}
	}

	void ShowReport() {

		final AlertDialog alertDialog;

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.report,
				(ViewGroup) findViewById(R.id.report_dialog));

		CreateResultInfo(layout);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(layout);

		alertDialog = builder.create();
		alertDialog.show();

		Button b = (Button) layout.findViewById(R.id.bRpDone);

		b.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				if (alertDialog != null)
					alertDialog.dismiss();
			}
		});

		// Ready for new game
		final ToggleMa s = (ToggleMa) findViewById(R.id.bOnOff);
		s.setChecked(false);
		Cdt.cancel(); // quit
	}

	void CreateResultInfo(View v) {
		TextView d = (TextView) v.findViewById(R.id.rp_date);
		Calendar rN = Calendar.getInstance();
		SimpleDateFormat Sfm = new SimpleDateFormat("MM-dd-yyyy");
		String Dt = Sfm.format(rN.getTime());
		d.setText(Dt);

		TextView t = (TextView) v.findViewById(R.id.rp_time);
		Sfm = new SimpleDateFormat("hh:mm:ss");
		String Tm = Sfm.format(rN.getTime());
		t.setText(Tm);

		TextView e = (TextView) v.findViewById(R.id.rp_elapse);
		String Es = ConfigGame.HourMinuteSecond(ConfigGame.elapseTime);
		e.setText(Es);

		TextView c = (TextView) v.findViewById(R.id.rp_correct);
		c.setText(String.format("%d", ConfigGame.goodResult));

		TextView w = (TextView) v.findViewById(R.id.rp_wrong);
		w.setText(String.format("%d", ConfigGame.badResult));

		TextView p = (TextView) v.findViewById(R.id.rp_percent);
		p.setText(String.format("%.2f", ConfigGame.elapseTime
				/ (float) ConfigGame.goodResult));

		String Ops = "";
		if (ConfigGame.addGame)
			Ops += getString(R.string.num_plus);
		else
			Ops += " ";
		if (ConfigGame.subGame)
			Ops += getString(R.string.num_minus);
		else
			Ops += " ";
		if (ConfigGame.mulGame)
			Ops += getString(R.string.num_multi);
		else
			Ops += " ";
		if (ConfigGame.divGame)
			Ops += getString(R.string.num_div);
		else
			Ops += " ";

		String Rs = String.format("%s|%s|%s|%d|%d|%.2f|%s\n", Dt, Tm, Es,
				ConfigGame.goodResult, ConfigGame.badResult,
				ConfigGame.elapseTime / (float) ConfigGame.goodResult, Ops);

		ConfigGame.SaveResult(v.getContext(), Rs);
	}

	void FillTest() {

		if (!ConfigGame.gameStart)
			return;

		int c = ConfigGame.goodResult + ConfigGame.badResult;

		if (c < ConfigGame.numOfTest && Test != null) {
			MathText Mt = Test.get(c);

			final TextView op1 = (TextView) findViewById(R.id.tOp1);
			op1.setText(String.format("%d", Mt.op1));
			final TextView op2 = (TextView) findViewById(R.id.tOp2);
			op2.setText(String.format("%d", Mt.op2));
			String OpSig = "";
			switch (Mt.op) {
			case ADD:
				OpSig = getString(R.string.num_plus);
				break;
			case SUB:
				OpSig = getString(R.string.num_minus);
				break;
			case MUL:
				OpSig = getString(R.string.num_multi);
				break;
			case DIV:
				OpSig = getString(R.string.num_div);
				break;
			}
			final TextView op = (TextView) findViewById(R.id.tOpType);
			op.setText(OpSig);

			final TextView dvd = (TextView) findViewById(R.id.tDvd);
			dvd.setVisibility(0);

			final TextView ans = (TextView) findViewById(R.id.tAns);
			ans.setText("");

		} else {
			ConfigGame.Result = "";
			if (ConfigGame.gameStart) {
				ConfigGame.gameStart = false;
				ShowReport();
			}
		}

	}

	ArrayList<MathText> TestList() {

		ArrayList<MathText> l = new ArrayList<MathText>();

		Random r = new Random();

		int i = 0;
		while (i < ConfigGame.numOfTest) {
			// choose operator
			int op = r.nextInt(4);
			MathText m = new MathText();

			switch (op) {
			case 0:
				if (!ConfigGame.addGame)
					continue;
				m.op = OpType.ADD;
				m.op1 = r.nextInt(ConfigGame.maxNumber + 1);
				m.op2 = r.nextInt(ConfigGame.maxNumber + 1);
				m.ans = m.op1 + m.op2;
				break;
			case 1:
				if (!ConfigGame.subGame)
					continue;
				m.op = OpType.SUB;
				m.op1 = r.nextInt(ConfigGame.maxNumber + 1);
				m.op2 = r.nextInt(ConfigGame.maxNumber + 1);
				if (m.op1 < m.op2) {
					int x = m.op1;
					m.op1 = m.op2;
					m.op2 = x;
				}
				m.ans = m.op1 - m.op2;
				break;
			case 2:
				if (!ConfigGame.mulGame)
					continue;
				m.op = OpType.MUL;
				m.op1 = r.nextInt(ConfigGame.maxNumber + 1);
				m.op2 = r.nextInt(ConfigGame.maxNumber + 1);
				m.ans = m.op1 * m.op2;
				break;
			case 3:
				if (!ConfigGame.divGame)
					continue;
				m.op = OpType.DIV;
				// don't choose zero
				while (m.op2 == 0)
					m.op2 = r.nextInt(ConfigGame.maxNumber + 1);
				m.ans = r.nextInt(ConfigGame.maxNumber + 1);
				m.op1 = m.op2 * m.ans;
				break;
			}
			// check if we get same number
			if (l.size() > 0) {
				int z = l.size();
				MathText n = l.get(z - 1);
				if (n.op1 == m.op1 && n.op2 == m.op2)
					continue;
			}
			l.add(m);
			i++;
		}
		return l;
	}

	class MathText {
		public int op1;
		public int op2;
		public OpType op;
		public int ans;
	}

	enum OpType {
		ADD, SUB, MUL, DIV
	}

}
