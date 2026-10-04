package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultChainCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StsWebIdentityProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", TtmlNode.TAG_REGION, "", "<init>", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Ljava/lang/String;)V", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getRegion", "()Ljava/lang/String;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsWebIdentityProvider implements CloseableCredentialsProvider {
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final String region;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityProvider$resolve$1 */
    /* JADX INFO: compiled from: DefaultChainCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityProvider", m1609f = "DefaultChainCredentialsProvider.kt", m1610i = {0, 0}, m1611l = {97}, m1612m = "resolve", m1613n = {"attributes", "wrapped"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30331(Continuation<? super C30331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StsWebIdentityProvider.this.resolve(null, this);
        }
    }

    public StsWebIdentityProvider() {
        this(null, null, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public StsWebIdentityProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine, String str) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.platformProvider = platformProvider;
        this.httpClient = httpClientEngine;
        this.region = str;
    }

    public /* synthetic */ StsWebIdentityProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 2) != 0 ? null : httpClientEngine, (i & 4) != 0 ? null : str);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public final String getRegion() {
        return this.region;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Throwable {
        C30331 c30331;
        if (continuation instanceof C30331) {
            c30331 = (C30331) continuation;
            if ((c30331.label & Integer.MIN_VALUE) != 0) {
                c30331.label -= Integer.MIN_VALUE;
            } else {
                c30331 = new C30331(continuation);
            }
        }
        Object objResolve = c30331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolve);
            StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProviderM12043fromEnvironmentTUYock$default = StsWebIdentityCredentialsProvider.Companion.m12043fromEnvironmentTUYock$default(StsWebIdentityCredentialsProvider.INSTANCE, null, null, this.region, null, 0L, this.platformProvider, this.httpClient, 27, null);
            c30331.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30331.L$1 = SpillingKt.nullOutSpilledVariable(stsWebIdentityCredentialsProviderM12043fromEnvironmentTUYock$default);
            c30331.label = 1;
            objResolve = stsWebIdentityCredentialsProviderM12043fromEnvironmentTUYock$default.resolve(attributes, c30331);
            if (objResolve == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolve);
        }
        return AwsBusinessMetricsUtilsKt.withBusinessMetric((Credentials) objResolve, AwsBusinessMetric.Credentials.CREDENTIALS_ENV_VARS_STS_WEB_ID_TOKEN);
    }
}
