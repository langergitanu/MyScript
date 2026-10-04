package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpProxySelector;", "Ljava/net/ProxySelector;", "sdkSelector", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/ProxySelector;)V", "select", "", "Ljava/net/Proxy;", "uri", "Ljava/net/URI;", "connectFailed", "", "sa", "Ljava/net/SocketAddress;", "ioe", "Ljava/io/IOException;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpProxySelector extends ProxySelector {
    private final aws.smithy.kotlin.runtime.http.engine.ProxySelector sdkSelector;

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    }

    public OkHttpProxySelector(aws.smithy.kotlin.runtime.http.engine.ProxySelector sdkSelector) {
        Intrinsics.checkNotNullParameter(sdkSelector, "sdkSelector");
        this.sdkSelector = sdkSelector;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri == null) {
            return CollectionsKt.emptyList();
        }
        ProxyConfig proxyConfigSelect = this.sdkSelector.select(OkHttpUtilsKt.toUrl(uri));
        if (proxyConfigSelect instanceof ProxyConfig.Http) {
            ProxyConfig.Http http = (ProxyConfig.Http) proxyConfigSelect;
            return CollectionsKt.listOf(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(http.getUrl().getHost().toString(), http.getUrl().getPort())));
        }
        return CollectionsKt.emptyList();
    }
}
