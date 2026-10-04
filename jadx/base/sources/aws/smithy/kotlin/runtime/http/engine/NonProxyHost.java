package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.url.Url;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: EnvironmentProxySelector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/NonProxyHost;", "", "", "hostMatch", "", ClientCookie.PORT_ATTR, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Laws/smithy/kotlin/runtime/net/url/Url;", ImagesContract.URL, "", "matches", "(Laws/smithy/kotlin/runtime/net/url/Url;)Z", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Laws/smithy/kotlin/runtime/http/engine/NonProxyHost;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getHostMatch", "Ljava/lang/Integer;", "getPort", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NonProxyHost {
    private final String hostMatch;
    private final Integer port;

    public static /* synthetic */ NonProxyHost copy$default(NonProxyHost nonProxyHost, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nonProxyHost.hostMatch;
        }
        if ((i & 2) != 0) {
            num = nonProxyHost.port;
        }
        return nonProxyHost.copy(str, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHostMatch() {
        return this.hostMatch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPort() {
        return this.port;
    }

    public final NonProxyHost copy(String hostMatch, Integer port) {
        Intrinsics.checkNotNullParameter(hostMatch, "hostMatch");
        return new NonProxyHost(hostMatch, port);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NonProxyHost)) {
            return false;
        }
        NonProxyHost nonProxyHost = (NonProxyHost) other;
        return Intrinsics.areEqual(this.hostMatch, nonProxyHost.hostMatch) && Intrinsics.areEqual(this.port, nonProxyHost.port);
    }

    public int hashCode() {
        int iHashCode = this.hostMatch.hashCode() * 31;
        Integer num = this.port;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "NonProxyHost(hostMatch=" + this.hostMatch + ", port=" + this.port + ')';
    }

    public NonProxyHost(String hostMatch, Integer num) {
        Intrinsics.checkNotNullParameter(hostMatch, "hostMatch");
        this.hostMatch = hostMatch;
        this.port = num;
    }

    public /* synthetic */ NonProxyHost(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num);
    }

    public final String getHostMatch() {
        return this.hostMatch;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final boolean matches(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(this.hostMatch, "*")) {
            return true;
        }
        if (this.port != null) {
            int port = url.getPort();
            Integer num = this.port;
            if (num == null || port != num.intValue()) {
                return false;
            }
        }
        String string = url.getHost().toString();
        if (StringsKt.endsWith$default(this.hostMatch, "*", false, 2, (Object) null)) {
            return StringsKt.startsWith$default(string, StringsKt.removeSuffix(this.hostMatch, (CharSequence) "*"), false, 2, (Object) null);
        }
        if (StringsKt.startsWith$default(this.hostMatch, "*", false, 2, (Object) null)) {
            return StringsKt.endsWith$default(string, StringsKt.removePrefix(this.hostMatch, (CharSequence) "*"), false, 2, (Object) null);
        }
        if (this.hostMatch.length() > string.length()) {
            return false;
        }
        boolean zEndsWith$default = StringsKt.endsWith$default(string, this.hostMatch, false, 2, (Object) null);
        int length = (string.length() - this.hostMatch.length()) - 1;
        return zEndsWith$default && (length < 0 || string.charAt(length) == '.');
    }
}
