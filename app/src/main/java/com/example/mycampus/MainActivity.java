package com.example.mycampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1tu1, btn2tu1, btn3tu1, btn1tu2, btn2tu2;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        iniData();
        btn1tu1.setOnClickListener(this);
        btn2tu1.setOnClickListener(this);
        btn3tu1.setOnClickListener(this);
        btn1tu2.setOnClickListener(this);
        btn2tu2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void iniData(){
        btn1tu1 = findViewById(R.id.btnMainOne);
        btn2tu1 = findViewById(R.id.btnMainTwo);
        btn3tu1 = findViewById(R.id.btnMainThree);
        btn1tu2 = findViewById(R.id.btnMainDate);
        btn2tu2 = findViewById(R.id.btnMainTime);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMainOne:
                Intent move = new Intent(MainActivity.this, SecondMainActivity.class);
                txt = btn1tu1.getText().toString();
                move.putExtra("1", txt);
                startActivity(move);
                break;
            case R.id.btnMainTwo:
                Intent move2 = new Intent(MainActivity.this, SecondMainActivity.class);
                txt = btn2tu1.getText().toString();
                move2.putExtra("1", txt);
                startActivity(move2);
                break;
            case  R.id.btnMainThree:
                Intent move3 = new Intent(MainActivity.this, SecondMainActivity.class);
                txt = btn3tu1.getText().toString();
                move3.putExtra("1", txt);
                startActivity(move3);
                break;
            case  R.id.btnMainDate:
                Intent move4 = new Intent(MainActivity.this, PickerForDateActivity.class);
                startActivity(move4);
                break;
            case  R.id.btnMainTime:
                Intent move5 = new Intent(MainActivity.this, PickerForTimeActivity.class);
                startActivity(move5);
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemSettings:
                displayToast(getString(R.string.toastSettings));
                break;
            case R.id.menuItemHelp:
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.menuItemLogout:
                displayToast(getString(R.string.toastLogout));
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}