package com.example.rishabh.testapp1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class TaskListActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_addtask);

    }

    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.add_task:
                GotoAddTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void GotoAddTask()
    {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
        //updateUI();
    }
}
