package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        users = new LinkedList<>();

        users.add(new Developer("Nika", "500", false));
        users.add(new Manager("Ivan", "600", true));
        users.add(new Manager("Mary", "700", false));
        users.add(new Developer("Dmitry", "800",true));
        users.add(new Developer("Katy", "900", false));


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