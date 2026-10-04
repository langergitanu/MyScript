package com.myscript.nebo.discoverability;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IFeatureUsageMetrics.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/IFeatureUsageMetrics;", "", "recordVariableDeclaration", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVariableDeclarationsCount", "", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IFeatureUsageMetrics {
    Object getVariableDeclarationsCount(Continuation<? super Integer> continuation);

    Object recordVariableDeclaration(Continuation<? super Unit> continuation);
}
