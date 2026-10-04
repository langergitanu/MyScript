package aws.sdk.kotlin.services.p010s3.paginators;

import aws.sdk.kotlin.services.p010s3.model.Bucket;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsResponse;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, m1599d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$buckets$$inlined$transform$2", m1609f = "Paginators.kt", m1610i = {0}, m1611l = {36}, m1612m = "invokeSuspend", m1613n = {"$this$flow"}, m1614nl = {40}, m1615s = {"L$0"}, m1616v = 2)
public final class PaginatorsKt$buckets$$inlined$transform$2 extends SuspendLambda implements Function2<FlowCollector<? super Bucket>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaginatorsKt$buckets$$inlined$transform$2(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaginatorsKt$buckets$$inlined$transform$2 paginatorsKt$buckets$$inlined$transform$2 = new PaginatorsKt$buckets$$inlined$transform$2(this.$this_transform, continuation);
        paginatorsKt$buckets$$inlined$transform$2.L$0 = obj;
        return paginatorsKt$buckets$$inlined$transform$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Bucket> flowCollector, Continuation<? super Unit> continuation) {
        return ((PaginatorsKt$buckets$$inlined$transform$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$buckets$$inlined$transform$2$1 */
    /* JADX INFO: compiled from: Emitters.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C34731<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Bucket> $$this$flow;

        /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$buckets$$inlined$transform$2$1$1, reason: invalid class name */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$buckets$$inlined$transform$2$1", m1609f = "Paginators.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {41}, m1612m = "emit", m1613n = {"value", "$completion", "response", "$this$buckets_u24lambda_u241", "$this$forEach$iv", "element$iv", "it", "$i$a$-transform-PaginatorsKt$buckets$2", "$i$f$forEach", "$i$a$-forEach-PaginatorsKt$buckets$2$1"}, m1614nl = {42}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2"}, m1616v = 2)
        public static final class AnonymousClass1 extends ContinuationImpl {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return C34731.this.emit(null, this);
            }
        }

        public C34731(FlowCollector flowCollector) {
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1;
            Iterable iterable;
            Continuation continuation2;
            int i;
            ListDirectoryBucketsResponse listDirectoryBucketsResponse;
            Iterator<T> it;
            FlowCollector<Bucket> flowCollector;
            int i2;
            Object obj;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label -= Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
            }
            Object obj2 = anonymousClass1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = anonymousClass1.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector<Bucket> flowCollector2 = this.$$this$flow;
                AnonymousClass1 anonymousClass12 = anonymousClass1;
                ListDirectoryBucketsResponse listDirectoryBucketsResponse2 = (ListDirectoryBucketsResponse) t;
                Iterable buckets = listDirectoryBucketsResponse2.getBuckets();
                if (buckets != null) {
                    iterable = buckets;
                    continuation2 = anonymousClass12;
                    i = 0;
                    listDirectoryBucketsResponse = listDirectoryBucketsResponse2;
                    it = iterable.iterator();
                    flowCollector = flowCollector2;
                    i2 = 0;
                    obj = t;
                }
                return Unit.INSTANCE;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = anonymousClass1.I$2;
            int i5 = anonymousClass1.I$1;
            i = anonymousClass1.I$0;
            Object obj3 = anonymousClass1.L$6;
            it = (Iterator) anonymousClass1.L$5;
            iterable = (Iterable) anonymousClass1.L$4;
            flowCollector = (FlowCollector) anonymousClass1.L$3;
            listDirectoryBucketsResponse = (ListDirectoryBucketsResponse) anonymousClass1.L$2;
            continuation2 = (Continuation) anonymousClass1.L$1;
            Object obj4 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
            i2 = i5;
            obj = (T) obj4;
            while (it.hasNext()) {
                Object next = it.next();
                Bucket bucket = (Bucket) next;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsResponse);
                anonymousClass1.L$3 = flowCollector;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(iterable);
                anonymousClass1.L$5 = it;
                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(next);
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(bucket);
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = i2;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 1;
                if (flowCollector.emit(bucket, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.$this_transform.collect(new C34731(flowCollector), this) == coroutine_suspended) {
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
