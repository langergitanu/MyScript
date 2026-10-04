package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0088\u0001\b\u0092\u0001\u00020\t¨\u0006\u001a"}, m1599d2 = {"Landroidx/constraintlayout/compose/DebugFlags;", "", "showBounds", "", "showPaths", "showKeyPositions", "constructor-impl", "(ZZZ)I", "flags", "", "(I)I", "getShowBounds-impl", "(I)Z", "getShowKeyPositions-impl", "getShowPaths-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@JvmInline
public final class DebugFlags {
    private static final int BOUNDS_FLAG = 1;
    private static final int KEY_POSITIONS_FLAG = 4;
    private static final int PATHS_FLAG = 2;
    private final int flags;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m11363constructorimpl(0);
    private static final int All = m11363constructorimpl(-1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DebugFlags m11362boximpl(int i) {
        return new DebugFlags(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m11363constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m11366equalsimpl(int i, Object obj) {
        return (obj instanceof DebugFlags) && i == ((DebugFlags) obj).getFlags();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m11367equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getShowBounds-impl, reason: not valid java name */
    public static final boolean m11368getShowBoundsimpl(int i) {
        return (i & 1) > 0;
    }

    /* JADX INFO: renamed from: getShowKeyPositions-impl, reason: not valid java name */
    public static final boolean m11369getShowKeyPositionsimpl(int i) {
        return (i & 4) > 0;
    }

    /* JADX INFO: renamed from: getShowPaths-impl, reason: not valid java name */
    public static final boolean m11370getShowPathsimpl(int i) {
        return (i & 2) > 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m11371hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m11366equalsimpl(this.flags, obj);
    }

    public int hashCode() {
        return m11371hashCodeimpl(this.flags);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getFlags() {
        return this.flags;
    }

    private /* synthetic */ DebugFlags(int i) {
        this.flags = i;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ int m11365constructorimpl$default(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return m11364constructorimpl(z, z2, z3);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m11364constructorimpl(boolean z, boolean z2, boolean z3) {
        return m11363constructorimpl((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0));
    }

    public String toString() {
        return m11372toStringimpl(this.flags);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m11372toStringimpl(int i) {
        return "DebugFlags(showBounds = " + m11368getShowBoundsimpl(i) + ", showPaths = " + m11370getShowPathsimpl(i) + ", showKeyPositions = " + m11369getShowKeyPositionsimpl(i) + ')';
    }

    /* JADX INFO: compiled from: MotionLayout.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m1599d2 = {"Landroidx/constraintlayout/compose/DebugFlags$Companion;", "", "()V", "All", "Landroidx/constraintlayout/compose/DebugFlags;", "getAll-bfy_xzQ", "()I", "I", "BOUNDS_FLAG", "", "KEY_POSITIONS_FLAG", "None", "getNone-bfy_xzQ", "PATHS_FLAG", "constraintlayout-compose_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-bfy_xzQ, reason: not valid java name */
        public final int m11375getNonebfy_xzQ() {
            return DebugFlags.None;
        }

        /* JADX INFO: renamed from: getAll-bfy_xzQ, reason: not valid java name */
        public final int m11374getAllbfy_xzQ() {
            return DebugFlags.All;
        }
    }
}
