package com.solomonron.mystudent_pilot;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsScreen extends AppCompatActivity {

    private RecyclerView studentListRV;
    private ArrayList<Student> studentList = new ArrayList<>();
    private StudentListAdapter mAdapter;
    private TextView addStudent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.students_screen);

        studentListRV = findViewById(R.id.students_list_RV);
        mAdapter = new StudentListAdapter(this, studentList); // משתמש בקונסטרקטור מתוך קלאס האדפטר
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        studentListRV.setLayoutManager(mLayoutManager);
        studentListRV.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        addStudent = findViewById(R.id.add_student_TV);


        studentList.add(new Student(1, "MICHAL", "SHUKER"));
        studentList.add(new Student(2, "RON", "SOLOMON"));
        studentList.add(new Student(3, "DAVID", "HAMELECH"));
        studentList.add(new Student(4, "ZUR", "BEN"));
        studentList.add(new Student(5, "ZIV", "AVRAMOVICH"));


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentDialog();

            }
        });


    }

    private void addStudentDialog() {

        final Dialog addStudentDlg = new Dialog(this);
        addStudentDlg.setContentView(R.layout.add_student_comment);

        //  TextView addStudentHeader = addStudentDlg.findViewById(R.id.add_student_header);
        final EditText newFirstName = addStudentDlg.findViewById(R.id.first_name_ET);
        final EditText newLastName = addStudentDlg.findViewById(R.id.last_name_ET);
        TextView cancelAddStudent = addStudentDlg.findViewById(R.id.cancel_addStudent_dlg);
        TextView confirmAddStudent = addStudentDlg.findViewById(R.id.confirm_addStudent_dlg);

        cancelAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentDlg.dismiss();

            }
        });


        confirmAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = newFirstName.getText() + "";
                String lastName = newLastName.getText() + "";


                studentList.add(new Student(6, firstName, lastName));


                addStudentDlg.dismiss();
            }
        });

        addStudentDlg.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.student_screen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.delete_class) {

            //מחיקת האייטם הראשון מהרשימה, יוחלף למחיקת כיתה מדאטהבייס מקומי
            studentList.remove(0);
            studentListRV.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

            return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

