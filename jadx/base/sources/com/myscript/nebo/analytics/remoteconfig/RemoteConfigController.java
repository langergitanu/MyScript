package com.myscript.nebo.analytics.remoteconfig;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteConfigController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u000bH\u0016¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfigController;", "Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig;", "<init>", "()V", "instantiate", "", "getString", "", SubscriberAttributeKt.JSON_NAME_KEY, "default", "getBoolean", "", "Companion", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RemoteConfigController implements RemoteConfig {
    private static final Companion Companion = new Companion(null);
    private static final long MINIMUM_FETCH_INTERVAL_SECONDS = 43200;

    @Deprecated
    public static final String TAG = "RemoteConfigController";

    public final void instantiate() {
        FirebaseRemoteConfig remoteConfig = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
        remoteConfig.setConfigSettingsAsync(RemoteConfigKt.remoteConfigSettings(new Function1() { // from class: com.myscript.nebo.analytics.remoteconfig.RemoteConfigController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteConfigController.instantiate$lambda$0((FirebaseRemoteConfigSettings.Builder) obj);
            }
        }));
        remoteConfig.setDefaultsAsync(Experiment.INSTANCE.getDefaults());
        remoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener() { // from class: com.myscript.nebo.analytics.remoteconfig.RemoteConfigController$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit instantiate$lambda$0(FirebaseRemoteConfigSettings.Builder remoteConfigSettings) {
        Intrinsics.checkNotNullParameter(remoteConfigSettings, "$this$remoteConfigSettings");
        remoteConfigSettings.setMinimumFetchIntervalInSeconds(MINIMUM_FETCH_INTERVAL_SECONDS);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.analytics.remoteconfig.RemoteConfig
    public String getString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        FirebaseRemoteConfigValue value = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE).getValue(key);
        if (value.getSource() == 0) {
            return str;
        }
        String strAsString = value.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    @Override // com.myscript.nebo.analytics.remoteconfig.RemoteConfig
    public boolean getBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseRemoteConfigValue value = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE).getValue(key);
        return value.getSource() == 0 ? z : value.asBoolean();
    }

    /* JADX INFO: compiled from: RemoteConfigController.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfigController$Companion;", "", "<init>", "()V", "TAG", "", "MINIMUM_FETCH_INTERVAL_SECONDS", "", "getMINIMUM_FETCH_INTERVAL_SECONDS", "()J", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getMINIMUM_FETCH_INTERVAL_SECONDS() {
            return RemoteConfigController.MINIMUM_FETCH_INTERVAL_SECONDS;
        }
    }
}
