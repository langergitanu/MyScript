package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.JsonCredentialsResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProcessCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\u0003H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/ProcessCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "credentialProcess", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "maxOutputLengthBytes", "", "timeoutMillis", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;JJ)V", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProcessCredentialsProvider implements CredentialsProvider {
    private final String credentialProcess;
    private final long maxOutputLengthBytes;
    private final PlatformProvider platformProvider;
    private final long timeoutMillis;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ProcessCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: ProcessCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ProcessCredentialsProvider", m1609f = "ProcessCredentialsProvider.kt", m1610i = {0, 0}, m1611l = {56}, m1612m = "resolve", m1613n = {"attributes", "logger"}, m1614nl = {57}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30181(Continuation<? super C30181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProcessCredentialsProvider.this.resolve(null, this);
        }
    }

    public ProcessCredentialsProvider(String credentialProcess, PlatformProvider platformProvider, long j, long j2) {
        Intrinsics.checkNotNullParameter(credentialProcess, "credentialProcess");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.credentialProcess = credentialProcess;
        this.platformProvider = platformProvider;
        this.maxOutputLengthBytes = j;
        this.timeoutMillis = j2;
    }

    public /* synthetic */ ProcessCredentialsProvider(String str, PlatformProvider platformProvider, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 4) != 0 ? 65536L : j, (i & 8) != 0 ? 60000L : j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        C30181 c30181;
        Logger logger;
        if (continuation instanceof C30181) {
            c30181 = (C30181) continuation;
            if ((c30181.label & Integer.MIN_VALUE) != 0) {
                c30181.label -= Integer.MIN_VALUE;
            } else {
                c30181 = new C30181(continuation);
            }
        }
        C30181 c301812 = c30181;
        Object obj = c301812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c301812.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = c301812.get$context();
                String qualifiedName = Reflection.getOrCreateKotlinClass(ProcessCredentialsProvider.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
                }
                Logger logger2 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
                String str = this.credentialProcess;
                PlatformProvider platformProvider = this.platformProvider;
                long j = this.maxOutputLengthBytes;
                long j2 = this.timeoutMillis;
                c301812.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
                c301812.L$1 = logger2;
                c301812.label = 1;
                Object objExecuteCommand$default = ExecuteCommandJVMKt.executeCommand$default(str, platformProvider, j, j2, null, c301812, 16, null);
                if (objExecuteCommand$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecuteCommand$default;
                logger = logger2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                logger = (Logger) c301812.L$1;
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            final int iIntValue = ((Number) pair.component1()).intValue();
            final String str2 = (String) pair.component2();
            if (iIntValue != 0) {
                Logger.warn$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProcessCredentialsProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProcessCredentialsProvider.resolve$lambda$0(iIntValue, str2);
                    }
                }, 1, null);
                throw new CredentialsProviderException("Command completed with nonzero exit code " + iIntValue + ": " + str2, null, 2, null);
            }
            JsonCredentialsResponse jsonCredentialsResponseDeserializeJsonProcessCredentials = JsonCredentialsDeserializerKt.deserializeJsonProcessCredentials(new JsonDeserializer(StringsKt.encodeToByteArray(str2)));
            if (jsonCredentialsResponseDeserializeJsonProcessCredentials instanceof JsonCredentialsResponse.SessionCredentials) {
                JsonCredentialsResponse.SessionCredentials sessionCredentials = (JsonCredentialsResponse.SessionCredentials) jsonCredentialsResponseDeserializeJsonProcessCredentials;
                String accessKeyId = sessionCredentials.getAccessKeyId();
                String secretAccessKey = sessionCredentials.getSecretAccessKey();
                String sessionToken = sessionCredentials.getSessionToken();
                Instant expiration = sessionCredentials.getExpiration();
                if (expiration == null) {
                    expiration = Instant.INSTANCE.getMAX_VALUE();
                }
                return AwsBusinessMetricsUtilsKt.withBusinessMetric(CredentialsExtKt.credentials(accessKeyId, secretAccessKey, sessionToken, expiration, "Process", sessionCredentials.getAccountId()), AwsBusinessMetric.Credentials.CREDENTIALS_PROCESS);
            }
            throw new CredentialsProviderException("Credentials response was not of expected format", null, 2, null);
        } catch (Exception e) {
            throw new CredentialsProviderException("Failed to execute command", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0(int i, String str) {
        return "Command completed with nonzero exit code " + i + ": " + str;
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
