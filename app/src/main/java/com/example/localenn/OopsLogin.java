package com.example.localenn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OopsLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopslogin);
    }

    public void gaslog(View view) {
        Intent it = new Intent(OopsLogin.this, Register.class );
        startActivity(it);
    }

    public void loginbtn(View view) {
        Intent it = new Intent(OopsLogin.this, Login.class );
        startActivity(it);
    }
}
