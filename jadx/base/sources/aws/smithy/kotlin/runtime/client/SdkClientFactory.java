package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClient.Builder;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkClientFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u0006*\u001c\b\u0003\u0010\u0007 \u0001*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\b2\u00020\tJ\r\u0010\n\u001a\u00028\u0003H&¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u00028\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClientFactory;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "TConfigBuilder", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "TClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "TClientBuilder", "Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "", "builder", "()Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "invoke", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/client/SdkClient;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkClientFactory<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient, TClientBuilder extends SdkClient.Builder<TConfig, TConfigBuilder, ? extends TClient>> {
    TClientBuilder builder();

    /* JADX INFO: compiled from: SdkClientFactory.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient, TClientBuilder extends SdkClient.Builder<TConfig, TConfigBuilder, ? extends TClient>> TClient invoke(SdkClientFactory<TConfig, TConfigBuilder, TClient, ? extends TClientBuilder> sdkClientFactory, Function1<? super TConfigBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return (TClient) SdkClientFactory.super.invoke(block);
        }
    }

    default TClient invoke(Function1<? super TConfigBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SdkClient.Builder builder = builder();
        block.invoke(builder.getConfig());
        return (TClient) builder.build();
    }
}
