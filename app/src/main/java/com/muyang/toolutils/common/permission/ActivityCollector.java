package com.muyang.toolutils.common.permission;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limuyang on 2016/12/29.
 * Activity管理类
 */

public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static Activity getTopActivity() {
        if (activities.isEmpty()) {
            return null;
        } else {
            return activities.get(activities.size() - 1);
        }
    }
}
