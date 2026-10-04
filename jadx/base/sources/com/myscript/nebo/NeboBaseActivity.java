package com.myscript.nebo;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.preference.PreferenceManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.dropbox.core.android.Auth;
import com.dropbox.core.oauth.DbxCredential;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.atk.core.Context;
import com.myscript.nebo.NeboBaseActivity;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import com.myscript.nebo.cloudsync.dialogs.ForwardCompatibilityDialogFragment;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.IMyScriptEngineContextProvider;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.debug.UOCController;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.dropbox.DropboxLoginHelper;
import com.myscript.nebo.dms.event.OnDMSSyncStateChangedEvent;
import com.myscript.nebo.dms.gdrive.C6278R;
import com.myscript.nebo.dms.gdrive.DriveLoginHelper;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.dms.sharepage.SharePageController;
import com.myscript.nebo.dms.sharepage.SharePageControllerProvider;
import com.myscript.nebo.dms.sharepage.dialog.SharePageDialog;
import com.myscript.nebo.events.OnSSOTokenInvalidEvent;
import com.myscript.nebo.events.OnUpdatePrivacyPolicyNeededEvent;
import com.myscript.nebo.export.ExportHelper;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.imageloading.GlideApp;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.p034ui.compose.NativeSignInDialogKt;
import com.myscript.nebo.sso.HelpUsManager;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.p032ui.SSOTokenInvalidatedDialogFragment;
import com.myscript.nebo.sso.p032ui.UpdatePrivacyPolicyActivity;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.myscript.nebo.utils.Session;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.squareup.otto.Subscribe;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: NeboBaseActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0002LO\b\u0017\u0018\u0000 «\u00012\u00020\u00012\u00020\u0002:\u0002«\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010Q\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u0010\u0010T\u001a\u00020:2\u0006\u0010R\u001a\u00020SH\u0014J\u0010\u0010U\u001a\u00020:2\u0006\u0010V\u001a\u00020SH\u0014J\b\u0010W\u001a\u00020:H\u0014J\b\u0010X\u001a\u00020:H\u0014J\b\u0010Y\u001a\u00020:H\u0014J\b\u0010Z\u001a\u00020:H\u0014J\b\u0010[\u001a\u00020:H\u0014J\u0010\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020\u0006H\u0004J\u0010\u0010^\u001a\u00020:2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020:H\u0004J\u0010\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020\u0006H\u0016J\b\u0010f\u001a\u00020\u0006H\u0016J\b\u0010g\u001a\u00020\u0006H\u0016J\b\u0010h\u001a\u00020:H\u0016J\b\u0010i\u001a\u00020:H\u0016J\b\u0010j\u001a\u00020:H\u0002J\b\u0010k\u001a\u00020lH\u0016J\u0018\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020d2\u0006\u0010o\u001a\u00020pH\u0016J\n\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020:H\u0016J\u0006\u0010v\u001a\u00020:J\u000e\u0010w\u001a\u00020:2\u0006\u0010)\u001a\u00020*J\u0010\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020zH\u0004J\b\u0010{\u001a\u00020:H\u0002J\u0006\u0010|\u001a\u00020:J\b\u0010}\u001a\u00020:H\u0002J\b\u0010~\u001a\u00020:H\u0002J\b\u0010\u007f\u001a\u00020:H\u0004J\t\u0010\u0080\u0001\u001a\u00020:H\u0002J\t\u0010\u0081\u0001\u001a\u00020:H\u0002J\u0011\u0010\u0082\u0001\u001a\u00020:2\u0006\u0010_\u001a\u00020`H\u0002J\u001c\u0010\u0083\u0001\u001a\u00020:2\u0006\u0010_\u001a\u00020`2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0006H\u0014J\u001e\u0010\u0085\u0001\u001a\u00020:2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0088\u0001\u001a\u00020:H\u0002J\t\u0010\u0089\u0001\u001a\u00020\u0006H\u0002J\u0019\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020:09H\u0084@¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001b\u0010\u008d\u0001\u001a\u00020:2\u0007\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020\u0006H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020:J\u0019\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020:09H\u0086@¢\u0006\u0006\b\u0092\u0001\u0010\u008c\u0001J\u0019\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020:09H\u0082@¢\u0006\u0006\b\u0094\u0001\u0010\u008c\u0001J#\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020:092\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0082@¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J#\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020:092\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0082@¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J#\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020:092\b\u0010¢\u0001\u001a\u00030£\u0001H\u0082@¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001f\u0010¦\u0001\u001a\u00020:2\r\u0010§\u0001\u001a\b0¨\u0001j\u0003`©\u0001H\u0082@¢\u0006\u0003\u0010ª\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010\nR\u000e\u0010F\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u0018\u0010\u0095\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¬\u0001²\u0006\f\u0010\u00ad\u0001\u001a\u00030®\u0001X\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/NeboBaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$Callback;", "<init>", "()V", "dropboxConnectionOnGoing", "", "getDropboxConnectionOnGoing", "()Z", "setDropboxConnectionOnGoing", "(Z)V", "firstLaunchingIntent", "Landroid/content/Intent;", "getFirstLaunchingIntent", "()Landroid/content/Intent;", "setFirstLaunchingIntent", "(Landroid/content/Intent;)V", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "setLibraryRepository", "(Lcom/myscript/nebo/dms/core/LibraryRepository;)V", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "getAutoSyncTimerManager", "()Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "setAutoSyncTimerManager", "(Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;)V", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "getCloudManager", "()Lcom/myscript/nebo/cloudsync/CloudManager;", "setCloudManager", "(Lcom/myscript/nebo/cloudsync/CloudManager;)V", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "getUserData", "()Lcom/myscript/nebo/sso/model/UserData;", "setUserData", "(Lcom/myscript/nebo/sso/model/UserData;)V", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "getSsoManager", "()Lcom/myscript/nebo/sso/api/ISSOManager;", "setSsoManager", "(Lcom/myscript/nebo/sso/api/ISSOManager;)V", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "pendingAuthorizationContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/Result;", "", "uocController", "Lcom/myscript/nebo/common/debug/UOCController;", "dpiDebugView", "Landroid/widget/TextView;", "notebookInfoDebugView", "<set-?>", "showNativeSignInDialog", "getShowNativeSignInDialog", "setShowNativeSignInDialog", "showNativeSignInDialog$delegate", "Landroidx/compose/runtime/MutableState;", "nativeSignInOverlayAttached", "signInLoginActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "appUpdateHandler", "Lcom/myscript/nebo/AppUpdateHandler;", "busEventListener", "com/myscript/nebo/NeboBaseActivity$busEventListener$1", "Lcom/myscript/nebo/NeboBaseActivity$busEventListener$1;", "loginListener", "com/myscript/nebo/NeboBaseActivity$loginListener$1", "Lcom/myscript/nebo/NeboBaseActivity$loginListener$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestoreInstanceState", "onSaveInstanceState", "outState", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onCloudTokenExpired", "expired", "cloudTokenExpired", "cloudProviderType", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "findDebugView", "resetUUID", "pageKey", "Lcom/myscript/snt/core/PageKey;", "usesFullscreenDialog", "hasValidUserAccount", "hasCloudUserConsent", "setCloudUserConsent", "signInRequested", "ensureNativeSignInOverlay", "getSharePageController", "Lcom/myscript/nebo/dms/sharepage/SharePageController;", "requestThumbnail", "requestedPageKey", "callback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ThumbnailCallback;", "getPageUpdateProvider", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProvider;", "getImageLoader", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ImageLoader;", "onSharedPageSuccessful", "onUserSignOut", "onUserSignIn", "displayNetworkOperationCanceledOverCellularPopup", "messageResId", "", "handleDebugView", "driveSignOut", "revokeDriveAuthorisation", "checkForwardCompatibilityIssue", "openForwardCompatibilityIssueDialog", "checkSSOTokenInvalidated", "checkUpdatePrivacyPolicy", "openCloudTokenInvalidatedDialog", "openCloudDisconnectedDialog", "tokenInvalidated", "handleCloudReconnect", "providerName", "", "handleCloudDisconnect", "handleManualDropboxSignIn", "initCloud", "initCloud-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindCloud", "wasBound", "clientInitialized", "dropboxSignIn", "driveManualSignIn", "driveManualSignIn-IoAF18A", "driveSilentSignIn", "driveSilentSignIn-IoAF18A", "intentSenderLauncher", "Landroidx/activity/result/IntentSenderRequest;", "handleAuthorizationResult", "authorizationResult", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "handleAuthorizationResult-gIAlu-s", "(Lcom/google/android/gms/auth/api/identity/AuthorizationResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authorizeGoogleDrive", "authorizationRequest", "Lcom/google/android/gms/auth/api/identity/AuthorizationRequest;", "authorizeGoogleDrive-gIAlu-s", "(Lcom/google/android/gms/auth/api/identity/AuthorizationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGDriveSignIn", "result", "Landroidx/credentials/GetCredentialResponse;", "handleGDriveSignIn-gIAlu-s", "(Landroidx/credentials/GetCredentialResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGDriveSignInFailure", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_standardRelease", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class NeboBaseActivity extends AppCompatActivity implements SharePageDialog.Callback {
    private static final String ELLIPSIS = "…";
    private static final String NEEDS_NEW_AUTH_CODE_KEY = "NEEDS_NEW_AUTH_CODE_KEY";
    private static final String SHOW_NATIVE_SIGN_IN_DIALOG_KEY = "SHOW_NATIVE_SIGN_IN_DIALOG_KEY";
    protected IAutoSyncTimerManager autoSyncTimerManager;
    protected CloudManager cloudManager;
    private TextView dpiDebugView;
    private boolean dropboxConnectionOnGoing;
    private Intent firstLaunchingIntent;
    protected FragmentManager fragmentManager;
    protected LibraryRepository libraryRepository;
    private boolean nativeSignInOverlayAttached;
    private NeboNetworkStateRepository networkStateRepository;
    private TextView notebookInfoDebugView;
    private CancellableContinuation<? super Result<Unit>> pendingAuthorizationContinuation;
    protected ISSOManager ssoManager;
    private UOCController uocController;
    protected UserData userData;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: showNativeSignInDialog$delegate, reason: from kotlin metadata */
    private final MutableState showNativeSignInDialog = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final ActivityResultLauncher<Intent> signInLoginActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda3
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "it");
        }
    });
    private final AppUpdateHandler appUpdateHandler = new AppUpdateHandler();
    private final NeboBaseActivity$busEventListener$1 busEventListener = new Object() { // from class: com.myscript.nebo.NeboBaseActivity$busEventListener$1
        @Subscribe
        public final void onDMSSyncStateChangedEvent(OnDMSSyncStateChangedEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.this$0.checkForwardCompatibilityIssue();
        }

        @Subscribe
        public final void onSSOTokenInvalidEvent(OnSSOTokenInvalidEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.this$0.driveSignOut();
            this.this$0.checkSSOTokenInvalidated();
        }

        @Subscribe
        public final void onUpdatePrivacyPolicyNeededEvent(OnUpdatePrivacyPolicyNeededEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.this$0.checkUpdatePrivacyPolicy();
        }
    };
    private final NeboBaseActivity$loginListener$1 loginListener = new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.NeboBaseActivity$loginListener$1
        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogin() {
            NeboBaseActivity neboBaseActivity = this.this$0;
            neboBaseActivity.onUserSignIn(neboBaseActivity.getUserData());
        }

        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogout() {
            this.this$0.onUserSignOut();
        }
    };
    private ActivityResultLauncher<IntentSenderRequest> intentSenderLauncher = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda4
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) throws ApiException {
            NeboBaseActivity.intentSenderLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });

    /* JADX INFO: compiled from: NeboBaseActivity.kt */
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

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleGDriveSignInFailure$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0, 1, 1, 1, 1}, m1611l = {990, 995}, m1612m = "handleGDriveSignInFailure", m1613n = {"e", "logger", "e", "logger", "$this$handleGDriveSignInFailure_u24lambda_u240", "$i$a$-runCatching-NeboBaseActivity$handleGDriveSignInFailure$3"}, m1614nl = {993, 996}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C60701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C60701(Continuation<? super C60701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBaseActivity.this.handleGDriveSignInFailure(null, this);
        }
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public SharePageDialog.PageUpdateProvider getPageUpdateProvider() {
        return null;
    }

    protected final boolean getDropboxConnectionOnGoing() {
        return this.dropboxConnectionOnGoing;
    }

    protected final void setDropboxConnectionOnGoing(boolean z) {
        this.dropboxConnectionOnGoing = z;
    }

    protected final Intent getFirstLaunchingIntent() {
        return this.firstLaunchingIntent;
    }

    protected final void setFirstLaunchingIntent(Intent intent) {
        this.firstLaunchingIntent = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public final FragmentManager getFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
        return null;
    }

    protected final void setFragmentManager(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<set-?>");
        this.fragmentManager = fragmentManager;
    }

    protected final LibraryRepository getLibraryRepository() {
        LibraryRepository libraryRepository = this.libraryRepository;
        if (libraryRepository != null) {
            return libraryRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
        return null;
    }

    protected final void setLibraryRepository(LibraryRepository libraryRepository) {
        Intrinsics.checkNotNullParameter(libraryRepository, "<set-?>");
        this.libraryRepository = libraryRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IAutoSyncTimerManager getAutoSyncTimerManager() {
        IAutoSyncTimerManager iAutoSyncTimerManager = this.autoSyncTimerManager;
        if (iAutoSyncTimerManager != null) {
            return iAutoSyncTimerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
        return null;
    }

    protected final void setAutoSyncTimerManager(IAutoSyncTimerManager iAutoSyncTimerManager) {
        Intrinsics.checkNotNullParameter(iAutoSyncTimerManager, "<set-?>");
        this.autoSyncTimerManager = iAutoSyncTimerManager;
    }

    protected final CloudManager getCloudManager() {
        CloudManager cloudManager = this.cloudManager;
        if (cloudManager != null) {
            return cloudManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
        return null;
    }

    protected final void setCloudManager(CloudManager cloudManager) {
        Intrinsics.checkNotNullParameter(cloudManager, "<set-?>");
        this.cloudManager = cloudManager;
    }

    protected final UserData getUserData() {
        UserData userData = this.userData;
        if (userData != null) {
            return userData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userData");
        return null;
    }

    protected final void setUserData(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "<set-?>");
        this.userData = userData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ISSOManager getSsoManager() {
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager != null) {
            return iSSOManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
        return null;
    }

    protected final void setSsoManager(ISSOManager iSSOManager) {
        Intrinsics.checkNotNullParameter(iSSOManager, "<set-?>");
        this.ssoManager = iSSOManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowNativeSignInDialog() {
        return ((Boolean) this.showNativeSignInDialog.getValue()).booleanValue();
    }

    private final void setShowNativeSignInDialog(boolean z) {
        this.showNativeSignInDialog.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NeboBaseActivity neboBaseActivity = this;
        this.appUpdateHandler.registerActivity(neboBaseActivity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        setFragmentManager(supportFragmentManager);
        if (savedInstanceState != null) {
            this.firstLaunchingIntent = (Intent) savedInstanceState.getParcelable(getString(C6079R.string.first_intent));
        }
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        setLibraryRepository(((LibraryRepository.Provider) application).provideLibraryRepository());
        ComponentCallbacks2 application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.dms.core.IAutoSyncTimerManager.Provider");
        setAutoSyncTimerManager(((IAutoSyncTimerManager.Provider) application2).provideAutoSyncTimerManager());
        ComponentCallbacks2 application3 = getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.common.IMyScriptEngineContextProvider");
        Context engineContext = ((IMyScriptEngineContextProvider) application3).getEngineContext();
        if (engineContext == null) {
            new MaterialAlertDialogBuilder(this).setTitle(C6079R.string.certificate_dialog_title).setMessage(C6079R.string.certificate_dialog_label).setCancelable(false).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).show();
        }
        ComponentCallbacks2 application4 = getApplication();
        Intrinsics.checkNotNull(application4, "null cannot be cast to non-null type com.myscript.nebo.cloudsync.CloudManager.Provider");
        setCloudManager(((CloudManager.Provider) application4).provideCloudManager());
        ComponentCallbacks2 application5 = getApplication();
        Intrinsics.checkNotNull(application5, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
        setUserData(((UserData.Provider) application5).provideUserData());
        ComponentCallbacks2 application6 = getApplication();
        Intrinsics.checkNotNull(application6, "null cannot be cast to non-null type com.myscript.nebo.sso.api.ISSOManager.Provider");
        setSsoManager(((ISSOManager.Provider) application6).provideSSOManager());
        getSsoManager().addLoginListener(this.loginListener);
        ComponentCallbacks2 application7 = getApplication();
        Intrinsics.checkNotNull(application7, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        this.networkStateRepository = ((NeboNetworkStateRepositoryProvider) application7).provideNeboNetworkStateRepository();
        getSupportFragmentManager().setFragmentResultListener(CloudTokenInvalidDialogFragment.REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda9
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                NeboBaseActivity.onCreate$lambda$0(this.f$0, str, bundle);
            }
        });
        if (getResources().getBoolean(C6079R.bool.show_debug_view)) {
            this.uocController = new UOCController(neboBaseActivity, C6079R.id.app_debug_userObjectCount, engineContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(NeboBaseActivity neboBaseActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString(CloudTokenInvalidDialogFragment.KEY_ACTION);
        String string2 = bundle.getString(CloudTokenInvalidDialogFragment.KEY_PROVIDER);
        boolean z = bundle.getBoolean(CloudTokenInvalidDialogFragment.KEY_TOKEN_INVALIDATED, false);
        if (Intrinsics.areEqual(string, CloudTokenInvalidDialogFragment.ACTION_RECONNECT)) {
            neboBaseActivity.handleCloudReconnect(string2, z);
        } else if (Intrinsics.areEqual(string, CloudTokenInvalidDialogFragment.ACTION_DISCONNECT)) {
            neboBaseActivity.handleCloudDisconnect();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getBoolean(SHOW_NATIVE_SIGN_IN_DIALOG_KEY, false)) {
            setShowNativeSignInDialog(true);
            ensureNativeSignInOverlay();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(SHOW_NATIVE_SIGN_IN_DIALOG_KEY, getShowNativeSignInDialog());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        MainThreadBus.eventBus.register(this.busEventListener);
        checkForwardCompatibilityIssue();
        checkSSOTokenInvalidated();
        checkUpdatePrivacyPolicy();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60731(null), 3, null);
        if (Session.needToDisplaySSOTokenInvalidated && getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            openCloudTokenInvalidatedDialog(CloudManager.CloudProviderType.Dropbox);
        }
        NeboBaseActivity neboBaseActivity = this;
        if (ExportHelper.wasProbablyGoneExporting(neboBaseActivity)) {
            ExportHelper.resetProbablyGoneExporting(neboBaseActivity);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$onStart$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$onStart$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {246}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {247}, m1615s = {}, m1616v = 2)
    static final class C60731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60731(Continuation<? super C60731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM12803initCloudIoAF18A;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM12803initCloudIoAF18A = NeboBaseActivity.this.m12803initCloudIoAF18A(this);
                if (objM12803initCloudIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM12803initCloudIoAF18A = ((Result) obj).getValue();
            }
            if (Result.m14506isSuccessimpl(objM12803initCloudIoAF18A)) {
                Log.d("NeboBaseActivity", "initCloud succeeded");
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM12803initCloudIoAF18A);
            if (thM14502exceptionOrNullimpl != null) {
                Log.e("NeboBaseActivity", "initCloud failed", thM14502exceptionOrNullimpl);
            }
            NeboNetworkStateRepository neboNetworkStateRepository = NeboBaseActivity.this.networkStateRepository;
            if (neboNetworkStateRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepository = null;
            }
            LiveData<NeboNetworkState> neboNetworkState = neboNetworkStateRepository.getNeboNetworkState();
            final NeboBaseActivity neboBaseActivity = NeboBaseActivity.this;
            neboNetworkState.observe(neboBaseActivity, new NeboBaseActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.NeboBaseActivity$onStart$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NeboBaseActivity.C60731.invokeSuspend$lambda$1(neboBaseActivity, (NeboNetworkState) obj2);
                }
            }));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(NeboBaseActivity neboBaseActivity, NeboNetworkState neboNetworkState) {
            if (neboNetworkState != null && neboNetworkState.isDataTransferAllowed() && neboBaseActivity.getCloudManager().isCloudConnected()) {
                neboBaseActivity.bindCloud(neboBaseActivity.getCloudManager().isCloudBound(), neboBaseActivity.getCloudManager().isClientInstantiated());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.appUpdateHandler.onResume();
        getSharePageController().setOnSharePageCanceledOverCellularListener(new SharePageController.OnSharePageCanceledOverCellularListener() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda0
            @Override // com.myscript.nebo.dms.sharepage.SharePageController.OnSharePageCanceledOverCellularListener
            public final void onSharePageCanceledOverCellular() {
                NeboBaseActivity.onResume$lambda$0(this.f$0);
            }
        });
        ExportHelper.resetExportDisplayed();
        handleDebugView();
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.freemium.PurchaseController.Provider");
        ((PurchaseController.Provider) application).providePurchaseController().fetchPreviousPurchasesState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(NeboBaseActivity neboBaseActivity) {
        neboBaseActivity.displayNetworkOperationCanceledOverCellularPopup(C6079R.string.pref_network_popup_cellular_message_from_share_note);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        getSharePageController().setOnSharePageCanceledOverCellularListener(null);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        MainThreadBus.eventBus.unregister(this.busEventListener);
        if (ExportHelper.isExportDisplayed()) {
            ExportHelper.setProbablyGoneExporting(this);
            ExportHelper.resetExportDisplayed();
        }
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        getSsoManager().removeLoginListener(this.loginListener);
        this.intentSenderLauncher = null;
        this.appUpdateHandler.unregisterActivity();
        super.onDestroy();
    }

    protected final void onCloudTokenExpired(boolean expired) {
        if (expired) {
            cloudTokenExpired(getCloudManager().getConnectedProvider());
        }
    }

    private final void cloudTokenExpired(CloudManager.CloudProviderType cloudProviderType) {
        if (CloudManager.CloudProviderType.GDrive == cloudProviderType) {
            revokeDriveAuthorisation();
        } else if (CloudManager.CloudProviderType.Dropbox == cloudProviderType) {
            DropboxLoginHelper.logout();
        }
        if (getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            openCloudTokenInvalidatedDialog(cloudProviderType);
        }
    }

    protected final void findDebugView() {
        if (getResources().getBoolean(C6079R.bool.show_debug_view)) {
            this.dpiDebugView = (TextView) findViewById(C6079R.id.app_debug_dpi);
            this.notebookInfoDebugView = (TextView) findViewById(C6079R.id.app_debug_notebook);
        }
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public void resetUUID(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        getLibraryRepository().resetPageUUID(pageKey);
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public boolean usesFullscreenDialog() {
        return getResources().getBoolean(C6079R.bool.fullscreen_dialog);
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public boolean hasValidUserAccount() {
        return getUserData().hasUser() && getUserData().isAccountActivated();
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public boolean hasCloudUserConsent() {
        return getUserData().isNewPrivacyAccepted();
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public void setCloudUserConsent() {
        getUserData().setNewPrivacyAccepted(true);
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public void signInRequested() {
        ensureNativeSignInOverlay();
        setShowNativeSignInDialog(true);
    }

    private final void ensureNativeSignInOverlay() {
        if (this.nativeSignInOverlayAttached) {
            return;
        }
        this.nativeSignInOverlayAttached = true;
        ComposeView composeView = new ComposeView(this, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1391148243, true, new Function2() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NeboBaseActivity.ensureNativeSignInOverlay$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addContentView(composeView, new ViewGroup.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureNativeSignInOverlay$lambda$0$0(final NeboBaseActivity neboBaseActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C367@15133L40,368@15200L908,368@15190L918:NeboBaseActivity.kt#3ig9qq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1391148243, i, -1, "com.myscript.nebo.NeboBaseActivity.ensureNativeSignInOverlay.<anonymous>.<anonymous> (NeboBaseActivity.kt:365)");
            }
            Application application = neboBaseActivity.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
            final NeboApplication neboApplication = (NeboApplication) application;
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(neboApplication.provideNeboNetworkStateRepository().getNeboNetworkState(), NeboNetworkState.Offline.INSTANCE, composer, 0);
            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(-886938955, true, new Function2() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NeboBaseActivity.ensureNativeSignInOverlay$lambda$0$0$1(this.f$0, neboApplication, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureNativeSignInOverlay$lambda$0$0$1(final NeboBaseActivity neboBaseActivity, NeboApplication neboApplication, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C371@15331L34,380@15928L139,375@15654L229,369@15222L868:NeboBaseActivity.kt#3ig9qq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-886938955, i, -1, "com.myscript.nebo.NeboBaseActivity.ensureNativeSignInOverlay.<anonymous>.<anonymous>.<anonymous> (NeboBaseActivity.kt:369)");
            }
            boolean showNativeSignInDialog = neboBaseActivity.getShowNativeSignInDialog();
            GoogleSignInHelper googleSignInHelper = neboApplication.getGoogleSignInHelper();
            String string = neboBaseActivity.getString(C6278R.string.google_server_client_id);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean z = ensureNativeSignInOverlay$lambda$0$0$0(state) instanceof NeboNetworkState.Connected;
            ComposerKt.sourceInformationMarkerStart(composer, -1944806921, "CC(remember):NeboBaseActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(neboBaseActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NeboBaseActivity.ensureNativeSignInOverlay$lambda$0$0$1$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1944787712, "CC(remember):NeboBaseActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(neboBaseActivity);
            NeboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1 neboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || neboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                neboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1RememberedValue = new NeboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1(neboBaseActivity, null);
                composer.updateRememberedValue(neboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1RememberedValue);
            }
            Function2 function2 = (Function2) neboBaseActivity$ensureNativeSignInOverlay$composeView$1$1$1$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1944796390, "CC(remember):NeboBaseActivity.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(neboBaseActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NeboBaseActivity.ensureNativeSignInOverlay$lambda$0$0$1$2$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NativeSignInDialogKt.NativeSignInDialog(showNativeSignInDialog, function0, googleSignInHelper, string, function2, z, null, (Function0) objRememberedValue2, composer, 0, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureNativeSignInOverlay$lambda$0$0$1$0$0(NeboBaseActivity neboBaseActivity) {
        neboBaseActivity.setShowNativeSignInDialog(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureNativeSignInOverlay$lambda$0$0$1$2$0(NeboBaseActivity neboBaseActivity) {
        neboBaseActivity.signInLoginActivityLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(neboBaseActivity, LoginOrigin.CreateLink.getValue()));
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public SharePageController getSharePageController() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.sharepage.SharePageControllerProvider");
        return ((SharePageControllerProvider) application).provideSharePageController();
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public boolean requestThumbnail(final PageKey requestedPageKey, final SharePageDialog.ThumbnailCallback callback) {
        Intrinsics.checkNotNullParameter(requestedPageKey, "requestedPageKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PageModel page = getLibraryRepository().getPage(requestedPageKey);
        if (page == null || page.isEmpty()) {
            return false;
        }
        getLibraryRepository().addThumbnailListener(new IThumbnailerNotificationListener() { // from class: com.myscript.nebo.NeboBaseActivity$requestThumbnail$thumbnailListener$1
            @Override // com.myscript.snt.core.IThumbnailerNotificationListener
            public void thumbnailCreated(PageKey pageKey, String thumbnailPath, boolean success) {
                Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
                if (Intrinsics.areEqual(requestedPageKey, pageKey)) {
                    this.getLibraryRepository().removeThumbnailListener(this);
                    callback.onThumbnailAvailable(thumbnailPath);
                }
            }
        });
        getLibraryRepository().createThumbnail(requestedPageKey);
        return false;
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public SharePageDialog.ImageLoader getImageLoader() {
        return new SharePageDialog.ImageLoader() { // from class: com.myscript.nebo.NeboBaseActivity.getImageLoader.1
            @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.ImageLoader
            public void loadInto(String imagePath, ImageView imageView, final Runnable completionListener) {
                Intrinsics.checkNotNullParameter(imagePath, "imagePath");
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(completionListener, "completionListener");
                GlideApp.with((FragmentActivity) NeboBaseActivity.this).load(new File(imagePath)).override(imageView.getMeasuredWidth(), imageView.getMeasuredHeight()).addListener(new RequestListener<Drawable>() { // from class: com.myscript.nebo.NeboBaseActivity$getImageLoader$1$loadInto$1
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(target, "target");
                        completionListener.run();
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        Intrinsics.checkNotNullParameter(model, "model");
                        Intrinsics.checkNotNullParameter(target, "target");
                        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                        completionListener.run();
                        return false;
                    }
                }).into(imageView);
            }
        };
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public void onSharedPageSuccessful() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.HelpUsManager.Provider");
        ((HelpUsManager.Provider) application).provideHelpUsManager().increaseUserActionCounter();
    }

    public final void onUserSignOut() {
        driveSignOut();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60751(null), 3, null);
        getLibraryRepository().setPublicAuthorId("");
        if (getResources().getBoolean(C6079R.bool.mandatory_login)) {
            startActivity(new Intent(this, (Class<?>) LaunchActivity.class));
            finish();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$onUserSignOut$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$onUserSignOut$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {476}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {479}, m1615s = {}, m1616v = 2)
    static final class C60751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60751(Continuation<? super C60751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$onUserSignOut$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NeboBaseActivity.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$onUserSignOut$1$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {477}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {478}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ NeboBaseActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NeboBaseActivity neboBaseActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = neboBaseActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.getCloudManager().disconnect(this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(NeboBaseActivity.this, null), this) == coroutine_suspended) {
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

    public final void onUserSignIn(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        getLibraryRepository().setPublicAuthorId(userData.getPublicAuthorId());
        ComponentCallbacks2 application = getApplication();
        if (application instanceof HelpUsManager.Provider) {
            ((HelpUsManager.Provider) application).provideHelpUsManager().userLoggedIn();
        }
        if (application instanceof UserProfileManager.Provider) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60741(((UserProfileManager.Provider) application).provideUserProfileManager(), null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$onUserSignIn$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$onUserSignIn$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {500}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {501}, m1615s = {}, m1616v = 2)
    static final class C60741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserProfileManager $userProfileManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60741(UserProfileManager userProfileManager, Continuation<? super C60741> continuation) {
            super(2, continuation);
            this.$userProfileManager = userProfileManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C60741(this.$userProfileManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$userProfileManager.fetchNeboAccount(this) == coroutine_suspended) {
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

    protected final void displayNetworkOperationCanceledOverCellularPopup(int messageResId) {
        new MaterialAlertDialogBuilder(this).setTitle(C6079R.string.pref_network_popup_cellular_title).setMessage(messageResId).setPositiveButton(C6079R.string.pref_network_popup_cellular_enable, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NeboBaseActivity.displayNetworkOperationCanceledOverCellularPopup$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6079R.string.pref_network_popup_cellular_dismiss, (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayNetworkOperationCanceledOverCellularPopup$lambda$0(NeboBaseActivity neboBaseActivity, DialogInterface dialogInterface, int i) {
        NeboNetworkStateRepository neboNetworkStateRepository = neboBaseActivity.networkStateRepository;
        if (neboNetworkStateRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepository = null;
        }
        neboNetworkStateRepository.setDownloadOverCellularEnabled(true);
    }

    private final void handleDebugView() {
        if (getResources().getBoolean(C6079R.bool.show_debug_view)) {
            NeboBaseActivity neboBaseActivity = this;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(neboBaseActivity);
            boolean z = defaultSharedPreferences.getBoolean(getString(C6079R.string.showDeviceInformationPreferenceKey), false);
            boolean z2 = defaultSharedPreferences.getBoolean(getString(C6079R.string.showDeviceInformationPreferenceKey), false);
            boolean z3 = defaultSharedPreferences.getBoolean(getString(C6079R.string.showNotebookInformationPreferenceKey), false);
            UOCController uOCController = this.uocController;
            if (uOCController != null && uOCController != null) {
                uOCController.display(z);
            }
            if (z2 && this.dpiDebugView != null) {
                DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(neboBaseActivity);
                TextView textView = this.dpiDebugView;
                if (textView != null) {
                    textView.setText(getString(C6079R.string.debug_dpi, new Object[]{Float.valueOf(fixedDisplayMetrics.xdpi), Float.valueOf(fixedDisplayMetrics.ydpi)}));
                }
                TextView textView2 = this.dpiDebugView;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
            if (!z3 || this.notebookInfoDebugView == null) {
                return;
            }
            NotebookKey lastOpenedFolderKey = getLibraryRepository().getLastOpenedFolderKey();
            FolderModel folder = lastOpenedFolderKey != null ? getLibraryRepository().getFolder(lastOpenedFolderKey) : null;
            if (folder != null) {
                String str = ELLIPSIS + folder.getName();
                TextView textView3 = this.notebookInfoDebugView;
                if (textView3 != null) {
                    textView3.setText(str);
                }
                TextView textView4 = this.notebookInfoDebugView;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$driveSignOut$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$driveSignOut$1", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0, 0, 0}, m1611l = {553}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "credentialManager", "$i$a$-runCatching-NeboBaseActivity$driveSignOut$1$1"}, m1614nl = {554}, m1615s = {"L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C60621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C60621(Continuation<? super C60621> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C60621 c60621 = NeboBaseActivity.this.new C60621(continuation);
            c60621.L$0 = obj;
            return c60621;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NeboBaseActivity neboBaseActivity = NeboBaseActivity.this;
                    Result.Companion companion = Result.INSTANCE;
                    CredentialManager credentialManagerCreate = CredentialManager.INSTANCE.create(neboBaseActivity);
                    ClearCredentialStateRequest clearCredentialStateRequest = new ClearCredentialStateRequest(null, 1, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(credentialManagerCreate);
                    this.I$0 = 0;
                    this.label = 1;
                    if (credentialManagerCreate.clearCredentialState(clearCredentialStateRequest, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void driveSignOut() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60621(null), 3, null);
    }

    private final void revokeDriveAuthorisation() {
        String accessToken = DriveLoginHelper.getInstance().getAccessToken();
        if (accessToken == null) {
            return;
        }
        Task<Void> taskClearToken = Identity.getAuthorizationClient((Activity) this).clearToken(ClearTokenRequest.builder().setToken(accessToken).build());
        final Function1 function1 = new Function1() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboBaseActivity.revokeDriveAuthorisation$lambda$0(this.f$0, (Void) obj);
            }
        };
        taskClearToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                NeboBaseActivity.revokeDriveAuthorisation$lambda$2(this.f$0, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revokeDriveAuthorisation$lambda$0(NeboBaseActivity neboBaseActivity, Void r7) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(neboBaseActivity), null, null, new NeboBaseActivity$revokeDriveAuthorisation$1$1(neboBaseActivity, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revokeDriveAuthorisation$lambda$2(NeboBaseActivity neboBaseActivity, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(neboBaseActivity), null, null, new NeboBaseActivity$revokeDriveAuthorisation$2$1(neboBaseActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkForwardCompatibilityIssue() {
        if (getCloudManager().getHasForwardCompatibilityIssue() || !getLibraryRepository().getHasForwardCompatibilityIssue()) {
            return;
        }
        getCloudManager().setHasForwardCompatibilityIssue();
        openForwardCompatibilityIssueDialog();
    }

    protected final void openForwardCompatibilityIssueDialog() {
        ForwardCompatibilityDialogFragment forwardCompatibilityDialogFragmentNewInstance = ForwardCompatibilityDialogFragment.INSTANCE.newInstance();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        DialogFragmentExt.showAtMostOnce(forwardCompatibilityDialogFragmentNewInstance, supportFragmentManager, ForwardCompatibilityDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSSOTokenInvalidated() {
        if (Session.needToDisplaySSOTokenInvalidated && getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            Session.needToDisplaySSOTokenInvalidated = false;
            SSOTokenInvalidatedDialogFragment sSOTokenInvalidatedDialogFragmentNewInstance = SSOTokenInvalidatedDialogFragment.INSTANCE.newInstance(new SSOTokenInvalidatedDialogFragment.Callback() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda5
                @Override // com.myscript.nebo.sso.ui.SSOTokenInvalidatedDialogFragment.Callback
                public final void onLoginRequested() {
                    NeboBaseActivity.checkSSOTokenInvalidated$lambda$0(this.f$0);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            DialogFragmentExt.showAtMostOnce(sSOTokenInvalidatedDialogFragmentNewInstance, supportFragmentManager, SSOTokenInvalidatedDialogFragment.TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSSOTokenInvalidated$lambda$0(NeboBaseActivity neboBaseActivity) {
        neboBaseActivity.startActivity(LoginActivityHelperKt.getLoginActivityIntent$default(neboBaseActivity, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUpdatePrivacyPolicy() {
        if (Session.needToUpdatePrivacyPolicy) {
            Session.needToUpdatePrivacyPolicy = false;
            startActivity(UpdatePrivacyPolicyActivity.INSTANCE.newIntent(this));
        }
    }

    private final void openCloudTokenInvalidatedDialog(CloudManager.CloudProviderType cloudProviderType) {
        if (cloudProviderType == CloudManager.CloudProviderType.Dropbox) {
            Session.needToDisplayDropboxTokenInvalidated = false;
        }
        openCloudDisconnectedDialog(cloudProviderType, true);
    }

    public static /* synthetic */ void openCloudDisconnectedDialog$default(NeboBaseActivity neboBaseActivity, CloudManager.CloudProviderType cloudProviderType, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openCloudDisconnectedDialog");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        neboBaseActivity.openCloudDisconnectedDialog(cloudProviderType, z);
    }

    protected void openCloudDisconnectedDialog(CloudManager.CloudProviderType cloudProviderType, boolean tokenInvalidated) {
        Intrinsics.checkNotNullParameter(cloudProviderType, "cloudProviderType");
        CloudTokenInvalidDialogFragment cloudTokenInvalidDialogFragmentNewInstance = CloudTokenInvalidDialogFragment.INSTANCE.newInstance(cloudProviderType, tokenInvalidated);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        DialogFragmentExt.showAtMostOnce(cloudTokenInvalidDialogFragmentNewInstance, supportFragmentManager, CloudTokenInvalidDialogFragment.TAG);
    }

    private final void handleCloudReconnect(String providerName, boolean tokenInvalidated) {
        if (providerName == null) {
            return;
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[CloudManager.CloudProviderType.valueOf(providerName).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60692(null), 3, null);
            } else if (!tokenInvalidated) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60681(null), 3, null);
            } else {
                dropboxSignIn();
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleCloudReconnect$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$handleCloudReconnect$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {681}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {682}, m1615s = {}, m1616v = 2)
    static final class C60681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60681(Continuation<? super C60681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NeboBaseActivity.this.m12803initCloudIoAF18A(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleCloudReconnect$2 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$handleCloudReconnect$2", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {685}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C60692 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60692(Continuation<? super C60692> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60692(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60692) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NeboBaseActivity.this.m12802driveManualSignInIoAF18A(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleCloudDisconnect$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$handleCloudDisconnect$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {695}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {696}, m1615s = {}, m1616v = 2)
    static final class C60671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60671(Continuation<? super C60671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NeboBaseActivity.this.driveSignOut();
                this.label = 1;
                if (NeboBaseActivity.this.getCloudManager().disconnect(this) == coroutine_suspended) {
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

    private final void handleCloudDisconnect() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60671(null), 3, null);
    }

    private final boolean handleManualDropboxSignIn() {
        if (!this.dropboxConnectionOnGoing) {
            return false;
        }
        this.dropboxConnectionOnGoing = false;
        DbxCredential dbxCredential = Auth.INSTANCE.getDbxCredential();
        if (dbxCredential == null) {
            return true;
        }
        String string = dbxCredential.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        DropboxLoginHelper.logout();
        getUserData().setDropboxCredential(string);
        ISSOManager ssoManager = getSsoManager();
        String appKey = dbxCredential.getAppKey();
        Intrinsics.checkNotNullExpressionValue(appKey, "getAppKey(...)");
        String refreshToken = dbxCredential.getRefreshToken();
        Intrinsics.checkNotNullExpressionValue(refreshToken, "getRefreshToken(...)");
        ISSOManager.saveDropboxCredential$default(ssoManager, appKey, refreshToken, null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60721(null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleManualDropboxSignIn$1 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$handleManualDropboxSignIn$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {714}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {718}, m1615s = {}, m1616v = 2)
    static final class C60721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60721(Continuation<? super C60721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NeboBaseActivity.this.getCloudManager().connect(CloudManager.CloudProviderType.Dropbox, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            NeboNetworkStateRepository neboNetworkStateRepository = NeboBaseActivity.this.networkStateRepository;
            if (neboNetworkStateRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepository = null;
            }
            NeboNetworkState value = neboNetworkStateRepository.getNeboNetworkState().getValue();
            if (value != null && value.isDataTransferAllowed() && NeboBaseActivity.this.getCloudManager().isCloudConnected()) {
                NeboBaseActivity neboBaseActivity = NeboBaseActivity.this;
                neboBaseActivity.bindCloud(neboBaseActivity.getCloudManager().isCloudBound(), NeboBaseActivity.this.getCloudManager().isClientInstantiated());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        if (r7 == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: initCloud-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final Object m12803initCloudIoAF18A(Continuation<? super Result<Unit>> continuation) {
        NeboBaseActivity$initCloud$1 neboBaseActivity$initCloud$1;
        Object objM12799driveSilentSignInIoAF18A;
        Object objM12802driveManualSignInIoAF18A;
        if (continuation instanceof NeboBaseActivity$initCloud$1) {
            neboBaseActivity$initCloud$1 = (NeboBaseActivity$initCloud$1) continuation;
            if ((neboBaseActivity$initCloud$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$initCloud$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$initCloud$1 = new NeboBaseActivity$initCloud$1(this, continuation);
            }
        }
        Object obj = neboBaseActivity$initCloud$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBaseActivity$initCloud$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                if (!handleManualDropboxSignIn()) {
                    if (getCloudManager().isConnectedToGDrive()) {
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                        boolean z = defaultSharedPreferences.getBoolean(NEEDS_NEW_AUTH_CODE_KEY, true);
                        if (z) {
                            neboBaseActivity$initCloud$1.L$0 = SpillingKt.nullOutSpilledVariable(defaultSharedPreferences);
                            neboBaseActivity$initCloud$1.I$0 = 0;
                            neboBaseActivity$initCloud$1.Z$0 = z;
                            neboBaseActivity$initCloud$1.label = 1;
                            objM12802driveManualSignInIoAF18A = m12802driveManualSignInIoAF18A(neboBaseActivity$initCloud$1);
                            if (objM12802driveManualSignInIoAF18A == coroutine_suspended) {
                            }
                            ResultKt.throwOnFailure(objM12802driveManualSignInIoAF18A);
                        } else {
                            neboBaseActivity$initCloud$1.L$0 = SpillingKt.nullOutSpilledVariable(defaultSharedPreferences);
                            neboBaseActivity$initCloud$1.I$0 = 0;
                            neboBaseActivity$initCloud$1.Z$0 = z;
                            neboBaseActivity$initCloud$1.label = 2;
                            objM12799driveSilentSignInIoAF18A = m12799driveSilentSignInIoAF18A(neboBaseActivity$initCloud$1);
                        }
                        return coroutine_suspended;
                    }
                    if (getCloudManager().isConnectedToDropbox()) {
                        NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
                        if (neboNetworkStateRepository == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                            neboNetworkStateRepository = null;
                        }
                        NeboNetworkState value = neboNetworkStateRepository.getNeboNetworkState().getValue();
                        if (value != null && value.isDataTransferAllowed()) {
                            bindCloud(getCloudManager().isCloudBound(), getCloudManager().isClientInstantiated());
                        }
                    }
                }
            } else if (i == 1) {
                boolean z2 = neboBaseActivity$initCloud$1.Z$0;
                int i2 = neboBaseActivity$initCloud$1.I$0;
                ResultKt.throwOnFailure(obj);
                objM12802driveManualSignInIoAF18A = ((Result) obj).getValue();
                ResultKt.throwOnFailure(objM12802driveManualSignInIoAF18A);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = neboBaseActivity$initCloud$1.Z$0;
                int i3 = neboBaseActivity$initCloud$1.I$0;
                ResultKt.throwOnFailure(obj);
                objM12799driveSilentSignInIoAF18A = ((Result) obj).getValue();
                ResultKt.throwOnFailure(objM12799driveSilentSignInIoAF18A);
            }
            return Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindCloud(final boolean wasBound, final boolean clientInitialized) {
        getCloudManager().bindCloud(new CloudManager.BindCloudCallback() { // from class: com.myscript.nebo.NeboBaseActivity.bindCloud.1
            @Override // com.myscript.nebo.cloudsync.CloudManager.BindCloudCallback
            public void onResult(boolean bound, boolean handled) {
                if (handled) {
                    return;
                }
                if ((wasBound || !clientInitialized) && !bound && this.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
                    boolean z = Session.needToDisplayDropboxTokenInvalidated;
                    NeboBaseActivity neboBaseActivity = this;
                    neboBaseActivity.openCloudDisconnectedDialog(neboBaseActivity.getCloudManager().getConnectedProvider(), z);
                }
            }
        });
    }

    public final void dropboxSignIn() {
        this.dropboxConnectionOnGoing = true;
        DropboxLoginHelper.login(this, getString(C6079R.string.dropbox_app_key));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: driveManualSignIn-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12802driveManualSignInIoAF18A(Continuation<? super Result<Unit>> continuation) throws GetCredentialException {
        NeboBaseActivity$driveManualSignIn$1 neboBaseActivity$driveManualSignIn$1;
        CredentialManager credentialManagerCreate;
        GetSignInWithGoogleOption getSignInWithGoogleOption;
        Exception e;
        GetCredentialRequest getCredentialRequest;
        int i;
        GetSignInWithGoogleOption getSignInWithGoogleOption2;
        GetCredentialRequest getCredentialRequest2;
        CredentialManager credentialManager;
        Object objM12801handleGDriveSignIngIAlus;
        if (continuation instanceof NeboBaseActivity$driveManualSignIn$1) {
            neboBaseActivity$driveManualSignIn$1 = (NeboBaseActivity$driveManualSignIn$1) continuation;
            if ((neboBaseActivity$driveManualSignIn$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$driveManualSignIn$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$driveManualSignIn$1 = new NeboBaseActivity$driveManualSignIn$1(this, continuation);
            }
        }
        Object obj = neboBaseActivity$driveManualSignIn$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = neboBaseActivity$driveManualSignIn$1.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.INSTANCE;
                    credentialManagerCreate = CredentialManager.INSTANCE.create(this);
                    String string = getString(C6278R.string.google_server_client_id);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    GetSignInWithGoogleOption getSignInWithGoogleOptionBuild = new GetSignInWithGoogleOption.Builder(string).build();
                    GetCredentialRequest getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(getSignInWithGoogleOptionBuild).build();
                    try {
                        neboBaseActivity$driveManualSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(credentialManagerCreate);
                        neboBaseActivity$driveManualSignIn$1.L$1 = SpillingKt.nullOutSpilledVariable(getCredentialRequestBuild);
                        neboBaseActivity$driveManualSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(getSignInWithGoogleOptionBuild);
                        neboBaseActivity$driveManualSignIn$1.I$0 = 0;
                        neboBaseActivity$driveManualSignIn$1.label = 1;
                        Object credential = credentialManagerCreate.getCredential(this, getCredentialRequestBuild, neboBaseActivity$driveManualSignIn$1);
                        if (credential != coroutine_suspended) {
                            getSignInWithGoogleOption2 = getSignInWithGoogleOptionBuild;
                            obj = credential;
                            getCredentialRequest2 = getCredentialRequestBuild;
                            i = 0;
                            credentialManager = credentialManagerCreate;
                        }
                    } catch (GetCredentialException e2) {
                        getSignInWithGoogleOption = getSignInWithGoogleOptionBuild;
                        e = e2;
                        getCredentialRequest = getCredentialRequestBuild;
                        i = 0;
                        neboBaseActivity$driveManualSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(credentialManagerCreate);
                        neboBaseActivity$driveManualSignIn$1.L$1 = SpillingKt.nullOutSpilledVariable(getCredentialRequest);
                        neboBaseActivity$driveManualSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(getSignInWithGoogleOption);
                        neboBaseActivity$driveManualSignIn$1.L$3 = e;
                        neboBaseActivity$driveManualSignIn$1.I$0 = i;
                        neboBaseActivity$driveManualSignIn$1.label = 3;
                        if (handleGDriveSignInFailure(e, neboBaseActivity$driveManualSignIn$1) != coroutine_suspended) {
                            throw e;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i3 = neboBaseActivity$driveManualSignIn$1.I$0;
                        GetCredentialException getCredentialException = (GetCredentialException) neboBaseActivity$driveManualSignIn$1.L$3;
                        ResultKt.throwOnFailure(obj);
                        throw getCredentialException;
                    }
                    i = neboBaseActivity$driveManualSignIn$1.I$0;
                    getSignInWithGoogleOption = (GetSignInWithGoogleOption) neboBaseActivity$driveManualSignIn$1.L$2;
                    getCredentialRequest = (GetCredentialRequest) neboBaseActivity$driveManualSignIn$1.L$1;
                    credentialManagerCreate = (CredentialManager) neboBaseActivity$driveManualSignIn$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objM12801handleGDriveSignIngIAlus = ((Result) obj).getValue();
                        ResultKt.throwOnFailure(objM12801handleGDriveSignIngIAlus);
                        return Result.m14499constructorimpl(Unit.INSTANCE);
                    } catch (GetCredentialException e3) {
                        e = e3;
                        neboBaseActivity$driveManualSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(credentialManagerCreate);
                        neboBaseActivity$driveManualSignIn$1.L$1 = SpillingKt.nullOutSpilledVariable(getCredentialRequest);
                        neboBaseActivity$driveManualSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(getSignInWithGoogleOption);
                        neboBaseActivity$driveManualSignIn$1.L$3 = e;
                        neboBaseActivity$driveManualSignIn$1.I$0 = i;
                        neboBaseActivity$driveManualSignIn$1.label = 3;
                        if (handleGDriveSignInFailure(e, neboBaseActivity$driveManualSignIn$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                }
                i = neboBaseActivity$driveManualSignIn$1.I$0;
                getSignInWithGoogleOption2 = (GetSignInWithGoogleOption) neboBaseActivity$driveManualSignIn$1.L$2;
                getCredentialRequest2 = (GetCredentialRequest) neboBaseActivity$driveManualSignIn$1.L$1;
                credentialManager = (CredentialManager) neboBaseActivity$driveManualSignIn$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (GetCredentialException e4) {
                    e = e4;
                    getSignInWithGoogleOption = getSignInWithGoogleOption2;
                    getCredentialRequest = getCredentialRequest2;
                    credentialManagerCreate = credentialManager;
                    neboBaseActivity$driveManualSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(credentialManagerCreate);
                    neboBaseActivity$driveManualSignIn$1.L$1 = SpillingKt.nullOutSpilledVariable(getCredentialRequest);
                    neboBaseActivity$driveManualSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(getSignInWithGoogleOption);
                    neboBaseActivity$driveManualSignIn$1.L$3 = e;
                    neboBaseActivity$driveManualSignIn$1.I$0 = i;
                    neboBaseActivity$driveManualSignIn$1.label = 3;
                    if (handleGDriveSignInFailure(e, neboBaseActivity$driveManualSignIn$1) != coroutine_suspended) {
                    }
                }
                GetCredentialResponse getCredentialResponse = (GetCredentialResponse) obj;
                neboBaseActivity$driveManualSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(credentialManager);
                neboBaseActivity$driveManualSignIn$1.L$1 = SpillingKt.nullOutSpilledVariable(getCredentialRequest2);
                neboBaseActivity$driveManualSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(getSignInWithGoogleOption2);
                neboBaseActivity$driveManualSignIn$1.L$3 = SpillingKt.nullOutSpilledVariable(getCredentialResponse);
                neboBaseActivity$driveManualSignIn$1.I$0 = i;
                neboBaseActivity$driveManualSignIn$1.label = 2;
                objM12801handleGDriveSignIngIAlus = m12801handleGDriveSignIngIAlus(getCredentialResponse, neboBaseActivity$driveManualSignIn$1);
                if (objM12801handleGDriveSignIngIAlus != coroutine_suspended) {
                    getSignInWithGoogleOption = getSignInWithGoogleOption2;
                    getCredentialRequest = getCredentialRequest2;
                    credentialManagerCreate = credentialManager;
                    ResultKt.throwOnFailure(objM12801handleGDriveSignIngIAlus);
                    return Result.m14499constructorimpl(Unit.INSTANCE);
                }
                return coroutine_suspended;
            } catch (GetCredentialCancellationException e5) {
                ComponentCallbacks2 application = getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
                ((TechnicalLoggerProvider) application).provideTechnicalLogger().logTrace("User cancelled GDrive sign-in");
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m14499constructorimpl(ResultKt.createFailure(e5));
            }
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: driveSilentSignIn-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12799driveSilentSignInIoAF18A(Continuation<? super Result<Unit>> continuation) {
        NeboBaseActivity$driveSilentSignIn$1 neboBaseActivity$driveSilentSignIn$1;
        if (continuation instanceof NeboBaseActivity$driveSilentSignIn$1) {
            neboBaseActivity$driveSilentSignIn$1 = (NeboBaseActivity$driveSilentSignIn$1) continuation;
            if ((neboBaseActivity$driveSilentSignIn$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$driveSilentSignIn$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$driveSilentSignIn$1 = new NeboBaseActivity$driveSilentSignIn$1(this, continuation);
            }
        }
        Object result = neboBaseActivity$driveSilentSignIn$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBaseActivity$driveSilentSignIn$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            AuthorizationRequest authorizationRequestBuild = AuthorizationRequest.builder().setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/drive.appdata"))).build();
            Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
            neboBaseActivity$driveSilentSignIn$1.L$0 = authorizationRequestBuild;
            neboBaseActivity$driveSilentSignIn$1.I$0 = 0;
            neboBaseActivity$driveSilentSignIn$1.label = 1;
            NeboBaseActivity$driveSilentSignIn$1 neboBaseActivity$driveSilentSignIn$12 = neboBaseActivity$driveSilentSignIn$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(neboBaseActivity$driveSilentSignIn$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Identity.getAuthorizationClient((Activity) this).authorize(authorizationRequestBuild).addOnSuccessListener(new C6078xa16116ae(new Function1<AuthorizationResult, Unit>() { // from class: com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthorizationResult authorizationResult) {
                    invoke2(authorizationResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthorizationResult authorizationResult) {
                    if (authorizationResult.hasResolution()) {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C60631(this.this$0, cancellableContinuationImpl2, null), 3, null);
                    } else {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C60642(this.this$0, authorizationResult, cancellableContinuationImpl2, null), 3, null);
                    }
                }

                /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$1$1 */
                /* JADX INFO: compiled from: NeboBaseActivity.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$1$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {810}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {811}, m1615s = {}, m1616v = 2)
                static final class C60631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;
                    int label;
                    final /* synthetic */ NeboBaseActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C60631(NeboBaseActivity neboBaseActivity, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super C60631> continuation) {
                        super(2, continuation);
                        this.this$0 = neboBaseActivity;
                        this.$continuation = cancellableContinuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C60631(this.this$0, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C60631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws GetCredentialException {
                        Object objM12802driveManualSignInIoAF18A;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            objM12802driveManualSignInIoAF18A = this.this$0.m12802driveManualSignInIoAF18A(this);
                            if (objM12802driveManualSignInIoAF18A == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            objM12802driveManualSignInIoAF18A = ((Result) obj).getValue();
                        }
                        if (this.$continuation.isActive()) {
                            CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m14499constructorimpl(Result.m14498boximpl(objM12802driveManualSignInIoAF18A)));
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$1$2 */
                /* JADX INFO: compiled from: NeboBaseActivity.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$1$2", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {816}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {817}, m1615s = {}, m1616v = 2)
                static final class C60642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ AuthorizationResult $authorizationResult;
                    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;
                    int label;
                    final /* synthetic */ NeboBaseActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C60642(NeboBaseActivity neboBaseActivity, AuthorizationResult authorizationResult, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super C60642> continuation) {
                        super(2, continuation);
                        this.this$0 = neboBaseActivity;
                        this.$authorizationResult = authorizationResult;
                        this.$continuation = cancellableContinuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C60642(this.this$0, this.$authorizationResult, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C60642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object objM12800handleAuthorizationResultgIAlus;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            NeboBaseActivity neboBaseActivity = this.this$0;
                            AuthorizationResult authorizationResult = this.$authorizationResult;
                            Intrinsics.checkNotNull(authorizationResult);
                            this.label = 1;
                            objM12800handleAuthorizationResultgIAlus = neboBaseActivity.m12800handleAuthorizationResultgIAlus(authorizationResult, this);
                            if (objM12800handleAuthorizationResultgIAlus == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            objM12800handleAuthorizationResultgIAlus = ((Result) obj).getValue();
                        }
                        if (this.$continuation.isActive()) {
                            CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m14499constructorimpl(Result.m14498boximpl(objM12800handleAuthorizationResultgIAlus)));
                        }
                        return Unit.INSTANCE;
                    }
                }
            })).addOnFailureListener(new OnFailureListener() { // from class: com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$2

                /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$2$1 */
                /* JADX INFO: compiled from: NeboBaseActivity.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$driveSilentSignIn$2$2$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {823}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {824}, m1615s = {}, m1616v = 2)
                static final class C60651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;

                    /* JADX INFO: renamed from: $e */
                    final /* synthetic */ Exception f1269$e;
                    int label;
                    final /* synthetic */ NeboBaseActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C60651(NeboBaseActivity neboBaseActivity, Exception exc, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super C60651> continuation) {
                        super(2, continuation);
                        this.this$0 = neboBaseActivity;
                        this.f1269$e = exc;
                        this.$continuation = cancellableContinuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C60651(this.this$0, this.f1269$e, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C60651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            NeboBaseActivity neboBaseActivity = this.this$0;
                            Exception exc = this.f1269$e;
                            Intrinsics.checkNotNull(exc);
                            this.label = 1;
                            if (neboBaseActivity.handleGDriveSignInFailure(exc, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        if (this.$continuation.isActive()) {
                            CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            Exception exc2 = this.f1269$e;
                            Intrinsics.checkNotNull(exc2);
                            Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(exc2)));
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C60651(this.this$0, e, cancellableContinuationImpl2, null), 3, null);
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(neboBaseActivity$driveSilentSignIn$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = neboBaseActivity$driveSilentSignIn$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intentSenderLauncher$lambda$0(NeboBaseActivity neboBaseActivity, ActivityResult result) throws ApiException {
        Intrinsics.checkNotNullParameter(result, "result");
        CancellableContinuation<? super Result<Unit>> cancellableContinuation = neboBaseActivity.pendingAuthorizationContinuation;
        neboBaseActivity.pendingAuthorizationContinuation = null;
        if (result.getResultCode() == -1) {
            AuthorizationResult authorizationResultFromIntent = Identity.getAuthorizationClient((Activity) neboBaseActivity).getAuthorizationResultFromIntent(result.getData());
            Intrinsics.checkNotNullExpressionValue(authorizationResultFromIntent, "getAuthorizationResultFromIntent(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(neboBaseActivity), null, null, new NeboBaseActivity$intentSenderLauncher$1$1(neboBaseActivity, authorizationResultFromIntent, cancellableContinuation, null), 3, null);
            return;
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new Exception("Authorization cancelled"))));
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: handleAuthorizationResult-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12800handleAuthorizationResultgIAlus(AuthorizationResult authorizationResult, Continuation<? super Result<Unit>> continuation) {
        NeboBaseActivity$handleAuthorizationResult$1 neboBaseActivity$handleAuthorizationResult$1;
        if (continuation instanceof NeboBaseActivity$handleAuthorizationResult$1) {
            neboBaseActivity$handleAuthorizationResult$1 = (NeboBaseActivity$handleAuthorizationResult$1) continuation;
            if ((neboBaseActivity$handleAuthorizationResult$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$handleAuthorizationResult$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$handleAuthorizationResult$1 = new NeboBaseActivity$handleAuthorizationResult$1(this, continuation);
            }
        }
        Object obj = neboBaseActivity$handleAuthorizationResult$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBaseActivity$handleAuthorizationResult$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                ComponentCallbacks2 application = getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
                final TechnicalLogger technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
                String accessToken = authorizationResult.getAccessToken();
                if (accessToken != null) {
                    DriveLoginHelper.getInstance().setAccessToken(accessToken);
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
                    SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
                    editorEdit.putBoolean(NEEDS_NEW_AUTH_CODE_KEY, false);
                    editorEdit.apply();
                    final android.content.Context applicationContext = getApplicationContext();
                    DriveLoginHelper.getInstance().setTokenProvider(new DriveLoginHelper.TokenProvider() { // from class: com.myscript.nebo.NeboBaseActivity$handleAuthorizationResult$2$1$2
                        @Override // com.myscript.nebo.dms.gdrive.DriveLoginHelper.TokenProvider
                        public String refreshAccessToken() {
                            try {
                                AuthorizationRequest authorizationRequestBuild = AuthorizationRequest.builder().setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/drive.appdata"))).build();
                                Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
                                AuthorizationResult authorizationResult2 = (AuthorizationResult) Tasks.await(Identity.getAuthorizationClient(applicationContext).authorize(authorizationRequestBuild));
                                if (authorizationResult2.hasResolution()) {
                                    technicalLoggerProvideTechnicalLogger.logTrace("GDrive silent token refresh requires user interaction, deferring to fallback");
                                    return null;
                                }
                                String accessToken2 = authorizationResult2.getAccessToken();
                                if (accessToken2 == null) {
                                    return null;
                                }
                                technicalLoggerProvideTechnicalLogger.logTrace("GDrive access token silently refreshed successfully");
                                return accessToken2;
                            } catch (Exception e) {
                                technicalLoggerProvideTechnicalLogger.logTrace("GDrive silent token refresh failed");
                                technicalLoggerProvideTechnicalLogger.logError(e);
                                return null;
                            }
                        }

                        @Override // com.myscript.nebo.dms.gdrive.DriveLoginHelper.TokenProvider
                        public String provideAccessToken() {
                            try {
                                AuthorizationRequest authorizationRequestBuild = AuthorizationRequest.builder().requestOfflineAccess(applicationContext.getString(C6278R.string.google_server_client_id)).setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/drive.appdata"))).build();
                                Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
                                AuthorizationResult authorizationResult2 = (AuthorizationResult) Tasks.await(Identity.getAuthorizationClient(applicationContext).authorize(authorizationRequestBuild));
                                if (authorizationResult2.hasResolution()) {
                                    technicalLoggerProvideTechnicalLogger.logTrace("GDrive full re-authorization requires user interaction, cannot proceed from background");
                                    return null;
                                }
                                String accessToken2 = authorizationResult2.getAccessToken();
                                if (accessToken2 == null) {
                                    return null;
                                }
                                technicalLoggerProvideTechnicalLogger.logTrace("GDrive access token obtained via full re-authorization");
                                return accessToken2;
                            } catch (Exception e) {
                                technicalLoggerProvideTechnicalLogger.logTrace("GDrive full re-authorization failed");
                                technicalLoggerProvideTechnicalLogger.logError(e);
                                return null;
                            }
                        }
                    });
                }
                final String serverAuthCode = authorizationResult.getServerAuthCode();
                if (serverAuthCode != null && serverAuthCode.length() > 0 && !Intrinsics.areEqual(serverAuthCode, getUserData().getGDriveAuthCode())) {
                    getSsoManager().saveGDriveAuthToken(serverAuthCode, new ISSOManager.OnProviderTokenSaved() { // from class: com.myscript.nebo.NeboBaseActivity$$ExternalSyntheticLambda12
                        @Override // com.myscript.nebo.sso.api.ISSOManager.OnProviderTokenSaved
                        public final void onProviderTokenSaved(boolean z) {
                            NeboBaseActivity.handleAuthorizationResult_gIAlu_s$lambda$0$1(this.f$0, serverAuthCode, z);
                        }
                    });
                }
                if (authorizationResult.getAccessToken() != null) {
                    if (getUserData().hasUser()) {
                        CloudManager cloudManager = getCloudManager();
                        CloudManager.CloudProviderType cloudProviderType = CloudManager.CloudProviderType.GDrive;
                        neboBaseActivity$handleAuthorizationResult$1.L$0 = SpillingKt.nullOutSpilledVariable(authorizationResult);
                        neboBaseActivity$handleAuthorizationResult$1.L$1 = SpillingKt.nullOutSpilledVariable(serverAuthCode);
                        neboBaseActivity$handleAuthorizationResult$1.L$2 = SpillingKt.nullOutSpilledVariable(technicalLoggerProvideTechnicalLogger);
                        neboBaseActivity$handleAuthorizationResult$1.I$0 = 0;
                        neboBaseActivity$handleAuthorizationResult$1.label = 1;
                        if (cloudManager.connect(cloudProviderType, neboBaseActivity$handleAuthorizationResult$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Result.m14499constructorimpl(Unit.INSTANCE);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = neboBaseActivity$handleAuthorizationResult$1.I$0;
            ResultKt.throwOnFailure(obj);
            NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
            if (neboNetworkStateRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepository = null;
            }
            NeboNetworkState value = neboNetworkStateRepository.getNeboNetworkState().getValue();
            if (value != null && value.isDataTransferAllowed()) {
                bindCloud(getCloudManager().isCloudBound(), getCloudManager().isClientInstantiated());
            }
            return Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAuthorizationResult_gIAlu_s$lambda$0$1(NeboBaseActivity neboBaseActivity, String str, boolean z) {
        if (z) {
            neboBaseActivity.getUserData().setGDriveAuthCode(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: authorizeGoogleDrive-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12798authorizeGoogleDrivegIAlus(AuthorizationRequest authorizationRequest, Continuation<? super Result<Unit>> continuation) {
        NeboBaseActivity$authorizeGoogleDrive$1 neboBaseActivity$authorizeGoogleDrive$1;
        if (continuation instanceof NeboBaseActivity$authorizeGoogleDrive$1) {
            neboBaseActivity$authorizeGoogleDrive$1 = (NeboBaseActivity$authorizeGoogleDrive$1) continuation;
            if ((neboBaseActivity$authorizeGoogleDrive$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$authorizeGoogleDrive$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$authorizeGoogleDrive$1 = new NeboBaseActivity$authorizeGoogleDrive$1(this, continuation);
            }
        }
        Object result = neboBaseActivity$authorizeGoogleDrive$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBaseActivity$authorizeGoogleDrive$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            neboBaseActivity$authorizeGoogleDrive$1.L$0 = authorizationRequest;
            neboBaseActivity$authorizeGoogleDrive$1.I$0 = 0;
            neboBaseActivity$authorizeGoogleDrive$1.label = 1;
            NeboBaseActivity$authorizeGoogleDrive$1 neboBaseActivity$authorizeGoogleDrive$12 = neboBaseActivity$authorizeGoogleDrive$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(neboBaseActivity$authorizeGoogleDrive$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Identity.getAuthorizationClient((Activity) this).authorize(authorizationRequest).addOnSuccessListener(new C6078xa16116ae(new Function1<AuthorizationResult, Unit>() { // from class: com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthorizationResult authorizationResult) {
                    invoke2(authorizationResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthorizationResult authorizationResult) {
                    if (!authorizationResult.hasResolution()) {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C60591(this, authorizationResult, cancellableContinuationImpl2, null), 3, null);
                        return;
                    }
                    PendingIntent pendingIntent = authorizationResult.getPendingIntent();
                    IntentSender intentSender = pendingIntent != null ? pendingIntent.getIntentSender() : null;
                    if (intentSender == null) {
                        CancellableContinuation<Result<Unit>> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new IllegalStateException("No pending intent sender"))));
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                        return;
                    }
                    IntentSenderRequest intentSenderRequestBuild = new IntentSenderRequest.Builder(intentSender).build();
                    ActivityResultLauncher activityResultLauncher = this.intentSenderLauncher;
                    if (activityResultLauncher != null) {
                        activityResultLauncher.launch(intentSenderRequestBuild);
                    }
                    this.pendingAuthorizationContinuation = cancellableContinuationImpl2;
                }

                /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$1$1 */
                /* JADX INFO: compiled from: NeboBaseActivity.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$1$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {946}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {947}, m1615s = {}, m1616v = 2)
                static final class C60591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ AuthorizationResult $authorizationResult;
                    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;
                    int label;
                    final /* synthetic */ NeboBaseActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C60591(NeboBaseActivity neboBaseActivity, AuthorizationResult authorizationResult, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super C60591> continuation) {
                        super(2, continuation);
                        this.this$0 = neboBaseActivity;
                        this.$authorizationResult = authorizationResult;
                        this.$continuation = cancellableContinuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C60591(this.this$0, this.$authorizationResult, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C60591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object objM12800handleAuthorizationResultgIAlus;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            NeboBaseActivity neboBaseActivity = this.this$0;
                            AuthorizationResult authorizationResult = this.$authorizationResult;
                            Intrinsics.checkNotNull(authorizationResult);
                            this.label = 1;
                            objM12800handleAuthorizationResultgIAlus = neboBaseActivity.m12800handleAuthorizationResultgIAlus(authorizationResult, this);
                            if (objM12800handleAuthorizationResultgIAlus == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            objM12800handleAuthorizationResultgIAlus = ((Result) obj).getValue();
                        }
                        CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m14499constructorimpl(Result.m14498boximpl(objM12800handleAuthorizationResultgIAlus)));
                        return Unit.INSTANCE;
                    }
                }
            })).addOnFailureListener(new OnFailureListener() { // from class: com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$2

                /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$2$1 */
                /* JADX INFO: compiled from: NeboBaseActivity.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$authorizeGoogleDrive$2$2$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {953}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {954}, m1615s = {}, m1616v = 2)
                static final class C60601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;

                    /* JADX INFO: renamed from: $e */
                    final /* synthetic */ Exception f1268$e;
                    int label;
                    final /* synthetic */ NeboBaseActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C60601(NeboBaseActivity neboBaseActivity, Exception exc, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super C60601> continuation) {
                        super(2, continuation);
                        this.this$0 = neboBaseActivity;
                        this.f1268$e = exc;
                        this.$continuation = cancellableContinuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C60601(this.this$0, this.f1268$e, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C60601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            NeboBaseActivity neboBaseActivity = this.this$0;
                            Exception exc = this.f1268$e;
                            Intrinsics.checkNotNull(exc);
                            this.label = 1;
                            if (neboBaseActivity.handleGDriveSignInFailure(exc, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
                        Result.Companion companion = Result.INSTANCE;
                        Exception exc2 = this.f1268$e;
                        Intrinsics.checkNotNull(exc2);
                        Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(exc2)));
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                        return Unit.INSTANCE;
                    }
                }

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C60601(this.this$0, e, cancellableContinuationImpl2, null), 3, null);
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(neboBaseActivity$authorizeGoogleDrive$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = neboBaseActivity$authorizeGoogleDrive$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: handleGDriveSignIn-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12801handleGDriveSignIngIAlus(GetCredentialResponse getCredentialResponse, Continuation<? super Result<Unit>> continuation) {
        NeboBaseActivity$handleGDriveSignIn$1 neboBaseActivity$handleGDriveSignIn$1;
        TechnicalLogger technicalLoggerProvideTechnicalLogger;
        Credential credential;
        GetCredentialResponse getCredentialResponse2;
        GoogleIdTokenParsingException googleIdTokenParsingException;
        Object objM12798authorizeGoogleDrivegIAlus;
        TechnicalLogger technicalLogger;
        if (continuation instanceof NeboBaseActivity$handleGDriveSignIn$1) {
            neboBaseActivity$handleGDriveSignIn$1 = (NeboBaseActivity$handleGDriveSignIn$1) continuation;
            if ((neboBaseActivity$handleGDriveSignIn$1.label & Integer.MIN_VALUE) != 0) {
                neboBaseActivity$handleGDriveSignIn$1.label -= Integer.MIN_VALUE;
            } else {
                neboBaseActivity$handleGDriveSignIn$1 = new NeboBaseActivity$handleGDriveSignIn$1(this, continuation);
            }
        }
        Object obj = neboBaseActivity$handleGDriveSignIn$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBaseActivity$handleGDriveSignIn$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ComponentCallbacks2 application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
            technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
            credential = getCredentialResponse.getCredential();
            if (credential instanceof CustomCredential) {
                if (Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                    try {
                        AuthorizationRequest authorizationRequestBuild = AuthorizationRequest.builder().requestOfflineAccess(getResources().getString(C6278R.string.google_server_client_id)).setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/drive.appdata"))).build();
                        Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
                        neboBaseActivity$handleGDriveSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(getCredentialResponse);
                        neboBaseActivity$handleGDriveSignIn$1.L$1 = technicalLoggerProvideTechnicalLogger;
                        neboBaseActivity$handleGDriveSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(credential);
                        neboBaseActivity$handleGDriveSignIn$1.L$3 = SpillingKt.nullOutSpilledVariable(authorizationRequestBuild);
                        neboBaseActivity$handleGDriveSignIn$1.label = 1;
                        objM12798authorizeGoogleDrivegIAlus = m12798authorizeGoogleDrivegIAlus(authorizationRequestBuild, neboBaseActivity$handleGDriveSignIn$1);
                    } catch (GoogleIdTokenParsingException e) {
                        getCredentialResponse2 = getCredentialResponse;
                        googleIdTokenParsingException = e;
                        neboBaseActivity$handleGDriveSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(getCredentialResponse2);
                        neboBaseActivity$handleGDriveSignIn$1.L$1 = technicalLoggerProvideTechnicalLogger;
                        neboBaseActivity$handleGDriveSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(credential);
                        neboBaseActivity$handleGDriveSignIn$1.L$3 = googleIdTokenParsingException;
                        neboBaseActivity$handleGDriveSignIn$1.label = 2;
                        if (handleGDriveSignInFailure(googleIdTokenParsingException, neboBaseActivity$handleGDriveSignIn$1) != coroutine_suspended) {
                        }
                    }
                    return objM12798authorizeGoogleDrivegIAlus == coroutine_suspended ? coroutine_suspended : objM12798authorizeGoogleDrivegIAlus;
                }
                technicalLoggerProvideTechnicalLogger.setKeyValue("gdrive_UnexpectedTypeOfCustomCredential", credential.getType());
                Result.Companion companion = Result.INSTANCE;
                return Result.m14499constructorimpl(ResultKt.createFailure(new IllegalStateException("Unexpected type of custom credential: " + credential.getType())));
            }
            technicalLoggerProvideTechnicalLogger.setKeyValue("gdrive_UnexpectedTypeOfCredential", credential.getClass().getSimpleName());
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(new IllegalStateException("Unexpected type of credential: " + credential.getClass().getSimpleName())));
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            googleIdTokenParsingException = (GoogleIdTokenParsingException) neboBaseActivity$handleGDriveSignIn$1.L$3;
            technicalLogger = (TechnicalLogger) neboBaseActivity$handleGDriveSignIn$1.L$1;
            ResultKt.throwOnFailure(obj);
            technicalLogger.setKeyValue("gdrive_GoogleIdTokenParsingException_message", googleIdTokenParsingException.getMessage());
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(googleIdTokenParsingException));
        }
        Credential credential2 = (Credential) neboBaseActivity$handleGDriveSignIn$1.L$2;
        TechnicalLogger technicalLogger2 = (TechnicalLogger) neboBaseActivity$handleGDriveSignIn$1.L$1;
        getCredentialResponse2 = (GetCredentialResponse) neboBaseActivity$handleGDriveSignIn$1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        } catch (GoogleIdTokenParsingException e2) {
            credential = credential2;
            googleIdTokenParsingException = e2;
            technicalLoggerProvideTechnicalLogger = technicalLogger2;
        }
        neboBaseActivity$handleGDriveSignIn$1.L$0 = SpillingKt.nullOutSpilledVariable(getCredentialResponse2);
        neboBaseActivity$handleGDriveSignIn$1.L$1 = technicalLoggerProvideTechnicalLogger;
        neboBaseActivity$handleGDriveSignIn$1.L$2 = SpillingKt.nullOutSpilledVariable(credential);
        neboBaseActivity$handleGDriveSignIn$1.L$3 = googleIdTokenParsingException;
        neboBaseActivity$handleGDriveSignIn$1.label = 2;
        if (handleGDriveSignInFailure(googleIdTokenParsingException, neboBaseActivity$handleGDriveSignIn$1) != coroutine_suspended) {
            technicalLogger = technicalLoggerProvideTechnicalLogger;
            technicalLogger.setKeyValue("gdrive_GoogleIdTokenParsingException_message", googleIdTokenParsingException.getMessage());
            Result.Companion companion32 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(googleIdTokenParsingException));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c1, code lost:
    
        if (r2.clearCredentialState(r6, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleGDriveSignInFailure(Exception exc, Continuation<? super Unit> continuation) throws Throwable {
        C60701 c60701;
        Object objM14499constructorimpl;
        TechnicalLogger technicalLoggerProvideTechnicalLogger;
        if (continuation instanceof C60701) {
            c60701 = (C60701) continuation;
            if ((c60701.label & Integer.MIN_VALUE) != 0) {
                c60701.label -= Integer.MIN_VALUE;
            } else {
                c60701 = new C60701(continuation);
            }
        }
        Object obj = c60701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60701.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ComponentCallbacks2 application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
            technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
            technicalLoggerProvideTechnicalLogger.setKeyValue("gdrive_SignInException_message", exc.getMessage());
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C60712 c60712 = new C60712(null);
            c60701.L$0 = SpillingKt.nullOutSpilledVariable(exc);
            c60701.L$1 = SpillingKt.nullOutSpilledVariable(technicalLoggerProvideTechnicalLogger);
            c60701.label = 1;
            if (BuildersKt.withContext(io2, c60712, c60701) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c60701.I$0;
            ResultKt.throwOnFailure(obj);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl == null || !(thM14502exceptionOrNullimpl instanceof CancellationException)) {
                return Unit.INSTANCE;
            }
            throw thM14502exceptionOrNullimpl;
        }
        TechnicalLogger technicalLogger = (TechnicalLogger) c60701.L$1;
        Exception exc2 = (Exception) c60701.L$0;
        ResultKt.throwOnFailure(obj);
        technicalLoggerProvideTechnicalLogger = technicalLogger;
        exc = exc2;
        Result.Companion companion2 = Result.INSTANCE;
        NeboBaseActivity neboBaseActivity = this;
        CredentialManager credentialManagerCreate = CredentialManager.INSTANCE.create(this);
        ClearCredentialStateRequest clearCredentialStateRequest = new ClearCredentialStateRequest(null, 1, null);
        c60701.L$0 = SpillingKt.nullOutSpilledVariable(exc);
        c60701.L$1 = SpillingKt.nullOutSpilledVariable(technicalLoggerProvideTechnicalLogger);
        c60701.L$2 = SpillingKt.nullOutSpilledVariable(this);
        c60701.I$0 = 0;
        c60701.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$handleGDriveSignInFailure$2 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$handleGDriveSignInFailure$2", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {991}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {992}, m1615s = {}, m1616v = 2)
    static final class C60712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60712(Continuation<? super C60712> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBaseActivity.this.new C60712(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NeboBaseActivity.this.getCloudManager().disconnect(this) == coroutine_suspended) {
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

    private static final NeboNetworkState ensureNativeSignInOverlay$lambda$0$0$0(State<? extends NeboNetworkState> state) {
        return state.getValue();
    }
}
