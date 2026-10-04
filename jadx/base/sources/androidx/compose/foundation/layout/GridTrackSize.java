package androidx.compose.foundation.layout;

import androidx.compose.p004ui.unit.C1486Dp;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: Grid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001c"}, m1599d2 = {"Landroidx/compose/foundation/layout/GridTrackSize;", "Landroidx/compose/foundation/layout/GridTrackSpec;", "encodedValue", "", "constructor-impl", "(J)J", "type", "", "getType-impl$foundation_layout", "(J)I", "value", "", "getValue-impl$foundation_layout", "(J)F", "minValue", "getMinValue-impl$foundation_layout", "maxValue", "getMaxValue-impl$foundation_layout", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "", "hashCode", "Companion", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@JvmInline
public final class GridTrackSize implements GridTrackSpec {
    private static final long Auto;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final long MaxContent;
    private static final long MinContent;
    public static final int TypeAuto = 6;
    public static final int TypeFixed = 1;
    public static final int TypeFlex = 3;
    public static final int TypeMaxContent = 5;
    public static final int TypeMinContent = 4;
    public static final int TypeMinMax = 7;
    public static final int TypePercentage = 2;
    private final long encodedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ GridTrackSize m2776boximpl(long j) {
        return new GridTrackSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2777constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2778equalsimpl(long j, Object obj) {
        return (obj instanceof GridTrackSize) && j == ((GridTrackSize) obj).getEncodedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2779equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getType-impl$foundation_layout, reason: not valid java name */
    public static final int m2782getTypeimpl$foundation_layout(long j) {
        return (int) (j >>> 60);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2784hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m2778equalsimpl(this.encodedValue, other);
    }

    public int hashCode() {
        return m2784hashCodeimpl(this.encodedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getEncodedValue() {
        return this.encodedValue;
    }

    private /* synthetic */ GridTrackSize(long j) {
        this.encodedValue = j;
    }

    /* JADX INFO: renamed from: getValue-impl$foundation_layout, reason: not valid java name */
    public static final float m2783getValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) j);
    }

    /* JADX INFO: renamed from: getMinValue-impl$foundation_layout, reason: not valid java name */
    public static final float m2781getMinValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(((int) ((j >>> 30) & LockFreeTaskQueueCore.HEAD_MASK)) << 2);
    }

