package com.myscript.nebo.grid;

import com.myscript.nebo.purchase.RenewalOfferState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$renewalOfferBannerHours$2$1", m1609f = "GridViewModel.kt", m1610i = {0, 0, 1, 1, 2, 2}, m1611l = {495, 498, 499}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "remainingMs", "$this$flow", "remainingMs", "$this$flow", "remainingMs"}, m1614nl = {496, 499, 501}, m1615s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"}, m1616v = 2)
final class GridViewModel$renewalOfferBannerHours$2$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RenewalOfferState $state;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$renewalOfferBannerHours$2$1(RenewalOfferState renewalOfferState, Continuation<? super GridViewModel$renewalOfferBannerHours$2$1> continuation) {
        super(2, continuation);
        this.$state = renewalOfferState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GridViewModel$renewalOfferBannerHours$2$1 gridViewModel$renewalOfferBannerHours$2$1 = new GridViewModel$renewalOfferBannerHours$2$1(this.$state, continuation);
        gridViewModel$renewalOfferBannerHours$2$1.L$0 = obj;
        return gridViewModel$renewalOfferBannerHours$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((GridViewModel$renewalOfferBannerHours$2$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r0.emit(kotlin.coroutines.jvm.internal.Boxing.boxInt(0), r12) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009b -> B:13:0x002b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long endsAtMs;
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                endsAtMs = this.J$0;
                ResultKt.throwOnFailure(obj);
                Duration.Companion companion = Duration.INSTANCE;
                this.L$0 = flowCollector;
                this.J$0 = endsAtMs;
                this.label = 3;
                if (DelayKt.m16008delayVtjQ1oo(DurationKt.toDuration(1, DurationUnit.MINUTES), this) != coroutine_suspended) {
                    endsAtMs = this.$state.getEndsAtMs() - System.currentTimeMillis();
                    if (endsAtMs > 0) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.J$0 = endsAtMs;
                        this.label = 1;
                    } else {
                        Duration.Companion companion2 = Duration.INSTANCE;
                        this.L$0 = flowCollector;
                        this.J$0 = endsAtMs;
                        this.label = 2;
                        if (flowCollector.emit(Boxing.boxInt(RangesKt.coerceIn((int) Math.ceil(endsAtMs / Duration.m15867getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.HOURS))), 1, 72)), this) != coroutine_suspended) {
                            Duration.Companion companion3 = Duration.INSTANCE;
                            this.L$0 = flowCollector;
                            this.J$0 = endsAtMs;
                            this.label = 3;
                            if (DelayKt.m16008delayVtjQ1oo(DurationKt.toDuration(1, DurationUnit.MINUTES), this) != coroutine_suspended) {
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        endsAtMs = this.$state.getEndsAtMs() - System.currentTimeMillis();
        if (endsAtMs > 0) {
        }
        return coroutine_suspended;
    }
}
