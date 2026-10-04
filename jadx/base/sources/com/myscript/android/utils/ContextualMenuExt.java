package com.myscript.android.utils;

import android.view.View;
import com.myscript.android.utils.ContextualMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextualMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"startContextualMenu", "Lcom/myscript/android/utils/ContextualMenu;", "Landroid/view/View;", "callback", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContextualMenuExt {
    public static final ContextualMenu startContextualMenu(View view, ContextualMenu.Callback callback) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return ContextualMenu.INSTANCE.newInstance$android_utils_release(callback).start$android_utils_release(view);
    }
}
