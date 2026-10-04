package com.myscript.nebo.editing.discoverability;

import androidx.appcompat.app.AppCompatDelegate;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature$DocumentConvertTextFeature$needsDiscovery$1 */
/* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature$DocumentConvertTextFeature", m1609f = "EditingDiscoverableFeature.kt", m1610i = {0, 1}, m1611l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 110}, m1612m = "needsDiscovery", m1613n = {"state", "state"}, m1614nl = {110, 108}, m1615s = {"L$0", "L$0"}, m1616v = 2)
final class C6423xf01c6aa extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditingDiscoverableFeature.DocumentConvertTextFeature this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6423xf01c6aa(EditingDiscoverableFeature.DocumentConvertTextFeature documentConvertTextFeature, Continuation<? super C6423xf01c6aa> continuation) {
        super(continuation);
        this.this$0 = documentConvertTextFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.needsDiscovery(null, this);
    }
}
