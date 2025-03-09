package online.mx.ctrl.flow.utils

import android.content.Context
import android.content.Intent
import android.provider.Settings


/**
 * 打开无障碍模式设置
 */
fun Context.openAccessibilityActivity() {
    try {
        if (!openAccessibilityManager()) {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    } catch (e: Exception) {
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        e.printStackTrace()
    }
}

fun Context.openAccessibilityManager(): Boolean {
    try {
        val p = "com.accessibilitymanager"
        val intent = Intent().apply {
            setPackage(p)
            setClassName(p, "com.accessibilitymanager.MainActivity")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            return true
        }//未安装包管理器
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return false
}