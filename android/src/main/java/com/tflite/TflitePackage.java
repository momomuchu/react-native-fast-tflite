package com.tflite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TflitePackage extends TurboReactPackage {

  @Nullable
  @Override
  public NativeModule getModule(@NonNull String name, @NonNull ReactApplicationContext reactContext) {
    if (name.equals(TfliteModule.NAME)) {
      return new TfliteModule(reactContext);
    } else {
      return null;
    }
  }

  @Override
  public ReactModuleInfoProvider getReactModuleInfoProvider() {
    return () -> {
      final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
      // BuildConfig.IS_NEW_ARCHITECTURE_ENABLED is set by build.gradle when compiling
      boolean isTurboModule;
      try {
        isTurboModule = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
      } catch (NoSuchFieldError | IllegalAccessError e) {
        // Fallback to false if BuildConfig field is not available
        isTurboModule = false;
      }
      moduleInfos.put(
        TfliteModule.NAME,
        new ReactModuleInfo(
          TfliteModule.NAME,
          TfliteModule.NAME,
          false, // canOverrideExistingModule
          false, // needsEagerInit
          true, // hasConstants
          false, // isCxxModule
          isTurboModule // isTurboModule
        )
      );
      return moduleInfos;
    };
  }

  @NonNull
  @Override
  public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
    return Collections.emptyList();
  }
}
