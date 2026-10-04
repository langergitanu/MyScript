package com.revenuecat.purchases.checkpoints;

import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CheckpointWorkflowResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolver;", "", "resolve", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", Keys.IDENTIFIER, "", "customVariables", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface CheckpointWorkflowResolver {
    Object resolve(String str, Map<String, ? extends RulesDimensionValue> map, Continuation<? super CheckpointResolution> continuation);
}
