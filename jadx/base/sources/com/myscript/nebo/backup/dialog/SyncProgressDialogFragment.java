package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.backup.dialog.ProgressDialogFragment;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.event.OnDMSSyncStateChangedEvent;
import com.myscript.nebo.dms.event.OnGlobalNotebookSyncProgressEvent;
import com.myscript.nebo.dms.event.OnPrepareSyncProgressEvent;
import com.myscript.snt.dms.DMSSyncState;
import com.squareup.otto.Subscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncProgressDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u000f\u0010%\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020\r2\u0006\u0010(\u001a\u00020+H\u0007J\u0010\u0010,\u001a\u00020\r2\u0006\u0010(\u001a\u00020-H\u0007R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/SyncProgressDialogFragment;", "Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment;", "<init>", "()V", "value", "", "isSyncAllowed", "setSyncAllowed", "(Z)V", "isNetworkOff", "syncCallback", "Lcom/myscript/nebo/backup/dialog/SyncProgressDialogFragment$CloudSyncCallback;", "onStart", "", "onResume", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCancel", "onDestroy", "setCloudSyncCallback", "callback", "setPrepareSyncingProgress", "progress", "", "total", "numberOfNotebookToSynchronize", "setSyncingProgress", "refreshState", "setState", "syncState", "Lcom/myscript/snt/dms/DMSSyncState;", "onFinished", "onError", "resource", "cancelSync", "()Lkotlin/Unit;", "onPrepareSyncProgressEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/myscript/nebo/dms/event/OnPrepareSyncProgressEvent;", "onGlobalNotebookSyncProgressEvent", "Lcom/myscript/nebo/dms/event/OnGlobalNotebookSyncProgressEvent;", "onDMSSyncStateChangedEvent", "Lcom/myscript/nebo/dms/event/OnDMSSyncStateChangedEvent;", "CloudSyncCallback", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SyncProgressDialogFragment extends ProgressDialogFragment {
    public static final String ERROR_MESSAGE = "ERROR_MESSAGE";
    public static final String TAG = "SyncProgressDialogFragment";
    private boolean isNetworkOff = true;
    private boolean isSyncAllowed;
    private CloudSyncCallback syncCallback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SyncProgressDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/SyncProgressDialogFragment$CloudSyncCallback;", "", "syncState", "Lcom/myscript/snt/dms/DMSSyncState;", "getSyncState", "()Lcom/myscript/snt/dms/DMSSyncState;", "onSync", "", "onCancelSync", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface CloudSyncCallback {
        DMSSyncState getSyncState();

        void onCancelSync();

        void onSync();
    }

    /* JADX INFO: compiled from: SyncProgressDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMSSyncState.values().length];
            try {
                iArr[DMSSyncState.CLOUD_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DMSSyncState.UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void setSyncAllowed(boolean z) {
        this.isSyncAllowed = z;
        refreshState();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainThreadBus.eventBus.register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshState();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainThreadBus.eventBus.unregister(this);
        super.onStop();
    }

    @Override // com.myscript.nebo.backup.dialog.ProgressDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().observe(this, new SyncProgressDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.backup.dialog.SyncProgressDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SyncProgressDialogFragment.onCreateDialog$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        }));
        CloudSyncCallback cloudSyncCallback = this.syncCallback;
        if (cloudSyncCallback != null) {
            cloudSyncCallback.onSync();
        }
        return super.onCreateDialog(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateDialog$lambda$0(SyncProgressDialogFragment syncProgressDialogFragment, NeboNetworkState neboNetworkState) {
        syncProgressDialogFragment.isNetworkOff = neboNetworkState instanceof NeboNetworkState.Offline;
        syncProgressDialogFragment.setSyncAllowed(neboNetworkState.isDataTransferAllowed());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.myscript.nebo.backup.dialog.ProgressDialogFragment
    public void onCancel() {
        cancelSync();
        super.onCancel();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.syncCallback = null;
        super.onDestroy();
    }

    public final void setCloudSyncCallback(CloudSyncCallback callback) {
        this.syncCallback = callback;
    }

    private final void setPrepareSyncingProgress(int progress, int total, int numberOfNotebookToSynchronize) {
        ProgressDialog progressDialog = getProgressDialog();
        if (progressDialog != null) {
            progressDialog.setProgressNumberFormat(progressDialog.getContext().getString(C6079R.string.backup_sync_prepare_folders, Integer.valueOf(numberOfNotebookToSynchronize)));
            progressDialog.setIndeterminate(false);
            progressDialog.setMax(total);
            progressDialog.setProgress(progress);
        }
    }

    private final void setSyncingProgress(int progress, int total, int numberOfNotebookToSynchronize) {
        ProgressDialog progressDialog = getProgressDialog();
        if (progressDialog != null) {
            progressDialog.setProgressNumberFormat(progressDialog.getContext().getString(C6079R.string.backup_to_sync_folders, Integer.valueOf(numberOfNotebookToSynchronize)));
            progressDialog.setIndeterminate(false);
            progressDialog.setMax(total);
            progressDialog.setProgress(progress);
        }
    }

    private final void refreshState() {
        DMSSyncState syncState;
        CloudSyncCallback cloudSyncCallback = this.syncCallback;
        if (cloudSyncCallback == null || (syncState = cloudSyncCallback.getSyncState()) == null) {
            syncState = DMSSyncState.NONE;
        }
        setState(syncState);
    }

    private final void setState(DMSSyncState syncState) {
        if (this.isNetworkOff) {
            onError(C6208R.string.sync_header_offline);
            return;
        }
        if (!this.isSyncAllowed) {
            onError(C6208R.string.sync_header_cellular);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[syncState.ordinal()];
        if (i == 1) {
            onError(C6208R.string.sync_header_paused);
        } else {
            if (i != 2) {
                return;
            }
            onFinished();
        }
    }

    private final void onFinished() {
        if (isAdded()) {
            dismiss();
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), -1, null);
            }
        }
    }

    private final void onError(int resource) {
        String string;
        Resources resources;
        if (isAdded()) {
            Bundle bundle = new Bundle();
            Context context = getContext();
            if (context == null || (resources = context.getResources()) == null || (string = resources.getString(resource)) == null) {
                string = "";
            }
            bundle.putString(ERROR_MESSAGE, string);
            bundle.putInt("RESULT_CODE", ProgressDialogFragment.ProgressDialogResult.Error.ordinal());
            dismiss();
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), 0, intentPutExtras);
            }
        }
    }

    private final Unit cancelSync() {
        CloudSyncCallback cloudSyncCallback = this.syncCallback;
        if (cloudSyncCallback == null) {
            return null;
        }
        cloudSyncCallback.onCancelSync();
        return Unit.INSTANCE;
    }

    @Subscribe
    public final void onPrepareSyncProgressEvent(OnPrepareSyncProgressEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        setPrepareSyncingProgress(event.getAmountDone(), event.getTotalAmount(), event.getNumberOfNotebookToSynchronize());
    }

    @Subscribe
    public final void onGlobalNotebookSyncProgressEvent(OnGlobalNotebookSyncProgressEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        setSyncingProgress(event.getAmountDone(), event.getTotalAmount(), event.getNumberOfNotebookToSynchronize());
    }

    @Subscribe
    public final void onDMSSyncStateChangedEvent(OnDMSSyncStateChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DMSSyncState mSyncState = event.mSyncState;
        Intrinsics.checkNotNullExpressionValue(mSyncState, "mSyncState");
        setState(mSyncState);
    }

    /* JADX INFO: compiled from: SyncProgressDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/SyncProgressDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", SyncProgressDialogFragment.ERROR_MESSAGE, "newInstance", "Lcom/myscript/nebo/backup/dialog/SyncProgressDialogFragment;", "title", "message", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SyncProgressDialogFragment newInstance(String title, String message) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            SyncProgressDialogFragment syncProgressDialogFragment = new SyncProgressDialogFragment();
            ProgressDialogFragment.setupArguments$default(syncProgressDialogFragment, title, message, false, false, 12, null);
            return syncProgressDialogFragment;
        }
    }
}
