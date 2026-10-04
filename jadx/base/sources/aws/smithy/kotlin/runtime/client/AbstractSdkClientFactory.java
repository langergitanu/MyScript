package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClient.Builder;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractSdkClientFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u0006*\u001a\b\u0003\u0010\u0007*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\b2\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00070\tB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0003H\u0014¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u00028\u00022\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\b\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/AbstractSdkClientFactory;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "TConfigBuilder", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "TClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "TClientBuilder", "Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "Laws/smithy/kotlin/runtime/client/SdkClientFactory;", "<init>", "()V", "finalizeConfig", "", "builder", "(Laws/smithy/kotlin/runtime/client/SdkClient$Builder;)V", "invoke", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/client/SdkClient;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractSdkClientFactory<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient, TClientBuilder extends SdkClient.Builder<TConfig, TConfigBuilder, ? extends TClient>> implements SdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> {
    protected void finalizeConfig(TClientBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Override // aws.smithy.kotlin.runtime.client.SdkClientFactory
    public TClient invoke(Function1<? super TConfigBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TClientBuilder tclientbuilderBuilder = builder();
        block.invoke(tclientbuilderBuilder.getConfig());
        finalizeConfig(tclientbuilderBuilder);
        return (TClient) tclientbuilderBuilder.build();
    }
}
