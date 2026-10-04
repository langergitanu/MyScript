package com.myscript.nebo.discoverability;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prerequisiteKey", "", "getPrerequisiteKey", "()Ljava/lang/String;", "discoveryKey", "getDiscoveryKey", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IDiscoverableFeature {
    String getDiscoveryKey();

    int getMinimumSessionCount();

    Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation);

    /* JADX INFO: compiled from: IDiscoverableFeature.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getPrerequisiteKey(IDiscoverableFeature iDiscoverableFeature) {
            return IDiscoverableFeature.super.getPrerequisiteKey();
        }
    }

    default String getPrerequisiteKey() {
        return getDiscoveryKey() + "_prerequisite";
    }
}
