package org.yameida.phoneortablet;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class CheckUtils {

    private static final String TAG = "CheckUtils";

    /**
     * 判断是否为平板
     */
    public static boolean isPad() {
        boolean result = false;
        String mDeviceType = SysProp.get("ro.build.characteristics", "default");
        if (mDeviceType != null && mDeviceType.equalsIgnoreCase("tablet")) {
            result = true;
        }
        Log.d(TAG, "isPad:" + result);
        return result;
    }

    /**
     * 判断是否为平板
     */
    public static boolean isPad(Context context) {
        boolean result = false;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
        // 屏幕尺寸
        double screenInches = Math.sqrt(x + y);
        // 大于7尺寸则为Pad
        if (screenInches >= 7.0) {
            result = true;
        }
        Log.d(TAG, "screenInches:" + screenInches);
        Log.d(TAG, "isPad:" + result);
        return result;
    }

    /**
     * 判断是否为平板
     */
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * 判断屏幕尺寸
     */
    public static double screenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
        // 屏幕尺寸
        return Math.sqrt(x + y);
    }

}
