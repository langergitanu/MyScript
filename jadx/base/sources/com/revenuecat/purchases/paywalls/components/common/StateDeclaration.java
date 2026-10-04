package com.revenuecat.purchases.paywalls.components.common;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

/* JADX INFO: compiled from: StateDeclaration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001a\u001b\u001cB/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018HÁ\u0001¢\u0006\u0002\b\u0019R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration;", "", "seen1", "", "type", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "defaultValue", "Lkotlinx/serialization/json/JsonPrimitive;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;Lkotlinx/serialization/json/JsonPrimitive;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;Lkotlinx/serialization/json/JsonPrimitive;)V", "getDefaultValue$annotations", "()V", "getDefaultValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "getType", "()Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "ValueType", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final class StateDeclaration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JsonPrimitive defaultValue;
    private final ValueType type;

    @SerialName("default")
    public static /* synthetic */ void getDefaultValue$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StateDeclaration)) {
            return false;
        }
        StateDeclaration stateDeclaration = (StateDeclaration) obj;
        return this.type == stateDeclaration.type && Intrinsics.areEqual(this.defaultValue, stateDeclaration.defaultValue);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.defaultValue.hashCode();
    }

    public String toString() {
        return "StateDeclaration(type=" + this.type + ", defaultValue=" + this.defaultValue + ')';
    }

    /* JADX INFO: compiled from: StateDeclaration.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StateDeclaration> serializer() {
            return StateDeclaration$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ StateDeclaration(int i, ValueType valueType, @SerialName("default") JsonPrimitive jsonPrimitive, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, StateDeclaration$$serializer.INSTANCE.getDescriptor());
        }
        this.type = valueType;
        this.defaultValue = jsonPrimitive;
    }

    public StateDeclaration(ValueType type, JsonPrimitive defaultValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.type = type;
        this.defaultValue = defaultValue;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(StateDeclaration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ValueTypeSerializer.INSTANCE, self.type);
        output.encodeSerializableElement(serialDesc, 1, JsonPrimitiveSerializer.INSTANCE, self.defaultValue);
    }

    public final /* synthetic */ ValueType getType() {
        return this.type;
    }

    public final /* synthetic */ JsonPrimitive getDefaultValue() {
        return this.defaultValue;
    }

    /* JADX INFO: compiled from: StateDeclaration.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "", "(Ljava/lang/String;I)V", "BOOLEAN", "INTEGER", "DOUBLE", "STRING", "UNKNOWN", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable(with = ValueTypeSerializer.class)
    public enum ValueType {
        BOOLEAN,
        INTEGER,
        DOUBLE,
        STRING,
        UNKNOWN;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: StateDeclaration.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ValueType> serializer() {
                return ValueTypeSerializer.INSTANCE;
            }
        }
    }
}
