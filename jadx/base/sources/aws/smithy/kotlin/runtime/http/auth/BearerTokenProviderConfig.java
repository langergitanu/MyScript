package aws.smithy.kotlin.runtime.http.auth;

import kotlin.Metadata;

/* JADX INFO: compiled from: BearerTokenProviderConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/BearerTokenProviderConfig;", "", "bearerTokenProvider", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "getBearerTokenProvider", "()Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "Builder", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface BearerTokenProviderConfig {

    /* JADX INFO: compiled from: BearerTokenProviderConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/BearerTokenProviderConfig$Builder;", "", "bearerTokenProvider", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "getBearerTokenProvider", "()Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "setBearerTokenProvider", "(Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;)V", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        BearerTokenProvider getBearerTokenProvider();

        void setBearerTokenProvider(BearerTokenProvider bearerTokenProvider);
    }

    BearerTokenProvider getBearerTokenProvider();
}
