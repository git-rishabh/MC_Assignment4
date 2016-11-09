// The files source is taken and referred from the Code posted by Pushpendra Sir on backpack.

package com.example.rishabh.testapp1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class TaskPagerActivity extends AppCompatActivity {

    private static final String EXTRA_TASK_ID =
            "com.bignerdranch.android.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Task> mTasks;

    public static Intent newIntent(Context packageContext, int taskId) {
        Intent intent = new Intent(packageContext, TaskPagerActivity.class);
        intent.putExtra(EXTRA_TASK_ID, taskId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pager);

        int taskId = (int) getIntent()
                .getSerializableExtra(EXTRA_TASK_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);

       // mTasks = TaskLab.get(this).getTasks();

        TasksDB db=new TasksDB(this);
        mTasks=db.getAllTasks();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Task task = mTasks.get(position);
                return TaskFragment.newInstance(task.getId());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });

        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getId()==taskId) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
