package androidx.datastore.core.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DirectBootUtil.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0001¨\u0006\u0002"}, m1599d2 = {"requireDeviceProtectedStorageContext", "Landroid/content/Context;", "datastore-core"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class DirectBootUtil_androidKt {
    public static final Context requireDeviceProtectedStorageContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        Intrinsics.checkNotNull(contextCreateDeviceProtectedStorageContext);
        return contextCreateDeviceProtectedStorageContext;
    }
}
