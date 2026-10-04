package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import okio.Okio;

/* JADX INFO: compiled from: SdkSink.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkSink;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "flush", "()V", "close", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkSink extends Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close() throws IOException;

    void flush() throws IOException;

    void write(SdkBuffer source, long byteCount) throws IOException;

    /* JADX INFO: compiled from: SdkSink.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkSink$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/SdkSink;", "blackhole", "()Laws/smithy/kotlin/runtime/io/SdkSink;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SdkSink blackhole() {
            return ConvertKt.toSdk(Okio.blackhole());
        }
    }
}
