package com.example.datbase_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datbase_test.entity.User;
import com.example.datbase_test.entity.UserDao;

public class MainActivity extends AppCompatActivity{
    EditText et_name, et_gender, et_age;
    Button btn_add, btn_start;
    String name, gender;
    int age;

    String TAG = "myTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    name = et_name.getText().toString();
                    gender = et_gender.getText().toString();
                    age = Integer.parseInt(et_age.getText().toString());
                    String status = insert(name, gender, age);
                    if (status == null) {
                        Toast.makeText(MainActivity.this, "successfully added", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "enter click");
                Intent intent = new Intent(MainActivity.this, TUGActivity.class);
                // user name have to be there
                name = et_name.getText().toString();
                intent.putExtra("user_name", name);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_gender = findViewById(R.id.et_gender);
        et_age = findViewById(R.id.et_age);
        btn_add = findViewById(R.id.btn_add_user);
        btn_start = findViewById(R.id.btn_start_activity);
    }

//    public void onAddUserClick(View view) {
//        try {
//            name = et_name.getText().toString();
//            gender = et_gender.getText().toString();
//            age = Integer.parseInt(et_age.getText().toString());
//            String status = insert(name, gender, age);
//            if (status == null) {
//                Toast.makeText(this, "successfully added", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
//            }
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }


    private String insert(String name, String gender, int age){
        UserDao userDao = MyApplication.daoSession.getUserDao();
        // check whether user is exited or not
        User unique = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        if (unique == null){
            User user = new User(null, name, gender, age);
            userDao.insert(user);
        }else{
            return "The user is existed!";
        }
        return null;
    }

//    public void start_new_activity(View view) {
//        Log.d(TAG, "enter click");
//        Intent intent = new Intent(this, TUGActivity.class);
//        // user name have to be there
//        name = et_name.getText().toString();
//        intent.putExtra("user_name", name);
//        startActivity(intent);
//    }
}