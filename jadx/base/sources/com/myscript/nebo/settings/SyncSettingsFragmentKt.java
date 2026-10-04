package com.myscript.nebo.settings;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.settings.ProviderModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, m1599d2 = {"ProviderDropbox", "Lcom/myscript/nebo/cloudsync/settings/ProviderModel;", "ProviderGDrive", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SyncSettingsFragmentKt {
    private static final ProviderModel ProviderDropbox = new ProviderModel(1, CloudManager.CloudProviderType.Dropbox, C6079R.string.cloud_provider_dropbox, C6079R.drawable.ic_dropbox);
    private static final ProviderModel ProviderGDrive = new ProviderModel(0, CloudManager.CloudProviderType.GDrive, C6079R.string.cloud_provider_gdrive, C6079R.drawable.ic_gdrive);
}
