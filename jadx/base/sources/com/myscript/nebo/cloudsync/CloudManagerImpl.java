package com.myscript.nebo.cloudsync;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.oauth.DbxCredential;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.analytics.AnalyticsProperty;
import com.myscript.nebo.analytics.firebase.NeboFirebaseProperty;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.dropbox.DropboxCallback;
import com.myscript.nebo.dms.dropbox.DropboxClient;
import com.myscript.nebo.dms.dropbox.DropboxLoginHelper;
import com.myscript.nebo.dms.gdrive.DriveLoginHelper;
import com.myscript.nebo.dms.gdrive.GDriveCallback;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.sso.model.UserData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u00018\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010D\u001a\u00020\u001b2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\"\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010J\u001a\u00020\u001bH\u0002J\u000e\u0010K\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010LJ\u0016\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020#H\u0096@¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010LJ\u001e\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0082@¢\u0006\u0002\u0010TJ\u0010\u0010=\u001a\u00020(2\u0006\u0010O\u001a\u00020#H\u0016J@\u0010U\u001a\u00020\u001b26\u0010E\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u001b0VH\u0002J@\u0010Y\u001a\u00020\u001b26\u0010Z\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u001b0VH\u0002J\b\u0010[\u001a\u00020\u001bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010(2\n\u0010_\u001a\u00060`j\u0002`aH\u0002J\u001e\u0010b\u001a\u00020\u00142\b\u0010^\u001a\u0004\u0018\u00010(2\n\u0010_\u001a\u00060`j\u0002`aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010*R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u0014\u0010:\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010,R\u0014\u0010;\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010,R\u0014\u0010<\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010*R\u0014\u0010>\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010,R\u0014\u0010B\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010,R\u0014\u0010C\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010,¨\u0006c"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManagerImpl;", "Lcom/myscript/nebo/cloudsync/CloudManager;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/sso/model/UserData;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "hasForwardCompatibilityIssue", "", "cloudSyncInitializedListeners", "", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudSyncInitializedListener;", "cloudDisconnectedListeners", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudDisconnectedListener;", "addCloudSyncInitializedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeCloudSyncInitializedListener", "addCloudDisconnectedListener", "removeCloudDisconnectedListener", "notifyCloudSyncInitialized", "notifyCloudDisconnecting", "provider", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "notifyCloudDisconnected", "dropboxCallback", "Lcom/myscript/nebo/dms/dropbox/DropboxCallback;", "dropboxPrefKey", "", "getDropboxPrefKey", "()Ljava/lang/String;", "isConnectedToDropbox", "()Z", "gdriveCallback", "Lcom/myscript/nebo/dms/gdrive/GDriveCallback;", "gdrivePrefKey", "getGdrivePrefKey", "technicalLogger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getTechnicalLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "technicalLogger$delegate", "Lkotlin/Lazy;", "cloudLogger", "com/myscript/nebo/cloudsync/CloudManagerImpl$cloudLogger$1", "Lcom/myscript/nebo/cloudsync/CloudManagerImpl$cloudLogger$1;", "isConnectedToGDrive", "isCloudConnected", "providerName", "getProviderName", "connectedProvider", "getConnectedProvider", "()Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "isCloudEnabled", "isCloudBound", "isClientInstantiated", "bindCloud", "callback", "Lcom/myscript/nebo/cloudsync/CloudManager$BindCloudCallback;", "handleBindResult", "bound", "handled", "handleDegradedModeIfNeeded", "unbindCloud", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectCloudInterface", "connect", "providerType", "(Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "setCloudConnected", "enabled", "(ZLcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupDriveClient", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "setupDropboxClient", "onResult", "setHasForwardCompatibilityIssue", "handleErrorAndThrow", "", "actionId", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloudManagerImpl implements CloudManager {
    public static final int $stable = 8;
    private final Application application;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final Set<CloudManager.CloudDisconnectedListener> cloudDisconnectedListeners;
    private final CloudManagerImpl$cloudLogger$1 cloudLogger;
    private final Set<CloudManager.CloudSyncInitializedListener> cloudSyncInitializedListeners;
    private final CoroutineScope coroutineScope;
    private volatile DropboxCallback dropboxCallback;
    private volatile GDriveCallback gdriveCallback;
    private boolean hasForwardCompatibilityIssue;
    private final CoroutineDispatcher ioDispatcher;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final NeboNetworkStateRepository networkStateRepository;

    /* JADX INFO: renamed from: technicalLogger$delegate, reason: from kotlin metadata */
    private final Lazy technicalLogger;
    private final UserData userData;

    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloudManager.CloudProviderType.values().length];
            try {
                iArr[CloudManager.CloudProviderType.Dropbox.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloudManager.CloudProviderType.GDrive.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$disconnectCloudInterface$1 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {344, PDFACompliance.e_PDFA3_5_4}, m1612m = "disconnectCloudInterface", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA3_5_4, 359}, m1615s = {}, m1616v = 2)
    static final class C61681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C61681(Continuation<? super C61681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudManagerImpl.this.disconnectCloudInterface(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$setCloudConnected$1 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl", m1609f = "CloudManagerImpl.kt", m1610i = {0, 0, 0, 0}, m1611l = {399}, m1612m = "setCloudConnected", m1613n = {"provider", "wasConnected", "sharedPreferences", "enabled"}, m1614nl = {400}, m1615s = {"L$0", "L$1", "L$2", "Z$0"}, m1616v = 2)
    static final class C61771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C61771(Continuation<? super C61771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudManagerImpl.this.setCloudConnected(false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$unbindCloud$1 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {337}, m1612m = "unbindCloud", m1613n = {}, m1614nl = {338}, m1615s = {}, m1616v = 2)
    static final class C61801 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C61801(Continuation<? super C61801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudManagerImpl.this.unbindCloud(this);
        }
    }

    public CloudManagerImpl(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager autoSyncTimerManager, NeboNetworkStateRepository networkStateRepository, UserData userData, CoroutineScope coroutineScope, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.application = application;
        this.libraryRepository = libraryRepository;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.networkStateRepository = networkStateRepository;
        this.userData = userData;
        this.coroutineScope = coroutineScope;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.cloudSyncInitializedListeners = new LinkedHashSet();
        this.cloudDisconnectedListeners = new LinkedHashSet();
        this.technicalLogger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CloudManagerImpl.technicalLogger_delegate$lambda$0(this.f$0);
            }
        });
        this.cloudLogger = new CloudManagerImpl$cloudLogger$1(this);
    }

    public /* synthetic */ CloudManagerImpl(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager iAutoSyncTimerManager, NeboNetworkStateRepository neboNetworkStateRepository, UserData userData, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, libraryRepository, iAutoSyncTimerManager, neboNetworkStateRepository, userData, coroutineScope, (i & 64) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 128) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void addCloudSyncInitializedListener(CloudManager.CloudSyncInitializedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.cloudSyncInitializedListeners) {
            this.cloudSyncInitializedListeners.add(listener);
        }
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void removeCloudSyncInitializedListener(CloudManager.CloudSyncInitializedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.cloudSyncInitializedListeners) {
            this.cloudSyncInitializedListeners.remove(listener);
        }
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void addCloudDisconnectedListener(CloudManager.CloudDisconnectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.cloudDisconnectedListeners) {
            this.cloudDisconnectedListeners.add(listener);
        }
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void removeCloudDisconnectedListener(CloudManager.CloudDisconnectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.cloudDisconnectedListeners) {
            this.cloudDisconnectedListeners.remove(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyCloudSyncInitialized() {
        synchronized (this.cloudSyncInitializedListeners) {
            Iterator<T> it = this.cloudSyncInitializedListeners.iterator();
            while (it.hasNext()) {
                ((CloudManager.CloudSyncInitializedListener) it.next()).onCloudSyncInitialized();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyCloudDisconnecting(CloudManager.CloudProviderType provider) {
        synchronized (this.cloudDisconnectedListeners) {
            Iterator<T> it = this.cloudDisconnectedListeners.iterator();
            while (it.hasNext()) {
                ((CloudManager.CloudDisconnectedListener) it.next()).onCloudDisconnecting(provider);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyCloudDisconnected(CloudManager.CloudProviderType provider) {
        synchronized (this.cloudDisconnectedListeners) {
            Iterator<T> it = this.cloudDisconnectedListeners.iterator();
            while (it.hasNext()) {
                ((CloudManager.CloudDisconnectedListener) it.next()).onCloudDisconnected(provider);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final String getDropboxPrefKey() {
        String string = this.application.getString(C6079R.string.pref_cloudsync_dropbox_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public boolean isConnectedToDropbox() {
        return isCloudConnected() && CloudManager.CloudProviderType.Dropbox == getConnectedProvider();
    }

    private final String getGdrivePrefKey() {
        String string = this.application.getString(C6079R.string.pref_cloudsync_gdrive_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TechnicalLogger getTechnicalLogger() {
        return (TechnicalLogger) this.technicalLogger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger technicalLogger_delegate$lambda$0(CloudManagerImpl cloudManagerImpl) {
        ComponentCallbacks2 componentCallbacks2 = cloudManagerImpl.application;
        Intrinsics.checkNotNull(componentCallbacks2, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) componentCallbacks2).provideTechnicalLogger();
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public boolean isConnectedToGDrive() {
        return isCloudConnected() && CloudManager.CloudProviderType.GDrive == getConnectedProvider();
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public boolean isCloudConnected() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.application);
        return defaultSharedPreferences.getBoolean(getDropboxPrefKey(), false) || defaultSharedPreferences.getBoolean(getGdrivePrefKey(), false);
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public String getProviderName() {
        return getProviderName(getConnectedProvider());
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public CloudManager.CloudProviderType getConnectedProvider() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.application);
        return defaultSharedPreferences.getBoolean(getDropboxPrefKey(), false) ? CloudManager.CloudProviderType.Dropbox : defaultSharedPreferences.getBoolean(getGdrivePrefKey(), false) ? CloudManager.CloudProviderType.GDrive : CloudManager.CloudProviderType.None;
    }

    private final boolean isCloudEnabled() {
        NeboNetworkState value = this.networkStateRepository.getNeboNetworkState().getValue();
        return isCloudConnected() && (value != null ? value.isDataTransferAllowed() : false);
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public boolean isCloudBound() {
        return this.libraryRepository.getHasCloudProvider() && isCloudEnabled();
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public boolean isClientInstantiated() {
        int i = WhenMappings.$EnumSwitchMapping$0[getConnectedProvider().ordinal()];
        if (i == 1) {
            return DropboxClient.hasInstance();
        }
        if (i != 2) {
            return false;
        }
        return DriveLoginHelper.hasInstance();
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void bindCloud(final CloudManager.BindCloudCallback callback) {
        if (!isCloudConnected()) {
            if (callback != null) {
                CloudManager.BindCloudCallback.onResult$default(callback, false, false, 2, null);
                return;
            }
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getConnectedProvider().ordinal()];
        if (i == 1) {
            setupDropboxClient(new Function2() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CloudManagerImpl.bindCloud$lambda$0(this.f$0, callback, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            });
        } else if (i == 2) {
            setupDriveClient(new Function2() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CloudManagerImpl.bindCloud$lambda$1(this.f$0, callback, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            });
        } else if (callback != null) {
            CloudManager.BindCloudCallback.onResult$default(callback, false, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCloud$lambda$0(CloudManagerImpl cloudManagerImpl, CloudManager.BindCloudCallback bindCloudCallback, boolean z, boolean z2) {
        cloudManagerImpl.handleBindResult(z, z2, bindCloudCallback);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCloud$lambda$1(CloudManagerImpl cloudManagerImpl, CloudManager.BindCloudCallback bindCloudCallback, boolean z, boolean z2) {
        cloudManagerImpl.handleBindResult(z, z2, bindCloudCallback);
        return Unit.INSTANCE;
    }

    private final void handleBindResult(boolean bound, boolean handled, CloudManager.BindCloudCallback callback) {
        if (bound) {
            if (!this.libraryRepository.getHasCloudProvider()) {
                int i = WhenMappings.$EnumSwitchMapping$0[getConnectedProvider().ordinal()];
                if (i == 1) {
                    this.gdriveCallback = null;
                    DropboxCallback dropboxCallback = new DropboxCallback(new C6175x47b4483b(new PropertyReference0Impl(this) { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$capturedDropboxCallback$1
                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                        public Object get() {
                            return Boolean.valueOf(((CloudManagerImpl) this.receiver).isCloudBound());
                        }
                    }), new CloudManagerImpl$handleBindResult$capturedDropboxCallback$2(this), this.libraryRepository.getCloudOperationLogger(), this.cloudLogger, new CloudManagerImpl$handleBindResult$capturedDropboxCallback$3(this.libraryRepository));
                    this.dropboxCallback = dropboxCallback;
                    BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C61711(callback, dropboxCallback, null), 2, null);
                    return;
                }
                if (i != 2) {
                    if (callback != null) {
                        CloudManager.BindCloudCallback.onResult$default(callback, false, false, 2, null);
                        return;
                    }
                    return;
                } else {
                    this.dropboxCallback = null;
                    GDriveCallback gDriveCallback = new GDriveCallback(this.application, new C6176x1a44c495(new PropertyReference0Impl(this) { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$capturedGDriveCallback$1
                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                        public Object get() {
                            return Boolean.valueOf(((CloudManagerImpl) this.receiver).isCloudBound());
                        }
                    }), new CloudManagerImpl$handleBindResult$capturedGDriveCallback$2(this), this.libraryRepository.getCloudOperationLogger(), new CloudManagerImpl$handleBindResult$capturedGDriveCallback$3(this.libraryRepository));
                    this.gdriveCallback = gDriveCallback;
                    BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C61722(callback, gDriveCallback, null), 2, null);
                    return;
                }
            }
            notifyCloudSyncInitialized();
            if (callback != null) {
                CloudManager.BindCloudCallback.onResult$default(callback, true, false, 2, null);
                return;
            }
            return;
        }
        this.dropboxCallback = null;
        this.gdriveCallback = null;
        if (callback != null) {
            callback.onResult(false, handled);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$1 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$1", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {222}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {230}, m1615s = {}, m1616v = 2)
    static final class C61711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudManager.BindCloudCallback $callback;
        final /* synthetic */ DropboxCallback $capturedDropboxCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61711(CloudManager.BindCloudCallback bindCloudCallback, DropboxCallback dropboxCallback, Continuation<? super C61711> continuation) {
            super(2, continuation);
            this.$callback = bindCloudCallback;
            this.$capturedDropboxCallback = dropboxCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61711(this.$callback, this.$capturedDropboxCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (BuildersKt.withContext(CloudManagerImpl.this.ioDispatcher, new AnonymousClass1(CloudManagerImpl.this, this.$capturedDropboxCallback, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CloudManagerImpl.this.notifyCloudSyncInitialized();
                CloudManager.BindCloudCallback bindCloudCallback = this.$callback;
                if (bindCloudCallback != null) {
                    CloudManager.BindCloudCallback.onResult$default(bindCloudCallback, true, false, 2, null);
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                CloudManagerImpl.this.dropboxCallback = null;
                CloudManagerImpl.this.gdriveCallback = null;
                CloudManagerImpl.this.libraryRepository.setCloudProviderName(null);
                Log.e("CloudManagerImpl", "Failed to set Dropbox cloud interface", e2);
                CloudManager.BindCloudCallback bindCloudCallback2 = this.$callback;
                if (bindCloudCallback2 != null) {
                    CloudManager.BindCloudCallback.onResult$default(bindCloudCallback2, false, false, 2, null);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: CloudManagerImpl.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$1$1", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DropboxCallback $capturedDropboxCallback;
            int label;
            final /* synthetic */ CloudManagerImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CloudManagerImpl cloudManagerImpl, DropboxCallback dropboxCallback, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = cloudManagerImpl;
                this.$capturedDropboxCallback = dropboxCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$capturedDropboxCallback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.libraryRepository.setCloudProviderName(this.this$0.getProviderName(CloudManager.CloudProviderType.Dropbox));
                    this.this$0.libraryRepository.setCloudDriveInterface(this.$capturedDropboxCallback);
                    this.this$0.handleDegradedModeIfNeeded();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {262}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {270}, m1615s = {}, m1616v = 2)
    static final class C61722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudManager.BindCloudCallback $callback;
        final /* synthetic */ GDriveCallback $capturedGDriveCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61722(CloudManager.BindCloudCallback bindCloudCallback, GDriveCallback gDriveCallback, Continuation<? super C61722> continuation) {
            super(2, continuation);
            this.$callback = bindCloudCallback;
            this.$capturedGDriveCallback = gDriveCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61722(this.$callback, this.$capturedGDriveCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (BuildersKt.withContext(CloudManagerImpl.this.ioDispatcher, new AnonymousClass1(CloudManagerImpl.this, this.$capturedGDriveCallback, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CloudManagerImpl.this.notifyCloudSyncInitialized();
                CloudManager.BindCloudCallback bindCloudCallback = this.$callback;
                if (bindCloudCallback != null) {
                    CloudManager.BindCloudCallback.onResult$default(bindCloudCallback, true, false, 2, null);
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                CloudManagerImpl.this.dropboxCallback = null;
                CloudManagerImpl.this.gdriveCallback = null;
                CloudManagerImpl.this.libraryRepository.setCloudProviderName(null);
                Log.e("CloudManagerImpl", "Failed to set GDrive cloud interface", e2);
                CloudManager.BindCloudCallback bindCloudCallback2 = this.$callback;
                if (bindCloudCallback2 != null) {
                    CloudManager.BindCloudCallback.onResult$default(bindCloudCallback2, false, false, 2, null);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CloudManagerImpl.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleBindResult$2$1", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ GDriveCallback $capturedGDriveCallback;
            int label;
            final /* synthetic */ CloudManagerImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CloudManagerImpl cloudManagerImpl, GDriveCallback gDriveCallback, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = cloudManagerImpl;
                this.$capturedGDriveCallback = gDriveCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$capturedGDriveCallback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.libraryRepository.setCloudProviderName(this.this$0.getProviderName(CloudManager.CloudProviderType.GDrive));
                    this.this$0.libraryRepository.setCloudDriveInterface(this.$capturedGDriveCallback);
                    this.this$0.handleDegradedModeIfNeeded();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDegradedModeIfNeeded() {
        String string;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.application);
        int i = 0;
        if (defaultSharedPreferences.getBoolean(this.application.getString(C6079R.string.pref_internal_sync_degraded_key), false)) {
            try {
                string = defaultSharedPreferences.getString(this.application.getString(C6079R.string.pref_internal_sync_degraded_upload_dial_key), null);
            } catch (NumberFormatException unused) {
            }
            int i2 = string != null ? Integer.parseInt(string) : 0;
            try {
                String string2 = defaultSharedPreferences.getString(this.application.getString(C6079R.string.pref_internal_sync_degraded_download_dial_key), null);
                if (string2 != null) {
                    i = Integer.parseInt(string2);
                }
            } catch (NumberFormatException unused2) {
            }
            this.libraryRepository.setSyncDegradedMode(i2, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.cloudsync.CloudManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object unbindCloud(Continuation<? super Unit> continuation) {
        C61801 c61801;
        if (continuation instanceof C61801) {
            c61801 = (C61801) continuation;
            if ((c61801.label & Integer.MIN_VALUE) != 0) {
                c61801.label -= Integer.MIN_VALUE;
            } else {
                c61801 = new C61801(continuation);
            }
        }
        Object obj = c61801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c61801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c61801.label = 1;
            if (disconnectCloudInterface(c61801) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        DropboxClient.destroy();
        DriveLoginHelper.destroy();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object disconnectCloudInterface(Continuation<? super Unit> continuation) {
        C61681 c61681;
        if (continuation instanceof C61681) {
            c61681 = (C61681) continuation;
            if ((c61681.label & Integer.MIN_VALUE) != 0) {
                c61681.label -= Integer.MIN_VALUE;
            } else {
                c61681 = new C61681(continuation);
            }
        }
        Object obj = c61681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c61681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = this.mainDispatcher;
            C61692 c61692 = new C61692(null);
            c61681.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, c61692, c61681) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.dropboxCallback = null;
            this.gdriveCallback = null;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher coroutineDispatcher2 = this.ioDispatcher;
        C61703 c61703 = new C61703(null);
        c61681.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$disconnectCloudInterface$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$disconnectCloudInterface$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {345}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {346}, m1615s = {}, m1616v = 2)
    static final class C61692 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61692(Continuation<? super C61692> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61692(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61692) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudManagerImpl.this.autoSyncTimerManager.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CloudManagerImpl.this.autoSyncTimerManager.cancelSync();
            DropboxCallback dropboxCallback = CloudManagerImpl.this.dropboxCallback;
            if (dropboxCallback != null) {
                dropboxCallback.disconnect();
            }
            GDriveCallback gDriveCallback = CloudManagerImpl.this.gdriveCallback;
            if (gDriveCallback == null) {
                return null;
            }
            gDriveCallback.disconnect();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$disconnectCloudInterface$3 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$disconnectCloudInterface$3", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61703 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61703(Continuation<? super C61703> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61703(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61703) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CloudManagerImpl.this.libraryRepository.setCloudProviderName(null);
                CloudManagerImpl.this.libraryRepository.setCloudDriveInterface(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$connect$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$connect$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {365}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {366}, m1615s = {}, m1616v = 2)
    static final class C61662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudManager.CloudProviderType $providerType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61662(CloudManager.CloudProviderType cloudProviderType, Continuation<? super C61662> continuation) {
            super(2, continuation);
            this.$providerType = cloudProviderType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61662(this.$providerType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61662) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudManagerImpl.this.setCloudConnected(true, this.$providerType, this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public Object connect(CloudManager.CloudProviderType cloudProviderType, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new C61662(cloudProviderType, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$disconnect$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$disconnect$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_7_2}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA3_7_3}, m1615s = {}, m1616v = 2)
    static final class C61672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudManager.CloudProviderType $cloudProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61672(CloudManager.CloudProviderType cloudProviderType, Continuation<? super C61672> continuation) {
            super(2, continuation);
            this.$cloudProvider = cloudProviderType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61672(this.$cloudProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudManagerImpl.this.setCloudConnected(false, this.$cloudProvider, this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public Object disconnect(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new C61672(getConnectedProvider(), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setCloudConnected(boolean z, final CloudManager.CloudProviderType cloudProviderType, Continuation<? super Unit> continuation) {
        C61771 c61771;
        if (continuation instanceof C61771) {
            c61771 = (C61771) continuation;
            if ((c61771.label & Integer.MIN_VALUE) != 0) {
                c61771.label -= Integer.MIN_VALUE;
            } else {
                c61771 = new C61771(continuation);
            }
        }
        Object obj = c61771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c61771.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.application);
            Intrinsics.checkNotNull(defaultSharedPreferences);
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            int i2 = WhenMappings.$EnumSwitchMapping$0[cloudProviderType.ordinal()];
            if (i2 == 1) {
                booleanRef.element = defaultSharedPreferences.getBoolean(getDropboxPrefKey(), false);
                editorEdit.putBoolean(getDropboxPrefKey(), z);
                editorEdit.remove(getGdrivePrefKey());
            } else if (i2 == 2) {
                booleanRef.element = defaultSharedPreferences.getBoolean(getGdrivePrefKey(), false);
                editorEdit.putBoolean(getGdrivePrefKey(), z);
                editorEdit.remove(getDropboxPrefKey());
            } else {
                return Unit.INSTANCE;
            }
            editorEdit.apply();
            if (booleanRef.element && !z) {
                notifyCloudDisconnecting(cloudProviderType);
                c61771.L$0 = cloudProviderType;
                c61771.L$1 = SpillingKt.nullOutSpilledVariable(booleanRef);
                c61771.L$2 = SpillingKt.nullOutSpilledVariable(defaultSharedPreferences);
                c61771.Z$0 = z;
                c61771.label = 1;
                if (unbindCloud(c61771) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!booleanRef.element && isCloudConnected()) {
                    bindCloud(new CloudManager.BindCloudCallback() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl.setCloudConnected.3

                        /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$setCloudConnected$3$WhenMappings */
                        /* JADX INFO: compiled from: CloudManagerImpl.kt */
                        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                        public static final /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[CloudManager.CloudProviderType.values().length];
                                try {
                                    iArr[CloudManager.CloudProviderType.Dropbox.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[CloudManager.CloudProviderType.GDrive.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        @Override // com.myscript.nebo.cloudsync.CloudManager.BindCloudCallback
                        public void onResult(boolean bound, boolean handled) {
                            String strConcat;
                            int i3 = WhenMappings.$EnumSwitchMapping$0[cloudProviderType.ordinal()];
                            if (i3 == 1) {
                                strConcat = "dropbox".concat(this.libraryRepository.getIsAutoSyncEnabled() ? "_auto_sync" : "");
                            } else if (i3 == 2) {
                                strConcat = "gdrive".concat(this.libraryRepository.getIsAutoSyncEnabled() ? "_auto_sync" : "");
                            } else {
                                strConcat = "not_syncing";
                            }
                            AnalyticsProperty.log$default(new NeboFirebaseProperty.CloudSyncProviderProperty(strConcat), null, 1, null);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c61771.Z$0;
            cloudProviderType = (CloudManager.CloudProviderType) c61771.L$0;
            ResultKt.throwOnFailure(obj);
        }
        notifyCloudDisconnected(cloudProviderType);
        AnalyticsProperty.log$default(new NeboFirebaseProperty.CloudSyncProviderProperty("not_syncing"), null, 1, null);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public String getProviderName(CloudManager.CloudProviderType providerType) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        int i = WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()];
        if (i == 1) {
            String string = this.application.getString(C6079R.string.cloud_provider_dropbox);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i == 2) {
            String string2 = this.application.getString(C6079R.string.cloud_provider_gdrive);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        return "";
    }

    private final void setupDriveClient(final Function2<? super Boolean, ? super Boolean, Unit> callback) {
        DriveLoginHelper.isWellConnectedAsync(new DriveLoginHelper.ConnectionCallback() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$$ExternalSyntheticLambda0
            @Override // com.myscript.nebo.dms.gdrive.DriveLoginHelper.ConnectionCallback
            public final void onResult(boolean z, Exception exc) {
                CloudManagerImpl.setupDriveClient$lambda$0(this.f$0, callback, z, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDriveClient$lambda$0(CloudManagerImpl cloudManagerImpl, Function2 function2, boolean z, Exception exc) {
        BuildersKt__Builders_commonKt.launch$default(cloudManagerImpl.coroutineScope, cloudManagerImpl.mainDispatcher, null, new CloudManagerImpl$setupDriveClient$1$1(exc, z, cloudManagerImpl, function2, null), 2, null);
    }

    private final void setupDropboxClient(final Function2<? super Boolean, ? super Boolean, Unit> onResult) {
        DbxCredential fully;
        String dropboxCredential = this.userData.getDropboxCredential();
        if (dropboxCredential.length() == 0) {
            fully = new DbxCredential(this.userData.getDropboxToken());
        } else {
            try {
                fully = DbxCredential.Reader.readFully(dropboxCredential);
            } catch (JsonReadException unused) {
                fully = null;
            }
        }
        if (fully == null) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C61792(onResult, null), 2, null);
        } else {
            DropboxLoginHelper.setupDropboxClient(fully, new DropboxLoginHelper.SetupCallback() { // from class: com.myscript.nebo.cloudsync.CloudManagerImpl$$ExternalSyntheticLambda1
                @Override // com.myscript.nebo.dms.dropbox.DropboxLoginHelper.SetupCallback
                public final void onResult(boolean z, Exception exc) {
                    CloudManagerImpl.setupDropboxClient$lambda$0(this.f$0, onResult, z, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDropboxClient$lambda$0(CloudManagerImpl cloudManagerImpl, Function2 function2, boolean z, Exception exc) {
        BuildersKt__Builders_commonKt.launch$default(cloudManagerImpl.coroutineScope, cloudManagerImpl.mainDispatcher, null, new CloudManagerImpl$setupDropboxClient$1$1(exc, z, cloudManagerImpl, function2, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$setupDropboxClient$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$setupDropboxClient$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, Boolean, Unit> $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C61792(Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super C61792> continuation) {
            super(2, continuation);
            this.$onResult = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C61792(this.$onResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onResult.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    public void setHasForwardCompatibilityIssue() {
        this.hasForwardCompatibilityIssue = true;
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager
    /* JADX INFO: renamed from: hasForwardCompatibilityIssue, reason: from getter */
    public boolean getHasForwardCompatibilityIssue() {
        return this.hasForwardCompatibilityIssue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void handleErrorAndThrow(String actionId, Exception exception) throws Exception {
        handleError(actionId, exception);
        throw exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleError(String actionId, Exception exception) {
        this.cloudLogger.logError(exception);
        DropboxCallback dropboxCallback = this.dropboxCallback;
        GDriveCallback gDriveCallback = this.gdriveCallback;
        boolean z = true;
        if ((dropboxCallback != null && dropboxCallback.isAuthenticateError(exception)) || (gDriveCallback != null && gDriveCallback.isAuthenticateError(exception))) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new C61731(null), 2, null);
            this.libraryRepository.notifyCloudTokenExpired();
        } else if (dropboxCallback == null && gDriveCallback == null) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new C61742(null), 2, null);
            this.libraryRepository.notifyCloudTokenExpired();
        } else {
            z = false;
        }
        this.libraryRepository.getCloudOperationLogger().addError(actionId, exception.toString());
        return z;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleError$1 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleError$1", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA5_2_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA5_2_2}, m1615s = {}, m1616v = 2)
    static final class C61731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61731(Continuation<? super C61731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudManagerImpl.this.disconnectCloudInterface(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$handleError$2 */
    /* JADX INFO: compiled from: CloudManagerImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$handleError$2", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA5_2_8}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA5_2_9}, m1615s = {}, m1616v = 2)
    static final class C61742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61742(Continuation<? super C61742> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudManagerImpl.this.new C61742(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudManagerImpl.this.disconnectCloudInterface(this) == coroutine_suspended) {
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
}
