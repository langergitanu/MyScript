package com.myscript.nebo.discoverability;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureDiscoveryState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "", "sessionCount", "", "discoveryRepository", "Lcom/myscript/nebo/discoverability/IDiscoveryRepository;", "extras", "<init>", "(ILcom/myscript/nebo/discoverability/IDiscoveryRepository;Ljava/lang/Object;)V", "getSessionCount", "()I", "getDiscoveryRepository", "()Lcom/myscript/nebo/discoverability/IDiscoveryRepository;", "getExtras", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FeatureDiscoveryState {
    public static final int $stable = 8;
    private final IDiscoveryRepository discoveryRepository;
    private final Object extras;
    private final int sessionCount;

    public static /* synthetic */ FeatureDiscoveryState copy$default(FeatureDiscoveryState featureDiscoveryState, int i, IDiscoveryRepository iDiscoveryRepository, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = featureDiscoveryState.sessionCount;
        }
        if ((i2 & 2) != 0) {
            iDiscoveryRepository = featureDiscoveryState.discoveryRepository;
        }
        if ((i2 & 4) != 0) {
            obj = featureDiscoveryState.extras;
        }
        return featureDiscoveryState.copy(i, iDiscoveryRepository, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSessionCount() {
        return this.sessionCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IDiscoveryRepository getDiscoveryRepository() {
        return this.discoveryRepository;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getExtras() {
        return this.extras;
    }

    public final FeatureDiscoveryState copy(int sessionCount, IDiscoveryRepository discoveryRepository, Object extras) {
        Intrinsics.checkNotNullParameter(discoveryRepository, "discoveryRepository");
        return new FeatureDiscoveryState(sessionCount, discoveryRepository, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureDiscoveryState)) {
            return false;
        }
        FeatureDiscoveryState featureDiscoveryState = (FeatureDiscoveryState) other;
        return this.sessionCount == featureDiscoveryState.sessionCount && Intrinsics.areEqual(this.discoveryRepository, featureDiscoveryState.discoveryRepository) && Intrinsics.areEqual(this.extras, featureDiscoveryState.extras);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.sessionCount) * 31) + this.discoveryRepository.hashCode()) * 31;
        Object obj = this.extras;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "FeatureDiscoveryState(sessionCount=" + this.sessionCount + ", discoveryRepository=" + this.discoveryRepository + ", extras=" + this.extras + ")";
    }

    public FeatureDiscoveryState(int i, IDiscoveryRepository discoveryRepository, Object obj) {
        Intrinsics.checkNotNullParameter(discoveryRepository, "discoveryRepository");
        this.sessionCount = i;
        this.discoveryRepository = discoveryRepository;
        this.extras = obj;
    }

    public /* synthetic */ FeatureDiscoveryState(int i, IDiscoveryRepository iDiscoveryRepository, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, iDiscoveryRepository, (i2 & 4) != 0 ? null : obj);
    }

    public final IDiscoveryRepository getDiscoveryRepository() {
        return this.discoveryRepository;
    }

    public final Object getExtras() {
        return this.extras;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }
}
