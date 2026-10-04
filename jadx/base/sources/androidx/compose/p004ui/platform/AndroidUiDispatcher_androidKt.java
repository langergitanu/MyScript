package androidx.compose.p004ui.platform;

import android.os.Looper;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, m1599d2 = {"isMainThread", "", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidUiDispatcher_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
