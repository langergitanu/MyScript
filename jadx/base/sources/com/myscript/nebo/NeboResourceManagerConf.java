package com.myscript.nebo;

import android.app.Application;
import android.content.SharedPreferences;
import android.webkit.URLUtil;
import androidx.preference.PreferenceManager;
import com.myscript.atk.resourcemanager.ResourceManagerConf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboResourceManagerConf.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"neboResourceManagerConf", "Lcom/myscript/atk/resourcemanager/ResourceManagerConf;", "Landroid/app/Application;", "getNeboResourceManagerConf", "(Landroid/app/Application;)Lcom/myscript/atk/resourcemanager/ResourceManagerConf;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboResourceManagerConf {
    public static final ResourceManagerConf getNeboResourceManagerConf(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        String string = application.getResources().getString(C6079R.string.rm_config_repo_remote_uri);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
            String string2 = application.getResources().getString(C6079R.string.pref_internal_rm_url_key);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = defaultSharedPreferences.getString(string2, string);
            if (string3 == null || !URLUtil.isNetworkUrl(string3)) {
                Intrinsics.checkNotNull(defaultSharedPreferences);
                SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
                editorEdit.putString(string2, string);
                editorEdit.apply();
            } else {
                string = string3;
            }
        } catch (Exception unused) {
        }
        String string4 = application.getResources().getString(C6079R.string.rm_config_repo_name);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = application.getResources().getString(C6079R.string.rm_config_repo_assetfolder_path);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = application.getResources().getString(C6079R.string.rm_config_repo_localfolder_name);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        return new ResourceManagerConf(string4, string5, string6, string);
    }
}
