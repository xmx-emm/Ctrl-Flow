package online.mx.ctrl.flow.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.github.only52607.compose.window.ComposeFloatingWindow
import online.mx.ctrl.flow.compose.floating.window.floatingWindow


/**
 * https://juejin.cn/post/7169033859894345765
 * 无障碍服务
 */
class CtrlFlowAccessibilityService : AccessibilityService(), LifecycleOwner {
    override val lifecycle: Lifecycle = LifecycleRegistry(this)
    private val tag: String = javaClass.simpleName

    private val floatingWindow by lazy {
        ComposeFloatingWindow(applicationContext).floatingWindow()
    }

    /**
     * 系统成功连接无障碍服务时回调，可在此调用 setServiceInfo() 对服务进行配置调整
     */
    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d(tag, "$tag\tonServiceConnected")
        floatingWindow.show()
    }

    /**
     * 系统将要关闭无障碍服务时回调，可在此进行一些关闭流程，如取消分配的音频管理器
     */
    override fun onUnbind(intent: Intent?): Boolean {

        Log.d(tag, "$tag\tonUnbind")
        floatingWindow.hide()
        return super.onUnbind(intent)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
//        Log.d(tag, "$tag\tonAccessibilityEvent $event")
        rootInActiveWindow?.let {
        }
    }

    override fun onInterrupt() {
        Log.d(tag, "$tag\tonInterrupt")
    }
}
