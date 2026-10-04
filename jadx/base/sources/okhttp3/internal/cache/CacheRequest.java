package okhttp3.internal.cache;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;

/* JADX INFO: compiled from: CacheRequest.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lokhttp3/internal/cache/CacheRequest;", "", TtmlNode.TAG_BODY, "Lokio/Sink;", "abort", "", "okhttp"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
