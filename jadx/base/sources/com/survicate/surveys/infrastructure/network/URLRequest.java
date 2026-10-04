package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: URLRequest.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/URLRequest;", "", ImagesContract.URL, "Ljava/net/URI;", FirebaseAnalytics.Param.METHOD, "", TtmlNode.TAG_BODY, "<init>", "(Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/net/URI;", "getMethod", "()Ljava/lang/String;", "getBody", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class URLRequest {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private final String body;
    private final String method;
    private final URI url;

    public static /* synthetic */ URLRequest copy$default(URLRequest uRLRequest, URI uri, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = uRLRequest.url;
        }
        if ((i & 2) != 0) {
            str = uRLRequest.method;
        }
        if ((i & 4) != 0) {
            str2 = uRLRequest.body;
        }
        return uRLRequest.copy(uri, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final URI getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final URLRequest copy(URI url, String method, String body) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        return new URLRequest(url, method, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof URLRequest)) {
            return false;
        }
        URLRequest uRLRequest = (URLRequest) other;
        return Intrinsics.areEqual(this.url, uRLRequest.url) && Intrinsics.areEqual(this.method, uRLRequest.method) && Intrinsics.areEqual(this.body, uRLRequest.body);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        String str = this.body;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "URLRequest(url=" + this.url + ", method=" + this.method + ", body=" + this.body + ')';
    }

    public URLRequest(URI url, String method, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        this.url = url;
        this.method = method;
        this.body = str;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getBody() {
        return this.body;
    }
}
