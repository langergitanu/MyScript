package aws.smithy.kotlin.runtime.net.url;

import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.IpV6Addr;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Url.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"", "Lkotlin/Pair;", "Laws/smithy/kotlin/runtime/net/Host;", "", "parseHostPort", "(Ljava/lang/String;)Lkotlin/Pair;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UrlKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Host, Integer> parseHostPort(String str) {
        String str2 = str;
        if (StringsKt.startsWith$default((CharSequence) str2, '[', false, 2, (Object) null)) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, ']', 0, false, 6, (Object) null);
            if (iIndexOf$default <= 0) {
                throw new IllegalArgumentException("unmatched [ or ]".toString());
            }
            String strSubstring = str.substring(1, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Host host = Host.INSTANCE.parse(PercentEncoding.INSTANCE.getHost().decode(strSubstring));
            if (!(host instanceof Host.IpAddress) || !(((Host.IpAddress) host).getAddress() instanceof IpV6Addr)) {
                throw new IllegalArgumentException("non-ipv6 host was enclosed in []-brackets".toString());
            }
            Character orNull = StringsKt.getOrNull(str2, iIndexOf$default + 1);
            if (orNull != null && orNull.charValue() == ':') {
                String strSubstring2 = str.substring(iIndexOf$default + 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                numValueOf = Integer.valueOf(Integer.parseInt(strSubstring2));
            } else if (orNull != null) {
                throw new IllegalArgumentException("unexpected characters after ]");
            }
            return TuplesKt.m1606to(host, numValueOf);
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str2, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
        Host host2 = Host.INSTANCE.parse(PercentEncoding.INSTANCE.getHost().decode((String) listSplit$default.get(0)));
        if ((host2 instanceof Host.IpAddress) && (((Host.IpAddress) host2).getAddress() instanceof IpV6Addr)) {
            throw new IllegalArgumentException("ipv6 host given without []-brackets".toString());
        }
        String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
        return TuplesKt.m1606to(host2, str3 != null ? Integer.valueOf(Integer.parseInt(str3)) : null);
    }
}
