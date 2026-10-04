package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/HostAddress;", "", "", "hostname", "Laws/smithy/kotlin/runtime/net/IpAddr;", "address", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/IpAddr;)V", "component1", "()Ljava/lang/String;", "component2", "()Laws/smithy/kotlin/runtime/net/IpAddr;", "copy", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/IpAddr;)Laws/smithy/kotlin/runtime/net/HostAddress;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getHostname", "Laws/smithy/kotlin/runtime/net/IpAddr;", "getAddress", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class HostAddress {
    private final IpAddr address;
    private final String hostname;

    public static /* synthetic */ HostAddress copy$default(HostAddress hostAddress, String str, IpAddr ipAddr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostAddress.hostname;
        }
        if ((i & 2) != 0) {
            ipAddr = hostAddress.address;
        }
        return hostAddress.copy(str, ipAddr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHostname() {
        return this.hostname;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IpAddr getAddress() {
        return this.address;
    }

    public final HostAddress copy(String hostname, IpAddr address) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(address, "address");
        return new HostAddress(hostname, address);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostAddress)) {
            return false;
        }
        HostAddress hostAddress = (HostAddress) other;
        return Intrinsics.areEqual(this.hostname, hostAddress.hostname) && Intrinsics.areEqual(this.address, hostAddress.address);
    }

    public int hashCode() {
        return (this.hostname.hashCode() * 31) + this.address.hashCode();
    }

    public String toString() {
        return "HostAddress(hostname=" + this.hostname + ", address=" + this.address + ')';
    }

    public HostAddress(String hostname, IpAddr address) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(address, "address");
        this.hostname = hostname;
        this.address = address;
    }

    public final String getHostname() {
        return this.hostname;
    }

    public final IpAddr getAddress() {
        return this.address;
    }
}
