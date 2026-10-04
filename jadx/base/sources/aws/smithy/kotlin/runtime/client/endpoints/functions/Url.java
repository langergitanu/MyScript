package aws.smithy.kotlin.runtime.client.endpoints.functions;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/endpoints/functions/Url;", "", "scheme", "", "authority", ClientCookie.PATH_ATTR, "normalizedPath", "isIp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getScheme", "()Ljava/lang/String;", "getAuthority", "getPath", "getNormalizedPath", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Url {
    private final String authority;
    private final boolean isIp;
    private final String normalizedPath;
    private final String path;
    private final String scheme;

    public static /* synthetic */ Url copy$default(Url url, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = url.scheme;
        }
        if ((i & 2) != 0) {
            str2 = url.authority;
        }
        if ((i & 4) != 0) {
            str3 = url.path;
        }
        if ((i & 8) != 0) {
            str4 = url.normalizedPath;
        }
        if ((i & 16) != 0) {
            z = url.isIp;
        }
        boolean z2 = z;
        String str5 = str3;
        return url.copy(str, str2, str5, str4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthority() {
        return this.authority;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNormalizedPath() {
        return this.normalizedPath;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsIp() {
        return this.isIp;
    }

    public final Url copy(String scheme, String authority, String path, String normalizedPath, boolean isIp) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(normalizedPath, "normalizedPath");
        return new Url(scheme, authority, path, normalizedPath, isIp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Url)) {
            return false;
        }
        Url url = (Url) other;
        return Intrinsics.areEqual(this.scheme, url.scheme) && Intrinsics.areEqual(this.authority, url.authority) && Intrinsics.areEqual(this.path, url.path) && Intrinsics.areEqual(this.normalizedPath, url.normalizedPath) && this.isIp == url.isIp;
    }

    public int hashCode() {
        return (((((((this.scheme.hashCode() * 31) + this.authority.hashCode()) * 31) + this.path.hashCode()) * 31) + this.normalizedPath.hashCode()) * 31) + Boolean.hashCode(this.isIp);
    }

    public String toString() {
        return "Url(scheme=" + this.scheme + ", authority=" + this.authority + ", path=" + this.path + ", normalizedPath=" + this.normalizedPath + ", isIp=" + this.isIp + ')';
    }

    public Url(String scheme, String authority, String path, String normalizedPath, boolean z) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(normalizedPath, "normalizedPath");
        this.scheme = scheme;
        this.authority = authority;
        this.path = path;
        this.normalizedPath = normalizedPath;
        this.isIp = z;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getAuthority() {
        return this.authority;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getNormalizedPath() {
        return this.normalizedPath;
    }

    public final boolean isIp() {
        return this.isIp;
    }
}
