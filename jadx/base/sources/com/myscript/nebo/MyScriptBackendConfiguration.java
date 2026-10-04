package com.myscript.nebo;

import android.app.Application;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyScriptBackendConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0015\u0010\r\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, m1599d2 = {"usePreprod", "", "Landroid/app/Application;", "getUsePreprod", "(Landroid/app/Application;)Z", "ssoUrl", "", "getSsoUrl", "(Landroid/app/Application;)Ljava/lang/String;", "neboAppUrl", "getNeboAppUrl", "aiUrl", "getAiUrl", "mailServicesUrl", "getMailServicesUrl", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MyScriptBackendConfiguration {
    private static final boolean getUsePreprod(Application application) {
        String string = application.getString(C6079R.string.pref_internal_preprod_sso_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return PreferenceManager.getDefaultSharedPreferences(application).getBoolean(string, application.getResources().getBoolean(C6079R.bool.pref_internal_preprod_sso_default));
    }

    public static final String getSsoUrl(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        String string = application.getString(getUsePreprod(application) ? C6079R.string.sso_url_preprod : C6079R.string.sso_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String getNeboAppUrl(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        String string = application.getString(getUsePreprod(application) ? C6079R.string.nebo_app_url_preprod : C6079R.string.nebo_app_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String getAiUrl(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        String string = application.getString(getUsePreprod(application) ? C6079R.string.nebo_ai_url_preprod : C6079R.string.nebo_ai_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String getMailServicesUrl(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        String string = application.getString(getUsePreprod(application) ? C6079R.string.mail_services_url_preprod : C6079R.string.mail_services_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
