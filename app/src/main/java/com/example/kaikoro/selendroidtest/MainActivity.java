package com.example.kaikoro.selendroidtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


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
        SharedPreferences data = getSharedPreferences("loginParameter", MODE_PRIVATE);
        editURL.setText(data.getString("editURL", ""));     //URL
        editID.setText(data.getString("editID", ""));       //ID
        editPass.setText(data.getString("editPass", ""));   //Password

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.runURL:

                String url=editURL.getText().toString();
                String id=editID.getText().toString();
                String pass=editPass.getText().toString();

                Intent intent = new Intent(this, LoginFormActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("id", id);
                intent.putExtra("pass", pass);
                startActivity(intent);

                break;
            case R.id.HTML:
                break;
            case R.id.save:
                //パラメータの保存する
                SharedPreferences data = getSharedPreferences("loginParameter", MODE_PRIVATE);
                SharedPreferences.Editor loginParameter = data.edit();
                loginParameter.putString("editURL",editURL.getText().toString());   //URL
                loginParameter.putString("editID",editID.getText().toString());     //ID
                loginParameter.putString("editPass",editPass.getText().toString()); //Password
                loginParameter.apply();
                Toast.makeText(this, "保存しました", Toast.LENGTH_SHORT).show();
        }
    }
}
