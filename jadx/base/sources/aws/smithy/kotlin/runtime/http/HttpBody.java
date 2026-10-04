package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody;", "", "<init>", "()V", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isOneShot", "", "()Z", "isDuplex", "equals", "other", "Empty", "Bytes", "SourceContent", "ChannelContent", "Companion", "Laws/smithy/kotlin/runtime/http/HttpBody$Bytes;", "Laws/smithy/kotlin/runtime/http/HttpBody$ChannelContent;", "Laws/smithy/kotlin/runtime/http/HttpBody$Empty;", "Laws/smithy/kotlin/runtime/http/HttpBody$SourceContent;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class HttpBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long contentLength;
    private final boolean isDuplex;
    private final boolean isOneShot;

    public /* synthetic */ HttpBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HttpBody() {
        this.isOneShot = true;
    }

    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX INFO: renamed from: isOneShot, reason: from getter */
    public boolean getIsOneShot() {
        return this.isOneShot;
    }

    /* JADX INFO: renamed from: isDuplex, reason: from getter */
    public boolean getIsDuplex() {
        return this.isDuplex;
    }

    public boolean equals(Object other) {
        if (!(other instanceof HttpBody)) {
            return false;
        }
        HttpBody httpBody = (HttpBody) other;
        return Intrinsics.areEqual(httpBody.getContentLength(), getContentLength()) && httpBody.getIsOneShot() == getIsOneShot() && httpBody.getIsDuplex() == getIsDuplex();
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0082\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody$Empty;", "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "()V", "isOneShot", "", "()Z", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "equals", "other", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Empty extends HttpBody {
        public static final Empty INSTANCE = new Empty();
        private static final long contentLength = 0;
        private static final boolean isOneShot = false;

        private Empty() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        /* JADX INFO: renamed from: isOneShot */
        public final boolean getIsOneShot() {
            return isOneShot;
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        public Long getContentLength() {
            return Long.valueOf(contentLength);
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        public boolean equals(Object other) {
            if (!(other instanceof HttpBody)) {
                return false;
            }
            Long contentLength2 = ((HttpBody) other).getContentLength();
            return contentLength2 != null && contentLength2.longValue() == getContentLength().longValue();
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody$Bytes;", "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "()V", "isOneShot", "", "()Z", "bytes", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Bytes extends HttpBody {
        private final boolean isOneShot;

        /* JADX INFO: renamed from: bytes */
        public abstract byte[] getBytes();

        public Bytes() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        /* JADX INFO: renamed from: isOneShot, reason: from getter */
        public final boolean getIsOneShot() {
            return this.isOneShot;
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody$SourceContent;", "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "()V", "readFrom", "Laws/smithy/kotlin/runtime/io/SdkSource;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class SourceContent extends HttpBody {
        public abstract SdkSource readFrom();

        public SourceContent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody$ChannelContent;", "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "()V", "readFrom", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class ChannelContent extends HttpBody {
        public abstract SdkByteReadChannel readFrom();

        public ChannelContent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody$Companion;", "", "<init>", "()V", "fromBytes", "Laws/smithy/kotlin/runtime/http/HttpBody;", "bytes", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpBody fromBytes(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return new ByteArrayContent(bytes);
        }
    }
}
