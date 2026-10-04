package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.localrules.LocalRulesEvaluationException;
import com.revenuecat.purchases.rules.RulesEngine;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: LocalRulesEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JL\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\f0\u000b\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014Jr\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102(\u0010\u0015\u001a$\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluator;", "", "providers", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Ljava/util/List;Lcom/revenuecat/purchases/common/DateProvider;)V", "dimensionResolver", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolver;", "match", "Lkotlin/Result;", "Rule", "Lcom/revenuecat/purchases/common/localrules/LocalRule;", "rules", "customVariables", "", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "match-0E7RQCE", "(Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicateFor", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "match-BWLJW6A", "(Ljava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class LocalRulesEvaluator {
    private final RulesDimensionResolver dimensionResolver;

    public LocalRulesEvaluator(List<? extends RulesDimensionProvider> providers, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.dimensionResolver = new RulesDimensionResolver(providers, dateProvider);
    }

    public /* synthetic */ LocalRulesEvaluator(List list, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: match-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <Rule extends LocalRule> Object m13733match0E7RQCE(List<? extends Rule> list, Map<String, ? extends RulesDimensionValue> map, Continuation<? super Result<? extends Rule>> continuation) {
        LocalRulesEvaluator$match$1 localRulesEvaluator$match$1;
        if (continuation instanceof LocalRulesEvaluator$match$1) {
            localRulesEvaluator$match$1 = (LocalRulesEvaluator$match$1) continuation;
            if ((localRulesEvaluator$match$1.label & Integer.MIN_VALUE) != 0) {
                localRulesEvaluator$match$1.label -= Integer.MIN_VALUE;
            } else {
                localRulesEvaluator$match$1 = new LocalRulesEvaluator$match$1(this, continuation);
            }
        }
        Object obj = localRulesEvaluator$match$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = localRulesEvaluator$match$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LocalRulesEvaluator$match$2 localRulesEvaluator$match$2 = new LocalRulesEvaluator$match$2(null);
        localRulesEvaluator$match$1.label = 1;
        Object objM13734matchBWLJW6A = m13734matchBWLJW6A(list, map, localRulesEvaluator$match$2, localRulesEvaluator$match$1);
        return objM13734matchBWLJW6A == coroutine_suspended ? coroutine_suspended : objM13734matchBWLJW6A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: match-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m13731match0E7RQCE$default(LocalRulesEvaluator localRulesEvaluator, List list, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return localRulesEvaluator.m13733match0E7RQCE(list, map, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
    
        if (r13 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b8, code lost:
    
        if (r15 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ba, code lost:
    
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r15v16, types: [T, com.revenuecat.purchases.common.localrules.LocalRulesEvaluationException$PredicateEvaluation] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b8 -> B:31:0x00bb). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: match-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <Rule> Object m13734matchBWLJW6A(List<? extends Rule> list, Map<String, ? extends RulesDimensionValue> map, Function2<? super Rule, ? super Continuation<? super Result<String>>, ? extends Object> function2, Continuation<? super Result<? extends Rule>> continuation) {
        LocalRulesEvaluator$match$3 localRulesEvaluator$match$3;
        Object objM13736snapshotgIAlus;
        Iterator it;
        RulesDimensionSnapshot rulesDimensionSnapshot;
        Function2<? super Rule, ? super Continuation<? super Result<String>>, ? extends Object> function22;
        Ref.ObjectRef objectRef;
        int i;
        if (continuation instanceof LocalRulesEvaluator$match$3) {
            localRulesEvaluator$match$3 = (LocalRulesEvaluator$match$3) continuation;
            if ((localRulesEvaluator$match$3.label & Integer.MIN_VALUE) != 0) {
                localRulesEvaluator$match$3.label -= Integer.MIN_VALUE;
            } else {
                localRulesEvaluator$match$3 = new LocalRulesEvaluator$match$3(this, continuation);
            }
        }
        Object objInvoke = localRulesEvaluator$match$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = localRulesEvaluator$match$3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (list.isEmpty()) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m14499constructorimpl(null);
            }
            RulesDimensionResolver rulesDimensionResolver = this.dimensionResolver;
            localRulesEvaluator$match$3.L$0 = list;
            localRulesEvaluator$match$3.L$1 = function2;
            localRulesEvaluator$match$3.label = 1;
            objM13736snapshotgIAlus = rulesDimensionResolver.m13736snapshotgIAlus(map, localRulesEvaluator$match$3);
        } else if (i2 == 1) {
            function2 = (Function2) localRulesEvaluator$match$3.L$1;
            list = (List) localRulesEvaluator$match$3.L$0;
            ResultKt.throwOnFailure(objInvoke);
            objM13736snapshotgIAlus = ((Result) objInvoke).getValue();
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = localRulesEvaluator$match$3.I$1;
            int i3 = localRulesEvaluator$match$3.I$0;
            Object next = localRulesEvaluator$match$3.L$4;
            it = (Iterator) localRulesEvaluator$match$3.L$3;
            objectRef = (Ref.ObjectRef) localRulesEvaluator$match$3.L$2;
            rulesDimensionSnapshot = (RulesDimensionSnapshot) localRulesEvaluator$match$3.L$1;
            function22 = (Function2) localRulesEvaluator$match$3.L$0;
            ResultKt.throwOnFailure(objInvoke);
            Object value = ((Result) objInvoke).getValue();
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(value);
            if (thM14502exceptionOrNullimpl != null) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
            Object objM13852evaluategIAlus = RulesEngine.INSTANCE.m13852evaluategIAlus((String) value, rulesDimensionSnapshot.getValues());
            Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM13852evaluategIAlus);
            if (thM14502exceptionOrNullimpl2 != null) {
                if (objectRef.element == 0) {
                    objectRef.element = new LocalRulesEvaluationException.PredicateEvaluation(i, thM14502exceptionOrNullimpl2);
                }
                objM13852evaluategIAlus = Boxing.boxBoolean(false);
            }
            if (((Boolean) objM13852evaluategIAlus).booleanValue()) {
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m14499constructorimpl(next);
            }
            i = i3;
            if (!it.hasNext()) {
                i3 = i + 1;
                next = it.next();
                localRulesEvaluator$match$3.L$0 = function22;
                localRulesEvaluator$match$3.L$1 = rulesDimensionSnapshot;
                localRulesEvaluator$match$3.L$2 = objectRef;
                localRulesEvaluator$match$3.L$3 = it;
                localRulesEvaluator$match$3.L$4 = next;
                localRulesEvaluator$match$3.I$0 = i3;
                localRulesEvaluator$match$3.I$1 = i;
                localRulesEvaluator$match$3.label = 2;
                objInvoke = function22.invoke(next, localRulesEvaluator$match$3);
            } else {
                LocalRulesEvaluationException.PredicateEvaluation predicateEvaluation = (LocalRulesEvaluationException.PredicateEvaluation) objectRef.element;
                if (predicateEvaluation != null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m14499constructorimpl(ResultKt.createFailure(predicateEvaluation));
                }
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m14499constructorimpl(null);
            }
        }
        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM13736snapshotgIAlus);
        if (thM14502exceptionOrNullimpl3 != null) {
            Result.Companion companion6 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(new LocalRulesEvaluationException.DimensionResolution(thM14502exceptionOrNullimpl3)));
        }
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        it = list.iterator();
        rulesDimensionSnapshot = (RulesDimensionSnapshot) objM13736snapshotgIAlus;
        function22 = function2;
        objectRef = objectRef2;
        i = 0;
        if (!it.hasNext()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: match-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m13732matchBWLJW6A$default(LocalRulesEvaluator localRulesEvaluator, List list, Map map, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return localRulesEvaluator.m13734matchBWLJW6A(list, map, function2, continuation);
    }
}
