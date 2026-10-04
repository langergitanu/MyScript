package com.myscript.nebo.utils;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.network.PrefSaver;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferencesSaver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/utils/SharedPreferencesSaver;", "Lcom/myscript/nebo/network/PrefSaver;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/app/Application;Landroid/content/SharedPreferences;)V", "saveBoolean", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "", "getBoolean", "defaultValue", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharedPreferencesSaver implements PrefSaver {
    public static final int $stable = 8;
    private final Application application;
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesSaver(Application application, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.application = application;
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.myscript.nebo.network.PrefSaver
    public void saveBoolean(int key, boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(this.application.getString(key), value);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.network.PrefSaver
    public boolean getBoolean(int key, int defaultValue) {
        return this.sharedPreferences.getBoolean(this.application.getString(key), this.application.getResources().getBoolean(defaultValue));
    }
}
