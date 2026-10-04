package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMapImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u00020\u0002H\u0096\u0080\u0004¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HeadersImpl;", "Laws/smithy/kotlin/runtime/collections/ValuesMapImpl;", "", "Laws/smithy/kotlin/runtime/http/Headers;", "values", "", "", "<init>", "(Ljava/util/Map;)V", "toString", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class HeadersImpl extends ValuesMapImpl<String> implements Headers {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadersImpl(Map<String, ? extends List<String>> values) {
        super(true, values);
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public String toString() {
        return "Headers " + entries();
    }
}
