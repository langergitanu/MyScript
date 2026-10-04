package aws.smithy.kotlin.runtime.compression;

import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.p011io.GzipByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.GzipSdkSource;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.revenuecat.purchases.common.HTTPClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/compression/Gzip;", "Laws/smithy/kotlin/runtime/compression/CompressionAlgorithm;", "<init>", "()V", "Laws/smithy/kotlin/runtime/content/ByteStream;", "stream", "compress", "(Laws/smithy/kotlin/runtime/content/ByteStream;)Laws/smithy/kotlin/runtime/content/ByteStream;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "contentEncoding", "getContentEncoding", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Gzip implements CompressionAlgorithm {
    private final String id = HTTPClient.RC_FORMAT_ACCEPT_ENCODING;
    private final String contentEncoding = HTTPClient.RC_FORMAT_ACCEPT_ENCODING;

    @Override // aws.smithy.kotlin.runtime.compression.CompressionAlgorithm
    public String getId() {
        return this.id;
    }

    @Override // aws.smithy.kotlin.runtime.compression.CompressionAlgorithm
    public String getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // aws.smithy.kotlin.runtime.compression.CompressionAlgorithm
    public ByteStream compress(final ByteStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        if (stream instanceof ByteStream.Buffer) {
            return new ByteStream.Buffer() { // from class: aws.smithy.kotlin.runtime.compression.Gzip.compress.1
                private final Long contentLength;

                @Override // aws.smithy.kotlin.runtime.content.ByteStream.Buffer
                /* JADX INFO: renamed from: bytes */
                public byte[] getAsBytes() throws IOException {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(((ByteStream.Buffer) stream).getAsBytes());
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    Intrinsics.checkNotNull(byteArray);
                    return byteArray;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                public Long getContentLength() {
                    return this.contentLength;
                }
            };
        }
        if (stream instanceof ByteStream.ChannelStream) {
            return new ByteStream.ChannelStream() { // from class: aws.smithy.kotlin.runtime.compression.Gzip.compress.2
                private final Long contentLength;
                private final boolean isOneShot;

                {
                    this.isOneShot = this.$stream.getIsOneShot();
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream.ChannelStream
                public SdkByteReadChannel readFrom() {
                    return new GzipByteReadChannel(((ByteStream.ChannelStream) this.$stream).readFrom());
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
            };
        }
        if (!(stream instanceof ByteStream.SourceStream)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ByteStream.SourceStream() { // from class: aws.smithy.kotlin.runtime.compression.Gzip.compress.3
            private final Long contentLength;
            private final boolean isOneShot;

            {
                this.isOneShot = this.$stream.getIsOneShot();
            }

            @Override // aws.smithy.kotlin.runtime.content.ByteStream.SourceStream
            public SdkSource readFrom() {
                return new GzipSdkSource(((ByteStream.SourceStream) this.$stream).readFrom());
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
        };
    }
}
