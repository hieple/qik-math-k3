package multiDiv.Math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiDivActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button button1 = (Button) findViewById(R.id.mRpt);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite1 = new Intent(MultiDivActivity.this,
						ReportView.class);
				ite1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite1);
			}
		});

		final Button button2 = (Button) findViewById(R.id.mCfg);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite2 = new Intent(MultiDivActivity.this,
						ConfigMath.class);
				ite2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite2);
			}
		});

		final Button button3 = (Button) findViewById(R.id.mPrc);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent ite3 = new Intent(MultiDivActivity.this, MainWork.class);
				ite3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ite3);
			}
		});
	}

}