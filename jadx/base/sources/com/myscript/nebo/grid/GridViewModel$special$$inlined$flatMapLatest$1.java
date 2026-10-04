package com.myscript.nebo.grid;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.PsExtractor;
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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, m1599d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$special$$inlined$flatMapLatest$1", m1609f = "GridViewModel.kt", m1610i = {0, 0}, m1611l = {PsExtractor.PRIVATE_STREAM_1}, m1612m = "invokeSuspend", m1613n = {"$this$transformLatest", "it"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
public final class GridViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, RenewalOfferState, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public GridViewModel$special$$inlined$flatMapLatest$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super Integer> flowCollector, RenewalOfferState renewalOfferState, Continuation<? super Unit> continuation) {
        GridViewModel$special$$inlined$flatMapLatest$1 gridViewModel$special$$inlined$flatMapLatest$1 = new GridViewModel$special$$inlined$flatMapLatest$1(continuation);
        gridViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        gridViewModel$special$$inlined$flatMapLatest$1.L$1 = renewalOfferState;
        return gridViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            GridViewModel$special$$inlined$flatMapLatest$1 gridViewModel$special$$inlined$flatMapLatest$1 = this;
            RenewalOfferState renewalOfferState = (RenewalOfferState) obj2;
            if (renewalOfferState == null) {
                flow = FlowKt.flowOf(Boxing.boxInt(0));
            } else {
                flow = FlowKt.flow(new GridViewModel$renewalOfferBannerHours$2$1(renewalOfferState, null));
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, gridViewModel$special$$inlined$flatMapLatest$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
