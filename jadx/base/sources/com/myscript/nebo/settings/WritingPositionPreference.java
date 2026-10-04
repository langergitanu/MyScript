package com.myscript.nebo.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.WritingPosition;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WritingPositionPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/settings/WritingPositionPreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultPositionViewId", "", "selectedButton", "Landroid/view/View;", "onSetInitialValue", "", "defaultValue", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "toggle", "button", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WritingPositionPreference extends Preference {
    public static final int $stable = 8;
    private int defaultPositionViewId;
    private View selectedButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WritingPositionPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setWidgetLayoutResource(C6079R.layout.preference_writing_position);
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object defaultValue) {
        String strSerialize = defaultValue instanceof String ? (String) defaultValue : null;
        if (strSerialize == null) {
            strSerialize = WritingPosition.Undefined.serialize();
        }
        WritingPosition.Companion companion = WritingPosition.INSTANCE;
        String persistedString = getPersistedString(strSerialize);
        Intrinsics.checkNotNullExpressionValue(persistedString, "getPersistedString(...)");
        this.defaultPositionViewId = WritingPositionPreferenceKt.toResourceId(companion.deserialize(persistedString));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        int i = this.defaultPositionViewId;
        if (i != 0) {
            View viewFindViewById = holder.findViewById(i);
            this.selectedButton = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setSelected(true);
            }
        }
        holder.itemView.setClickable(false);
        holder.itemView.getRootView().getLayoutParams().height = -1;
        holder.findViewById(C6079R.id.writing_position_left_top).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
        holder.findViewById(C6079R.id.writing_position_right_top).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
        holder.findViewById(C6079R.id.writing_position_left_middle).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
        holder.findViewById(C6079R.id.writing_position_right_middle).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
        holder.findViewById(C6079R.id.writing_position_left_bottom).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
        holder.findViewById(C6079R.id.writing_position_right_bottom).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.settings.WritingPositionPreference$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggle(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggle(View button) {
        View view = this.selectedButton;
        if (view != null) {
            view.setSelected(false);
        }
        button.setSelected(!button.isSelected());
        this.selectedButton = button;
        persistString(WritingPositionPreferenceKt.fromResourceId(WritingPosition.INSTANCE, button.getId()).serialize());
    }
}
