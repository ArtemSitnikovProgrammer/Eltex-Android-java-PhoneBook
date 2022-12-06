package ru.eltex.phonebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "PHONES", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users (id NUMBER, name TEXT, phone TEXT);");
        sqLiteDatabase.execSQL("INSERT INTO users VALUES (1,\"Ivan\",\"900\"),(2,\"Mary\",\"800\"),(3,\"Anton\",\"700\");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users;");
        onCreate(sqLiteDatabase);
    }
}
