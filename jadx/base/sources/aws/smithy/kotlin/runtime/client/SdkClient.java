package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.util.Buildable;
import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClient;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "config", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "getConfig", "()Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkClient extends Closeable {

    /* JADX INFO: compiled from: SdkClient.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\n\b\u0002\u0010\u0005 \u0001*\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00050\u0007R\u0012\u0010\b\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "TConfigBuilder", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "TClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "Laws/smithy/kotlin/runtime/util/Buildable;", "config", "getConfig", "()Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient> extends Buildable<TClient> {
        TConfigBuilder getConfig();
    }

    SdkClientConfig getConfig();
}
