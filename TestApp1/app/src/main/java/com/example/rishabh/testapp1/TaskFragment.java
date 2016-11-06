package com.example.rishabh.testapp1;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskFragment extends Fragment {

    private static final String ARG_TASK_ID = "task_id";

    private Task mTask;
    private TextView mTitleField;
    private TextView mDescription;
  //  private CheckBox mSolvedCheckBox;

    public static TaskFragment newInstance(int taskId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID, taskId);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int taskId = (int) getArguments().getSerializable(ARG_TASK_ID);
        //mTask = TaskLab.get(getActivity()).getTask(taskId);
        TasksDB db=new TasksDB(getActivity());
        ArrayList<Task> l=new ArrayList<Task>();
        l=db.getAllTasks();
        int i;
        for (Task task : l) {
            if (task.getId() == (taskId))
                mTask = task;
        }
      //  mTask=db.getTask(taskId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task, container, false);

        mTitleField = (TextView) v.findViewById(R.id.task_title);
        mTitleField.setText(mTask.getTitle());
      /*  mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        mDescription = (TextView) v.findViewById(R.id.task_description);
        mDescription.setText(mTask.getDescription().toString());
        //mDateButton.setEnabled(false);

      /*  mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });*/

        return v;
    }
}
