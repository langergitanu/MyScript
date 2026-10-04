package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001b\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\"J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b$\u0010 J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020&H\u0017¢\u0006\u0004\b'\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u001eHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, m1599d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "width", "Landroidx/compose/ui/unit/Dp;", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "(J)F", "height", "getHeight-D9Ej5fM$annotations", "getHeight-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "minus", "other", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "times", "", "times-Gh9hcWk", "(JI)J", "", "(JF)J", TtmlNode.TAG_DIV, "div-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@JvmInline
public final class DpSize {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m11106constructorimpl(0);
    private static final long Unspecified = m11106constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m11103boximpl(long j) {
        return new DpSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m11106constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m11111equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m11112equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m11114getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m11116getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m11117hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m11111equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m11117hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m11108copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m11115getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m11113getHeightD9Ej5fM(j);
        }
        return m11107copyDwJknco(j, f, f2);
    }

    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m11118minuse_xh8Ic(long j, long j2) {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) - m11115getWidthD9Ej5fM(j2));
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) - m11113getHeightD9Ej5fM(j2));
        return m11106constructorimpl((((long) Float.floatToRawIntBits(fM11017constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM11017constructorimpl2))));
    }

    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m11119pluse_xh8Ic(long j, long j2) {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) + m11115getWidthD9Ej5fM(j2));
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) + m11113getHeightD9Ej5fM(j2));
        return m11106constructorimpl((((long) Float.floatToRawIntBits(fM11017constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM11017constructorimpl2))));
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m11104component1D9Ej5fM(long j) {
        return m11115getWidthD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m11105component2D9Ej5fM(long j) {
        return m11113getHeightD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m11121timesGh9hcWk(long j, int i) {
        float f = i;
        return m11106constructorimpl((((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) * f))) << 32) | (((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) * f))) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m11120timesGh9hcWk(long j, float f) {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) * f);
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) * f);
        return m11106constructorimpl((((long) Float.floatToRawIntBits(fM11017constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM11017constructorimpl2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m11110divGh9hcWk(long j, int i) {
        float f = i;
        return m11106constructorimpl((((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) / f))) << 32) | (((long) Float.floatToRawIntBits(C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) / f))) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m11109divGh9hcWk(long j, float f) {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(m11115getWidthD9Ej5fM(j) / f);
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(m11113getHeightD9Ej5fM(j) / f);
        return m11106constructorimpl((((long) Float.floatToRawIntBits(fM11017constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM11017constructorimpl2)) & 4294967295L));
    }

    public String toString() {
        return m11122toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m11122toStringimpl(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return ((Object) C1486Dp.m11028toStringimpl(m11115getWidthD9Ej5fM(j))) + " x " + ((Object) C1486Dp.m11028toStringimpl(m11113getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }

    /* JADX INFO: compiled from: Dp.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m1599d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpSize;", "getZero-MYxV2XQ", "()J", "J", "Unspecified", "getUnspecified-MYxV2XQ", "ui-unit"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m11125getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m11124getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m11115getWidthD9Ej5fM(long j) {
        return C1486Dp.m11017constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m11113getHeightD9Ej5fM(long j) {
        return C1486Dp.m11017constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m11107copyDwJknco(long j, float f, float f2) {
        return m11106constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }
}
