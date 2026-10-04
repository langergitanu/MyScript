package aws.smithy.kotlin.runtime.p011io;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import okio.Okio;

/* JADX INFO: compiled from: JavaIO.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\t\u001a%\u0010\u0004\u001a\u00020\u0003*\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\n¢\u0006\u0004\b\u000e\u0010\u0010\u001a\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0011¢\u0006\u0004\b\u0004\u0010\u0012\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"Ljava/nio/file/Path;", "Lkotlin/ranges/LongRange;", "range", "Laws/smithy/kotlin/runtime/io/SdkSource;", FirebaseAnalytics.Param.SOURCE, "(Ljava/nio/file/Path;Lkotlin/ranges/LongRange;)Laws/smithy/kotlin/runtime/io/SdkSource;", "", TtmlNode.START, "endInclusive", "(Ljava/nio/file/Path;JJ)Laws/smithy/kotlin/runtime/io/SdkSource;", "Ljava/io/File;", "(Ljava/io/File;JJ)Laws/smithy/kotlin/runtime/io/SdkSource;", "(Ljava/io/File;Lkotlin/ranges/LongRange;)Laws/smithy/kotlin/runtime/io/SdkSource;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "(Ljava/nio/file/Path;)Laws/smithy/kotlin/runtime/io/SdkSink;", "(Ljava/io/File;)Laws/smithy/kotlin/runtime/io/SdkSink;", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Laws/smithy/kotlin/runtime/io/SdkSource;", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;)Laws/smithy/kotlin/runtime/io/SdkSink;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JavaIOKt {
    public static final SdkSource source(Path path, LongRange range) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return source(path, range.getFirst(), range.getLast());
    }

    public static /* synthetic */ SdkSource source$default(Path path, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = -1;
        }
        return source(path, j, j2);
    }

    public static final SdkSource source(Path path, long j, long j2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        long j3 = j - 1;
        if (j2 < j3) {
            throw new IllegalArgumentException(("end index " + j2 + " must be greater or equal to start index minus one (" + j3 + ')').toString());
        }
        File file = path.toFile();
        if (j2 == -1) {
            j2 = file.length() - 1;
        }
        Intrinsics.checkNotNull(file);
        return source(file, j, j2);
    }

    public static final SdkSource source(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ConvertKt.toSdk(new RandomAccessFileSource(file, j, j2, null, 8, null));
    }

    public static /* synthetic */ SdkSource source$default(File file, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = file.length() - 1;
        }
        return source(file, j, j2);
    }

    public static final SdkSource source(File file, LongRange range) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return source(file, range.getFirst(), range.getLast());
    }

    public static final SdkSink sink(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile(...)");
        return sink(file);
    }

    public static final SdkSink sink(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ConvertKt.toSdk(Okio.sink(file, false));
    }

    public static final SdkSource source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return ConvertKt.toSdk(Okio.source(inputStream));
    }

    public static final SdkSink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return ConvertKt.toSdk(Okio.sink(outputStream));
    }
}
