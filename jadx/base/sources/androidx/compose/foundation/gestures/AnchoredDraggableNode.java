package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.p004ui.unit.VelocityKt;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002JM\u0010#\u001a\u00020\u001e2=\u0010$\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001e0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0+\u0012\u0006\u0012\u0004\u0018\u00010,0%H\u0096@¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0082@¢\u0006\u0002\u00109J\b\u0010\u000e\u001a\u00020\bH\u0016J[\u0010:\u001a\u00020\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0013\u0010;\u001a\u000200*\u000207H\u0002¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\u00020?*\u000207H\u0002¢\u0006\u0004\b@\u0010=J\u0013\u0010A\u001a\u000207*\u00020?H\u0002¢\u0006\u0004\bB\u0010CJ\u0013\u0010A\u001a\u000207*\u000200H\u0002¢\u0006\u0004\bD\u0010CJ\u0013\u0010E\u001a\u00020?*\u00020?H\u0002¢\u0006\u0004\bF\u0010GJ\u0013\u0010E\u001a\u000200*\u000200H\u0002¢\u0006\u0004\bH\u0010GR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006I"}, m1599d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Ljava/lang/Boolean;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "resolvedFlingBehavior", "getResolvedFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setResolvedFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "density", "Landroidx/compose/ui/unit/Density;", "isReverseDirection", "()Z", "onAttach", "", "onDensityChange", "updateDensity", "updateFlingBehavior", "newFlingBehavior", "drag", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "fling", "", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat", "toFloat-TH1AsA0", "(J)F", "toFloat-k-4lQ0M", "reverseIfNeeded", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Density density;
    private FlingBehavior flingBehavior;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    public FlingBehavior resolvedFlingBehavior;
    private Boolean reverseDirection;
    private Boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableNode", m1609f = "AnchoredDraggable.kt", m1610i = {1}, m1611l = {459, 462}, m1612m = "fling", m1613n = {"leftoverVelocity"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C03661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03661(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C03661> continuation) {
            super(continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fling(0.0f, this);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo2212onDragStartedk4lQ0M(long startedPosition) {
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, Boolean bool2, FlingBehavior flingBehavior) {
        super(AnchoredDraggableKt.AlwaysDrag, z, mutableInteractionSource, orientation);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = bool;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = bool2;
        this.flingBehavior = flingBehavior;
    }

    public final FlingBehavior getResolvedFlingBehavior() {
        FlingBehavior flingBehavior = this.resolvedFlingBehavior;
        if (flingBehavior != null) {
            return flingBehavior;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
        return null;
    }

    public final void setResolvedFlingBehavior(FlingBehavior flingBehavior) {
        this.resolvedFlingBehavior = flingBehavior;
    }

    private final boolean isReverseDirection() {
        Boolean bool = this.reverseDirection;
        if (bool == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateFlingBehavior(this.flingBehavior);
    }

    @Override // androidx.compose.p004ui.node.DelegatableNode, androidx.compose.p004ui.node.PointerInputModifierNode
    public void onDensityChange() {
        onCancelPointerInput();
        if (getIsAttached()) {
            updateDensity();
        }
    }

    private final void updateDensity() {
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        Density density = this.density;
        if (density == null || !Intrinsics.areEqual(density, densityRequireDensity)) {
            this.density = densityRequireDensity;
            updateFlingBehavior(this.flingBehavior);
        }
    }

    private final void updateFlingBehavior(FlingBehavior newFlingBehavior) {
        if (newFlingBehavior == null) {
            AnimationSpec<Float> snapAnimationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            Function1<Float, Float> positionalThreshold = AnchoredDraggableDefaults.INSTANCE.getPositionalThreshold();
            Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            this.density = densityRequireDensity;
            newFlingBehavior = AnchoredDraggableKt.anchoredDraggableFlingBehavior(this.state, densityRequireDensity, positionalThreshold, snapAnimationSpec);
        }
        setResolvedFlingBehavior(newFlingBehavior);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {412}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03652 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03652(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C03652> continuation) {
            super(3, continuation);
            this.$forEachDelta = function2;
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            C03652 c03652 = new C03652(this.$forEachDelta, this.this$0, continuation);
            c03652.L$0 = anchoredDragScope;
            return c03652.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                Function1<? super DragEvent.DragDelta, Unit> function1 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AnchoredDraggableNode.C03652.invokeSuspend$lambda$0(anchoredDraggableNode, anchoredDragScope, (DragEvent.DragDelta) obj2);
                    }
                };
                this.label = 1;
                if (function2.invoke(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(final AnchoredDraggableNode anchoredDraggableNode, final AnchoredDragScope anchoredDragScope, DragEvent.DragDelta dragDelta) {
            float fM2209toFloatk4lQ0M = anchoredDraggableNode.m2209toFloatk4lQ0M(anchoredDraggableNode.m2207reverseIfNeededMKHz9U(dragDelta.getDelta()));
            if (anchoredDraggableNode.overscrollEffect == null) {
                AnchoredDragScope.dragTo$default(anchoredDragScope, anchoredDraggableNode.state.newOffsetForDelta$foundation(fM2209toFloatk4lQ0M), 0.0f, 2, null);
            } else {
                OverscrollEffect overscrollEffect = anchoredDraggableNode.overscrollEffect;
                Intrinsics.checkNotNull(overscrollEffect);
                Offset.m7892boximpl(overscrollEffect.mo1992applyToScrollRhakbz0(anchoredDraggableNode.m2210toOffsettuRUvjQ(fM2209toFloatk4lQ0M), NestedScrollSource.INSTANCE.m9361getUserInputWNlRxjI(), new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AnchoredDraggableNode.C03652.invokeSuspend$lambda$0$0(anchoredDraggableNode, anchoredDragScope, (Offset) obj);
                    }
                }));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Offset invokeSuspend$lambda$0$0(AnchoredDraggableNode anchoredDraggableNode, AnchoredDragScope anchoredDragScope, Offset offset) {
            float fNewOffsetForDelta$foundation = anchoredDraggableNode.state.newOffsetForDelta$foundation(anchoredDraggableNode.m2209toFloatk4lQ0M(offset.m7913unboximpl()));
            long jM2210toOffsettuRUvjQ = anchoredDraggableNode.m2210toOffsettuRUvjQ(fNewOffsetForDelta$foundation - anchoredDraggableNode.state.requireOffset());
            AnchoredDragScope.dragTo$default(anchoredDragScope, fNewOffsetForDelta$foundation, 0.0f, 2, null);
            return Offset.m7892boximpl(jM2210toOffsettuRUvjQ);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, null, new C03652(function2, this, null), continuation, 1, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {438, 440}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DragEvent.DragStopped $event;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03681(AnchoredDraggableNode<T> anchoredDraggableNode, DragEvent.DragStopped dragStopped, Continuation<? super C03681> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
            this.$event = dragStopped;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03681(this.this$0, this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        
            if (r7.this$0.fling(r8, r7) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        
            if (r1.mo1991applyToFlingBMRW4eQ(r7.this$0.m2211toVelocityadjELrA(r8), new androidx.compose.foundation.gestures.AnchoredDraggableNode.C03681.AnonymousClass1(r7.this$0, null), r7) == r0) goto L17;
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
                AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                float fM2208toFloatTH1AsA0 = anchoredDraggableNode.m2208toFloatTH1AsA0(anchoredDraggableNode.m2206reverseIfNeededAH228Gc(this.$event.getVelocity()));
                if (((AnchoredDraggableNode) this.this$0).overscrollEffect == null) {
                    this.label = 1;
                } else {
                    OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
                    Intrinsics.checkNotNull(overscrollEffect);
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "availableVelocity"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", m1609f = "AnchoredDraggable.kt", m1610i = {0}, m1611l = {442}, m1612m = "invokeSuspend", m1613n = {"availableVelocity"}, m1615s = {"J$0"}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
            /* synthetic */ long J$0;
            int label;
            final /* synthetic */ AnchoredDraggableNode<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = anchoredDraggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.J$0 = ((Velocity) obj).getPackedValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
                return m2215invokesFctU(velocity.getPackedValue(), continuation);
            }

            /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
            public final Object m2215invokesFctU(long j, Continuation<? super Velocity> continuation) {
                return ((AnonymousClass1) create(Velocity.m11246boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                long jM2211toVelocityadjELrA;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.J$0;
                    AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                    this.J$0 = j;
                    this.label = 1;
                    obj = anchoredDraggableNode.fling(anchoredDraggableNode.m2208toFloatTH1AsA0(j), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jM2211toVelocityadjELrA = j;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jM2211toVelocityadjELrA = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                float fFloatValue = ((Number) obj).floatValue();
                float fRequireOffset = ((AnchoredDraggableNode) this.this$0).state.requireOffset();
                float fMinPosition = ((AnchoredDraggableNode) this.this$0).state.getAnchors().minPosition();
                if (fRequireOffset >= ((AnchoredDraggableNode) this.this$0).state.getAnchors().maxPosition() || fRequireOffset <= fMinPosition) {
                    jM2211toVelocityadjELrA = this.this$0.m2211toVelocityadjELrA(fFloatValue);
                }
                return Velocity.m11246boximpl(jM2211toVelocityadjELrA);
            }
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped(DragEvent.DragStopped event) {
        if (getIsAttached()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03681(this, event, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fling(float f, Continuation<? super Float> continuation) {
        C03661 c03661;
        Ref.FloatRef floatRef;
        if (continuation instanceof C03661) {
            c03661 = (C03661) continuation;
            if ((c03661.label & Integer.MIN_VALUE) != 0) {
                c03661.label -= Integer.MIN_VALUE;
            } else {
                c03661 = new C03661(this, continuation);
            }
        }
        C03661 c036612 = c03661;
        Object obj = c036612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c036612.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.state.getUsePreModifierChangeBehavior$foundation()) {
                AnchoredDraggableState<T> anchoredDraggableState = this.state;
                c036612.label = 1;
                Object obj2 = anchoredDraggableState.settle(f, c036612);
                if (obj2 != coroutine_suspended) {
                    return obj2;
                }
            } else {
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.element = f;
                AnchoredDraggableState<T> anchoredDraggableState2 = this.state;
                C03672 c03672 = new C03672(this, floatRef2, f, null);
                c036612.L$0 = floatRef2;
                c036612.label = 2;
                if (AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState2, null, c03672, c036612, 1, null) != coroutine_suspended) {
                    floatRef = floatRef2;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        floatRef = (Ref.FloatRef) c036612.L$0;
        ResultKt.throwOnFailure(obj);
        return Boxing.boxFloat(floatRef.element);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {473}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03672 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $leftoverVelocity;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03672(AnchoredDraggableNode<T> anchoredDraggableNode, Ref.FloatRef floatRef, float f, Continuation<? super C03672> continuation) {
            super(3, continuation);
            this.this$0 = anchoredDraggableNode;
            this.$leftoverVelocity = floatRef;
            this.$velocity = f;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            C03672 c03672 = new C03672(this.this$0, this.$leftoverVelocity, this.$velocity, continuation);
            c03672.L$0 = anchoredDragScope;
            return c03672.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.FloatRef floatRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2$scrollScope$1
                    @Override // androidx.compose.foundation.gestures.ScrollScope
                    public float scrollBy(float pixels) {
                        float fNewOffsetForDelta$foundation = ((AnchoredDraggableNode) anchoredDraggableNode).state.newOffsetForDelta$foundation(pixels);
                        float offset = fNewOffsetForDelta$foundation - ((AnchoredDraggableNode) anchoredDraggableNode).state.getOffset();
                        AnchoredDragScope.dragTo$default(anchoredDragScope, fNewOffsetForDelta$foundation, 0.0f, 2, null);
                        return offset;
                    }
                };
                FlingBehavior resolvedFlingBehavior = this.this$0.getResolvedFlingBehavior();
                Ref.FloatRef floatRef2 = this.$leftoverVelocity;
                float f = this.$velocity;
                this.L$0 = floatRef2;
                this.label = 1;
                obj = resolvedFlingBehavior.performFling(scrollScope, f, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                floatRef = floatRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                floatRef = (Ref.FloatRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            floatRef.element = ((Number) obj).floatValue();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        Boolean bool = this.startDragImmediately;
        return bool != null ? bool.booleanValue() : this.state.isAnimationRunning();
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, Boolean startDragImmediately, FlingBehavior flingBehavior) {
        boolean z;
        this.flingBehavior = flingBehavior;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.state, state)) {
            z = false;
        } else {
            this.state = state;
            updateFlingBehavior(flingBehavior);
            z = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (Intrinsics.areEqual(this.reverseDirection, reverseDirection)) {
            z2 = z;
        } else {
            this.reverseDirection = reverseDirection;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default(this, null, enabled, interactionSource, orientation, z2, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m2210toOffsettuRUvjQ(float f) {
        float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m2211toVelocityadjELrA(float f) {
        float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return VelocityKt.Velocity(f2, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m2208toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Vertical ? Velocity.m11256getYimpl(j) : Velocity.m11255getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m2209toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Vertical ? j & 4294967295L : j >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m2206reverseIfNeededAH228Gc(long j) {
        return Velocity.m11261timesadjELrA(j, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m2207reverseIfNeededMKHz9U(long j) {
        return Offset.m7910timestuRUvjQ(j, isReverseDirection() ? -1.0f : 1.0f);
    }
}
