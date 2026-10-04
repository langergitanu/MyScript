package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004\u0082\u0001\n\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "", "<init>", "()V", "toString", "", "BeginArray", "EndArray", "BeginObject", "EndObject", "Name", "String", "Number", "Bool", "Null", "EndDocument", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$BeginArray;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$BeginObject;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$Bool;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndArray;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndDocument;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndObject;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$Name;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$Null;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$Number;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken$String;", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class JsonToken {
    public /* synthetic */ JsonToken(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JsonToken() {
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$BeginArray;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BeginArray extends JsonToken {
        public static final BeginArray INSTANCE = new BeginArray();

        private BeginArray() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndArray;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndArray extends JsonToken {
        public static final EndArray INSTANCE = new EndArray();

        private EndArray() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$BeginObject;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BeginObject extends JsonToken {
        public static final BeginObject INSTANCE = new BeginObject();

        private BeginObject() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndObject;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndObject extends JsonToken {
        public static final EndObject INSTANCE = new EndObject();

        private EndObject() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$Name;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Name extends JsonToken {
        private final java.lang.String value;

        public static /* synthetic */ Name copy$default(Name name, java.lang.String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = name.value;
            }
            return name.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getValue() {
            return this.value;
        }

        public final Name copy(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Name(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Name) && Intrinsics.areEqual(this.value, ((Name) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public java.lang.String toString() {
            return "Name(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Name(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$String;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class String extends JsonToken {
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

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public java.lang.String toString() {
            return "String(value=" + this.value + ')';
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
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$Number;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Number extends JsonToken {
        private final java.lang.String value;

        public static /* synthetic */ Number copy$default(Number number, java.lang.String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = number.value;
            }
            return number.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getValue() {
            return this.value;
        }

        public final Number copy(java.lang.String value) {
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

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public java.lang.String toString() {
            return "Number(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Number(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$Bool;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "value", "", "<init>", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Bool extends JsonToken {
        private final boolean value;

        public static /* synthetic */ Bool copy$default(Bool bool, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bool.value;
            }
            return bool.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final Bool copy(boolean value) {
            return new Bool(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Bool) && this.value == ((Bool) other).value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        @Override // aws.smithy.kotlin.runtime.serde.json.JsonToken
        public java.lang.String toString() {
            return "Bool(value=" + this.value + ')';
        }

        public Bool(boolean z) {
            super(null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$Null;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Null extends JsonToken {
        public static final Null INSTANCE = new Null();

        private Null() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: JsonToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonToken$EndDocument;", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "<init>", "()V", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndDocument extends JsonToken {
        public static final EndDocument INSTANCE = new EndDocument();

        private EndDocument() {
            super(null);
        }
    }

    public java.lang.String toString() {
        if (Intrinsics.areEqual(this, BeginArray.INSTANCE)) {
            return "BeginArray";
        }
        if (Intrinsics.areEqual(this, EndArray.INSTANCE)) {
            return "EndArray";
        }
        if (Intrinsics.areEqual(this, BeginObject.INSTANCE)) {
            return "BeginObject";
        }
        if (Intrinsics.areEqual(this, EndObject.INSTANCE)) {
            return "EndObject";
        }
        if (this instanceof Name) {
            return "Name(" + ((Name) this).getValue() + ')';
        }
        if (this instanceof String) {
            return "String(" + ((String) this).getValue() + ')';
        }
        if (this instanceof Number) {
            return "Number(" + ((Number) this).getValue() + ')';
        }
        if (this instanceof Bool) {
            return "Bool(" + ((Bool) this).getValue() + ')';
        }
        if (Intrinsics.areEqual(this, Null.INSTANCE)) {
            return "Null";
        }
        if (Intrinsics.areEqual(this, EndDocument.INSTANCE)) {
            return "EndDocument";
        }
        throw new NoWhenBranchMatchedException();
    }
}
