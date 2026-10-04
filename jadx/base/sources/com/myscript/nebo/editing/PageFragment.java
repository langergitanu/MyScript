package com.myscript.nebo.editing;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.C0028R;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.MenuKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.credentials.provider.CredentialEntry;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ContextualMenu;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewExt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.Box;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.IURIListener;
import com.myscript.atk.core.KeyboardAction;
import com.myscript.atk.core.MessageIdentifier;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.SWIGVectorExtent;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.p021ui.ActionMenuCallback;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.SmartGuideController;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.banner.Banner;
import com.myscript.nebo.banner.BannerViewModel;
import com.myscript.nebo.banner.Type;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.common.utils.PopupUtils;
import com.myscript.nebo.common.utils.TouchUtils;
import com.myscript.nebo.crash.ICrashCountState;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.PdfOptimizationLevel;
import com.myscript.nebo.dms.core.PdfOptimizationResult;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.nebo.dms.sharepage.dialog.SharePageDialog;
import com.myscript.nebo.editing.CanvasContentDropTarget;
import com.myscript.nebo.editing.CropImageDialog;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.ImageImportState;
import com.myscript.nebo.editing.PageFragment;
import com.myscript.nebo.editing.PageViewModel;
import com.myscript.nebo.editing.impl.p027ui.ContextualMenuManager;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.nebo.editing.impl.p027ui.ITouchFeature;
import com.myscript.nebo.editing.impl.p027ui.InteractionContext;
import com.myscript.nebo.editing.impl.p027ui.LocalActionMenuHandler;
import com.myscript.nebo.editing.search.SearchHitNavState;
import com.myscript.nebo.editing.search.SearchPageViewModel;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.featureflags.RuntimeFeatureFlagHelper;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.p022ai.domain.AIActionMenuHandler;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.p034ui.compose.PdfOptimizationKt;
import com.myscript.nebo.penpanel.ColorNonePill;
import com.myscript.nebo.penpanel.ColorPill;
import com.myscript.nebo.penpanel.ToolbarViewModel;
import com.myscript.nebo.penpanel.ToolbarViewModelFactory;
import com.myscript.nebo.penpanel.WritingSettings;
import com.myscript.nebo.userdict.C6889R;
import com.myscript.nebo.utils.EarlyAccessFeature;
import com.myscript.nebo.utils.FileUriExtKt;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.CrossSellFilter;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.snt.core.GestureType;
import com.myscript.snt.core.IEventListener;
import com.myscript.snt.core.IReflowSessionListener;
import com.myscript.snt.core.LayoutGrid;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.core.SWIGAngle;
import com.myscript.snt.core.SearchMatch;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfigurationExt;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.TextRecallingManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0098\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f*\u0004\u0092\u0001\u0095\u0001\b\u0007\u0018\u0000 ¥\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\n¡\u0002¢\u0002£\u0002¤\u0002¥\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J,\u0010\u009d\u0001\u001a\u0004\u0018\u00010_2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010Y2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\u001f\u0010¡\u0001\u001a\u00030\u009a\u00012\u0007\u0010¢\u0001\u001a\u00020_2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030\u009a\u0001H\u0017J\f\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0002J\n\u0010§\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010©\u0001\u001a\u00030\u009a\u0001H\u0016J\u0014\u0010ª\u0001\u001a\u00030\u009a\u00012\b\u0010«\u0001\u001a\u00030\u009c\u0001H\u0016J\n\u0010¬\u0001\u001a\u00030\u009a\u0001H\u0017J\n\u0010\u00ad\u0001\u001a\u00030\u009a\u0001H\u0016J\u001d\u0010®\u0001\u001a\u00020<2\b\u0010¯\u0001\u001a\u00030°\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\t\u0010³\u0001\u001a\u00020<H\u0002J\u001d\u0010´\u0001\u001a\u00020<2\b\u0010¯\u0001\u001a\u00030°\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u001d\u0010µ\u0001\u001a\u00020<2\b\u0010¯\u0001\u001a\u00030°\u00012\b\u0010¶\u0001\u001a\u00030\u0090\u0001H\u0016J&\u0010·\u0001\u001a\u00020<2\u000f\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010¹\u00012\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\u0014\u0010¼\u0001\u001a\u00030\u009a\u00012\b\u0010±\u0001\u001a\u00030°\u0001H\u0016J'\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010¢\u0001\u001a\u00020_2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\u0014\u0010À\u0001\u001a\u00030\u009a\u00012\b\u0010Á\u0001\u001a\u00030Â\u0001H\u0016J\u0014\u0010À\u0001\u001a\u00030\u009a\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0016J\n\u0010Å\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010Æ\u0001\u001a\u00030\u009a\u0001H\u0016J\u001c\u0010Ç\u0001\u001a\u00020<2\u0007\u0010È\u0001\u001a\u00020_2\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00020<2\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0002J\u0014\u0010Î\u0001\u001a\u00030\u009a\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u009a\u0001H\u0002J\u001d\u0010Ò\u0001\u001a\u00030\u009a\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0007\u0010Õ\u0001\u001a\u00020<H\u0002J\u0014\u0010Ö\u0001\u001a\u00030\u009a\u00012\b\u0010×\u0001\u001a\u00030\u0085\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00030\u009a\u00012\u0007\u0010Ù\u0001\u001a\u00020?H\u0002J\u0014\u0010Ú\u0001\u001a\u00030\u009a\u00012\b\u0010Û\u0001\u001a\u00030Í\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u009a\u0001H\u0002J\b\u0010â\u0001\u001a\u00030\u009a\u0001J\n\u0010ã\u0001\u001a\u00030\u009a\u0001H\u0002J\b\u0010æ\u0001\u001a\u00030\u009a\u0001J\u0014\u0010ç\u0001\u001a\u00030\u009a\u00012\b\u0010è\u0001\u001a\u00030Í\u0001H\u0002J\u0014\u0010é\u0001\u001a\u00030\u009a\u00012\b\u0010Ï\u0001\u001a\u00030ê\u0001H\u0002J\u0013\u0010ë\u0001\u001a\u00030\u009a\u00012\u0007\u0010ì\u0001\u001a\u00020|H\u0002J&\u0010í\u0001\u001a\u00030\u009a\u00012\b\u0010î\u0001\u001a\u00030ï\u00012\u0007\u0010ð\u0001\u001a\u00020T2\u0007\u0010ñ\u0001\u001a\u00020TH\u0002J\u001c\u0010ò\u0001\u001a\u00030\u009a\u00012\u0006\u0010k\u001a\u00020l2\b\u0010ó\u0001\u001a\u00030ô\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u009a\u0001H\u0002J\u0013\u0010ö\u0001\u001a\u00020<2\b\u0010¶\u0001\u001a\u00030\u0090\u0001H\u0002J\u0016\u0010÷\u0001\u001a\u00030\u009a\u00012\n\u0010ø\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0003J=\u0010ù\u0001\u001a\u00030\u009a\u00012\b\u0010+\u001a\u0004\u0018\u00010,2\u0010\u0010ú\u0001\u001a\u000b\u0012\u0005\u0012\u00030û\u0001\u0018\u0001012\n\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u00012\t\u0010J\u001a\u0005\u0018\u00010þ\u0001H\u0002J\n\u0010ÿ\u0001\u001a\u00030\u009a\u0001H\u0003J\n\u0010\u0080\u0002\u001a\u00030\u009a\u0001H\u0002J\n\u0010\u0081\u0002\u001a\u00030\u009a\u0001H\u0002J\n\u0010\u0082\u0002\u001a\u00030\u009a\u0001H\u0002J\u0014\u0010\u0083\u0002\u001a\u00030\u009a\u00012\b\u0010\u0084\u0002\u001a\u00030Í\u0001H\u0002J\u0014\u0010\u0085\u0002\u001a\u00030\u009a\u00012\b\u0010\u0084\u0002\u001a\u00030Í\u0001H\u0002J\n\u0010\u0086\u0002\u001a\u00030\u009a\u0001H\u0002J\u001a\u0010\u0087\u0002\u001a\u00020<2\u0007\u0010\u0088\u0002\u001a\u00020z2\b\u0010É\u0001\u001a\u00030\u0089\u0002J\b\u0010\u008a\u0002\u001a\u00030\u009a\u0001J1\u0010\u008b\u0002\u001a\u00030\u009a\u00012'\u0010\u008c\u0002\u001a\"\u0012\u0016\u0012\u001407¢\u0006\u000f\b\u008e\u0002\u0012\n\b\u008f\u0002\u0012\u0005\b\b(\u0090\u0002\u0012\u0005\u0012\u00030\u009a\u00010\u008d\u0002J\u001e\u0010\u0091\u0002\u001a\u00030\u009a\u00012\b\u0010\u0092\u0002\u001a\u00030Í\u00012\b\u0010\u0084\u0002\u001a\u00030Í\u0001H\u0002J\u0011\u0010\u0093\u0002\u001a\u00030\u009a\u00012\u0007\u0010\u0094\u0002\u001a\u00020TJ\b\u0010\u0095\u0002\u001a\u00030\u009a\u0001J\u0011\u0010\u0096\u0002\u001a\u00030\u009a\u00012\u0007\u0010\u0097\u0002\u001a\u00020zJ\u0012\u0010\u0098\u0002\u001a\u00030\u009a\u00012\b\u0010\u0099\u0002\u001a\u00030\u009a\u0002J\t\u0010\u009b\u0002\u001a\u00020<H\u0002J\t\u0010\u009c\u0002\u001a\u00020<H\u0002J\b\u0010\u009d\u0002\u001a\u00030\u009a\u0001J\n\u0010\u009e\u0002\u001a\u00030\u009a\u0001H\u0002J\n\u0010\u009f\u0002\u001a\u00030\u009a\u0001H\u0002J\n\u0010 \u0002\u001a\u00030\u009a\u0001H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001b\u001a\u00020\u001c8BX\u0083\u0084\u0002¢\u0006\u0012\n\u0004\b \u0010\u000b\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010,8FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010/R!\u00100\u001a\b\u0012\u0004\u0012\u000202018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104R\u001e\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010E\u001a\u0004\u0018\u00010D2\b\u00106\u001a\u0004\u0018\u00010D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\u0004\u0018\u00010[8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010b\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010r\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010y\u001a\u00020z8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0082\u0001\u001a\u00020<8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010cR\u0018\u0010\u0084\u0001\u001a\u00030\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u0088\u0001\u001a\u00020<8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010cR\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0093\u0001R\u0013\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0096\u0001R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010Ý\u0001\u001a\"\u0012\u001d\u0012\u001b\u0012\u0005\u0012\u00030Í\u0001 à\u0001*\f\u0012\u0005\u0012\u00030Í\u0001\u0018\u00010ß\u00010ß\u00010Þ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010á\u0001\u001a\u0012\u0012\r\u0012\u000b à\u0001*\u0004\u0018\u00010|0|0Þ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010ä\u0001\u001a\u0014\u0012\u000f\u0012\r à\u0001*\u0005\u0018\u00010å\u00010å\u00010Þ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¦\u0002"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "Lcom/myscript/nebo/editing/impl/ui/InteractionContext;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "bannerViewModel", "Lcom/myscript/nebo/banner/BannerViewModel;", "getBannerViewModel", "()Lcom/myscript/nebo/banner/BannerViewModel;", "bannerViewModel$delegate", "pageViewModel", "Lcom/myscript/nebo/editing/PageViewModel;", "getPageViewModel", "()Lcom/myscript/nebo/editing/PageViewModel;", "pageViewModel$delegate", "searchViewModel", "Lcom/myscript/nebo/editing/search/SearchPageViewModel;", "getSearchViewModel", "()Lcom/myscript/nebo/editing/search/SearchPageViewModel;", "searchViewModel$delegate", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "getLibraryRepository$annotations", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "libraryRepository$delegate", "toolbarViewModel", "Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "getToolbarViewModel", "()Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "toolbarViewModel$delegate", "crashCountState", "Lcom/myscript/nebo/crash/ICrashCountState;", "getCrashCountState", "()Lcom/myscript/nebo/crash/ICrashCountState;", "crashCountState$delegate", "pageController", "Lcom/myscript/snt/core/PageController;", "getPageController$annotations", "getPageController", "()Lcom/myscript/snt/core/PageController;", "customResources", "", "Lcom/myscript/atk/core/CustomResource;", "getCustomResources", "()Ljava/util/List;", "customResources$delegate", "value", "Lcom/myscript/snt/core/PageKey;", "openedPageKey", "getOpenedPageKey", "()Lcom/myscript/snt/core/PageKey;", PageFragment.ALLOW_TRY_RELOAD_ARGUMENT, "", "scrollToBottom", "openedPageProperties", "Lcom/myscript/nebo/editing/PageProperties;", "getOpenedPageProperties", "()Lcom/myscript/nebo/editing/PageProperties;", "contextualMenuManager", "Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager;", "Lcom/myscript/nebo/editing/EditingController;", "editingController", "getEditingController", "()Lcom/myscript/nebo/editing/EditingController;", "smartGuideController", "Lcom/myscript/nebo/SmartGuideController;", "callback", "Lcom/myscript/nebo/editing/PageFragment$Callback;", "notificationBannerCallback", "Lcom/myscript/nebo/editing/PageFragment$INotificationBannerCallback;", "zoomCallback", "Lcom/myscript/nebo/editing/PageFragment$IZoomCallback;", "isFirstReflowDone", "writingSettings", "Lcom/myscript/nebo/penpanel/WritingSettings;", TtmlNode.ATTR_TTS_FONT_SIZE, "", "lineHeight", "styleProperties", "Lcom/myscript/snt/core/LayoutGrid$StyleProperties;", "editingLayout", "Landroid/view/ViewGroup;", "renderingView", "Lcom/myscript/nebo/editing/impl/ui/DocumentRenderingView;", "getRenderingView", "()Lcom/myscript/nebo/editing/impl/ui/DocumentRenderingView;", "touchInterceptor", "Landroid/view/View;", "neboQuickToolControl", "Lcom/myscript/nebo/editing/NeboQuickToolControl;", "isSpenToolboxVisible", "()Z", "spenHoverCursor", "Lcom/myscript/nebo/editing/SpenHoverCursor;", "spenHoverCursorActive", "spenQuickToolTrigger", "Lcom/myscript/nebo/editing/SpenQuickToolTrigger;", "blockPosition", "Lcom/myscript/atk/core/PointerInfo;", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "optimizationOverlay", "pdfOptimDialogView", "Landroidx/compose/ui/platform/ComposeView;", "loadingProgress", "loadFailPlaceholder", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "handler", "Landroid/os/Handler;", PageFragment.CONTEXTUAL_MENU_GROUP_ID, "", "pendingCameraImageUri", "Landroid/net/Uri;", "canvasDropTarget", "Lcom/myscript/nebo/editing/CanvasContentDropTarget;", "pendingDropPermissions", "Landroidx/core/view/DragAndDropPermissionsCompat;", "isAIEnabled", "activePenEnabled", "getActivePenEnabled", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "getCurrentToolType", "()Lcom/myscript/snt/core/ToolType;", "isCurrentToolInteracting", "onPreferenceChange", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "onReflowUpdate", "Lcom/myscript/snt/core/IReflowSessionListener;", "zoomController", "Lcom/myscript/nebo/editing/EditingController$ZoomController;", "searchMenuItem", "Landroid/view/MenuItem;", "menuProvider", "com/myscript/nebo/editing/PageFragment$menuProvider$1", "Lcom/myscript/nebo/editing/PageFragment$menuProvider$1;", "onTouchGesture", "com/myscript/nebo/editing/PageFragment$onTouchGesture$1", "Lcom/myscript/nebo/editing/PageFragment$onTouchGesture$1;", "onCanvasUriClicked", "Lcom/myscript/atk/core/IURIListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "onViewCreated", "view", "onDestroyView", "onStart", "getSelectedImage", "Ljava/io/File;", "cropSelectedImage", "onResume", "onPause", "onSaveInstanceState", "outState", "onStop", "onDestroy", "onCreateContextualMenu", "contextualMenu", "Lcom/myscript/android/utils/ContextualMenu;", "menu", "Landroid/view/Menu;", "isInlineSelectionOnPdfContent", "onPrepareContextualMenu", "onContextualMenuItemClicked", "item", "onContextualActionRequested", "action", "Lkotlin/Function0;", "userData", "", "onDestroyContextualMenu", "onGetContentRect", "outRect", "Landroid/graphics/Rect;", "onAttach", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "internalOnAttach", "onDetach", "onPageTouchIntercepted", "v", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "isSmartGuideSupported", "contentType", "", "bindPageController", "state", "Lcom/myscript/nebo/editing/PageViewModel$State$Loaded;", "unbindPageController", "configureInkCapture", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "enableActivePen", "reconfigureInkCapture", "selectedToolType", "onPagePropertiesUpdate", "pageProperties", "exportToPowerPoint", "boxId", "showCameraPermissionRationaleDialog", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "imageCaptureLauncher", "requestImageCapture", "doRequestImageCapture", "pickImageLauncher", "Landroidx/activity/result/PickVisualMediaRequest;", "requestImagePick", "createAndAddBlock", "blockType", "onImageImportStateUpdate", "Lcom/myscript/nebo/editing/ImageImportState;", "streamImageToPage", "uri", "onContentDroppedOnCanvas", FirebaseAnalytics.Param.CONTENT, "Lcom/myscript/nebo/editing/CanvasContentDropTarget$DroppedContent;", "viewX", "viewY", "onPopupMenuCreated", "popupInfo", "Lcom/myscript/nebo/common/utils/PopupUtils$PopupInfoSaveInstanceState;", "resetPopupMenu", "onPopupMenuItemClick", "addWordIntoDictionary", "word", "showActionMenuEntries", "actionMenuEntries", "Lcom/myscript/atk/ui/ActionMenuEntry;", "inputPoint", "Lcom/myscript/atk/core/Point;", "Lcom/myscript/atk/ui/ActionMenuCallback;", "updateOptionsMenu", "openSharePageDialog", "showPdfOptimizationDialogView", "hidePdfOptimizationDialog", "showOptimizationOverlay", "message", "showOptimizationResult", "hideOptimizationOverlay", "onKeyShortcut", "keyCode", "Landroid/view/KeyEvent;", "closeKeyboard", "createSiblingPage", "updateOpenNote", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", PageFragment.PAGE_KEY_ARGUMENT, "tagCorruptionWarningInfoPage", "reason", "zoom", "zoomFactor", "toggleLockZoom", "setBackgroundColor", "color", "setBackgroundPattern", "pattern", "Lcom/myscript/atk/core/BackgroundPattern;", "loadCrashLoopDetected", "loadFailureDetected", "tryReloadAfterLoadFailure", "enableForceRestoreScrollPositionForNotebook", "disableForceRestoreScrollPositionForNotebook", "updateHoverCursor", "Callback", "INotificationBannerCallback", "IZoomCallback", "PickImage", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageFragment extends Fragment implements ContextualMenu.Callback, InteractionContext {
    private static final String ALLOW_TRY_RELOAD_ARGUMENT = "allowTryReload";
    private static final String BANNER_ID_USER_DICT = "PageFragment.BANNER_ID_USER_DICT";
    private static final String CONTEXTUAL_MENU_GROUP_ID = "contextualMenuGroupId";
    public static final int CORRUPTED_PAGE_RESULT_CODE = 40;
    private static final String DOUBLE_TAP_ADD_BLOCK_MENU = "DOUBLE_TAP_ADD_BLOCK_MENU";
    private static final String FREEFORM_ADD_BLOCK_MENU = "FREEFORM_ADD_BLOCK_MENU";
    private static final String KEY_CAMERA_FILE_URI = "CAMERA_FILE_URI";
    private static final String LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU = "LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU";
    private static final String PAGE_KEY_ARGUMENT = "pageKey";
    public static final String TAG = "PageFragment";
    private boolean allowTryReload;

    /* JADX INFO: renamed from: bannerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy bannerViewModel;
    private PointerInfo blockPosition;
    private Callback callback;
    private final ActivityResultLauncher<String[]> cameraPermissionLauncher;
    private CanvasContentDropTarget canvasDropTarget;
    private int contextualMenuGroupId;
    private final ContextualMenuManager contextualMenuManager;

    /* JADX INFO: renamed from: crashCountState$delegate, reason: from kotlin metadata */
    private final Lazy crashCountState;

    /* JADX INFO: renamed from: customResources$delegate, reason: from kotlin metadata */
    private final Lazy customResources;
    private EditingController editingController;
    private ViewGroup editingLayout;
    private float fontSize;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;
    private final Handler handler;
    private final ActivityResultLauncher<Uri> imageCaptureLauncher;
    private boolean isAIEnabled;
    private boolean isFirstReflowDone;

    /* JADX INFO: renamed from: libraryRepository$delegate, reason: from kotlin metadata */
    private final Lazy libraryRepository;
    private float lineHeight;
    private View loadFailPlaceholder;
    private View loadingProgress;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PageFragment.logger_delegate$lambda$0(this.f$0);
        }
    });
    private final PageFragment$menuProvider$1 menuProvider;
    private NeboQuickToolControl neboQuickToolControl;
    private INotificationBannerCallback notificationBannerCallback;
    private final IURIListener onCanvasUriClicked;
    private final SharedPreferences.OnSharedPreferenceChangeListener onPreferenceChange;
    private final IReflowSessionListener onReflowUpdate;
    private final PageFragment$onTouchGesture$1 onTouchGesture;
    private PageKey openedPageKey;
    private View optimizationOverlay;

    /* JADX INFO: renamed from: pageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy pageViewModel;
    private ComposeView pdfOptimDialogView;
    private Uri pendingCameraImageUri;
    private DragAndDropPermissionsCompat pendingDropPermissions;
    private final ActivityResultLauncher<PickVisualMediaRequest> pickImageLauncher;
    private PopupMenu popupMenu;
    private boolean scrollToBottom;
    private MenuItem searchMenuItem;

    /* JADX INFO: renamed from: searchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy searchViewModel;
    private SmartGuideController smartGuideController;
    private SpenHoverCursor spenHoverCursor;
    private boolean spenHoverCursorActive;
    private final SpenQuickToolTrigger spenQuickToolTrigger;
    private LayoutGrid.StyleProperties styleProperties;

    /* JADX INFO: renamed from: toolbarViewModel$delegate, reason: from kotlin metadata */
    private final Lazy toolbarViewModel;
    private View touchInterceptor;
    private WritingSettings writingSettings;
    private IZoomCallback zoomCallback;
    private final EditingController.ZoomController zoomController;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&¨\u0006\u001cÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment$Callback;", "", "onPageReady", "", PageFragment.PAGE_KEY_ARGUMENT, "Lcom/myscript/snt/core/PageKey;", "onPageStateUpdated", "state", "Lcom/myscript/nebo/editing/PageViewModel$State;", "pageProperties", "Lcom/myscript/nebo/editing/PageProperties;", "onPagePropertiesChanged", "onFinish", "resultCode", "", "onForceFinish", "result", "onShouldScrollToBottom", "", "tag", "", "onExplainSelection", "onSummarizeSelection", "onQuizSelection", "notifyScratchOutGesture", "notifyDocumentTextBoxAdded", "notifyTextBoxAdded", "notifyHoldItemAdded", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void notifyDocumentTextBoxAdded();

        void notifyHoldItemAdded();

        void notifyScratchOutGesture();

        void notifyTextBoxAdded();

        void onExplainSelection();

        void onFinish(int resultCode, PageKey pageKey);

        void onForceFinish(int result);

        void onPagePropertiesChanged(PageKey pageKey, PageProperties pageProperties);

        void onPageReady(PageKey pageKey);

        void onPageStateUpdated(PageViewModel.State state, PageProperties pageProperties);

        void onQuizSelection();

        boolean onShouldScrollToBottom(String tag);

        void onSummarizeSelection();
    }

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment$INotificationBannerCallback;", "", "onShowNotificationBanner", "", "stringRes", "", PageFragment.PAGE_KEY_ARGUMENT, "Lcom/myscript/snt/core/PageKey;", "pageType", "Lcom/myscript/snt/dms/PageType;", "messageIdentifier", "Lcom/myscript/atk/core/MessageIdentifier;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface INotificationBannerCallback {
        void onShowNotificationBanner(int stringRes);

        void onShowNotificationBanner(PageKey pageKey, PageType pageType, MessageIdentifier messageIdentifier);
    }

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment$IZoomCallback;", "", "onZoomChanged", "", "zoomState", "Lcom/myscript/nebo/editing/ZoomState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IZoomCallback {
        void onZoomChanged(ZoomState zoomState);
    }

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[MessageIdentifier.values().length];
            try {
                iArr[MessageIdentifier.LOCKED_GESTURE_SCRATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageIdentifier.LOCKED_GESTURE_ON_HOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PdfOptimizationResult.values().length];
            try {
                iArr2[PdfOptimizationResult.OPTIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PdfOptimizationResult.ALREADY_OPTIMIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PdfOptimizationResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ActionMenuEntry.values().length];
            try {
                iArr3[ActionMenuEntry.CONVERT_MATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ActionMenuEntry.CONVERT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ActionMenuEntry.AI_SUMMARIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ActionMenuEntry.AI_EXPLAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ActionMenuEntry.AI_QUIZ.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[PdfOptimizationLevel.values().length];
            try {
                iArr4[PdfOptimizationLevel.BEST_QUALITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[PdfOptimizationLevel.BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[PdfOptimizationLevel.BEST_PERFORMANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    @Deprecated(message = "Repository shouldn't be used directly from UI layer but through ViewModel")
    private static /* synthetic */ void getLibraryRepository$annotations() {
    }

    public static /* synthetic */ void getPageController$annotations() {
    }

    @JvmStatic
    public static final PageFragment newInstance(PageKey pageKey, boolean z) {
        return INSTANCE.newInstance(pageKey, z);
    }

    public PageFragment() {
        final PageFragment pageFragment = this;
        final Function0 function0 = null;
        this.bannerViewModel = FragmentViewModelLazyKt.createViewModelLazy(pageFragment, Reflection.getOrCreateKotlinClass(BannerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return pageFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? pageFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return pageFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Function0 function02 = new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.pageViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return pageFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.pageViewModel = FragmentViewModelLazyKt.createViewModelLazy(pageFragment, Reflection.getOrCreateKotlinClass(PageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
        this.searchViewModel = FragmentViewModelLazyKt.createViewModelLazy(pageFragment, Reflection.getOrCreateKotlinClass(SearchPageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return pageFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? pageFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.searchViewModel_delegate$lambda$0();
            }
        });
        this.libraryRepository = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.libraryRepository_delegate$lambda$0(this.f$0);
            }
        });
        this.toolbarViewModel = FragmentViewModelLazyKt.createViewModelLazy(pageFragment, Reflection.getOrCreateKotlinClass(ToolbarViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return pageFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? pageFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.toolbarViewModel_delegate$lambda$0(this.f$0);
            }
        });
        this.crashCountState = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.crashCountState_delegate$lambda$0(this.f$0);
            }
        });
        this.customResources = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.customResources_delegate$lambda$0(this.f$0);
            }
        });
        this.contextualMenuManager = new ContextualMenuManager();
        this.spenQuickToolTrigger = new SpenQuickToolTrigger(new Function2() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PageFragment.spenQuickToolTrigger$lambda$0(this.f$0, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(pageFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return pageFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.PageFragment$special$$inlined$activityViewModels$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? pageFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
        this.contextualMenuGroupId = C6079R.id.page_inline_selection_base_group;
        this.onPreferenceChange = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda27
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                PageFragment.onPreferenceChange$lambda$0(this.f$0, sharedPreferences, str);
            }
        };
        this.onReflowUpdate = new ReflowListenerAdapter() { // from class: com.myscript.nebo.editing.PageFragment$onReflowUpdate$1
            @Override // com.myscript.nebo.editing.ReflowListenerAdapter, com.myscript.snt.core.IReflowSessionListener
            public void reflowUpdated(Extent docExtent) {
                if (docExtent != null) {
                    try {
                        if (!this.this$0.isFirstReflowDone && !docExtent.empty()) {
                            this.this$0.isFirstReflowDone = true;
                            PageKey openPageKey = this.this$0.getPageViewModel().getOpenPageKey();
                            if (openPageKey != null) {
                                this.this$0.getSearchViewModel().refreshHitBounds(openPageKey);
                            }
                        }
                    } finally {
                        docExtent.delete();
                    }
                }
            }
        };
        this.zoomController = new EditingController.ZoomController() { // from class: com.myscript.nebo.editing.PageFragment$zoomController$1
            @Override // com.myscript.nebo.editing.EditingController.ZoomController
            public void setZoomChangedListener(EditingController.ZoomChangedListener listener) {
                EditingController editingController = this.this$0.getEditingController();
                if (editingController != null) {
                    editingController.setZoomChangedListener(listener);
                }
            }

            @Override // com.myscript.nebo.editing.EditingController.ZoomController
            public float currentZoom() {
                EditingController editingController = this.this$0.getEditingController();
                if (editingController != null) {
                    return editingController.currentZoom();
                }
                return 0.0f;
            }

            @Override // com.myscript.nebo.editing.EditingController.ZoomController
            public float zoom(float zoom, DocumentTouchController.ZoomListener.ZoomFromReference reference, boolean intermediate) {
                Intrinsics.checkNotNullParameter(reference, "reference");
                EditingController editingController = this.this$0.getEditingController();
                if (editingController != null) {
                    return editingController.zoom(zoom, reference, intermediate);
                }
                return 0.0f;
            }

            @Override // com.myscript.nebo.editing.EditingController.ZoomController
            public boolean checkZoomNotLocked() {
                return this.this$0.getPageViewModel().checkZoomNotLocked();
            }
        };
        this.menuProvider = new PageFragment$menuProvider$1(this);
        this.onTouchGesture = new PageFragment$onTouchGesture$1(this);
        this.onCanvasUriClicked = new IURIListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda14
            @Override // com.myscript.atk.core.IURIListener
            public final void linkActivated(String str) {
                PageFragment.onCanvasUriClicked$lambda$0(this.f$0, str);
            }
        };
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda15
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PageFragment.cameraPermissionLauncher$lambda$0(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda16
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PageFragment.imageCaptureLauncher$lambda$0(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.imageCaptureLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new PickImage(), new ActivityResultCallback() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda17
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PageFragment.pickImageLauncher$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.pickImageLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(PageFragment pageFragment) {
        ComponentCallbacks2 application = pageFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    private final BannerViewModel getBannerViewModel() {
        return (BannerViewModel) this.bannerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PageViewModel getPageViewModel() {
        return (PageViewModel) this.pageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory pageViewModel_delegate$lambda$0(PageFragment pageFragment) {
        return new PageViewModelFactory(DarkModeUtils.isDarkMode(pageFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchPageViewModel getSearchViewModel() {
        return (SearchPageViewModel) this.searchViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory searchViewModel_delegate$lambda$0() {
        return SearchPageViewModel.INSTANCE.getFactory();
    }

    private final LibraryRepository getLibraryRepository() {
        return (LibraryRepository) this.libraryRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LibraryRepository libraryRepository_delegate$lambda$0(PageFragment pageFragment) {
        ComponentCallbacks2 application = pageFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return ((LibraryRepository.Provider) application).provideLibraryRepository();
    }

    private final ToolbarViewModel getToolbarViewModel() {
        return (ToolbarViewModel) this.toolbarViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory toolbarViewModel_delegate$lambda$0(PageFragment pageFragment) {
        String string;
        PageKey pageKeyDeserialize;
        String strContentType;
        Bundle arguments = pageFragment.getArguments();
        if (arguments == null || (string = arguments.getString(PAGE_KEY_ARGUMENT)) == null || (pageKeyDeserialize = PageKey.deserialize(string)) == null) {
            throw new IllegalStateException("PageKey is required to create ToolbarViewModel".toString());
        }
        PageType pageType = pageFragment.getLibraryRepository().getPageType(pageKeyDeserialize);
        if (pageType == null || (strContentType = Page.contentType(pageType)) == null) {
            throw new IllegalStateException(("Can't find page type for " + pageKeyDeserialize).toString());
        }
        return new ToolbarViewModelFactory(strContentType);
    }

    private final ICrashCountState getCrashCountState() {
        return (ICrashCountState) this.crashCountState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationState crashCountState_delegate$lambda$0(PageFragment pageFragment) {
        ComponentCallbacks2 application = pageFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        return ((IApplicationStateProvider) application).provideApplicationState();
    }

    public final PageController getPageController() {
        return getPageViewModel().getPageController();
    }

    private final List<CustomResource> getCustomResources() {
        return (List) this.customResources.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List customResources_delegate$lambda$0(PageFragment pageFragment) {
        Application application = pageFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
        return ((NeboApplication) application).getCustomResources();
    }

    public final PageKey getOpenedPageKey() {
        PageKey pageKey = this.openedPageKey;
        if (pageKey != null) {
            return pageKey;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openedPageKey");
        return null;
    }

    public final PageProperties getOpenedPageProperties() {
        return getPageViewModel().getOpenPageProperties();
    }

    public final EditingController getEditingController() {
        return this.editingController;
    }

    private final DocumentRenderingView getRenderingView() {
        EditingController editingController = this.editingController;
        if (editingController != null) {
            return editingController.getRenderingView();
        }
        return null;
    }

    public final boolean isSpenToolboxVisible() {
        NeboQuickToolControl neboQuickToolControl = this.neboQuickToolControl;
        return neboQuickToolControl != null && neboQuickToolControl.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit spenQuickToolTrigger$lambda$0(PageFragment pageFragment, float f, float f2) {
        NeboQuickToolControl neboQuickToolControl;
        NeboQuickToolControl neboQuickToolControl2 = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl2 != null && neboQuickToolControl2.isVisible()) {
            NeboQuickToolControl neboQuickToolControl3 = pageFragment.neboQuickToolControl;
            if (neboQuickToolControl3 != null) {
                neboQuickToolControl3.hide();
            }
        } else {
            pageFragment.spenHoverCursorActive = true;
            NeboQuickToolControl neboQuickToolControl4 = pageFragment.neboQuickToolControl;
            if (neboQuickToolControl4 != null) {
                neboQuickToolControl4.show(f, f2);
            }
            PageViewModel.PageState value = pageFragment.getPageViewModel().getPageState().getValue();
            if (value != null && (neboQuickToolControl = pageFragment.neboQuickToolControl) != null) {
                neboQuickToolControl.syncPageState(value.getCanUndo(), value.getCanRedo());
            }
            pageFragment.updateHoverCursor();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.InteractionContext
    public boolean getActivePenEnabled() {
        return getPageViewModel().isActivePenEnabled();
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.InteractionContext
    public ToolType getCurrentToolType() {
        return getPageViewModel().getCurrentToolType();
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.InteractionContext
    public boolean isCurrentToolInteracting() {
        return getPageViewModel().isCurrentToolInteracting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreferenceChange$lambda$0(PageFragment pageFragment, SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1449108452) {
                if (iHashCode != 1518691923 || !str.equals(CommonUtils.APPLICATION_IS_PEN_KEY)) {
                    return;
                }
            } else if (!str.equals(CommonUtils.APPLICATION_IS_ACTIVE_PEN_MODE_KEY)) {
                return;
            }
            pageFragment.requireActivity().invalidateMenu();
            PageController pageController = pageFragment.getPageController();
            if (pageController != null) {
                PageController pageController2 = pageController;
                try {
                    pageController2.enableActivePen(CommonUtils.isActivePenMode(pageFragment.requireActivity().getApplication()));
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController2, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(pageController2, th);
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCanvasUriClicked$lambda$0(PageFragment pageFragment, String str) {
        FragmentActivity activity = pageFragment.getActivity();
        if (activity != null) {
            PlatformUtils.openUrl(activity, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        PageKey pageKeyDeserialize;
        boolean z;
        super.onCreate(savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.pendingCameraImageUri = savedInstanceState != null ? (Uri) savedInstanceState.getParcelable(KEY_CAMERA_FILE_URI) : null;
        FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(fragmentActivity);
        this.fontSize = defaultSharedPreferences.getFloat(getString(C6079R.string.pref_font_size_key), 16.0f);
        this.lineHeight = defaultSharedPreferences.getFloat(getString(C6079R.string.pref_line_height_key), 1.5f);
        DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(fragmentActivity);
        Intrinsics.checkNotNull(fixedDisplayMetrics);
        this.styleProperties = DisplayMetricsExtKt.createInkStyleProperties(fixedDisplayMetrics, this.fontSize, this.lineHeight);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(PAGE_KEY_ARGUMENT);
        if (string == null || (pageKeyDeserialize = PageKey.deserialize(string)) == null) {
            throw new IllegalStateException("PageKey must be provided to PageFragment".toString());
        }
        this.openedPageKey = pageKeyDeserialize;
        this.allowTryReload = bundleRequireArguments.getBoolean(ALLOW_TRY_RELOAD_ARGUMENT);
        if (getResources().getBoolean(C6079R.bool.is_ai_available_for_flavor)) {
            z = PreferenceManager.getDefaultSharedPreferences(requireContext()).getBoolean(AIContainerViewModel.AI_ENABLED_PREFS, true);
        }
        this.isAIEnabled = z;
        getPageViewModel().preloadPage(getOpenedPageKey());
        if (Build.VERSION.SDK_INT >= 30) {
            fragmentActivityRequireActivity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return PageFragment.onCreate$lambda$0(this.f$0, view, windowInsets);
                }
            });
        } else {
            fragmentActivityRequireActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i) {
                    PageFragment.onCreate$lambda$1(this.f$0, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onCreate$lambda$0(PageFragment pageFragment, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (!insets.isVisible(WindowInsetsCompat.Type.systemBars())) {
            pageFragment.disableForceRestoreScrollPositionForNotebook();
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PageFragment pageFragment, int i) {
        if ((i & 6) == 0) {
            return;
        }
        pageFragment.disableForceRestoreScrollPositionForNotebook();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6079R.layout.page_fragment, container, false);
        this.editingLayout = (ViewGroup) viewInflate.findViewById(C6079R.id.editing_layout);
        this.loadingProgress = viewInflate.findViewById(C6079R.id.page_fragment_loading_progressBar);
        this.loadFailPlaceholder = viewInflate.findViewById(C6079R.id.page_fragment_placeholder);
        ViewGroup viewGroup = this.editingLayout;
        if (viewGroup != null) {
            EditingController editingController = new EditingController(viewGroup, this.contextualMenuManager);
            editingController.setLogger(getLogger());
            editingController.getTouchFeatureImpl().enableFeatureCenterWhenPageWidthFitsScreen(RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.CENTERED_FIT_TO));
            this.editingController = editingController;
            this.touchInterceptor = viewInflate.findViewById(C6079R.id.editing_content_touch_interceptor);
            ViewGroup viewGroup2 = this.editingLayout;
            if (viewGroup2 != null) {
                this.canvasDropTarget = new CanvasContentDropTarget(viewGroup2, getLogger(), new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(PageFragment.onCreateView$lambda$1(this.f$0));
                    }
                }, new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PageFragment.onCreateView$lambda$2(this.f$0, (DragEvent) obj);
                    }
                }, new C63934(this));
                if (savedInstanceState != null && savedInstanceState.containsKey(CONTEXTUAL_MENU_GROUP_ID)) {
                    this.contextualMenuGroupId = savedInstanceState.getInt(CONTEXTUAL_MENU_GROUP_ID, C6079R.id.page_inline_selection_base_group);
                }
                return viewInflate;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$1(PageFragment pageFragment) {
        PageController pageController;
        if (!(pageFragment.getPageViewModel().getState().getValue() instanceof PageViewModel.State.Loaded) || (pageController = pageFragment.getPageController()) == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean z = !pageController2.isReadOnly();
            AutoCloseableKt.closeFinally(pageController2, null);
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(pageController2, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DragAndDropPermissionsCompat onCreateView$lambda$2(PageFragment pageFragment, DragEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DragAndDropPermissionsCompat dragAndDropPermissionsCompatRequestDragAndDropPermissions = ActivityCompat.requestDragAndDropPermissions(pageFragment.requireActivity(), event);
        if (dragAndDropPermissionsCompatRequestDragAndDropPermissions == null) {
            return null;
        }
        pageFragment.pendingDropPermissions = dragAndDropPermissionsCompatRequestDragAndDropPermissions;
        return dragAndDropPermissionsCompatRequestDragAndDropPermissions;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onCreateView$4 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63934 extends FunctionReferenceImpl implements Function3<CanvasContentDropTarget.DroppedContent, Float, Float, Unit> {
        C63934(Object obj) {
            super(3, obj, PageFragment.class, "onContentDroppedOnCanvas", "onContentDroppedOnCanvas(Lcom/myscript/nebo/editing/CanvasContentDropTarget$DroppedContent;FF)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(CanvasContentDropTarget.DroppedContent droppedContent, Float f, Float f2) {
            invoke(droppedContent, f.floatValue(), f2.floatValue());
            return Unit.INSTANCE;
        }

        public final void invoke(CanvasContentDropTarget.DroppedContent p0, float f, float f2) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PageFragment) this.receiver).onContentDroppedOnCanvas(p0, f, f2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        boolean zOnShouldScrollToBottom;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getChildFragmentManager().setFragmentResultListener(CropImageDialog.REQUEST_KEY, getViewLifecycleOwner(), new FragmentResultListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda39
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                PageFragment.onViewCreated$lambda$0(this.f$0, str, bundle);
            }
        });
        Callback callback = this.callback;
        if (callback != null) {
            String tag = getTag();
            if (tag == null) {
                tag = "";
            }
            zOnShouldScrollToBottom = callback.onShouldScrollToBottom(tag);
        } else {
            zOnShouldScrollToBottom = false;
        }
        this.scrollToBottom = zOnShouldScrollToBottom;
        getPageViewModel().getState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$1(this.f$0, view, (PageViewModel.State) obj);
            }
        }));
        SingleLiveEvent<Integer> messageNotification = getPageViewModel().getMessageNotification();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        messageNotification.observe(viewLifecycleOwner, new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$2(this.f$0, (Integer) obj);
            }
        }));
        SingleLiveEvent<MessageIdentifier> messageNotificationIdentifier = getPageViewModel().getMessageNotificationIdentifier();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        messageNotificationIdentifier.observe(viewLifecycleOwner2, new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$3(this.f$0, (MessageIdentifier) obj);
            }
        }));
        getPageViewModel().getPageProperties().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new C64005(this)));
        getPageViewModel().getZoom().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$4(this.f$0, (ZoomState) obj);
            }
        }));
        getPageViewModel().getImageImportState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new C64017(this)));
        SingleLiveEvent<Integer> messageNotification2 = getPageViewModel().getMessageNotification();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        messageNotification2.observe(viewLifecycleOwner3, new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$5(this.f$0, (Integer) obj);
            }
        }));
        SingleLiveEvent<MessageIdentifier> messageNotificationIdentifier2 = getPageViewModel().getMessageNotificationIdentifier();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        messageNotificationIdentifier2.observe(viewLifecycleOwner4, new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$6(this.f$0, (MessageIdentifier) obj);
            }
        }));
        getPageViewModel().getPageState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$7(this.f$0, (PageViewModel.PageState) obj);
            }
        }));
        getPageViewModel().getMenuCapabilities().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$8(this.f$0, (PageViewModel.MenuCapabilities) obj);
            }
        }));
        getPageViewModel().getActivityIndicator().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$9(this.f$0, (Boolean) obj);
            }
        }));
        getPageViewModel().getActionMenuState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$10(this.f$0, (PageViewModel.ActionMenuState) obj);
            }
        }));
        getPageViewModel().getShowFreemiumLimitation().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$11(this.f$0, (PageViewModel.FreemiumLimitationDialogState) obj);
            }
        }));
        getPageViewModel().getPdfOptimizationUiState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$12(this.f$0, (PageViewModel.PdfOptimizationUiState) obj);
            }
        }));
        getToolbarViewModel().getSelectedColor().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$13(this.f$0, (Integer) obj);
            }
        }));
        getToolbarViewModel().getSelectedToolType().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new C639817(this)));
        getToolbarViewModel().getSelectedToolType().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$14(this.f$0, (ToolType) obj);
            }
        }));
        getToolbarViewModel().getColors().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$15(this.f$0, (List) obj);
            }
        }));
        getToolbarViewModel().getAppliedToolConfig().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$16(this.f$0, (ToolConfiguration) obj);
            }
        }));
        getToolbarViewModel().getColorNone().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$17(this.f$0, (ColorNonePill) obj);
            }
        }));
        getPageViewModel().getPageState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$18(this.f$0, (PageViewModel.PageState) obj);
            }
        }));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner5, new OnBackPressedCallback() { // from class: com.myscript.nebo.editing.PageFragment.onViewCreated.23
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                NeboQuickToolControl neboQuickToolControl = PageFragment.this.neboQuickToolControl;
                if (neboQuickToolControl != null && neboQuickToolControl.isVisible()) {
                    NeboQuickToolControl neboQuickToolControl2 = PageFragment.this.neboQuickToolControl;
                    if (neboQuickToolControl2 != null) {
                        neboQuickToolControl2.hide();
                        return;
                    }
                    return;
                }
                setEnabled(false);
                PageFragment.this.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                setEnabled(true);
            }
        });
        getSearchViewModel().getHitNavState().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$19(this.f$0, (SearchHitNavState) obj);
            }
        }));
        getSearchViewModel().getSearchHits().observe(getViewLifecycleOwner(), new PageFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onViewCreated$lambda$20(this.f$0, (List) obj);
            }
        }));
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        fragmentActivityRequireActivity.addMenuProvider(this.menuProvider, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onViewCreated$lambda$0(final PageFragment pageFragment, String str, Bundle bundle) {
        String string;
        Uri uri;
        String mimeTypeFromExtension;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY") && bundle.getBoolean("RESULT_KEY") && bundle.containsKey(CropImageDialog.IMAGE_CROPPED_URI_KEY) && (string = bundle.getString(CropImageDialog.IMAGE_CROPPED_URI_KEY)) != null && (uri = Uri.parse(string)) != null) {
            PointerInfo pointerInfo = pageFragment.blockPosition;
            pageFragment.blockPosition = null;
            boolean z = bundle.getBoolean(CropImageDialog.IMAGE_TO_CROP_EXISTING_KEY);
            String path = uri.getPath();
            if (path != null) {
                if (z) {
                    mimeTypeFromExtension = "image/jpeg";
                } else {
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
                    Intrinsics.checkNotNull(fileExtensionFromUrl);
                    if (StringsKt.isBlank(fileExtensionFromUrl)) {
                        fileExtensionFromUrl = null;
                    }
                    if (fileExtensionFromUrl == null) {
                        fileExtensionFromUrl = "jpeg";
                    }
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                }
                if (mimeTypeFromExtension != null) {
                    if ((SetsKt.setOf((Object[]) new String[]{"image/png", "image/jpeg"}).contains(mimeTypeFromExtension) ? mimeTypeFromExtension : null) != null) {
                        File file = new File(path);
                        if (z) {
                            pageFragment.getPageViewModel().replaceSelectedImage(path, mimeTypeFromExtension);
                        } else if (pointerInfo != null) {
                            pageFragment.getPageViewModel().addImageAt(file, pointerInfo.getX(), pointerInfo.getY(), mimeTypeFromExtension);
                        } else {
                            pageFragment.getPageViewModel().addImage(path, mimeTypeFromExtension);
                        }
                        obj = Unit.INSTANCE;
                    }
                    if (obj != null) {
                    }
                } else {
                    obj = new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PageFragment.onViewCreated$lambda$0$0$0$3(this.f$0);
                        }
                    };
                    if (obj != null) {
                        return;
                    }
                }
            }
            new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PageFragment.onViewCreated$lambda$0$0$1(this.f$0);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0$3(PageFragment pageFragment) {
        pageFragment.getLogger().logError(new IllegalStateException("Unexpected image mime type returned by the image cropping dialog box"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$1(PageFragment pageFragment) {
        pageFragment.getLogger().logError(new IllegalStateException("Fail to retrieve cropped image"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onViewCreated$lambda$1(final PageFragment pageFragment, View view, final PageViewModel.State state) {
        Callback callback;
        Callback callback2;
        String strUuid;
        PageKey pageKey = state.getPageKey();
        Callback callback3 = pageFragment.callback;
        if (callback3 != null) {
            Intrinsics.checkNotNull(state);
            callback3.onPageStateUpdated(state, pageFragment.getPageViewModel().getOpenPageProperties());
        }
        boolean z = state instanceof PageViewModel.State.Loaded;
        if (z) {
            ViewGroup viewGroup = pageFragment.editingLayout;
            if (viewGroup != null) {
                ViewExt.fadeIn$default(viewGroup, 0L, 0L, 3, null);
            }
        } else {
            ViewGroup viewGroup2 = pageFragment.editingLayout;
            if (viewGroup2 != null) {
                ViewExt.fadeOut$default(viewGroup2, 0L, 0L, 3, null);
            }
        }
        View view2 = pageFragment.loadFailPlaceholder;
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(pageFragment.loadFailureDetected() ? 0 : 8);
        }
        View view3 = pageFragment.loadFailPlaceholder;
        if (view3 != null) {
            ViewGroup.LayoutParams layoutParams = view3 != null ? view3.getLayoutParams() : null;
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                PaperSize paperSize = pageFragment.getPageViewModel().getOpenPageProperties().getPaperSize();
                layoutParams2.dimensionRatio = paperSize.getWidth() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + paperSize.getHeight();
            } else {
                layoutParams2 = null;
            }
            view3.setLayoutParams(layoutParams2);
        }
        PageKey pageKey2 = state.getPageKey();
        Object[] objArr = (pageKey2 == null || pageFragment.getLibraryRepository().getPaginatedContainerFromPageKey(pageKey2) == null) ? false : true;
        if (state instanceof PageViewModel.State.Unloaded) {
            pageFragment.unbindPageController();
            if (pageKey != null && (strUuid = pageKey.uuid()) != null) {
                pageFragment.getCrashCountState().resetCrashCount(strUuid);
                if (objArr != false) {
                    ICrashCountState crashCountState = pageFragment.getCrashCountState();
                    crashCountState.setPagesCrashCountKeys(SetsKt.minus(crashCountState.getPagesCrashCountKeys(), strUuid));
                }
            }
            if (((PageViewModel.State.Unloaded) state).getClosePage()) {
                TechnicalLoggerExt.logAction$default(pageFragment.getLogger(), EditingActivity.TAG, "Closing page requested by business logic", null, 4, null);
                Callback callback4 = pageFragment.callback;
                if (callback4 != null) {
                    callback4.onFinish(42, pageKey);
                }
            }
        } else if (state instanceof PageViewModel.State.ReadyToLoad) {
            pageFragment.openedPageKey = ((PageViewModel.State.ReadyToLoad) state).getPageKey();
            if (pageKey != null) {
                String strUuid2 = pageKey.uuid();
                String noteCrashCountKey = pageFragment.getCrashCountState().getNoteCrashCountKey();
                if (objArr != false) {
                    ICrashCountState crashCountState2 = pageFragment.getCrashCountState();
                    crashCountState2.setPagesCrashCountKeys(SetsKt.plus(crashCountState2.getPagesCrashCountKeys(), strUuid2));
                } else {
                    String str = noteCrashCountKey;
                    if (str != null && str.length() != 0 && !Intrinsics.areEqual(noteCrashCountKey, strUuid2)) {
                        pageFragment.getCrashCountState().resetCrashCount(noteCrashCountKey);
                    }
                    pageFragment.getCrashCountState().setNoteCrashCountKey(strUuid2);
                }
                ICrashCountState crashCountState3 = pageFragment.getCrashCountState();
                Intrinsics.checkNotNull(strUuid2);
                if (crashCountState3.shouldFlagPageAsCorrupted(strUuid2)) {
                    pageFragment.tagCorruptionWarningInfoPage("Crash count", "This page crashed more than twice");
                    if (objArr == false) {
                        pageFragment.getCrashCountState().resetCrashCount(strUuid2);
                        Callback callback5 = pageFragment.callback;
                        if (callback5 != null) {
                            callback5.onFinish(40, pageKey);
                        }
                    }
                } else if (pageFragment.getLibraryRepository().isPageCorrupted(pageKey) && pageFragment.getCrashCountState().shouldLeaveCrashingPage(strUuid2) && objArr == false) {
                    pageFragment.getCrashCountState().resetCrashCount(strUuid2);
                    Callback callback6 = pageFragment.callback;
                    if (callback6 != null) {
                        callback6.onFinish(40, pageKey);
                    }
                }
            }
            PageProperties value = pageFragment.getPageViewModel().getPageProperties().getValue();
            PageType pageType = value != null ? value.getPageType() : null;
            if (pageType == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String strContentType = Page.contentType(pageType);
            Intrinsics.checkNotNull(strContentType);
            if (pageFragment.isSmartGuideSupported(strContentType)) {
                pageFragment.smartGuideController = new SmartGuideController(pageFragment.getLogger(), new PageFragment$onViewCreated$2$3(pageFragment));
            }
            Application application = pageFragment.requireActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            pageFragment.writingSettings = new WritingSettings(application, strContentType, null, 4, null);
            DocumentRenderingView renderingView = pageFragment.getRenderingView();
            if (renderingView != null) {
                if (objArr == false || pageFragment.allowTryReload || !pageFragment.loadFailureDetected()) {
                    boolean zIsSmartGuideSupported = pageFragment.isSmartGuideSupported(strContentType);
                    PageViewModel pageViewModel = pageFragment.getPageViewModel();
                    DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(renderingView.getContext());
                    Intrinsics.checkNotNullExpressionValue(fixedDisplayMetrics, "getFixedDisplayMetrics(...)");
                    pageViewModel.loadPage(fixedDisplayMetrics, zIsSmartGuideSupported, pageFragment.getCustomResources());
                } else {
                    PageProperties value2 = pageFragment.getPageViewModel().getPageProperties().getValue();
                    if (value2 != null && (callback2 = pageFragment.callback) != null) {
                        callback2.onPagePropertiesChanged(pageFragment.getPageViewModel().getOpenPageKey(), value2);
                    }
                }
            }
        } else if (z) {
            pageFragment.openedPageKey = ((PageViewModel.State.Loaded) state).getPageKey();
            pageFragment.getPageViewModel().setDarkMode(DarkModeUtils.isDarkMode(pageFragment));
            TypedValue typedValue = new TypedValue();
            pageFragment.requireContext().getTheme().resolveAttribute(C0028R.attr.colorPrimary, typedValue, true);
            pageFragment.getPageViewModel().setTintColor(typedValue.data);
            view.post(new Runnable() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    PageFragment.onViewCreated$lambda$1$4(this.f$0, state);
                }
            });
            pageFragment.getPageViewModel().startAutoSave();
        } else {
            if (!(state instanceof PageViewModel.State.LoadingError)) {
                throw new NoWhenBranchMatchedException();
            }
            if (pageKey != null) {
                pageFragment.openedPageKey = pageKey;
            }
            View view4 = pageFragment.loadFailPlaceholder;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            PageViewModel.State.LoadingError loadingError = (PageViewModel.State.LoadingError) state;
            Exception error = loadingError.getError();
            PageControllerLoadingException pageControllerLoadingException = error instanceof PageControllerLoadingException ? (PageControllerLoadingException) error : null;
            final NeboSanitizer.SanitizerStatus status = pageControllerLoadingException != null ? pageControllerLoadingException.getStatus() : null;
            if (PageLoaderKt.isCorruption(status)) {
                TechnicalLoggerExt.logAction(pageFragment.getLogger(), EditingActivity.TAG, "Loading error", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onViewCreated$lambda$1$5(state, status);
                    }
                });
            } else {
                TechnicalLoggerExt.logAction(pageFragment.getLogger(), EditingActivity.TAG, "Loading error", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onViewCreated$lambda$1$6(state);
                    }
                });
                PageKey pageKey3 = loadingError.getPageKey();
                final String strUuid3 = pageKey3 != null ? pageKey3.uuid() : null;
                if (strUuid3 != null) {
                    pageFragment.getCrashCountState().incrementCrashCount(strUuid3);
                    if (pageFragment.getCrashCountState().shouldFlagPageAsCorrupted(strUuid3)) {
                        TechnicalLoggerExt.logAction(pageFragment.getLogger(), EditingActivity.TAG, "Set page as corrupted", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda34
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PageFragment.onViewCreated$lambda$1$7(state, pageFragment, strUuid3);
                            }
                        });
                        pageFragment.tagCorruptionWarningInfoPage("Loading error", "This page crashed " + pageFragment.getCrashCountState().getCrashCount(strUuid3) + " times");
                        pageFragment.getCrashCountState().resetCrashCount(strUuid3);
                    } else {
                        i = 41;
                    }
                }
                pageFragment.getLogger().logError(loadingError.getError());
                TechnicalLoggerExt.logAction$default(pageFragment.getLogger(), EditingActivity.TAG, "Close page after loading error", null, 4, null);
                if (objArr == false && (callback = pageFragment.callback) != null) {
                    callback.onFinish(i, pageKey);
                }
            }
            i = 40;
            pageFragment.getLogger().logError(loadingError.getError());
            TechnicalLoggerExt.logAction$default(pageFragment.getLogger(), EditingActivity.TAG, "Close page after loading error", null, 4, null);
            if (objArr == false) {
                callback.onFinish(i, pageKey);
            }
        }
        pageFragment.updateOptionsMenu();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$4(PageFragment pageFragment, PageViewModel.State state) {
        if (pageFragment.isAdded()) {
            pageFragment.bindPageController((PageViewModel.State.Loaded) state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onViewCreated$lambda$1$5(PageViewModel.State state, NeboSanitizer.SanitizerStatus sanitizerStatus) {
        PageKey pageKey = ((PageViewModel.State.LoadingError) state).getPageKey();
        return "Corrupted page " + (pageKey != null ? pageKey.uuid() : null) + ": " + (sanitizerStatus != null ? sanitizerStatus.name() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onViewCreated$lambda$1$6(PageViewModel.State state) {
        PageKey pageKey = ((PageViewModel.State.LoadingError) state).getPageKey();
        return "Page crashes at load " + (pageKey != null ? pageKey.uuid() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onViewCreated$lambda$1$7(PageViewModel.State state, PageFragment pageFragment, String str) {
        String strUuid;
        PageKey pageKey = ((PageViewModel.State.LoadingError) state).getPageKey();
        if (pageKey == null || (strUuid = pageKey.uuid()) == null) {
            strUuid = AbstractJsonLexerKt.NULL;
        }
        return strUuid + ", crash count: " + pageFragment.getCrashCountState().getCrashCount(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(PageFragment pageFragment, Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            INotificationBannerCallback iNotificationBannerCallback = pageFragment.notificationBannerCallback;
            if (iNotificationBannerCallback != null) {
                iNotificationBannerCallback.onShowNotificationBanner(iIntValue);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(PageFragment pageFragment, MessageIdentifier messageIdentifier) {
        INotificationBannerCallback iNotificationBannerCallback;
        if (messageIdentifier != null && (iNotificationBannerCallback = pageFragment.notificationBannerCallback) != null) {
            iNotificationBannerCallback.onShowNotificationBanner(pageFragment.getPageViewModel().getOpenPageKey(), pageFragment.getOpenedPageProperties().getPageType(), messageIdentifier);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onViewCreated$5 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64005 extends FunctionReferenceImpl implements Function1<PageProperties, Unit> {
        C64005(Object obj) {
            super(1, obj, PageFragment.class, "onPagePropertiesUpdate", "onPagePropertiesUpdate(Lcom/myscript/nebo/editing/PageProperties;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PageProperties pageProperties) {
            invoke2(pageProperties);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PageProperties p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PageFragment) this.receiver).onPagePropertiesUpdate(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(PageFragment pageFragment, ZoomState zoomState) {
        IZoomCallback iZoomCallback = pageFragment.zoomCallback;
        if (iZoomCallback != null) {
            Intrinsics.checkNotNull(zoomState);
            iZoomCallback.onZoomChanged(zoomState);
        }
        pageFragment.getPageViewModel().zoomLockedNotificationTakenIntoAccount();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onViewCreated$7 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64017 extends FunctionReferenceImpl implements Function1<ImageImportState, Unit> {
        C64017(Object obj) {
            super(1, obj, PageFragment.class, "onImageImportStateUpdate", "onImageImportStateUpdate(Lcom/myscript/nebo/editing/ImageImportState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageImportState imageImportState) {
            invoke2(imageImportState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageImportState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PageFragment) this.receiver).onImageImportStateUpdate(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(PageFragment pageFragment, Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            INotificationBannerCallback iNotificationBannerCallback = pageFragment.notificationBannerCallback;
            if (iNotificationBannerCallback != null) {
                iNotificationBannerCallback.onShowNotificationBanner(iIntValue);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(PageFragment pageFragment, MessageIdentifier messageIdentifier) {
        INotificationBannerCallback iNotificationBannerCallback;
        if (messageIdentifier != null && (iNotificationBannerCallback = pageFragment.notificationBannerCallback) != null) {
            iNotificationBannerCallback.onShowNotificationBanner(pageFragment.getPageViewModel().getOpenPageKey(), pageFragment.getOpenedPageProperties().getPageType(), messageIdentifier);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(PageFragment pageFragment, PageViewModel.PageState pageState) {
        pageFragment.updateOptionsMenu();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(PageFragment pageFragment, PageViewModel.MenuCapabilities menuCapabilities) {
        pageFragment.updateOptionsMenu();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(PageFragment pageFragment, Boolean bool) {
        View view = pageFragment.loadingProgress;
        if (view != null) {
            Intrinsics.checkNotNull(bool);
            view.setVisibility(bool.booleanValue() ? 0 : 8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10(PageFragment pageFragment, PageViewModel.ActionMenuState actionMenuState) {
        if (actionMenuState instanceof PageViewModel.ActionMenuState.Opened) {
            PageController pageController = pageFragment.getPageController();
            if (pageController != null) {
                PageController pageController2 = pageController;
                try {
                    pageFragment.showActionMenuEntries(pageController2, ((PageViewModel.ActionMenuState.Opened) actionMenuState).getActionMenuEntries(), ((PageViewModel.ActionMenuState.Opened) actionMenuState).getInputPoint(), ((PageViewModel.ActionMenuState.Opened) actionMenuState).getCallback());
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController2, null);
                } finally {
                }
            }
        } else {
            pageFragment.showActionMenuEntries(null, null, null, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(PageFragment pageFragment, PageViewModel.FreemiumLimitationDialogState freemiumLimitationDialogState) {
        int i = WhenMappings.$EnumSwitchMapping$0[freemiumLimitationDialogState.getContext().ordinal()];
        if (i == 1) {
            pageFragment.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_SCRATCH_GESTURE, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        } else if (i == 2) {
            pageFragment.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_SHAPE_ON_HOLD_GESTURE, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$12(PageFragment pageFragment, PageViewModel.PdfOptimizationUiState pdfOptimizationUiState) {
        int i;
        if (pdfOptimizationUiState instanceof PageViewModel.PdfOptimizationUiState.Hidden) {
            pageFragment.hidePdfOptimizationDialog();
            pageFragment.hideOptimizationOverlay();
        } else if (pdfOptimizationUiState instanceof PageViewModel.PdfOptimizationUiState.SelectingLevel) {
            pageFragment.hideOptimizationOverlay();
            pageFragment.showPdfOptimizationDialogView();
        } else if (pdfOptimizationUiState instanceof PageViewModel.PdfOptimizationUiState.InProgress) {
            pageFragment.hidePdfOptimizationDialog();
            String string = pageFragment.getString(C6079R.string.pdf_optim_toast_optimizing);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            pageFragment.showOptimizationOverlay(string);
        } else {
            if (!(pdfOptimizationUiState instanceof PageViewModel.PdfOptimizationUiState.Done)) {
                throw new NoWhenBranchMatchedException();
            }
            pageFragment.hidePdfOptimizationDialog();
            PageViewModel.PdfOptimizationUiState.Done done = (PageViewModel.PdfOptimizationUiState.Done) pdfOptimizationUiState;
            if (done.getResult() == PdfOptimizationResult.FAILED) {
                TechnicalLogger logger = pageFragment.getLogger();
                PageKey openPageKey = pageFragment.getPageViewModel().getOpenPageKey();
                logger.logError(new IllegalStateException("PDF optimization failed for " + (openPageKey != null ? openPageKey.uuid() : null)));
            }
            int i2 = WhenMappings.$EnumSwitchMapping$1[done.getResult().ordinal()];
            if (i2 == 1) {
                i = C6079R.string.pdf_optim_toast_success;
            } else if (i2 == 2) {
                i = C6079R.string.pdf_optim_toast_already;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i = C6079R.string.pdf_optim_toast_error;
            }
            String string2 = pageFragment.getString(i);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            pageFragment.showOptimizationResult(string2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$13(PageFragment pageFragment, Integer num) {
        pageFragment.reconfigureInkCapture(pageFragment.getToolbarViewModel().getSelectedToolTypeValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onViewCreated$17 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C639817 extends FunctionReferenceImpl implements Function1<ToolType, Unit> {
        C639817(Object obj) {
            super(1, obj, PageFragment.class, "reconfigureInkCapture", "reconfigureInkCapture(Lcom/myscript/snt/core/ToolType;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ToolType toolType) {
            invoke2(toolType);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ToolType p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PageFragment) this.receiver).reconfigureInkCapture(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14(PageFragment pageFragment, ToolType toolType) {
        NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            Intrinsics.checkNotNull(toolType);
            neboQuickToolControl.syncToolType(toolType, pageFragment.getToolbarViewModel().findToolConfigurationByType(toolType));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15(PageFragment pageFragment, List list) {
        NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            Intrinsics.checkNotNull(list);
            neboQuickToolControl.syncColors(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16(PageFragment pageFragment, ToolConfiguration toolConfiguration) {
        NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            ToolType type = toolConfiguration.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            neboQuickToolControl.syncToolType(type, toolConfiguration);
        }
        if (pageFragment.spenHoverCursor != null) {
            pageFragment.spenHoverCursorActive = true;
        }
        pageFragment.updateHoverCursor();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17(PageFragment pageFragment, ColorNonePill colorNonePill) {
        NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            neboQuickToolControl.syncNoColor(colorNonePill.isSelected());
        }
        if (pageFragment.spenHoverCursor != null) {
            pageFragment.spenHoverCursorActive = true;
        }
        pageFragment.updateHoverCursor();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18(PageFragment pageFragment, PageViewModel.PageState pageState) {
        NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            neboQuickToolControl.syncPageState(pageState.getCanUndo(), pageState.getCanRedo());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$19(PageFragment pageFragment, SearchHitNavState searchHitNavState) {
        EditingController editingController = pageFragment.editingController;
        if (editingController != null) {
            editingController.setSelectedHitIndex(searchHitNavState.getSelectedHitExtent());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$20(PageFragment pageFragment, List list) {
        if (!pageFragment.getSearchViewModel().isSearchProcessing() || pageFragment.getSearchViewModel().getSearchType() == DMSSearchController.SearchType.GRID) {
            Intrinsics.checkNotNull(list);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((SearchMatch) obj).getPageUUID(), pageFragment.getOpenedPageKey().uuid())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                SWIGVectorExtent extents = ((SearchMatch) it.next()).getExtents();
                Intrinsics.checkNotNullExpressionValue(extents, "getExtents(...)");
                arrayList3.add((Extent) CollectionsKt.first((List) extents));
            }
            ArrayList arrayList4 = arrayList3;
            EditingController editingController = pageFragment.editingController;
            if (editingController != null) {
                editingController.setSearchHits(arrayList4);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        requireActivity().removeMenuProvider(this.menuProvider);
        hideOptimizationOverlay();
        hidePdfOptimizationDialog();
        NeboQuickToolControl neboQuickToolControl = this.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            neboQuickToolControl.release();
        }
        this.neboQuickToolControl = null;
        this.editingLayout = null;
        this.loadingProgress = null;
        this.touchInterceptor = null;
        this.loadFailPlaceholder = null;
        this.canvasDropTarget = null;
        DragAndDropPermissionsCompat dragAndDropPermissionsCompat = this.pendingDropPermissions;
        if (dragAndDropPermissionsCompat != null) {
            dragAndDropPermissionsCompat.release();
        }
        this.pendingDropPermissions = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        ViewGroup viewGroup;
        NeboQuickToolControl neboQuickToolControl;
        super.onStart();
        requireActivity().getSharedPreferences(CommonUtils.COMMON_PREFERENCES_NAME, 0).registerOnSharedPreferenceChangeListener(this.onPreferenceChange);
        this.contextualMenuManager.setContextualMenuCallback(this);
        this.contextualMenuManager.setActionMenuRetentionPolicy(new ContextualMenuManager.ActionMenuRetentionPolicy() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda55
            @Override // com.myscript.nebo.editing.impl.ui.ContextualMenuManager.ActionMenuRetentionPolicy
            public final boolean shouldRetainActionMenu() {
                return this.f$0.isInlineSelectionOnPdfContent();
            }
        });
        this.contextualMenuManager.setAIActionMenuHandler(new AIActionMenuHandler() { // from class: com.myscript.nebo.editing.PageFragment.onStart.2
            @Override // com.myscript.nebo.p022ai.domain.AIActionMenuHandler
            public void summarizeText() {
                Callback callback = PageFragment.this.callback;
                if (callback != null) {
                    callback.onSummarizeSelection();
                }
            }

            @Override // com.myscript.nebo.p022ai.domain.AIActionMenuHandler
            public void explainText() {
                Callback callback = PageFragment.this.callback;
                if (callback != null) {
                    callback.onExplainSelection();
                }
            }

            @Override // com.myscript.nebo.p022ai.domain.AIActionMenuHandler
            public void quiz() {
                Callback callback = PageFragment.this.callback;
                if (callback != null) {
                    callback.onQuizSelection();
                }
            }
        });
        this.contextualMenuManager.setLocalActionMenuHandler(new C63963());
        View view = this.touchInterceptor;
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda66
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f$0.onPageTouchIntercepted(view2, motionEvent);
                }
            });
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (SpenExtKt.isSamsungSpenTablet(contextRequireContext)) {
            if (this.neboQuickToolControl == null && (viewGroup = this.editingLayout) != null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                this.neboQuickToolControl = new NeboQuickToolControl(fragmentActivityRequireActivity, viewGroup, getToolbarViewModel(), new C63975(this.spenQuickToolTrigger), new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PageFragment.onStart$lambda$1(this.f$0, (MotionEvent) obj);
                    }
                }, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda68
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onStart$lambda$2(this.f$0);
                    }
                }, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda69
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onStart$lambda$3(this.f$0);
                    }
                });
                List<ColorPill> value = getToolbarViewModel().getColors().getValue();
                if (value != null && (neboQuickToolControl = this.neboQuickToolControl) != null) {
                    neboQuickToolControl.syncColors(value);
                }
            }
            if (this.spenHoverCursor == null) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                this.spenHoverCursor = new SpenHoverCursor(contextRequireContext2);
            }
            this.spenHoverCursorActive = true;
            this.spenQuickToolTrigger.setOnHoverChange(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PageFragment.onStart$lambda$5(this.f$0, ((Boolean) obj).booleanValue());
                }
            });
            DocumentRenderingView renderingView = getRenderingView();
            if (renderingView != null) {
                renderingView.setSecondaryHoverListener(this.spenQuickToolTrigger);
            }
            updateHoverCursor();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onStart$3 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"com/myscript/nebo/editing/PageFragment$onStart$3", "Lcom/myscript/nebo/editing/impl/ui/LocalActionMenuHandler;", "cropImage", "", "actionMenuPoint", "Lcom/myscript/atk/core/Point;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C63963 implements LocalActionMenuHandler {
        C63963() {
        }

        @Override // com.myscript.nebo.editing.impl.p027ui.LocalActionMenuHandler
        public void cropImage(Point actionMenuPoint) {
            Intrinsics.checkNotNullParameter(actionMenuPoint, "actionMenuPoint");
            NeboFirebaseEvent.CropImage.log(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$onStart$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PageFragment.C63963.cropImage$lambda$0((Bundle) obj);
                }
            });
            PageFragment.this.cropSelectedImage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit cropImage$lambda$0(Bundle log) {
            Intrinsics.checkNotNullParameter(log, "$this$log");
            log.putString("origin", "image_edit_menu");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onStart$5 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63975 extends FunctionReferenceImpl implements Function2<View, MotionEvent, Unit> {
        C63975(Object obj) {
            super(2, obj, SpenQuickToolTrigger.class, "trackButtonWhileOpen", "trackButtonWhileOpen(Landroid/view/View;Landroid/view/MotionEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, MotionEvent motionEvent) {
            invoke2(view, motionEvent);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View p0, MotionEvent p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((SpenQuickToolTrigger) this.receiver).trackButtonWhileOpen(p0, p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$1(PageFragment pageFragment, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DocumentRenderingView renderingView = pageFragment.getRenderingView();
        if (renderingView != null) {
            renderingView.dispatchTouchEvent(event);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$2(PageFragment pageFragment) {
        pageFragment.getPageViewModel().undo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$3(PageFragment pageFragment) {
        pageFragment.getPageViewModel().redo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$5(PageFragment pageFragment, boolean z) {
        if (!z) {
            DocumentRenderingView renderingView = pageFragment.getRenderingView();
            if (renderingView != null) {
                renderingView.setHoverPointerIcon(null);
            }
            NeboQuickToolControl neboQuickToolControl = pageFragment.neboQuickToolControl;
            if (neboQuickToolControl == null || !neboQuickToolControl.isVisible()) {
                pageFragment.spenHoverCursorActive = false;
            }
        } else {
            pageFragment.updateHoverCursor();
        }
        return Unit.INSTANCE;
    }

    private final File getSelectedImage() {
        String selectedImage;
        File file = new File(requireContext().getCacheDir(), "image_to_crop");
        String absolutePath = file.getAbsolutePath();
        SWIGAngle sWIGAngle = new SWIGAngle();
        Point point = new Point();
        PageController pageController = getPageController();
        if (pageController == null || (selectedImage = pageController.getSelectedImage(absolutePath, point, sWIGAngle)) == null || selectedImage.length() <= 0) {
            return null;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cropSelectedImage() {
        File selectedImage = getSelectedImage();
        if (selectedImage != null) {
            Uri uriFromFile = Uri.fromFile(selectedImage);
            Uri uriFromFile2 = Uri.fromFile(new File(requireContext().getCacheDir(), CropImageDialog.CROPPED_IMAGE_FILENAME));
            CropImageDialog.Companion companion = CropImageDialog.INSTANCE;
            Intrinsics.checkNotNull(uriFromFile);
            Intrinsics.checkNotNull(uriFromFile2);
            CropImageDialog cropImageDialogNewInstance = companion.newInstance(uriFromFile, uriFromFile2, true);
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            cropImageDialogNewInstance.show(childFragmentManager);
            return;
        }
        new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.cropSelectedImage$lambda$1(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cropSelectedImage$lambda$1(PageFragment pageFragment) {
        pageFragment.getLogger().logError(new IllegalStateException("Fail to crop selected image"));
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EditingController editingController = this.editingController;
        if (editingController != null) {
            editingController.onFragmentResume();
        }
        getPageViewModel().startAutoSave();
        PageViewModel.State value = getPageViewModel().getState().getValue();
        PageViewModel.State.Loaded loaded = value instanceof PageViewModel.State.Loaded ? (PageViewModel.State.Loaded) value : null;
        if (loaded != null) {
            getToolbarViewModel().unbindPageController();
            getToolbarViewModel().bindPageController(loaded.getPageControllerState().getPageController());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        NeboQuickToolControl neboQuickToolControl = this.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            neboQuickToolControl.hide();
        }
        getPageViewModel().stopAutoSave();
        getToolbarViewModel().unbindPageController();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(CONTEXTUAL_MENU_GROUP_ID, this.contextualMenuManager.hasValidSelection() ? this.contextualMenuGroupId : C6079R.id.page_inline_selection_base_group);
        outState.putParcelable(KEY_CAMERA_FILE_URI, this.pendingCameraImageUri);
        EditingController editingController = this.editingController;
        if (editingController != null) {
            editingController.onFragmentSaveInstanceState();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        requireActivity().getSharedPreferences(CommonUtils.COMMON_PREFERENCES_NAME, 0).unregisterOnSharedPreferenceChangeListener(this.onPreferenceChange);
        View view = this.touchInterceptor;
        if (view != null) {
            view.setOnTouchListener(null);
        }
        DocumentRenderingView renderingView = getRenderingView();
        if (renderingView != null) {
            renderingView.setSecondaryHoverListener(null);
        }
        DocumentRenderingView renderingView2 = getRenderingView();
        if (renderingView2 != null) {
            renderingView2.setHoverPointerIcon(null);
        }
        this.spenHoverCursorActive = false;
        this.spenHoverCursor = null;
        this.spenQuickToolTrigger.setOnHoverChange(null);
        this.spenQuickToolTrigger.reset();
        NeboQuickToolControl neboQuickToolControl = this.neboQuickToolControl;
        if (neboQuickToolControl != null) {
            neboQuickToolControl.release();
        }
        this.neboQuickToolControl = null;
        this.contextualMenuManager.setContextualMenuCallback(null);
        this.contextualMenuManager.setActionMenuRetentionPolicy(null);
        this.contextualMenuManager.setAIActionMenuHandler(null);
        if (this.popupMenu != null) {
            resetPopupMenu();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String strUuid;
        if (getPageViewModel().getContainerPageKey() != null) {
            PageKey openPageKey = getPageViewModel().getOpenPageKey();
            if (openPageKey != null && (strUuid = openPageKey.uuid()) != null) {
                getCrashCountState().resetCrashCount(strUuid);
                ICrashCountState crashCountState = getCrashCountState();
                crashCountState.setPagesCrashCountKeys(SetsKt.minus(crashCountState.getPagesCrashCountKeys(), strUuid));
            }
        } else {
            getCrashCountState().setNoteCrashCountKey(null);
        }
        LayoutGrid.StyleProperties styleProperties = this.styleProperties;
        if (styleProperties != null) {
            styleProperties.delete();
        }
        unbindPageController();
        super.onDestroy();
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public boolean onCreateContextualMenu(ContextualMenu contextualMenu, Menu menu) {
        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
        Intrinsics.checkNotNullParameter(menu, "menu");
        FragmentActivity activity = getActivity();
        if ((activity != null && activity.isChangingConfigurations()) || isInlineSelectionOnPdfContent()) {
            return false;
        }
        MenuInflater menuInflater = contextualMenu.getMenuInflater();
        if (menuInflater != null) {
            menuInflater.inflate(C6079R.menu.page_inline_selection_menu, menu);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInlineSelectionOnPdfContent() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean z = pageController2.currentInlineSelectionTextType() == PageController.InlineSelectionTextType.PDF_CONTENT;
            AutoCloseableKt.closeFinally(pageController2, null);
            return z;
        } finally {
        }
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public boolean onPrepareContextualMenu(ContextualMenu contextualMenu, final Menu menu) {
        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
        Intrinsics.checkNotNullParameter(menu, "menu");
        menu.setGroupVisible(C6079R.id.page_inline_selection_base_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_base_group);
        menu.setGroupVisible(C6079R.id.page_inline_selection_indent_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_indent_group);
        menu.setGroupVisible(C6079R.id.page_inline_selection_list_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_list_group);
        menu.setGroupVisible(C6079R.id.page_inline_selection_copy_as_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_copy_as_group);
        menu.setGroupVisible(C6079R.id.page_inline_selection_styles_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_styles_group);
        menu.setGroupVisible(C6079R.id.page_inline_selection_ai_group, this.contextualMenuGroupId == C6079R.id.page_inline_selection_ai_group);
        MenuItem menuItemFindItem = menu.findItem(C6079R.id.page_inline_selection_paste);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(getPageViewModel().canPaste());
        }
        String text = this.contextualMenuManager.getText();
        boolean z = text == null || StringsKt.isBlank(text);
        boolean z2 = !z;
        String textSelection = this.contextualMenuManager.getTextSelection();
        String str = textSelection;
        boolean z3 = str == null || StringsKt.isBlank(str);
        boolean z4 = !z3;
        boolean zHasValidSelection = this.contextualMenuManager.hasValidSelection();
        boolean z5 = this.contextualMenuGroupId == C6079R.id.page_inline_selection_base_group;
        boolean z6 = (z3 || textSelection == null || StringsKt.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null) || !URLUtil.isNetworkUrl(textSelection)) ? false : true;
        MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.page_inline_selection_list);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(!z && z5);
        }
        MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.page_inline_selection_list_as_ordered);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(z2);
        }
        MenuItem menuItemFindItem4 = menu.findItem(C6079R.id.page_inline_selection_list_as_unordered);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setEnabled(z2);
        }
        MenuItem menuItemFindItem5 = menu.findItem(C6079R.id.page_inline_selection_list_as_checklist);
        if (menuItemFindItem5 != null) {
            menuItemFindItem5.setEnabled(z2);
        }
        MenuItem menuItemFindItem6 = menu.findItem(C6079R.id.page_inline_selection_list_as_text);
        if (menuItemFindItem6 != null) {
            menuItemFindItem6.setEnabled(z2);
        }
        MenuItem menuItemFindItem7 = menu.findItem(C6079R.id.page_inline_selection_indent);
        if (menuItemFindItem7 != null) {
            menuItemFindItem7.setEnabled(getPageViewModel().canIndentInlineSelection());
        }
        MenuItem menuItemFindItem8 = menu.findItem(C6079R.id.page_inline_selection_copy_as);
        if (menuItemFindItem8 != null) {
            menuItemFindItem8.setEnabled(false);
        }
        MenuItem menuItemFindItem9 = menu.findItem(C6079R.id.page_inline_selection_copy_as_text);
        if (menuItemFindItem9 != null) {
            menuItemFindItem9.setEnabled(z4);
        }
        MenuItem menuItemFindItem10 = menu.findItem(C6079R.id.page_inline_selection_copy_as_math);
        if (menuItemFindItem10 != null) {
            menuItemFindItem10.setEnabled(z4);
        }
        MenuItem menuItemFindItem11 = menu.findItem(C6079R.id.page_inline_selection_styles);
        if (menuItemFindItem11 != null) {
            menuItemFindItem11.setEnabled(zHasValidSelection);
        }
        MenuItem menuItemFindItem12 = menu.findItem(C6079R.id.page_inline_selection_copy);
        if (menuItemFindItem12 != null) {
            menuItemFindItem12.setEnabled(zHasValidSelection);
        }
        MenuItem menuItemFindItem13 = menu.findItem(C6079R.id.page_inline_selection_cut);
        if (menuItemFindItem13 != null) {
            menuItemFindItem13.setEnabled(zHasValidSelection);
        }
        MenuItem menuItemFindItem14 = menu.findItem(C6079R.id.page_inline_selection_bold);
        if (menuItemFindItem14 != null) {
            menuItemFindItem14.setEnabled(z4);
        }
        MenuItem menuItemFindItem15 = menu.findItem(C6079R.id.page_inline_selection_highlight);
        if (menuItemFindItem15 != null) {
            menuItemFindItem15.setEnabled(z4);
        }
        MenuItem menuItemFindItem16 = menu.findItem(C6079R.id.page_inline_selection_delete);
        if (menuItemFindItem16 != null) {
            menuItemFindItem16.setEnabled(zHasValidSelection);
        }
        MenuItem menuItemFindItem17 = menu.findItem(C6079R.id.page_inline_selection_convert);
        if (menuItemFindItem17 != null) {
            menuItemFindItem17.setEnabled(getPageViewModel().canConvertInlineSelection());
        }
        MenuItem menuItemFindItem18 = menu.findItem(C6079R.id.page_inline_selection_learn);
        if (menuItemFindItem18 != null) {
            boolean z7 = z5 && getPageViewModel().canLearnWord(textSelection);
            if (z7) {
                menuItemFindItem18.setTitle(getString(C6079R.string.page_inline_selection_add_to_user_dict, textSelection));
            }
            menuItemFindItem18.setVisible(z7);
        }
        MenuItem menuItemFindItem19 = menu.findItem(C6079R.id.page_inline_selection_link);
        if (menuItemFindItem19 != null) {
            boolean z8 = z5 && requireContext().getResources().getBoolean(C6079R.bool.enable_open_link_from_inline_selection) && z6;
            if (z8) {
                menuItemFindItem19.setTitle(getString(C6079R.string.page_inline_selection_link, textSelection));
            }
            menuItemFindItem19.setVisible(z8);
        }
        MenuItem menuItemFindItem20 = menu.findItem(C6079R.id.page_inline_selection_ai);
        if (menuItemFindItem20 != null) {
            menuItemFindItem20.setEnabled(zHasValidSelection && this.isAIEnabled);
        }
        MenuItem menuItemFindItem21 = menu.findItem(C6079R.id.page_inline_selection_ai_summarize);
        if (menuItemFindItem21 != null) {
            menuItemFindItem21.setEnabled(zHasValidSelection && this.isAIEnabled);
        }
        MenuItem menuItemFindItem22 = menu.findItem(C6079R.id.page_inline_selection_ai_explain);
        if (menuItemFindItem22 != null) {
            menuItemFindItem22.setEnabled(zHasValidSelection && this.isAIEnabled);
        }
        MenuItem menuItemFindItem23 = menu.findItem(C6079R.id.page_inline_selection_ai_quiz);
        if (menuItemFindItem23 != null) {
            menuItemFindItem23.setEnabled(zHasValidSelection && this.isAIEnabled);
        }
        TechnicalLoggerExt.logAction(getLogger(), TAG, "Prepare inline selection contextual menu", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda65
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment.onPrepareContextualMenu$lambda$6(menu, this);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPrepareContextualMenu$lambda$6(Menu menu, final PageFragment pageFragment) {
        return SequencesKt.joinToString$default(SequencesKt.filter(MenuKt.getChildren(menu), new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PageFragment.onPrepareContextualMenu$lambda$6$0((MenuItem) obj));
            }
        }), ",", "[", "]", 0, null, new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.onPrepareContextualMenu$lambda$6$1(this.f$0, (MenuItem) obj);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onPrepareContextualMenu$lambda$6$0(MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isVisible() && it.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onPrepareContextualMenu$lambda$6$1(PageFragment pageFragment, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            return "'" + pageFragment.getResources().getResourceEntryName(it.getItemId()) + "'";
        } catch (Resources.NotFoundException unused) {
            return "'??'";
        }
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public boolean onContextualMenuItemClicked(ContextualMenu contextualMenu, MenuItem item) {
        Callback callback;
        DocumentRenderingView renderingView;
        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == C6079R.id.page_inline_selection_paste) {
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Paste", null, 4, null);
            getPageViewModel().paste();
        } else {
            if (itemId == C6079R.id.page_inline_selection_indent) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Indent...", null, 4, null);
                this.contextualMenuGroupId = C6079R.id.page_inline_selection_indent_group;
                contextualMenu.invalidate();
            } else if (itemId == C6079R.id.page_inline_selection_indent_decrease) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Indent > Decrease", null, 4, null);
                getPageViewModel().unindentSelection();
            } else if (itemId == C6079R.id.page_inline_selection_indent_increase) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Indent > Increase", null, 4, null);
                getPageViewModel().indentSelection();
            } else if (itemId == C6079R.id.page_inline_selection_list) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "List...", null, 4, null);
                this.contextualMenuGroupId = C6079R.id.page_inline_selection_list_group;
                contextualMenu.invalidate();
            } else if (itemId == C6079R.id.page_inline_selection_list_as_ordered) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "List > Ordered", null, 4, null);
                getPageViewModel().selectionAsOrderedList();
            } else if (itemId == C6079R.id.page_inline_selection_list_as_unordered) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "List > Unordered", null, 4, null);
                getPageViewModel().selectionAsUnorderedList();
            } else if (itemId == C6079R.id.page_inline_selection_list_as_checklist) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "List > Checklist", null, 4, null);
                getPageViewModel().selectionAsCheckedList();
            } else if (itemId == C6079R.id.page_inline_selection_list_as_text) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "List > None", null, 4, null);
                getPageViewModel().selectionAsText();
            } else if (itemId == C6079R.id.page_inline_selection_copy_as) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy as...", null, 4, null);
                this.contextualMenuGroupId = C6079R.id.page_inline_selection_copy_as_group;
                contextualMenu.invalidate();
            } else if (itemId == C6079R.id.page_inline_selection_copy_as_text) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy as > Text", null, 4, null);
                PageViewModel pageViewModel = getPageViewModel();
                String TEXT = ContentTypes.TEXT;
                Intrinsics.checkNotNullExpressionValue(TEXT, "TEXT");
                pageViewModel.copyAs(TEXT);
            } else if (itemId == C6079R.id.page_inline_selection_copy_as_sketch) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy as > Drawing", null, 4, null);
                PageViewModel pageViewModel2 = getPageViewModel();
                String DRAWING = ContentTypes.DRAWING;
                Intrinsics.checkNotNullExpressionValue(DRAWING, "DRAWING");
                pageViewModel2.copyAs(DRAWING);
            } else if (itemId == C6079R.id.page_inline_selection_copy_as_math) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy as > Math", null, 4, null);
                PageViewModel pageViewModel3 = getPageViewModel();
                String MATH = ContentTypes.MATH;
                Intrinsics.checkNotNullExpressionValue(MATH, "MATH");
                pageViewModel3.copyAs(MATH);
            } else if (itemId == C6079R.id.page_inline_selection_copy_as_diagram) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy as > Diagram", null, 4, null);
                PageViewModel pageViewModel4 = getPageViewModel();
                String DIAGRAM = ContentTypes.DIAGRAM;
                Intrinsics.checkNotNullExpressionValue(DIAGRAM, "DIAGRAM");
                pageViewModel4.copyAs(DIAGRAM);
            } else if (itemId == C6079R.id.page_inline_selection_styles) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style...", null, 4, null);
                this.contextualMenuGroupId = C6079R.id.page_inline_selection_styles_group;
                contextualMenu.invalidate();
            } else if (itemId == C6079R.id.page_inline_selection_bold) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style > Bold", null, 4, null);
                getPageViewModel().emboldenSelection();
            } else if (itemId == C6079R.id.page_inline_selection_underline) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style > Underline", null, 4, null);
                getPageViewModel().underlineSelection();
            } else if (itemId == C6079R.id.page_inline_selection_double_underline) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style > Double Underline", null, 4, null);
                getPageViewModel().doubleUnderlineSelection();
            } else if (itemId == C6079R.id.page_inline_selection_strike_through) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style > Strike-through", null, 4, null);
                getPageViewModel().strikeThrough();
            } else if (itemId == C6079R.id.page_inline_selection_highlight) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Style > Highlight", null, 4, null);
                getPageViewModel().highlightSelection();
            } else if (itemId == C6079R.id.page_inline_selection_ai) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "AI ✨", null, 4, null);
                this.contextualMenuGroupId = C6079R.id.page_inline_selection_ai_group;
                contextualMenu.invalidate();
            } else {
                if (itemId == C6421R.id.editing_action_menu_add_object) {
                    EditingController editingController = this.editingController;
                    int[] locationInWindow = (editingController == null || (renderingView = editingController.getRenderingView()) == null) ? null : ViewExt.getLocationInWindow(renderingView);
                    EditingController editingController2 = this.editingController;
                    ITouchFeature touchFeatureImpl = editingController2 != null ? editingController2.getTouchFeatureImpl() : null;
                    final PointerInfo pointerInfo = this.blockPosition;
                    if (touchFeatureImpl != null && locationInWindow != null && pointerInfo != null) {
                        TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Add object...", null, 4, null);
                        float x = pointerInfo.getX() - touchFeatureImpl.getHorizontalScrollPos();
                        float y = pointerInfo.getY() - touchFeatureImpl.getVerticalScrollPos();
                        TechnicalLoggerExt.logAction(getLogger(), TAG, FREEFORM_ADD_BLOCK_MENU, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PageFragment.onContextualMenuItemClicked$lambda$0(pointerInfo);
                            }
                        });
                        PopupUtils.launchPopupMenu(getActivity(), FREEFORM_ADD_BLOCK_MENU, C6079R.menu.double_tap_add_block_menu, 0, C0028R.attr.actionOverflowMenuStyle, ((int) x) + locationInWindow[0], ((int) y) + locationInWindow[1], true, new PopupUtils.PopupInfoMenuCallback() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda22
                            @Override // com.myscript.nebo.common.utils.PopupUtils.PopupInfoMenuCallback
                            public final void popupMenuCreated(PopupMenu popupMenu, PopupUtils.PopupInfoSaveInstanceState popupInfoSaveInstanceState) {
                                this.f$0.onPopupMenuCreated(popupMenu, popupInfoSaveInstanceState);
                            }
                        });
                    }
                } else if (itemId == C6079R.id.page_inline_selection_copy) {
                    TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Copy", null, 4, null);
                    getPageViewModel().copySelection();
                } else if (itemId == C6079R.id.page_inline_selection_cut) {
                    TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Cut", null, 4, null);
                    getPageViewModel().cutSelection();
                } else if (itemId == C6079R.id.page_inline_selection_delete) {
                    TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Delete", null, 4, null);
                    getPageViewModel().deleteSelection();
                } else if (itemId == C6079R.id.page_inline_selection_convert) {
                    TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Convert", null, 4, null);
                    getPageViewModel().convertSelection();
                } else if (itemId == C6079R.id.page_inline_selection_learn) {
                    TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Learn word", null, 4, null);
                    String textSelection = this.contextualMenuManager.getTextSelection();
                    addWordIntoDictionary(textSelection != null ? StringsKt.trim((CharSequence) textSelection).toString() : null);
                } else if (itemId == C6079R.id.page_inline_selection_link) {
                    String textSelection2 = this.contextualMenuManager.getTextSelection();
                    String str = textSelection2;
                    if (str != null && !StringsKt.isBlank(str) && !PlatformUtils.openUrl(requireActivity(), textSelection2)) {
                        Log.e(TAG, "No app found to handle url intent");
                    }
                } else if (itemId == C6079R.id.page_inline_selection_ai_summarize) {
                    Callback callback2 = this.callback;
                    if (callback2 != null) {
                        callback2.onSummarizeSelection();
                    }
                } else if (itemId == C6079R.id.page_inline_selection_ai_explain) {
                    Callback callback3 = this.callback;
                    if (callback3 != null) {
                        callback3.onExplainSelection();
                    }
                } else if (itemId == C6079R.id.page_inline_selection_ai_quiz && (callback = this.callback) != null) {
                    callback.onQuizSelection();
                }
            }
            return true;
        }
        contextualMenu.finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onContextualMenuItemClicked$lambda$0(PointerInfo pointerInfo) {
        return "(" + ((int) pointerInfo.getX()) + TextRecallingManager.ANSWER_SEPARATOR + ((int) pointerInfo.getY()) + ")";
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public boolean onContextualActionRequested(final Function0<Unit> action, Object userData) {
        CrossSellFilter crossSellFilterProvideCrossSellFilter;
        Intrinsics.checkNotNullParameter(action, "action");
        ActionMenuEntry actionMenuEntry = userData instanceof ActionMenuEntry ? (ActionMenuEntry) userData : null;
        int i = actionMenuEntry == null ? -1 : WhenMappings.$EnumSwitchMapping$2[actionMenuEntry.ordinal()];
        if (i == 1 || i == 2) {
            if (userData == ActionMenuEntry.CONVERT_MATH) {
                ComponentCallbacks2 application = requireActivity().getApplication();
                CrossSellFilter.Provider provider = application instanceof CrossSellFilter.Provider ? (CrossSellFilter.Provider) application : null;
                if (provider != null && (crossSellFilterProvideCrossSellFilter = provider.provideCrossSellFilter()) != null) {
                    crossSellFilterProvideCrossSellFilter.notifyMathConversion();
                }
            }
            getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_CONVERT_BLOCK, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PageFragment.onContextualActionRequested$lambda$0(this.f$0, action);
                }
            });
            return false;
        }
        if (i == 3) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onSummarizeSelection();
            }
            return false;
        }
        if (i == 4) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onExplainSelection();
            }
            return false;
        }
        if (i == 5) {
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onQuizSelection();
            }
            return false;
        }
        getPageViewModel().timeConsumingAction(action);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onContextualActionRequested$lambda$0(PageFragment pageFragment, Function0 function0) {
        pageFragment.getPageViewModel().timeConsumingAction(function0);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public void onDestroyContextualMenu(ContextualMenu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        FragmentActivity activity = getActivity();
        if ((activity == null || activity.isChangingConfigurations()) && this.contextualMenuManager.hasSelection()) {
            return;
        }
        this.contextualMenuGroupId = C6079R.id.page_inline_selection_base_group;
    }

    @Override // com.myscript.android.utils.ContextualMenu.Callback
    public void onGetContentRect(ContextualMenu contextualMenu, View view, Rect outRect) {
        ITouchFeature touchFeatureImpl;
        ITouchFeature touchFeatureImpl2;
        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        RectF offsetSelectionRect = this.contextualMenuManager.getOffsetSelectionRect();
        if (offsetSelectionRect != null) {
            EditingController editingController = this.editingController;
            int verticalScrollPos = 0;
            int horizontalScrollPos = (editingController == null || (touchFeatureImpl2 = editingController.getTouchFeatureImpl()) == null) ? 0 : touchFeatureImpl2.getHorizontalScrollPos();
            EditingController editingController2 = this.editingController;
            if (editingController2 != null && (touchFeatureImpl = editingController2.getTouchFeatureImpl()) != null) {
                verticalScrollPos = touchFeatureImpl.getVerticalScrollPos();
            }
            float f = horizontalScrollPos;
            float f2 = verticalScrollPos;
            outRect.set(new Rect((int) (offsetSelectionRect.left - f), (int) (offsetSelectionRect.top - f2), (int) (offsetSelectionRect.right - f), (int) (offsetSelectionRect.bottom - f2)));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        internalOnAttach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        internalOnAttach();
    }

    private final void internalOnAttach() {
        this.callback = (Callback) getActivity();
        KeyEventDispatcher.Component activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.myscript.nebo.editing.PageFragment.INotificationBannerCallback");
        this.notificationBannerCallback = (INotificationBannerCallback) activity;
        KeyEventDispatcher.Component activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.myscript.nebo.editing.PageFragment.IZoomCallback");
        this.zoomCallback = (IZoomCallback) activity2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.callback = null;
        this.notificationBannerCallback = null;
        this.zoomCallback = null;
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onPageTouchIntercepted(View v, MotionEvent event) {
        EditingController editingController = this.editingController;
        if (editingController != null) {
            editingController.requestActionMenuDismiss();
        }
        SmartGuideController smartGuideController = this.smartGuideController;
        if (smartGuideController != null && smartGuideController.requestActionMenuDismiss()) {
            return true;
        }
        if (!TouchUtils.isRightClick(event)) {
            return false;
        }
        this.onTouchGesture.onLongPress(event);
        return true;
    }

    private final boolean isSmartGuideSupported(String contentType) {
        return Intrinsics.areEqual(contentType, ContentTypes.TEXT_DOCUMENT);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$bindPageController$1 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63901 extends FunctionReferenceImpl implements Function0<String> {
        C63901(Object obj) {
            super(0, obj, PageKey.class, "uuid", "uuid()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((PageKey) this.receiver).uuid();
        }
    }

    private final void bindPageController(PageViewModel.State.Loaded state) {
        ITouchFeature touchFeatureImpl;
        TechnicalLoggerExt.logAction(getLogger(), TAG, "PageController loaded", new C63901(state.getPageKey()));
        PageControllerState pageControllerState = state.getPageControllerState();
        int pageBackgroundColor = getOpenedPageProperties().getPageBackgroundColor();
        boolean zIsFeatureEnabled = RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.COLORIZE_PREDICTION);
        int i = PreferenceManager.getDefaultSharedPreferences(requireActivity().getApplication()).getInt(requireActivity().getApplication().getString(C6079R.string.pref_internal_prediction_duration), 16);
        EditingController editingController = this.editingController;
        if (editingController != null) {
            editingController.setTextDisplaySettings(this.fontSize, this.lineHeight);
        }
        EditingController editingController2 = this.editingController;
        if (editingController2 != null) {
            editingController2.setPageController(pageControllerState, true, getPageViewModel().getShowKeyboardOnTap(), this.scrollToBottom, zIsFeatureEnabled, i);
        }
        EditingController editingController3 = this.editingController;
        if (editingController3 != null) {
            editingController3.scrollAtBottomByDefault(false);
        }
        this.scrollToBottom = false;
        EditingController editingController4 = this.editingController;
        if (editingController4 != null) {
            editingController4.setPaperSize(getPageViewModel().getOpenPageProperties().getPaperSize(), pageBackgroundColor);
        }
        EditingController editingController5 = this.editingController;
        if (editingController5 != null) {
            editingController5.allowAdditionalSpaceForKeyboard(getPageViewModel().getOpenPageProperties().isFixedPageSize());
        }
        EditingController editingController6 = this.editingController;
        if (editingController6 != null && (touchFeatureImpl = editingController6.getTouchFeatureImpl()) != null) {
            touchFeatureImpl.addGestureListener(this.onTouchGesture);
        }
        DocumentRenderingView renderingView = getRenderingView();
        if (renderingView != null) {
            renderingView.setOnDragListener(this.canvasDropTarget);
        }
        if (this.editingController != null) {
            getPageViewModel().setZoomController(this.zoomController);
        }
        EditingController editingController7 = this.editingController;
        if (editingController7 != null) {
            editingController7.setZoomController(this.zoomController);
        }
        PageController pageController = pageControllerState.getPageController();
        if (pageController.currentInlineSelectionTextType() != PageController.InlineSelectionTextType.NONE) {
            pageController.callKeyboardCallbacksAgain();
        }
        pageController.addEventListener(new IEventListener() { // from class: com.myscript.nebo.editing.PageFragment$bindPageController$eventListener$1

            /* JADX INFO: compiled from: PageFragment.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* synthetic */ class EntriesMappings {
                public static final /* synthetic */ EnumEntries<GestureType> entries$0 = EnumEntriesKt.enumEntries(GestureType.values());
            }

            @Override // com.myscript.snt.core.IEventListener
            public void flush() {
            }

            @Override // com.myscript.snt.core.IEventListener
            public void itemChanged(String activeAreaId, long tagId) {
            }

            @Override // com.myscript.snt.core.IEventListener
            public void itemRemoved(String activeAreaId, long tagId) {
            }

            @Override // com.myscript.snt.core.IEventListener
            public void selectionChanged() {
            }

            @Override // com.myscript.snt.core.IEventListener
            public void itemAdded(String activeAreaId, long tagId) {
                Box box;
                PageFragment.Callback callback;
                PageFragment pageFragment;
                PageController pageController2;
                Box box2;
                PageFragment.Callback callback2;
                PageProperties value = this.this$0.getPageViewModel().getPageProperties().getValue();
                PageType pageType = value != null ? value.getPageType() : null;
                if (pageType == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                if (pageType == PageType.TextDocument) {
                    if (activeAreaId == null || (pageController2 = (pageFragment = this.this$0).getPageController()) == null || (box2 = pageController2.getBox(activeAreaId)) == null || !Intrinsics.areEqual(box2.type(), "TextBox") || (callback2 = pageFragment.callback) == null) {
                        return;
                    }
                    callback2.notifyDocumentTextBoxAdded();
                    return;
                }
                String strValueOf = String.valueOf(tagId);
                PageFragment pageFragment2 = this.this$0;
                PageController pageController3 = pageFragment2.getPageController();
                if (pageController3 == null || (box = pageController3.getBox(strValueOf)) == null) {
                    return;
                }
                if ((Intrinsics.areEqual(box.type(), "Text") || Intrinsics.areEqual(box.type(), "TextBox")) && (callback = pageFragment2.callback) != null) {
                    callback.notifyTextBoxAdded();
                }
            }

            @Override // com.myscript.snt.core.IEventListener
            public void gestureTriggered(String activeAreaId, int gestureType, int geometry, int toolKind, String contentType) {
                PageFragment.Callback callback;
                if (EntriesMappings.entries$0.get(gestureType) != GestureType.GESTURE_TYPE_SCRATCH_OUT || (callback = this.this$0.callback) == null) {
                    return;
                }
                callback.notifyScratchOutGesture();
            }

            @Override // com.myscript.snt.core.IEventListener
            public void holdItemAdded(String activeAreaId, List<Long> tagIds) {
                Intrinsics.checkNotNullParameter(activeAreaId, "activeAreaId");
                Intrinsics.checkNotNullParameter(tagIds, "tagIds");
                PageFragment.Callback callback = this.this$0.callback;
                if (callback != null) {
                    callback.notifyHoldItemAdded();
                }
            }
        });
        pageController.addURIListener(this.onCanvasUriClicked);
        pageController.addReflowSessionListener(this.onReflowUpdate);
        getPageViewModel().registerPageStateListener(pageController);
        SmartGuideController smartGuideController = this.smartGuideController;
        if (smartGuideController != null) {
            smartGuideController.setEditingController(this.editingController, getRenderingView());
        }
        SmartGuideController smartGuideController2 = this.smartGuideController;
        if (smartGuideController2 != null) {
            smartGuideController2.setBackgroundColor(pageBackgroundColor);
        }
        if (isResumed()) {
            getToolbarViewModel().unbindPageController();
            getToolbarViewModel().bindPageController(pageController);
        }
        Uri uri = this.pendingCameraImageUri;
        if (uri != null) {
            this.pendingCameraImageUri = null;
            streamImageToPage(uri);
        }
        getSearchViewModel().bindPageController(state.getPageKey(), pageControllerState.getPageController());
        Callback callback = this.callback;
        if (callback != null) {
            PageKey openPageKey = getPageViewModel().getOpenPageKey();
            if (openPageKey == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            callback.onPageReady(openPageKey);
        }
        View view = this.loadFailPlaceholder;
        if (view != null) {
            view.setVisibility(8);
        }
        EditingController editingController8 = this.editingController;
        if (editingController8 != null) {
            editingController8.setSizeChangedListener(new EditingController.SizeChangedListener() { // from class: com.myscript.nebo.editing.PageFragment.bindPageController.3
                @Override // com.myscript.nebo.editing.EditingController.SizeChangedListener
                public void beforeOnSizeChanged(int w, int h) {
                    FragmentActivity fragmentActivityRequireActivity = PageFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                    if ((fragmentActivityRequireActivity.getWindow().getDecorView().getSystemUiVisibility() & 6) == 0) {
                        PageFragment.this.enableForceRestoreScrollPositionForNotebook();
                    }
                }

                @Override // com.myscript.nebo.editing.EditingController.SizeChangedListener
                public void afterOnSizeChanged(int w, int h) {
                    FragmentActivity fragmentActivityRequireActivity = PageFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                    if ((fragmentActivityRequireActivity.getWindow().getDecorView().getSystemUiVisibility() & 6) == 0) {
                        return;
                    }
                    PageFragment.this.disableForceRestoreScrollPositionForNotebook();
                }
            });
        }
        requireActivity().invalidateMenu();
    }

    private final void unbindPageController() {
        TechnicalLoggerExt.setPageKeyValues(getLogger(), null);
        TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Unloading PageController", null, 4, null);
        SmartGuideController smartGuideController = this.smartGuideController;
        if (smartGuideController != null) {
            smartGuideController.setEditingController(null, null);
        }
        EditingController editingController = this.editingController;
        if (editingController != null) {
            PageController pageControllerNewRef = editingController.getPageControllerNewRef();
            if (pageControllerNewRef != null) {
                PageController pageController = pageControllerNewRef;
                try {
                    PageController pageController2 = pageController;
                    pageController2.removeURIListener(this.onCanvasUriClicked);
                    pageController2.removeReflowSessionListener(this.onReflowUpdate);
                    getPageViewModel().unregisterPageStateListener(pageController2);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController, null);
                } finally {
                }
            }
            editingController.getTouchFeatureImpl().removeGestureListener(this.onTouchGesture);
            DocumentRenderingView renderingView = editingController.getRenderingView();
            if (renderingView != null) {
                renderingView.setOnDragListener(null);
            }
            editingController.setZoomController(null);
            editingController.setLogger(null);
            editingController.release();
        }
        this.editingController = null;
        getPageViewModel().setZoomController(null);
    }

    private final void configureInkCapture(ToolConfiguration toolConfiguration, boolean enableActivePen) {
        EditingController.PenConfig penConfig;
        EditingController editingController = this.editingController;
        if (editingController == null || (penConfig = editingController.getPenConfig()) == null) {
            return;
        }
        int color2 = toolConfiguration.getColor2();
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
        penConfig.setPenColor(((ColorPolicyRepositoryProvider) application).provideColorPolicyRepository().invertColor(color2));
        PageController pageController = getPageController();
        if (pageController != null) {
            ViewTransform viewTransform = pageController;
            try {
                ViewTransform viewTransform2 = viewTransform.getViewTransform();
                if (viewTransform2 != null) {
                    viewTransform = viewTransform2;
                    try {
                        penConfig.setPenWidth(ToolbarConfigurationExt.getInkThicknessForScreen(toolConfiguration, viewTransform, this.styleProperties));
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(viewTransform, null);
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                    }
                }
                AutoCloseableKt.closeFinally(viewTransform, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        penConfig.setPenStroker(ToolbarConfigurationExt.getStroker(toolConfiguration));
        penConfig.setActivePenEnabled(enableActivePen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reconfigureInkCapture(ToolType selectedToolType) {
        ToolConfiguration toolConfigurationFindToolConfigurationByType;
        if (ToolbarConfigurationExt.isWritingTool(selectedToolType)) {
            toolConfigurationFindToolConfigurationByType = getToolbarViewModel().findToolConfigurationByType(selectedToolType);
        } else {
            if (selectedToolType == ToolType.Keyboard) {
                this.handler.post(new Runnable() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda38
                    @Override // java.lang.Runnable
                    public final void run() {
                        PageFragment.reconfigureInkCapture$lambda$0(this.f$0);
                    }
                });
            }
            toolConfigurationFindToolConfigurationByType = getToolbarViewModel().findToolConfigurationByType(ToolType.Pen);
        }
        if (toolConfigurationFindToolConfigurationByType != null) {
            configureInkCapture(toolConfigurationFindToolConfigurationByType, getToolbarViewModel().findToolConfigurationByType(ToolType.InteractionTool) == null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reconfigureInkCapture$lambda$0(PageFragment pageFragment) {
        EditingController editingController = pageFragment.editingController;
        if (editingController != null) {
            editingController.enableKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPagePropertiesUpdate(PageProperties pageProperties) {
        int color;
        TechnicalLoggerExt.setPageKeyValues(getLogger(), pageProperties);
        View view = getView();
        if (view != null) {
            if (pageProperties.isFixedPageSize() || pageProperties.getPageType() == PageType.PDF) {
                color = ResourcesCompat.getColor(getResources(), C6079R.color.pdf_background_color, view.getContext().getTheme());
            } else {
                color = pageProperties.getPageBackgroundColor();
            }
            Drawable background = view.getBackground();
            int color2 = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            if (color2 == 0) {
                view.setBackgroundColor(color);
            } else {
                ObjectAnimator.ofArgb(view, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, color2, color).start();
            }
        }
        EditingController editingController = this.editingController;
        if (editingController != null) {
            editingController.setPaperSize(pageProperties.getPaperSize(), pageProperties.getPageBackgroundColor());
        }
        SmartGuideController smartGuideController = this.smartGuideController;
        if (smartGuideController != null) {
            smartGuideController.setBackgroundColor(pageProperties.getPageBackgroundColor());
        }
        Callback callback = this.callback;
        if (callback != null) {
            callback.onPagePropertiesChanged(getPageViewModel().getOpenPageKey(), pageProperties);
        }
    }

    private final void exportToPowerPoint(String boxId) {
        PageKey openPageKey = getPageViewModel().getOpenPageKey();
        if (openPageKey == null) {
            return;
        }
        ExportDialog exportDialogNewInstance = ExportDialog.INSTANCE.newInstance(openPageKey, boxId, MimeType.PPTX);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        exportDialogNewInstance.show(childFragmentManager);
    }

    private final void showCameraPermissionRationaleDialog() {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.camera_missing_permission_alert_dialog_title).setMessage(C6079R.string.camera_missing_permission_alert_dialog_message).setPositiveButton(C6079R.string.camera_missing_permission_alert_dialog_settings_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda62
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PageFragment.showCameraPermissionRationaleDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCameraPermissionRationaleDialog$lambda$0(PageFragment pageFragment, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(Keys.PACKAGE, pageFragment.requireContext().getPackageName(), null));
        pageFragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$0(PageFragment pageFragment, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (!permissions.isEmpty()) {
            if (!permissions.isEmpty()) {
                Iterator it = permissions.entrySet().iterator();
                while (it.hasNext()) {
                    if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    }
                }
            }
            pageFragment.doRequestImageCapture();
            return;
        }
        pageFragment.showCameraPermissionRationaleDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imageCaptureLauncher$lambda$0(PageFragment pageFragment, Boolean success) {
        Intrinsics.checkNotNullParameter(success, "success");
        Uri uri = pageFragment.pendingCameraImageUri;
        if (success.booleanValue() && uri != null && (pageFragment.getPageViewModel().getState().getValue() instanceof PageViewModel.State.Loaded)) {
            pageFragment.pendingCameraImageUri = null;
            pageFragment.streamImageToPage(uri);
        } else {
            if (success.booleanValue()) {
                return;
            }
            pageFragment.pendingCameraImageUri = null;
        }
    }

    public final void requestImageCapture() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 30) {
            strArr = new String[]{"android.permission.CAMERA"};
        } else {
            strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(requireContext(), str) != 0) {
                this.cameraPermissionLauncher.launch(strArr);
                return;
            }
        }
        doRequestImageCapture();
    }

    private final void doRequestImageCapture() {
        if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(requireActivity().getPackageManager()) == null) {
            Snackbar.make(requireView(), C6079R.string.no_take_picture_app_installed, -1).show();
            return;
        }
        String str = "IMG_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault(Locale.Category.FORMAT)).format(Long.valueOf(System.currentTimeMillis())) + "." + MimeTypeMap.getSingleton().getExtensionFromMimeType("image/jpeg");
        try {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Uri fileUriForPicture = FileUriExtKt.getFileUriForPicture(contextRequireContext, str, "image/jpeg");
            if (fileUriForPicture != null) {
                this.pendingCameraImageUri = fileUriForPicture;
                try {
                    getPageViewModel().save(true, true);
                } catch (Exception e) {
                    getLogger().logError(e);
                }
                this.imageCaptureLauncher.launch(fileUriForPicture);
            }
        } catch (Exception e2) {
            getLogger().logError(e2);
        }
    }

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment$PickImage;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "input", "Landroidx/activity/result/PickVisualMediaRequest;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class PickImage extends ActivityResultContracts.PickVisualMedia {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia, androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentCreateIntent = super.createIntent(context, input);
            intentCreateIntent.putExtra("android.intent.extra.MIME_TYPES", ImageImporter.INSTANCE.getSUPPORTED_IMAGE_MIMETYPES());
            return intentCreateIntent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickImageLauncher$lambda$0(PageFragment pageFragment, Uri uri) {
        if (uri != null) {
            pageFragment.streamImageToPage(uri);
        }
    }

    public final void requestImagePick() {
        try {
            this.pickImageLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE, 0, false, null, 14, null));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(requireContext(), getString(C6079R.string.no_pick_picture_app_installed), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndAddBlock(String blockType) {
        PointerInfo pointerInfo = this.blockPosition;
        this.blockPosition = null;
        if (pointerInfo != null) {
            getPageViewModel().addBlockAt(blockType, pointerInfo.getX(), pointerInfo.getY());
        } else {
            getPageViewModel().addBlock(blockType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onImageImportStateUpdate(ImageImportState state) {
        if (!Intrinsics.areEqual(state, ImageImportState.Idle.INSTANCE)) {
            TechnicalLoggerExt.logAction(getLogger(), TAG, "Image import state update", new C63941(state));
        }
        if ((state instanceof ImageImportState.Success) || (state instanceof ImageImportState.Error)) {
            DragAndDropPermissionsCompat dragAndDropPermissionsCompat = this.pendingDropPermissions;
            if (dragAndDropPermissionsCompat != null) {
                dragAndDropPermissionsCompat.release();
            }
            this.pendingDropPermissions = null;
        }
        if (state instanceof ImageImportState.Error) {
            getLogger().logError(((ImageImportState.Error) state).getException());
            new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.page_image_import_error_title).setMessage(C6079R.string.page_image_import_error_message).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$onImageImportStateUpdate$1 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63941 extends FunctionReferenceImpl implements Function0<String> {
        C63941(Object obj) {
            super(0, obj, ImageImportState.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((ImageImportState) this.receiver).toString();
        }
    }

    private final void streamImageToPage(Uri uri) {
        PointerInfo pointerInfo = this.blockPosition;
        this.blockPosition = null;
        if (pointerInfo != null) {
            getPageViewModel().addImageAt(uri, pointerInfo.getX(), pointerInfo.getY());
        } else {
            getPageViewModel().addImage(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onContentDroppedOnCanvas(CanvasContentDropTarget.DroppedContent content, float viewX, float viewY) {
        ITouchFeature touchFeatureImpl;
        EditingController editingController = this.editingController;
        if (editingController == null || (touchFeatureImpl = editingController.getTouchFeatureImpl()) == null) {
            return;
        }
        float horizontalScrollPos = viewX + touchFeatureImpl.getHorizontalScrollPos();
        float verticalScrollPos = viewY + touchFeatureImpl.getVerticalScrollPos();
        Uri imageUri = content.getImageUri();
        String text = content.getText();
        if (imageUri == null) {
            if (text != null) {
                getPageViewModel().pasteTextAt(text, horizontalScrollPos, verticalScrollPos);
            }
        } else if (getPageViewModel().getAvailableBlockTypesAt(horizontalScrollPos, verticalScrollPos).contains(ContentTypes.IMAGE)) {
            getPageViewModel().addImageAt(imageUri, horizontalScrollPos, verticalScrollPos);
        } else {
            getPageViewModel().addImage(imageUri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPopupMenuCreated(PopupMenu popupMenu, PopupUtils.PopupInfoSaveInstanceState popupInfo) {
        resetPopupMenu();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda35
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.onPopupMenuItemClick(menuItem);
            }
        });
        this.popupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        PointerInfo pointerInfo = this.blockPosition;
        List<String> availableBlockTypesAt = pointerInfo != null ? getPageViewModel().getAvailableBlockTypesAt(pointerInfo.getX(), pointerInfo.getY()) : CollectionsKt.emptyList();
        boolean zContains = availableBlockTypesAt.contains(ContentTypes.IMAGE);
        boolean zContains2 = availableBlockTypesAt.contains(ContentTypes.DRAWING);
        boolean zContains3 = availableBlockTypesAt.contains(ContentTypes.DIAGRAM);
        boolean zContains4 = availableBlockTypesAt.contains(ContentTypes.MATH);
        boolean zContains5 = availableBlockTypesAt.contains(ContentTypes.RAW_CONTENT);
        String str = popupInfo.popupKey;
        if (str != null) {
            int iHashCode = str.hashCode();
            boolean z = true;
            if (iHashCode != -1928048802) {
                if (iHashCode == -1052251902) {
                    if (str.equals(LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU)) {
                        MenuItem menuItemFindItem = menu.findItem(C6079R.id.long_press_add_block_camera);
                        if (menuItemFindItem != null) {
                            menuItemFindItem.setVisible(zContains);
                        }
                        MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.long_press_add_block_picture);
                        if (menuItemFindItem2 != null) {
                            menuItemFindItem2.setVisible(zContains);
                        }
                        MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.long_press_add_block_sketch);
                        if (menuItemFindItem3 != null) {
                            menuItemFindItem3.setVisible(zContains2);
                        }
                        MenuItem menuItemFindItem4 = menu.findItem(C6079R.id.long_press_add_block_diagram);
                        if (menuItemFindItem4 != null) {
                            menuItemFindItem4.setVisible(zContains3);
                        }
                        MenuItem menuItemFindItem5 = menu.findItem(C6079R.id.long_press_add_block_math);
                        if (menuItemFindItem5 != null) {
                            menuItemFindItem5.setVisible(zContains4);
                        }
                        MenuItem menuItemFindItem6 = menu.findItem(C6079R.id.long_press_add_section_draft);
                        if (menuItemFindItem6 != null) {
                            menuItemFindItem6.setVisible(zContains5);
                        }
                        MenuItem menuItemFindItem7 = menu.findItem(C6079R.id.long_press_add_block);
                        if (menuItemFindItem7 != null) {
                            if (!zContains && !zContains2 && !zContains3 && !zContains4 && !zContains5) {
                                z = false;
                            }
                            menuItemFindItem7.setVisible(z);
                        }
                        MenuItem menuItemFindItem8 = menu.findItem(C6079R.id.long_press_paste);
                        if (menuItemFindItem8 != null) {
                            menuItemFindItem8.setEnabled(getPageViewModel().canPaste());
                        }
                        MenuItem menuItemFindItem9 = menu.findItem(C6079R.id.long_press_manage_space);
                        if (menuItemFindItem9 != null) {
                            menuItemFindItem9.setVisible(pointerInfo != null ? getPageViewModel().isSpaceManagementAvailableAt(pointerInfo) : false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (iHashCode != -318131239 || !str.equals(DOUBLE_TAP_ADD_BLOCK_MENU)) {
                    return;
                }
            } else if (!str.equals(FREEFORM_ADD_BLOCK_MENU)) {
                return;
            }
            MenuItem menuItemFindItem10 = menu.findItem(C6079R.id.double_tap_add_objects_category);
            if (menuItemFindItem10 != null) {
                if (!zContains && !zContains3 && !zContains2 && !zContains4) {
                    z = false;
                }
                menuItemFindItem10.setVisible(z);
            }
            MenuItem menuItemFindItem11 = menu.findItem(C6079R.id.double_tap_add_block_camera);
            if (menuItemFindItem11 != null) {
                menuItemFindItem11.setVisible(zContains);
            }
            MenuItem menuItemFindItem12 = menu.findItem(C6079R.id.double_tap_add_block_picture);
            if (menuItemFindItem12 != null) {
                menuItemFindItem12.setVisible(zContains);
            }
            MenuItem menuItemFindItem13 = menu.findItem(C6079R.id.double_tap_add_block_sketch);
            if (menuItemFindItem13 != null) {
                menuItemFindItem13.setVisible(zContains2);
            }
            MenuItem menuItemFindItem14 = menu.findItem(C6079R.id.double_tap_add_block_diagram);
            if (menuItemFindItem14 != null) {
                menuItemFindItem14.setVisible(zContains3);
            }
            MenuItem menuItemFindItem15 = menu.findItem(C6079R.id.double_tap_add_block_math);
            if (menuItemFindItem15 != null) {
                menuItemFindItem15.setVisible(zContains4);
            }
            MenuItem menuItemFindItem16 = menu.findItem(C6079R.id.double_tap_add_sections_category);
            if (menuItemFindItem16 != null) {
                menuItemFindItem16.setVisible(zContains5);
            }
            MenuItem menuItemFindItem17 = menu.findItem(C6079R.id.double_tap_add_section_draft);
            if (menuItemFindItem17 != null) {
                menuItemFindItem17.setVisible(zContains5);
            }
        }
    }

    private final void resetPopupMenu() {
        PopupMenu popupMenu = this.popupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
        PopupMenu popupMenu2 = this.popupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(null);
        }
        this.popupMenu = null;
        PopupUtils.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onPopupMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == C6079R.id.long_press_add_block) {
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Add... from long press popup menu", null, 4, null);
            return true;
        }
        if (itemId == C6079R.id.long_press_paste) {
            final PointerInfo pointerInfo = this.blockPosition;
            if (pointerInfo != null) {
                TechnicalLoggerExt.logAction(getLogger(), TAG, "Paste from long press popup menu", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onPopupMenuItemClick$lambda$0$0(pointerInfo);
                    }
                });
                getPageViewModel().pasteAt(pointerInfo.getX(), pointerInfo.getY());
                return true;
            }
        } else {
            if (itemId == C6079R.id.double_tap_add_block_camera || itemId == C6079R.id.long_press_add_block_camera) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Request camera from popup menu", null, 4, null);
                requestImageCapture();
                return true;
            }
            if (itemId == C6079R.id.double_tap_add_block_picture || itemId == C6079R.id.long_press_add_block_picture) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Request image from popup menu", null, 4, null);
                requestImagePick();
                return true;
            }
            if (itemId == C6079R.id.double_tap_add_block_sketch || itemId == C6079R.id.long_press_add_block_sketch) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Create sketch block from popup menu", null, 4, null);
                String DRAWING = ContentTypes.DRAWING;
                Intrinsics.checkNotNullExpressionValue(DRAWING, "DRAWING");
                createAndAddBlock(DRAWING);
                return true;
            }
            if (itemId == C6079R.id.double_tap_add_block_diagram || itemId == C6079R.id.long_press_add_block_diagram) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Create diagram block from popup menu", null, 4, null);
                String DIAGRAM = ContentTypes.DIAGRAM;
                Intrinsics.checkNotNullExpressionValue(DIAGRAM, "DIAGRAM");
                createAndAddBlock(DIAGRAM);
                return true;
            }
            if (itemId == C6079R.id.double_tap_add_block_math || itemId == C6079R.id.long_press_add_block_math) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Create math block from popup menu", null, 4, null);
                String MATH = ContentTypes.MATH;
                Intrinsics.checkNotNullExpressionValue(MATH, "MATH");
                createAndAddBlock(MATH);
                return true;
            }
            if (itemId == C6079R.id.double_tap_add_section_draft || itemId == C6079R.id.long_press_add_section_draft) {
                TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Create freeform section block from popup menu", null, 4, null);
                String RAW_CONTENT = ContentTypes.RAW_CONTENT;
                Intrinsics.checkNotNullExpressionValue(RAW_CONTENT, "RAW_CONTENT");
                createAndAddBlock(RAW_CONTENT);
                return true;
            }
            if (itemId != C6079R.id.long_press_manage_space) {
                return false;
            }
            final PointerInfo pointerInfo2 = this.blockPosition;
            if (pointerInfo2 != null) {
                TechnicalLoggerExt.logAction(getLogger(), TAG, "Space management from popup menu", new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.onPopupMenuItemClick$lambda$1$0(pointerInfo2);
                    }
                });
                getPageViewModel().spaceManagementAt(pointerInfo2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPopupMenuItemClick$lambda$0$0(PointerInfo pointerInfo) {
        return "(" + pointerInfo.getX() + TextRecallingManager.ANSWER_SEPARATOR + pointerInfo.getY() + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPopupMenuItemClick$lambda$1$0(PointerInfo pointerInfo) {
        return "(" + pointerInfo.getX() + TextRecallingManager.ANSWER_SEPARATOR + pointerInfo.getY() + ")";
    }

    private final void addWordIntoDictionary(final String word) {
        if (word == null || !getPageViewModel().learnWord(word)) {
            return;
        }
        String string = requireContext().getString(C6889R.string.user_dict_add_from_inline_banner_word_added, word);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        getBannerViewModel().push(new Banner.FeedbackBanner(BANNER_ID_USER_DICT, string, Type.TRANSIENT, getString(C6889R.string.user_dict_add_from_inline_banner_undo), new Runnable() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PageFragment.addWordIntoDictionary$lambda$0(this.f$0, word);
            }
        }, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addWordIntoDictionary$lambda$0(PageFragment pageFragment, String str) {
        pageFragment.getPageViewModel().forgetWord(str);
    }

    private final void showActionMenuEntries(PageController pageController, List<? extends ActionMenuEntry> actionMenuEntries, Point inputPoint, ActionMenuCallback callback) {
        DocumentRenderingView renderingView;
        ViewTransform viewTransform;
        EditingController editingController = this.editingController;
        boolean z = true;
        if (editingController != null ? Intrinsics.areEqual((Object) editingController.isMagnifierShowing(), (Object) true) : false) {
            return;
        }
        this.contextualMenuManager.updateActionMenu(actionMenuEntries, inputPoint, callback);
        List<? extends ActionMenuEntry> list = actionMenuEntries;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z || (renderingView = getRenderingView()) == null || pageController == null || (viewTransform = pageController.getViewTransform()) == null) {
            return;
        }
        ViewTransform viewTransform2 = viewTransform;
        try {
            this.contextualMenuManager.showContextualMenu(renderingView, viewTransform2);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(viewTransform2, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(viewTransform2, th);
                throw th2;
            }
        }
    }

    private final void updateOptionsMenu() {
        MenuItem menuItem;
        MenuItem menuItem2 = this.searchMenuItem;
        View actionView = menuItem2 != null ? menuItem2.getActionView() : null;
        SearchView searchView = actionView instanceof SearchView ? (SearchView) actionView : null;
        if (searchView == null || searchView.isIconified()) {
            requireActivity().invalidateMenu();
        } else {
            if (!getSearchViewModel().isSearchModeActive() || (menuItem = this.searchMenuItem) == null) {
                return;
            }
            menuItem.collapseActionView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSharePageDialog() {
        PageModel page;
        PageKey openPageKey = getPageViewModel().getOpenPageKey();
        if (openPageKey == null || (page = getLibraryRepository().getPage(openPageKey)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C64021(openPageKey, page, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$openSharePageDialog$1 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageFragment$openSharePageDialog$1", m1609f = "PageFragment.kt", m1610i = {}, m1611l = {2294}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {2297}, m1615s = {}, m1616v = 2)
    static final class C64021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageModel $page;
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64021(PageKey pageKey, PageModel pageModel, Continuation<? super C64021> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$page = pageModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageFragment.this.new C64021(this.$pageKey, this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TechnicalLoggerExt.logPageDetails(PageFragment.this.getLogger(), PageFragment.TAG, "Save before sharing", this.$pageKey, this.$page);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(PageFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TechnicalLoggerExt.logAction$default(PageFragment.this.getLogger(), PageFragment.TAG, "Share Page Dialog", null, 4, null);
            SharePageDialog.INSTANCE.newInstance(this.$pageKey, this.$page.getTitle()).show(PageFragment.this.getParentFragmentManager(), SharePageDialog.TAG);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$openSharePageDialog$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageFragment.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageFragment$openSharePageDialog$1$1", m1609f = "PageFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PageFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageFragment pageFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = pageFragment;
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
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    PageViewModel.save$default(this.this$0.getPageViewModel(), false, false, 3, null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void showPdfOptimizationDialogView() {
        ViewGroup viewGroup;
        FragmentActivity activity = getActivity();
        if (activity == null || (viewGroup = (ViewGroup) activity.findViewById(android.R.id.content)) == null || this.pdfOptimDialogView != null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(22299045, true, new Function2() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PageFragment.showPdfOptimizationDialogView$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        viewGroup.addView(composeView, new ViewGroup.LayoutParams(-1, -1));
        this.pdfOptimDialogView = composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPdfOptimizationDialogView$lambda$0$0(final PageFragment pageFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2314@112239L618,2326@112891L48,2312@112151L806:PageFragment.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(22299045, i, -1, "com.myscript.nebo.editing.PageFragment.showPdfOptimizationDialogView.<anonymous>.<anonymous> (PageFragment.kt:2312)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -45450225, "CC(remember):PageFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(pageFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda63
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PageFragment.showPdfOptimizationDialogView$lambda$0$0$0$0(this.f$0, (PdfOptimizationLevel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -45429931, "CC(remember):PageFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(pageFragment);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PageFragment.showPdfOptimizationDialogView$lambda$0$0$1$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PdfOptimizationKt.PdfOptimizationDialog(true, function1, (Function0) objRememberedValue2, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPdfOptimizationDialogView$lambda$0$0$0$0(PageFragment pageFragment, final PdfOptimizationLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        NeboFirebaseEvent.PdfOptimization.log(new Function1() { // from class: com.myscript.nebo.editing.PageFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageFragment.showPdfOptimizationDialogView$lambda$0$0$0$0$0(level, (Bundle) obj);
            }
        });
        pageFragment.getPageViewModel().optimizePdf(level);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPdfOptimizationDialogView$lambda$0$0$0$0$0(PdfOptimizationLevel pdfOptimizationLevel, Bundle log) {
        String str;
        Intrinsics.checkNotNullParameter(log, "$this$log");
        int i = WhenMappings.$EnumSwitchMapping$3[pdfOptimizationLevel.ordinal()];
        if (i == 1) {
            str = "small";
        } else if (i == 2) {
            str = FirebaseAnalytics.Param.MEDIUM;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "high";
        }
        log.putString("type", str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPdfOptimizationDialogView$lambda$0$0$1$0(PageFragment pageFragment) {
        pageFragment.getPageViewModel().dismissPdfOptimizationDialog();
        return Unit.INSTANCE;
    }

    private final void hidePdfOptimizationDialog() {
        ComposeView composeView = this.pdfOptimDialogView;
        if (composeView != null) {
            ViewParent parent = composeView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(composeView);
            }
        }
        this.pdfOptimDialogView = null;
    }

    private final void showOptimizationOverlay(String message) {
        ViewGroup viewGroup;
        FragmentActivity activity = getActivity();
        if (activity == null || (viewGroup = (ViewGroup) activity.findViewById(android.R.id.content)) == null) {
            return;
        }
        hideOptimizationOverlay();
        View viewInflate = getLayoutInflater().inflate(C6079R.layout.pdf_optimization_overlay, viewGroup, false);
        ((TextView) viewInflate.findViewById(C6079R.id.pdf_optim_overlay_message)).setText(message);
        viewGroup.addView(viewInflate);
        this.optimizationOverlay = viewInflate;
    }

    private final void showOptimizationResult(String message) {
        showOptimizationOverlay(message);
        View view = this.optimizationOverlay;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(0);
        view.setClickable(false);
        view.setFocusable(false);
    }

    private final void hideOptimizationOverlay() {
        View view = this.optimizationOverlay;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.optimizationOverlay = null;
    }

    public final boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zIsCtrlPressed = event.isCtrlPressed();
        boolean zIsShiftPressed = event.isShiftPressed();
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 54) {
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Undo Shortcut", null, 4, null);
            getPageViewModel().undo();
            return true;
        }
        if ((zIsCtrlPressed && !zIsShiftPressed && keyCode == 53) || (zIsCtrlPressed && zIsShiftPressed && keyCode == 54)) {
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Redo Shortcut", null, 4, null);
            getPageViewModel().redo();
            return true;
        }
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 34) {
            if (!getLibraryRepository().isCloudSyncOngoing()) {
                getSearchViewModel().setSearchType(DMSSearchController.SearchType.PAGE);
                MenuItem menuItem = this.searchMenuItem;
                if (menuItem != null) {
                    menuItem.expandActionView();
                }
            }
            return true;
        }
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 52) {
            getPageViewModel().cutSelection();
            return true;
        }
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 31) {
            getPageViewModel().copySelection();
            return true;
        }
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 50) {
            getPageViewModel().paste();
            return true;
        }
        if (zIsCtrlPressed && !zIsShiftPressed && keyCode == 30) {
            getPageViewModel().emboldenSelection();
            return true;
        }
        if (!zIsCtrlPressed || zIsShiftPressed || keyCode != 49) {
            return false;
        }
        getPageViewModel().underlineSelection();
        return true;
    }

    public final void closeKeyboard() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.keyboardAction(KeyboardAction.CLOSE);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void createSiblingPage(Function1<? super PageKey, Unit> updateOpenNote) {
        Intrinsics.checkNotNullParameter(updateOpenNote, "updateOpenNote");
        PageKey openPageKey = getPageViewModel().getOpenPageKey();
        if (openPageKey == null) {
            return;
        }
        TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Create new sibling page from page " + openPageKey.uuid(), null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C63921(updateOpenNote, this, openPageKey, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageFragment$createSiblingPage$1 */
    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageFragment$createSiblingPage$1", m1609f = "PageFragment.kt", m1610i = {}, m1611l = {2415}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {2417}, m1615s = {}, m1616v = 2)
    static final class C63921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $sourcePageKey;
        final /* synthetic */ Function1<PageKey, Unit> $updateOpenNote;
        int label;
        final /* synthetic */ PageFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C63921(Function1<? super PageKey, Unit> function1, PageFragment pageFragment, PageKey pageKey, Continuation<? super C63921> continuation) {
            super(2, continuation);
            this.$updateOpenNote = function1;
            this.this$0 = pageFragment;
            this.$sourcePageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63921(this.$updateOpenNote, this.this$0, this.$sourcePageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new PageFragment$createSiblingPage$1$siblingPageKey$1(this.this$0, this.$sourcePageKey, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PageKey pageKey = (PageKey) obj;
            if (pageKey == null) {
                return Unit.INSTANCE;
            }
            this.$updateOpenNote.invoke(pageKey);
            return Unit.INSTANCE;
        }
    }

    private final void tagCorruptionWarningInfoPage(String reason, String message) {
        getPageViewModel().tagCorruptionWarningInfoPage(reason, message);
    }

    public final void zoom(float zoomFactor) {
        getPageViewModel().zoom(zoomFactor);
    }

    public final void toggleLockZoom() {
        getPageViewModel().toggleLockZoom();
    }

    public final void setBackgroundColor(int color) {
        getPageViewModel().setBackgroundColor(color);
    }

    public final void setBackgroundPattern(BackgroundPattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        getPageViewModel().setBackgroundPattern(pattern);
    }

    private final boolean loadCrashLoopDetected() {
        PageKey openPageKey = getPageViewModel().getOpenPageKey();
        if (openPageKey == null) {
            return true;
        }
        ICrashCountState crashCountState = getCrashCountState();
        String strUuid = openPageKey.uuid();
        Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
        return crashCountState.shouldLeaveCrashingPage(strUuid);
    }

    private final boolean loadFailureDetected() {
        PageKey openPageKey;
        if (loadCrashLoopDetected() || (openPageKey = getPageViewModel().getOpenPageKey()) == null) {
            return true;
        }
        ICrashCountState crashCountState = getCrashCountState();
        String strSerialize = openPageKey.serialize();
        Intrinsics.checkNotNullExpressionValue(strSerialize, "serialize(...)");
        return crashCountState.shouldLeaveCrashingPage(strSerialize) || getLibraryRepository().isPageCorrupted(openPageKey);
    }

    public final void tryReloadAfterLoadFailure() {
        PageType pageType;
        if (getPageViewModel().getOpenPageKey() == null) {
            ICrashCountState crashCountState = getCrashCountState();
            String strUuid = getOpenedPageKey().uuid();
            Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
            crashCountState.resetCrashCount(strUuid);
        }
        if (loadFailureDetected()) {
            View view = this.loadFailPlaceholder;
            if (view != null) {
                view.setVisibility(8);
            }
            PageKey openPageKey = getPageViewModel().getOpenPageKey();
            if (openPageKey != null) {
                ICrashCountState crashCountState2 = getCrashCountState();
                String strUuid2 = openPageKey.uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid2, "uuid(...)");
                crashCountState2.resetCrashCount(strUuid2);
                DocumentRenderingView renderingView = getRenderingView();
                if (renderingView != null) {
                    PageProperties value = getPageViewModel().getPageProperties().getValue();
                    String strContentType = (value == null || (pageType = value.getPageType()) == null) ? null : Page.contentType(pageType);
                    boolean z = strContentType != null && isSmartGuideSupported(strContentType);
                    PageViewModel pageViewModel = getPageViewModel();
                    DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(renderingView.getContext());
                    Intrinsics.checkNotNullExpressionValue(fixedDisplayMetrics, "getFixedDisplayMetrics(...)");
                    pageViewModel.loadPage(fixedDisplayMetrics, z, getCustomResources());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableForceRestoreScrollPositionForNotebook() {
        PageController pageController;
        if (getPageViewModel().getContainerPageKey() == null || (pageController = getPageController()) == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.setProperty("scroll.restore.position.enable", CredentialEntry.TRUE_STRING);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(pageController2, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableForceRestoreScrollPositionForNotebook() {
        boolean z = getPageViewModel().getContainerPageKey() != null;
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.setProperty("scroll.restore.position.enable", String.valueOf(!z));
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    private final void updateHoverCursor() {
        DocumentRenderingView renderingView;
        ToolType value;
        if (!this.spenHoverCursorActive || (renderingView = getRenderingView()) == null || (value = getToolbarViewModel().getSelectedToolType().getValue()) == null) {
            return;
        }
        ToolConfiguration toolConfigurationFindToolConfigurationByType = getToolbarViewModel().findToolConfigurationByType(value);
        ColorNonePill value2 = getToolbarViewModel().getColorNone().getValue();
        boolean z = false;
        if (value2 != null && value2.isSelected()) {
            z = true;
        }
        SpenHoverCursor spenHoverCursor = this.spenHoverCursor;
        if (spenHoverCursor != null) {
            spenHoverCursor.update(renderingView, value, toolConfigurationFindToolConfigurationByType != null ? toolConfigurationFindToolConfigurationByType.getColor2() : -16777216, z);
        }
    }

    /* JADX INFO: compiled from: PageFragment.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageFragment$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_KEY_ARGUMENT", "ALLOW_TRY_RELOAD_ARGUMENT", "CONTEXTUAL_MENU_GROUP_ID", "KEY_CAMERA_FILE_URI", "BANNER_ID_USER_DICT", PageFragment.LONG_PRESS_ADD_BLOCK_AND_PASTE_MENU, PageFragment.DOUBLE_TAP_ADD_BLOCK_MENU, PageFragment.FREEFORM_ADD_BLOCK_MENU, "CORRUPTED_PAGE_RESULT_CODE", "", "newInstance", "Lcom/myscript/nebo/editing/PageFragment;", PageFragment.PAGE_KEY_ARGUMENT, "Lcom/myscript/snt/core/PageKey;", PageFragment.ALLOW_TRY_RELOAD_ARGUMENT, "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageFragment newInstance(PageKey pageKey, boolean allowTryReload) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            PageFragment pageFragment = new PageFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PageFragment.PAGE_KEY_ARGUMENT, pageKey.serialize());
            bundle.putBoolean(PageFragment.ALLOW_TRY_RELOAD_ARGUMENT, allowTryReload);
            pageFragment.setArguments(bundle);
            return pageFragment;
        }
    }
}
