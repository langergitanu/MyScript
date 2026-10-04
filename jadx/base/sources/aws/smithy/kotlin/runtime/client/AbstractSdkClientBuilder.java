package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder;
import kotlin.Metadata;

/* JADX INFO: compiled from: AbstractSdkClientBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\n\b\u0002\u0010\u0005 \u0001*\u00020\u00062\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u0007B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\n\u001a\u00028\u0002¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00028\u00022\u0006\u0010\r\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/AbstractSdkClientBuilder;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "TConfigBuilder", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "TClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "<init>", "()V", "build", "()Laws/smithy/kotlin/runtime/client/SdkClient;", "newClient", "config", "(Laws/smithy/kotlin/runtime/client/SdkClientConfig;)Laws/smithy/kotlin/runtime/client/SdkClient;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractSdkClientBuilder<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient> implements SdkClient.Builder<TConfig, TConfigBuilder, TClient> {
    protected abstract TClient newClient(TConfig config);

    @Override // aws.smithy.kotlin.runtime.util.Buildable
    public final TClient build() {
        return (TClient) newClient((SdkClientConfig) getConfig().build());
    }
}
