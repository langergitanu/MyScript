package com.revenuecat.purchases.p036ui.revenuecatui.customercenter;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0081@¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"resolveButtonText", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "resolveOfferingSuspend", "Lcom/revenuecat/purchases/Offering;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ScreenOfferingExtensionsKt {

    /* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.values().length];
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1 */
    /* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt", m1609f = "ScreenOfferingExtensions.kt", m1610i = {0}, m1611l = {14}, m1612m = "resolveOfferingSuspend", m1613n = {"screenOffering"}, m1615s = {"L$0"})
    static final class C79541 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C79541(Continuation<? super C79541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScreenOfferingExtensionsKt.resolveOfferingSuspend(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveOfferingSuspend(CustomerCenterConfigData.Screen screen, PurchasesType purchasesType, Continuation<? super Offering> continuation) {
        C79541 c79541;
        CustomerCenterConfigData.ScreenOffering offering;
        if (continuation instanceof C79541) {
            c79541 = (C79541) continuation;
            if ((c79541.label & Integer.MIN_VALUE) != 0) {
                c79541.label -= Integer.MIN_VALUE;
            } else {
                c79541 = new C79541(continuation);
            }
        }
        Object objAwaitOfferings = c79541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c79541.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitOfferings);
            offering = screen.getOffering();
            if (offering == null) {
                return null;
            }
            c79541.L$0 = offering;
            c79541.label = 1;
            objAwaitOfferings = purchasesType.awaitOfferings(c79541);
            if (objAwaitOfferings == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            offering = (CustomerCenterConfigData.ScreenOffering) c79541.L$0;
            ResultKt.throwOnFailure(objAwaitOfferings);
        }
        Offerings offerings = (Offerings) objAwaitOfferings;
        int i2 = WhenMappings.$EnumSwitchMapping$0[offering.getType().ordinal()];
        if (i2 == 1) {
            return offerings.getCurrent();
        }
        if (i2 == 2) {
            String offeringId = offering.getOfferingId();
            if (offeringId != null) {
                return offerings.getAll().get(offeringId);
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String resolveButtonText(CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        String buttonText;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        return (offering == null || (buttonText = offering.getButtonText()) == null) ? localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BUY_SUBSCRIPTION) : buttonText;
    }
}
