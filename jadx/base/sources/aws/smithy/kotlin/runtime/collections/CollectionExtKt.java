package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: CollectionExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "dest", "x", "createOrAppend", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionExtKt {
    public static final <T> List<T> createOrAppend(List<? extends T> list, T t) {
        if (list == null) {
            return CollectionsKt.listOf(t);
        }
        List<T> mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(t);
        return mutableList;
    }
}
