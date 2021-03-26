package com.example.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dialog.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get floatingbutton
        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.floatingActionButton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Interface for interacting with Fragment objects inside of an Activity
                //FragmentManager is the class responsible for performing actions on your app's
                // fragments, such as adding, removing, or replacing them, and adding them to the back stack
                FragmentManager framentManager = getSupportFragmentManager();

                // a transaction can add or replace multiple fragments
                FragmentTransaction ft =  framentManager.beginTransaction();


                DialogFragment newFragment = FullscreenDialog.newInstance();
                newFragment.show(ft, "fullscreen_dialog");


            }
        });
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void Text(String hourOfDay, String minute)
    {
        setContentView(R.layout.activity_main);
        TextView dateFroms =(TextView)findViewById(R.id.dateFrom);
        dateFroms.setText("1");
    }


}