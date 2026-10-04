package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, m1599d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "RadioAnimationDuration", "", "RadioButtonRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonSize", "RadioRadius", "RadioButtonDotSize", "RadioStrokeWidth", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = C1486Dp.m11017constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, mutableInteractionSource, radioButtonColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        RadioButtonColors radioButtonColors2;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Composer composer2;
        int i6;
        RadioButtonColors radioButtonColorsM4379colorsRGew2ao;
        MutableInteractionSource mutableInteractionSource4;
        int i7;
        float fM11017constructorimpl;
        ?? r14;
        Modifier modifier4;
        int i8;
        Modifier.Companion companionM3195selectableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        Composer composerStartRestartGroup = composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)N(selected,onClick,modifier,enabled,interactionSource,colors)82@3703L177,86@3909L29,113@4796L386,100@4389L793:RadioButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
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
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            radioButtonColors2 = radioButtonColors;
                            int i10 = composerStartRestartGroup.changed(radioButtonColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            radioButtonColors2 = radioButtonColors;
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i6 = i3;
                            companion = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM4379colorsRGew2ao = radioButtonColors2;
                        } else {
                            companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            z5 = i4 != 0 ? true : z3;
                            MutableInteractionSource mutableInteractionSource5 = i5 != 0 ? null : mutableInteractionSource2;
                            if ((i2 & 32) != 0) {
                                composer2 = composerStartRestartGroup;
                                i6 = i3 & (-458753);
                                radioButtonColorsM4379colorsRGew2ao = RadioButtonDefaults.INSTANCE.m4379colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i6 = i3;
                                radioButtonColorsM4379colorsRGew2ao = radioButtonColors2;
                            }
                            mutableInteractionSource4 = mutableInteractionSource5;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1314435585, i6, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                        }
                        if (z) {
                            i7 = 2;
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(RadioButtonDotSize / 2);
                        } else {
                            i7 = 2;
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                        }
                        int i11 = i7;
                        int i12 = i6;
                        composerStartRestartGroup = composer2;
                        final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(fM11017constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                        int i13 = i12 >> 9;
                        final State<Color> stateRadioColor = radioButtonColorsM4379colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, ((i12 << 3) & 112) | (i13 & 14) | (i13 & 896));
                        if (function0 != null) {
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            int iM10198getRadioButtono7Vup1c = Role.INSTANCE.m10198getRadioButtono7Vup1c();
                            IndicationNodeFactory indicationNodeFactoryM4384rippleH2RKhps$default = RippleKt.m4384rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null);
                            Role roleM10186boximpl = Role.m10186boximpl(iM10198getRadioButtono7Vup1c);
                            modifier4 = companion;
                            radioButtonColors2 = radioButtonColorsM4379colorsRGew2ao;
                            r14 = 0;
                            z4 = z5;
                            i8 = i11;
                            companionM3195selectableO2vRcR0 = SelectableKt.m3195selectableO2vRcR0(companion2, z, mutableInteractionSource4, indicationNodeFactoryM4384rippleH2RKhps$default, z4, roleM10186boximpl, function0);
                        } else {
                            radioButtonColors2 = radioButtonColorsM4379colorsRGew2ao;
                            r14 = 0;
                            modifier4 = companion;
                            z4 = z5;
                            i8 = i11;
                            companionM3195selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierM2916requiredSize3ABfNKs = SizeKt.m2916requiredSize3ABfNKs(PaddingKt.m2854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM3195selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r14, i8, null), RadioButtonPadding), RadioButtonSize);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                        boolean zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM1892animateDpAsStateAjpBEmI);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM1892animateDpAsStateAjpBEmI, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2916requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, r14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    final RadioButtonColors radioButtonColors3 = radioButtonColors2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z4, mutableInteractionSource3, radioButtonColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) != 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                final RadioButtonColors radioButtonColors32 = radioButtonColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            final RadioButtonColors radioButtonColors322 = radioButtonColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        final RadioButtonColors radioButtonColors3222 = radioButtonColors2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$0$0(State state, State state2, DrawScope drawScope) {
        float f = drawScope.mo2191toPx0680j_4(RadioStrokeWidth);
        float f2 = f / 2;
        DrawScope.m8710drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m8158unboximpl(), drawScope.mo2191toPx0680j_4(RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (C1486Dp.m11016compareTo0680j_4(((C1486Dp) state2.getValue()).m11031unboximpl(), C1486Dp.m11017constructorimpl(0)) > 0) {
            DrawScope.m8710drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m8158unboximpl(), drawScope.mo2191toPx0680j_4(((C1486Dp) state2.getValue()).m11031unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static {
        float f = 2;
        RadioButtonPadding = C1486Dp.m11017constructorimpl(f);
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(20);
        RadioButtonSize = fM11017constructorimpl;
        RadioRadius = C1486Dp.m11017constructorimpl(fM11017constructorimpl / f);
        RadioButtonDotSize = C1486Dp.m11017constructorimpl(12);
        RadioStrokeWidth = C1486Dp.m11017constructorimpl(f);
    }
}
