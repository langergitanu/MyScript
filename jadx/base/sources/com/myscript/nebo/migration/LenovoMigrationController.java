package com.myscript.nebo.migration;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.migration.BackupStatus;
import com.myscript.nebo.migration.MigrationRestorer;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: LenovoMigrationController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u0001:\u0003012B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u000e\u0010\"\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u0004\u0018\u00010%H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0082@¢\u0006\u0002\u0010)J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController;", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "migrationPrefs", "Landroid/content/SharedPreferences;", "backupSource", "Lcom/myscript/nebo/migration/LenovoBackupSource;", "restorer", "Lcom/myscript/nebo/migration/MigrationRestorer;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/SharedPreferences;Lcom/myscript/nebo/migration/LenovoBackupSource;Lcom/myscript/nebo/migration/MigrationRestorer;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lcom/myscript/nebo/log/TechnicalLogger;Lkotlinx/coroutines/CoroutineScope;)V", "cachedState", "Lcom/myscript/nebo/migration/MigrationState;", "migrationState", "getMigrationState", "()Lcom/myscript/nebo/migration/MigrationState;", "markMigrationPending", "", "markMigrationCompleted", "_progress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/myscript/nebo/migration/MigrationProgress;", "progress", "Lkotlinx/coroutines/flow/StateFlow;", "getProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "migrationJob", "Lkotlinx/coroutines/Job;", TtmlNode.START, "runMigration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollUntilDone", "", "runRestore", "stream", "Ljava/io/FileInputStream;", "(Ljava/io/FileInputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitError", "error", "Lcom/myscript/nebo/migration/MigrationError;", "detail", "cause", "", "Outcome", "ProgressionListener", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LenovoMigrationController implements ILenovoMigrationController {
    private static final String KEY_LOG_ERROR_CODE = "lenovo_migration_error_code";
    private static final String KEY_LOG_FAILED_PHASE = "lenovo_migration_failed_phase";
    private static final long MAX_BACKUP_STALL_MS = 120000;
    public static final String MIGRATION_PREFS_NAME = "lenovo_migration_state_prefs";
    private static final long POLL_INTERVAL_MS = 2000;
    public static final String PREF_MIGRATION_STATE = "pref_migration_state";
    private final MutableStateFlow<MigrationProgress> _progress;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final LenovoBackupSource backupSource;
    private volatile MigrationState cachedState;
    private final TechnicalLogger logger;
    private volatile Job migrationJob;
    private final SharedPreferences migrationPrefs;
    private final StateFlow<MigrationProgress> progress;
    private final MigrationRestorer restorer;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.migration.LenovoMigrationController$pollUntilDone$1 */
    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.LenovoMigrationController", m1609f = "LenovoMigrationController.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA1_7_1, PDFACompliance.e_PDFA1_7_4}, m1612m = "pollUntilDone", m1613n = {"lastCurrent", "lastTotal", "stalledMs", "lastCurrent", "lastTotal", "stalledMs"}, m1614nl = {PDFACompliance.e_PDFA1_7_3, 175}, m1615s = {"I$0", "I$1", "J$0", "I$0", "I$1", "J$0"}, m1616v = 2)
    static final class C66281 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        int label;
        /* synthetic */ Object result;

        C66281(Continuation<? super C66281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LenovoMigrationController.this.pollUntilDone(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.LenovoMigrationController$runMigration$1 */
    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.LenovoMigrationController", m1609f = "LenovoMigrationController.kt", m1610i = {1, 2, 2, 3, 3, 3, 3, 3}, m1611l = {111, PDFACompliance.e_PDFA1_2_2, 127, 152}, m1612m = "runMigration", m1613n = {"startStatus", "startStatus", "handle", "startStatus", "handle", "openError", "rawStream", "stream"}, m1614nl = {112, GapComposerKt.nodeKey, 128, 154}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, m1616v = 2)
    static final class C66291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C66291(Continuation<? super C66291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LenovoMigrationController.this.runMigration(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.LenovoMigrationController$runRestore$1 */
    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.LenovoMigrationController", m1609f = "LenovoMigrationController.kt", m1610i = {0, 1, 1, 2, 3}, m1611l = {229, PDFACompliance.e_PDFA2_3_3, PDFACompliance.e_PDFA2_5_1, PDFACompliance.e_PDFA2_5_1}, m1612m = "runRestore", m1613n = {"stream", "stream", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "stream", "stream"}, m1614nl = {230, 236, PDFACompliance.e_PDFA2_5_2, 253}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$0"}, m1616v = 2)
    static final class C66301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C66301(Continuation<? super C66301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LenovoMigrationController.this.runRestore(null, this);
        }
    }

    public LenovoMigrationController(SharedPreferences migrationPrefs, LenovoBackupSource backupSource, MigrationRestorer restorer, IAutoSyncTimerManager autoSyncTimerManager, TechnicalLogger logger, CoroutineScope scope) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(migrationPrefs, "migrationPrefs");
        Intrinsics.checkNotNullParameter(backupSource, "backupSource");
        Intrinsics.checkNotNullParameter(restorer, "restorer");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.migrationPrefs = migrationPrefs;
        this.backupSource = backupSource;
        this.restorer = restorer;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.logger = logger;
        this.scope = scope;
        String string = this.migrationPrefs.getString(PREF_MIGRATION_STATE, "NotStarted");
        String str = string != null ? string : "NotStarted";
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(MigrationState.valueOf(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        this.cachedState = (MigrationState) (Result.m14505isFailureimpl(objM14499constructorimpl) ? MigrationState.NotStarted : objM14499constructorimpl);
        MutableStateFlow<MigrationProgress> MutableStateFlow = StateFlowKt.MutableStateFlow(new MigrationProgress(null, 0, null, 7, null));
        this._progress = MutableStateFlow;
        this.progress = MutableStateFlow;
    }

    public /* synthetic */ LenovoMigrationController(SharedPreferences sharedPreferences, LenovoBackupSource lenovoBackupSource, MigrationRestorer migrationRestorer, IAutoSyncTimerManager iAutoSyncTimerManager, TechnicalLogger technicalLogger, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, lenovoBackupSource, migrationRestorer, iAutoSyncTimerManager, technicalLogger, (i & 32) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController
    /* JADX INFO: renamed from: getMigrationState, reason: from getter */
    public MigrationState getCachedState() {
        return this.cachedState;
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController
    public void markMigrationPending() {
        this.cachedState = MigrationState.Pending;
        this.migrationPrefs.edit().putString(PREF_MIGRATION_STATE, "Pending").apply();
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController
    public void markMigrationCompleted() {
        this.cachedState = MigrationState.Completed;
        this.migrationPrefs.edit().putString(PREF_MIGRATION_STATE, "Completed").apply();
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController
    public StateFlow<MigrationProgress> getProgress() {
        return this.progress;
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController
    public void start() {
        Job job = this.migrationJob;
        if (job == null || !job.isActive()) {
            this._progress.setValue(new MigrationProgress(Phase.CreatingBackup, 0, null, 6, null));
            this.migrationJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C66311(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.LenovoMigrationController$start$1 */
    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.LenovoMigrationController$start$1", m1609f = "LenovoMigrationController.kt", m1610i = {}, m1611l = {100}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C66311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66311(Continuation<? super C66311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LenovoMigrationController.this.new C66311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LenovoMigrationController.this.runMigration(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc A[Catch: Exception -> 0x0074, CancellationException -> 0x007b, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x007b, blocks: (B:96:0x0199, B:104:0x01bb, B:103:0x01b2, B:23:0x0064, B:59:0x00e9, B:64:0x00f8, B:66:0x00fc, B:79:0x0121, B:86:0x0153, B:80:0x012b, B:82:0x012f, B:84:0x0135, B:85:0x0139, B:88:0x0156, B:77:0x0116, B:28:0x0070, B:51:0x00c7, B:53:0x00cc, B:55:0x00cf, B:32:0x0077, B:42:0x0090, B:43:0x0092, B:45:0x0096, B:47:0x00b2, B:105:0x01bc, B:39:0x0084), top: B:113:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fc A[Catch: Exception -> 0x0074, CancellationException -> 0x007b, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x007b, blocks: (B:96:0x0199, B:104:0x01bb, B:103:0x01b2, B:23:0x0064, B:59:0x00e9, B:64:0x00f8, B:66:0x00fc, B:79:0x0121, B:86:0x0153, B:80:0x012b, B:82:0x012f, B:84:0x0135, B:85:0x0139, B:88:0x0156, B:77:0x0116, B:28:0x0070, B:51:0x00c7, B:53:0x00cc, B:55:0x00cf, B:32:0x0077, B:42:0x0090, B:43:0x0092, B:45:0x0096, B:47:0x00b2, B:105:0x01bc, B:39:0x0084), top: B:113:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0156 A[Catch: Exception -> 0x0074, CancellationException -> 0x007b, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x007b, blocks: (B:96:0x0199, B:104:0x01bb, B:103:0x01b2, B:23:0x0064, B:59:0x00e9, B:64:0x00f8, B:66:0x00fc, B:79:0x0121, B:86:0x0153, B:80:0x012b, B:82:0x012f, B:84:0x0135, B:85:0x0139, B:88:0x0156, B:77:0x0116, B:28:0x0070, B:51:0x00c7, B:53:0x00cc, B:55:0x00cf, B:32:0x0077, B:42:0x0090, B:43:0x0092, B:45:0x0096, B:47:0x00b2, B:105:0x01bc, B:39:0x0084), top: B:113:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runMigration(Continuation<? super Unit> continuation) throws Throwable {
        C66291 c66291;
        BackupStatus backupStatus;
        String str;
        BackupStatus backupStatus2;
        String str2;
        BackupStatus backupStatus3;
        Exception exc;
        String str3;
        InputStream inputStream;
        FileInputStream fileInputStream;
        Class<?> cls;
        Unit unit;
        FileInputStream fileInputStream2;
        Throwable th;
        if (continuation instanceof C66291) {
            c66291 = (C66291) continuation;
            if ((c66291.label & Integer.MIN_VALUE) != 0) {
                c66291.label -= Integer.MIN_VALUE;
            } else {
                c66291 = new C66291(continuation);
            }
        }
        Object objStartBackup = c66291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c66291.label;
        String name = null;
        try {
            try {
                try {
                } catch (Exception e) {
                    emitError(MigrationError.ProviderUnreachable, "startBackup call failed", e);
                    return Unit.INSTANCE;
                }
            } catch (CancellationException e2) {
                throw e2;
            }
        } catch (Exception e3) {
            emitError(MigrationError.RestoreFailed, "unexpected failure", e3);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(objStartBackup);
            LenovoBackupSource lenovoBackupSource = this.backupSource;
            c66291.label = 1;
            objStartBackup = lenovoBackupSource.startBackup(c66291);
            if (objStartBackup == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                backupStatus = (BackupStatus) c66291.L$0;
                ResultKt.throwOnFailure(objStartBackup);
                str = (String) objStartBackup;
                if (str != null) {
                    return Unit.INSTANCE;
                }
                try {
                    LenovoBackupSource lenovoBackupSource2 = this.backupSource;
                    c66291.L$0 = SpillingKt.nullOutSpilledVariable(backupStatus);
                    c66291.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c66291.label = 3;
                    objStartBackup = lenovoBackupSource2.openBackupStream(str, c66291);
                } catch (Exception e4) {
                    e = e4;
                    backupStatus2 = backupStatus;
                    str2 = str;
                    backupStatus3 = backupStatus2;
                    exc = e;
                    str3 = str2;
                    inputStream = null;
                }
                if (objStartBackup != coroutine_suspended) {
                    backupStatus2 = backupStatus;
                    str2 = str;
                    String str4 = str2;
                    inputStream = (InputStream) objStartBackup;
                    str3 = str4;
                    backupStatus3 = backupStatus2;
                    exc = null;
                    if (!(inputStream instanceof FileInputStream)) {
                    }
                    if (fileInputStream != null) {
                    }
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fileInputStream2 = (FileInputStream) c66291.L$4;
                try {
                    ResultKt.throwOnFailure(objStartBackup);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        LenovoMigrationController lenovoMigrationController = this;
                        fileInputStream2.close();
                        Result.m14499constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m14499constructorimpl(ResultKt.createFailure(th2));
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    th = th;
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        fileInputStream.close();
                        Result.m14499constructorimpl(Unit.INSTANCE);
                        throw th;
                    } catch (Throwable th4) {
                        Result.Companion companion4 = Result.INSTANCE;
                        Result.m14499constructorimpl(ResultKt.createFailure(th4));
                        throw th;
                    }
                }
            }
            str2 = (String) c66291.L$1;
            backupStatus2 = (BackupStatus) c66291.L$0;
            try {
                ResultKt.throwOnFailure(objStartBackup);
                String str42 = str2;
                inputStream = (InputStream) objStartBackup;
                str3 = str42;
                backupStatus3 = backupStatus2;
                exc = null;
            } catch (Exception e5) {
                e = e5;
                backupStatus3 = backupStatus2;
                exc = e;
                str3 = str2;
                inputStream = null;
            }
            fileInputStream = !(inputStream instanceof FileInputStream) ? (FileInputStream) inputStream : null;
            if (fileInputStream != null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    LenovoMigrationController lenovoMigrationController2 = this;
                    if (inputStream != null) {
                        inputStream.close();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.m14499constructorimpl(unit);
                } catch (Throwable th5) {
                    Result.Companion companion6 = Result.INSTANCE;
                    Result.m14499constructorimpl(ResultKt.createFailure(th5));
                }
                if (exc != null) {
                    emitError(MigrationError.BackupStreamUnavailable, "openInputStream failed", exc);
                } else {
                    MigrationError migrationError = MigrationError.BackupStreamUnavailable;
                    if (inputStream != null && (cls = inputStream.getClass()) != null) {
                        name = cls.getName();
                    }
                    emitError$default(this, migrationError, "openInputStream did not return a FileInputStream (" + name + ")", null, 4, null);
                }
                return Unit.INSTANCE;
            }
            this._progress.setValue(new MigrationProgress(Phase.CopyingBackup, 0, null, 4, null));
            try {
                c66291.L$0 = SpillingKt.nullOutSpilledVariable(backupStatus3);
                c66291.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                c66291.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                c66291.L$3 = SpillingKt.nullOutSpilledVariable(inputStream);
                c66291.L$4 = fileInputStream;
                c66291.label = 4;
                if (runRestore(fileInputStream, c66291) != coroutine_suspended) {
                    fileInputStream2 = fileInputStream;
                    Result.Companion companion7 = Result.INSTANCE;
                    LenovoMigrationController lenovoMigrationController3 = this;
                    fileInputStream2.close();
                    Result.m14499constructorimpl(Unit.INSTANCE);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th6) {
                th = th6;
                th = th;
                Result.Companion companion32 = Result.INSTANCE;
                fileInputStream.close();
                Result.m14499constructorimpl(Unit.INSTANCE);
                throw th;
            }
        }
        ResultKt.throwOnFailure(objStartBackup);
        BackupStatus backupStatus4 = (BackupStatus) objStartBackup;
        if (backupStatus4 instanceof BackupStatus.Failed) {
            emitError$default(this, MigrationError.INSTANCE.fromRemoteCode(((BackupStatus.Failed) backupStatus4).getCode()), ((BackupStatus.Failed) backupStatus4).getMessage(), null, 4, null);
            return Unit.INSTANCE;
        }
        c66291.L$0 = SpillingKt.nullOutSpilledVariable(backupStatus4);
        c66291.label = 2;
        Object objPollUntilDone = pollUntilDone(c66291);
        if (objPollUntilDone == coroutine_suspended) {
            return coroutine_suspended;
        }
        backupStatus = backupStatus4;
        objStartBackup = objPollUntilDone;
        str = (String) objStartBackup;
        if (str != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r0 != r4) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0075 -> B:28:0x0078). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollUntilDone(Continuation<? super String> continuation) {
        C66281 c66281;
        int total;
        long j;
        int i;
        int i2;
        long j2;
        LenovoMigrationController lenovoMigrationController = this;
        int current = Integer.MIN_VALUE;
        if (continuation instanceof C66281) {
            c66281 = (C66281) continuation;
            if ((c66281.label & Integer.MIN_VALUE) != 0) {
                c66281.label -= Integer.MIN_VALUE;
            } else {
                c66281 = lenovoMigrationController.new C66281(continuation);
            }
        }
        Object status = c66281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c66281.label;
        long j3 = 2000;
        if (i3 == 0) {
            ResultKt.throwOnFailure(status);
            total = Integer.MIN_VALUE;
            j = 0;
            c66281.I$0 = current;
            c66281.I$1 = total;
            c66281.J$0 = j;
            c66281.label = 1;
            if (DelayKt.delay(j3, c66281) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c66281.J$0;
            i2 = c66281.I$1;
            i = c66281.I$0;
            try {
                ResultKt.throwOnFailure(status);
                BackupStatus backupStatus = (BackupStatus) status;
                if (Intrinsics.areEqual(backupStatus, BackupStatus.Unavailable.INSTANCE)) {
                    emitError$default(lenovoMigrationController, MigrationError.ProviderUnreachable, "getStatus returned no Bundle", null, 4, null);
                    return null;
                }
                if (backupStatus instanceof BackupStatus.Done) {
                    String handle = ((BackupStatus.Done) backupStatus).getHandle();
                    if (handle != null) {
                        return handle;
                    }
                    emitError$default(this, MigrationError.BackupUriMissing, null, null, 6, null);
                    return null;
                }
                if (backupStatus instanceof BackupStatus.Failed) {
                    BackupStatus.Failed failed = (BackupStatus.Failed) backupStatus;
                    emitError$default(this, MigrationError.INSTANCE.fromRemoteCode(failed.getCode()), failed.getMessage(), null, 4, null);
                    return null;
                }
                lenovoMigrationController = this;
                if (backupStatus instanceof BackupStatus.InProgress) {
                    BackupStatus.InProgress inProgress = (BackupStatus.InProgress) backupStatus;
                    j2 = j3;
                    lenovoMigrationController._progress.setValue(new MigrationProgress(Phase.CreatingBackup, inProgress.getTotal() > 0 ? (inProgress.getCurrent() * 100) / inProgress.getTotal() : -1, null, 4, null));
                    if (inProgress.getCurrent() != i || inProgress.getTotal() != i2) {
                        current = inProgress.getCurrent();
                        total = inProgress.getTotal();
                        j = 0;
                    }
                    j3 = j2;
                    c66281.I$0 = current;
                    c66281.I$1 = total;
                    c66281.J$0 = j;
                    c66281.label = 1;
                    if (DelayKt.delay(j3, c66281) != coroutine_suspended) {
                        i = current;
                        i2 = total;
                        LenovoBackupSource lenovoBackupSource = lenovoMigrationController.backupSource;
                        c66281.I$0 = i;
                        c66281.I$1 = i2;
                        c66281.J$0 = j;
                        c66281.label = 2;
                        status = lenovoBackupSource.getStatus(c66281);
                    }
                    return coroutine_suspended;
                }
                j2 = j3;
                if (!Intrinsics.areEqual(backupStatus, BackupStatus.Idle.INSTANCE) && !(backupStatus instanceof BackupStatus.Unknown)) {
                    throw new NoWhenBranchMatchedException();
                }
                j += j2;
                if (j < MAX_BACKUP_STALL_MS) {
                    total = i2;
                    current = i;
                    j3 = j2;
                    c66281.I$0 = current;
                    c66281.I$1 = total;
                    c66281.J$0 = j;
                    c66281.label = 1;
                    if (DelayKt.delay(j3, c66281) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                emitError$default(lenovoMigrationController, MigrationError.BackupStalled, "Backup made no progress for " + j + "ms", null, 4, null);
                return null;
            } catch (Exception e) {
                lenovoMigrationController.emitError(MigrationError.ProviderUnreachable, "getStatus call failed", e);
                return null;
            }
        }
        j = c66281.J$0;
        i2 = c66281.I$1;
        i = c66281.I$0;
        ResultKt.throwOnFailure(status);
        LenovoBackupSource lenovoBackupSource2 = lenovoMigrationController.backupSource;
        c66281.I$0 = i;
        c66281.I$1 = i2;
        c66281.J$0 = j;
        c66281.label = 2;
        status = lenovoBackupSource2.getStatus(c66281);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0107, code lost:
    
        if (r0.resume(r7) != r8) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1 A[Catch: all -> 0x0115, TryCatch #1 {all -> 0x0115, blocks: (B:38:0x00a5, B:40:0x00b1, B:41:0x00cc, B:49:0x00ee, B:56:0x010f, B:57:0x0114), top: B:71:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc A[Catch: all -> 0x0115, TRY_LEAVE, TryCatch #1 {all -> 0x0115, blocks: (B:38:0x00a5, B:40:0x00b1, B:41:0x00cc, B:49:0x00ee, B:56:0x010f, B:57:0x0114), top: B:71:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.myscript.nebo.migration.MigrationRestorer] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runRestore(FileInputStream fileInputStream, Continuation<? super Unit> continuation) throws Throwable {
        C66301 c66301;
        ?? r11;
        ?? r112;
        Throwable th;
        IAutoSyncTimerManager iAutoSyncTimerManager;
        ProgressionListener progressionListener;
        Outcome outcome;
        LenovoMigrationController lenovoMigrationController = this;
        if (continuation instanceof C66301) {
            c66301 = (C66301) continuation;
            if ((c66301.label & Integer.MIN_VALUE) != 0) {
                c66301.label -= Integer.MIN_VALUE;
            } else {
                c66301 = lenovoMigrationController.new C66301(continuation);
            }
        }
        C66301 c663012 = c66301;
        Object obj = c663012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c663012.label;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        if (r2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                IAutoSyncTimerManager iAutoSyncTimerManager2 = lenovoMigrationController.autoSyncTimerManager;
                FileInputStream fileInputStream2 = fileInputStream;
                c663012.L$0 = fileInputStream2;
                c663012.label = 1;
                r2 = fileInputStream2;
                if (iAutoSyncTimerManager2.pause(c663012) == coroutine_suspended) {
                }
            } catch (Throwable th3) {
                th = th3;
                r2 = fileInputStream;
                r11 = r2;
                th = th;
                r112 = r11;
                lenovoMigrationController.restorer.restartThumbnailer();
                iAutoSyncTimerManager = lenovoMigrationController.autoSyncTimerManager;
                c663012.L$0 = SpillingKt.nullOutSpilledVariable(r112);
                c663012.L$1 = th;
                c663012.label = 4;
                if (iAutoSyncTimerManager.resume(c663012) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return coroutine_suspended;
        }
        if (r2 == 1) {
            FileInputStream fileInputStream3 = (FileInputStream) c663012.L$0;
            ResultKt.throwOnFailure(obj);
            r2 = fileInputStream3;
        } else {
            if (r2 != 2) {
                if (r2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (r2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th4 = (Throwable) c663012.L$1;
                ResultKt.throwOnFailure(obj);
                throw th4;
            }
            progressionListener = (ProgressionListener) c663012.L$1;
            FileInputStream fileInputStream4 = (FileInputStream) c663012.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                r11 = fileInputStream4;
                try {
                    outcome = progressionListener.getOutcome();
                    if (!Intrinsics.areEqual(outcome, Outcome.Done.INSTANCE)) {
                        lenovoMigrationController.logger.logTrace("Migration restore complete");
                        lenovoMigrationController._progress.setValue(new MigrationProgress(Phase.Done, 100, null, 4, null));
                    } else {
                        try {
                            if (outcome instanceof Outcome.Error) {
                                emitError$default(lenovoMigrationController, ((Outcome.Error) outcome).getError(), null, null, 6, null);
                                lenovoMigrationController = this;
                            } else {
                                if (outcome != null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                lenovoMigrationController = this;
                                emitError$default(lenovoMigrationController, MigrationError.RestoreNoOutcome, null, null, 6, null);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            lenovoMigrationController = this;
                            th = th;
                            r112 = r11;
                            lenovoMigrationController.restorer.restartThumbnailer();
                            iAutoSyncTimerManager = lenovoMigrationController.autoSyncTimerManager;
                            c663012.L$0 = SpillingKt.nullOutSpilledVariable(r112);
                            c663012.L$1 = th;
                            c663012.label = 4;
                            if (iAutoSyncTimerManager.resume(c663012) == coroutine_suspended) {
                                throw th;
                            }
                        }
                    }
                    lenovoMigrationController.restorer.restartThumbnailer();
                    IAutoSyncTimerManager iAutoSyncTimerManager3 = lenovoMigrationController.autoSyncTimerManager;
                    c663012.L$0 = SpillingKt.nullOutSpilledVariable(r11);
                    c663012.L$1 = null;
                    c663012.label = 3;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                r112 = fileInputStream4;
                lenovoMigrationController.restorer.restartThumbnailer();
                iAutoSyncTimerManager = lenovoMigrationController.autoSyncTimerManager;
                c663012.L$0 = SpillingKt.nullOutSpilledVariable(r112);
                c663012.L$1 = th;
                c663012.label = 4;
                if (iAutoSyncTimerManager.resume(c663012) == coroutine_suspended) {
                }
            }
        }
        lenovoMigrationController.restorer.stopThumbnailer();
        ProgressionListener progressionListener2 = lenovoMigrationController.new ProgressionListener();
        c663012.L$0 = SpillingKt.nullOutSpilledVariable(r2);
        c663012.L$1 = progressionListener2;
        c663012.label = 2;
        if (lenovoMigrationController.restorer.restore(r2, progressionListener2, c663012) != coroutine_suspended) {
            r11 = r2;
            progressionListener = progressionListener2;
            outcome = progressionListener.getOutcome();
            if (!Intrinsics.areEqual(outcome, Outcome.Done.INSTANCE)) {
            }
            lenovoMigrationController.restorer.restartThumbnailer();
            IAutoSyncTimerManager iAutoSyncTimerManager32 = lenovoMigrationController.autoSyncTimerManager;
            c663012.L$0 = SpillingKt.nullOutSpilledVariable(r11);
            c663012.L$1 = null;
            c663012.label = 3;
        }
        return coroutine_suspended;
    }

    static /* synthetic */ void emitError$default(LenovoMigrationController lenovoMigrationController, MigrationError migrationError, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        lenovoMigrationController.emitError(migrationError, str, th);
    }

    private final void emitError(MigrationError error, String detail, Throwable cause) {
        String str;
        Phase phase = this._progress.getValue().getPhase();
        TechnicalLogger technicalLogger = this.logger;
        String code = error.getCode();
        if (detail == null || (str = ": " + detail) == null) {
            str = "";
        }
        technicalLogger.logTrace("Migration failed in " + phase + " [" + code + "]" + str);
        this.logger.setKeyValue(KEY_LOG_ERROR_CODE, error.getCode());
        this.logger.setKeyValue(KEY_LOG_FAILED_PHASE, phase.name());
        this.logger.logError(new LenovoMigrationException(error, detail, cause));
        this._progress.setValue(new MigrationProgress(Phase.Error, 0, error, 2, null));
    }

    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;", "", "<init>", "()V", "Done", "Error", "Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome$Done;", "Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome$Error;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static abstract class Outcome {
        public /* synthetic */ Outcome(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: LenovoMigrationController.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome$Done;", "Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Done extends Outcome {
            public static final int $stable = 0;
            public static final Done INSTANCE = new Done();

            private Done() {
                super(null);
            }
        }

        private Outcome() {
        }

        /* JADX INFO: compiled from: LenovoMigrationController.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome$Error;", "Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;", "error", "Lcom/myscript/nebo/migration/MigrationError;", "<init>", "(Lcom/myscript/nebo/migration/MigrationError;)V", "getError", "()Lcom/myscript/nebo/migration/MigrationError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Error extends Outcome {
            public static final int $stable = 0;
            private final MigrationError error;

            public static /* synthetic */ Error copy$default(Error error, MigrationError migrationError, int i, Object obj) {
                if ((i & 1) != 0) {
                    migrationError = error.error;
                }
                return error.copy(migrationError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MigrationError getError() {
                return this.error;
            }

            public final Error copy(MigrationError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && this.error == ((Error) other).error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(MigrationError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final MigrationError getError() {
                return this.error;
            }
        }
    }

    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController$ProgressionListener;", "Lcom/myscript/nebo/migration/MigrationRestorer$Listener;", "<init>", "(Lcom/myscript/nebo/migration/LenovoMigrationController;)V", "outcome", "Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;", "getOutcome", "()Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;", "setOutcome", "(Lcom/myscript/nebo/migration/LenovoMigrationController$Outcome;)V", "onCopyProgress", "", "percent", "", "onCopyFinished", "onCopyCanceled", "onCopyError", "onVerifyError", "onRestoreProgress", "current", "total", "onRestoreFinished", "onRestoreCanceled", "onRestoreInsufficientSpace", "requiredSize", "", "onRestoreError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private final class ProgressionListener implements MigrationRestorer.Listener {
        private volatile Outcome outcome;

        public ProgressionListener() {
        }

        public final Outcome getOutcome() {
            return this.outcome;
        }

        public final void setOutcome(Outcome outcome) {
            this.outcome = outcome;
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onCopyProgress(int percent) {
            LenovoMigrationController.this._progress.setValue(new MigrationProgress(Phase.CopyingBackup, percent, null, 4, null));
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onCopyFinished() {
            LenovoMigrationController.this._progress.setValue(new MigrationProgress(Phase.Restoring, 0, null, 4, null));
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onCopyCanceled() {
            this.outcome = new Outcome.Error(MigrationError.CopyCanceled);
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onCopyError() {
            this.outcome = new Outcome.Error(MigrationError.CopyFailed);
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onVerifyError() {
            this.outcome = new Outcome.Error(MigrationError.VerifyFailed);
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onRestoreProgress(int current, int total) {
            LenovoMigrationController.this._progress.setValue(new MigrationProgress(Phase.Restoring, total > 0 ? (current * 100) / total : -1, null, 4, null));
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onRestoreFinished() {
            this.outcome = Outcome.Done.INSTANCE;
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onRestoreCanceled() {
            this.outcome = new Outcome.Error(MigrationError.RestoreCanceled);
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onRestoreInsufficientSpace(long requiredSize) {
            this.outcome = new Outcome.Error(MigrationError.RestoreInsufficientSpace);
        }

        @Override // com.myscript.nebo.migration.MigrationRestorer.Listener
        public void onRestoreError() {
            this.outcome = new Outcome.Error(MigrationError.RestoreFailed);
        }
    }

    /* JADX INFO: compiled from: LenovoMigrationController.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationController$Companion;", "", "<init>", "()V", "POLL_INTERVAL_MS", "", "MAX_BACKUP_STALL_MS", "KEY_LOG_ERROR_CODE", "", "KEY_LOG_FAILED_PHASE", "MIGRATION_PREFS_NAME", "PREF_MIGRATION_STATE", "create", "Lcom/myscript/nebo/migration/LenovoMigrationController;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LenovoMigrationController create(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager autoSyncTimerManager, TechnicalLogger logger) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
            Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
            Intrinsics.checkNotNullParameter(logger, "logger");
            SharedPreferences sharedPreferences = application.getSharedPreferences(LenovoMigrationController.MIGRATION_PREFS_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            ContentResolver contentResolver = application.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            CoroutineScope coroutineScope = null;
            return new LenovoMigrationController(sharedPreferences, new ContentResolverLenovoBackupSource(contentResolver, null, 2, null), new RestoreRunnableMigrationRestorer(application, libraryRepository, null, 4, null), autoSyncTimerManager, logger, coroutineScope, 32, null);
        }
    }
}
