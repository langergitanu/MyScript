package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DefaultAwsSignerJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/DefaultAwsSignerImpl;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "canonicalizer", "Laws/smithy/kotlin/runtime/auth/awssigning/Canonicalizer;", "requestMutator", "Laws/smithy/kotlin/runtime/auth/awssigning/RequestMutator;", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awssigning/Canonicalizer;Laws/smithy/kotlin/runtime/auth/awssigning/RequestMutator;Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "sign", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningResult;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signChunk", "", "chunkBody", "", "prevSignature", "([B[BLaws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signChunkTrailer", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/Headers;", "(Laws/smithy/kotlin/runtime/http/Headers;[BLaws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultAwsSignerImpl implements AwsSigner {
    private final Canonicalizer canonicalizer;
    private final RequestMutator requestMutator;
    private final TelemetryProvider telemetryProvider;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$sign$1 */
    /* JADX INFO: compiled from: DefaultAwsSignerJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl", m1609f = "DefaultAwsSignerJVM.kt", m1610i = {0, 0, 0}, m1611l = {46}, m1612m = "sign", m1613n = {"request", "config", "logger"}, m1614nl = {47}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36451(Continuation<? super C36451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultAwsSignerImpl.this.sign(null, null, this);
        }
    }

    public DefaultAwsSignerImpl() {
        this(null, null, null, 7, null);
    }

    public DefaultAwsSignerImpl(Canonicalizer canonicalizer, RequestMutator requestMutator, TelemetryProvider telemetryProvider) {
        Intrinsics.checkNotNullParameter(canonicalizer, "canonicalizer");
        Intrinsics.checkNotNullParameter(requestMutator, "requestMutator");
        this.canonicalizer = canonicalizer;
        this.requestMutator = requestMutator;
        this.telemetryProvider = telemetryProvider;
    }

    public /* synthetic */ DefaultAwsSignerImpl(DefaultCanonicalizer defaultCanonicalizer, DefaultRequestMutator defaultRequestMutator, TelemetryProvider telemetryProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Canonicalizer.INSTANCE.getDefault() : defaultCanonicalizer, (i & 2) != 0 ? RequestMutator.INSTANCE.getDefault() : defaultRequestMutator, (i & 4) != 0 ? null : telemetryProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sign(HttpRequest httpRequest, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<HttpRequest>> continuation) {
        C36451 c36451;
        Logger logger;
        Logger logger2;
        LoggerProvider loggerProvider;
        if (continuation instanceof C36451) {
            c36451 = (C36451) continuation;
            if ((c36451.label & Integer.MIN_VALUE) != 0) {
                c36451.label -= Integer.MIN_VALUE;
            } else {
                c36451 = new C36451(continuation);
            }
        }
        Object obj = c36451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36451.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TelemetryProvider telemetryProvider = this.telemetryProvider;
            if (telemetryProvider == null || (loggerProvider = telemetryProvider.getLoggerProvider()) == null || (logger = loggerProvider.getOrCreateLogger("DefaultAwsSigner")) == null) {
                CoroutineContext context = c36451.getContext();
                String qualifiedName = Reflection.getOrCreateKotlinClass(DefaultAwsSignerImpl.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
                }
                logger = CoroutineContextLogExtKt.logger(context, qualifiedName);
            }
            Canonicalizer canonicalizer = this.canonicalizer;
            c36451.L$0 = SpillingKt.nullOutSpilledVariable(httpRequest);
            c36451.L$1 = awsSigningConfig;
            c36451.L$2 = logger;
            c36451.label = 1;
            Object objCanonicalRequest = canonicalizer.canonicalRequest(httpRequest, awsSigningConfig, c36451);
            if (objCanonicalRequest == coroutine_suspended) {
                return coroutine_suspended;
            }
            Logger logger3 = logger;
            obj = objCanonicalRequest;
            logger2 = logger3;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            logger2 = (Logger) c36451.L$2;
            awsSigningConfig = (AwsSigningConfig) c36451.L$1;
            ResultKt.throwOnFailure(obj);
        }
        final CanonicalRequest canonicalRequest = (CanonicalRequest) obj;
        if (awsSigningConfig.getLogRequest()) {
            Logger.trace$default(logger2, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DefaultAwsSignerImpl.sign$lambda$0(canonicalRequest);
                }
            }, 1, null);
        }
        BaseSigV4SignatureCalculator signatureCalculator = DefaultAwsSignerJVMKt.getSignatureCalculator(awsSigningConfig.getAlgorithm());
        final String strStringToSign = signatureCalculator.stringToSign(canonicalRequest.getRequestString(), awsSigningConfig);
        Logger.trace$default(logger2, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.sign$lambda$1(strStringToSign);
            }
        }, 1, null);
        final String strCalculate = signatureCalculator.calculate(signatureCalculator.signingKey(awsSigningConfig), strStringToSign);
        Logger.debug$default(logger2, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.sign$lambda$2(strCalculate);
            }
        }, 1, null);
        return new AwsSigningResult(this.requestMutator.appendAuth(awsSigningConfig, canonicalRequest, strCalculate), StringsKt.encodeToByteArray(strCalculate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sign$lambda$0(CanonicalRequest canonicalRequest) {
        return "Canonical request:\n" + canonicalRequest.getRequestString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sign$lambda$1(String str) {
        return "String to sign:\n" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sign$lambda$2(String str) {
        return "Calculated signature: " + str;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner
    public Object signChunk(byte[] bArr, byte[] bArr2, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<Unit>> continuation) {
        Logger logger;
        LoggerProvider loggerProvider;
        TelemetryProvider telemetryProvider = this.telemetryProvider;
        if (telemetryProvider == null || (loggerProvider = telemetryProvider.getLoggerProvider()) == null || (logger = loggerProvider.getOrCreateLogger("DefaultAwsSigner")) == null) {
            CoroutineContext context = continuation.getContext();
            String qualifiedName = Reflection.getOrCreateKotlinClass(DefaultAwsSignerImpl.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            logger = CoroutineContextLogExtKt.logger(context, qualifiedName);
        }
        BaseSigV4SignatureCalculator signatureCalculator = DefaultAwsSignerJVMKt.getSignatureCalculator(awsSigningConfig.getAlgorithm());
        final String strChunkStringToSign = signatureCalculator.chunkStringToSign(bArr, bArr2, awsSigningConfig);
        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.signChunk$lambda$0(strChunkStringToSign);
            }
        }, 1, null);
        final String strCalculate = signatureCalculator.calculate(signatureCalculator.signingKey(awsSigningConfig), strChunkStringToSign);
        Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.signChunk$lambda$1(strCalculate);
            }
        }, 1, null);
        return new AwsSigningResult(Unit.INSTANCE, StringsKt.encodeToByteArray(strCalculate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String signChunk$lambda$0(String str) {
        return "Chunk string to sign:\n" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String signChunk$lambda$1(String str) {
        return "Calculated chunk signature: " + str;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner
    public Object signChunkTrailer(Headers headers, byte[] bArr, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<Unit>> continuation) {
        Logger logger;
        LoggerProvider loggerProvider;
        TelemetryProvider telemetryProvider = this.telemetryProvider;
        if (telemetryProvider == null || (loggerProvider = telemetryProvider.getLoggerProvider()) == null || (logger = loggerProvider.getOrCreateLogger("DefaultAwsSigner")) == null) {
            CoroutineContext context = continuation.getContext();
            String qualifiedName = Reflection.getOrCreateKotlinClass(DefaultAwsSignerImpl.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            logger = CoroutineContextLogExtKt.logger(context, qualifiedName);
        }
        BaseSigV4SignatureCalculator signatureCalculator = DefaultAwsSignerJVMKt.getSignatureCalculator(awsSigningConfig.getAlgorithm());
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(headers.entries(), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$signChunkTrailer$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String lowerCase = ((String) ((Map.Entry) t).getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((String) ((Map.Entry) t2).getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (Map.Entry entry : listSortedWith) {
            StringBuilder sb = new StringBuilder();
            String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            sb.append(lowerCase);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(CollectionsKt.joinToString$default((Iterable) entry.getValue(), ",", null, null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefaultAwsSignerImpl.signChunkTrailer$lambda$1$0$0((String) obj);
                }
            }, 30, null));
            sb.append("\n");
            arrayList.add(StringsKt.encodeToByteArray(sb.toString()));
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = ArraysKt.plus((byte[]) next, (byte[]) it.next());
        }
        final String strChunkTrailerStringToSign = signatureCalculator.chunkTrailerStringToSign((byte[]) next, bArr, awsSigningConfig);
        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.signChunkTrailer$lambda$3(strChunkTrailerStringToSign);
            }
        }, 1, null);
        final String strCalculate = signatureCalculator.calculate(signatureCalculator.signingKey(awsSigningConfig), strChunkTrailerStringToSign);
        Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultAwsSignerImpl.signChunkTrailer$lambda$4(strCalculate);
            }
        }, 1, null);
        return new AwsSigningResult(Unit.INSTANCE, StringsKt.encodeToByteArray(strCalculate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence signChunkTrailer$lambda$1$0$0(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return StringsKt.trim((CharSequence) v).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String signChunkTrailer$lambda$3(String str) {
        return "Chunk trailer string to sign:\n" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String signChunkTrailer$lambda$4(String str) {
        return "Calculated chunk signature: " + str;
    }
}
