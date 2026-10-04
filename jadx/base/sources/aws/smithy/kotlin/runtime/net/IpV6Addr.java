package aws.smithy.kotlin.runtime.net;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.common.Constants;
import com.survicate.surveys.TextRecallingManager;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: IpV6Addr.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007BU\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0011J#\u0010\u0016\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u00020\u001fH\u0096\u0080\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b'\u0010\u0019J&\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u0019R\u001b\u00103\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u00100\u001a\u0004\b5\u0010\u0019R\u0014\u00107\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00108¨\u0006;"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpV6Addr;", "Laws/smithy/kotlin/runtime/net/IpAddr;", "", "octets", "", "zoneId", "<init>", "([BLjava/lang/String;)V", "Lkotlin/UShort;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "d", "e", "f", "g", CmcdData.STREAMING_FORMAT_HLS, "(SSSSSSSSLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/ranges/IntRange;", "range", "formatSegments", "(Ljava/lang/StringBuilder;Lkotlin/ranges/IntRange;)Ljava/lang/StringBuilder;", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "toIpv4Mapped", "()Laws/smithy/kotlin/runtime/net/IpV4Addr;", "component1", "()[B", "component2", "copy", "([BLjava/lang/String;)Laws/smithy/kotlin/runtime/net/IpV6Addr;", "[B", "getOctets", "Ljava/lang/String;", "getZoneId", "Lkotlin/UShortArray;", "segments$delegate", "Lkotlin/Lazy;", "getSegments-amswpOA", "()[S", "segments", "address$delegate", "getAddress", "address", "isLoopBack", "()Z", "isUnspecified", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class IpV6Addr extends IpAddr {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] IPV4_MAPPED_PREFIX_OCTETS = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    private static final IpV6Addr LOCALHOST;
    private static final IpV6Addr UNSPECIFIED;

    /* JADX INFO: renamed from: address$delegate, reason: from kotlin metadata */
    private final Lazy address;
    private final byte[] octets;

    /* JADX INFO: renamed from: segments$delegate, reason: from kotlin metadata */
    private final Lazy segments;
    private final String zoneId;

    public /* synthetic */ IpV6Addr(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(s, s2, s3, s4, s5, s6, s7, s8, str);
    }

    public static /* synthetic */ IpV6Addr copy$default(IpV6Addr ipV6Addr, byte[] bArr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = ipV6Addr.octets;
        }
        if ((i & 2) != 0) {
            str = ipV6Addr.zoneId;
        }
        return ipV6Addr.copy(bArr, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getOctets() {
        return this.octets;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getZoneId() {
        return this.zoneId;
    }

    public final IpV6Addr copy(byte[] octets, String zoneId) {
        Intrinsics.checkNotNullParameter(octets, "octets");
        return new IpV6Addr(octets, zoneId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IpV6Addr(byte[] octets, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(octets, "octets");
        this.octets = octets;
        this.zoneId = str;
        if (getOctets().length != 16) {
            throw new IllegalArgumentException(("Invalid IPv6 repr: " + getOctets() + "; expected 16 bytes").toString());
        }
        this.segments = LazyKt.lazy(new Function0<UShortArray>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$segments$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ UShortArray invoke() {
                return UShortArray.m14831boximpl(m12225invokeamswpOA());
            }

            /* JADX INFO: renamed from: invoke-amswpOA, reason: not valid java name */
            public final short[] m12225invokeamswpOA() {
                int length = this.this$0.getOctets().length / 2;
                IpV6Addr ipV6Addr = this.this$0;
                short[] sArr = new short[length];
                for (int i = 0; i < length; i++) {
                    byte[] octets2 = ipV6Addr.getOctets();
                    int i2 = i * 2;
                    if (i2 > octets2.length - 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    sArr[i] = UShort.m14780constructorimpl((short) ((octets2[i2 + 1] & 255) | ((octets2[i2] & 255) << 8)));
                }
                return UShortArray.m14833constructorimpl(sArr);
            }
        });
        this.address = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IpV6Addr.address_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ IpV6Addr(byte[] bArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? null : str);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public byte[] getOctets() {
        return this.octets;
    }

    public final String getZoneId() {
        return this.zoneId;
    }

    public /* synthetic */ IpV6Addr(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(s, s2, s3, s4, s5, s6, s7, s8, (i & 256) != 0 ? null : str, null);
    }

    private IpV6Addr(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, String str) {
        this(IpV6AddrKt.m12227ipv6SegmentsToOctetsBGmAo10(s, s2, s3, s4, s5, s6, s7, s8), str);
    }

    /* JADX INFO: compiled from: IpV6Addr.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/IpV6Addr$Companion;", "", "<init>", "()V", "", CmcdData.STREAMING_FORMAT_SS, "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/IpV6Addr;", "LOCALHOST", "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "getLOCALHOST", "()Laws/smithy/kotlin/runtime/net/IpV6Addr;", "UNSPECIFIED", "getUNSPECIFIED", "", "IPV4_MAPPED_PREFIX_OCTETS", "[B", "getIPV4_MAPPED_PREFIX_OCTETS$runtime_core", "()[B", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IpV6Addr getLOCALHOST() {
            return IpV6Addr.LOCALHOST;
        }

        public final IpV6Addr getUNSPECIFIED() {
            return IpV6Addr.UNSPECIFIED;
        }

        public final byte[] getIPV4_MAPPED_PREFIX_OCTETS$runtime_core() {
            return IpV6Addr.IPV4_MAPPED_PREFIX_OCTETS;
        }

        public final IpV6Addr parse(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            IpV6Addr ipv6OrNull = TextKt.parseIpv6OrNull(s);
            if (ipv6OrNull != null) {
                return ipv6OrNull;
            }
            throw new IllegalArgumentException(("Invalid Ipv6 address: " + s).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 2;
        LOCALHOST = new IpV6Addr(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        UNSPECIFIED = new IpV6Addr(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: getSegments-amswpOA, reason: not valid java name */
    public final short[] m12224getSegmentsamswpOA() {
        return ((UShortArray) this.segments.getValue()).getStorage();
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public String getAddress() {
        return (String) this.address.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String address_delegate$lambda$0(IpV6Addr ipV6Addr) {
        String string;
        IpV4Addr ipv4Mapped = ipV6Addr.toIpv4Mapped();
        if (ipV6Addr.isLoopBack()) {
            string = "::1";
        } else if (ipV6Addr.isUnspecified()) {
            string = "::";
        } else if (ipv4Mapped != null) {
            string = "::ffff:" + ipv4Mapped;
        } else {
            StringBuilder sb = new StringBuilder();
            IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span = new IpV6Addr$address$2$formatted$1$Span(0, 0, 3, null);
            IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span2 = new IpV6Addr$address$2$formatted$1$Span(0, 0, 3, null);
            short[] sArrM12224getSegmentsamswpOA = ipV6Addr.m12224getSegmentsamswpOA();
            int iM14839getSizeimpl = UShortArray.m14839getSizeimpl(sArrM12224getSegmentsamswpOA);
            int i = 0;
            int i2 = 0;
            while (i < iM14839getSizeimpl) {
                int i3 = i2 + 1;
                if (UShortArray.m14838getMh2AYeg(sArrM12224getSegmentsamswpOA, i) == UShort.m14780constructorimpl((short) 0)) {
                    if (ipV6Addr$address$2$formatted$1$Span.getLen() == 0) {
                        ipV6Addr$address$2$formatted$1$Span.setStart(i2);
                    }
                    ipV6Addr$address$2$formatted$1$Span.setLen(ipV6Addr$address$2$formatted$1$Span.getLen() + 1);
                    if (ipV6Addr$address$2$formatted$1$Span.getLen() > ipV6Addr$address$2$formatted$1$Span2.getLen()) {
                        ipV6Addr$address$2$formatted$1$Span2 = ipV6Addr$address$2$formatted$1$Span;
                    }
                } else {
                    ipV6Addr$address$2$formatted$1$Span = new IpV6Addr$address$2$formatted$1$Span(0, 0, 3, null);
                }
                i++;
                i2 = i3;
            }
            if (ipV6Addr$address$2$formatted$1$Span2.getLen() > 1) {
                ipV6Addr.formatSegments(sb, RangesKt.until(0, ipV6Addr$address$2$formatted$1$Span2.getStart()));
                sb.append("::");
                ipV6Addr.formatSegments(sb, RangesKt.until(ipV6Addr$address$2$formatted$1$Span2.getStart() + ipV6Addr$address$2$formatted$1$Span2.getLen(), UShortArray.m14839getSizeimpl(ipV6Addr.m12224getSegmentsamswpOA())));
            } else {
                ipV6Addr.formatSegments(sb, ArraysKt.getIndices(ipV6Addr.m12224getSegmentsamswpOA()));
            }
            string = sb.toString();
        }
        return ipV6Addr.zoneId != null ? string + '%' + ipV6Addr.zoneId : string;
    }

    private final StringBuilder formatSegments(StringBuilder sb, IntRange intRange) {
        return (StringBuilder) CollectionsKt.joinTo(intRange, sb, (60 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (60 & 4) != 0 ? "" : null, (60 & 8) != 0 ? "" : null, (60 & 16) != 0 ? -1 : 0, (60 & 32) != 0 ? "..." : null, (60 & 64) != 0 ? null : new Function1() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IpV6Addr.formatSegments$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatSegments$lambda$0(IpV6Addr ipV6Addr, int i) {
        return UStringsKt.m15843toStringolVBNx4(UShortArray.m14838getMh2AYeg(ipV6Addr.m12224getSegmentsamswpOA(), i), 16);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public boolean isLoopBack() {
        return Intrinsics.areEqual(this, LOCALHOST);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public boolean isUnspecified() {
        return Intrinsics.areEqual(this, UNSPECIFIED);
    }

    public String toString() {
        return getAddress();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Arrays.equals(getOctets(), ((IpV6Addr) other).getOctets());
    }

    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    public final IpV4Addr toIpv4Mapped() {
        byte[] bArr = IPV4_MAPPED_PREFIX_OCTETS;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (getOctets()[i2] != bArr[i]) {
                return null;
            }
            i++;
            i2 = i3;
        }
        return new IpV4Addr(ArraysKt.sliceArray(getOctets(), RangesKt.until(IPV4_MAPPED_PREFIX_OCTETS.length, getOctets().length)));
    }
}
