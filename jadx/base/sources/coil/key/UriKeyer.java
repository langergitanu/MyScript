package coil.key;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: UriKeyer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcoil/key/UriKeyer;", "Lcoil/key/Keyer;", "Landroid/net/Uri;", "<init>", "()V", SubscriberAttributeKt.JSON_NAME_KEY, "", "data", "options", "Lcoil/request/Options;", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class UriKeyer implements Keyer<Uri> {
    @Override // coil.key.Keyer
    public String key(Uri data, Options options) {
        if (Intrinsics.areEqual(data.getScheme(), "android.resource")) {
            return new StringBuilder().append(data).append(Soundex.SILENT_MARKER).append(Utils.getNightMode(options.getContext().getResources().getConfiguration())).toString();
        }
        return data.toString();
    }
}
