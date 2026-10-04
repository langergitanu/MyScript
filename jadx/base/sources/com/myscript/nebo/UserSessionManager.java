package com.myscript.nebo;

import android.content.SharedPreferences;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UserSessionManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0007R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/UserSessionManager;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "<set-?>", "", "sessionCount", "getSessionCount", "()I", "setSessionCount", "(I)V", "sessionCount$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "forceSessionCount", "", "value", "Provider", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserSessionManager {
    private static final String SESSION_COUNT_KEY = "SESSION_COUNT_KEY";

    /* JADX INFO: renamed from: sessionCount$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty sessionCount;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(UserSessionManager.class, "sessionCount", "getSessionCount()I", 0)};
    public static final int $stable = IntSharedPreferencesProperty.$stable;

    /* JADX INFO: compiled from: UserSessionManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/UserSessionManager$Provider;", "", "provideUserSessionManager", "Lcom/myscript/nebo/UserSessionManager;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        UserSessionManager provideUserSessionManager();
    }

    public UserSessionManager(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sessionCount = SharedPreferencesExtKt.intPref(sharedPreferences, SESSION_COUNT_KEY, 0);
        setSessionCount(getSessionCount() + 1);
        getSessionCount();
    }

    private final void setSessionCount(int i) {
        this.sessionCount.setValue(this, $$delegatedProperties[0], i);
    }

    public final int getSessionCount() {
        return this.sessionCount.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    public final void forceSessionCount(int value) {
        setSessionCount(value);
    }
}
