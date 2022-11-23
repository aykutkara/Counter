package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    Button btn_upper_minus,btn_upper_plus,btn_lower_minus,btn_lower_plus;
    CheckBox checkBox_upper_vib,checkBox_upper_sound,checkBox_lower_vib,checkBox_lower_sound;
    EditText editText_upper_value,editText_lower_value;

    SettingsClass settingsClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btn_upper_minus = (Button) findViewById(R.id.btn_upper_minus);
        btn_upper_plus = (Button) findViewById(R.id.btn_upper_plus);
        btn_lower_minus = (Button) findViewById(R.id.btn_lower_minus);
        btn_lower_plus = (Button) findViewById(R.id.btn_lower_plus);
        checkBox_upper_vib = (CheckBox) findViewById(R.id.checkBox_upper_vib);
        checkBox_upper_sound = (CheckBox) findViewById(R.id.checkBox_upper_sound);
        checkBox_lower_vib = (CheckBox) findViewById(R.id.checkBox_lower_vib);
        checkBox_lower_sound = (CheckBox) findViewById(R.id.checkBox_lower_sound);

        editText_upper_value = (EditText) findViewById(R.id.editTextNumberSigned_upper_value);
        editText_lower_value = (EditText) findViewById(R.id.editTextNumberSigned_lower_value);

        settingsClass = SettingsClass.getSettingsClass(getApplicationContext());


        btn_upper_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsClass.upperLimit++;
                editText_upper_value.setText(String.valueOf(settingsClass.upperLimit));
            }
        });
        btn_upper_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsClass.upperLimit--;
                editText_upper_value.setText(String.valueOf(settingsClass.upperLimit));
            }
        });
        btn_lower_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsClass.lowerLimit++;
                editText_lower_value.setText(String.valueOf(settingsClass.lowerLimit));
            }
        });
        btn_lower_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsClass.lowerLimit--;
                editText_lower_value.setText(String.valueOf(settingsClass.lowerLimit));
            }
        });

        checkBox_upper_vib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                settingsClass.upperVib =b;
            }
        });
        checkBox_upper_sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                settingsClass.upperSound =b;
            }
        });
        checkBox_lower_vib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                settingsClass.lowerVib =b;
            }
        });
        checkBox_lower_sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                settingsClass.lowerSound =b;
            }
        });
        editText_upper_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText_upper_value.getText().toString().length() !=0){
                    settingsClass.upperLimit = Integer.parseInt(editText_upper_value.getText().toString());
                }
            }
        });
        editText_lower_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText_lower_value.getText().toString().length() !=0){
                    settingsClass.lowerLimit = Integer.parseInt(editText_lower_value.getText().toString());
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        editText_upper_value.setText(String.valueOf(settingsClass.upperLimit));
        editText_lower_value.setText(String.valueOf(settingsClass.lowerLimit));
        checkBox_upper_vib.setChecked(settingsClass.upperVib);
        checkBox_upper_sound.setChecked(settingsClass.upperSound);
        checkBox_lower_vib.setChecked(settingsClass.lowerVib);
        checkBox_lower_sound.setChecked(settingsClass.lowerSound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        settingsClass.saveValues();

    }
}