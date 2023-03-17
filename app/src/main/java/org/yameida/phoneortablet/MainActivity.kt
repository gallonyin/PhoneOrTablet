package org.yameida.phoneortablet

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * 登录页
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        Log.e("CheckUtils.isPad()", "" + CheckUtils.isPad());
        Log.e("CheckUtils.isPad()", "" + CheckUtils.isPad(this));
        Log.e("CheckUtils.isPad()", "" + CheckUtils.isTablet(this));

    }
}
