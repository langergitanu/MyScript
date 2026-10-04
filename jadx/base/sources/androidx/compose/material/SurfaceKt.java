package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.ShadowKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0092\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001f\u001a5\u0010 \u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#\u001a)\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\fH\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, m1599d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurfaceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_F_jzlyU$lambda$1(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4445SurfaceFjzlyU(modifier, shape, j, j2, borderStroke, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_LPr_se0$lambda$1(Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4446SurfaceLPr_se0(function0, modifier, z, shape, j, j2, borderStroke, f, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m4447SurfaceNy5ogXk(z, (Function0<Unit>) function0, modifier, z2, shape, j, j2, borderStroke, f, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m4448SurfaceNy5ogXk(z, (Function1<? super Boolean, Unit>) function1, modifier, z2, shape, j, j2, borderStroke, f, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4445SurfaceFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape rectangleShape;
        long jM4207getSurface0d7_KjU;
        long jM4221contentColorForek8zF_U;
        int i4;
        BorderStroke borderStroke2;
        int i5;
        final Shape shape2;
        final long j3;
        final BorderStroke borderStroke3;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final float fM11017constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(174096871);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(modifier,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,content)102@5257L7,106@5421L878,103@5281L1018:Surface.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    jM4207getSurface0d7_KjU = j;
                    int i8 = composerStartRestartGroup.changed(jM4207getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i8;
                } else {
                    jM4207getSurface0d7_KjU = j;
                }
                i3 |= i8;
            } else {
                jM4207getSurface0d7_KjU = j;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    jM4221contentColorForek8zF_U = j2;
                    int i9 = composerStartRestartGroup.changed(jM4221contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    jM4221contentColorForek8zF_U = j2;
                }
                i3 |= i9;
            } else {
                jM4221contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    borderStroke2 = borderStroke;
                    i3 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                    i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@5039L6,97@5081L22");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM4207getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4207getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM4221contentColorForek8zF_U = ColorsKt.m4221contentColorForek8zF_U(jM4207getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            borderStroke2 = null;
                        }
                        if (i5 != 0) {
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                        }
                        final Shape shape3 = rectangleShape;
                        j3 = jM4207getSurface0d7_KjU;
                        final BorderStroke borderStroke4 = borderStroke2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
                        }
                        ProvidableCompositionLocal<C1486Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(((C1486Dp) objConsume).m11031unboximpl() + fM11017constructorimpl);
                        final Modifier modifier3 = modifier2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM4221contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1486Dp.m11015boximpl(fM11017constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier3, shape3, j3, fM11017constructorimpl2, borderStroke4, fM11017constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        shape2 = shape3;
                        borderStroke3 = borderStroke4;
                        f2 = fM11017constructorimpl;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                    }
                    fM11017constructorimpl = f;
                    final Shape shape32 = rectangleShape;
                    j3 = jM4207getSurface0d7_KjU;
                    final BorderStroke borderStroke42 = borderStroke2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<C1486Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM11017constructorimpl22 = C1486Dp.m11017constructorimpl(((C1486Dp) objConsume2).m11031unboximpl() + fM11017constructorimpl);
                    final Modifier modifier32 = modifier2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM4221contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1486Dp.m11015boximpl(fM11017constructorimpl22))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier32, shape32, j3, fM11017constructorimpl22, borderStroke42, fM11017constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier32;
                    shape2 = shape32;
                    borderStroke3 = borderStroke42;
                    f2 = fM11017constructorimpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = rectangleShape;
                    j3 = jM4207getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    f2 = f;
                }
                final long j4 = jM4221contentColorForek8zF_U;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final long j5 = j3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_F_jzlyU$lambda$1(modifier4, shape2, j5, j4, borderStroke3, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            borderStroke2 = borderStroke;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            final long j42 = jM4221contentColorForek8zF_U;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        rectangleShape = shape;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        borderStroke2 = borderStroke;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        final long j422 = jM4221contentColorForek8zF_U;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_F_jzlyU$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5768L7,113@5623L254,121@6046L115,125@6202L2,107@5431L862:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004281689, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:107)");
            }
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM4449surface8ww4TTg = m4449surface8ww4TTg(modifier, shape, m4450surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2);
            ComposerKt.sourceInformationMarkerStart(composer, -1969334406, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM4449surface8ww4TTg, false, (Function1) objRememberedValue);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1969329527, "CC(remember):Surface.kt#9igjgp");
            SurfaceKt$Surface$1$2$1 surfaceKt$Surface$1$2$1RememberedValue = composer.rememberedValue();
            if (surfaceKt$Surface$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                surfaceKt$Surface$1$2$1RememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.material.SurfaceKt$Surface$1$2$1
                    @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(surfaceKt$Surface$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) surfaceKt$Surface$1$2$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPointerInput);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -305383667, "C128@6274L9:Surface.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_F_jzlyU$lambda$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0121  */
    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4446SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape rectangleShape;
        long jM4207getSurface0d7_KjU;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM4221contentColorForek8zF_U;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Modifier modifier4;
        final boolean z4;
        final Shape shape3;
        final long j5;
        long j6;
        int i12;
        final BorderStroke borderStroke3;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(2141308794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)210@11108L7,214@11272L967,211@11132L1107:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        rectangleShape = shape;
                        i3 |= composerStartRestartGroup.changed(rectangleShape) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            jM4207getSurface0d7_KjU = j;
                            int i15 = composerStartRestartGroup.changed(jM4207getSurface0d7_KjU) ? 16384 : 8192;
                            i3 |= i15;
                        } else {
                            jM4207getSurface0d7_KjU = j;
                        }
                        i3 |= i15;
                    } else {
                        jM4207getSurface0d7_KjU = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            i13 = i3;
                            int i16 = composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                            i6 = i13 | i16;
                        } else {
                            i13 = i3;
                        }
                        i6 = i13 | i16;
                    } else {
                        i6 = i3;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i6 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i6 |= composerStartRestartGroup.changed(borderStroke) ? 1048576 : 524288;
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                        i6 |= 12582912;
                    } else {
                        if ((i & 12582912) == 0) {
                            i9 = i8;
                            i6 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                        }
                        i10 = i2 & 256;
                        if (i10 == 0) {
                            if ((i & 100663296) == 0) {
                                i11 = i10;
                                i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i6 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "203@10833L6,204@10875L22");
                                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i6 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i6 &= -458753;
                                    }
                                    borderStroke3 = borderStroke;
                                    f3 = f;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    modifier4 = modifier2;
                                    z4 = z2;
                                    shape3 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    i12 = 2141308794;
                                    j6 = j2;
                                } else {
                                    if (i14 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if (i5 != 0) {
                                        rectangleShape = RectangleShapeKt.getRectangleShape();
                                    }
                                    if ((i2 & 16) != 0) {
                                        jM4207getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4207getSurface0d7_KjU();
                                        i6 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        jM4221contentColorForek8zF_U = ColorsKt.m4221contentColorForek8zF_U(jM4207getSurface0d7_KjU, composerStartRestartGroup, (i6 >> 12) & 14);
                                        i6 &= -458753;
                                    } else {
                                        jM4221contentColorForek8zF_U = j2;
                                    }
                                    BorderStroke borderStroke4 = i7 != 0 ? null : borderStroke;
                                    float fM11017constructorimpl = i9 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                    mutableInteractionSource3 = i11 != 0 ? null : mutableInteractionSource;
                                    f3 = fM11017constructorimpl;
                                    modifier4 = modifier2;
                                    z4 = z2;
                                    shape3 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    j6 = jM4221contentColorForek8zF_U;
                                    i12 = 2141308794;
                                    borderStroke3 = borderStroke4;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i12, i6, -1, "androidx.compose.material.Surface (Surface.kt:209)");
                                }
                                ProvidableCompositionLocal<C1486Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(((C1486Dp) objConsume).m11031unboximpl() + f3);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1486Dp.m11015boximpl(fM11017constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM11017constructorimpl2, borderStroke3, f3, mutableInteractionSource3, z4, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j4 = j6;
                                modifier3 = modifier4;
                                shape2 = shape3;
                                j3 = j5;
                                borderStroke2 = borderStroke3;
                                f2 = f3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                z3 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                borderStroke2 = borderStroke;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape2 = rectangleShape;
                                j3 = jM4207getSurface0d7_KjU;
                                j4 = j2;
                                f2 = f;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z3, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= 100663296;
                        i11 = i10;
                        if ((i & 805306368) == 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if ((i & 805306368) == 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                rectangleShape = shape;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            rectangleShape = shape;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i & 805306368) == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        rectangleShape = shape;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i & 805306368) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_LPr_se0$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, MutableInteractionSource mutableInteractionSource, boolean z, Function0 function0, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C224@11674L7,222@11529L254,215@11282L951:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1766606150, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:215)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2058clickableO2vRcR0$default = ClickableKt.m2058clickableO2vRcR0$default(m4449surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m4450surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), mutableInteractionSource, RippleKt.m4384rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z, null, null, function0, 24, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2058clickableO2vRcR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2077913498, "C238@12214L9:Surface.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4447SurfaceNy5ogXk(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        Shape shape2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        final long j3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final long j4;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM4207getSurface0d7_KjU;
        long jM4221contentColorForek8zF_U;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Shape shape4;
        final long j5;
        final boolean z5;
        final BorderStroke borderStroke4;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-258978402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(selected,onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)322@17136L7,326@17300L1013,323@17160L1153:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function02 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i13 = i3 & 4;
        if (i13 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        shape2 = shape;
                        i4 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    }
                    if ((196608 & i) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(j)) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                        }
                        i10 = i3 & 512;
                        if (i10 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "315@16861L6,316@16903L22");
                            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                j5 = j;
                                f3 = f;
                                mutableInteractionSource3 = mutableInteractionSource;
                                companion = modifier2;
                                z5 = z3;
                                shape4 = shape2;
                                borderStroke4 = borderStroke2;
                                i12 = -258978402;
                                jM4221contentColorForek8zF_U = j2;
                            } else {
                                companion = i13 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                Shape rectangleShape = i6 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                if ((i3 & 32) != 0) {
                                    jM4207getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4207getSurface0d7_KjU();
                                    i4 &= -458753;
                                } else {
                                    jM4207getSurface0d7_KjU = j;
                                }
                                if ((i3 & 64) != 0) {
                                    jM4221contentColorForek8zF_U = ColorsKt.m4221contentColorForek8zF_U(jM4207getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 = (-3670017) & i4;
                                } else {
                                    jM4221contentColorForek8zF_U = j2;
                                }
                                if (i7 != 0) {
                                    borderStroke2 = null;
                                }
                                float fM11017constructorimpl = i9 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                if (i10 != 0) {
                                    f3 = fM11017constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    z5 = z3;
                                    borderStroke4 = borderStroke2;
                                    i12 = -258978402;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    f3 = fM11017constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    z5 = z3;
                                    borderStroke4 = borderStroke2;
                                    i12 = -258978402;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i4, i11, "androidx.compose.material.Surface (Surface.kt:321)");
                            }
                            ProvidableCompositionLocal<C1486Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(((C1486Dp) objConsume).m11031unboximpl() + f3);
                            final Modifier modifier4 = companion;
                            final Function0<Unit> function03 = function02;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM4221contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1486Dp.m11015boximpl(fM11017constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier4, shape4, j5, fM11017constructorimpl2, borderStroke4, f3, z, mutableInteractionSource3, z5, function03, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = jM4221contentColorForek8zF_U;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j3 = j5;
                            borderStroke3 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j3 = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            j4 = j2;
                            f2 = f;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z4, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    i9 = i8;
                    i10 = i3 & 512;
                    if (i10 != 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                shape2 = shape;
                if ((196608 & i) == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 != 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            shape2 = shape;
            if ((196608 & i) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        shape2 = shape;
        if ((196608 & i) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function0 function0, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C336@17702L7,334@17557L254,327@17310L997:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830486238, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:327)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM3196selectableO2vRcR0$default = SelectableKt.m3196selectableO2vRcR0$default(m4449surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m4450surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), z, mutableInteractionSource, RippleKt.m4384rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function0, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM3196selectableO2vRcR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1999142974, "C351@18288L9:Surface.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4448SurfaceNy5ogXk(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        Shape shape2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        final long j3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final long j4;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM4207getSurface0d7_KjU;
        long jM4221contentColorForek8zF_U;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Shape shape4;
        final long j5;
        final boolean z5;
        final BorderStroke borderStroke4;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-391302147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(checked,onCheckedChange,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)435@23284L7,439@23448L1023,436@23308L1163:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function12 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i13 = i3 & 4;
        if (i13 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        shape2 = shape;
                        i4 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    }
                    if ((196608 & i) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(j)) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                        }
                        i10 = i3 & 512;
                        if (i10 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "428@23009L6,429@23051L22");
                            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                j5 = j;
                                f3 = f;
                                mutableInteractionSource3 = mutableInteractionSource;
                                companion = modifier2;
                                z5 = z3;
                                shape4 = shape2;
                                borderStroke4 = borderStroke2;
                                i12 = -391302147;
                                jM4221contentColorForek8zF_U = j2;
                            } else {
                                companion = i13 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                Shape rectangleShape = i6 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                if ((i3 & 32) != 0) {
                                    jM4207getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4207getSurface0d7_KjU();
                                    i4 &= -458753;
                                } else {
                                    jM4207getSurface0d7_KjU = j;
                                }
                                if ((i3 & 64) != 0) {
                                    jM4221contentColorForek8zF_U = ColorsKt.m4221contentColorForek8zF_U(jM4207getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 = (-3670017) & i4;
                                } else {
                                    jM4221contentColorForek8zF_U = j2;
                                }
                                if (i7 != 0) {
                                    borderStroke2 = null;
                                }
                                float fM11017constructorimpl = i9 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                if (i10 != 0) {
                                    f3 = fM11017constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    z5 = z3;
                                    borderStroke4 = borderStroke2;
                                    i12 = -391302147;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    f3 = fM11017constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM4207getSurface0d7_KjU;
                                    z5 = z3;
                                    borderStroke4 = borderStroke2;
                                    i12 = -391302147;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i4, i11, "androidx.compose.material.Surface (Surface.kt:434)");
                            }
                            ProvidableCompositionLocal<C1486Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(((C1486Dp) objConsume).m11031unboximpl() + f3);
                            final Modifier modifier4 = companion;
                            final Function1<? super Boolean, Unit> function13 = function12;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM4221contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1486Dp.m11015boximpl(fM11017constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier4, shape4, j5, fM11017constructorimpl2, borderStroke4, f3, z, mutableInteractionSource3, z5, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = jM4221contentColorForek8zF_U;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j3 = j5;
                            borderStroke3 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j3 = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            j4 = j2;
                            f2 = f;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z4, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    i9 = i8;
                    i10 = i3 & 512;
                    if (i10 != 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                shape2 = shape;
                if ((196608 & i) == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 != 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            shape2 = shape;
            if ((196608 & i) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        shape2 = shape;
        if ((196608 & i) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$2(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function1 function1, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C449@23850L7,447@23705L254,440@23458L1007:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1698162493, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:440)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM3203toggleableO2vRcR0$default = ToggleableKt.m3203toggleableO2vRcR0$default(m4449surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m4450surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), z, mutableInteractionSource, RippleKt.m4384rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function1, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM3203toggleableO2vRcR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1275852541, "C464@24446L9:Surface.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    private static final Modifier m4449surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Modifier modifierM7746shadows4CzXII$default = ShadowKt.m7746shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null);
        Modifier.Companion companionBorder = Modifier.INSTANCE;
        if (borderStroke != null) {
            companionBorder = BorderKt.border(companionBorder, borderStroke, shape);
        }
        return ClipKt.clip(BackgroundKt.m2015backgroundbw27NRU(modifierM7746shadows4CzXII$default.then(companionBorder), j, shape), shape);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    private static final long m4450surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        Composer composer2;
        long jMo4239apply7g2Lkgo;
        ComposerKt.sourceInformationMarkerStart(composer, 1561611256, "C(surfaceColorAtElevation)N(color:c#ui.graphics.Color,elevationOverlay,absoluteElevation:c#ui.unit.Dp)486@24995L6:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:485)");
        }
        if (Color.m8149equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m4207getSurface0d7_KjU()) && elevationOverlay != null) {
            composer.startReplaceGroup(-1124614454);
            ComposerKt.sourceInformation(composer, "487@25066L31");
            composer2 = composer;
            jMo4239apply7g2Lkgo = elevationOverlay.mo4239apply7g2Lkgo(j, f, composer2, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1124546347);
            composer2.endReplaceGroup();
            jMo4239apply7g2Lkgo = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return jMo4239apply7g2Lkgo;
    }
}
