package kotlinx.datetime.serializers;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;

/* JADX INFO: compiled from: DateTimeUnitSerializers.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"throwUnknownIndexException", "", FirebaseAnalytics.Param.INDEX, "", "kotlinx-datetime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateTimeUnitSerializersKt {
    public static final Void throwUnknownIndexException(int i) {
        throw new SerializationException("An unknown field for index " + i);
    }
}
