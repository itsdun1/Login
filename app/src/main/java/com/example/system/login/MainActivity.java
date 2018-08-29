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

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    String users,passs;
    public void go(View view)
    {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
    public  void Login(View view) {

        EditText username = (EditText) findViewById(R.id.editText);
        EditText password = (EditText) findViewById(R.id.editText2);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        SQLiteDatabase database = this.openOrCreateDatabase("Users1", MODE_PRIVATE, null);
//        database.execSQL("CREATE TABLE IF NOT EXISTS USERS2(first_name VARCHAR NOT NULL,last_name VARCHAR NOT NULL,username VARCHAR NOT NULL UNIQUE ,password VARCHAR NOT NULL )");
//        database.execSQL("INSERT INTO Users2 (first_name,last_name,username,password) VALUES('Aditya','Kale','itsdun','Aditya99')");
//       hh Cursor c = database.rawQuery("SELECT * FROM Users " , null);
//        int i = c.getColumnIndex("first_name");
//        while(c!= null)
//        {
//            Log.i("siss",c.getString(i));
//
//        }

        try {
            String query="SELECT username,password FROM Users2 WHERE username='" + user +"' AND password='"+ pass+"' LIMIT 1";
            Cursor c = database.rawQuery(query, null);
//            int nameIndex = c.getColumnIndex("first_name");
//            int lastIndex = c.getColumnIndex("last_name");
            int userIndex = c.getColumnIndex("username");
            int passIndex = c.getColumnIndex("password");

            c.moveToFirst();

            if (!(c.moveToFirst()) || c.getCount() ==0)
            {
                Toast.makeText(this, "Enter correct credentials", Toast.LENGTH_SHORT).show();
            }
            else
            {



//                Log.i("Results - name", c.getString(nameIndex));
//                Log.i("Results - year", c.getString(lastIndex));
                    Log.i("ha ha ",c.getString(userIndex));
                     users = c.getString(userIndex);
                     passs = c.getString(passIndex);
                    Log.i("ha ha ",user);
                Log.i("Results - year", c.getString(passIndex));
                    Log.i("ha ha ",pass);








                if(users.equals(user) && passs.equals(pass))
                {

                    Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                    intent.putExtra("key1", user);
                    startActivity(intent);

//                    Log.i("isuahdj","success");
                }

                else
                {
                    Log.i("sadjkk","not succedd");
                }


            }




        } catch (Exception e) {
//            Toast.makeText(this, "Plese enter correct credentials", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
