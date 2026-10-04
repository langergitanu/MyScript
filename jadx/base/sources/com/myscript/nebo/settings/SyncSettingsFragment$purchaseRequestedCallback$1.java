package com.myscript.nebo.settings;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.myscript.android.utils.preference.InAppPreference;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m1599d2 = {"com/myscript/nebo/settings/SyncSettingsFragment$purchaseRequestedCallback$1", "Lcom/myscript/android/utils/preference/InAppPreference$OnPurchaseRequestedCallback;", "onPurchaseRequested", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SyncSettingsFragment$purchaseRequestedCallback$1 implements InAppPreference.OnPurchaseRequestedCallback {
    final /* synthetic */ SyncSettingsFragment this$0;

    SyncSettingsFragment$purchaseRequestedCallback$1(SyncSettingsFragment syncSettingsFragment) {
        this.this$0 = syncSettingsFragment;
    }

    @Override // com.myscript.android.utils.preference.InAppPreference.OnPurchaseRequestedCallback
    public void onPurchaseRequested() {
        this.this$0.purchaseFlowRequested = true;
        NeboFirebaseEvent.PaywallModalDisplay.log(new Function1() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$purchaseRequestedCallback$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SyncSettingsFragment$purchaseRequestedCallback$1.onPurchaseRequested$lambda$0((Bundle) obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C6796xf026a9a1(this.this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPurchaseRequested$lambda$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", "panel_settings_cta");
        return Unit.INSTANCE;
    }
}
