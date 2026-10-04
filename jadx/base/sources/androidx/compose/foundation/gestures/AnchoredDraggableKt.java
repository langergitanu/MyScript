package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.input.pointer.PointerType;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000À\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001ah\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aT\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a`\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aQ\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001626\u0010\u0017\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00150\u0018H\u0086\b\u001a5\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u001f2\u001d\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\"\u001a\u0093\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010/\u001a¡\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u00101\u001a&\u00102\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u0002H\u0086@¢\u0006\u0002\u00104\u001aR\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u00109\u001a\u0002H\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0082@¢\u0006\u0002\u0010:\u001a6\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0086@¢\u0006\u0002\u0010<\u001aN\u0010=\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u0006\u00106\u001a\u00020\u001c2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,H\u0086@¢\u0006\u0002\u0010>\u001a^\u0010?\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010@\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002¢\u0006\u0002\u0010A\u001a\u0014\u0010B\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0002\u001aF\u0010D\u001a\u00020\u0015\"\u0004\b\u0000\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0(2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002HE\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150G\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018H\u0082@¢\u0006\u0002\u0010H\u001a\u0014\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020J\"\u0004\b\u0000\u0010\u0002H\u0002\u001aU\u0010W\u001a\u00020X\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010Y\u001a\u00020Z2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0000\u001aM\u0010[\u001a\u00020\\\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002\u001a\u0017\u0010_\u001a\u00020\u00152\f\u0010`\u001a\b\u0012\u0004\u0012\u00020S0(H\u0082\b\"\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001c0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010M\u001a\u00020NX\u0080\u0004¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010P\"\u000e\u0010R\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, m1599d2 = {"anchoredDraggable", "Landroidx/compose/ui/Modifier;", ExifInterface.GPS_DIRECTION_TRUE, "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "reverseDirection", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "startDragImmediately", "AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "forEach", "", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", SubscriberAttributeKt.JSON_NAME_KEY, "", "position", "DraggableAnchors", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "Lkotlin/ExtensionFunctionType;", "AnchoredDraggableState", "initialValue", "positionalThreshold", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "snapTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "currentOffset", "(Landroidx/compose/foundation/gestures/DraggableAnchors;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "coerceToTarget", TypedValues.AttributesType.S_TARGET, "restartable", "I", Keys.INPUTS, "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "GetOrNan", "", "AnchoredDraggableMinFlingVelocity", "Landroidx/compose/ui/unit/Dp;", "getAnchoredDraggableMinFlingVelocity", "()F", "F", "ConfigurationMovedToModifier", "", "SettleWithVelocityDeprecated", "StartDragImmediatelyDeprecated", "ConfirmValueChangeDeprecated", "anchoredDraggableFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "density", "Landroidx/compose/ui/unit/Density;", "AnchoredDraggableLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "NoOpDecayAnimationSpec", "DEBUG", "debugLog", "generateMsg", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AnchoredDraggableKt {
    private static final String ConfigurationMovedToModifier = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.";
    private static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";
    private static final boolean DEBUG = false;
    private static final String SettleWithVelocityDeprecated = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.";
    private static final String StartDragImmediatelyDeprecated = "startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.";
    private static final Function1<PointerType, Boolean> AlwaysDrag = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(AnchoredDraggableKt.AlwaysDrag$lambda$0((PointerType) obj));
        }
    };
    private static final Function1<Integer, Float> GetOrNan = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Float.valueOf(AnchoredDraggableKt.GetOrNan$lambda$0(((Integer) obj).intValue()));
        }
    };
    private static final float AnchoredDraggableMinFlingVelocity = C1486Dp.m11017constructorimpl(GapComposerKt.nodeKey);
    private static final DecayAnimationSpec<Float> NoOpDecayAnimationSpec = DecayAnimationSpecKt.generateDecayAnimationSpec(new FloatDecayAnimationSpec() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$NoOpDecayAnimationSpec$1
        private final float absVelocityThreshold;

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public long getDurationNanos(float initialValue, float initialVelocity) {
            return 0L;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getTargetValue(float initialValue, float initialVelocity) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getValueFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getVelocityFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getAbsVelocityThreshold() {
            return this.absVelocityThreshold;
        }
    });

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", m1609f = "AnchoredDraggable.kt", m1610i = {0, 0}, m1611l = {1414}, m1612m = "animateToWithDecay", m1613n = {"remainingVelocity", "velocity"}, m1615s = {"L$0", "F$0"}, m1616v = 1)
    static final class C03591<T> extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03591(Continuation<? super C03591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.animateToWithDecay(null, null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {1578}, m1612m = "restartable", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03621<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C03621(Continuation<? super C03621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.restartable(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AlwaysDrag$lambda$0(PointerType pointerType) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AnchoredDraggableState$lambda$0(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AnchoredDraggableState$lambda$2(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float GetOrNan$lambda$0(int i) {
        return Float.NaN;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        boolean z3;
        Orientation orientation2;
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        MutableInteractionSource mutableInteractionSource2 = (i & 16) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 32) != 0 ? null : overscrollEffect;
        if ((i & 64) != 0) {
            flingBehavior2 = null;
            anchoredDraggableState2 = anchoredDraggableState;
            z3 = z;
            orientation2 = orientation;
            modifier2 = modifier;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            z3 = z;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, z3, orientation2, z4, mutableInteractionSource2, overscrollEffect2, flingBehavior2);
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z2, Boolean.valueOf(z), mutableInteractionSource, null, overscrollEffect, flingBehavior, 32, null));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z3, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        boolean z4;
        Orientation orientation2;
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z5 = z2;
        MutableInteractionSource mutableInteractionSource2 = (i & 16) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 32) != 0 ? null : overscrollEffect;
        boolean zIsAnimationRunning = (i & 64) != 0 ? anchoredDraggableState.isAnimationRunning() : z3;
        if ((i & 128) != 0) {
            flingBehavior2 = null;
            modifier2 = modifier;
            z4 = z;
            orientation2 = orientation;
            anchoredDraggableState2 = anchoredDraggableState;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            z4 = z;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, z4, orientation2, z5, mutableInteractionSource2, overscrollEffect2, zIsAnimationRunning, flingBehavior2);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z3, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z2, Boolean.valueOf(z), mutableInteractionSource, Boolean.valueOf(z3), overscrollEffect, flingBehavior));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z, (i & 8) != 0 ? null : mutableInteractionSource, (i & 16) != 0 ? null : overscrollEffect, (i & 32) != 0 ? null : flingBehavior);
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z, null, mutableInteractionSource, null, overscrollEffect, flingBehavior, 32, null));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z2, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        Orientation orientation2;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        MutableInteractionSource mutableInteractionSource2 = (i & 8) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 16) != 0 ? null : overscrollEffect;
        if ((i & 32) != 0) {
            z2 = anchoredDraggableState.isAnimationRunning();
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            flingBehavior2 = null;
            anchoredDraggableState2 = anchoredDraggableState;
            orientation2 = orientation;
            modifier2 = modifier;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, orientation2, z3, mutableInteractionSource2, overscrollEffect2, z4, flingBehavior2);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z2, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z, null, mutableInteractionSource, Boolean.valueOf(z2), overscrollEffect, flingBehavior));
    }

    public static final <T> void forEach(DraggableAnchors<T> draggableAnchors, Function2<? super T, ? super Float, Unit> function2) {
        int size = draggableAnchors.getSize();
        for (int i = 0; i < size; i++) {
            T tAnchorAt = draggableAnchors.anchorAt(i);
            if (tAnchorAt == null) {
                throw new IllegalArgumentException(("There was no key at index " + i + ". Please report a bug.").toString());
            }
            function2.invoke(tAnchorAt, Float.valueOf(draggableAnchors.positionAt(i)));
        }
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new DefaultDraggableAnchors(draggableAnchorsConfig.buildKeys$foundation(), draggableAnchorsConfig.buildPositions$foundation());
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, int i, Object obj2) {
        if ((i & 32) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return Boolean.valueOf(AnchoredDraggableKt.AnchoredDraggableState$lambda$0(obj3));
                }
            };
        }
        return AnchoredDraggableState(obj, function1, function0, animationSpec, decayAnimationSpec, function12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        AnchoredDraggableState<T> anchoredDraggableState = new AnchoredDraggableState<>(t, function12);
        anchoredDraggableState.setPositionalThreshold$foundation(function1);
        anchoredDraggableState.setVelocityThreshold$foundation(function0);
        anchoredDraggableState.setSnapAnimationSpec$foundation(animationSpec);
        anchoredDraggableState.setDecayAnimationSpec$foundation(decayAnimationSpec);
        return anchoredDraggableState;
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, int i, Object obj2) {
        if ((i & 64) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return Boolean.valueOf(AnchoredDraggableKt.AnchoredDraggableState$lambda$2(obj3));
                }
            };
        }
        return AnchoredDraggableState(obj, draggableAnchors, function1, function0, animationSpec, decayAnimationSpec, function12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        AnchoredDraggableState<T> anchoredDraggableState = new AnchoredDraggableState<>(t, draggableAnchors, function12);
        anchoredDraggableState.setPositionalThreshold$foundation(function1);
        anchoredDraggableState.setVelocityThreshold$foundation(function0);
        anchoredDraggableState.setSnapAnimationSpec$foundation(animationSpec);
        anchoredDraggableState.setDecayAnimationSpec$foundation(decayAnimationSpec);
        return anchoredDraggableState;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03642<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C03642(Continuation<? super C03642> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03642 c03642 = new C03642(continuation);
            c03642.L$0 = anchoredDragScope;
            c03642.L$1 = draggableAnchors;
            c03642.L$2 = t;
            return c03642.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            float fPositionOf = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (!Float.isNaN(fPositionOf)) {
                AnchoredDragScope.dragTo$default(anchoredDragScope, fPositionOf, 0.0f, 2, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C03642(null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, float f, final AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objAnimate;
        float fPositionOf = draggableAnchors.positionOf(t);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.isNaN(anchoredDraggableState.getOffset()) ? 0.0f : anchoredDraggableState.getOffset();
        return (Float.isNaN(fPositionOf) || floatRef.element == fPositionOf || (objAnimate = SuspendAnimationKt.animate(floatRef.element, fPositionOf, f, animationSpec, new Function2() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AnchoredDraggableKt.animateTo$lambda$0$1(anchoredDragScope, floatRef, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        }, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objAnimate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateTo$lambda$0$1(AnchoredDragScope anchoredDragScope, Ref.FloatRef floatRef, float f, float f2) {
        anchoredDragScope.dragTo(f, f2);
        floatRef.element = f;
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation()) {
                animationSpec = anchoredDraggableState.getSnapAnimationSpec();
            } else {
                animationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            }
        }
        return animateTo(anchoredDraggableState, obj, animationSpec, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {1378}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03584<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03584(AnchoredDraggableState<T> anchoredDraggableState, AnimationSpec<Float> animationSpec, Continuation<? super C03584> continuation) {
            super(4, continuation);
            this.$this_animateTo = anchoredDraggableState;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03584 c03584 = new C03584(this.$this_animateTo, this.$animationSpec, continuation);
            c03584.L$0 = anchoredDragScope;
            c03584.L$1 = draggableAnchors;
            c03584.L$2 = t;
            return c03584.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                Object obj2 = this.L$2;
                AnchoredDraggableState<T> anchoredDraggableState = this.$this_animateTo;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (AnchoredDraggableKt.animateTo(anchoredDraggableState, anchoredDraggableState.getLastVelocity(), anchoredDragScope, draggableAnchors, obj2, this.$animationSpec, this) == coroutine_suspended) {
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
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C03584(anchoredDraggableState, animationSpec, null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object animateToWithDecay(AnchoredDraggableState<T> anchoredDraggableState, T t, float f, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super Float> continuation) {
        C03591 c03591;
        float f2;
        Ref.FloatRef floatRef;
        if (continuation instanceof C03591) {
            c03591 = (C03591) continuation;
            if ((c03591.label & Integer.MIN_VALUE) != 0) {
                c03591.label -= Integer.MIN_VALUE;
            } else {
                c03591 = new C03591(continuation);
            }
        }
        C03591 c035912 = c03591;
        Object obj = c035912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c035912.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            floatRef2.element = f;
            C03602 c03602 = new C03602(anchoredDraggableState, f, animationSpec, floatRef2, decayAnimationSpec, null);
            c035912.L$0 = floatRef2;
            c035912.F$0 = f;
            c035912.label = 1;
            if (AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, c03602, c035912, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            f2 = f;
            floatRef = floatRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f2 = c035912.F$0;
            floatRef = (Ref.FloatRef) c035912.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxFloat(f2 - floatRef.element);
    }

    public static /* synthetic */ Object animateToWithDecay$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Continuation continuation, int i, Object obj2) {
        DecayAnimationSpec<Float> decayAnimationSpec2;
        if ((i & 4) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation()) {
                animationSpec = anchoredDraggableState.getSnapAnimationSpec();
            } else {
                animationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            }
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 8) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation()) {
                decayAnimationSpec2 = anchoredDraggableState.getDecayAnimationSpec();
            } else {
                decayAnimationSpec2 = AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
            }
            decayAnimationSpec = decayAnimationSpec2;
        }
        return animateToWithDecay(anchoredDraggableState, obj, f, animationSpec2, decayAnimationSpec, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {1425, 1443, 1467}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03602<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
        final /* synthetic */ Ref.FloatRef $remainingVelocity;
        final /* synthetic */ AnimationSpec<Float> $snapAnimationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03602(AnchoredDraggableState<T> anchoredDraggableState, float f, AnimationSpec<Float> animationSpec, Ref.FloatRef floatRef, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super C03602> continuation) {
            super(4, continuation);
            this.$this_animateToWithDecay = anchoredDraggableState;
            this.$velocity = f;
            this.$snapAnimationSpec = animationSpec;
            this.$remainingVelocity = floatRef;
            this.$decayAnimationSpec = decayAnimationSpec;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03602 c03602 = new C03602(this.$this_animateToWithDecay, this.$velocity, this.$snapAnimationSpec, this.$remainingVelocity, this.$decayAnimationSpec, continuation);
            c03602.L$0 = anchoredDragScope;
            c03602.L$1 = draggableAnchors;
            c03602.L$2 = t;
            return c03602.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
        
            if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r22, r3, false, new androidx.compose.foundation.gestures.C0361xff5bb877(r2, r7, r9, r5), r29, 2, null) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00db, code lost:
        
            if (androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r29.$this_animateToWithDecay, r8, r9, r10, r11, r29.$snapAnimationSpec, r29) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:
        
            if (androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r29.$this_animateToWithDecay, r29.$velocity, r9, r10, r11, r29.$snapAnimationSpec, r29) == r1) goto L42;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                Object obj2 = this.L$2;
                final float fPositionOf = draggableAnchors.positionOf(obj2);
                if (!Float.isNaN(fPositionOf)) {
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = Float.isNaN(this.$this_animateToWithDecay.getOffset()) ? 0.0f : this.$this_animateToWithDecay.getOffset();
                    if (floatRef.element != fPositionOf) {
                        if (this.$velocity * (fPositionOf - floatRef.element) < 0.0f || this.$velocity == 0.0f) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 1;
                        } else {
                            float fCalculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, floatRef.element, this.$velocity);
                            float f = this.$velocity;
                            if (f <= 0.0f ? fCalculateTargetValue > fPositionOf : fCalculateTargetValue < fPositionOf) {
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 3;
                            } else {
                                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(floatRef.element, this.$velocity, 0L, 0L, false, 28, null);
                                DecayAnimationSpec<Float> decayAnimationSpec = this.$decayAnimationSpec;
                                final Ref.FloatRef floatRef2 = this.$remainingVelocity;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 2;
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.$remainingVelocity.element = 0.0f;
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$remainingVelocity.element = 0.0f;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(float f, Ref.FloatRef floatRef, AnchoredDragScope anchoredDragScope, Ref.FloatRef floatRef2, AnimationScope animationScope) {
            if ((((Number) animationScope.getValue()).floatValue() < f && floatRef.element > f) || (((Number) animationScope.getValue()).floatValue() > f && floatRef.element < f)) {
                float fCoerceToTarget = AnchoredDraggableKt.coerceToTarget(((Number) animationScope.getValue()).floatValue(), f);
                anchoredDragScope.dragTo(fCoerceToTarget, ((Number) animationScope.getVelocity()).floatValue());
                floatRef2.element = Float.isNaN(((Number) animationScope.getVelocity()).floatValue()) ? 0.0f : ((Number) animationScope.getVelocity()).floatValue();
                floatRef.element = fCoerceToTarget;
                animationScope.cancelAnimation();
            } else {
                anchoredDragScope.dragTo(((Number) animationScope.getValue()).floatValue(), ((Number) animationScope.getVelocity()).floatValue());
                floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
                floatRef.element = ((Number) animationScope.getValue()).floatValue();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T computeTarget(DraggableAnchors<T> draggableAnchors, float f, float f2, Function1<? super Float, Float> function1, Function0<Float> function0) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("The offset provided to computeTarget must not be NaN.".toString());
        }
        boolean z = Math.abs(f2) > 0.0f;
        boolean z2 = z && f2 > 0.0f;
        if (!z) {
            T tClosestAnchor = draggableAnchors.closestAnchor(f);
            Intrinsics.checkNotNull(tClosestAnchor);
            return tClosestAnchor;
        }
        if (Math.abs(f2) >= Math.abs(function0.invoke().floatValue())) {
            T tClosestAnchor2 = draggableAnchors.closestAnchor(f, z2);
            Intrinsics.checkNotNull(tClosestAnchor2);
            return tClosestAnchor2;
        }
        T tClosestAnchor3 = draggableAnchors.closestAnchor(f, false);
        Intrinsics.checkNotNull(tClosestAnchor3);
        float fPositionOf = draggableAnchors.positionOf(tClosestAnchor3);
        T tClosestAnchor4 = draggableAnchors.closestAnchor(f, true);
        Intrinsics.checkNotNull(tClosestAnchor4);
        float fPositionOf2 = draggableAnchors.positionOf(tClosestAnchor4);
        float fAbs = Math.abs(function1.invoke(Float.valueOf(Math.abs(fPositionOf - fPositionOf2))).floatValue());
        if (!z2) {
            fPositionOf = fPositionOf2;
        }
        boolean z3 = Math.abs(fPositionOf - f) >= fAbs;
        if (z3) {
            return z2 ? tClosestAnchor4 : tClosestAnchor3;
        }
        if (z3) {
            throw new NoWhenBranchMatchedException();
        }
        if (z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <I> Object restartable(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C03621 c03621;
        if (continuation instanceof C03621) {
            c03621 = (C03621) continuation;
            if ((c03621.label & Integer.MIN_VALUE) != 0) {
                c03621.label -= Integer.MIN_VALUE;
            } else {
                c03621 = new C03621(continuation);
            }
        }
        Object obj = c03621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03621.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C03632 c03632 = new C03632(function0, function2, null);
                c03621.label = 1;
                if (CoroutineScopeKt.coroutineScope(c03632, c03621) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (AnchoredDragFinishedSignal unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {1580}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03632(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03632> continuation) {
            super(2, continuation);
            this.$inputs = function0;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03632 c03632 = new C03632(this.$inputs, this.$block, continuation);
            c03632.L$0 = obj;
            return c03632;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                this.label = 1;
                if (SnapshotStateKt.snapshotFlow(this.$inputs).collect(new AnonymousClass1(objectRef, coroutineScope, this.$block), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
                this.$previousDrag = objectRef;
                this.$$this$coroutineScope = coroutineScope;
                this.$block = function2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(I i, Continuation<? super Unit> continuation) {
                AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
                Object obj;
                if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                    anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                    if ((anchoredDraggableKt$restartable$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        anchoredDraggableKt$restartable$2$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                    }
                }
                Object obj2 = anchoredDraggableKt$restartable$2$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Job job = this.$previousDrag.element;
                    obj = i;
                    if (job != null) {
                        job.cancel((CancellationException) new AnchoredDragFinishedSignal());
                        anchoredDraggableKt$restartable$2$1$emit$1.L$0 = i;
                        anchoredDraggableKt$restartable$2$1$emit$1.L$1 = job;
                        anchoredDraggableKt$restartable$2$1$emit$1.label = 1;
                        obj = i;
                        if (job.join(anchoredDraggableKt$restartable$2$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj3 = anchoredDraggableKt$restartable$2$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj3;
                }
                this.$previousDrag.element = (T) BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$block, obj, this.$$this$coroutineScope, null), 1, null);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: AnchoredDraggable.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", m1609f = "AnchoredDraggable.kt", m1610i = {}, m1611l = {1587}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$block = function2;
                    this.$latestInputs = i;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                        I i2 = this.$latestInputs;
                        this.label = 1;
                        if (function2.invoke(i2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> DefaultDraggableAnchors<T> emptyDraggableAnchors() {
        return new DefaultDraggableAnchors<>(CollectionsKt.emptyList(), new float[0]);
    }

    public static final float getAnchoredDraggableMinFlingVelocity() {
        return AnchoredDraggableMinFlingVelocity;
    }

    public static final <T> TargetedFlingBehavior anchoredDraggableFlingBehavior(AnchoredDraggableState<T> anchoredDraggableState, final Density density, Function1<? super Float, Float> function1, AnimationSpec<Float> animationSpec) {
        return SnapFlingBehaviorKt.snapFlingBehavior(AnchoredDraggableLayoutInfoProvider(anchoredDraggableState, function1, new Function0() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(AnchoredDraggableKt.anchoredDraggableFlingBehavior$lambda$0(density));
            }
        }), NoOpDecayAnimationSpec, animationSpec);
    }

    private static final <T> SnapLayoutInfoProvider AnchoredDraggableLayoutInfoProvider(final AnchoredDraggableState<T> anchoredDraggableState, final Function1<? super Float, Float> function1, final Function0<Float> function0) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt.AnchoredDraggableLayoutInfoProvider.1
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                float fRequireOffset = anchoredDraggableState.requireOffset();
                Object objComputeTarget = AnchoredDraggableKt.computeTarget(anchoredDraggableState.getAnchors(), fRequireOffset, velocity, function1, function0);
                if (!((Boolean) anchoredDraggableState.getConfirmValueChange$foundation().invoke(objComputeTarget)).booleanValue()) {
                    objComputeTarget = anchoredDraggableState.getSettledValue();
                }
                return anchoredDraggableState.getAnchors().positionOf(objComputeTarget) - fRequireOffset;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableFlingBehavior$lambda$0(Density density) {
        return density.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(GapComposerKt.nodeKey));
    }
}
