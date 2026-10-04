package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Host.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"", DiagnosticsTracker.HOST_KEY, "Laws/smithy/kotlin/runtime/net/Host;", "hostParseImpl", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/Host;", "toUrlString", "(Laws/smithy/kotlin/runtime/net/Host;)Ljava/lang/String;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Host hostParseImpl(String str) {
        IpAddr ipv4OrNull = TextKt.parseIpv4OrNull(str);
        if (ipv4OrNull == null) {
            ipv4OrNull = TextKt.parseIpv6OrNull(str);
        }
        IpAddr ipAddr = ipv4OrNull;
        if (ipAddr != null) {
            return new Host.IpAddress(ipAddr);
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (!(listSplit$default instanceof Collection) || !listSplit$default.isEmpty()) {
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                if (!TextKt.isValidHostname((String) it.next())) {
                    throw new IllegalArgumentException(str + " is not a valid inet host");
                }
            }
        }
        return new Host.Domain(str);
    }

    public static final String toUrlString(Host host) {
        Intrinsics.checkNotNullParameter(host, "<this>");
        if (host instanceof Host.IpAddress) {
            Host.IpAddress ipAddress = (Host.IpAddress) host;
            if (ipAddress.getAddress() instanceof IpV6Addr) {
                return "[" + PercentEncoding.INSTANCE.getHost().encode(((IpV6Addr) ipAddress.getAddress()).toString()) + ']';
            }
            return ipAddress.getAddress().toString();
        }
        if (host instanceof Host.Domain) {
            return ((Host.Domain) host).getName();
        }
        throw new NoWhenBranchMatchedException();
    }
}
