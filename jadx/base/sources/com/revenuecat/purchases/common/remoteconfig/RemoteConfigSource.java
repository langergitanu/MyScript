package com.revenuecat.purchases.common.remoteconfig;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;", "Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", ImagesContract.URL, "", LogFactory.PRIORITY_KEY, "", "weight", "(Ljava/lang/String;II)V", "getPriority", "()I", "getUrl", "()Ljava/lang/String;", "getWeight", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class RemoteConfigSource implements WeightedSource {
    private final int priority;
    private final String url;
    private final int weight;

    public static /* synthetic */ RemoteConfigSource copy$default(RemoteConfigSource remoteConfigSource, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = remoteConfigSource.url;
        }
        if ((i3 & 2) != 0) {
            i = remoteConfigSource.priority;
        }
        if ((i3 & 4) != 0) {
            i2 = remoteConfigSource.weight;
        }
        return remoteConfigSource.copy(str, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    public final RemoteConfigSource copy(String url, int priority, int weight) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new RemoteConfigSource(url, priority, weight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteConfigSource)) {
            return false;
        }
        RemoteConfigSource remoteConfigSource = (RemoteConfigSource) other;
        return Intrinsics.areEqual(this.url, remoteConfigSource.url) && this.priority == remoteConfigSource.priority && this.weight == remoteConfigSource.weight;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + Integer.hashCode(this.weight);
    }

    public String toString() {
        return "RemoteConfigSource(url=" + this.url + ", priority=" + this.priority + ", weight=" + this.weight + ')';
    }

    public RemoteConfigSource(String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.priority = i;
        this.weight = i2;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.WeightedSource
    public int getPriority() {
        return this.priority;
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.WeightedSource
    public int getWeight() {
        return this.weight;
    }
}
