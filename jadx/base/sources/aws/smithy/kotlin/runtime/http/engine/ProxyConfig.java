package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.url.Url;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProxyConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "", "<init>", "()V", "Direct", "Http", "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig$Direct;", "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig$Http;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ProxyConfig {
    public /* synthetic */ ProxyConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProxyConfig() {
    }

    /* JADX INFO: compiled from: ProxyConfig.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/ProxyConfig$Direct;", "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "<init>", "()V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Direct extends ProxyConfig {
        public static final Direct INSTANCE = new Direct();

        private Direct() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ProxyConfig.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0006HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/ProxyConfig$Http;", "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "Laws/smithy/kotlin/runtime/net/url/Url;", ImagesContract.URL, "<init>", "(Laws/smithy/kotlin/runtime/net/url/Url;)V", "", "(Ljava/lang/String;)V", "component1", "()Laws/smithy/kotlin/runtime/net/url/Url;", "copy", "(Laws/smithy/kotlin/runtime/net/url/Url;)Laws/smithy/kotlin/runtime/http/engine/ProxyConfig$Http;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/net/url/Url;", "getUrl", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Http extends ProxyConfig {
        private final Url url;

        public static /* synthetic */ Http copy$default(Http http, Url url, int i, Object obj) {
            if ((i & 1) != 0) {
                url = http.url;
            }
            return http.copy(url);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Url getUrl() {
            return this.url;
        }

        public final Http copy(Url url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Http(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Http) && Intrinsics.areEqual(this.url, ((Http) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Http(url=" + this.url + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Http(Url url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final Url getUrl() {
            return this.url;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Http(String url) {
            this(Url.Companion.parse$default(Url.INSTANCE, url, null, 2, null));
            Intrinsics.checkNotNullParameter(url, "url");
        }
    }
}
