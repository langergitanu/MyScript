package aws.smithy.kotlin.runtime.text;

import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import com.fasterxml.jackson.core.base.GeneratorBase;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utf8.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0006\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, m1599d2 = {"", TtmlNode.START, "", "byteCountUtf8", "(B)I", "Lkotlin/Char$Companion;", "codePoint", "", "isSupplementaryCodePoint", "(Lkotlin/jvm/internal/CharCompanionObject;I)Z", "", "codePointToChars", "(Lkotlin/jvm/internal/CharCompanionObject;I)[C", "SUPPLEMENTARY_PLANE_LOW", "I", "MAX_CODEPOINT", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Utf8Kt {
    private static final int MAX_CODEPOINT = 1114111;
    private static final int SUPPLEMENTARY_PLANE_LOW = 65536;

    @InternalApi
    public static final boolean isSupplementaryCodePoint(CharCompanionObject charCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(charCompanionObject, "<this>");
        return 65536 <= i && i < 1114112;
    }

    @InternalApi
    public static final int byteCountUtf8(byte b) {
        int iM14594constructorimpl = UInt.m14594constructorimpl(b);
        if (Integer.compareUnsigned(iM14594constructorimpl, 127) <= 0) {
            return 1;
        }
        if (UInt.m14594constructorimpl(iM14594constructorimpl & 224) == 192) {
            return 2;
        }
        if (UInt.m14594constructorimpl(iM14594constructorimpl & PsExtractor.VIDEO_STREAM_MASK) == 224) {
            return 3;
        }
        if (UInt.m14594constructorimpl(iM14594constructorimpl & 248) == 240) {
            return 4;
        }
        throw new IllegalStateException(((int) b) + " is not a valid UTF-8 start sequence");
    }

    @InternalApi
    public static final char[] codePointToChars(CharCompanionObject charCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(charCompanionObject, "<this>");
        if (i >= 0 && i < 65536) {
            return new char[]{(char) i};
        }
        if (65536 <= i && i < 1114112) {
            int i2 = i - 65536;
            return new char[]{(char) (((i2 >>> 10) & 1023) + GeneratorBase.SURR1_FIRST), (char) ((i2 & 1023) + 56320)};
        }
        throw new IllegalArgumentException("invalid codepoint " + i);
    }
}
