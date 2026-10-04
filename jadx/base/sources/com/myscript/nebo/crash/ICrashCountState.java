package com.myscript.nebo.crash;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICrashCountState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&R\u001a\u0010\t\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/crash/ICrashCountState;", "", "getCrashCount", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "incrementCrashCount", "", "resetCrashCount", "noteCrashCountKey", "getNoteCrashCountKey", "()Ljava/lang/String;", "setNoteCrashCountKey", "(Ljava/lang/String;)V", "pagesCrashCountKeys", "", "getPagesCrashCountKeys", "()Ljava/util/Set;", "setPagesCrashCountKeys", "(Ljava/util/Set;)V", "shouldFlagPageAsCorrupted", "", "shouldLeaveCrashingPage", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ICrashCountState {
    int getCrashCount(String key);

    String getNoteCrashCountKey();

    Set<String> getPagesCrashCountKeys();

    void incrementCrashCount(String key);

    void resetCrashCount(String key);

    void setNoteCrashCountKey(String str);

    void setPagesCrashCountKeys(Set<String> set);

    boolean shouldFlagPageAsCorrupted(String key);

    boolean shouldLeaveCrashingPage(String key);
}
