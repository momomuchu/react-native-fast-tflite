package com.tflite;

import com.facebook.react.bridge.ReactApplicationContext;

/**
 * Abstract base class for TfliteModule to support new React Native architecture.
 * This extends the generated NativeRNTfliteSpec which is a TurboModule.
 */
abstract class TfliteModuleSpec extends NativeRNTfliteSpec {
  TfliteModuleSpec(ReactApplicationContext context) {
    super(context);
  }
}
