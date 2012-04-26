package multiDiv.Math;

import multiDiv.Math.Comp.TextViewMa;
import multiDiv.Math.Comp.ToggleMa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ConfigMath extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);

		final Button button1 = (Button) findViewById(R.id.cHme);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SaveConfig();
				Intent ite1 = new Intent(ConfigMath.this,
						MultiDivActivity.class);
				ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite1);
			}
		});

		final Button button2 = (Button) findViewById(R.id.cPtc);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SaveConfig();
				Intent ite3 = new Intent(ConfigMath.this, MainWork.class);
				ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite3);
			}
		});

		final Button button3 = (Button) findViewById(R.id.cRpt);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SaveConfig();
				Intent ite4 = new Intent(ConfigMath.this, ReportView.class);
				ite4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite4);
			}
		});

		final SeekBar Sb = (SeekBar) findViewById(R.id.tNumTest);
		Sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				final TextViewMa t = (TextViewMa) findViewById(R.id.tTest);
				int s = arg1 + ConfigGame.N_O_T;
				ConfigGame.numOfTest = s;
				t.setText(String.format("%d", s));
			}

			public void onStartTrackingTouch(SeekBar arg0) {

			}

			public void onStopTrackingTouch(SeekBar arg0) {

			}

		});

		final SeekBar Sc = (SeekBar) findViewById(R.id.tTimeTest);
		Sc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				final TextViewMa d = (TextViewMa) findViewById(R.id.tTime);
				int s = arg1 + ConfigGame.D_O_T;
				ConfigGame.durationOfTest = s;
				d.setText(ConfigGame.HourMinuteSecond(s));
			}

			public void onStartTrackingTouch(SeekBar arg0) {

			}

			public void onStopTrackingTouch(SeekBar arg0) {

			}

		});

		final SeekBar Sd = (SeekBar) findViewById(R.id.tNumberTest);
		Sd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				final TextViewMa d = (TextViewMa) findViewById(R.id.tNumber);
				int s = arg1 + ConfigGame.N_U_B;
				ConfigGame.maxNumber = s;
				d.setText(String.format("%d", s));
			}

			public void onStartTrackingTouch(SeekBar arg0) {

			}

			public void onStopTrackingTouch(SeekBar arg0) {

			}

		});

		final ToggleMa oA = (ToggleMa) findViewById(R.id.tAdd);
		oA.toggle();
		oA.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ConfigGame.addGame = oA.isChecked();
			}
		});

		final ToggleMa oS = (ToggleMa) findViewById(R.id.tSub);
		oS.toggle();
		oS.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ConfigGame.subGame = oS.isChecked();
			}
		});

		final ToggleMa oM = (ToggleMa) findViewById(R.id.tMul);
		oM.toggle();
		oM.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ConfigGame.mulGame = oM.isChecked();
			}
		});

		final ToggleMa oD = (ToggleMa) findViewById(R.id.tDiv);
		oD.toggle();
		oD.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ConfigGame.divGame = oD.isChecked();
			}
		});

		ConfigGame.ReadConfig(this);

		SetScreenInfo();
	}

	void SaveConfig() {
		ConfigGame.SaveConfig(this);
	}

	void SetScreenInfo() {
		final ToggleMa oA = (ToggleMa) findViewById(R.id.tAdd);
		oA.setChecked(ConfigGame.addGame);

		final ToggleMa oS = (ToggleMa) findViewById(R.id.tSub);
		oS.setChecked(ConfigGame.subGame);

		final ToggleMa oM = (ToggleMa) findViewById(R.id.tMul);
		oM.setChecked(ConfigGame.mulGame);

		final ToggleMa oD = (ToggleMa) findViewById(R.id.tDiv);
		oD.setChecked(ConfigGame.divGame);

		final SeekBar Sb = (SeekBar) findViewById(R.id.tNumTest);
		Sb.setProgress(ConfigGame.numOfTest - ConfigGame.N_O_T);
		final TextViewMa t1 = (TextViewMa) findViewById(R.id.tTest);
		t1.setText(String.format("%d", ConfigGame.numOfTest));

		final SeekBar Sc = (SeekBar) findViewById(R.id.tTimeTest);
		Sc.setProgress(ConfigGame.durationOfTest - ConfigGame.D_O_T);
		final TextViewMa t2 = (TextViewMa) findViewById(R.id.tTime);
		t2.setText(String.format("%s",
				ConfigGame.HourMinuteSecond(ConfigGame.durationOfTest)));

		final SeekBar Sd = (SeekBar) findViewById(R.id.tNumberTest);
		Sd.setProgress(ConfigGame.maxNumber - ConfigGame.N_U_B);
		final TextViewMa t3 = (TextViewMa) findViewById(R.id.tNumber);
		t3.setText(String.format("%d", ConfigGame.maxNumber));
	}

}
