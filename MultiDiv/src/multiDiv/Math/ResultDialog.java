package multiDiv.Math;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.view.View;
import android.widget.TextView;

public class ResultDialog {

	public static ResultDialog newInstance() {
		return new ResultDialog();
	}

	/*
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle savedInstanceState) { View v =
	 * inflater.inflate(R.layout.report, container, false); Button b = (Button)
	 * v.findViewById(R.id.bRpDone);
	 * 
	 * b.setOnClickListener(new Button.OnClickListener() { public void
	 * onClick(View arg0) { CloseDialog(); } });
	 * 
	 * CreateInfo(v); return v; }
	 */

	void CreateInfo(View v) {
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
			Ops += "+";
		else
			Ops += " ";
		if (ConfigGame.subGame)
			Ops += "-";
		else
			Ops += " ";
		if (ConfigGame.mulGame)
			Ops += "x";
		else
			Ops += " ";
		if (ConfigGame.divGame)
			Ops += "÷";
		else
			Ops += " ";

		String Rs = String.format("%s|%s|%s|%d|%d|%.2f|%s\n", Dt, Tm, Es,
				ConfigGame.goodResult, ConfigGame.badResult,
				ConfigGame.elapseTime / (float) ConfigGame.goodResult, Ops);

		ConfigGame.SaveResult(v.getContext(), Rs);
	}

	void CloseDialog() {
		// this.dismiss();
	}
}
