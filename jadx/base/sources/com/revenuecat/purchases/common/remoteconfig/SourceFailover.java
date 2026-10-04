package com.revenuecat.purchases.common.remoteconfig;

import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/SourceFailover;", "", "purpose", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "sources", "", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;", "random", "Lkotlin/random/Random;", "initialToken", "", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;Ljava/util/List;Lkotlin/random/Random;I)V", "current", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "getCurrent", "()Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "currentToken", "getCurrentToken", "()I", "selector", "Lcom/revenuecat/purchases/common/remoteconfig/WeightedSourceSelector;", "token", "reportUnhealthy", "", "handle", "restart", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class SourceFailover {
    private final RemoteConfigSourceHandle.Purpose purpose;
    private final WeightedSourceSelector<RemoteConfigSource> selector;
    private int token;

    public SourceFailover(RemoteConfigSourceHandle.Purpose purpose, List<RemoteConfigSource> sources, Random random, int i) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(random, "random");
        this.purpose = purpose;
        this.selector = new WeightedSourceSelector<>(sources, random);
        this.token = i;
    }

    public /* synthetic */ SourceFailover(RemoteConfigSourceHandle.Purpose purpose, List list, Random random, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(purpose, list, random, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: getCurrentToken, reason: from getter */
    public final int getToken() {
        return this.token;
    }

    public final RemoteConfigSourceHandle getCurrent() {
        RemoteConfigSource remoteConfigSource = (RemoteConfigSource) this.selector.getCurrent();
        if (remoteConfigSource != null) {
            return new RemoteConfigSourceHandle(this.purpose, remoteConfigSource, this.token);
        }
        return null;
    }

    public final boolean reportUnhealthy(RemoteConfigSourceHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        if (handle.getToken() != this.token) {
            return false;
        }
        this.selector.advance();
        this.token++;
        return true;
    }

    public final void restart() {
        this.selector.reset();
        this.token++;
    }
}
