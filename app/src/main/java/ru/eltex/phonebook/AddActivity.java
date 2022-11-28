package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ImageView imageView = (ImageView) findViewById(R.id.avatar);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                System.out.println(name + " " + phone);


            }
        });

    }
}