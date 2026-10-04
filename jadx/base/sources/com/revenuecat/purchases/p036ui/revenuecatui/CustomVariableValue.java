package com.revenuecat.purchases.p036ui.revenuecatui;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CustomVariableValue.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b'\u0018\u0000 \u00122\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007\b\u0000¢\u0006\u0002\u0010\u0002JQ\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\b0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\b0\nH ¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "()V", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "map", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.Custom.S_STRING, "Lkotlin/Function1;", "number", "", TypedValues.Custom.S_BOOLEAN, "", "map$revenuecatui_defaultsRelease", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Boolean", "Companion", "Number", "String", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CustomVariableValue implements Parcelable {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public abstract <T> T map$revenuecatui_defaultsRelease(Function1<? super java.lang.String, ? extends T> string, Function1<? super Double, ? extends T> number, Function1<? super java.lang.Boolean, ? extends T> function1);

    /* JADX INFO: compiled from: CustomVariableValue.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016JQ\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00100\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u00100\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$String;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "equals", "", "other", "", "hashCode", "map", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.Custom.S_STRING, "Lkotlin/Function1;", "number", "", TypedValues.Custom.S_BOOLEAN, "map$revenuecatui_defaultsRelease", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class String extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<String> CREATOR = new Creator();
        private final java.lang.String value;

        /* JADX INFO: compiled from: CustomVariableValue.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<String> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new String(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String[] newArray(int i) {
                return new String[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.value);
        }

        public String(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            return (other instanceof String) && Intrinsics.areEqual(this.value, ((String) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "CustomVariableValue.String(value=" + this.value + ')';
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue
        public <T> T map$revenuecatui_defaultsRelease(Function1<? super java.lang.String, ? extends T> string, Function1<? super Double, ? extends T> number, Function1<? super java.lang.Boolean, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(number, "number");
            Intrinsics.checkNotNullParameter(function1, "boolean");
            return string.invoke(this.value);
        }
    }

    /* JADX INFO: compiled from: CustomVariableValue.kt */
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016JQ\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u00150\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00150\u00172\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u00150\u0017H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Number;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(I)V", "", "(J)V", "", "(F)V", "", "(D)V", "getValue", "()D", "describeContents", "equals", "", "other", "", "hashCode", "map", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.Custom.S_STRING, "Lkotlin/Function1;", "", "number", TypedValues.Custom.S_BOOLEAN, "map$revenuecatui_defaultsRelease", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Number extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Number> CREATOR = new Creator();
        private final double value;

        /* JADX INFO: compiled from: CustomVariableValue.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<Number> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Number(parcel.readDouble());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number[] newArray(int i) {
                return new Number[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeDouble(this.value);
        }

        public Number(double d) {
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }

        public Number(int i) {
            this(i);
        }

        public Number(long j) {
            this(j);
        }

        public Number(float f) {
            this(f);
        }

        public boolean equals(Object other) {
            return (other instanceof Number) && this.value == ((Number) other).value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Number(value=" + this.value + ')';
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue
        public <T> T map$revenuecatui_defaultsRelease(Function1<? super java.lang.String, ? extends T> string, Function1<? super Double, ? extends T> number, Function1<? super java.lang.Boolean, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(number, "number");
            Intrinsics.checkNotNullParameter(function1, "boolean");
            return number.invoke(Double.valueOf(this.value));
        }
    }

    /* JADX INFO: compiled from: CustomVariableValue.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\tH\u0016JQ\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u000f0\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u000f0\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Boolean;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(Z)V", "getValue", "()Z", "describeContents", "", "equals", "other", "", "hashCode", "map", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.Custom.S_STRING, "Lkotlin/Function1;", "", "number", "", TypedValues.Custom.S_BOOLEAN, "map$revenuecatui_defaultsRelease", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Boolean extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Boolean> CREATOR = new Creator();
        private final boolean value;

        /* JADX INFO: compiled from: CustomVariableValue.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<Boolean> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Boolean(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean[] newArray(int i) {
                return new Boolean[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.value ? 1 : 0);
        }

        public Boolean(boolean z) {
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            return (other instanceof Boolean) && this.value == ((Boolean) other).value;
        }

        public int hashCode() {
            return java.lang.Boolean.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Boolean(value=" + this.value + ')';
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue
        public <T> T map$revenuecatui_defaultsRelease(Function1<? super java.lang.String, ? extends T> string, Function1<? super Double, ? extends T> number, Function1<? super java.lang.Boolean, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(number, "number");
            Intrinsics.checkNotNullParameter(function1, "boolean");
            return function1.invoke(java.lang.Boolean.valueOf(this.value));
        }
    }

    public final java.lang.String getStringValue() {
        return (java.lang.String) map$revenuecatui_defaultsRelease(new Function1<java.lang.String, java.lang.String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue$stringValue$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        }, new Function1<Double, java.lang.String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue$stringValue$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Double d) {
                return invoke(d.doubleValue());
            }

            public final String invoke(double d) {
                return d % 1.0d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? String.valueOf((long) d) : String.valueOf(d);
            }
        }, new Function1<java.lang.Boolean, java.lang.String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue$stringValue$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final String invoke(boolean z) {
                return String.valueOf(z);
            }
        });
    }

    /* JADX INFO: compiled from: CustomVariableValue.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "value", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomVariableValue from(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof java.lang.String) {
                return new String((java.lang.String) value);
            }
            if (value instanceof Integer) {
                return new Number(((java.lang.Number) value).intValue());
            }
            if (value instanceof Long) {
                return new Number(((java.lang.Number) value).longValue());
            }
            if (value instanceof Double) {
                return new Number(((java.lang.Number) value).doubleValue());
            }
            if (value instanceof Float) {
                return new Number(((java.lang.Number) value).floatValue());
            }
            if (value instanceof java.lang.Boolean) {
                return new Boolean(((java.lang.Boolean) value).booleanValue());
            }
            throw new IllegalArgumentException("Unsupported custom variable type: " + Reflection.getOrCreateKotlinClass(value.getClass()).getSimpleName() + ". Supported types are: String, Int, Long, Double, Float, Boolean.");
        }
    }
}
