package com.example.jjesusmonroy.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText email;
    RadioGroup radioGroup;
    RadioButton male,female;
    CheckBox h1,h2,h3;
    Spinner zodiac;
    Button save,get;

    private final String emaill="email",rg="rg",hh1="hh1",hh2="hh2",hh3="hh3",zodiacosign="zodiacsign";


    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sharedPreferences = getPreferences(MODE_PRIVATE);
    }

    public void saveMe(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(emaill, email.getText().toString());
        editor.putInt(rg,valueRB(male));
        editor.putInt(hh1,valueCB(h1));
        editor.putInt(hh2,valueCB(h2));
        editor.putInt(hh3,valueCB(h3));
        editor.putInt(zodiacosign,zodiac.getSelectedItemPosition());
        editor.commit();
        clear();
    }

    public void getMe(View view){
        email.setText(sharedPreferences.getString(emaill,null));
        if(sharedPreferences.getInt(rg,0)==1)male.setChecked(true);
        else female.setChecked(true);
        if(sharedPreferences.getInt(hh1,0)==1)h1.setChecked(true);
        else h1.setChecked(false);
        if(sharedPreferences.getInt(hh2,0)==1)h2.setChecked(true);
        else h2.setChecked(false);
        if(sharedPreferences.getInt(hh3,0)==1)h3.setChecked(true);
        else h3.setChecked(false);
        zodiac.setSelection(sharedPreferences.getInt(zodiacosign,0));
    }

    private void init(){
        email=findViewById(R.id.email);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        h1=findViewById(R.id.hobbie1);
        h2=findViewById(R.id.hobbie2);
        h3=findViewById(R.id.hobbie3);
        zodiac=findViewById(R.id.zodiac);
        save=findViewById(R.id.save);
        get=findViewById(R.id.get);
        radioGroup=findViewById(R.id.radioGroup);
    }
    private void clear(){
        email.setText("");
        if(male.isChecked())male.setChecked(false);
        if(female.isChecked())female.setChecked(false);
        h1.setChecked(false);
        h2.setChecked(false);
        h3.setChecked(false);
        zodiac.setSelection(0);
    }
    private int valueRB(RadioButton r){
        if(r.isChecked())return 1;
        else return 0;
    }
    private int valueCB(CheckBox c){
        if(c.isChecked())return 1;
        else return 0;
    }
}
