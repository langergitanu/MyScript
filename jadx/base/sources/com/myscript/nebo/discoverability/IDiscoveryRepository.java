package com.myscript.nebo.discoverability;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IDiscoveryRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/IDiscoveryRepository;", "", "isDiscovered", "", "feature", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discover", "", "isDiscoverable", "defaultValue", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDiscoverable", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IDiscoveryRepository {
    Object clear(Continuation<? super Unit> continuation);

    Object discover(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation);

    Object isDiscoverable(IDiscoverableFeature iDiscoverableFeature, boolean z, Continuation<? super Boolean> continuation);

    Object isDiscovered(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Boolean> continuation);

    Object setDiscoverable(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: IDiscoveryRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object isDiscoverable$default(IDiscoveryRepository iDiscoveryRepository, IDiscoverableFeature iDiscoverableFeature, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isDiscoverable");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return iDiscoveryRepository.isDiscoverable(iDiscoverableFeature, z, continuation);
    }
}
