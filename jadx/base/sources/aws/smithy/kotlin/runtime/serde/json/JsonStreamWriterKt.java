package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: JsonStreamWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m1599d2 = {"jsonStreamWriter", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamWriter;", "pretty", "", "serde-json"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonStreamWriterKt {
    @InternalApi
    public static final JsonStreamWriter jsonStreamWriter(boolean z) {
        return new JsonEncoder(z);
    }

    public static /* synthetic */ JsonStreamWriter jsonStreamWriter$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return jsonStreamWriter(z);
    }
}
