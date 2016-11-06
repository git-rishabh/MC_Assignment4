package com.example.rishabh.testapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rishabh on 9/30/2016.
 */
public class TasksDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "task.db";
    public static final String USERS_TABLE_NAME = "tasks";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_TITLE = "title";
    public static final String USERS_COLUMN_DESCRIPTION = "description";
    private HashMap hp;

    public TasksDB(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table tasks " +
                        "(id integer primary key, title text, description text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    public boolean inserttask  (Task task)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", task.getTitle());
        contentValues.put("description", task.getDescription());

        db.insert("tasks", null, contentValues);
        return true;
    }

    public Task getTask(int id){
        SQLiteDatabase db = this.getReadableDatabase();
       // Cursor res =  db.rawQuery( "select * from tasks where id="+"'"+id+"'"+"", null );
        Cursor res =  db.rawQuery( "select * from tasks where id="+id, null );

        int id1=res.getInt(res.getColumnIndex(USERS_COLUMN_ID));
        String title=res.getString(res.getColumnIndex(USERS_COLUMN_TITLE));
        String description=res.getString(res.getColumnIndex(USERS_COLUMN_DESCRIPTION));
        Task newtask=new Task(id1,title,description);

        return newtask;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, USERS_TABLE_NAME);
        return numRows;
    }

  /*  public boolean updateUser (String name, String username, String qualification)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("username", username);
        contentValues.put("qualification", qualification);

        db.update("users", contentValues, "username = ? ", new String[] {username } );
        return true;
    }*/

   /* public Integer deleteUser(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tasks",
                "id = ? ",
                new String[] { username });
    }*/

    public ArrayList<Task> getAllTasks()
    {
        ArrayList<Task> array_list = new ArrayList<Task>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tasks", null );
        res.moveToFirst();


        while(res.isAfterLast() == false){
            int id1=res.getInt(res.getColumnIndex(USERS_COLUMN_ID));
            String title=res.getString(res.getColumnIndex(USERS_COLUMN_TITLE));
            String description=res.getString(res.getColumnIndex(USERS_COLUMN_DESCRIPTION));
            Task newuser=new Task(id1,title,description);
            array_list.add(newuser);
            res.moveToNext();
        }
        return array_list;
    }
}