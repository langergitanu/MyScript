package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderChain;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.DefaultHttpEngineKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.io.IOException;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultChainCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u00020\u0003H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/DefaultChainCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "profileName", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", TtmlNode.TAG_REGION, "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Ljava/lang/String;)V", "getProfileName", "()Ljava/lang/String;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getRegion", "manageEngine", "", "engine", "chain", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderChain;", "provider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CachedCredentialsProvider;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultChainCredentialsProvider implements CloseableCredentialsProvider {
    private final CredentialsProviderChain chain;
    private final HttpClientEngine engine;
    private final boolean manageEngine;
    private final PlatformProvider platformProvider;
    private final String profileName;
    private final CachedCredentialsProvider provider;
    private final String region;

    public DefaultChainCredentialsProvider() {
        this(null, null, null, null, 15, null);
    }

    public DefaultChainCredentialsProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, String str2) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.profileName = str;
        this.platformProvider = platformProvider;
        this.region = str2;
        this.manageEngine = httpClientEngine == null;
        CloseableHttpClientEngine closeableHttpClientEngineDefaultHttpEngine$default = httpClientEngine == null ? DefaultHttpEngineKt.DefaultHttpEngine$default(null, 1, null) : httpClientEngine;
        this.engine = closeableHttpClientEngineDefaultHttpEngine$default;
        CredentialsProviderChain credentialsProviderChain = new CredentialsProviderChain(new SystemPropertyCredentialsProvider(new DefaultChainCredentialsProvider$chain$1(platformProvider)), new EnvironmentCredentialsProvider(new DefaultChainCredentialsProvider$chain$2(platformProvider)), new StsWebIdentityProvider(platformProvider, closeableHttpClientEngineDefaultHttpEngine$default, str2), new ProfileCredentialsProvider(str, str2, platformProvider, closeableHttpClientEngineDefaultHttpEngine$default), new EcsCredentialsProvider(platformProvider, closeableHttpClientEngineDefaultHttpEngine$default), new ImdsCredentialsProvider(null, LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultChainCredentialsProvider.chain$lambda$0(this.f$0);
            }
        }), platformProvider, null, 9, null));
        this.chain = credentialsProviderChain;
        this.provider = new CachedCredentialsProvider(credentialsProviderChain, 0L, 0L, null, 14, null);
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public /* synthetic */ DefaultChainCredentialsProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 4) != 0 ? null : httpClientEngine, (i & 8) != 0 ? null : str2);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImdsClient chain$lambda$0(final DefaultChainCredentialsProvider defaultChainCredentialsProvider) {
        return ImdsClient.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultChainCredentialsProvider.chain$lambda$0$0(this.f$0, (ImdsClient.Builder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit chain$lambda$0$0(DefaultChainCredentialsProvider defaultChainCredentialsProvider, ImdsClient.Builder ImdsClient) {
        Intrinsics.checkNotNullParameter(ImdsClient, "$this$ImdsClient");
        ImdsClient.setPlatformProvider$aws_config(defaultChainCredentialsProvider.platformProvider);
        ImdsClient.setEngine(defaultChainCredentialsProvider.engine);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        return this.provider.resolve(attributes, continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.provider.close();
        if (this.manageEngine) {
            CloseableKt.closeIfCloseable(this.engine);
        }
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this) + ": " + this.chain;
    }
}
