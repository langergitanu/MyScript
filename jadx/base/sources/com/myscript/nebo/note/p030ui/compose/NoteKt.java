package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.focus.FocusRequesterModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.dms.p026ui.compose.components.FadingEdgeModifierKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: note.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001aT\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u001aX\u008a\u0084\u0002"}, m1599d2 = {"NoteNameField", "", "name", "", "modifier", "Landroidx/compose/ui/Modifier;", "nameHint", "", "onNoteNameChanged", "Lkotlin/Function1;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NotebookCoverList", "covers", "", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "selectedIndex", "onColorSelected", "Lkotlin/ParameterName;", FirebaseAnalytics.Param.INDEX, "(Ljava/util/List;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ColorPill", "color", "Landroidx/compose/ui/graphics/Color;", "isSelected", "", "size", "Landroidx/compose/ui/unit/Dp;", "onClick", "Lkotlin/Function0;", "ColorPill-L8y2Mks", "(JLandroidx/compose/ui/Modifier;ZFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease", "currentColorPillsSpacing", "animatedColorPillsSpacing", "animatedAlpha", "", "selectionFeedbackSize"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ColorPill_L8y2Mks$lambda$3(long j, Modifier modifier, boolean z, float f, Function0 function0, int i, int i2, Composer composer, int i3) {
        m13309ColorPillL8y2Mks(j, modifier, z, f, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteNameField$lambda$5(String str, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        NoteNameField(str, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotebookCoverList$lambda$6(List list, int i, Modifier modifier, Function1 function1, int i2, int i3, Composer composer, int i4) {
        NotebookCoverList(list, i, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NoteNameField(final String name, Modifier modifier, int i, Function1<? super String, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        Function1<? super String, Unit> function12;
        int i8;
        Composer composer2;
        final Modifier modifier3;
        final int i9;
        final Function1<? super String, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Continuation continuation;
        String str;
        int i10;
        Intrinsics.checkNotNullParameter(name, "name");
        Composer composerStartRestartGroup = composer.startRestartGroup(-75675141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteNameField)N(name,modifier,nameHint,onNoteNameChanged)47@2125L49,48@2200L29,49@2265L128,49@2234L159,61@2770L6,61@2834L6,61@2722L129,56@2475L118,60@2615L66,54@2399L646:note.kt#ku1rws");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(name) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
                }
                i7 = i3 & 8;
                if (i7 == 0) {
                    if ((i2 & 3072) == 0) {
                        function12 = function1;
                        i4 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i8 = i4;
                    if (composerStartRestartGroup.shouldExecute((i8 & 1171) == 1170, i8 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        i9 = i6;
                        function13 = function12;
                    } else {
                        Modifier modifier4 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i5 != 0) {
                            i6 = 0;
                        }
                        if (i7 != 0) {
                            function12 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-75675141, i8, -1, "com.myscript.nebo.note.ui.compose.NoteNameField (note.kt:46)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 290638764, "CC(remember):note.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            str = "CC(remember):note.kt#9igjgp";
                            continuation = null;
                            i10 = i6;
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(name, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            continuation = null;
                            str = "CC(remember):note.kt#9igjgp";
                            i10 = i6;
                        }
                        final MutableState mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 290641144, str);
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 290643323, str);
                        boolean z = (i8 & 14) == 4;
                        NoteKt$NoteNameField$1$1 noteKt$NoteNameField$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || noteKt$NoteNameField$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            noteKt$NoteNameField$1$1RememberedValue = new NoteKt$NoteNameField$1$1(focusRequester, mutableState, name, continuation);
                            composerStartRestartGroup.updateRememberedValue(noteKt$NoteNameField$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(focusRequester, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) noteKt$NoteNameField$1$1RememberedValue, composerStartRestartGroup, 6);
                        TextFieldValue textFieldValue = (TextFieldValue) mutableState.getValue();
                        Modifier modifier5 = modifier4;
                        Function1<? super String, Unit> function14 = function12;
                        TextFieldColors textFieldColorsM4499textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m4499textFieldColorsdx8h9Zs(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.03f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097146);
                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(PaddingKt.m2858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, continuation), 0.0f, C1486Dp.m11017constructorimpl(0), 0.0f, 0.0f, 13, null), focusRequester);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 290650033, str);
                        boolean z2 = (i8 & 7168) == 2048;
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            function13 = function14;
                            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NoteKt.NoteNameField$lambda$3$0(mutableState, function13, (TextFieldValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            function13 = function14;
                        }
                        Function1 function15 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final int i12 = i10;
                        composer2 = composerStartRestartGroup;
                        TextFieldKt.TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function15, modifierFocusRequester, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1308779735, true, new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NoteKt.NoteNameField$lambda$4(i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM4499textFieldColorsdx8h9Zs, composer2, 1572864, 24576, 507832);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i9 = i12;
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NoteKt.NoteNameField$lambda$5(name, modifier3, i9, function13, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 3072;
                function12 = function1;
                i8 = i4;
                if (composerStartRestartGroup.shouldExecute((i8 & 1171) == 1170, i8 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i6 = i;
            i7 = i3 & 8;
            if (i7 == 0) {
            }
            function12 = function1;
            i8 = i4;
            if (composerStartRestartGroup.shouldExecute((i8 & 1171) == 1170, i8 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        i6 = i;
        i7 = i3 & 8;
        if (i7 == 0) {
        }
        function12 = function1;
        i8 = i4;
        if (composerStartRestartGroup.shouldExecute((i8 & 1171) == 1170, i8 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteNameField$lambda$3$0(MutableState mutableState, Function1 function1, TextFieldValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        mutableState.setValue(value);
        if (function1 != null) {
            function1.invoke(value.getText());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteNameField$lambda$4(int i, Composer composer, int i2) {
        String strStringResource;
        ComposerKt.sourceInformation(composer, "C60@2617L62:note.kt#ku1rws");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1308779735, i2, -1, "com.myscript.nebo.note.ui.compose.NoteNameField.<anonymous> (note.kt:60)");
            }
            if (i != 0) {
                composer.startReplaceGroup(-688091532);
                ComposerKt.sourceInformation(composer, "60@2641L29");
                strStringResource = StringResources_androidKt.stringResource(i, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(144032871);
                composer.endReplaceGroup();
                strStringResource = "";
            }
            TextKt.m4524Text4IGK_g(strStringResource, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NotebookCoverList(final List<CoverData> covers, final int i, Modifier modifier, Function1<? super Integer, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Function1<? super Integer, Unit> function12;
        final Modifier modifier3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(covers, "covers");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1482045403);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotebookCoverList)N(covers,selectedIndex,modifier,onColorSelected)71@3232L23,74@3327L47,75@3412L195,80@3633L124,80@3612L145,86@3832L6,89@4019L203,85@3763L459:note.kt#ku1rws");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(covers) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i6 = i3 & 4;
        if (i6 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    function12 = function1;
                    i4 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                }
                if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function13 = function12;
                } else {
                    Modifier modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i5 != 0) {
                        function12 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1482045403, i4, -1, "com.myscript.nebo.note.ui.compose.NotebookCoverList (note.kt:70)");
                    }
                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    float fM11017constructorimpl = C1486Dp.m11017constructorimpl(12);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1683518548, "CC(remember):note.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(-fM11017constructorimpl)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function1<? super Integer, Unit> function14 = function12;
                    State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(NotebookCoverList$lambda$1(mutableState), AnimationSpecKt.spring$default(0.5f, 50.0f, null, 4, null), "color pills spacing", null, composerStartRestartGroup, 432, 8);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1683528417, "CC(remember):note.kt#9igjgp");
                    NoteKt$NotebookCoverList$1$1 noteKt$NotebookCoverList$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (noteKt$NotebookCoverList$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        noteKt$NotebookCoverList$1$1RememberedValue = new NoteKt$NotebookCoverList$1$1(fM11017constructorimpl, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(noteKt$NotebookCoverList$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) noteKt$NotebookCoverList$1$1RememberedValue, composerStartRestartGroup, 6);
                    Modifier modifierM13021fadingEdgesbN7B8ug = FadingEdgeModifierKt.m13021fadingEdgesbN7B8ug(modifier4, lazyListStateRememberLazyListState, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4196getBackground0d7_KjU(), C1486Dp.m11017constructorimpl(48), Orientation.Horizontal);
                    Modifier modifier5 = modifier4;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(NotebookCoverList$lambda$3(stateM1892animateDpAsStateAjpBEmI));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1683540848, "CC(remember):note.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(covers) | ((i4 & 112) == 32) | ((i4 & 7168) == 2048);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NoteKt.NotebookCoverList$lambda$5$0(covers, i, function14, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LazyDslKt.LazyRow(modifierM13021fadingEdgesbN7B8ug, lazyListStateRememberLazyListState, null, false, horizontalOrVerticalM2528spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 492);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function13 = function14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NoteKt.NotebookCoverList$lambda$6(covers, i, modifier3, function13, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 3072;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final float NotebookCoverList$lambda$1(MutableState<C1486Dp> mutableState) {
        return mutableState.getValue().m11031unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NotebookCoverList$lambda$2(MutableState<C1486Dp> mutableState, float f) {
        mutableState.setValue(C1486Dp.m11015boximpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ColorPill-L8y2Mks, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m13309ColorPillL8y2Mks(final long j, Modifier modifier, boolean z, float f, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        float f2;
        final Modifier modifier3;
        final boolean z3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(672046560);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ColorPill)N(color:c#ui.graphics.Color,modifier,isSelected,size:c#ui.unit.Dp,onClick)100@4392L111,101@4551L6,103@4630L211,108@4847L640:note.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        f2 = f;
                        i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
                    }
                    if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        f3 = f2;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z4 = i4 != 0 ? false : z2;
                        float fM11017constructorimpl = i5 != 0 ? C1486Dp.m11017constructorimpl(32) : f2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(672046560, i3, -1, "com.myscript.nebo.note.ui.compose.ColorPill (note.kt:99)");
                        }
                        long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ColorPill_L8y2Mks$lambda$0(AnimateAsStateKt.animateFloatAsState(z4 ? 0.08f : 0.0f, null, 0.0f, "color pill selection feedback alpha", null, composerStartRestartGroup, 3072, 22)), 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup = composerStartRestartGroup;
                        State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(z4 ? fM11017constructorimpl : C1486Dp.m11017constructorimpl(0), AnimationSpecKt.spring$default(0.5f, 50.0f, null, 4, null), "color pill selection feedback size", null, composerStartRestartGroup, 432, 8);
                        float f4 = fM11017constructorimpl;
                        Modifier modifier4 = companion;
                        Modifier modifierM2062clickableoSLSa3U$default = ClickableKt.m2062clickableoSLSa3U$default(SizeKt.m2924size3ABfNKs(ClipKt.clip(companion, RoundedCornerShapeKt.getCircleShape()), fM11017constructorimpl), false, null, Role.m10186boximpl(Role.INSTANCE.m10193getButtono7Vup1c()), null, onClick, 11, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2062clickableoSLSa3U$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1789930122, "C115@5090L206,121@5305L176:note.kt#ku1rws");
                        BoxKt.Box(SizeKt.m2924size3ABfNKs(BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(modifier4, RoundedCornerShapeKt.getCircleShape()), jM8147copywmQWz5c$default, null, 2, null), ColorPill_L8y2Mks$lambda$1(stateM1892animateDpAsStateAjpBEmI)), composerStartRestartGroup, 0);
                        BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.m2924size3ABfNKs(ClipKt.clip(modifier4, RoundedCornerShapeKt.getCircleShape()), C1486Dp.m11017constructorimpl(f4 / 2)), j, null, 2, null), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f3 = f4;
                        modifier3 = modifier4;
                        z3 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NoteKt.ColorPill_L8y2Mks$lambda$3(j, modifier3, z3, f3, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                f2 = f;
                if ((i & 24576) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            f2 = f;
            if ((i & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
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
        if (i5 == 0) {
        }
        f2 = f;
        if ((i & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotebookCoverList$lambda$5$0(final List list, final int i, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$NotebookCoverList$lambda$5$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i2) {
                list.get(i2);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$NotebookCoverList$lambda$5$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, final int i2, Composer composer, int i3) {
                int i4;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                if ((i3 & 6) == 0) {
                    i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i3;
                } else {
                    i4 = i3;
                }
                if ((i3 & 48) == 0) {
                    i4 |= composer.changed(i2) ? 32 : 16;
                }
                if (!composer.shouldExecute((i4 & 147) != 146, i4 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i4, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                CoverData coverData = (CoverData) list.get(i2);
                composer.startReplaceGroup(-753855914);
                ComposerKt.sourceInformation(composer, "CN(index,cover)*91@4144L62,91@4080L126:note.kt#ku1rws");
                long jM13291getPillColor0d7_KjU = coverData.m13291getPillColor0d7_KjU();
                boolean z = i2 == i;
                ComposerKt.sourceInformationMarkerStart(composer, 1915346701, "CC(remember):note.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | ((((i4 & 112) ^ 48) > 32 && composer.changed(i2)) || (i4 & 48) == 32);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function12 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.note.ui.compose.NoteKt$NotebookCoverList$2$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function1<Integer, Unit> function13 = function12;
                            if (function13 != null) {
                                function13.invoke(Integer.valueOf(i2));
                            }
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                NoteKt.m13309ColorPillL8y2Mks(jM13291getPillColor0d7_KjU, null, z, 0.0f, (Function0) objRememberedValue, composer, 0, 10);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    private static final float NotebookCoverList$lambda$3(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float ColorPill_L8y2Mks$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float ColorPill_L8y2Mks$lambda$1(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }
}
