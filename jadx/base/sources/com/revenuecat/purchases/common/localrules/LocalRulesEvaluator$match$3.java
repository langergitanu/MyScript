package com.revenuecat.purchases.common.localrules;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LocalRulesEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.localrules.LocalRulesEvaluator", m1609f = "LocalRulesEvaluator.kt", m1610i = {0, 0, 1, 1, 1, 1, 1}, m1611l = {60, UCrop.REQUEST_CROP}, m1612m = "match-BWLJW6A", m1613n = {"rules", "predicateFor", "predicateFor", "snapshot", "firstFailure", "rule", FirebaseAnalytics.Param.INDEX}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "I$1"})
final class LocalRulesEvaluator$match$3<Rule> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalRulesEvaluator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalRulesEvaluator$match$3(LocalRulesEvaluator localRulesEvaluator, Continuation<? super LocalRulesEvaluator$match$3> continuation) {
        super(continuation);
        this.this$0 = localRulesEvaluator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13734matchBWLJW6A = this.this$0.m13734matchBWLJW6A(null, null, null, this);
        return objM13734matchBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13734matchBWLJW6A : Result.m14498boximpl(objM13734matchBWLJW6A);
    }
}
