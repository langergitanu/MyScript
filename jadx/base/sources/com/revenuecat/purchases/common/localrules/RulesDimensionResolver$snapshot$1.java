package com.revenuecat.purchases.common.localrules;

import androidx.compose.p004ui.spatial.RectListKt;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RulesDimensionResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.localrules.RulesDimensionResolver", m1609f = "RulesDimensionResolver.kt", m1610i = {0, 0, 0, 0}, m1611l = {RectListKt.BitOffsetForGesturable}, m1612m = "snapshot-gIAlu-s", m1613n = {"customVariables", QuestionSurveyAnswerType.DATE, "values", "provider"}, m1615s = {"L$0", "L$1", "L$2", "L$4"})
final class RulesDimensionResolver$snapshot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RulesDimensionResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RulesDimensionResolver$snapshot$1(RulesDimensionResolver rulesDimensionResolver, Continuation<? super RulesDimensionResolver$snapshot$1> continuation) {
        super(continuation);
        this.this$0 = rulesDimensionResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13736snapshotgIAlus = this.this$0.m13736snapshotgIAlus(null, this);
        return objM13736snapshotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13736snapshotgIAlus : Result.m14498boximpl(objM13736snapshotgIAlus);
    }
}
