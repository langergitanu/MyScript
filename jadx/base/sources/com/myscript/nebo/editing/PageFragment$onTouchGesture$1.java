package com.myscript.nebo.editing;

import android.view.MotionEvent;
import androidx.appcompat.C0028R;
import com.myscript.android.utils.ViewExt;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.PointerType;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.utils.PopupUtils;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.GestureListenerAdapter;
import com.myscript.nebo.editing.impl.p027ui.ITouchFeature;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.snt.core.PageController;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m1599d2 = {"com/myscript/nebo/editing/PageFragment$onTouchGesture$1", "Lcom/myscript/nebo/editing/impl/ui/GestureListenerAdapter;", "onDoubleTap", "", "motionEvent", "Landroid/view/MotionEvent;", "onLongPress", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageFragment$onTouchGesture$1 extends GestureListenerAdapter {
    final /* synthetic */ PageFragment this$0;

    PageFragment$onTouchGesture$1(PageFragment pageFragment) {
        this.this$0 = pageFragment;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.GestureListenerAdapter, com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        DocumentRenderingView renderingView;
        int[] locationInWindow;
        EditingController editingController;
        ITouchFeature touchFeatureImpl;
        PointerType pointerType;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        EditingController editingController2 = this.this$0.getEditingController();
        if (editingController2 == null || (renderingView = editingController2.getRenderingView()) == null || (locationInWindow = ViewExt.getLocationInWindow(renderingView)) == null || (editingController = this.this$0.getEditingController()) == null || (touchFeatureImpl = editingController.getTouchFeatureImpl()) == null) {
            return;
        }
        PageFragment pageFragment = this.this$0;
        float x = motionEvent.getX() + touchFeatureImpl.getHorizontalScrollPos();
        float y = motionEvent.getY() + touchFeatureImpl.getVerticalScrollPos();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (motionEvent.getPointerCount() == 2) {
            pointerType = PointerType.DOUBLE_TOUCH;
        } else {
            pointerType = PointerType.TOUCH;
        }
        final PointerInfo pointerInfo = new PointerInfo(x, y, jCurrentTimeMillis, 0.0f, pointerType);
        TechnicalLoggerExt.logAction(this.this$0.getLogger(), PageFragment.TAG, "DOUBLE_TAP_ADD_BLOCK_MENU", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$onTouchGesture$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment$onTouchGesture$1.onDoubleTap$lambda$0$0(pointerInfo);
            }
        });
        pageFragment.blockPosition = pointerInfo;
        PopupUtils.launchPopupMenu(this.this$0.getActivity(), "DOUBLE_TAP_ADD_BLOCK_MENU", C6079R.menu.double_tap_add_block_menu, 0, C0028R.attr.actionOverflowMenuStyle, ((int) motionEvent.getX()) + locationInWindow[0], ((int) motionEvent.getY()) + locationInWindow[1], true, new PageFragment$onTouchGesture$1$$ExternalSyntheticLambda1(this.this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onDoubleTap$lambda$0$0(PointerInfo pointerInfo) {
        return "(" + ((int) pointerInfo.getX()) + TextRecallingManager.ANSWER_SEPARATOR + ((int) pointerInfo.getY()) + ")";
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.GestureListenerAdapter, com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onLongPress(MotionEvent motionEvent) {
        DocumentRenderingView renderingView;
        int[] locationInWindow;
        EditingController editingController;
        ITouchFeature touchFeatureImpl;
        PageController pageController;
        PointerType pointerType;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        EditingController editingController2 = this.this$0.getEditingController();
        if (editingController2 == null || (renderingView = editingController2.getRenderingView()) == null || (locationInWindow = ViewExt.getLocationInWindow(renderingView)) == null || (editingController = this.this$0.getEditingController()) == null || (touchFeatureImpl = editingController.getTouchFeatureImpl()) == null || (pageController = this.this$0.getPageController()) == null) {
            return;
        }
        PageController pageController2 = pageController;
        PageFragment pageFragment = this.this$0;
        try {
            PageController pageController3 = pageController2;
            int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
            float x = motionEvent.getX() + touchFeatureImpl.getHorizontalScrollPos();
            float y = motionEvent.getY() + touchFeatureImpl.getVerticalScrollPos();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (toolType == 2) {
                pointerType = PointerType.PEN;
            } else {
                pointerType = motionEvent.getPointerCount() == 2 ? PointerType.DOUBLE_TOUCH : PointerType.TOUCH;
            }
            final PointerInfo pointerInfo = new PointerInfo(x, y, jCurrentTimeMillis, 0.0f, pointerType);
            pageFragment.blockPosition = pointerInfo;
            if (pageController3.onLongPress(pointerInfo)) {
                pageController3.penAbort();
                AutoCloseableKt.closeFinally(pageController2, null);
                return;
            }
            if (toolType == 1 && !pageController3.isFingerWritingAllowed()) {
                TechnicalLoggerExt.logAction(pageFragment.getLogger(), PageFragment.TAG, "LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$onTouchGesture$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment$onTouchGesture$1.onLongPress$lambda$1$0(pointerInfo);
                    }
                });
                PopupUtils.launchPopupMenu(pageFragment.getActivity(), "LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU", C6079R.menu.long_press_add_and_paste_menu, 0, C0028R.attr.actionOverflowMenuStyle, ((int) motionEvent.getX()) + locationInWindow[0], ((int) motionEvent.getY()) + locationInWindow[1], true, new PageFragment$onTouchGesture$1$$ExternalSyntheticLambda1(pageFragment));
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(pageController2, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onLongPress$lambda$1$0(PointerInfo pointerInfo) {
        return "(" + ((int) pointerInfo.getX()) + TextRecallingManager.ANSWER_SEPARATOR + ((int) pointerInfo.getY()) + ")";
    }
}
