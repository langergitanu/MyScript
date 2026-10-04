package com.myscript.nebo.dms.discoverability;

import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GridDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.discoverability.GridDiscoverableFeature$SyncButtonFeature", m1609f = "GridDiscoverableFeature.kt", m1610i = {0}, m1611l = {34}, m1612m = "needsDiscovery", m1613n = {"state"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GridDiscoverableFeature.SyncButtonFeature this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1(GridDiscoverableFeature.SyncButtonFeature syncButtonFeature, Continuation<? super GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1> continuation) {
        super(continuation);
        this.this$0 = syncButtonFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.needsDiscovery(null, this);
    }
}
