package com.example.counter;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsClass{
    int upperLimit,lowerLimit,currentValue;
    boolean upperVib,upperSound,lowerVib,lowerSound;

    static SettingsClass settingsClass = null;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private SettingsClass(Context context){
        sharedPreferences =context.getSharedPreferences("settings",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loadValues();
    }

    public static SettingsClass getSettingsClass(Context context){
        if (settingsClass ==null){
            settingsClass = new SettingsClass(context);
        }
        return  settingsClass;
    }
     public  void saveValues(){
        editor.putInt("upperLimit",upperLimit);
        editor.putInt("lowerLimit",lowerLimit);
        editor.putInt("currentValue",currentValue);
        editor.putBoolean("upperVib",upperVib);
        editor.putBoolean("upperSound",upperSound);
        editor.putBoolean("lowerVib",lowerVib);
        editor.putBoolean("lowerSound",lowerSound);
        editor.commit();
     }
     public void loadValues(){
        upperLimit = sharedPreferences.getInt("upperLimit",10);
        lowerLimit = sharedPreferences.getInt("lowerLimit",0);
        currentValue = sharedPreferences.getInt("currentValue",0);
        upperVib = sharedPreferences.getBoolean("upperVib",false);
        upperSound = sharedPreferences.getBoolean("upperSound",false);
        lowerVib = sharedPreferences.getBoolean("lowerVib",false);
        lowerSound = sharedPreferences.getBoolean("lowerSound",false);
     }


}
