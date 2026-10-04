package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.painter.Painter;
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
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.compose.AIError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingTextCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0007X\u008a\u008e\u0002"}, m1599d2 = {"StreamingTextCard", "", "titleRes", "", "error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "isLoading", "", "aiGeneratedText", "", "isStreamingComplete", "showShorter", "closeClick", "Lkotlin/Function0;", "shorterClick", "copyClick", "Lkotlin/Function1;", "addToNoteClick", "tryAgainClick", "(ILcom/myscript/nebo/ai/presentation/compose/AIError;ZLjava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "StreamingTextCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release", "showMenu"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StreamingTextCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$4(int i, AIError aIError, boolean z, String str, boolean z2, boolean z3, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, int i2, int i3, int i4, Composer composer, int i5) {
        StreamingTextCard(i, aIError, z, str, z2, z3, function0, function02, function1, function12, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCardPreview$lambda$5(int i, Composer composer, int i2) {
        StreamingTextCardPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void StreamingTextCard(final int i, final AIError aIError, final boolean z, final String aiGeneratedText, final boolean z2, boolean z3, final Function0<Unit> closeClick, final Function0<Unit> shorterClick, final Function1<? super String, Unit> copyClick, final Function1<? super String, Unit> addToNoteClick, final Function0<Unit> tryAgainClick, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        AIError aIError2;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        Composer composer2;
        final boolean z7;
        Intrinsics.checkNotNullParameter(aiGeneratedText, "aiGeneratedText");
        Intrinsics.checkNotNullParameter(closeClick, "closeClick");
        Intrinsics.checkNotNullParameter(shorterClick, "shorterClick");
        Intrinsics.checkNotNullParameter(copyClick, "copyClick");
        Intrinsics.checkNotNullParameter(addToNoteClick, "addToNoteClick");
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-482702200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StreamingTextCard)N(titleRes,error,isLoading,aiGeneratedText,isStreamingComplete,showShorter,closeClick,shorterClick,copyClick,addToNoteClick,tryAgainClick)54@2081L34,59@2201L5282,56@2121L5362:StreamingTextCard.kt#ysqczk");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            aIError2 = aIError;
            i5 |= composerStartRestartGroup.changed(aIError2) ? 32 : 16;
        } else {
            aIError2 = aIError;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            z4 = z;
            i5 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
        } else {
            z4 = z;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(aiGeneratedText) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            z5 = z2;
            i5 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
        } else {
            z5 = z2;
        }
        int i7 = i4 & 32;
        if (i7 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            z6 = z3;
        } else {
            z6 = z3;
            if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                i5 |= composerStartRestartGroup.changed(z6) ? 131072 : 65536;
            }
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(closeClick) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(shorterClick) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(copyClick) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(addToNoteClick) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerStartRestartGroup.changedInstance(tryAgainClick) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if (!composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i6 & 3) == 2) ? false : true, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z7 = z6;
        } else {
            final boolean z8 = i7 != 0 ? false : z6;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-482702200, i5, i6, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCard (StreamingTextCard.kt:52)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -20334102, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(12));
            float fM11017constructorimpl = C1486Dp.m11017constructorimpl(8);
            final AIError aIError3 = aIError2;
            final boolean z9 = z4;
            final boolean z10 = z5;
            boolean z11 = z8;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-617219195, true, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3(aIError3, i, z10, mutableState, copyClick, aiGeneratedText, addToNoteClick, tryAgainClick, z9, z8, closeClick, shorterClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            composer2 = composerStartRestartGroup;
            CardKt.m4173CardFjzlyU(null, roundedCornerShapeM3235RoundedCornerShape0680j_4, 0L, 0L, null, fM11017constructorimpl, composableLambdaRememberComposableLambda, composer2, 1769472, 29);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z11;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreamingTextCardKt.StreamingTextCard$lambda$4(i, aIError, z, aiGeneratedText, z2, z7, closeClick, shorterClick, copyClick, addToNoteClick, tryAgainClick, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean StreamingTextCard$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StreamingTextCard$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public static final Unit StreamingTextCard$lambda$3(AIError aIError, int i, boolean z, final MutableState mutableState, final Function1 function1, final String str, final Function1 function12, final Function0 function0, boolean z2, boolean z3, final Function0 function02, final Function0 function03, Composer composer, int i2) {
        String str2;
        ColumnScopeInstance columnScopeInstance;
        int i3;
        String str3;
        ?? r0;
        float f;
        int i4;
        String str4;
        String str5;
        FiniteAnimationSpec finiteAnimationSpec;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C60@2211L5266:StreamingTextCard.kt#ysqczk");
        if (composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617219195, i2, -1, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCard.<anonymous> (StreamingTextCard.kt:60)");
            }
            float f2 = 16;
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1567614331, "C64@2344L2334,117@4692L40,162@6663L41,164@6718L749:StreamingTextCard.kt#ysqczk");
            int errorTitle = aIError != null ? aIError.getErrorTitle() : i;
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer2);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1096334318, "C74@2803L21,75@2868L6,76@2928L10,73@2770L241,80@3096L1568,80@3029L1635:StreamingTextCard.kt#ysqczk");
            if (aIError != null) {
                composer2.startReplaceGroup(1096313919);
                ComposerKt.sourceInformation(composer2, "67@2495L41,70@2701L6,66@2455L280");
                columnScopeInstance = columnScopeInstance2;
                str2 = "C89@4557L9:Column.kt#2w3rfo";
                i3 = errorTitle;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_info, composer2, 0), "Info", PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 0.0f, 11, null), MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable).m4197getError0d7_KjU(), composer, Painter.$stable | 432, 0);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                str2 = "C89@4557L9:Column.kt#2w3rfo";
                columnScopeInstance = columnScopeInstance2;
                i3 = errorTitle;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                composer2.startReplaceGroup(1096600855);
                composer2.endReplaceGroup();
            }
            ColumnScopeInstance columnScopeInstance3 = columnScopeInstance;
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(i3, composer2, 0), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getH6(), composer, 0, 0, 65528);
            Composer composer3 = composer;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z && aIError == null, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(56026259, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0(mutableState, function1, str, function12, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer3, 1572870, 30);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(8)), composer3, 6);
            Unit unit = null;
            if (aIError == null) {
                composer3.startReplaceGroup(1569904888);
                composer3.endReplaceGroup();
                r0 = 0;
            } else {
                composer3.startReplaceGroup(1569904889);
                ComposerKt.sourceInformation(composer3, "*121@4815L36,122@4895L10,123@4955L6,120@4782L207");
                r0 = 0;
                TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(aIError.getErrorDescription(), composer3, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer3, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBody1(), composer, 0, 0, 65530);
                composer3 = composer;
                Unit unit2 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                composer3.startReplaceGroup(1570200009);
                ComposerKt.sourceInformation(composer3, "*133@5380L21,127@5109L1526");
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(columnScopeInstance3.weight(Modifier.INSTANCE, 1.0f, r0), ScrollKt.rememberScrollState(r0, composer3, r0, 1), false, null, false, 14, null);
                ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r0);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r0));
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                String str6 = str3;
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str6);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer3);
                Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -1740719069, "C:StreamingTextCard.kt#ysqczk");
                if (z2) {
                    composer3.startReplaceGroup(-1740737515);
                    ComposerKt.sourceInformation(composer3, "136@5519L16");
                    BlinkingCursorKt.BlinkingCursor(composer3, r0);
                    composer3.endReplaceGroup();
                    f = 0.0f;
                    i4 = 3;
                    str5 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                    str4 = str6;
                    finiteAnimationSpec = null;
                } else {
                    composer3.startReplaceGroup(-1740637385);
                    ComposerKt.sourceInformation(composer3, "138@5589L1006");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, r0);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r0));
                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, companion2);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str6);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor4);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM7248constructorimpl4 = Updater.m7248constructorimpl(composer3);
                    Updater.m7256setimpl(composerM7248constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, str2);
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1783048563, "C141@5742L10,142@5814L6,139@5626L234,144@5889L680:StreamingTextCard.kt#ysqczk");
                    f = 0.0f;
                    str4 = str6;
                    str5 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                    TextKt.m4524Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColors(composer3, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBody1(), composer, 0, 0, 65530);
                    finiteAnimationSpec = null;
                    i4 = 3;
                    composer3 = composer;
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance4, z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), (ExitTransition) null, (String) null, ComposableSingletons$StreamingTextCardKt.INSTANCE.getLambda$562554207$nebo_ai_release(), composer3, 1575942, 26);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Unit unit3 = Unit.INSTANCE;
                composer3.endReplaceGroup();
            } else {
                f = 0.0f;
                i4 = 3;
                str4 = str3;
                str5 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                finiteAnimationSpec = null;
                composer3.startReplaceGroup(-87903810);
                composer3.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f2)), composer3, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, 1, finiteAnimationSpec);
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str5);
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str4);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor5);
            } else {
                composer3.useNode();
            }
            Composer composerM7248constructorimpl5 = Updater.m7248constructorimpl(composer3);
            Updater.m7256setimpl(composerM7248constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1393094422, "C168@6895L276,165@6776L395,175@7188L38,177@7299L16,178@7344L33,179@7421L6,176@7243L210:StreamingTextCard.kt#ysqczk");
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z3, (Modifier) null, EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, f, i4, finiteAnimationSpec), (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(928608892, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3$0$3$0(function03, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer3, 1575942, 26);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer3, 0);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1291848444, "CC(remember):StreamingTextCard.kt#9igjgp");
            boolean zChanged = composer3.changed(function02);
            Object objRememberedValue = composer3.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreamingTextCardKt.StreamingTextCard$lambda$3$0$3$1$0(function02);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_close, composer3, 0), ClickableKt.m2062clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue, 15, null), MaterialTheme.INSTANCE.getColors(composer3, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0(final MutableState mutableState, final Function1 function1, final String str, final Function1 function12, final Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C81@3118L1528:StreamingTextCard.kt#ysqczk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56026259, i, -1, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StreamingTextCard.kt:81)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1017729774, "C82@3169L19,82@3148L363,92@3647L20,93@3694L930,90@3537L1087:StreamingTextCard.kt#ysqczk");
        ComposerKt.sourceInformationMarkerStart(composer, 1906831872, "CC(remember):StreamingTextCard.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$0$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, ComposableSingletons$StreamingTextCardKt.INSTANCE.getLambda$1388567345$nebo_ai_release(), composer, 24582, 14);
        boolean zStreamingTextCard$lambda$1 = StreamingTextCard$lambda$1(mutableState);
        ComposerKt.sourceInformationMarkerStart(composer, 1906847169, "CC(remember):StreamingTextCard.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$1$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(zStreamingTextCard$lambda$1, (Function0) objRememberedValue2, null, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1852760710, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$2(function1, str, function12, function0, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 1572912, 60);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$0$0(MutableState mutableState) {
        StreamingTextCard$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$1$0(MutableState mutableState) {
        StreamingTextCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$2(final Function1 function1, final String str, final Function1 function12, final Function0 function0, final MutableState mutableState, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C94@3751L139,94@3724L270,100@4050L144,100@4023L282,106@4361L128,106@4334L264:StreamingTextCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1852760710, i, -1, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StreamingTextCard.kt:94)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1908387493, "CC(remember):StreamingTextCard.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$2$0$0(function1, str, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem((Function0) objRememberedValue, null, false, null, null, ComposableSingletons$StreamingTextCardKt.INSTANCE.m12861getLambda$1072615651$nebo_ai_release(), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            ComposerKt.sourceInformationMarkerStart(composer, 1908397066, "CC(remember):StreamingTextCard.kt#9igjgp");
            boolean zChanged2 = composer.changed(function12) | composer.changed(str);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$2$1$0(function12, str, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem((Function0) objRememberedValue2, null, false, null, null, ComposableSingletons$StreamingTextCardKt.INSTANCE.getLambda$1926516486$nebo_ai_release(), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            ComposerKt.sourceInformationMarkerStart(composer, 1908407002, "CC(remember):StreamingTextCard.kt#9igjgp");
            boolean zChanged3 = composer.changed(function0);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreamingTextCardKt.StreamingTextCard$lambda$3$0$0$0$0$2$2$0(function0, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem((Function0) objRememberedValue3, null, false, null, null, ComposableSingletons$StreamingTextCardKt.INSTANCE.m12862getLambda$419316763$nebo_ai_release(), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$2$0$0(Function1 function1, String str, MutableState mutableState) {
        function1.invoke(str);
        StreamingTextCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$2$1$0(Function1 function1, String str, MutableState mutableState) {
        function1.invoke(str);
        StreamingTextCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$0$0$0$2$2$0(Function0 function0, MutableState mutableState) {
        function0.invoke();
        StreamingTextCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$3$0(final Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C170@6977L18,171@7028L41,172@7117L6,169@6917L236:StreamingTextCard.kt#ysqczk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(928608892, i, -1, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StreamingTextCard.kt:169)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -960049714, "CC(remember):StreamingTextCard.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StreamingTextCardKt.StreamingTextCard$lambda$3$0$3$0$0$0(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_shorter_title, composer, 0), ClickableKt.m2062clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null), MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131064);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$3$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCard$lambda$3$0$3$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void StreamingTextCardPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-290011474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StreamingTextCardPreview)196@7796L2,197@7823L2,198@7847L2,199@7876L2,200@7904L2,189@7545L367:StreamingTextCard.kt#ysqczk");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290011474, i, -1, "com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardPreview (StreamingTextCard.kt:188)");
            }
            int i2 = C6091R.string.ai_summary_title;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 471856944, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 471857808, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function02 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 471858576, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StreamingTextCardKt.StreamingTextCardPreview$lambda$2$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 471859504, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StreamingTextCardKt.StreamingTextCardPreview$lambda$3$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function12 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 471860400, "CC(remember):StreamingTextCard.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            StreamingTextCard(i2, null, false, "This is a preview text", true, true, function0, function02, function1, function12, (Function0) objRememberedValue5, composerStartRestartGroup, 920350128, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.StreamingTextCardKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreamingTextCardKt.StreamingTextCardPreview$lambda$5(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCardPreview$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamingTextCardPreview$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
