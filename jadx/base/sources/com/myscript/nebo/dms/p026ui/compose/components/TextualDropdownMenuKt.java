package com.myscript.nebo.dms.p026ui.compose.components;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
import androidx.compose.material.ExposedDropdownMenuDefaults;
import androidx.compose.material.ExposedDropdownMenu_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: textualDropdownMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u001am\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\t2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002"}, m1599d2 = {"TextualDropdownMenu", "", ExifInterface.GPS_DIRECTION_TRUE, "modifier", "Landroidx/compose/ui/Modifier;", "label", "", "options", "", "Lcom/myscript/nebo/dms/ui/compose/components/TextualDropdownOption;", "selectedOption", "onOptionSelected", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/util/List;Lcom/myscript/nebo/dms/ui/compose/components/TextualDropdownOption;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "dms_release", "expanded", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextualDropdownMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$5(Modifier modifier, String str, List list, TextualDropdownOption textualDropdownOption, Function1 function1, int i, int i2, Composer composer, int i3) {
        TextualDropdownMenu(modifier, str, list, textualDropdownOption, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void TextualDropdownMenu(Modifier modifier, String str, List<TextualDropdownOption<T>> list, TextualDropdownOption<T> textualDropdownOption, Function1<? super TextualDropdownOption<T>, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        String str2;
        int i4;
        List<TextualDropdownOption<T>> listEmptyList;
        int i5;
        Function1<? super TextualDropdownOption<T>, Unit> function12;
        final Modifier modifier3;
        final String str3;
        final List<TextualDropdownOption<T>> list2;
        final Function1<? super TextualDropdownOption<T>, Unit> function13;
        final TextualDropdownOption<T> textualDropdownOption2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final TextualDropdownOption<T> textualDropdownOption3;
        Modifier modifier4;
        final String str4;
        final List<TextualDropdownOption<T>> list3;
        final Function1<? super TextualDropdownOption<T>, Unit> function14;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i6;
        TextualDropdownOption<T> textualDropdownOption4 = textualDropdownOption;
        Composer composerStartRestartGroup = composer.startRestartGroup(43392938);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextualDropdownMenu)N(modifier,label,options,selectedOption,onOptionSelected)29@1200L34,33@1328L17,34@1380L1085,31@1240L1225:textualDropdownMenu.kt#r7kl7s");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    listEmptyList = list;
                    i3 |= composerStartRestartGroup.changedInstance(listEmptyList) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) != 0) {
                        i6 = 1024;
                        i3 |= i6;
                    } else {
                        if ((i & 4096) == 0 ? composerStartRestartGroup.changed(textualDropdownOption4) : composerStartRestartGroup.changedInstance(textualDropdownOption4)) {
                            i6 = 2048;
                        }
                        i3 |= i6;
                    }
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        function12 = function1;
                        i3 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            textualDropdownOption3 = textualDropdownOption4;
                            modifier4 = modifier2;
                            str4 = str2;
                            list3 = listEmptyList;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i8 != 0) {
                                str2 = "";
                            }
                            if (i4 != 0) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            if ((i2 & 8) != 0) {
                                textualDropdownOption4 = (TextualDropdownOption) CollectionsKt.firstOrNull((List) listEmptyList);
                                i3 &= -7169;
                            }
                            textualDropdownOption3 = textualDropdownOption4;
                            modifier4 = companion;
                            str4 = str2;
                            list3 = listEmptyList;
                            if (i5 != 0) {
                                function14 = null;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(43392938, i3, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu (textualDropdownMenu.kt:28)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1249049012, "CC(remember):textualDropdownMenu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            final MutableState mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean zTextualDropdownMenu$lambda$1 = TextualDropdownMenu$lambda$1(mutableState);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1249044933, "CC(remember):textualDropdownMenu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TextualDropdownMenuKt.TextualDropdownMenu$lambda$3$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Modifier modifier5 = modifier4;
                            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zTextualDropdownMenu$lambda$1, (Function1) objRememberedValue2, modifier4, ComposableLambdaKt.rememberComposableLambda(-688470080, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4(textualDropdownOption3, str4, modifier5, mutableState, list3, function14, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 896) | 3120, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            textualDropdownOption2 = textualDropdownOption3;
                            str3 = str4;
                            list2 = list3;
                            function13 = function14;
                        }
                        function14 = function12;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1249049012, "CC(remember):textualDropdownMenu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        final MutableState mutableState2 = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean zTextualDropdownMenu$lambda$12 = TextualDropdownMenu$lambda$1(mutableState2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1249044933, "CC(remember):textualDropdownMenu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Modifier modifier52 = modifier4;
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zTextualDropdownMenu$lambda$12, (Function1) objRememberedValue2, modifier4, ComposableLambdaKt.rememberComposableLambda(-688470080, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4(textualDropdownOption3, str4, modifier52, mutableState2, list3, function14, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 896) | 3120, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier4;
                        textualDropdownOption2 = textualDropdownOption3;
                        str3 = str4;
                        list2 = list3;
                        function13 = function14;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        str3 = str2;
                        list2 = listEmptyList;
                        function13 = function12;
                        textualDropdownOption2 = textualDropdownOption4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextualDropdownMenuKt.TextualDropdownMenu$lambda$5(modifier3, str3, list2, textualDropdownOption2, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                function12 = function1;
                if (!composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            listEmptyList = list;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        str2 = str;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        listEmptyList = list;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final boolean TextualDropdownMenu$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TextualDropdownMenu$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$3$0(MutableState mutableState, boolean z) {
        TextualDropdownMenu$lambda$2(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4(TextualDropdownOption textualDropdownOption, final String str, Modifier modifier, final MutableState mutableState, final List list, final Function1 function1, ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer composer, int i) {
        int i2;
        String label;
        ComposableLambda composableLambdaRememberComposableLambda;
        Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
        ComposerKt.sourceInformation(composer, "C44@1931L6,44@1981L6,44@1889L129,41@1667L2,43@1779L65,36@1391L675,50@2169L20,50@2191L268,48@2076L383:textualDropdownMenu.kt#r7kl7s");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(ExposedDropdownMenuBox) : composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-688470080, i2, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu.<anonymous> (textualDropdownMenu.kt:36)");
            }
            if (textualDropdownOption == null || (label = textualDropdownOption.getLabel()) == null) {
                label = "";
            }
            String str2 = label;
            if (StringsKt.isBlank(str)) {
                composer.startReplaceGroup(-1742955651);
                composer.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composer.startReplaceGroup(-1742978063);
                ComposerKt.sourceInformation(composer, "42@1720L15");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(126358704, true, new Function2() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$0(str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
                composer.endReplaceGroup();
            }
            int i3 = i2;
            ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
            TextFieldColors textFieldColorsM4499textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m4499textFieldColorsdx8h9Zs(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.03f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 48, 2097146);
            ComposerKt.sourceInformationMarkerStart(composer, -194774110, "CC(remember):textualDropdownMenu.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldKt.TextField(str2, (Function1<? super String, Unit>) objRememberedValue, modifier, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1991401479, true, new Function2() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$2(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM4499textFieldColorsdx8h9Zs, composer, 805330992, 0, 523688);
            boolean zTextualDropdownMenu$lambda$1 = TextualDropdownMenu$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -194758028, "CC(remember):textualDropdownMenu.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$3$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ExposedDropdownMenuBox.ExposedDropdownMenu(zTextualDropdownMenu$lambda$1, (Function0) objRememberedValue2, null, null, ComposableLambdaKt.rememberComposableLambda(-173685359, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$4(list, function1, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, (ExposedDropdownMenuBoxScope.$stable << 15) | 24624 | (458752 & (i3 << 15)), 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C42@1722L11:textualDropdownMenu.kt#r7kl7s");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(126358704, i, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu.<anonymous>.<anonymous> (textualDropdownMenu.kt:42)");
            }
            TextKt.m4524Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$2(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C43@1809L33:textualDropdownMenu.kt#r7kl7s");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1991401479, i, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu.<anonymous>.<anonymous> (textualDropdownMenu.kt:43)");
            }
            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(TextualDropdownMenu$lambda$1(mutableState), null, composer, ExposedDropdownMenuDefaults.$stable << 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$3$0(MutableState mutableState) {
        TextualDropdownMenu$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$4(List list, final Function1 function1, final MutableState mutableState, ColumnScope ExposedDropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
        ComposerKt.sourceInformation(composer, "C*53@2267L105,56@2374L61,53@2240L195:textualDropdownMenu.kt#r7kl7s");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-173685359, i, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu.<anonymous>.<anonymous> (textualDropdownMenu.kt:52)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final TextualDropdownOption textualDropdownOption = (TextualDropdownOption) it.next();
                ComposerKt.sourceInformationMarkerStart(composer, -312146216, "CC(remember):textualDropdownMenu.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(textualDropdownOption);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$4$0$0$0(function1, textualDropdownOption, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem((Function0) objRememberedValue, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1378027122, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenuKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TextualDropdownMenuKt.TextualDropdownMenu$lambda$4$4$0$1(textualDropdownOption, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$4$0$0$0(Function1 function1, TextualDropdownOption textualDropdownOption, MutableState mutableState) {
        TextualDropdownMenu$lambda$2(mutableState, false);
        if (function1 != null) {
            function1.invoke(textualDropdownOption);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextualDropdownMenu$lambda$4$4$0$1(TextualDropdownOption textualDropdownOption, RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C57@2396L21:textualDropdownMenu.kt#r7kl7s");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1378027122, i, -1, "com.myscript.nebo.dms.ui.compose.components.TextualDropdownMenu.<anonymous>.<anonymous>.<anonymous>.<anonymous> (textualDropdownMenu.kt:57)");
            }
            TextKt.m4524Text4IGK_g(textualDropdownOption.getLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
