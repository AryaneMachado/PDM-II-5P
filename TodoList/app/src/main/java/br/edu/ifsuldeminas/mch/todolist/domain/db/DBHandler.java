package br.edu.ifsuldeminas.mch.todolist.domain.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "tarefas.db";
    private static final int DB_VERSION = 1;


    private static final String TASKS_CREATE_SQL =
            " CREATE TABLE IF NOT EXISTS tasks ( " +
            " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " description TEXT, " +
            " active VARCHAR(1)); ";

    DBHandler (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(TASKS_CREATE_SQL);
        } catch (Exception e) {
            Log.e("br.edu.ifsuldeminas.mch.todolist.domain.dbDBHandler",
                    e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nas atualizações
    }
}
