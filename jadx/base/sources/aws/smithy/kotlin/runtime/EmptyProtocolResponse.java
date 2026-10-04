package aws.smithy.kotlin.runtime;

import kotlin.Metadata;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/EmptyProtocolResponse;", "Laws/smithy/kotlin/runtime/ProtocolResponse;", "<init>", "()V", "", "summary", "Ljava/lang/String;", "getSummary", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EmptyProtocolResponse implements ProtocolResponse {
    public static final EmptyProtocolResponse INSTANCE = new EmptyProtocolResponse();
    private static final String summary = "(empty response)";

    private EmptyProtocolResponse() {
    }

    @Override // aws.smithy.kotlin.runtime.ProtocolResponse
    public String getSummary() {
        return summary;
    }
}
