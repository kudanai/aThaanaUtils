package com.athaanautils;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Simple InputFilter implementation, which will
 * run the changes through the ThaanaConversions
 * class, and return an appropriately converted
 * thing.
 *
 * @author kudanai
 * @version 0.1
 */
public class ThaanaInputFilter implements InputFilter {

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        CharSequence converted = ThaanaConversions.transposePhoneticSegha(source);
        if(converted.equals(source))
            return null;
        else
            return converted;
    }
}
