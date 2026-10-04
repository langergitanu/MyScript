package aws.smithy.kotlin.runtime.net;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpV4Addr.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0014H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010$\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000e¨\u0006&"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpV4Addr;", "Laws/smithy/kotlin/runtime/net/IpAddr;", "", "octets", "<init>", "([B)V", "Lkotlin/UByte;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "d", "(BBBBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "toMappedIpv6", "()Laws/smithy/kotlin/runtime/net/IpV6Addr;", "component1", "()[B", "copy", "([B)Laws/smithy/kotlin/runtime/net/IpV4Addr;", "[B", "getOctets", "isLoopBack", "()Z", "isUnspecified", "getAddress", "address", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class IpV4Addr extends IpAddr {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IpV4Addr LOCALHOST;
    private static final IpV4Addr UNSPECIFIED;
    private final byte[] octets;

    public /* synthetic */ IpV4Addr(byte b, byte b2, byte b3, byte b4, DefaultConstructorMarker defaultConstructorMarker) {
        this(b, b2, b3, b4);
    }

    public static /* synthetic */ IpV4Addr copy$default(IpV4Addr ipV4Addr, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = ipV4Addr.octets;
        }
        return ipV4Addr.copy(bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getOctets() {
        return this.octets;
    }

    public final IpV4Addr copy(byte[] octets) {
        Intrinsics.checkNotNullParameter(octets, "octets");
        return new IpV4Addr(octets);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IpV4Addr(byte[] octets) {
        super(null);
        Intrinsics.checkNotNullParameter(octets, "octets");
        this.octets = octets;
        if (getOctets().length != 4) {
            throw new IllegalArgumentException(("Invalid IPv4 repr: " + getOctets() + "; expected 4 bytes").toString());
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public byte[] getOctets() {
        return this.octets;
    }

    private IpV4Addr(byte b, byte b2, byte b3, byte b4) {
        this(new byte[]{b, b2, b3, b4});
    }

    /* JADX INFO: compiled from: IpV4Addr.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpV4Addr$Companion;", "", "<init>", "()V", "", CmcdData.STREAMING_FORMAT_SS, "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/IpV4Addr;", "LOCALHOST", "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "getLOCALHOST", "()Laws/smithy/kotlin/runtime/net/IpV4Addr;", "UNSPECIFIED", "getUNSPECIFIED", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IpV4Addr getLOCALHOST() {
            return IpV4Addr.LOCALHOST;
        }

        public final IpV4Addr getUNSPECIFIED() {
            return IpV4Addr.UNSPECIFIED;
        }

        public final IpV4Addr parse(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            IpV4Addr ipv4OrNull = TextKt.parseIpv4OrNull(s);
            if (ipv4OrNull != null) {
                return ipv4OrNull;
            }
            throw new IllegalArgumentException(("Invalid Ipv4 address: " + s).toString());
        }
    }

    static {
        byte b = 0;
        byte b2 = 0;
        LOCALHOST = new IpV4Addr((byte) 127, b, b2, (byte) 1, null);
        UNSPECIFIED = new IpV4Addr(b, b2, (byte) 0, (byte) 0, null);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public boolean isLoopBack() {
        return getOctets()[0] == 127;
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public boolean isUnspecified() {
        return Intrinsics.areEqual(this, UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _get_address_$lambda$0(byte b) {
        return UByte.m14561toStringimpl(UByte.m14517constructorimpl(b));
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public String getAddress() {
        return ArraysKt.joinToString$default(getOctets(), (CharSequence) ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: aws.smithy.kotlin.runtime.net.IpV4Addr$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IpV4Addr._get_address_$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    public String toString() {
        return getAddress();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Arrays.equals(getOctets(), ((IpV4Addr) other).getOctets());
    }

    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IpV6Addr toMappedIpv6() {
        byte[] bArr = new byte[16];
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = getOctets()[0];
        bArr[13] = getOctets()[1];
        bArr[14] = getOctets()[2];
        bArr[15] = getOctets()[3];
        return new IpV6Addr(bArr, null, 2, 0 == true ? 1 : 0);
    }
}
