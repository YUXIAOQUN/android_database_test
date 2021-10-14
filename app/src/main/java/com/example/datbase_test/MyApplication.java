package com.example.datbase_test;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.datbase_test.entity.DaoMaster;
import com.example.datbase_test.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

public class MyApplication extends Application {
    public static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        // 1. create/connect database
//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "test.db");
//        MySQLiteOpenHelper devOpenHelper = new MySQLiteOpenHelper(this, "test.db", null);
        MyGreenDaoDbHelper helper = new MyGreenDaoDbHelper(this, "test.db", null);

        // 2. get the sql database
//        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
//        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        SQLiteDatabase db = helper.getWritableDatabase();



        // 3. create daoMaster through SQLiteDatabase
        DaoMaster daoMaster = new DaoMaster(db);


        // 4. get the daoSession
        daoSession = daoMaster.newSession();

    }

}
