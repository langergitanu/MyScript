package com.google.firebase.sessions;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimeProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/google/firebase/sessions/TimeProvider;", "", "elapsedRealtime", "Lkotlin/time/Duration;", "elapsedRealtime-UwyO8pc", "()J", "currentTime", "Lcom/google/firebase/sessions/Time;", "com.google.firebase-firebase-sessions"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface TimeProvider {
    Time currentTime();

    /* JADX INFO: renamed from: elapsedRealtime-UwyO8pc, reason: not valid java name */
    long mo12502elapsedRealtimeUwyO8pc();
}
