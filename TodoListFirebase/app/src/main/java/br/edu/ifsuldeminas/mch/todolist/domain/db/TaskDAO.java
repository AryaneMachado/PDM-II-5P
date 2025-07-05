package br.edu.ifsuldeminas.mch.todolist.domain.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.todolist.domain.Task;

public class TaskDAO extends DAO {

    private static final String TABLE_NAME = "tasks";

    public TaskDAO (Context context) {
        super(context);
    }

    public void save(Task task) {
        SQLiteDatabase db = null;

        try {
            db = openToWrite();

            ContentValues content = new ContentValues();
            content.put("description", task.getDescription());
            String active = task.isActive() ? "1" : "0";
            content.put("active", active);

            db.insert(TABLE_NAME, null, content);
        } catch (Exception e) {
            Log.e("br.edu.ifsuldeminas.mch.todolist.domain.TaskDAO",
                    e.getMessage());
        } finally {
            if (db != null)
                db.close();
        }
    }

    public void update(Task task) {
        SQLiteDatabase db = openToWrite();

        ContentValues content = new ContentValues();
        content.put("description", task.getDescription());
        String active = task.isActive() ? "1" : "0";
        content.put("active", active);

        String[] params = {String.valueOf(task.getId())};
        db.update(TABLE_NAME, content, " id = ? ", params);

        db.close();
    }

    public void delete(Task task) {
        SQLiteDatabase db = openToWrite();

        String[] params = {String.valueOf(task.getId())};
        db.delete(TABLE_NAME, " id = ? ", params);

        db.close();
    }

    public List<Task> listAll() {
        SQLiteDatabase db = openToRead();
        List<Task> tasks = new ArrayList<>();
        String sql = " SELECT * FROM " + TABLE_NAME+";";

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (Exception e) {
            Log.e("br.edu.ifsuldeminas.mch.todolist.domain.db", e.getMessage());
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String desc = cursor.getString(cursor.getColumnIndexOrThrow("description"));
            String activeStr = cursor.getString(cursor.getColumnIndexOrThrow("active"));
            boolean active = "1".equals(activeStr);

            Task task = new Task(id);
            task.setDescription(desc);
            task.setActive(active);

            tasks.add(task);
        }

        cursor.close();
        db.close();

        return tasks;
    }
}
