package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPendingTransition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowTransitionState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1", m1609f = "WorkflowTransitionState.kt", m1610i = {}, m1611l = {100}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animatable;
    final /* synthetic */ State<Function1<Integer, Unit>> $latestOnTransitionComplete$delegate;
    final /* synthetic */ WorkflowPendingTransition $pendingTransition;
    final /* synthetic */ WorkflowTransitionAnimation $transition;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1(WorkflowPendingTransition workflowPendingTransition, Animatable<Float, AnimationVector1D> animatable, WorkflowTransitionAnimation workflowTransitionAnimation, State<? extends Function1<? super Integer, Unit>> state, Continuation<? super WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1> continuation) {
        super(2, continuation);
        this.$pendingTransition = workflowPendingTransition;
        this.$animatable = animatable;
        this.$transition = workflowTransitionAnimation;
        this.$latestOnTransitionComplete$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1(this.$pendingTransition, this.$animatable, this.$transition, this.$latestOnTransitionComplete$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$pendingTransition != null) {
                this.label = 1;
                if (Animatable.animateTo$default(this.$animatable, Boxing.boxFloat(1.0f), WorkflowTransitionStateKt.toAnimationSpec(this.$transition), null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        WorkflowTransitionStateKt.rememberWorkflowTransitionState$lambda$1(this.$latestOnTransitionComplete$delegate).invoke(Boxing.boxInt(this.$pendingTransition.getId()));
        return Unit.INSTANCE;
    }
}
