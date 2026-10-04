package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.common.localrules.LocalRule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LocalRulesEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.localrules.LocalRulesEvaluator", m1609f = "LocalRulesEvaluator.kt", m1610i = {}, m1611l = {50}, m1612m = "match-0E7RQCE", m1613n = {}, m1615s = {})
final class LocalRulesEvaluator$match$1<Rule extends LocalRule> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalRulesEvaluator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalRulesEvaluator$match$1(LocalRulesEvaluator localRulesEvaluator, Continuation<? super LocalRulesEvaluator$match$1> continuation) {
        super(continuation);
        this.this$0 = localRulesEvaluator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13733match0E7RQCE = this.this$0.m13733match0E7RQCE(null, null, this);
        return objM13733match0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13733match0E7RQCE : Result.m14498boximpl(objM13733match0E7RQCE);
    }
}
