package com.revenuecat.purchases.common.localrules;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [Rule] */
/* JADX INFO: compiled from: LocalRulesEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lkotlin/Result;", "", "Rule", "Lcom/revenuecat/purchases/common/localrules/LocalRule;", "rule"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.localrules.LocalRulesEvaluator$match$2", m1609f = "LocalRulesEvaluator.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class LocalRulesEvaluator$match$2<Rule> extends SuspendLambda implements Function2<Rule, Continuation<? super Result<? extends String>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    LocalRulesEvaluator$match$2(Continuation<? super LocalRulesEvaluator$match$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalRulesEvaluator$match$2 localRulesEvaluator$match$2 = new LocalRulesEvaluator$match$2(continuation);
        localRulesEvaluator$match$2.L$0 = obj;
        return localRulesEvaluator$match$2;
    }

    /* JADX WARN: Incorrect types in method signature: (TRule;Lkotlin/coroutines/Continuation<-Lkotlin/Result<Ljava/lang/String;>;>;)Ljava/lang/Object; */
    public final Object invoke(LocalRule localRule, Continuation continuation) {
        return ((LocalRulesEvaluator$match$2) create(localRule, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Result<? extends String>> continuation) {
        return invoke((LocalRule) obj, (Continuation) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LocalRule localRule = (LocalRule) this.L$0;
        Result.Companion companion = Result.INSTANCE;
        return Result.m14498boximpl(Result.m14499constructorimpl(localRule.getPredicate()));
    }
}
