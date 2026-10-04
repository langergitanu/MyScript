package kotlinx.coroutines.flow;

import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m1599d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FlowKt__LogicKt$all$$inlined$collectWhile$1<T> implements FlowCollector<T> {
    final /* synthetic */ Ref.BooleanRef $foundCounterExample$inlined;
    final /* synthetic */ Function2 $predicate$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LogicKt$all$$inlined$collectWhile$1$1 */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "kotlinx.coroutines.flow.FlowKt__LogicKt$all$$inlined$collectWhile$1", m1609f = "Logic.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_3_2}, m1612m = "emit", m1613n = {"this"}, m1615s = {"L$0"})
    public static final class C88031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C88031(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LogicKt$all$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LogicKt$all$$inlined$collectWhile$1(Function2 function2, Ref.BooleanRef booleanRef) {
        this.$predicate$inlined = function2;
        this.$foundCounterExample$inlined = booleanRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        C88031 c88031;
        FlowKt__LogicKt$all$$inlined$collectWhile$1<T> flowKt__LogicKt$all$$inlined$collectWhile$1;
        if (continuation instanceof C88031) {
            c88031 = (C88031) continuation;
            if ((c88031.label & Integer.MIN_VALUE) != 0) {
                c88031.label -= Integer.MIN_VALUE;
            } else {
                c88031 = new C88031(continuation);
            }
        }
        Object objInvoke = c88031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c88031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function2 function2 = this.$predicate$inlined;
            c88031.L$0 = this;
            c88031.label = 1;
            objInvoke = function2.invoke(t, c88031);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowKt__LogicKt$all$$inlined$collectWhile$1 = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__LogicKt$all$$inlined$collectWhile$1 = (FlowKt__LogicKt$all$$inlined$collectWhile$1) c88031.L$0;
            ResultKt.throwOnFailure(objInvoke);
        }
        boolean zBooleanValue = ((Boolean) objInvoke).booleanValue();
        if (!zBooleanValue) {
            flowKt__LogicKt$all$$inlined$collectWhile$1.$foundCounterExample$inlined.element = true;
        }
        if (zBooleanValue) {
            return Unit.INSTANCE;
        }
        throw new AbortFlowException(flowKt__LogicKt$all$$inlined$collectWhile$1);
    }
}
