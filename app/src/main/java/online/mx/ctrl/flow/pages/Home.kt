package online.mx.ctrl.flow.pages

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import online.mx.ctrl.flow.utils.openAccessibilityActivity


@Composable
fun Home(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        println("rememberLauncherForActivityResult\t$it")
    }
    Column(modifier = modifier) {
        Button(onClick = { context.openAccessibilityActivity() }) {
            Text("打开无障碍页面")
        }
        Button(onClick = { context.openApplicationDetailsSettingsActivity(launcher) }) {
            Text("打开权限页面")
        }
        (2..10).forEach {
            Button(onClick = {}) {
                Text("$it")
            }
        }
    }
}

fun Context.openApplicationDetailsSettingsActivity(launcher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
    try {
        val localIntent = Intent("miui.intent.action.APP_PERM_EDITOR");
        localIntent.setClassName(
            "com.miui.securitycenter",
            "com.miui.permcenter.permissions.AppPermissionsEditorActivity"
        )
        localIntent.putExtra("extra_pkgname", packageName)
        launcher.launch(localIntent)
    } catch (e: ActivityNotFoundException) {
        val intent1 = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent1.setData(uri)
        launcher.launch(intent1)
    }
}