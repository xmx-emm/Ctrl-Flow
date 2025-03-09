package online.mx.ctrl.flow.compose.floating.window

import android.content.Context.INPUT_SERVICE
import android.hardware.input.InputManager
import android.hardware.input.InputManager.InputDeviceListener
import android.util.Log
import android.view.InputDevice
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.github.only52607.compose.window.ComposeFloatingWindow


fun ComposeFloatingWindow.floatingWindow(): ComposeFloatingWindow {
    val view = decorView as View
    view.setOnKeyListener { v, keyCode, event ->
        println("floatingWindow $v $keyCode $event")
        true
    }
    setContent {
        Column(
            modifier = Modifier
        ) {
            Text("A")
            Text("B")
        }
        val inputManager = context.getSystemService(INPUT_SERVICE) as InputManager?
        inputManager!!.registerInputDeviceListener(object : InputDeviceListener {
            override fun onInputDeviceAdded(deviceId: Int) {
                val device = InputDevice.getDevice(deviceId)
                println(device)
            }

            override fun onInputDeviceRemoved(deviceId: Int) {
                Log.d("Gamepad", "手柄已断开")
            }

            override fun onInputDeviceChanged(deviceId: Int) {
                println("onInputDeviceChanged $deviceId")
            }
        }, null)

    }
    return this
}
