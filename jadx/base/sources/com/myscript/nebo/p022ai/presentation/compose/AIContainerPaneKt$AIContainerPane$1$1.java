package com.myscript.nebo.p022ai.presentation.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AIContainerPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$AIContainerPane$1$1", m1609f = "AIContainerPane.kt", m1610i = {}, m1611l = {83, 84}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {84, -1}, m1615s = {}, m1616v = 2)
final class AIContainerPaneKt$AIContainerPane$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $dotCount;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AIContainerPaneKt$AIContainerPane$1$1(Animatable<Float, AnimationVector1D> animatable, Continuation<? super AIContainerPaneKt$AIContainerPane$1$1> continuation) {
        super(2, continuation);
        this.$dotCount = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIContainerPaneKt$AIContainerPane$1$1(this.$dotCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIContainerPaneKt$AIContainerPane$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0057 -> B:11:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.label = 2;
                if (this.$dotCount.snapTo(Boxing.boxFloat(1.0f), this) != coroutine_suspended) {
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$dotCount, Boxing.boxFloat(3.0f), AnimationSpecKt.tween$default(600, 0, EasingKt.getLinearEasing(), 2, null), null, null, this, 12, null) != coroutine_suspended) {
                        this.label = 2;
                        if (this.$dotCount.snapTo(Boxing.boxFloat(1.0f), this) != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (Animatable.animateTo$default(this.$dotCount, Boxing.boxFloat(3.0f), AnimationSpecKt.tween$default(600, 0, EasingKt.getLinearEasing(), 2, null), null, null, this, 12, null) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
