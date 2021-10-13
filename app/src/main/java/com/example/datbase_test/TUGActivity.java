package com.example.datbase_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datbase_test.entity.TUG;
import com.example.datbase_test.entity.TUGDao;
import com.example.datbase_test.entity.User;
import com.example.datbase_test.entity.UserDao;

import java.util.List;

public class TUGActivity extends AppCompatActivity implements View.OnClickListener {
    Button save;
    EditText et_tug_time;
    float tug_time;
    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugactivity);
        et_tug_time = findViewById(R.id.et_tug_time);
        save = findViewById(R.id.tug_time);
        save.setOnClickListener(this);

        // get the user name from the last activity
        Intent intent = getIntent();
        user_name = intent.getStringExtra("user_name");
    }

    // save features
    @Override
    public void onClick(View view) {
        tug_time = Float.parseFloat(et_tug_time.getText().toString());
        User user = queryUserbyName(user_name);
        TUG tug = new TUG(null, tug_time, user.getId());
        TUGDao tugDao = MyApplication.daoSession.getTUGDao();
        tugDao.insert(tug);
        Toast.makeText(this, "insert tug successfully", Toast.LENGTH_SHORT).show();


    }

    public User queryUserbyName(String name){
        UserDao userDao = MyApplication.daoSession.getUserDao();
        List<User> listData = null;
        User user = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        if (user != null)
        {
            return user;
        }
        return null;
    }
}