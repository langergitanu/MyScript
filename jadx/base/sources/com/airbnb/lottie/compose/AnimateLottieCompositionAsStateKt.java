package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.container.MdtaMetadataEntry;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: animateLottieCompositionAsState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001as\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0005X\u008a\u008e\u0002"}, m1599d2 = {"animateLottieCompositionAsState", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "isPlaying", "", "restartOnPlay", "reverseOnRepeat", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "", "iterations", "", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimatorScale", "useCompositionFrameRate", "(Lcom/airbnb/lottie/LottieComposition;ZZZLcom/airbnb/lottie/compose/LottieClipSpec;FILcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLandroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieAnimationState;", "lottie-compose_release", "wasPlaying"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class AnimateLottieCompositionAsStateKt {
    public static final LottieAnimationState animateLottieCompositionAsState(LottieComposition lottieComposition, boolean z, boolean z2, boolean z3, LottieClipSpec lottieClipSpec, float f, int i, LottieCancellationBehavior lottieCancellationBehavior, boolean z4, boolean z5, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(683659508);
        boolean z6 = (i3 & 2) != 0 ? true : z;
        boolean z7 = (i3 & 4) != 0 ? true : z2;
        boolean z8 = (i3 & 8) != 0 ? false : z3;
        LottieClipSpec lottieClipSpec2 = (i3 & 16) != 0 ? null : lottieClipSpec;
        float animationScale = (i3 & 32) != 0 ? 1.0f : f;
        int i4 = (i3 & 64) != 0 ? 1 : i;
        LottieCancellationBehavior lottieCancellationBehavior2 = (i3 & 128) != 0 ? LottieCancellationBehavior.Immediately : lottieCancellationBehavior;
        boolean z9 = (i3 & 256) != 0 ? false : z4;
        boolean z10 = (i3 & 512) != 0 ? false : z5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(683659508, i2, -1, "com.airbnb.lottie.compose.animateLottieCompositionAsState (animateLottieCompositionAsState.kt:54)");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException(("Iterations must be a positive number (" + i4 + ").").toString());
        }
        if (Float.isInfinite(animationScale) || Float.isNaN(animationScale)) {
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + animationScale + ".").toString());
        }
        LottieAnimatable lottieAnimatableRememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(composer, 0);
        composer.startReplaceableGroup(-180606964);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z6), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-180606834);
        if (!z9) {
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            animationScale /= Utils.getAnimationScale((Context) objConsume);
        }
        float f2 = animationScale;
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(new Object[]{lottieComposition, Boolean.valueOf(z6), lottieClipSpec2, Float.valueOf(f2), Integer.valueOf(i4)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new C38603(z6, z7, lottieAnimatableRememberLottieAnimatable, lottieComposition, i4, z8, f2, lottieClipSpec2, lottieCancellationBehavior2, z10, mutableState, null), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lottieAnimatableRememberLottieAnimatable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean animateLottieCompositionAsState$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateLottieCompositionAsState$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3 */
    /* JADX INFO: compiled from: animateLottieCompositionAsState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3", m1609f = "animateLottieCompositionAsState.kt", m1610i = {}, m1611l = {73, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38603 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $actualSpeed;
        final /* synthetic */ LottieAnimatable $animatable;
        final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
        final /* synthetic */ LottieClipSpec $clipSpec;
        final /* synthetic */ LottieComposition $composition;
        final /* synthetic */ boolean $isPlaying;
        final /* synthetic */ int $iterations;
        final /* synthetic */ boolean $restartOnPlay;
        final /* synthetic */ boolean $reverseOnRepeat;
        final /* synthetic */ boolean $useCompositionFrameRate;
        final /* synthetic */ MutableState<Boolean> $wasPlaying$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38603(boolean z, boolean z2, LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int i, boolean z3, float f, LottieClipSpec lottieClipSpec, LottieCancellationBehavior lottieCancellationBehavior, boolean z4, MutableState<Boolean> mutableState, Continuation<? super C38603> continuation) {
            super(2, continuation);
            this.$isPlaying = z;
            this.$restartOnPlay = z2;
            this.$animatable = lottieAnimatable;
            this.$composition = lottieComposition;
            this.$iterations = i;
            this.$reverseOnRepeat = z3;
            this.$actualSpeed = f;
            this.$clipSpec = lottieClipSpec;
            this.$cancellationBehavior = lottieCancellationBehavior;
            this.$useCompositionFrameRate = z4;
            this.$wasPlaying$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38603(this.$isPlaying, this.$restartOnPlay, this.$animatable, this.$composition, this.$iterations, this.$reverseOnRepeat, this.$actualSpeed, this.$clipSpec, this.$cancellationBehavior, this.$useCompositionFrameRate, this.$wasPlaying$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38603) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        
            if (com.airbnb.lottie.compose.LottieAnimatable.DefaultImpls.animate$default(r2, r17.$composition, 0, r17.$iterations, r17.$reverseOnRepeat, r17.$actualSpeed, r17.$clipSpec, r2.getProgress(), false, r17.$cancellationBehavior, false, r17.$useCompositionFrameRate, r17, 514, null) == r1) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$isPlaying && !AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState$lambda$3(this.$wasPlaying$delegate) && this.$restartOnPlay) {
                    this.label = 1;
                    if (LottieAnimatableKt.resetToBeginning(this.$animatable, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState$lambda$4(this.$wasPlaying$delegate, this.$isPlaying);
            if (!this.$isPlaying) {
                return Unit.INSTANCE;
            }
            LottieAnimatable lottieAnimatable = this.$animatable;
            this.label = 2;
        }
    }
}
