package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CurrentDataProviderStore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, m1599d2 = {"Landroidx/datastore/core/CurrentDataProviderStore;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/DataStore;", "currentData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface CurrentDataProviderStore<T> extends DataStore<T> {
    Object currentData(Continuation<? super T> continuation);
}
