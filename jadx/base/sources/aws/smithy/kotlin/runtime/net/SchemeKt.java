package aws.smithy.kotlin.runtime.net;

import androidx.webkit.ProxyConfig;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Scheme;", "", "isSecure", "(Laws/smithy/kotlin/runtime/net/Scheme;)Z", "isSecure$annotations", "(Laws/smithy/kotlin/runtime/net/Scheme;)V", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SchemeKt {
    @InternalApi
    public static /* synthetic */ void isSecure$annotations(Scheme scheme) {
    }

    public static final boolean isSecure(Scheme scheme) {
        Intrinsics.checkNotNullParameter(scheme, "<this>");
        String lowerCase = scheme.getProtocolName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, ProxyConfig.MATCH_HTTPS) || Intrinsics.areEqual(lowerCase, "wss");
    }
}
