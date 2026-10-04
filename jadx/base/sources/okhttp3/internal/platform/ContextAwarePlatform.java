package okhttp3.internal.platform;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextAwarePlatform.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lokhttp3/internal/platform/ContextAwarePlatform;", "", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "okhttp"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public interface ContextAwarePlatform {
    Context getApplicationContext();

    void setApplicationContext(Context context);
}
