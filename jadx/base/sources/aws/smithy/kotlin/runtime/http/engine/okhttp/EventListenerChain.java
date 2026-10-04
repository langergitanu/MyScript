package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: EventListenerChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010 \u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J2\u0010#\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u00108\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00109\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010:\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010<\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010=\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\u0018\u0010>\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010?\u001a\u000206H\u0016J\u0018\u0010@\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010A\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/EventListenerChain;", "Lokhttp3/EventListener;", "listeners", "", "<init>", "(Ljava/util/List;)V", "reverseListeners", "close", "", "callStart", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "dnsStart", "domainName", "", "dnsEnd", "inetAddressList", "Ljava/net/InetAddress;", "proxySelectStart", ImagesContract.URL, "Lokhttp3/HttpUrl;", "proxySelectEnd", "proxies", "Ljava/net/Proxy;", "connectStart", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "secureConnectStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "connectEnd", "protocol", "Lokhttp3/Protocol;", "connectFailed", "ioe", "Ljava/io/IOException;", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "requestHeadersStart", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestBodyStart", "requestBodyEnd", "byteCount", "", "requestFailed", "responseHeadersStart", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheConditionalHit", "cachedResponse", "cacheHit", "cacheMiss", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EventListenerChain extends EventListener {
    private final List<EventListener> listeners;
    private final List<EventListener> reverseListeners;

    /* JADX WARN: Multi-variable type inference failed */
    public EventListenerChain(List<? extends EventListener> listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners = listeners;
        this.reverseListeners = CollectionsKt.reversed(listeners);
    }

    public final void close() throws IOException {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            CloseableKt.closeIfCloseable((EventListener) it.next());
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).dnsStart(call, domainName);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List<? extends InetAddress> inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).dnsEnd(call, domainName, inetAddressList);
        }
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).proxySelectStart(call, url);
        }
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl url, List<? extends Proxy> proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).proxySelectEnd(call, url, proxies);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).secureConnectStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestBodyEnd(call, byteCount);
        }
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseBodyEnd(call, byteCount);
        }
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).canceled(call);
        }
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Iterator<T> it = this.reverseListeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).satisfactionFailure(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheConditionalHit(call, cachedResponse);
        }
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheHit(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheMiss(call);
        }
    }
}
