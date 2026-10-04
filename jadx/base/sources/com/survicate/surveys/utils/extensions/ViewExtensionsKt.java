package com.survicate.surveys.utils.extensions;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, m1599d2 = {"clipChildrenToBackground", "", "Landroid/view/View;", "getDimensionPx", "", "resId", "requestOnScreen", "immediate", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ViewExtensionsKt {
    public static final void clipChildrenToBackground(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        view.setClipToOutline(true);
    }

    public static final int getDimensionPx(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getResources().getDimensionPixelSize(i);
    }

    public static /* synthetic */ void requestOnScreen$default(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        requestOnScreen(view, z);
    }

    public static final void requestOnScreen(final View view, final boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            view.requestRectangleOnScreen(rect, z);
            return;
        }
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.survicate.surveys.utils.extensions.ViewExtensionsKt$requestOnScreen$$inlined$doOnLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view2.removeOnLayoutChangeListener(this);
                Rect rect2 = new Rect();
                view.getDrawingRect(rect2);
                view.requestRectangleOnScreen(rect2, z);
            }
        });
    }
}
