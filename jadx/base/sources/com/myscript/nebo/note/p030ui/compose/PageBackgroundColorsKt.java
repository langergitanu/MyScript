package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
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
import com.myscript.android.utils.ColorExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.penpanel.C6693R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: pageBackgroundColors.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"BackgroundColorList", "", "colors", "", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "onPageColorClicked", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BackgroundColorPill", "color", "isSelected", "", "onPillClicked", "(Lcom/myscript/nebo/note/ui/PageBackgroundColor;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageBackgroundColorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorList$lambda$1(List list, Function1 function1, int i, Composer composer, int i2) {
        BackgroundColorList(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorPill$lambda$2(PageBackgroundColor pageBackgroundColor, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        BackgroundColorPill(pageBackgroundColor, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BackgroundColorList(final List<PageBackgroundColor> colors, final Function1<? super PageBackgroundColor, Unit> function1, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-323627963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackgroundColorList)N(colors,onPageColorClicked)39@1711L910,39@1687L934:pageBackgroundColors.kt#ku1rws");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(colors) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-323627963, i2, -1, "com.myscript.nebo.note.ui.compose.BackgroundColorList (pageBackgroundColors.kt:38)");
            }
            NoteCreationPaneKt.NoteCreationSectionCard(ComposableLambdaKt.rememberComposableLambda(162850924, true, new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PageBackgroundColorsKt.BackgroundColorList$lambda$0(colors, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PageBackgroundColorsKt.BackgroundColorList$lambda$1(colors, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorList$lambda$0(final List list, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C41@1722L893:pageBackgroundColors.kt#ku1rws");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(162850924, i, -1, "com.myscript.nebo.note.ui.compose.BackgroundColorList.<anonymous> (pageBackgroundColors.kt:41)");
            }
            float f = 16;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m2857paddingqDBjuR0(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(8), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f)), 0.0f, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1011336339, "C46@1950L60,46@2034L10,46@2078L6,46@1945L150,50@2317L288,47@2108L497:pageBackgroundColors.kt#ku1rws");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_page_color_title, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getSubtitle2(), composer, 0, 0, 65530);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f)), Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f)), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-122812409, true, new Function3() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PageBackgroundColorsKt.BackgroundColorList$lambda$0$0$0(list, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
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
    public static final Unit BackgroundColorList$lambda$0$0$0(List list, Function1 function1, FlowRowScope FlowRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C*52@2372L201:pageBackgroundColors.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-122812409, i, -1, "com.myscript.nebo.note.ui.compose.BackgroundColorList.<anonymous>.<anonymous>.<anonymous> (pageBackgroundColors.kt:51)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PageBackgroundColor pageBackgroundColor = (PageBackgroundColor) it.next();
                BackgroundColorPill(pageBackgroundColor, pageBackgroundColor.isSelected(), function1, composer, 0, 0);
            }
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
    /* JADX WARN: Removed duplicated region for block: B:80:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BackgroundColorPill(final PageBackgroundColor color, boolean z, Function1<? super PageBackgroundColor, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        Function1<? super PageBackgroundColor, Unit> function12;
        final boolean z3;
        final Function1<? super PageBackgroundColor, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(color, "color");
        Composer composerStartRestartGroup = composer.startRestartGroup(14335806);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackgroundColorPill)N(color,isSelected,onPillClicked)65@2798L83,66@2903L21,71@3085L32,67@2929L751:pageBackgroundColors.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(color) ? 4 : 2) | i;
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
                if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    boolean z4 = i5 != 0 ? false : z2;
                    final Function1<? super PageBackgroundColor, Unit> function14 = i4 != 0 ? null : function12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(14335806, i3, -1, "com.myscript.nebo.note.ui.compose.BackgroundColorPill (pageBackgroundColors.kt:64)");
                    }
                    final long jColorResource = ColorResources_androidKt.colorResource(C6693R.color.secondaryBarPenPaletteBorder, composerStartRestartGroup, 0);
                    final boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 891822046, "CC(remember):pageBackgroundColors.kt#9igjgp");
                    int i6 = i3 & 14;
                    boolean z5 = ((i3 & 896) == 256) | (i6 == 4);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PageBackgroundColorsKt.BackgroundColorPill$lambda$0$0(function14, color);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2062clickableoSLSa3U$default = ClickableKt.m2062clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2062clickableoSLSa3U$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i7 = i3;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 427894526, "C72@3178L172,72@3129L222,77@3361L313:pageBackgroundColors.kt#ku1rws");
                    Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(48));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -124743088, "CC(remember):pageBackgroundColors.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(zIsSystemInDarkTheme) | (i6 == 4) | composerStartRestartGroup.changed(jColorResource);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PageBackgroundColorsKt.BackgroundColorPill$lambda$1$0$0(zIsSystemInDarkTheme, color, jColorResource, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM2924size3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 6);
                    AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$PageBackgroundColorsKt.INSTANCE.getLambda$1036225052$app_standardRelease(), composerStartRestartGroup, ((i7 >> 3) & 14) | ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    function13 = function14;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z2;
                    function13 = function12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.PageBackgroundColorsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PageBackgroundColorsKt.BackgroundColorPill$lambda$2(color, z3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
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
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorPill$lambda$0$0(Function1 function1, PageBackgroundColor pageBackgroundColor) {
        if (function1 != null) {
            function1.invoke(pageBackgroundColor);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorPill$lambda$1$0$0(boolean z, PageBackgroundColor pageBackgroundColor, long j, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m8710drawCircleVaOC9Bg$default(Canvas, ColorKt.Color(ColorExt.getOpaque(z ? pageBackgroundColor.getColor2() : pageBackgroundColor.getColor())), 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        DrawScope.m8710drawCircleVaOC9Bg$default(Canvas, j, 0.0f, 0L, 0.0f, new Stroke(0.0f, 0.0f, 0, 0, null, 31, null), null, 0, 110, null);
        return Unit.INSTANCE;
    }
}
