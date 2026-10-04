package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.RadioButtonTokens;
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
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, m1599d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RadioButtonKt {
    private static final float RadioButtonDotSize = C1486Dp.m11017constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, radioButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        RadioButtonColors radioButtonColorsColors;
        int i5;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final RadioButtonColors radioButtonColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource3;
        int i6;
        boolean z5;
        RadioButtonColors radioButtonColors3;
        float fM11017constructorimpl;
        final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI;
        final State<Color> stateRadioColor$material3;
        Object obj;
        Modifier modifier4;
        RadioButtonColors radioButtonColors4;
        Modifier.Companion companionM3195selectableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(408580840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)N(selected,onClick,modifier,enabled,colors,interactionSource)85@4070L7,82@3836L252,87@4117L29,114@5028L416,101@4610L834:RadioButton.kt#uh7d8r");
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
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
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        radioButtonColorsColors = radioButtonColors;
                        int i8 = composerStartRestartGroup.changed(radioButtonColorsColors) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        radioButtonColorsColors = radioButtonColors;
                    }
                    i3 |= i8;
                } else {
                    radioButtonColorsColors = radioButtonColors;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                    }
                    if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            i6 = i3;
                            companion = modifier2;
                        } else {
                            companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                i6 = i3;
                                z5 = z3;
                                radioButtonColors3 = radioButtonColorsColors;
                                mutableInteractionSource3 = null;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(408580840, i6, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                                }
                                if (!z) {
                                    fM11017constructorimpl = C1486Dp.m11017constructorimpl(RadioButtonDotSize / 2);
                                } else {
                                    fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                                }
                                stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(fM11017constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                                stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z5, z, composerStartRestartGroup, ((i6 >> 6) & 896) | ((i6 >> 9) & 14) | ((i6 << 3) & 112));
                                if (function0 == null) {
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    int iM10198getRadioButtono7Vup1c = Role.INSTANCE.m10198getRadioButtono7Vup1c();
                                    IndicationNodeFactory indicationNodeFactoryM5482rippleH2RKhps$default = RippleKt.m5482rippleH2RKhps$default(false, C1486Dp.m11017constructorimpl(RadioButtonTokens.INSTANCE.m6944getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null);
                                    Role roleM10186boximpl = Role.m10186boximpl(iM10198getRadioButtono7Vup1c);
                                    Modifier modifier5 = companion;
                                    z4 = z5;
                                    modifier4 = modifier5;
                                    radioButtonColors4 = radioButtonColors3;
                                    obj = null;
                                    companionM3195selectableO2vRcR0 = SelectableKt.m3195selectableO2vRcR0(companion2, z, mutableInteractionSource3, indicationNodeFactoryM5482rippleH2RKhps$default, z4, roleM10186boximpl, function0);
                                } else {
                                    obj = null;
                                    modifier4 = companion;
                                    radioButtonColors4 = radioButtonColors3;
                                    z4 = z5;
                                    companionM3195selectableO2vRcR0 = Modifier.INSTANCE;
                                }
                                if (function0 == null) {
                                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                                } else {
                                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                                }
                                Modifier modifierM2916requiredSize3ABfNKs = SizeKt.m2916requiredSize3ABfNKs(PaddingKt.m2854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM3195selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, obj), RadioButtonPadding), RadioButtonTokens.INSTANCE.m6943getIconSizeD9Ej5fM());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804211304, "CC(remember):RadioButton.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM1892animateDpAsStateAjpBEmI);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return RadioButtonKt.RadioButton$lambda$1$lambda$0(stateRadioColor$material3, stateM1892animateDpAsStateAjpBEmI, (DrawScope) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                CanvasKt.Canvas(modifierM2916requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource2 = mutableInteractionSource3;
                                radioButtonColors2 = radioButtonColors4;
                                modifier3 = modifier4;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                i6 = i3;
                            }
                        }
                        z5 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (!z) {
                        }
                        stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(fM11017constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                        stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z5, z, composerStartRestartGroup, ((i6 >> 6) & 896) | ((i6 >> 9) & 14) | ((i6 << 3) & 112));
                        if (function0 == null) {
                        }
                        if (function0 == null) {
                        }
                        Modifier modifierM2916requiredSize3ABfNKs2 = SizeKt.m2916requiredSize3ABfNKs(PaddingKt.m2854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM3195selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, obj), RadioButtonPadding), RadioButtonTokens.INSTANCE.m6943getIconSizeD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804211304, "CC(remember):RadioButton.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM1892animateDpAsStateAjpBEmI);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return RadioButtonKt.RadioButton$lambda$1$lambda$0(stateRadioColor$material3, stateM1892animateDpAsStateAjpBEmI, (DrawScope) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2916requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            radioButtonColors2 = radioButtonColors4;
                            modifier3 = modifier4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z4 = z3;
                        radioButtonColors2 = radioButtonColorsColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return RadioButtonKt.RadioButton$lambda$2(z, function0, modifier3, z4, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$1$lambda$0(State state, State state2, DrawScope drawScope) {
        float f = drawScope.mo2191toPx0680j_4(RadioStrokeWidth);
        float f2 = 2;
        float f3 = f / f2;
        DrawScope.m8710drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m8158unboximpl(), drawScope.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(RadioButtonTokens.INSTANCE.m6943getIconSizeD9Ej5fM() / f2)) - f3, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (C1486Dp.m11016compareTo0680j_4(((C1486Dp) state2.getValue()).m11031unboximpl(), C1486Dp.m11017constructorimpl(0)) > 0) {
            DrawScope.m8710drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m8158unboximpl(), drawScope.mo2191toPx0680j_4(((C1486Dp) state2.getValue()).m11031unboximpl()) - f3, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static {
        float f = 2;
        RadioButtonPadding = C1486Dp.m11017constructorimpl(f);
        RadioStrokeWidth = C1486Dp.m11017constructorimpl(f);
    }
}
