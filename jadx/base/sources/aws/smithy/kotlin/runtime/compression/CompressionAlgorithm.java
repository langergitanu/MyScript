package aws.smithy.kotlin.runtime.compression;

import aws.smithy.kotlin.runtime.content.ByteStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: CompressionAlgorithm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/compression/CompressionAlgorithm;", "", "Laws/smithy/kotlin/runtime/content/ByteStream;", "stream", "compress", "(Laws/smithy/kotlin/runtime/content/ByteStream;)Laws/smithy/kotlin/runtime/content/ByteStream;", "", "getId", "()Ljava/lang/String;", "id", "getContentEncoding", "contentEncoding", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CompressionAlgorithm {
    ByteStream compress(ByteStream stream);

    String getContentEncoding();

    String getId();
}
