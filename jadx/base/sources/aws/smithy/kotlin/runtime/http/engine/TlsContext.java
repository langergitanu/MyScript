package aws.smithy.kotlin.runtime.http.engine;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.client.config.ClientSettings;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfigDsl;
import aws.smithy.kotlin.runtime.net.TlsVersion;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TlsContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "", "Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;)V", "toBuilder$http_client", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "toBuilder", "", "Laws/smithy/kotlin/runtime/http/engine/AlpnId;", "alpn", "Ljava/util/List;", "getAlpn", "()Ljava/util/List;", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "minVersion", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "getMinVersion", "()Laws/smithy/kotlin/runtime/net/TlsVersion;", "Companion", "Builder", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TlsContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TlsContext Default = new TlsContext(new Builder());
    private final List<AlpnId> alpn;
    private final TlsVersion minVersion;

    /* JADX INFO: compiled from: TlsContext.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/TlsContext$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/http/engine/TlsContext;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "getDefault", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TlsContext invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return new TlsContext(builder);
        }

        public final TlsContext getDefault() {
            return TlsContext.Default;
        }
    }

    public TlsContext(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.alpn = builder.getAlpn();
        TlsVersion minVersion = builder.getMinVersion();
        this.minVersion = minVersion == null ? (TlsVersion) EnvironmentSettingKt.resolve$default(ClientSettings.INSTANCE.getMinTlsVersion(), (PlatformEnvironProvider) null, 1, (Object) null) : minVersion;
    }

    public final List<AlpnId> getAlpn() {
        return this.alpn;
    }

    public final TlsVersion getMinVersion() {
        return this.minVersion;
    }

    public final Builder toBuilder$http_client() {
        Builder builder = new Builder();
        builder.setAlpn(this.alpn);
        builder.setMinVersion(this.minVersion);
        return builder;
    }

    /* JADX INFO: compiled from: TlsContext.kt */
    @HttpEngineConfigDsl
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "", "<init>", "()V", "", "Laws/smithy/kotlin/runtime/http/engine/AlpnId;", "alpn", "Ljava/util/List;", "getAlpn", "()Ljava/util/List;", "setAlpn", "(Ljava/util/List;)V", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "minVersion", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "getMinVersion", "()Laws/smithy/kotlin/runtime/net/TlsVersion;", "setMinVersion", "(Laws/smithy/kotlin/runtime/net/TlsVersion;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<? extends AlpnId> alpn = CollectionsKt.emptyList();
        private TlsVersion minVersion;

        public final List<AlpnId> getAlpn() {
            return this.alpn;
        }

        public final void setAlpn(List<? extends AlpnId> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.alpn = list;
        }

        public final TlsVersion getMinVersion() {
            return this.minVersion;
        }

        public final void setMinVersion(TlsVersion tlsVersion) {
            this.minVersion = tlsVersion;
        }
    }
}
