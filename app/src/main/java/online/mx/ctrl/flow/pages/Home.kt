package online.mx.ctrl.flow.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import online.mx.ctrl.flow.utils.openAccessibilitySettings


@Composable
fun Home(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Button(onClick = { context.openAccessibilitySettings() }) {
            Text("打开无障碍页面")
        }
        (2..10).forEach {
            Button(onClick = {}) {
                Text("$it")
            }
        }
    }
}
