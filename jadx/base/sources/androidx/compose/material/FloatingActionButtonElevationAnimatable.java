package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001a\u00020\u0003*\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Landroidx/compose/material/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "updateElevation", "", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateElevation", TypedValues.TransitionType.S_TO, "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "material"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class FloatingActionButtonElevationAnimatable {
    private final Animatable<C1486Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$animateElevation$1 */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", m1609f = "FloatingActionButton.kt", m1610i = {0}, m1611l = {RendererCapabilities.DECODER_SUPPORT_MASK}, m1612m = "animateElevation", m1613n = {TypedValues.TransitionType.S_TO}, m1615s = {"L$0"}, m1616v = 1)
    static final class C08551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08551(Continuation<? super C08551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.animateElevation(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$snapElevation$1 */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", m1609f = "FloatingActionButton.kt", m1610i = {}, m1611l = {370}, m1612m = "snapElevation", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C08561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08561(Continuation<? super C08561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.snapElevation(this);
        }
    }

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
        this.animatable = new Animatable<>(C1486Dp.m11015boximpl(this.defaultElevation), VectorConvertersKt.getVectorConverter(C1486Dp.INSTANCE), null, null, 12, null);
    }

    /* JADX INFO: renamed from: calculateTarget-u2uoSUM, reason: not valid java name */
    private final float m4289calculateTargetu2uoSUM(Interaction interaction) {
        return interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction.Enter ? this.hoveredElevation : interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
    }

    /* JADX INFO: renamed from: updateElevation-lDy3nrA, reason: not valid java name */
    public final Object m4290updateElevationlDy3nrA(float f, float f2, float f3, float f4, Continuation<? super Unit> continuation) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
        Object objSnapElevation = snapElevation(continuation);
        return objSnapElevation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapElevation : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object snapElevation(Continuation<? super Unit> continuation) {
        C08561 c08561;
        if (continuation instanceof C08561) {
            c08561 = (C08561) continuation;
            if ((c08561.label & Integer.MIN_VALUE) != 0) {
                c08561.label -= Integer.MIN_VALUE;
            } else {
                c08561 = new C08561(continuation);
            }
        }
        Object obj = c08561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08561.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fM4289calculateTargetu2uoSUM = m4289calculateTargetu2uoSUM(this.targetInteraction);
                if (!C1486Dp.m11022equalsimpl0(this.animatable.getTargetValue().m11031unboximpl(), fM4289calculateTargetu2uoSUM)) {
                    Animatable<C1486Dp, AnimationVector1D> animatable = this.animatable;
                    C1486Dp c1486DpM11015boximpl = C1486Dp.m11015boximpl(fM4289calculateTargetu2uoSUM);
                    c08561.label = 1;
                    if (animatable.snapTo(c1486DpM11015boximpl, c08561) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } finally {
            this.lastTargetInteraction = this.targetInteraction;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.foundation.interaction.Interaction, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.foundation.interaction.Interaction] */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.foundation.interaction.Interaction] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateElevation(Interaction interaction, Continuation<? super Unit> continuation) {
        C08551 c08551;
        ?? r6;
        if (continuation instanceof C08551) {
            c08551 = (C08551) continuation;
            if ((c08551.label & Integer.MIN_VALUE) != 0) {
                c08551.label -= Integer.MIN_VALUE;
            } else {
                c08551 = new C08551(continuation);
            }
        }
        Object obj = c08551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08551.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fM4289calculateTargetu2uoSUM = m4289calculateTargetu2uoSUM(interaction);
                this.targetInteraction = interaction;
                r6 = interaction;
                if (!C1486Dp.m11022equalsimpl0(this.animatable.getTargetValue().m11031unboximpl(), fM4289calculateTargetu2uoSUM)) {
                    Animatable<C1486Dp, AnimationVector1D> animatable = this.animatable;
                    Interaction interaction2 = this.lastTargetInteraction;
                    c08551.L$0 = interaction;
                    c08551.label = 1;
                    Object objM4262animateElevationrAjV9yQ = ElevationKt.m4262animateElevationrAjV9yQ(animatable, fM4289calculateTargetu2uoSUM, interaction2, interaction, c08551);
                    r6 = interaction;
                    if (objM4262animateElevationrAjV9yQ == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Interaction interaction3 = (Interaction) c08551.L$0;
                ResultKt.throwOnFailure(obj);
                r6 = interaction3;
            }
            this.lastTargetInteraction = r6;
            interaction = Unit.INSTANCE;
            return interaction;
        } catch (Throwable th) {
            this.lastTargetInteraction = interaction;
            throw th;
        }
    }

    public final State<C1486Dp> asState() {
        return this.animatable.asState();
    }
}
