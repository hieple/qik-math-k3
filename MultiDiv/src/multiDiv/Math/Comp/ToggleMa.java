package multiDiv.Math.Comp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class ToggleMa extends ToggleButton {

	boolean bgReversed = false;
	
	public ToggleMa(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		CreateFont();
		OnClick();
	}

	public ToggleMa(Context context, AttributeSet attrs) {
		super(context, attrs);
		CreateFont();
		OnClick();
	}

	public ToggleMa(Context context) {
		super(context);
		CreateFont();
		OnClick();
	}

	void CreateFont() {

	}

	public void setBgReversed(){
		bgReversed = true;
	}
	
	public void switchButton(boolean isOn) {
	
		if (bgReversed)
			isOn = !isOn;
		
		final GradientDrawable SdwOff = (GradientDrawable) this.getContext()
				.getResources()
				.getDrawable(multiDiv.Math.R.drawable.rec_lines_off);
		final GradientDrawable SdwOn = (GradientDrawable) this.getContext()
				.getResources()
				.getDrawable(multiDiv.Math.R.drawable.rec_lines_on);
		if (isOn) {
			setTextColor(Color.WHITE);
			setBackgroundDrawable(SdwOn);

		} else {
			setTextColor(Color.WHITE);
			setBackgroundDrawable(SdwOff);
		}
	}

	void OnClick() {
		if (!isInEditMode()) {
			this.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					switchButton(isChecked);
				}
			});
		}
	}

}
