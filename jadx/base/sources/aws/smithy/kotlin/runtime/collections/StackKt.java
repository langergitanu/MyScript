package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Stack.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002H\u0007¢\u0006\u0004\b\t\u0010\b\u001a)\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002H\u0007¢\u0006\u0004\b\n\u0010\b\u001a+\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\b\u001a3\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\f\u0010\r*\"\b\u0007\u0010\u000f\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0002\b\u000e¨\u0006\u0010"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Laws/smithy/kotlin/runtime/collections/ListStack;", "item", "", "push", "(Ljava/util/List;Ljava/lang/Object;)Z", "pop", "(Ljava/util/List;)Ljava/lang/Object;", "popOrNull", "top", "topOrNull", "replaceTop", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/InternalApi;", "ListStack", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StackKt {
    @InternalApi
    public static /* synthetic */ void ListStack$annotations() {
    }

    @InternalApi
    public static final <T> boolean push(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.add(t);
    }

    @InternalApi
    public static final <T> T pop(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) CollectionsKt.removeLast(list);
    }

    @InternalApi
    public static final <T> T popOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) CollectionsKt.removeLastOrNull(list);
    }

    @InternalApi
    public static final <T> T top(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(list.size() - 1);
    }

    @InternalApi
    public static final <T> T topOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) top(list);
    }

    @InternalApi
    public static final <T> T replaceTop(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        T t2 = (T) popOrNull(list);
        push(list, t);
        return t2;
    }
}
