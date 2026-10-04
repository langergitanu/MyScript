package aws.sdk.kotlin.services.p010s3.endpoints;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointParameters;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: S3EndpointParameters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u000278B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010/\u001a\u000200H\u0096\u0080\u0004J\n\u00101\u001a\u00020\fH\u0096\u0080\u0004J!\u00102\u001a\u00020\u00002\u0019\b\u0002\u00103\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020504¢\u0006\u0002\b6R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\tR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\tR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0015\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\"\u0010\tR\u0015\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b$\u0010\tR\u0015\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b&\u0010\tR\u0015\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b(\u0010\tR\u0015\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b*\u0010\tR\u0015\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b,\u0010\t¨\u00069"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "", "builder", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;)V", "accelerate", "", "getAccelerate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "bucket", "", "getBucket", "()Ljava/lang/String;", "copySource", "getCopySource", "disableAccessPoints", "getDisableAccessPoints", "disableMultiRegionAccessPoints", "getDisableMultiRegionAccessPoints", "disableS3ExpressSessionAuth", "getDisableS3ExpressSessionAuth", "endpoint", "getEndpoint", "forcePathStyle", "getForcePathStyle", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "prefix", "getPrefix", TtmlNode.TAG_REGION, "getRegion", "useArnRegion", "getUseArnRegion", "useDualStack", "getUseDualStack", "useFips", "getUseFips", "useGlobalEndpoint", "getUseGlobalEndpoint", "useObjectLambdaEndpoint", "getUseObjectLambdaEndpoint", "useS3ExpressControlEndpoint", "getUseS3ExpressControlEndpoint", "equals", "other", "hashCode", "", "toString", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3EndpointParameters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean accelerate;
    private final String bucket;
    private final String copySource;
    private final Boolean disableAccessPoints;
    private final Boolean disableMultiRegionAccessPoints;
    private final Boolean disableS3ExpressSessionAuth;
    private final String endpoint;
    private final Boolean forcePathStyle;
    private final String key;
    private final String prefix;
    private final String region;
    private final Boolean useArnRegion;
    private final Boolean useDualStack;
    private final Boolean useFips;
    private final Boolean useGlobalEndpoint;
    private final Boolean useObjectLambdaEndpoint;
    private final Boolean useS3ExpressControlEndpoint;

    public /* synthetic */ S3EndpointParameters(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private S3EndpointParameters(Builder builder) {
        Boolean accelerate = builder.getAccelerate();
        if (accelerate == null) {
            throw new IllegalArgumentException("endpoint provider parameter #accelerate is required".toString());
        }
        this.accelerate = accelerate;
        this.bucket = builder.getBucket();
        this.copySource = builder.getCopySource();
        this.disableAccessPoints = builder.getDisableAccessPoints();
        Boolean disableMultiRegionAccessPoints = builder.getDisableMultiRegionAccessPoints();
        if (disableMultiRegionAccessPoints == null) {
            throw new IllegalArgumentException("endpoint provider parameter #disableMultiRegionAccessPoints is required".toString());
        }
        this.disableMultiRegionAccessPoints = disableMultiRegionAccessPoints;
        this.disableS3ExpressSessionAuth = builder.getDisableS3ExpressSessionAuth();
        this.endpoint = builder.getEndpoint();
        Boolean forcePathStyle = builder.getForcePathStyle();
        if (forcePathStyle == null) {
            throw new IllegalArgumentException("endpoint provider parameter #forcePathStyle is required".toString());
        }
        this.forcePathStyle = forcePathStyle;
        this.key = builder.getKey();
        this.prefix = builder.getPrefix();
        this.region = builder.getRegion();
        this.useArnRegion = builder.getUseArnRegion();
        Boolean useDualStack = builder.getUseDualStack();
        if (useDualStack == null) {
            throw new IllegalArgumentException("endpoint provider parameter #useDualStack is required".toString());
        }
        this.useDualStack = useDualStack;
        Boolean useFips = builder.getUseFips();
        if (useFips == null) {
            throw new IllegalArgumentException("endpoint provider parameter #useFips is required".toString());
        }
        this.useFips = useFips;
        Boolean useGlobalEndpoint = builder.getUseGlobalEndpoint();
        if (useGlobalEndpoint == null) {
            throw new IllegalArgumentException("endpoint provider parameter #useGlobalEndpoint is required".toString());
        }
        this.useGlobalEndpoint = useGlobalEndpoint;
        this.useObjectLambdaEndpoint = builder.getUseObjectLambdaEndpoint();
        this.useS3ExpressControlEndpoint = builder.getUseS3ExpressControlEndpoint();
    }

    public final Boolean getAccelerate() {
        return this.accelerate;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getCopySource() {
        return this.copySource;
    }

    public final Boolean getDisableAccessPoints() {
        return this.disableAccessPoints;
    }

    public final Boolean getDisableMultiRegionAccessPoints() {
        return this.disableMultiRegionAccessPoints;
    }

    public final Boolean getDisableS3ExpressSessionAuth() {
        return this.disableS3ExpressSessionAuth;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final Boolean getForcePathStyle() {
        return this.forcePathStyle;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getRegion() {
        return this.region;
    }

    public final Boolean getUseArnRegion() {
        return this.useArnRegion;
    }

    public final Boolean getUseDualStack() {
        return this.useDualStack;
    }

    public final Boolean getUseFips() {
        return this.useFips;
    }

    public final Boolean getUseGlobalEndpoint() {
        return this.useGlobalEndpoint;
    }

    public final Boolean getUseObjectLambdaEndpoint() {
        return this.useObjectLambdaEndpoint;
    }

    public final Boolean getUseS3ExpressControlEndpoint() {
        return this.useS3ExpressControlEndpoint;
    }

    /* JADX INFO: compiled from: S3EndpointParameters.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final S3EndpointParameters invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3EndpointParameters)) {
            return false;
        }
        S3EndpointParameters s3EndpointParameters = (S3EndpointParameters) other;
        return Intrinsics.areEqual(this.accelerate, s3EndpointParameters.accelerate) && Intrinsics.areEqual(this.bucket, s3EndpointParameters.bucket) && Intrinsics.areEqual(this.copySource, s3EndpointParameters.copySource) && Intrinsics.areEqual(this.disableAccessPoints, s3EndpointParameters.disableAccessPoints) && Intrinsics.areEqual(this.disableMultiRegionAccessPoints, s3EndpointParameters.disableMultiRegionAccessPoints) && Intrinsics.areEqual(this.disableS3ExpressSessionAuth, s3EndpointParameters.disableS3ExpressSessionAuth) && Intrinsics.areEqual(this.endpoint, s3EndpointParameters.endpoint) && Intrinsics.areEqual(this.forcePathStyle, s3EndpointParameters.forcePathStyle) && Intrinsics.areEqual(this.key, s3EndpointParameters.key) && Intrinsics.areEqual(this.prefix, s3EndpointParameters.prefix) && Intrinsics.areEqual(this.region, s3EndpointParameters.region) && Intrinsics.areEqual(this.useArnRegion, s3EndpointParameters.useArnRegion) && Intrinsics.areEqual(this.useDualStack, s3EndpointParameters.useDualStack) && Intrinsics.areEqual(this.useFips, s3EndpointParameters.useFips) && Intrinsics.areEqual(this.useGlobalEndpoint, s3EndpointParameters.useGlobalEndpoint) && Intrinsics.areEqual(this.useObjectLambdaEndpoint, s3EndpointParameters.useObjectLambdaEndpoint) && Intrinsics.areEqual(this.useS3ExpressControlEndpoint, s3EndpointParameters.useS3ExpressControlEndpoint);
    }

    public int hashCode() {
        Boolean bool = this.accelerate;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        String str = this.bucket;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.copySource;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool2 = this.disableAccessPoints;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0)) * 31;
        Boolean bool3 = this.disableMultiRegionAccessPoints;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? Boolean.hashCode(bool3.booleanValue()) : 0)) * 31;
        Boolean bool4 = this.disableS3ExpressSessionAuth;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? Boolean.hashCode(bool4.booleanValue()) : 0)) * 31;
        String str3 = this.endpoint;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool5 = this.forcePathStyle;
        int iHashCode8 = (iHashCode7 + (bool5 != null ? Boolean.hashCode(bool5.booleanValue()) : 0)) * 31;
        String str4 = this.key;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.prefix;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.region;
        int iHashCode11 = (iHashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Boolean bool6 = this.useArnRegion;
        int iHashCode12 = (iHashCode11 + (bool6 != null ? Boolean.hashCode(bool6.booleanValue()) : 0)) * 31;
        Boolean bool7 = this.useDualStack;
        int iHashCode13 = (iHashCode12 + (bool7 != null ? Boolean.hashCode(bool7.booleanValue()) : 0)) * 31;
        Boolean bool8 = this.useFips;
        int iHashCode14 = (iHashCode13 + (bool8 != null ? Boolean.hashCode(bool8.booleanValue()) : 0)) * 31;
        Boolean bool9 = this.useGlobalEndpoint;
        int iHashCode15 = (iHashCode14 + (bool9 != null ? Boolean.hashCode(bool9.booleanValue()) : 0)) * 31;
        Boolean bool10 = this.useObjectLambdaEndpoint;
        int iHashCode16 = (iHashCode15 + (bool10 != null ? Boolean.hashCode(bool10.booleanValue()) : 0)) * 31;
        Boolean bool11 = this.useS3ExpressControlEndpoint;
        return iHashCode16 + (bool11 != null ? Boolean.hashCode(bool11.booleanValue()) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("S3EndpointParameters(");
        sb.append("accelerate=" + this.accelerate + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("copySource=" + this.copySource + AbstractJsonLexerKt.COMMA);
        sb.append("disableAccessPoints=" + this.disableAccessPoints + AbstractJsonLexerKt.COMMA);
        sb.append("disableMultiRegionAccessPoints=" + this.disableMultiRegionAccessPoints + AbstractJsonLexerKt.COMMA);
        sb.append("disableS3ExpressSessionAuth=" + this.disableS3ExpressSessionAuth + AbstractJsonLexerKt.COMMA);
        sb.append("endpoint=" + this.endpoint + AbstractJsonLexerKt.COMMA);
        sb.append("forcePathStyle=" + this.forcePathStyle + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("region=" + this.region + AbstractJsonLexerKt.COMMA);
        sb.append("useArnRegion=" + this.useArnRegion + AbstractJsonLexerKt.COMMA);
        sb.append("useDualStack=" + this.useDualStack + AbstractJsonLexerKt.COMMA);
        sb.append("useFips=" + this.useFips + AbstractJsonLexerKt.COMMA);
        sb.append("useGlobalEndpoint=" + this.useGlobalEndpoint + AbstractJsonLexerKt.COMMA);
        sb.append("useObjectLambdaEndpoint=" + this.useObjectLambdaEndpoint + AbstractJsonLexerKt.COMMA);
        sb.append("useS3ExpressControlEndpoint=" + this.useS3ExpressControlEndpoint + ')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ S3EndpointParameters copy$default(S3EndpointParameters s3EndpointParameters, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: aws.sdk.kotlin.services.s3.endpoints.S3EndpointParameters$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return S3EndpointParameters.copy$lambda$0((S3EndpointParameters.Builder) obj2);
                }
            };
        }
        return s3EndpointParameters.copy(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copy$lambda$0(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }

    public final S3EndpointParameters copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder();
        builder.setAccelerate(this.accelerate);
        builder.setBucket(this.bucket);
        builder.setCopySource(this.copySource);
        builder.setDisableAccessPoints(this.disableAccessPoints);
        builder.setDisableMultiRegionAccessPoints(this.disableMultiRegionAccessPoints);
        builder.setDisableS3ExpressSessionAuth(this.disableS3ExpressSessionAuth);
        builder.setEndpoint(this.endpoint);
        builder.setForcePathStyle(this.forcePathStyle);
        builder.setKey(this.key);
        builder.setPrefix(this.prefix);
        builder.setRegion(this.region);
        builder.setUseArnRegion(this.useArnRegion);
        builder.setUseDualStack(this.useDualStack);
        builder.setUseFips(this.useFips);
        builder.setUseGlobalEndpoint(this.useGlobalEndpoint);
        builder.setUseObjectLambdaEndpoint(this.useObjectLambdaEndpoint);
        builder.setUseS3ExpressControlEndpoint(this.useS3ExpressControlEndpoint);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: S3EndpointParameters.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010>\u001a\u00020?R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001e\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001c\u0010&\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001c\u0010)\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001e\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001e\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u001e\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR\u001e\u00105\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR\u001e\u00108\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\u001e\u0010;\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\t¨\u0006@"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;", "", "<init>", "()V", "accelerate", "", "getAccelerate", "()Ljava/lang/Boolean;", "setAccelerate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "copySource", "getCopySource", "setCopySource", "disableAccessPoints", "getDisableAccessPoints", "setDisableAccessPoints", "disableMultiRegionAccessPoints", "getDisableMultiRegionAccessPoints", "setDisableMultiRegionAccessPoints", "disableS3ExpressSessionAuth", "getDisableS3ExpressSessionAuth", "setDisableS3ExpressSessionAuth", "endpoint", "getEndpoint", "setEndpoint", "forcePathStyle", "getForcePathStyle", "setForcePathStyle", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "prefix", "getPrefix", "setPrefix", TtmlNode.TAG_REGION, "getRegion", "setRegion", "useArnRegion", "getUseArnRegion", "setUseArnRegion", "useDualStack", "getUseDualStack", "setUseDualStack", "useFips", "getUseFips", "setUseFips", "useGlobalEndpoint", "getUseGlobalEndpoint", "setUseGlobalEndpoint", "useObjectLambdaEndpoint", "getUseObjectLambdaEndpoint", "setUseObjectLambdaEndpoint", "useS3ExpressControlEndpoint", "getUseS3ExpressControlEndpoint", "setUseS3ExpressControlEndpoint", "build", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String copySource;
        private Boolean disableAccessPoints;
        private Boolean disableS3ExpressSessionAuth;
        private String endpoint;
        private String key;
        private String prefix;
        private String region;
        private Boolean useArnRegion;
        private Boolean useObjectLambdaEndpoint;
        private Boolean useS3ExpressControlEndpoint;
        private Boolean accelerate = false;
        private Boolean disableMultiRegionAccessPoints = false;
        private Boolean forcePathStyle = false;
        private Boolean useDualStack = false;
        private Boolean useFips = false;
        private Boolean useGlobalEndpoint = false;

        public final Boolean getAccelerate() {
            return this.accelerate;
        }

        public final void setAccelerate(Boolean bool) {
            this.accelerate = bool;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final String getCopySource() {
            return this.copySource;
        }

        public final void setCopySource(String str) {
            this.copySource = str;
        }

        public final Boolean getDisableAccessPoints() {
            return this.disableAccessPoints;
        }

        public final void setDisableAccessPoints(Boolean bool) {
            this.disableAccessPoints = bool;
        }

        public final Boolean getDisableMultiRegionAccessPoints() {
            return this.disableMultiRegionAccessPoints;
        }

        public final void setDisableMultiRegionAccessPoints(Boolean bool) {
            this.disableMultiRegionAccessPoints = bool;
        }

        public final Boolean getDisableS3ExpressSessionAuth() {
            return this.disableS3ExpressSessionAuth;
        }

        public final void setDisableS3ExpressSessionAuth(Boolean bool) {
            this.disableS3ExpressSessionAuth = bool;
        }

        public final String getEndpoint() {
            return this.endpoint;
        }

        public final void setEndpoint(String str) {
            this.endpoint = str;
        }

        public final Boolean getForcePathStyle() {
            return this.forcePathStyle;
        }

        public final void setForcePathStyle(Boolean bool) {
            this.forcePathStyle = bool;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final String getRegion() {
            return this.region;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public final Boolean getUseArnRegion() {
            return this.useArnRegion;
        }

        public final void setUseArnRegion(Boolean bool) {
            this.useArnRegion = bool;
        }

        public final Boolean getUseDualStack() {
            return this.useDualStack;
        }

        public final void setUseDualStack(Boolean bool) {
            this.useDualStack = bool;
        }

        public final Boolean getUseFips() {
            return this.useFips;
        }

        public final void setUseFips(Boolean bool) {
            this.useFips = bool;
        }

        public final Boolean getUseGlobalEndpoint() {
            return this.useGlobalEndpoint;
        }

        public final void setUseGlobalEndpoint(Boolean bool) {
            this.useGlobalEndpoint = bool;
        }

        public final Boolean getUseObjectLambdaEndpoint() {
            return this.useObjectLambdaEndpoint;
        }

        public final void setUseObjectLambdaEndpoint(Boolean bool) {
            this.useObjectLambdaEndpoint = bool;
        }

        public final Boolean getUseS3ExpressControlEndpoint() {
            return this.useS3ExpressControlEndpoint;
        }

        public final void setUseS3ExpressControlEndpoint(Boolean bool) {
            this.useS3ExpressControlEndpoint = bool;
        }

        public final S3EndpointParameters build() {
            return new S3EndpointParameters(this, null);
        }
    }
}
