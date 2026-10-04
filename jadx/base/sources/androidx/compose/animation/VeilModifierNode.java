package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.DrawModifierNode;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010 \u001a\u00020!*\u00020\"H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, m1599d2 = {"Landroidx/compose/animation/VeilModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "veilAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "getVeilAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setVeilAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class VeilModifierNode extends Modifier.Node implements DrawModifierNode {
    private EnterTransition enter;
    private ExitTransition exit;
    private Transition<EnterExitState> transition;
    private Transition<EnterExitState>.DeferredAnimation<Color, AnimationVector4D> veilAnimation;

    public VeilModifierNode(Transition<EnterExitState> transition, Transition<EnterExitState>.DeferredAnimation<Color, AnimationVector4D> deferredAnimation, EnterTransition enterTransition, ExitTransition exitTransition) {
        this.transition = transition;
        this.veilAnimation = deferredAnimation;
        this.enter = enterTransition;
        this.exit = exitTransition;
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition<EnterExitState> transition) {
        this.transition = transition;
    }

    public final Transition<EnterExitState>.DeferredAnimation<Color, AnimationVector4D> getVeilAnimation() {
        return this.veilAnimation;
    }

    public final void setVeilAnimation(Transition<EnterExitState>.DeferredAnimation<Color, AnimationVector4D> deferredAnimation) {
        this.veilAnimation = deferredAnimation;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final void setEnter(EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final void setExit(ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    @Override // androidx.compose.p004ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jM7981getZeroNHjbRc;
        contentDrawScope.drawContent();
        State<Color> stateAnimate = this.veilAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.animation.VeilModifierNode$draw$veilColor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<EnterExitState> segment) {
                FiniteAnimationSpec<Color> animationSpec;
                FiniteAnimationSpec<Color> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Veil veil = this.this$0.getEnter().getData().getVeil();
                    return (veil == null || (animationSpec2 = veil.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultColorAnimationSpec : animationSpec2;
                }
                if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    return EnterExitTransitionKt.DefaultColorAnimationSpec;
                }
                Veil veil2 = this.this$0.getExit().getData().getVeil();
                return (veil2 == null || (animationSpec = veil2.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultColorAnimationSpec : animationSpec;
            }
        }, new Function1<EnterExitState, Color>() { // from class: androidx.compose.animation.VeilModifierNode$draw$veilColor$2

            /* JADX INFO: compiled from: EnterExitTransition.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Color invoke(EnterExitState enterExitState) {
                return Color.m8138boximpl(m1891invokevNxB06k(enterExitState));
            }

            /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
            public final long m1891invokevNxB06k(EnterExitState enterExitState) {
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                if (i == 1) {
                    Veil veil = this.this$0.getEnter().getData().getVeil();
                    if (veil != null) {
                        return veil.m1890getTargetColor0d7_KjU();
                    }
                    Veil veil2 = this.this$0.getExit().getData().getVeil();
                    return veil2 != null ? veil2.m1889getInitialColor0d7_KjU() : Color.INSTANCE.m8183getTransparent0d7_KjU();
                }
                if (i == 2) {
                    Veil veil3 = this.this$0.getEnter().getData().getVeil();
                    return veil3 != null ? veil3.m1889getInitialColor0d7_KjU() : Color.INSTANCE.m8183getTransparent0d7_KjU();
                }
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Veil veil4 = this.this$0.getExit().getData().getVeil();
                return veil4 != null ? veil4.m1890getTargetColor0d7_KjU() : Color.INSTANCE.m8183getTransparent0d7_KjU();
            }
        });
        if (Color.m8150getAlphaimpl(stateAnimate.getValue().m8158unboximpl()) == 0.0f) {
            return;
        }
        Veil veil = this.enter.getData().getVeil();
        if (veil == null) {
            veil = this.exit.getData().getVeil();
        }
        if (veil != null && veil.getMatchParentSize()) {
            LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(this);
            LayoutCoordinates parentLayoutCoordinates = layoutCoordinatesRequireLayoutCoordinates.getParentLayoutCoordinates();
            if (parentLayoutCoordinates == null) {
                jM7981getZeroNHjbRc = Size.INSTANCE.m7981getZeroNHjbRc();
            } else {
                long jMo9633getSizeYbymL2g = parentLayoutCoordinates.mo9633getSizeYbymL2g();
                jM7981getZeroNHjbRc = Size.m7963constructorimpl((((long) Float.floatToRawIntBits((int) (jMo9633getSizeYbymL2g & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (jMo9633getSizeYbymL2g >> 32)) << 32));
            }
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            DrawScope.m8723drawRectnJ9OG0$default(contentDrawScope2, stateAnimate.getValue().m8158unboximpl(), Offset.m7895constructorimpl(LayoutCoordinatesKt.positionInParent(layoutCoordinatesRequireLayoutCoordinates) ^ (-9223372034707292160L)), jM7981getZeroNHjbRc, 0.0f, null, null, 0, 120, null);
            return;
        }
        DrawScope.m8723drawRectnJ9OG0$default(contentDrawScope, stateAnimate.getValue().m8158unboximpl(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
    }
}
