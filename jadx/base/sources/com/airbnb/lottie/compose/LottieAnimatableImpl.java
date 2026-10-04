package com.airbnb.lottie.compose;

import androidx.compose.animation.core.InfiniteAnimationPolicyKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: LottieAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jj\u0010P\u001a\u00020Q2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020$2\u0006\u0010+\u001a\u00020$2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020$H\u0082@¢\u0006\u0002\u0010YJ\u0018\u0010Z\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020$2\u0006\u0010[\u001a\u00020/H\u0002J0\u0010\\\u001a\u00020Q2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u00108\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010]\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010^J\u0010\u0010_\u001a\u00020Q2\u0006\u00108\u001a\u00020\u0014H\u0002J\u0016\u0010`\u001a\u00020\u0014*\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001c\u0010\u001eR+\u0010 \u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\"R+\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020$8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u0010+\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020$8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R+\u00100\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00108\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00148V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010;R+\u0010=\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010;R+\u0010A\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bB\u0010\u001e\"\u0004\bC\u0010\"R+\u0010E\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00148V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010;R+\u0010I\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010\"R\u0014\u0010M\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006a"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatableImpl;", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "()V", "<set-?>", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "setClipSpec", "(Lcom/airbnb/lottie/compose/LottieClipSpec;)V", "clipSpec$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition", "(Lcom/airbnb/lottie/LottieComposition;)V", "composition$delegate", "endProgress", "", "getEndProgress", "()F", "endProgress$delegate", "Landroidx/compose/runtime/State;", "frameSpeed", "getFrameSpeed", "frameSpeed$delegate", "isAtEnd", "", "()Z", "isAtEnd$delegate", "isPlaying", "setPlaying", "(Z)V", "isPlaying$delegate", "", "iteration", "getIteration", "()I", "setIteration", "(I)V", "iteration$delegate", "iterations", "getIterations", "setIterations", "iterations$delegate", "", "lastFrameNanos", "getLastFrameNanos", "()J", "setLastFrameNanos", "(J)V", "lastFrameNanos$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "progress", "getProgress", "setProgress", "(F)V", "progress$delegate", "progressRaw", "getProgressRaw", "setProgressRaw", "progressRaw$delegate", "reverseOnRepeat", "getReverseOnRepeat", "setReverseOnRepeat", "reverseOnRepeat$delegate", "speed", "getSpeed", "setSpeed", "speed$delegate", "useCompositionFrameRate", "getUseCompositionFrameRate", "setUseCompositionFrameRate", "useCompositionFrameRate$delegate", "value", "getValue", "()Ljava/lang/Float;", "animate", "", "initialProgress", "continueFromPreviousAnimate", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimationsDisabled", "(Lcom/airbnb/lottie/LottieComposition;IIZFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFrame", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFrame", "frameNanos", "snapTo", "resetLastFrameNanos", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgress", "roundToCompositionFrameRate", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
final class LottieAnimatableImpl implements LottieAnimatable {

    /* JADX INFO: renamed from: endProgress$delegate, reason: from kotlin metadata */
    private final State endProgress;

    /* JADX INFO: renamed from: isAtEnd$delegate, reason: from kotlin metadata */
    private final State isAtEnd;

    /* JADX INFO: renamed from: lastFrameNanos$delegate, reason: from kotlin metadata */
    private final MutableState lastFrameNanos;
    private final MutatorMutex mutex;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    private final MutableState progress;

    /* JADX INFO: renamed from: progressRaw$delegate, reason: from kotlin metadata */
    private final MutableState progressRaw;

    /* JADX INFO: renamed from: isPlaying$delegate, reason: from kotlin metadata */
    private final MutableState isPlaying = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: iteration$delegate, reason: from kotlin metadata */
    private final MutableState iteration = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);

    /* JADX INFO: renamed from: iterations$delegate, reason: from kotlin metadata */
    private final MutableState iterations = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);

    /* JADX INFO: renamed from: reverseOnRepeat$delegate, reason: from kotlin metadata */
    private final MutableState reverseOnRepeat = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: clipSpec$delegate, reason: from kotlin metadata */
    private final MutableState clipSpec = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: speed$delegate, reason: from kotlin metadata */
    private final MutableState speed = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    /* JADX INFO: renamed from: useCompositionFrameRate$delegate, reason: from kotlin metadata */
    private final MutableState useCompositionFrameRate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: frameSpeed$delegate, reason: from kotlin metadata */
    private final State frameSpeed = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$frameSpeed$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            return Float.valueOf((this.this$0.getReverseOnRepeat() && this.this$0.getIteration() % 2 == 0) ? -this.this$0.getSpeed() : this.this$0.getSpeed());
        }
    });

    /* JADX INFO: renamed from: composition$delegate, reason: from kotlin metadata */
    private final MutableState composition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public LottieAnimatableImpl() {
        Float fValueOf = Float.valueOf(0.0f);
        this.progressRaw = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.progress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.lastFrameNanos = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, null, 2, null);
        this.endProgress = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$endProgress$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                LottieComposition composition = this.this$0.getComposition();
                float maxProgress$lottie_compose_release = 0.0f;
                if (composition != null) {
                    if (this.this$0.getSpeed() < 0.0f) {
                        LottieClipSpec clipSpec = this.this$0.getClipSpec();
                        if (clipSpec != null) {
                            maxProgress$lottie_compose_release = clipSpec.getMinProgress$lottie_compose_release(composition);
                        }
                    } else {
                        LottieClipSpec clipSpec2 = this.this$0.getClipSpec();
                        maxProgress$lottie_compose_release = clipSpec2 != null ? clipSpec2.getMaxProgress$lottie_compose_release(composition) : 1.0f;
                    }
                }
                return Float.valueOf(maxProgress$lottie_compose_release);
            }
        });
        this.isAtEnd = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl.isAtEnd.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(LottieAnimatableImpl.this.getIteration() == LottieAnimatableImpl.this.getIterations() && LottieAnimatableImpl.this.getProgress() == LottieAnimatableImpl.this.getEndProgress());
            }
        });
        this.mutex = new MutatorMutex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z) {
        this.isPlaying.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean isPlaying() {
        return ((Boolean) this.isPlaying.getValue()).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    public Float getValue() {
        return Float.valueOf(getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIteration(int i) {
        this.iteration.setValue(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public int getIteration() {
        return ((Number) this.iteration.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIterations(int i) {
        this.iterations.setValue(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public int getIterations() {
        return ((Number) this.iterations.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReverseOnRepeat(boolean z) {
        this.reverseOnRepeat.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean getReverseOnRepeat() {
        return ((Boolean) this.reverseOnRepeat.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipSpec(LottieClipSpec lottieClipSpec) {
        this.clipSpec.setValue(lottieClipSpec);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public LottieClipSpec getClipSpec() {
        return (LottieClipSpec) this.clipSpec.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeed(float f) {
        this.speed.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public float getSpeed() {
        return ((Number) this.speed.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUseCompositionFrameRate(boolean z) {
        this.useCompositionFrameRate.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean getUseCompositionFrameRate() {
        return ((Boolean) this.useCompositionFrameRate.getValue()).booleanValue();
    }

    private final float getFrameSpeed() {
        return ((Number) this.frameSpeed.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComposition(LottieComposition lottieComposition) {
        this.composition.setValue(lottieComposition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public LottieComposition getComposition() {
        return (LottieComposition) this.composition.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float getProgressRaw() {
        return ((Number) this.progressRaw.getValue()).floatValue();
    }

    private final void setProgressRaw(float f) {
        this.progressRaw.setValue(Float.valueOf(f));
    }

    private void setProgress(float f) {
        this.progress.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastFrameNanos(long j) {
        this.lastFrameNanos.setValue(Long.valueOf(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public long getLastFrameNanos() {
        return ((Number) this.lastFrameNanos.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getEndProgress() {
        return ((Number) this.endProgress.getValue()).floatValue();
    }

    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean isAtEnd() {
        return ((Boolean) this.isAtEnd.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$snapTo$2 */
    /* JADX INFO: compiled from: LottieAnimatable.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.LottieAnimatableImpl$snapTo$2", m1609f = "LottieAnimatable.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38652 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LottieComposition $composition;
        final /* synthetic */ int $iteration;
        final /* synthetic */ float $progress;
        final /* synthetic */ boolean $resetLastFrameNanos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38652(LottieComposition lottieComposition, float f, int i, boolean z, Continuation<? super C38652> continuation) {
            super(1, continuation);
            this.$composition = lottieComposition;
            this.$progress = f;
            this.$iteration = i;
            this.$resetLastFrameNanos = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LottieAnimatableImpl.this.new C38652(this.$composition, this.$progress, this.$iteration, this.$resetLastFrameNanos, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C38652) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LottieAnimatableImpl.this.setComposition(this.$composition);
                LottieAnimatableImpl.this.updateProgress(this.$progress);
                LottieAnimatableImpl.this.setIteration(this.$iteration);
                LottieAnimatableImpl.this.setPlaying(false);
                if (this.$resetLastFrameNanos) {
                    LottieAnimatableImpl.this.setLastFrameNanos(Long.MIN_VALUE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public Object snapTo(LottieComposition lottieComposition, float f, int i, boolean z, Continuation<? super Unit> continuation) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutex, null, new C38652(lottieComposition, f, i, z, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2 */
    /* JADX INFO: compiled from: LottieAnimatable.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2", m1609f = "LottieAnimatable.kt", m1610i = {}, m1611l = {269}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38612 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
        final /* synthetic */ LottieClipSpec $clipSpec;
        final /* synthetic */ LottieComposition $composition;
        final /* synthetic */ boolean $continueFromPreviousAnimate;
        final /* synthetic */ float $initialProgress;
        final /* synthetic */ int $iteration;
        final /* synthetic */ int $iterations;
        final /* synthetic */ boolean $reverseOnRepeat;
        final /* synthetic */ float $speed;
        final /* synthetic */ boolean $useCompositionFrameRate;
        int label;

        /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$WhenMappings */
        /* JADX INFO: compiled from: LottieAnimatable.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LottieCancellationBehavior.values().length];
                try {
                    iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LottieCancellationBehavior.Immediately.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38612(int i, int i2, boolean z, float f, LottieClipSpec lottieClipSpec, LottieComposition lottieComposition, float f2, boolean z2, boolean z3, LottieCancellationBehavior lottieCancellationBehavior, Continuation<? super C38612> continuation) {
            super(1, continuation);
            this.$iteration = i;
            this.$iterations = i2;
            this.$reverseOnRepeat = z;
            this.$speed = f;
            this.$clipSpec = lottieClipSpec;
            this.$composition = lottieComposition;
            this.$initialProgress = f2;
            this.$useCompositionFrameRate = z2;
            this.$continueFromPreviousAnimate = z3;
            this.$cancellationBehavior = lottieCancellationBehavior;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LottieAnimatableImpl.this.new C38612(this.$iteration, this.$iterations, this.$reverseOnRepeat, this.$speed, this.$clipSpec, this.$composition, this.$initialProgress, this.$useCompositionFrameRate, this.$continueFromPreviousAnimate, this.$cancellationBehavior, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C38612) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NonCancellable nonCancellable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    LottieAnimatableImpl.this.setIteration(this.$iteration);
                    LottieAnimatableImpl.this.setIterations(this.$iterations);
                    LottieAnimatableImpl.this.setReverseOnRepeat(this.$reverseOnRepeat);
                    LottieAnimatableImpl.this.setSpeed(this.$speed);
                    LottieAnimatableImpl.this.setClipSpec(this.$clipSpec);
                    LottieAnimatableImpl.this.setComposition(this.$composition);
                    LottieAnimatableImpl.this.updateProgress(this.$initialProgress);
                    LottieAnimatableImpl.this.setUseCompositionFrameRate(this.$useCompositionFrameRate);
                    if (!this.$continueFromPreviousAnimate) {
                        LottieAnimatableImpl.this.setLastFrameNanos(Long.MIN_VALUE);
                    }
                    if (this.$composition == null) {
                        LottieAnimatableImpl.this.setPlaying(false);
                        return Unit.INSTANCE;
                    }
                    if (!Float.isInfinite(this.$speed)) {
                        LottieAnimatableImpl.this.setPlaying(true);
                        int i2 = WhenMappings.$EnumSwitchMapping$0[this.$cancellationBehavior.ordinal()];
                        if (i2 == 1) {
                            nonCancellable = NonCancellable.INSTANCE;
                        } else {
                            if (i2 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            nonCancellable = EmptyCoroutineContext.INSTANCE;
                        }
                        Job job = JobKt.getJob(get$context());
                        this.label = 1;
                        if (BuildersKt.withContext(nonCancellable, new AnonymousClass1(this.$cancellationBehavior, job, this.$iterations, this.$iteration, LottieAnimatableImpl.this, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        LottieAnimatableImpl lottieAnimatableImpl = LottieAnimatableImpl.this;
                        lottieAnimatableImpl.updateProgress(lottieAnimatableImpl.getEndProgress());
                        LottieAnimatableImpl.this.setPlaying(false);
                        LottieAnimatableImpl.this.setIteration(this.$iterations);
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                JobKt.ensureActive(get$context());
                LottieAnimatableImpl.this.setPlaying(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                LottieAnimatableImpl.this.setPlaying(false);
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: LottieAnimatable.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1", m1609f = "LottieAnimatable.kt", m1610i = {}, m1611l = {277}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
            final /* synthetic */ int $iteration;
            final /* synthetic */ int $iterations;
            final /* synthetic */ Job $parentJob;
            int label;
            final /* synthetic */ LottieAnimatableImpl this$0;

            /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1$WhenMappings */
            /* JADX INFO: compiled from: LottieAnimatable.kt */
            @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LottieCancellationBehavior.values().length];
                    try {
                        iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LottieCancellationBehavior lottieCancellationBehavior, Job job, int i, int i2, LottieAnimatableImpl lottieAnimatableImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$cancellationBehavior = lottieCancellationBehavior;
                this.$parentJob = job;
                this.$iterations = i;
                this.$iteration = i2;
                this.this$0 = lottieAnimatableImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$cancellationBehavior, this.$parentJob, this.$iterations, this.$iteration, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0041 -> B:19:0x0044). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L44
                Lf:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L17:
                    kotlin.ResultKt.throwOnFailure(r5)
                L1a:
                    com.airbnb.lottie.compose.LottieCancellationBehavior r5 = r4.$cancellationBehavior
                    int[] r1 = com.airbnb.lottie.compose.LottieAnimatableImpl.C38612.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                    int r5 = r5.ordinal()
                    r5 = r1[r5]
                    if (r5 != r2) goto L34
                    kotlinx.coroutines.Job r5 = r4.$parentJob
                    boolean r5 = r5.isActive()
                    if (r5 == 0) goto L31
                    int r5 = r4.$iterations
                    goto L36
                L31:
                    int r5 = r4.$iteration
                    goto L36
                L34:
                    int r5 = r4.$iterations
                L36:
                    com.airbnb.lottie.compose.LottieAnimatableImpl r1 = r4.this$0
                    r3 = r4
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    r4.label = r2
                    java.lang.Object r5 = com.airbnb.lottie.compose.LottieAnimatableImpl.access$doFrame(r1, r5, r3)
                    if (r5 != r0) goto L44
                    return r0
                L44:
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    boolean r5 = r5.booleanValue()
                    if (r5 != 0) goto L1a
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieAnimatableImpl.C38612.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public Object animate(LottieComposition lottieComposition, int i, int i2, boolean z, float f, LottieClipSpec lottieClipSpec, float f2, boolean z2, LottieCancellationBehavior lottieCancellationBehavior, boolean z3, boolean z4, Continuation<? super Unit> continuation) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutex, null, new C38612(i, i2, z, f, lottieClipSpec, lottieComposition, f2, z4, z2, lottieCancellationBehavior, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doFrame(final int i, Continuation<? super Boolean> continuation) {
        if (i == Integer.MAX_VALUE) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1<Long, Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl.doFrame.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                    return invoke(l.longValue());
                }

                public final Boolean invoke(long j) {
                    return Boolean.valueOf(LottieAnimatableImpl.this.onFrame(i, j));
                }
            }, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl.doFrame.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Boolean invoke(long j) {
                return Boolean.valueOf(LottieAnimatableImpl.this.onFrame(i, j));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onFrame(int iterations, long frameNanos) {
        LottieComposition composition = getComposition();
        if (composition == null) {
            return true;
        }
        long lastFrameNanos = getLastFrameNanos() == Long.MIN_VALUE ? 0L : frameNanos - getLastFrameNanos();
        setLastFrameNanos(frameNanos);
        LottieClipSpec clipSpec = getClipSpec();
        float minProgress$lottie_compose_release = clipSpec != null ? clipSpec.getMinProgress$lottie_compose_release(composition) : 0.0f;
        LottieClipSpec clipSpec2 = getClipSpec();
        float maxProgress$lottie_compose_release = clipSpec2 != null ? clipSpec2.getMaxProgress$lottie_compose_release(composition) : 1.0f;
        float duration = ((lastFrameNanos / ((long) 1000000)) / composition.getDuration()) * getFrameSpeed();
        float progressRaw = getFrameSpeed() < 0.0f ? minProgress$lottie_compose_release - (getProgressRaw() + duration) : (getProgressRaw() + duration) - maxProgress$lottie_compose_release;
        if (minProgress$lottie_compose_release == maxProgress$lottie_compose_release) {
            updateProgress(minProgress$lottie_compose_release);
            return false;
        }
        if (progressRaw < 0.0f) {
            updateProgress(RangesKt.coerceIn(getProgressRaw(), minProgress$lottie_compose_release, maxProgress$lottie_compose_release) + duration);
        } else {
            float f = maxProgress$lottie_compose_release - minProgress$lottie_compose_release;
            int i = (int) (progressRaw / f);
            int i2 = i + 1;
            if (getIteration() + i2 > iterations) {
                updateProgress(getEndProgress());
                setIteration(iterations);
                return false;
            }
            setIteration(getIteration() + i2);
            float f2 = progressRaw - (i * f);
            updateProgress(getFrameSpeed() < 0.0f ? maxProgress$lottie_compose_release - f2 : minProgress$lottie_compose_release + f2);
        }
        return true;
    }

    private final float roundToCompositionFrameRate(float f, LottieComposition lottieComposition) {
        if (lottieComposition == null) {
            return f;
        }
        return f - (f % (1 / lottieComposition.getFrameRate()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress(float progress) {
        setProgressRaw(progress);
        if (getUseCompositionFrameRate()) {
            progress = roundToCompositionFrameRate(progress, getComposition());
        }
        setProgress(progress);
    }
}
