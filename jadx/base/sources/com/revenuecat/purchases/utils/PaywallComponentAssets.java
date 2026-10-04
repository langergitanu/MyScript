package com.revenuecat.purchases.utils;

import android.net.Uri;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallComponentAssets.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/PaywallComponentAssets;", "", "imageUris", "", "Landroid/net/Uri;", "webViewUrls", "", "(Ljava/util/Set;Ljava/util/Set;)V", "getImageUris", "()Ljava/util/Set;", "getWebViewUrls", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class PaywallComponentAssets {
    private final Set<Uri> imageUris;
    private final Set<String> webViewUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallComponentAssets copy$default(PaywallComponentAssets paywallComponentAssets, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            set = paywallComponentAssets.imageUris;
        }
        if ((i & 2) != 0) {
            set2 = paywallComponentAssets.webViewUrls;
        }
        return paywallComponentAssets.copy(set, set2);
    }

    public final Set<Uri> component1() {
        return this.imageUris;
    }

    public final Set<String> component2() {
        return this.webViewUrls;
    }

    public final PaywallComponentAssets copy(Set<? extends Uri> imageUris, Set<String> webViewUrls) {
        Intrinsics.checkNotNullParameter(imageUris, "imageUris");
        Intrinsics.checkNotNullParameter(webViewUrls, "webViewUrls");
        return new PaywallComponentAssets(imageUris, webViewUrls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallComponentAssets)) {
            return false;
        }
        PaywallComponentAssets paywallComponentAssets = (PaywallComponentAssets) other;
        return Intrinsics.areEqual(this.imageUris, paywallComponentAssets.imageUris) && Intrinsics.areEqual(this.webViewUrls, paywallComponentAssets.webViewUrls);
    }

    public int hashCode() {
        return (this.imageUris.hashCode() * 31) + this.webViewUrls.hashCode();
    }

    public String toString() {
        return "PaywallComponentAssets(imageUris=" + this.imageUris + ", webViewUrls=" + this.webViewUrls + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallComponentAssets(Set<? extends Uri> imageUris, Set<String> webViewUrls) {
        Intrinsics.checkNotNullParameter(imageUris, "imageUris");
        Intrinsics.checkNotNullParameter(webViewUrls, "webViewUrls");
        this.imageUris = imageUris;
        this.webViewUrls = webViewUrls;
    }

    public final Set<Uri> getImageUris() {
        return this.imageUris;
    }

    public final Set<String> getWebViewUrls() {
        return this.webViewUrls;
    }
}
