package com.myscript.nebo.onboarding;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnboardingUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {OnboardingUtilsKt.APPLICATION_ONBOARDING_NEEDED_AT_STARTUP, "", "ONBOARDING_PREFERENCES_NAME", "isOnBoardingNeededAtStartup", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "setOnBoardingNeededAtStartup", "", "needed", "onboarding_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OnboardingUtilsKt {
    private static final String APPLICATION_ONBOARDING_NEEDED_AT_STARTUP = "APPLICATION_ONBOARDING_NEEDED_AT_STARTUP";
    private static final String ONBOARDING_PREFERENCES_NAME = "OnboardingUtilsSharedPreferences";

    public static final boolean isOnBoardingNeededAtStartup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(ONBOARDING_PREFERENCES_NAME, 0).getBoolean(APPLICATION_ONBOARDING_NEEDED_AT_STARTUP, true);
    }

    public static final void setOnBoardingNeededAtStartup(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(ONBOARDING_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(APPLICATION_ONBOARDING_NEEDED_AT_STARTUP, z);
        editorEdit.apply();
    }
}
