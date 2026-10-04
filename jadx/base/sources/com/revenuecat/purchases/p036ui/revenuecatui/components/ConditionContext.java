package com.revenuecat.purchases.p036ui.revenuecatui.components;

import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: PresentedPartial.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0002\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/ConditionContext;", "", "selectedPackageId", "", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateReader", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonPrimitive;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getCustomVariables", "()Ljava/util/Map;", "getSelectedPackageId", "()Ljava/lang/String;", "getStateReader", "()Lkotlin/jvm/functions/Function1;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ConditionContext {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final String selectedPackageId;
    private final Function1<String, JsonPrimitive> stateReader;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionContext(String str, Map<String, ? extends CustomVariableValue> customVariables, Function1<? super String, ? extends JsonPrimitive> stateReader) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(stateReader, "stateReader");
        this.selectedPackageId = str;
        this.customVariables = customVariables;
        this.stateReader = stateReader;
    }

    public final String getSelectedPackageId() {
        return this.selectedPackageId;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public /* synthetic */ ConditionContext(String str, Map map, C75101 c75101, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext.1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : c75101);
    }

    public final Function1<String, JsonPrimitive> getStateReader() {
        return this.stateReader;
    }
}
