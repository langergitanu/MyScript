package com.myscript.nebo.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.HapticFeedbackManagerFactoryImpl;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.editing.HapticFeedbackManager;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.PenDetectionDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PenSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/settings/PenSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "isActivePenChecked", "", "penDetectionCallback", "Lcom/myscript/nebo/penpanel/PenDetectionDialog$Callback;", "onMenuItemClicked", "menuItem", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "onSaveInstanceState", "outState", "onWritingPositionSettingsRequested", "onDestroy", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PenSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    private static final String USE_ACTIVE_PEN_CHECKED = "USE_ACTIVE_PEN_CHECKED";
    private boolean isActivePenChecked;
    private Navigator navigator;
    private PenDetectionDialog.Callback penDetectionCallback = new PenDetectionDialog.Callback() { // from class: com.myscript.nebo.settings.PenSettingsFragment$penDetectionCallback$1
        @Override // com.myscript.nebo.penpanel.PenDetectionDialog.Callback
        public void onPenDetectionClosed(boolean penDetected, boolean aborted) {
            PenSettingsFragment penSettingsFragment = this.this$0;
            SwitchPreference switchPreference = (SwitchPreference) penSettingsFragment.findPreference(penSettingsFragment.getString(C6693R.string.pref_cpi_smartpen_key));
            boolean zIsChecked = switchPreference != null ? switchPreference.isChecked() : false;
            if (penDetected) {
                CommonUtils.savePenUsed(this.this$0.getContext(), true);
                CommonUtils.saveActivePenMode(this.this$0.getContext(), zIsChecked);
            } else if (switchPreference != null) {
                switchPreference.setChecked(false);
            }
        }
    };
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

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.pen_settings);
        if (savedInstanceState != null) {
            this.isActivePenChecked = savedInstanceState.getBoolean(USE_ACTIVE_PEN_CHECKED);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(PenDetectionDialog.TAG);
                PenDetectionDialog penDetectionDialog = fragmentFindFragmentByTag instanceof PenDetectionDialog ? (PenDetectionDialog) fragmentFindFragmentByTag : null;
                if (penDetectionDialog != null) {
                    penDetectionDialog.setCallback(this.penDetectionCallback);
                }
            }
        }
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_cpi_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Preference preferenceFindPreference = findPreference(getString(C6693R.string.pref_cpi_writing_position_category_key));
        if (preferenceFindPreference != null && preferenceFindPreference.isVisible()) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.PenSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return PenSettingsFragment.onViewCreated$lambda$0$0(this.f$0, preference);
                }
            });
        }
        final SwitchPreference switchPreference = (SwitchPreference) findPreference(getString(C6693R.string.pref_cpi_smartpen_key));
        boolean zIsDeviceCapable = false;
        if (switchPreference != null) {
            switchPreference.setChecked(this.isActivePenChecked || CommonUtils.isActivePenMode(switchPreference.getContext()));
            switchPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.PenSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return PenSettingsFragment.onViewCreated$lambda$1$0(switchPreference, this, preference);
                }
            });
        }
        SwitchPreference switchPreference2 = (SwitchPreference) findPreference(getString(C6693R.string.pref_pen_haptic_feedback_key));
        if (switchPreference2 != null) {
            if (getResources().getBoolean(C6079R.bool.enable_haptic_feedback_check)) {
                HapticFeedbackManager hapticFeedbackManagerCreateHapticFeedbackManager = new HapticFeedbackManagerFactoryImpl().createHapticFeedbackManager();
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                zIsDeviceCapable = hapticFeedbackManagerCreateHapticFeedbackManager.isDeviceCapable(contextRequireContext);
            }
            switchPreference2.setVisible(zIsDeviceCapable);
            switchPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.PenSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return PenSettingsFragment.onViewCreated$lambda$2$0(preference);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0$0(PenSettingsFragment penSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        penSettingsFragment.onWritingPositionSettingsRequested();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(SwitchPreference switchPreference, PenSettingsFragment penSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean zIsChecked = ((SwitchPreference) it).isChecked();
        if (!CommonUtils.isPenUsed(switchPreference.getContext()) && zIsChecked) {
            FragmentActivity activity = penSettingsFragment.getActivity();
            if (activity != null) {
                PenDetectionDialog penDetectionDialogNewInstance$default = PenDetectionDialog.Companion.newInstance$default(PenDetectionDialog.INSTANCE, false, 1, null);
                penDetectionDialogNewInstance$default.setCallback(penSettingsFragment.penDetectionCallback);
                penDetectionDialogNewInstance$default.show(activity.getSupportFragmentManager(), PenDetectionDialog.TAG);
            }
        } else {
            CommonUtils.saveActivePenMode(switchPreference.getContext(), zIsChecked);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0(Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        new HapticFeedbackManagerFactoryImpl().createHapticFeedbackManager().setEnable(((SwitchPreference) it).isChecked());
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SwitchPreference switchPreference = (SwitchPreference) findPreference(getString(C6693R.string.pref_cpi_smartpen_key));
        if (switchPreference != null) {
            outState.putBoolean(USE_ACTIVE_PEN_CHECKED, switchPreference.isChecked());
        }
        super.onSaveInstanceState(outState);
    }

    private final void onWritingPositionSettingsRequested() {
        Navigator navigator = getNavigator();
        if (navigator != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WritingPositionSettingsFragment onWritingPositionSettingsRequested$lambda$0() {
        return new WritingPositionSettingsFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.penDetectionCallback = null;
        super.onDestroy();
    }
}
