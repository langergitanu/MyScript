package com.revenuecat.purchases.p036ui.revenuecatui.workflow;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.WorkflowScreen;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowScreenMapper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/workflow/WorkflowScreenMapper;", "", "()V", "toPaywallComponents", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "screen", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "screenId", "", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "toPaywallComponentsData", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowScreenMapper {
    public static final int $stable = 0;
    public static final WorkflowScreenMapper INSTANCE = new WorkflowScreenMapper();

    private WorkflowScreenMapper() {
    }

    public final PaywallComponentsData toPaywallComponentsData(WorkflowScreen screen, String screenId) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        return new PaywallComponentsData(screenId, screen.getTemplateName(), screen.getAssetBaseURL(), screen.getComponentsConfig(), screen.getComponentsLocalizations(), screen.m13746getDefaultLocaleIdentifieruqtKvyA(), screen.getRevision(), screen.getZeroDecimalPlaceCountries(), screen.getExitOffers(), screen.getProductChangeConfig(), screen.getAutomaticallyScaleFontSize(), screen.getStateDeclarations(), null);
    }

    public final Offering.PaywallComponents toPaywallComponents(WorkflowScreen screen, String screenId, UiConfig uiConfig) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        return new Offering.PaywallComponents(uiConfig, toPaywallComponentsData(screen, screenId));
    }
}
