package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Serializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "beginStruct", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "beginList", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "beginMap", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "toByteArray", "", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Serializer extends PrimitiveSerializer {
    ListSerializer beginList(SdkFieldDescriptor descriptor);

    MapSerializer beginMap(SdkFieldDescriptor descriptor);

    StructSerializer beginStruct(SdkFieldDescriptor descriptor);

    byte[] toByteArray();
}
