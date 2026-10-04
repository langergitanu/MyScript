package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SettingsCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.google.firebase.sessions.settings.SettingsCacheImpl", m1609f = "SettingsCache.kt", m1610i = {}, m1611l = {107}, m1612m = "removeConfigs$com_google_firebase_firebase_sessions", m1613n = {}, m1615s = {})
final class SettingsCacheImpl$removeConfigs$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsCacheImpl$removeConfigs$1(SettingsCacheImpl settingsCacheImpl, Continuation<? super SettingsCacheImpl$removeConfigs$1> continuation) {
        super(continuation);
        this.this$0 = settingsCacheImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
