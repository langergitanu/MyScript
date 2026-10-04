package com.myscript.atk.resourcemanager.utils;

import android.net.Uri;
import android.util.Log;
import com.myscript.atk.resourcemanager.internal.Constants;
import com.myscript.atk.resourcemanager.internal.bean.FileInfo;
import com.myscript.atk.resourcemanager.internal.bean.FilesParserResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FilesParser extends Parser<FilesParserResult> {
    private static final String TAG = "FilesParser";
    private final Uri mBaseUri;

    public FilesParser(Uri uri) {
        this.mBaseUri = uri;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.resourcemanager.utils.Parser
    public FilesParserResult parse(String str) {
        FilesParserResult filesParserResult = new FilesParserResult();
        ArrayList arrayList = new ArrayList();
        filesParserResult.setFilesInfo(arrayList);
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("files");
            int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("relativePath");
                FileInfo fileInfo = new FileInfo(strOptString, jSONObject.optString("md5"), Integer.parseInt(jSONObject.optString("size")), this.mBaseUri.buildUpon().appendEncodedPath(strOptString).build());
                if (strOptString.endsWith(Constants.CONF_FILENAME_EXT)) {
                    filesParserResult.setConfInfo(fileInfo);
                } else {
                    arrayList.add(fileInfo);
                }
            }
            return filesParserResult;
        } catch (JSONException e) {
            Log.e(TAG, "JSON error", e);
            return filesParserResult;
        }
    }
}
