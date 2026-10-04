package aws.smithy.kotlin.runtime.net.url;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlEncoding.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00162\u00020\u0001:\u0006\u0017\u0018\u0019\u001a\u001b\u0016B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015\u0082\u0001\u0005\u001c\u001d\u001e\u001f ¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "", "", "mask", "<init>", "(I)V", "other", "plus", "(Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "minus", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "item", "contains", "(Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)Z", "I", "Companion", "None", "Path", "QueryParameters", "Fragment", "Composite", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Composite;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Fragment;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding$None;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Path;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding$QueryParameters;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class UrlEncoding {
    private static final UrlEncoding All;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<UrlEncoding> entries;
    private final int mask;

    public /* synthetic */ UrlEncoding(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private UrlEncoding(int i) {
        this.mask = i;
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$None;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class None extends UrlEncoding {
        public static final None INSTANCE = new None();

        private None() {
            super(0, null);
        }

        @Override // aws.smithy.kotlin.runtime.net.url.UrlEncoding
        public String toString() {
            return "None";
        }
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Path;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Path extends UrlEncoding {
        public static final Path INSTANCE = new Path();

        private Path() {
            super(1, null);
        }

        @Override // aws.smithy.kotlin.runtime.net.url.UrlEncoding
        public String toString() {
            return "Path";
        }
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$QueryParameters;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class QueryParameters extends UrlEncoding {
        public static final QueryParameters INSTANCE = new QueryParameters();

        private QueryParameters() {
            super(2, null);
        }

        @Override // aws.smithy.kotlin.runtime.net.url.UrlEncoding
        public String toString() {
            return "QueryParameters";
        }
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Fragment;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Fragment extends UrlEncoding {
        public static final Fragment INSTANCE = new Fragment();

        private Fragment() {
            super(4, null);
        }

        @Override // aws.smithy.kotlin.runtime.net.url.UrlEncoding
        public String toString() {
            return "Fragment";
        }
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Composite;", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "", "mask", "<init>", "(I)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Composite extends UrlEncoding {
        public Composite(int i) {
            super(i, null);
        }
    }

    public final UrlEncoding plus(UrlEncoding other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new Composite(other.mask | this.mask);
    }

    public final UrlEncoding minus(UrlEncoding other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new Composite((~other.mask) & this.mask);
    }

    public boolean equals(Object other) {
        return (other instanceof UrlEncoding) && this.mask == ((UrlEncoding) other).mask;
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getMask() {
        return this.mask;
    }

    public String toString() {
        Set<UrlEncoding> set = entries;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (contains((UrlEncoding) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "|", null, null, 0, null, null, 62, null);
    }

    public final boolean contains(UrlEncoding item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item.mask & this.mask) != 0;
    }

    /* JADX INFO: compiled from: UrlEncoding.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlEncoding$Companion;", "", "<init>", "()V", "", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Ljava/util/Set;", "getEntries", "()Ljava/util/Set;", "All", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "getAll", "()Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<UrlEncoding> getEntries() {
            return UrlEncoding.entries;
        }

        public final UrlEncoding getAll() {
            return UrlEncoding.All;
        }
    }

    static {
        int i = 0;
        Set<UrlEncoding> of = SetsKt.setOf((Object[]) new UrlEncoding[]{Path.INSTANCE, QueryParameters.INSTANCE, Fragment.INSTANCE});
        entries = of;
        Iterator<T> it = of.iterator();
        while (it.hasNext()) {
            i += ((UrlEncoding) it.next()).mask;
        }
        All = new Composite(i);
    }
}
