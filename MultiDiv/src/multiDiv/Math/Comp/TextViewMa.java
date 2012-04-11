package multiDiv.Math.Comp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewMa extends TextView {

	public TextViewMa(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		CreateFont();
	}

	public TextViewMa(Context context, AttributeSet attrs) {
		super(context, attrs);
		CreateFont();
	}

	public TextViewMa(Context context) {
		super(context);
		CreateFont();
	}

	void CreateFont() {

	}
}
