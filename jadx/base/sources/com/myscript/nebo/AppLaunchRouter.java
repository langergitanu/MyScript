package com.myscript.nebo;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppLaunchRouter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/AppLaunchRouter;", "", "<init>", "()V", "redirect", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "getRedirect", "()Lkotlin/jvm/functions/Function1;", "setRedirect", "(Lkotlin/jvm/functions/Function1;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AppLaunchRouter {
    private static Function1<? super Activity, Boolean> redirect;
    public static final AppLaunchRouter INSTANCE = new AppLaunchRouter();
    public static final int $stable = 8;

    private AppLaunchRouter() {
    }

    public final Function1<Activity, Boolean> getRedirect() {
        return redirect;
    }

    public final void setRedirect(Function1<? super Activity, Boolean> function1) {
        redirect = function1;
    }
}
