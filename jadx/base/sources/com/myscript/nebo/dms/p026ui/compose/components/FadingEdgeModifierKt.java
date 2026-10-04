package com.myscript.nebo.dms.p026ui.compose.components;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: fadingEdgeModifier.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, m1599d2 = {"fadingEdges", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/lazy/LazyListState;", "color", "Landroidx/compose/ui/graphics/Color;", "size", "Landroidx/compose/ui/unit/Dp;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "fadingEdges-bN7B8ug", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;JFLandroidx/compose/foundation/gestures/Orientation;)Landroidx/compose/ui/Modifier;", "dms_release", "startAnimatedSize", "animatedStartAlpha", "", "animatedStartColor", "endAnimatedSize", "animatedEndAlpha", "animatedEndColor", "horizontal", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FadingEdgeModifierKt {
    /* JADX INFO: renamed from: fadingEdges-bN7B8ug, reason: not valid java name */
    public static final Modifier m13021fadingEdgesbN7B8ug(Modifier fadingEdges, final LazyListState scrollState, final long j, final float f, final Orientation orientation) {
        Intrinsics.checkNotNullParameter(fadingEdges, "$this$fadingEdges");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return ComposedModifierKt.composed$default(fadingEdges, null, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.components.FadingEdgeModifierKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FadingEdgeModifierKt.fadingEdges_bN7B8ug$lambda$0(scrollState, f, j, orientation, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier fadingEdges_bN7B8ug$lambda$0(LazyListState lazyListState, float f, final long j, Orientation orientation, Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(-1427992094);
        ComposerKt.sourceInformation(composer, "C28@1088L108,29@1227L115,30@1373L102,36@1504L105,37@1638L112,38@1779L100,45@1985L66,50@2182L22,51@2234L1309:fadingEdgeModifier.kt#r7kl7s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1427992094, i, -1, "com.myscript.nebo.dms.ui.compose.components.fadingEdges.<anonymous> (fadingEdgeModifier.kt:28)");
        }
        final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(lazyListState.getCanScrollBackward() ? f : C1486Dp.m11017constructorimpl(0), null, "start fade size", null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 10);
        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(lazyListState.getCanScrollBackward() ? 1.0f : 0.0f, null, 0.0f, "start fading edge alpha", null, composer, 3072, 22);
        ComposerKt.sourceInformationMarkerStart(composer, 2089142600, "CC(remember):fadingEdgeModifier.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Color>() { // from class: com.myscript.nebo.dms.ui.compose.components.FadingEdgeModifierKt$fadingEdges$1$animatedStartColor$2$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Color invoke() {
                    return Color.m8138boximpl(m13024invoke0d7_KjU());
                }

                /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
                public final long m13024invoke0d7_KjU() {
                    return Color.m8147copywmQWz5c$default(j, FadingEdgeModifierKt.fadingEdges_bN7B8ug$lambda$0$1(stateAnimateFloatAsState), 0.0f, 0.0f, 0.0f, 14, null);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        final State state = (State) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(lazyListState.getCanScrollForward() ? f : C1486Dp.m11017constructorimpl(0), null, "end fade size", null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 10);
        final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(lazyListState.getCanScrollForward() ? 1.0f : 0.0f, null, 0.0f, "end fading edge alpha", null, composer, 3072, 22);
        ComposerKt.sourceInformationMarkerStart(composer, 2089155590, "CC(remember):fadingEdgeModifier.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Color>() { // from class: com.myscript.nebo.dms.ui.compose.components.FadingEdgeModifierKt$fadingEdges$1$animatedEndColor$2$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Color invoke() {
                    return Color.m8138boximpl(m13023invoke0d7_KjU());
                }

                /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
                public final long m13023invoke0d7_KjU() {
                    return Color.m8147copywmQWz5c$default(j, FadingEdgeModifierKt.fadingEdges_bN7B8ug$lambda$0$5(stateAnimateFloatAsState2), 0.0f, 0.0f, 0.0f, 14, null);
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        final State state2 = (State) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2089162148, "CC(remember):fadingEdgeModifier.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(orientation == Orientation.Horizontal), null, 2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        final MutableState mutableState = (MutableState) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 2089168408, "CC(remember):fadingEdgeModifier.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.components.FadingEdgeModifierKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FadingEdgeModifierKt.fadingEdges_bN7B8ug$lambda$0$10$0((GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4);
        ComposerKt.sourceInformationMarkerStart(composer, 2089171359, "CC(remember):fadingEdgeModifier.kt#9igjgp");
        boolean zChanged = composer.changed(stateM1892animateDpAsStateAjpBEmI) | composer.changed(stateM1892animateDpAsStateAjpBEmI2);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.components.FadingEdgeModifierKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FadingEdgeModifierKt.fadingEdges_bN7B8ug$lambda$0$11$0(mutableState, stateM1892animateDpAsStateAjpBEmI, state, stateM1892animateDpAsStateAjpBEmI2, state2, (ContentDrawScope) obj2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue5 = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierThen = composed.then(DrawModifierKt.drawWithContent(modifierGraphicsLayer, (Function1) objRememberedValue5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    private static final boolean fadingEdges_bN7B8ug$lambda$0$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fadingEdges_bN7B8ug$lambda$0$10$0(GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(0.99f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit fadingEdges_bN7B8ug$lambda$0$11$0(MutableState mutableState, State state, State state2, State state3, State state4, ContentDrawScope drawWithContent) {
        float fIntBitsToFloat;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        long j3 = drawWithContent.mo8729getSizeNHjbRc();
        boolean zFadingEdges_bN7B8ug$lambda$0$9 = fadingEdges_bN7B8ug$lambda$0$9(mutableState);
        Float fValueOf = Float.valueOf(0.0f);
        if (zFadingEdges_bN7B8ug$lambda$0$9) {
            int i = (int) (j3 >> 32);
            if (Float.intBitsToFloat(i) > 0.0f) {
                fIntBitsToFloat = Float.intBitsToFloat(i);
            } else if (!fadingEdges_bN7B8ug$lambda$0$9(mutableState)) {
                int i2 = (int) (j3 & 4294967295L);
                fIntBitsToFloat = Float.intBitsToFloat(i2) > 0.0f ? Float.intBitsToFloat(i2) : 0.0f;
            }
        }
        float f = drawWithContent.mo2191toPx0680j_4(fadingEdges_bN7B8ug$lambda$0$0(state)) / fIntBitsToFloat;
        ContentDrawScope contentDrawScope = drawWithContent;
        Brush.Companion companion = Brush.INSTANCE;
        Pair[] pairArr = {TuplesKt.m1606to(fValueOf, Color.m8138boximpl(fadingEdges_bN7B8ug$lambda$0$3(state2))), TuplesKt.m1606to(Float.valueOf(f), Color.m8138boximpl(Color.INSTANCE.m8183getTransparent0d7_KjU()))};
        long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        if (fadingEdges_bN7B8ug$lambda$0$9(mutableState)) {
            j = 4294967295L;
            j2 = j3 >> 32;
        } else {
            j = 4294967295L;
            j2 = j3 & 4294967295L;
        }
        DrawScope.m8722drawRectAsUm42w$default(contentDrawScope, Brush.Companion.m8098linearGradientmHitzGk$default(companion, pairArr, jM7919getZeroF1C5BW0, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) j2))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & j)), 0, 8, (Object) null), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        DrawScope.m8722drawRectAsUm42w$default(contentDrawScope, Brush.Companion.m8098linearGradientmHitzGk$default(Brush.INSTANCE, new Pair[]{TuplesKt.m1606to(fValueOf, Color.m8138boximpl(fadingEdges_bN7B8ug$lambda$0$7(state4))), TuplesKt.m1606to(Float.valueOf(drawWithContent.mo2191toPx0680j_4(fadingEdges_bN7B8ug$lambda$0$4(state3)) / fIntBitsToFloat), Color.m8138boximpl(Color.INSTANCE.m8183getTransparent0d7_KjU()))}, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (fadingEdges_bN7B8ug$lambda$0$9(mutableState) ? j3 >> 32 : j3 & j)))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & j)), Offset.INSTANCE.m7919getZeroF1C5BW0(), 0, 8, (Object) null), 0L, j3, 0.0f, null, null, 0, PDFACompliance.e_PDFA1_2_2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: fadingEdges-bN7B8ug$default, reason: not valid java name */
    public static /* synthetic */ Modifier m13022fadingEdgesbN7B8ug$default(Modifier modifier, LazyListState lazyListState, long j, float f, Orientation orientation, int i, Object obj) {
        if ((i & 4) != 0) {
            f = C1486Dp.m11017constructorimpl(48);
        }
        float f2 = f;
        if ((i & 8) != 0) {
            orientation = Orientation.Vertical;
        }
        return m13021fadingEdgesbN7B8ug(modifier, lazyListState, j, f2, orientation);
    }

    private static final float fadingEdges_bN7B8ug$lambda$0$0(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float fadingEdges_bN7B8ug$lambda$0$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long fadingEdges_bN7B8ug$lambda$0$3(State<Color> state) {
        return state.getValue().m8158unboximpl();
    }

    private static final float fadingEdges_bN7B8ug$lambda$0$4(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float fadingEdges_bN7B8ug$lambda$0$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long fadingEdges_bN7B8ug$lambda$0$7(State<Color> state) {
        return state.getValue().m8158unboximpl();
    }
}
