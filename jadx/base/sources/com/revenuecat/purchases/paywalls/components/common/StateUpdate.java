package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: StateUpdate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", "", "Companion", "Set", "Unsupported", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate$Set;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate$Unsupported;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable(with = StateUpdateSerializer.class)
public interface StateUpdate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<StateUpdate> serializer() {
            return StateUpdateSerializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate$Set;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateValue;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Set implements StateUpdate {
        private final String key;
        private final StateUpdateValue value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            return Intrinsics.areEqual(this.key, set.key) && Intrinsics.areEqual(this.value, set.value);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Set(key=" + this.key + ", value=" + this.value + ')';
        }

        public Set(String key, StateUpdateValue value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.key = key;
            this.value = value;
        }

        public final /* synthetic */ String getKey() {
            return this.key;
        }

        public final /* synthetic */ StateUpdateValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: StateUpdate.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate$Unsupported;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Unsupported implements StateUpdate {
        public static final Unsupported INSTANCE = new Unsupported();

        private Unsupported() {
        }
    }
}
