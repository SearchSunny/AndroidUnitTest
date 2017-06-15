package com.androidunittest.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

public class ReadContantsEngine {

    public static void getAppsToJson(Context context) {
        try {
            //获取到assets文件下的apps.json文件的数据，并以输出流形式返回。
            InputStreamReader isr = new InputStreamReader(context.getAssets().open("apps.json"), "utf-8");
            //从assets获取json文件
            BufferedReader bfr = new BufferedReader(isr);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bfr.readLine()) != null) {
                stringBuilder.append(line);
            }
            bfr.close();
            isr.close();
            try {
                Log.d("MV",stringBuilder.toString());
                JSONObject object = new JSONObject(stringBuilder.toString());
                JSONArray jsonApps = object.getJSONArray("apps");
                for (int i = 0; i < jsonApps.length(); i++) {
                    JSONObject jsonObject = jsonApps.getJSONObject(i);
                    String name = (String) jsonObject.get("name");
                    int versionCode = (int) jsonObject.get("versionCode");
                    String versionName = (String) jsonObject.get("versionName");
                    String packageName = (String) jsonObject.get("packageName");
                    boolean isInstalled = (boolean) jsonObject.get("isInstalled");
                    String pgyerUrl = (String) jsonObject.get("pgyerUrl");
                    String appIcon = (String) jsonObject.get("appIcon");
                    String buildName = (String) jsonObject.get("buildName");
                    String buildEnvironment = (String) jsonObject.get("buildEnvironment");
                    String buildBranch = (String) jsonObject.get("buildBranch");

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
