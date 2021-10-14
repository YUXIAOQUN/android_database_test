package com.example.datbase_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.datbase_test.entity.DaoMaster;
import com.example.datbase_test.entity.TUG;
import com.example.datbase_test.entity.TUGDao;
import com.example.datbase_test.entity.UserDao;

import org.greenrobot.greendao.database.Database;

public class MyGreenDaoDbHelper extends DaoMaster.OpenHelper {
    String TAG = "MyGreenDaoDbHelper";

    public MyGreenDaoDbHelper(Context context, String name) {
        super(context, name);
    }

    public MyGreenDaoDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }


    @Override
    @SuppressWarnings("all")
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
//        LoggUtils.e("MyGreenDaoDbHelper", );
        Log.d(TAG, "----" + oldVersion + "---先前和更新之后的版本---" + newVersion + "----");

        if (oldVersion < newVersion) {
            Log.d(TAG, "进行数据库升级");
            new GreenDaoCompatibleUpdateHelper()
                    .setCallBack(
                            new GreenDaoCompatibleUpdateHelper.GreenDaoCompatibleUpdateCallBack() {

                                @Override
                                public void onFinalSuccess() {
                                    Log.d("MyGreenDaoDbHelper", "进行数据库升级 ===> 成功");
                                }

                                @Override
                                public void onFailedLog(String errorMsg) {
                                    Log.d("MyGreenDaoDbHelper", "升级失败日志 ===> " + errorMsg);
                                }
                            }
                    )
                    .compatibleUpdate(
                            db,
                            UserDao.class, TUGDao.class);
            Log.d("MyGreenDaoDbHelper", "进行数据库升级--完成");
        }
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        // 不要调用父类的，它默认是先删除全部表再创建
        // super.onUpgrade(db, oldVersion, newVersion);
    }
}

