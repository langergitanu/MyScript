package com.revenuecat.purchases.checkpoints;

import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl;
import com.revenuecat.purchases.common.audiences.Audience;
import com.revenuecat.purchases.common.checkpoints.CheckpointRule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m1599d2 = {"<anonymous>", "Lkotlin/Result;", "", "rule", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA9_4}, m1612m = "invokeSuspend", m1613n = {"rule"}, m1615s = {"L$0"})
final class CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1 extends SuspendLambda implements Function2<CheckpointRule, Continuation<? super Result<? extends String>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CheckpointWorkflowResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1(CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl, Continuation<? super CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = checkpointWorkflowResolverImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1 checkpointWorkflowResolverImpl$attemptResolve$matchResult$1 = new CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1(this.this$0, continuation);
        checkpointWorkflowResolverImpl$attemptResolve$matchResult$1.L$0 = obj;
        return checkpointWorkflowResolverImpl$attemptResolve$matchResult$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CheckpointRule checkpointRule, Continuation<? super Result<String>> continuation) {
        return ((CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1) create(checkpointRule, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CheckpointRule checkpointRule, Continuation<? super Result<? extends String>> continuation) {
        return invoke2(checkpointRule, (Continuation<? super Result<String>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CheckpointRule checkpointRule;
        Object objM14499constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CheckpointRule checkpointRule2 = (CheckpointRule) this.L$0;
            this.L$0 = checkpointRule2;
            this.label = 1;
            Object audience = this.this$0.audiencesConfigProvider.getAudience(checkpointRule2.getAudienceId(), this);
            if (audience == coroutine_suspended) {
                return coroutine_suspended;
            }
            checkpointRule = checkpointRule2;
            obj = audience;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            checkpointRule = (CheckpointRule) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Audience audience2 = (Audience) obj;
        if (audience2 != null) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(audience2.getRules());
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new CheckpointWorkflowResolverImpl.AudienceUnavailableException(checkpointRule.getAudienceId())));
        }
        return Result.m14498boximpl(objM14499constructorimpl);
    }
}
