package aws.smithy.kotlin.runtime.client.config;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.compression.CompressionAlgorithm;
import aws.smithy.kotlin.runtime.compression.Gzip;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompressionClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0003H\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig;", "", "builder", "Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;", "<init>", "(Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;)V", "compressionAlgorithms", "", "Laws/smithy/kotlin/runtime/compression/CompressionAlgorithm;", "getCompressionAlgorithms", "()Ljava/util/List;", "disableRequestCompression", "", "getDisableRequestCompression", "()Z", "requestMinCompressionSizeBytes", "", "getRequestMinCompressionSizeBytes", "()J", "toBuilder", "Companion", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RequestCompressionConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CompressionAlgorithm> compressionAlgorithms;
    private final boolean disableRequestCompression;
    private final long requestMinCompressionSizeBytes;

    /* JADX INFO: compiled from: CompressionClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RequestCompressionConfig invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return new RequestCompressionConfig(builder);
        }
    }

    @InternalApi
    public RequestCompressionConfig(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.compressionAlgorithms = builder.getCompressionAlgorithms();
        Boolean disableRequestCompression = builder.getDisableRequestCompression();
        this.disableRequestCompression = disableRequestCompression != null ? disableRequestCompression.booleanValue() : false;
        Long requestMinCompressionSizeBytes = builder.getRequestMinCompressionSizeBytes();
        this.requestMinCompressionSizeBytes = requestMinCompressionSizeBytes != null ? requestMinCompressionSizeBytes.longValue() : 10240L;
    }

    public final List<CompressionAlgorithm> getCompressionAlgorithms() {
        return this.compressionAlgorithms;
    }

    public final boolean getDisableRequestCompression() {
        return this.disableRequestCompression;
    }

    public final long getRequestMinCompressionSizeBytes() {
        return this.requestMinCompressionSizeBytes;
    }

    @InternalApi
    public final Builder toBuilder() {
        Builder builder = new Builder();
        builder.setCompressionAlgorithms(CollectionsKt.toMutableList((Collection) this.compressionAlgorithms));
        builder.setDisableRequestCompression(Boolean.valueOf(this.disableRequestCompression));
        builder.setRequestMinCompressionSizeBytes(Long.valueOf(this.requestMinCompressionSizeBytes));
        return builder;
    }

    /* JADX INFO: compiled from: CompressionClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;", "", "<init>", "()V", "compressionAlgorithms", "", "Laws/smithy/kotlin/runtime/compression/CompressionAlgorithm;", "getCompressionAlgorithms", "()Ljava/util/List;", "setCompressionAlgorithms", "(Ljava/util/List;)V", "disableRequestCompression", "", "getDisableRequestCompression", "()Ljava/lang/Boolean;", "setDisableRequestCompression", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "requestMinCompressionSizeBytes", "", "getRequestMinCompressionSizeBytes", "()Ljava/lang/Long;", "setRequestMinCompressionSizeBytes", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    @CompressionClientConfigDsl
    public static final class Builder {
        private List<CompressionAlgorithm> compressionAlgorithms = CollectionsKt.mutableListOf(new Gzip());
        private Boolean disableRequestCompression;
        private Long requestMinCompressionSizeBytes;

        @InternalApi
        public Builder() {
        }

        public final List<CompressionAlgorithm> getCompressionAlgorithms() {
            return this.compressionAlgorithms;
        }

        public final void setCompressionAlgorithms(List<CompressionAlgorithm> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.compressionAlgorithms = list;
        }

        public final Boolean getDisableRequestCompression() {
            return this.disableRequestCompression;
        }

        public final void setDisableRequestCompression(Boolean bool) {
            this.disableRequestCompression = bool;
        }

        public final Long getRequestMinCompressionSizeBytes() {
            return this.requestMinCompressionSizeBytes;
        }

        public final void setRequestMinCompressionSizeBytes(Long l) {
            this.requestMinCompressionSizeBytes = l;
        }
    }
}
