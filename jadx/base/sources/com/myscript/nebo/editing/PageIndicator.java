package com.myscript.nebo.editing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.card.MaterialCardView;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.C6079R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0016R@\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageIndicator;", "Lcom/google/android/material/card/MaterialCardView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lkotlin/Function0;", "", "Lcom/myscript/nebo/editing/ChildPagesPanelToggleListener;", "sidePanelToggleListener", "getSidePanelToggleListener", "()Lkotlin/jvm/functions/Function0;", "setSidePanelToggleListener", "(Lkotlin/jvm/functions/Function0;)V", "lastRequestedVisibility", "", "setState", "isVisible", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageIndicator extends MaterialCardView {
    public static final int $stable = 8;
    private boolean lastRequestedVisibility;
    private Function0<Unit> sidePanelToggleListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialCardView.inflate(getContext(), C6079R.layout.page_indicator_widget, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialCardView.inflate(getContext(), C6079R.layout.page_indicator_widget, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialCardView.inflate(getContext(), C6079R.layout.page_indicator_widget, this);
    }

    public final Function0<Unit> getSidePanelToggleListener() {
        return this.sidePanelToggleListener;
    }

    public final void setSidePanelToggleListener(final Function0<Unit> function0) {
        View viewFindViewById = findViewById(C6079R.id.editing_page_widget_side_panel_toggle);
        Intrinsics.checkNotNull(viewFindViewById);
        viewFindViewById.setVisibility(function0 != null ? 0 : 8);
        if (function0 == null) {
            viewFindViewById.setOnClickListener(null);
        } else {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.PageIndicator$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    function0.invoke();
                }
            });
        }
        this.sidePanelToggleListener = function0;
    }

    public final void setState(boolean isVisible) {
        boolean z = isVisible && !isShown();
        boolean z2 = !isVisible && isShown();
        this.lastRequestedVisibility = isVisible;
        if (z) {
            ViewExt.fadeIn$default(this, 0L, 0L, 3, null);
        } else {
            if (!z2 || hasFocus()) {
                return;
            }
            ViewExt.fadeOut$default(this, 0L, 0L, 3, null);
        }
    }
}
