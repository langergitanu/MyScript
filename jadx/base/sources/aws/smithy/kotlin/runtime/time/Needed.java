package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Needed;", "", "<init>", "()V", "Unknown", "Size", "Laws/smithy/kotlin/runtime/time/Needed$Size;", "Laws/smithy/kotlin/runtime/time/Needed$Unknown;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Needed {
    public /* synthetic */ Needed(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ParserCombinators.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Needed$Unknown;", "Laws/smithy/kotlin/runtime/time/Needed;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Unknown extends Needed {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }

        public String toString() {
            return "incomplete input";
        }
    }

    private Needed() {
    }

    /* JADX INFO: compiled from: ParserCombinators.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Needed$Size;", "Laws/smithy/kotlin/runtime/time/Needed;", "", "size", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "component1", "()I", "copy", "(I)Laws/smithy/kotlin/runtime/time/Needed$Size;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "I", "getSize", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Size extends Needed {
        private final int size;

        public static /* synthetic */ Size copy$default(Size size, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = size.size;
            }
            return size.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        public final Size copy(int size) {
            return new Size(size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Size) && this.size == ((Size) other).size;
        }

        public int hashCode() {
            return Integer.hashCode(this.size);
        }

        public Size(int i) {
            super(null);
            this.size = i;
        }

        public final int getSize() {
            return this.size;
        }

        public String toString() {
            return "incomplete input needed (" + this.size + ')';
        }
    }
}
