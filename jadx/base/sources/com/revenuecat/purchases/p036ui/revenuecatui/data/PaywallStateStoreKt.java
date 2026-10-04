package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.paywalls.components.common.StateDeclaration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: PaywallStateStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, m1599d2 = {"matchesDeclaredType", "", "Lkotlinx/serialization/json/JsonPrimitive;", "declaredType", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration$ValueType;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallStateStoreKt {

    /* JADX INFO: compiled from: PaywallStateStore.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateDeclaration.ValueType.values().length];
            try {
                iArr[StateDeclaration.ValueType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StateDeclaration.ValueType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StateDeclaration.ValueType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StateDeclaration.ValueType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StateDeclaration.ValueType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean matchesDeclaredType(JsonPrimitive jsonPrimitive, StateDeclaration.ValueType valueType) {
        int i = WhenMappings.$EnumSwitchMapping$0[valueType.ordinal()];
        if (i == 1) {
            return (jsonPrimitive.getIsString() || JsonElementKt.getBooleanOrNull(jsonPrimitive) == null) ? false : true;
        }
        if (i == 2) {
            return jsonPrimitive.getIsString();
        }
        if (i != 3) {
            if (i == 4) {
                return (jsonPrimitive.getIsString() || JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) ? false : true;
            }
            if (i == 5) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!jsonPrimitive.getIsString()) {
            if (JsonElementKt.getLongOrNull(jsonPrimitive) == null) {
                Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                if (Intrinsics.areEqual(doubleOrNull != null ? Double.valueOf(doubleOrNull.doubleValue() % 1.0d) : null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                }
            }
            return true;
        }
        return false;
    }
}
