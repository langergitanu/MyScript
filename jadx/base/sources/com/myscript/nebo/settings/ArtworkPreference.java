package com.myscript.nebo.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.myscript.nebo.C6079R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArtworkPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/settings/ArtworkPreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "artworkDrawable", "Landroid/graphics/drawable/Drawable;", "configure", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ArtworkPreference extends Preference {
    public static final int $stable = 8;
    private Drawable artworkDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtworkPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtworkPreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtworkPreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        configure(attrs, i, i2);
    }

    private final void configure(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setLayoutResource(C6079R.layout.artwork_preference);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C6079R.styleable.ArtworkPreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.artworkDrawable = typedArrayObtainStyledAttributes.getDrawable(C6079R.styleable.ArtworkPreference_artworkDrawable);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        holder.itemView.setClickable(false);
        View viewFindViewById = holder.findViewById(C6079R.id.artwork_preference_illustration);
        ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
        if (imageView != null) {
            imageView.setImageDrawable(this.artworkDrawable);
        }
    }
}
