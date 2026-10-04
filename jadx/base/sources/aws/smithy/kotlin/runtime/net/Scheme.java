package aws.smithy.kotlin.runtime.net;

import androidx.webkit.ProxyConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.http.HttpVersion;

/* JADX INFO: compiled from: Scheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u000bJ\u0011\u0010\u0013\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Scheme;", "", "", "protocolName", "", "defaultPort", "<init>", "(Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "()I", "copy", "(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/net/Scheme;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getProtocolName", "I", "getDefaultPort", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Scheme {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Scheme HTTP;
    private static final Scheme HTTPS;

    /* JADX INFO: renamed from: WS */
    private static final Scheme f528WS;
    private static final Scheme WSS;
    private static final Map<String, Scheme> byName;
    private final int defaultPort;
    private final String protocolName;

    public static /* synthetic */ Scheme copy$default(Scheme scheme, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = scheme.protocolName;
        }
        if ((i2 & 2) != 0) {
            i = scheme.defaultPort;
        }
        return scheme.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProtocolName() {
        return this.protocolName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final Scheme copy(String protocolName, int defaultPort) {
        Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        return new Scheme(protocolName, defaultPort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) other;
        return Intrinsics.areEqual(this.protocolName, scheme.protocolName) && this.defaultPort == scheme.defaultPort;
    }

    public int hashCode() {
        return (this.protocolName.hashCode() * 31) + Integer.hashCode(this.defaultPort);
    }

    public String toString() {
        return "Scheme(protocolName=" + this.protocolName + ", defaultPort=" + this.defaultPort + ')';
    }

    /* JADX INFO: compiled from: Scheme.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Scheme$Companion;", "", "<init>", "()V", "", "scheme", "Laws/smithy/kotlin/runtime/net/Scheme;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/Scheme;", "HTTPS", "Laws/smithy/kotlin/runtime/net/Scheme;", "getHTTPS", "()Laws/smithy/kotlin/runtime/net/Scheme;", HttpVersion.HTTP, "getHTTP", "WS", "getWS", "WSS", "getWSS", "", "byName", "Ljava/util/Map;", "getByName", "()Ljava/util/Map;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Scheme getHTTPS() {
            return Scheme.HTTPS;
        }

        public final Scheme getHTTP() {
            return Scheme.HTTP;
        }

        public final Scheme getWS() {
            return Scheme.f528WS;
        }

        public final Scheme getWSS() {
            return Scheme.WSS;
        }

        public final Map<String, Scheme> getByName() {
            return Scheme.byName;
        }

        public final Scheme parse(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Map<String, Scheme> byName = getByName();
            String lowerCase = scheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Scheme scheme2 = byName.get(lowerCase);
            return scheme2 == null ? new Scheme(scheme, -1) : scheme2;
        }
    }

    public Scheme(String protocolName, int i) {
        Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        this.protocolName = protocolName;
        this.defaultPort = i;
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final String getProtocolName() {
        return this.protocolName;
    }

    static {
        Scheme scheme = new Scheme(ProxyConfig.MATCH_HTTPS, 443);
        HTTPS = scheme;
        Scheme scheme2 = new Scheme("http", 80);
        HTTP = scheme2;
        Scheme scheme3 = new Scheme("ws", 80);
        f528WS = scheme3;
        Scheme scheme4 = new Scheme("wss", 443);
        WSS = scheme4;
        List listListOf = CollectionsKt.listOf((Object[]) new Scheme[]{scheme2, scheme, scheme3, scheme4});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(((Scheme) obj).protocolName, obj);
        }
        byName = linkedHashMap;
    }
}
