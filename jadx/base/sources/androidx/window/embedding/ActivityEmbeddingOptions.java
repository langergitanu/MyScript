package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityEmbeddingOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m1599d2 = {"setLaunchingActivityStack", "Landroid/os/Bundle;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "setOverlayCreateParams", "activity", "Landroid/app/Activity;", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "window_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ActivityEmbeddingOptions {
    public static final Bundle setLaunchingActivityStack(Bundle bundle, Context context, ActivityStack activityStack) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityStack, "activityStack");
        return ActivityEmbeddingController.INSTANCE.getInstance(context).setLaunchingActivityStack$window_release(bundle, activityStack);
    }

    public static final Bundle setOverlayCreateParams(Bundle bundle, Activity activity, OverlayCreateParams overlayCreateParams) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(overlayCreateParams, "overlayCreateParams");
        return OverlayController.INSTANCE.getInstance(activity).setOverlayCreateParams$window_release(bundle, overlayCreateParams);
    }
}
