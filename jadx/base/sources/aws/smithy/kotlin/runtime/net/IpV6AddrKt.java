package aws.smithy.kotlin.runtime.net;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.UShort;

/* JADX INFO: compiled from: IpV6Addr.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001aO\u0010\f\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\u0013\u001a\u00020\u0010*\u00020\t2\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0000*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000eH\u0082\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m1599d2 = {"Lkotlin/UShort;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "d", "e", "f", "g", CmcdData.STREAMING_FORMAT_HLS, "", "ipv6SegmentsToOctets-BGmAo10", "(SSSSSSSS)[B", "ipv6SegmentsToOctets", "value", "", "startIdx", "", "writeUShort-qEOnv9Y", "([BSI)V", "writeUShort", "idx", "readUShort", "([BI)S", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IpV6AddrKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ipv6SegmentsToOctets-BGmAo10, reason: not valid java name */
    public static final byte[] m12227ipv6SegmentsToOctetsBGmAo10(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8) {
        return new byte[]{(byte) (((s & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s & 255), (byte) (((s2 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s2 & 255), (byte) (((s3 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s3 & 255), (byte) (((s4 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s4 & 255), (byte) (((s5 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s5 & 255), (byte) (((s6 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s6 & 255), (byte) (((s7 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s7 & 255), (byte) (((s8 & UShort.MAX_VALUE) >>> 8) & 255), (byte) (s8 & 255)};
    }

    /* JADX INFO: renamed from: writeUShort-qEOnv9Y, reason: not valid java name */
    private static final void m12228writeUShortqEOnv9Y(byte[] bArr, short s, int i) {
        bArr[i] = (byte) (((65535 & s) >>> 8) & 255);
        bArr[i + 1] = (byte) (s & 255);
    }

    private static final short readUShort(byte[] bArr, int i) {
        if (i > bArr.length - 2) {
            throw new IllegalStateException("Check failed.");
        }
        return UShort.m14780constructorimpl((short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8)));
    }
}
