package com.revenuecat.purchases.utils;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurrentActivityTracker.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/CurrentActivityTracker;", "", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "startedActivities", "", "Ljava/lang/ref/WeakReference;", "onActivityStarted", "", "activity", "onActivityStopped", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CurrentActivityTracker {
    private final List<WeakReference<Activity>> startedActivities = new ArrayList();

    public final synchronized Activity getCurrentActivity() {
        Activity activity;
        Iterator it = CollectionsKt.asReversedMutable(this.startedActivities).iterator();
        do {
            activity = null;
            if (!it.hasNext()) {
                break;
            }
            Activity activity2 = (Activity) ((WeakReference) it.next()).get();
            if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                activity = activity2;
            }
        } while (activity == null);
        return activity;
    }

    public final synchronized void onActivityStarted(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CollectionsKt.removeAll((List) this.startedActivities, (Function1) new Function1<WeakReference<Activity>, Boolean>() { // from class: com.revenuecat.purchases.utils.CurrentActivityTracker.onActivityStarted.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<Activity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null || Intrinsics.areEqual(it.get(), activity));
            }
        });
        this.startedActivities.add(new WeakReference<>(activity));
    }

    public final synchronized void onActivityStopped(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CollectionsKt.removeAll((List) this.startedActivities, (Function1) new Function1<WeakReference<Activity>, Boolean>() { // from class: com.revenuecat.purchases.utils.CurrentActivityTracker.onActivityStopped.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<Activity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null || Intrinsics.areEqual(it.get(), activity));
            }
        });
    }
}
