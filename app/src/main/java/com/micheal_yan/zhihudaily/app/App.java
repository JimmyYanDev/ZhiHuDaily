package com.micheal_yan.zhihudaily.app;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public class App extends Application {

    // App实例
    private static App instance;
    // 创建一个Activity集合，来集中管理Activity
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    /**
     * 获取App实例
     * @return App
     */
    public static synchronized App getInstance() {
        return instance;
    }

    /**
     * 向集合中添加Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    /**
     * 从集合中删除Activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (allActivities != null) {
            allActivities.remove(activity);
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity activity : allActivities) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
