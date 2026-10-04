package com.revenuecat.purchases.p036ui.revenuecatui.components.button;

import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonComponentInteraction.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0000¨\u0006\b"}, m1599d2 = {"componentInteraction", "Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentInteraction;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "localeUrl", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "isPurchaseRelated", "", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ButtonComponentInteractionKt {
    public static final ButtonComponentInteraction componentInteraction(ButtonComponentStyle.Action action, String str) {
        Intrinsics.checkNotNullParameter(action, "<this>");
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases) {
            return new ButtonComponentInteraction(PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, null, 2, null);
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateBack) {
            return new ButtonComponentInteraction("navigate_back", null, 2, null);
        }
        if (action instanceof ButtonComponentStyle.Action.CloseWorkflow) {
            return new ButtonComponentInteraction("close_workflow", null, 2, null);
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateTo) {
            return componentInteraction(((ButtonComponentStyle.Action.NavigateTo) action).getDestination(), str);
        }
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage ? true : action instanceof ButtonComponentStyle.Action.WebCheckout ? true : action instanceof ButtonComponentStyle.Action.WebProductSelection ? true : action instanceof ButtonComponentStyle.Action.CustomWebCheckout ? true : action instanceof ButtonComponentStyle.Action.WorkflowTrigger ? true : action instanceof ButtonComponentStyle.Action.NoOp) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final ButtonComponentInteraction componentInteraction(ButtonComponentStyle.Action.NavigateTo.Destination destination, String str) {
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter) {
            return new ButtonComponentInteraction("navigate_to_customer_center", null, 2, null);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Url) {
            return new ButtonComponentInteraction(((ButtonComponentStyle.Action.NavigateTo.Destination.Url) destination).getComponentInteractionValue(), str);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) {
            return new ButtonComponentInteraction("navigate_to_sheet", null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isPurchaseRelated(ButtonComponentStyle.Action action) {
        Intrinsics.checkNotNullParameter(action, "<this>");
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage ? true : action instanceof ButtonComponentStyle.Action.WebCheckout ? true : action instanceof ButtonComponentStyle.Action.WebProductSelection ? true : action instanceof ButtonComponentStyle.Action.CustomWebCheckout) {
            return true;
        }
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases ? true : action instanceof ButtonComponentStyle.Action.NavigateBack ? true : action instanceof ButtonComponentStyle.Action.NavigateTo ? true : action instanceof ButtonComponentStyle.Action.WorkflowTrigger ? true : action instanceof ButtonComponentStyle.Action.CloseWorkflow ? true : action instanceof ButtonComponentStyle.Action.NoOp) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
