package com.revenuecat.purchases.common.remoteconfig;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: RemoteConfigManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, m1599d2 = {"<anonymous>", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$mergedBlobObject$resolved$1", m1609f = "RemoteConfigManager.kt", m1610i = {0}, m1611l = {765}, m1612m = "invokeSuspend", m1613n = {"destination$iv$iv"}, m1615s = {"L$0"})
final class RemoteConfigManager$mergedBlobObject$resolved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends byte[]>>, Object> {
    final /* synthetic */ List<String> $keys;
    final /* synthetic */ RemoteConfigTopic $topic;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ RemoteConfigManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigManager$mergedBlobObject$resolved$1(List<String> list, RemoteConfigManager remoteConfigManager, RemoteConfigTopic remoteConfigTopic, Continuation<? super RemoteConfigManager$mergedBlobObject$resolved$1> continuation) {
        super(2, continuation);
        this.$keys = list;
        this.this$0 = remoteConfigManager;
        this.$topic = remoteConfigTopic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteConfigManager$mergedBlobObject$resolved$1 remoteConfigManager$mergedBlobObject$resolved$1 = new RemoteConfigManager$mergedBlobObject$resolved$1(this.$keys, this.this$0, this.$topic, continuation);
        remoteConfigManager$mergedBlobObject$resolved$1.L$0 = obj;
        return remoteConfigManager$mergedBlobObject$resolved$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends byte[]>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<String, byte[]>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<String, byte[]>> continuation) {
        return ((RemoteConfigManager$mergedBlobObject$resolved$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b8 -> B:19:0x00b9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Map linkedHashMap;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List<String> list = this.$keys;
            RemoteConfigManager remoteConfigManager = this.this$0;
            RemoteConfigTopic remoteConfigTopic = this.$topic;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap2.put(obj2, BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteConfigManager$mergedBlobObject$resolved$1$1$1(remoteConfigManager, remoteConfigTopic, (String) obj2, null), 3, null));
            }
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
            it = linkedHashMap3.entrySet().iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object key = this.L$3;
            linkedHashMap = (Map) this.L$2;
            it = (Iterator) this.L$1;
            Map map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap.put(key, (byte[]) obj);
            linkedHashMap = map;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                key = entry.getKey();
                Deferred deferred = (Deferred) entry.getValue();
                this.L$0 = linkedHashMap;
                this.L$1 = it;
                this.L$2 = linkedHashMap;
                this.L$3 = key;
                this.label = 1;
                obj = deferred.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = linkedHashMap;
                linkedHashMap.put(key, (byte[]) obj);
                linkedHashMap = map;
                if (it.hasNext()) {
                    return linkedHashMap;
                }
            }
        }
    }
}
