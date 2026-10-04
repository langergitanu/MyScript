package com.myscript.nebo.editing.discoverability;

import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature$BoardFeature", m1609f = "EditingDiscoverableFeature.kt", m1610i = {0}, m1611l = {35}, m1612m = "needsDiscovery", m1613n = {"state"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class EditingDiscoverableFeature$BoardFeature$needsDiscovery$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditingDiscoverableFeature.BoardFeature this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditingDiscoverableFeature$BoardFeature$needsDiscovery$1(EditingDiscoverableFeature.BoardFeature boardFeature, Continuation<? super EditingDiscoverableFeature$BoardFeature$needsDiscovery$1> continuation) {
        super(continuation);
        this.this$0 = boardFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.needsDiscovery(null, this);
    }
}
