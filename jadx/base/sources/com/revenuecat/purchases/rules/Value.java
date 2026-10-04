package com.revenuecat.purchases.rules;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Value.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value;", "", "()V", "isTruthy", "", "isTruthy$purchases_defaultsRelease", "()Z", "toNumberOrNull", "", "toNumberOrNull$purchases_defaultsRelease", "()Ljava/lang/Double;", "ArrayValue", "BoolValue", "FloatValue", "IntValue", "Null", "ObjectValue", "StringValue", "Undefined", "Lcom/revenuecat/purchases/rules/Value$ArrayValue;", "Lcom/revenuecat/purchases/rules/Value$BoolValue;", "Lcom/revenuecat/purchases/rules/Value$FloatValue;", "Lcom/revenuecat/purchases/rules/Value$IntValue;", "Lcom/revenuecat/purchases/rules/Value$Null;", "Lcom/revenuecat/purchases/rules/Value$ObjectValue;", "Lcom/revenuecat/purchases/rules/Value$StringValue;", "Lcom/revenuecat/purchases/rules/Value$Undefined;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class Value {
    public /* synthetic */ Value(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Value() {
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$Null;", "Lcom/revenuecat/purchases/rules/Value;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Null extends Value {
        public static final Null INSTANCE = new Null();

        private Null() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$Undefined;", "Lcom/revenuecat/purchases/rules/Value;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Undefined extends Value {
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$BoolValue;", "Lcom/revenuecat/purchases/rules/Value;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class BoolValue extends Value {
        private final boolean value;

        public static /* synthetic */ BoolValue copy$default(BoolValue boolValue, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = boolValue.value;
            }
            return boolValue.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final BoolValue copy(boolean value) {
            return new BoolValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BoolValue) && this.value == ((BoolValue) other).value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public String toString() {
            return "BoolValue(value=" + this.value + ')';
        }

        public BoolValue(boolean z) {
            super(null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$IntValue;", "Lcom/revenuecat/purchases/rules/Value;", "value", "", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class IntValue extends Value {
        private final long value;

        public static /* synthetic */ IntValue copy$default(IntValue intValue, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = intValue.value;
            }
            return intValue.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getValue() {
            return this.value;
        }

        public final IntValue copy(long value) {
            return new IntValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IntValue) && this.value == ((IntValue) other).value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public String toString() {
            return "IntValue(value=" + this.value + ')';
        }

        public IntValue(long j) {
            super(null);
            this.value = j;
        }

        public final long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$FloatValue;", "Lcom/revenuecat/purchases/rules/Value;", "value", "", "(D)V", "getValue", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class FloatValue extends Value {
        private final double value;

        public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = floatValue.value;
            }
            return floatValue.copy(d);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getValue() {
            return this.value;
        }

        public final FloatValue copy(double value) {
            return new FloatValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FloatValue) && Double.compare(this.value, ((FloatValue) other).value) == 0;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public String toString() {
            return "FloatValue(value=" + this.value + ')';
        }

        public FloatValue(double d) {
            super(null);
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$StringValue;", "Lcom/revenuecat/purchases/rules/Value;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class StringValue extends Value {
        private final String value;

        public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringValue.value;
            }
            return stringValue.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final StringValue copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new StringValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StringValue) && Intrinsics.areEqual(this.value, ((StringValue) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringValue(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringValue(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$ArrayValue;", "Lcom/revenuecat/purchases/rules/Value;", FirebaseAnalytics.Param.ITEMS, "", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ArrayValue extends Value {
        private final List<Value> items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ArrayValue copy$default(ArrayValue arrayValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = arrayValue.items;
            }
            return arrayValue.copy(list);
        }

        public final List<Value> component1() {
            return this.items;
        }

        public final ArrayValue copy(List<? extends Value> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new ArrayValue(items);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ArrayValue) && Intrinsics.areEqual(this.items, ((ArrayValue) other).items);
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        public String toString() {
            return "ArrayValue(items=" + this.items + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ArrayValue(List<? extends Value> items) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
        }

        public final List<Value> getItems() {
            return this.items;
        }
    }

    /* JADX INFO: compiled from: Value.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Value$ObjectValue;", "Lcom/revenuecat/purchases/rules/Value;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "", "(Ljava/util/Map;)V", "getEntries", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ObjectValue extends Value {
        private final Map<String, Value> entries;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ObjectValue copy$default(ObjectValue objectValue, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = objectValue.entries;
            }
            return objectValue.copy(map);
        }

        public final Map<String, Value> component1() {
            return this.entries;
        }

        public final ObjectValue copy(Map<String, ? extends Value> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new ObjectValue(entries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ObjectValue) && Intrinsics.areEqual(this.entries, ((ObjectValue) other).entries);
        }

        public int hashCode() {
            return this.entries.hashCode();
        }

        public String toString() {
            return "ObjectValue(entries=" + this.entries + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ObjectValue(Map<String, ? extends Value> entries) {
            super(null);
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
        }

        public final Map<String, Value> getEntries() {
            return this.entries;
        }
    }

    public final boolean isTruthy$purchases_defaultsRelease() {
        if (Intrinsics.areEqual(this, Null.INSTANCE) ? true : Intrinsics.areEqual(this, Undefined.INSTANCE)) {
            return false;
        }
        if (this instanceof BoolValue) {
            return ((BoolValue) this).getValue();
        }
        if (this instanceof IntValue) {
            return ((IntValue) this).getValue() != 0;
        }
        if (this instanceof FloatValue) {
            FloatValue floatValue = (FloatValue) this;
            return (((floatValue.getValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (floatValue.getValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) == 0) || Double.isNaN(floatValue.getValue())) ? false : true;
        }
        if (this instanceof StringValue) {
            return ((StringValue) this).getValue().length() > 0;
        }
        if (this instanceof ArrayValue) {
            return !((ArrayValue) this).getItems().isEmpty();
        }
        if (this instanceof ObjectValue) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Double toNumberOrNull$purchases_defaultsRelease() {
        boolean zAreEqual = Intrinsics.areEqual(this, Null.INSTANCE);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Double dValueOf = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        if (zAreEqual) {
            return dValueOf;
        }
        if (Intrinsics.areEqual(this, Undefined.INSTANCE)) {
            return null;
        }
        if (this instanceof BoolValue) {
            if (((BoolValue) this).getValue()) {
                d = 1.0d;
            }
            return Double.valueOf(d);
        }
        if (this instanceof IntValue) {
            return Double.valueOf(((IntValue) this).getValue());
        }
        if (this instanceof FloatValue) {
            return Double.valueOf(((FloatValue) this).getValue());
        }
        if (this instanceof StringValue) {
            String string = StringsKt.trim((CharSequence) ((StringValue) this).getValue()).toString();
            return string.length() == 0 ? dValueOf : StringsKt.toDoubleOrNull(string);
        }
        if (!(this instanceof ArrayValue ? true : this instanceof ObjectValue)) {
            throw new NoWhenBranchMatchedException();
        }
        String string2 = StringsKt.trim((CharSequence) ValueKt.jsString(this)).toString();
        return string2.length() == 0 ? dValueOf : StringsKt.toDoubleOrNull(string2);
    }
}
