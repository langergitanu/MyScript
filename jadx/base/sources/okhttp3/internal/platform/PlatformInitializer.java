package okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformInitializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¨\u0006\u000b"}, m1599d2 = {"Lokhttp3/internal/platform/PlatformInitializer;", "Landroidx/startup/Initializer;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "create", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "okhttp"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class PlatformInitializer implements Initializer<Platform> {
    @Override // androidx.startup.Initializer
    public Platform create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.INSTANCE.get();
    }

    @Override // androidx.startup.Initializer
    public List<Class<Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}
