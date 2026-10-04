package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.http.auth.BearerTokenProviderChain;
import aws.smithy.kotlin.runtime.http.auth.CloseableBearerTokenProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultChainBearerTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/DefaultChainBearerTokenProvider;", "Laws/smithy/kotlin/runtime/http/auth/CloseableBearerTokenProvider;", "profileName", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getProfileName", "()Ljava/lang/String;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "chain", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProviderChain;", "resolve", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultChainBearerTokenProvider implements CloseableBearerTokenProvider {
    private final BearerTokenProviderChain chain;
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final String profileName;

    public DefaultChainBearerTokenProvider() {
        this(null, null, null, 7, null);
    }

    public DefaultChainBearerTokenProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.profileName = str;
        this.platformProvider = platformProvider;
        this.httpClient = httpClientEngine;
        this.chain = new BearerTokenProviderChain(new ProfileBearerTokenProvider(str, platformProvider, httpClientEngine, null, 8, null));
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public /* synthetic */ DefaultChainBearerTokenProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 4) != 0 ? null : httpClientEngine);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        return this.chain.resolve(attributes, continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.chain.close();
    }
}
