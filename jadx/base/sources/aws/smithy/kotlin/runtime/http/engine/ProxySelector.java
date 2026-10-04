package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.http.engine.ProxySelector;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProxySelector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "", "Laws/smithy/kotlin/runtime/net/url/Url;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "select", "(Laws/smithy/kotlin/runtime/net/url/Url;)Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ProxySelector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ProxyConfig select(Url url);

    /* JADX INFO: compiled from: ProxySelector.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/ProxySelector$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "NoProxy", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "getNoProxy", "()Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ProxySelector NoProxy = new ProxySelector() { // from class: aws.smithy.kotlin.runtime.http.engine.ProxySelector$Companion$$ExternalSyntheticLambda0
            @Override // aws.smithy.kotlin.runtime.http.engine.ProxySelector
            public final ProxyConfig select(Url url) {
                return ProxySelector.Companion.NoProxy$lambda$0(url);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProxyConfig NoProxy$lambda$0(Url it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return ProxyConfig.Direct.INSTANCE;
        }

        public final ProxySelector getNoProxy() {
            return NoProxy;
        }
    }
}
