package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/ListSerializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "endList", "", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ListSerializer extends PrimitiveSerializer {
    void endList();
}
