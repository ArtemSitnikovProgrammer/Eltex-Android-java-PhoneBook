package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);


        User[] users = {
                new Manager("Ivan", "700", "M"),
                new Manager("Mary", "800", "W"),
                new Developer("Dmitry", "900","M"),
                new Developer("Katy", "600", "W")
        };

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

//        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                System.out.println(users[position].getName());
//                Toast.makeText(getApplicationContext(), users[position].getPhone(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}