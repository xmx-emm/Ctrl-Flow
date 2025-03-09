package online.mx.ctrl.flow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import online.mx.ctrl.flow.pages.Home
import online.mx.ctrl.flow.ui.theme.CtrlFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CtrlFlowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @SuppressLint("RestrictedApi")
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        println("KeyEvent $event")
        if (event.getKeyCode() === KeyEvent.KEYCODE_BUTTON_A) {
            // 拦截手柄A键事件
            return true // 返回true表示消费事件
        }
        return super.dispatchKeyEvent(event)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CtrlFlowTheme {
        Home()
    }
}