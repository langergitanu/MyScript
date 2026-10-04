package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironmentProxySelector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/EnvironmentProxySelector;", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "provider", "<init>", "(Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)V", "Laws/smithy/kotlin/runtime/net/url/Url;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "select", "(Laws/smithy/kotlin/runtime/net/url/Url;)Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "", "nonProxy", "(Laws/smithy/kotlin/runtime/net/url/Url;)Z", "httpProxy$delegate", "Lkotlin/Lazy;", "getHttpProxy", "()Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "httpProxy", "httpsProxy$delegate", "getHttpsProxy", "httpsProxy", "", "Laws/smithy/kotlin/runtime/http/engine/NonProxyHost;", "nonProxyHosts$delegate", "getNonProxyHosts", "()Ljava/util/Set;", "nonProxyHosts", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentProxySelector implements ProxySelector {

    /* JADX INFO: renamed from: httpProxy$delegate, reason: from kotlin metadata */
    private final Lazy httpProxy;

    /* JADX INFO: renamed from: httpsProxy$delegate, reason: from kotlin metadata */
    private final Lazy httpsProxy;

    /* JADX INFO: renamed from: nonProxyHosts$delegate, reason: from kotlin metadata */
    private final Lazy nonProxyHosts;

    /* JADX WARN: Multi-variable type inference failed */
    public EnvironmentProxySelector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EnvironmentProxySelector(final PlatformEnvironProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.httpProxy = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnvironmentProxySelector.httpProxy_delegate$lambda$0(provider);
            }
        });
        this.httpsProxy = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnvironmentProxySelector.httpsProxy_delegate$lambda$0(provider);
            }
        });
        this.nonProxyHosts = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnvironmentProxySelectorKt.access$resolveNonProxyHosts(provider);
            }
        });
    }

    public /* synthetic */ EnvironmentProxySelector(PlatformProvider platformProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider);
    }

    private final ProxyConfig getHttpProxy() {
        return (ProxyConfig) this.httpProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProxyConfig httpProxy_delegate$lambda$0(PlatformEnvironProvider platformEnvironProvider) {
        ProxyConfig proxyConfigResolveProxyByProperty = EnvironmentProxySelectorKt.resolveProxyByProperty(platformEnvironProvider, Scheme.INSTANCE.getHTTP());
        return proxyConfigResolveProxyByProperty == null ? EnvironmentProxySelectorKt.resolveProxyByEnvironment(platformEnvironProvider, Scheme.INSTANCE.getHTTP()) : proxyConfigResolveProxyByProperty;
    }

    private final ProxyConfig getHttpsProxy() {
        return (ProxyConfig) this.httpsProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProxyConfig httpsProxy_delegate$lambda$0(PlatformEnvironProvider platformEnvironProvider) {
        ProxyConfig proxyConfigResolveProxyByProperty = EnvironmentProxySelectorKt.resolveProxyByProperty(platformEnvironProvider, Scheme.INSTANCE.getHTTPS());
        return proxyConfigResolveProxyByProperty == null ? EnvironmentProxySelectorKt.resolveProxyByEnvironment(platformEnvironProvider, Scheme.INSTANCE.getHTTPS()) : proxyConfigResolveProxyByProperty;
    }

    private final Set<NonProxyHost> getNonProxyHosts() {
        return (Set) this.nonProxyHosts.getValue();
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.ProxySelector
    public ProxyConfig select(Url url) {
        ProxyConfig httpsProxy;
        Intrinsics.checkNotNullParameter(url, "url");
        if ((getHttpProxy() == null && getHttpsProxy() == null) || nonProxy(url)) {
            return ProxyConfig.Direct.INSTANCE;
        }
        Scheme scheme = url.getScheme();
        if (Intrinsics.areEqual(scheme, Scheme.INSTANCE.getHTTP())) {
            httpsProxy = getHttpProxy();
        } else {
            httpsProxy = Intrinsics.areEqual(scheme, Scheme.INSTANCE.getHTTPS()) ? getHttpsProxy() : null;
        }
        return httpsProxy == null ? ProxyConfig.Direct.INSTANCE : httpsProxy;
    }

    private final boolean nonProxy(Url url) {
        Set<NonProxyHost> nonProxyHosts = getNonProxyHosts();
        if ((nonProxyHosts instanceof Collection) && nonProxyHosts.isEmpty()) {
            return false;
        }
        Iterator<T> it = nonProxyHosts.iterator();
        while (it.hasNext()) {
            if (((NonProxyHost) it.next()).matches(url)) {
                return true;
            }
        }
        return false;
    }
}
