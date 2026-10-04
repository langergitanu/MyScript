package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.InternalApi;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultHostResolverJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Ljava/net/InetAddress;", "Laws/smithy/kotlin/runtime/net/HostAddress;", "toHostAddress", "(Ljava/net/InetAddress;)Laws/smithy/kotlin/runtime/net/HostAddress;", "toInetAddress", "(Laws/smithy/kotlin/runtime/net/HostAddress;)Ljava/net/InetAddress;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultHostResolverJVMKt {
    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final HostAddress toHostAddress(InetAddress inetAddress) {
        IpV6Addr ipV6Addr;
        Intrinsics.checkNotNullParameter(inetAddress, "<this>");
        if (inetAddress instanceof Inet4Address) {
            byte[] address = ((Inet4Address) inetAddress).getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
            ipV6Addr = new IpV4Addr(address);
        } else {
            if (!(inetAddress instanceof Inet6Address)) {
                throw new IllegalStateException(("unrecognized InetAddress " + inetAddress).toString());
            }
            byte[] address2 = ((Inet6Address) inetAddress).getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
            ipV6Addr = new IpV6Addr(address2, null, 2, 0 == true ? 1 : 0);
        }
        String hostName = inetAddress.getHostName();
        Intrinsics.checkNotNullExpressionValue(hostName, "getHostName(...)");
        return new HostAddress(hostName, ipV6Addr);
    }

    @InternalApi
    public static final InetAddress toInetAddress(HostAddress hostAddress) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostAddress, "<this>");
        InetAddress byAddress = InetAddress.getByAddress(hostAddress.getHostname(), hostAddress.getAddress().getOctets());
        Intrinsics.checkNotNullExpressionValue(byAddress, "getByAddress(...)");
        return byAddress;
    }
}
