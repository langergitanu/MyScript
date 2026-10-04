package com.myscript.nebo.discoverability.session;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u001e\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bR+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/discoverability/session/SessionManager;", "Lcom/myscript/nebo/discoverability/session/ISessionManager;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "<set-?>", "", "serializedSessionCount", "getSerializedSessionCount", "()I", "setSerializedSessionCount", "(I)V", "serializedSessionCount$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "_sessionCountFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "sessionCountFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSessionCountFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getSessionCount", "incrementSessionCount", "", "clearSessionCount", "registerSessionListener", WebViewMessageType.CONTEXT, "Landroid/app/Application;", "unregisterSessionListener", "activityLifecycleCallbacks", "com/myscript/nebo/discoverability/session/SessionManager$activityLifecycleCallbacks$1", "Lcom/myscript/nebo/discoverability/session/SessionManager$activityLifecycleCallbacks$1;", "Provider", "Companion", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SessionManager implements ISessionManager {
    private static final String SESSION_MANAGER_COUNT_KEY = "SESSION_MANAGER_COUNT_KEY";
    private final MutableStateFlow<Integer> _sessionCountFlow;
    private final SessionManager$activityLifecycleCallbacks$1 activityLifecycleCallbacks;

    /* JADX INFO: renamed from: serializedSessionCount$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty serializedSessionCount;
    private final StateFlow<Integer> sessionCountFlow;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(SessionManager.class, "serializedSessionCount", "getSerializedSessionCount()I", 0)};
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/session/SessionManager$Provider;", "", "provideDiscoverySessionManager", "Lcom/myscript/nebo/discoverability/session/SessionManager;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        SessionManager provideDiscoverySessionManager();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.myscript.nebo.discoverability.session.SessionManager$activityLifecycleCallbacks$1] */
    public SessionManager(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.serializedSessionCount = SharedPreferencesExtKt.intPref(sharedPreferences, SESSION_MANAGER_COUNT_KEY, 0);
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(Integer.valueOf(getSerializedSessionCount()));
        this._sessionCountFlow = MutableStateFlow;
        this.sessionCountFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.myscript.nebo.discoverability.session.SessionManager$activityLifecycleCallbacks$1
            private long currentPauseTimestamp;
            private long currentResumeTimestamp;
            private final int maxPauseDuration = 1800000;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity p0, Bundle p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                long j = this.currentResumeTimestamp;
                if (j == 0) {
                    this.this$0.incrementSessionCount();
                } else {
                    long j2 = this.currentPauseTimestamp;
                    if (j2 > j && j2 - j > this.maxPauseDuration) {
                        this.this$0.incrementSessionCount();
                    }
                }
                this.currentResumeTimestamp = System.currentTimeMillis();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                this.currentPauseTimestamp = System.currentTimeMillis();
            }
        };
    }

    private final int getSerializedSessionCount() {
        return this.serializedSessionCount.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    private final void setSerializedSessionCount(int i) {
        this.serializedSessionCount.setValue(this, $$delegatedProperties[0], i);
    }

    public final StateFlow<Integer> getSessionCountFlow() {
        return this.sessionCountFlow;
    }

    @Override // com.myscript.nebo.discoverability.session.ISessionManager
    public int getSessionCount() {
        return this._sessionCountFlow.getValue().intValue();
    }

    @Override // com.myscript.nebo.discoverability.session.ISessionManager
    public void incrementSessionCount() {
        setSerializedSessionCount(getSerializedSessionCount() + 1);
        getSerializedSessionCount();
        this._sessionCountFlow.setValue(Integer.valueOf(getSerializedSessionCount()));
    }

    @Override // com.myscript.nebo.discoverability.session.ISessionManager
    public void clearSessionCount() {
        setSerializedSessionCount(0);
        this._sessionCountFlow.setValue(0);
    }

    public final void registerSessionListener(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    public final void unregisterSessionListener(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }
}
