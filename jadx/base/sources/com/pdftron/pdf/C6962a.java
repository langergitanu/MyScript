package com.pdftron.pdf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.pdftron.pdf.a */
/* JADX INFO: loaded from: classes7.dex */
final class C6962a implements JavaScriptEventProc {

    /* JADX INFO: renamed from: a */
    private Context f2102a;

    C6962a(Context context) {
        this.f2102a = context;
    }

    @Override // com.pdftron.pdf.JavaScriptEventProc
    public final void handleEvent(String str, String str2, Object obj) {
        String string;
        String str3 = "JavaScript Alert: ";
        try {
            JSONObject jSONObject = new JSONObject(str2);
            string = jSONObject.getString("cMsg");
            if (!jSONObject.isNull("cTitle")) {
                str3 = "JavaScript Alert: " + jSONObject.getString("cTitle");
            }
        } catch (JSONException unused) {
            string = "fail to get JavaScript Message";
        }
        new AlertDialog.Builder(this.f2102a).setTitle(str3).setMessage(Html.fromHtml(string)).setPositiveButton("OK", new DialogInterface.OnClickListener(this) { // from class: com.pdftron.pdf.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }
}
