package aws.smithy.kotlin.runtime.http.interceptors;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: RequestCompressionInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lkotlin/ranges/IntRange;", "VALID_COMPRESSION_THRESHOLD_BYTES_RANGE", "Lkotlin/ranges/IntRange;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RequestCompressionInterceptorKt {
    private static final IntRange VALID_COMPRESSION_THRESHOLD_BYTES_RANGE = new IntRange(0, MediaHttpUploader.DEFAULT_CHUNK_SIZE);
}
