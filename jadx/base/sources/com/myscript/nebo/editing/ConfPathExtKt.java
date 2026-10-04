package com.myscript.nebo.editing;

import android.content.Context;
import com.myscript.atk.resourcemanager.ResourceManager;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfPathExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"getConfPath", "", "", "Landroid/content/Context;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConfPathExtKt {
    public static final List<String> getConfPath(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.atk.resourcemanager.ResourceManager.Provider");
        ResourceManager resourceManagerProvideResourceManager = ((ResourceManager.Provider) applicationContext).provideResourceManager();
        Intrinsics.checkNotNullExpressionValue(resourceManagerProvideResourceManager, "provideResourceManager(...)");
        List<String> confPaths = resourceManagerProvideResourceManager.getConfPaths();
        Intrinsics.checkNotNullExpressionValue(confPaths, "getConfPaths(...)");
        return CollectionsKt.plus((Collection<? extends String>) confPaths, "zip://" + context.getPackageCodePath() + "!/assets/conf");
    }
}
