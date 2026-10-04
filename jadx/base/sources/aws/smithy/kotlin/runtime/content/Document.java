package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.content.Document;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: Document.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005789:;B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010#¢\u0006\u0004\b&\u0010'J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u0004\u0018\u00010(¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010-¢\u0006\u0004\b0\u00101J\r\u00103\u001a\u000202¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u0004\u0018\u000102¢\u0006\u0004\b5\u00106\u0082\u0001\u0005<=>?@¨\u0006A"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document;", "", "<init>", "()V", "", "asNumber", "()Ljava/lang/Number;", "asNumberOrNull", "", "asString", "()Ljava/lang/String;", "asStringOrNull", "", "asBoolean", "()Z", "asBooleanOrNull", "()Ljava/lang/Boolean;", "", "asList", "()Ljava/util/List;", "asListOrNull", "", "asMap", "()Ljava/util/Map;", "asMapOrNull", "", "asInt", "()I", "asIntOrNull", "()Ljava/lang/Integer;", "", "asByte", "()B", "asByteOrNull", "()Ljava/lang/Byte;", "", "asShort", "()S", "asShortOrNull", "()Ljava/lang/Short;", "", "asLong", "()J", "asLongOrNull", "()Ljava/lang/Long;", "", "asFloat", "()F", "asFloatOrNull", "()Ljava/lang/Float;", "", "asDouble", "()D", "asDoubleOrNull", "()Ljava/lang/Double;", "Number", "String", "Boolean", "List", "Map", "Laws/smithy/kotlin/runtime/content/Document$Boolean;", "Laws/smithy/kotlin/runtime/content/Document$List;", "Laws/smithy/kotlin/runtime/content/Document$Map;", "Laws/smithy/kotlin/runtime/content/Document$Number;", "Laws/smithy/kotlin/runtime/content/Document$String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Document {
    public /* synthetic */ Document(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Document() {
    }

    /* JADX INFO: compiled from: Document.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document$Number;", "Laws/smithy/kotlin/runtime/content/Document;", "", "value", "<init>", "(Ljava/lang/Number;)V", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Number;", "copy", "(Ljava/lang/Number;)Laws/smithy/kotlin/runtime/content/Document$Number;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Number;", "getValue", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Number extends Document {
        private final java.lang.Number value;

        public static /* synthetic */ Number copy$default(Number number, java.lang.Number number2, int i, Object obj) {
            if ((i & 1) != 0) {
                number2 = number.value;
            }
            return number.copy(number2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.Number getValue() {
            return this.value;
        }

        public final Number copy(java.lang.Number value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Number(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Number) && Intrinsics.areEqual(this.value, ((Number) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Number(java.lang.Number value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            if (((value instanceof Double) && Math.abs(value.doubleValue()) > Double.MAX_VALUE) || ((value instanceof Float) && Math.abs(value.floatValue()) > Float.MAX_VALUE)) {
                throw new IllegalArgumentException("a document number cannot be " + value + ", as its value cannot be preserved across serde");
            }
        }

        public final java.lang.Number getValue() {
            return this.value;
        }

        public java.lang.String toString() {
            return this.value.toString();
        }
    }

    /* JADX INFO: compiled from: Document.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document$String;", "Laws/smithy/kotlin/runtime/content/Document;", "", "value", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/content/Document$String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getValue", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class String extends Document {
        private final java.lang.String value;

        public static /* synthetic */ String copy$default(String string, java.lang.String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = string.value;
            }
            return string.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getValue() {
            return this.value;
        }

        public final String copy(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof String) && Intrinsics.areEqual(this.value, ((String) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public String(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public java.lang.String toString() {
            return "\"" + this.value + '\"';
        }
    }

    /* JADX INFO: compiled from: Document.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\n¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document$Boolean;", "Laws/smithy/kotlin/runtime/content/Document;", "", "value", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "component1", "()Z", "copy", "(Z)Laws/smithy/kotlin/runtime/content/Document$Boolean;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "getValue", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Boolean extends Document {
        private final boolean value;

        public static /* synthetic */ Boolean copy$default(Boolean r0, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = r0.value;
            }
            return r0.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final Boolean copy(boolean value) {
            return new Boolean(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Boolean) && this.value == ((Boolean) other).value;
        }

        public int hashCode() {
            return java.lang.Boolean.hashCode(this.value);
        }

        public Boolean(boolean z) {
            super(null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }

        public java.lang.String toString() {
            return java.lang.String.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Document.kt */
    @Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0083\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0096\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0083\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0081\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u00020\u000eH\u0096\u0081\u0004¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0096\u0083\u0004¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0081\u0004¢\u0006\u0004\b&\u0010 J\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0096\u0081\u0004¢\u0006\u0004\b(\u0010)J!\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0081\u0004¢\u0006\u0004\b(\u0010*J)\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0096\u0081\u0004¢\u0006\u0004\b-\u0010.R\u001f\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\nR\u0015\u00102\u001a\u00020\u00198\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b1\u0010\u001e¨\u00063"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document$List;", "Laws/smithy/kotlin/runtime/content/Document;", "", "value", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Laws/smithy/kotlin/runtime/content/Document$List;", "element", "", "contains", "(Laws/smithy/kotlin/runtime/content/Document;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Laws/smithy/kotlin/runtime/content/Document;", "hashCode", "()I", "indexOf", "(Laws/smithy/kotlin/runtime/content/Document;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Ljava/util/List;", "getValue", "getSize", "size", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class List extends Document implements java.util.List<Document>, KMappedMarker {
        private final java.util.List<Document> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List copy$default(List list, java.util.List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list2 = list.value;
            }
            return list.copy(list2);
        }

        /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
        public void add2(int i, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Document> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends Document> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final java.util.List<Document> component1() {
            return this.value;
        }

        public boolean contains(Document element) {
            return this.value.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.value.containsAll(elements);
        }

        public final List copy(java.util.List<? extends Document> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new List(value);
        }

        @Override // java.util.List, java.util.Collection
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof List) && Intrinsics.areEqual(this.value, ((List) other).value);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public Document get(int index) {
            return this.value.get(index);
        }

        public int getSize() {
            return this.value.size();
        }

        @Override // java.util.List, java.util.Collection
        public int hashCode() {
            return this.value.hashCode();
        }

        public int indexOf(Document element) {
            return this.value.indexOf(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.value.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<Document> iterator() {
            return this.value.iterator();
        }

        public int lastIndexOf(Document element) {
            return this.value.lastIndexOf(element);
        }

        @Override // java.util.List
        public ListIterator<Document> listIterator() {
            return this.value.listIterator();
        }

        @Override // java.util.List
        public ListIterator<Document> listIterator(int index) {
            return this.value.listIterator(index);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public Document remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Document remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<Document> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public Document set2(int i, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Document set(int i, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void sort(Comparator<? super Document> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public java.util.List<Document> subList(int fromIndex, int toIndex) {
            return this.value.subList(fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.toArray(this, array);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public List(java.util.List<? extends Document> value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof Document) {
                return contains((Document) obj);
            }
            return false;
        }

        public final java.util.List<Document> getValue() {
            return this.value;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof Document) {
                return indexOf((Document) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof Document) {
                return lastIndexOf((Document) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public java.lang.String toString() {
            return CollectionsKt.joinToString$default(this.value, ",", "[", "]", 0, null, null, 56, null);
        }
    }

    /* JADX INFO: compiled from: Document.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u000eH\u0096\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010\nR)\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010!0 8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0015\u0010(\u001a\u00020\u00198\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u001d\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/Document$Map;", "Laws/smithy/kotlin/runtime/content/Document;", "", "", "value", "<init>", "(Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "component1", "()Ljava/util/Map;", "copy", "(Ljava/util/Map;)Laws/smithy/kotlin/runtime/content/Document$Map;", SubscriberAttributeKt.JSON_NAME_KEY, "", "containsKey", "(Ljava/lang/String;)Z", "containsValue", "(Laws/smithy/kotlin/runtime/content/Document;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/content/Document;", "", "hashCode", "()I", "isEmpty", "()Z", "Ljava/util/Map;", "getValue", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "size", "", "getValues", "()Ljava/util/Collection;", "values", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Map extends Document implements java.util.Map<java.lang.String, Document>, KMappedMarker {
        private final java.util.Map<java.lang.String, Document> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map copy$default(Map map, java.util.Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map2 = map.value;
            }
            return map.copy(map2);
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final java.util.Map<java.lang.String, Document> component1() {
            return this.value;
        }

        /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
        public Document compute2(java.lang.String str, BiFunction<? super java.lang.String, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document compute(java.lang.String str, BiFunction<? super java.lang.String, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
        public Document computeIfAbsent2(java.lang.String str, Function<? super java.lang.String, ? extends Document> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document computeIfAbsent(java.lang.String str, Function<? super java.lang.String, ? extends Document> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
        public Document computeIfPresent2(java.lang.String str, BiFunction<? super java.lang.String, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document computeIfPresent(java.lang.String str, BiFunction<? super java.lang.String, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean containsKey(java.lang.String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.value.containsKey(key);
        }

        public boolean containsValue(Document value) {
            return this.value.containsValue(value);
        }

        public final Map copy(java.util.Map<java.lang.String, ? extends Document> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Map(value);
        }

        @Override // java.util.Map
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Map) && Intrinsics.areEqual(this.value, ((Map) other).value);
        }

        public Document get(java.lang.String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.value.get(key);
        }

        public Set<Map.Entry<java.lang.String, Document>> getEntries() {
            return this.value.entrySet();
        }

        public Set<java.lang.String> getKeys() {
            return this.value.keySet();
        }

        public int getSize() {
            return this.value.size();
        }

        public Collection<Document> getValues() {
            return this.value.values();
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.value.isEmpty();
        }

        /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
        public Document merge2(java.lang.String str, Document document, BiFunction<? super Document, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document merge(java.lang.String str, Document document, BiFunction<? super Document, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
        public Document put2(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document put(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(java.util.Map<? extends java.lang.String, ? extends Document> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
        public Document putIfAbsent2(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document putIfAbsent(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map
        public Document remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public Document replace2(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Document replace(java.lang.String str, Document document) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ boolean replace(java.lang.String str, Document document, Document document2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public boolean replace2(java.lang.String str, Document document, Document document2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super java.lang.String, ? super Document, ? extends Document> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Map(java.util.Map<java.lang.String, ? extends Document> value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof java.lang.String) {
                return containsKey((java.lang.String) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj == null ? true : obj instanceof Document) {
                return containsValue((Document) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<java.lang.String, Document>> entrySet() {
            return getEntries();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map
        public final /* bridge */ Document get(Object obj) {
            if (obj instanceof java.lang.String) {
                return get((java.lang.String) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Document get(Object obj) {
            if (obj instanceof java.lang.String) {
                return get((java.lang.String) obj);
            }
            return null;
        }

        public final java.util.Map<java.lang.String, Document> getValue() {
            return this.value;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<java.lang.String> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<Document> values() {
            return getValues();
        }

        public java.lang.String toString() {
            return CollectionsKt.joinToString$default(this.value.entrySet(), ",", "{", "}", 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.content.Document$Map$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Document.Map.toString$lambda$0((Map.Entry) obj);
                }
            }, 24, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toString$lambda$0(Map.Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "<destruct>");
            return "\"" + ((java.lang.String) entry.getKey()) + "\":" + ((Document) entry.getValue());
        }
    }

    private final java.lang.Number asNumber() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.content.Document.Number");
        return ((Number) this).getValue();
    }

    private final java.lang.Number asNumberOrNull() {
        Number number = this instanceof Number ? (Number) this : null;
        if (number != null) {
            return number.getValue();
        }
        return null;
    }

    public final java.lang.String asString() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.content.Document.String");
        return ((String) this).getValue();
    }

    public final java.lang.String asStringOrNull() {
        String string = this instanceof String ? (String) this : null;
        if (string != null) {
            return string.getValue();
        }
        return null;
    }

    public final boolean asBoolean() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.content.Document.Boolean");
        return ((Boolean) this).getValue();
    }

    public final java.lang.Boolean asBooleanOrNull() {
        Boolean r0 = this instanceof Boolean ? (Boolean) this : null;
        if (r0 != null) {
            return java.lang.Boolean.valueOf(r0.getValue());
        }
        return null;
    }

    public final java.util.List<Document> asList() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.content.Document.List");
        return ((List) this).getValue();
    }

    public final java.util.List<Document> asListOrNull() {
        List list = this instanceof List ? (List) this : null;
        if (list != null) {
            return list.getValue();
        }
        return null;
    }

    public final java.util.Map<java.lang.String, Document> asMap() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.content.Document.Map");
        return ((Map) this).getValue();
    }

    public final java.util.Map<java.lang.String, Document> asMapOrNull() {
        Map map = this instanceof Map ? (Map) this : null;
        if (map != null) {
            return map.getValue();
        }
        return null;
    }

    public final int asInt() {
        return asNumber().intValue();
    }

    public final Integer asIntOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Integer.valueOf(numberAsNumberOrNull.intValue());
        }
        return null;
    }

    public final byte asByte() {
        return asNumber().byteValue();
    }

    public final Byte asByteOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Byte.valueOf(numberAsNumberOrNull.byteValue());
        }
        return null;
    }

    public final short asShort() {
        return asNumber().shortValue();
    }

    public final Short asShortOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Short.valueOf(numberAsNumberOrNull.shortValue());
        }
        return null;
    }

    public final long asLong() {
        return asNumber().longValue();
    }

    public final Long asLongOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Long.valueOf(numberAsNumberOrNull.longValue());
        }
        return null;
    }

    public final float asFloat() {
        return asNumber().floatValue();
    }

    public final Float asFloatOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Float.valueOf(numberAsNumberOrNull.floatValue());
        }
        return null;
    }

    public final double asDouble() {
        return asNumber().doubleValue();
    }

    public final Double asDoubleOrNull() {
        java.lang.Number numberAsNumberOrNull = asNumberOrNull();
        if (numberAsNumberOrNull != null) {
            return Double.valueOf(numberAsNumberOrNull.doubleValue());
        }
        return null;
    }
}
