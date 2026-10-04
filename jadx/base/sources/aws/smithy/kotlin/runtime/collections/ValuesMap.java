package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValuesMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\r0\nH&¢\u0006\u0004\b\u000e\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H¦\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0013J/\u0010\u0017\u001a\u00020\u00152\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH&¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001dÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/ValuesMap;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "name", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/Object;)Z", "Lkotlin/Function2;", "", TtmlNode.TAG_BODY, "forEach", "(Lkotlin/jvm/functions/Function2;)V", "isEmpty", "()Z", "getCaseInsensitiveName", "caseInsensitiveName", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ValuesMap<T> {
    boolean contains(String name);

    Set<Map.Entry<String, List<T>>> entries();

    List<T> getAll(String name);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();

    /* JADX INFO: compiled from: ValuesMap.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T get(ValuesMap<T> valuesMap, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (T) ValuesMap.super.get(name);
        }

        @Deprecated
        public static <T> boolean contains(ValuesMap<T> valuesMap, String name, T t) {
            Intrinsics.checkNotNullParameter(name, "name");
            return ValuesMap.super.contains(name, t);
        }

        @Deprecated
        public static <T> void forEach(ValuesMap<T> valuesMap, Function2<? super String, ? super List<? extends T>, Unit> body) {
            Intrinsics.checkNotNullParameter(body, "body");
            ValuesMap.super.forEach(body);
        }
    }

    default T get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> all = getAll(name);
        if (all != null) {
            return (T) CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    default boolean contains(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> all = getAll(name);
        if (all != null) {
            return all.contains(value);
        }
        return false;
    }

    default void forEach(Function2<? super String, ? super List<? extends T>, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Iterator<T> it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }
}
