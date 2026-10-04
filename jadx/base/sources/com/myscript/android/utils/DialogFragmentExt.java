package com.myscript.android.utils;

import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogFragmentExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002¨\u0006\b"}, m1599d2 = {"showAtMostOnce", "", "Landroidx/fragment/app/DialogFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "allowWindowToBeResizedWithVirtualKeyboard", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DialogFragmentExt {
    public static final void showAtMostOnce(DialogFragment dialogFragment, FragmentManager fragmentManager, String tag) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (dialogFragment.getClass()) {
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(tag);
            if ((fragmentFindFragmentByTag instanceof DialogFragment ? (DialogFragment) fragmentFindFragmentByTag : null) == null) {
                dialogFragment.show(fragmentManager, tag);
                fragmentManager.executePendingTransactions();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void allowWindowToBeResizedWithVirtualKeyboard(DialogFragment dialogFragment) {
        Window window;
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        Dialog dialog = dialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(16);
    }
}
