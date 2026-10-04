package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {0}, m1611l = {368}, m1612m = "writeData$datastore_core", m1613n = {"newVersion"}, m1615s = {"L$0"}, m1616v = 1)
final class DataStoreImpl$writeData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeData$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$writeData$1> continuation) {
        super(continuation);
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeData$datastore_core(null, false, this);
    }
}
