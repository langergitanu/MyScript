package com.revenuecat.purchases.paywalls.components.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: StateUpdate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;", "", "Companion", "Literal", "PayloadReference", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue$Literal;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue$PayloadReference;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface StateUpdateValue {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String PAYLOAD_REFERENCE_TOKEN = "$value";

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue$Literal;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "(Lkotlinx/serialization/json/JsonPrimitive;)V", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Literal implements StateUpdateValue {
        private final JsonPrimitive value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Literal) && Intrinsics.areEqual(this.value, ((Literal) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Literal(value=" + this.value + ')';
        }

        public Literal(JsonPrimitive value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final /* synthetic */ JsonPrimitive getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue$PayloadReference;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class PayloadReference implements StateUpdateValue {
        public static final PayloadReference INSTANCE = new PayloadReference();

        private PayloadReference() {
        }
    }

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue$Companion;", "", "()V", "PAYLOAD_REFERENCE_TOKEN", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PAYLOAD_REFERENCE_TOKEN = "$value";

        private Companion() {
        }
    }
}
