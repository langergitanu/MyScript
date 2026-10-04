package aws.smithy.kotlin.runtime.client.endpoints.functions;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.HostKt;
import aws.smithy.kotlin.runtime.net.TextKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.revenuecat.purchases.common.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, m1599d2 = {"substring", "", "value", TtmlNode.START, "", "stop", "reverse", "", "isValidHostLabel", "allowSubdomains", "uriEncode", "parseUrl", "Laws/smithy/kotlin/runtime/client/endpoints/functions/Url;", "smithy-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FunctionsKt {
    @InternalApi
    public static final String substring(String str, int i, int i2, boolean z) {
        if (str == null || i >= i2 || i2 > str.length()) {
            return null;
        }
        if (z) {
            return StringsKt.substring(str, RangesKt.until(str.length() - i2, str.length() - i));
        }
        return StringsKt.substring(str, RangesKt.until(i, i2));
    }

    @InternalApi
    public static final boolean isValidHostLabel(String str, boolean z) {
        if (str == null) {
            return false;
        }
        if (!z) {
            return TextKt.isValidHostname(str);
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
            return true;
        }
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            if (!TextKt.isValidHostname((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    @InternalApi
    public static final String uriEncode(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return PercentEncoding.INSTANCE.getSmithyLabel().encode(value);
    }

    @InternalApi
    public static final Url parseUrl(String str) {
        if (str != null) {
            try {
                aws.smithy.kotlin.runtime.net.url.Url url = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, str, null, 2, null);
                StringBuilder sb = new StringBuilder();
                sb.append(HostKt.toUrlString(url.getHost()));
                if (url.getPort() != url.getScheme().getDefaultPort()) {
                    sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + url.getPort());
                }
                String string = sb.toString();
                String string2 = url.getPath().toString();
                return new Url(url.getScheme().getProtocolName(), string, string2, aws.smithy.kotlin.runtime.text.TextKt.ensureSuffix(string2, DomExceptionUtils.SEPARATOR), url.getHost() instanceof Host.IpAddress);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
