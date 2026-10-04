package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.http.engine.ProxySelector;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.net.url.UserInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpProxyAuthenticator;", "Lokhttp3/Authenticator;", "selector", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/ProxySelector;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpProxyAuthenticator implements Authenticator {
    private final ProxySelector selector;

    public OkHttpProxyAuthenticator(ProxySelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.request().header("Proxy-Authorization") != null) {
            return null;
        }
        HttpUrl httpUrlUrl = response.request().url();
        Url.Companion companion = Url.INSTANCE;
        Url.Builder builder = new Url.Builder();
        builder.setScheme(new Scheme(httpUrlUrl.scheme(), httpUrlUrl.port()));
        builder.setHost(Host.INSTANCE.parse(httpUrlUrl.host()));
        builder.setPort(Integer.valueOf(httpUrlUrl.port()));
        ProxyConfig proxyConfigSelect = this.selector.select(builder.build());
        UserInfo userInfo = proxyConfigSelect instanceof ProxyConfig.Http ? ((ProxyConfig.Http) proxyConfigSelect).getUrl().getUserInfo() : null;
        if (userInfo == null) {
            return null;
        }
        for (Challenge challenge : response.challenges()) {
            String lowerCase = challenge.scheme().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "okhttp-preemptive") || Intrinsics.areEqual(challenge.scheme(), "Basic")) {
                return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic$default(userInfo.getUserName().getDecoded(), userInfo.getPassword().getDecoded(), null, 4, null)).build();
            }
        }
        return null;
    }
}
