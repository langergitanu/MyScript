package aws.smithy.kotlin.runtime.net;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpAddr.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpAddr;", "", "<init>", "()V", "", "getOctets", "()[B", "octets", "", "getAddress", "()Ljava/lang/String;", "address", "", "isLoopBack", "()Z", "isUnspecified", "Companion", "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class IpAddr {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ IpAddr(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getAddress();

    public abstract byte[] getOctets();

    public abstract boolean isLoopBack();

    public abstract boolean isUnspecified();

    private IpAddr() {
    }

    /* JADX INFO: compiled from: IpAddr.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpAddr$Companion;", "", "<init>", "()V", "", CmcdData.STREAMING_FORMAT_SS, "Laws/smithy/kotlin/runtime/net/IpAddr;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/IpAddr;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IpAddr parse(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            return TextKt.isIpv4(s) ? IpV4Addr.Companion.parse(s) : IpV6Addr.Companion.parse(s);
        }
    }
}
