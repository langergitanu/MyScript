package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextStyleProviderNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\t\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, m1599d2 = {"Landroidx/compose/foundation/text/modifiers/StylePhase;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@JvmInline
public final class StylePhase {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Layout = m3954constructorimpl(1);
    private static final int Draw = m3954constructorimpl(2);
    private static final int All = m3954constructorimpl(-1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StylePhase m3953boximpl(int i) {
        return new StylePhase(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3954constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3955equalsimpl(int i, Object obj) {
        return (obj instanceof StylePhase) && i == ((StylePhase) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3956equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3957hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3958toStringimpl(int i) {
        return "StylePhase(value=" + i + ')';
    }

    public boolean equals(Object other) {
        return m3955equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m3957hashCodeimpl(this.value);
    }

    public String toString() {
        return m3958toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: TextStyleProviderNode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, m1599d2 = {"Landroidx/compose/foundation/text/modifiers/StylePhase$Companion;", "", "<init>", "()V", "Layout", "Landroidx/compose/foundation/text/modifiers/StylePhase;", "getLayout-oWBPZag", "()I", "I", "Draw", "getDraw-oWBPZag", "All", "getAll-oWBPZag", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLayout-oWBPZag, reason: not valid java name */
        public final int m3962getLayoutoWBPZag() {
            return StylePhase.Layout;
        }

        /* JADX INFO: renamed from: getDraw-oWBPZag, reason: not valid java name */
        public final int m3961getDrawoWBPZag() {
            return StylePhase.Draw;
        }

        /* JADX INFO: renamed from: getAll-oWBPZag, reason: not valid java name */
        public final int m3960getAlloWBPZag() {
            return StylePhase.All;
        }
    }

    private /* synthetic */ StylePhase(int i) {
        this.value = i;
    }
}
