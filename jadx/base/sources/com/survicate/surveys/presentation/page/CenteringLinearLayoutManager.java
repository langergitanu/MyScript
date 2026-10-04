package com.survicate.surveys.presentation.page;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CenteringLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rR\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/CenteringLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "isQuestionPosition", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CenteringLinearLayoutManager extends LinearLayoutManager {
    private final Function1<Integer, Boolean> isQuestionPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CenteringLinearLayoutManager(Context context, Function1<? super Integer, Boolean> isQuestionPosition) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isQuestionPosition, "isQuestionPosition");
        this.isQuestionPosition = isQuestionPosition;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        View childAt;
        int decoratedBottom;
        int height;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutChildren(recycler, state);
        if (getChildCount() == 0 || (childAt = getChildAt(getChildCount() - 1)) == null || (decoratedBottom = getDecoratedBottom(childAt)) >= (height = (getHeight() - getPaddingTop()) - getPaddingBottom())) {
            return;
        }
        int i = height - decoratedBottom;
        int childCount = getChildCount();
        int decoratedMeasuredHeight = 0;
        int decoratedBottom2 = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = getChildAt(i2);
            if (childAt2 != null) {
                if (this.isQuestionPosition.invoke(Integer.valueOf(getPosition(childAt2))).booleanValue()) {
                    decoratedBottom2 = getDecoratedBottom(childAt2);
                } else {
                    decoratedMeasuredHeight += getDecoratedMeasuredHeight(childAt2);
                }
            }
        }
        int i3 = ((height - decoratedMeasuredHeight) - decoratedBottom2) / 2;
        int childCount2 = getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt3 = getChildAt(i4);
            if (childAt3 != null) {
                if (this.isQuestionPosition.invoke(Integer.valueOf(getPosition(childAt3))).booleanValue()) {
                    childAt3.offsetTopAndBottom(i3);
                } else {
                    childAt3.offsetTopAndBottom(i);
                }
            }
        }
    }
}
