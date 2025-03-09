package online.mx.ctrl.flow

import android.annotation.SuppressLint
import android.app.GameManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import online.mx.ctrl.flow.pages.Home
import online.mx.ctrl.flow.ui.theme.CtrlFlowTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidView(factory = { context ->
                object : View(context) {
                    override fun onKeyDown(keyCode: Int, event: android.view.KeyEvent): Boolean {
                        println("onKeyDown $keyCode $event")
                        return true
                    }
                }.apply {
                    isFocusable = true
                    requestFocus()
                }
            }
            ) {
            }
            CtrlFlowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CtrlFlowTheme {
        Home()
    }
}