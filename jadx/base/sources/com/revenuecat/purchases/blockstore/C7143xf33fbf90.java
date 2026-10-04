package com.revenuecat.purchases.blockstore;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0 */
/* JADX INFO: compiled from: BlockstoreHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
final class C7143xf33fbf90 implements OnSuccessListener {
    private final /* synthetic */ Function1 function;

    C7143xf33fbf90(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        this.function.invoke(obj);
    }
}
