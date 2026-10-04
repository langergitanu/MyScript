package com.revenuecat.purchases.common.localrules;

import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RulesDimensionValue.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "", "()V", "BoolValue", "DateValue", "DoubleValue", "IntValue", "ObjectListValue", "ObjectValue", "StringValue", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$BoolValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$DateValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$DoubleValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$IntValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$ObjectListValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$ObjectValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$StringValue;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class RulesDimensionValue {
    public /* synthetic */ RulesDimensionValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RulesDimensionValue() {
    }

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$StringValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class StringValue extends RulesDimensionValue {
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

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$BoolValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class BoolValue extends RulesDimensionValue {
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

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$IntValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class IntValue extends RulesDimensionValue {
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

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$DoubleValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "(D)V", "getValue", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class DoubleValue extends RulesDimensionValue {
        private final double value;

        public static /* synthetic */ DoubleValue copy$default(DoubleValue doubleValue, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = doubleValue.value;
            }
            return doubleValue.copy(d);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getValue() {
            return this.value;
        }

        public final DoubleValue copy(double value) {
            return new DoubleValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DoubleValue) && Double.compare(this.value, ((DoubleValue) other).value) == 0;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public String toString() {
            return "DoubleValue(value=" + this.value + ')';
        }

        public DoubleValue(double d) {
            super(null);
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$DateValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getValue", "()Ljava/util/Date;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class DateValue extends RulesDimensionValue {
        private final Date value;

        public static /* synthetic */ DateValue copy$default(DateValue dateValue, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                date = dateValue.value;
            }
            return dateValue.copy(date);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Date getValue() {
            return this.value;
        }

        public final DateValue copy(Date value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new DateValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DateValue) && Intrinsics.areEqual(this.value, ((DateValue) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "DateValue(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateValue(Date value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final Date getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$ObjectListValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "", "", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ObjectListValue extends RulesDimensionValue {
        private final List<Map<String, RulesDimensionValue>> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ObjectListValue copy$default(ObjectListValue objectListValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = objectListValue.value;
            }
            return objectListValue.copy(list);
        }

        public final List<Map<String, RulesDimensionValue>> component1() {
            return this.value;
        }

        public final ObjectListValue copy(List<? extends Map<String, ? extends RulesDimensionValue>> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ObjectListValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ObjectListValue) && Intrinsics.areEqual(this.value, ((ObjectListValue) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ObjectListValue(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ObjectListValue(List<? extends Map<String, ? extends RulesDimensionValue>> value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final List<Map<String, RulesDimensionValue>> getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: RulesDimensionValue.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue$ObjectValue;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "value", "", "", "(Ljava/util/Map;)V", "getValue", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ObjectValue extends RulesDimensionValue {
        private final Map<String, RulesDimensionValue> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ObjectValue copy$default(ObjectValue objectValue, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = objectValue.value;
            }
            return objectValue.copy(map);
        }

        public final Map<String, RulesDimensionValue> component1() {
            return this.value;
        }

        public final ObjectValue copy(Map<String, ? extends RulesDimensionValue> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ObjectValue(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ObjectValue) && Intrinsics.areEqual(this.value, ((ObjectValue) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ObjectValue(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ObjectValue(Map<String, ? extends RulesDimensionValue> value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final Map<String, RulesDimensionValue> getValue() {
            return this.value;
        }
    }
}
