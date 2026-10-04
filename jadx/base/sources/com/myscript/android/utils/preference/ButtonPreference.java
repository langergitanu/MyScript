package com.myscript.android.utils.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.android.material.C4627R;
import com.myscript.android.utils.C6014R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006 "}, m1599d2 = {"Lcom/myscript/android/utils/preference/ButtonPreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "titleColor", "getTitleColor", "()I", "setTitleColor", "(I)V", "useAllCaps", "", "getUseAllCaps", "()Z", "setUseAllCaps", "(Z)V", "buttonBackgroundResId", "getButtonBackgroundResId", "setButtonBackgroundResId", "configure", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ButtonPreference extends Preference {
    public static final int $stable = 8;
    private int buttonBackgroundResId;
    private int titleColor;
    private boolean useAllCaps;

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final boolean getUseAllCaps() {
        return this.useAllCaps;
    }

    public final void setUseAllCaps(boolean z) {
        this.useAllCaps = z;
    }

    public final int getButtonBackgroundResId() {
        return this.buttonBackgroundResId;
    }

    public final void setButtonBackgroundResId(int i) {
        this.buttonBackgroundResId = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.useAllCaps = true;
        configure(attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.useAllCaps = true;
        configure(attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.useAllCaps = true;
        configure(attrs, i, i2);
    }

    private final void configure(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C6014R.styleable.ButtonPreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.titleColor = typedArrayObtainStyledAttributes.getInteger(C6014R.styleable.ButtonPreference_titleColor, 0);
            this.useAllCaps = typedArrayObtainStyledAttributes.getBoolean(C6014R.styleable.ButtonPreference_useAllCaps, true);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(C6014R.styleable.ButtonPreference_buttonBackground, 0);
            this.buttonBackgroundResId = resourceId;
            if (resourceId != 0) {
                setLayoutResource(C6014R.layout.preference_button);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View viewFindViewById = holder.findViewById(R.id.title);
        View childAt = null;
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, R.style.TextAppearance.Material.Widget.Button.Borderless.Colored);
            textView.setAllCaps(this.useAllCaps);
            int i = this.titleColor;
            if (i != 0) {
                textView.setTextColor(i);
            } else if (this.buttonBackgroundResId != 0) {
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(C4627R.attr.colorOnSurface, typedValue, true);
                textView.setTextColor(typedValue.data);
            }
        }
        if (this.buttonBackgroundResId != 0) {
            if (holder.itemView instanceof FrameLayout) {
                View view = holder.itemView;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                if (viewGroup != null) {
                    childAt = viewGroup.getChildAt(0);
                }
            } else {
                childAt = holder.itemView;
            }
            if (childAt != null) {
                childAt.setBackgroundResource(this.buttonBackgroundResId);
            }
        }
    }
}
