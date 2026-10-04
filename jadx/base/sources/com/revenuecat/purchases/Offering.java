package com.revenuecat.purchases;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.workflows.WorkflowScreenType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Offering.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001PB9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010F\u001a\u00020\u00002\u0006\u00102\u001a\u000203H\u0007J\u0012\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020IH\u0002J\u0011\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003J\u000e\u0010O\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u001a8G¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010$\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b%\u0010\u0014R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001d\u0010)\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b*\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010.R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u0001038FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001c\u001a\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u001d\u00108\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0016\u001a\u0004\b9\u0010\u0014R\u001d\u0010;\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0016\u001a\u0004\b<\u0010\u0014R\u001d\u0010>\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0016\u001a\u0004\b?\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001d\u0010C\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0016\u001a\u0004\bD\u0010\u0014¨\u0006Q"}, m1599d2 = {"Lcom/revenuecat/purchases/Offering;", "", Keys.IDENTIFIER, "", "serverDescription", TtmlNode.TAG_METADATA, "", "availablePackages", "", "Lcom/revenuecat/purchases/Package;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", WorkflowScreenType.PAYWALL, "Lcom/revenuecat/purchases/paywalls/PaywallData;", "paywallComponents", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "webCheckoutURL", "Ljava/net/URL;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/PaywallData;Lcom/revenuecat/purchases/Offering$PaywallComponents;Ljava/net/URL;)V", "annual", "getAnnual", "()Lcom/revenuecat/purchases/Package;", "annual$delegate", "Lkotlin/Lazy;", "getAvailablePackages", "()Ljava/util/List;", "hasPaywall", "", "hasPaywall$annotations", "()V", "()Z", "hasPaywallComponents", "getHasPaywallComponents$purchases_defaultsRelease", "setHasPaywallComponents$purchases_defaultsRelease", "(Z)V", "getIdentifier", "()Ljava/lang/String;", "lifetime", "getLifetime", "lifetime$delegate", "getMetadata", "()Ljava/util/Map;", "monthly", "getMonthly", "monthly$delegate", "getPaywall$annotations", "getPaywall", "()Lcom/revenuecat/purchases/paywalls/PaywallData;", "getPaywallComponents$annotations", "getPaywallComponents", "()Lcom/revenuecat/purchases/Offering$PaywallComponents;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$annotations", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getServerDescription", "sixMonth", "getSixMonth", "sixMonth$delegate", "threeMonth", "getThreeMonth", "threeMonth$delegate", "twoMonth", "getTwoMonth", "twoMonth$delegate", "getWebCheckoutURL", "()Ljava/net/URL;", "weekly", "getWeekly", "weekly$delegate", "copy", "findPackage", "packageType", "Lcom/revenuecat/purchases/PackageType;", "get", CmcdData.STREAMING_FORMAT_SS, "getMetadataString", SubscriberAttributeKt.JSON_NAME_KEY, "default", "getPackage", "PaywallComponents", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Offering {

    /* JADX INFO: renamed from: annual$delegate, reason: from kotlin metadata */
    private final Lazy annual;
    private final List<Package> availablePackages;
    private boolean hasPaywallComponents;
    private final String identifier;

    /* JADX INFO: renamed from: lifetime$delegate, reason: from kotlin metadata */
    private final Lazy lifetime;
    private final Map<String, Object> metadata;

    /* JADX INFO: renamed from: monthly$delegate, reason: from kotlin metadata */
    private final Lazy monthly;
    private final PaywallData paywall;
    private final PaywallComponents paywallComponents;
    private final String serverDescription;

    /* JADX INFO: renamed from: sixMonth$delegate, reason: from kotlin metadata */
    private final Lazy sixMonth;

    /* JADX INFO: renamed from: threeMonth$delegate, reason: from kotlin metadata */
    private final Lazy threeMonth;

    /* JADX INFO: renamed from: twoMonth$delegate, reason: from kotlin metadata */
    private final Lazy twoMonth;
    private final URL webCheckoutURL;

    /* JADX INFO: renamed from: weekly$delegate, reason: from kotlin metadata */
    private final Lazy weekly;

    public static /* synthetic */ void getPaywall$annotations() {
    }

    public static /* synthetic */ void getPaywallComponents$annotations() {
    }

    public static /* synthetic */ void getPresentedOfferingContext$annotations() {
    }

    public static /* synthetic */ void hasPaywall$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) obj;
        return Intrinsics.areEqual(this.identifier, offering.identifier) && Intrinsics.areEqual(this.serverDescription, offering.serverDescription) && Intrinsics.areEqual(this.metadata, offering.metadata) && Intrinsics.areEqual(this.availablePackages, offering.availablePackages) && Intrinsics.areEqual(this.paywall, offering.paywall) && Intrinsics.areEqual(this.paywallComponents, offering.paywallComponents) && Intrinsics.areEqual(this.webCheckoutURL, offering.webCheckoutURL);
    }

    public int hashCode() {
        int iHashCode = ((((((this.identifier.hashCode() * 31) + this.serverDescription.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.availablePackages.hashCode()) * 31;
        PaywallData paywallData = this.paywall;
        int iHashCode2 = (iHashCode + (paywallData == null ? 0 : paywallData.hashCode())) * 31;
        PaywallComponents paywallComponents = this.paywallComponents;
        int iHashCode3 = (iHashCode2 + (paywallComponents == null ? 0 : paywallComponents.hashCode())) * 31;
        URL url = this.webCheckoutURL;
        return iHashCode3 + (url != null ? url.hashCode() : 0);
    }

    public String toString() {
        return "Offering(identifier=" + this.identifier + ", serverDescription=" + this.serverDescription + ", metadata=" + this.metadata + ", availablePackages=" + this.availablePackages + ", paywall=" + this.paywall + ", paywallComponents=" + this.paywallComponents + ", webCheckoutURL=" + this.webCheckoutURL + ')';
    }

    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData, PaywallComponents paywallComponents, URL url) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        this.identifier = identifier;
        this.serverDescription = serverDescription;
        this.metadata = metadata;
        this.availablePackages = availablePackages;
        this.paywall = paywallData;
        this.paywallComponents = paywallComponents;
        this.webCheckoutURL = url;
        this.lifetime = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$lifetime$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.LIFETIME);
            }
        });
        this.annual = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$annual$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.ANNUAL);
            }
        });
        this.sixMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$sixMonth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.SIX_MONTH);
            }
        });
        this.threeMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$threeMonth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.THREE_MONTH);
            }
        });
        this.twoMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$twoMonth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.TWO_MONTH);
            }
        });
        this.monthly = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$monthly$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.MONTHLY);
            }
        });
        this.weekly = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$weekly$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.WEEKLY);
            }
        });
    }

    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, PaywallComponents paywallComponents, URL url, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, list, (i & 16) != 0 ? null : paywallData, (i & 32) != 0 ? null : paywallComponents, (i & 64) != 0 ? null : url);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final PaywallComponents getPaywallComponents() {
        return this.paywallComponents;
    }

    public final URL getWebCheckoutURL() {
        return this.webCheckoutURL;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages) {
        this(identifier, serverDescription, metadata, availablePackages, null, null, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
    }

    /* JADX INFO: renamed from: getHasPaywallComponents$purchases_defaultsRelease, reason: from getter */
    public final boolean getHasPaywallComponents() {
        return this.hasPaywallComponents;
    }

    public final void setHasPaywallComponents$purchases_defaultsRelease(boolean z) {
        this.hasPaywallComponents = z;
    }

    /* JADX INFO: compiled from: Offering.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\u0010\u000bB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/Offering$PaywallComponents;", "", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "data", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "(Lcom/revenuecat/purchases/UiConfig;Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;)V", "componentsHash", "", "dataProvider", "Lkotlin/Function0;", "(Lcom/revenuecat/purchases/UiConfig;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "dataResult", "Lkotlin/Lazy;", "Lkotlin/Result;", "(Lcom/revenuecat/purchases/UiConfig;Ljava/lang/String;Lkotlin/Lazy;)V", "getData-d1pmJ48", "()Ljava/lang/Object;", "dataOrNull", "getDataOrNull", "()Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "getUiConfig", "()Lcom/revenuecat/purchases/UiConfig;", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class PaywallComponents {
        private final String componentsHash;
        private final Lazy<Result<PaywallComponentsData>> dataResult;
        private final UiConfig uiConfig;

        private PaywallComponents(UiConfig uiConfig, String str, Lazy<Result<PaywallComponentsData>> lazy) {
            this.uiConfig = uiConfig;
            this.componentsHash = str;
            this.dataResult = lazy;
        }

        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public PaywallComponents(UiConfig uiConfig, PaywallComponentsData data) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            Intrinsics.checkNotNullParameter(data, "data");
            String strValueOf = String.valueOf(data.hashCode());
            Result.Companion companion = Result.INSTANCE;
            this(uiConfig, strValueOf, (Lazy<Result<PaywallComponentsData>>) LazyKt.lazyOf(Result.m14498boximpl(Result.m14499constructorimpl(data))));
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PaywallComponents(UiConfig uiConfig, String componentsHash, final Function0<PaywallComponentsData> dataProvider) {
            this(uiConfig, componentsHash, (Lazy<Result<PaywallComponentsData>>) LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Result<? extends PaywallComponentsData>>() { // from class: com.revenuecat.purchases.Offering.PaywallComponents.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Result<? extends PaywallComponentsData> invoke() {
                    return Result.m14498boximpl(m13642invoked1pmJ48());
                }

                /* JADX INFO: renamed from: invoke-d1pmJ48, reason: not valid java name */
                public final Object m13642invoked1pmJ48() {
                    Function0<PaywallComponentsData> function0 = dataProvider;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m14499constructorimpl(function0.invoke());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m14499constructorimpl(ResultKt.createFailure(th));
                    }
                }
            }));
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            Intrinsics.checkNotNullParameter(componentsHash, "componentsHash");
            Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        }

        /* JADX INFO: renamed from: getData-d1pmJ48, reason: not valid java name */
        public final Object m13641getDatad1pmJ48() {
            return this.dataResult.getValue().getValue();
        }

        public final PaywallComponentsData getDataOrNull() {
            Object value = this.dataResult.getValue().getValue();
            if (Result.m14505isFailureimpl(value)) {
                value = null;
            }
            return (PaywallComponentsData) value;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaywallComponents)) {
                return false;
            }
            PaywallComponents paywallComponents = (PaywallComponents) other;
            return Intrinsics.areEqual(this.uiConfig, paywallComponents.uiConfig) && Intrinsics.areEqual(this.componentsHash, paywallComponents.componentsHash);
        }

        public int hashCode() {
            return (this.uiConfig.hashCode() * 31) + this.componentsHash.hashCode();
        }

        public String toString() {
            return "PaywallComponents(uiConfig=" + this.uiConfig + ')';
        }
    }

    public final boolean hasPaywall() {
        return (this.paywall == null && this.paywallComponents == null && !this.hasPaywallComponents) ? false : true;
    }

    public final Package getLifetime() {
        return (Package) this.lifetime.getValue();
    }

    public final Package getAnnual() {
        return (Package) this.annual.getValue();
    }

    public final Package getSixMonth() {
        return (Package) this.sixMonth.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth.getValue();
    }

    public final Package getMonthly() {
        return (Package) this.monthly.getValue();
    }

    public final Package getWeekly() {
        return (Package) this.weekly.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Package findPackage(PackageType packageType) {
        Object next;
        Iterator<T> it = this.availablePackages.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Package) next).getIdentifier(), packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) next;
    }

    public final Package get(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return getPackage(s);
    }

    public final Package getPackage(String identifier) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        for (Package r1 : this.availablePackages) {
            if (Intrinsics.areEqual(r1.getIdentifier(), identifier)) {
                return r1;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final String getMetadataString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Object obj = this.metadata.get(key);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? str : str2;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        Package r0 = (Package) CollectionsKt.firstOrNull((List) this.availablePackages);
        if (r0 != null) {
            return r0.getPresentedOfferingContext();
        }
        return null;
    }

    public final Offering copy(PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        String str = this.identifier;
        String str2 = this.serverDescription;
        Map<String, Object> map = this.metadata;
        List<Package> list = this.availablePackages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).copy$purchases_defaultsRelease(presentedOfferingContext));
        }
        Offering offering = new Offering(str, str2, map, arrayList, this.paywall, this.paywallComponents, this.webCheckoutURL);
        offering.hasPaywallComponents = this.hasPaywallComponents;
        return offering;
    }
}
