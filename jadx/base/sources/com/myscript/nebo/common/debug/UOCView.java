package com.myscript.nebo.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.myscript.nebo.common.C6183R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UOCView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/common/debug/UOCView;", "Landroid/widget/TextView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "formatter", "Ljava/text/NumberFormat;", "max", "", "getMax", "()J", "setMax", "(J)V", "value", "count", "getCount", "setCount", "onCreateDrawableState", "", "extraSpace", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UOCView extends TextView {
    private long count;
    private final NumberFormat formatter;
    private long max;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UOCView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        if (percentInstance == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        percentInstance.setMinimumFractionDigits(2);
        percentInstance.setMaximumFractionDigits(2);
        this.formatter = percentInstance;
        this.count = Long.MIN_VALUE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UOCView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        if (percentInstance == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        percentInstance.setMinimumFractionDigits(2);
        percentInstance.setMaximumFractionDigits(2);
        this.formatter = percentInstance;
        this.count = Long.MIN_VALUE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UOCView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        if (percentInstance == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        percentInstance.setMinimumFractionDigits(2);
        percentInstance.setMaximumFractionDigits(2);
        this.formatter = percentInstance;
        this.count = Long.MIN_VALUE;
    }

    public final long getMax() {
        return this.max;
    }

    public final void setMax(long j) {
        this.max = j;
    }

    public final long getCount() {
        return this.count;
    }

    public final void setCount(long j) {
        String string;
        if (j != this.count) {
            this.count = j;
            if (j != Long.MIN_VALUE) {
                float fCountToPercent = UOCViewKt.countToPercent(j, this.max);
                Context context = getContext();
                int i = C6183R.string.debug_uoc;
                String str = this.formatter.format(Float.valueOf(fCountToPercent));
                Long lValueOf = Long.valueOf(j);
                long j2 = this.max;
                string = context.getString(i, str, lValueOf, j2 == 0 ? "∞" : String.valueOf(j2));
            } else {
                string = getContext().getString(C6183R.string.debug_uoc_na);
            }
            setText(string);
            refreshDrawableState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int i;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        long j = this.count;
        if (j != Long.MIN_VALUE) {
            int iCountToPercent = (int) (UOCViewKt.countToPercent(j, this.max) * 100);
            if (iCountToPercent >= 0 && iCountToPercent < 25) {
                i = C6183R.attr.state_uoc_ok;
            } else if (25 <= iCountToPercent && iCountToPercent < 50) {
                i = C6183R.attr.state_uoc_watch;
            } else if (50 <= iCountToPercent && iCountToPercent < 75) {
                i = C6183R.attr.state_uoc_warning;
            } else if (75 <= iCountToPercent && iCountToPercent < 101) {
                i = C6183R.attr.state_uoc_critical;
            } else {
                i = C6183R.attr.state_uoc_unknown;
            }
        } else {
            i = C6183R.attr.state_uoc_unknown;
        }
        TextView.mergeDrawableStates(iArrOnCreateDrawableState, new int[]{i});
        Intrinsics.checkNotNull(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }
}
