package com.turbovideo

import android.view.View
import android.widget.VideoView
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager

abstract class TurboVideoViewManagerSpec<T : VideoView> : SimpleViewManager<T>() {
  abstract fun setColor(view: T?, value: String?)

  abstract fun setUri(view: T?, value: String)
}
