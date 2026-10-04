package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.JsonTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: WorkflowJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowJsonParser;", "", "()V", "parsePublishedWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "payload", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowJsonParser {
    public static final WorkflowJsonParser INSTANCE = new WorkflowJsonParser();

    private WorkflowJsonParser() {
    }

    public final PublishedWorkflow parsePublishedWorkflow(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json json = JsonTools.INSTANCE.getJson();
        json.getSerializersModule();
        return (PublishedWorkflow) json.decodeFromString(PublishedWorkflow.INSTANCE.serializer(), payload);
    }
}
