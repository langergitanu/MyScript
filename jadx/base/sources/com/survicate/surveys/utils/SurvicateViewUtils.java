package com.survicate.surveys.utils;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.survicate.surveys.C8369R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateViewUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u001c\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateViewUtils;", "", "<init>", "()V", "applySafeCardMargins", "", "cardView", "Landroidx/cardview/widget/CardView;", "isDialog", "", "applySafeContentPaddings", "rootView", "Landroid/view/View;", "observeShowKeyboardAnimationEnd", "onAnimationEnd", "Lkotlin/Function0;", "applyKeyboardMargin", "contentWrapper", "bottomViews", "", "BottomMarginKeyboardInsetsListener", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateViewUtils {
    public static final SurvicateViewUtils INSTANCE = new SurvicateViewUtils();

    private SurvicateViewUtils() {
    }

    public final void applySafeCardMargins(CardView cardView, final boolean isDialog) {
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        ViewCompat.setOnApplyWindowInsetsListener(cardView, new OnApplyWindowInsetsListener() { // from class: com.survicate.surveys.utils.SurvicateViewUtils$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SurvicateViewUtils.applySafeCardMargins$lambda$1(isDialog, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applySafeCardMargins$lambda$1(boolean z, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, insets.top + (z ? view.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_survey_dialog_top_space) : 0), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
        view.setLayoutParams(marginLayoutParams);
        return windowInsets;
    }

    public final void applySafeContentPaddings(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.survicate.surveys.utils.SurvicateViewUtils$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SurvicateViewUtils.applySafeContentPaddings$lambda$2(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applySafeContentPaddings$lambda$2(View view, WindowInsetsCompat windowInsets) {
        Insets insets;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (screenUtils.isLandscapeOrientation(resources)) {
            insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
        } else {
            insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        }
        Intrinsics.checkNotNull(insets);
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C8369R.dimen.survicate_horizontal_insets_extra_padding);
        int i = insets.left + dimensionPixelSize;
        int i2 = insets.bottom;
        view.setPadding(i, view.getPaddingTop(), insets.right + dimensionPixelSize, i2);
        return windowInsets;
    }

    public final void observeShowKeyboardAnimationEnd(final View rootView, final Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        ViewCompat.setWindowInsetsAnimationCallback(rootView, new WindowInsetsAnimationCompat.Callback() { // from class: com.survicate.surveys.utils.SurvicateViewUtils.observeShowKeyboardAnimationEnd.1
            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                return insets;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onEnd(WindowInsetsAnimationCompat animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(rootView);
                if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                    onAnimationEnd.invoke();
                }
            }
        });
    }

    public final void applyKeyboardMargin(View contentWrapper, List<? extends View> bottomViews) {
        Intrinsics.checkNotNullParameter(contentWrapper, "contentWrapper");
        Intrinsics.checkNotNullParameter(bottomViews, "bottomViews");
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        Resources resources = contentWrapper.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (screenUtils.isLandscapeOrientation(resources)) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(contentWrapper, new BottomMarginKeyboardInsetsListener(contentWrapper, bottomViews));
    }

    /* JADX INFO: compiled from: SurvicateViewUtils.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateViewUtils$BottomMarginKeyboardInsetsListener;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "contentWrapper", "Landroid/view/View;", "bottomViews", "", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "insets", "getTargetMargin", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final class BottomMarginKeyboardInsetsListener implements OnApplyWindowInsetsListener {
        private final List<View> bottomViews;
        private final View contentWrapper;

        /* JADX WARN: Multi-variable type inference failed */
        public BottomMarginKeyboardInsetsListener(View contentWrapper, List<? extends View> bottomViews) {
            Intrinsics.checkNotNullParameter(contentWrapper, "contentWrapper");
            Intrinsics.checkNotNullParameter(bottomViews, "bottomViews");
            this.contentWrapper = contentWrapper;
            this.bottomViews = bottomViews;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            int targetMargin = getTargetMargin(insets);
            View view = this.contentWrapper;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, targetMargin);
            view.setLayoutParams(marginLayoutParams);
            return insets;
        }

        private final int getTargetMargin(WindowInsetsCompat insets) {
            int i = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            if (i == 0) {
                return 0;
            }
            int i2 = i - insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            Iterator<T> it = this.bottomViews.iterator();
            int height = 0;
            while (it.hasNext()) {
                height += ((View) it.next()).getHeight();
            }
            if (height >= i2) {
                return 0;
            }
            return i2 - height;
        }
    }
}
