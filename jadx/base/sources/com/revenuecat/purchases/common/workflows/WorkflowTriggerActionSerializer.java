package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerActionSerializer;", "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowTriggerActionSerializer extends SealedDeserializerWithDefault<WorkflowTriggerAction> {
    public static final WorkflowTriggerActionSerializer INSTANCE = new WorkflowTriggerActionSerializer();

    private WorkflowTriggerActionSerializer() {
        super("WorkflowTriggerAction", MapsKt.mapOf(TuplesKt.m1606to("step", new Function0<KSerializer<WorkflowTriggerAction.Step>>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerActionSerializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<WorkflowTriggerAction.Step> invoke() {
                return WorkflowTriggerAction.Step.INSTANCE.serializer();
            }
        })), new Function1<String, WorkflowTriggerAction>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerActionSerializer.2
            @Override // kotlin.jvm.functions.Function1
            public final WorkflowTriggerAction invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return WorkflowTriggerAction.Unknown.INSTANCE;
            }
        }, null, 8, null);
    }
}
