package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        users = new LinkedList<>();

        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users;",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            System.out.println("User: " + cursor.getString(1) + "- " + cursor.getString(2));
            users.add(new Developer(cursor.getString(1), cursor.getString(2), true));
            cursor.moveToNext();
        }
        cursor.close();

//        users.add(new Developer("Nika", "500", false));
//        users.add(new Manager("Ivan", "600", true));
//        users.add(new Manager("Mary", "700", false));
//        users.add(new Developer("Dmitry", "800",true));
//        users.add(new Developer("Katy", "900", false));


        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);


//        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                System.out.println(users[position].getName());
//                Toast.makeText(getApplicationContext(), users[position].getPhone(), Toast.LENGTH_SHORT).show();
//            }
//        });

        ((Button) findViewById(R.id.add_contact_button)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });

//        SharedPreferences preferences = getSharedPreferences("INFO",MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("APP_STATUS", "READY");
//        editor.commit();
//
//        Toast.makeText(this, preferences.getString("APP_STATUS", "STOP"),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView mainList = (ListView) findViewById(R.id.main_list);
        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("INFO",MODE_PRIVATE);
        Toast.makeText(this, preferences.getString("APP_STATUS", "STOP"),Toast.LENGTH_SHORT).show();
    }
}