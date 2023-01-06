package com.umak.testingheronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    static String Account = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }


    public void student_user(View view) {
        Account = "student";
        Intent intent = new Intent(getApplicationContext(), Register_Student.class);
        startActivity(intent);
        finish();
    }


    public void parent_user(View view) {
        Account = "parent";
        Intent intent = new Intent(getApplicationContext(), Register_Student.class);
        startActivity(intent);
        finish();
    }


    public void reporter_user(View view) {
        Account = "reporter";
        Intent intent = new Intent(getApplicationContext(), Register_Student.class);
        startActivity(intent);
    }
}