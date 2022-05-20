package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    TextView createV , forgotPass;
    EditText loginEmail ,loginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEmail = findViewById(R.id.loginEmail);
        loginPass = findViewById(R.id.loginPass);
        btnlogin = findViewById(R.id.loginBtn);
        createV = findViewById(R.id.createAccV);
        forgotPass = findViewById(R.id.forgetPass);

        createV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newi = new Intent(MainActivity.this,regsiter_form.class);
                startActivity(newi);
            }
        });
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newf = new Intent(MainActivity.this,forgetpassword.class);
                startActivity(newf);
                finish();

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getemail = loginEmail.getText().toString();
                String getpass = loginPass.getText().toString();

                String reg = "[A-Za-z+_.]+@(.+pub)$";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(getemail);

                if(matcher.matches()){
                Intent logi = new Intent(MainActivity.this,emp_listview.class);
                startActivity(logi);
                finish();
                }else{loginEmail.setText("");}



            }
        });

    }
}