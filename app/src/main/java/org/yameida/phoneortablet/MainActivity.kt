package org.yameida.phoneortablet

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ScreenUtils
import kotlinx.android.synthetic.main.activity_main.*

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

        val m1 = CheckUtils.isPad()
        val m2 = CheckUtils.isPad(this)
        val m3 = CheckUtils.isTablet(this)
        var flag = 0
        if (m1) flag++
        if (m2) flag++
        if (m3) flag++
        tv_params.text = "屏幕参数: 宽" + ScreenUtils.getScreenWidth() + " 高" + ScreenUtils.getScreenHeight() +
                "\n\t" + "dpi" + ScreenUtils.getScreenDensityDpi() + " 屏幕:" + String.format("%.2f", CheckUtils.screenSize(this))
        tv_method1.text = "ro.build.characteristics:$m1"
        tv_method2.text = "屏幕尺寸大于7寸:$m2"
        tv_method3.text = "Google推荐的方法:$m3"
        tv_comment.text = "结论:" + (if (flag >= 2) "设备满足两项平板标准" else "设备疑似非平板设备")

        Log.e("CheckUtils.isPad()", "" + CheckUtils.isPad())
        Log.e("CheckUtils.isPad()", "" + CheckUtils.isPad(this))
        Log.e("CheckUtils.isPad()", "" + CheckUtils.isTablet(this))

    }
}
