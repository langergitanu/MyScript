package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0018H\u0002R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/settings/NetworkSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "onCellularPrefToggled", "enabled", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NetworkSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final int $stable = 8;
    private Navigator navigator;

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
        addPreferencesFromResource(C6079R.xml.network_settings);
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_network_title;
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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_network_cellular_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.NetworkSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return NetworkSettingsFragment.onViewCreated$lambda$0(view, this, preference, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(View view, final NetworkSettingsFragment networkSettingsFragment, Preference preference, final Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        view.post(new Runnable() { // from class: com.myscript.nebo.settings.NetworkSettingsFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkSettingsFragment.onViewCreated$lambda$0$0(this.f$0, obj);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0(NetworkSettingsFragment networkSettingsFragment, Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        networkSettingsFragment.onCellularPrefToggled(((Boolean) obj).booleanValue());
    }

    private final void onCellularPrefToggled(boolean enabled) {
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().setDownloadOverCellularEnabled(enabled);
    }
}
