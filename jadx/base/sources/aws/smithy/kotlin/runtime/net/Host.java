package aws.smithy.kotlin.runtime.net;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Host.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Host;", "", "<init>", "()V", "Companion", "IpAddress", "Domain", "Laws/smithy/kotlin/runtime/net/Host$Domain;", "Laws/smithy/kotlin/runtime/net/Host$IpAddress;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Host {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ Host(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: Host.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Host$Companion;", "", "<init>", "()V", "", DiagnosticsTracker.HOST_KEY, "Laws/smithy/kotlin/runtime/net/Host;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/Host;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Host parse(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return HostKt.hostParseImpl(host);
        }
    }

    private Host() {
    }

    /* JADX INFO: compiled from: Host.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Host$IpAddress;", "Laws/smithy/kotlin/runtime/net/Host;", "Laws/smithy/kotlin/runtime/net/IpAddr;", "address", "<init>", "(Laws/smithy/kotlin/runtime/net/IpAddr;)V", "", "toString", "()Ljava/lang/String;", "component1", "()Laws/smithy/kotlin/runtime/net/IpAddr;", "copy", "(Laws/smithy/kotlin/runtime/net/IpAddr;)Laws/smithy/kotlin/runtime/net/Host$IpAddress;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Laws/smithy/kotlin/runtime/net/IpAddr;", "getAddress", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class IpAddress extends Host {
        private final IpAddr address;

        public static /* synthetic */ IpAddress copy$default(IpAddress ipAddress, IpAddr ipAddr, int i, Object obj) {
            if ((i & 1) != 0) {
                ipAddr = ipAddress.address;
            }
            return ipAddress.copy(ipAddr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IpAddr getAddress() {
            return this.address;
        }

        public final IpAddress copy(IpAddr address) {
            Intrinsics.checkNotNullParameter(address, "address");
            return new IpAddress(address);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IpAddress) && Intrinsics.areEqual(this.address, ((IpAddress) other).address);
        }

        public int hashCode() {
            return this.address.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IpAddress(IpAddr address) {
            super(null);
            Intrinsics.checkNotNullParameter(address, "address");
            this.address = address;
        }

        public final IpAddr getAddress() {
            return this.address;
        }

        public String toString() {
            return this.address.toString();
        }
    }

    /* JADX INFO: compiled from: Host.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/Host$Domain;", "Laws/smithy/kotlin/runtime/net/Host;", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/Host$Domain;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getName", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Domain extends Host {
        private final String name;

        public static /* synthetic */ Domain copy$default(Domain domain, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = domain.name;
            }
            return domain.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Domain copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Domain(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Domain) && Intrinsics.areEqual(this.name, ((Domain) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Domain(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}
