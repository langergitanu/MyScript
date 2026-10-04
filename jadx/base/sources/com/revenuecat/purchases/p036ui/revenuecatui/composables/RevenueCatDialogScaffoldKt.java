package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import android.os.Build;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.window.AndroidDialog_androidKt;
import androidx.compose.p004ui.window.DialogProperties;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.WindowHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevenueCatDialogScaffold.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, m1599d2 = {"RevenueCatDialogScaffold", "", "handleCloseRequest", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getDialogMaxHeightPercentage", "", "(Landroidx/compose/runtime/Composer;I)F", "shouldUsePlatformDefaultWidth", "", "(Landroidx/compose/runtime/Composer;I)Z", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RevenueCatDialogScaffoldKt {
    public static final void RevenueCatDialogScaffold(final Function0<Unit> handleCloseRequest, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        final float fM11017constructorimpl;
        Intrinsics.checkNotNullParameter(handleCloseRequest, "handleCloseRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-208613253);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RevenueCatDialogScaffold)P(1)42@1751L40,47@1929L31,50@2079L1283,44@1797L1565:RevenueCatDialogScaffold.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(handleCloseRequest) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208613253, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold (RevenueCatDialogScaffold.kt:34)");
            }
            composerStartRestartGroup.startReplaceGroup(5743785);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*36@1578L14,36@1593L17,37@1663L10,37@1674L17");
            if (Build.VERSION.SDK_INT > 34) {
                fM11017constructorimpl = C1486Dp.m11017constructorimpl(WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getBottom() + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop());
            } else {
                fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
            }
            composerStartRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, handleCloseRequest, composerStartRestartGroup, (i2 << 3) & 112, 1);
            AndroidDialog_androidKt.Dialog(handleCloseRequest, new DialogProperties(false, false, null, shouldUsePlatformDefaultWidth(composerStartRestartGroup, 0), Build.VERSION.SDK_INT <= 34, 7, null), ComposableLambdaKt.rememberComposableLambda(-754282670, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C54@2194L30,60@2749L607,51@2089L1267:RevenueCatDialogScaffold.kt#51odh9");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-754282670, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold.<anonymous> (RevenueCatDialogScaffold.kt:51)");
                        }
                        Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RevenueCatDialogScaffoldKt.getDialogMaxHeightPercentage(composer2, 0));
                        long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(Color.INSTANCE.m8174getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        final float f = fM11017constructorimpl;
                        final Function2<Composer, Integer, Unit> function2 = content;
                        ScaffoldKt.m5487ScaffoldTvnljyQ(modifierFillMaxHeight, null, null, null, null, 0, jM8147copywmQWz5c$default, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1072225887, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                                invoke(paddingValues, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final PaddingValues paddingValues, Composer composer3, int i4) {
                                int i5;
                                float fM11017constructorimpl2;
                                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                                ComposerKt.sourceInformation(composer3, "C68@3158L26,63@2939L407:RevenueCatDialogScaffold.kt#51odh9");
                                if ((i4 & 6) == 0) {
                                    i5 = i4 | (composer3.changed(paddingValues) ? 4 : 2);
                                } else {
                                    i5 = i4;
                                }
                                if ((i5 & 19) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1072225887, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold.<anonymous>.<anonymous> (RevenueCatDialogScaffold.kt:61)");
                                    }
                                    float f2 = 0;
                                    boolean z = C1486Dp.m11022equalsimpl0(paddingValues.getBottom(), C1486Dp.m11017constructorimpl(f2)) && C1486Dp.m11022equalsimpl0(paddingValues.getTop(), C1486Dp.m11017constructorimpl(f2));
                                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    boolean z2 = Build.VERSION.SDK_INT <= 34;
                                    composer3.startReplaceGroup(-1581046047);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):RevenueCatDialogScaffold.kt#9igjgp");
                                    boolean z3 = (i5 & 14) == 4;
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt$RevenueCatDialogScaffold$1$1$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Modifier invoke(Modifier conditional) {
                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                return PaddingKt.padding(conditional, paddingValues);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    composer3.endReplaceGroup();
                                    Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierFillMaxSize$default, z2, (Function1) objRememberedValue);
                                    if (z) {
                                        fM11017constructorimpl2 = f;
                                    } else {
                                        fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(f2);
                                    }
                                    Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(modifierConditional, 0.0f, 0.0f, 0.0f, fM11017constructorimpl2, 7, null);
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2858paddingqDBjuR0$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer3);
                                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1422019852, "C71@3323L9:RevenueCatDialogScaffold.kt#51odh9");
                                    function22.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54), composer2, 806879232, 446);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold(handleCloseRequest, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getDialogMaxHeightPercentage(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1654283702, "C(getDialogMaxHeightPercentage)80@3459L19,83@3582L21:RevenueCatDialogScaffold.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1654283702, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.getDialogMaxHeightPercentage (RevenueCatDialogScaffold.kt:79)");
        }
        if (HelperFunctionsKt.windowAspectRatio(composer, 0) < 1.25f) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return 1.0f;
        }
        float f = WindowHelperKt.hasCompactDimension(composer, 0) ? 1.0f : 0.85f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }

    public static final boolean shouldUsePlatformDefaultWidth(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 242326841, "C(shouldUsePlatformDefaultWidth)89@3767L21:RevenueCatDialogScaffold.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(242326841, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.shouldUsePlatformDefaultWidth (RevenueCatDialogScaffold.kt:88)");
        }
        boolean z = !WindowHelperKt.hasCompactDimension(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }
}
