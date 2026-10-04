package com.survicate.surveys.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.core.providers.LocaleProvider;
import com.survicate.surveys.infrastructure.storage.interfaces.LocaleStore;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLocaleProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/helpers/AndroidLocaleProvider;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/LocaleStore;", "Lcom/survicate/surveys/core/providers/LocaleProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appLanguage", "", "getAppLanguage", "()Ljava/lang/String;", "deviceLanguage", "getDeviceLanguage", "currentLocale", "getCurrentLocale", "localeObservable", "Lcom/survicate/surveys/helpers/BehaviourObservable;", "deviceLocale", "getDeviceLocale", "sdkLocale", "observeLocale", "Lcom/survicate/surveys/helpers/Observable;", "saveLocale", "", "languageTag", "reset", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidLocaleProvider implements LocaleStore, LocaleProvider {
    private final BehaviourObservable<String> localeObservable;
    private String sdkLocale;

    public AndroidLocaleProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BehaviourObservable<String> behaviourObservable = new BehaviourObservable<>();
        this.localeObservable = behaviourObservable;
        behaviourObservable.notifyObservers(getCurrentLocale());
        context.registerReceiver(new BroadcastReceiver() { // from class: com.survicate.surveys.helpers.AndroidLocaleProvider.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (AndroidLocaleProvider.this.sdkLocale == null) {
                    AndroidLocaleProvider.this.localeObservable.notifyObservers(AndroidLocaleProvider.this.getDeviceLocale());
                }
            }
        }, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    @Override // com.survicate.surveys.core.providers.LocaleProvider
    public String getAppLanguage() {
        return getCurrentLocale();
    }

    @Override // com.survicate.surveys.core.providers.LocaleProvider
    public String getDeviceLanguage() {
        return getCurrentLocale();
    }

    private final String getCurrentLocale() {
        String str = this.sdkLocale;
        return str == null ? getDeviceLocale() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDeviceLocale() {
        String languageTag = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return languageTag;
    }

    public final Observable<String> observeLocale() {
        return this.localeObservable;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.LocaleStore
    public void saveLocale(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        this.sdkLocale = languageTag;
        this.localeObservable.notifyObservers(languageTag);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.LocaleStore
    public void reset() {
        this.sdkLocale = null;
        this.localeObservable.notifyObservers(getCurrentLocale());
    }
}
