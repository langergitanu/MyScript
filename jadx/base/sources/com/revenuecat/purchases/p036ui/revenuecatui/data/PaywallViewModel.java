package com.revenuecat.purchases.p036ui.revenuecatui.data;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.State;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\b\u0010\u0018\u001a\u00020\u0019H&J\u0014\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\bH&J,\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H¦@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0019H&J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u001eH&J\b\u00103\u001a\u00020\u0019H&J\b\u00104\u001a\u00020\u0019H&J\b\u00105\u001a\u00020\u0019H&J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u000208H&J\b\u00109\u001a\u00020\u0019H&J\u0012\u0010:\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H&J\u0018\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\bH&J\b\u0010?\u001a\u00020\u0019H&J\b\u0010@\u001a\u00020\u0019H&J\u0010\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020CH&J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020FH&J.\u0010D\u001a\u00020\u00192\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u001e2\u0006\u0010J\u001a\u00020\u001e2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u001eH&J\b\u0010P\u001a\u00020\u0019H&R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006QÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "", "actionError", "Landroidx/compose/runtime/State;", "Lcom/revenuecat/purchases/PurchasesError;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "", "getActionInProgress", "purchaseCompleted", "getPurchaseCompleted", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "getWorkflowState", "clearActionError", "", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getWebCheckoutUrl", "", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "handleBackNavigation", "handlePackagePurchase", "activity", "Landroid/app/Activity;", "pkg", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleWorkflowAction", "componentId", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "invalidateCustomerInfoCache", "notifyUrlOpened", ImagesContract.URL, "notifyWebCheckoutOpened", "onPaywallDismissed", "onPaywallPresented", "onTransitionComplete", "transitionId", "", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDark", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "trackComponentInteraction", "data", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "componentType", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;", "componentName", "componentValue", "componentUrl", "trackExitOffer", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "trackPaywallImpressionIfNeeded", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PaywallViewModel {
    void clearActionError();

    void closePaywall(PaywallResult result);

    State<PurchasesError> getActionError();

    State<Boolean> getActionInProgress();

    State<Boolean> getPurchaseCompleted();

    ResourceProvider getResourceProvider();

    StateFlow<PaywallState> getState();

    String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout);

    State<WorkflowPaywallUiState> getWorkflowState();

    boolean handleBackNavigation();

    Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation);

    Object handleRestorePurchases(Continuation<? super Unit> continuation);

    void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType);

    void invalidateCustomerInfoCache();

    void notifyUrlOpened(String url);

    void notifyWebCheckoutOpened();

    void onPaywallDismissed();

    void onPaywallPresented();

    void onTransitionComplete(int transitionId);

    void preloadExitOffering();

    void purchaseSelectedPackage(Activity activity);

    void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDark);

    void refreshStateIfLocaleChanged();

    void restorePurchases();

    void selectPackage(TemplateConfiguration.PackageInfo packageToSelect);

    void trackComponentInteraction(PaywallComponentInteractionData data);

    void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier);

    void trackPaywallImpressionIfNeeded();

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void trackComponentInteraction(PaywallViewModel paywallViewModel, PaywallComponentType componentType, String str, String componentValue, String str2) {
            Intrinsics.checkNotNullParameter(componentType, "componentType");
            Intrinsics.checkNotNullParameter(componentValue, "componentValue");
            PaywallViewModel.super.trackComponentInteraction(componentType, str, componentValue, str2);
        }
    }

    static /* synthetic */ void trackComponentInteraction$default(PaywallViewModel paywallViewModel, PaywallComponentType paywallComponentType, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackComponentInteraction");
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        paywallViewModel.trackComponentInteraction(paywallComponentType, str, str2, str3);
    }

    default void trackComponentInteraction(PaywallComponentType componentType, String componentName, String componentValue, String componentUrl) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        trackComponentInteraction(new PaywallComponentInteractionData(componentType, componentName, componentValue, componentUrl, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524272, (DefaultConstructorMarker) null));
    }

    static /* synthetic */ void closePaywall$default(PaywallViewModel paywallViewModel, PaywallResult paywallResult, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePaywall");
        }
        if ((i & 1) != 0) {
            paywallResult = null;
        }
        paywallViewModel.closePaywall(paywallResult);
    }

    static /* synthetic */ Object handlePackagePurchase$default(PaywallViewModel paywallViewModel, Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePackagePurchase");
        }
        if ((i & 4) != 0) {
            resolvedOffer = null;
        }
        return paywallViewModel.handlePackagePurchase(activity, r2, resolvedOffer, continuation);
    }
}
