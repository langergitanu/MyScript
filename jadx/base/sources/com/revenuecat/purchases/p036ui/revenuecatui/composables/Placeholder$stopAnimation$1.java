package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder", m1609f = "Placeholder.kt", m1610i = {0, 1}, m1611l = {TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, 190}, m1612m = "stopAnimation$revenuecatui_defaultsRelease", m1613n = {"this", "this"}, m1615s = {"L$0", "L$0"})
final class Placeholder$stopAnimation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Placeholder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Placeholder$stopAnimation$1(Placeholder placeholder, Continuation<? super Placeholder$stopAnimation$1> continuation) {
        super(continuation);
        this.this$0 = placeholder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stopAnimation$revenuecatui_defaultsRelease(this);
    }
}
