package com.example.rishabh.testapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rishabh on 11/3/2016.
 */
public class AddTaskActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    public String title;
    public String description;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

    }

    public void AddTask(View view){
        boolean b_description=false,b_title=false;
        EditText text_title;
        text_title= (EditText) findViewById(R.id.addtask_title);
        if(!text_title.getText().toString().matches("")){
            title=text_title.getText().toString();
            //  Log.d(TAG,name);
            b_title=true;
        }

        EditText text_description;
        text_description= (EditText) findViewById(R.id.addtask_description);
        if(!text_description.getText().toString().matches("")){
            description=text_description.getText().toString();
            //  Log.d(TAG,name);
            b_description=true;
        }

        if(b_title && b_description)
        {
            Log.d(TAG,title);
            Log.d(TAG,description);
            Task new_task=new Task(title,description);
            TasksDB event_db=new TasksDB(this);
            boolean i=event_db.inserttask(new_task);
            if(i){
                Toast toast = Toast.makeText(getApplicationContext(), "TASK CREATED", Toast.LENGTH_LONG);
                toast.show();
                text_description.setText("");
                text_title.setText("");
                Intent intent=new Intent(this,TaskListActivity.class);
                startActivity(intent);
                finish();
            }
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Fill in all fields", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    }

