package com.example.datbase_test;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.datbase_test.entity.DaoMaster;
import com.example.datbase_test.entity.DaoSession;

public class MyApplication extends Application {
    public static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        // 1. create/connect database
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "test.db");
        // 2. get the sql database
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        // 3. create daoMaster througn SQLiteDatabase
        DaoMaster daoMaster = new DaoMaster(db);
        // 4. get the daoSession
        daoSession = daoMaster.newSession();

    }
}
