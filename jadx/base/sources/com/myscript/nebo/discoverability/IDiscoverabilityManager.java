package com.myscript.nebo.discoverability;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: IDiscoverabilityManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H¦@¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/IDiscoverabilityManager;", "", "extraMetrics", "Lcom/myscript/nebo/discoverability/IExtraMetrics;", "<init>", "(Lcom/myscript/nebo/discoverability/IExtraMetrics;)V", "nextDiscovery", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "getNextDiscovery", "()Lkotlinx/coroutines/flow/StateFlow;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discover", "feature", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDiscoverable", "updateDiscoverableFeaturesList", "features", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class IDiscoverabilityManager {
    public static final int $stable = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public IDiscoverabilityManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract Object discover(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation);

    public abstract StateFlow<IDiscoverableFeature> getNextDiscovery();

    public abstract Object init(Continuation<? super Unit> continuation);

    public abstract Object setDiscoverable(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation);

    public abstract Object updateDiscoverableFeaturesList(List<? extends IDiscoverableFeature> list, Continuation<? super Unit> continuation);

    public IDiscoverabilityManager(IExtraMetrics iExtraMetrics) {
    }

    public /* synthetic */ IDiscoverabilityManager(IExtraMetrics iExtraMetrics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iExtraMetrics);
    }
}
