package com.myscript.nebo.discoverability.session;

import kotlin.Metadata;

/* JADX INFO: compiled from: ISessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/session/ISessionManager;", "", "getSessionCount", "", "incrementSessionCount", "", "clearSessionCount", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ISessionManager {
    void clearSessionCount();

    int getSessionCount();

    void incrementSessionCount();
}
