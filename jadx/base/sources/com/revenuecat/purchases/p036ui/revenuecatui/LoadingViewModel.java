package com.revenuecat.purchases.p036ui.revenuecatui;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPaywallUiState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: LoadingPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J*\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020!H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u001cH\u0016J\u0012\u0010=\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fH\u0016J\b\u0010B\u001a\u00020\u001cH\u0016J\b\u0010C\u001a\u00020\u001cH\u0016J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020!H\u0016J\b\u0010N\u001a\u00020\u001cH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006O"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/LoadingViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "actionError", "Landroidx/compose/runtime/State;", "Lcom/revenuecat/purchases/PurchasesError;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "", "getActionInProgress", "purchaseCompleted", "getPurchaseCompleted", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "getWorkflowState", "clearActionError", "", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getWebCheckoutUrl", "", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "handleBackNavigation", "handlePackagePurchase", "activity", "Landroid/app/Activity;", "pkg", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleWorkflowAction", "componentId", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "invalidateCustomerInfoCache", "notifyUrlOpened", ImagesContract.URL, "notifyWebCheckoutOpened", "onPaywallDismissed", "onPaywallPresented", "onTransitionComplete", "transitionId", "", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "trackComponentInteraction", "data", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "trackExitOffer", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "trackPaywallImpressionIfNeeded", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class LoadingViewModel implements PaywallViewModel {
    private final MutableStateFlow<PaywallState> _state;
    private final State<PurchasesError> actionError;
    private final State<Boolean> actionInProgress;
    private final State<Boolean> purchaseCompleted;
    private final ResourceProvider resourceProvider;
    private final State<WorkflowPaywallUiState> workflowState;

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult result) {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        return null;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public boolean handleBackNavigation() {
        return false;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyUrlOpened(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyWebCheckoutOpened() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallDismissed() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallPresented() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onTransitionComplete(int transitionId) {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
    }

    public LoadingViewModel(PaywallState state, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.resourceProvider = resourceProvider;
        this.actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.purchaseCompleted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.workflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._state = StateFlowKt.MutableStateFlow(state);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return this.resourceProvider;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.asStateFlow(this._state);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this.actionInProgress;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this.actionError;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this.purchaseCompleted;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<WorkflowPaywallUiState> getWorkflowState() {
        return this.workflowState;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
