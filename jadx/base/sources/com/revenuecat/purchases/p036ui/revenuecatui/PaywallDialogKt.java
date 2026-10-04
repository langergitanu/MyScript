package com.revenuecat.purchases.p036ui.revenuecatui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.p036ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.RevenueCatDialogScaffoldKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PaywallDialog.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a3\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001aH\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010H\u0002¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002"}, m1599d2 = {"PaywallDialog", "", "paywallDialogOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Landroidx/compose/runtime/Composer;I)V", "PaywallDialogContent", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "onDismissRequest", "Lkotlin/Function1;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "buildPaywallOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "dismissRequest", "Lkotlin/Function0;", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "revenuecatui_defaultsRelease", "shouldDisplayDialog", "", "currentDialogOffering", "pendingExitOffering"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallDialogKt {
    public static final void PaywallDialog(final PaywallDialogOptions paywallDialogOptions, Composer composer, final int i) {
        int i2;
        String str;
        final MutableState mutableState;
        PaywallDialogKt$PaywallDialog$3$1 paywallDialogKt$PaywallDialog$3$1;
        Intrinsics.checkNotNullParameter(paywallDialogOptions, "paywallDialogOptions");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772149319);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialog)25@1189L46,25@1172L63,34@1485L157,39@1674L53,41@1769L160,41@1733L196,47@1967L134,54@2283L571,54@2224L630,*75@3079L258,72@2918L430:PaywallDialog.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772149319, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialog (PaywallDialog.kt:23)");
            }
            final Function1<CustomerInfo, Boolean> shouldDisplayBlock = paywallDialogOptions.getShouldDisplayBlock();
            Object[] objArr = new Object[0];
            composerStartRestartGroup.startReplaceGroup(751283007);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(shouldDisplayBlock);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$shouldDisplayDialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<Boolean> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(shouldDisplayBlock == null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.m7530rememberSaveable(objArr, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 6);
            composerStartRestartGroup.startReplaceGroup(751284803);
            ComposerKt.sourceInformation(composerStartRestartGroup, "27@1319L125,27@1282L162");
            if (shouldDisplayBlock != null) {
                composerStartRestartGroup.startReplaceGroup(751287246);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(shouldDisplayBlock);
                PaywallDialogKt$PaywallDialog$1$1 paywallDialogKt$PaywallDialog$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || paywallDialogKt$PaywallDialog$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    paywallDialogKt$PaywallDialog$1$1RememberedValue = new PaywallDialogKt$PaywallDialog$1$1(shouldDisplayBlock, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$1$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(paywallDialogOptions, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialog$1$1RememberedValue, composerStartRestartGroup, i2 & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751292590);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PaywallDialog$lambda$1(mutableState2) ? paywallDialogOptions.getOfferingSelection$revenuecatui_defaultsRelease() : null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751298534);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue3;
            composerStartRestartGroup.endReplaceGroup();
            Boolean boolValueOf = Boolean.valueOf(PaywallDialog$lambda$1(mutableState2));
            composerStartRestartGroup.startReplaceGroup(751301681);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState2) | (i3 == 4);
            PaywallDialogKt$PaywallDialog$2$1 paywallDialogKt$PaywallDialog$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || paywallDialogKt$PaywallDialog$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialog$2$1RememberedValue = new PaywallDialogKt$PaywallDialog$2$1(paywallDialogOptions, mutableState2, mutableState3, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialog$2$1RememberedValue, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(751307991);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(mutableState2) | (i3 == 4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$dismissDialog$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        mutableState3.setValue(null);
                        PaywallDialogKt.PaywallDialog$lambda$2(mutableState2, false);
                        Function0<Unit> dismissRequest = paywallDialogOptions.getDismissRequest();
                        if (dismissRequest != null) {
                            dismissRequest.invoke();
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final Function0 function0 = (Function0) objRememberedValue4;
            composerStartRestartGroup.endReplaceGroup();
            OfferingSelection offeringSelectionPaywallDialog$lambda$5 = PaywallDialog$lambda$5(mutableState3);
            OfferingSelection offeringSelectionPaywallDialog$lambda$8 = PaywallDialog$lambda$8(mutableState4);
            composerStartRestartGroup.startReplaceGroup(751318540);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(shouldDisplayBlock) | composerStartRestartGroup.changed(function0);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):PaywallDialog.kt#9igjgp";
                mutableState = mutableState4;
                paywallDialogKt$PaywallDialog$3$1 = new PaywallDialogKt$PaywallDialog$3$1(shouldDisplayBlock, function0, mutableState3, mutableState4, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$3$1);
            } else {
                paywallDialogKt$PaywallDialog$3$1 = objRememberedValue5;
                str = "CC(remember):PaywallDialog.kt#9igjgp";
                mutableState = mutableState4;
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(offeringSelectionPaywallDialog$lambda$5, offeringSelectionPaywallDialog$lambda$8, (Function2) paywallDialogKt$PaywallDialog$3$1, composerStartRestartGroup, 0);
            OfferingSelection offeringSelectionPaywallDialog$lambda$52 = PaywallDialog$lambda$5(mutableState3);
            if (offeringSelectionPaywallDialog$lambda$52 != null) {
                composerStartRestartGroup.startReplaceGroup(714520786);
                ComposerKt.sourceInformation(composerStartRestartGroup, str);
                boolean zChanged6 = composerStartRestartGroup.changed(function0);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function1) new Function1<OfferingSelection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(OfferingSelection offeringSelection) {
                            invoke2(offeringSelection);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(OfferingSelection offeringSelection) {
                            if (offeringSelection == null) {
                                function0.invoke();
                            } else {
                                mutableState.setValue(offeringSelection);
                                mutableState3.setValue(null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceGroup();
                PaywallDialogContent(paywallDialogOptions, offeringSelectionPaywallDialog$lambda$52, (Function1) objRememberedValue6, composerStartRestartGroup, i3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallDialogKt.PaywallDialog(paywallDialogOptions, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PaywallDialog$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialog$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$5(MutableState<OfferingSelection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$8(MutableState<OfferingSelection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialogContent(final PaywallDialogOptions paywallDialogOptions, final OfferingSelection offeringSelection, final Function1<? super OfferingSelection, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(217055693);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialogContent)P(2)93@3575L433,104@4030L130,109@4187L47,109@4166L68,114@4295L23,115@4326L58,113@4240L144:PaywallDialog.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(offeringSelection) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217055693, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent (PaywallDialog.kt:92)");
            }
            composerStartRestartGroup.startReplaceGroup(-926362855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = buildPaywallOptions(paywallDialogOptions, offeringSelection, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function1.invoke(null);
                    }
                }, new Function2<Offering, PaywallResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Offering offering, PaywallResult paywallResult) {
                        invoke2(offering, paywallResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Offering offering, PaywallResult paywallResult) {
                        function1.invoke(offering != null ? new OfferingSelection.OfferingType(offering) : null);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PaywallOptions paywallOptions = (PaywallOptions) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            final PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptions, paywallDialogOptions.getShouldDisplayBlock(), composerStartRestartGroup, 0, 0);
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-926343657);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(paywallViewModel);
            PaywallDialogKt$PaywallDialogContent$1$1 paywallDialogKt$PaywallDialogContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || paywallDialogKt$PaywallDialogContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialogContent$1$1RememberedValue = new PaywallDialogKt$PaywallDialogContent$1$1(paywallViewModel, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialogContent$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialogContent$1$1RememberedValue, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(-926340225);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(paywallViewModel);
            PaywallDialogKt$PaywallDialogContent$2$1 paywallDialogKt$PaywallDialogContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || paywallDialogKt$PaywallDialogContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialogContent$2$1RememberedValue = new PaywallDialogKt$PaywallDialogContent$2$1(paywallViewModel);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialogContent$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold((Function0) paywallDialogKt$PaywallDialogContent$2$1RememberedValue, ComposableLambdaKt.rememberComposableLambda(1910079027, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C116@4336L42:PaywallDialog.kt#ao8ymz");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1910079027, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent.<anonymous> (PaywallDialog.kt:116)");
                    }
                    InternalPaywallKt.InternalPaywall(paywallOptions, paywallViewModel, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.4
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
                    PaywallDialogKt.PaywallDialogContent(paywallDialogOptions, offeringSelection, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static /* synthetic */ PaywallOptions buildPaywallOptions$default(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0 function0, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        return buildPaywallOptions(paywallDialogOptions, offeringSelection, function0, function2);
    }

    private static final PaywallOptions buildPaywallOptions(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0<Unit> function0, Function2<? super Offering, ? super PaywallResult, Unit> function2) {
        return new PaywallOptions.Builder(function0).setOfferingSelection$revenuecatui_defaultsRelease(offeringSelection).setShouldDisplayDismissButton(paywallDialogOptions.getShouldDisplayDismissButton()).setFontProvider(paywallDialogOptions.getFontProvider()).setListener(paywallDialogOptions.getListener()).setPurchaseLogic(paywallDialogOptions.getPurchaseLogic()).setDismissRequestWithExitOffering$revenuecatui_defaultsRelease(function2).setCustomVariables(paywallDialogOptions.getCustomVariables()).build();
    }
}
