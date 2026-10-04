package aws.smithy.kotlin.runtime.http.engine.internal;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedHttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "manage", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManagedHttpClientEngineKt {
    @InternalApi
    public static final HttpClientEngine manage(HttpClientEngine httpClientEngine) {
        Intrinsics.checkNotNullParameter(httpClientEngine, "<this>");
        return (!(httpClientEngine instanceof ManagedHttpClientEngine) && (httpClientEngine instanceof CloseableHttpClientEngine)) ? new ManagedHttpClientEngine((CloseableHttpClientEngine) httpClientEngine) : httpClientEngine;
    }
}
