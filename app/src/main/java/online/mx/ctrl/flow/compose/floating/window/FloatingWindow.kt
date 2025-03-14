package online.mx.ctrl.flow.compose.floating.window

import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.github.only52607.compose.window.ComposeFloatingWindow
import com.github.only52607.compose.window.LocalFloatingWindow


fun ComposeFloatingWindow.floatingWindow(): ComposeFloatingWindow {
    setContentView(ComposeView(context).apply {
        setViewTreeLifecycleOwner(this@floatingWindow)
        setViewTreeViewModelStoreOwner(this@floatingWindow)
        setViewTreeSavedStateRegistryOwner(this@floatingWindow)
        setContent {
            CompositionLocalProvider(
                LocalFloatingWindow provides this@floatingWindow
            ) {
                setContent {
                    Column(
                        modifier = Modifier
                    ) {
                        Text("A")
                        Text("B")
                    }
                }
            }
        }
    }
    )
    return this
}
