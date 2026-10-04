package com.revenuecat.purchases;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceServerErrorStrategy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bà\u0080\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "", "serverErrorURL", "", "getServerErrorURL", "()Ljava/lang/String;", "fakeResponseWithoutPerformingRequest", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "baseURL", "Ljava/net/URL;", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "modifyRequestURL", ImagesContract.URL, "shouldForceConnectionFailure", "", "shouldForceServerError", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface ForceServerErrorStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    default HTTPResult fakeResponseWithoutPerformingRequest(URL baseURL, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return null;
    }

    default URL modifyRequestURL(URL url, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return url;
    }

    default boolean shouldForceConnectionFailure(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return false;
    }

    boolean shouldForceServerError(URL baseURL, Endpoint endpoint);

    /* JADX INFO: compiled from: ForceServerErrorStrategy.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ForceServerErrorStrategy$Companion;", "", "()V", "doNotFail", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "getDoNotFail", "()Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "failAll", "getFailAll", "failExceptFallbackUrls", "getFailExceptFallbackUrls", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ForceServerErrorStrategy doNotFail = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.ForceServerErrorStrategy$Companion$$ExternalSyntheticLambda0
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.doNotFail$lambda$0(url, endpoint);
            }
        };
        private static final ForceServerErrorStrategy failAll = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.ForceServerErrorStrategy$Companion$$ExternalSyntheticLambda1
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.failAll$lambda$1(url, endpoint);
            }
        };
        private static final ForceServerErrorStrategy failExceptFallbackUrls = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.ForceServerErrorStrategy$Companion$$ExternalSyntheticLambda2
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.failExceptFallbackUrls$lambda$2(url, endpoint);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean doNotFail$lambda$0(URL url, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(url, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean failAll$lambda$1(URL url, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(url, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return true;
        }

        private Companion() {
        }

        public final ForceServerErrorStrategy getDoNotFail() {
            return doNotFail;
        }

        public final ForceServerErrorStrategy getFailAll() {
            return failAll;
        }

        public final ForceServerErrorStrategy getFailExceptFallbackUrls() {
            return failExceptFallbackUrls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean failExceptFallbackUrls$lambda$2(URL baseURL, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return !Intrinsics.areEqual(baseURL.toString(), AppConfig.INSTANCE.getFallbackURL().toString());
        }
    }

    /* JADX INFO: compiled from: ForceServerErrorStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getServerErrorURL(ForceServerErrorStrategy forceServerErrorStrategy) {
            return ForceServerErrorStrategy.super.getServerErrorURL();
        }

        @Deprecated
        public static URL modifyRequestURL(ForceServerErrorStrategy forceServerErrorStrategy, URL url, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            return ForceServerErrorStrategy.super.modifyRequestURL(url, endpoint);
        }

        @Deprecated
        public static boolean shouldForceConnectionFailure(ForceServerErrorStrategy forceServerErrorStrategy, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ForceServerErrorStrategy.super.shouldForceConnectionFailure(url);
        }

        @Deprecated
        public static HTTPResult fakeResponseWithoutPerformingRequest(ForceServerErrorStrategy forceServerErrorStrategy, URL baseURL, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            return ForceServerErrorStrategy.super.fakeResponseWithoutPerformingRequest(baseURL, endpoint);
        }
    }

    default String getServerErrorURL() {
        return "https://api.revenuecat.com/force-server-failure";
    }
}
