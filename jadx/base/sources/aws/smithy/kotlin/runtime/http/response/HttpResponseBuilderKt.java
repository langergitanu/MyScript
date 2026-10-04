package aws.smithy.kotlin.runtime.http.response;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpResponseBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m1599d2 = {"immutableView", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;", "allowToBuilder", "", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpResponseBuilderKt {
    public static /* synthetic */ HttpResponse immutableView$default(HttpResponseBuilder httpResponseBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return immutableView(httpResponseBuilder, z);
    }

    @InternalApi
    public static final HttpResponse immutableView(HttpResponseBuilder httpResponseBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(httpResponseBuilder, "<this>");
        return new HttpResponseBuilderView(httpResponseBuilder, z);
    }
}
