package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.state.ToggleableState;
import androidx.compose.p004ui.state.ToggleableStateKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, m1599d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = C1486Dp.m11017constructorimpl(20);
    private static final float RadiusSize;
    private static final int SnapAnimationDelay = 100;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.f193On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$6(boolean z, Function1 function1, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, stroke, stroke2, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$15(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, stroke, stroke2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$8(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$9(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        CheckboxColors checkboxColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Function0 function0;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource)98@4432L7,99@4492L493:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i7 = composerStartRestartGroup.changed(checkboxColorsColors) ? 16384 : 8192;
                        i3 |= i7;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i7;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                z5 = z3;
                                checkboxColors3 = checkboxColorsColors;
                                mutableInteractionSource4 = null;
                            }
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fFloor = (float) Math.floor(((Density) objConsume).mo2191toPx0680j_4(CheckboxDefaults.INSTANCE.m4722getStrokeWidthD9Ej5fM()));
                            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                            if (function1 == null) {
                                composerStartRestartGroup.startReplaceGroup(2066152950);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481964, "CC(remember):Checkbox.kt#9igjgp");
                                boolean z6 = ((i3 & 112) == 32) | ((i3 & 14) == 4);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CheckboxKt.Checkbox$lambda$2$lambda$1(function1, z);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                function0 = (Function0) objRememberedValue;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(2066218639);
                                composerStartRestartGroup.endReplaceGroup();
                                function0 = null;
                            }
                            composer2 = composerStartRestartGroup;
                            TriStateCheckbox(ToggleableState, function0, new Stroke(fFloor, 0.0f, StrokeCap.INSTANCE.m8526getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor, 0.0f, 0, 0, null, 30, null), modifier4, z5, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z5;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                        Modifier modifier42 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fFloor2 = (float) Math.floor(((Density) objConsume2).mo2191toPx0680j_4(CheckboxDefaults.INSTANCE.m4722getStrokeWidthD9Ej5fM()));
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        if (function1 == null) {
                        }
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(ToggleableState2, function0, new Stroke(fFloor2, 0.0f, StrokeCap.INSTANCE.m8526getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor2, 0.0f, 0, 0, null, 30, null), modifier42, z5, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        z4 = z5;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.Checkbox$lambda$3(z, function1, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                mutableInteractionSource2 = mutableInteractionSource;
                if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$2$lambda$1(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Stroke stroke3;
        Stroke stroke4;
        Modifier modifier2;
        int i4;
        boolean z3;
        CheckboxColors checkboxColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        MutableInteractionSource mutableInteractionSource4;
        CheckboxColors checkboxColors3;
        boolean z5;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(534932591);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)162@7424L439:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            stroke3 = stroke;
        } else {
            stroke3 = stroke;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(stroke3) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            stroke4 = stroke2;
        } else {
            stroke4 = stroke2;
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(stroke4) ? 2048 : 1024;
            }
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i11 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i11;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i11;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                    }
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                    Function0 function0 = null;
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i7 = i6 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i7 = i6;
                        }
                        if (i5 != 0) {
                            mutableInteractionSource4 = null;
                        }
                        z5 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        i9 = 32;
                        i8 = 534932591;
                        Modifier modifier4 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i8, i7, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1848599606);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840532, "CC(remember):Checkbox.kt#9igjgp");
                            boolean z6 = ((i7 & 112) == i9) | ((i7 & 14) == 4);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$5$lambda$4(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1848665295);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(ToggleableState, function0, stroke3, stroke4, modifier4, z5, checkboxColors3, mutableInteractionSource4, composer2, i7 & 33554304, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i7 = i6 & (-3670017);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z3;
                            i7 = i6;
                            i9 = 32;
                            i8 = 534932591;
                            checkboxColors3 = checkboxColorsColors;
                            Modifier modifier42 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                            if (function1 != null) {
                            }
                            composer2 = composerStartRestartGroup;
                            TriStateCheckbox(ToggleableState2, function0, stroke3, stroke4, modifier42, z5, checkboxColors3, mutableInteractionSource4, composer2, i7 & 33554304, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            z4 = z5;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        }
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    z5 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i9 = 32;
                    i8 = 534932591;
                    Modifier modifier422 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ToggleableState ToggleableState22 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                    }
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(ToggleableState22, function0, stroke3, stroke4, modifier422, z5, checkboxColors3, mutableInteractionSource4, composer2, i7 & 33554304, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier422;
                    z4 = z5;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    checkboxColors2 = checkboxColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$6(z, function1, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            z3 = z2;
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        z3 = z2;
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        boolean z2;
        CheckboxColors checkboxColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z4;
        int i6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,colors,interactionSource)215@9923L7,216@9983L337:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i8 = composerStartRestartGroup.changed(checkboxColorsColors) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i8;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier4 = modifier2;
                            z4 = z2;
                            checkboxColors3 = checkboxColorsColors;
                            i6 = 6;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                modifier4 = companion;
                                z4 = z5;
                                i6 = 6;
                                mutableInteractionSource4 = null;
                                checkboxColors3 = checkboxColorsColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                float fFloor = (float) Math.floor(((Density) objConsume).mo2191toPx0680j_4(CheckboxDefaults.INSTANCE.m4722getStrokeWidthD9Ej5fM()));
                                Stroke stroke = new Stroke(fFloor, 0.0f, StrokeCap.INSTANCE.m8526getSquareKaPHkGw(), 0, null, 26, null);
                                Stroke stroke2 = new Stroke(fFloor, 0.0f, 0, 0, null, 30, null);
                                int i9 = i3 & WebSocketProtocol.PAYLOAD_SHORT;
                                int i10 = i3 << i6;
                                composer2 = composerStartRestartGroup;
                                TriStateCheckbox(toggleableState, function02, stroke, stroke2, modifier4, z4, checkboxColors3, mutableInteractionSource4, composer2, i9 | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z3 = z4;
                                checkboxColors2 = checkboxColors3;
                                mutableInteractionSource3 = mutableInteractionSource4;
                            } else {
                                modifier4 = companion;
                                z4 = z5;
                                i6 = 6;
                                checkboxColors3 = checkboxColorsColors;
                            }
                        }
                        mutableInteractionSource4 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fFloor2 = (float) Math.floor(((Density) objConsume2).mo2191toPx0680j_4(CheckboxDefaults.INSTANCE.m4722getStrokeWidthD9Ej5fM()));
                        Stroke stroke3 = new Stroke(fFloor2, 0.0f, StrokeCap.INSTANCE.m8526getSquareKaPHkGw(), 0, null, 26, null);
                        Stroke stroke22 = new Stroke(fFloor2, 0.0f, 0, 0, null, 30, null);
                        int i92 = i3 & WebSocketProtocol.PAYLOAD_SHORT;
                        int i102 = i3 << i6;
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(toggleableState, function02, stroke3, stroke22, modifier4, z4, checkboxColors3, mutableInteractionSource4, composer2, i92 | (57344 & i102) | (458752 & i102) | (3670016 & i102) | (i102 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier4;
                        z3 = z4;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$8(toggleableState, function0, modifier3, z3, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                mutableInteractionSource2 = mutableInteractionSource;
                if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Stroke stroke3;
        Modifier modifier2;
        int i4;
        boolean z2;
        CheckboxColors checkboxColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        Composer composer2;
        final boolean z3;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        Modifier.Companion companionM3208triStateToggleableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        Composer composerStartRestartGroup = composer.startRestartGroup(-406243761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)289@13489L543:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(stroke) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            stroke3 = stroke2;
        } else {
            stroke3 = stroke2;
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(stroke3) ? 2048 : 1024;
            }
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            } else {
                if ((196608 & i) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i8 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i8;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i8;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i5 = i2 & 128;
                if (i5 == 0) {
                    if ((12582912 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "273@12959L8");
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            i6 = i3;
                            z4 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier2;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                mutableInteractionSource3 = null;
                                i6 = i3;
                                z4 = z2;
                            } else {
                                i6 = i3;
                                z4 = z2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-406243761, i6, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:275)");
                        }
                        if (function0 != null) {
                            boolean z5 = z4;
                            companionM3208triStateToggleableO2vRcR0 = ToggleableKt.m3208triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource3, RippleKt.m5482rippleH2RKhps$default(false, C1486Dp.m11017constructorimpl(CheckboxTokens.INSTANCE.m6436getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m10186boximpl(Role.INSTANCE.m10195getCheckboxo7Vup1c()), function0);
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource3;
                            companionM3208triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM3208triStateToggleableO2vRcR0), CheckboxDefaultPadding);
                        int i9 = i6 << 6;
                        CheckboxColors checkboxColors3 = checkboxColorsColors;
                        CheckboxImpl(z4, toggleableState, modifierM2854padding3ABfNKs, checkboxColors3, stroke, stroke3, composerStartRestartGroup, ((i6 >> 15) & 14) | ((i6 << 3) & 112) | ((i6 >> 9) & 7168) | (57344 & i9) | (i9 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z4;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier4;
                        checkboxColors2 = checkboxColors3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        z3 = z2;
                        checkboxColors2 = checkboxColorsColors;
                    }
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$9(toggleableState, function0, stroke, stroke2, modifier3, z3, checkboxColors2, mutableInteractionSource4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
                if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, final Stroke stroke, final Stroke stroke2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        int i4;
        float f;
        Float f2;
        ToggleableState toggleableState2;
        int i5;
        float f3;
        final State stateCreateTransitionAnimation;
        int i6;
        float f4;
        int i7;
        float f5;
        final State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        final CheckDrawingCache checkDrawingCache;
        final State<Color> stateCheckmarkColor$material3;
        final State<Color> stateBoxColor$material3;
        final State<Color> stateBorderColor$material3;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-891330208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors,checkmarkStroke,outlineStroke)402@18923L23,403@19015L14,405@19077L608,423@19752L594,439@20368L32,440@20429L21,441@20477L24,442@20531L27,443@20641L476,443@20563L554:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stroke) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stroke2) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891330208, i2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:401)");
            }
            int i8 = i2 >> 3;
            int i9 = i8 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i9, 2);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i10) {
                    composer3.startReplaceGroup(1780794470);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1780794470, i10, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:407)");
                    }
                    SnapSpec snapSpecSnap = (segment.getInitialState() != ToggleableState.Off && segment.getTargetState() == ToggleableState.Off) ? AnimationSpecKt.snap(100) : finiteAnimationSpecValue;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return snapSpecSnap;
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState3 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                i3 = i2;
                i4 = i9;
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
            } else {
                i3 = i2;
                i4 = i9;
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i10 == 1) {
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf = Float.valueOf(f);
                ToggleableState toggleableState4 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-768316570);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    f2 = fValueOf;
                    toggleableState2 = toggleableState4;
                    ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
                } else {
                    f2 = fValueOf;
                    toggleableState2 = toggleableState4;
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
                if (i5 == 1) {
                    f3 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, f2, Float.valueOf(f3), function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i11) {
                            SnapSpec snapSpecSnap;
                            composer3.startReplaceGroup(630790831);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(630790831, i11, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snapSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snapSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : finiteAnimationSpecValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return snapSpecSnap;
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState5 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                    if (i6 == 1 || i6 == 2) {
                        f4 = 0.0f;
                    } else {
                        if (i6 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f4 = 1.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Float fValueOf2 = Float.valueOf(f4);
                    ToggleableState toggleableState6 = (ToggleableState) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
                    }
                    i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState6.ordinal()];
                    if (i7 != 1 || i7 == 2) {
                        f5 = 0.0f;
                    } else {
                        if (i7 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f5 = 1.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f5), function32.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1869784640, "CC(remember):Checkbox.kt#9igjgp");
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        Object checkDrawingCache2 = new CheckDrawingCache(null, null, null, 7, null);
                        composer2.updateRememberedValue(checkDrawingCache2);
                        objRememberedValue = checkDrawingCache2;
                    }
                    checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i4 | ((i3 >> 6) & 112));
                    int i11 = (i8 & 896) | (i3 & WebSocketProtocol.PAYLOAD_SHORT);
                    stateBoxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i11);
                    stateBorderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i11);
                    Modifier modifierM2916requiredSize3ABfNKs = SizeKt.m2916requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1869775460, "CC(remember):Checkbox.kt#9igjgp");
                    zChanged = composer2.changed(stateBoxColor$material3) | composer2.changed(stateBorderColor$material3) | composer2.changedInstance(stroke2) | composer2.changed(stateCheckmarkColor$material3) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2) | composer2.changedInstance(stroke);
                    objRememberedValue2 = composer2.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        Object obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$14$lambda$13(stateBoxColor$material3, stateBorderColor$material3, stroke2, stateCheckmarkColor$material3, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke, checkDrawingCache, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                        objRememberedValue2 = obj;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierM2916requiredSize3ABfNKs, (Function1) objRememberedValue2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else if (i5 != 2) {
                    if (i5 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f3 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, f2, Float.valueOf(f3), function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function322 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i112) {
                            SnapSpec snapSpecSnap;
                            composer3.startReplaceGroup(630790831);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(630790831, i112, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snapSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snapSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : finiteAnimationSpecValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return snapSpecSnap;
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState52 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState52.ordinal()];
                    if (i6 == 1) {
                        f4 = 0.0f;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Float fValueOf22 = Float.valueOf(f4);
                        ToggleableState toggleableState62 = (ToggleableState) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceGroup(1840054703);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState62.ordinal()];
                        if (i7 != 1) {
                            f5 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf22, Float.valueOf(f5), function322.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter22, "FloatAnimation", composerStartRestartGroup, 0);
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1869784640, "CC(remember):Checkbox.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i4 | ((i3 >> 6) & 112));
                            int i112 = (i8 & 896) | (i3 & WebSocketProtocol.PAYLOAD_SHORT);
                            stateBoxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i112);
                            stateBorderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i112);
                            Modifier modifierM2916requiredSize3ABfNKs2 = SizeKt.m2916requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1869775460, "CC(remember):Checkbox.kt#9igjgp");
                            zChanged = composer2.changed(stateBoxColor$material3) | composer2.changed(stateBorderColor$material3) | composer2.changedInstance(stroke2) | composer2.changed(stateCheckmarkColor$material3) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2) | composer2.changedInstance(stroke);
                            objRememberedValue2 = composer2.rememberedValue();
                            if (!zChanged) {
                                Object obj2 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj22) {
                                        return CheckboxKt.CheckboxImpl$lambda$14$lambda$13(stateBoxColor$material3, stateBorderColor$material3, stroke2, stateCheckmarkColor$material3, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke, checkDrawingCache, (DrawScope) obj22);
                                    }
                                };
                                composer2.updateRememberedValue(obj2);
                                objRememberedValue2 = obj2;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                CanvasKt.Canvas(modifierM2916requiredSize3ABfNKs2, (Function1) objRememberedValue2, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                        }
                    }
                } else {
                    f3 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, f2, Float.valueOf(f3), function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function3222 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i1122) {
                            SnapSpec snapSpecSnap;
                            composer3.startReplaceGroup(630790831);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(630790831, i1122, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snapSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snapSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : finiteAnimationSpecValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return snapSpecSnap;
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState522 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState522.ordinal()];
                    if (i6 == 1) {
                    }
                }
            } else if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf3 = Float.valueOf(f);
                ToggleableState toggleableState42 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-768316570);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
                if (i5 == 1) {
                }
            } else {
                f = 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf32 = Float.valueOf(f);
                ToggleableState toggleableState422 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-768316570);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
                if (i5 == 1) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return CheckboxKt.CheckboxImpl$lambda$15(z, toggleableState, modifier, checkboxColors, stroke, stroke2, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$14$lambda$13(State state, State state2, Stroke stroke, State state3, State state4, State state5, Stroke stroke2, CheckDrawingCache checkDrawingCache, DrawScope drawScope) {
        m4727drawBox1wkBAMs(drawScope, ((Color) state.getValue()).m8158unboximpl(), ((Color) state2.getValue()).m8158unboximpl(), drawScope.mo2191toPx0680j_4(RadiusSize), stroke);
        m4728drawCheck3IgeMak(drawScope, ((Color) state3.getValue()).m8158unboximpl(), ((Number) state4.getValue()).floatValue(), ((Number) state5.getValue()).floatValue(), stroke2, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m4727drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() >> 32));
        if (!Color.m8149equalsimpl0(j, j2)) {
            long jM7895constructorimpl = Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(stroke.getWidth())) << 32) | (((long) Float.floatToRawIntBits(stroke.getWidth())) & 4294967295L));
            float f2 = 2;
            long jM7963constructorimpl = Size.m7963constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f2))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f2))) & 4294967295L));
            float fMax = Math.max(0.0f, f - stroke.getWidth());
            DrawScope.m8725drawRoundRectuAw5IA$default(drawScope, j, jM7895constructorimpl, jM7963constructorimpl, CornerRadius.m7857constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
            long jM7895constructorimpl2 = Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(width)) << 32) | (((long) Float.floatToRawIntBits(width)) & 4294967295L));
            float width2 = fIntBitsToFloat - stroke.getWidth();
            float f3 = f - width;
            DrawScope.m8725drawRoundRectuAw5IA$default(drawScope, j2, jM7895constructorimpl2, Size.m7963constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - stroke.getWidth())) & 4294967295L) | (Float.floatToRawIntBits(width2) << 32)), CornerRadius.m7857constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
            return;
        }
        DrawScope.m8725drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m7963constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), CornerRadius.m7857constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m4728drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, Stroke stroke, CheckDrawingCache checkDrawingCache) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo8729getSizeNHjbRc() >> 32));
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().rewind();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().rewind();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m8719drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = C1486Dp.m11017constructorimpl(f);
        RadiusSize = C1486Dp.m11017constructorimpl(f);
    }
}
