package aws.smithy.kotlin.runtime.content;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.p011io.JavaIOKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileContent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/FileContent;", "Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "Ljava/io/File;", "file", "", TtmlNode.START, "endInclusive", "<init>", "(Ljava/io/File;JJ)V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "readFrom", "()Laws/smithy/kotlin/runtime/io/SdkSource;", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "J", "getStart", "()J", "getEndInclusive", "", "isOneShot", "Z", "()Z", "getContentLength", "()Ljava/lang/Long;", "contentLength", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FileContent extends ByteStream.SourceStream {
    private final long endInclusive;
    private final File file;
    private final boolean isOneShot;
    private final long start;

    public FileContent(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.start = j;
        this.endInclusive = j2;
    }

    public final File getFile() {
        return this.file;
    }

    public final long getStart() {
        return this.start;
    }

    public /* synthetic */ FileContent(File file, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? file.length() - 1 : j2);
    }

    public final long getEndInclusive() {
        return this.endInclusive;
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream
    /* JADX INFO: renamed from: isOneShot, reason: from getter */
    public boolean getIsOneShot() {
        return this.isOneShot;
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream
    public Long getContentLength() {
        return Long.valueOf((this.endInclusive - this.start) + 1);
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream.SourceStream
    public SdkSource readFrom() {
        return JavaIOKt.source(this.file, this.start, this.endInclusive);
    }
}
