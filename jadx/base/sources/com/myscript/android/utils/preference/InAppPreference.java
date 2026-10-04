package com.myscript.android.utils.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.myscript.android.utils.C6014R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J \u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Lcom/myscript/android/utils/preference/InAppPreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "alreadyOwned", "", "iconDrawableRes", "title", "", "subtitle", "checkmark", "Landroid/view/View;", "value", "Lcom/myscript/android/utils/preference/InAppPreference$OnPurchaseRequestedCallback;", "onPurchaseRequestedCallback", "setOnPurchaseRequestedCallback", "(Lcom/myscript/android/utils/preference/InAppPreference$OnPurchaseRequestedCallback;)V", "onPreferenceClickedListener", "Landroidx/preference/Preference$OnPreferenceClickListener;", "configure", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "onAttached", "onDetached", "updateState", "owned", "newTitle", "purchaseRequestedCallback", "OnPurchaseRequestedCallback", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InAppPreference extends Preference {
    public static final int $stable = 8;
    private boolean alreadyOwned;
    private View checkmark;
    private int iconDrawableRes;
    private final Preference.OnPreferenceClickListener onPreferenceClickedListener;
    private OnPurchaseRequestedCallback onPurchaseRequestedCallback;
    private String subtitle;
    private String title;

    /* JADX INFO: compiled from: InAppPreference.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/android/utils/preference/InAppPreference$OnPurchaseRequestedCallback;", "", "onPurchaseRequested", "", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnPurchaseRequestedCallback {
        void onPurchaseRequested();
    }

    private final void setOnPurchaseRequestedCallback(OnPurchaseRequestedCallback onPurchaseRequestedCallback) {
        this.onPurchaseRequestedCallback = onPurchaseRequestedCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onPreferenceClickedListener$lambda$0(InAppPreference inAppPreference, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OnPurchaseRequestedCallback onPurchaseRequestedCallback = inAppPreference.onPurchaseRequestedCallback;
        if (onPurchaseRequestedCallback == null) {
            return true;
        }
        onPurchaseRequestedCallback.onPurchaseRequested();
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.title = "";
        this.subtitle = "";
        this.onPreferenceClickedListener = new Preference.OnPreferenceClickListener() { // from class: com.myscript.android.utils.preference.InAppPreference$$ExternalSyntheticLambda0
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                return InAppPreference.onPreferenceClickedListener$lambda$0(this.f$0, preference);
            }
        };
        configure(attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppPreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.title = "";
        this.subtitle = "";
        this.onPreferenceClickedListener = new Preference.OnPreferenceClickListener() { // from class: com.myscript.android.utils.preference.InAppPreference$$ExternalSyntheticLambda0
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                return InAppPreference.onPreferenceClickedListener$lambda$0(this.f$0, preference);
            }
        };
        configure(attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppPreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.title = "";
        this.subtitle = "";
        this.onPreferenceClickedListener = new Preference.OnPreferenceClickListener() { // from class: com.myscript.android.utils.preference.InAppPreference$$ExternalSyntheticLambda0
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                return InAppPreference.onPreferenceClickedListener$lambda$0(this.f$0, preference);
            }
        };
        configure(attrs, i, i2);
    }

    private final void configure(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setLayoutResource(C6014R.layout.inapp_preference);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C6014R.styleable.InAppPreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.iconDrawableRes = typedArrayObtainStyledAttributes.getResourceId(C6014R.styleable.InAppPreference_inAppIcon, 0);
            String string = typedArrayObtainStyledAttributes.getString(C6014R.styleable.InAppPreference_inAppTitle);
            String str = "";
            if (string == null) {
                string = "";
            }
            this.title = string;
            String string2 = typedArrayObtainStyledAttributes.getString(C6014R.styleable.InAppPreference_inAppSubtitle);
            if (string2 != null) {
                str = string2;
            }
            this.subtitle = str;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View viewFindViewById = holder.findViewById(C6014R.id.in_app_preference_title);
        View view = null;
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView != null) {
            textView.setText(this.title);
        }
        View viewFindViewById2 = holder.findViewById(C6014R.id.in_app_preference_subtitle);
        TextView textView2 = viewFindViewById2 instanceof TextView ? (TextView) viewFindViewById2 : null;
        if (textView2 != null) {
            textView2.setText(this.subtitle);
        }
        View viewFindViewById3 = holder.findViewById(C6014R.id.in_app_preference_icon);
        ImageView imageView = viewFindViewById3 instanceof ImageView ? (ImageView) viewFindViewById3 : null;
        if (imageView != null && (drawable = ResourcesCompat.getDrawable(imageView.getResources(), this.iconDrawableRes, imageView.getContext().getTheme())) != null) {
            imageView.setImageDrawable(drawable);
        }
        View viewFindViewById4 = holder.findViewById(C6014R.id.in_app_preference_checkmark);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setVisibility(this.alreadyOwned ? 0 : 8);
            view = viewFindViewById4;
        }
        this.checkmark = view;
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        setOnPreferenceClickListener(this.onPreferenceClickedListener);
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        setOnPreferenceClickListener(null);
        super.onDetached();
    }

    public final void updateState(boolean owned, String newTitle, OnPurchaseRequestedCallback purchaseRequestedCallback) {
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        this.alreadyOwned = owned;
        setOnPreferenceClickListener(!owned ? this.onPreferenceClickedListener : null);
        setSelectable(!owned);
        setOnPurchaseRequestedCallback(purchaseRequestedCallback);
        View view = this.checkmark;
        if (view != null) {
            view.setVisibility(owned ? 0 : 8);
        }
        this.title = newTitle;
        notifyChanged();
    }
}
