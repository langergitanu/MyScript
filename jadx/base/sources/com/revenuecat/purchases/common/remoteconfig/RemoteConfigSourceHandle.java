package com.revenuecat.purchases.common.remoteconfig;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "", "purpose", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", FirebaseAnalytics.Param.SOURCE, "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;", "token", "", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;I)V", "getPurpose", "()Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "getSource", "()Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;", "getToken", "()I", ImagesContract.URL, "", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", HttpHeaders.PURPOSE, "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class RemoteConfigSourceHandle {
    private final Purpose purpose;
    private final RemoteConfigSource source;
    private final int token;

    /* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "", "(Ljava/lang/String;I)V", "API", "BLOB", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public enum Purpose {
        API,
        BLOB
    }

    public static /* synthetic */ RemoteConfigSourceHandle copy$default(RemoteConfigSourceHandle remoteConfigSourceHandle, Purpose purpose, RemoteConfigSource remoteConfigSource, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            purpose = remoteConfigSourceHandle.purpose;
        }
        if ((i2 & 2) != 0) {
            remoteConfigSource = remoteConfigSourceHandle.source;
        }
        if ((i2 & 4) != 0) {
            i = remoteConfigSourceHandle.token;
        }
        return remoteConfigSourceHandle.copy(purpose, remoteConfigSource, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Purpose getPurpose() {
        return this.purpose;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RemoteConfigSource getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getToken() {
        return this.token;
    }

    public final RemoteConfigSourceHandle copy(Purpose purpose, RemoteConfigSource source, int token) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(source, "source");
        return new RemoteConfigSourceHandle(purpose, source, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteConfigSourceHandle)) {
            return false;
        }
        RemoteConfigSourceHandle remoteConfigSourceHandle = (RemoteConfigSourceHandle) other;
        return this.purpose == remoteConfigSourceHandle.purpose && Intrinsics.areEqual(this.source, remoteConfigSourceHandle.source) && this.token == remoteConfigSourceHandle.token;
    }

    public int hashCode() {
        return (((this.purpose.hashCode() * 31) + this.source.hashCode()) * 31) + Integer.hashCode(this.token);
    }

    public String toString() {
        return "RemoteConfigSourceHandle(purpose=" + this.purpose + ", source=" + this.source + ", token=" + this.token + ')';
    }

    public RemoteConfigSourceHandle(Purpose purpose, RemoteConfigSource source, int i) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(source, "source");
        this.purpose = purpose;
        this.source = source;
        this.token = i;
    }

    public final Purpose getPurpose() {
        return this.purpose;
    }

    public final RemoteConfigSource getSource() {
        return this.source;
    }

    public final int getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.source.getUrl();
    }
}
