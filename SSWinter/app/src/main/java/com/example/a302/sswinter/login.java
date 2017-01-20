package com.example.a302.sswinter;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class login extends AppCompatActivity implements View.OnClickListener{

    EditText id,pw;
    Button out,signUp;
    String getId,getPw;
    Snackbar idSn,pwSn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        id = (EditText)findViewById(R.id.id);
        pw = (EditText)findViewById(R.id.pw);
        out = (Button)findViewById(R.id.out);
        signUp = (Button)findViewById(R.id.login);
        out.setOnClickListener(this);
        signUp.setOnClickListener(this);
        id.setOnClickListener(this);
        pw.setOnClickListener(this);
        StrictMode.ThreadPolicy pl = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pl);

    }
    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.login:
                getId = id.getText().toString();
                if(getId.getBytes().length <= 0){
                    idSn.make(v,"아이디를 입력해주세요",Snackbar.LENGTH_SHORT).show();
                    id.setText(null);
                    pw.setText(null);
                    break;
                }else
                    getPw = pw.getText().toString();
                if(getPw.getBytes().length <=0){
                    pwSn.make(v,"비밀번호를 입력해주`세요",Snackbar.LENGTH_SHORT).show();
                    break;
                }
                id.setText(null);
                pw.setText(null);
                break;
            case R.id.out:
                this.finish();
                overridePendingTransition(R.anim.gone,R.anim.go);
                Intent in = new Intent(this, MainActivity.class);
                startActivity(in);
                break;
        }
    }

}


