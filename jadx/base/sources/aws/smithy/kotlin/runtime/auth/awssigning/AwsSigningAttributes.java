package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.time.Instant;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: AwsSigningAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\bR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020$0\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020$0\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\b¨\u0006,"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAttributes;", "", "<init>", "()V", "Signer", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "getSigner", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "SigningRegion", "", "getSigningRegion", "SigningRegionSet", "", "getSigningRegionSet", "ConfigSigningRegionSet", "getConfigSigningRegionSet", "SigningService", "getSigningService", "SigningDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getSigningDate", "CredentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "HashSpecification", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "getHashSpecification", "SignedBodyHeader", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "getSignedBodyHeader", "RequestSignature", "Lkotlinx/coroutines/CompletableDeferred;", "", "getRequestSignature", "UseDoubleUriEncode", "", "getUseDoubleUriEncode", "NormalizeUriPath", "getNormalizeUriPath", "EnableAwsChunked", "getEnableAwsChunked", "OmitSessionToken", "getOmitSessionToken", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSigningAttributes {
    public static final AwsSigningAttributes INSTANCE = new AwsSigningAttributes();
    private static final AttributeKey<AwsSigner> Signer = new AttributeKey<>("aws.smithy.kotlin.signing#Signer");
    private static final AttributeKey<String> SigningRegion = new AttributeKey<>("aws.smithy.kotlin.signing#AwsSigningRegion");
    private static final AttributeKey<Set<String>> SigningRegionSet = new AttributeKey<>("aws.smithy.kotlin.signing#AwsSigningRegionSet");
    private static final AttributeKey<Set<String>> ConfigSigningRegionSet = new AttributeKey<>("aws.smithy.kotlin.signing#ConfigSigningRegionSet");
    private static final AttributeKey<String> SigningService = new AttributeKey<>("aws.smithy.kotlin.signing#AwsSigningService");
    private static final AttributeKey<Instant> SigningDate = new AttributeKey<>("aws.smithy.kotlin.signing#SigningDate");
    private static final AttributeKey<CredentialsProvider> CredentialsProvider = new AttributeKey<>("aws.smithy.kotlin.signing#CredentialsProvider");
    private static final AttributeKey<HashSpecification> HashSpecification = new AttributeKey<>("aws.smithy.kotlin.signing#HashSpecification");
    private static final AttributeKey<AwsSignedBodyHeader> SignedBodyHeader = new AttributeKey<>("aws.smithy.kotlin.signing#SignedBodyHeader");
    private static final AttributeKey<CompletableDeferred<byte[]>> RequestSignature = new AttributeKey<>("aws.smithy.kotlin.signing#RequestSignature");
    private static final AttributeKey<Boolean> UseDoubleUriEncode = new AttributeKey<>("aws.smithy.kotlin.signing#UseDoubleUriEncode");
    private static final AttributeKey<Boolean> NormalizeUriPath = new AttributeKey<>("aws.smithy.kotlin.signing#NormalizeUriPath");
    private static final AttributeKey<Boolean> EnableAwsChunked = new AttributeKey<>("aws.smithy.kotlin.signing#EnableAwsChunked");
    private static final AttributeKey<Boolean> OmitSessionToken = new AttributeKey<>("aws.smithy.kotlin.signing#OmitSessionToken");

    private AwsSigningAttributes() {
    }

    public final AttributeKey<AwsSigner> getSigner() {
        return Signer;
    }

    public final AttributeKey<String> getSigningRegion() {
        return SigningRegion;
    }

    public final AttributeKey<Set<String>> getSigningRegionSet() {
        return SigningRegionSet;
    }

    public final AttributeKey<Set<String>> getConfigSigningRegionSet() {
        return ConfigSigningRegionSet;
    }

    public final AttributeKey<String> getSigningService() {
        return SigningService;
    }

    public final AttributeKey<Instant> getSigningDate() {
        return SigningDate;
    }

    public final AttributeKey<CredentialsProvider> getCredentialsProvider() {
        return CredentialsProvider;
    }

    public final AttributeKey<HashSpecification> getHashSpecification() {
        return HashSpecification;
    }

    public final AttributeKey<AwsSignedBodyHeader> getSignedBodyHeader() {
        return SignedBodyHeader;
    }

    public final AttributeKey<CompletableDeferred<byte[]>> getRequestSignature() {
        return RequestSignature;
    }

    public final AttributeKey<Boolean> getUseDoubleUriEncode() {
        return UseDoubleUriEncode;
    }

    public final AttributeKey<Boolean> getNormalizeUriPath() {
        return NormalizeUriPath;
    }

    public final AttributeKey<Boolean> getEnableAwsChunked() {
        return EnableAwsChunked;
    }

    public final AttributeKey<Boolean> getOmitSessionToken() {
        return OmitSessionToken;
    }
}
