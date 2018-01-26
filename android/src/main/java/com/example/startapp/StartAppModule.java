package com.example.startapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.packageNames;

public class StartAppModule extends ReactContextBaseJavaModule {

    public StartAppModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public boolean canOverrideExistingModule() {
        return true;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public String getName() {
        return "StartApp";
    }

    @ReactMethod
    public void checkAppExist(String packageName,Promise promise){
        promise.resolve(isAvilible(packageName));
    }

    public boolean isAvilible(String packageName){
        if (TextUtils.isEmpty(packageName))
            return false;
        final PackageManager packageManager = getReactApplicationContext().getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        List<String> packageNames = new ArrayList<String>();
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        return packageNames.contains(packageName);
    }

    @ReactMethod
    public void startApp(String packageName) {
        if (!isAvilible(packageName)) {
            return;
        }
        Intent intent = getReactApplicationContext().getPackageManager().getLaunchIntentForPackage(packageName);
        getCurrentActivity().startActivity(intent);
    }
}
