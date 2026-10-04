package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EnvironmentCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\u0004H\u0096\u0080\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/EnvironmentCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getEnv", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getGetEnv", "()Lkotlin/jvm/functions/Function1;", "requireEnv", "variable", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentCredentialsProvider implements CredentialsProvider {
    private final Function1<String, String> getEnv;

    /* JADX WARN: Multi-variable type inference failed */
    public EnvironmentCredentialsProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.EnvironmentCredentialsProvider$1 */
    /* JADX INFO: compiled from: EnvironmentCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C30061 extends FunctionReferenceImpl implements Function1<String, String> {
        C30061(Object obj) {
            super(1, obj, PlatformProvider.class, "getenv", "getenv(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((PlatformProvider) this.receiver).getenv(p0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnvironmentCredentialsProvider(Function1<? super String, String> getEnv) {
        Intrinsics.checkNotNullParameter(getEnv, "getEnv");
        this.getEnv = getEnv;
    }

    public /* synthetic */ EnvironmentCredentialsProvider(C30061 c30061, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C30061(PlatformProvider.INSTANCE.getSystem()) : c30061);
    }

    public final Function1<String, String> getGetEnv() {
        return this.getEnv;
    }

    private final String requireEnv(String variable) {
        String strInvoke = this.getEnv.invoke(variable);
        if (strInvoke != null) {
            if (StringsKt.isBlank(strInvoke)) {
                strInvoke = null;
            }
            if (strInvoke != null) {
                return strInvoke;
            }
        }
        throw new ProviderConfigurationException("Missing value for environment variable `" + variable + '`', null, 2, null);
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        CoroutineContext coroutineContext = continuation.get$context();
        Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EnvironmentCredentialsProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnvironmentCredentialsProvider.resolve$lambda$0();
            }
        };
        LogLevel logLevel = LogLevel.Trace;
        String qualifiedName = Reflection.getOrCreateKotlinClass(EnvironmentCredentialsProvider.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
        return AwsBusinessMetricsUtilsKt.withBusinessMetric(CredentialsExtKt.credentials$default(requireEnv(EnvironmentCredentialsProviderKt.ACCESS_KEY_ID), requireEnv(EnvironmentCredentialsProviderKt.SECRET_ACCESS_KEY), this.getEnv.invoke(EnvironmentCredentialsProviderKt.SESSION_TOKEN), null, "Environment", this.getEnv.invoke(EnvironmentCredentialsProviderKt.ACCOUNT_ID), 8, null), AwsBusinessMetric.Credentials.CREDENTIALS_ENV_VARS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0() {
        return "Attempting to load credentials from env vars " + EnvironmentCredentialsProviderKt.ACCESS_KEY_ID + JsonPointer.SEPARATOR + EnvironmentCredentialsProviderKt.SECRET_ACCESS_KEY + JsonPointer.SEPARATOR + EnvironmentCredentialsProviderKt.SESSION_TOKEN;
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
