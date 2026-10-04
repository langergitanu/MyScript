package com.myscript.nebo.sidenavigation;

import com.myscript.nebo.settings.SyncSettingsFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: SidePanelFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class SidePanelFragment$showSyncSettingsFragment$1$1 extends FunctionReferenceImpl implements Function0<SyncSettingsFragment> {
    public static final SidePanelFragment$showSyncSettingsFragment$1$1 INSTANCE = new SidePanelFragment$showSyncSettingsFragment$1$1();

    SidePanelFragment$showSyncSettingsFragment$1$1() {
        super(0, SyncSettingsFragment.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SyncSettingsFragment invoke() {
        return new SyncSettingsFragment();
    }
}
