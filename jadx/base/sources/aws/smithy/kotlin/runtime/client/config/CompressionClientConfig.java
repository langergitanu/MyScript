package aws.smithy.kotlin.runtime.client.config;

import aws.smithy.kotlin.runtime.client.config.RequestCompressionConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompressionClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/CompressionClientConfig;", "", "requestCompression", "Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig;", "getRequestCompression", "()Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CompressionClientConfig {
    RequestCompressionConfig getRequestCompression();

    /* JADX INFO: compiled from: CompressionClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/CompressionClientConfig$Builder;", "", "requestCompression", "Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;", "getRequestCompression", "()Laws/smithy/kotlin/runtime/client/config/RequestCompressionConfig$Builder;", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    @CompressionClientConfigDsl
    public interface Builder {
        RequestCompressionConfig.Builder getRequestCompression();

        /* JADX INFO: compiled from: CompressionClientConfig.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void requestCompression(Builder builder, Function1<? super RequestCompressionConfig.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder.super.requestCompression(block);
            }
        }

        default void requestCompression(Function1<? super RequestCompressionConfig.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getRequestCompression());
        }
    }
}
