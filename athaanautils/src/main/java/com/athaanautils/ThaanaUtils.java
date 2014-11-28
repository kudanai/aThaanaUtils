package com.athaanautils;

import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;


import java.io.IOException;

/**
 * Generic utility functions.
 *
 * @author kudanai
 * @version 0.1
 */
public class ThaanaUtils {

    /**
     * Sets the typeface, layout-direction, gravity etc on any TextView
     * subclass. Just a convenience function.
     *
     * @param v the View in question
     * @param fontAsset the location of the font to use (relative to assets)
     * @throws java.io.IOException if the font resource is not found
     */
    public static void thaanafyTextViewSubclass(View v,String fontAsset) throws IOException {
        TextView tv = (TextView) v; //will probably throw a classcast exception for good measure
        tv.setTypeface(TypefaceManager.getInstance().getTypeface(fontAsset, v.getContext()));

        // Do RTL thing. should be true by default, but in case
        // we want to use it for other things, do checking
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setTextDirection(View.TEXT_DIRECTION_RTL);
            tv.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START); //or set rtl
            tv.setGravity(Gravity.START); // using start since already flipped RTL
        } else {
            tv.setGravity(Gravity.RIGHT); //that's about all we can do I guess
        }

    }

}
