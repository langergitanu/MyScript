package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.preference.ButtonPreference;
import com.myscript.android.utils.preference.RangePreference;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextDisplaySettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010!\u001a\u00020\u0019H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Lcom/myscript/nebo/settings/TextDisplaySettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "previewPreference", "Lcom/myscript/nebo/settings/PagePreviewPreference;", "resetPref", "Lcom/myscript/android/utils/preference/ButtonPreference;", "lineHeightPref", "Lcom/myscript/android/utils/preference/RangePreference;", "fontSizePref", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "onUnbindPreferences", "updateResetState", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextDisplaySettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final String TAG = "TextDisplaySettingsFragment";
    private RangePreference fontSizePref;
    private RangePreference lineHeightPref;
    private Navigator navigator;
    private PagePreviewPreference previewPreference;
    private ButtonPreference resetPref;
    public static final int $stable = 8;

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_text_display;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.text_display_settings);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.fontSizePref = (RangePreference) findPreference(getString(C6079R.string.pref_font_size_key));
        this.lineHeightPref = (RangePreference) findPreference(getString(C6079R.string.pref_line_height_key));
        this.resetPref = (ButtonPreference) findPreference(getString(C6079R.string.pref_text_display_reset_key));
        final PagePreviewPreference pagePreviewPreference = (PagePreviewPreference) findPreference(getString(C6079R.string.pref_pagepreview_key));
        if (pagePreviewPreference != null) {
            RangePreference rangePreference = this.fontSizePref;
            String key = rangePreference != null ? rangePreference.getKey() : null;
            TypedValue typedValue = new TypedValue();
            getResources().getValue(C6079R.dimen.pref_font_size_default_value, typedValue, true);
            float f = typedValue.getFloat();
            SharedPreferences sharedPreferences = pagePreviewPreference.getSharedPreferences();
            if (sharedPreferences != null) {
                pagePreviewPreference.setFontSize(sharedPreferences.getFloat(key, f));
            }
            RangePreference rangePreference2 = this.lineHeightPref;
            String key2 = rangePreference2 != null ? rangePreference2.getKey() : null;
            getResources().getValue(C6079R.dimen.pref_line_height_default_value, typedValue, true);
            float f2 = typedValue.getFloat();
            SharedPreferences sharedPreferences2 = pagePreviewPreference.getSharedPreferences();
            if (sharedPreferences2 != null) {
                pagePreviewPreference.setLineHeight(sharedPreferences2.getFloat(key2, f2));
            }
        } else {
            pagePreviewPreference = null;
        }
        this.previewPreference = pagePreviewPreference;
        if (pagePreviewPreference != null) {
            RangePreference rangePreference3 = this.fontSizePref;
            if (rangePreference3 != null) {
                rangePreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.TextDisplaySettingsFragment$$ExternalSyntheticLambda0
                    @Override // androidx.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        return TextDisplaySettingsFragment.onViewCreated$lambda$1$0(pagePreviewPreference, this, preference, obj);
                    }
                });
            }
            RangePreference rangePreference4 = this.lineHeightPref;
            if (rangePreference4 != null) {
                rangePreference4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.TextDisplaySettingsFragment$$ExternalSyntheticLambda1
                    @Override // androidx.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        return TextDisplaySettingsFragment.onViewCreated$lambda$1$1(pagePreviewPreference, this, preference, obj);
                    }
                });
            }
            ComponentCallbacks2 application = requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
            ((ColorPolicyRepositoryProvider) application).provideColorPolicyRepository().getColorPolicy().observe(getViewLifecycleOwner(), new TextDisplaySettingsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.settings.TextDisplaySettingsFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextDisplaySettingsFragment.onViewCreated$lambda$1$2(pagePreviewPreference, (IColorInversionPolicy) obj);
                }
            }));
        }
        ButtonPreference buttonPreference = this.resetPref;
        if (buttonPreference != null) {
            buttonPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.TextDisplaySettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return TextDisplaySettingsFragment.onViewCreated$lambda$2(this.f$0, preference);
                }
            });
        }
        updateResetState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(PagePreviewPreference pagePreviewPreference, TextDisplaySettingsFragment textDisplaySettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        pagePreviewPreference.setFontSize(((Float) obj).floatValue());
        textDisplaySettingsFragment.updateResetState();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$1(PagePreviewPreference pagePreviewPreference, TextDisplaySettingsFragment textDisplaySettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        pagePreviewPreference.setLineHeight(((Float) obj).floatValue());
        textDisplaySettingsFragment.updateResetState();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1$2(PagePreviewPreference pagePreviewPreference, IColorInversionPolicy iColorInversionPolicy) {
        Intrinsics.checkNotNull(iColorInversionPolicy);
        pagePreviewPreference.setColorPolicy(iColorInversionPolicy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2(TextDisplaySettingsFragment textDisplaySettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RangePreference rangePreference = textDisplaySettingsFragment.fontSizePref;
        if (rangePreference != null) {
            rangePreference.reset();
        }
        RangePreference rangePreference2 = textDisplaySettingsFragment.lineHeightPref;
        if (rangePreference2 == null) {
            return true;
        }
        rangePreference2.reset();
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    protected void onUnbindPreferences() {
        RangePreference rangePreference = this.fontSizePref;
        if (rangePreference != null) {
            rangePreference.setOnPreferenceChangeListener(null);
        }
        RangePreference rangePreference2 = this.lineHeightPref;
        if (rangePreference2 != null) {
            rangePreference2.setOnPreferenceChangeListener(null);
        }
        ButtonPreference buttonPreference = this.resetPref;
        if (buttonPreference != null) {
            buttonPreference.setOnPreferenceClickListener(null);
        }
        getPreferenceManager().setOnNavigateToScreenListener(null);
    }

    private final void updateResetState() {
        RangePreference rangePreference = this.fontSizePref;
        float defaultValue = rangePreference != null ? rangePreference.getDefaultValue() : -1.0f;
        RangePreference rangePreference2 = this.fontSizePref;
        float value = rangePreference2 != null ? rangePreference2.getValue() : -1.0f;
        RangePreference rangePreference3 = this.lineHeightPref;
        float defaultValue2 = rangePreference3 != null ? rangePreference3.getDefaultValue() : -1.0f;
        RangePreference rangePreference4 = this.lineHeightPref;
        float value2 = rangePreference4 != null ? rangePreference4.getValue() : -1.0f;
        ButtonPreference buttonPreference = this.resetPref;
        if (buttonPreference != null) {
            buttonPreference.setEnabled((value == defaultValue && value2 == defaultValue2) ? false : true);
        }
    }
}
