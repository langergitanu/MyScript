package aws.smithy.kotlin.runtime.client.endpoints;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.ValuesMap;
import aws.smithy.kotlin.runtime.net.url.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Endpoint.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fJ\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J/\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "", "uri", "Laws/smithy/kotlin/runtime/net/url/Url;", "headers", "Laws/smithy/kotlin/runtime/collections/ValuesMap;", "", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Laws/smithy/kotlin/runtime/net/url/Url;Laws/smithy/kotlin/runtime/collections/ValuesMap;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "(Ljava/lang/String;)V", "(Laws/smithy/kotlin/runtime/net/url/Url;Laws/smithy/kotlin/runtime/collections/ValuesMap;)V", "getUri", "()Laws/smithy/kotlin/runtime/net/url/Url;", "getHeaders", "()Laws/smithy/kotlin/runtime/collections/ValuesMap;", "getAttributes$annotations", "()V", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Endpoint {
    private final Attributes attributes;
    private final ValuesMap<String> headers;
    private final Url uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Endpoint copy$default(Endpoint endpoint, Url url, ValuesMap valuesMap, Attributes attributes, int i, Object obj) {
        if ((i & 1) != 0) {
            url = endpoint.uri;
        }
        if ((i & 2) != 0) {
            valuesMap = endpoint.headers;
        }
        if ((i & 4) != 0) {
            attributes = endpoint.attributes;
        }
        return endpoint.copy(url, valuesMap, attributes);
    }

    @InternalApi
    public static /* synthetic */ void getAttributes$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Url getUri() {
        return this.uri;
    }

    public final ValuesMap<String> component2() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final Endpoint copy(Url uri, ValuesMap<String> headers, Attributes attributes) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new Endpoint(uri, headers, attributes);
    }

    public String toString() {
        return "Endpoint(uri=" + this.uri + ", headers=" + this.headers + ", attributes=" + this.attributes + ')';
    }

    @InternalApi
    public Endpoint(Url uri, ValuesMap<String> valuesMap, Attributes attributes) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.uri = uri;
        this.headers = valuesMap;
        this.attributes = attributes;
    }

    public final Url getUri() {
        return this.uri;
    }

    public final ValuesMap<String> getHeaders() {
        return this.headers;
    }

    public /* synthetic */ Endpoint(Url url, ValuesMap valuesMap, Attributes attributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, (i & 2) != 0 ? null : valuesMap, (i & 4) != 0 ? AttributesKt.emptyAttributes() : attributes);
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Endpoint(String uri) {
        this(Url.Companion.parse$default(Url.INSTANCE, uri, null, 2, null), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public /* synthetic */ Endpoint(Url url, ValuesMap valuesMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, (i & 2) != 0 ? null : valuesMap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Endpoint(Url uri, ValuesMap<String> valuesMap) {
        this(uri, valuesMap, AttributesKt.emptyAttributes());
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public boolean equals(Object other) {
        if (!(other instanceof Endpoint)) {
            return false;
        }
        Endpoint endpoint = (Endpoint) other;
        return Intrinsics.areEqual(this.uri, endpoint.uri) && Intrinsics.areEqual(this.headers, endpoint.headers) && Intrinsics.areEqual(this.attributes, endpoint.attributes);
    }

    public int hashCode() {
        int iHashCode = this.uri.hashCode() * 31;
        ValuesMap<String> valuesMap = this.headers;
        return ((iHashCode + (valuesMap != null ? valuesMap.hashCode() : 0)) * 31) + this.attributes.hashCode();
    }
}
