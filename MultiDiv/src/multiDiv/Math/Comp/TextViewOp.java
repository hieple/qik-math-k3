package multiDiv.Math.Comp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class TextViewOp extends TextView {

	public TextViewOp(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		CreateFont();
	}

	public TextViewOp(Context context, AttributeSet attrs) {
		super(context, attrs);
		CreateFont();
	}

	public TextViewOp(Context context) {
		super(context);
		CreateFont();
	}

	void CreateFont() {
		DisplayMetrics metrics = this.getContext().getResources()
				.getDisplayMetrics();
		int _height = metrics.heightPixels < metrics.widthPixels ? metrics.heightPixels
				: metrics.widthPixels;
		this.setTextSize(1, _height / 12);
	}
}
