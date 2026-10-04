package com.revenuecat.purchases.p036ui.revenuecatui;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016¨\u0006\u001aÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "", "onPurchaseCancelled", "", "onPurchaseCompleted", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "onPurchaseError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchasePackageInitiated", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resume", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/Resumable;", "onPurchaseStarted", "onRestoreCompleted", "onRestoreError", "onRestoreInitiated", "onRestoreStarted", "onUrlOpened", ImagesContract.URL, "", "onWebCheckoutOpened", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PaywallListener {
    default void onPurchaseCancelled() {
    }

    default void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
    }

    default void onPurchaseError(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    default void onPurchaseStarted(Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
    }

    default void onRestoreCompleted(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
    }

    default void onRestoreError(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    default void onRestoreStarted() {
    }

    default void onUrlOpened(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    default void onWebCheckoutOpened() {
    }

    /* JADX INFO: compiled from: PaywallListener.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onPurchasePackageInitiated(PaywallListener paywallListener, Package rcPackage, Resumable resume) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(resume, "resume");
            PaywallListener.super.onPurchasePackageInitiated(rcPackage, resume);
        }

        @Deprecated
        public static void onRestoreInitiated(PaywallListener paywallListener, Resumable resume) {
            Intrinsics.checkNotNullParameter(resume, "resume");
            PaywallListener.super.onRestoreInitiated(resume);
        }

        @Deprecated
        public static void onPurchaseStarted(PaywallListener paywallListener, Package rcPackage) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            PaywallListener.super.onPurchaseStarted(rcPackage);
        }

        @Deprecated
        public static void onPurchaseCompleted(PaywallListener paywallListener, CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
            PaywallListener.super.onPurchaseCompleted(customerInfo, storeTransaction);
        }

        @Deprecated
        public static void onPurchaseError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            PaywallListener.super.onPurchaseError(error);
        }

        @Deprecated
        public static void onPurchaseCancelled(PaywallListener paywallListener) {
            PaywallListener.super.onPurchaseCancelled();
        }

        @Deprecated
        public static void onRestoreStarted(PaywallListener paywallListener) {
            PaywallListener.super.onRestoreStarted();
        }

        @Deprecated
        public static void onRestoreCompleted(PaywallListener paywallListener, CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            PaywallListener.super.onRestoreCompleted(customerInfo);
        }

        @Deprecated
        public static void onRestoreError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            PaywallListener.super.onRestoreError(error);
        }

        @Deprecated
        public static void onWebCheckoutOpened(PaywallListener paywallListener) {
            PaywallListener.super.onWebCheckoutOpened();
        }

        @Deprecated
        public static void onUrlOpened(PaywallListener paywallListener, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            PaywallListener.super.onUrlOpened(url);
        }
    }

    default void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(resume, "resume");
        Resumable.invoke$default(resume, false, 1, null);
    }

    default void onRestoreInitiated(Resumable resume) {
        Intrinsics.checkNotNullParameter(resume, "resume");
        Resumable.invoke$default(resume, false, 1, null);
    }
}
