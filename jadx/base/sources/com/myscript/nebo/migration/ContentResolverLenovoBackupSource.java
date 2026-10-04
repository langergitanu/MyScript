package com.myscript.nebo.migration;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.myscript.nebo.migration.BackupStatus;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ContentResolverLenovoBackupSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000b*\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/migration/ContentResolverLenovoBackupSource;", "Lcom/myscript/nebo/migration/LenovoBackupSource;", "resolver", "Landroid/content/ContentResolver;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/content/ContentResolver;Lkotlinx/coroutines/CoroutineDispatcher;)V", "authorityUri", "Landroid/net/Uri;", ContentResolverLenovoBackupSource.METHOD_START_BACKUP, "Lcom/myscript/nebo/migration/BackupStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ContentResolverLenovoBackupSource.METHOD_GET_STATUS, "openBackupStream", "Ljava/io/InputStream;", "handle", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toStatus", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContentResolverLenovoBackupSource implements LenovoBackupSource {
    private static final String KEY_CURRENT = "current";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MESSAGE = "error_message";
    private static final String KEY_PHASE = "phase";
    private static final String KEY_TOTAL = "total";
    private static final String KEY_URI = "uri";
    private static final String METHOD_GET_STATUS = "getStatus";
    private static final String METHOD_START_BACKUP = "startBackup";
    private static final String PHASE_BACKING = "backing";
    private static final String PHASE_DONE = "done";
    private static final String PHASE_ERROR = "error";
    private static final String PHASE_IDLE = "idle";
    private static final String PROVIDER_AUTHORITY = "com.myscript.nebo.lenovo.backup";
    private final Uri authorityUri;
    private final CoroutineDispatcher ioDispatcher;
    private final ContentResolver resolver;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ContentResolverLenovoBackupSource(ContentResolver resolver, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.resolver = resolver;
        this.ioDispatcher = ioDispatcher;
        Uri uri = Uri.parse("content://com.myscript.nebo.lenovo.backup");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        this.authorityUri = uri;
    }

    public /* synthetic */ ContentResolverLenovoBackupSource(ContentResolver contentResolver, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentResolver, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.ContentResolverLenovoBackupSource$startBackup$2 */
    /* JADX INFO: compiled from: ContentResolverLenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/migration/BackupStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.ContentResolverLenovoBackupSource$startBackup$2", m1609f = "ContentResolverLenovoBackupSource.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BackupStatus>, Object> {
        int label;

        C66262(Continuation<? super C66262> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContentResolverLenovoBackupSource.this.new C66262(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BackupStatus> continuation) {
            return ((C66262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ContentResolverLenovoBackupSource contentResolverLenovoBackupSource = ContentResolverLenovoBackupSource.this;
            return contentResolverLenovoBackupSource.toStatus(contentResolverLenovoBackupSource.resolver.call(ContentResolverLenovoBackupSource.this.authorityUri, ContentResolverLenovoBackupSource.METHOD_START_BACKUP, (String) null, (Bundle) null));
        }
    }

    @Override // com.myscript.nebo.migration.LenovoBackupSource
    public Object startBackup(Continuation<? super BackupStatus> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C66262(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.ContentResolverLenovoBackupSource$getStatus$2 */
    /* JADX INFO: compiled from: ContentResolverLenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/migration/BackupStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.ContentResolverLenovoBackupSource$getStatus$2", m1609f = "ContentResolverLenovoBackupSource.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BackupStatus>, Object> {
        int label;

        C66242(Continuation<? super C66242> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContentResolverLenovoBackupSource.this.new C66242(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BackupStatus> continuation) {
            return ((C66242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ContentResolverLenovoBackupSource contentResolverLenovoBackupSource = ContentResolverLenovoBackupSource.this;
            return contentResolverLenovoBackupSource.toStatus(contentResolverLenovoBackupSource.resolver.call(ContentResolverLenovoBackupSource.this.authorityUri, ContentResolverLenovoBackupSource.METHOD_GET_STATUS, (String) null, (Bundle) null));
        }
    }

    @Override // com.myscript.nebo.migration.LenovoBackupSource
    public Object getStatus(Continuation<? super BackupStatus> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C66242(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.ContentResolverLenovoBackupSource$openBackupStream$2 */
    /* JADX INFO: compiled from: ContentResolverLenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Ljava/io/InputStream;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.ContentResolverLenovoBackupSource$openBackupStream$2", m1609f = "ContentResolverLenovoBackupSource.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InputStream>, Object> {
        final /* synthetic */ String $handle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66252(String str, Continuation<? super C66252> continuation) {
            super(2, continuation);
            this.$handle = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContentResolverLenovoBackupSource.this.new C66252(this.$handle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InputStream> continuation) {
            return ((C66252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return ContentResolverLenovoBackupSource.this.resolver.openInputStream(Uri.parse(this.$handle));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.myscript.nebo.migration.LenovoBackupSource
    public Object openBackupStream(String str, Continuation<? super InputStream> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C66252(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BackupStatus toStatus(Bundle bundle) {
        if (bundle == null) {
            return BackupStatus.Unavailable.INSTANCE;
        }
        return INSTANCE.toBackupStatus$app_standardRelease(bundle.getString("phase"), bundle.getInt(KEY_CURRENT, 0), bundle.getInt(KEY_TOTAL, 0), bundle.getString(KEY_URI), bundle.getString("error_code"), bundle.getString("error_message"));
    }

    /* JADX INFO: compiled from: ContentResolverLenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\b\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/migration/ContentResolverLenovoBackupSource$Companion;", "", "<init>", "()V", "PROVIDER_AUTHORITY", "", "METHOD_START_BACKUP", "METHOD_GET_STATUS", "KEY_PHASE", "KEY_CURRENT", "KEY_TOTAL", "KEY_URI", "KEY_ERROR_CODE", "KEY_ERROR_MESSAGE", "PHASE_IDLE", "PHASE_BACKING", "PHASE_DONE", "PHASE_ERROR", "toBackupStatus", "Lcom/myscript/nebo/migration/BackupStatus;", "phase", ContentResolverLenovoBackupSource.KEY_CURRENT, "", ContentResolverLenovoBackupSource.KEY_TOTAL, ContentResolverLenovoBackupSource.KEY_URI, "errorCode", "errorMessage", "toBackupStatus$app_standardRelease", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final BackupStatus toBackupStatus$app_standardRelease(String phase, int current, int total, String uri, String errorCode, String errorMessage) {
            if (phase != null) {
                switch (phase.hashCode()) {
                    case -347204197:
                        if (phase.equals(ContentResolverLenovoBackupSource.PHASE_BACKING)) {
                            return new BackupStatus.InProgress(current, total);
                        }
                        break;
                    case 3089282:
                        if (phase.equals(ContentResolverLenovoBackupSource.PHASE_DONE)) {
                            return new BackupStatus.Done(uri);
                        }
                        break;
                    case 3227604:
                        if (phase.equals(ContentResolverLenovoBackupSource.PHASE_IDLE)) {
                            return BackupStatus.Idle.INSTANCE;
                        }
                        break;
                    case 96784904:
                        if (phase.equals(ContentResolverLenovoBackupSource.PHASE_ERROR)) {
                            return new BackupStatus.Failed(errorCode, errorMessage);
                        }
                        break;
                }
            }
            return new BackupStatus.Unknown(phase);
        }
    }
}
