package com.myscript.nebo.penpanel;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/KeyboardSettings;", "", "preferences", "Landroid/content/SharedPreferences;", "showKeyboardOnTapPreference", "Lcom/myscript/nebo/penpanel/ShowKeyboardOnTapPreference;", "<init>", "(Landroid/content/SharedPreferences;Lcom/myscript/nebo/penpanel/ShowKeyboardOnTapPreference;)V", "enabled", "", "showKeyboardOnTap", "getShowKeyboardOnTap", "()Z", "setShowKeyboardOnTap", "(Z)V", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class KeyboardSettings {
    private final SharedPreferences preferences;
    private final ShowKeyboardOnTapPreference showKeyboardOnTapPreference;

    public KeyboardSettings(SharedPreferences preferences, ShowKeyboardOnTapPreference showKeyboardOnTapPreference) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(showKeyboardOnTapPreference, "showKeyboardOnTapPreference");
        this.preferences = preferences;
        this.showKeyboardOnTapPreference = showKeyboardOnTapPreference;
    }

    public final boolean getShowKeyboardOnTap() {
        return this.preferences.getBoolean(this.showKeyboardOnTapPreference.getKey(), this.showKeyboardOnTapPreference.getDefaultValue());
    }

    public final void setShowKeyboardOnTap(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putBoolean(this.showKeyboardOnTapPreference.getKey(), z);
        editorEdit.apply();
    }
}
