package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        Intent info = getIntent();
        String name = info.getStringExtra("name");
        String phone = info.getStringExtra("phone");
        //String img = info.getStringExtra("avatar");

        System.out.println("FROM DEVACTIVITY: " + name + " " + phone + " ");

        //((ImageView) findViewById(R.id.avatar)).setImageResource();
        ((TextView) findViewById(R.id.name)).setText(name);
        ((TextView) findViewById(R.id.phone)).setText(phone);
    }
}