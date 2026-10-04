package aws.sdk.kotlin.runtime.config.imds;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/InstanceMetadataProvider;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "get", "", ClientCookie.PATH_ATTR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface InstanceMetadataProvider extends Closeable {
    Object get(String str, Continuation<? super String> continuation);
}
