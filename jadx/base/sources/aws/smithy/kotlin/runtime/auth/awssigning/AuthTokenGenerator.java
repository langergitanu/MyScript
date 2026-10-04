package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.time.Clock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;

/* JADX INFO: compiled from: AuthTokenGenerator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AuthTokenGenerator;", "", NotificationCompat.CATEGORY_SERVICE, "", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/time/Clock;)V", "getService", "()Ljava/lang/String;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getSigner", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "getClock", "()Laws/smithy/kotlin/runtime/time/Clock;", "trimScheme", "Laws/smithy/kotlin/runtime/net/url/Url;", "generateAuthToken", "endpoint", TtmlNode.TAG_REGION, "expiration", "Lkotlin/time/Duration;", "generateAuthToken-exY8QGI", "(Laws/smithy/kotlin/runtime/net/url/Url;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AuthTokenGenerator {
    private final Clock clock;
    private final CredentialsProvider credentialsProvider;
    private final String service;
    private final AwsSigner signer;

    public AuthTokenGenerator(String service, CredentialsProvider credentialsProvider, AwsSigner signer, Clock clock) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(credentialsProvider, "credentialsProvider");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.service = service;
        this.credentialsProvider = credentialsProvider;
        this.signer = signer;
        this.clock = clock;
    }

    public final String getService() {
        return this.service;
    }

    public final CredentialsProvider getCredentialsProvider() {
        return this.credentialsProvider;
    }

    public final AwsSigner getSigner() {
        return this.signer;
    }

    public /* synthetic */ AuthTokenGenerator(String str, CredentialsProvider credentialsProvider, AwsSigner awsSigner, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, credentialsProvider, awsSigner, (i & 8) != 0 ? Clock.System.INSTANCE : system);
    }

    public final Clock getClock() {
        return this.clock;
    }

    private final String trimScheme(Url url) {
        return StringsKt.removePrefix(StringsKt.removePrefix(url.getEncoded(), (CharSequence) url.getScheme().getProtocolName()), (CharSequence) "://");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX INFO: renamed from: generateAuthToken-exY8QGI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12132generateAuthTokenexY8QGI(final Url url, String str, long j, Continuation<? super String> continuation) {
        AuthTokenGenerator$generateAuthToken$1 authTokenGenerator$generateAuthToken$1;
        HttpRequest httpRequestHttpRequest$default;
        AwsSigningConfig.Builder builder;
        String str2;
        long j2;
        Url url2;
        AwsSigningConfig.Builder builder2;
        AwsSigningConfig.Builder builder3;
        AuthTokenGenerator authTokenGenerator;
        if (continuation instanceof AuthTokenGenerator$generateAuthToken$1) {
            authTokenGenerator$generateAuthToken$1 = (AuthTokenGenerator$generateAuthToken$1) continuation;
            if ((authTokenGenerator$generateAuthToken$1.label & Integer.MIN_VALUE) != 0) {
                authTokenGenerator$generateAuthToken$1.label -= Integer.MIN_VALUE;
            } else {
                authTokenGenerator$generateAuthToken$1 = new AuthTokenGenerator$generateAuthToken$1(this, continuation);
            }
        }
        Object objResolve$default = authTokenGenerator$generateAuthToken$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = authTokenGenerator$generateAuthToken$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolve$default);
            httpRequestHttpRequest$default = HttpRequestKt.HttpRequest$default(HttpMethod.GET, url, Headers.INSTANCE.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.AuthTokenGenerator$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthTokenGenerator.generateAuthToken_exY8QGI$lambda$0(url, (HeadersBuilder) obj);
                }
            }), null, null, 24, null);
            AwsSigningConfig.Companion companion = AwsSigningConfig.INSTANCE;
            builder = new AwsSigningConfig.Builder();
            CredentialsProvider credentialsProvider = this.credentialsProvider;
            authTokenGenerator$generateAuthToken$1.L$0 = SpillingKt.nullOutSpilledVariable(url);
            authTokenGenerator$generateAuthToken$1.L$1 = str;
            authTokenGenerator$generateAuthToken$1.L$2 = httpRequestHttpRequest$default;
            authTokenGenerator$generateAuthToken$1.L$3 = SpillingKt.nullOutSpilledVariable(companion);
            authTokenGenerator$generateAuthToken$1.L$4 = builder;
            authTokenGenerator$generateAuthToken$1.L$5 = builder;
            authTokenGenerator$generateAuthToken$1.L$6 = builder;
            authTokenGenerator$generateAuthToken$1.J$0 = j;
            authTokenGenerator$generateAuthToken$1.I$0 = 0;
            authTokenGenerator$generateAuthToken$1.I$1 = 0;
            authTokenGenerator$generateAuthToken$1.label = 1;
            objResolve$default = IdentityProvider.resolve$default(credentialsProvider, null, authTokenGenerator$generateAuthToken$1, 1, null);
            if (objResolve$default != coroutine_suspended) {
                str2 = str;
                j2 = j;
                url2 = url;
                builder2 = builder;
                builder3 = builder2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = authTokenGenerator$generateAuthToken$1.J$0;
            authTokenGenerator = (AuthTokenGenerator) authTokenGenerator$generateAuthToken$1.L$4;
            ResultKt.throwOnFailure(objResolve$default);
            return authTokenGenerator.trimScheme(((HttpRequest) ((AwsSigningResult) objResolve$default).getOutput()).getUrl());
        }
        int i2 = authTokenGenerator$generateAuthToken$1.I$1;
        int i3 = authTokenGenerator$generateAuthToken$1.I$0;
        j2 = authTokenGenerator$generateAuthToken$1.J$0;
        builder = (AwsSigningConfig.Builder) authTokenGenerator$generateAuthToken$1.L$6;
        builder2 = (AwsSigningConfig.Builder) authTokenGenerator$generateAuthToken$1.L$5;
        builder3 = (AwsSigningConfig.Builder) authTokenGenerator$generateAuthToken$1.L$4;
        httpRequestHttpRequest$default = (HttpRequest) authTokenGenerator$generateAuthToken$1.L$2;
        str2 = (String) authTokenGenerator$generateAuthToken$1.L$1;
        url2 = (Url) authTokenGenerator$generateAuthToken$1.L$0;
        ResultKt.throwOnFailure(objResolve$default);
        builder.setCredentials((Credentials) objResolve$default);
        builder2.setRegion(str2);
        builder2.setService(this.service);
        builder2.setSigningDate(this.clock.getNow());
        builder2.m12135setExpiresAfterBwNAW2A(Duration.m15854boximpl(j2));
        builder2.setSignatureType(AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS);
        AwsSigningConfig awsSigningConfigBuild = builder3.build();
        AwsSigner awsSigner = this.signer;
        authTokenGenerator$generateAuthToken$1.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        authTokenGenerator$generateAuthToken$1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        authTokenGenerator$generateAuthToken$1.L$2 = SpillingKt.nullOutSpilledVariable(httpRequestHttpRequest$default);
        authTokenGenerator$generateAuthToken$1.L$3 = SpillingKt.nullOutSpilledVariable(awsSigningConfigBuild);
        authTokenGenerator$generateAuthToken$1.L$4 = this;
        authTokenGenerator$generateAuthToken$1.L$5 = null;
        authTokenGenerator$generateAuthToken$1.L$6 = null;
        authTokenGenerator$generateAuthToken$1.J$0 = j2;
        authTokenGenerator$generateAuthToken$1.label = 2;
        objResolve$default = awsSigner.sign(httpRequestHttpRequest$default, awsSigningConfigBuild, authTokenGenerator$generateAuthToken$1);
        if (objResolve$default != coroutine_suspended) {
            authTokenGenerator = this;
            return authTokenGenerator.trimScheme(((HttpRequest) ((AwsSigningResult) objResolve$default).getOutput()).getUrl());
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateAuthToken_exY8QGI$lambda$0(Url url, HeadersBuilder Headers) {
        Intrinsics.checkNotNullParameter(Headers, "$this$Headers");
        Headers.append("Host", url.getHostAndPort());
        return Unit.INSTANCE;
    }
}
