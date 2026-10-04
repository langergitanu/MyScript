package aws.smithy.kotlin.runtime.content;

import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.p011io.BufferedSourceAdapter;
import aws.smithy.kotlin.runtime.p011io.JavaIOKt;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelJVMKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSink;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.p039io.CloseableKt;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: ByteStreamJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\t\u001a\u00020\u0003*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\t\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\r\u001a%\u0010\t\u001a\u00020\u0003*\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000f\u001a\u0019\u0010\t\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0018\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a%\u0010\u001f\u001a\u00020\u001e*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001f\u0010 \u001a\u001d\u0010\t\u001a\u00020\u001e*\u00020\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010!\u001a\u001c\u0010$\u001a\u00020\u0006*\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010&\u001a\u00020\u0006*\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b&\u0010%\u001a\u001c\u0010\u0015\u001a\u00020\u0006*\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u0015\u0010'¨\u0006("}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream$Companion;", "Ljava/io/File;", "file", "Laws/smithy/kotlin/runtime/content/ByteStream;", "fromFile", "(Laws/smithy/kotlin/runtime/content/ByteStream$Companion;Ljava/io/File;)Laws/smithy/kotlin/runtime/content/ByteStream;", "", TtmlNode.START, "endInclusive", "asByteStream", "(Ljava/io/File;JJ)Laws/smithy/kotlin/runtime/content/ByteStream;", "Lkotlin/ranges/LongRange;", "range", "(Ljava/io/File;Lkotlin/ranges/LongRange;)Laws/smithy/kotlin/runtime/content/ByteStream;", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;JJ)Laws/smithy/kotlin/runtime/content/ByteStream;", "(Ljava/nio/file/Path;Lkotlin/ranges/LongRange;)Laws/smithy/kotlin/runtime/content/ByteStream;", "writeToFile", "(Laws/smithy/kotlin/runtime/content/ByteStream;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "chan", "writeAll", "(Ljava/io/File;Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ClientCookie.PATH_ATTR, "(Laws/smithy/kotlin/runtime/content/ByteStream;Ljava/nio/file/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/InputStream;", "toInputStream", "(Laws/smithy/kotlin/runtime/content/ByteStream;)Ljava/io/InputStream;", "inputStream", "contentLength", "Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "fromInputStream", "(Laws/smithy/kotlin/runtime/content/ByteStream$Companion;Ljava/io/InputStream;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "(Ljava/io/InputStream;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "Ljava/io/OutputStream;", "outputStream", "writeToOutputStream", "(Laws/smithy/kotlin/runtime/content/ByteStream;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendToOutputStream", "(Ljava/io/OutputStream;Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ByteStreamJVMKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeAll$1 */
    /* JADX INFO: compiled from: ByteStreamJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamJVMKt", m1609f = "ByteStreamJVM.kt", m1610i = {0, 0, 0, 0}, m1611l = {83}, m1612m = "writeAll", m1613n = {"$this$writeAll", "chan", "it", "$i$a$-use-ByteStreamJVMKt$writeAll$2"}, m1614nl = {82}, m1615s = {"L$0", "L$1", "L$3", "I$0"}, m1616v = 2)
    static final class C36801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C36801(Continuation<? super C36801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteStreamJVMKt.writeAll((File) null, (SdkByteReadChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeAll$3 */
    /* JADX INFO: compiled from: ByteStreamJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamJVMKt", m1609f = "ByteStreamJVM.kt", m1610i = {0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_8_4}, m1612m = "writeAll", m1613n = {"$this$writeAll", "chan", "it", "$i$a$-use-ByteStreamJVMKt$writeAll$4"}, m1614nl = {PDFACompliance.e_PDFA1_8_3}, m1615s = {"L$0", "L$1", "L$3", "I$0"}, m1616v = 2)
    static final class C36813 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C36813(Continuation<? super C36813> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteStreamJVMKt.writeAll((OutputStream) null, (SdkByteReadChannel) null, this);
        }
    }

    public static final ByteStream fromFile(ByteStream.Companion companion, File file) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        return asByteStream$default(file, 0L, 0L, 3, (Object) null);
    }

    public static /* synthetic */ ByteStream asByteStream$default(File file, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = file.length() - 1;
        }
        return asByteStream(file, j, j2);
    }

    public static final ByteStream asByteStream(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("start index " + j + " cannot be negative").toString());
        }
        long j3 = j - 1;
        if (j2 < j3) {
            throw new IllegalArgumentException(("end index " + j2 + " must be greater than or equal to start index minus one (" + j3 + ')').toString());
        }
        long length = file.length();
        if (j2 >= length) {
            throw new IllegalArgumentException(("end index " + j2 + " must be less than file size " + length).toString());
        }
        return new FileContent(file, j, j2);
    }

    public static final ByteStream asByteStream(File file, LongRange range) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return asByteStream(file, range.getFirst(), range.getLast());
    }

    public static /* synthetic */ ByteStream asByteStream$default(Path path, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = -1;
        }
        return asByteStream(path, j, j2);
    }

    public static final ByteStream asByteStream(Path path, long j, long j2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException(("cannot create ByteStream, file does not exist: " + path).toString());
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException(("cannot create a ByteStream from a directory: " + path).toString());
        }
        if (j2 == -1) {
            j2 = file.length() - 1;
        }
        long j3 = j - 1;
        if (j2 < j3) {
            throw new IllegalArgumentException(("end index " + j2 + " must be greater or equal to start index minus one (" + j3 + ')').toString());
        }
        Intrinsics.checkNotNull(file);
        return asByteStream(file, j, j2);
    }

    public static final ByteStream asByteStream(Path path, LongRange range) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return asByteStream(path, range.getFirst(), range.getLast());
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeToFile$2 */
    /* JADX INFO: compiled from: ByteStreamJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeToFile$2", m1609f = "ByteStreamJVM.kt", m1610i = {0}, m1611l = {70}, m1612m = "invokeSuspend", m1613n = {"stream"}, m1614nl = {TsExtractor.TS_SYNC_BYTE}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ ByteStream $this_writeToFile;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36822(ByteStream byteStream, File file, Continuation<? super C36822> continuation) {
            super(2, continuation);
            this.$this_writeToFile = byteStream;
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36822(this.$this_writeToFile, this.$file, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C36822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SdkSource from;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ByteStream byteStream = this.$this_writeToFile;
            if (byteStream instanceof ByteStream.ChannelStream) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
                this.label = 1;
                Object objWriteAll = ByteStreamJVMKt.writeAll(this.$file, ((ByteStream.ChannelStream) byteStream).readFrom(), this);
                return objWriteAll == coroutine_suspended ? coroutine_suspended : objWriteAll;
            }
            if (byteStream instanceof ByteStream.Buffer) {
                from = SdkIoKt.source(((ByteStream.Buffer) byteStream).getAsBytes());
            } else {
                if (!(byteStream instanceof ByteStream.SourceStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                from = ((ByteStream.SourceStream) byteStream).readFrom();
            }
            SdkBufferedSink sdkBufferedSinkSink = JavaIOKt.sink(this.$file);
            try {
                sdkBufferedSinkSink = SdkIoKt.buffer(sdkBufferedSinkSink);
                try {
                    long jWriteAll = sdkBufferedSinkSink.writeAll(from);
                    CloseableKt.closeFinally(sdkBufferedSinkSink, null);
                    Long lBoxLong = Boxing.boxLong(jWriteAll);
                    CloseableKt.closeFinally(sdkBufferedSinkSink, null);
                    return lBoxLong;
                } finally {
                }
            } finally {
            }
        }
    }

    public static final Object writeToFile(ByteStream byteStream, File file, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C36822(byteStream, file, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeAll(File file, SdkByteReadChannel sdkByteReadChannel, Continuation<? super Long> continuation) {
        C36801 c36801;
        Closeable closeable;
        if (continuation instanceof C36801) {
            c36801 = (C36801) continuation;
            if ((c36801.label & Integer.MIN_VALUE) != 0) {
                c36801.label -= Integer.MIN_VALUE;
            } else {
                c36801 = new C36801(continuation);
            }
        }
        Object obj = c36801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SdkSink sdkSinkSink = JavaIOKt.sink(file);
            try {
                SdkSink sdkSink = sdkSinkSink;
                c36801.L$0 = SpillingKt.nullOutSpilledVariable(file);
                c36801.L$1 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
                c36801.L$2 = sdkSinkSink;
                c36801.L$3 = SpillingKt.nullOutSpilledVariable(sdkSink);
                c36801.I$0 = 0;
                c36801.label = 1;
                Object all = SdkByteReadChannelKt.readAll(sdkByteReadChannel, sdkSink, c36801);
                if (all == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = all;
                closeable = sdkSinkSink;
            } catch (Throwable th) {
                th = th;
                closeable = sdkSinkSink;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36801.I$0;
            closeable = (Closeable) c36801.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th3;
                }
            }
        }
        Long lBoxLong = Boxing.boxLong(((Number) obj).longValue());
        CloseableKt.closeFinally(closeable, null);
        return lBoxLong;
    }

    public static final Object writeToFile(ByteStream byteStream, Path path, Continuation<? super Long> continuation) {
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile(...)");
        return writeToFile(byteStream, file, continuation);
    }

    public static final InputStream toInputStream(ByteStream byteStream) {
        Intrinsics.checkNotNullParameter(byteStream, "<this>");
        if (byteStream instanceof ByteStream.Buffer) {
            return new ByteArrayInputStream(((ByteStream.Buffer) byteStream).getAsBytes());
        }
        if (byteStream instanceof ByteStream.ChannelStream) {
            return SdkByteReadChannelJVMKt.toInputStream(((ByteStream.ChannelStream) byteStream).readFrom());
        }
        if (!(byteStream instanceof ByteStream.SourceStream)) {
            throw new NoWhenBranchMatchedException();
        }
        SdkBufferedSource sdkBufferedSourceBuffer = SdkIoKt.buffer(((ByteStream.SourceStream) byteStream).readFrom());
        if (sdkBufferedSourceBuffer instanceof SdkBuffer) {
            return ((SdkBuffer) sdkBufferedSourceBuffer).inputStream();
        }
        if (sdkBufferedSourceBuffer instanceof BufferedSourceAdapter) {
            return ((BufferedSourceAdapter) sdkBufferedSourceBuffer).inputStream();
        }
        throw new IllegalStateException("Buffer class " + Reflection.getOrCreateKotlinClass(sdkBufferedSourceBuffer.getClass()).getSimpleName() + " could not be converted to an InputStream");
    }

    public static /* synthetic */ ByteStream.SourceStream fromInputStream$default(ByteStream.Companion companion, InputStream inputStream, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return fromInputStream(companion, inputStream, l);
    }

    public static final ByteStream.SourceStream fromInputStream(ByteStream.Companion companion, InputStream inputStream, Long l) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return asByteStream(inputStream, l);
    }

    public static /* synthetic */ ByteStream.SourceStream asByteStream$default(InputStream inputStream, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return asByteStream(inputStream, l);
    }

    public static final ByteStream.SourceStream asByteStream(InputStream inputStream, Long l) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        if (inputStream.markSupported() && l != null) {
            inputStream.mark((int) l.longValue());
        }
        return new ByteStream.SourceStream(l, inputStream) { // from class: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt.asByteStream.7
            final /* synthetic */ Long $contentLength;
            final /* synthetic */ InputStream $this_asByteStream;
            private final Long contentLength;
            private final boolean isOneShot;

            {
                this.$contentLength = l;
                this.$this_asByteStream = inputStream;
                this.contentLength = l;
                this.isOneShot = !inputStream.markSupported();
            }

            @Override // aws.smithy.kotlin.runtime.content.ByteStream
            public Long getContentLength() {
                return this.contentLength;
            }

            @Override // aws.smithy.kotlin.runtime.content.ByteStream
            /* JADX INFO: renamed from: isOneShot, reason: from getter */
            public boolean getIsOneShot() {
                return this.isOneShot;
            }

            @Override // aws.smithy.kotlin.runtime.content.ByteStream.SourceStream
            public SdkSource readFrom() throws IOException {
                if (this.$this_asByteStream.markSupported() && this.$contentLength != null) {
                    this.$this_asByteStream.reset();
                    this.$this_asByteStream.mark((int) this.$contentLength.longValue());
                    final InputStream inputStream2 = this.$this_asByteStream;
                    return new SdkSource(inputStream2) { // from class: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$asByteStream$7$readFrom$1
                        private final /* synthetic */ SdkSource $$delegate_0;

                        @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
                        public void close() {
                        }

                        @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
                        public long read(SdkBuffer sink, long limit) {
                            Intrinsics.checkNotNullParameter(sink, "sink");
                            return this.$$delegate_0.read(sink, limit);
                        }

                        {
                            this.$$delegate_0 = JavaIOKt.source(inputStream2);
                        }
                    };
                }
                return JavaIOKt.source(this.$this_asByteStream);
            }
        };
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeToOutputStream$2 */
    /* JADX INFO: compiled from: ByteStreamJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$writeToOutputStream$2", m1609f = "ByteStreamJVM.kt", m1610i = {0}, m1611l = {156}, m1612m = "invokeSuspend", m1613n = {"stream"}, m1614nl = {157}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ OutputStream $outputStream;
        final /* synthetic */ ByteStream $this_writeToOutputStream;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36832(ByteStream byteStream, OutputStream outputStream, Continuation<? super C36832> continuation) {
            super(2, continuation);
            this.$this_writeToOutputStream = byteStream;
            this.$outputStream = outputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36832(this.$this_writeToOutputStream, this.$outputStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C36832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SdkSource from;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ByteStream byteStream = this.$this_writeToOutputStream;
            if (byteStream instanceof ByteStream.ChannelStream) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
                this.label = 1;
                Object objWriteAll = ByteStreamJVMKt.writeAll(this.$outputStream, ((ByteStream.ChannelStream) byteStream).readFrom(), this);
                return objWriteAll == coroutine_suspended ? coroutine_suspended : objWriteAll;
            }
            if (byteStream instanceof ByteStream.Buffer) {
                from = SdkIoKt.source(((ByteStream.Buffer) byteStream).getAsBytes());
            } else {
                if (!(byteStream instanceof ByteStream.SourceStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                from = ((ByteStream.SourceStream) byteStream).readFrom();
            }
            SdkBufferedSink sdkBufferedSinkSink = JavaIOKt.sink(this.$outputStream);
            try {
                sdkBufferedSinkSink = SdkIoKt.buffer(sdkBufferedSinkSink);
                try {
                    long jWriteAll = sdkBufferedSinkSink.writeAll(from);
                    CloseableKt.closeFinally(sdkBufferedSinkSink, null);
                    Long lBoxLong = Boxing.boxLong(jWriteAll);
                    CloseableKt.closeFinally(sdkBufferedSinkSink, null);
                    return lBoxLong;
                } finally {
                }
            } finally {
            }
        }
    }

    public static final Object writeToOutputStream(ByteStream byteStream, OutputStream outputStream, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C36832(byteStream, outputStream, null), continuation);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$appendToOutputStream$2 */
    /* JADX INFO: compiled from: ByteStreamJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamJVMKt$appendToOutputStream$2", m1609f = "ByteStreamJVM.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_7_4}, m1612m = "invokeSuspend", m1613n = {"stream"}, m1614nl = {175}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ OutputStream $outputStream;
        final /* synthetic */ ByteStream $this_appendToOutputStream;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36782(ByteStream byteStream, OutputStream outputStream, Continuation<? super C36782> continuation) {
            super(2, continuation);
            this.$this_appendToOutputStream = byteStream;
            this.$outputStream = outputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36782(this.$this_appendToOutputStream, this.$outputStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C36782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SdkSource from;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ByteStream byteStream = this.$this_appendToOutputStream;
            if (byteStream instanceof ByteStream.ChannelStream) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
                this.label = 1;
                Object objWriteAll = ByteStreamJVMKt.writeAll(this.$outputStream, ((ByteStream.ChannelStream) byteStream).readFrom(), this);
                return objWriteAll == coroutine_suspended ? coroutine_suspended : objWriteAll;
            }
            if (byteStream instanceof ByteStream.Buffer) {
                from = SdkIoKt.source(((ByteStream.Buffer) byteStream).getAsBytes());
            } else {
                if (!(byteStream instanceof ByteStream.SourceStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                from = ((ByteStream.SourceStream) byteStream).readFrom();
            }
            return Boxing.boxLong(SdkIoKt.buffer(JavaIOKt.sink(this.$outputStream)).writeAll(from));
        }
    }

    public static final Object appendToOutputStream(ByteStream byteStream, OutputStream outputStream, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C36782(byteStream, outputStream, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeAll(OutputStream outputStream, SdkByteReadChannel sdkByteReadChannel, Continuation<? super Long> continuation) {
        C36813 c36813;
        Closeable closeable;
        if (continuation instanceof C36813) {
            c36813 = (C36813) continuation;
            if ((c36813.label & Integer.MIN_VALUE) != 0) {
                c36813.label -= Integer.MIN_VALUE;
            } else {
                c36813 = new C36813(continuation);
            }
        }
        Object obj = c36813.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36813.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SdkSink sdkSinkSink = JavaIOKt.sink(outputStream);
            try {
                SdkSink sdkSink = sdkSinkSink;
                c36813.L$0 = SpillingKt.nullOutSpilledVariable(outputStream);
                c36813.L$1 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
                c36813.L$2 = sdkSinkSink;
                c36813.L$3 = SpillingKt.nullOutSpilledVariable(sdkSink);
                c36813.I$0 = 0;
                c36813.label = 1;
                Object all = SdkByteReadChannelKt.readAll(sdkByteReadChannel, sdkSink, c36813);
                if (all == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = all;
                closeable = sdkSinkSink;
            } catch (Throwable th) {
                th = th;
                closeable = sdkSinkSink;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36813.I$0;
            closeable = (Closeable) c36813.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th3;
                }
            }
        }
        Long lBoxLong = Boxing.boxLong(((Number) obj).longValue());
        CloseableKt.closeFinally(closeable, null);
        return lBoxLong;
    }
}
