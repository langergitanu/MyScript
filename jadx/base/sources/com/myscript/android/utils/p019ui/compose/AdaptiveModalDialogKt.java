package com.myscript.android.utils.p019ui.compose;

import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.C6014R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: AdaptiveModalDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aa\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032.\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a)\u0010\u0018\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, m1599d2 = {"AdaptiveModalDialog", "", "showPopup", "", "onDismiss", "Lkotlin/Function0;", "dismissOnTapOutside", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function3;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "Scrim", "onScrimClicked", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "RoundedOutlineDialogButton", "text", "", "tint", "Landroidx/compose/ui/graphics/Color;", "onClick", "RoundedOutlineDialogButton-3IgeMak", "(IJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "RoundCloseButton", "isCompact", "(Landroidx/compose/foundation/layout/BoxScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AdaptiveModalDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdaptiveModalDialog$lambda$2(boolean z, Function0 function0, boolean z2, Function5 function5, int i, int i2, Composer composer, int i3) {
        AdaptiveModalDialog(z, function0, z2, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundCloseButton$lambda$2(BoxScope boxScope, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        RoundCloseButton(boxScope, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundedOutlineDialogButton_3IgeMak$lambda$0(int i, long j, Function0 function0, int i2, int i3, Composer composer, int i4) {
        m12523RoundedOutlineDialogButton3IgeMak(i, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim$lambda$2(Function0 function0, int i, int i2, Composer composer, int i3) {
        Scrim(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdaptiveModalDialog(boolean z, Function0<Unit> function0, boolean z2, final Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function0<Unit> function02;
        int i4;
        boolean z4;
        final boolean z5;
        final Function0<Unit> function03;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function04;
        boolean z7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1736647718);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AdaptiveModalDialog)N(showPopup,onDismiss,dismissOnTapOutside,content)39@1588L2,43@1741L7:AdaptiveModalDialog.kt#vd5fha");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z3;
                    function03 = function02;
                    z6 = z4;
                } else {
                    if (i5 != 0) {
                        z3 = false;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1823823868, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function04 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function04 = function02;
                    }
                    boolean z8 = i4 != 0 ? false : z4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1736647718, i3, -1, "com.myscript.android.utils.ui.compose.AdaptiveModalDialog (AdaptiveModalDialog.kt:41)");
                    }
                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean z9 = C1486Dp.m11016compareTo0680j_4(C1486Dp.m11017constructorimpl((float) ((Configuration) objConsume).screenWidthDp), C1486Dp.m11017constructorimpl((float) 600)) <= 0;
                    if (z3) {
                        composerStartRestartGroup.startReplaceGroup(704204351);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "45@1805L1081");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment.Companion companion = Alignment.INSTANCE;
                        Alignment bottomCenter = z9 ? companion.getBottomCenter() : companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1311910594, "C49@1972L68,53@2162L38,55@2279L2,57@2464L412,51@2054L822:AdaptiveModalDialog.kt#vd5fha");
                        Scrim(z8 ? function04 : null, composerStartRestartGroup, 0, 0);
                        Modifier modifierNavigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE);
                        z7 = z3;
                        function03 = function04;
                        CardElevation cardElevationM4699cardElevationaqJV_2Y = CardDefaults.INSTANCE.m4699cardElevationaqJV_2Y(C1486Dp.m11017constructorimpl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
                        RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 596517947, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CardKt.Card((Function0) objRememberedValue2, modifierNavigationBarsPadding, false, roundedCornerShapeM3235RoundedCornerShape0680j_4, null, cardElevationM4699cardElevationaqJV_2Y, null, null, ComposableLambdaKt.rememberComposableLambda(1918462916, true, new Function3() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AdaptiveModalDialogKt.AdaptiveModalDialog$lambda$1$1(content, z9, function03, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663686, 208);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z7 = z3;
                        function03 = function04;
                        composerStartRestartGroup.startReplaceGroup(705258568);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z7;
                    z6 = z8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AdaptiveModalDialogKt.AdaptiveModalDialog$lambda$2(z5, function03, z6, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            z4 = z2;
            if ((i & 3072) == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        z4 = z2;
        if ((i & 3072) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdaptiveModalDialog$lambda$1$1(Function5 function5, boolean z, Function0 function0, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C61@2634L11,58@2482L380:AdaptiveModalDialog.kt#vd5fha");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1918462916, i, -1, "com.myscript.android.utils.ui.compose.AdaptiveModalDialog.<anonymous>.<anonymous> (AdaptiveModalDialog.kt:58)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16))), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2016backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1930379316, "C64@2755L29,66@2806L38:AdaptiveModalDialog.kt#vd5fha");
            function5.invoke(boxScopeInstance, Boolean.valueOf(z), function0, composer, 6);
            RoundCloseButton(boxScopeInstance, z, function0, composer, 6, 0);
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

    private static final void Scrim(Function0<Unit> function0, Composer composer, final int i, final int i2) {
        final Function0<Unit> function02;
        int i3;
        Function0<Unit> function03;
        Composer composerStartRestartGroup = composer.startRestartGroup(-769548691);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(onScrimClicked)78@3090L80,75@2970L341:AdaptiveModalDialog.kt#vd5fha");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                function02 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-769548691, i3, -1, "com.myscript.android.utils.ui.compose.Scrim (AdaptiveModalDialog.kt:74)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -801911491, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AdaptiveModalDialogKt.Scrim$lambda$0$0((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifierFillMaxSize$default, (Function1) objRememberedValue);
            boolean z = function02 != null;
            if (function02 == null) {
                composerStartRestartGroup.startReplaceGroup(910742547);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@3289L2");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -801905201, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function03 = (Function0) objRememberedValue2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-801905759);
                composerStartRestartGroup.endReplaceGroup();
                function03 = function02;
            }
            BoxKt.Box(ClickableKt.m2062clickableoSLSa3U$default(modifierDrawBehind, z, null, null, null, function03, 14, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AdaptiveModalDialogKt.Scrim$lambda$2(function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim$lambda$0$0(DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m8723drawRectnJ9OG0$default(drawBehind, Color.m8147copywmQWz5c$default(Color.INSTANCE.m8174getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX INFO: renamed from: RoundedOutlineDialogButton-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m12523RoundedOutlineDialogButton3IgeMak(final int i, long j, final Function0<Unit> onClick, Composer composer, final int i2, final int i3) {
        int i4;
        long onSurface;
        Composer composer2;
        int i5;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2061346350);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RoundedOutlineDialogButton)N(text,tint:c#ui.graphics.Color,onClick)95@3494L20,98@3606L10,94@3473L490:AdaptiveModalDialog.kt#vd5fha");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                onSurface = j;
                if (composerStartRestartGroup.changed(onSurface)) {
                    i5 = 32;
                }
                i4 |= i5;
            } else {
                onSurface = j;
            }
            i5 = 16;
            i4 |= i5;
        } else {
            onSurface = j;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "91@3417L11");
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i3 & 2) != 0) {
                    onSurface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface();
                    i4 &= -113;
                }
                int i6 = i4;
                long j2 = onSurface;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2061346350, i6, -1, "com.myscript.android.utils.ui.compose.RoundedOutlineDialogButton (AdaptiveModalDialog.kt:93)");
                }
                float f = 12;
                composer2 = composerStartRestartGroup;
                onSurface = j2;
                TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14), PaddingKt.m2855paddingVpY3zN4(BorderKt.m2033borderxT4_qwU(ClickableKt.m2062clickableoSLSa3U$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f))), false, null, null, null, onClick, 15, null), C1486Dp.m11017constructorimpl(2), j2, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f))), C1486Dp.m11017constructorimpl(16), C1486Dp.m11017constructorimpl(f)), onSurface, null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TextStyle.m10466copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer2, (i6 << 3) & 896, 0, 130040);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i4 &= -113;
                }
                int i62 = i4;
                long j22 = onSurface;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f2 = 12;
                composer2 = composerStartRestartGroup;
                onSurface = j22;
                TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i62 & 14), PaddingKt.m2855paddingVpY3zN4(BorderKt.m2033borderxT4_qwU(ClickableKt.m2062clickableoSLSa3U$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f2))), false, null, null, null, onClick, 15, null), C1486Dp.m11017constructorimpl(2), j22, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f2))), C1486Dp.m11017constructorimpl(16), C1486Dp.m11017constructorimpl(f2)), onSurface, null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TextStyle.m10466copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer2, (i62 << 3) & 896, 0, 130040);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        final long j3 = onSurface;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AdaptiveModalDialogKt.RoundedOutlineDialogButton_3IgeMak$lambda$0(i, j3, onClick, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RoundCloseButton(final BoxScope boxScope, final boolean z, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function04;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-236812234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RoundCloseButton)N(isCompact,onDismiss)114@4062L2,116@4121L11,118@4169L36,126@4478L78,117@4145L499:AdaptiveModalDialog.kt#vd5fha");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function03 = function02;
            } else {
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 56712472, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function04 = (Function0) objRememberedValue;
                } else {
                    function04 = function02;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-236812234, i3, -1, "com.myscript.android.utils.ui.compose.RoundCloseButton (AdaptiveModalDialog.kt:115)");
                }
                final long surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                Painter painterPainterResource = PainterResources_androidKt.painterResource(C6014R.drawable.ic_close, composerStartRestartGroup, 0);
                Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(ClickableKt.m2062clickableoSLSa3U$default(ClipKt.clip(PaddingKt.m2854padding3ABfNKs(AlphaKt.alpha(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), 0.66f), C1486Dp.m11017constructorimpl(z ? 4 : 16)), RoundedCornerShapeKt.getCircleShape()), false, null, null, null, function04, 15, null), C1486Dp.m11017constructorimpl(16));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 56725860, "CC(remember):AdaptiveModalDialog.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(surface);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AdaptiveModalDialogKt.RoundCloseButton$lambda$1$0(surface, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m5163Iconww6aTOc(painterPainterResource, (String) null, PaddingKt.m2854padding3ABfNKs(SizeKt.m2924size3ABfNKs(DrawModifierKt.drawBehind(modifierM2854padding3ABfNKs, (Function1) objRememberedValue2), C1486Dp.m11017constructorimpl(20)), C1486Dp.m11017constructorimpl(2)), 0L, composerStartRestartGroup, Painter.$stable | 48, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function03 = function04;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.AdaptiveModalDialogKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AdaptiveModalDialogKt.RoundCloseButton$lambda$2(boxScope, z, function03, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        function02 = function0;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundCloseButton$lambda$1$0(long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m8710drawCircleVaOC9Bg$default(drawBehind, j, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }
}
