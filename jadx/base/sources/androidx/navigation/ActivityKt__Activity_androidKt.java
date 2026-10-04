package androidx.navigation;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Activity.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/app/Activity;", "viewId", "", "navigation-runtime_release"}, m1600k = 5, m1601mv = {2, 0, 0}, m1603xi = 48, m1604xs = "androidx/navigation/ActivityKt")
final /* synthetic */ class ActivityKt__Activity_androidKt {
    public static final NavController findNavController(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return Navigation.findNavController(activity, i);
    }
}
