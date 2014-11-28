package com.athaanautils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Simple TextView capable of taking an attribute in xml
 * and set the font accordingly.
 *
 * @author kudanai
 * @version 0.1
 */
public class ThaanaAssetTextView extends TextView{

    public ThaanaAssetTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ThaanaAssetTextView,
                0, 0);

        try {
            String tf = a.getString(R.styleable.ThaanaAssetTextView_assetfont);
            boolean rtl = a.getBoolean(R.styleable.ThaanaAssetTextView_isrtl, true);

            // Do RTL thing. should be true by default, but in case
            // we want to use it for other things, do checking
            if(rtl){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    this.setTextDirection(TEXT_DIRECTION_RTL);
                    this.setLayoutDirection(LAYOUT_DIRECTION_RTL);
                    this.setTextAlignment(TEXT_ALIGNMENT_TEXT_START); //or set rtl
                    this.setGravity(Gravity.START); // using start since already flipped RTL
                } else {
                    this.setGravity(Gravity.RIGHT); //that's about all we can do I guess
                }
            }

            if (tf != null) {
                this.setTypeface(TypefaceManager.getInstance().getTypeface(tf, context));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            a.recycle();
        }
    }

}
