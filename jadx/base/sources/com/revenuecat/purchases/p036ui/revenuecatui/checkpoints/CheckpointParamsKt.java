package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointParams.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, m1599d2 = {"asRulesDimensionValue", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "getAsRulesDimensionValue$annotations", "(Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;)V", "getAsRulesDimensionValue", "(Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;)Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "CheckpointParams", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;", "block", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams$Builder;", "", "Lkotlin/ExtensionFunctionType;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointParamsKt {
    public static /* synthetic */ void getAsRulesDimensionValue$annotations(CustomVariableValue customVariableValue) {
    }

    public static final /* synthetic */ CheckpointParams CheckpointParams(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CheckpointParams.Builder builder = new CheckpointParams.Builder();
        block.invoke(builder);
        return builder.build();
    }

    public static final RulesDimensionValue getAsRulesDimensionValue(CustomVariableValue customVariableValue) {
        Intrinsics.checkNotNullParameter(customVariableValue, "<this>");
        return (RulesDimensionValue) customVariableValue.map$revenuecatui_defaultsRelease(new Function1<String, RulesDimensionValue>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointParamsKt$asRulesDimensionValue$1
            @Override // kotlin.jvm.functions.Function1
            public final RulesDimensionValue invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new RulesDimensionValue.StringValue(it);
            }
        }, new Function1<Double, RulesDimensionValue>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointParamsKt$asRulesDimensionValue$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ RulesDimensionValue invoke(Double d) {
                return invoke(d.doubleValue());
            }

            public final RulesDimensionValue invoke(double d) {
                return new RulesDimensionValue.DoubleValue(d);
            }
        }, new Function1<Boolean, RulesDimensionValue>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointParamsKt$asRulesDimensionValue$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ RulesDimensionValue invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final RulesDimensionValue invoke(boolean z) {
                return new RulesDimensionValue.BoolValue(z);
            }
        });
    }
}
