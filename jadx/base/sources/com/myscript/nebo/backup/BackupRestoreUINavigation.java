package com.myscript.nebo.backup;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.backup.BackupState;
import com.myscript.nebo.backup.RestoreState;
import com.myscript.nebo.backup.dialog.BackupProgressDialogFragment;
import com.myscript.nebo.backup.dialog.ConfirmRestoreDialogFragment;
import com.myscript.nebo.backup.dialog.ConfirmSyncDialogFragment;
import com.myscript.nebo.backup.dialog.InformationDialogFragment;
import com.myscript.nebo.backup.dialog.ProgressDialogFragment;
import com.myscript.nebo.backup.dialog.RestoreProgressDialogFragment;
import com.myscript.nebo.backup.dialog.SyncProgressDialogFragment;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.export.ExportHelper;
import com.myscript.snt.dms.DMSSyncState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupRestoreUINavigation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0019\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0004YZ[\\B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\rJ\u0010\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\rH\u0002J\u0006\u0010'\u001a\u00020$J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\tH\u0002J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0016\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020:H\u0082@¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J\b\u0010A\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\tH\u0002J\b\u0010D\u001a\u00020$H\u0002J\b\u0010E\u001a\u00020$H\u0002J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002J\b\u0010H\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0002J\b\u0010J\u001a\u00020$H\u0002J \u0010K\u001a\u00020$2\u0006\u0010L\u001a\u0002012\u0006\u0010M\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010OJ\u000e\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020RJ\u0010\u0010S\u001a\u00020$2\b\u0010T\u001a\u0004\u0018\u00010RJ\b\u0010U\u001a\u00020$H\u0002J\u0006\u0010V\u001a\u00020\rJ\u0006\u0010W\u001a\u00020$J\b\u0010X\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010(\u001a\u0012\u0012\f\u0012\n **\u0004\u0018\u00010\t0\t\u0018\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreUINavigation;", "", "backupRestoreContext", "Lcom/myscript/nebo/backup/BackupRestoreUINavigation$IBackupRestoreContext;", "viewModel", "Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "<init>", "(Lcom/myscript/nebo/backup/BackupRestoreUINavigation$IBackupRestoreContext;Lcom/myscript/nebo/backup/BackupRestoreViewModel;)V", "lastBackupPath", "", "lastRestorePath", "lastRestoreName", "dialogSequence", "", "getDialogSequence", "()Z", "setDialogSequence", "(Z)V", "exportIntentSent", "getExportIntentSent", "setExportIntentSent", "legacyBackupRequested", "getLegacyBackupRequested", "setLegacyBackupRequested", "onCloudSyncStatusRequested", "com/myscript/nebo/backup/BackupRestoreUINavigation$onCloudSyncStatusRequested$1", "Lcom/myscript/nebo/backup/BackupRestoreUINavigation$onCloudSyncStatusRequested$1;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "onSyncAndBackupNotebooks", "", "useLegacyFormat", "onBackupNotebooks", "onRestoreNotebooks", "getContent", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "showConfirmDialogFragment", "showSyncProgressFragment", "syncNotebooks", "showSyncErrorMessage", "showConflictedPagesFound", "count", "", "showNotEnoughSpaceDialog", "message", "showBackupNotEnoughSpaceDialog", "requiredSize", "", "showBackupErrorDialog", "showSyncOngoingErrorDialog", "getBackupInformation", "Lcom/myscript/nebo/backup/BackupRestoreUINavigation$BackupInformation;", "uri", "Landroid/net/Uri;", "prepareRestoreNotebooks", TtmlNode.TAG_INFORMATION, "(Lcom/myscript/nebo/backup/BackupRestoreUINavigation$BackupInformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showRestoreNotEnoughSpaceDialog", "showCopyErrorDialog", "confirmRestoreArchive", "backupFileName", "showVerifyErrorDialog", "restoreArchive", "showRestoredToast", "showRestoreErrorDialog", "onBackupRestoreRequested", "onBackupCancelRequested", "onRestoreCancelRequested", "onParentFragmentNotifyActivityResult", "requestCode", "resultCode", "returnIntent", "Landroid/content/Intent;", "saveInstanceState", "outState", "Landroid/os/Bundle;", "restoreInstanceState", "savedInstanceState", "updateSettings", "isInScreenSequence", "settingsFragmentResumed", "requireContext", "BackupRestoreAction", "IBackupRestoreContext", "BackupInformation", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupRestoreUINavigation {
    private static final boolean DBG = false;
    private static final String LAST_BACKUP_PATH = "LAST_BACKUP_PATH";
    private static final String LAST_RESTORE_NAME = "LAST_RESTORE_NAME";
    private static final String LAST_RESTORE_PATH = "LAST_RESTORE_PATH";
    private static final String MIME_TYPE_WILD_CARD = "*/*";
    private static final String TAG = "BackupRestoreUINav";
    private final IBackupRestoreContext backupRestoreContext;
    private boolean dialogSequence;
    private boolean exportIntentSent;
    private final ActivityResultLauncher<String> getContent;
    private String lastBackupPath;
    private String lastRestoreName;
    private String lastRestorePath;
    private boolean legacyBackupRequested;
    private final BackupRestoreUINavigation$onCloudSyncStatusRequested$1 onCloudSyncStatusRequested;
    private final BackupRestoreViewModel viewModel;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BackupRestoreUINavigation.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreUINavigation$IBackupRestoreContext;", "", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "isFragmentReady", "", "()Z", "updateSettingsItems", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IBackupRestoreContext {
        Fragment getFragment();

        boolean isFragmentReady();

        void updateSettingsItems();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.backup.BackupRestoreUINavigation$prepareRestoreNotebooks$1 */
    /* JADX INFO: compiled from: BackupRestoreUINavigation.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.backup.BackupRestoreUINavigation", m1609f = "BackupRestoreUINavigation.kt", m1610i = {0, 0, 0}, m1611l = {308}, m1612m = "prepareRestoreNotebooks", m1613n = {TtmlNode.TAG_INFORMATION, WebViewMessageType.CONTEXT, "$i$a$-let-BackupRestoreUINavigation$prepareRestoreNotebooks$2"}, m1614nl = {311}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C61511 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C61511(Continuation<? super C61511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackupRestoreUINavigation.this.prepareRestoreNotebooks(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.myscript.nebo.backup.BackupRestoreUINavigation$onCloudSyncStatusRequested$1] */
    public BackupRestoreUINavigation(IBackupRestoreContext backupRestoreContext, BackupRestoreViewModel viewModel) {
        Intrinsics.checkNotNullParameter(backupRestoreContext, "backupRestoreContext");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.backupRestoreContext = backupRestoreContext;
        this.viewModel = viewModel;
        this.onCloudSyncStatusRequested = new SyncProgressDialogFragment.CloudSyncCallback() { // from class: com.myscript.nebo.backup.BackupRestoreUINavigation$onCloudSyncStatusRequested$1
            @Override // com.myscript.nebo.backup.dialog.SyncProgressDialogFragment.CloudSyncCallback
            public DMSSyncState getSyncState() {
                return this.this$0.viewModel.getCloudSyncState();
            }

            @Override // com.myscript.nebo.backup.dialog.SyncProgressDialogFragment.CloudSyncCallback
            public void onSync() {
                this.this$0.viewModel.triggerCloudSync();
            }

            @Override // com.myscript.nebo.backup.dialog.SyncProgressDialogFragment.CloudSyncCallback
            public void onCancelSync() {
                this.this$0.viewModel.cancelCloudSync();
            }
        };
        Fragment fragment = backupRestoreContext.getFragment();
        this.getContent = fragment != null ? fragment.registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.myscript.nebo.backup.BackupRestoreUINavigation$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BackupRestoreUINavigation.getContent$lambda$0(this.f$0, (Uri) obj);
            }
        }) : null;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: BackupRestoreUINavigation.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreUINavigation$BackupRestoreAction;", "", "<init>", "(Ljava/lang/String;I)V", "SyncConfirm", "SyncProgress", "SyncConflictedPages", "SyncError", "BackupProgress", "BackupError", "RestoreSelect", "RestoreConfirm", "CopyError", "VerifyError", "RestoreProgress", "RestoreError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BackupRestoreAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BackupRestoreAction[] $VALUES;
        public static final BackupRestoreAction SyncConfirm = new BackupRestoreAction("SyncConfirm", 0);
        public static final BackupRestoreAction SyncProgress = new BackupRestoreAction("SyncProgress", 1);
        public static final BackupRestoreAction SyncConflictedPages = new BackupRestoreAction("SyncConflictedPages", 2);
        public static final BackupRestoreAction SyncError = new BackupRestoreAction("SyncError", 3);
        public static final BackupRestoreAction BackupProgress = new BackupRestoreAction("BackupProgress", 4);
        public static final BackupRestoreAction BackupError = new BackupRestoreAction("BackupError", 5);
        public static final BackupRestoreAction RestoreSelect = new BackupRestoreAction("RestoreSelect", 6);
        public static final BackupRestoreAction RestoreConfirm = new BackupRestoreAction("RestoreConfirm", 7);
        public static final BackupRestoreAction CopyError = new BackupRestoreAction("CopyError", 8);
        public static final BackupRestoreAction VerifyError = new BackupRestoreAction("VerifyError", 9);
        public static final BackupRestoreAction RestoreProgress = new BackupRestoreAction("RestoreProgress", 10);
        public static final BackupRestoreAction RestoreError = new BackupRestoreAction("RestoreError", 11);

        private static final /* synthetic */ BackupRestoreAction[] $values() {
            return new BackupRestoreAction[]{SyncConfirm, SyncProgress, SyncConflictedPages, SyncError, BackupProgress, BackupError, RestoreSelect, RestoreConfirm, CopyError, VerifyError, RestoreProgress, RestoreError};
        }

        public static EnumEntries<BackupRestoreAction> getEntries() {
            return $ENTRIES;
        }

        public static BackupRestoreAction valueOf(String str) {
            return (BackupRestoreAction) Enum.valueOf(BackupRestoreAction.class, str);
        }

        public static BackupRestoreAction[] values() {
            return (BackupRestoreAction[]) $VALUES.clone();
        }

        private BackupRestoreAction(String str, int i) {
        }

        static {
            BackupRestoreAction[] backupRestoreActionArr$values = $values();
            $VALUES = backupRestoreActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(backupRestoreActionArr$values);
        }
    }

    public final boolean getDialogSequence() {
        return this.dialogSequence;
    }

    public final void setDialogSequence(boolean z) {
        this.dialogSequence = z;
    }

    public final boolean getExportIntentSent() {
        return this.exportIntentSent;
    }

    public final void setExportIntentSent(boolean z) {
        this.exportIntentSent = z;
    }

    public final boolean getLegacyBackupRequested() {
        return this.legacyBackupRequested;
    }

    public final void setLegacyBackupRequested(boolean z) {
        this.legacyBackupRequested = z;
    }

    private final Fragment getFragment() {
        return this.backupRestoreContext.getFragment();
    }

    private final Context getContext() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            return fragment.getContext();
        }
        return null;
    }

    public final void onSyncAndBackupNotebooks(boolean useLegacyFormat) {
        if (this.viewModel.isCloudSyncOngoing()) {
            showSyncOngoingErrorDialog();
            return;
        }
        if (this.viewModel.needCloudSync()) {
            this.legacyBackupRequested = useLegacyFormat;
            if (showConfirmDialogFragment()) {
                return;
            }
            this.dialogSequence = true;
            showSyncErrorMessage();
            return;
        }
        onBackupNotebooks(useLegacyFormat);
    }

    private final void onBackupNotebooks(boolean useLegacyFormat) {
        FragmentManager parentFragmentManager;
        if (this.backupRestoreContext.isFragmentReady()) {
            String str = this.lastBackupPath;
            if ((str == null || str.length() == 0) ? false : new File(this.lastBackupPath).exists()) {
                this.exportIntentSent = true;
                Context contextRequireContext = requireContext();
                String str2 = this.lastBackupPath;
                if (str2 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                ExportHelper.exportBackup(contextRequireContext, str2);
                return;
            }
            Context context = getContext();
            if (context == null) {
                return;
            }
            this.dialogSequence = true;
            Fragment fragment = getFragment();
            if (fragment == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
                return;
            }
            this.viewModel.backupNotebooks(useLegacyFormat);
            BackupProgressDialogFragment.Companion companion = BackupProgressDialogFragment.INSTANCE;
            String string = context.getString(C6079R.string.backup_progress_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            BackupProgressDialogFragment backupProgressDialogFragmentNewInstance = companion.newInstance(string);
            backupProgressDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.BackupProgress.ordinal());
            backupProgressDialogFragmentNewInstance.show(parentFragmentManager, BackupProgressDialogFragment.TAG);
        }
    }

    public final void onRestoreNotebooks() {
        this.viewModel.cancelCloudSyncIfNeeded();
        ActivityResultLauncher<String> activityResultLauncher = this.getContent;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch("*/*");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getContent$lambda$0(BackupRestoreUINavigation backupRestoreUINavigation, Uri uri) {
        LifecycleCoroutineScope lifecycleScope;
        try {
            BackupInformation backupInformation = backupRestoreUINavigation.getBackupInformation(uri);
            if (backupInformation == null) {
                return;
            }
            backupRestoreUINavigation.dialogSequence = true;
            Fragment fragment = backupRestoreUINavigation.getFragment();
            if (fragment == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragment)) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new BackupRestoreUINavigation$getContent$1$1(backupRestoreUINavigation, backupInformation, null), 3, null);
        } catch (SecurityException unused) {
            backupRestoreUINavigation.showRestoreErrorDialog();
        }
    }

    private final boolean showConfirmDialogFragment() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return false;
        }
        ConfirmSyncDialogFragment.Companion companion = ConfirmSyncDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.sync_confirm_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.sync_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(C6079R.string.sync_confirm_alert_sync_and_backup);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = context.getString(C6079R.string.sync_confirm_alert_backup_only);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        ConfirmSyncDialogFragment confirmSyncDialogFragmentNewInstance = companion.newInstance(string, string2, string3, string4);
        confirmSyncDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.SyncConfirm.ordinal());
        confirmSyncDialogFragmentNewInstance.show(parentFragmentManager, ConfirmSyncDialogFragment.TAG);
        return true;
    }

    private final boolean showSyncProgressFragment() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return false;
        }
        SyncProgressDialogFragment.Companion companion = SyncProgressDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.sync_confirm_alert_sync_and_backup);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.sync_ongoing_folders_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SyncProgressDialogFragment syncProgressDialogFragmentNewInstance = companion.newInstance(string, string2);
        syncProgressDialogFragmentNewInstance.setCloudSyncCallback(this.onCloudSyncStatusRequested);
        syncProgressDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.SyncProgress.ordinal());
        syncProgressDialogFragmentNewInstance.show(parentFragmentManager, SyncProgressDialogFragment.TAG);
        return true;
    }

    private final boolean syncNotebooks() {
        if (!this.viewModel.needCloudSync()) {
            return false;
        }
        if (showSyncProgressFragment()) {
            return true;
        }
        showBackupErrorDialog();
        return true;
    }

    private final void showSyncErrorMessage() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.sync_error_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.sync_error_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment.Companion.newInstance$default(companion, string, string2, false, 4, null).show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void showConflictedPagesFound(int count) {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6208R.string.sync_page_conflict_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String quantityString = context.getResources().getQuantityString(C6208R.plurals.sync_note_conflict_message, count, Integer.valueOf(count));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance$default = InformationDialogFragment.Companion.newInstance$default(companion, string, quantityString, false, 4, null);
        informationDialogFragmentNewInstance$default.setTargetFragment(getFragment(), BackupRestoreAction.SyncConflictedPages.ordinal());
        informationDialogFragmentNewInstance$default.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void showNotEnoughSpaceDialog(String message) {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.backup_not_enough_room);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance$default = InformationDialogFragment.Companion.newInstance$default(companion, string, message, false, 4, null);
        informationDialogFragmentNewInstance$default.setTargetFragment(getFragment(), BackupRestoreAction.BackupError.ordinal());
        informationDialogFragmentNewInstance$default.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void showBackupNotEnoughSpaceDialog(long requiredSize) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = context.getString(C6079R.string.backup_not_enough_room_message, Formatter.formatFileSize(context, requiredSize));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showNotEnoughSpaceDialog(string);
    }

    private final void showBackupErrorDialog() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.backup_error_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.backup_notes_error_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance = companion.newInstance(string, string2, true);
        informationDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.BackupError.ordinal());
        informationDialogFragmentNewInstance.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void showSyncOngoingErrorDialog() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.sync_ongoing_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.sync_ongoing_folders_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance$default = InformationDialogFragment.Companion.newInstance$default(companion, string, string2, false, 4, null);
        informationDialogFragmentNewInstance$default.setTargetFragment(getFragment(), BackupRestoreAction.BackupError.ordinal());
        informationDialogFragmentNewInstance$default.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BackupRestoreUINavigation.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreUINavigation$BackupInformation;", "", "uri", "Landroid/net/Uri;", "name", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* data */ class BackupInformation {
        private final String name;
        private final Uri uri;

        public static /* synthetic */ BackupInformation copy$default(BackupInformation backupInformation, Uri uri, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = backupInformation.uri;
            }
            if ((i & 2) != 0) {
                str = backupInformation.name;
            }
            return backupInformation.copy(uri, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final BackupInformation copy(Uri uri, String name) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new BackupInformation(uri, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BackupInformation)) {
                return false;
            }
            BackupInformation backupInformation = (BackupInformation) other;
            return Intrinsics.areEqual(this.uri, backupInformation.uri) && Intrinsics.areEqual(this.name, backupInformation.name);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "BackupInformation(uri=" + this.uri + ", name=" + this.name + ")";
        }

        public BackupInformation(Uri uri, String str) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }

        public final Uri getUri() {
            return this.uri;
        }
    }

    private final BackupInformation getBackupInformation(Uri uri) {
        ContentResolver contentResolver;
        Cursor cursorQuery;
        Context context = getContext();
        if (context != null && uri != null && (contentResolver = context.getContentResolver()) != null && (cursorQuery = contentResolver.query(uri, null, null, null, null)) != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    int columnIndex = cursor2.getColumnIndex("_display_name");
                    BackupInformation backupInformation = new BackupInformation(uri, columnIndex != -1 ? cursor2.getString(columnIndex) : null);
                    CloseableKt.closeFinally(cursor, null);
                    return backupInformation;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepareRestoreNotebooks(BackupInformation backupInformation, Continuation<? super Unit> continuation) throws IOException {
        C61511 c61511;
        if (continuation instanceof C61511) {
            c61511 = (C61511) continuation;
            if ((c61511.label & Integer.MIN_VALUE) != 0) {
                c61511.label -= Integer.MIN_VALUE;
            } else {
                c61511 = new C61511(continuation);
            }
        }
        Object objWithContext = c61511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c61511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            Context context = getContext();
            if (context != null) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                BackupRestoreUINavigation$prepareRestoreNotebooks$2$stream$1 backupRestoreUINavigation$prepareRestoreNotebooks$2$stream$1 = new BackupRestoreUINavigation$prepareRestoreNotebooks$2$stream$1(context, backupInformation, null);
                c61511.L$0 = backupInformation;
                c61511.L$1 = SpillingKt.nullOutSpilledVariable(context);
                c61511.I$0 = 0;
                c61511.label = 1;
                objWithContext = BuildersKt.withContext(io2, backupRestoreUINavigation$prepareRestoreNotebooks$2$stream$1, c61511);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c61511.I$0;
        backupInformation = (BackupInformation) c61511.L$0;
        ResultKt.throwOnFailure(objWithContext);
        InputStream inputStream = (InputStream) objWithContext;
        if (inputStream instanceof FileInputStream) {
            this.viewModel.prepareRestoreNotebooks((FileInputStream) inputStream);
            String name = backupInformation.getName();
            if (name == null) {
                name = "";
            }
            confirmRestoreArchive(name);
        } else {
            if (inputStream != null) {
                inputStream.close();
            }
            showCopyErrorDialog();
        }
        return Unit.INSTANCE;
    }

    private final void showRestoreNotEnoughSpaceDialog(long requiredSize) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = context.getString(C6079R.string.restore_not_enough_storage_message, Formatter.formatFileSize(context, requiredSize));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showNotEnoughSpaceDialog(string);
    }

    private final void showCopyErrorDialog() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.copy_error_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.backup_error_not_enough_room);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance$default = InformationDialogFragment.Companion.newInstance$default(companion, string, string2, false, 4, null);
        informationDialogFragmentNewInstance$default.setTargetFragment(getFragment(), BackupRestoreAction.CopyError.ordinal());
        informationDialogFragmentNewInstance$default.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void confirmRestoreArchive(String backupFileName) {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        String string = context.getString(C6079R.string.restore_confirm_restoration_alert_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (backupFileName.length() > 0) {
            string = string + "\n\n" + backupFileName;
        }
        ConfirmRestoreDialogFragment.Companion companion = ConfirmRestoreDialogFragment.INSTANCE;
        String string2 = context.getString(C6079R.string.restore_confirm_restoration_alert_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ConfirmRestoreDialogFragment confirmRestoreDialogFragmentNewInstance = companion.newInstance(string2, string);
        confirmRestoreDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.RestoreConfirm.ordinal());
        confirmRestoreDialogFragmentNewInstance.show(parentFragmentManager, ConfirmRestoreDialogFragment.TAG);
    }

    private final void showVerifyErrorDialog() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.restore_incompatible_backup);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.restore_read_error);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance$default = InformationDialogFragment.Companion.newInstance$default(companion, string, string2, false, 4, null);
        informationDialogFragmentNewInstance$default.setTargetFragment(getFragment(), BackupRestoreAction.VerifyError.ordinal());
        informationDialogFragmentNewInstance$default.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void restoreArchive() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        onBackupRestoreRequested();
        RestoreProgressDialogFragment.Companion companion = RestoreProgressDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.restore_progress_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        RestoreProgressDialogFragment restoreProgressDialogFragmentNewInstance = companion.newInstance(string, null);
        restoreProgressDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.RestoreProgress.ordinal());
        restoreProgressDialogFragmentNewInstance.show(parentFragmentManager, RestoreProgressDialogFragment.TAG);
    }

    private final void showRestoredToast() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Toast.makeText(context, context.getString(C6079R.string.restore_success_alert_title), 1).show();
        this.lastRestorePath = null;
    }

    private final void showRestoreErrorDialog() {
        Fragment fragment;
        FragmentManager parentFragmentManager;
        Context context = getContext();
        if (context == null || (fragment = getFragment()) == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null) {
            return;
        }
        InformationDialogFragment.Companion companion = InformationDialogFragment.INSTANCE;
        String string = context.getString(C6079R.string.restore_error_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.restore_error_alert_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        InformationDialogFragment informationDialogFragmentNewInstance = companion.newInstance(string, string2, true);
        informationDialogFragmentNewInstance.setTargetFragment(getFragment(), BackupRestoreAction.RestoreError.ordinal());
        informationDialogFragmentNewInstance.show(parentFragmentManager, InformationDialogFragment.TAG);
    }

    private final void onBackupRestoreRequested() {
        if (this.backupRestoreContext.isFragmentReady()) {
            this.viewModel.startRestoreArchive();
        }
    }

    private final void onBackupCancelRequested() {
        if (this.backupRestoreContext.isFragmentReady()) {
            this.viewModel.cancelBackupNotebooks();
        }
    }

    private final void onRestoreCancelRequested() {
        if (this.backupRestoreContext.isFragmentReady()) {
            this.viewModel.cancelRestoreNotebooks();
        }
    }

    public final void onParentFragmentNotifyActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        this.dialogSequence = false;
        this.exportIntentSent = false;
        if (requestCode == BackupRestoreAction.SyncConfirm.ordinal()) {
            if (resultCode == -1) {
                Integer numValueOf = returnIntent != null ? Integer.valueOf(returnIntent.getIntExtra("RESULT_CODE", Integer.MIN_VALUE)) : null;
                int iOrdinal = ConfirmSyncDialogFragment.ConfirmSyncDialogResult.ButtonSync.ordinal();
                if (numValueOf != null && numValueOf.intValue() == iOrdinal) {
                    if (syncNotebooks()) {
                        this.dialogSequence = true;
                    } else {
                        onSyncAndBackupNotebooks(this.legacyBackupRequested);
                    }
                } else {
                    int iOrdinal2 = ConfirmSyncDialogFragment.ConfirmSyncDialogResult.ButtonBackup.ordinal();
                    if (numValueOf != null && numValueOf.intValue() == iOrdinal2) {
                        onBackupNotebooks(this.legacyBackupRequested);
                    } else {
                        this.dialogSequence = false;
                    }
                }
            }
        } else if (requestCode == BackupRestoreAction.SyncProgress.ordinal()) {
            if (resultCode == -1) {
                int conflictedPageCount = this.viewModel.getConflictedPageCount();
                if (conflictedPageCount > 0) {
                    this.dialogSequence = true;
                    showConflictedPagesFound(conflictedPageCount);
                } else {
                    onBackupNotebooks(this.legacyBackupRequested);
                }
            } else {
                Integer numValueOf2 = returnIntent != null ? Integer.valueOf(returnIntent.getIntExtra("RESULT_CODE", Integer.MIN_VALUE)) : null;
                int iOrdinal3 = ProgressDialogFragment.ProgressDialogResult.Error.ordinal();
                if (numValueOf2 != null && numValueOf2.intValue() == iOrdinal3) {
                    this.dialogSequence = true;
                    showSyncErrorMessage();
                } else if (numValueOf2 != null) {
                    numValueOf2.intValue();
                }
            }
        } else if (requestCode == BackupRestoreAction.SyncConflictedPages.ordinal()) {
            onBackupNotebooks(this.legacyBackupRequested);
        } else if (requestCode == BackupRestoreAction.BackupProgress.ordinal()) {
            if (resultCode == -1) {
                String stringExtra = returnIntent != null ? returnIntent.getStringExtra("BACKUP_PATH") : null;
                String str = stringExtra;
                if (str != null && str.length() != 0) {
                    this.exportIntentSent = true;
                    ExportHelper.exportBackup(requireContext(), stringExtra);
                    this.lastBackupPath = stringExtra;
                }
            } else {
                this.lastBackupPath = null;
                Integer numValueOf3 = returnIntent != null ? Integer.valueOf(returnIntent.getIntExtra("RESULT_CODE", Integer.MIN_VALUE)) : null;
                int iOrdinal4 = ProgressDialogFragment.ProgressDialogResult.Canceled.ordinal();
                if (numValueOf3 != null && numValueOf3.intValue() == iOrdinal4) {
                    onBackupCancelRequested();
                } else {
                    int iOrdinal5 = ProgressDialogFragment.ProgressDialogResult.Error.ordinal();
                    if (numValueOf3 != null && numValueOf3.intValue() == iOrdinal5) {
                        this.dialogSequence = true;
                        BackupState value = this.viewModel.getBackupState().getValue();
                        if (value instanceof BackupState.BackupError.NotEnoughSpace) {
                            showBackupNotEnoughSpaceDialog(((BackupState.BackupError.NotEnoughSpace) value).getRequiredSize());
                        } else {
                            showBackupErrorDialog();
                        }
                    } else if (numValueOf3 != null) {
                        numValueOf3.intValue();
                    }
                }
            }
        } else if (requestCode == BackupRestoreAction.RestoreConfirm.ordinal()) {
            if (resultCode == -1) {
                this.dialogSequence = true;
                restoreArchive();
            }
        } else if (requestCode == BackupRestoreAction.RestoreProgress.ordinal()) {
            if (resultCode == -1) {
                showRestoredToast();
            } else {
                Integer numValueOf4 = returnIntent != null ? Integer.valueOf(returnIntent.getIntExtra("RESULT_CODE", Integer.MIN_VALUE)) : null;
                int iOrdinal6 = ProgressDialogFragment.ProgressDialogResult.Canceled.ordinal();
                if (numValueOf4 != null && numValueOf4.intValue() == iOrdinal6) {
                    onRestoreCancelRequested();
                } else {
                    int iOrdinal7 = ProgressDialogFragment.ProgressDialogResult.Error.ordinal();
                    if (numValueOf4 != null && numValueOf4.intValue() == iOrdinal7) {
                        this.dialogSequence = true;
                        RestoreState value2 = this.viewModel.getRestoreState().getValue();
                        if (value2 instanceof RestoreState.CopyArchiveError) {
                            showCopyErrorDialog();
                        } else if (value2 instanceof RestoreState.RestoreArchiveError.NotEnoughSpace) {
                            showRestoreNotEnoughSpaceDialog(((RestoreState.RestoreArchiveError.NotEnoughSpace) value2).getRequiredSize());
                        } else if (value2 instanceof RestoreState.RestoreArchiveError.VerifyError) {
                            showVerifyErrorDialog();
                        } else if (value2 instanceof RestoreState.RestoreArchiveError.UnknownError) {
                            showRestoreErrorDialog();
                        }
                    } else if (numValueOf4 != null) {
                        numValueOf4.intValue();
                    }
                }
            }
        } else if (requestCode != BackupRestoreAction.SyncError.ordinal()) {
            BackupRestoreAction.CopyError.ordinal();
        }
        updateSettings();
    }

    public final void saveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        String str = this.lastBackupPath;
        if (str != null && str.length() != 0) {
            outState.putString(LAST_BACKUP_PATH, this.lastBackupPath);
        }
        String str2 = this.lastRestorePath;
        if (str2 != null && str2.length() != 0) {
            outState.putString(LAST_RESTORE_PATH, this.lastRestorePath);
        }
        String str3 = this.lastRestoreName;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        outState.putString(LAST_RESTORE_NAME, this.lastRestoreName);
    }

    public final void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_BACKUP_PATH)) {
                this.lastBackupPath = savedInstanceState.getString(LAST_BACKUP_PATH);
            }
            if (savedInstanceState.containsKey(LAST_RESTORE_PATH)) {
                this.lastRestorePath = savedInstanceState.getString(LAST_RESTORE_PATH);
            }
            if (savedInstanceState.containsKey(LAST_RESTORE_NAME)) {
                this.lastRestoreName = savedInstanceState.getString(LAST_RESTORE_NAME);
            }
        }
    }

    private final void updateSettings() {
        this.backupRestoreContext.updateSettingsItems();
    }

    public final boolean isInScreenSequence() {
        return this.dialogSequence || this.exportIntentSent;
    }

    public final void settingsFragmentResumed() {
        this.exportIntentSent = false;
    }

    private final Context requireContext() {
        Fragment fragment = this.backupRestoreContext.getFragment();
        if (fragment == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Context contextRequireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return contextRequireContext;
    }
}
