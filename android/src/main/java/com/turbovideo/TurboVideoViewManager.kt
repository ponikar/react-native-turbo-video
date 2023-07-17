package com.turbovideo

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = TurboVideoViewManager.NAME)
class TurboVideoViewManager :
  TurboVideoViewManagerSpec<TurboVideoView>() {
  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): TurboVideoView {
    return TurboVideoView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: TurboVideoView?, color: String?) {
    view?.setBackgroundColor(Color.parseColor(color))
  }

  companion object {
    const val NAME = "TurboVideoView"
  }
}
