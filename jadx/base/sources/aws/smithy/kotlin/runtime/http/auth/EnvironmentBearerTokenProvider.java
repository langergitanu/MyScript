package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EnvironmentBearerTokenProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/EnvironmentBearerTokenProvider;", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "sysPropKey", "", "envKey", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;)V", "resolve", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentBearerTokenProvider implements BearerTokenProvider {
    private final String envKey;
    private final PlatformProvider platform;
    private final String sysPropKey;

    public EnvironmentBearerTokenProvider(String sysPropKey, String envKey, PlatformProvider platform) {
        Intrinsics.checkNotNullParameter(sysPropKey, "sysPropKey");
        Intrinsics.checkNotNullParameter(envKey, "envKey");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.sysPropKey = sysPropKey;
        this.envKey = envKey;
        this.platform = platform;
    }

    public /* synthetic */ EnvironmentBearerTokenProvider(String str, String str2, PlatformProvider platformProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider);
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        String property;
        String str = this.sysPropKey;
        if (StringsKt.isBlank(str)) {
            str = null;
        }
        if (str == null || (property = this.platform.getProperty(str)) == null) {
            property = this.platform.getenv(this.envKey);
        }
        String str2 = property;
        if (str2 == null || StringsKt.isBlank(str2)) {
            throw new IllegalStateException("Missing values for system property \"" + this.sysPropKey + "\" and environment variable \"" + this.envKey + '\"');
        }
        return new BearerToken(property) { // from class: aws.smithy.kotlin.runtime.http.auth.EnvironmentBearerTokenProvider.resolve.2
            private final Attributes attributes;
            private final Instant expiration;
            private final String token;

            {
                this.token = property;
                MutableAttributes mutableAttributes = AttributesKt.mutableAttributes();
                BusinessMetricsUtilsKt.emitBusinessMetric(mutableAttributes, SmithyBusinessMetric.BEARER_SERVICE_ENV_VARS);
                this.attributes = mutableAttributes;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.BearerToken
            public String getToken() {
                return this.token;
            }

            @Override // aws.smithy.kotlin.runtime.identity.Identity
            public Attributes getAttributes() {
                return this.attributes;
            }

            @Override // aws.smithy.kotlin.runtime.identity.Identity
            public Instant getExpiration() {
                return this.expiration;
            }
        };
    }
}
