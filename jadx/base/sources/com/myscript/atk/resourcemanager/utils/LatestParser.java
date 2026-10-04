package com.myscript.atk.resourcemanager.utils;

import android.util.Log;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LatestParser extends Parser<Latest> {
    private static final String TAG = "LatestParser";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.resourcemanager.utils.Parser
    public Latest parse(String str) {
        Latest latest = new Latest();
        try {
            JSONObject jSONObject = new JSONObject(str);
            latest.setVersion(new Version(jSONObject.optString("version").toString()));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("folders");
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                String string = jSONObject2.optString("name").toString();
                String string2 = jSONObject2.optString("md5").toString();
                if (string.contains(File.separator)) {
                    Log.e(TAG, "!!!!! Invalid contents on latest info content: " + string);
                } else {
                    latest.addLanguageHash(string, string2);
                }
            }
            return latest;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return latest;
        }
    }
}
