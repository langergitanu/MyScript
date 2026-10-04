package com.revenuecat.purchases.common.checkpoints;

import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* JADX INFO: compiled from: CheckpointResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m1599d2 = {"checkpointRuleListSerializer", "Lkotlinx/serialization/KSerializer;", "", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointResponseKt {
    private static final KSerializer<List<CheckpointRule>> checkpointRuleListSerializer = BuiltinSerializersKt.ListSerializer(CheckpointRule.INSTANCE.serializer());
}
