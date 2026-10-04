package com.myscript.nebo.editing;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.C0028R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NavUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuProvider;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.android.utils.ComposeViewManager;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.TextViewExt;
import com.myscript.android.utils.ViewExt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.MessageIdentifier;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.SelectionState;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.HapticFeedbackManagerFactoryImpl;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.NeboBaseActivity;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.banner.Banner;
import com.myscript.nebo.banner.BannerLayout;
import com.myscript.nebo.banner.BannerViewModel;
import com.myscript.nebo.banner.Type;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.common.view.LanguagePill;
import com.myscript.nebo.crash.ICrashCountState;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.discoverability.p024ui.compose.TooltipComposableProviderImpl;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.gdrive.C6278R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.nebo.dms.sharepage.dialog.SharePageDialog;
import com.myscript.nebo.draft.videotutorial.C6313R;
import com.myscript.nebo.editing.ChildPagesViewModel;
import com.myscript.nebo.editing.EditingActivity;
import com.myscript.nebo.editing.ManagePagesDialog;
import com.myscript.nebo.editing.PageFragment;
import com.myscript.nebo.editing.PageViewModel;
import com.myscript.nebo.editing.background.PageBackgroundFragment;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.ITouchFeature;
import com.myscript.nebo.editing.search.SearchHitNavState;
import com.myscript.nebo.editing.search.SearchPageState;
import com.myscript.nebo.editing.search.SearchPageViewModel;
import com.myscript.nebo.editing.zoom.ZoomIndicatorView;
import com.myscript.nebo.events.OnUpdatePrivacyPolicyNeededEvent;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.freemium.FreemiumLimitationDialogKt;
import com.myscript.nebo.freemium.FreemiumLimitationDialogState;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.freemium.FreemiumLimitationViewModelKt;
import com.myscript.nebo.grid.NoteNameDialog;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.p022ai.AIAnalyticsOrigin;
import com.myscript.nebo.p022ai.AIExplainTrigger;
import com.myscript.nebo.p022ai.AISummarizeTrigger;
import com.myscript.nebo.p022ai.domain.AIContainerEvent;
import com.myscript.nebo.p022ai.presentation.AIExplainViewModel;
import com.myscript.nebo.p022ai.presentation.AIQuizViewModel;
import com.myscript.nebo.p022ai.presentation.AISummarizeViewModel;
import com.myscript.nebo.p022ai.presentation.QuizMode;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerPaneKt;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIMode;
import com.myscript.nebo.p022ai.presentation.compose.UserDataProvider;
import com.myscript.nebo.p034ui.compose.DataCollectDialogKt;
import com.myscript.nebo.p034ui.compose.NativeSignInDialogKt;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.PenFragment;
import com.myscript.nebo.penpanel.ToolConfigurationDialogFragment;
import com.myscript.nebo.penpanel.ToolbarViewModel;
import com.myscript.nebo.penpanel.ToolbarViewModelFactory;
import com.myscript.nebo.purchase.PaywallKt;
import com.myscript.nebo.purchase.PaywallViewModel;
import com.myscript.nebo.search.HistoryAdapter;
import com.myscript.nebo.sso.IHelpUsConsumer;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import com.myscript.nebo.utils.Session;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfiguration;
import com.myscript.snt.dms.DMSSyncState;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import com.myscript.snt.dms.PageType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u009a\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\n\u0017`£\u0001®\u0001³\u0001Í\u0001\b\u0007\u0018\u0000 \u009b\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u009b\u0002B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00101\u001a\u000202H\u0002J\b\u0010]\u001a\u00020^H\u0014J\u0015\u0010\u009d\u0001\u001a\u0004\u0018\u0001042\b\u0010\u009e\u0001\u001a\u00030\u0093\u0001H\u0002J\u0015\u0010\u009f\u0001\u001a\u0004\u0018\u00010i2\b\u0010\u009e\u0001\u001a\u00030\u0093\u0001H\u0002J\u001a\u0010 \u0001\u001a\u00020^2\u000f\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u0001H\u0002J\u0013\u0010¥\u0001\u001a\u00020^2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u0015\u0010¹\u0001\u001a\u00020^2\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0014J\t\u0010¼\u0001\u001a\u00020^H\u0002J\u0015\u0010¼\u0001\u001a\u00020^2\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020^H\u0016J\u0013\u0010À\u0001\u001a\u00020^2\b\u0010Á\u0001\u001a\u00030Â\u0001H\u0016J\u0014\u0010Ã\u0001\u001a\u00020^2\t\u0010Ä\u0001\u001a\u0004\u0018\u000104H\u0002J\t\u0010Å\u0001\u001a\u00020^H\u0014J\t\u0010Æ\u0001\u001a\u00020^H\u0014J\t\u0010Ç\u0001\u001a\u00020^H\u0014J \u0010È\u0001\u001a\u00030\u0088\u00012\b\u0010É\u0001\u001a\u00030\u0093\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010Ê\u0001H\u0016J\t\u0010Ë\u0001\u001a\u00020^H\u0016J\t\u0010Ï\u0001\u001a\u00020^H\u0002J\u0013\u0010Ð\u0001\u001a\u00020^2\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0002J\u0014\u0010Ó\u0001\u001a\u00020^2\t\u0010Ô\u0001\u001a\u0004\u0018\u000104H\u0002J\u001d\u0010Õ\u0001\u001a\u00020^2\b\u0010Ö\u0001\u001a\u00030\u0088\u00012\b\u0010×\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010Ø\u0001\u001a\u00030\u0088\u0001H\u0016J\t\u0010Ù\u0001\u001a\u00020^H\u0016J\u001e\u0010Ú\u0001\u001a\u00020^2\b\u0010Û\u0001\u001a\u00030\u0093\u00012\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010Ý\u0001\u001a\u00020^2\b\u0010Þ\u0001\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010ß\u0001\u001a\u00030\u0088\u00012\u0007\u0010à\u0001\u001a\u000204H\u0016J\t\u0010á\u0001\u001a\u00020^H\u0016J\t\u0010â\u0001\u001a\u00020^H\u0016J\t\u0010ã\u0001\u001a\u00020^H\u0016J\u001e\u0010ä\u0001\u001a\u00030\u0088\u00012\b\u0010É\u0001\u001a\u00030\u0093\u00012\b\u0010¦\u0001\u001a\u00030Ê\u0001H\u0016J\u0014\u0010å\u0001\u001a\u00030\u0088\u00012\b\u0010¦\u0001\u001a\u00030Ê\u0001H\u0016J\u0014\u0010æ\u0001\u001a\u00030\u0088\u00012\b\u0010¦\u0001\u001a\u00030ç\u0001H\u0016J\u001d\u0010è\u0001\u001a\u00020^2\b\u0010é\u0001\u001a\u00030ê\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0016J\u0015\u0010í\u0001\u001a\u00020^2\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0002J\u001e\u0010ð\u0001\u001a\u00020^2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0016J\u0013\u0010ñ\u0001\u001a\u00020^2\b\u0010ò\u0001\u001a\u00030ó\u0001H\u0016J\u0013\u0010ô\u0001\u001a\u00020^2\b\u0010î\u0001\u001a\u00030ï\u0001H\u0002J\t\u0010õ\u0001\u001a\u00020^H\u0002J\u0012\u0010ö\u0001\u001a\u00020^2\u0007\u0010Ü\u0001\u001a\u00020\u0010H\u0016J\t\u0010÷\u0001\u001a\u00020^H\u0016J\t\u0010ø\u0001\u001a\u00020^H\u0016J\t\u0010ù\u0001\u001a\u00020^H\u0016J\t\u0010ú\u0001\u001a\u00020^H\u0016J\t\u0010û\u0001\u001a\u00020^H\u0002J\n\u0010ü\u0001\u001a\u00030ý\u0001H\u0002J\u0013\u0010þ\u0001\u001a\u00020^2\b\u0010ÿ\u0001\u001a\u00030\u0088\u0001H\u0002J\u001c\u0010\u0080\u0002\u001a\u00020^2\u0007\u0010Ü\u0001\u001a\u00020\u00102\b\u0010\u0081\u0002\u001a\u00030\u0088\u0001H\u0002J\u0015\u0010\u0082\u0002\u001a\u00020^2\n\b\u0001\u0010\u0083\u0002\u001a\u00030\u0093\u0001H\u0017J*\u0010\u0082\u0002\u001a\u00020^2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00102\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u00022\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0017J\u0013\u0010\u0088\u0002\u001a\u00020^2\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0002J\u0013\u0010\u008b\u0002\u001a\u00020^2\b\u0010\u008c\u0002\u001a\u00030\u008d\u0002H\u0002J\u0019\u0010\u008e\u0002\u001a\u00020^2\u000e\u0010\u008f\u0002\u001a\t\u0012\u0004\u0012\u0002040\u008b\u0001H\u0002J\t\u0010\u0090\u0002\u001a\u00020^H\u0002J\t\u0010\u0091\u0002\u001a\u00020^H\u0017J\n\u0010\u0092\u0002\u001a\u00030\u0088\u0001H\u0016J\u0015\u0010\u0093\u0002\u001a\u00020^2\n\b\u0002\u0010Þ\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010\u0094\u0002\u001a\u00020^H\u0002J\n\u0010\u0095\u0002\u001a\u00030\u0096\u0002H\u0016J\t\u0010\u0097\u0002\u001a\u00020^H\u0002J\t\u0010\u0098\u0002\u001a\u00020^H\u0002J\u0012\u0010\u0099\u0002\u001a\u00020^2\u0007\u0010\u009a\u0002\u001a\u000204H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000e\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000e\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u000e\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000e\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u000e\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u000e\u001a\u0004\bU\u0010VR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u000e\u001a\u0004\bZ\u0010[R\u0010\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u000e\u0010b\u001a\u00020cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010i8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u0001028FX\u0087\u0004¢\u0006\f\u0012\u0004\bn\u0010\b\u001a\u0004\bo\u0010pR\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\u000e\u001a\u0004\bs\u0010tR\u000e\u0010v\u001a\u00020wX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020wX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020yX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020wX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020wX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u007fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¤\u0001R\u0010\u0010¨\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010©\u0001\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0005\u0012\u00030\u0088\u00010ª\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010«\u0001\u001a\u00030¬\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0013\u0010\u00ad\u0001\u001a\u00030®\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¯\u0001R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010²\u0001\u001a\u00030³\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010´\u0001R\u0010\u0010µ\u0001\u001a\u00030¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ì\u0001\u001a\u00030Í\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Î\u0001¨\u0006\u009c\u0002²\u0006\f\u0010\u009d\u0002\u001a\u00030\u009e\u0002X\u008a\u0084\u0002²\u0006\f\u0010\u009f\u0002\u001a\u00030\u0088\u0001X\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/editing/EditingActivity;", "Lcom/myscript/nebo/NeboBaseActivity;", "Lcom/myscript/nebo/editing/PageFragment$Callback;", "Lcom/myscript/nebo/sso/IHelpUsConsumer;", "Lcom/myscript/nebo/editing/PageFragment$INotificationBannerCallback;", "Lcom/myscript/nebo/editing/PageFragment$IZoomCallback;", "Lcom/myscript/nebo/penpanel/PenFragment$Callback;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "openNoteKey", "Lcom/myscript/snt/core/PageKey;", "userDataProvider", "Lcom/myscript/nebo/ai/presentation/compose/UserDataProvider;", "aiSignInActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "aiTextSelectionProvider", "com/myscript/nebo/editing/EditingActivity$aiTextSelectionProvider$1", "Lcom/myscript/nebo/editing/EditingActivity$aiTextSelectionProvider$1;", "aiContainerViewModel", "Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "getAiContainerViewModel", "()Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "aiContainerViewModel$delegate", "aiExplainViewModel", "Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;", "getAiExplainViewModel", "()Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;", "aiExplainViewModel$delegate", "aiSummarizeViewModel", "Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "getAiSummarizeViewModel", "()Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "aiSummarizeViewModel$delegate", "aiQuizViewModel", "Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "getAiQuizViewModel", "()Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "aiQuizViewModel$delegate", "aiButtonRect", "Landroid/graphics/Rect;", "getAIAnalyticsOrigin", "Lcom/myscript/nebo/ai/AIAnalyticsOrigin;", "pageController", "Lcom/myscript/snt/core/PageController;", "getAIAnalyticsSelectionType", "", "bannerViewModel", "Lcom/myscript/nebo/banner/BannerViewModel;", "getBannerViewModel", "()Lcom/myscript/nebo/banner/BannerViewModel;", "bannerViewModel$delegate", "toolbarViewModel", "Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "getToolbarViewModel", "()Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "toolbarViewModel$delegate", "searchViewModel", "Lcom/myscript/nebo/editing/search/SearchPageViewModel;", "getSearchViewModel", "()Lcom/myscript/nebo/editing/search/SearchPageViewModel;", "searchViewModel$delegate", "noteEditorViewModel", "Lcom/myscript/nebo/editing/NoteEditorViewModel;", "getNoteEditorViewModel", "()Lcom/myscript/nebo/editing/NoteEditorViewModel;", "noteEditorViewModel$delegate", "childPagesViewModel", "Lcom/myscript/nebo/editing/ChildPagesViewModel;", "getChildPagesViewModel", "()Lcom/myscript/nebo/editing/ChildPagesViewModel;", "childPagesViewModel$delegate", "paywallViewModel", "Lcom/myscript/nebo/purchase/PaywallViewModel;", "getPaywallViewModel", "()Lcom/myscript/nebo/purchase/PaywallViewModel;", "paywallViewModel$delegate", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "crashCountState", "Lcom/myscript/nebo/crash/ICrashCountState;", "getCrashCountState", "()Lcom/myscript/nebo/crash/ICrashCountState;", "crashCountState$delegate", "onResume", "", "syncListener", "com/myscript/nebo/editing/EditingActivity$syncListener$1", "Lcom/myscript/nebo/editing/EditingActivity$syncListener$1;", "bannerLayout", "Lcom/myscript/nebo/banner/BannerLayout;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "penFragment", "Lcom/myscript/nebo/penpanel/PenFragment;", "pageFragment", "Lcom/myscript/nebo/editing/PageFragment;", "getPageFragment", "()Lcom/myscript/nebo/editing/PageFragment;", "childPagesFragment", "Lcom/myscript/nebo/editing/ChildPagesFragment;", "getPageController$annotations", "getPageController", "()Lcom/myscript/snt/core/PageController;", "searchHistoryAdapter", "Lcom/myscript/nebo/search/HistoryAdapter;", "getSearchHistoryAdapter", "()Lcom/myscript/nebo/search/HistoryAdapter;", "searchHistoryAdapter$delegate", "searchResultsToolbar", "Landroid/view/View;", "hitsSearchTextView", "Landroid/widget/TextView;", "searchProgress", "navHitsSearchTextView", "searchPreviousButton", "searchNextButton", "editingContentConstraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "sidePanelGuideline", "Landroidx/constraintlayout/widget/Guideline;", "autoCompleteSearchView", "Landroidx/appcompat/widget/SearchView$SearchAutoComplete;", "paywallView", "Landroidx/compose/ui/platform/ComposeView;", "showPaywallDialog", "Landroidx/compose/runtime/MutableState;", "", "discoverabilityTooltip", "lastChildPagesUpdatedState", "", "Lcom/myscript/nebo/editing/ChildPage;", "childPagesNavigationWidget", "Lcom/myscript/nebo/editing/PageIndicator;", "isContainer", "childPagesViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "formerPagerPosition", "", "swipeTouchOverlay", "Landroid/gesture/GestureOverlayView;", "hapticFeedbackManager", "Lcom/myscript/nebo/editing/HapticFeedbackManager;", "isStylusWriting", "composeDialogHost", "dataCollectHost", "childPagesPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "getFragmentTagAtPosition", "position", "getFragmentAtPosition", "restoreSelectedChildPage", "pages", "onChildPagesPagerUpdate", "com/myscript/nebo/editing/EditingActivity$onChildPagesPagerUpdate$1", "Lcom/myscript/nebo/editing/EditingActivity$onChildPagesPagerUpdate$1;", "handleAIEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "tryReloadPageNextTime", "scrollToBottom", "Lkotlin/Pair;", "zoomIndicatorPanel", "Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView;", "onZoomIndicatorUpdate", "com/myscript/nebo/editing/EditingActivity$onZoomIndicatorUpdate$1", "Lcom/myscript/nebo/editing/EditingActivity$onZoomIndicatorUpdate$1;", "pageUpdateProviderCallback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProviderCallback;", "pageUpdateProvider", "com/myscript/nebo/editing/EditingActivity$pageUpdateProvider$1", "Lcom/myscript/nebo/editing/EditingActivity$pageUpdateProvider$1;", "onStylusDoubleTap", "Lcom/myscript/nebo/editing/IStylusDoubleTapListener;", "stylusDoubleTapReceiver", "Lcom/myscript/nebo/editing/StylusDoubleTapReceiver;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateDiscoveryTooltip", "tooltipUIState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "onPenToolbarLayout", "onPenOptionsDiscovered", "toolType", "Lcom/myscript/snt/core/ToolType;", "navigateToSearchHit", "pageId", "onStart", "onStop", "onDestroy", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "invalidateOptionsMenu", "menuProvider", "com/myscript/nebo/editing/EditingActivity$menuProvider$1", "Lcom/myscript/nebo/editing/EditingActivity$menuProvider$1;", "openExportDialog", "setupSearch", "menu", "Landroid/view/Menu;", "searchLabel", "label", "animateChildPagesPanel", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "animate", "canShowHelpUsDialog", "showHelpUsDialog", "onFinish", "resultCode", "pageKey", "onForceFinish", "result", "onShouldScrollToBottom", "tag", "onExplainSelection", "onSummarizeSelection", "onQuizSelection", "onKeyShortcut", "dispatchKeyEvent", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "onPageStateUpdated", "state", "Lcom/myscript/nebo/editing/PageViewModel$State;", "pageProperties", "Lcom/myscript/nebo/editing/PageProperties;", "onNotePropertiesChanged", "noteProperties", "Lcom/myscript/nebo/editing/NoteProperties;", "onPagePropertiesChanged", "onZoomChanged", "zoomState", "Lcom/myscript/nebo/editing/ZoomState;", "updateToolbarTitle", "openNewPage", "onPageReady", "notifyScratchOutGesture", "notifyDocumentTextBoxAdded", "notifyTextBoxAdded", "notifyHoldItemAdded", "unbindPage", "getKnowledgeBaseBanner", "Lcom/myscript/nebo/banner/Banner;", "showKnowledgeBaseBannerIfNeeded", "isSamplePage", "updateCorruptedPageNotif", "isCorrupted", "onShowNotificationBanner", "stringRes", "pageType", "Lcom/myscript/snt/dms/PageType;", "messageIdentifier", "Lcom/myscript/atk/core/MessageIdentifier;", "onSearchStateUpdate", "searchState", "Lcom/myscript/nebo/editing/search/SearchPageState;", "onHitNavStateUpdate", "hitNavState", "Lcom/myscript/nebo/editing/search/SearchHitNavState;", "onSearchHistoryUpdate", "history", "homePressed", "onBackPressed", "onNavigateUp", "saveStateBeforeLeaving", "onPenDetected", "getPageUpdateProvider", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProvider;", "requestNewNoteName", "addChildPagesFragment", "onShowPaywall", "origin", "Companion", "app_standardRelease", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "showSignIn"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EditingActivity extends NeboBaseActivity implements PageFragment.Callback, IHelpUsConsumer, PageFragment.INotificationBannerCallback, PageFragment.IZoomCallback, PenFragment.Callback {
    private static final String BANNER_ID_CORRUPTED_PAGE = "EditingActivity.BANNER_ID_CORRUPTED_PAGE";
    private static final String BANNER_ID_KNOWLEDGE_BASE = "EditingActivity.BANNER_ID_KNOWLEDGE_BASE";
    private static final String BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED = "EditingActivity.PAGE_ITEM_HARD_LIMIT_REACHED-";
    private static final String BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED = "EditingActivity.PAGE_ITEM_SOFT_LIMIT_REACHED-";
    private static final String BANNER_ID_MATH_BLOCK_LIMIT_REACHED = "EditingActivity.BANNER_ID_MATH_BLOCK_LIMIT_REACHED-";
    private static final String BANNER_ID_TRANSIENT = "EditingActivity.BANNER_ID_TRANSIENT-";
    public static final int CLOSE_PAGE_FORCED_CODE = 42;
    public static final int CORRUPTED_PAGE_RESULT_CODE = 40;
    public static final int CRASHED_AT_LOAD_PAGE_RESULT_CODE = 41;
    private static final String LONG_PAGE_ANALYTICS_KEY = "long_page_limit";
    private static final String LONG_PAGE_ANALYTICS_VALUE_HARD = "hard reached";
    private static final String LONG_PAGE_ANALYTICS_VALUE_OK = "OK";
    private static final String LONG_PAGE_ANALYTICS_VALUE_SOFT = "soft reached";
    public static final String PAGE_CONTENT_TYPE_ARGUMENT = "EditingActivity:PAGE_CONTENT_TYPE_ARGUMENT";
    public static final String PAGE_KEY_ARGUMENT = "EditingActivity:PAGE_KEY_ARGUMENT";
    public static final String TAG = "EditingActivity";
    private Rect aiButtonRect;

    /* JADX INFO: renamed from: aiContainerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiContainerViewModel;

    /* JADX INFO: renamed from: aiExplainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiExplainViewModel;

    /* JADX INFO: renamed from: aiQuizViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiQuizViewModel;

    /* JADX INFO: renamed from: aiSummarizeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiSummarizeViewModel;
    private SearchView.SearchAutoComplete autoCompleteSearchView;
    private BannerLayout bannerLayout;

    /* JADX INFO: renamed from: bannerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy bannerViewModel;
    private ChildPagesFragment childPagesFragment;
    private PageIndicator childPagesNavigationWidget;

    /* JADX INFO: renamed from: childPagesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy childPagesViewModel;
    private ViewPager2 childPagesViewPager;
    private ComposeView composeDialogHost;
    private ComposeView dataCollectHost;
    private ComposeView discoverabilityTooltip;
    private ConstraintLayout editingContentConstraintLayout;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;
    private HapticFeedbackManager hapticFeedbackManager;
    private TextView hitsSearchTextView;
    private boolean isContainer;
    private boolean isStylusWriting;
    private List<ChildPage> lastChildPagesUpdatedState;
    private TextView navHitsSearchTextView;

    /* JADX INFO: renamed from: noteEditorViewModel$delegate, reason: from kotlin metadata */
    private final Lazy noteEditorViewModel;
    private PageKey openNoteKey;
    private SharePageDialog.PageUpdateProviderCallback pageUpdateProviderCallback;
    private ComposeView paywallView;

    /* JADX INFO: renamed from: paywallViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paywallViewModel;
    private PenFragment penFragment;
    private View searchNextButton;
    private View searchPreviousButton;
    private View searchProgress;
    private View searchResultsToolbar;

    /* JADX INFO: renamed from: searchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy searchViewModel;
    private Guideline sidePanelGuideline;
    private StylusDoubleTapReceiver stylusDoubleTapReceiver;
    private GestureOverlayView swipeTouchOverlay;
    private MaterialToolbar toolbar;

    /* JADX INFO: renamed from: toolbarViewModel$delegate, reason: from kotlin metadata */
    private final Lazy toolbarViewModel;
    private boolean tryReloadPageNextTime;
    private ZoomIndicatorView zoomIndicatorPanel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EditingActivity.logger_delegate$lambda$0(this.f$0);
        }
    });
    private final UserDataProvider userDataProvider = new UserDataProvider() { // from class: com.myscript.nebo.editing.EditingActivity$userDataProvider$1
        @Override // com.myscript.nebo.p022ai.presentation.compose.UserDataProvider
        public boolean hasUser() {
            ComponentCallbacks2 application = this.this$0.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
            return ((UserData.Provider) application).provideUserData().hasUser();
        }

        @Override // com.myscript.nebo.p022ai.presentation.compose.UserDataProvider
        public boolean requiresSignIn() {
            return !RetailMode.INSTANCE.isEnabled();
        }
    };
    private final ActivityResultLauncher<Intent> aiSignInActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda66
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            EditingActivity.aiSignInActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final EditingActivity$aiTextSelectionProvider$1 aiTextSelectionProvider = new EditingActivity$aiTextSelectionProvider$1(this);

    /* JADX INFO: renamed from: crashCountState$delegate, reason: from kotlin metadata */
    private final Lazy crashCountState = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda44
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EditingActivity.crashCountState_delegate$lambda$0(this.f$0);
        }
    });
    private final EditingActivity$syncListener$1 syncListener = new LibraryRepository.SyncListener() { // from class: com.myscript.nebo.editing.EditingActivity$syncListener$1
        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void autoSyncSettingChanged() {
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void refreshProgress(int amountDone, int totalAmount) {
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void syncPrepareProgress(int amountDone, int totalAmount) {
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void syncProgress(int amountDone, int totalAmount) {
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void syncProgress(NotebookKey folderSyncing, int amountDone, int totalAmount) {
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void syncStateChanged(DMSSyncState state, int impactedFolderCount, LibraryRepository.SyncFailureReason failureReason) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        }

        @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
        public void conflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2s) {
            Intrinsics.checkNotNullParameter(duplicatedPageKeys, "duplicatedPageKeys");
            Intrinsics.checkNotNullParameter(duplicatedPageKeys2s, "duplicatedPageKeys2s");
            IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
            if (paginatedContainer instanceof NotebookManager) {
                List<com.myscript.snt.dms.PageProperties> listPages = ((NotebookManager) paginatedContainer).pages();
                List<? extends PageKey> list = duplicatedPageKeys;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return;
                }
                for (PageKey pageKey : list) {
                    Intrinsics.checkNotNull(listPages);
                    List<com.myscript.snt.dms.PageProperties> list2 = listPages;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((com.myscript.snt.dms.PageProperties) it.next()).getPageId(), pageKey.uuid())) {
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new EditingActivity$syncListener$1$conflictedPageCopies$2(this.this$0, duplicatedPageKeys, null), 3, null);
                                return;
                            }
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: renamed from: searchHistoryAdapter$delegate, reason: from kotlin metadata */
    private final Lazy searchHistoryAdapter = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda55
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EditingActivity.searchHistoryAdapter_delegate$lambda$0(this.f$0);
        }
    });
    private final MutableState<Boolean> showPaywallDialog = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private int formerPagerPosition = -1;
    private final FragmentStateAdapter childPagesPagerAdapter = new FragmentStateAdapter() { // from class: com.myscript.nebo.editing.EditingActivity$childPagesPagerAdapter$1
        {
            super(this.this$0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
            if (paginatedContainer instanceof NotebookManager) {
                return (int) ((NotebookManager) paginatedContainer).pageCount();
            }
            return 1;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            PageKey pageKeyCreateKeyFromUuid;
            IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
            if (!(paginatedContainer instanceof NotebookManager)) {
                pageKeyCreateKeyFromUuid = this.this$0.openNoteKey;
                if (pageKeyCreateKeyFromUuid == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKeyCreateKeyFromUuid = null;
                }
            } else {
                pageKeyCreateKeyFromUuid = PageKey.createKeyFromUuid(((NotebookManager) paginatedContainer).pageAt(((long) position) + 1));
            }
            PageFragment.Companion companion = PageFragment.INSTANCE;
            Intrinsics.checkNotNull(pageKeyCreateKeyFromUuid);
            PageFragment pageFragmentNewInstance = companion.newInstance(pageKeyCreateKeyFromUuid, this.this$0.tryReloadPageNextTime);
            this.this$0.tryReloadPageNextTime = false;
            return pageFragmentNewInstance;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            int iHashCode;
            if (position > getItemCount()) {
                return -1L;
            }
            IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
            if (!(paginatedContainer instanceof NotebookManager)) {
                PageKey pageKey = this.this$0.openNoteKey;
                if (pageKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey = null;
                }
                iHashCode = pageKey.uuid().hashCode();
            } else {
                iHashCode = ((NotebookManager) paginatedContainer).pageAt(((long) position) + 1).hashCode();
            }
            return iHashCode;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public boolean containsItem(long itemId) {
            IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
            if (!(paginatedContainer instanceof NotebookManager)) {
                PageKey pageKey = this.this$0.openNoteKey;
                if (pageKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey = null;
                }
                return ((long) pageKey.uuid().hashCode()) == itemId;
            }
            List<com.myscript.snt.dms.PageProperties> listPages = ((NotebookManager) paginatedContainer).pages();
            Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
            List<com.myscript.snt.dms.PageProperties> list = listPages;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((com.myscript.snt.dms.PageProperties) it.next()).getPageId().hashCode() == itemId) {
                    return true;
                }
            }
            return false;
        }
    };
    private final EditingActivity$onChildPagesPagerUpdate$1 onChildPagesPagerUpdate = new EditingActivity$onChildPagesPagerUpdate$1(this);
    private Pair<String, Boolean> scrollToBottom = new Pair<>("", false);
    private final EditingActivity$onZoomIndicatorUpdate$1 onZoomIndicatorUpdate = new ZoomIndicatorView.ZoomIndicatorListener() { // from class: com.myscript.nebo.editing.EditingActivity$onZoomIndicatorUpdate$1
        @Override // com.myscript.nebo.editing.zoom.ZoomIndicatorView.ZoomIndicatorListener
        public void onZoomIndicatorClicked() {
            PageFragment pageFragment = this.this$0.getPageFragment();
            if (pageFragment != null) {
                pageFragment.zoom(1.0f);
            }
        }

        @Override // com.myscript.nebo.editing.zoom.ZoomIndicatorView.ZoomIndicatorListener
        public void onLockButtonClicked() {
            PageFragment pageFragment = this.this$0.getPageFragment();
            if (pageFragment != null) {
                pageFragment.toggleLockZoom();
            }
        }
    };
    private final EditingActivity$pageUpdateProvider$1 pageUpdateProvider = new SharePageDialog.PageUpdateProvider() { // from class: com.myscript.nebo.editing.EditingActivity$pageUpdateProvider$1
        @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.PageUpdateProvider
        public void setCallback(SharePageDialog.PageUpdateProviderCallback callback) {
            this.this$0.pageUpdateProviderCallback = callback;
        }
    };
    private final IStylusDoubleTapListener onStylusDoubleTap = new IStylusDoubleTapListener() { // from class: com.myscript.nebo.editing.EditingActivity$onStylusDoubleTap$1

        /* JADX INFO: compiled from: EditingActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[StylusSwitchBehavior.values().length];
                try {
                    iArr[StylusSwitchBehavior.CURRENT_AND_ERASER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StylusSwitchBehavior.CURRENT_AND_TOOL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[StylusSwitchBehavior.COLOR_PALETTE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[StylusSwitchBehavior.NONE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // com.myscript.nebo.editing.IStylusDoubleTapListener
        public void stylusDoubleTap(StylusSwitchBehavior mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                this.this$0.getToolbarViewModel().switchBetweenEraserAndPreviousTool();
                return;
            }
            if (i == 2) {
                this.this$0.getToolbarViewModel().switchToPreviousTool();
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                PenFragment penFragment = this.this$0.penFragment;
                if (penFragment != null) {
                    penFragment.toggleColorPicker();
                }
            }
        }
    };
    private final EditingActivity$menuProvider$1 menuProvider = new MenuProvider() { // from class: com.myscript.nebo.editing.EditingActivity$menuProvider$1
        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
            menuInflater.inflate(C6079R.menu.editing_view_more_menu, menu);
            if (this.this$0.getResources().getBoolean(C6079R.bool.show_debug_menu)) {
                menuInflater.inflate(C6079R.menu.editing_view_debug_more_menu, menu);
            }
            this.this$0.setupSearch(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public void onPrepareMenu(Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            MenuItem menuItemFindItem = menu.findItem(C6079R.id.editing_view_more_menu_export);
            if (menuItemFindItem != null) {
                EditingActivity editingActivity = this.this$0;
                LibraryRepository libraryRepository = editingActivity.getLibraryRepository();
                PageKey pageKey = editingActivity.openNoteKey;
                if (pageKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey = null;
                }
                menuItemFindItem.setEnabled(libraryRepository.canExport(CollectionsKt.listOf(pageKey)));
            }
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == 16908332) {
                this.this$0.homePressed();
                return true;
            }
            if (itemId == C6079R.id.editing_update_page_title) {
                TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), EditingActivity.TAG, "Note name dialog from Menu", null, 4, null);
                this.this$0.requestNewNoteName();
                return true;
            }
            if (itemId != C6079R.id.editing_view_more_menu_export) {
                return false;
            }
            this.this$0.openExportDialog();
            return true;
        }
    };

    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SelectionState.values().length];
            try {
                iArr[SelectionState.INLINE_SELECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectionState.INLINE_SELECTION_PDF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SelectionState.SELECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MessageIdentifier.values().length];
            try {
                iArr2[MessageIdentifier.PAGE_ITEM_SOFT_LIMIT_REACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MessageIdentifier.PAGE_ITEM_HARD_LIMIT_REACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MessageIdentifier.PAGE_ITEM_LIMIT_OK.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MessageIdentifier.LIMIT_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MessageIdentifier.SNAPPING_ROTATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[MessageIdentifier.SNAPPING_ALIGNMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MessageIdentifier.SNAPPING_CONNECTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ void getPageController$annotations() {
    }

    @JvmStatic
    public static final Intent getPageIntent(Context context, PageKey pageKey, String str) {
        return INSTANCE.getPageIntent(context, pageKey, str);
    }

    @Override // com.myscript.nebo.sso.IHelpUsConsumer
    public boolean canShowHelpUsDialog() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.myscript.nebo.editing.EditingActivity$syncListener$1] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.myscript.nebo.editing.EditingActivity$onZoomIndicatorUpdate$1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.myscript.nebo.editing.EditingActivity$pageUpdateProvider$1] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.myscript.nebo.editing.EditingActivity$menuProvider$1] */
    public EditingActivity() {
        final EditingActivity editingActivity = this;
        final Function0 function0 = null;
        this.aiContainerViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AIContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda68
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.aiContainerViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.aiExplainViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AIExplainViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda69
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.aiExplainViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.aiSummarizeViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AISummarizeViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda70
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.aiSummarizeViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.aiQuizViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AIQuizViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.aiQuizViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.bannerViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(BannerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return editingActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.toolbarViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ToolbarViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.toolbarViewModel_delegate$lambda$0(this.f$0);
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.searchViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SearchPageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.searchViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.noteEditorViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NoteEditorViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.noteEditorViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.childPagesViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ChildPagesViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.childPagesViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.paywallViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaywallViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.paywallViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.freemiumLimitationViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return editingActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.EditingActivity$special$$inlined$viewModels$default$33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? editingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(EditingActivity editingActivity) {
        ComponentCallbacks2 application = editingActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aiSignInActivityLauncher$lambda$0(EditingActivity editingActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (editingActivity.userDataProvider.hasUser()) {
            editingActivity.getAiContainerViewModel().onSignInSuccess();
        } else {
            editingActivity.getAiContainerViewModel().onSignInCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIContainerViewModel getAiContainerViewModel() {
        return (AIContainerViewModel) this.aiContainerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory aiContainerViewModel_delegate$lambda$0() {
        return AIContainerViewModel.INSTANCE.getFactory();
    }

    private final AIExplainViewModel getAiExplainViewModel() {
        return (AIExplainViewModel) this.aiExplainViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory aiExplainViewModel_delegate$lambda$0() {
        return AIExplainViewModel.INSTANCE.getFactory();
    }

    private final AISummarizeViewModel getAiSummarizeViewModel() {
        return (AISummarizeViewModel) this.aiSummarizeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory aiSummarizeViewModel_delegate$lambda$0() {
        return AISummarizeViewModel.INSTANCE.getFactory();
    }

    private final AIQuizViewModel getAiQuizViewModel() {
        return (AIQuizViewModel) this.aiQuizViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory aiQuizViewModel_delegate$lambda$0() {
        return AIQuizViewModel.INSTANCE.getFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIAnalyticsOrigin getAIAnalyticsOrigin(PageController pageController) {
        String strPageType = pageController.pageType();
        if (Intrinsics.areEqual(strPageType, ContentTypes.PDF)) {
            return AIAnalyticsOrigin.PDF;
        }
        if (Intrinsics.areEqual(strPageType, ContentTypes.TEXT_DOCUMENT)) {
            return AIAnalyticsOrigin.TEXT_DOCUMENT;
        }
        if (Intrinsics.areEqual(strPageType, ContentTypes.RAW_CONTENT)) {
            return this.isContainer ? AIAnalyticsOrigin.NOTEBOOK : AIAnalyticsOrigin.RAW_CONTENT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAIAnalyticsSelectionType(PageController pageController) {
        boolean z = pageController.currentToolType() == ToolType.Lasso && !Intrinsics.areEqual(pageController.pageType(), ContentTypes.TEXT_DOCUMENT);
        SelectionState selectionState = pageController.selectionState();
        int i = selectionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[selectionState.ordinal()];
        if (i == 1 || i == 2) {
            return "inline_selection";
        }
        if (i != 3) {
            return "";
        }
        return z ? "lasso_selection" : "tap_selection";
    }

    private final BannerViewModel getBannerViewModel() {
        return (BannerViewModel) this.bannerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ToolbarViewModel getToolbarViewModel() {
        return (ToolbarViewModel) this.toolbarViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory toolbarViewModel_delegate$lambda$0(EditingActivity editingActivity) {
        String stringExtra = editingActivity.getIntent().getStringExtra(PAGE_CONTENT_TYPE_ARGUMENT);
        if (stringExtra == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return new ToolbarViewModelFactory(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchPageViewModel getSearchViewModel() {
        return (SearchPageViewModel) this.searchViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory searchViewModel_delegate$lambda$0() {
        return SearchPageViewModel.INSTANCE.getFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NoteEditorViewModel getNoteEditorViewModel() {
        return (NoteEditorViewModel) this.noteEditorViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory noteEditorViewModel_delegate$lambda$0() {
        return NoteEditorViewModel.INSTANCE.getFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChildPagesViewModel getChildPagesViewModel() {
        return (ChildPagesViewModel) this.childPagesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory childPagesViewModel_delegate$lambda$0() {
        return ChildPagesViewModel.INSTANCE.getFactory();
    }

    private final PaywallViewModel getPaywallViewModel() {
        return (PaywallViewModel) this.paywallViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory paywallViewModel_delegate$lambda$0() {
        return new PaywallViewModel.Factory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    private final ICrashCountState getCrashCountState() {
        return (ICrashCountState) this.crashCountState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationState crashCountState_delegate$lambda$0(EditingActivity editingActivity) {
        ComponentCallbacks2 application = editingActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        return ((IApplicationStateProvider) application).provideApplicationState();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!getUserData().isNewPrivacyAccepted() && getUserData().hasUser()) {
            Session.needToUpdatePrivacyPolicy = true;
            MainThreadBus.eventBus.post(OnUpdatePrivacyPolicyNeededEvent.UNIQUE);
        }
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.account.UserProfileManager.Provider");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C63651(((UserProfileManager.Provider) application).provideUserProfileManager(), null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onResume$1 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$onResume$1", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {433}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {434}, m1615s = {}, m1616v = 2)
    static final class C63651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserProfileManager $userProfileManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63651(UserProfileManager userProfileManager, Continuation<? super C63651> continuation) {
            super(2, continuation);
            this.$userProfileManager = userProfileManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63651(this.$userProfileManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final PageFragment getPageFragment() {
        ViewPager2 viewPager2 = this.childPagesViewPager;
        return getFragmentAtPosition(viewPager2 != null ? viewPager2.getCurrentItem() : 0);
    }

    public final PageController getPageController() {
        PageFragment pageFragment = getPageFragment();
        if (pageFragment != null) {
            return pageFragment.getPageController();
        }
        return null;
    }

    private final HistoryAdapter getSearchHistoryAdapter() {
        return (HistoryAdapter) this.searchHistoryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HistoryAdapter searchHistoryAdapter_delegate$lambda$0(EditingActivity editingActivity) {
        return new HistoryAdapter(editingActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragmentTagAtPosition(int position) {
        RecyclerView.Adapter adapter;
        ViewPager2 viewPager2 = this.childPagesViewPager;
        if (viewPager2 == null || (adapter = viewPager2.getAdapter()) == null) {
            return null;
        }
        return "f" + adapter.getItemId(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PageFragment getFragmentAtPosition(int position) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(getFragmentTagAtPosition(position));
        if (fragmentFindFragmentByTag instanceof PageFragment) {
            return (PageFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAIEvent(AIContainerEvent event) {
        EditingController editingController;
        ITouchFeature touchFeatureImpl;
        PointerInfo pointerInfo;
        if (event instanceof AIContainerEvent.UpdateAvailableActions) {
            AIContainerViewModel.updateAvailableActions$default(getAiContainerViewModel(), null, 1, null);
            return;
        }
        if (event instanceof AIContainerEvent.SummarizeClick) {
            getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$0(this.f$0);
                }
            });
            return;
        }
        if (event instanceof AIContainerEvent.ExplainClick) {
            getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$1(this.f$0);
                }
            });
            return;
        }
        if (event instanceof AIContainerEvent.ExplainClose) {
            getAiContainerViewModel().setMode(AIMode.NONE);
            getAiExplainViewModel().closeExplain();
            return;
        }
        if (event instanceof AIContainerEvent.SummarizeClose) {
            getAiContainerViewModel().setMode(AIMode.NONE);
            getAiSummarizeViewModel().closeSummarize();
            return;
        }
        if (event instanceof AIContainerEvent.SummarizeCurrentPage) {
            Function0<Unit> function0 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$2(this.f$0);
                }
            };
            getAiContainerViewModel().saveLastOperation(function0);
            function0.invoke();
            return;
        }
        if (event instanceof AIContainerEvent.SummarizeSelectPages) {
            getAiSummarizeViewModel().closeNoteInput();
            ManagePagesDialog managePagesDialogNewInstance$default = ManagePagesDialog.Companion.newInstance$default(ManagePagesDialog.INSTANCE, true, false, 2, null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            managePagesDialogNewInstance$default.show(supportFragmentManager);
            return;
        }
        if (event instanceof AIContainerEvent.SummarizeAllPages) {
            Function0<Unit> function02 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$3(this.f$0);
                }
            };
            getAiContainerViewModel().saveLastOperation(function02);
            function02.invoke();
            return;
        }
        if (event instanceof AIContainerEvent.ShortenResult) {
            getAiSummarizeViewModel().shortenText();
            return;
        }
        if (event instanceof AIContainerEvent.TryAgainClick) {
            getAiContainerViewModel().triggerLastOperation();
            return;
        }
        if (event instanceof AIContainerEvent.CopyResult) {
            Object systemService = getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("AI generated text", ((AIContainerEvent.CopyResult) event).getText()));
            return;
        }
        if (event instanceof AIContainerEvent.AddToNote) {
            String text = ((AIContainerEvent.AddToNote) event).getText();
            PageController pageController = getPageController();
            if (pageController != null) {
                ViewTransform viewTransform = pageController;
                try {
                    PageController pageController2 = viewTransform;
                    PageFragment pageFragment = getPageFragment();
                    if (pageFragment != null && (editingController = pageFragment.getEditingController()) != null && (touchFeatureImpl = editingController.getTouchFeatureImpl()) != null) {
                        if (Intrinsics.areEqual(pageController2.pageType(), ContentTypes.PDF) || (!this.isContainer && Intrinsics.areEqual(pageController2.pageType(), ContentTypes.RAW_CONTENT))) {
                            PointerInfo pointerInfo2 = new PointerInfo(touchFeatureImpl.getScreenVisibleArea().centerX(), touchFeatureImpl.getScreenVisibleArea().centerY());
                            pageController2.unsetCursor(1);
                            pageController2.setCursorPosition(0, pointerInfo2, true);
                            pageController2.insertText(text, -1, -1, true);
                        } else {
                            float fLineHeight = pageController2.getGrid().lineHeight() * 3.0f;
                            Extent extentSelectionExtent = pageController2.hasSelection() ? pageController2.selectionExtent() : pageController2.contentExtent();
                            if (extentSelectionExtent.valid()) {
                                pageController2.getGrid().lineHeight();
                                pointerInfo = new PointerInfo(extentSelectionExtent.getXMin(), extentSelectionExtent.getYMax() + fLineHeight);
                            } else {
                                Extent paperExtent = touchFeatureImpl.getPaperExtent();
                                pointerInfo = new PointerInfo(fLineHeight, (paperExtent.getYMax() - paperExtent.getYMin()) / 2);
                            }
                            viewTransform = pageController2.getViewTransform();
                            try {
                                pageController2.unsetCursor(1);
                                pageController2.setCursorPosition(0, viewTransform.map(pointerInfo), true);
                                pageController2.insertText(text, -1, -1, true);
                                Unit unit = Unit.INSTANCE;
                                AutoCloseableKt.closeFinally(viewTransform, null);
                            } finally {
                            }
                        }
                    }
                    getAiContainerViewModel().setMode(AIMode.NONE);
                    getAiSummarizeViewModel().closeSummarize();
                    getAiExplainViewModel().closeExplain();
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(viewTransform, null);
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            return;
        }
        if (event instanceof AIContainerEvent.QuizDisclaimerAccepted) {
            getAiQuizViewModel().onDisclaimerAccepted();
            return;
        }
        if (event instanceof AIContainerEvent.QuizDisclaimerDismissed) {
            getAiContainerViewModel().setMode(AIMode.NONE);
            getAiQuizViewModel().onDisclaimerDismissed();
            return;
        }
        if (event instanceof AIContainerEvent.QuizClick) {
            getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$5(this.f$0);
                }
            });
            return;
        }
        if (event instanceof AIContainerEvent.CloseQuiz) {
            getAiContainerViewModel().setMode(AIMode.NONE);
            getAiQuizViewModel().closeQuiz();
            return;
        }
        if (event instanceof AIContainerEvent.QuizCurrentPage) {
            Function0<Unit> function03 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$6(this.f$0);
                }
            };
            getAiContainerViewModel().saveLastOperation(function03);
            function03.invoke();
            return;
        }
        if (event instanceof AIContainerEvent.QuizAllPages) {
            Function0<Unit> function04 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.handleAIEvent$lambda$7(this.f$0);
                }
            };
            getAiContainerViewModel().saveLastOperation(function04);
            function04.invoke();
            return;
        }
        if (event instanceof AIContainerEvent.QuizSelectPages) {
            getAiQuizViewModel().closeNoteInput();
            ManagePagesDialog managePagesDialogNewInstance$default2 = ManagePagesDialog.Companion.newInstance$default(ManagePagesDialog.INSTANCE, false, true, 1, null);
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            managePagesDialogNewInstance$default2.show(supportFragmentManager2);
            return;
        }
        if (event instanceof AIContainerEvent.TrueOrFalseClick) {
            getAiQuizViewModel().onQuizModeSelected(QuizMode.TRUE_FALSE);
            return;
        }
        if (event instanceof AIContainerEvent.MultipleChoiceClick) {
            getAiQuizViewModel().onQuizModeSelected(QuizMode.MULTIPLE_CHOICE);
            return;
        }
        if (event instanceof AIContainerEvent.AnswerQuestionClick) {
            getAiQuizViewModel().answerQuestion(((AIContainerEvent.AnswerQuestionClick) event).getAnswer());
            return;
        }
        if (event instanceof AIContainerEvent.NextQuestionClick) {
            getAiQuizViewModel().nextQuestion();
            return;
        }
        if (event instanceof AIContainerEvent.NextQuestionsClick) {
            getAiQuizViewModel().nextQuestions();
            return;
        }
        if (event instanceof AIContainerEvent.QuizTryAgainClick) {
            getAiQuizViewModel().tryAgain();
            return;
        }
        if (event instanceof AIContainerEvent.HideNoteClick) {
            getAiQuizViewModel().toggleHideNote();
            return;
        }
        if (event instanceof AIContainerEvent.AIButtonPositionChanged) {
            this.aiButtonRect = ((AIContainerEvent.AIButtonPositionChanged) event).getTargetRect();
            updateDiscoveryTooltip(getNoteEditorViewModel().getDiscoveryTooltip().getValue());
        } else if (event instanceof AIContainerEvent.FabClickHook) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C63525(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$0(final EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.SUMMARIZE);
        Function0<Unit> function0 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.handleAIEvent$lambda$0$0(this.f$0);
            }
        };
        editingActivity.getAiContainerViewModel().saveLastOperation(function0);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$0$0(EditingActivity editingActivity) {
        editingActivity.getAiSummarizeViewModel().summarizeText(AISummarizeTrigger.BUTTON);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$1(final EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.EXPLAIN);
        Function0<Unit> function0 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.handleAIEvent$lambda$1$0(this.f$0);
            }
        };
        editingActivity.getAiContainerViewModel().saveLastOperation(function0);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$1$0(EditingActivity editingActivity) {
        editingActivity.getAiExplainViewModel().explainText(AIExplainTrigger.BUTTON);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$2(EditingActivity editingActivity) {
        AISummarizeViewModel.summarizeCurrentPage$default(editingActivity.getAiSummarizeViewModel(), null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$3(EditingActivity editingActivity) {
        AISummarizeViewModel.summarizeAllPages$default(editingActivity.getAiSummarizeViewModel(), null, null, 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$5(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.QUIZ);
        editingActivity.getAiQuizViewModel().startQuizGeneration();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$6(EditingActivity editingActivity) {
        editingActivity.getAiQuizViewModel().onSourceSelectedCurrentPage();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAIEvent$lambda$7(EditingActivity editingActivity) {
        editingActivity.getAiQuizViewModel().onSourceSelectedAllPages();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$handleAIEvent$5 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$handleAIEvent$5", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63525 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63525(Continuation<? super C63525> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditingActivity.this.new C63525(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63525) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FreemiumLimitationViewModel freemiumLimitationViewModel = EditingActivity.this.getFreemiumLimitationViewModel();
                FreemiumLimitationTrigger freemiumLimitationTrigger = FreemiumLimitationTrigger.TRIGGER_AI_TAP_ON_BUTTON;
                final EditingActivity editingActivity = EditingActivity.this;
                freemiumLimitationViewModel.tryUsePremiumFeature(freemiumLimitationTrigger, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$handleAIEvent$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.C63525.invokeSuspend$lambda$0(editingActivity);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(EditingActivity editingActivity) {
            AIMode value = editingActivity.getAiContainerViewModel().getMode().getValue();
            Boolean value2 = editingActivity.getAiContainerViewModel().getShowMenu().getValue();
            if (value == AIMode.MINIMIZED) {
                editingActivity.getAiContainerViewModel().restoreLastMode();
            } else if (value != AIMode.NONE) {
                editingActivity.getAiContainerViewModel().setMode(AIMode.MINIMIZED);
            } else if (Intrinsics.areEqual((Object) value2, (Object) true)) {
                editingActivity.getAiContainerViewModel().toggleMenuVisibility();
            } else {
                editingActivity.getAiContainerViewModel().toggleMenuVisibility();
            }
            AIContainerViewModel.updateAvailableActions$default(editingActivity.getAiContainerViewModel(), null, 1, null);
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        PageKey pageKeyDeserialize;
        PageKey pageKey;
        View viewFindViewById;
        super.onCreate(savedInstanceState);
        setContentView(C6079R.layout.editing_activity);
        this.childPagesViewPager = (ViewPager2) findViewById(C6079R.id.page_fragment_view_pager);
        View viewFindViewById2 = findViewById(C6079R.id.page_indicator_widget);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.childPagesNavigationWidget = (PageIndicator) viewFindViewById2;
        GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(C6079R.id.page_fragment_view_pager_touch_overlay);
        this.swipeTouchOverlay = gestureOverlayView;
        if (gestureOverlayView != null) {
            gestureOverlayView.setGestureVisible(false);
            Unit unit = Unit.INSTANCE;
        }
        String stringExtra = getIntent().getStringExtra(PAGE_KEY_ARGUMENT);
        if (stringExtra == null || (pageKeyDeserialize = PageKey.deserialize(stringExtra)) == null) {
            throw new IllegalStateException("Page key is required".toString());
        }
        this.openNoteKey = pageKeyDeserialize;
        NoteEditorViewModel noteEditorViewModel = getNoteEditorViewModel();
        PageKey pageKey2 = this.openNoteKey;
        if (pageKey2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
            pageKey2 = null;
        }
        noteEditorViewModel.openNote(pageKey2);
        View viewFindViewById3 = findViewById(C6079R.id.editing_activity_toolbar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.toolbar = (MaterialToolbar) viewFindViewById3;
        View viewFindViewById4 = findViewById(C6079R.id.content_constraint_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.editingContentConstraintLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(C6079R.id.child_pages_side_panel_guideline);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.sidePanelGuideline = (Guideline) viewFindViewById5;
        MaterialToolbar materialToolbar = this.toolbar;
        if (materialToolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            materialToolbar = null;
        }
        setSupportActionBar(materialToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        int i = -1;
        if (supportActionBar != null) {
            ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1);
            LayoutInflater layoutInflater = getLayoutInflater();
            int i2 = C6079R.layout.editing_toolbar_title;
            MaterialToolbar materialToolbar2 = this.toolbar;
            if (materialToolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                materialToolbar2 = null;
            }
            View viewInflate = layoutInflater.inflate(i2, (ViewGroup) materialToolbar2, false);
            supportActionBar.setDisplayShowTitleEnabled(false);
            supportActionBar.setCustomView(viewInflate, layoutParams);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
        }
        NewFeatureVisibilityHelper newFeatureVisibilityHelper = NewFeatureVisibilityHelper.INSTANCE;
        MaterialToolbar materialToolbar3 = this.toolbar;
        if (materialToolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            materialToolbar3 = null;
        }
        newFeatureVisibilityHelper.chooseOverflowIconForNewFeatures(materialToolbar3);
        if (RetailMode.INSTANCE.isEnabled() && (viewFindViewById = findViewById(C6079R.id.retail_qr_toolbar_badge)) != null) {
            viewFindViewById.setVisibility(0);
            Unit unit4 = Unit.INSTANCE;
        }
        View viewFindViewById6 = findViewById(C6079R.id.editing_view_banner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        BannerLayout bannerLayout = (BannerLayout) viewFindViewById6;
        this.bannerLayout = bannerLayout;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout = null;
        }
        bannerLayout.setCallback(getBannerViewModel());
        String stringExtra2 = getIntent().getStringExtra(PAGE_CONTENT_TYPE_ARGUMENT);
        if (stringExtra2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        findDebugView();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(PenFragment.TAG);
        PenFragment penFragmentNewInstance = fragmentFindFragmentByTag instanceof PenFragment ? (PenFragment) fragmentFindFragmentByTag : null;
        if (penFragmentNewInstance == null) {
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            String strShowKeyboardOnTapKey = NeboKeyboardSettings.showKeyboardOnTapKey(application);
            Application application2 = getApplication();
            Intrinsics.checkNotNullExpressionValue(application2, "getApplication(...)");
            penFragmentNewInstance = PenFragment.INSTANCE.newInstance(stringExtra2, strShowKeyboardOnTapKey, NeboKeyboardSettings.showKeyboardOnTapDefaultValue(application2));
        }
        this.penFragment = penFragmentNewInstance;
        if (penFragmentNewInstance != null) {
            if (!penFragmentNewInstance.isAdded()) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.replace(C6079R.id.editing_activity_secondary_toolbar, penFragmentNewInstance, PenFragment.TAG);
                fragmentTransactionBeginTransaction.commit();
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        Fragment fragmentFindFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(ChildPagesFragment.TAG);
        ChildPagesFragment childPagesFragment = fragmentFindFragmentByTag2 instanceof ChildPagesFragment ? (ChildPagesFragment) fragmentFindFragmentByTag2 : null;
        if (childPagesFragment == null) {
            childPagesFragment = null;
        } else if (!childPagesFragment.isAdded()) {
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction2 = supportFragmentManager2.beginTransaction();
            fragmentTransactionBeginTransaction2.replace(C6079R.id.child_pages_side_panel, childPagesFragment, ChildPagesFragment.TAG);
            fragmentTransactionBeginTransaction2.commit();
        }
        this.childPagesFragment = childPagesFragment;
        getChildPagesViewModel().setThumbnailWidthInPixels(getResources().getDimensionPixelSize(C6079R.dimen.child_pages_side_panel_width_large));
        View viewFindViewById7 = findViewById(C6079R.id.search_results_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.searchResultsToolbar = viewFindViewById7;
        View viewFindViewById8 = findViewById(C6079R.id.hits);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.hitsSearchTextView = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(C6079R.id.secondary_toolbar_search_progressBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.searchProgress = viewFindViewById9;
        View viewFindViewById10 = findViewById(C6079R.id.nav_hits);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.navHitsSearchTextView = (TextView) viewFindViewById10;
        View viewFindViewById11 = findViewById(C6079R.id.search_previous);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.searchPreviousButton = viewFindViewById11;
        View viewFindViewById12 = findViewById(C6079R.id.search_next);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.searchNextButton = viewFindViewById12;
        View viewFindViewById13 = findViewById(C6079R.id.zoom_indicator_panel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.zoomIndicatorPanel = (ZoomIndicatorView) viewFindViewById13;
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
        LiveData<Banner> currentPermanentBanner = getBannerViewModel().getCurrentPermanentBanner();
        EditingActivity editingActivity = this;
        BannerLayout bannerLayout2 = this.bannerLayout;
        if (bannerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout2 = null;
        }
        currentPermanentBanner.observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C63637(bannerLayout2)));
        LiveData<Banner> currentTransientBanner = getBannerViewModel().getCurrentTransientBanner();
        BannerLayout bannerLayout3 = this.bannerLayout;
        if (bannerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout3 = null;
        }
        currentTransientBanner.observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C63648(bannerLayout3)));
        getToolbarViewModel().getToolbarConfiguration().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$5(this.f$0, (ToolbarConfiguration) obj);
            }
        }));
        getToolbarViewModel().getSelectedToolType().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$6(this.f$0, (ToolType) obj);
            }
        }));
        getSupportFragmentManager().setFragmentResultListener(ToolConfigurationDialogFragment.RESULT_WRITING_KEY, editingActivity, new FragmentResultListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda56
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                EditingActivity.onCreate$lambda$7(this.f$0, str, bundle);
            }
        });
        getSearchViewModel().showCurrentHitNextPageBinding(true);
        getSearchViewModel().getSearchState().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C635612(this)));
        getSearchViewModel().getHistory().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C635713(this)));
        getSearchViewModel().getPageIdToShow().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C635814(this)));
        getSearchViewModel().getHitNavState().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C635915(this)));
        IPaginatedContainer paginatedContainer = getChildPagesViewModel().getPaginatedContainer();
        if (paginatedContainer == null) {
            LibraryRepository libraryRepository = getLibraryRepository();
            PageKey pageKey3 = this.openNoteKey;
            if (pageKey3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                pageKey3 = null;
            }
            IPaginatedContainer iPaginatedContainerBuildNotebookManager = libraryRepository.buildNotebookManager(pageKey3);
            if (iPaginatedContainerBuildNotebookManager != null) {
                List<com.myscript.snt.dms.PageProperties> listPages = iPaginatedContainerBuildNotebookManager.pages();
                LibraryRepository libraryRepository2 = getLibraryRepository();
                PageKey pageKey4 = this.openNoteKey;
                if (pageKey4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey4 = null;
                }
                PageKey pageKeyLastOpenedPage = libraryRepository2.lastOpenedPage(pageKey4);
                if (pageKeyLastOpenedPage != null) {
                    Intrinsics.checkNotNull(listPages);
                    Iterator<com.myscript.snt.dms.PageProperties> it = listPages.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (Intrinsics.areEqual(it.next().getPageId(), pageKeyLastOpenedPage.uuid())) {
                            i = i3;
                            break;
                        }
                        i3++;
                    }
                } else {
                    i = 0;
                }
                Integer numValueOf = Integer.valueOf(i + 1);
                numValueOf.intValue();
                if (i < 0 || i >= listPages.size()) {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : 1;
                Intrinsics.checkNotNull(listPages);
                if (!listPages.isEmpty()) {
                    iPaginatedContainerBuildNotebookManager.selectPage(iPaginatedContainerBuildNotebookManager.pageAt(iIntValue), false);
                } else {
                    TechnicalLogger logger = getLogger();
                    PageKey pageKey5 = this.openNoteKey;
                    if (pageKey5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                        pageKey5 = null;
                    }
                    logger.logError(new IllegalStateException("Notebook has no pages: " + pageKey5.uuid()));
                }
                ChildPagesViewModel childPagesViewModel = getChildPagesViewModel();
                PageKey pageKey6 = this.openNoteKey;
                if (pageKey6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey = null;
                } else {
                    pageKey = pageKey6;
                }
                ChildPagesViewModel.bindPaginatedContainer$default(childPagesViewModel, iPaginatedContainerBuildNotebookManager, pageKey, false, 4, null);
                ICrashCountState crashCountState = getCrashCountState();
                PageKey pageKey7 = this.openNoteKey;
                if (pageKey7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey7 = null;
                }
                crashCountState.setNoteCrashCountKey(pageKey7.uuid());
                paginatedContainer = iPaginatedContainerBuildNotebookManager;
            } else {
                paginatedContainer = null;
            }
        }
        boolean z = paginatedContainer instanceof NotebookManager;
        this.isContainer = z;
        if (z) {
            PageIndicator pageIndicator = this.childPagesNavigationWidget;
            if (pageIndicator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childPagesNavigationWidget");
                pageIndicator = null;
            }
            pageIndicator.setSidePanelToggleListener(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.onCreate$lambda$9(this.f$0);
                }
            });
        }
        GestureOverlayView gestureOverlayView2 = this.swipeTouchOverlay;
        if (gestureOverlayView2 != null) {
            gestureOverlayView2.setEnabled(this.isContainer);
            Unit unit7 = Unit.INSTANCE;
        }
        ViewPager2 viewPager2 = this.childPagesViewPager;
        if (viewPager2 != null) {
            viewPager2.setUserInputEnabled(this.isContainer);
            viewPager2.setNestedScrollingEnabled(this.isContainer);
            viewPager2.setAdapter(this.childPagesPagerAdapter);
            viewPager2.registerOnPageChangeCallback(this.onChildPagesPagerUpdate);
        }
        getNoteEditorViewModel().getNoteProperties().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C636018(this)));
        getNoteEditorViewModel().getDiscoveryTooltip().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new C636119(this)));
        getNoteEditorViewModel().getCloudTokenExpiredNotification().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$11(this.f$0, (Boolean) obj);
            }
        }));
        getChildPagesViewModel().getChildPages().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$12(this.f$0, (ImmutableList) obj);
            }
        }));
        getChildPagesViewModel().getChildPagesNavigationState().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$13(this.f$0, (ChildPagesNavigationState) obj);
            }
        }));
        getChildPagesViewModel().isChildPagesPanelVisible().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$14(this.f$0, (ChildPagesPanelVisibilityState) obj);
            }
        }));
        getSupportFragmentManager().setFragmentResultListener(NoteNameDialog.REQUEST_KEY, editingActivity, new FragmentResultListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda62
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                EditingActivity.onCreate$lambda$15(this.f$0, str, bundle);
            }
        });
        getSupportFragmentManager().setFragmentResultListener(PageBackgroundFragment.PAGE_BACKGROUND_REQUEST_KEY, editingActivity, new FragmentResultListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda63
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                EditingActivity.onCreate$lambda$16(this.f$0, str, bundle);
            }
        });
        if (this.childPagesFragment == null && this.isContainer) {
            addChildPagesFragment();
        }
        addMenuProvider(this.menuProvider);
        if (this.isContainer) {
            getLibraryRepository().addSyncListener(this.syncListener);
        }
        HapticFeedbackManager hapticFeedbackManagerCreateHapticFeedbackManager = new HapticFeedbackManagerFactoryImpl().createHapticFeedbackManager();
        this.hapticFeedbackManager = hapticFeedbackManagerCreateHapticFeedbackManager;
        if (hapticFeedbackManagerCreateHapticFeedbackManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
            hapticFeedbackManagerCreateHapticFeedbackManager = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        hapticFeedbackManagerCreateHapticFeedbackManager.init(applicationContext);
        ComposeView composeView = (ComposeView) findViewById(C6079R.id.ai_pane);
        if (getResources().getBoolean(C6079R.bool.is_ai_available_for_flavor)) {
            Application application3 = getApplication();
            Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
            final NeboApplication neboApplication = (NeboApplication) application3;
            final NeboNetworkStateRepository neboNetworkStateRepositoryProvideNeboNetworkStateRepository = neboApplication.provideNeboNetworkStateRepository();
            final ISSOManager iSSOManagerProvideSSOManager = neboApplication.provideSSOManager();
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-671516752, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditingActivity.onCreate$lambda$17(this.f$0, neboNetworkStateRepositoryProvideNeboNetworkStateRepository, neboApplication, iSSOManagerProvideSSOManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        } else {
            Intrinsics.checkNotNull(composeView);
            composeView.setVisibility(8);
        }
        this.composeDialogHost = (ComposeView) findViewById(C6079R.id.main_activity_compose_dialog_host);
        getFreemiumLimitationViewModel().getFreemiumLimitationDialogState().observe(editingActivity, new EditingActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditingActivity.onCreate$lambda$18(this.f$0, (FreemiumLimitationDialogState) obj);
            }
        }));
        this.paywallView = (ComposeView) findViewById(C6079R.id.main_activity_paywall);
        this.discoverabilityTooltip = (ComposeView) findViewById(C6079R.id.discoverability_tooltip);
        this.dataCollectHost = (ComposeView) findViewById(C6079R.id.data_collect_dialog);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(editingActivity), null, null, new C636228(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$7 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63637 extends FunctionReferenceImpl implements Function1<Banner, Unit> {
        C63637(Object obj) {
            super(1, obj, BannerLayout.class, "permanentBannerChanged", "permanentBannerChanged(Lcom/myscript/nebo/banner/Banner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Banner banner) {
            invoke2(banner);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Banner banner) {
            ((BannerLayout) this.receiver).permanentBannerChanged(banner);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$8 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63648 extends FunctionReferenceImpl implements Function1<Banner, Unit> {
        C63648(Object obj) {
            super(1, obj, BannerLayout.class, "transientBannerChanged", "transientBannerChanged(Lcom/myscript/nebo/banner/Banner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Banner banner) {
            invoke2(banner);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Banner banner) {
            ((BannerLayout) this.receiver).transientBannerChanged(banner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(EditingActivity editingActivity, ToolbarConfiguration toolbarConfiguration) {
        TechnicalLogger logger = editingActivity.getLogger();
        Intrinsics.checkNotNull(toolbarConfiguration);
        TechnicalLoggerExt.logAction(logger, TAG, "Toolbar update", new EditingActivity$onCreate$9$1(toolbarConfiguration));
        ToolConfiguration toolConfigurationFindToolConfigurationByType = editingActivity.getToolbarViewModel().findToolConfigurationByType(editingActivity.getToolbarViewModel().getSelectedToolTypeValue());
        if (toolConfigurationFindToolConfigurationByType != null) {
            HapticFeedbackManager hapticFeedbackManager = editingActivity.hapticFeedbackManager;
            if (hapticFeedbackManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
                hapticFeedbackManager = null;
            }
            hapticFeedbackManager.setTool(toolConfigurationFindToolConfigurationByType);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6(EditingActivity editingActivity, ToolType toolType) {
        if (toolType == ToolType.Eraser) {
            editingActivity.getNoteEditorViewModel().setDiscoverable(EditingDiscoverableFeature.ScratchOutGestureFeature.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7(EditingActivity editingActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey(ToolConfigurationDialogFragment.IS_WRITING_KEY)) {
            boolean z = bundle.getBoolean(ToolConfigurationDialogFragment.IS_WRITING_KEY);
            HapticFeedbackManager hapticFeedbackManager = null;
            if (PreferenceManager.getDefaultSharedPreferences(editingActivity).getBoolean(editingActivity.getString(C6693R.string.pref_pen_haptic_feedback_key), editingActivity.getResources().getBoolean(C6079R.bool.pref_enable_pen_haptic_feedback_default)) && z) {
                HapticFeedbackManager hapticFeedbackManager2 = editingActivity.hapticFeedbackManager;
                if (hapticFeedbackManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
                } else {
                    hapticFeedbackManager = hapticFeedbackManager2;
                }
                hapticFeedbackManager.startFeedback();
                return;
            }
            HapticFeedbackManager hapticFeedbackManager3 = editingActivity.hapticFeedbackManager;
            if (hapticFeedbackManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
            } else {
                hapticFeedbackManager = hapticFeedbackManager3;
            }
            hapticFeedbackManager.stopFeedback();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$12 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C635612 extends FunctionReferenceImpl implements Function1<SearchPageState, Unit> {
        C635612(Object obj) {
            super(1, obj, EditingActivity.class, "onSearchStateUpdate", "onSearchStateUpdate(Lcom/myscript/nebo/editing/search/SearchPageState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchPageState searchPageState) {
            invoke2(searchPageState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchPageState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EditingActivity) this.receiver).onSearchStateUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$13 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C635713 extends FunctionReferenceImpl implements Function1<List<? extends String>, Unit> {
        C635713(Object obj) {
            super(1, obj, EditingActivity.class, "onSearchHistoryUpdate", "onSearchHistoryUpdate(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EditingActivity) this.receiver).onSearchHistoryUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$14 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C635814 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C635814(Object obj) {
            super(1, obj, EditingActivity.class, "navigateToSearchHit", "navigateToSearchHit(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            ((EditingActivity) this.receiver).navigateToSearchHit(str);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$15 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C635915 extends FunctionReferenceImpl implements Function1<SearchHitNavState, Unit> {
        C635915(Object obj) {
            super(1, obj, EditingActivity.class, "onHitNavStateUpdate", "onHitNavStateUpdate(Lcom/myscript/nebo/editing/search/SearchHitNavState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchHitNavState searchHitNavState) {
            invoke2(searchHitNavState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchHitNavState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EditingActivity) this.receiver).onHitNavStateUpdate(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9(EditingActivity editingActivity) {
        TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "Toggle child pages panel", null, 4, null);
        editingActivity.getChildPagesViewModel().toggleChildPagesPanel();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$18 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C636018 extends FunctionReferenceImpl implements Function1<NoteProperties, Unit> {
        C636018(Object obj) {
            super(1, obj, EditingActivity.class, "onNotePropertiesChanged", "onNotePropertiesChanged(Lcom/myscript/nebo/editing/NoteProperties;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NoteProperties noteProperties) {
            invoke2(noteProperties);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NoteProperties noteProperties) {
            ((EditingActivity) this.receiver).onNotePropertiesChanged(noteProperties);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$19 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C636119 extends FunctionReferenceImpl implements Function1<TooltipUIState, Unit> {
        C636119(Object obj) {
            super(1, obj, EditingActivity.class, "updateDiscoveryTooltip", "updateDiscoveryTooltip(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TooltipUIState tooltipUIState) {
            invoke2(tooltipUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TooltipUIState tooltipUIState) {
            ((EditingActivity) this.receiver).updateDiscoveryTooltip(tooltipUIState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$11(EditingActivity editingActivity, Boolean bool) {
        if (bool != null) {
            editingActivity.onCloudTokenExpired(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$12(final EditingActivity editingActivity, final ImmutableList immutableList) {
        if (editingActivity.isContainer) {
            ChildPagesViewModel.Companion companion = ChildPagesViewModel.INSTANCE;
            List<ChildPage> list = editingActivity.lastChildPagesUpdatedState;
            Intrinsics.checkNotNull(immutableList);
            ImmutableList immutableList2 = immutableList;
            if (companion.confirmStructuralChange(list, immutableList2)) {
                ViewPager2 viewPager2 = editingActivity.childPagesViewPager;
                if (viewPager2 != null) {
                    viewPager2.setAdapter(editingActivity.childPagesPagerAdapter);
                }
                ViewPager2 viewPager22 = editingActivity.childPagesViewPager;
                if (viewPager22 != null) {
                    viewPager22.post(new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda36
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditingActivity.onCreate$lambda$12$0(this.f$0, immutableList);
                        }
                    });
                }
            }
            editingActivity.lastChildPagesUpdatedState = immutableList2;
        }
        editingActivity.getAiContainerViewModel().updatePagesCount(immutableList.size());
        editingActivity.getAiSummarizeViewModel().updatePagesCount(immutableList.size());
        editingActivity.getAiQuizViewModel().updatePagesCount(immutableList.size());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$12$0(EditingActivity editingActivity, ImmutableList immutableList) {
        Intrinsics.checkNotNull(immutableList);
        editingActivity.restoreSelectedChildPage(immutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13(final EditingActivity editingActivity, final ChildPagesNavigationState childPagesNavigationState) {
        ViewPager2 viewPager2;
        TechnicalLogger logger = editingActivity.getLogger();
        Intrinsics.checkNotNull(childPagesNavigationState);
        TechnicalLoggerExt.logAction(logger, TAG, "Child page state update", new EditingActivity$onCreate$22$1(childPagesNavigationState));
        PageIndicator pageIndicator = editingActivity.childPagesNavigationWidget;
        if (pageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childPagesNavigationWidget");
            pageIndicator = null;
        }
        pageIndicator.setState(childPagesNavigationState.isNavigationWidgetVisible());
        IPaginatedContainer paginatedContainer = editingActivity.getChildPagesViewModel().getPaginatedContainer();
        if (paginatedContainer != null && ChildPagesViewModelKt.isValidChildPageId(paginatedContainer, childPagesNavigationState.getSelectedPageId())) {
            String strSelectedPage = paginatedContainer.selectedPage();
            List<com.myscript.snt.dms.PageProperties> listPages = paginatedContainer.pages();
            Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
            Iterator<com.myscript.snt.dms.PageProperties> it = listPages.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getPageId(), strSelectedPage)) {
                    break;
                }
                i++;
            }
            int itemCount = editingActivity.childPagesPagerAdapter.getItemCount();
            ViewPager2 viewPager22 = editingActivity.childPagesViewPager;
            if (i != (viewPager22 != null ? viewPager22.getCurrentItem() : -1) && i >= 0 && i < itemCount && (viewPager2 = editingActivity.childPagesViewPager) != null) {
                viewPager2.setCurrentItem(i, false);
            }
            PageFragment pageFragment = editingActivity.getPageFragment();
            if (pageFragment != null) {
                pageFragment.tryReloadAfterLoadFailure();
            } else {
                new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onCreate$lambda$13$1(this.f$0, childPagesNavigationState);
                    }
                };
            }
        }
        if (childPagesNavigationState.getCloseSearch()) {
            editingActivity.getSearchViewModel().closeSearch();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13$1(EditingActivity editingActivity, ChildPagesNavigationState childPagesNavigationState) {
        editingActivity.tryReloadPageNextTime = childPagesNavigationState.isUserAction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14(EditingActivity editingActivity, ChildPagesPanelVisibilityState childPagesPanelVisibilityState) {
        editingActivity.animateChildPagesPanel(childPagesPanelVisibilityState.isVisible(), childPagesPanelVisibilityState.getShouldAnimate());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$15(EditingActivity editingActivity, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString(NoteNameDialog.NOTE_NAME_KEY, null);
        if (string != null) {
            TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "New page title validated", null, 4, null);
            editingActivity.getNoteEditorViewModel().updateNoteName(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$16(EditingActivity editingActivity, String str, Bundle result) {
        PageKey pageKeyDeserialize;
        PageFragment pageFragment;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString("PAGE_KEY_KEY", null);
        if (string == null || (pageKeyDeserialize = PageKey.deserialize(string)) == null) {
            return;
        }
        boolean z = result.getBoolean(PageBackgroundFragment.IS_CONTAINER_KEY);
        int i = result.getInt(PageBackgroundFragment.PAGE_BACKGROUND_COLOR_KEY, 0);
        if (i != 0) {
            if (z) {
                TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background color selected #" + Integer.toHexString(i) + " for container", new EditingActivity$onCreate$25$1(pageKeyDeserialize));
                editingActivity.getChildPagesViewModel().setBackgroundColor(pageKeyDeserialize, i);
            } else {
                PageKey pageKey = editingActivity.openNoteKey;
                if (pageKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey = null;
                }
                if (Intrinsics.areEqual(pageKeyDeserialize, pageKey)) {
                    TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background color selected #" + Integer.toHexString(i) + " for self contained note", new EditingActivity$onCreate$25$2(pageKeyDeserialize));
                    PageFragment pageFragment2 = editingActivity.getPageFragment();
                    if (pageFragment2 != null) {
                        pageFragment2.setBackgroundColor(i);
                    }
                } else {
                    PageKey pageKey2 = editingActivity.openNoteKey;
                    if (pageKey2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                        pageKey2 = null;
                    }
                    if (!Intrinsics.areEqual(pageKeyDeserialize, pageKey2)) {
                        TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background color selected #" + Integer.toHexString(i) + " for container's child page", new EditingActivity$onCreate$25$3(pageKeyDeserialize));
                        editingActivity.getChildPagesViewModel().setBackgroundColor(pageKeyDeserialize, i);
                    }
                }
            }
        }
        String string2 = result.getString(PageBackgroundFragment.PAGE_BACKGROUND_PATTERN_KEY);
        BackgroundPattern backgroundPatternValueOf = string2 != null ? BackgroundPattern.valueOf(string2) : null;
        if (backgroundPatternValueOf != null) {
            if (z) {
                TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background pattern selected " + backgroundPatternValueOf + " for container", new EditingActivity$onCreate$25$4(pageKeyDeserialize));
                editingActivity.getChildPagesViewModel().setBackgroundPattern(pageKeyDeserialize, backgroundPatternValueOf);
                return;
            }
            PageKey pageKey3 = editingActivity.openNoteKey;
            if (pageKey3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                pageKey3 = null;
            }
            if (Intrinsics.areEqual(pageKeyDeserialize, pageKey3)) {
                TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background pattern selected " + backgroundPatternValueOf + " for self contained note", new EditingActivity$onCreate$25$5(pageKeyDeserialize));
                PageFragment pageFragment3 = editingActivity.getPageFragment();
                if (pageFragment3 != null) {
                    pageFragment3.setBackgroundPattern(backgroundPatternValueOf);
                    return;
                }
                return;
            }
            PageKey pageKey4 = editingActivity.openNoteKey;
            if (pageKey4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                pageKey4 = null;
            }
            if (Intrinsics.areEqual(pageKeyDeserialize, pageKey4)) {
                return;
            }
            TechnicalLoggerExt.logAction(editingActivity.getLogger(), TAG, "New page background pattern selected " + backgroundPatternValueOf + " for container's child page", new EditingActivity$onCreate$25$6(pageKeyDeserialize));
            editingActivity.getChildPagesViewModel().setBackgroundPattern(pageKeyDeserialize, backgroundPatternValueOf);
            PageFragment pageFragment4 = editingActivity.getPageFragment();
            if (!Intrinsics.areEqual(pageFragment4 != null ? pageFragment4.getOpenedPageKey() : null, pageKeyDeserialize) || (pageFragment = editingActivity.getPageFragment()) == null) {
                return;
            }
            pageFragment.setBackgroundPattern(backgroundPatternValueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$17(final EditingActivity editingActivity, final NeboNetworkStateRepository neboNetworkStateRepository, final NeboApplication neboApplication, final ISSOManager iSSOManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1270@62176L1636,1270@62084L1728:EditingActivity.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-671516752, i, -1, "com.myscript.nebo.editing.EditingActivity.onCreate.<anonymous> (EditingActivity.kt:1270)");
            }
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(editingActivity, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-432254152, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditingActivity.onCreate$lambda$17$0(this.f$0, neboNetworkStateRepository, neboApplication, iSSOManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$17$0(final EditingActivity editingActivity, NeboNetworkStateRepository neboNetworkStateRepository, NeboApplication neboApplication, ISSOManager iSSOManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1276@62511L15,1271@62198L350,1279@62619L40,1280@62736L21,1283@62875L46,1291@63504L267,1287@63211L44,1288@63298L161,1281@62778L1016:EditingActivity.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-432254152, i, -1, "com.myscript.nebo.editing.EditingActivity.onCreate.<anonymous>.<anonymous> (EditingActivity.kt:1271)");
            }
            AIContainerViewModel aiContainerViewModel = editingActivity.getAiContainerViewModel();
            AIExplainViewModel aiExplainViewModel = editingActivity.getAiExplainViewModel();
            AISummarizeViewModel aiSummarizeViewModel = editingActivity.getAiSummarizeViewModel();
            AIQuizViewModel aiQuizViewModel = editingActivity.getAiQuizViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, 1215598375, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(editingActivity);
            EditingActivity$onCreate$26$1$1$1 editingActivity$onCreate$26$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || editingActivity$onCreate$26$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editingActivity$onCreate$26$1$1$1RememberedValue = new EditingActivity$onCreate$26$1$1$1(editingActivity);
                composer.updateRememberedValue(editingActivity$onCreate$26$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AIContainerPaneKt.AIContainerPane(aiContainerViewModel, aiSummarizeViewModel, aiExplainViewModel, aiQuizViewModel, (Function1) ((KFunction) editingActivity$onCreate$26$1$1$1RememberedValue), null, composer, (AIQuizViewModel.$stable << 9) | AIContainerViewModel.$stable | (AISummarizeViewModel.$stable << 3) | (AIExplainViewModel.$stable << 6), 32);
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(neboNetworkStateRepository.getNeboNetworkState(), NeboNetworkState.Offline.INSTANCE, composer, 0);
            boolean zOnCreate$lambda$17$0$2 = onCreate$lambda$17$0$2(LiveDataAdapterKt.observeAsState(editingActivity.getAiContainerViewModel().getShowSignInDialog(), false, composer, 48));
            GoogleSignInHelper googleSignInHelper = neboApplication.getGoogleSignInHelper();
            String string = editingActivity.getString(C6278R.string.google_server_client_id);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean z = onCreate$lambda$17$0$1(stateObserveAsState) instanceof NeboNetworkState.Connected;
            ComposerKt.sourceInformationMarkerStart(composer, 1215610054, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(editingActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onCreate$lambda$17$0$3$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1215630403, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(iSSOManager) | composer.changedInstance(editingActivity);
            EditingActivity$onCreate$26$1$3$1 editingActivity$onCreate$26$1$3$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance3 || editingActivity$onCreate$26$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editingActivity$onCreate$26$1$3$1RememberedValue = new EditingActivity$onCreate$26$1$3$1(iSSOManager, editingActivity, null);
                composer.updateRememberedValue(editingActivity$onCreate$26$1$3$1RememberedValue);
            }
            Function2 function2 = (Function2) editingActivity$onCreate$26$1$3$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1215620804, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(editingActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onCreate$lambda$17$0$5$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function02 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1215623705, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(editingActivity);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onCreate$lambda$17$0$6$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NativeSignInDialogKt.NativeSignInDialog(zOnCreate$lambda$17$0$2, function0, googleSignInHelper, string, function2, z, function02, (Function0) objRememberedValue3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$17$0$3$0(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().dismissSignInDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$17$0$5$0(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().onSignInCancelled();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$17$0$6$0(EditingActivity editingActivity) {
        editingActivity.aiSignInActivityLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(editingActivity, LoginOrigin.AiButton.getValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18(final EditingActivity editingActivity, final FreemiumLimitationDialogState freemiumLimitationDialogState) {
        ComposeView composeView = editingActivity.composeDialogHost;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(427273304, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditingActivity.onCreate$lambda$18$0(freemiumLimitationDialogState, editingActivity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18$0(FreemiumLimitationDialogState freemiumLimitationDialogState, final EditingActivity editingActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:EditingActivity.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(427273304, i, -1, "com.myscript.nebo.editing.EditingActivity.onCreate.<anonymous>.<anonymous> (EditingActivity.kt:1307)");
            }
            if (freemiumLimitationDialogState.isDialogVisible()) {
                composer.startReplaceGroup(-1383999476);
                ComposerKt.sourceInformation(composer, "1309@64298L75,1314@64497L165,1318@64709L115,1312@64394L452");
                final String originForAnalytics = FreemiumLimitationViewModelKt.getOriginForAnalytics(freemiumLimitationDialogState.getTrigger());
                NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.FreemiumModalDisplay;
                ComposerKt.sourceInformationMarkerStart(composer, -1707209405, "CC(remember):EditingActivity.kt#9igjgp");
                boolean zChanged = composer.changed(originForAnalytics);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditingActivity.onCreate$lambda$18$0$0$0(originForAnalytics, (Bundle) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                neboFirebaseEvent.log((Function1<? super Bundle, Unit>) objRememberedValue);
                Intrinsics.checkNotNull(freemiumLimitationDialogState);
                ComposerKt.sourceInformationMarkerStart(composer, -1707202947, "CC(remember):EditingActivity.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(editingActivity) | composer.changed(originForAnalytics);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditingActivity.onCreate$lambda$18$0$1$0(this.f$0, originForAnalytics);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1707196213, "CC(remember):EditingActivity.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(editingActivity);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditingActivity.onCreate$lambda$18$0$2$0(this.f$0);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FreemiumLimitationDialogKt.FreemiumLimitationDialog(freemiumLimitationDialogState, function0, (Function0) objRememberedValue3, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1383317538);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18$0$0$0(String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18$0$1$0(EditingActivity editingActivity, String str) {
        editingActivity.getFreemiumLimitationViewModel().closeFreemiumLimitationDialog();
        editingActivity.onShowPaywall(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18$0$2$0(EditingActivity editingActivity) {
        editingActivity.getFreemiumLimitationViewModel().closeFreemiumLimitationDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$28 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$onCreate$28", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {1335}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C636228 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C636228(Continuation<? super C636228> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditingActivity.this.new C636228(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C636228) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onCreate$28$1, reason: invalid class name */
        /* JADX INFO: compiled from: EditingActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ EditingActivity this$0;

            AnonymousClass1(EditingActivity editingActivity) {
                this.this$0 = editingActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final boolean z, Continuation<? super Unit> continuation) {
                ComposeView composeView = this.this$0.dataCollectHost;
                if (composeView != null) {
                    final EditingActivity editingActivity = this.this$0;
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(134753011, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$onCreate$28$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditingActivity.C636228.AnonymousClass1.emit$lambda$0(z, editingActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0(final boolean z, final EditingActivity editingActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C1336@65326L468,1336@65316L478:EditingActivity.kt#v1cuvs");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(134753011, i, -1, "com.myscript.nebo.editing.EditingActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (EditingActivity.kt:1336)");
                    }
                    ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(643671147, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$onCreate$28$1$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditingActivity.C636228.AnonymousClass1.emit$lambda$0$0(z, editingActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0(boolean z, final EditingActivity editingActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C1339@65459L189,1343@65696L50,1337@65352L420:EditingActivity.kt#v1cuvs");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(643671147, i, -1, "com.myscript.nebo.editing.EditingActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EditingActivity.kt:1337)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 92686088, "CC(remember):EditingActivity.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(editingActivity);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$onCreate$28$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditingActivity.C636228.AnonymousClass1.emit$lambda$0$0$0$0(editingActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 92693533, "CC(remember):EditingActivity.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(editingActivity);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$onCreate$28$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditingActivity.C636228.AnonymousClass1.emit$lambda$0$0$1$0(editingActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DataCollectDialogKt.DataCollectDialog(z, function0, (Function0) objRememberedValue2, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0$0$0(EditingActivity editingActivity) {
                editingActivity.getNoteEditorViewModel().dismissDataCollectDialog();
                editingActivity.getSsoManager().saveShareMyNotesSetting(true, null);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0$1$0(EditingActivity editingActivity) {
                editingActivity.getNoteEditorViewModel().dismissDataCollectDialog();
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
                if (EditingActivity.this.getNoteEditorViewModel().getDataCollectVisible().collect(new AnonymousClass1(EditingActivity.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void updateDiscoveryTooltip() {
        updateDiscoveryTooltip(getNoteEditorViewModel().getDiscoveryTooltip().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateDiscoveryTooltip(TooltipUIState tooltipUIState) {
        Rect rect = null;
        Object userData = tooltipUIState != null ? tooltipUIState.getUserData() : null;
        EditingDiscoverableFeature.DiscoverableFeatureDestination discoverableFeatureDestination = userData instanceof EditingDiscoverableFeature.DiscoverableFeatureDestination ? (EditingDiscoverableFeature.DiscoverableFeatureDestination) userData : null;
        if (tooltipUIState == null || discoverableFeatureDestination != EditingDiscoverableFeature.DiscoverableFeatureDestination.MAIN_FRAGMENT) {
            tooltipUIState = null;
        }
        ComposeView composeView = this.discoverabilityTooltip;
        if (composeView != null) {
            ComposeViewManager composeViewManager = ComposeViewManager.INSTANCE;
            Integer numValueOf = tooltipUIState != null ? Integer.valueOf(tooltipUIState.getId()) : null;
            int id = EditingDiscoverableFeature.AIExplainFeature.INSTANCE.getId();
            if (numValueOf != null && numValueOf.intValue() == id) {
                rect = this.aiButtonRect;
            } else {
                int id2 = EditingDiscoverableFeature.PenOptionsFeature.INSTANCE.getId();
                if (numValueOf != null && numValueOf.intValue() == id2) {
                    PenFragment penFragment = this.penFragment;
                    if (penFragment != null) {
                        rect = penFragment.toolLocation(ToolType.Pen);
                    }
                } else {
                    int id3 = EditingDiscoverableFeature.ConvertTextFeature.INSTANCE.getId();
                    if (numValueOf == null || numValueOf.intValue() != id3) {
                        int id4 = EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE.getId();
                        if (numValueOf == null || numValueOf.intValue() != id4) {
                            int id5 = EditingDiscoverableFeature.ScratchOutGestureFeature.INSTANCE.getId();
                            if (numValueOf == null || numValueOf.intValue() != id5) {
                                int id6 = EditingDiscoverableFeature.ShapesFeature.INSTANCE.getId();
                                if (numValueOf != null && numValueOf.intValue() == id6) {
                                }
                            }
                        }
                    } else {
                        View viewFindViewById = findViewById(C6079R.id.page_fragment_view_pager);
                        Intrinsics.checkNotNull(viewFindViewById);
                        int[] locationInWindow = ViewExt.getLocationInWindow(viewFindViewById);
                        EditingActivity editingActivity = this;
                        rect = new Rect(locationInWindow[0] + viewFindViewById.getWidth(), locationInWindow[1] + ScreenUtils.dpToPx(editingActivity, 16.0f), locationInWindow[0] + viewFindViewById.getWidth(), locationInWindow[1] + ScreenUtils.dpToPx(editingActivity, 16.0f));
                    }
                }
            }
            composeViewManager.setComposableContent(composeView, new TooltipComposableProviderImpl(tooltipUIState, rect, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditingActivity.updateDiscoveryTooltip$lambda$0$0(this.f$0);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateDiscoveryTooltip$lambda$0$0(EditingActivity editingActivity) {
        editingActivity.getNoteEditorViewModel().dismissCurrentTooltip();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.penpanel.PenFragment.Callback
    public void onPenToolbarLayout() {
        updateDiscoveryTooltip();
    }

    @Override // com.myscript.nebo.penpanel.PenFragment.Callback
    public void onPenOptionsDiscovered(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        if (toolType == ToolType.Pen) {
            getNoteEditorViewModel().discover(EditingDiscoverableFeature.PenOptionsFeature.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToSearchHit(String pageId) {
        ImmutableList<ChildPage> value;
        ChildPage next;
        if (pageId != null) {
            if (!getSearchViewModel().isSearchProcessing() || getSearchViewModel().getSearchType() == DMSSearchController.SearchType.GRID) {
                ChildPagesNavigationState value2 = getChildPagesViewModel().getChildPagesNavigationState().getValue();
                String selectedPageId = value2 != null ? value2.getSelectedPageId() : null;
                if (selectedPageId == null || Intrinsics.areEqual(selectedPageId, pageId) || (value = getChildPagesViewModel().getChildPages().getValue()) == null) {
                    return;
                }
                Iterator<ChildPage> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(next.getId(), pageId)) {
                            break;
                        }
                    }
                }
                ChildPage childPage = next;
                if (childPage != null) {
                    ChildPagesViewModel.selectPage$default(getChildPagesViewModel(), childPage, false, 2, null);
                }
            }
        }
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        StylusDoubleTapReceiverImpl stylusDoubleTapReceiverImpl = new StylusDoubleTapReceiverImpl();
        stylusDoubleTapReceiverImpl.setStylusDoubleTapListener(this.onStylusDoubleTap);
        ContextCompat.registerReceiver(this, stylusDoubleTapReceiverImpl, stylusDoubleTapReceiverImpl.getIntentFilters(), 2);
        this.stylusDoubleTapReceiver = stylusDoubleTapReceiverImpl;
        ZoomIndicatorView zoomIndicatorView = this.zoomIndicatorPanel;
        TextView textView = null;
        if (zoomIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zoomIndicatorPanel");
            zoomIndicatorView = null;
        }
        zoomIndicatorView.setZoomIndicatorListener(this.onZoomIndicatorUpdate);
        View view = this.searchPreviousButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchPreviousButton");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditingActivity.onStart$lambda$2(this.f$0, view2);
            }
        });
        View view2 = this.searchNextButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchNextButton");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                EditingActivity.onStart$lambda$3(this.f$0, view3);
            }
        });
        getAiContainerViewModel().setTextSelectionProvider(this.aiTextSelectionProvider);
        getAiSummarizeViewModel().setTextSelectionProvider(this.aiTextSelectionProvider);
        getAiExplainViewModel().setTextSelectionProvider(this.aiTextSelectionProvider);
        getAiQuizViewModel().setTextSelectionProvider(this.aiTextSelectionProvider);
        getAiContainerViewModel().setUserDataProvider(this.userDataProvider);
        TextView textView2 = this.hitsSearchTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hitsSearchTextView");
        } else {
            textView = textView2;
        }
        TextViewExt.clearLastHoveredView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$2(EditingActivity editingActivity, View view) {
        TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "Search > previous hit", null, 4, null);
        editingActivity.getSearchViewModel().previousHit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$3(EditingActivity editingActivity, View view) {
        TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "Search > next hit", null, 4, null);
        editingActivity.getSearchViewModel().nextHit();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        unregisterReceiver(this.stylusDoubleTapReceiver);
        StylusDoubleTapReceiver stylusDoubleTapReceiver = this.stylusDoubleTapReceiver;
        if (stylusDoubleTapReceiver != null) {
            stylusDoubleTapReceiver.setStylusDoubleTapListener(null);
        }
        ZoomIndicatorView zoomIndicatorView = this.zoomIndicatorPanel;
        if (zoomIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zoomIndicatorPanel");
            zoomIndicatorView = null;
        }
        zoomIndicatorView.setZoomIndicatorListener(null);
        View view = this.searchPreviousButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchPreviousButton");
            view = null;
        }
        view.setOnClickListener(null);
        View view2 = this.searchNextButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchNextButton");
            view2 = null;
        }
        view2.setOnClickListener(null);
        if (getChildPagesViewModel().isChildPagesCompatible()) {
            getChildPagesViewModel().cleanOldThumbnails();
        }
        getAiContainerViewModel().setTextSelectionProvider(null);
        getAiContainerViewModel().setUserDataProvider(null);
        getAiContainerViewModel().clearLastOperation();
        getAiQuizViewModel().setTextSelectionProvider(null);
        super.onStop();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        getLibraryRepository().removeSyncListener(this.syncListener);
        this.penFragment = null;
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout = null;
        }
        bannerLayout.setCallback(null);
        PageIndicator pageIndicator = this.childPagesNavigationWidget;
        if (pageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childPagesNavigationWidget");
            pageIndicator = null;
        }
        pageIndicator.setSidePanelToggleListener(null);
        TechnicalLoggerExt.setNoteKeyValues(getLogger(), null);
        if (isFinishing()) {
            getChildPagesViewModel().unbindPaginatedContainer();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        StylusDoubleTapReceiver stylusDoubleTapReceiver = this.stylusDoubleTapReceiver;
        if (stylusDoubleTapReceiver == null || !stylusDoubleTapReceiver.onKeyDown(keyCode, event)) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        if (getSearchViewModel().isSearchModeActive()) {
            return;
        }
        super.invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openExportDialog() {
        if (FeatureHelper.checkFeatureAvailable(this, C6079R.bool.export_enabled)) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C63661(null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$openExportDialog$1 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$openExportDialog$1", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {1546}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1552}, m1615s = {}, m1616v = 2)
    static final class C63661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63661(Continuation<? super C63661> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditingActivity.this.new C63661(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageKey pageKey;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TechnicalLogger logger = EditingActivity.this.getLogger();
                PageKey pageKey2 = EditingActivity.this.openNoteKey;
                if (pageKey2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey2 = null;
                }
                LibraryRepository libraryRepository = EditingActivity.this.getLibraryRepository();
                PageKey pageKey3 = EditingActivity.this.openNoteKey;
                if (pageKey3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                    pageKey3 = null;
                }
                TechnicalLoggerExt.logPageDetails(logger, EditingActivity.TAG, "Save before exporting", pageKey2, libraryRepository.getPage(pageKey3));
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(EditingActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TechnicalLoggerExt.logAction$default(EditingActivity.this.getLogger(), EditingActivity.TAG, "Export Note Dialog", null, 4, null);
            ExportDialog.Companion companion = ExportDialog.INSTANCE;
            PageKey pageKey4 = EditingActivity.this.openNoteKey;
            if (pageKey4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                pageKey = null;
            } else {
                pageKey = pageKey4;
            }
            ExportDialog exportDialogNewInstance$default = ExportDialog.Companion.newInstance$default(companion, pageKey, (String) null, (MimeType) null, 6, (Object) null);
            FragmentManager supportFragmentManager = EditingActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            exportDialogNewInstance$default.show(supportFragmentManager);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$openExportDialog$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: EditingActivity.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$openExportDialog$1$1", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EditingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(EditingActivity editingActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = editingActivity;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PageController pageController = this.this$0.getPageController();
                if (pageController == null) {
                    return null;
                }
                PageController pageController2 = pageController;
                try {
                    this.this$0.getLibraryRepository().save(null, pageController2, false);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController2, null);
                    return Unit.INSTANCE;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupSearch(Menu menu) {
        final MenuItem menuItemFindItem = menu.findItem(C6079R.id.editing_view_more_menu_search);
        MaterialToolbar materialToolbar = null;
        View actionView = menuItemFindItem != null ? menuItemFindItem.getActionView() : null;
        SearchView searchView = actionView instanceof SearchView ? (SearchView) actionView : null;
        if (searchView == null) {
            return;
        }
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.myscript.nebo.editing.EditingActivity.setupSearch.1
            private boolean newQuery;

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String label) {
                Intrinsics.checkNotNullParameter(label, "label");
                if (!this.newQuery || EditingActivity.this.getSearchViewModel().isSearchProcessing()) {
                    return true;
                }
                this.newQuery = false;
                View view = EditingActivity.this.searchResultsToolbar;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultsToolbar");
                    view = null;
                }
                EditingActivityKt.closeInputMethod(view);
                EditingActivity.this.searchLabel(label);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String label) {
                Intrinsics.checkNotNullParameter(label, "label");
                this.newQuery = true;
                return false;
            }
        });
        searchView.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC63682(menu));
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(C0028R.id.search_src_text);
        if (searchAutoComplete != null) {
            searchAutoComplete.setAdapter(getSearchHistoryAdapter());
            searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda64
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    EditingActivity.setupSearch$lambda$0$0(this.f$0, adapterView, view, i, j);
                }
            });
        } else {
            searchAutoComplete = null;
        }
        this.autoCompleteSearchView = searchAutoComplete;
        MaterialToolbar materialToolbar2 = this.toolbar;
        if (materialToolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        } else {
            materialToolbar = materialToolbar2;
        }
        materialToolbar.post(new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                EditingActivity.setupSearch$lambda$1(this.f$0, menuItemFindItem);
            }
        });
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$setupSearch$2 */
    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m1599d2 = {"com/myscript/nebo/editing/EditingActivity$setupSearch$2", "Landroid/view/View$OnAttachStateChangeListener;", "onViewDetachedFromWindow", "", "view", "Landroid/view/View;", "onViewAttachedToWindow", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ViewOnAttachStateChangeListenerC63682 implements View.OnAttachStateChangeListener {
        final /* synthetic */ Menu $menu;

        /* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$setupSearch$2$WhenMappings */
        /* JADX INFO: compiled from: EditingActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DMSSearchController.SearchType.values().length];
                try {
                    iArr[DMSSearchController.SearchType.PAGE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DMSSearchController.SearchType.GRID.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        ViewOnAttachStateChangeListenerC63682(Menu menu) {
            this.$menu = menu;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (EditingActivity.this.isChangingConfigurations()) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[EditingActivity.this.getSearchViewModel().getSearchType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    EditingActivity.this.getSearchViewModel().closeSearch();
                    return;
                } else {
                    if (!EditingActivity.this.getSearchViewModel().isSearchModeActive() || EditingActivity.this.isDestroyed()) {
                        return;
                    }
                    EditingActivity.this.getOnBackPressedDispatcher().onBackPressed();
                    return;
                }
            }
            TechnicalLoggerExt.logAction$default(EditingActivity.this.getLogger(), EditingActivity.TAG, "Close Search", null, 4, null);
            boolean zIsSearchModeActive = EditingActivity.this.getSearchViewModel().isSearchModeActive();
            EditingActivity.this.getSearchViewModel().closeSearch();
            Menu menu = this.$menu;
            int size = menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                menu.getItem(i2).setVisible(true);
            }
            if (!zIsSearchModeActive || EditingActivity.this.isDestroyed()) {
                return;
            }
            EditingActivity.this.getOnBackPressedDispatcher().onBackPressed();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TechnicalLoggerExt.logAction$default(EditingActivity.this.getLogger(), EditingActivity.TAG, "Open Search", null, 4, null);
            EditingActivity.this.getSearchViewModel().openSearch();
            Menu menu = this.$menu;
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                menu.getItem(i).setVisible(false);
            }
            MaterialToolbar materialToolbar = EditingActivity.this.toolbar;
            if (materialToolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                materialToolbar = null;
            }
            final EditingActivity editingActivity = EditingActivity.this;
            materialToolbar.post(new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$setupSearch$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EditingActivity.ViewOnAttachStateChangeListenerC63682.onViewAttachedToWindow$lambda$2(editingActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onViewAttachedToWindow$lambda$2(final EditingActivity editingActivity) {
            MaterialToolbar materialToolbar = editingActivity.toolbar;
            if (materialToolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                materialToolbar = null;
            }
            materialToolbar.hideOverflowMenu();
            ImageView imageView = (ImageView) editingActivity.findViewById(C0028R.id.search_close_btn);
            if (imageView != null) {
                imageView.setImageResource(C6183R.drawable.ic_close);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.EditingActivity$setupSearch$2$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditingActivity.ViewOnAttachStateChangeListenerC63682.onViewAttachedToWindow$lambda$2$0$0(editingActivity, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onViewAttachedToWindow$lambda$2$0$0(EditingActivity editingActivity, View view) {
            SearchView.SearchAutoComplete searchAutoComplete = editingActivity.autoCompleteSearchView;
            Editable text = searchAutoComplete != null ? searchAutoComplete.getText() : null;
            if (text == null || text.length() == 0) {
                editingActivity.getSearchViewModel().closeSearch();
                return;
            }
            SearchView.SearchAutoComplete searchAutoComplete2 = editingActivity.autoCompleteSearchView;
            if (searchAutoComplete2 != null) {
                searchAutoComplete2.setText("");
            }
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$0$0(EditingActivity editingActivity, AdapterView adapterView, View view, int i, long j) {
        if (editingActivity.getSearchViewModel().isSearchProcessing()) {
            return;
        }
        if (editingActivity.getSearchHistoryAdapter().isClearItem(i)) {
            editingActivity.getSearchViewModel().clearHistory();
            editingActivity.getSearchHistoryAdapter().clear();
            return;
        }
        String item = editingActivity.getSearchHistoryAdapter().getItem(i);
        if (item != null) {
            SearchView.SearchAutoComplete searchAutoComplete = editingActivity.autoCompleteSearchView;
            if (searchAutoComplete != null) {
                searchAutoComplete.setText(item);
            }
            editingActivity.searchLabel(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$1(EditingActivity editingActivity, MenuItem menuItem) {
        if (editingActivity.getSearchViewModel().isSearchModeActive()) {
            String searchQuery = editingActivity.getSearchViewModel().getSearchQuery();
            if (searchQuery.length() > 0) {
                menuItem.expandActionView();
                SearchView.SearchAutoComplete searchAutoComplete = editingActivity.autoCompleteSearchView;
                if (searchAutoComplete != null) {
                    searchAutoComplete.setText(searchQuery);
                }
                SearchView.SearchAutoComplete searchAutoComplete2 = editingActivity.autoCompleteSearchView;
                if (searchAutoComplete2 != null) {
                    searchAutoComplete2.clearFocus();
                }
                SearchView.SearchAutoComplete searchAutoComplete3 = editingActivity.autoCompleteSearchView;
                if (searchAutoComplete3 != null) {
                    searchAutoComplete3.dismissDropDown();
                }
                View view = editingActivity.searchResultsToolbar;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultsToolbar");
                    view = null;
                }
                EditingActivityKt.closeInputMethod(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void searchLabel(final String label) {
        TechnicalLoggerExt.logAction(getLogger(), TAG, "Search", new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.searchLabel$lambda$0(label);
            }
        });
        String str = label;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        getSearchViewModel().setSearchType(DMSSearchController.SearchType.PAGE);
        getSearchViewModel().search(StringsKt.trim((CharSequence) str).toString());
        SearchView.SearchAutoComplete searchAutoComplete = this.autoCompleteSearchView;
        if (searchAutoComplete != null) {
            searchAutoComplete.clearFocus();
        }
        SearchView.SearchAutoComplete searchAutoComplete2 = this.autoCompleteSearchView;
        if (searchAutoComplete2 != null) {
            searchAutoComplete2.dismissDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String searchLabel$lambda$0(String str) {
        return "query='" + str + "'";
    }

    private final void animateChildPagesPanel(final boolean open, boolean animate) {
        Guideline guideline = this.sidePanelGuideline;
        if (guideline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sidePanelGuideline");
            guideline = null;
        }
        ViewGroup.LayoutParams layoutParams = guideline.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        int i = ((ConstraintLayout.LayoutParams) layoutParams).guideBegin;
        int dimensionPixelSize = open ? getResources().getDimensionPixelSize(C6079R.dimen.child_pages_side_panel_width) : 0;
        if (i == dimensionPixelSize) {
            return;
        }
        TechnicalLoggerExt.logAction(getLogger(), TAG, "Child pages panel", new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.animateChildPagesPanel$lambda$0(open);
            }
        });
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, dimensionPixelSize);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda28
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EditingActivity.animateChildPagesPanel$lambda$1$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.myscript.nebo.editing.EditingActivity$animateChildPagesPanel$2$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                EditingController editingController;
                DocumentRenderingView renderingView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                PageFragment pageFragment = this.this$0.getPageFragment();
                if (pageFragment == null || (editingController = pageFragment.getEditingController()) == null || (renderingView = editingController.getRenderingView()) == null) {
                    return;
                }
                renderingView.setInteractionAllowed(false);
                renderingView.setLayerType(2, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                EditingController editingController;
                DocumentRenderingView renderingView;
                EditingController editingController2;
                DocumentRenderingView renderingView2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                PageFragment pageFragment = this.this$0.getPageFragment();
                if (pageFragment != null && (editingController2 = pageFragment.getEditingController()) != null && (renderingView2 = editingController2.getRenderingView()) != null) {
                    renderingView2.setInteractionAllowed(true);
                    renderingView2.setLayerType(0, null);
                }
                PageFragment pageFragment2 = this.this$0.getPageFragment();
                if (pageFragment2 != null && (editingController = pageFragment2.getEditingController()) != null && (renderingView = editingController.getRenderingView()) != null) {
                    final DocumentRenderingView documentRenderingView = renderingView;
                    final EditingActivity editingActivity = this.this$0;
                    OneShotPreDrawListener.add(documentRenderingView, new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$animateChildPagesPanel$2$2$onAnimationEnd$$inlined$doOnPreDraw$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditingController editingController3;
                            View view = documentRenderingView;
                            PageFragment pageFragment3 = editingActivity.getPageFragment();
                            if (pageFragment3 == null || (editingController3 = pageFragment3.getEditingController()) == null) {
                                return;
                            }
                            editingController3.onResize(view.getWidth(), view.getHeight());
                        }
                    });
                }
                valueAnimatorOfInt.removeAllListeners();
            }
        });
        valueAnimatorOfInt.setDuration(animate ? getResources().getInteger(android.R.integer.config_mediumAnimTime) : 0L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String animateChildPagesPanel$lambda$0(boolean z) {
        return z ? "opening" : "closing";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateChildPagesPanel$lambda$1$0(EditingActivity editingActivity, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = editingActivity.editingContentConstraintLayout;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editingContentConstraintLayout");
            constraintLayout = null;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.setGuidelineBegin(C6079R.id.child_pages_side_panel_guideline, iIntValue);
        ConstraintLayout constraintLayout3 = editingActivity.editingContentConstraintLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editingContentConstraintLayout");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        constraintSet.applyTo(constraintLayout2);
    }

    @Override // com.myscript.nebo.sso.IHelpUsConsumer
    public void showHelpUsDialog() {
        getNoteEditorViewModel().showDataCollectDialog();
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onFinish(int resultCode, PageKey pageKey) {
        if (this.isContainer) {
            return;
        }
        setResult(resultCode, INSTANCE.getResultPageIntent(this, pageKey));
        finish();
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onForceFinish(int result) {
        saveStateBeforeLeaving(result);
        finish();
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public boolean onShouldScrollToBottom(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        boolean z = Intrinsics.areEqual(this.scrollToBottom.getFirst(), tag) && this.scrollToBottom.getSecond().booleanValue();
        this.scrollToBottom = new Pair<>("", false);
        return z;
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onExplainSelection() {
        getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onExplainSelection$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onExplainSelection$lambda$0(final EditingActivity editingActivity) {
        editingActivity.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_AI_EDIT_MENU_ENTRY, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onExplainSelection$lambda$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onExplainSelection$lambda$0$0(final EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().updateAvailableActions(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onExplainSelection$lambda$0$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onExplainSelection$lambda$0$0$0(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.EXPLAIN);
        editingActivity.getAiExplainViewModel().explainText(AIExplainTrigger.CONTEXTUAL_MENU);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onSummarizeSelection() {
        getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onSummarizeSelection$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSummarizeSelection$lambda$0(final EditingActivity editingActivity) {
        editingActivity.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_AI_EDIT_MENU_ENTRY, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onSummarizeSelection$lambda$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSummarizeSelection$lambda$0$0(final EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().updateAvailableActions(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onSummarizeSelection$lambda$0$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSummarizeSelection$lambda$0$0$0(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.SUMMARIZE);
        editingActivity.getAiSummarizeViewModel().summarizeText(AISummarizeTrigger.CONTEXTUAL_MENU);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onQuizSelection() {
        getAiContainerViewModel().runIfSignedIn(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onQuizSelection$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQuizSelection$lambda$0(final EditingActivity editingActivity) {
        editingActivity.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_AI_EDIT_MENU_ENTRY, new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onQuizSelection$lambda$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQuizSelection$lambda$0$0(final EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().updateAvailableActions(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditingActivity.onQuizSelection$lambda$0$0$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQuizSelection$lambda$0$0$0(EditingActivity editingActivity) {
        editingActivity.getAiContainerViewModel().setMode(AIMode.QUIZ);
        editingActivity.getAiQuizViewModel().startQuizFromSelection();
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zIsAltPressed = event.isAltPressed();
        boolean zIsMetaPressed = event.isMetaPressed();
        if (!zIsAltPressed && !zIsMetaPressed) {
            PageFragment pageFragment = getPageFragment();
            return pageFragment != null ? pageFragment.onKeyShortcut(keyCode, event) : super.onKeyShortcut(keyCode, event);
        }
        return super.onKeyShortcut(keyCode, event);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 111) {
            if (getSearchViewModel().isSearchModeActive() && event.getAction() == 0) {
                getSearchViewModel().closeSearch();
                return true;
            }
            PageFragment pageFragment = getPageFragment();
            if (pageFragment == null) {
                return true;
            }
            pageFragment.closeKeyboard();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getToolType(event.getActionIndex()) == 2 && !CommonUtils.isActivePenMode(this)) {
            onPenDetected();
        }
        if (event.getToolType(event.getActionIndex()) == 2) {
            View viewFindViewById = findViewById(C6079R.id.page_fragment_view_pager);
            HapticFeedbackManager hapticFeedbackManager = null;
            if (event.getAction() == 0 || event.getAction() == 5) {
                Intrinsics.checkNotNull(viewFindViewById);
                if (EditingActivityKt.containsEvent(viewFindViewById, event)) {
                    this.isStylusWriting = true;
                    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(C6693R.string.pref_pen_haptic_feedback_key), getResources().getBoolean(C6079R.bool.pref_enable_pen_haptic_feedback_default))) {
                        HapticFeedbackManager hapticFeedbackManager2 = this.hapticFeedbackManager;
                        if (hapticFeedbackManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
                        } else {
                            hapticFeedbackManager = hapticFeedbackManager2;
                        }
                        hapticFeedbackManager.startFeedback();
                    }
                } else if (event.getAction() == 1 || event.getAction() == 6 || event.getAction() == 3) {
                    this.isStylusWriting = false;
                    HapticFeedbackManager hapticFeedbackManager3 = this.hapticFeedbackManager;
                    if (hapticFeedbackManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
                    } else {
                        hapticFeedbackManager = hapticFeedbackManager3;
                    }
                    hapticFeedbackManager.stopFeedback();
                }
            }
        } else {
            this.isStylusWriting = false;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onPageStateUpdated(PageViewModel.State state, PageProperties pageProperties) {
        PageKey pageKey;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pageProperties, "pageProperties");
        if (state instanceof PageViewModel.State.ReadyToLoad) {
            showKnowledgeBaseBannerIfNeeded(pageProperties.isSamplePage());
            getNoteEditorViewModel().initDiscoverability();
            return;
        }
        if (state instanceof PageViewModel.State.Loaded) {
            PageViewModel.State.Loaded loaded = (PageViewModel.State.Loaded) state;
            if (loaded.getPageControllerState().getPageController().isChildPageNavigationCompatible() && Intrinsics.areEqual(loaded.getPageControllerState().getPageController().pageType(), ContentTypes.PDF)) {
                PageIndicator pageIndicator = null;
                if (getChildPagesViewModel().getPaginatedContainer() == null) {
                    PDFManager pDFManagerCreate = PDFManager.create(loaded.getPageControllerState().getPageController());
                    ChildPagesViewModel childPagesViewModel = getChildPagesViewModel();
                    Intrinsics.checkNotNull(pDFManagerCreate);
                    PDFManager pDFManager = pDFManagerCreate;
                    PageKey pageKey2 = this.openNoteKey;
                    if (pageKey2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("openNoteKey");
                        pageKey = null;
                    } else {
                        pageKey = pageKey2;
                    }
                    ChildPagesViewModel.bindPaginatedContainer$default(childPagesViewModel, pDFManager, pageKey, false, 4, null);
                }
                PageIndicator pageIndicator2 = this.childPagesNavigationWidget;
                if (pageIndicator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("childPagesNavigationWidget");
                } else {
                    pageIndicator = pageIndicator2;
                }
                pageIndicator.setSidePanelToggleListener(new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onPageStateUpdated$lambda$0(this.f$0);
                    }
                });
                addChildPagesFragment();
            }
            getNoteEditorViewModel().updateDiscoverableFeatures();
            return;
        }
        if (!(state instanceof PageViewModel.State.LoadingError) && !(state instanceof PageViewModel.State.Unloaded)) {
            throw new NoWhenBranchMatchedException();
        }
        unbindPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPageStateUpdated$lambda$0(EditingActivity editingActivity) {
        TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "Toggle child pages panel", null, 4, null);
        editingActivity.getChildPagesViewModel().toggleChildPagesPanel();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNotePropertiesChanged(NoteProperties noteProperties) {
        if (noteProperties == null) {
            saveStateBeforeLeaving$default(this, 0, 1, null);
            finish();
        }
        if (noteProperties != null) {
            SharePageDialog.PageUpdateProviderCallback pageUpdateProviderCallback = this.pageUpdateProviderCallback;
            if (pageUpdateProviderCallback != null) {
                pageUpdateProviderCallback.onPageUpdated(noteProperties.getNoteName());
            }
            TechnicalLoggerExt.setNoteKeyValues(getLogger(), noteProperties);
            updateToolbarTitle(noteProperties);
        }
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onPagePropertiesChanged(PageKey pageKey, PageProperties pageProperties) {
        Intrinsics.checkNotNullParameter(pageProperties, "pageProperties");
        if (pageKey != null) {
            updateCorruptedPageNotif(pageKey, pageProperties.isCorrupted());
        }
        PenFragment penFragment = this.penFragment;
        if (penFragment != null) {
            penFragment.setPageBackgroundColor(pageProperties.getPageBackgroundColor());
        }
    }

    @Override // com.myscript.nebo.editing.PageFragment.IZoomCallback
    public void onZoomChanged(ZoomState zoomState) {
        Intrinsics.checkNotNullParameter(zoomState, "zoomState");
        ZoomIndicatorView zoomIndicatorView = this.zoomIndicatorPanel;
        if (zoomIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zoomIndicatorPanel");
            zoomIndicatorView = null;
        }
        zoomIndicatorView.displayZoom(zoomState);
    }

    private final void updateToolbarTitle(NoteProperties noteProperties) {
        String string;
        SpannableStringBuilder spannableStringBuilder;
        String noteName = noteProperties.getNoteName();
        if (noteName.length() == 0) {
            string = getString(C6079R.string.untitled_page);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            string = noteName;
        }
        String str = string;
        String folderName = noteProperties.getFolderName();
        String displayedLang = noteProperties.getDisplayedLang();
        boolean isEditable = noteProperties.getIsEditable();
        String fileExtension = noteProperties.getFileExtension();
        View viewFindViewById = findViewById(C6079R.id.page_title_container);
        if (viewFindViewById != null) {
            if (isEditable) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda26
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditingActivity.updateToolbarTitle$lambda$1$0(this.f$0, view);
                    }
                });
            } else {
                viewFindViewById.setOnClickListener(null);
            }
        }
        TextView textView = (TextView) findViewById(C6079R.id.page_title);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) findViewById(C6079R.id.folder_title);
        if (textView2 != null) {
            String str2 = folderName;
            textView2.setText(str2);
            textView2.setVisibility(str2.length() > 0 ? 0 : 8);
        }
        LanguagePill languagePill = (LanguagePill) findViewById(C6079R.id.language_pill);
        if (languagePill != null) {
            String str3 = displayedLang;
            languagePill.setText(str3);
            languagePill.setVisibility(!languagePill.getResources().getBoolean(C6079R.bool.compact_ui) && str3.length() > 0 ? 0 : 8);
        }
        TextView textView3 = (TextView) findViewById(C6079R.id.page_title);
        if (textView3 != null) {
            textView3.setEnabled(noteName.length() > 0);
            textView3.setVisibility(isEditable ? 0 : 8);
            String str4 = fileExtension;
            if (str4.length() == 0) {
                spannableStringBuilder = str;
            } else {
                int colorForState = textView3.getTextColors().getColorForState(new int[]{-16842910}, 0);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
                spannableStringBuilder2.append(str4, new ForegroundColorSpan(colorForState), 0);
                spannableStringBuilder = spannableStringBuilder2;
            }
            textView3.setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateToolbarTitle$lambda$1$0(EditingActivity editingActivity, View view) {
        TechnicalLoggerExt.logAction$default(editingActivity.getLogger(), TAG, "Note name dialog from toolbar", null, 4, null);
        editingActivity.requestNewNoteName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openNewPage() {
        PageFragment pageFragment = getPageFragment();
        if (pageFragment != null) {
            pageFragment.createSiblingPage(new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EditingActivity.openNewPage$lambda$0(this.f$0, (PageKey) obj);
                }
            });
        }
        this.childPagesFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openNewPage$lambda$0(EditingActivity editingActivity, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (!editingActivity.isContainer) {
            editingActivity.openNoteKey = pageKey;
            editingActivity.getNoteEditorViewModel().openNote(pageKey);
            ViewPager2 viewPager2 = editingActivity.childPagesViewPager;
            if (viewPager2 != null) {
                viewPager2.setAdapter(editingActivity.childPagesPagerAdapter);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void onPageReady(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        BannerViewModel.INSTANCE.removeBannerFromBlackList(BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED + pageKey.pageId());
        BannerViewModel.INSTANCE.removeBannerFromBlackList(BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED + pageKey.pageId());
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void notifyScratchOutGesture() {
        getNoteEditorViewModel().setDiscoverable(EditingDiscoverableFeature.ScratchOutGestureFeature.INSTANCE);
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void notifyDocumentTextBoxAdded() {
        getNoteEditorViewModel().setDiscoverable(EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE);
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void notifyTextBoxAdded() {
        getNoteEditorViewModel().setDiscoverable(EditingDiscoverableFeature.ConvertTextFeature.INSTANCE);
    }

    @Override // com.myscript.nebo.editing.PageFragment.Callback
    public void notifyHoldItemAdded() {
        getNoteEditorViewModel().setDiscoverable(EditingDiscoverableFeature.ShapesFeature.INSTANCE);
    }

    private final void unbindPage() {
        if (!this.isContainer) {
            ChildPagesFragment childPagesFragment = this.childPagesFragment;
            if (childPagesFragment != null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.detach(childPagesFragment);
                fragmentTransactionBeginTransaction.commit();
            }
            this.childPagesFragment = null;
        }
        invalidateOptionsMenu();
    }

    private final Banner getKnowledgeBaseBanner() {
        String string = getString(C6079R.string.knownledge_base_banner);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new Banner.MarketingBanner(BANNER_ID_KNOWLEDGE_BASE, string, Type.PERMANENT_FORCED, getString(C6079R.string.knownledge_base_banner_button), new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                EditingActivity.getKnowledgeBaseBanner$lambda$0(this.f$0);
            }
        }, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getKnowledgeBaseBanner$lambda$0(EditingActivity editingActivity) {
        PlatformUtils.openUrl(editingActivity, C6079R.string.help_knowledge_base_url);
    }

    private final void showKnowledgeBaseBannerIfNeeded(boolean isSamplePage) {
        if (isSamplePage) {
            getBannerViewModel().push(getKnowledgeBaseBanner());
        }
    }

    private final void updateCorruptedPageNotif(PageKey pageKey, boolean isCorrupted) {
        String str = "EditingActivity.BANNER_ID_CORRUPTED_PAGE." + pageKey.hashCode();
        if (isCorrupted) {
            BannerViewModel bannerViewModel = getBannerViewModel();
            String string = getString(C6079R.string.corrupted_banner_note_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            bannerViewModel.push(new Banner.CorruptedBanner(str, string, Type.PERMANENT, null, null, null, null, false, 0, 504, null));
            return;
        }
        BannerViewModel.dismiss$default(getBannerViewModel(), str, false, 2, (Object) null);
    }

    @Override // com.myscript.nebo.editing.PageFragment.INotificationBannerCallback
    public void onShowNotificationBanner(int stringRes) {
        if (stringRes == C6313R.string.tutorial_freeform_section_board_step1_body) {
            EditingActivity editingActivity = this;
            if (NewFeatureVisibilityHelper.hasFeatureBeenDiscovered(editingActivity, NewFeatureVisibilityHelper.Key.DRAFT_SECTION)) {
                return;
            }
            NewFeatureVisibilityHelper.markFeatureDiscovered$default(editingActivity, NewFeatureVisibilityHelper.Key.DRAFT_SECTION, false, 2, null);
            return;
        }
        if (stringRes != 0) {
            String str = BANNER_ID_TRANSIENT + SystemClock.uptimeMillis();
            BannerViewModel bannerViewModel = getBannerViewModel();
            String string = getString(stringRes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            bannerViewModel.push(new Banner.FeedbackBanner(str, string, Type.TRANSIENT, null, null, null, null, false, 0, 504, null));
        }
    }

    @Override // com.myscript.nebo.editing.PageFragment.INotificationBannerCallback
    public void onShowNotificationBanner(PageKey pageKey, PageType pageType, MessageIdentifier messageIdentifier) {
        Intrinsics.checkNotNullParameter(messageIdentifier, "messageIdentifier");
        HapticFeedbackManager hapticFeedbackManager = null;
        switch (WhenMappings.$EnumSwitchMapping$1[messageIdentifier.ordinal()]) {
            case 1:
                if (pageKey != null && pageType != null) {
                    String strPageId = pageKey.pageId();
                    getBannerViewModel().dismiss(BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED + strPageId, false);
                    BannerViewModel bannerViewModel = getBannerViewModel();
                    String str = BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED + strPageId;
                    String string = getString(C6079R.string.long_note_banner_message_soft);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    bannerViewModel.push(new Banner.CorruptedBanner(str, string, Type.PERMANENT, pageType != PageType.PDF ? getString(C6079R.string.long_note_banner_cta) : null, pageType != PageType.PDF ? new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda30
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.openNewPage();
                        }
                    } : null, null, null, false, 0, 256, null), true);
                }
                getLogger().setKeyValue(LONG_PAGE_ANALYTICS_KEY, LONG_PAGE_ANALYTICS_VALUE_SOFT);
                break;
            case 2:
                if (pageKey != null && pageType != null) {
                    final String strPageId2 = pageKey.pageId();
                    getBannerViewModel().dismiss(BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED + strPageId2, false);
                    BannerViewModel bannerViewModel2 = getBannerViewModel();
                    String str2 = BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED + strPageId2;
                    String string2 = getString(C6079R.string.long_note_banner_message_hard);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    bannerViewModel2.push(new Banner.WarningBanner(str2, string2, Type.PERMANENT_FORCED, pageType != PageType.PDF ? getString(C6079R.string.long_note_banner_cta) : null, pageType != PageType.PDF ? new Runnable() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda31
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditingActivity.onShowNotificationBanner$lambda$1(this.f$0, strPageId2);
                        }
                    } : null, null, null, false, 0, 256, null), true);
                }
                getLogger().setKeyValue(LONG_PAGE_ANALYTICS_KEY, LONG_PAGE_ANALYTICS_VALUE_HARD);
                break;
            case 3:
                if (pageKey != null) {
                    String strPageId3 = pageKey.pageId();
                    getBannerViewModel().dismiss(BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED + strPageId3, false);
                    getBannerViewModel().dismiss(BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED + strPageId3, false);
                }
                getLogger().setKeyValue(LONG_PAGE_ANALYTICS_KEY, LONG_PAGE_ANALYTICS_VALUE_OK);
                break;
            case 4:
                BannerViewModel bannerViewModel3 = getBannerViewModel();
                String str3 = BANNER_ID_MATH_BLOCK_LIMIT_REACHED + System.currentTimeMillis();
                String string3 = getString(C6079R.string.long_page_math_block_message);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                bannerViewModel3.push(new Banner.CorruptedBanner(str3, string3, Type.TRANSIENT, null, null, null, null, false, 0, 504, null));
                break;
            case 5:
            case 6:
            case 7:
                if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(C6693R.string.pref_pen_haptic_feedback_key), getResources().getBoolean(C6079R.bool.pref_enable_pen_haptic_feedback_default)) && this.isStylusWriting) {
                    HapticFeedbackManager hapticFeedbackManager2 = this.hapticFeedbackManager;
                    if (hapticFeedbackManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hapticFeedbackManager");
                    } else {
                        hapticFeedbackManager = hapticFeedbackManager2;
                    }
                    hapticFeedbackManager.onEvent();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowNotificationBanner$lambda$1(EditingActivity editingActivity, String str) {
        editingActivity.getBannerViewModel().dismiss(BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED + str, false);
        editingActivity.openNewPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchStateUpdate(SearchPageState searchState) {
        if (!searchState.isActive()) {
            invalidateOptionsMenu();
        }
        View view = this.searchResultsToolbar;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultsToolbar");
            view = null;
        }
        view.setVisibility(searchState.isSearchToolbarVisible() ? 0 : 8);
        TextView textView = this.hitsSearchTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hitsSearchTextView");
            textView = null;
        }
        textView.setVisibility(searchState.isResultsCountVisible() ? 0 : 8);
        View view3 = this.searchProgress;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchProgress");
        } else {
            view2 = view3;
        }
        view2.setVisibility(searchState.isProgressVisible() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHitNavStateUpdate(SearchHitNavState hitNavState) {
        int hitCount = hitNavState.getHitCount();
        TextView textView = this.hitsSearchTextView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hitsSearchTextView");
            textView = null;
        }
        textView.setText(getResources().getQuantityString(C6079R.plurals.search_hits, hitCount, Integer.valueOf(hitCount)));
        TextView textView3 = this.navHitsSearchTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navHitsSearchTextView");
            textView3 = null;
        }
        textView3.setText(getString(C6079R.string.search_results_nav, new Object[]{Integer.valueOf(hitNavState.getCurrentHitNumber()), Integer.valueOf(hitCount)}));
        View view = this.searchNextButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchNextButton");
            view = null;
        }
        view.setVisibility(hitNavState.getIsVisible() ? 0 : 8);
        View view2 = this.searchPreviousButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchPreviousButton");
            view2 = null;
        }
        view2.setVisibility(hitNavState.getIsVisible() ? 0 : 8);
        TextView textView4 = this.navHitsSearchTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navHitsSearchTextView");
        } else {
            textView2 = textView4;
        }
        textView2.setVisibility(hitNavState.getIsVisible() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchHistoryUpdate(List<String> history) {
        getSearchHistoryAdapter().clear();
        getSearchHistoryAdapter().addAll(history);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void homePressed() {
        saveStateBeforeLeaving$default(this, 0, 1, null);
        NavUtils.navigateUpFromSameTask(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Super method deprecated")
    public void onBackPressed() {
        saveStateBeforeLeaving$default(this, 0, 1, null);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        saveStateBeforeLeaving$default(this, 0, 1, null);
        return super.onNavigateUp();
    }

    static /* synthetic */ void saveStateBeforeLeaving$default(EditingActivity editingActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        editingActivity.saveStateBeforeLeaving(i);
    }

    private final void saveStateBeforeLeaving(int result) {
        String noteCrashCountKey = getCrashCountState().getNoteCrashCountKey();
        if (noteCrashCountKey != null) {
            getCrashCountState().resetCrashCount(noteCrashCountKey);
        }
        getCrashCountState().setNoteCrashCountKey(null);
        getLibraryRepository().setLastOpenedNoteKey(null);
        setResult(result, INSTANCE.getResultPageIntent(this, getNoteEditorViewModel().getOpenNoteProperties().getPageKey()));
    }

    private final void onPenDetected() {
        EditingActivity editingActivity = this;
        CommonUtils.savePenUsed(editingActivity, true);
        CommonUtils.saveActivePenMode(editingActivity, true);
        onShowNotificationBanner(C6079R.string.interaction_banner_pen_detection);
    }

    @Override // com.myscript.nebo.NeboBaseActivity, com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.Callback
    public SharePageDialog.PageUpdateProvider getPageUpdateProvider() {
        return this.pageUpdateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestNewNoteName() {
        NoteProperties openNoteProperties = getNoteEditorViewModel().getOpenNoteProperties();
        if (!openNoteProperties.getIsEditable() || openNoteProperties.getPageKey() == null) {
            return;
        }
        NoteNameDialog noteNameDialogNewInstance = NoteNameDialog.INSTANCE.newInstance(openNoteProperties.getPageKey(), openNoteProperties.getNoteName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        noteNameDialogNewInstance.show(supportFragmentManager);
    }

    private final void addChildPagesFragment() {
        ChildPagesFragment childPagesFragmentNewInstance = this.childPagesFragment;
        if (childPagesFragmentNewInstance == null) {
            childPagesFragmentNewInstance = ChildPagesFragment.INSTANCE.newInstance();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(C6079R.id.child_pages_side_panel, childPagesFragmentNewInstance, ChildPagesFragment.TAG);
            fragmentTransactionBeginTransaction.commit();
        }
        this.childPagesFragment = childPagesFragmentNewInstance;
    }

    private final void onShowPaywall(final String origin) {
        this.showPaywallDialog.setValue(true);
        ComposeView composeView = this.paywallView;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-237102274, true, new Function2() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditingActivity.onShowPaywall$lambda$0(this.f$0, origin, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowPaywall$lambda$0(final EditingActivity editingActivity, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2184@101446L35,2185@101513L35,2180@101264L298:EditingActivity.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-237102274, i, -1, "com.myscript.nebo.editing.EditingActivity.onShowPaywall.<anonymous> (EditingActivity.kt:2180)");
            }
            boolean zBooleanValue = editingActivity.showPaywallDialog.getValue().booleanValue();
            PaywallViewModel paywallViewModel = editingActivity.getPaywallViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -222012319, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(editingActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onShowPaywall$lambda$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -222010175, "CC(remember):EditingActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(editingActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditingActivity.onShowPaywall$lambda$0$1$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PaywallKt.PaywallDialog(zBooleanValue, paywallViewModel, str, function0, (Function0) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowPaywall$lambda$0$0$0(EditingActivity editingActivity) {
        editingActivity.showPaywallDialog.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowPaywall$lambda$0$1$0(EditingActivity editingActivity) {
        editingActivity.showPaywallDialog.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: EditingActivity.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0003J$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/editing/EditingActivity$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_KEY_ARGUMENT", "PAGE_CONTENT_TYPE_ARGUMENT", "CORRUPTED_PAGE_RESULT_CODE", "", "CRASHED_AT_LOAD_PAGE_RESULT_CODE", "CLOSE_PAGE_FORCED_CODE", "BANNER_ID_CORRUPTED_PAGE", "BANNER_ID_KNOWLEDGE_BASE", "BANNER_ID_TRANSIENT", "BANNER_ID_LONG_PAGE_SOFT_LIMIT_REACHED", "BANNER_ID_LONG_PAGE_HARD_LIMIT_REACHED", "BANNER_ID_MATH_BLOCK_LIMIT_REACHED", "LONG_PAGE_ANALYTICS_KEY", "LONG_PAGE_ANALYTICS_VALUE_OK", "LONG_PAGE_ANALYTICS_VALUE_SOFT", "LONG_PAGE_ANALYTICS_VALUE_HARD", "getResultPageIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "getPageIntent", "contentType", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Deprecated(message = "Only used for setResult without contentType information. We should store content type and give it to `getPageIntent()`.")
        public final Intent getResultPageIntent(Context context, PageKey pageKey) {
            return getPageIntent(context, pageKey, null);
        }

        @JvmStatic
        public final Intent getPageIntent(Context context, PageKey pageKey, String contentType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) EditingActivity.class);
            if (pageKey != null) {
                intent.putExtra(EditingActivity.PAGE_KEY_ARGUMENT, pageKey.serialize());
            }
            if (contentType != null) {
                intent.putExtra(EditingActivity.PAGE_CONTENT_TYPE_ARGUMENT, contentType);
            }
            return intent;
        }
    }

    private final void restoreSelectedChildPage(List<ChildPage> pages) {
        ViewPager2 viewPager2;
        Iterator<ChildPage> it = pages.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().isActive()) {
                break;
            } else {
                i++;
            }
        }
        ViewPager2 viewPager22 = this.childPagesViewPager;
        if (i == (viewPager22 != null ? viewPager22.getCurrentItem() : -1) || i < 0 || i >= this.childPagesPagerAdapter.getItemCount() || (viewPager2 = this.childPagesViewPager) == null) {
            return;
        }
        viewPager2.setCurrentItem(i, false);
    }

    private static final NeboNetworkState onCreate$lambda$17$0$1(State<? extends NeboNetworkState> state) {
        return state.getValue();
    }

    private static final boolean onCreate$lambda$17$0$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
