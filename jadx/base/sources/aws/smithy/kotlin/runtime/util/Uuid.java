package aws.smithy.kotlin.runtime.util;

import androidx.collection.SieveCacheKt;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Stream;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: Uuid.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/Uuid;", "", "", "high", "low", "<init>", "(JJ)V", "", "toString", "()Ljava/lang/String;", "component1", "()J", "component2", "copy", "(JJ)Laws/smithy/kotlin/runtime/util/Uuid;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getHigh", "getLow", "stringRep", "Ljava/lang/String;", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Uuid {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] nibbleChars;
    private static final Random.Companion random;
    private static final long type2Mask;
    private static final long type2Set;
    private static final long v4Mask;
    private static final long v4Set;
    private final long high;
    private final long low;
    private final String stringRep;

    public static /* synthetic */ Uuid copy$default(Uuid uuid, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = uuid.high;
        }
        if ((i & 2) != 0) {
            j2 = uuid.low;
        }
        return uuid.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getHigh() {
        return this.high;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLow() {
        return this.low;
    }

    public final Uuid copy(long high, long low) {
        return new Uuid(high, low);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) other;
        return this.high == uuid.high && this.low == uuid.low;
    }

    public int hashCode() {
        return (Long.hashCode(this.high) * 31) + Long.hashCode(this.low);
    }

    public Uuid(long j, long j2) {
        this.high = j;
        this.low = j2;
        this.stringRep = INSTANCE.toString(j, j2);
    }

    /* JADX INFO: compiled from: Uuid.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/Uuid$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/util/Uuid;", "random", "()Laws/smithy/kotlin/runtime/util/Uuid;", "", "high", "low", "", "toString", "(JJ)Ljava/lang/String;", "src", "", "srcOffset", "", "dest", "destOffset", "length", "", "writeDigits", "(JI[CII)V", "nibbleChars", "[C", "Lkotlin/random/Random$Default;", "Lkotlin/random/Random$Default;", "v4Mask", "J", "v4Set", "type2Mask", "type2Set", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uuid random() {
            return new Uuid((Uuid.random.nextLong() & (~Uuid.v4Mask)) | Uuid.v4Set, (Uuid.random.nextLong() & (~Uuid.type2Mask)) | Uuid.type2Set);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String toString(long high, long low) {
            char[] cArr = new char[36];
            writeDigits(high, 0, cArr, 0, 4);
            cArr[8] = Soundex.SILENT_MARKER;
            writeDigits(high, 4, cArr, 9, 2);
            cArr[13] = Soundex.SILENT_MARKER;
            writeDigits(high, 6, cArr, 14, 2);
            cArr[18] = Soundex.SILENT_MARKER;
            writeDigits(low, 0, cArr, 19, 2);
            cArr[23] = Soundex.SILENT_MARKER;
            writeDigits(low, 2, cArr, 24, 6);
            return StringsKt.concatToString(cArr);
        }

        private final void writeDigits(long src, int srcOffset, char[] dest, int destOffset, int length) {
            int i = 64 - (srcOffset * 8);
            int i2 = length * 2;
            int i3 = 0;
            while (i3 < i2) {
                i -= 4;
                dest[destOffset] = Uuid.nibbleChars[(int) ((src >> i) & 15)];
                i3++;
                destOffset++;
            }
        }
    }

    public final long getHigh() {
        return this.high;
    }

    public final long getLow() {
        return this.low;
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        nibbleChars = charArray;
        random = Random.INSTANCE;
        v4Mask = 61440L;
        v4Set = Http2Stream.EMIT_BUFFER_SIZE;
        type2Mask = SieveCacheKt.NodeMetaMask;
        type2Set = Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getStringRep() {
        return this.stringRep;
    }
}
