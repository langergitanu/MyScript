package androidx.compose.p004ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.p004ui.input.key.Key;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.compose.p004ui.platform.AndroidComposeView;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusInteropUtils.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u001a%\u0010\u0015\u001a\u00020\u0016*\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"tempCoordinates", "", "tempRect", "Landroid/graphics/Rect;", "toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateFocusRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FocusInteropUtils_androidKt {
    private static final int[] tempCoordinates = new int[2];
    private static final Rect tempRect = new Rect();

    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7787getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7786getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7785getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7789getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7788getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7782getDowndhqQ8s());
    }

    /* JADX INFO: renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m7790toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7789getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7782getDowndhqQ8s())) {
            return Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7785getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7788getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7786getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m7778equalsimpl0(i, FocusDirection.INSTANCE.m7787getPreviousdhqQ8s()) ? 1 : null;
    }

    /* JADX INFO: renamed from: toFocusDirection-ZmokQxo, reason: not valid java name */
    public static final FocusDirection m7791toFocusDirectionZmokQxo(KeyEvent keyEvent) {
        long jM9324getKeyZmokQxo = KeyEvent_androidKt.m9324getKeyZmokQxo(keyEvent);
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9165getNavigatePreviousEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7787getPreviousdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9163getNavigateNextEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7786getNextdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9252getTabEK5gGoQ())) {
            return FocusDirection.m7775boximpl(KeyEvent_androidKt.m9330isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m7787getPreviousdhqQ8s() : FocusDirection.INSTANCE.m7786getNextdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9082getDirectionRightEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7788getRightdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9081getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7785getLeftdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9083getDirectionUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9204getPageUpEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7789getUpdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9078getDirectionDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9203getPageDownEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7782getDowndhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9077getDirectionCenterEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9091getEnterEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9188getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7783getEnterdhqQ8s());
        }
        if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9020getBackEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9094getEscapeEK5gGoQ())) {
            return FocusDirection.m7775boximpl(FocusDirection.INSTANCE.m7784getExitdhqQ8s());
        }
        return null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }

    public static final androidx.compose.p004ui.geometry.Rect calculateFocusRectRelativeTo(View view, View view2) {
        int[] iArr = tempCoordinates;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        float f = i - iArr[0];
        float f2 = i2 - iArr[1];
        view.getFocusedRect(tempRect);
        return new androidx.compose.p004ui.geometry.Rect(r1.left + f, r1.top + f2, f + r1.left + r1.width(), f2 + r1.top + r1.height());
    }

    public static final boolean requestInteropFocus(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !viewGroup.hasFocus()) {
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return ((AndroidComposeView) view).requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }
}
