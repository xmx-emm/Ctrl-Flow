package online.mx.ctrl.flow.utils

import android.content.Context
import android.content.Intent
import android.provider.Settings


/**
 * 打开无障碍模式设置
 */
fun Context.openAccessibilitySettings() {
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(intent)
}