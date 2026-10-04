package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.revenuecat.purchases.paywalls.components.common.StateDeclaration;
import com.revenuecat.purchases.paywalls.components.common.StateUpdate;
import com.revenuecat.purchases.paywalls.components.common.StateUpdateValue;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: PaywallStateStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J \u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00102\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "", "declarations", "", "", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration;", "(Ljava/util/Map;)V", "currentValues", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/runtime/MutableState;", "Lkotlinx/serialization/json/JsonPrimitive;", "declaredDefaults", "Ljava/util/concurrent/ConcurrentHashMap;", "declaredTypes", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "applyUpdates", "", "updates", "", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", "payload", "currentValueOrDefault", SubscriberAttributeKt.JSON_NAME_KEY, "registerDeclarations", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallStateStore {
    public static final int $stable = 0;
    private final SnapshotStateMap<String, MutableState<JsonPrimitive>> currentValues;
    private final ConcurrentHashMap<String, JsonPrimitive> declaredDefaults;
    private final ConcurrentHashMap<String, StateDeclaration.ValueType> declaredTypes;

    public PaywallStateStore(Map<String, StateDeclaration> declarations) {
        Intrinsics.checkNotNullParameter(declarations, "declarations");
        this.declaredTypes = new ConcurrentHashMap<>();
        this.declaredDefaults = new ConcurrentHashMap<>();
        this.currentValues = SnapshotStateKt.mutableStateMapOf();
        registerDeclarations(declarations);
    }

    public final JsonPrimitive currentValueOrDefault(String key) {
        JsonPrimitive value;
        Intrinsics.checkNotNullParameter(key, "key");
        MutableState<JsonPrimitive> mutableState = this.currentValues.get(key);
        return (mutableState == null || (value = mutableState.getValue()) == null) ? this.declaredDefaults.get(key) : value;
    }

    public static /* synthetic */ void applyUpdates$default(PaywallStateStore paywallStateStore, List list, JsonPrimitive jsonPrimitive, int i, Object obj) {
        if ((i & 2) != 0) {
            jsonPrimitive = null;
        }
        paywallStateStore.applyUpdates(list, jsonPrimitive);
    }

    public final synchronized void applyUpdates(List<? extends StateUpdate> updates, JsonPrimitive payload) {
        JsonPrimitive value;
        MutableState<JsonPrimitive> mutableState;
        Intrinsics.checkNotNullParameter(updates, "updates");
        for (StateUpdate stateUpdate : updates) {
            StateUpdate.Set set = stateUpdate instanceof StateUpdate.Set ? (StateUpdate.Set) stateUpdate : null;
            if (set != null) {
                StateUpdateValue value2 = set.getValue();
                if (value2 instanceof StateUpdateValue.Literal) {
                    value = ((StateUpdateValue.Literal) value2).getValue();
                } else {
                    if (!Intrinsics.areEqual(value2, StateUpdateValue.PayloadReference.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (payload != null) {
                        value = payload;
                    }
                }
                StateDeclaration.ValueType valueType = this.declaredTypes.get(set.getKey());
                if (valueType != null) {
                    Intrinsics.checkNotNullExpressionValue(valueType, "declaredTypes[setUpdate.key] ?: return@forEach");
                    if (PaywallStateStoreKt.matchesDeclaredType(value, valueType) && (mutableState = this.currentValues.get(set.getKey())) != null) {
                        mutableState.setValue(value);
                    }
                }
            }
        }
    }

    public final synchronized void registerDeclarations(Map<String, StateDeclaration> declarations) {
        Intrinsics.checkNotNullParameter(declarations, "declarations");
        for (Map.Entry<String, StateDeclaration> entry : declarations.entrySet()) {
            String key = entry.getKey();
            StateDeclaration value = entry.getValue();
            if (!this.declaredDefaults.containsKey(key)) {
                this.declaredTypes.put(key, value.getType());
                this.declaredDefaults.put(key, value.getDefaultValue());
                this.currentValues.put(key, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value.getDefaultValue(), null, 2, null));
            }
        }
    }
}
