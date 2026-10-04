package kotlinx.datetime.format;

import com.survicate.surveys.TextRecallingManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YearMonthFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006Bi\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, m1599d2 = {"Lkotlinx/datetime/format/MonthNames;", "", "names", "", "", "<init>", "(Ljava/util/List;)V", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNames", "()Ljava/util/List;", "toString", "equals", "", "other", "hashCode", "", "Companion", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MonthNames {
    private final List<String> names;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MonthNames ENGLISH_FULL = new MonthNames(CollectionsKt.listOf((Object[]) new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
    private static final MonthNames ENGLISH_ABBREVIATED = new MonthNames(CollectionsKt.listOf((Object[]) new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));

    public MonthNames(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
        if (names.size() != 12) {
            throw new IllegalArgumentException("Month names must contain exactly 12 elements".toString());
        }
        Iterator<Integer> it = CollectionsKt.getIndices(names).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (this.names.get(iNextInt).length() <= 0) {
                throw new IllegalArgumentException("A month name can not be empty".toString());
            }
            for (int i = 0; i < iNextInt; i++) {
                if (Intrinsics.areEqual(this.names.get(iNextInt), this.names.get(i))) {
                    throw new IllegalArgumentException(("Month names must be unique, but '" + this.names.get(iNextInt) + "' was repeated").toString());
                }
            }
        }
    }

    public final List<String> getNames() {
        return this.names;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MonthNames(String january, String february, String march, String april, String may, String june, String july, String august, String september, String october, String november, String december) {
        this(CollectionsKt.listOf((Object[]) new String[]{january, february, march, april, may, june, july, august, september, october, november, december}));
        Intrinsics.checkNotNullParameter(january, "january");
        Intrinsics.checkNotNullParameter(february, "february");
        Intrinsics.checkNotNullParameter(march, "march");
        Intrinsics.checkNotNullParameter(april, "april");
        Intrinsics.checkNotNullParameter(may, "may");
        Intrinsics.checkNotNullParameter(june, "june");
        Intrinsics.checkNotNullParameter(july, "july");
        Intrinsics.checkNotNullParameter(august, "august");
        Intrinsics.checkNotNullParameter(september, "september");
        Intrinsics.checkNotNullParameter(october, "october");
        Intrinsics.checkNotNullParameter(november, "november");
        Intrinsics.checkNotNullParameter(december, "december");
    }

    /* JADX INFO: compiled from: YearMonthFormat.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m1599d2 = {"Lkotlinx/datetime/format/MonthNames$Companion;", "", "<init>", "()V", "ENGLISH_FULL", "Lkotlinx/datetime/format/MonthNames;", "getENGLISH_FULL", "()Lkotlinx/datetime/format/MonthNames;", "ENGLISH_ABBREVIATED", "getENGLISH_ABBREVIATED", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonthNames getENGLISH_FULL() {
            return MonthNames.ENGLISH_FULL;
        }

        public final MonthNames getENGLISH_ABBREVIATED() {
            return MonthNames.ENGLISH_ABBREVIATED;
        }
    }

    /* JADX INFO: renamed from: kotlinx.datetime.format.MonthNames$toString$1 */
    /* JADX INFO: compiled from: YearMonthFormat.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C88991 extends FunctionReferenceImpl implements Function1<String, String> {
        public static final C88991 INSTANCE = new C88991();

        C88991() {
            super(1, String.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.toString();
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.names, TextRecallingManager.ANSWER_SEPARATOR, "MonthNames(", ")", 0, null, C88991.INSTANCE, 24, null);
    }

    public boolean equals(Object other) {
        return (other instanceof MonthNames) && Intrinsics.areEqual(this.names, ((MonthNames) other).names);
    }

    public int hashCode() {
        return this.names.hashCode();
    }
}
