package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.DpOffset;
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
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.compose.ActionsAvailability;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIDropdownMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001aQ\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0015\u001aO\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, m1599d2 = {"AIDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "onMenuItemClick", "Lkotlin/Function1;", "Lcom/myscript/nebo/ai/presentation/compose/components/AIDropdownOption;", "actionsAvailability", "Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemWithIcon", "onClick", "labelRes", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "drawableRes", "iconSpaceReserved", "isAvailable", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Integer;ZZLandroidx/compose/runtime/Composer;II)V", "label", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/painter/Painter;ZZLandroidx/compose/runtime/Composer;II)V", "nebo-ai_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIDropdownMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIDropdownMenu$lambda$1(boolean z, Function0 function0, Function1 function1, ActionsAvailability actionsAvailability, int i, Composer composer, int i2) {
        AIDropdownMenu(z, function0, function1, actionsAvailability, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$1(Function0 function0, int i, ImageVector imageVector, Integer num, boolean z, boolean z2, int i2, int i3, Composer composer, int i4) {
        DropdownMenuItemWithIcon((Function0<Unit>) function0, i, imageVector, num, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$3(Function0 function0, String str, ImageVector imageVector, Painter painter, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        DropdownMenuItemWithIcon((Function0<Unit>) function0, str, imageVector, painter, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AIDropdownMenu(final boolean z, final Function0<Unit> onDismissRequest, final Function1<? super AIDropdownOption, Unit> onMenuItemClick, final ActionsAvailability actionsAvailability, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onMenuItemClick, "onMenuItemClick");
        Intrinsics.checkNotNullParameter(actionsAvailability, "actionsAvailability");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1703617681);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIDropdownMenu)N(expanded,onDismissRequest,onMenuItemClick,actionsAvailability)50@1875L828,46@1739L964:AIDropdownMenu.kt#ysqczk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onMenuItemClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(actionsAvailability) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1703617681, i2, -1, "com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenu (AIDropdownMenu.kt:45)");
            }
            AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(z, onDismissRequest, null, DpOffset.m11073constructorimpl((((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(0))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(-16))))), null, null, ComposableLambdaKt.rememberComposableLambda(-23096542, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIDropdownMenuKt.AIDropdownMenu$lambda$0(onMenuItemClick, actionsAvailability, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 1575936 | (i2 & 112), 52);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIDropdownMenuKt.AIDropdownMenu$lambda$1(z, onDismissRequest, onMenuItemClick, actionsAvailability, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIDropdownMenu$lambda$0(final Function1 function1, ActionsAvailability actionsAvailability, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C52@1933L47,51@1885L266,59@2209L45,58@2161L273,65@2491L42,64@2443L254:AIDropdownMenu.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-23096542, i, -1, "com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenu.<anonymous> (AIDropdownMenu.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -720938479, "CC(remember):AIDropdownMenu.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIDropdownMenuKt.AIDropdownMenu$lambda$0$0$0(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DropdownMenuItemWithIcon((Function0<Unit>) objRememberedValue, C6091R.string.ai_summarize_title, (ImageVector) null, Integer.valueOf(C6183R.drawable.ic_list), false, actionsAvailability.getSummarize(), composer, 0, 20);
            ComposerKt.sourceInformationMarkerStart(composer, -720929649, "CC(remember):AIDropdownMenu.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIDropdownMenuKt.AIDropdownMenu$lambda$0$1$0(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DropdownMenuItemWithIcon((Function0<Unit>) objRememberedValue2, C6091R.string.ai_explain_title, (ImageVector) null, Integer.valueOf(C6183R.drawable.ic_lightbulb_outline), false, actionsAvailability.getExplain(), composer, 0, 20);
            ComposerKt.sourceInformationMarkerStart(composer, -720920628, "CC(remember):AIDropdownMenu.kt#9igjgp");
            boolean zChanged3 = composer.changed(function1);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIDropdownMenuKt.AIDropdownMenu$lambda$0$2$0(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DropdownMenuItemWithIcon((Function0<Unit>) objRememberedValue3, C6091R.string.ai_quizz, (ImageVector) null, Integer.valueOf(C6183R.drawable.ic_quiz_outline), false, actionsAvailability.getQuiz(), composer, 0, 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIDropdownMenu$lambda$0$0$0(Function1 function1) {
        function1.invoke(AIDropdownOption.Summarize);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIDropdownMenu$lambda$0$1$0(Function1 function1) {
        function1.invoke(AIDropdownOption.Explain);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIDropdownMenu$lambda$0$2$0(Function1 function1) {
        function1.invoke(AIDropdownOption.Quiz);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItemWithIcon(final Function0<Unit> onClick, final int i, ImageVector imageVector, Integer num, boolean z, boolean z2, Composer composer, final int i2, final int i3) {
        int i4;
        ImageVector imageVector2;
        int i5;
        Integer num2;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        final ImageVector imageVector3;
        Composer composer2;
        final Integer num3;
        final boolean z5;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(649215082);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemWithIcon)N(onClick,labelRes,imageVector,drawableRes,iconSpaceReserved,isAvailable)85@3098L29,83@3029L248:AIDropdownMenu.kt#ysqczk");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i8 = i3 & 4;
        if (i8 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                imageVector2 = imageVector;
                i4 |= composerStartRestartGroup.changed(imageVector2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    num2 = num;
                    i4 |= composerStartRestartGroup.changed(num2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 != 0) {
                        if ((196608 & i2) == 0) {
                            z4 = z2;
                            i4 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                        }
                        if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            imageVector3 = imageVector2;
                            composer2 = composerStartRestartGroup;
                            num3 = num2;
                            z5 = z3;
                            z6 = z4;
                        } else {
                            Painter painterPainterResource = null;
                            if (i8 != 0) {
                                imageVector2 = null;
                            }
                            Integer num4 = i5 != 0 ? null : num2;
                            ImageVector imageVector4 = imageVector2;
                            boolean z7 = i6 != 0 ? false : z3;
                            boolean z8 = i7 != 0 ? true : z4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(649215082, i4, -1, "com.myscript.nebo.ai.presentation.compose.components.DropdownMenuItemWithIcon (AIDropdownMenu.kt:81)");
                            }
                            if (num4 == null) {
                                composerStartRestartGroup.startReplaceGroup(529045783);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(529045784);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*82@2998L24");
                                painterPainterResource = PainterResources_androidKt.painterResource(num4.intValue(), composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            DropdownMenuItemWithIcon(onClick, StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 3) & 14), imageVector4, painterPainterResource, z7, z8, composerStartRestartGroup, (i4 & 910) | (Painter.$stable << 9) | (57344 & i4) | (i4 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            imageVector3 = imageVector4;
                            composer2 = composerStartRestartGroup;
                            z6 = z8;
                            z5 = z7;
                            num3 = num4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$1(onClick, i, imageVector3, num3, z5, z6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    z4 = z2;
                    if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                i7 = i3 & 32;
                if (i7 != 0) {
                }
                z4 = z2;
                if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            num2 = num;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i3 & 32;
            if (i7 != 0) {
            }
            z4 = z2;
            if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        imageVector2 = imageVector;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        num2 = num;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i3 & 32;
        if (i7 != 0) {
        }
        z4 = z2;
        if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItemWithIcon(final Function0<Unit> onClick, final String label, ImageVector imageVector, Painter painter, boolean z, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        ImageVector imageVector2;
        int i4;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        final Painter painter2;
        final ImageVector imageVector3;
        final boolean z5;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final long jM8158unboximpl;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(1190875092);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemWithIcon)N(onClick,label,imageVector,painter,iconSpaceReserved,isAvailable)103@3680L1648,103@3614L1714:AIDropdownMenu.kt#ysqczk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                imageVector2 = imageVector;
                i3 |= composerStartRestartGroup.changed(imageVector2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(painter) : composerStartRestartGroup.changedInstance(painter) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    z3 = z;
                    i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                    if ((196608 & i) == 0) {
                        z4 = z2;
                        i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        painter2 = painter;
                        imageVector3 = imageVector2;
                        z5 = z3;
                        z6 = z4;
                    } else {
                        if (i7 != 0) {
                            imageVector2 = null;
                        }
                        final Painter painter3 = i4 != 0 ? null : painter;
                        final ImageVector imageVector4 = imageVector2;
                        final boolean z7 = i5 != 0 ? false : z3;
                        final boolean z8 = i6 != 0 ? true : z4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1190875092, i3, -1, "com.myscript.nebo.ai.presentation.compose.components.DropdownMenuItemWithIcon (AIDropdownMenu.kt:101)");
                        }
                        if (!z8) {
                            composerStartRestartGroup.startReplaceGroup(1969671641);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "102@3566L6");
                            jM8158unboximpl = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4197getError0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1969672571);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "102@3602L7");
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM8158unboximpl = ((Color) objConsume).m8158unboximpl();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM8158unboximpl)), ComposableLambdaKt.rememberComposableLambda(-462351596, true, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$2(onClick, z8, label, imageVector4, painter3, z7, jM8158unboximpl, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        painter2 = painter3;
                        z5 = z7;
                        imageVector3 = imageVector4;
                        z6 = z8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$3(onClick, label, imageVector3, painter2, z5, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                z4 = z2;
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z4 = z2;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        imageVector2 = imageVector;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z4 = z2;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$2(Function0 function0, final boolean z, final String str, final ImageVector imageVector, final Painter painter, final boolean z2, final long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@3726L1596,104@3690L1632:AIDropdownMenu.kt#ysqczk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-462351596, i, -1, "com.myscript.nebo.ai.presentation.compose.components.DropdownMenuItemWithIcon.<anonymous> (AIDropdownMenu.kt:104)");
            }
            AndroidMenu_androidKt.DropdownMenuItem(function0, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1908311799, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$2$0(z, str, imageVector, painter, z2, j, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$2$0(boolean z, String str, final ImageVector imageVector, final Painter painter, final boolean z2, final long j, RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C105@3740L1572:AIDropdownMenu.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908311799, i, -1, "com.myscript.nebo.ai.presentation.compose.components.DropdownMenuItemWithIcon.<anonymous>.<anonymous> (AIDropdownMenu.kt:105)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1173350191, "C112@4043L180,116@4242L878,109@3897L1223,139@5212L6,137@5137L161:AIDropdownMenu.kt#ysqczk");
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composer, 2116063439, "CC(remember):AIDropdownMenu.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$2$0$0$0$0((AnimatedContentTransitionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedContentKt.AnimatedContent(boolValueOf, null, (Function1) objRememberedValue, null, "IconAnimation", null, ComposableLambdaKt.rememberComposableLambda(140004766, true, new Function4() { // from class: com.myscript.nebo.ai.presentation.compose.components.AIDropdownMenuKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AIDropdownMenuKt.DropdownMenuItemWithIcon$lambda$2$0$0$1(imageVector, painter, z2, j, (AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 1597824, 42);
            TextKt.m4524Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131064);
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
    public static final ContentTransform DropdownMenuItemWithIcon$lambda$2$0$0$0$0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$2$0$0$1(ImageVector imageVector, Painter painter, boolean z, long j, AnimatedContentScope AnimatedContent, boolean z2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(available):AIDropdownMenu.kt#ysqczk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(140004766, i, -1, "com.myscript.nebo.ai.presentation.compose.components.DropdownMenuItemWithIcon.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AIDropdownMenu.kt:117)");
        }
        if (z2) {
            composer.startReplaceGroup(468805646);
            ComposerKt.sourceInformation(composer, "");
            if (imageVector != null) {
                composer.startReplaceGroup(468875768);
                ComposerKt.sourceInformation(composer, "120@4410L44");
                IconKt.m4301Iconww6aTOc(imageVector, (String) null, (Modifier) null, 0L, composer, 48, 12);
                composer.endReplaceGroup();
            } else if (painter != null) {
                composer.startReplaceGroup(469030396);
                ComposerKt.sourceInformation(composer, "123@4566L40");
                IconKt.m4300Iconww6aTOc(painter, (String) null, (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
                composer.endReplaceGroup();
            } else if (z) {
                composer.startReplaceGroup(469182792);
                ComposerKt.sourceInformation(composer, "126@4720L28");
                SpacerKt.Spacer(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(469296996);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(469333142);
            ComposerKt.sourceInformation(composer, "131@4902L46,130@4858L222");
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_info, composer, 0), "Info", (Modifier) null, j, composer, Painter.$stable | 48, 4);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
