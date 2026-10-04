package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: JsonStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;", "", "nextToken", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "skipNext", "", "peek", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface JsonStreamReader {
    JsonToken nextToken();

    JsonToken peek();

    void skipNext();
}
