package com.myscript.nebo.settings;

import android.util.Log;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.settings.ProviderModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$cloudDisconnectedListener$1$onCloudDisconnecting$1 */
/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$cloudDisconnectedListener$1$onCloudDisconnecting$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class C6793xa30ae2e6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CloudManager.CloudProviderType $provider;
    int label;
    final /* synthetic */ SyncSettingsFragment this$0;

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$cloudDisconnectedListener$1$onCloudDisconnecting$1$WhenMappings */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloudManager.CloudProviderType.values().length];
            try {
                iArr[CloudManager.CloudProviderType.GDrive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloudManager.CloudProviderType.Dropbox.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloudManager.CloudProviderType.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6793xa30ae2e6(SyncSettingsFragment syncSettingsFragment, CloudManager.CloudProviderType cloudProviderType, Continuation<? super C6793xa30ae2e6> continuation) {
        super(2, continuation);
        this.this$0 = syncSettingsFragment;
        this.$provider = cloudProviderType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6793xa30ae2e6(this.this$0, this.$provider, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C6793xa30ae2e6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProviderModel providerModel;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.this$0.isAdded() || this.this$0.getView() == null || this.this$0.getContext() == null) {
            return Unit.INSTANCE;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.$provider.ordinal()];
        if (i == 1) {
            providerModel = SyncSettingsFragmentKt.ProviderGDrive;
        } else if (i == 2) {
            providerModel = SyncSettingsFragmentKt.ProviderDropbox;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            providerModel = null;
        }
        if (providerModel != null) {
            SyncSettingsFragment syncSettingsFragment = this.this$0;
            try {
                String string = syncSettingsFragment.getResources().getString(C6079R.string.disconnect_cloud, syncSettingsFragment.getResources().getString(providerModel.getName()));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                syncSettingsFragment.showDisconnectProgress(string);
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                Log.e(SyncSettingsFragment.TAG, "Failed to show disconnect progress", e2);
            }
        }
        return Unit.INSTANCE;
    }
}
