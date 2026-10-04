package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: pageBackgroundPatterns.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"BackgroundPatternList", "", "patterns", "", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "onPagePatternClicked", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BackgroundPatternPill", "pageBackgroundPattern", "isSelected", "", "onPillClicked", "(Lcom/myscript/nebo/note/ui/PageBackgroundPattern;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageBackgroundPatternsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundPatternList$lambda$1(List list, Function1 function1, int i, Composer composer, int i2) {
        BackgroundPatternList(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundPatternPill$lambda$2(PageBackgroundPattern pageBackgroundPattern, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        BackgroundPatternPill(pageBackgroundPattern, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BackgroundPatternList(final List<PageBackgroundPattern> patterns, final Function1<? super PageBackgroundPattern, Unit> function1, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1187665307);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackgroundPatternList)N(patterns,onPagePatternClicked)36@1566L787,36@1542L811:pageBackgroundPatterns.kt#ku1rws");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(patterns) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1187665307, i2, -1, "com.myscript.nebo.note.ui.compose.BackgroundPatternList (pageBackgroundPatterns.kt:35)");
            }
            NoteCreationPaneKt.NoteCreationSectionCard(ComposableLambdaKt.rememberComposableLambda(1521505036, true, new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PageBackgroundPatternsKt.BackgroundPatternList$lambda$0(patterns, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PageBackgroundPatternsKt.BackgroundPatternList$lambda$1(patterns, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundPatternList$lambda$0(final List list, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C37@1576L771:pageBackgroundPatterns.kt#ku1rws");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1521505036, i, -1, "com.myscript.nebo.note.ui.compose.BackgroundPatternList.<anonymous> (pageBackgroundPatterns.kt:37)");
            }
            float f = 16;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m2857paddingqDBjuR0(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f)), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 423593255, "C41@1804L62,41@1890L10,41@1934L6,41@1799L152,42@2024L313,42@1964L373:pageBackgroundPatterns.kt#ku1rws");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_page_pattern_title, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getSubtitle2(), composer, 0, 0, 65530);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 1676239259, "CC(remember):pageBackgroundPatterns.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PageBackgroundPatternsKt.BackgroundPatternList$lambda$0$0$0$0(list, function1, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyRow(null, null, null, false, horizontalOrVerticalM2528spacedBy0680j_42, null, null, false, null, (Function1) objRememberedValue, composer, 24576, 495);
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
    public static final Unit BackgroundPatternList$lambda$0$0$0$0(final List list, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.items$default(LazyRow, list.size(), null, null, ComposableLambdaKt.composableLambdaInstance(-362943274, true, new Function4() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PageBackgroundPatternsKt.BackgroundPatternList$lambda$0$0$0$0$0(list, function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundPatternList$lambda$0$0$0$0$0(List list, Function1 function1, LazyItemScope items, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation(composer, "CN(it)44@2085L220:pageBackgroundPatterns.kt#ku1rws");
        if ((i2 & 48) == 0) {
            i2 |= composer.changed(i) ? 32 : 16;
        }
        if (!composer.shouldExecute((i2 & 145) != 144, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-362943274, i2, -1, "com.myscript.nebo.note.ui.compose.BackgroundPatternList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (pageBackgroundPatterns.kt:44)");
            }
            BackgroundPatternPill((PageBackgroundPattern) list.get(i), ((PageBackgroundPattern) list.get(i)).isSelected(), function1, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BackgroundPatternPill(final PageBackgroundPattern pageBackgroundPattern, boolean z, Function1<? super PageBackgroundPattern, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        Function1<? super PageBackgroundPattern, Unit> function12;
        final boolean z3;
        final Function1<? super PageBackgroundPattern, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super PageBackgroundPattern, Unit> function14;
        Intrinsics.checkNotNullParameter(pageBackgroundPattern, "pageBackgroundPattern");
        Composer composerStartRestartGroup = composer.startRestartGroup(2052507269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackgroundPatternPill)N(pageBackgroundPattern,isSelected,onPillClicked)61@2724L48,62@2827L6,64@2972L6,65@3030L46,57@2535L1324:pageBackgroundPatterns.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pageBackgroundPattern) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z2;
                    function13 = function12;
                } else {
                    boolean z4 = i5 != 0 ? false : z2;
                    final Function1<? super PageBackgroundPattern, Unit> function15 = i4 != 0 ? null : function12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2052507269, i3, -1, "com.myscript.nebo.note.ui.compose.BackgroundPatternPill (pageBackgroundPatterns.kt:56)");
                    }
                    Alignment center = Alignment.INSTANCE.getCenter();
                    float f = 4;
                    float f2 = 48;
                    Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f))), C1486Dp.m11017constructorimpl(f2));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1069508021, "CC(remember):pageBackgroundPatterns.kt#9igjgp");
                    boolean z5 = ((i3 & 896) == 256) | ((i3 & 14) == 4);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PageBackgroundPatternsKt.BackgroundPatternPill$lambda$0$0(function15, pageBackgroundPattern);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z6 = z4;
                    Modifier modifierM2033borderxT4_qwU = BorderKt.m2033borderxT4_qwU(BackgroundKt.m2016backgroundbw27NRU$default(ClickableKt.m2062clickableoSLSa3U$default(modifierM2924size3ABfNKs, false, null, null, null, (Function0) objRememberedValue, 15, null), ColorKt.m8193compositeOverOWjLjI(Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), z4 ? 0.05f : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4207getSurface0d7_KjU()), null, 2, null), C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), ColorResources_androidKt.colorResource(C6079R.color.page_pattern_color, composerStartRestartGroup, 0), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f)));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2033borderxT4_qwU);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375532490, "C75@3561L292:pageBackgroundPatterns.kt#ku1rws");
                    int assetRes = pageBackgroundPattern.getPattern() != BackgroundPattern.NONE ? pageBackgroundPattern.getAssetRes() : 0;
                    if (assetRes != 0) {
                        composerStartRestartGroup.startReplaceGroup(-1375387442);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3328L32,71@3441L46,68@3276L265");
                        function14 = function15;
                        IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, assetRes, composerStartRestartGroup, 6), "checked", SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f2)), ColorResources_androidKt.colorResource(C6079R.color.page_pattern_color, composerStartRestartGroup, 0), composerStartRestartGroup, 432, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        function14 = function15;
                        composerStartRestartGroup.startReplaceGroup(-1375122857);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(z6, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$PageBackgroundPatternsKt.INSTANCE.m13290getLambda$207129885$app_standardRelease(), composerStartRestartGroup, ((i3 >> 3) & 14) | ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function14;
                    z3 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundPatternsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PageBackgroundPatternsKt.BackgroundPatternPill$lambda$2(pageBackgroundPattern, z3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundPatternPill$lambda$0$0(Function1 function1, PageBackgroundPattern pageBackgroundPattern) {
        if (function1 != null) {
            function1.invoke(pageBackgroundPattern);
        }
        return Unit.INSTANCE;
    }
}
