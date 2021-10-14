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

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Date;
import java.util.List;

public class TUGActivity extends AppCompatActivity implements View.OnClickListener {
    Button save, show;
    EditText et_tug_time;
    float tug_time;
    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugactivity);
        et_tug_time = findViewById(R.id.et_tug_time);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        save.setOnClickListener(this);
        show.setOnClickListener(this);

        // get the user name from the last activity
        Intent intent = getIntent();
        user_name = intent.getStringExtra("user_name");
    }

    // save features
    @Override
    public void onClick(View view) {
        TUGDao tugDao = MyApplication.daoSession.getTUGDao();
        User user = queryUserbyName(user_name);
        switch (view.getId()){
            case R.id.save:
                tug_time = Float.parseFloat(et_tug_time.getText().toString());
                Date date = new Date();
                long finish_datetime = date.getTime();

                TUG tug = new TUG(null, tug_time, 1.2f, 1.5f, 2.0f,  finish_datetime,user.getId());
                tugDao.insert(tug);
                Toast.makeText(this, "insert tug successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.show:
                // get the most recent performance
                List<TUG> list = tugDao.queryBuilder().where(TUGDao.Properties.UserId.eq(user.getId())).
                        limit(1).orderDesc(TUGDao.Properties.Id).list();
//                Toast.makeText(this, "most recent record is " + list.get(0).getTime(),
//                        Toast.LENGTH_SHORT).show();
                // show the time in readable time format
                String readable_time = MyTimeUtils.getYearMonthDayHourMinuteSecond(list.get(0).getFinish_date_time());
                Toast.makeText(this, "TUG time is " + readable_time, Toast.LENGTH_SHORT).show();
                break;

        }


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