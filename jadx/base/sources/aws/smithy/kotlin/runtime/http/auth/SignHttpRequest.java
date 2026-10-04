package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.identity.Identity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: HttpSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "", "httpRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", HTTP.IDENTITY_CODING, "Laws/smithy/kotlin/runtime/identity/Identity;", "signingAttributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Laws/smithy/kotlin/runtime/identity/Identity;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "getHttpRequest", "()Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "getIdentity", "()Laws/smithy/kotlin/runtime/identity/Identity;", "getSigningAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "http-auth-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SignHttpRequest {
    private final HttpRequestBuilder httpRequest;
    private final Identity identity;
    private final Attributes signingAttributes;

    public static /* synthetic */ SignHttpRequest copy$default(SignHttpRequest signHttpRequest, HttpRequestBuilder httpRequestBuilder, Identity identity, Attributes attributes, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = signHttpRequest.httpRequest;
        }
        if ((i & 2) != 0) {
            identity = signHttpRequest.identity;
        }
        if ((i & 4) != 0) {
            attributes = signHttpRequest.signingAttributes;
        }
        return signHttpRequest.copy(httpRequestBuilder, identity, attributes);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HttpRequestBuilder getHttpRequest() {
        return this.httpRequest;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Identity getIdentity() {
        return this.identity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Attributes getSigningAttributes() {
        return this.signingAttributes;
    }

    public final SignHttpRequest copy(HttpRequestBuilder httpRequest, Identity identity, Attributes signingAttributes) {
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(signingAttributes, "signingAttributes");
        return new SignHttpRequest(httpRequest, identity, signingAttributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignHttpRequest)) {
            return false;
        }
        SignHttpRequest signHttpRequest = (SignHttpRequest) other;
        return Intrinsics.areEqual(this.httpRequest, signHttpRequest.httpRequest) && Intrinsics.areEqual(this.identity, signHttpRequest.identity) && Intrinsics.areEqual(this.signingAttributes, signHttpRequest.signingAttributes);
    }

    public int hashCode() {
        return (((this.httpRequest.hashCode() * 31) + this.identity.hashCode()) * 31) + this.signingAttributes.hashCode();
    }

    public String toString() {
        return "SignHttpRequest(httpRequest=" + this.httpRequest + ", identity=" + this.identity + ", signingAttributes=" + this.signingAttributes + ')';
    }

    public SignHttpRequest(HttpRequestBuilder httpRequest, Identity identity, Attributes signingAttributes) {
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(signingAttributes, "signingAttributes");
        this.httpRequest = httpRequest;
        this.identity = identity;
        this.signingAttributes = signingAttributes;
    }

    public final HttpRequestBuilder getHttpRequest() {
        return this.httpRequest;
    }

    public final Identity getIdentity() {
        return this.identity;
    }

    public final Attributes getSigningAttributes() {
        return this.signingAttributes;
    }
}
