package com.myscript.android.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NestedFragmentNavigator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, m1599d2 = {"showFragment", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", "containerRes", "", "tag", "", "popBackStack", "", "newInstance", "Lkotlin/Function0;", "(Landroidx/fragment/app/FragmentManager;ILjava/lang/String;ZLkotlin/jvm/functions/Function0;)Landroidx/fragment/app/Fragment;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NestedFragmentNavigatorKt {
    public static final <T extends Fragment> T showFragment(FragmentManager fragmentManager, int i, String tag, boolean z, Function0<? extends T> newInstance) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        String name = backStackEntryCount >= 0 ? fragmentManager.getBackStackEntryAt(backStackEntryCount).getName() : null;
        T tInvoke = (T) fragmentManager.findFragmentByTag(tag);
        if (tInvoke == null) {
            tInvoke = newInstance.invoke();
        }
        if (!Intrinsics.areEqual(tag, name)) {
            if (z) {
                fragmentManager.popBackStack();
            }
            if (!tInvoke.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.replace(i, tInvoke, tag);
                fragmentTransactionBeginTransaction.addToBackStack(tag);
                fragmentTransactionBeginTransaction.commit();
            }
        }
        Intrinsics.checkNotNull(tInvoke, "null cannot be cast to non-null type T of com.myscript.android.utils.NestedFragmentNavigatorKt.showFragment");
        return tInvoke;
    }
}
