package com.myscript.nebo.purchase;

import com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Paywall.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1", m1609f = "Paywall.kt", m1610i = {}, m1611l = {306}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {307}, m1615s = {}, m1616v = 2)
final class PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $onPurchaseInitiated;
    final /* synthetic */ Resumable $resume;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1(Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Resumable resumable, Continuation<? super PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1> continuation) {
        super(2, continuation);
        this.$onPurchaseInitiated = function1;
        this.$resume = resumable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1(this.$onPurchaseInitiated, this.$resume, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Boolean>, Object> function1 = this.$onPurchaseInitiated;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$resume.invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
