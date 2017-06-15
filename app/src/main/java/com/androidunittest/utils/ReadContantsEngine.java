package com.androidunittest.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
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

    //读取手机联系人
    public static void readContants(Context context) {
        Log.d("MV","调用读取手机联系人方法readContants()");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        Uri uridatas = Uri.parse("content://com.android.contacts/data");

        Cursor cursor = contentResolver.query(uri, new String[]{"_id"}, null, null, null);
        //循环取出数据
        while (cursor.moveToNext()){
            System.out.println(cursor.getString(0));

            String id = cursor.getString(0);//获取到联系人的id

            Cursor cursor1 = contentResolver.query(uridatas, new String[]{"data1", "mimetype"}, "raw_contact_id = ?", new String[]{id}, null);
            while (cursor1.moveToNext()){
                String data = cursor1.getString(0);
                String mimetype = cursor1.getString(1);
                if (mimetype.equals("vnd.android.cursor.item/name")){
                    Log.d("MV","第"+id+"个用户 名字:"+data);
                } else if (mimetype.equals("vnd.android.cursor.item/phone_v2")){
                    Log.d("MV","第"+id+"个用户 电话:"+data);
                }
            }
            cursor1.close();
        }
        cursor.close();
    }

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
