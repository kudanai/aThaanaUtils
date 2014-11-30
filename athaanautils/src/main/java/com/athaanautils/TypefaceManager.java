package com.athaanautils;

import android.content.Context;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.HashMap;

/**
 * Simple singleton typeface manager to handle
 * memory efficient typeface stuff
 *
 * @author kudanai
 * @version 0.1
 */
public class TypefaceManager {

    private static TypefaceManager _instance;
    private HashMap<String,Typeface> _typefaces;

    // required empty constructor
    public TypefaceManager(){

    }

    /**
     * Call this to return an instance of the TypefaceManager.
     * Do not instantiate directly, for performance reasons.
     * @return singleton instance of TypefaceManager
     */
    public synchronized static TypefaceManager getInstance(){
        //lazy instantiation
        if(_instance==null)
            _instance = new TypefaceManager();

        return _instance;
    }


    /**
     * Call this to optain an instance of a typeface. Provide
     * context to access asset.
     * @param assetName the name of the asset to obtain the typeface from
     * @param context the context to obtain the assetmanager from
     * @return a typeface instance
     * @throws java.io.IOException if the asset isn't found
     */
    public synchronized Typeface getTypeface(String assetName, Context context) throws IOException {
        if(_typefaces==null)
            _typefaces = new HashMap<String, Typeface>();

        if(_typefaces.containsKey(assetName)) //if already instantiated
            return _typefaces.get(assetName);
        else {  //if not already instantiate it, create and put in hashmap
            Typeface m = Typeface.createFromAsset(context.getAssets(),assetName);
            if(m==null)
                throw new IOException("The specified font "+assetName+"could not be found"); //throw an exception if not successful
            _typefaces.put(assetName,m);
            return m;
        }
    }

}
