package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.p004ui.draw.CacheDrawModifierNode;
import androidx.compose.p004ui.draw.CacheDrawScope;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.draw.DrawResult;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.OutlineKt;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p004ui.node.DelegatingNode;
import androidx.compose.p004ui.unit.C1486Dp;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\b\u0010,\u001a\u00020&H\u0016J\u000e\u0010-\u001a\u00020&H\u0082@¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, m1599d2 = {"Landroidx/compose/material3/IndicatorLineNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "textFieldShape", "Landroidx/compose/ui/graphics/Shape;", "focusedIndicatorWidth", "Landroidx/compose/ui/unit/Dp;", "unfocusedIndicatorWidth", "<init>", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "focused", "trackFocusStateJob", "Lkotlinx/coroutines/Job;", "_colors", "getColors", "()Landroidx/compose/material3/TextFieldColors;", "colorAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "value", "_shape", "set_shape", "(Landroidx/compose/ui/graphics/Shape;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "widthAnimatable", "Landroidx/compose/animation/core/AnimationVector1D;", "update", "", "update-gv0btCI", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onAttach", "trackFocusState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateIndicator", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class IndicatorLineNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private TextFieldColors _colors;
    private Shape _shape;
    private Animatable<Color, AnimationVector4D> colorAnimatable;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private boolean enabled;
    private boolean focused;
    private float focusedIndicatorWidth;
    private InteractionSource interactionSource;
    private boolean isError;
    private Job trackFocusStateJob;
    private float unfocusedIndicatorWidth;
    private final Animatable<C1486Dp, AnimationVector1D> widthAnimatable;

    public /* synthetic */ IndicatorLineNode(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, interactionSource, textFieldColors, shape, f, f2);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    private IndicatorLineNode(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2) {
        this.enabled = z;
        this.isError = z2;
        this.interactionSource = interactionSource;
        this.focusedIndicatorWidth = f;
        this.unfocusedIndicatorWidth = f2;
        this._colors = textFieldColors;
        this._shape = shape;
        this.widthAnimatable = new Animatable<>(C1486Dp.m11015boximpl((this.focused && this.enabled) ? this.focusedIndicatorWidth : this.unfocusedIndicatorWidth), VectorConvertersKt.getVectorConverter(C1486Dp.INSTANCE), null, null, 12, null);
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.IndicatorLineNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndicatorLineNode.drawWithCacheModifierNode$lambda$3(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextFieldColors getColors() {
        TextFieldColors textFieldColors = this._colors;
        if (textFieldColors != null) {
            return textFieldColors;
        }
        IndicatorLineNode indicatorLineNode = this;
        return TextFieldDefaults.INSTANCE.defaultTextFieldColors$material3((ColorScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(indicatorLineNode, ColorSchemeKt.getLocalColorScheme()), (TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(indicatorLineNode, TextSelectionColorsKt.getLocalTextSelectionColors()));
    }

    private final void set_shape(Shape shape) {
        if (Intrinsics.areEqual(this._shape, shape)) {
            return;
        }
        this._shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    private final Shape getShape() {
        Shape shape = this._shape;
        return shape == null ? ShapesKt.fromToken((Shapes) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, ShapesKt.getLocalShapes()), FilledTextFieldTokens.INSTANCE.getContainerShape()) : shape;
    }

    /* JADX INFO: renamed from: update-gv0btCI, reason: not valid java name */
    public final void m5181updategv0btCI(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, Shape textFieldShape, float focusedIndicatorWidth, float unfocusedIndicatorWidth) {
        boolean z;
        boolean z2 = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            z = true;
        } else {
            z = false;
        }
        if (this.isError != isError) {
            this.isError = isError;
            z = true;
        }
        if (this.interactionSource != interactionSource) {
            this.interactionSource = interactionSource;
            Job job = this.trackFocusStateJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.trackFocusStateJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, null), 3, null);
        }
        if (!Intrinsics.areEqual(this._colors, colors)) {
            this._colors = colors;
            z = true;
        }
        if (!Intrinsics.areEqual(this._shape, textFieldShape)) {
            set_shape(textFieldShape);
            z = true;
        }
        if (!C1486Dp.m11022equalsimpl0(this.focusedIndicatorWidth, focusedIndicatorWidth)) {
            this.focusedIndicatorWidth = focusedIndicatorWidth;
            z = true;
        }
        if (C1486Dp.m11022equalsimpl0(this.unfocusedIndicatorWidth, unfocusedIndicatorWidth)) {
            z2 = z;
        } else {
            this.unfocusedIndicatorWidth = unfocusedIndicatorWidth;
        }
        if (z2) {
            invalidateIndicator();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$onAttach$1 */
    /* JADX INFO: compiled from: TextField.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material3.IndicatorLineNode$onAttach$1", m1609f = "TextField.kt", m1610i = {}, m1611l = {1569}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C10251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10251(Continuation<? super C10251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IndicatorLineNode.this.new C10251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (IndicatorLineNode.this.trackFocusState(this) == coroutine_suspended) {
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

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.trackFocusStateJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C10251(null), 3, null);
        if (this.colorAnimatable == null) {
            long jM5819indicatorColorXeAY9LY$material3 = getColors().m5819indicatorColorXeAY9LY$material3(this.enabled, this.isError, this.focused);
            this.colorAnimatable = new Animatable<>(Color.m8138boximpl(jM5819indicatorColorXeAY9LY$material3), ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m8152getColorSpaceimpl(jM5819indicatorColorXeAY9LY$material3)), null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object trackFocusState(Continuation<? super Unit> continuation) {
        this.focused = false;
        final ArrayList arrayList = new ArrayList();
        Object objCollect = this.interactionSource.getInteractions().collect(new FlowCollector() { // from class: androidx.compose.material3.IndicatorLineNode.trackFocusState.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Interaction) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Interaction interaction, Continuation<? super Unit> continuation2) {
                if (interaction instanceof FocusInteraction.Focus) {
                    arrayList.add(interaction);
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    arrayList.remove(((FocusInteraction.Unfocus) interaction).getFocus());
                }
                boolean z = !arrayList.isEmpty();
                if (z != this.focused) {
                    this.focused = z;
                    this.invalidateIndicator();
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$invalidateIndicator$1 */
    /* JADX INFO: compiled from: TextField.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material3.IndicatorLineNode$invalidateIndicator$1", m1609f = "TextField.kt", m1610i = {}, m1611l = {1599}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C10231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10231(Continuation<? super C10231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IndicatorLineNode.this.new C10231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SnapSpec snapSpecSnap$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = IndicatorLineNode.this.colorAnimatable;
                if (animatable != null) {
                    Color colorM8138boximpl = Color.m8138boximpl(IndicatorLineNode.this.getColors().m5819indicatorColorXeAY9LY$material3(IndicatorLineNode.this.enabled, IndicatorLineNode.this.isError, IndicatorLineNode.this.focused));
                    if (IndicatorLineNode.this.enabled) {
                        snapSpecSnap$default = MotionSchemeKt.fromToken((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(IndicatorLineNode.this, MaterialTheme.INSTANCE.getLocalMotionScheme$material3()), MotionSchemeKeyTokens.FastEffects);
                    } else {
                        snapSpecSnap$default = AnimationSpecKt.snap$default(0, 1, null);
                    }
                    this.label = 1;
                    obj = Animatable.animateTo$default(animatable, colorM8138boximpl, snapSpecSnap$default, null, null, this, 12, null);
                    if (obj == coroutine_suspended) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateIndicator() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C10231(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C10242(null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$invalidateIndicator$2 */
    /* JADX INFO: compiled from: TextField.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material3.IndicatorLineNode$invalidateIndicator$2", m1609f = "TextField.kt", m1610i = {}, m1611l = {1611}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C10242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10242(Continuation<? super C10242> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IndicatorLineNode.this.new C10242(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SnapSpec snapSpecSnap$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = IndicatorLineNode.this.widthAnimatable;
                C1486Dp c1486DpM11015boximpl = C1486Dp.m11015boximpl((IndicatorLineNode.this.focused && IndicatorLineNode.this.enabled) ? IndicatorLineNode.this.focusedIndicatorWidth : IndicatorLineNode.this.unfocusedIndicatorWidth);
                if (IndicatorLineNode.this.enabled) {
                    snapSpecSnap$default = MotionSchemeKt.fromToken((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(IndicatorLineNode.this, MaterialTheme.INSTANCE.getLocalMotionScheme$material3()), MotionSchemeKeyTokens.FastSpatial);
                } else {
                    snapSpecSnap$default = AnimationSpecKt.snap$default(0, 1, null);
                }
                this.label = 1;
                if (Animatable.animateTo$default(animatable, c1486DpM11015boximpl, snapSpecSnap$default, null, null, this, 12, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawWithCacheModifierNode$lambda$3(final IndicatorLineNode indicatorLineNode, CacheDrawScope cacheDrawScope) {
        float f = cacheDrawScope.mo2191toPx0680j_4(indicatorLineNode.widthAnimatable.getValue().m11031unboximpl());
        Path Path = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(Path, indicatorLineNode.getShape().mo2085createOutlinePq9zytI(cacheDrawScope.m7683getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope));
        Path Path2 = AndroidPath_androidKt.Path();
        Path.addRect$default(Path2, new Rect(0.0f, Float.intBitsToFloat((int) (cacheDrawScope.m7683getSizeNHjbRc() & 4294967295L)) - f, Float.intBitsToFloat((int) (cacheDrawScope.m7683getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (cacheDrawScope.m7683getSizeNHjbRc() & 4294967295L))), null, 2, null);
        final Path pathAnd = Path2.and(Path);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.IndicatorLineNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndicatorLineNode.drawWithCacheModifierNode$lambda$3$lambda$2(pathAnd, indicatorLineNode, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawWithCacheModifierNode$lambda$3$lambda$2(Path path, IndicatorLineNode indicatorLineNode, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Animatable<Color, AnimationVector4D> animatable = indicatorLineNode.colorAnimatable;
        Intrinsics.checkNotNull(animatable);
        DrawScope.m8718drawPathGBMwjPU$default(contentDrawScope, path, new SolidColor(animatable.getValue().m8158unboximpl(), null), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }
}
