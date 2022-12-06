package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    String gender;
    String employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        SharedPreferences preferences = getSharedPreferences("INFO",MODE_PRIVATE);
        Toast.makeText(this, preferences.getString("APP_STATUS", "STOP"), Toast.LENGTH_SHORT).show();

        ImageView imageView = (ImageView) findViewById(R.id.avatar);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                System.out.println(name + " " + phone + " " + gender);

                SQLiteDatabase database = new DBHelper(getApplicationContext()).getWritableDatabase();
                database.execSQL("INSERT INTO users(name, phone) VALUES('" + name + "', '" + phone + "')");
                database.close();

                if(employee.equals(Developer.class.getSimpleName())) {
                    MainActivity.users.add(new Developer(name, phone, gender));
                    System.out.println("ADD DEVELOPER");
                }else if(employee.equals(Manager.class.getSimpleName())){
                    MainActivity.users.add(new Manager(name,phone,gender));
                    System.out.println("ADD MANAGER");
                }

                finish();
            }
        });

        ((RadioGroup) findViewById(R.id.employee_radioGroup))
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        switch (checkedId) {
                            case -1:
                                employee = "Ничего не выбрано";
                                break;
                            case R.id.radio_developer:
                                employee = "Developer";
                                break;
                            case R.id.radio_manager:
                                employee = "Manager";
                                break;
                            default:
                                break;
                        }
                    }
                });

        ((RadioGroup) findViewById(R.id.gender_radioGroup))
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        gender = "Ничего не выбрано";
                        break;
                    case R.id.radio_men:
                        gender = "Men";
                        break;
                    case R.id.radio_women:
                        gender = "Women";
                        break;
                    default:
                        break;
                }
            }
        });

    }
}