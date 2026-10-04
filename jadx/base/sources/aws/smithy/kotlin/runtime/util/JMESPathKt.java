package aws.smithy.kotlin.runtime.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: JMESPath.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0001\u001a\u00020\u0003*\u00020\u0003H\u0007¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0005*\u00020\u0005H\u0007¢\u0006\u0004\b\u0001\u0010\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0007*\u00020\u0007H\u0007¢\u0006\u0004\b\u0001\u0010\b\u001a\u0013\u0010\u0001\u001a\u00020\t*\u00020\tH\u0007¢\u0006\u0004\b\u0001\u0010\n\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\t*\u00020\u000bH\u0007¢\u0006\u0004\b\u0001\u0010\f\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u000e*\u00020\rH\u0007¢\u0006\u0004\b\u0001\u0010\u000f\u001a\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u000b*\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u0017H\u0087\b¢\u0006\u0004\b\u001b\u0010\u0019\u001a(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0087\b¢\u0006\u0004\b\u0018\u0010\u001d\u001a.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u001cH\u0087\b¢\u0006\u0004\b\u001b\u0010\u001d\"*\u0010\"\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, m1599d2 = {"", "toNumber", "(S)S", "", "(I)I", "", "(J)J", "", "(F)F", "", "(D)D", "", "(Ljava/lang/String;)Ljava/lang/Double;", "", "", "(Ljava/lang/Object;)Ljava/lang/Void;", "value", "", "truthiness", "(Ljava/lang/Object;)Z", "type", "(Ljava/lang/Object;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "", "noOpUnnestedCollection", "(Ljava/util/Collection;)Ljava/util/Collection;", "flattenIfPossible", "flattenNestedCollection", "", "(Ljava/util/List;)Ljava/util/List;", "getLength", "(Ljava/util/Collection;)I", "getLength$annotations", "(Ljava/util/Collection;)V", "length", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JMESPathKt {
    @InternalApi
    public static /* synthetic */ void getLength$annotations(Collection collection) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final /* synthetic */ <T> Collection<T> noOpUnnestedCollection(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final /* synthetic */ <T> List<T> noOpUnnestedCollection(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list;
    }

    @InternalApi
    public static final double toNumber(double d) {
        return d;
    }

    @InternalApi
    public static final float toNumber(float f) {
        return f;
    }

    @InternalApi
    public static final int toNumber(int i) {
        return i;
    }

    @InternalApi
    public static final long toNumber(long j) {
        return j;
    }

    @InternalApi
    public static final Void toNumber(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return null;
    }

    @InternalApi
    public static final short toNumber(short s) {
        return s;
    }

    @InternalApi
    public static final Double toNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toDoubleOrNull(str);
    }

    @InternalApi
    public static final boolean truthiness(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : obj instanceof Collection ? !((Collection) obj).isEmpty() : obj instanceof Map ? !((Map) obj).isEmpty() : obj instanceof String ? ((CharSequence) obj).length() > 0 : obj != null;
    }

    public static final <T> int getLength(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.size();
    }

    @InternalApi
    public static final String type(Object obj) {
        if (obj instanceof String) {
            return TypedValues.Custom.S_STRING;
        }
        if (obj instanceof Boolean) {
            return TypedValues.Custom.S_BOOLEAN;
        }
        if ((obj instanceof List) || (obj instanceof Object[])) {
            return "array";
        }
        if (obj instanceof Number) {
            return "number";
        }
        if (obj != null) {
            return "object";
        }
        return AbstractJsonLexerKt.NULL;
    }

    @InternalApi
    public static final /* synthetic */ <T> Collection<T> flattenNestedCollection(Collection<? extends Collection<? extends T>> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return CollectionsKt.flatten(collection);
    }

    @InternalApi
    public static final /* synthetic */ <T> List<T> flattenNestedCollection(List<? extends List<? extends T>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.flatten(list);
    }
}
