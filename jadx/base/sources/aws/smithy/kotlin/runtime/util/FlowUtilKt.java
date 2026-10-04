package aws.smithy.kotlin.runtime.util;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FlowUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/Flow;", "flows", "mergeSequential", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FlowUtilKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.FlowUtilKt$mergeSequential$1 */
    /* JADX INFO: compiled from: FlowUtil.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.FlowUtilKt$mergeSequential$1", m1609f = "FlowUtil.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {14}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$forEach$iv", "element$iv", "flow", "$i$f$forEach", "$i$a$-forEach-FlowUtilKt$mergeSequential$1$1"}, m1614nl = {17}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$3"}, m1616v = 2)
    static final class C37971<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C37971(Flow<? extends T>[] flowArr, Continuation<? super C37971> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C37971 c37971 = new C37971(this.$flows, continuation);
            c37971.L$0 = obj;
            return c37971;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((C37971) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0059 -> B:13:0x005c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int length;
            Flow<T>[] flowArr;
            int i;
            int i2;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T>[] flowArr2 = this.$flows;
                length = flowArr2.length;
                flowArr = flowArr2;
                i = 0;
                i2 = 0;
                if (i < length) {
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                length = this.I$2;
                i = this.I$1;
                i2 = this.I$0;
                flowArr = (Flow[]) this.L$1;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < length) {
                    Flow<T> flow = flowArr[i];
                    this.L$0 = flowCollector;
                    this.L$1 = flowArr;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(flow);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(flow);
                    this.I$0 = i2;
                    this.I$1 = i;
                    this.I$2 = length;
                    this.I$3 = 0;
                    this.label = 1;
                    if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i++;
                    if (i < length) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    @InternalApi
    public static final <T> Flow<T> mergeSequential(Flow<? extends T>... flows) {
        Intrinsics.checkNotNullParameter(flows, "flows");
        return FlowKt.flow(new C37971(flows, null));
    }
}
