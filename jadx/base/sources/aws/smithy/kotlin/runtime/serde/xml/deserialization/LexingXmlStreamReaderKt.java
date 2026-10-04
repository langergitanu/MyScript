package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: LexingXmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"getOrNull", ExifInterface.GPS_DIRECTION_TRUE, "", FirebaseAnalytics.Param.INDEX, "", "(Ljava/util/List;I)Ljava/lang/Object;", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LexingXmlStreamReaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getOrNull(List<? extends T> list, int i) {
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }
}