    /* JADX INFO: renamed from: getMaxValue-impl$foundation_layout, reason: not valid java name */
    public static final float m2780getMaxValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(((int) (j & LockFreeTaskQueueCore.HEAD_MASK)) << 2);
    }

    public String toString() {
        return m2785toStringimpl(this.encodedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2785toStringimpl(long j) {
        switch (m2782getTypeimpl$foundation_layout(j)) {
            case 1:
                return "Fixed(" + m2783getValueimpl$foundation_layout(j) + "dp)";
            case 2:
                return "Percentage(" + m2783getValueimpl$foundation_layout(j) + ')';
            case 3:
                return "Flex(" + m2783getValueimpl$foundation_layout(j) + "fr)";
            case 4:
                return "MinContent";
            case 5:
                return "MaxContent";
            case 6:
                return "Auto";
            case 7:
                return "MinMax(" + m2781getMinValueimpl$foundation_layout(j) + "dp, " + m2780getMaxValueimpl$foundation_layout(j) + "fr)";
            default:
                return "Unknown";
        }
    }

    /* JADX INFO: compiled from: Grid.kt */
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u0011J!\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0001\u0010\u001c\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010'\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b(\u0010\u001eJ\u001f\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b+\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010#\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0013\u0010%\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!¨\u0006-"}, m1599d2 = {"Landroidx/compose/foundation/layout/GridTrackSize$Companion;", "", "<init>", "()V", "TypeFixed", "", "TypePercentage", "TypeFlex", "TypeMinContent", "TypeMaxContent", "TypeAuto", "TypeMinMax", "Fixed", "Landroidx/compose/foundation/layout/GridTrackSize;", "size", "Landroidx/compose/ui/unit/Dp;", "Fixed-psSkOvk", "(F)J", "Percentage", "value", "", "Percentage-9Tp3RV8", "Flex", "weight", "Landroidx/compose/foundation/layout/Fr;", "Flex-KGB9zo8", "MinMax", "min", "max", "MinMax-1z8F7YY", "(FF)J", "MinContent", "getMinContent-eyNpfc4", "()J", "J", "MaxContent", "getMaxContent-eyNpfc4", "Auto", "getAuto-eyNpfc4", "packMinMax", "packMinMax-ALYS8Xw", "pack", "type", "pack-ALYS8Xw", "(IF)J", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: Fixed-psSkOvk, reason: not valid java name */
        public final long m2790FixedpsSkOvk(float size) {
            if (C1486Dp.m11022equalsimpl0(size, C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM()) || size < 0.0f) {
                throw new IllegalArgumentException(("Fixed size must be non-negative and specified (was " + ((Object) C1486Dp.m11028toStringimpl(size)) + ')').toString());
            }
            return m2788packALYS8Xw(1, size);
        }

        /* JADX INFO: renamed from: Percentage-9Tp3RV8, reason: not valid java name */
        public final long m2793Percentage9Tp3RV8(float value) {
            if (value < 0.0f) {
                throw new IllegalArgumentException("Percentage cannot be negative".toString());
            }
            return m2788packALYS8Xw(2, value);
        }

        /* JADX INFO: renamed from: Flex-KGB9zo8, reason: not valid java name */
        public final long m2791FlexKGB9zo8(float weight) {
            if (weight < 0.0f) {
                throw new IllegalArgumentException("Flex weight must be non-negative".toString());
            }
            return m2788packALYS8Xw(3, weight);
        }

        /* JADX INFO: renamed from: MinMax-1z8F7YY, reason: not valid java name */
        public final long m2792MinMax1z8F7YY(float min, float max) {
            if (min < 0.0f) {
                throw new IllegalArgumentException("MinMax minimum size cannot be negative".toString());
            }
            if (max < 0.0f) {
                throw new IllegalArgumentException("MinMax max weight cannot be negative".toString());
            }
            return m2789packMinMaxALYS8Xw(min, max);
        }

        /* JADX INFO: renamed from: getMinContent-eyNpfc4, reason: not valid java name */
        public final long m2796getMinContenteyNpfc4() {
            return GridTrackSize.MinContent;
        }

        /* JADX INFO: renamed from: getMaxContent-eyNpfc4, reason: not valid java name */
        public final long m2795getMaxContenteyNpfc4() {
            return GridTrackSize.MaxContent;
        }

        /* JADX INFO: renamed from: getAuto-eyNpfc4, reason: not valid java name */
        public final long m2794getAutoeyNpfc4() {
            return GridTrackSize.Auto;
        }

        /* JADX INFO: renamed from: packMinMax-ALYS8Xw, reason: not valid java name */
        private final long m2789packMinMaxALYS8Xw(float min, float max) {
            if (min < 0.0f || max < 0.0f) {
                throw new IllegalArgumentException("minmax values must be non-negative".toString());
            }
            return GridTrackSize.m2777constructorimpl((((long) (Float.floatToRawIntBits(max) >>> 2)) & LockFreeTaskQueueCore.HEAD_MASK) | ((((long) (Float.floatToRawIntBits(min) >>> 2)) & LockFreeTaskQueueCore.HEAD_MASK) << 30) | 8070450532247928832L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: pack-ALYS8Xw, reason: not valid java name */
        public final long m2788packALYS8Xw(int type, float value) {
            return GridTrackSize.m2777constructorimpl((((long) Float.floatToRawIntBits(value)) & 4294967295L) | ((((long) type) & 15) << 60));
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        MinContent = companion.m2788packALYS8Xw(4, 0.0f);
        MaxContent = companion.m2788packALYS8Xw(5, 0.0f);
        Auto = companion.m2788packALYS8Xw(6, 0.0f);
    }
}
