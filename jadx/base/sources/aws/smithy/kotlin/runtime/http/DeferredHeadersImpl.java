package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMapImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: DeferredHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004B'\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/DeferredHeadersImpl;", "Laws/smithy/kotlin/runtime/collections/ValuesMapImpl;", "Lkotlinx/coroutines/Deferred;", "", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "values", "", "", "<init>", "(Ljava/util/Map;)V", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class DeferredHeadersImpl extends ValuesMapImpl<Deferred<? extends String>> implements DeferredHeaders {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredHeadersImpl(Map<String, ? extends List<? extends Deferred<String>>> values) {
        super(true, values);
        Intrinsics.checkNotNullParameter(values, "values");
    }
}
