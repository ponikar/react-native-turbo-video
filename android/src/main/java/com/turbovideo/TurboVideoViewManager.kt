package com.turbovideo

import android.graphics.Color
import android.net.Uri
import android.view.ViewGroup
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import android.widget.*
import android.widget.LinearLayout.LayoutParams
import com.facebook.react.bridge.Promise
import com.facebook.react.uimanager.annotations.ReactProp
import java.net.URL

@ReactModule(name = TurboVideoViewManager.NAME)
class TurboVideoViewManager :
  TurboVideoViewManagerSpec<VideoView>() {
  override fun getName(): String {
    return NAME
  }


  private lateinit var mediaConroller: MediaController;

  public override fun createViewInstance(context: ThemedReactContext): VideoView {

    var video = VideoView(context)

    mediaConroller = MediaController(context);
    video.setMediaController(mediaConroller);

    val layoutParams = LinearLayout.LayoutParams(400, 200)
    layoutParams.setMargins(10, 10, 10, 10)
    video.layoutParams = layoutParams

    return video
  }

  @ReactProp(name = "uri")
  override fun setUri(view: VideoView?, value: String?) {
     var nativeUri = Uri.parse(value)
     view?.setVideoURI(nativeUri)
  }

  fun setHideController(view: VideoView?, flag: Boolean?) {
      if(flag == true) {
        mediaConroller.hide();
      } else if(flag === false) {
        mediaConroller.show();
      }
  }

  fun setDuration(view: VideoView?, callback: Promise) {
     callback.promise()
  }

  fun getVideoLength(view: VideoView?, callback: Promise) {
      callback.resolve(view?.duration)
  }

  @ReactProp(name = "width")
  fun setWidth(view: VideoView?, value: String?) {

  }


  companion object {
    const val NAME = "TurboVideoView"
  }
}
