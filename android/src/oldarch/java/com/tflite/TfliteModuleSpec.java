package com.tflite;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/**
 * Abstract base class for TfliteModule to support both old and new React Native architectures.
 * When new architecture is enabled, this will be replaced by the generated NativeRNTfliteSpec.
 */
abstract class TfliteModuleSpec extends ReactContextBaseJavaModule {
  TfliteModuleSpec(ReactApplicationContext context) {
    super(context);
  }

  public abstract boolean install();
}
