package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.VerifiedReward;
import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.checkpoints.CheckpointEvent;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.common.workflows.events.WorkflowEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.paywalls.events.BackendPaywallComponentFields;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventKt;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackendStoredEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020 2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020!2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\"*\u00020#2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0015\u001a\u00020\u0014*\u00020$2\u0006\u0010\u0017\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020%2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020&2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020'2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020(2\u0006\u0010\u0017\u001a\u00020\u0001H\u0000\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\" \u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\" \u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006)"}, m1599d2 = {"wireEntitlementId", "", "Lcom/revenuecat/purchases/VerifiedReward;", "getWireEntitlementId$annotations", "(Lcom/revenuecat/purchases/VerifiedReward;)V", "getWireEntitlementId", "(Lcom/revenuecat/purchases/VerifiedReward;)Ljava/lang/String;", "wireType", "getWireType$annotations", "getWireType", "wireVirtualCurrencyAmount", "", "getWireVirtualCurrencyAmount$annotations", "getWireVirtualCurrencyAmount", "(Lcom/revenuecat/purchases/VerifiedReward;)Ljava/lang/Integer;", "wireVirtualCurrencyCode", "getWireVirtualCurrencyCode$annotations", "getWireVirtualCurrencyCode", "toBackendEvent", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "toBackendStoredEvent", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "appUserID", "appSessionID", "Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;", "Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Open;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardEarnedUnverified;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardFailedToVerify;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardGranted;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardVerified;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Checkpoint;", "Lcom/revenuecat/purchases/checkpoints/CheckpointEvent;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class BackendStoredEventKt {
    private static /* synthetic */ void getWireEntitlementId$annotations(VerifiedReward verifiedReward) {
    }

    private static /* synthetic */ void getWireType$annotations(VerifiedReward verifiedReward) {
    }

    private static /* synthetic */ void getWireVirtualCurrencyAmount$annotations(VerifiedReward verifiedReward) {
    }

    private static /* synthetic */ void getWireVirtualCurrencyCode$annotations(VerifiedReward verifiedReward) {
    }

    public static final BackendEvent toBackendEvent(BackendStoredEvent backendStoredEvent) {
        Intrinsics.checkNotNullParameter(backendStoredEvent, "<this>");
        if (backendStoredEvent instanceof BackendStoredEvent.Paywalls) {
            return ((BackendStoredEvent.Paywalls) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomerCenter) {
            return ((BackendStoredEvent.CustomerCenter) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.C7175Ad) {
            return ((BackendStoredEvent.C7175Ad) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomPaywall) {
            return ((BackendStoredEvent.CustomPaywall) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.Checkpoint) {
            return ((BackendStoredEvent.Checkpoint) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.Workflows) {
            return ((BackendStoredEvent.Workflows) backendStoredEvent).getEvent();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ BackendStoredEvent.Checkpoint toBackendStoredEvent(CheckpointEvent checkpointEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(checkpointEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = checkpointEvent.getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
        return new BackendStoredEvent.Checkpoint(new BackendEvent.Checkpoint(string, 1, BackendEvent.CHECKPOINT_EVENT_TYPE, checkpointEvent.getIdentifier(), appUserID, appSessionID, checkpointEvent.getTimestamp().getTime()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(PaywallEvent paywallEvent, String appUserID) {
        Intrinsics.checkNotNullParameter(paywallEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (paywallEvent.getType() == PaywallEventType.PURCHASE_INITIATED || paywallEvent.getType() == PaywallEventType.PURCHASE_ERROR) {
            return null;
        }
        BackendPaywallComponentFields backendComponentFields = PaywallEventKt.toBackendComponentFields(paywallEvent.getComponentInteraction());
        String string = paywallEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        String value = paywallEvent.getType().getValue();
        String string2 = paywallEvent.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "data.sessionIdentifier.toString()");
        String offeringIdentifier = paywallEvent.getData().getPresentedOfferingContext().getOfferingIdentifier();
        String paywallIdentifier = paywallEvent.getData().getPaywallIdentifier();
        int paywallRevision = paywallEvent.getData().getPaywallRevision();
        long time = paywallEvent.getCreationData().getDate().getTime();
        String displayMode = paywallEvent.getData().getDisplayMode();
        boolean darkMode = paywallEvent.getData().getDarkMode();
        String localeIdentifier = paywallEvent.getData().getLocaleIdentifier();
        String workflowId = paywallEvent.getData().getWorkflowId();
        BackendEvent.PresentedOfferingContextData presentedOfferingContextDataFromContext = BackendEvent.PresentedOfferingContextData.INSTANCE.fromContext(paywallEvent.getData().getPresentedOfferingContext(), paywallEvent.getData().getPaywallIdentifier(), paywallEvent.getData().getWorkflowId(), paywallEvent.getData().getTraceId());
        ExitOfferType exitOfferType = paywallEvent.getData().getExitOfferType();
        return new BackendStoredEvent.Paywalls(new BackendEvent.Paywalls(string, 1, value, appUserID, string2, offeringIdentifier, paywallIdentifier, paywallRevision, time, displayMode, darkMode, localeIdentifier, workflowId, presentedOfferingContextDataFromContext, exitOfferType != null ? exitOfferType.getValue() : null, paywallEvent.getData().getExitOfferingIdentifier(), paywallEvent.getData().getPackageIdentifier(), paywallEvent.getData().getProductIdentifier(), paywallEvent.getData().getErrorCode(), paywallEvent.getData().getErrorMessage(), backendComponentFields.getComponentType(), backendComponentFields.getComponentName(), backendComponentFields.getComponentValue(), backendComponentFields.getComponentUrl(), backendComponentFields.getOriginIndex(), backendComponentFields.getDestinationIndex(), backendComponentFields.getOriginContextName(), backendComponentFields.getDestinationContextName(), backendComponentFields.getDefaultIndex(), backendComponentFields.getOriginPackageIdentifier(), backendComponentFields.getDestinationPackageIdentifier(), backendComponentFields.getDefaultPackageIdentifier(), backendComponentFields.getOriginProductIdentifier(), backendComponentFields.getDestinationProductIdentifier(), backendComponentFields.getDefaultProductIdentifier(), backendComponentFields.getCurrentPackageIdentifier(), backendComponentFields.getResultingPackageIdentifier(), backendComponentFields.getCurrentProductIdentifier(), backendComponentFields.getResultingProductIdentifier()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterImpressionEvent customerCenterImpressionEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterImpressionEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterImpressionEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterImpressionEvent.getData().getRevisionID(), customerCenterImpressionEvent.getData().getType(), appUserID, appSessionID, customerCenterImpressionEvent.getData().getTimestamp().getTime(), customerCenterImpressionEvent.getData().getDarkMode(), customerCenterImpressionEvent.getData().getLocale(), customerCenterImpressionEvent.getData().getDisplayMode(), null, null, null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterSurveyOptionChosenEvent customerCenterSurveyOptionChosenEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterSurveyOptionChosenEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterSurveyOptionChosenEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterSurveyOptionChosenEvent.getData().getRevisionID(), customerCenterSurveyOptionChosenEvent.getData().getType(), appUserID, appSessionID, customerCenterSurveyOptionChosenEvent.getData().getTimestamp().getTime(), customerCenterSurveyOptionChosenEvent.getData().getDarkMode(), customerCenterSurveyOptionChosenEvent.getData().getLocale(), customerCenterSurveyOptionChosenEvent.getData().getDisplayMode(), customerCenterSurveyOptionChosenEvent.getData().getPath(), customerCenterSurveyOptionChosenEvent.getData().getUrl(), customerCenterSurveyOptionChosenEvent.getData().getSurveyOptionID()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent adEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(adEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        if (adEvent instanceof AdEvent.Displayed) {
            return toBackendStoredEvent((AdEvent.Displayed) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.Open) {
            return toBackendStoredEvent((AdEvent.Open) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.Revenue) {
            return toBackendStoredEvent((AdEvent.Revenue) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.Loaded) {
            return toBackendStoredEvent((AdEvent.Loaded) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.FailedToLoad) {
            return toBackendStoredEvent((AdEvent.FailedToLoad) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.RewardEarnedUnverified) {
            return toBackendStoredEvent((AdEvent.RewardEarnedUnverified) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.RewardVerified) {
            return toBackendStoredEvent((AdEvent.RewardVerified) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.RewardGranted) {
            return toBackendStoredEvent((AdEvent.RewardGranted) adEvent, appUserID, appSessionID);
        }
        if (adEvent instanceof AdEvent.RewardFailedToVerify) {
            return toBackendStoredEvent((AdEvent.RewardFailedToVerify) adEvent, appUserID, appSessionID);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Open open, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(open, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(open.getId(), open.getEventVersion(), open.getType().getValue(), open.getTimestamp(), open.getNetworkName(), open.getMediatorName(), open.getAdFormat(), open.getPlacement(), open.getAdUnitId(), open.getImpressionId(), appUserID, appSessionID, open.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8380416, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Displayed displayed, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(displayed, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(displayed.getId(), displayed.getEventVersion(), displayed.getType().getValue(), displayed.getTimestamp(), displayed.getNetworkName(), displayed.getMediatorName(), displayed.getAdFormat(), displayed.getPlacement(), displayed.getAdUnitId(), displayed.getImpressionId(), appUserID, appSessionID, displayed.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8380416, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Revenue revenue, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(revenue, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(revenue.getId(), revenue.getEventVersion(), revenue.getType().getValue(), revenue.getTimestamp(), revenue.getNetworkName(), revenue.getMediatorName(), revenue.getAdFormat(), revenue.getPlacement(), revenue.getAdUnitId(), revenue.getImpressionId(), appUserID, appSessionID, revenue.getCaptureMethod().getValue(), Long.valueOf(revenue.getRevenueMicros()), revenue.getCurrency(), revenue.getPrecision(), (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8323072, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Loaded loaded, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(loaded, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(loaded.getId(), loaded.getEventVersion(), loaded.getType().getValue(), loaded.getTimestamp(), loaded.getNetworkName(), loaded.getMediatorName(), loaded.getAdFormat(), loaded.getPlacement(), loaded.getAdUnitId(), loaded.getImpressionId(), appUserID, appSessionID, loaded.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8380416, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.FailedToLoad failedToLoad, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(failedToLoad, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(failedToLoad.getId(), failedToLoad.getEventVersion(), failedToLoad.getType().getValue(), failedToLoad.getTimestamp(), (String) null, failedToLoad.getMediatorName(), failedToLoad.getAdFormat(), failedToLoad.getPlacement(), failedToLoad.getAdUnitId(), failedToLoad.getImpressionId(), appUserID, appSessionID, failedToLoad.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, failedToLoad.getMediatorErrorCode(), (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8314896, (DefaultConstructorMarker) null));
    }

    private static final String getWireType(VerifiedReward verifiedReward) {
        if (verifiedReward instanceof VerifiedReward.VirtualCurrency) {
            return "virtual_currency";
        }
        if (verifiedReward instanceof VerifiedReward.Entitlement) {
            return "entitlement";
        }
        if (Intrinsics.areEqual(verifiedReward, VerifiedReward.NoReward.INSTANCE)) {
            return "no_reward";
        }
        if (Intrinsics.areEqual(verifiedReward, VerifiedReward.UnsupportedReward.INSTANCE)) {
            return "unsupported_reward";
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String getWireVirtualCurrencyCode(VerifiedReward verifiedReward) {
        VerifiedReward.VirtualCurrency virtualCurrency = verifiedReward instanceof VerifiedReward.VirtualCurrency ? (VerifiedReward.VirtualCurrency) verifiedReward : null;
        if (virtualCurrency != null) {
            return virtualCurrency.getCode();
        }
        return null;
    }

    private static final Integer getWireVirtualCurrencyAmount(VerifiedReward verifiedReward) {
        VerifiedReward.VirtualCurrency virtualCurrency = verifiedReward instanceof VerifiedReward.VirtualCurrency ? (VerifiedReward.VirtualCurrency) verifiedReward : null;
        if (virtualCurrency != null) {
            return Integer.valueOf(virtualCurrency.getAmount());
        }
        return null;
    }

    private static final String getWireEntitlementId(VerifiedReward verifiedReward) {
        VerifiedReward.Entitlement entitlement = verifiedReward instanceof VerifiedReward.Entitlement ? (VerifiedReward.Entitlement) verifiedReward : null;
        if (entitlement != null) {
            return entitlement.getIdentifier();
        }
        return null;
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.RewardEarnedUnverified rewardEarnedUnverified, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(rewardEarnedUnverified, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(rewardEarnedUnverified.getId(), rewardEarnedUnverified.getEventVersion(), rewardEarnedUnverified.getType().getValue(), rewardEarnedUnverified.getTimestamp(), rewardEarnedUnverified.getNetworkName(), rewardEarnedUnverified.getMediatorName(), rewardEarnedUnverified.getAdFormat(), rewardEarnedUnverified.getPlacement(), rewardEarnedUnverified.getAdUnitId(), rewardEarnedUnverified.getImpressionId(), appUserID, appSessionID, rewardEarnedUnverified.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, Boolean.valueOf(rewardEarnedUnverified.getRewardVerificationEnabled()), (String) null, (String) null, (Integer) null, (String) null, (String) null, 8249344, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.RewardVerified rewardVerified, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(rewardVerified, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(rewardVerified.getId(), rewardVerified.getEventVersion(), rewardVerified.getType().getValue(), rewardVerified.getTimestamp(), rewardVerified.getNetworkName(), rewardVerified.getMediatorName(), rewardVerified.getAdFormat(), rewardVerified.getPlacement(), rewardVerified.getAdUnitId(), rewardVerified.getImpressionId(), appUserID, appSessionID, rewardVerified.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 8380416, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.RewardGranted rewardGranted, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(rewardGranted, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(rewardGranted.getId(), rewardGranted.getEventVersion(), rewardGranted.getType().getValue(), rewardGranted.getTimestamp(), rewardGranted.getNetworkName(), rewardGranted.getMediatorName(), rewardGranted.getAdFormat(), rewardGranted.getPlacement(), rewardGranted.getAdUnitId(), rewardGranted.getImpressionId(), appUserID, appSessionID, rewardGranted.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, getWireType(rewardGranted.getReward()), getWireVirtualCurrencyCode(rewardGranted.getReward()), getWireVirtualCurrencyAmount(rewardGranted.getReward()), getWireEntitlementId(rewardGranted.getReward()), (String) null, 4448256, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.RewardFailedToVerify rewardFailedToVerify, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(rewardFailedToVerify, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.C7175Ad(new BackendEvent.C7172Ad(rewardFailedToVerify.getId(), rewardFailedToVerify.getEventVersion(), rewardFailedToVerify.getType().getValue(), rewardFailedToVerify.getTimestamp(), rewardFailedToVerify.getNetworkName(), rewardFailedToVerify.getMediatorName(), rewardFailedToVerify.getAdFormat(), rewardFailedToVerify.getPlacement(), rewardFailedToVerify.getAdUnitId(), rewardFailedToVerify.getImpressionId(), appUserID, appSessionID, rewardFailedToVerify.getCaptureMethod().getValue(), (Long) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, rewardFailedToVerify.getFailureReason().getValue(), 4186112, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomPaywallEvent.Impression impression, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(impression, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = impression.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomPaywall(new BackendEvent.CustomPaywall(string, 1, "custom_paywall_impression", appUserID, appSessionID, impression.getCreationData().getDate().getTime(), impression.getData().getPaywallId(), impression.getData().getOfferingId(), BackendEvent.CustomPaywallPresentedOfferingContextData.INSTANCE.from(impression.getData().getPlacementIdentifier(), impression.getData().getTargetingRevision(), impression.getData().getTargetingRuleId())));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(WorkflowEvent workflowEvent, String appUserID) {
        String str;
        BackendEvent.Workflows.Properties properties;
        Intrinsics.checkNotNullParameter(workflowEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        boolean z = workflowEvent instanceof WorkflowEvent.StepStarted;
        if (z) {
            str = "workflow_step_started";
        } else if (workflowEvent instanceof WorkflowEvent.StepCompleted) {
            str = "workflow_step_completed";
        } else {
            if (!(workflowEvent instanceof WorkflowEvent.Close)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "workflow_close";
        }
        String str2 = str;
        if (z) {
            WorkflowEvent.StepStarted stepStarted = (WorkflowEvent.StepStarted) workflowEvent;
            properties = new BackendEvent.Workflows.Properties(workflowEvent.getWorkflowId(), workflowEvent.getStepId(), workflowEvent.getTraceId(), stepStarted.getFromStepId(), (String) null, stepStarted.getEntryReason(), stepStarted.isFirstStep(), stepStarted.isLastStep(), (String) null, (String) null, (Boolean) null, 1808, (DefaultConstructorMarker) null);
        } else if (workflowEvent instanceof WorkflowEvent.StepCompleted) {
            WorkflowEvent.StepCompleted stepCompleted = (WorkflowEvent.StepCompleted) workflowEvent;
            properties = new BackendEvent.Workflows.Properties(workflowEvent.getWorkflowId(), workflowEvent.getStepId(), workflowEvent.getTraceId(), (String) null, stepCompleted.getToStepId(), (String) null, stepCompleted.isFirstStep(), stepCompleted.isLastStep(), (String) null, (String) null, (Boolean) null, 1832, (DefaultConstructorMarker) null);
        } else {
            if (!(workflowEvent instanceof WorkflowEvent.Close)) {
                throw new NoWhenBranchMatchedException();
            }
            WorkflowEvent.Close close = (WorkflowEvent.Close) workflowEvent;
            properties = new BackendEvent.Workflows.Properties(workflowEvent.getWorkflowId(), workflowEvent.getStepId(), workflowEvent.getTraceId(), (String) null, (String) null, (String) null, close.isFirstStep(), close.isLastStep(), (String) null, (String) null, (Boolean) null, 1848, (DefaultConstructorMarker) null);
        }
        BackendEvent.Workflows.Properties properties2 = properties;
        String string = workflowEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.Workflows(new BackendEvent.Workflows(string, 1, BackendEvent.WORKFLOW_EVENT_TYPE, str2, workflowEvent.getCreationData().getDate().getTime(), appUserID, (BackendEvent.Workflows.Context) null, properties2, 64, (DefaultConstructorMarker) null));
    }
}
