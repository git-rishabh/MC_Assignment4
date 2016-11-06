package com.example.rishabh.testapp1;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskLab extends AppCompatActivity{
    private static TaskLab sTaskLab;

    private ArrayList<Task> mTasks;

    public static TaskLab get(Context context) {
        if (sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    private TaskLab(Context context) {
        mTasks = new ArrayList<>();
     /*   for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setTitle("Task #" + i);
            task.setDescription("Task Description #" + i);

            mTasks.add(task);
        }*/
    }

    public List<Task> getTasks() {
        TasksDB db=new TasksDB(this);
        mTasks=db.getAllTasks();
        return mTasks;
    }

    public Task getTask(int id) {
       TasksDB db=new TasksDB(this);
       Task t=db.getTask(id);
      /*  for (Task task : mTasks) {
            if (task.getId()==(id)) {
                return task;
            }
        }*/
        return t;
    }
}
