package com.myscript.nebo.editing;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.penpanel.KeyboardSettings;
import com.myscript.nebo.penpanel.ShowKeyboardOnTapPreference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboKeyboardSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/NeboKeyboardSettings;", "", "<init>", "()V", "showKeyboardOnTapKey", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "showKeyboardOnTapDefaultValue", "", "settings", "Lcom/myscript/nebo/penpanel/KeyboardSettings;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboKeyboardSettings {
    public static final int $stable = 0;
    public static final NeboKeyboardSettings INSTANCE = new NeboKeyboardSettings();

    private NeboKeyboardSettings() {
    }

    @JvmStatic
    public static final String showKeyboardOnTapKey(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        String string = application.getResources().getString(C6079R.string.pref_enable_keyboard_interactions_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    public static final boolean showKeyboardOnTapDefaultValue(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return application.getResources().getBoolean(C6079R.bool.pref_enable_keyboard_interactions_default);
    }

    @JvmStatic
    public static final KeyboardSettings settings(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        return new KeyboardSettings(defaultSharedPreferences, new ShowKeyboardOnTapPreference(showKeyboardOnTapKey(application), showKeyboardOnTapDefaultValue(application)));
    }
}
