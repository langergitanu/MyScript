package com.myscript.nebo.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BadgesPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/settings/BadgesPreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "badgeCount", "hasFullAccess", "", "isPremiumFeature", "showChildIndicator", "showSimpleBadge", "websiteUrl", "", "configure", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setBadgeCount", "count", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BadgesPreference extends Preference {
    public static final int $stable = 8;
    private int badgeCount;
    private boolean hasFullAccess;
    private boolean isPremiumFeature;
    private boolean showChildIndicator;
    private boolean showSimpleBadge;
    private String websiteUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgesPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(context, attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgesPreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(context, attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgesPreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(context, attrs, i, i2);
    }

    private final void configure(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        UserProfileManager userProfileManagerProvideUserProfileManager;
        setWidgetLayoutResource(C6079R.layout.preference_badges);
        Context applicationContext = context.getApplicationContext();
        NeboApplication neboApplication = applicationContext instanceof NeboApplication ? (NeboApplication) applicationContext : null;
        this.hasFullAccess = (neboApplication == null || (userProfileManagerProvideUserProfileManager = neboApplication.provideUserProfileManager()) == null) ? false : userProfileManagerProvideUserProfileManager.hasAccessToAllFeatures();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C6079R.styleable.BadgesPreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.isPremiumFeature = typedArrayObtainStyledAttributes.getBoolean(C6079R.styleable.BadgesPreference_premiumFeature, false);
            this.websiteUrl = typedArrayObtainStyledAttributes.getString(C6079R.styleable.BadgesPreference_website_url);
            this.showChildIndicator = typedArrayObtainStyledAttributes.getBoolean(C6079R.styleable.BadgesPreference_showChildIndicator, false);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View viewFindViewById = holder.findViewById(C6079R.id.preference_badge_count);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setVisibility(this.badgeCount > 0 ? 0 : 8);
        textView.setText(String.valueOf(this.badgeCount));
        View viewFindViewById2 = holder.findViewById(C6079R.id.preference_widget_new_feature);
        Intrinsics.checkNotNull(viewFindViewById2);
        viewFindViewById2.setVisibility(this.showSimpleBadge ? 0 : 8);
        if (this.showChildIndicator && this.badgeCount == 0) {
            holder.findViewById(C6079R.id.preference_widget_icon_caret).setVisibility(0);
        }
        View viewFindViewById3 = holder.findViewById(C6079R.id.preference_widget_badge);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewFindViewById3;
        if (this.isPremiumFeature && !this.hasFullAccess) {
            imageView.setImageResource(C6079R.drawable.ic_lock);
        } else {
            imageView.setImageDrawable(null);
        }
        if (this.websiteUrl != null) {
            imageView.setImageResource(C6079R.drawable.ic_open_in);
            setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.BadgesPreference$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return BadgesPreference.onBindViewHolder$lambda$0(this.f$0, preference);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0(BadgesPreference badgesPreference, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PlatformUtils.openUrl(badgesPreference.getContext(), badgesPreference.websiteUrl);
        return true;
    }

    public final void setBadgeCount(int count) {
        this.badgeCount = count;
        notifyChanged();
    }
}
