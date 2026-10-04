package com.google.firebase.sessions;

import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory */
/* JADX INFO: loaded from: classes3.dex */
public final class C5896x7ce4ac45 implements Factory<TimeProvider> {
    @Override // javax.inject.Provider
    public TimeProvider get() {
        return timeProvider();
    }

    public static C5896x7ce4ac45 create() {
        return InstanceHolder.INSTANCE;
    }

    public static TimeProvider timeProvider() {
        return (TimeProvider) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.timeProvider());
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory$InstanceHolder */
    private static final class InstanceHolder {
        static final C5896x7ce4ac45 INSTANCE = new C5896x7ce4ac45();

        private InstanceHolder() {
        }
    }
}
