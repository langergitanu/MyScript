package com.myscript.nebo.purchase;

import com.revenuecat.purchases.Offerings;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$preConfigure$2$1", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class SubscriptionRepository$preConfigure$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appUserId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$preConfigure$2$1(SubscriptionRepository subscriptionRepository, String str, Continuation<? super SubscriptionRepository$preConfigure$2$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionRepository;
        this.$appUserId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubscriptionRepository$preConfigure$2$1 subscriptionRepository$preConfigure$2$1 = new SubscriptionRepository$preConfigure$2$1(this.this$0, this.$appUserId, continuation);
        subscriptionRepository$preConfigure$2$1.L$0 = obj;
        return subscriptionRepository$preConfigure$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubscriptionRepository$preConfigure$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$preConfigure$2$1$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$preConfigure$2$1$1", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {293}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {294}, m1615s = {}, m1616v = 2)
    static final class C67411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appUserId;
        int label;
        final /* synthetic */ SubscriptionRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67411(SubscriptionRepository subscriptionRepository, String str, Continuation<? super C67411> continuation) {
            super(2, continuation);
            this.this$0 = subscriptionRepository;
            this.$appUserId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67411(this.this$0, this.$appUserId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objMo13348syncAttributesAndOfferingsIfNeededIoAF18A;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = this.this$0.purchaseProvider.mo13348syncAttributesAndOfferingsIfNeededIoAF18A(this);
                if (objMo13348syncAttributesAndOfferingsIfNeededIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = ((Result) obj).getValue();
            }
            if (this.this$0.recordFailure(objMo13348syncAttributesAndOfferingsIfNeededIoAF18A, "failed attributes and offerings sync in preConfigure(" + this.$appUserId + ")", true)) {
                SubscriptionRepository subscriptionRepository = this.this$0;
                if (Result.m14505isFailureimpl(objMo13348syncAttributesAndOfferingsIfNeededIoAF18A)) {
                    objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = null;
                }
                subscriptionRepository._offerings = (Offerings) objMo13348syncAttributesAndOfferingsIfNeededIoAF18A;
                this.this$0.publishRenewalOfferState();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C67411(this.this$0, this.$appUserId, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
