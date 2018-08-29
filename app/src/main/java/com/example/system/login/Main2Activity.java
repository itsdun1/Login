package com.example.system.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String first_name,last_name,username,passsword;
    public void register(View view)
    {
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        first_name = editText3.getText().toString();
        last_name = editText4.getText().toString();
        username = editText5.getText().toString();
        passsword = editText6.getText().toString();

        SQLiteDatabase database = this.openOrCreateDatabase("Users1", MODE_PRIVATE, null);
        try {

//            try{
//                String query="SELECT username,password FROM Users1 WHERE username='" + username +"'  LIMIT 1";
//                Cursor c = database.rawQuery(query, null);
//                if ((c.moveToFirst()) || c.getCount() >0)
//                {
//                    Toast.makeText(this, "Enter another username credentials", Toast.LENGTH_SHORT).show();
//                    finish();
//                    overridePendingTransition(0, 0);
//                    startActivity(getIntent());
//                    overridePendingTransition(0, 0);
//
//
//                }
//
//
//            }catch(Exception e)
//            {
//
//            }


           database.execSQL("INSERT INTO Users2 (first_name,last_name,username,password) VALUES('" + first_name + "','" + last_name + "','" + username + "','" + passsword + "')");
//            Log.i("ducces","asjdj");
            Toast.makeText(this, "User added Succefully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
//            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(intent);

        }catch (Exception e)
        {
            Toast.makeText(this, "enter another username or do not fill empty information", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
