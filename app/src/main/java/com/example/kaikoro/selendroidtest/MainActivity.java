package com.example.kaikoro.selendroidtest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.selendroid.common.SelendroidCapabilities;

public class MainActivity extends AppCompatActivity {
    //変数の宣言
    //EditTextの宣言
    EditText editURL;
    EditText editID;
    EditText editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditTextの関連付け
        editURL =(EditText)findViewById(R.id.editURL);      //URL
        editID =(EditText)findViewById(R.id.editID);        //ID
        editPass =(EditText)findViewById(R.id.editPass);    //Password

        //起動時にパラメータを読み込む
        SharedPreferences data = getSharedPreferences("IdInfo", MODE_PRIVATE);
        editURL.setText(data.getString("editURL", ""));     //URL
        editID.setText(data.getString("editID", ""));       //ID
        editPass.setText(data.getString("editPass", ""));   //Password

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.runURL:
                //パラメータの保存する
                SharedPreferences data = getSharedPreferences("loginParameter", MODE_PRIVATE);
                SharedPreferences.Editor loginParameter = data.edit();
                loginParameter.putString("editURL",editURL.getText().toString());   //URL
                loginParameter.putString("editID",editID.getText().toString());     //ID
                loginParameter.putString("editPass",editPass.getText().toString()); //Password
                break;
            case R.id.HTML:
                break;
        }
    }
}
