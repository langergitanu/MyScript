package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001aA\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a;\u0010\u0014\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001aK\u0010\u001e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b \u0010!\u001aA\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\"\u0010#\u001a5\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001fH\u0007¢\u0006\u0004\b$\u0010%\u001a-\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001fH\u0007¢\u0006\u0004\b&\u0010'\u001a3\u0010(\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101\u001a3\u00102\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u0010.\u001a;\u00104\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b5\u00106\"\u0010\u00107\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u0010\u00109\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u0010\u0010:\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u000e\u0010;\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S²\u0006\n\u0010T\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010W\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020<X\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0005X\u008a\u0084\u0002"}, m1599d2 = {"increaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "LinearProgressIndicator", "", "progress", "", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "CircularProgressIndicator", "Landroidx/compose/ui/unit/Dp;", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "LinearIndicatorHeight", "F", "LinearIndicatorWidth", "CircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "FirstLineHeadEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "FirstLineTailEasing", "SecondLineHeadEasing", "SecondLineTailEasing", "RotationsPerCycle", "RotationDuration", "StartAngleOffset", "BaseRotationAngle", "JumpRotationAngle", "RotationAngleOffset", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "CircularEasing", "material", "firstLineHead", "firstLineTail", "secondLineHead", "secondLineTail", "currentRotation", "baseRotation", "endAngle"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m4356getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = C1486Dp.m11017constructorimpl(PsExtractor.VIDEO_STREAM_MASK);
    private static final float CircularIndicatorDiameter = C1486Dp.m11017constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_DUhRLBM$lambda$3(float f, Modifier modifier, long j, float f2, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m4365CircularProgressIndicatorDUhRLBM(f, modifier, j, f2, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_LxG7B9w$lambda$8(Modifier modifier, long j, float f, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m4366CircularProgressIndicatorLxG7B9w(modifier, j, f, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_MBs18nI$lambda$0(float f, Modifier modifier, long j, float f2, int i, int i2, Composer composer, int i3) {
        m4367CircularProgressIndicatorMBs18nI(f, modifier, j, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_aM_cp0Q$lambda$0(Modifier modifier, long j, float f, int i, int i2, Composer composer, int i3) {
        m4368CircularProgressIndicatoraMcp0Q(modifier, j, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$9(Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m4369LinearProgressIndicator2cYBFYY(modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_RIQooxk$lambda$0(Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m4370LinearProgressIndicatorRIQooxk(modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator__5eSR_E$lambda$2(float f, Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m4371LinearProgressIndicator_5eSRE(f, modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_eaDK9VM$lambda$0(float f, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m4372LinearProgressIndicatoreaDK9VM(f, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult increaseSemanticsBounds$lambda$0(float f, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final int i = measureScope.mo2185roundToPx0680j_4(f);
        long value = constraints.getValue();
        int i2 = i * 2;
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.m10989offsetNN6EwU(value, 0, i2));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight() - i2, null, new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt.increaseSemanticsBounds$lambda$0$0(placeableMo9625measureBRTryo0, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit increaseSemanticsBounds$lambda$0$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, -i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit increaseSemanticsBounds$lambda$1(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4371LinearProgressIndicator_5eSRE(final float f, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long jM4203getPrimary0d7_KjU;
        long j3;
        int iM8524getButtKaPHkGw;
        Modifier.Companion companion;
        final int i5;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM8147copywmQWz5c$default;
        final int i6;
        final long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-531984864);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)115@5390L204,110@5177L417:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i7 = i3 & 2;
        if (i7 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                jM4203getPrimary0d7_KjU = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 256 : 128;
            } else {
                jM4203getPrimary0d7_KjU = j;
            }
            if ((i2 & 3072) != 0) {
                j3 = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j2;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    iM8524getButtKaPHkGw = i;
                    int i8 = composerStartRestartGroup.changed(iM8524getButtKaPHkGw) ? 16384 : 8192;
                    i4 |= i8;
                } else {
                    iM8524getButtKaPHkGw = i;
                }
                i4 |= i8;
            } else {
                iM8524getButtKaPHkGw = i;
            }
            boolean z = true;
            if (!composerStartRestartGroup.shouldExecute((i4 & 9363) == 9362, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "105@4977L6");
                if ((i2 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    companion = modifier2;
                } else {
                    companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 4) != 0) {
                        jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                        i4 &= -897;
                    }
                    long j7 = jM4203getPrimary0d7_KjU;
                    if ((i3 & 8) != 0) {
                        jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(j7, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                        i4 &= -7169;
                    } else {
                        jM8147copywmQWz5c$default = j3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        iM8524getButtKaPHkGw = StrokeCap.INSTANCE.m8524getButtKaPHkGw();
                    }
                    j3 = jM8147copywmQWz5c$default;
                    jM4203getPrimary0d7_KjU = j7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531984864, i4, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:108)");
                }
                float f2 = f < 0.0f ? 0.0f : f;
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                Modifier modifierIncreaseSemanticsBounds = increaseSemanticsBounds(companion);
                Float fValueOf = Float.valueOf(f2);
                if (Float.isNaN(fValueOf.floatValue())) {
                    fValueOf = null;
                }
                Modifier modifierM2926sizeVpY3zN4 = SizeKt.m2926sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifierIncreaseSemanticsBounds, fValueOf != null ? fValueOf.floatValue() : 0.0f, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -136327796, "CC(remember):ProgressIndicator.kt#9igjgp");
                boolean zChanged = ((((i4 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(j3)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) > 16384 && composerStartRestartGroup.changed(iM8524getButtKaPHkGw)) || (i4 & 24576) == 16384) | composerStartRestartGroup.changed(f2);
                if ((((i4 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) && (i4 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                    z = false;
                }
                boolean z2 = zChanged | z;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final float f3 = f2;
                    i6 = iM8524getButtKaPHkGw;
                    j4 = jM4203getPrimary0d7_KjU;
                    j6 = j3;
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$1$0(j6, i6, f3, j4, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i6 = iM8524getButtKaPHkGw;
                    j4 = jM4203getPrimary0d7_KjU;
                    j6 = j3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM2926sizeVpY3zN4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j5 = j6;
                i5 = i6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                i5 = iM8524getButtKaPHkGw;
                j4 = jM4203getPrimary0d7_KjU;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j8 = j4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$2(f, modifier3, j8, j5, i5, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        boolean z3 = true;
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) == 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator__5eSR_E$lambda$1$0(long j, int i, float f, long j2, DrawScope drawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() & 4294967295L));
        m4378drawLinearIndicatorBackgroundAZGd3zU(drawScope, j, fIntBitsToFloat, i);
        m4377drawLinearIndicatorqYKTg0g(drawScope, 0.0f, f, j2, fIntBitsToFloat, i);
        return Unit.INSTANCE;
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
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final void m4369LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long jM4203getPrimary0d7_KjU;
        long j3;
        int iM8524getButtKaPHkGw;
        final Modifier modifier3;
        final int i5;
        final long j4;
        final long j5;
        Modifier.Companion companion;
        long jM8147copywmQWz5c$default;
        int i6;
        long j6;
        long j7;
        final int i7;
        final long j8;
        final long j9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501635280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)145@6690L28,155@7116L236,150@6980L397,168@7566L236,163@7430L397,181@8017L240,176@7881L401,194@8472L240,189@8336L401,206@8908L434,201@8742L600:ProgressIndicator.kt#jmzs0o");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            jM4203getPrimary0d7_KjU = j;
            i4 |= ((i3 & 2) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 32 : 16;
        } else {
            jM4203getPrimary0d7_KjU = j;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j3 = j2;
            i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(j3)) ? 256 : 128;
        } else {
            j3 = j2;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                iM8524getButtKaPHkGw = i;
                int i9 = composerStartRestartGroup.changed(iM8524getButtKaPHkGw) ? 2048 : 1024;
                i4 |= i9;
            } else {
                iM8524getButtKaPHkGw = i;
            }
            i4 |= i9;
        } else {
            iM8524getButtKaPHkGw = i;
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "141@6521L6");
            if ((i2 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                }
                companion = modifier2;
                j7 = j3;
                long j10 = jM4203getPrimary0d7_KjU;
                i6 = i4;
                j6 = j10;
            } else {
                companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i3 & 2) != 0) {
                    jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                    i4 &= -113;
                }
                long j11 = jM4203getPrimary0d7_KjU;
                if ((i3 & 4) != 0) {
                    jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(j11, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    i4 &= -897;
                } else {
                    jM8147copywmQWz5c$default = j3;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    iM8524getButtKaPHkGw = StrokeCap.INSTANCE.m8524getButtKaPHkGw();
                }
                long j12 = jM8147copywmQWz5c$default;
                i6 = i4;
                j6 = j11;
                j7 = j12;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501635280, i6, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:144)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37484996, "CC(remember):ProgressIndicator.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$0$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i10 = i6;
            long j13 = j7;
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), null, 0L, 6, null), null, composerStartRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 432, 8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37470596, "CC(remember):ProgressIndicator.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier4 = companion;
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue2), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37456160, "CC(remember):ProgressIndicator.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long j14 = j6;
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue3), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37441600, "CC(remember):ProgressIndicator.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$6$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue4), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifierM2926sizeVpY3zN4 = SizeKt.m2926sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(increaseSemanticsBounds(modifier4)), LinearIndicatorWidth, LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37427454, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean zChanged = ((((i10 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composerStartRestartGroup.changed(j13)) || (i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i10 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(iM8524getButtKaPHkGw)) || (i10 & 3072) == 2048) | composerStartRestartGroup.changed(stateAnimateFloat) | composerStartRestartGroup.changed(stateAnimateFloat2) | ((((i10 & 112) ^ 48) > 32 && composerStartRestartGroup.changed(j14)) || (i10 & 48) == 32) | composerStartRestartGroup.changed(stateAnimateFloat3) | composerStartRestartGroup.changed(stateAnimateFloat4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                i7 = iM8524getButtKaPHkGw;
                j8 = j13;
                j9 = j14;
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$8$0(j8, i7, j9, stateAnimateFloat, stateAnimateFloat2, stateAnimateFloat3, stateAnimateFloat4, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                i7 = iM8524getButtKaPHkGw;
                j8 = j13;
                j9 = j14;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM2926sizeVpY3zN4, (Function1) objRememberedValue5, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j5 = j8;
            i5 = i7;
            j4 = j9;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            i5 = iM8524getButtKaPHkGw;
            j4 = jM4203getPrimary0d7_KjU;
            j5 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$9(modifier3, j4, j5, i5, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$0$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), 0), FirstLineHeadEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(1.0f), FirstLineHeadDuration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$2$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), FirstLineTailDelay), FirstLineTailEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(1.0f), 1183);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$4$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), 1000), SecondLineHeadEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(1.0f), 1567);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$6$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), SecondLineTailDelay), SecondLineTailEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(1.0f), LinearAnimationDuration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$8$0(long j, int i, long j2, State state, State state2, State state3, State state4, DrawScope drawScope) {
        int i2;
        DrawScope drawScope2;
        float f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() & 4294967295L));
        m4378drawLinearIndicatorBackgroundAZGd3zU(drawScope, j, fIntBitsToFloat, i);
        if (LinearProgressIndicator_2cYBFYY$lambda$1(state) - LinearProgressIndicator_2cYBFYY$lambda$3(state2) > 0.0f) {
            float fLinearProgressIndicator_2cYBFYY$lambda$1 = LinearProgressIndicator_2cYBFYY$lambda$1(state);
            float fLinearProgressIndicator_2cYBFYY$lambda$3 = LinearProgressIndicator_2cYBFYY$lambda$3(state2);
            i2 = i;
            f = fIntBitsToFloat;
            drawScope2 = drawScope;
            m4377drawLinearIndicatorqYKTg0g(drawScope2, fLinearProgressIndicator_2cYBFYY$lambda$1, fLinearProgressIndicator_2cYBFYY$lambda$3, j2, f, i2);
        } else {
            i2 = i;
            drawScope2 = drawScope;
            f = fIntBitsToFloat;
        }
        if (LinearProgressIndicator_2cYBFYY$lambda$5(state3) - LinearProgressIndicator_2cYBFYY$lambda$7(state4) > 0.0f) {
            m4377drawLinearIndicatorqYKTg0g(drawScope2, LinearProgressIndicator_2cYBFYY$lambda$5(state3), LinearProgressIndicator_2cYBFYY$lambda$7(state4), j2, f, i2);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4372LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        final Modifier modifier3;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM4203getPrimary0d7_KjU;
        long jM8147copywmQWz5c$default;
        long j7;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color)225@9657L95:ProgressIndicator.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i5 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i5;
                } else {
                    j3 = j;
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "223@9560L6");
                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    jM8147copywmQWz5c$default = j4;
                    modifier4 = modifier2;
                    j7 = j3;
                } else {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                    } else {
                        jM4203getPrimary0d7_KjU = j3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(jM4203getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                        j7 = jM4203getPrimary0d7_KjU;
                    } else {
                        jM8147copywmQWz5c$default = j4;
                        j7 = jM4203getPrimary0d7_KjU;
                        modifier4 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:225)");
                }
                m4371LinearProgressIndicator_5eSRE(f, modifier4, j7, jM8147copywmQWz5c$default, StrokeCap.INSTANCE.m8524getButtKaPHkGw(), composerStartRestartGroup, i3 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j5 = j7;
                j6 = jM8147copywmQWz5c$default;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.LinearProgressIndicator_eaDK9VM$lambda$0(f, modifier3, j5, j6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m4370LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM4203getPrimary0d7_KjU;
        long j3;
        final Modifier modifier3;
        final long j4;
        final long j5;
        long jM8147copywmQWz5c$default;
        long j6;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color)233@10044L85:ProgressIndicator.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                jM4203getPrimary0d7_KjU = j;
                int i5 = composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU) ? 32 : 16;
                i3 |= i5;
            } else {
                jM4203getPrimary0d7_KjU = j;
            }
            i3 |= i5;
        } else {
            jM4203getPrimary0d7_KjU = j;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i6 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i6;
            } else {
                j3 = j2;
            }
            i3 |= i6;
        } else {
            j3 = j2;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "231@9947L6");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                jM8147copywmQWz5c$default = j3;
                modifier4 = modifier2;
                j6 = jM4203getPrimary0d7_KjU;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                    i3 &= -113;
                }
                long j7 = jM4203getPrimary0d7_KjU;
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    modifier4 = companion;
                    jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(j7, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    j6 = j7;
                } else {
                    jM8147copywmQWz5c$default = j3;
                    j6 = j7;
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:233)");
            }
            m4369LinearProgressIndicator2cYBFYY(modifier4, j6, jM8147copywmQWz5c$default, StrokeCap.INSTANCE.m8524getButtKaPHkGw(), composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j4 = j6;
            j5 = jM8147copywmQWz5c$default;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = jM4203getPrimary0d7_KjU;
            j5 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressIndicatorKt.LinearProgressIndicator_RIQooxk$lambda$0(modifier3, j4, j5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    private static final void m4377drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() & 4294967295L));
        float f4 = 2;
        float f5 = fIntBitsToFloat2 / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * fIntBitsToFloat;
        float f7 = (z ? f2 : 1.0f - f) * fIntBitsToFloat;
        if (StrokeCap.m8520equalsimpl0(i, StrokeCap.INSTANCE.m8524getButtKaPHkGw()) || fIntBitsToFloat2 > fIntBitsToFloat) {
            DrawScope.m8715drawLineNGM6Ib0$default(drawScope, j, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(f8, fIntBitsToFloat - f8);
        float fFloatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), closedFloatingPointRangeRangeTo)).floatValue();
        float fFloatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), closedFloatingPointRangeRangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m8715drawLineNGM6Ib0$default(drawScope, j, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(fFloatValue2)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), f3, i, null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        }
    }

    /* JADX INFO: renamed from: drawLinearIndicatorBackground-AZGd3zU, reason: not valid java name */
    private static final void m4378drawLinearIndicatorBackgroundAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m4377drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013b  */
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
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4365CircularProgressIndicatorDUhRLBM(final float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long jM4203getPrimary0d7_KjU;
        int i5;
        float fM4356getStrokeWidthD9Ej5fM;
        int i6;
        long jM8183getTransparent0d7_KjU;
        int i7;
        int iM8524getButtKaPHkGw;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f3;
        final Stroke stroke;
        Float fValueOf;
        boolean z;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1746618448);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,backgroundColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)315@13540L7,320@13765L251,316@13609L407:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                jM4203getPrimary0d7_KjU = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 256 : 128;
            } else {
                jM4203getPrimary0d7_KjU = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    fM4356getStrokeWidthD9Ej5fM = f2;
                    i4 |= composerStartRestartGroup.changed(fM4356getStrokeWidthD9Ej5fM) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i2 & 24576) == 0) {
                        jM8183getTransparent0d7_KjU = j2;
                        i4 |= composerStartRestartGroup.changed(jM8183getTransparent0d7_KjU) ? 16384 : 8192;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) != 0) {
                        i7 = i;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(i7)) ? 131072 : 65536;
                    } else {
                        i7 = i;
                    }
                    boolean z2 = true;
                    if (!composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "309@13277L6");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                fM4356getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4356getStrokeWidthD9Ej5fM();
                            }
                            if (i6 != 0) {
                                jM8183getTransparent0d7_KjU = Color.INSTANCE.m8183getTransparent0d7_KjU();
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                iM8524getButtKaPHkGw = StrokeCap.INSTANCE.m8524getButtKaPHkGw();
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1746618448, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:313)");
                            }
                            f3 = f >= 0.0f ? 0.0f : f;
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            stroke = new Stroke(((Density) objConsume).mo2191toPx0680j_4(fM4356getStrokeWidthD9Ej5fM), 0.0f, iM8524getButtKaPHkGw, 0, null, 26, null);
                            fValueOf = Float.valueOf(f3);
                            if (Float.isNaN(fValueOf.floatValue())) {
                                fValueOf = null;
                            }
                            Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fValueOf != null ? fValueOf.floatValue() : 0.0f, null, 0, 6, null), CircularIndicatorDiameter);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -831863413, "CC(remember):ProgressIndicator.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(f3) | ((57344 & i4) != 16384) | composerStartRestartGroup.changedInstance(stroke);
                            if ((((i4 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 || !composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) && (i4 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                                z2 = false;
                            }
                            z = zChanged | z2;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                final float f4 = f3;
                                final long j3 = jM4203getPrimary0d7_KjU;
                                final long j4 = jM8183getTransparent0d7_KjU;
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$2$0(f4, j4, stroke, j3, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2924size3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                        }
                        iM8524getButtKaPHkGw = i7;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (f >= 0.0f) {
                        }
                        if (f3 > 1.0f) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        stroke = new Stroke(((Density) objConsume2).mo2191toPx0680j_4(fM4356getStrokeWidthD9Ej5fM), 0.0f, iM8524getButtKaPHkGw, 0, null, 26, null);
                        fValueOf = Float.valueOf(f3);
                        if (Float.isNaN(fValueOf.floatValue())) {
                        }
                        Modifier modifierM2924size3ABfNKs2 = SizeKt.m2924size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fValueOf != null ? fValueOf.floatValue() : 0.0f, null, 0, 6, null), CircularIndicatorDiameter);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -831863413, "CC(remember):ProgressIndicator.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(f3) | ((57344 & i4) != 16384) | composerStartRestartGroup.changedInstance(stroke);
                        if (((i4 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256) {
                            z2 = false;
                            z = zChanged2 | z2;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z) {
                                final float f42 = f3;
                                final long j32 = jM4203getPrimary0d7_KjU;
                                final long j42 = jM8183getTransparent0d7_KjU;
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$2$0(f42, j42, stroke, j32, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                CanvasKt.Canvas(modifierM2924size3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                        } else {
                            z2 = false;
                            z = zChanged2 | z2;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z) {
                            }
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        iM8524getButtKaPHkGw = i7;
                    }
                    final long j5 = jM4203getPrimary0d7_KjU;
                    final long j6 = jM8183getTransparent0d7_KjU;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final float f5 = fM4356getStrokeWidthD9Ej5fM;
                        final int i9 = iM8524getButtKaPHkGw;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$3(f, modifier3, j5, f5, j6, i9, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                jM8183getTransparent0d7_KjU = j2;
                if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) != 0) {
                }
                boolean z22 = true;
                if (!composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                }
                final long j52 = jM4203getPrimary0d7_KjU;
                final long j62 = jM8183getTransparent0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM4356getStrokeWidthD9Ej5fM = f2;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            jM8183getTransparent0d7_KjU = j2;
            if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) != 0) {
            }
            boolean z222 = true;
            if (!composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
            }
            final long j522 = jM4203getPrimary0d7_KjU;
            final long j622 = jM8183getTransparent0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        fM4356getStrokeWidthD9Ej5fM = f2;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        jM8183getTransparent0d7_KjU = j2;
        if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) != 0) {
        }
        boolean z2222 = true;
        if (!composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
        }
        final long j5222 = jM4203getPrimary0d7_KjU;
        final long j6222 = jM8183getTransparent0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_DUhRLBM$lambda$2$0(float f, long j, Stroke stroke, long j2, DrawScope drawScope) {
        m4374drawCircularIndicatorBackgroundbw27NRU(drawScope, j, stroke);
        m4375drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, f * 360.0f, j2, stroke);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0264  */
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
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4366CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long jM4203getPrimary0d7_KjU;
        float fM4356getStrokeWidthD9Ej5fM;
        int i5;
        int i6;
        final Modifier modifier3;
        final int i7;
        final long j3;
        final float f2;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final long j5;
        int iM8526getSquareKaPHkGw;
        long j6;
        int i8;
        final float f3;
        final Stroke stroke;
        final State stateAnimateValue;
        final State<Float> stateAnimateFloat;
        Object objRememberedValue;
        final State<Float> stateAnimateFloat2;
        Object objRememberedValue2;
        final State<Float> stateAnimateFloat3;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1119119072);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,backgroundColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)354@15229L7,356@15316L28,359@15482L352,373@15957L209,387@16443L247,382@16292L423,401@16909L256,396@16758L432,408@17264L538,408@17195L607:ProgressIndicator.kt#jmzs0o");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            jM4203getPrimary0d7_KjU = j;
            i4 |= ((i3 & 2) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 32 : 16;
        } else {
            jM4203getPrimary0d7_KjU = j;
        }
        int i10 = i3 & 4;
        if (i10 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                fM4356getStrokeWidthD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM4356getStrokeWidthD9Ej5fM) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        i6 = i;
                        int i11 = composerStartRestartGroup.changed(i6) ? 16384 : 8192;
                        i4 |= i11;
                    } else {
                        i6 = i;
                    }
                    i4 |= i11;
                } else {
                    i6 = i;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "349@15020L6");
                    if ((i2 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        j5 = j2;
                        companion = modifier2;
                    } else {
                        companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                            jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                        }
                        if (i10 != 0) {
                            fM4356getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4356getStrokeWidthD9Ej5fM();
                        }
                        long jM8183getTransparent0d7_KjU = i5 != 0 ? Color.INSTANCE.m8183getTransparent0d7_KjU() : j2;
                        if ((i3 & 16) != 0) {
                            j5 = jM8183getTransparent0d7_KjU;
                            iM8526getSquareKaPHkGw = StrokeCap.INSTANCE.m8526getSquareKaPHkGw();
                            j6 = jM4203getPrimary0d7_KjU;
                            i8 = i4 & (-57345);
                            f3 = fM4356getStrokeWidthD9Ej5fM;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1119119072, i8, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:353)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            stroke = new Stroke(((Density) objConsume).mo2191toPx0680j_4(f3), 0.0f, iM8526getSquareKaPHkGw, 0, null, 26, null);
                            int i12 = iM8526getSquareKaPHkGw;
                            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                            Modifier modifier4 = companion;
                            stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731555241, "CC(remember):ProgressIndicator.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$3$0((KeyframesSpec.KeyframesSpecConfig) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731540320, "CC(remember):ProgressIndicator.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$5$0((KeyframesSpec.KeyframesSpecConfig) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue2), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier4), CircularIndicatorDiameter);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731528678, "CC(remember):ProgressIndicator.kt#9igjgp");
                            zChangedInstance = composerStartRestartGroup.changedInstance(stroke) | ((i8 & 7168) != 2048) | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3) | composerStartRestartGroup.changed(stateAnimateFloat) | ((i8 & 896) != 256) | ((((i8 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(j6)) || (i8 & 48) == 32);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                j7 = j6;
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$7$0(j5, stroke, f3, j7, stateAnimateValue, stateAnimateFloat2, stateAnimateFloat3, stateAnimateFloat, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                j7 = j6;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2924size3ABfNKs, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i7 = i12;
                            j4 = j5;
                            f2 = f3;
                            j3 = j7;
                            modifier3 = modifier4;
                        } else {
                            j5 = jM8183getTransparent0d7_KjU;
                        }
                    }
                    i8 = i4;
                    iM8526getSquareKaPHkGw = i6;
                    j6 = jM4203getPrimary0d7_KjU;
                    f3 = fM4356getStrokeWidthD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stroke = new Stroke(((Density) objConsume2).mo2191toPx0680j_4(f3), 0.0f, iM8526getSquareKaPHkGw, 0, null, 26, null);
                    int i122 = iM8526getSquareKaPHkGw;
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                    Modifier modifier42 = companion;
                    stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731555241, "CC(remember):ProgressIndicator.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731540320, "CC(remember):ProgressIndicator.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue2), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier modifierM2924size3ABfNKs2 = SizeKt.m2924size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier42), CircularIndicatorDiameter);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731528678, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if (((i8 & 112) ^ 48) <= 32) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(stroke) | ((i8 & 7168) != 2048) | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3) | composerStartRestartGroup.changed(stateAnimateFloat) | ((i8 & 896) != 256) | ((((i8 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(j6)) || (i8 & 48) == 32);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            j7 = j6;
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$7$0(j5, stroke, f3, j7, stateAnimateValue, stateAnimateFloat2, stateAnimateFloat3, stateAnimateFloat, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2924size3ABfNKs2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i7 = i122;
                            j4 = j5;
                            f2 = f3;
                            j3 = j7;
                            modifier3 = modifier42;
                        }
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(stroke) | ((i8 & 7168) != 2048) | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3) | composerStartRestartGroup.changed(stateAnimateFloat) | ((i8 & 896) != 256) | ((((i8 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(j6)) || (i8 & 48) == 32);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    i7 = i6;
                    j3 = jM4203getPrimary0d7_KjU;
                    f2 = fM4356getStrokeWidthD9Ej5fM;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$8(modifier3, j3, f2, j4, i7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 3072;
            if ((i2 & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM4356getStrokeWidthD9Ej5fM = f;
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_LxG7B9w$lambda$3$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(RotationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), 0), CircularEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(JumpRotationAngle), 666);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_LxG7B9w$lambda$5$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(RotationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.mo10at(Float.valueOf(0.0f), 666), CircularEasing);
        keyframesSpecConfig.mo10at(Float.valueOf(JumpRotationAngle), keyframesSpecConfig.getDurationMillis());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_LxG7B9w$lambda$7$0(long j, Stroke stroke, float f, long j2, State state, State state2, State state3, State state4, DrawScope drawScope) {
        m4374drawCircularIndicatorBackgroundbw27NRU(drawScope, j, stroke);
        m4376drawIndeterminateCircularIndicatorhrjfTZI(drawScope, CircularProgressIndicator_LxG7B9w$lambda$6(state3) + ((CircularProgressIndicator_LxG7B9w$lambda$1(state) * RotationAngleOffset) % 360.0f) + StartAngleOffset + CircularProgressIndicator_LxG7B9w$lambda$2(state4), f, Math.abs(CircularProgressIndicator_LxG7B9w$lambda$4(state2) - CircularProgressIndicator_LxG7B9w$lambda$6(state3)), j2, stroke);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4367CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        float f3;
        int i3;
        Modifier modifier2;
        long jM4203getPrimary0d7_KjU;
        int i4;
        float f4;
        final Modifier modifier3;
        final long j2;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM4356getStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)430@18107L185:ProgressIndicator.kt#jmzs0o");
        if ((i & 6) == 0) {
            f3 = f;
            i3 = (composerStartRestartGroup.changed(f3) ? 4 : 2) | i;
        } else {
            f3 = f;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                jM4203getPrimary0d7_KjU = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 256 : 128;
            } else {
                jM4203getPrimary0d7_KjU = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f4 = f2;
                    i3 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "427@18022L6");
                    if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        fM4356getStrokeWidthD9Ej5fM = f4;
                        j3 = jM4203getPrimary0d7_KjU;
                        modifier4 = modifier2;
                    } else {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                            i3 &= -897;
                        }
                        fM4356getStrokeWidthD9Ej5fM = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m4356getStrokeWidthD9Ej5fM() : f4;
                        j3 = jM4203getPrimary0d7_KjU;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:430)");
                    }
                    m4365CircularProgressIndicatorDUhRLBM(f3, modifier4, j3, fM4356getStrokeWidthD9Ej5fM, Color.INSTANCE.m8183getTransparent0d7_KjU(), StrokeCap.INSTANCE.m8524getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    f5 = fM4356getStrokeWidthD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = jM4203getPrimary0d7_KjU;
                    f5 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_MBs18nI$lambda$0(f, modifier3, j2, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            f4 = f2;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        f4 = f2;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4368CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM4203getPrimary0d7_KjU;
        float f2;
        final Modifier modifier3;
        final long j2;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM4356getStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)446@18574L169:ProgressIndicator.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            jM4203getPrimary0d7_KjU = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 32 : 16;
        } else {
            jM4203getPrimary0d7_KjU = j;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "443@18489L6");
                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    fM4356getStrokeWidthD9Ej5fM = f2;
                    j3 = jM4203getPrimary0d7_KjU;
                    modifier4 = modifier2;
                } else {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4203getPrimary0d7_KjU();
                        i3 &= -113;
                    }
                    fM4356getStrokeWidthD9Ej5fM = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m4356getStrokeWidthD9Ej5fM() : f2;
                    j3 = jM4203getPrimary0d7_KjU;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-392089979, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:446)");
                }
                m4366CircularProgressIndicatorLxG7B9w(modifier4, j3, fM4356getStrokeWidthD9Ej5fM, Color.INSTANCE.m8183getTransparent0d7_KjU(), StrokeCap.INSTANCE.m8526getSquareKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
                f3 = fM4356getStrokeWidthD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM4203getPrimary0d7_KjU;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.CircularProgressIndicator_aM_cp0Q$lambda$0(modifier3, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        f2 = f;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m4373drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() >> 32)) - (f3 * width);
        DrawScope.m8708drawArcyD3GUKo$default(drawScope, j, f, f2, false, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(width)) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), Size.m7963constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: renamed from: drawCircularIndicatorBackground-bw27NRU, reason: not valid java name */
    private static final void m4374drawCircularIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m4373drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m4375drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m4373drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    private static final void m4376drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m4373drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m8520equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m8524getButtKaPHkGw()) ? 0.0f : ((f2 / C1486Dp.m11017constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    public static final Modifier increaseSemanticsBounds(Modifier modifier) {
        final float fM11017constructorimpl = C1486Dp.m11017constructorimpl(10);
        return PaddingKt.m2856paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProgressIndicatorKt.increaseSemanticsBounds$lambda$0(fM11017constructorimpl, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), true, new Function1() { // from class: androidx.compose.material.ProgressIndicatorKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt.increaseSemanticsBounds$lambda$1((SemanticsPropertyReceiver) obj);
            }
        }), 0.0f, fM11017constructorimpl, 1, null);
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final int CircularProgressIndicator_LxG7B9w$lambda$1(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}
