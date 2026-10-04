package com.myscript.nebo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.credentials.CredentialManager;
import androidx.credentials.provider.CredentialEntry;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.preference.PreferenceManager;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.common.p018io.BaseEncoding;
import com.myscript.android.utils.SignatureUtilsKt;
import com.myscript.atk.core.Context;
import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.CustomResourceType;
import com.myscript.atk.core.EngineError;
import com.myscript.atk.core.p020ui.utils.TypefaceUtils;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.atk.resourcemanager.ResourceManagerImpl;
import com.myscript.atk.text.UserDictionary;
import com.myscript.atk.text.UserDictionaryConfiguration;
import com.myscript.certificate.MyCertificate;
import com.myscript.nebo.UserSessionManager;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.account.backend.MailServices;
import com.myscript.nebo.account.backend.MailServicesProvider;
import com.myscript.nebo.account.backend.NeboBackend;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.AnalyticsProperty;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.analytics.firebase.NeboFirebaseProperty;
import com.myscript.nebo.analytics.remoteconfig.RemoteConfig;
import com.myscript.nebo.analytics.remoteconfig.RemoteConfigController;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.CloudManagerImpl;
import com.myscript.nebo.common.ColorPolicyRepository;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.common.IClock;
import com.myscript.nebo.common.IMyScriptEngineContextProvider;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.crash.CrashHandler;
import com.myscript.nebo.datacollect.NeboDataCollectDateStore;
import com.myscript.nebo.datacollect.NeboDataCollectWorker;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.DiscoveryRepository;
import com.myscript.nebo.discoverability.FeatureUsageMetrics;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.discoverability.session.SessionManager;
import com.myscript.nebo.dms.core.AutoSyncTimerManager;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.SyncHelper;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeatureKt;
import com.myscript.nebo.dms.sharepage.SharePageController;
import com.myscript.nebo.dms.sharepage.SharePageControllerProvider;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactoryProvider;
import com.myscript.nebo.events.OnUpdatePrivacyPolicyNeededEvent;
import com.myscript.nebo.featureflags.RuntimeFeatureFlagHelper;
import com.myscript.nebo.freemium.FreemiumBusinessModelStatus;
import com.myscript.nebo.freemium.InAppPurchaseController;
import com.myscript.nebo.freemium.NeboPromotionController;
import com.myscript.nebo.freemium.PromotionController;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.freemium.storage.LegacyPaidStorage;
import com.myscript.nebo.freemium.storage.PurchaseSecuredStorage;
import com.myscript.nebo.freemium.storage.SecuredLegacyPaidStorage;
import com.myscript.nebo.grid.discoverability.TooltipUIStateKt;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.log.FirebaseAnalyticsLogger;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.migration.ILenovoMigrationController;
import com.myscript.nebo.migration.InstallReferralRepository;
import com.myscript.nebo.migration.LenovoMigrationController;
import com.myscript.nebo.network.DozeIdleNotifications;
import com.myscript.nebo.network.NeboNetworkStateRepositoryImpl;
import com.myscript.nebo.network.PlatformNetworkProviderInternal;
import com.myscript.nebo.p022ai.data.NeboAIClient;
import com.myscript.nebo.p023di.LibraryModule;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.InkSettings;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import com.myscript.nebo.purchase.RevenueCatPurchaseProvider;
import com.myscript.nebo.purchase.SubscriptionRepository;
import com.myscript.nebo.rating.PreRatingFilter;
import com.myscript.nebo.remoteconfig.RemoteConfigFeatureFlagProvider;
import com.myscript.nebo.sso.HelpUsManager;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.api.SSOConfiguration;
import com.myscript.nebo.sso.api.SSOHttpClientKt;
import com.myscript.nebo.sso.api.SSOManager;
import com.myscript.nebo.sso.api.auth.SSOAuthApi;
import com.myscript.nebo.sso.api.auth.SSOAuthApiKt;
import com.myscript.nebo.sso.api.discovery.DiscoveryApi;
import com.myscript.nebo.sso.api.discovery.DiscoveryApiKt;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.util.SSOCustomHeaderKt;
import com.myscript.nebo.survicate.SurvicateController;
import com.myscript.nebo.userdict.IUserDictionaryProvider;
import com.myscript.nebo.utils.EarlyAccessFeaturesProvider;
import com.myscript.nebo.utils.InstrumentedFeatureFlagProvider;
import com.myscript.nebo.utils.Session;
import com.myscript.nebo.utils.SharedPreferencesSaver;
import com.myscript.nebo.videotutorial.IMediaPlayerConfigurer;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.CrossSellFilter;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.shared.datacollect.DataCollect;
import com.myscript.snt.core.NeboEngine;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMS;
import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFNet;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.pdftron.pdfnet.C6969R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: NeboApplication.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000À\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 ê\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u00152\u00020\u00162\u00020\u00172\u00020\u00182\u00020\u00192\u00020\u001a2\u00020\u001b2\u00020\u001c2\u00020\u001d2\u00020\u001e2\u00020\u001f2\u00020 2\u00020!2\u00020\"2\u00020#2\u00020$2\u00020%2\u00020&2\u00020'2\u00020(2\u00020):\u0002ê\u0001B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010.\u001a\u00020-H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00104\u001a\u000203H\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010=\u001a\u00020<H\u0016J\b\u0010E\u001a\u00020DH\u0016J\b\u0010H\u001a\u00020GH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010O\u001a\u00020NH\u0016J\b\u0010R\u001a\u00020QH\u0016J\b\u0010U\u001a\u00020VH\u0016J\b\u0010Y\u001a\u00020XH\u0016J\b\u0010\\\u001a\u00020[H\u0016J\b\u0010_\u001a\u00020^H\u0016J\b\u0010b\u001a\u00020aH\u0016J\b\u0010e\u001a\u00020fH\u0016J\b\u0010i\u001a\u00020hH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010o\u001a\u00020nH\u0016J\b\u0010r\u001a\u00020qH\u0016J\b\u0010u\u001a\u00020tH\u0016J\b\u0010x\u001a\u00020wH\u0016J\b\u0010{\u001a\u00020zH\u0016J\b\u0010~\u001a\u00020}H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010¼\u0001\u001a\n\u0012\u0005\u0012\u00030»\u00010¶\u0001H\u0016J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030Â\u0001H\u0016J\u0014\u0010Ã\u0001\u001a\u00030Â\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0016J\u0014\u0010Æ\u0001\u001a\u00030Â\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0016J\n\u0010Ç\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010È\u0001\u001a\u00030Â\u0001H\u0016J\u0014\u0010É\u0001\u001a\u00030Ê\u00012\b\u0010Ë\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010Ò\u0001\u001a\u00030Ó\u0001H\u0016J\n\u0010Þ\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010à\u0001\u001a\u00030¡\u0001H\u0016J\n\u0010á\u0001\u001a\u00030¦\u0001H\u0016J\u001a\u0010â\u0001\u001a\u0013\u0012\u0005\u0012\u00030ä\u0001\u0012\u0007\u0012\u0005\u0018\u00010å\u00010ã\u0001H\u0016J\u0016\u0010æ\u0001\u001a\u0005\u0018\u00010å\u00012\b\u0010ç\u0001\u001a\u00030ä\u0001H\u0002J\n\u0010è\u0001\u001a\u00030«\u0001H\u0016J\n\u0010é\u0001\u001a\u00030«\u0001H\u0016R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020zX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020}X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u007f\u001a\u00030\u0080\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082.¢\u0006\u0002\n\u0000R-\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001*\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R-\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001*\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0094\u0001\u001a\u0006\b\u0096\u0001\u0010\u0092\u0001R-\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001*\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u0094\u0001\u001a\u0006\b\u0099\u0001\u0010\u0092\u0001R!\u0010\u009b\u0001\u001a\u00030\u0089\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R!\u0010 \u0001\u001a\u00030¡\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¤\u0001\u0010\u009f\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R!\u0010¥\u0001\u001a\u00030¦\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b©\u0001\u0010\u009f\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010ª\u0001\u001a\u00030«\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b®\u0001\u0010\u009f\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010¯\u0001\u001a\u00030«\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b±\u0001\u0010\u009f\u0001\u001a\u0006\b°\u0001\u0010\u00ad\u0001R\u0017\u0010²\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010¶\u00018F¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u0017\u0010¹\u0001\u001a\n\u0012\u0005\u0012\u00030»\u00010º\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Î\u0001\u001a\u00030Ï\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001a\u0010Ô\u0001\u001a\u0005\u0018\u00010»\u00018UX\u0094\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0018\u0010×\u0001\u001a\u00030Ø\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0018\u0010Û\u0001\u001a\u00030Ê\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u0018\u0010Ý\u0001\u001a\u00030Ê\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Ü\u0001¨\u0006ë\u0001"}, m1599d2 = {"Lcom/myscript/nebo/NeboApplication;", "Landroid/app/Application;", "Lcom/myscript/nebo/common/IMyScriptEngineContextProvider;", "Lcom/myscript/atk/resourcemanager/ResourceManager$Provider;", "Lcom/myscript/nebo/dms/core/LibraryRepository$Provider;", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager$Provider;", "Lcom/myscript/nebo/UserSessionManager$Provider;", "Lcom/myscript/nebo/whatsnew/IApplicationStateProvider;", "Lcom/myscript/nebo/dms/sharepage/SharePageControllerProvider;", "Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer$Provider;", "Lcom/myscript/nebo/userdict/IUserDictionaryProvider;", "Lcom/myscript/nebo/editing/impl/ui/prediction/MotionPredictionParamsFactoryProvider;", "Lcom/myscript/nebo/common/IClock;", "Lcom/myscript/nebo/sso/HelpUsManager$Provider;", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepositoryProvider;", "Lcom/myscript/nebo/log/TechnicalLoggerProvider;", "Lcom/myscript/nebo/common/ColorPolicyRepositoryProvider;", "Lcom/myscript/nebo/rating/PreRatingFilter$Provider;", "Lcom/myscript/nebo/whatsnew/CrossSellFilter$Provider;", "Lcom/myscript/nebo/cloudsync/CloudManager$Provider;", "Lcom/myscript/nebo/sso/model/UserData$Provider;", "Lcom/myscript/nebo/sso/api/ISSOManager$Provider;", "Lcom/myscript/nebo/languagemanager/util/ISuggestedLanguagesProvider;", "Lcom/myscript/nebo/account/UserProfileManager$Provider;", "Lcom/myscript/nebo/freemium/PurchaseController$Provider;", "Lcom/myscript/nebo/freemium/PromotionController$Provider;", "Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage$Provider;", "Lcom/myscript/nebo/account/backend/Backend$Provider;", "Lcom/myscript/nebo/ai/data/NeboAIClient$Provider;", "Lcom/myscript/nebo/purchase/ISubscriptionRepository$Provider;", "Lcom/myscript/nebo/discoverability/DiscoveryRepository$Provider;", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager$Provider;", "Lcom/myscript/nebo/discoverability/session/SessionManager$Provider;", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState$Provider;", "Lcom/myscript/nebo/freemium/FreemiumBusinessModelStatus;", "Lcom/myscript/nebo/account/backend/MailServicesProvider;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/myscript/shared/datacollect/DataCollect$Provider;", "Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore$Provider;", "Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig$Provider;", "Lcom/myscript/nebo/migration/IInstallReferralRepository$Provider;", "Lcom/myscript/nebo/migration/ILenovoMigrationController$Provider;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "provideTechnicalLogger", "sessionManager", "Lcom/myscript/nebo/UserSessionManager;", "provideUserSessionManager", "applicationState", "Lcom/myscript/nebo/whatsnew/ApplicationState;", "provideApplicationState", "engineContext", "Lcom/myscript/atk/core/Context;", "getEngineContext", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "provideUserData", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "provideSSOManager", "value", "Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper;", "googleSignInHelper", "getGoogleSignInHelper", "()Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper;", "preRatingFilter", "Lcom/myscript/nebo/rating/PreRatingFilter;", "providePreRatingFilter", "crossSellFilter", "Lcom/myscript/nebo/whatsnew/CrossSellFilter;", "provideCrossSellFilter", "legacyPaidStorage", "Lcom/myscript/nebo/freemium/storage/SecuredLegacyPaidStorage;", "provideLegacyPaidStorage", "Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;", "purchaseController", "Lcom/myscript/nebo/freemium/PurchaseController;", "providePurchaseController", "promotionController", "Lcom/myscript/nebo/freemium/PromotionController;", "providePromotionController", "remoteConfig", "Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfigController;", "provideRemoteConfig", "Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "provideUserProfileManager", "resourceManager", "Lcom/myscript/atk/resourcemanager/ResourceManager;", "provideResourceManager", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "provideLibraryRepository", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "provideAutoSyncTimerManager", "networkStateRepository", "Lcom/myscript/nebo/network/NeboNetworkStateRepositoryImpl;", "provideNeboNetworkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "provideCloudManager", "sharePageController", "Lcom/myscript/nebo/dms/sharepage/SharePageController;", "provideSharePageController", "helpUsManager", "Lcom/myscript/nebo/sso/HelpUsManager;", "provideHelpUsManager", "userDictionary", "Lcom/myscript/atk/text/UserDictionary;", "provideUserDictionary", "colorPolicyRepository", "Lcom/myscript/nebo/common/ColorPolicyRepository;", "provideColorPolicyRepository", "neboBackend", "Lcom/myscript/nebo/account/backend/Backend;", "provideBackend", "mailServices", "Lcom/myscript/nebo/account/backend/MailServices;", "provideMailServices", "aiClient", "Lcom/myscript/nebo/ai/data/NeboAIClient;", "provideNeboAIClient", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "provideSubscriptionRepository", "installReferralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "provideInstallReferralRepository", "lenovoMigrationController", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "provideLenovoMigrationController", "provideDataCollectDateStore", "Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore;", "neboDataCollect", "Lcom/myscript/shared/datacollect/DataCollect;", "provideDataCollect", "discoverabilityDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDiscoverabilityDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "discoverabilityDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "featureMetricsDatastore", "getFeatureMetricsDatastore", "featureMetricsDatastore$delegate", "dataCollectDataStore", "getDataCollectDataStore", "dataCollectDataStore$delegate", "neboDataCollectDateStore", "getNeboDataCollectDateStore", "()Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore;", "neboDataCollectDateStore$delegate", "Lkotlin/Lazy;", "discoveryRepository", "Lcom/myscript/nebo/discoverability/DiscoveryRepository;", "getDiscoveryRepository", "()Lcom/myscript/nebo/discoverability/DiscoveryRepository;", "discoveryRepository$delegate", "discoverabilitySessionManager", "Lcom/myscript/nebo/discoverability/session/SessionManager;", "getDiscoverabilitySessionManager", "()Lcom/myscript/nebo/discoverability/session/SessionManager;", "discoverabilitySessionManager$delegate", "gridDiscoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "getGridDiscoverabilityManager", "()Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "gridDiscoverabilityManager$delegate", "editingDiscoverabilityManager", "getEditingDiscoverabilityManager", "editingDiscoverabilityManager$delegate", "_customResources", "", "Lcom/myscript/atk/core/CustomResource;", "customResources", "", "getCustomResources", "()Ljava/util/List;", "suggestedLanguageKeys", "", "", "provideSuggestedLanguages", "provideMotionPredictionParamsFactory", "Lcom/myscript/nebo/editing/impl/ui/prediction/MotionPredictionParamsFactory;", "deviceIdleReceiver", "Landroid/content/BroadcastReceiver;", "onCreate", "", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "deleteOldFonts", "onTerminate", "isMainProcess", "", WebViewMessageType.CONTEXT, "enableStrictMode", "checkSSOAccount", "mediaPlayerConfigurer", "Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;", "getMediaPlayerConfigurer", "()Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;", "getDMSUserDir", "Ljava/io/File;", "storedVersion", "getStoredVersion", "()Ljava/lang/String;", "time", "", "getTime", "()J", "isDnDActivated", "()Z", "isFreemiumBusinessModelEnabled", "enqueueDataCollectWork", "cancelDataCollectWork", "provideDiscoveryRepository", "provideDiscoverySessionManager", "provideFeatureToTooltipState", "Lkotlin/Function1;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "featureToTooltipState", "feature", "provideGridDiscoverabilityManager", "provideEditingDiscoverabilityManager", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class NeboApplication extends Application implements IMyScriptEngineContextProvider, ResourceManager.Provider, LibraryRepository.Provider, IAutoSyncTimerManager.Provider, UserSessionManager.Provider, IApplicationStateProvider, SharePageControllerProvider, IMediaPlayerConfigurer.Provider, IUserDictionaryProvider, MotionPredictionParamsFactoryProvider, IClock, HelpUsManager.Provider, NeboNetworkStateRepositoryProvider, TechnicalLoggerProvider, ColorPolicyRepositoryProvider, PreRatingFilter.Provider, CrossSellFilter.Provider, CloudManager.Provider, UserData.Provider, ISSOManager.Provider, ISuggestedLanguagesProvider, UserProfileManager.Provider, PurchaseController.Provider, PromotionController.Provider, LegacyPaidStorage.Provider, Backend.Provider, NeboAIClient.Provider, ISubscriptionRepository.Provider, DiscoveryRepository.Provider, DiscoverabilityManager.Provider, SessionManager.Provider, TooltipUIState.Provider, FreemiumBusinessModelStatus, MailServicesProvider, DefaultLifecycleObserver, DataCollect.Provider, NeboDataCollectDateStore.Provider, RemoteConfig.Provider, IInstallReferralRepository.Provider, ILenovoMigrationController.Provider {
    private static final int CURRENT_FONT_VERSION = 1;
    private static final String DISCOVERABILITY_PREFERENCES_NAME = "DISCOVERABILITY_PREFERENCES_NAME";
    private static final String FEATURE_METRICS_PREFERENCES_NAME = "FEATURE_METRICS_PREFERENCES_NAME";
    private static final String FONTS_DIR = "fonts";
    private static final String FONT_VERSION_KEY = "FONT_VERSION_KEY";
    private static final int JAVA_CRASH = -1;
    private static NeboApplication Self = null;
    public static final String TAG = "NeboApplication";
    public static final String USER_DIRECTORY_NAME = "user_dir";
    private static boolean successfulInit;
    private static boolean wasRestartedFromCrash;
    private NeboAIClient aiClient;
    private ApplicationState applicationState;
    private IAutoSyncTimerManager autoSyncTimerManager;
    private CloudManager cloudManager;
    private ColorPolicyRepository colorPolicyRepository;
    private CrossSellFilter crossSellFilter;
    private BroadcastReceiver deviceIdleReceiver;
    private Context engineContext;
    private GoogleSignInHelper googleSignInHelper;
    private HelpUsManager helpUsManager;
    private IInstallReferralRepository installReferralRepository;
    private SecuredLegacyPaidStorage legacyPaidStorage;
    private ILenovoMigrationController lenovoMigrationController;
    private LibraryRepository libraryRepository;
    private TechnicalLogger logger;
    private MailServices mailServices;
    private Backend neboBackend;
    private DataCollect neboDataCollect;
    private NeboNetworkStateRepositoryImpl networkStateRepository;
    private PreRatingFilter preRatingFilter;
    private PromotionController promotionController;
    private PurchaseController purchaseController;
    private RemoteConfigController remoteConfig;
    private ResourceManager resourceManager;
    private UserSessionManager sessionManager;
    private SharePageController sharePageController;
    private ISSOManager ssoManager;
    private ISubscriptionRepository subscriptionRepository;
    private UserData userData;
    private UserDictionary userDictionary;
    private UserProfileManager userProfileManager;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference2Impl(NeboApplication.class, "discoverabilityDataStore", "getDiscoverabilityDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0), new PropertyReference2Impl(NeboApplication.class, "featureMetricsDatastore", "getFeatureMetricsDatastore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0), new PropertyReference2Impl(NeboApplication.class, "dataCollectDataStore", "getDataCollectDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: discoverabilityDataStore$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty discoverabilityDataStore = PreferenceDataStoreDelegateKt.preferencesDataStore$default(DISCOVERABILITY_PREFERENCES_NAME, null, null, null, 14, null);

    /* JADX INFO: renamed from: featureMetricsDatastore$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty featureMetricsDatastore = PreferenceDataStoreDelegateKt.preferencesDataStore$default(FEATURE_METRICS_PREFERENCES_NAME, null, null, null, 14, null);

    /* JADX INFO: renamed from: dataCollectDataStore$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty dataCollectDataStore = PreferenceDataStoreDelegateKt.preferencesDataStore$default("data_collect", null, null, null, 14, null);

    /* JADX INFO: renamed from: neboDataCollectDateStore$delegate, reason: from kotlin metadata */
    private final Lazy neboDataCollectDateStore = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NeboApplication.neboDataCollectDateStore_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: discoveryRepository$delegate, reason: from kotlin metadata */
    private final Lazy discoveryRepository = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NeboApplication.discoveryRepository_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: discoverabilitySessionManager$delegate, reason: from kotlin metadata */
    private final Lazy discoverabilitySessionManager = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NeboApplication.discoverabilitySessionManager_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: gridDiscoverabilityManager$delegate, reason: from kotlin metadata */
    private final Lazy gridDiscoverabilityManager = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NeboApplication.gridDiscoverabilityManager_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: editingDiscoverabilityManager$delegate, reason: from kotlin metadata */
    private final Lazy editingDiscoverabilityManager = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NeboApplication.editingDiscoverabilityManager_delegate$lambda$0(this.f$0);
        }
    });
    private final List<CustomResource> _customResources = new ArrayList();
    private final Set<String> suggestedLanguageKeys = new LinkedHashSet();

    static {
        System.setProperty("IINK_PREVENT_NATIVE_LIBS_LOADING", CredentialEntry.TRUE_STRING);
        System.loadLibrary("c++_shared");
        System.loadLibrary("Nebo");
    }

    @JvmStatic
    public static final void handleDetectedCrash(int i) {
        INSTANCE.handleDetectedCrash(i);
    }

    @JvmStatic
    public static final boolean wasRestartedFromCrash() {
        return INSTANCE.wasRestartedFromCrash();
    }

    public boolean isDnDActivated() {
        return true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // com.myscript.nebo.log.TechnicalLoggerProvider
    public TechnicalLogger provideTechnicalLogger() {
        TechnicalLogger technicalLogger = this.logger;
        if (technicalLogger != null) {
            return technicalLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    @Override // com.myscript.nebo.UserSessionManager.Provider
    public UserSessionManager provideUserSessionManager() {
        UserSessionManager userSessionManager = this.sessionManager;
        if (userSessionManager != null) {
            return userSessionManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        return null;
    }

    @Override // com.myscript.nebo.whatsnew.IApplicationStateProvider
    public ApplicationState provideApplicationState() {
        ApplicationState applicationState = this.applicationState;
        if (applicationState != null) {
            return applicationState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationState");
        return null;
    }

    @Override // com.myscript.nebo.common.IMyScriptEngineContextProvider
    public Context getEngineContext() {
        return this.engineContext;
    }

    @Override // com.myscript.nebo.sso.model.UserData.Provider
    public UserData provideUserData() {
        UserData userData = this.userData;
        if (userData != null) {
            return userData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userData");
        return null;
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager.Provider
    public ISSOManager provideSSOManager() {
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager != null) {
            return iSSOManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
        return null;
    }

    public final GoogleSignInHelper getGoogleSignInHelper() {
        GoogleSignInHelper googleSignInHelper = this.googleSignInHelper;
        if (googleSignInHelper != null) {
            return googleSignInHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("googleSignInHelper");
        return null;
    }

    @Override // com.myscript.nebo.rating.PreRatingFilter.Provider
    public PreRatingFilter providePreRatingFilter() {
        PreRatingFilter preRatingFilter = this.preRatingFilter;
        if (preRatingFilter != null) {
            return preRatingFilter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preRatingFilter");
        return null;
    }

    @Override // com.myscript.nebo.whatsnew.CrossSellFilter.Provider
    public CrossSellFilter provideCrossSellFilter() {
        CrossSellFilter crossSellFilter = this.crossSellFilter;
        if (crossSellFilter != null) {
            return crossSellFilter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("crossSellFilter");
        return null;
    }

    @Override // com.myscript.nebo.freemium.storage.LegacyPaidStorage.Provider
    public LegacyPaidStorage provideLegacyPaidStorage() {
        SecuredLegacyPaidStorage securedLegacyPaidStorage = this.legacyPaidStorage;
        if (securedLegacyPaidStorage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyPaidStorage");
            securedLegacyPaidStorage = null;
        }
        return securedLegacyPaidStorage;
    }

    @Override // com.myscript.nebo.freemium.PurchaseController.Provider
    public PurchaseController providePurchaseController() {
        PurchaseController purchaseController = this.purchaseController;
        if (purchaseController != null) {
            return purchaseController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purchaseController");
        return null;
    }

    @Override // com.myscript.nebo.freemium.PromotionController.Provider
    public PromotionController providePromotionController() {
        PromotionController promotionController = this.promotionController;
        if (promotionController != null) {
            return promotionController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("promotionController");
        return null;
    }

    @Override // com.myscript.nebo.analytics.remoteconfig.RemoteConfig.Provider
    public RemoteConfig provideRemoteConfig() {
        RemoteConfigController remoteConfigController = this.remoteConfig;
        if (remoteConfigController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
            remoteConfigController = null;
        }
        return remoteConfigController;
    }

    @Override // com.myscript.nebo.account.UserProfileManager.Provider
    public UserProfileManager provideUserProfileManager() {
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager != null) {
            return userProfileManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
        return null;
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager.Provider
    public ResourceManager provideResourceManager() {
        ResourceManager resourceManager = this.resourceManager;
        if (resourceManager != null) {
            return resourceManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resourceManager");
        return null;
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.Provider
    public LibraryRepository provideLibraryRepository() {
        LibraryRepository libraryRepository = this.libraryRepository;
        if (libraryRepository != null) {
            return libraryRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
        return null;
    }

    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager.Provider
    public IAutoSyncTimerManager provideAutoSyncTimerManager() {
        IAutoSyncTimerManager iAutoSyncTimerManager = this.autoSyncTimerManager;
        if (iAutoSyncTimerManager != null) {
            return iAutoSyncTimerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
        return null;
    }

    @Override // com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider
    public NeboNetworkStateRepository provideNeboNetworkStateRepository() {
        NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl = this.networkStateRepository;
        if (neboNetworkStateRepositoryImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepositoryImpl = null;
        }
        return neboNetworkStateRepositoryImpl;
    }

    @Override // com.myscript.nebo.cloudsync.CloudManager.Provider
    public CloudManager provideCloudManager() {
        CloudManager cloudManager = this.cloudManager;
        if (cloudManager != null) {
            return cloudManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
        return null;
    }

    @Override // com.myscript.nebo.dms.sharepage.SharePageControllerProvider
    public SharePageController provideSharePageController() {
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            return sharePageController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharePageController");
        return null;
    }

    @Override // com.myscript.nebo.sso.HelpUsManager.Provider
    public HelpUsManager provideHelpUsManager() {
        HelpUsManager helpUsManager = this.helpUsManager;
        if (helpUsManager != null) {
            return helpUsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpUsManager");
        return null;
    }

    @Override // com.myscript.nebo.userdict.IUserDictionaryProvider
    public UserDictionary provideUserDictionary() {
        UserDictionary userDictionary = this.userDictionary;
        if (userDictionary != null) {
            return userDictionary;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userDictionary");
        return null;
    }

    @Override // com.myscript.nebo.common.ColorPolicyRepositoryProvider
    public ColorPolicyRepository provideColorPolicyRepository() {
        ColorPolicyRepository colorPolicyRepository = this.colorPolicyRepository;
        if (colorPolicyRepository != null) {
            return colorPolicyRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("colorPolicyRepository");
        return null;
    }

    @Override // com.myscript.nebo.account.backend.Backend.Provider
    public Backend provideBackend() {
        Backend backend = this.neboBackend;
        if (backend != null) {
            return backend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("neboBackend");
        return null;
    }

    @Override // com.myscript.nebo.account.backend.MailServicesProvider
    public MailServices provideMailServices() {
        MailServices mailServices = this.mailServices;
        if (mailServices != null) {
            return mailServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mailServices");
        return null;
    }

    @Override // com.myscript.nebo.ai.data.NeboAIClient.Provider
    public NeboAIClient provideNeboAIClient() {
        NeboAIClient neboAIClient = this.aiClient;
        if (neboAIClient != null) {
            return neboAIClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aiClient");
        return null;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository.Provider
    public ISubscriptionRepository provideSubscriptionRepository() {
        ISubscriptionRepository iSubscriptionRepository = this.subscriptionRepository;
        if (iSubscriptionRepository != null) {
            return iSubscriptionRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionRepository");
        return null;
    }

    @Override // com.myscript.nebo.migration.IInstallReferralRepository.Provider
    public IInstallReferralRepository provideInstallReferralRepository() {
        IInstallReferralRepository iInstallReferralRepository = this.installReferralRepository;
        if (iInstallReferralRepository != null) {
            return iInstallReferralRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("installReferralRepository");
        return null;
    }

    @Override // com.myscript.nebo.migration.ILenovoMigrationController.Provider
    public ILenovoMigrationController provideLenovoMigrationController() {
        ILenovoMigrationController iLenovoMigrationController = this.lenovoMigrationController;
        if (iLenovoMigrationController != null) {
            return iLenovoMigrationController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lenovoMigrationController");
        return null;
    }

    @Override // com.myscript.nebo.datacollect.NeboDataCollectDateStore.Provider
    public NeboDataCollectDateStore provideDataCollectDateStore() {
        return getNeboDataCollectDateStore();
    }

    @Override // com.myscript.shared.datacollect.DataCollect.Provider
    public DataCollect provideDataCollect() {
        DataCollect dataCollect = this.neboDataCollect;
        if (dataCollect != null) {
            return dataCollect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("neboDataCollect");
        return null;
    }

    private final DataStore<Preferences> getDiscoverabilityDataStore(android.content.Context context) {
        return (DataStore) this.discoverabilityDataStore.getValue(context, $$delegatedProperties[0]);
    }

    private final DataStore<Preferences> getFeatureMetricsDatastore(android.content.Context context) {
        return (DataStore) this.featureMetricsDatastore.getValue(context, $$delegatedProperties[1]);
    }

    private final DataStore<Preferences> getDataCollectDataStore(android.content.Context context) {
        return (DataStore) this.dataCollectDataStore.getValue(context, $$delegatedProperties[2]);
    }

    private final NeboDataCollectDateStore getNeboDataCollectDateStore() {
        return (NeboDataCollectDateStore) this.neboDataCollectDateStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NeboDataCollectDateStore neboDataCollectDateStore_delegate$lambda$0(NeboApplication neboApplication) {
        return new NeboDataCollectDateStore(neboApplication.getDataCollectDataStore(neboApplication));
    }

    private final DiscoveryRepository getDiscoveryRepository() {
        return (DiscoveryRepository) this.discoveryRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoveryRepository discoveryRepository_delegate$lambda$0(NeboApplication neboApplication) {
        return new DiscoveryRepository(neboApplication.getDiscoverabilityDataStore(neboApplication));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionManager getDiscoverabilitySessionManager() {
        return (SessionManager) this.discoverabilitySessionManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionManager discoverabilitySessionManager_delegate$lambda$0(NeboApplication neboApplication) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(neboApplication);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        return new SessionManager(defaultSharedPreferences);
    }

    private final DiscoverabilityManager getGridDiscoverabilityManager() {
        return (DiscoverabilityManager) this.gridDiscoverabilityManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverabilityManager gridDiscoverabilityManager_delegate$lambda$0(NeboApplication neboApplication) {
        return new DiscoverabilityManager(neboApplication.isFreemiumBusinessModelEnabled() ? GridDiscoverableFeatureKt.getGridDiscoverableFeatures() : CollectionsKt.emptyList(), neboApplication.getDiscoveryRepository(), neboApplication.getDiscoverabilitySessionManager(), new FeatureUsageMetrics(neboApplication.getFeatureMetricsDatastore(neboApplication)));
    }

    private final DiscoverabilityManager getEditingDiscoverabilityManager() {
        return (DiscoverabilityManager) this.editingDiscoverabilityManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverabilityManager editingDiscoverabilityManager_delegate$lambda$0(NeboApplication neboApplication) {
        return new DiscoverabilityManager(CollectionsKt.emptyList(), neboApplication.getDiscoveryRepository(), neboApplication.getDiscoverabilitySessionManager(), new FeatureUsageMetrics(neboApplication.getFeatureMetricsDatastore(neboApplication)));
    }

    public final List<CustomResource> getCustomResources() {
        return this._customResources;
    }

    @Override // com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider
    public List<String> provideSuggestedLanguages() {
        return CollectionsKt.toList(this.suggestedLanguageKeys);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactoryProvider
    public MotionPredictionParamsFactory provideMotionPredictionParamsFactory() {
        return new MotionPredictionParamsFactoryImpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application
    public void onCreate() throws Exception {
        TechnicalLogger technicalLogger;
        UserData userData;
        TechnicalLogger technicalLogger2;
        TechnicalLogger technicalLogger3;
        int i;
        TechnicalLogger technicalLogger4;
        UserData userData2;
        TechnicalLogger technicalLogger5;
        Backend backend;
        ISSOManager iSSOManager;
        UserData userData3;
        TechnicalLogger technicalLogger6;
        IInstallReferralRepository iInstallReferralRepository;
        PurchaseController purchaseController;
        ISubscriptionRepository iSubscriptionRepository;
        TechnicalLogger technicalLogger7;
        TechnicalLogger technicalLogger8;
        TechnicalLogger technicalLogger9;
        ApplicationState applicationState;
        UserProfileManager userProfileManager;
        ResourceManager resourceManager;
        LibraryRepository libraryRepository;
        Backend backend2;
        TechnicalLogger technicalLogger10;
        LibraryRepository libraryRepository2;
        IAutoSyncTimerManager iAutoSyncTimerManager;
        UserData userData4;
        TechnicalLogger technicalLogger11;
        TechnicalLogger technicalLogger12;
        TechnicalLogger technicalLogger13;
        TechnicalLogger technicalLogger14;
        String str;
        Object objM14499constructorimpl;
        String strSubstring;
        TechnicalLogger technicalLogger15;
        TechnicalLogger technicalLogger16;
        TechnicalLogger technicalLogger17;
        File file;
        InputStream inputStreamOpenRawResource;
        NeboApplication neboApplication = this;
        if (!isMainProcess(neboApplication)) {
            return;
        }
        Self = this;
        FirebaseAnalyticsLogger firebaseAnalyticsLogger = new FirebaseAnalyticsLogger();
        this.logger = firebaseAnalyticsLogger;
        TechnicalLoggerExt.logAction$default(firebaseAnalyticsLogger, TAG, "Start", null, 4, null);
        AnalyticsController.instantiate(neboApplication);
        SurvicateController survicateController = SurvicateController.INSTANCE;
        String string = getString(C6079R.string.survicate_workspace_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        survicateController.initSDK(neboApplication, string);
        RemoteConfigController remoteConfigController = new RemoteConfigController();
        this.remoteConfig = remoteConfigController;
        remoteConfigController.instantiate();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(neboApplication);
        Intrinsics.checkNotNull(defaultSharedPreferences);
        this.sessionManager = new UserSessionManager(defaultSharedPreferences);
        NeboApplication neboApplication2 = this;
        this.crossSellFilter = new CrossSellFilter(defaultSharedPreferences, neboApplication2);
        NeboApplication neboApplication3 = this;
        ApplicationState applicationState2 = new ApplicationState(neboApplication3);
        this.applicationState = applicationState2;
        wasRestartedFromCrash = applicationState2.wasCrashed();
        ApplicationState applicationState3 = this.applicationState;
        TechnicalLogger technicalLogger18 = null;
        if (applicationState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationState");
            applicationState3 = null;
        }
        applicationState3.clearCrash();
        TechnicalLogger technicalLogger19 = this.logger;
        if (technicalLogger19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            technicalLogger = null;
        } else {
            technicalLogger = technicalLogger19;
        }
        TechnicalLoggerExt.logAction$default(technicalLogger, TAG, "Create MyScript engine", null, 4, null);
        try {
            this.engineContext = Context.getInstance(MyCertificate.getBytes(), 73814285L);
            this.userData = new UserData(neboApplication3);
            String ssoUrl = MyScriptBackendConfiguration.getSsoUrl(neboApplication3);
            String string2 = getString(C6079R.string.myscript_sso_client_id);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getString(C6079R.string.myscript_sso_client_secret);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            SSOConfiguration sSOConfiguration = new SSOConfiguration(ssoUrl, string2, string3);
            UserData userData5 = this.userData;
            if (userData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData5 = null;
            }
            String str2 = "7.4.3.17964";
            SSOAuthApi sSOAuthApiBuildSSOAuthApi$default = SSOAuthApiKt.buildSSOAuthApi$default(userData5.getAppInstanceId(), "7.4.3.17964", null, 4, null);
            DiscoveryApi discoveryApiBuildDiscoveryApi = DiscoveryApiKt.buildDiscoveryApi(MyScriptBackendConfiguration.getSsoUrl(neboApplication3), new OkHttpClient().newBuilder().build());
            UserData userData6 = this.userData;
            if (userData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData6 = null;
            }
            Map mapPlus = MapsKt.plus(SSOCustomHeaderKt.computeCustomHeaders(userData6.getAppInstanceId(), "7.4.3.17964"), AppRequestHeaders.INSTANCE.getExtra());
            UserData userData7 = this.userData;
            if (userData7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData = null;
            } else {
                userData = userData7;
            }
            ChuckerInterceptor chuckerInterceptor = new ChuckerInterceptor(neboApplication);
            TechnicalLogger technicalLogger20 = this.logger;
            if (technicalLogger20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger2 = null;
            } else {
                technicalLogger2 = technicalLogger20;
            }
            OkHttpClient okHttpClientBuildSSOHttpClient = SSOHttpClientKt.buildSSOHttpClient(userData, sSOConfiguration, "7.4.3.17964", sSOAuthApiBuildSSOAuthApi$default, discoveryApiBuildDiscoveryApi, chuckerInterceptor, technicalLogger2, mapPlus);
            UserData userData8 = this.userData;
            if (userData8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData8 = null;
            }
            OkHttpClient okHttpClientBuildNativeLoginHttpClient = SSOHttpClientKt.buildNativeLoginHttpClient(userData8, "7.4.3.17964", new ChuckerInterceptor(neboApplication));
            UserData userData9 = this.userData;
            if (userData9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData9 = null;
            }
            TechnicalLogger technicalLogger21 = this.logger;
            if (technicalLogger21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger3 = null;
            } else {
                technicalLogger3 = technicalLogger21;
            }
            SSOManager sSOManager = new SSOManager(userData9, sSOConfiguration, str2, discoveryApiBuildDiscoveryApi, sSOAuthApiBuildSSOAuthApi$default, okHttpClientBuildSSOHttpClient, okHttpClientBuildNativeLoginHttpClient, technicalLogger3, new Function2() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NeboApplication.onCreate$lambda$1((String) obj, (String) obj2);
                }
            }, null, 512, null);
            this.ssoManager = sSOManager;
            sSOManager.addLoginListener(new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.NeboApplication.onCreate.3
                @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
                public void onLogin() {
                    NeboApplication.this.enqueueDataCollectWork();
                }

                @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
                public void onLogout() {
                    NeboApplication.this.cancelDataCollectWork();
                }
            });
            this.googleSignInHelper = new GoogleSignInHelper(CredentialManager.INSTANCE.create(neboApplication));
            UserData userData10 = this.userData;
            if (userData10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData10 = null;
            }
            RuntimeFeatureFlagHelper.addProvider(new InstrumentedFeatureFlagProvider(userData10));
            RuntimeFeatureFlagHelper.addProvider(new EarlyAccessFeaturesProvider(neboApplication3));
            RemoteConfigController remoteConfigController2 = this.remoteConfig;
            if (remoteConfigController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
                remoteConfigController2 = null;
            }
            RuntimeFeatureFlagHelper.addProvider(new RemoteConfigFeatureFlagProvider(remoteConfigController2));
            ApplicationState applicationState4 = this.applicationState;
            if (applicationState4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                applicationState4 = null;
            }
            Iterator<T> it = applicationState4.getNativeCrashesToLog().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                TechnicalLogger technicalLogger22 = this.logger;
                if (technicalLogger22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger22 = technicalLogger18;
                }
                technicalLogger22.logError(new NativeCrashCaughtException("A native crash happened in Nebo. Signal " + iIntValue + " was caught by signal handler."));
                neboApplication2 = neboApplication2;
                technicalLogger18 = null;
            }
            NeboApplication neboApplication4 = neboApplication2;
            ApplicationState applicationState5 = this.applicationState;
            if (applicationState5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                applicationState5 = null;
            }
            applicationState5.clearNativeCrashesToLog();
            String string4 = getString(C6079R.string.pref_dark_mode_key);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String string5 = getString(C6079R.string.pref_dark_mode_follow_system_value);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String string6 = getString(C6079R.string.pref_dark_mode_dark_value);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            String string7 = defaultSharedPreferences.getString(string4, string5);
            int i2 = 2;
            if (Intrinsics.areEqual(string7, string6)) {
                i = 2;
            } else {
                i = Intrinsics.areEqual(string7, string5) ? -1 : 1;
            }
            AppCompatDelegate.setDefaultNightMode(i);
            this.networkStateRepository = new NeboNetworkStateRepositoryImpl(new PlatformNetworkProviderInternal(neboApplication3), new SharedPreferencesSaver(neboApplication3, defaultSharedPreferences), new DozeIdleNotifications() { // from class: com.myscript.nebo.NeboApplication.onCreate.5
                @Override // com.myscript.nebo.network.DozeIdleNotifications
                public void registerDozeIdleChanged(final Function0<Unit> computeState) {
                    Intrinsics.checkNotNullParameter(computeState, "computeState");
                    NeboApplication.this.deviceIdleReceiver = new BroadcastReceiver() { // from class: com.myscript.nebo.NeboApplication$onCreate$5$registerDozeIdleChanged$1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(android.content.Context context, Intent intent) {
                            Intrinsics.checkNotNullParameter(context, "context");
                            Intrinsics.checkNotNullParameter(intent, "intent");
                            Object systemService = context.getSystemService("power");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                            if (((PowerManager) systemService).isDeviceIdleMode()) {
                                return;
                            }
                            computeState.invoke();
                        }
                    };
                    NeboApplication neboApplication5 = NeboApplication.this;
                    neboApplication5.registerReceiver(neboApplication5.deviceIdleReceiver, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
                }

                @Override // com.myscript.nebo.network.DozeIdleNotifications
                public void unregisterDozeIdleChanged() {
                    if (NeboApplication.this.deviceIdleReceiver != null) {
                        NeboApplication neboApplication5 = NeboApplication.this;
                        neboApplication5.unregisterReceiver(neboApplication5.deviceIdleReceiver);
                    }
                }
            }, null, 8, null);
            TechnicalLogger technicalLogger23 = this.logger;
            if (technicalLogger23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger4 = null;
            } else {
                technicalLogger4 = technicalLogger23;
            }
            TechnicalLoggerExt.logAction$default(technicalLogger4, TAG, "Initialize User Profile Manager", null, 4, null);
            this.purchaseController = new InAppPurchaseController(neboApplication3, null, i2, 0 == true ? 1 : 0);
            String aiUrl = MyScriptBackendConfiguration.getAiUrl(neboApplication3);
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl = this.networkStateRepository;
            if (neboNetworkStateRepositoryImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepositoryImpl = null;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl2 = neboNetworkStateRepositoryImpl;
            TechnicalLogger technicalLogger24 = this.logger;
            if (technicalLogger24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger24 = null;
            }
            this.aiClient = new NeboAIClient(okHttpClientBuildSSOHttpClient, aiUrl, neboNetworkStateRepositoryImpl2, technicalLogger24);
            this.legacyPaidStorage = new SecuredLegacyPaidStorage(neboApplication3, getStoredVersion(), null, 4, null);
            TechnicalLogger technicalLogger25 = this.logger;
            if (technicalLogger25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger25 = null;
            }
            PurchaseSecuredStorage purchaseSecuredStorage = new PurchaseSecuredStorage(neboApplication3, technicalLogger25);
            String neboAppUrl = MyScriptBackendConfiguration.getNeboAppUrl(neboApplication3);
            UserData userData11 = this.userData;
            if (userData11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData2 = null;
            } else {
                userData2 = userData11;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl3 = this.networkStateRepository;
            if (neboNetworkStateRepositoryImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepositoryImpl3 = null;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl4 = neboNetworkStateRepositoryImpl3;
            TechnicalLogger technicalLogger26 = this.logger;
            if (technicalLogger26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger5 = null;
            } else {
                technicalLogger5 = technicalLogger26;
            }
            this.neboBackend = new NeboBackend(okHttpClientBuildSSOHttpClient, neboAppUrl, userData2, defaultSharedPreferences, neboNetworkStateRepositoryImpl4, null, technicalLogger5, null, 160, null);
            String mailServicesUrl = MyScriptBackendConfiguration.getMailServicesUrl(neboApplication3);
            TechnicalLogger technicalLogger27 = this.logger;
            if (technicalLogger27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger27 = null;
            }
            this.mailServices = new MailServices(okHttpClientBuildSSOHttpClient, mailServicesUrl, technicalLogger27);
            InstallReferralRepository.Companion companion = InstallReferralRepository.INSTANCE;
            TechnicalLogger technicalLogger28 = this.logger;
            if (technicalLogger28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger28 = null;
            }
            this.installReferralRepository = companion.create(neboApplication, technicalLogger28);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), Dispatchers.getIO(), null, new C60536(null), 2, null);
            RevenueCatPurchaseProvider revenueCatPurchaseProvider = new RevenueCatPurchaseProvider(neboApplication3);
            Backend backend3 = this.neboBackend;
            if (backend3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("neboBackend");
                backend = null;
            } else {
                backend = backend3;
            }
            ISSOManager iSSOManager2 = this.ssoManager;
            if (iSSOManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
                iSSOManager = null;
            } else {
                iSSOManager = iSSOManager2;
            }
            MailServices mailServices = this.mailServices;
            if (mailServices == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mailServices");
                mailServices = null;
            }
            MailServices mailServices2 = mailServices;
            UserData userData12 = this.userData;
            if (userData12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData3 = null;
            } else {
                userData3 = userData12;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl5 = this.networkStateRepository;
            if (neboNetworkStateRepositoryImpl5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepositoryImpl5 = null;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl6 = neboNetworkStateRepositoryImpl5;
            TechnicalLogger technicalLogger29 = this.logger;
            if (technicalLogger29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger6 = null;
            } else {
                technicalLogger6 = technicalLogger29;
            }
            boolean zIsFreemiumBusinessModelEnabled = isFreemiumBusinessModelEnabled();
            RevenueCatPurchaseProvider revenueCatPurchaseProvider2 = revenueCatPurchaseProvider;
            IInstallReferralRepository iInstallReferralRepository2 = this.installReferralRepository;
            if (iInstallReferralRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("installReferralRepository");
                iInstallReferralRepository = null;
            } else {
                iInstallReferralRepository = iInstallReferralRepository2;
            }
            this.subscriptionRepository = new SubscriptionRepository(neboApplication3, backend, iSSOManager, mailServices2, userData3, neboNetworkStateRepositoryImpl6, defaultSharedPreferences, technicalLogger6, zIsFreemiumBusinessModelEnabled, revenueCatPurchaseProvider2, iInstallReferralRepository, null, 2048, null);
            SecuredLegacyPaidStorage securedLegacyPaidStorage = this.legacyPaidStorage;
            if (securedLegacyPaidStorage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPaidStorage");
                securedLegacyPaidStorage = null;
            }
            SecuredLegacyPaidStorage securedLegacyPaidStorage2 = securedLegacyPaidStorage;
            PurchaseController purchaseController2 = this.purchaseController;
            if (purchaseController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("purchaseController");
                purchaseController = null;
            } else {
                purchaseController = purchaseController2;
            }
            Backend backend4 = this.neboBackend;
            if (backend4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("neboBackend");
                backend4 = null;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl7 = this.networkStateRepository;
            if (neboNetworkStateRepositoryImpl7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepositoryImpl7 = null;
            }
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl8 = neboNetworkStateRepositoryImpl7;
            ISubscriptionRepository iSubscriptionRepository2 = this.subscriptionRepository;
            if (iSubscriptionRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionRepository");
                iSubscriptionRepository = null;
            } else {
                iSubscriptionRepository = iSubscriptionRepository2;
            }
            TechnicalLogger technicalLogger30 = this.logger;
            if (technicalLogger30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger7 = null;
            } else {
                technicalLogger7 = technicalLogger30;
            }
            this.userProfileManager = new NeboUserProfileManager(securedLegacyPaidStorage2, purchaseSecuredStorage, purchaseController, backend4, BuildConfig.APPLICATION_ID, neboNetworkStateRepositoryImpl8, iSubscriptionRepository, technicalLogger7, defaultSharedPreferences, null, null, 1536, null);
            PurchaseController purchaseController3 = this.purchaseController;
            if (purchaseController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("purchaseController");
                purchaseController3 = null;
            }
            purchaseController3.connect();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, new C60547(null), 3, null);
            ResourceManagerImpl resourceManagerImpl = new ResourceManagerImpl(neboApplication3, NeboResourceManagerConf.getNeboResourceManagerConf(neboApplication3));
            resourceManagerImpl.onBind();
            this.resourceManager = resourceManagerImpl;
            this.promotionController = new NeboPromotionController();
            TechnicalLogger technicalLogger31 = this.logger;
            if (technicalLogger31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger8 = null;
            } else {
                technicalLogger8 = technicalLogger31;
            }
            TechnicalLoggerExt.logAction$default(technicalLogger8, TAG, "Initialize LibraryRepository", null, 4, null);
            try {
                LibraryModule libraryModule = LibraryModule.INSTANCE;
                NeboApplication neboApplication5 = this;
                TechnicalLogger technicalLogger32 = this.logger;
                if (technicalLogger32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger9 = null;
                } else {
                    technicalLogger9 = technicalLogger32;
                }
                ApplicationState applicationState6 = this.applicationState;
                if (applicationState6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                    applicationState = null;
                } else {
                    applicationState = applicationState6;
                }
                UserProfileManager userProfileManager2 = this.userProfileManager;
                if (userProfileManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
                    userProfileManager = null;
                } else {
                    userProfileManager = userProfileManager2;
                }
                File dMSUserDir = getDMSUserDir();
                ResourceManager resourceManager2 = this.resourceManager;
                if (resourceManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resourceManager");
                    resourceManager = null;
                } else {
                    resourceManager = resourceManager2;
                }
                this.libraryRepository = libraryModule.provideLibraryRepository(neboApplication5, technicalLogger9, applicationState, userProfileManager, dMSUserDir, resourceManager);
                LibraryRepository libraryRepository3 = this.libraryRepository;
                if (libraryRepository3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository = null;
                } else {
                    libraryRepository = libraryRepository3;
                }
                LibraryRepository libraryRepository4 = this.libraryRepository;
                if (libraryRepository4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository4 = null;
                }
                SyncHelper syncHelper = libraryRepository4.syncHelper();
                Backend backend5 = this.neboBackend;
                if (backend5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("neboBackend");
                    backend2 = null;
                } else {
                    backend2 = backend5;
                }
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl9 = this.networkStateRepository;
                if (neboNetworkStateRepositoryImpl9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                    neboNetworkStateRepositoryImpl9 = null;
                }
                this.autoSyncTimerManager = new AutoSyncTimerManager(libraryRepository, syncHelper, backend2, neboNetworkStateRepositoryImpl9, null, null, 0L, 0L, 0L, 496, null);
                LenovoMigrationController.Companion companion2 = LenovoMigrationController.INSTANCE;
                LibraryRepository libraryRepository5 = this.libraryRepository;
                if (libraryRepository5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository5 = null;
                }
                IAutoSyncTimerManager iAutoSyncTimerManager2 = this.autoSyncTimerManager;
                if (iAutoSyncTimerManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager2 = null;
                }
                TechnicalLogger technicalLogger33 = this.logger;
                if (technicalLogger33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger33 = null;
                }
                this.lenovoMigrationController = companion2.create(neboApplication3, libraryRepository5, iAutoSyncTimerManager2, technicalLogger33);
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th) {
                        NeboApplication.onCreate$lambda$4(this.f$0, defaultUncaughtExceptionHandler, thread, th);
                    }
                });
                NeboEngine.setNativeCrashHandlerClass(NeboApplication.class);
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl10 = this.networkStateRepository;
                if (neboNetworkStateRepositoryImpl10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                    neboNetworkStateRepositoryImpl10 = null;
                }
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl11 = neboNetworkStateRepositoryImpl10;
                TechnicalLogger technicalLogger34 = this.logger;
                if (technicalLogger34 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger10 = null;
                } else {
                    technicalLogger10 = technicalLogger34;
                }
                this.preRatingFilter = new PreRatingFilter(neboApplication3, neboApplication4, neboNetworkStateRepositoryImpl11, technicalLogger10, null, 0, null, null, null, null, 1008, null);
                LibraryRepository libraryRepository6 = this.libraryRepository;
                if (libraryRepository6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository2 = null;
                } else {
                    libraryRepository2 = libraryRepository6;
                }
                IAutoSyncTimerManager iAutoSyncTimerManager3 = this.autoSyncTimerManager;
                if (iAutoSyncTimerManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager = null;
                } else {
                    iAutoSyncTimerManager = iAutoSyncTimerManager3;
                }
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl12 = this.networkStateRepository;
                if (neboNetworkStateRepositoryImpl12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                    neboNetworkStateRepositoryImpl12 = null;
                }
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl13 = neboNetworkStateRepositoryImpl12;
                UserData userData13 = this.userData;
                if (userData13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    userData4 = null;
                } else {
                    userData4 = userData13;
                }
                CloudManagerImpl cloudManagerImpl = new CloudManagerImpl(neboApplication3, libraryRepository2, iAutoSyncTimerManager, neboNetworkStateRepositoryImpl13, userData4, LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, PsExtractor.AUDIO_STREAM, null);
                this.cloudManager = cloudManagerImpl;
                cloudManagerImpl.addCloudSyncInitializedListener(new CloudManager.CloudSyncInitializedListener() { // from class: com.myscript.nebo.NeboApplication.onCreate.10
                    @Override // com.myscript.nebo.cloudsync.CloudManager.CloudSyncInitializedListener
                    public void onCloudSyncInitialized() {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, new NeboApplication$onCreate$10$onCloudSyncInitialized$1(NeboApplication.this, null), 3, null);
                    }
                });
                LibraryModule libraryModule2 = LibraryModule.INSTANCE;
                LibraryRepository libraryRepository7 = this.libraryRepository;
                if (libraryRepository7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository7 = null;
                }
                UserData userData14 = this.userData;
                if (userData14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    userData14 = null;
                }
                String neboAppUrl2 = MyScriptBackendConfiguration.getNeboAppUrl(neboApplication3);
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl14 = this.networkStateRepository;
                if (neboNetworkStateRepositoryImpl14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                    neboNetworkStateRepositoryImpl14 = null;
                }
                this.sharePageController = libraryModule2.provideSharePageController(this, libraryRepository7, userData14, okHttpClientBuildSSOHttpClient, neboAppUrl2, neboNetworkStateRepositoryImpl14);
                UserData userData15 = this.userData;
                if (userData15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    userData15 = null;
                }
                NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl15 = this.networkStateRepository;
                if (neboNetworkStateRepositoryImpl15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                    neboNetworkStateRepositoryImpl15 = null;
                }
                this.helpUsManager = new HelpUsManager(neboApplication3, neboApplication4, userData15, neboNetworkStateRepositoryImpl15);
                DataCollect.Companion companion3 = DataCollect.INSTANCE;
                String neboAppUrl3 = MyScriptBackendConfiguration.getNeboAppUrl(neboApplication3);
                File cacheDir = getCacheDir();
                Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
                this.neboDataCollect = companion3.create(okHttpClientBuildSSOHttpClient, neboAppUrl3, cacheDir, "MyScript Notes", new Function2() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NeboApplication.onCreate$lambda$5((String) obj, (Map) obj2);
                    }
                }, new Function1() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NeboApplication.onCreate$lambda$6((Exception) obj);
                    }
                });
                enqueueDataCollectWork();
                this._customResources.add(new CustomResource("zip://" + getPackageCodePath() + "!/assets/resources/mul-sk-nebo_disabled.res", CustomResourceType.STANDARD));
                File file2 = new File(getFilesDir(), "user_dict-lk.res");
                File parentFile = file2.getParentFile();
                Intrinsics.checkNotNull(parentFile);
                this.userDictionary = new UserDictionary(new UserDictionaryConfiguration(parentFile.getAbsolutePath(), file2.getName()));
                this._customResources.add(new CustomResource(file2.getAbsolutePath(), CustomResourceType.MUTABLE));
                this.colorPolicyRepository = new ColorPolicyRepositoryImpl(neboApplication3);
                InkSettings.INSTANCE.bootstrapIfNeeded(neboApplication3, C6079R.array.default_predefined_ink_colors, C6693R.color.default_pen_color, C6693R.color.default_highlighter_color);
                TechnicalLogger technicalLogger35 = this.logger;
                if (technicalLogger35 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger11 = null;
                } else {
                    technicalLogger11 = technicalLogger35;
                }
                TechnicalLoggerExt.logAction$default(technicalLogger11, TAG, "Initialize custom fonts", null, 4, null);
                deleteOldFonts();
                TypefaceUtils.loadFonts(neboApplication, FONTS_DIR, defaultSharedPreferences.getInt(FONT_VERSION_KEY, -1) != 1);
                SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
                editorEdit.putInt(FONT_VERSION_KEY, 1);
                editorEdit.apply();
                TechnicalLogger technicalLogger36 = this.logger;
                if (technicalLogger36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger12 = null;
                } else {
                    technicalLogger12 = technicalLogger36;
                }
                TechnicalLoggerExt.logAction$default(technicalLogger12, TAG, "Initialize PDFNet library", null, 4, null);
                try {
                    file = new File(getFilesDir(), "pdftron_layout_resources.plugin");
                    try {
                        inputStreamOpenRawResource = getResources().openRawResource(C6969R.raw.pdftron_layout_resources);
                    } catch (IOException e) {
                        Log.e(TAG, "Error during PDFNet initialization: could not copy font resource file", e);
                    }
                } catch (PDFNetException e2) {
                    Log.e(TAG, "Error during PDFNet initialization", e2);
                }
                try {
                    InputStream inputStream = inputStreamOpenRawResource;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        Intrinsics.checkNotNull(inputStream);
                        ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                        PDFNet.initialize(this, C6969R.raw.pdfnet, BuildConfig.PDFNET_LICENSE_KEY);
                        PDFNet.addResourceSearchPath(getFilesDir().getAbsolutePath());
                        LocaleList locales = getResources().getConfiguration().getLocales();
                        Intrinsics.checkNotNullExpressionValue(locales, "getLocales(...)");
                        int size = locales.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Locale locale = locales.get(i3);
                            this.suggestedLanguageKeys.add(locale.getLanguage() + "_" + locale.getCountry());
                        }
                        Set<String> set = this.suggestedLanguageKeys;
                        String[] stringArray = getResources().getStringArray(C6079R.array.suggested_language_keys);
                        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
                        CollectionsKt.addAll(set, ArraysKt.toList(stringArray));
                        TechnicalLogger technicalLogger37 = this.logger;
                        if (technicalLogger37 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            technicalLogger13 = null;
                        } else {
                            technicalLogger13 = technicalLogger37;
                        }
                        TechnicalLoggerExt.logAction$default(technicalLogger13, TAG, "System Application.onCreate()", null, 4, null);
                        super.onCreate();
                        UserData userData16 = this.userData;
                        if (userData16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userData");
                            userData16 = null;
                        }
                        if (userData16.hasUser()) {
                            TechnicalLogger technicalLogger38 = this.logger;
                            if (technicalLogger38 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("logger");
                                technicalLogger17 = null;
                            } else {
                                technicalLogger17 = technicalLogger38;
                            }
                            TechnicalLoggerExt.logAction$default(technicalLogger17, TAG, "Check SSO Account for invalidated refresh token", null, 4, null);
                            checkSSOAccount();
                        }
                        MainThreadBus.eventBus.register(this);
                        String string8 = getString(C6079R.string.pref_interactivity_strike_through_key);
                        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                        if (defaultSharedPreferences.getBoolean(string8, false)) {
                            TechnicalLogger technicalLogger39 = this.logger;
                            if (technicalLogger39 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("logger");
                                technicalLogger16 = null;
                            } else {
                                technicalLogger16 = technicalLogger39;
                            }
                            TechnicalLoggerExt.logAction$default(technicalLogger16, TAG, "Migrate legacy strike-through setting", null, 4, null);
                            SharedPreferences.Editor editorEdit2 = defaultSharedPreferences.edit();
                            editorEdit2.putString(getString(C6079R.string.pref_interactivity_strike_through_document_key), getString(C6079R.string.pref_interactivity_erase_value));
                            editorEdit2.putString(getString(C6079R.string.pref_interactivity_strike_through_note_key), getString(C6079R.string.pref_interactivity_erase_value));
                            editorEdit2.remove(string8);
                            editorEdit2.apply();
                        }
                        String string9 = getString(C6079R.string.pref_interactivity_underline_words_key);
                        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                        if (defaultSharedPreferences.getBoolean(string9, false)) {
                            TechnicalLogger technicalLogger40 = this.logger;
                            if (technicalLogger40 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("logger");
                                technicalLogger15 = null;
                            } else {
                                technicalLogger15 = technicalLogger40;
                            }
                            TechnicalLoggerExt.logAction$default(technicalLogger15, TAG, "Migrate legacy underline setting", null, 4, null);
                            SharedPreferences.Editor editorEdit3 = defaultSharedPreferences.edit();
                            editorEdit3.putString(getString(C6079R.string.pref_interactivity_underline_words_document_key), getString(C6079R.string.pref_interactivity_bold_value));
                            editorEdit3.putString(getString(C6079R.string.pref_interactivity_underline_words_note_key), getString(C6079R.string.pref_interactivity_bold_value));
                            editorEdit3.remove(string9);
                            editorEdit3.apply();
                        }
                        TechnicalLogger technicalLogger41 = this.logger;
                        if (technicalLogger41 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            technicalLogger14 = null;
                        } else {
                            technicalLogger14 = technicalLogger41;
                        }
                        TechnicalLoggerExt.logAction$default(technicalLogger14, TAG, "Initialization done", null, 4, null);
                        successfulInit = true;
                        ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(this);
                        try {
                            Result.Companion companion4 = Result.INSTANCE;
                            NeboApplication neboApplication6 = this;
                            Signature[] apkSigners = SignatureUtilsKt.getApkSigners(this);
                            Signature signature = apkSigners != null ? (Signature) ArraysKt.firstOrNull(apkSigners) : null;
                            if (signature == null) {
                                strSubstring = AbstractJsonLexerKt.NULL;
                            } else {
                                String charsString = signature.toCharsString();
                                Intrinsics.checkNotNullExpressionValue(charsString, "toCharsString(...)");
                                if (StringsKt.isBlank(charsString)) {
                                    strSubstring = "blank";
                                } else {
                                    String strEncode = BaseEncoding.base16().lowerCase().encode(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
                                    Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
                                    strSubstring = StringsKt.substring(strEncode, new IntRange(0, RangesKt.coerceIn(15, (ClosedRange<Integer>) new IntRange(0, StringsKt.getLastIndex(strEncode)))));
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("count", String.valueOf(apkSigners != null ? apkSigners.length : 0));
                            bundle.putString(WebViewMessageType.CONTEXT, strSubstring);
                            str = "signature";
                            try {
                                AnalyticsController.logAnalytics(str, bundle);
                                TechnicalLogger technicalLogger42 = this.logger;
                                if (technicalLogger42 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                                    technicalLogger42 = null;
                                }
                                technicalLogger42.setKeyValue(str, strSubstring);
                                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion5 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = "signature";
                        }
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            TechnicalLogger technicalLogger43 = this.logger;
                            if (technicalLogger43 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("logger");
                                technicalLogger43 = null;
                            }
                            technicalLogger43.logError(new RuntimeException("Could not get signature", thM14502exceptionOrNullimpl));
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("count", "0");
                            bundle2.putString(WebViewMessageType.CONTEXT, "error");
                            AnalyticsController.logAnalytics(str, bundle2);
                            TechnicalLogger technicalLogger44 = this.logger;
                            if (technicalLogger44 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("logger");
                                technicalLogger44 = null;
                            }
                            technicalLogger44.setKeyValue(str, "error");
                        }
                        getDiscoverabilitySessionManager().registerSessionListener(neboApplication3);
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, new C605020(null), 3, null);
                        ApplicationState applicationState7 = this.applicationState;
                        if (applicationState7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                            applicationState7 = null;
                        }
                        if (!applicationState7.isFirstInstall() || defaultSharedPreferences.getBoolean(getString(C6079R.string.pref_cloudsync_dropbox_key), false) || defaultSharedPreferences.getBoolean(getString(C6079R.string.pref_cloudsync_gdrive_key), false)) {
                            return;
                        }
                        AnalyticsProperty.log$default(new NeboFirebaseProperty.CloudSyncProviderProperty("not_syncing"), null, 1, null);
                    } finally {
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } finally {
                    }
                }
            } catch (Exception e3) {
                INSTANCE.rawDataBackup();
                throw e3;
            }
        } catch (EngineError e4) {
            Log.e(TAG, e4.getMessage(), e4);
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(final String origin, final String type) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(type, "type");
        NeboFirebaseEvent.Login.log(new Function1() { // from class: com.myscript.nebo.NeboApplication$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboApplication.onCreate$lambda$1$0(origin, type, (Bundle) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$0(String str, String str2, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", str);
        log.putString("type", str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onCreate$6 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onCreate$6", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {514}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {515}, m1615s = {}, m1616v = 2)
    static final class C60536 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60536(Continuation<? super C60536> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C60536(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60536) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IInstallReferralRepository iInstallReferralRepository = NeboApplication.this.installReferralRepository;
                if (iInstallReferralRepository == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("installReferralRepository");
                    iInstallReferralRepository = null;
                }
                this.label = 1;
                if (iInstallReferralRepository.resolveReferral(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onCreate$7 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onCreate$7", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA5_2_4}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA5_2_7}, m1615s = {}, m1616v = 2)
    static final class C60547 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60547(Continuation<? super C60547> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C60547(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60547) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UserProfileManager userProfileManager = NeboApplication.this.userProfileManager;
                if (userProfileManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
                    userProfileManager = null;
                }
                this.label = 1;
                if (userProfileManager.isPaidSubscriber().collect(new FlowCollector() { // from class: com.myscript.nebo.NeboApplication.onCreate.7.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        SurvicateController.INSTANCE.setUserType(z);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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
    public static final void onCreate$lambda$4(NeboApplication neboApplication, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        ApplicationState applicationState = null;
        if ((th instanceof EngineError) || (th.getCause() instanceof EngineError)) {
            INSTANCE.handleDetectedCrash(-1);
        } else {
            NeboApplication neboApplication2 = neboApplication;
            CrashHandler.addCrash$default(neboApplication2, null, null, 6, null);
            if (CrashHandler.shouldReset(neboApplication2)) {
                LibraryRepository libraryRepository = neboApplication.libraryRepository;
                if (libraryRepository == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository = null;
                }
                libraryRepository.setLastOpenedFolderKey(null);
                LibraryRepository libraryRepository2 = neboApplication.libraryRepository;
                if (libraryRepository2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository2 = null;
                }
                libraryRepository2.setLastOpenedNoteKey(null);
                ApplicationState applicationState2 = neboApplication.applicationState;
                if (applicationState2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                    applicationState2 = null;
                }
                applicationState2.setPagesCrashCountKeys(SetsKt.emptySet());
                CrashHandler.reset(neboApplication2);
            }
        }
        PreRatingFilter preRatingFilter = neboApplication.preRatingFilter;
        if (preRatingFilter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preRatingFilter");
            preRatingFilter = null;
        }
        preRatingFilter.saveCrash();
        ApplicationState applicationState3 = neboApplication.applicationState;
        if (applicationState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationState");
        } else {
            applicationState = applicationState3;
        }
        applicationState.setCrashing();
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(String event, Map params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        Bundle bundle = new Bundle();
        for (Map.Entry entry : params.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        AnalyticsController.logAnalytics(event, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        AnalyticsController.logException(e);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onCreate$20 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onCreate$20", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA7_3_9}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {742}, m1615s = {}, m1616v = 2)
    static final class C605020 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C605020(Continuation<? super C605020> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C605020(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C605020) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.drop(NeboApplication.this.getDiscoverabilitySessionManager().getSessionCountFlow(), 1).collect(new FlowCollector() { // from class: com.myscript.nebo.NeboApplication.onCreate.20.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(int i2, Continuation<? super Unit> continuation) {
                        SurvicateController.INSTANCE.invokeEvent(SurvicateController.SurveyEvent.Session.INSTANCE);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        Object systemService = getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (!((PowerManager) systemService).isDeviceIdleMode()) {
            NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl = this.networkStateRepository;
            if (neboNetworkStateRepositoryImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
                neboNetworkStateRepositoryImpl = null;
            }
            neboNetworkStateRepositoryImpl.computeState();
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(owner), null, null, new C60551(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onStart$1 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onStart$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {762}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {763}, m1615s = {}, m1616v = 2)
    static final class C60551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60551(Continuation<? super C60551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C60551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IAutoSyncTimerManager iAutoSyncTimerManager = NeboApplication.this.autoSyncTimerManager;
                if (iAutoSyncTimerManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager = null;
                }
                this.label = 1;
                if (iAutoSyncTimerManager.onAppResumedFromBackground(this) == coroutine_suspended) {
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

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(owner), null, null, new C60561(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onStop$1 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onStop$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {770}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {771}, m1615s = {}, m1616v = 2)
    static final class C60561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60561(Continuation<? super C60561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C60561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IAutoSyncTimerManager iAutoSyncTimerManager = NeboApplication.this.autoSyncTimerManager;
                if (iAutoSyncTimerManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager = null;
                }
                this.label = 1;
                if (iAutoSyncTimerManager.onAppGoingToBackground(this) == coroutine_suspended) {
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

    private final void deleteOldFonts() {
        File file = new File(getFilesDir(), FONTS_DIR);
        String[] strArr = {"Azuki.ttf", "Azuki_ALT.ttf", "Inter-Regular.otf", "Inter-Bold.otf", "InterNebo-Regular.otf", "InterNebo-Bold.otf", new String("SentyMarukoElementary.ttf".getBytes(), Charsets.UTF_8), "SourceSansPro-Light.ttf", "SourceSansPro-Regular.ttf", "SourceSansPro-Semibold.ttf", "STIXGeneral.ttf", "STIX-Italic.otf", "Azuki_20171124.ttf", "GunnyRewritten.ttf", "NanumPen.otf", "WaitingfortheSunrise.ttf"};
        ArrayList arrayList = new ArrayList(16);
        for (int i = 0; i < 16; i++) {
            arrayList.add(new File(file, strArr[i]));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((File) obj).isFile()) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$onTerminate$1 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onTerminate$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {806}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {807}, m1615s = {}, m1616v = 2)
    static final class C60571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60571(Continuation<? super C60571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboApplication.this.new C60571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IAutoSyncTimerManager iAutoSyncTimerManager = NeboApplication.this.autoSyncTimerManager;
                if (iAutoSyncTimerManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager = null;
                }
                this.label = 1;
                if (iAutoSyncTimerManager.stop(this) == coroutine_suspended) {
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

    @Override // android.app.Application
    public void onTerminate() throws InterruptedException {
        NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl = null;
        BuildersKt__BuildersKt.runBlocking$default(null, new C60571(null), 1, null);
        Context context = this.engineContext;
        if (context != null) {
            context.delete();
        }
        this.engineContext = null;
        BroadcastReceiver broadcastReceiver = this.deviceIdleReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        this.deviceIdleReceiver = null;
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        userProfileManager.release();
        NeboNetworkStateRepositoryImpl neboNetworkStateRepositoryImpl2 = this.networkStateRepository;
        if (neboNetworkStateRepositoryImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
        } else {
            neboNetworkStateRepositoryImpl = neboNetworkStateRepositoryImpl2;
        }
        neboNetworkStateRepositoryImpl.destroy();
        MainThreadBus.eventBus.unregister(this);
        ProcessLifecycleOwner.INSTANCE.get().getLifecycle().removeObserver(this);
        getDiscoverabilitySessionManager().unregisterSessionListener(this);
        super.onTerminate();
    }

    private final boolean isMainProcess(android.content.Context context) {
        Object next;
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        String str = null;
        if (runningAppProcesses != null) {
            Iterator<T> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ActivityManager.RunningAppProcessInfo) next).pid == Process.myPid()) {
                    break;
                }
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            if (runningAppProcessInfo != null) {
                str = runningAppProcessInfo.processName;
            }
        }
        return Intrinsics.areEqual(context.getApplicationInfo().packageName, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.VmPolicy.Builder builderDetectFileUriExposure = new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedClosableObjects().detectFileUriExposure();
        Intrinsics.checkNotNullExpressionValue(builderDetectFileUriExposure, "detectFileUriExposure(...)");
        builderDetectFileUriExposure.detectContentUriWithoutPermission();
        builderDetectFileUriExposure.penaltyLog();
        StrictMode.setVmPolicy(builderDetectFileUriExposure.build());
    }

    private final void checkSSOAccount() {
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        iSSOManager.getAccountAsync(new ISSOManager.OnAccountReceivedListener() { // from class: com.myscript.nebo.NeboApplication.checkSSOAccount.1
            @Override // com.myscript.nebo.sso.api.ISSOManager.OnAccountReceivedListener
            public void onAccountReceived() {
                UserData userData = NeboApplication.this.userData;
                UserData userData2 = null;
                if (userData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    userData = null;
                }
                if (!userData.isNewPrivacyAccepted()) {
                    Session.needToUpdatePrivacyPolicy = true;
                    MainThreadBus.eventBus.post(OnUpdatePrivacyPolicyNeededEvent.UNIQUE);
                }
                LibraryRepository libraryRepository = NeboApplication.this.libraryRepository;
                if (libraryRepository == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                    libraryRepository = null;
                }
                UserData userData3 = NeboApplication.this.userData;
                if (userData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                } else {
                    userData2 = userData3;
                }
                libraryRepository.setPublicAuthorId(userData2.getPublicAuthorId());
            }

            @Override // com.myscript.nebo.sso.api.ISSOManager.OnAccountReceivedListener
            public void onTokenInvalid() {
                IAutoSyncTimerManager iAutoSyncTimerManager = NeboApplication.this.autoSyncTimerManager;
                LibraryRepository libraryRepository = null;
                if (iAutoSyncTimerManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                    iAutoSyncTimerManager = null;
                }
                iAutoSyncTimerManager.cancelSync();
                Companion companion = NeboApplication.INSTANCE;
                UserData userData = NeboApplication.this.userData;
                if (userData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    userData = null;
                }
                CloudManager cloudManager = NeboApplication.this.cloudManager;
                if (cloudManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
                    cloudManager = null;
                }
                companion.onTokenInvalid$app_standardRelease(userData, cloudManager);
                LibraryRepository libraryRepository2 = NeboApplication.this.libraryRepository;
                if (libraryRepository2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                } else {
                    libraryRepository = libraryRepository2;
                }
                libraryRepository.setPublicAuthorId("");
            }
        });
    }

    @Override // com.myscript.nebo.videotutorial.IMediaPlayerConfigurer.Provider
    public IMediaPlayerConfigurer getMediaPlayerConfigurer() {
        return new IMediaPlayerConfigurer() { // from class: com.myscript.nebo.NeboApplication$mediaPlayerConfigurer$1
            @Override // com.myscript.nebo.videotutorial.IMediaPlayerConfigurer
            public long getProgressAnimationTick() {
                return 16L;
            }
        };
    }

    public File getDMSUserDir() {
        return new File(getFilesDir(), USER_DIRECTORY_NAME);
    }

    @Deprecated(message = "Revise how we can handle the 'legacy paid user' state in tests")
    protected String getStoredVersion() {
        ApplicationState applicationState = this.applicationState;
        if (applicationState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationState");
            applicationState = null;
        }
        return applicationState.getStoredVersion();
    }

    @Override // com.myscript.nebo.common.IClock
    public long getTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @Override // com.myscript.nebo.freemium.FreemiumBusinessModelStatus
    public boolean isFreemiumBusinessModelEnabled() {
        return getResources().getBoolean(C6079R.bool.enable_freemium_business_model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelDataCollectWork() {
        WorkManager.INSTANCE.getInstance(this).cancelUniqueWork(NeboDataCollectWorker.UNIQUE_WORK_NAME);
    }

    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001d\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/NeboApplication$Companion;", "", "<init>", "()V", "TAG", "", "JAVA_CRASH", "", NeboApplication.FONT_VERSION_KEY, "CURRENT_FONT_VERSION", "FONTS_DIR", NeboApplication.DISCOVERABILITY_PREFERENCES_NAME, NeboApplication.FEATURE_METRICS_PREFERENCES_NAME, "USER_DIRECTORY_NAME", "getUSER_DIRECTORY_NAME$annotations", "Self", "Lcom/myscript/nebo/NeboApplication;", "wasRestartedFromCrash", "", "successfulInit", "handleDetectedCrash", "", "signal", "rawDataBackup", "onTokenInvalid", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "onTokenInvalid$app_standardRelease", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getUSER_DIRECTORY_NAME$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void handleDetectedCrash(int signal) {
            if (!NeboApplication.successfulInit) {
                NeboApplication.successfulInit = true;
                rawDataBackup();
            }
            NeboApplication neboApplication = NeboApplication.Self;
            if (neboApplication == null) {
                return;
            }
            ApplicationState applicationState = null;
            if (PreferenceManager.getDefaultSharedPreferences(neboApplication).getBoolean(neboApplication.getString(C6079R.string.enable_recovery_key), true)) {
                ApplicationState applicationState2 = neboApplication.applicationState;
                if (applicationState2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                    applicationState2 = null;
                }
                String noteCrashCountKey = applicationState2.getNoteCrashCountKey();
                if (noteCrashCountKey != null) {
                    ApplicationState applicationState3 = neboApplication.applicationState;
                    if (applicationState3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                        applicationState3 = null;
                    }
                    applicationState3.incrementCrashCount(noteCrashCountKey);
                    ApplicationState applicationState4 = neboApplication.applicationState;
                    if (applicationState4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                        applicationState4 = null;
                    }
                    ApplicationState applicationState5 = neboApplication.applicationState;
                    if (applicationState5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                        applicationState5 = null;
                    }
                    Set<String> pagesCrashCountKeys = applicationState5.getPagesCrashCountKeys();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : pagesCrashCountKeys) {
                        if (PageKey.createKeyFromUuid((String) obj).isValid()) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<String> arrayList2 = arrayList;
                    for (String str : arrayList2) {
                        ApplicationState applicationState6 = neboApplication.applicationState;
                        if (applicationState6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                            applicationState6 = null;
                        }
                        applicationState6.incrementCrashCount(str);
                    }
                    applicationState4.setPagesCrashCountKeys(CollectionsKt.toSet(arrayList2));
                }
            }
            if (signal != -1) {
                ApplicationState applicationState7 = neboApplication.applicationState;
                if (applicationState7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationState");
                } else {
                    applicationState = applicationState7;
                }
                applicationState.addNativeCrashToLog(signal);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void rawDataBackup() {
            NeboApplication neboApplication = NeboApplication.Self;
            if (neboApplication == null) {
                return;
            }
            try {
                File file = new File(neboApplication.getFilesDir(), NeboApplication.USER_DIRECTORY_NAME);
                File file2 = new File(neboApplication.getFilesDir(), "database");
                File externalCacheDir = neboApplication.getExternalCacheDir();
                if (externalCacheDir != null) {
                    DMS.rawDataBackup(file2.getAbsolutePath(), file.getAbsolutePath(), externalCacheDir.getAbsolutePath());
                }
            } catch (Exception e) {
                TechnicalLogger technicalLogger = neboApplication.logger;
                if (technicalLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger = null;
                }
                technicalLogger.logError(e);
            }
        }

        @JvmStatic
        public final boolean wasRestartedFromCrash() {
            return NeboApplication.wasRestartedFromCrash;
        }

        public final void onTokenInvalid$app_standardRelease(UserData userData, CloudManager cloudManager) {
            Intrinsics.checkNotNullParameter(userData, "userData");
            Intrinsics.checkNotNullParameter(cloudManager, "cloudManager");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, new NeboApplication$Companion$onTokenInvalid$1(userData, cloudManager, null), 3, null);
        }
    }

    @Override // com.myscript.nebo.discoverability.DiscoveryRepository.Provider
    public DiscoveryRepository provideDiscoveryRepository() {
        return getDiscoveryRepository();
    }

    @Override // com.myscript.nebo.discoverability.session.SessionManager.Provider
    public SessionManager provideDiscoverySessionManager() {
        return getDiscoverabilitySessionManager();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$provideFeatureToTooltipState$1 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C60581 extends FunctionReferenceImpl implements Function1<IDiscoverableFeature, TooltipUIState> {
        C60581(Object obj) {
            super(1, obj, NeboApplication.class, "featureToTooltipState", "featureToTooltipState(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;)Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TooltipUIState invoke(IDiscoverableFeature p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((NeboApplication) this.receiver).featureToTooltipState(p0);
        }
    }

    @Override // com.myscript.nebo.discoverability.ui.TooltipUIState.Provider
    public Function1<IDiscoverableFeature, TooltipUIState> provideFeatureToTooltipState() {
        return new C60581(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TooltipUIState featureToTooltipState(IDiscoverableFeature feature) {
        if (feature instanceof GridDiscoverableFeature) {
            Intrinsics.checkNotNull(feature, "null cannot be cast to non-null type com.myscript.nebo.dms.discoverability.GridDiscoverableFeature");
            return TooltipUIStateKt.toTooltipState$default((GridDiscoverableFeature) feature, false, 1, null);
        }
        if (!(feature instanceof EditingDiscoverableFeature)) {
            return null;
        }
        Intrinsics.checkNotNull(feature, "null cannot be cast to non-null type com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature");
        return com.myscript.nebo.editing.discoverability.TooltipUIStateKt.toTooltipState$default((EditingDiscoverableFeature) feature, false, 1, null);
    }

    @Override // com.myscript.nebo.discoverability.DiscoverabilityManager.Provider
    public DiscoverabilityManager provideGridDiscoverabilityManager() {
        return getGridDiscoverabilityManager();
    }

    @Override // com.myscript.nebo.discoverability.DiscoverabilityManager.Provider
    public DiscoverabilityManager provideEditingDiscoverabilityManager() {
        return getEditingDiscoverabilityManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueDataCollectWork() {
        WorkManager.INSTANCE.getInstance(this).enqueueUniqueWork(NeboDataCollectWorker.UNIQUE_WORK_NAME, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) NeboDataCollectWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED).build()).build());
    }
}
