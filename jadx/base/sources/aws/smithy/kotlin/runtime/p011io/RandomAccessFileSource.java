package aws.smithy.kotlin.runtime.p011io;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: RandomAccessFileSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0018¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/RandomAccessFileSource;", "Lokio/Source;", "Ljava/io/File;", "fileObject", "", TtmlNode.START, "endInclusive", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/File;JJLokio/Timeout;)V", "", "toString", "()Ljava/lang/String;", "()Lokio/Timeout;", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "", "close", "()V", "Ljava/io/File;", "J", "Lokio/Timeout;", "Ljava/io/RandomAccessFile;", "file$delegate", "Lkotlin/Lazy;", "getFile", "()Ljava/io/RandomAccessFile;", "file", "position", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RandomAccessFileSource implements Source {
    private final long endInclusive;

    /* JADX INFO: renamed from: file$delegate, reason: from kotlin metadata */
    private final Lazy file;
    private final File fileObject;
    private long position;
    private final Timeout timeout;

    public RandomAccessFileSource(File fileObject, final long j, long j2, Timeout timeout) {
        Intrinsics.checkNotNullParameter(fileObject, "fileObject");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.fileObject = fileObject;
        this.endInclusive = j2;
        this.timeout = timeout;
        this.file = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.io.RandomAccessFileSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RandomAccessFileSource.file_delegate$lambda$0(this.f$0, j);
            }
        });
        this.position = j;
    }

    public /* synthetic */ RandomAccessFileSource(File file, long j, long j2, Timeout timeout, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, j, j2, (i & 8) != 0 ? Timeout.NONE : timeout);
    }

    private final RandomAccessFile getFile() {
        return (RandomAccessFile) this.file.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile file_delegate$lambda$0(RandomAccessFileSource randomAccessFileSource, long j) throws IOException {
        if (!randomAccessFileSource.fileObject.exists()) {
            throw new IllegalArgumentException(("cannot create SdkSource, file does not exist: " + randomAccessFileSource).toString());
        }
        if (!randomAccessFileSource.fileObject.isFile()) {
            throw new IllegalArgumentException(("cannot create a SdkSource from a directory: " + randomAccessFileSource).toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException(("start position should be >= 0, found " + j).toString());
        }
        long j2 = randomAccessFileSource.endInclusive;
        long j3 = j - 1;
        if (j2 < j3) {
            throw new IllegalArgumentException(("end index " + randomAccessFileSource.endInclusive + " must be greater than or equal to the start index minus one (" + j3 + ')').toString());
        }
        if (j2 > randomAccessFileSource.fileObject.length() - 1) {
            throw new IllegalArgumentException(("endInclusive should be less than or equal to the length of the file, was " + randomAccessFileSource.endInclusive).toString());
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(randomAccessFileSource.fileObject, "r");
        if (j > 0) {
            randomAccessFile.seek(j);
        }
        return randomAccessFile;
    }

    public String toString() {
        return "RandomAccessFileSource(" + this.fileObject + ')';
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: timeout, reason: from getter */
    public Timeout getTimeout() {
        return this.timeout;
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        FileChannel channel = getFile().getChannel();
        if (!channel.isOpen()) {
            throw new IllegalStateException("channel is closed".toString());
        }
        long j = this.position;
        long j2 = this.endInclusive;
        if (j > j2) {
            return -1L;
        }
        long jTransferTo = channel.transferTo(this.position, Math.min(byteCount, (j2 - j) + 1), sink);
        this.position += jTransferTo;
        return jTransferTo;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        getFile().close();
    }
}
