package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.util.Buildable;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "", "clientName", "", "getClientName", "()Ljava/lang/String;", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkClientConfig {

    /* JADX INFO: compiled from: SdkClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "Laws/smithy/kotlin/runtime/util/Buildable;", "clientName", "", "getClientName", "()Ljava/lang/String;", "setClientName", "(Ljava/lang/String;)V", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "setLogMode", "(Laws/smithy/kotlin/runtime/client/LogMode;)V", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder<TConfig extends SdkClientConfig> extends Buildable<TConfig> {
        String getClientName();

        LogMode getLogMode();

        void setClientName(String str);

        void setLogMode(LogMode logMode);
    }

    String getClientName();

    LogMode getLogMode();
}
