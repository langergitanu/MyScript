package aws.smithy.kotlin.runtime.auth;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AuthSchemeProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/AuthSchemeProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "resolveAuthScheme", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AuthSchemeProvider<T> {
    Object resolveAuthScheme(T t, Continuation<? super List<? extends AuthOption>> continuation);
}
