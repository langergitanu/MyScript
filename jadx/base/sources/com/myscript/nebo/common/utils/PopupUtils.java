package com.myscript.nebo.common.utils;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.PopupMenu;
import com.myscript.nebo.common.C6183R;

/* JADX INFO: loaded from: classes3.dex */
public final class PopupUtils {
    private static boolean mLaunched = false;
    private static final Object mLaunchedLock = new Object();

    @FunctionalInterface
    public interface PopupInfoMenuCallback {
        void popupMenuCreated(PopupMenu popupMenu, PopupInfoSaveInstanceState popupInfoSaveInstanceState);
    }

    private PopupUtils() {
    }

    public static class PopupInfoSaveInstanceState {
        public final boolean enableMenuIcon;
        public final int gravity;
        public final int menuLayout;
        public final String popupKey;
        public final int popupStyleAttr;

        /* JADX INFO: renamed from: x */
        public final int f1356x;

        /* JADX INFO: renamed from: y */
        public final int f1357y;

        private PopupInfoSaveInstanceState(String str, int i, int i2, int i3, int i4, int i5, boolean z) {
            this.popupKey = str;
            this.f1356x = i;
            this.f1357y = i2;
            this.menuLayout = i3;
            this.gravity = i4;
            this.popupStyleAttr = i5;
            this.enableMenuIcon = z;
        }
    }

    public static void launchPopupMenu(final Activity activity, final String str, final int i, final int i2, final int i3, final int i4, final int i5, final boolean z, final PopupInfoMenuCallback popupInfoMenuCallback) {
        synchronized (mLaunchedLock) {
            if (mLaunched) {
                return;
            }
            mLaunched = true;
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
            View viewFindViewById = activity.findViewById(C6183R.id.mock_anchor_view);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            final View view = new View(activity);
            view.setId(C6183R.id.mock_anchor_view);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setBackgroundColor(0);
            viewGroup.addView(view);
            view.setX(i4);
            view.setY(i5);
            view.post(new Runnable() { // from class: com.myscript.nebo.common.utils.PopupUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PopupUtils.lambda$launchPopupMenu$0(activity, view, i2, i3, i, popupInfoMenuCallback, str, i4, i5, z);
                }
            });
        }
    }

    static /* synthetic */ void lambda$launchPopupMenu$0(Activity activity, View view, int i, int i2, int i3, PopupInfoMenuCallback popupInfoMenuCallback, String str, int i4, int i5, boolean z) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(activity, view, i, i2, 0);
        popupMenu.inflate(i3);
        popupMenu.setForceShowIcon(true);
        popupMenu.show();
        popupInfoMenuCallback.popupMenuCreated(popupMenu, new PopupInfoSaveInstanceState(str, i4, i5, i3, i, i2, z));
    }

    public static void reset() {
        synchronized (mLaunchedLock) {
            mLaunched = false;
        }
    }
}
