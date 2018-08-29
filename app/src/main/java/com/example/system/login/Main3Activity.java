package com.example.system.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

//    Intent in = getIntent();
//    String value1 = in.getStringExtra("key1");

    public void logout(View view)
    {
        Intent intent = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
            Intent in = getIntent();
    String value1 = in.getStringExtra("key1");

        Toast.makeText(this, "welcome "+value1, Toast.LENGTH_SHORT).show();
    }
}
