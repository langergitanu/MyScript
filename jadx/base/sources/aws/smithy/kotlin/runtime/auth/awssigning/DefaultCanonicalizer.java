package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.media3.extractor.p007ts.PsExtractor;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.hashing.Sha256;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.net.url.QueryParameters;
import aws.smithy.kotlin.runtime.p011io.HashingSink;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.p011io.internal.SdkDispatchers;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Canonicalizer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0017H\u0002R\u0018\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/DefaultCanonicalizer;", "Laws/smithy/kotlin/runtime/auth/awssigning/Canonicalizer;", "sha256Supplier", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "canonicalRequest", "Laws/smithy/kotlin/runtime/auth/awssigning/CanonicalRequest;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateHash", "", "Laws/smithy/kotlin/runtime/http/HttpBody;", "(Laws/smithy/kotlin/runtime/http/HttpBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SigningManager.POST_PARAMS_ALGORITHM, "", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultCanonicalizer implements Canonicalizer {
    private final Function0<HashFunction> sha256Supplier;

    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwsSignatureType.values().length];
            try {
                iArr[AwsSignatureType.HTTP_REQUEST_VIA_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$calculateHash$1 */
    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer", m1609f = "Canonicalizer.kt", m1610i = {0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA1_7_3, 177}, m1612m = "calculateHash", m1613n = {"$this$calculateHash", "reader", "$this$calculateHash", FirebaseAnalytics.Param.SOURCE}, m1614nl = {175, PDFACompliance.e_PDFA1_8_2}, m1615s = {"L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C36471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C36471(Continuation<? super C36471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultCanonicalizer.this.calculateHash(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$canonicalRequest$1 */
    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer", m1609f = "Canonicalizer.kt", m1610i = {0, 0, 0}, m1611l = {90}, m1612m = "canonicalRequest", m1613n = {"request", "config", "hashSpec"}, m1614nl = {PDFACompliance.e_PDFA9_1}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36491(Continuation<? super C36491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultCanonicalizer.this.canonicalRequest(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$sha256$1 */
    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer", m1609f = "Canonicalizer.kt", m1610i = {0, 0, 0}, m1611l = {191}, m1612m = SigningManager.POST_PARAMS_ALGORITHM, m1613n = {"$this$sha256", "hash", "sink"}, m1614nl = {PsExtractor.AUDIO_STREAM}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36501(Continuation<? super C36501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultCanonicalizer.this.sha256(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultCanonicalizer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$1 */
    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C36461 extends FunctionReferenceImpl implements Function0<Sha256> {
        public static final C36461 INSTANCE = new C36461();

        C36461() {
            super(0, Sha256.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Sha256 invoke() {
            return new Sha256();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultCanonicalizer(Function0<? extends HashFunction> sha256Supplier) {
        Intrinsics.checkNotNullParameter(sha256Supplier, "sha256Supplier");
        this.sha256Supplier = sha256Supplier;
    }

    public /* synthetic */ DefaultCanonicalizer(C36461 c36461, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C36461.INSTANCE : c36461);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bd A[LOOP:0: B:42:0x01b7->B:44:0x01bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // aws.smithy.kotlin.runtime.auth.awssigning.Canonicalizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object canonicalRequest(HttpRequest httpRequest, AwsSigningConfig awsSigningConfig, Continuation<? super CanonicalRequest> continuation) {
        C36491 c36491;
        String hash;
        HttpRequest httpRequest2;
        final AwsSigningConfig awsSigningConfig2;
        AwsSigningConfig awsSigningConfig3;
        Iterator it;
        if (continuation instanceof C36491) {
            c36491 = (C36491) continuation;
            if ((c36491.label & Integer.MIN_VALUE) != 0) {
                c36491.label -= Integer.MIN_VALUE;
            } else {
                c36491 = new C36491(continuation);
            }
        }
        Object objCalculateHash = c36491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCalculateHash);
            HashSpecification hashSpecification = awsSigningConfig.getHashSpecification();
            if (!(hashSpecification instanceof HashSpecification.CalculateFromPayload)) {
                if (!(hashSpecification instanceof HashSpecification.HashLiteral)) {
                    throw new NoWhenBranchMatchedException();
                }
                hash = ((HashSpecification.HashLiteral) hashSpecification).getHash();
                httpRequest2 = httpRequest;
                awsSigningConfig2 = awsSigningConfig;
                boolean z = awsSigningConfig2.getSignatureType() != AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS;
                boolean z2 = z && awsSigningConfig2.getSignedBodyHeader() == AwsSignedBodyHeader.X_AMZ_CONTENT_SHA256;
                String sessionToken = awsSigningConfig2.getCredentials().getSessionToken();
                HttpRequestBuilder builder = HttpRequestKt.toBuilder(httpRequest2);
                canonicalRequest$param(awsSigningConfig2, builder, "Host", builder.getUrl().getHostAndPort(), !z, false);
                boolean z3 = z;
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Algorithm", awsSigningConfig2.getAlgorithm().getSigningName(), z3, false, 32, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Credential", RequestMutatorKt.credentialValue(awsSigningConfig2), z3, false, 32, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Content-Sha256", hash, z2, false, 32, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Date", awsSigningConfig2.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED), false, false, 48, null);
                Duration expiresAfter = awsSigningConfig2.getExpiresAfter();
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Expires", expiresAfter == null ? String.valueOf(Duration.m15870getInWholeSecondsimpl(expiresAfter.getRawValue())) : null, z3, false, 32, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Security-Token", sessionToken, !awsSigningConfig2.getOmitSessionToken(), false, 32, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Region-Set", awsSigningConfig2.getRegion(), awsSigningConfig2.getAlgorithm() != AwsSigningAlgorithm.SIGV4_ASYMMETRIC, false, 32, null);
                Sequence sequenceSortedWith = SequencesKt.sortedWith(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(builder.getHeaders().entries()), new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultCanonicalizer.canonicalRequest$lambda$0(awsSigningConfig2, (Map.Entry) obj));
                    }
                }), new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultCanonicalizer.canonicalRequest$lambda$1((Map.Entry) obj);
                    }
                }), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$canonicalRequest$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
                    }
                });
                String strJoinToString$default = SequencesKt.joinToString$default(sequenceSortedWith, Literals.COMMENT_2, null, null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultCanonicalizer.canonicalRequest$lambda$3((Pair) obj);
                    }
                }, 30, null);
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-SignedHeaders", strJoinToString$default, z3, false, 32, null);
                StringBuilder sb = new StringBuilder();
                sb.append(builder.getMethod().name()).append('\n');
                sb.append(CanonicalizerKt.canonicalPath(builder.getUrl(), awsSigningConfig2)).append('\n');
                sb.append(CanonicalizerKt.canonicalQueryParams(builder.getUrl())).append('\n');
                it = SequencesKt.map(sequenceSortedWith, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultCanonicalizer.canonicalRequest$lambda$4$0((Pair) obj);
                    }
                }).iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next()).append('\n');
                }
                sb.append('\n');
                sb.append(strJoinToString$default).append('\n');
                sb.append(hash);
                String string = sb.toString();
                canonicalRequest$param$default(awsSigningConfig2, builder, "X-Amz-Security-Token", sessionToken, awsSigningConfig2.getOmitSessionToken(), false, 32, null);
                return new CanonicalRequest(builder, string, strJoinToString$default, hash);
            }
            HttpBody body = httpRequest.getBody();
            c36491.L$0 = httpRequest;
            c36491.L$1 = awsSigningConfig;
            c36491.L$2 = SpillingKt.nullOutSpilledVariable(hashSpecification);
            c36491.label = 1;
            objCalculateHash = calculateHash(body, c36491);
            if (objCalculateHash == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpRequest2 = httpRequest;
            awsSigningConfig3 = awsSigningConfig;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awsSigningConfig3 = (AwsSigningConfig) c36491.L$1;
            httpRequest2 = (HttpRequest) c36491.L$0;
            ResultKt.throwOnFailure(objCalculateHash);
        }
        hash = (String) objCalculateHash;
        awsSigningConfig2 = awsSigningConfig3;
        if (awsSigningConfig2.getSignatureType() != AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS) {
        }
        if (z) {
        }
        String sessionToken2 = awsSigningConfig2.getCredentials().getSessionToken();
        HttpRequestBuilder builder2 = HttpRequestKt.toBuilder(httpRequest2);
        canonicalRequest$param(awsSigningConfig2, builder2, "Host", builder2.getUrl().getHostAndPort(), !z, false);
        boolean z32 = z;
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Algorithm", awsSigningConfig2.getAlgorithm().getSigningName(), z32, false, 32, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Credential", RequestMutatorKt.credentialValue(awsSigningConfig2), z32, false, 32, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Content-Sha256", hash, z2, false, 32, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Date", awsSigningConfig2.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED), false, false, 48, null);
        Duration expiresAfter2 = awsSigningConfig2.getExpiresAfter();
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Expires", expiresAfter2 == null ? String.valueOf(Duration.m15870getInWholeSecondsimpl(expiresAfter2.getRawValue())) : null, z32, false, 32, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Security-Token", sessionToken2, !awsSigningConfig2.getOmitSessionToken(), false, 32, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Region-Set", awsSigningConfig2.getRegion(), awsSigningConfig2.getAlgorithm() != AwsSigningAlgorithm.SIGV4_ASYMMETRIC, false, 32, null);
        Sequence sequenceSortedWith2 = SequencesKt.sortedWith(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(builder2.getHeaders().entries()), new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DefaultCanonicalizer.canonicalRequest$lambda$0(awsSigningConfig2, (Map.Entry) obj));
            }
        }), new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultCanonicalizer.canonicalRequest$lambda$1((Map.Entry) obj);
            }
        }), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$canonicalRequest$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            }
        });
        String strJoinToString$default2 = SequencesKt.joinToString$default(sequenceSortedWith2, Literals.COMMENT_2, null, null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultCanonicalizer.canonicalRequest$lambda$3((Pair) obj);
            }
        }, 30, null);
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-SignedHeaders", strJoinToString$default2, z32, false, 32, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(builder2.getMethod().name()).append('\n');
        sb2.append(CanonicalizerKt.canonicalPath(builder2.getUrl(), awsSigningConfig2)).append('\n');
        sb2.append(CanonicalizerKt.canonicalQueryParams(builder2.getUrl())).append('\n');
        it = SequencesKt.map(sequenceSortedWith2, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultCanonicalizer.canonicalRequest$lambda$4$0((Pair) obj);
            }
        }).iterator();
        while (it.hasNext()) {
        }
        sb2.append('\n');
        sb2.append(strJoinToString$default2).append('\n');
        sb2.append(hash);
        String string2 = sb2.toString();
        canonicalRequest$param$default(awsSigningConfig2, builder2, "X-Amz-Security-Token", sessionToken2, awsSigningConfig2.getOmitSessionToken(), false, 32, null);
        return new CanonicalRequest(builder2, string2, strJoinToString$default2, hash);
    }

    static /* synthetic */ void canonicalRequest$param$default(AwsSigningConfig awsSigningConfig, HttpRequestBuilder httpRequestBuilder, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        if ((i & 32) != 0) {
            z2 = true;
        }
        canonicalRequest$param(awsSigningConfig, httpRequestBuilder, str, str2, z, z2);
    }

    private static final void canonicalRequest$param(AwsSigningConfig awsSigningConfig, HttpRequestBuilder httpRequestBuilder, String str, String str2, boolean z, boolean z2) {
        if (!z || str2 == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[awsSigningConfig.getSignatureType().ordinal()];
        if (i == 1) {
            if (z2 || !httpRequestBuilder.getHeaders().contains(str)) {
                httpRequestBuilder.getHeaders().set(str, str2);
                return;
            }
            return;
        }
        if (i == 2) {
            QueryParameters.Builder parameters = httpRequestBuilder.getUrl().getParameters();
            if (z2 || !parameters.getDecodedParameters().containsKey(str)) {
                parameters.getDecodedParameters().remove(str);
                parameters.put(PercentEncoding.INSTANCE.getSigV4().encodableFromDecoded(str), PercentEncoding.INSTANCE.getSigV4().encodableFromDecoded(str2));
                return;
            }
            return;
        }
        throw new NotImplementedError("An operation is not implemented: " + ("Support for " + awsSigningConfig.getSignatureType() + " is not yet implemented"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canonicalRequest$lambda$0(AwsSigningConfig awsSigningConfig, Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CanonicalizerKt.includeHeader((String) it.getKey(), awsSigningConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair canonicalRequest$lambda$1(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = ((String) it.getKey()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return TuplesKt.m1606to(lowerCase, it.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence canonicalRequest$lambda$3(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (CharSequence) it.getFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String canonicalRequest$lambda$4$0(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CanonicalizerKt.canonicalLine(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
    
        if (r8 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateHash(HttpBody httpBody, Continuation<? super String> continuation) {
        C36471 c36471;
        if (continuation instanceof C36471) {
            c36471 = (C36471) continuation;
            if ((c36471.label & Integer.MIN_VALUE) != 0) {
                c36471.label -= Integer.MIN_VALUE;
            } else {
                c36471 = new C36471(continuation);
            }
        }
        Object objSha256 = c36471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36471.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSha256);
            if (httpBody.getIsOneShot()) {
                throw new IllegalArgumentException("Stream must be replayable to calculate a body hash".toString());
            }
            if (httpBody instanceof HttpBody.Empty) {
                return HashSpecification.EmptyBody.INSTANCE.getHash();
            }
            if (httpBody instanceof HttpBody.Bytes) {
                return HexKt.encodeToHex(HashFunctionKt.hash(((HttpBody.Bytes) httpBody).getBytes(), this.sha256Supplier));
            }
            if (httpBody instanceof HttpBody.ChannelContent) {
                SdkByteReadChannel sdkByteReadChannel = ((HttpBody.ChannelContent) httpBody).get$ch();
                c36471.L$0 = SpillingKt.nullOutSpilledVariable(httpBody);
                c36471.L$1 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
                c36471.label = 1;
                objSha256 = sha256(sdkByteReadChannel, c36471);
            } else {
                if (!(httpBody instanceof HttpBody.SourceContent)) {
                    throw new NoWhenBranchMatchedException();
                }
                SdkSource sdkSource = ((HttpBody.SourceContent) httpBody).get$this_toHttpBody();
                CoroutineDispatcher io2 = SdkDispatchers.INSTANCE.getIO();
                C36483 c36483 = new C36483(sdkSource, null);
                c36471.L$0 = SpillingKt.nullOutSpilledVariable(httpBody);
                c36471.L$1 = SpillingKt.nullOutSpilledVariable(sdkSource);
                c36471.label = 2;
                Object objWithContext = BuildersKt.withContext(io2, c36483, c36471);
                if (objWithContext != coroutine_suspended) {
                    return objWithContext;
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSha256);
            return objSha256;
        }
        ResultKt.throwOnFailure(objSha256);
        return HexKt.encodeToHex((byte[]) objSha256);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$calculateHash$3 */
    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.DefaultCanonicalizer$calculateHash$3", m1609f = "Canonicalizer.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C36483 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ SdkSource $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36483(SdkSource sdkSource, Continuation<? super C36483> continuation) {
            super(2, continuation);
            this.$source = sdkSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultCanonicalizer.this.new C36483(this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C36483) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return HexKt.encodeToHex(DefaultCanonicalizer.this.sha256(this.$source));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sha256(SdkByteReadChannel sdkByteReadChannel, Continuation<? super byte[]> continuation) {
        C36501 c36501;
        HashFunction hashFunction;
        if (continuation instanceof C36501) {
            c36501 = (C36501) continuation;
            if ((c36501.label & Integer.MIN_VALUE) != 0) {
                c36501.label -= Integer.MIN_VALUE;
            } else {
                c36501 = new C36501(continuation);
            }
        }
        Object obj = c36501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashFunction hashFunctionInvoke = this.sha256Supplier.invoke();
            HashingSink hashingSink = new HashingSink(hashFunctionInvoke, null, 2, null);
            HashingSink hashingSink2 = hashingSink;
            c36501.L$0 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
            c36501.L$1 = hashFunctionInvoke;
            c36501.L$2 = SpillingKt.nullOutSpilledVariable(hashingSink);
            c36501.label = 1;
            if (SdkByteReadChannelKt.readAll(sdkByteReadChannel, hashingSink2, c36501) == coroutine_suspended) {
                return coroutine_suspended;
            }
            hashFunction = hashFunctionInvoke;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hashFunction = (HashFunction) c36501.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return hashFunction.digest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] sha256(SdkSource sdkSource) throws IOException {
        HashFunction hashFunctionInvoke = this.sha256Supplier.invoke();
        SdkBufferedSink sdkBufferedSinkBuffer = SdkIoKt.buffer(new HashingSink(hashFunctionInvoke, null, 2, null));
        try {
            SdkSource sdkSource2 = sdkSource;
            try {
                sdkBufferedSinkBuffer.writeAll(sdkSource);
                sdkSource2.close();
                sdkBufferedSinkBuffer.close();
                return hashFunctionInvoke.digest();
            } finally {
            }
        } catch (Throwable th) {
            try {
                sdkBufferedSinkBuffer.close();
            } catch (Throwable th2) {
            }
            throw th;
        }
    }
}
