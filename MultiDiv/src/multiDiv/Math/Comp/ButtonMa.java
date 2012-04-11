package multiDiv.Math.Comp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;

public class ButtonMa extends Button {

	public ButtonMa(Context context, AttributeSet attrs) {
		super(context, attrs);
		CreateFont();
	}

	public ButtonMa(Context context, AttributeSet attrs, int i) {
		super(context, attrs, i);
		CreateFont();
	}

	public ButtonMa(Context context) {
		super(context);
		CreateFont();
	}

	void CreateFont() {

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight());
	}

	int measureHeight() {
		DisplayMetrics metrics = this.getContext().getResources()
				.getDisplayMetrics();
		int _height = metrics.heightPixels < metrics.widthPixels ? metrics.heightPixels
				: metrics.widthPixels;
		return _height / 6;
	}

	int measureWidth(int measureSpec) {
		return MeasureSpec.getSize(measureSpec);
	}
}
