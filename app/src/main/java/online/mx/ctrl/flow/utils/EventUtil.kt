package online.mx.ctrl.flow.utils

import android.util.Log

internal interface IInputEventReceiver {
    fun onInputEvent(keycode: Int, action: Int, pid: Int, uid: Int)
}


class Stub : IInputEventReceiver {

    override fun onInputEvent(keycode: Int, action: Int, pid: Int, uid: Int) {
        Log.d("ln28", "keycode:$keycode, action:$action, pid:$pid, uid:$uid")
    }

}

