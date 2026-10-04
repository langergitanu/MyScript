package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Canonicalizer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/CanonicalRequest;", "", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "requestString", "", "signedHeaders", "hash", "<init>", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequest", "()Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "getRequestString", "()Ljava/lang/String;", "getSignedHeaders", "getHash", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class CanonicalRequest {
    private final String hash;
    private final HttpRequestBuilder request;
    private final String requestString;
    private final String signedHeaders;

    public static /* synthetic */ CanonicalRequest copy$default(CanonicalRequest canonicalRequest, HttpRequestBuilder httpRequestBuilder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = canonicalRequest.request;
        }
        if ((i & 2) != 0) {
            str = canonicalRequest.requestString;
        }
        if ((i & 4) != 0) {
            str2 = canonicalRequest.signedHeaders;
        }
        if ((i & 8) != 0) {
            str3 = canonicalRequest.hash;
        }
        return canonicalRequest.copy(httpRequestBuilder, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HttpRequestBuilder getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRequestString() {
        return this.requestString;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSignedHeaders() {
        return this.signedHeaders;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    public final CanonicalRequest copy(HttpRequestBuilder request, String requestString, String signedHeaders, String hash) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestString, "requestString");
        Intrinsics.checkNotNullParameter(signedHeaders, "signedHeaders");
        Intrinsics.checkNotNullParameter(hash, "hash");
        return new CanonicalRequest(request, requestString, signedHeaders, hash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CanonicalRequest)) {
            return false;
        }
        CanonicalRequest canonicalRequest = (CanonicalRequest) other;
        return Intrinsics.areEqual(this.request, canonicalRequest.request) && Intrinsics.areEqual(this.requestString, canonicalRequest.requestString) && Intrinsics.areEqual(this.signedHeaders, canonicalRequest.signedHeaders) && Intrinsics.areEqual(this.hash, canonicalRequest.hash);
    }

    public int hashCode() {
        return (((((this.request.hashCode() * 31) + this.requestString.hashCode()) * 31) + this.signedHeaders.hashCode()) * 31) + this.hash.hashCode();
    }

    public String toString() {
        return "CanonicalRequest(request=" + this.request + ", requestString=" + this.requestString + ", signedHeaders=" + this.signedHeaders + ", hash=" + this.hash + ')';
    }

    public CanonicalRequest(HttpRequestBuilder request, String requestString, String signedHeaders, String hash) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestString, "requestString");
        Intrinsics.checkNotNullParameter(signedHeaders, "signedHeaders");
        Intrinsics.checkNotNullParameter(hash, "hash");
        this.request = request;
        this.requestString = requestString;
        this.signedHeaders = signedHeaders;
        this.hash = hash;
    }

    public final HttpRequestBuilder getRequest() {
        return this.request;
    }

    public final String getRequestString() {
        return this.requestString;
    }

    public final String getSignedHeaders() {
        return this.signedHeaders;
    }

    public final String getHash() {
        return this.hash;
    }
}
