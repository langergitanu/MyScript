package com.myscript.nebo.editing;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.snt.core.ChildPageThumbnailGenerator;
import com.myscript.snt.core.IChildPageThumbnailGenerator;
import com.myscript.snt.core.IChildPageThumbnailListener;
import com.myscript.snt.core.IThumbnailerImageRequester;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.IPaginatedContainerListener;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import com.myscript.snt.dms.PageAction;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009c\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010f\u001a\u00020gJ\u0006\u0010h\u001a\u00020gJ4\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001a0j2\b\u0010k\u001a\u0004\u0018\u00010,2\u0014\b\u0002\u0010l\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020n0mH\u0082@¢\u0006\u0002\u0010oJ\"\u0010p\u001a\u00020g2\u0006\u0010C\u001a\u00020B2\b\u0010G\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010q\u001a\u00020 J\u0006\u0010r\u001a\u00020gJ\b\u0010s\u001a\u00020gH\u0002J\u0006\u0010t\u001a\u00020gJ\b\u0010u\u001a\u00020gH\u0002J\u0014\u0010v\u001a\b\u0012\u0004\u0012\u00020w0j2\u0006\u0010x\u001a\u00020\u001aJ\u0018\u0010y\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001a2\b\b\u0002\u0010z\u001a\u00020 J\u000e\u0010{\u001a\u00020g2\u0006\u0010|\u001a\u00020.J\u0018\u0010}\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001a2\b\b\u0002\u0010~\u001a\u00020 J\u000e\u0010\u007f\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\u000f\u0010\u0080\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\u0015\u0010\u0081\u0001\u001a\u00020g2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0jJ\u000f\u0010\u0082\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\u000f\u0010\u0083\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\u0018\u0010\u0084\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001a2\u0007\u0010\u0085\u0001\u001a\u00020.J\u000f\u0010\u0086\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\t\u0010\u0087\u0001\u001a\u00020gH\u0017J\u0019\u0010\u0088\u0001\u001a\u00020g2\u0007\u0010\u0089\u0001\u001a\u00020F2\u0007\u0010\u008a\u0001\u001a\u00020.J\u001a\u0010\u008b\u0001\u001a\u00020g2\u0007\u0010\u0089\u0001\u001a\u00020F2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020g2\u0006\u0010x\u001a\u00020\u001aJ\u0010\u0010\u008f\u0001\u001a\u00020g2\u0007\u0010\u0090\u0001\u001a\u00020 J\u0007\u0010\u0091\u0001\u001a\u00020gJ\u0007\u0010\u0092\u0001\u001a\u00020gJ\u0007\u0010\u0093\u0001\u001a\u00020gJ\u0007\u0010\u0094\u0001\u001a\u00020 J\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020F0jJ\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020,0jJ\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020.0jJ\u0007\u0010\u0098\u0001\u001a\u00020gJ\u0011\u0010\u0099\u0001\u001a\u00020g2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010 0 0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001c8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001c8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b2\u0010\"R\u0011\u00103\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b4\u0010\"R\u0011\u00105\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b6\u0010\"R$\u00109\u001a\u0002082\u0006\u00107\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b?\u0010\"R\u0011\u0010@\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bA\u0010\"R\"\u0010C\u001a\u0004\u0018\u00010B2\b\u00107\u001a\u0004\u0018\u00010B@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\"\u0010G\u001a\u0004\u0018\u00010F2\b\u00107\u001a\u0004\u0018\u00010F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010O\u001a\u00020.2\u0006\u00107\u001a\u00020.@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00100\"\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010W\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bW\u0010\"R\u001c\u0010X\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010Y0Y0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u001c8F¢\u0006\u0006\u001a\u0004\b[\u0010\u001eR\u001c\u0010\\\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010]0]0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u001c8F¢\u0006\u0006\u001a\u0004\b^\u0010\u001eR+\u0010`\u001a\u00020 2\u0006\u0010_\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\ba\u0010\"\"\u0004\bb\u0010c¨\u0006\u009d\u0001"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPagesViewModel;", "Landroidx/lifecycle/ViewModel;", "thumbnailImageCreator", "Lcom/myscript/snt/core/IThumbnailerImageRequester;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "discoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "sharedPreferences", "Landroid/content/SharedPreferences;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "workDispatcher", "ioDispatcher", "thumbnailUpdateScheduler", "Ljava/util/concurrent/ScheduledExecutorService;", "thumbnailUpdatePeriod", "Lkotlin/time/Duration;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Lcom/myscript/snt/core/IThumbnailerImageRequester;Lcom/myscript/nebo/account/UserProfileManager;Lcom/myscript/nebo/discoverability/DiscoverabilityManager;Landroid/content/SharedPreferences;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/ScheduledExecutorService;JLcom/myscript/nebo/log/TechnicalLogger;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "_childPages", "Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/editing/ChildPage;", "childPages", "Landroidx/lifecycle/LiveData;", "getChildPages", "()Landroidx/lifecycle/LiveData;", "needsColorInversion", "", "getNeedsColorInversion", "()Z", "_isSelectionMode", "kotlin.jvm.PlatformType", "isSelectionMode", "_discoveryTooltip", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "discoveryTooltip", "getDiscoveryTooltip", "selectedPageIds", "", "", "selectedPagesCount", "", "getSelectedPagesCount", "()I", "canDelete", "getCanDelete", "canSelectAll", "getCanSelectAll", "canDeselectAll", "getCanDeselectAll", "value", "Lcom/myscript/atk/core/IColorInversionPolicy;", "colorInversionPolicy", "getColorInversionPolicy", "()Lcom/myscript/atk/core/IColorInversionPolicy;", "setColorInversionPolicy", "(Lcom/myscript/atk/core/IColorInversionPolicy;)V", "canConfigureBackground", "getCanConfigureBackground", "displayPageInsertionButton", "getDisplayPageInsertionButton", "Lcom/myscript/snt/dms/IPaginatedContainer;", "paginatedContainer", "getPaginatedContainer", "()Lcom/myscript/snt/dms/IPaginatedContainer;", "Lcom/myscript/snt/core/PageKey;", "openNoteKey", "getOpenNoteKey", "()Lcom/myscript/snt/core/PageKey;", "staleChildPageIds", "thumbnailAutoUpdateTask", "Ljava/util/concurrent/ScheduledFuture;", "thumbnailGenerator", "Lcom/myscript/snt/core/IChildPageThumbnailGenerator;", "thumbnailWidthInPixels", "getThumbnailWidthInPixels", "setThumbnailWidthInPixels", "(I)V", "childPageListener", "Lcom/myscript/snt/dms/IPaginatedContainerListener;", "thumbnailListener", "Lcom/myscript/snt/core/IChildPageThumbnailListener;", "isChildPagesCompatible", "_childPagesNavigationState", "Lcom/myscript/nebo/editing/ChildPagesNavigationState;", "childPagesNavigationState", "getChildPagesNavigationState", "_isChildPagesPanelVisible", "Lcom/myscript/nebo/editing/ChildPagesPanelVisibilityState;", "isChildPagesPanelVisible", "<set-?>", "lastUserChildPagesPanelState", "getLastUserChildPagesPanelState", "setLastUserChildPagesPanelState", "(Z)V", "lastUserChildPagesPanelState$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "toggleChildPagesPanel", "", "hideChildPagesPanel", "computeChildPages", "", "selectedPageId", "selectionStates", "", "Lcom/myscript/nebo/dms/core/model/SelectionState;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindPaginatedContainer", "openSidePanel", "unbindPaginatedContainer", "startThumbnailsAutoUpdate", "cleanOldThumbnails", "stopThumbnailsAutoUpdate", "getPageActions", "Lcom/myscript/nebo/editing/ChildPageAction;", "childPage", "selectPage", "userAction", "selectPageAt", "pageNumber", "insertPage", "afterPage", "duplicatePage", "deletePage", "deletePages", "movePageUp", "movePageDown", "movePageAt", "toPosition", "requestThumbnail", "onCleared", "setBackgroundColor", "pageKey", "color", "setBackgroundPattern", "pattern", "Lcom/myscript/atk/core/BackgroundPattern;", "togglePageSelection", "toggleSelectionMode", "activated", "selectAllPages", "deleteSelectedPages", "deselectAllPages", "areAllPagesSelected", "selectedPagesKeys", "selectedPagesIds", "selectedPagesIndexes", "dismissCurrentTooltip", "discover", "feature", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChildPagesViewModel extends ViewModel {
    public static final String CHILD_PAGES_PANEL_OPEN_KEY = "editing_child_pages_panel_open";
    private static final ViewModelProvider.Factory Factory;
    private static final String TAG = "ChildPagesViewModel";
    private final MutableLiveData<ImmutableList<ChildPage>> _childPages;
    private final MutableLiveData<ChildPagesNavigationState> _childPagesNavigationState;
    private MutableLiveData<TooltipUIState> _discoveryTooltip;
    private final MutableLiveData<ChildPagesPanelVisibilityState> _isChildPagesPanelVisible;
    private final MutableLiveData<Boolean> _isSelectionMode;
    private final IPaginatedContainerListener childPageListener;
    private IColorInversionPolicy colorInversionPolicy;
    private final DiscoverabilityManager discoverabilityManager;
    private final CoroutineContext ioDispatcher;

    /* JADX INFO: renamed from: lastUserChildPagesPanelState$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty lastUserChildPagesPanelState;
    private final TechnicalLogger logger;
    private final CoroutineContext mainDispatcher;
    private PageKey openNoteKey;
    private IPaginatedContainer paginatedContainer;
    private final Set<String> selectedPageIds;
    private final SharedPreferences sharedPreferences;
    private final Set<String> staleChildPageIds;
    private ScheduledFuture<?> thumbnailAutoUpdateTask;
    private IChildPageThumbnailGenerator thumbnailGenerator;
    private final IThumbnailerImageRequester thumbnailImageCreator;
    private final IChildPageThumbnailListener thumbnailListener;
    private final long thumbnailUpdatePeriod;
    private final ScheduledExecutorService thumbnailUpdateScheduler;
    private int thumbnailWidthInPixels;
    private final UserProfileManager userProfileManager;
    private final CoroutineContext workDispatcher;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(ChildPagesViewModel.class, "lastUserChildPagesPanelState", "getLastUserChildPagesPanelState()Z", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final IdentityColorInversionPolicy IdentityColorInversionPolicy = new IdentityColorInversionPolicy();

    public /* synthetic */ ChildPagesViewModel(IThumbnailerImageRequester iThumbnailerImageRequester, UserProfileManager userProfileManager, DiscoverabilityManager discoverabilityManager, SharedPreferences sharedPreferences, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, ScheduledExecutorService scheduledExecutorService, long j, TechnicalLogger technicalLogger, DefaultConstructorMarker defaultConstructorMarker) {
        this(iThumbnailerImageRequester, userProfileManager, discoverabilityManager, sharedPreferences, coroutineContext, coroutineContext2, coroutineContext3, scheduledExecutorService, j, technicalLogger);
    }

    @JvmStatic
    public static final boolean confirmStructuralChange(List<ChildPage> list, List<ChildPage> list2) {
        return INSTANCE.confirmStructuralChange(list, list2);
    }

    private ChildPagesViewModel(IThumbnailerImageRequester thumbnailImageCreator, UserProfileManager userProfileManager, DiscoverabilityManager discoverabilityManager, SharedPreferences sharedPreferences, CoroutineContext mainDispatcher, CoroutineContext workDispatcher, CoroutineContext ioDispatcher, ScheduledExecutorService thumbnailUpdateScheduler, long j, TechnicalLogger logger) {
        Intrinsics.checkNotNullParameter(thumbnailImageCreator, "thumbnailImageCreator");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(thumbnailUpdateScheduler, "thumbnailUpdateScheduler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.thumbnailImageCreator = thumbnailImageCreator;
        this.userProfileManager = userProfileManager;
        this.discoverabilityManager = discoverabilityManager;
        this.sharedPreferences = sharedPreferences;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.thumbnailUpdateScheduler = thumbnailUpdateScheduler;
        this.thumbnailUpdatePeriod = j;
        this.logger = logger;
        this._childPages = new MutableLiveData<>(ExtensionsKt.persistentListOf());
        this._isSelectionMode = new MutableLiveData<>(false);
        this._discoveryTooltip = new MutableLiveData<>(null);
        this.selectedPageIds = new LinkedHashSet();
        this.colorInversionPolicy = IdentityColorInversionPolicy;
        this.staleChildPageIds = new LinkedHashSet();
        this.childPageListener = new IPaginatedContainerListener() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1
            @Override // com.myscript.snt.dms.IPaginatedContainerListener
            public void pageSelected(String selectedPageId, long selectedPageNumber, long pageCount, boolean userAction) {
                Intrinsics.checkNotNullParameter(selectedPageId, "selectedPageId");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new ChildPagesViewModel$childPageListener$1$pageSelected$1(this.this$0, selectedPageNumber, pageCount, selectedPageId, userAction, null), 2, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.myscript.snt.dms.IPaginatedContainerListener
            public void pagesUpdated() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new ChildPagesViewModel$childPageListener$1$pagesUpdated$1(this.this$0, (ChildPagesNavigationState) this.this$0._childPagesNavigationState.getValue(), null), 2, null);
            }

            @Override // com.myscript.snt.dms.IPaginatedContainerListener
            public void pagePropertiesUpdated(String pageId) {
                Intrinsics.checkNotNullParameter(pageId, "pageId");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new ChildPagesViewModel$childPageListener$1$pagePropertiesUpdated$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.snt.dms.IPaginatedContainerListener
            public void pagesContentUpdated(List<String> pageIds) {
                Intrinsics.checkNotNullParameter(pageIds, "pageIds");
                ChildPagesViewModel childPagesViewModel = this.this$0;
                synchronized (this) {
                    CollectionsKt.addAll(childPagesViewModel.staleChildPageIds, pageIds);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.thumbnailListener = new IChildPageThumbnailListener() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$$ExternalSyntheticLambda0
            @Override // com.myscript.snt.core.IChildPageThumbnailListener
            public final void thumbnailCreated(String str, String str2, boolean z) {
                ChildPagesViewModel.thumbnailListener$lambda$0(this.f$0, str, str2, z);
            }
        };
        this._childPagesNavigationState = new MutableLiveData<>(new ChildPagesNavigationState(null, 0, false, 0, false, false, 63, null));
        this._isChildPagesPanelVisible = new MutableLiveData<>(new ChildPagesPanelVisibilityState(false, false, 3, null));
        this.lastUserChildPagesPanelState = SharedPreferencesExtKt.booleanPref(sharedPreferences, CHILD_PAGES_PANEL_OPEN_KEY, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChildPagesViewModel(IThumbnailerImageRequester iThumbnailerImageRequester, UserProfileManager userProfileManager, DiscoverabilityManager discoverabilityManager, SharedPreferences sharedPreferences, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, ScheduledExecutorService scheduledExecutorService, long j, TechnicalLogger technicalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ScheduledExecutorService scheduledExecutorService2;
        long duration;
        CoroutineContext main = (i & 16) != 0 ? Dispatchers.getMain() : coroutineContext;
        CoroutineContext coroutineContext4 = (i & 32) != 0 ? Dispatchers.getDefault() : coroutineContext2;
        CoroutineContext io2 = (i & 64) != 0 ? Dispatchers.getIO() : coroutineContext3;
        if ((i & 128) != 0) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
            scheduledExecutorService2 = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        } else {
            scheduledExecutorService2 = scheduledExecutorService;
        }
        if ((i & 256) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(5, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(iThumbnailerImageRequester, userProfileManager, discoverabilityManager, sharedPreferences, main, coroutineContext4, io2, scheduledExecutorService2, duration, technicalLogger, null);
    }

    public final LiveData<ImmutableList<ChildPage>> getChildPages() {
        return this._childPages;
    }

    private final boolean getNeedsColorInversion() {
        return !(this.paginatedContainer instanceof PDFManager);
    }

    public final LiveData<Boolean> isSelectionMode() {
        return this._isSelectionMode;
    }

    public final LiveData<TooltipUIState> getDiscoveryTooltip() {
        return this._discoveryTooltip;
    }

    public final int getSelectedPagesCount() {
        return this.selectedPageIds.size();
    }

    public final boolean getCanDelete() {
        if (!this.selectedPageIds.isEmpty()) {
            int size = this.selectedPageIds.size();
            ImmutableList<ChildPage> value = this._childPages.getValue();
            if (size < (value != null ? value.size() : 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getCanSelectAll() {
        int size = this.selectedPageIds.size();
        ImmutableList<ChildPage> value = this._childPages.getValue();
        return size < (value != null ? value.size() : 0);
    }

    public final boolean getCanDeselectAll() {
        return this.selectedPageIds.size() > 0;
    }

    public final IColorInversionPolicy getColorInversionPolicy() {
        return this.colorInversionPolicy;
    }

    public final void setColorInversionPolicy(IColorInversionPolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!getNeedsColorInversion()) {
            value = IdentityColorInversionPolicy;
        }
        this.colorInversionPolicy = value;
        IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.thumbnailGenerator;
        if (iChildPageThumbnailGenerator != null) {
            if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
            }
            ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
            if (childPageThumbnailGeneratorNewRef != null) {
                ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                try {
                    childPageThumbnailGenerator.setColorInversionPolicy(this.colorInversionPolicy);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                } finally {
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new ChildPagesViewModel$colorInversionPolicy$2(this, null), 2, null);
    }

    public final boolean getCanConfigureBackground() {
        return !(this.paginatedContainer instanceof PDFManager);
    }

    public final boolean getDisplayPageInsertionButton() {
        return !(this.paginatedContainer instanceof PDFManager);
    }

    public final IPaginatedContainer getPaginatedContainer() {
        return this.paginatedContainer;
    }

    public final PageKey getOpenNoteKey() {
        return this.openNoteKey;
    }

    public final int getThumbnailWidthInPixels() {
        return this.thumbnailWidthInPixels;
    }

    public final void setThumbnailWidthInPixels(int i) {
        IChildPageThumbnailGenerator iChildPageThumbnailGenerator;
        if (i > 0 && i != this.thumbnailWidthInPixels && (iChildPageThumbnailGenerator = this.thumbnailGenerator) != null) {
            if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
            }
            ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
            if (childPageThumbnailGeneratorNewRef != null) {
                ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                try {
                    childPageThumbnailGenerator.setThumbnailSize(i);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                } finally {
                }
            }
        }
        this.thumbnailWidthInPixels = RangesKt.coerceAtLeast(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void thumbnailListener$lambda$0(ChildPagesViewModel childPagesViewModel, String str, String str2, boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(childPagesViewModel), childPagesViewModel.mainDispatcher, null, new ChildPagesViewModel$thumbnailListener$1$1(childPagesViewModel, str, str2, z, null), 2, null);
    }

    public final boolean isChildPagesCompatible() {
        return this.paginatedContainer != null;
    }

    public final LiveData<ChildPagesNavigationState> getChildPagesNavigationState() {
        return this._childPagesNavigationState;
    }

    public final LiveData<ChildPagesPanelVisibilityState> isChildPagesPanelVisible() {
        return this._isChildPagesPanelVisible;
    }

    private final boolean getLastUserChildPagesPanelState() {
        return this.lastUserChildPagesPanelState.getValue((Object) this, $$delegatedProperties[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastUserChildPagesPanelState(boolean z) {
        this.lastUserChildPagesPanelState.setValue(this, $$delegatedProperties[0], z);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$toggleChildPagesPanel$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$toggleChildPagesPanel$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63461(Continuation<? super C63461> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63461(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChildPagesViewModel.this._isChildPagesPanelVisible.setValue(new ChildPagesPanelVisibilityState(!(((ChildPagesPanelVisibilityState) ChildPagesViewModel.this._isChildPagesPanelVisible.getValue()) != null ? r13.isVisible() : false), true));
                ChildPagesPanelVisibilityState childPagesPanelVisibilityState = (ChildPagesPanelVisibilityState) ChildPagesViewModel.this._isChildPagesPanelVisible.getValue();
                boolean zIsVisible = childPagesPanelVisibilityState != null ? childPagesPanelVisibilityState.isVisible() : false;
                ChildPagesViewModel.this.setLastUserChildPagesPanelState(zIsVisible);
                MutableLiveData mutableLiveData = ChildPagesViewModel.this._discoveryTooltip;
                TooltipUIState tooltipUIState = (TooltipUIState) ChildPagesViewModel.this._discoveryTooltip.getValue();
                mutableLiveData.setValue(tooltipUIState != null ? TooltipUIState.copy$default(tooltipUIState, 0, 0, null, 0, null, zIsVisible, null, null, 223, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleChildPagesPanel() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63461(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$hideChildPagesPanel$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$hideChildPagesPanel$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63311(Continuation<? super C63311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChildPagesViewModel.this._isChildPagesPanelVisible.setValue(new ChildPagesPanelVisibilityState(false, true));
                MutableLiveData mutableLiveData = ChildPagesViewModel.this._discoveryTooltip;
                TooltipUIState tooltipUIState = (TooltipUIState) ChildPagesViewModel.this._discoveryTooltip.getValue();
                mutableLiveData.setValue(tooltipUIState != null ? TooltipUIState.copy$default(tooltipUIState, 0, 0, null, 0, null, false, null, null, 223, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void hideChildPagesPanel() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63311(null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object computeChildPages$default(ChildPagesViewModel childPagesViewModel, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return childPagesViewModel.computeChildPages(str, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeChildPages(String str, Map<String, ? extends SelectionState> map, Continuation<? super List<ChildPage>> continuation) {
        AutoCloseable autoCloseableNewRef;
        File thumbnailFile;
        IPaginatedContainer iPaginatedContainer = this.paginatedContainer;
        if (iPaginatedContainer != null) {
            if (iPaginatedContainer instanceof NotebookManager) {
                autoCloseableNewRef = NotebookManager.newRef((NotebookManager) iPaginatedContainer);
            } else {
                if (!(iPaginatedContainer instanceof PDFManager)) {
                    throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                }
                autoCloseableNewRef = PDFManager.newRef((PDFManager) iPaginatedContainer);
            }
            ArrayList arrayList = null;
            if (autoCloseableNewRef != null) {
                ChildPageThumbnailGenerator childPageThumbnailGenerator = autoCloseableNewRef;
                try {
                    IPaginatedContainer iPaginatedContainer2 = (IPaginatedContainer) childPageThumbnailGenerator;
                    List<com.myscript.snt.dms.PageProperties> listPages = iPaginatedContainer2.pages();
                    Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
                    List<com.myscript.snt.dms.PageProperties> list = listPages;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        com.myscript.snt.dms.PageProperties pageProperties = (com.myscript.snt.dms.PageProperties) obj;
                        IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.thumbnailGenerator;
                        if (iChildPageThumbnailGenerator == null) {
                            thumbnailFile = null;
                        } else {
                            if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                                throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                            }
                            ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                            if (childPageThumbnailGeneratorNewRef != null) {
                                childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                                try {
                                    String pageId = pageProperties.getPageId();
                                    Intrinsics.checkNotNullExpressionValue(pageId, "getPageId(...)");
                                    thumbnailFile = ChildPagesViewModelKt.getThumbnailFile(childPageThumbnailGenerator, pageId);
                                    AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                                } finally {
                                }
                            }
                        }
                        Intrinsics.checkNotNull(pageProperties);
                        ChildPage childPage = ChildPagesViewModelKt.toChildPage(pageProperties, i, str, thumbnailFile);
                        SelectionState selectionState = map.get(pageProperties.getPageId());
                        if (selectionState == null) {
                            selectionState = SelectionState.NOT_SELECTABLE;
                        }
                        arrayList2.add(ChildPage.copy$default(childPage, null, false, 0, 0, 0, 0, null, null, false, selectionState, FrameMetricsAggregator.EVERY_DURATION, null));
                        i = i2;
                    }
                    ArrayList arrayList3 = arrayList2;
                    if (ChildPagesViewModelKt.isValidChildPageId(iPaginatedContainer2, str)) {
                        ArrayList arrayList4 = arrayList3;
                        if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                            Iterator it = arrayList4.iterator();
                            while (it.hasNext()) {
                                if (((ChildPage) it.next()).isActive()) {
                                    break;
                                }
                            }
                        }
                        String strSelectedPage = iPaginatedContainer2.selectedPage();
                        ArrayList<ChildPage> arrayList5 = arrayList3;
                        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                        for (ChildPage childPageCopy$default : arrayList5) {
                            if (Intrinsics.areEqual(childPageCopy$default.getId(), strSelectedPage)) {
                                childPageCopy$default = ChildPage.copy$default(childPageCopy$default, null, true, 0, 0, 0, 0, null, null, false, null, 1021, null);
                            }
                            arrayList6.add(childPageCopy$default);
                        }
                        arrayList3 = arrayList6;
                    }
                    AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                    arrayList = arrayList3;
                } finally {
                }
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ void bindPaginatedContainer$default(ChildPagesViewModel childPagesViewModel, IPaginatedContainer iPaginatedContainer, PageKey pageKey, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = childPagesViewModel.getLastUserChildPagesPanelState();
        }
        childPagesViewModel.bindPaginatedContainer(iPaginatedContainer, pageKey, z);
    }

    public final void bindPaginatedContainer(IPaginatedContainer paginatedContainer, PageKey openNoteKey, boolean openSidePanel) {
        Intrinsics.checkNotNullParameter(paginatedContainer, "paginatedContainer");
        if (this.paginatedContainer != null) {
            return;
        }
        paginatedContainer.addListener(this.childPageListener);
        this.paginatedContainer = paginatedContainer;
        this.openNoteKey = openNoteKey;
        String strSelectedPage = paginatedContainer.selectedPage();
        List<com.myscript.snt.dms.PageProperties> listPages = paginatedContainer.pages();
        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
        Iterator<com.myscript.snt.dms.PageProperties> it = listPages.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getPageId(), strSelectedPage)) {
                break;
            } else {
                i++;
            }
        }
        ChildPagesNavigationState childPagesNavigationState = new ChildPagesNavigationState(strSelectedPage, RangesKt.coerceAtLeast(i + 1, 1), false, (int) paginatedContainer.pageCount(), isChildPagesCompatible(), false, 36, null);
        IChildPageThumbnailGenerator iChildPageThumbnailGeneratorCreateChildPageThumbnailGenerator = paginatedContainer.createChildPageThumbnailGenerator(this.thumbnailImageCreator, this.colorInversionPolicy);
        iChildPageThumbnailGeneratorCreateChildPageThumbnailGenerator.addListener(this.thumbnailListener);
        int i2 = this.thumbnailWidthInPixels;
        if (i2 > 0) {
            iChildPageThumbnailGeneratorCreateChildPageThumbnailGenerator.setThumbnailSize(i2);
        }
        this.thumbnailGenerator = iChildPageThumbnailGeneratorCreateChildPageThumbnailGenerator;
        startThumbnailsAutoUpdate();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63163(childPagesNavigationState, openSidePanel, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3", m1609f = "ChildPagesViewModel.kt", m1610i = {2, 3}, m1611l = {PDFACompliance.e_PDFA5_2_3, PDFACompliance.e_PDFA5_2_7, 534, 538}, m1612m = "invokeSuspend", m1613n = {"visible", "visible"}, m1614nl = {PDFACompliance.e_PDFA5_2_6, PDFACompliance.e_PDFA5_2_8, 538, 542}, m1615s = {"I$0", "I$0"}, m1616v = 2)
    static final class C63163 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPagesNavigationState $navigationState;
        final /* synthetic */ boolean $openSidePanel;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63163(ChildPagesNavigationState childPagesNavigationState, boolean z, Continuation<? super C63163> continuation) {
            super(2, continuation);
            this.$navigationState = childPagesNavigationState;
            this.$openSidePanel = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63163(this.$navigationState, this.$openSidePanel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63163) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        
            if (r11.collect(new com.myscript.nebo.editing.ChildPagesViewModel.C63163.AnonymousClass3<>(), r10) == r0) goto L36;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            ?? r1;
            DiscoverabilityManager discoverabilityManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData = ChildPagesViewModel.this._childPages;
                this.L$0 = mutableLiveData;
                this.label = 1;
                obj = BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$navigationState, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    ?? r6 = (this.$openSidePanel || !ChildPagesViewModel.this.isChildPagesCompatible()) ? 0 : 1;
                    ChildPagesViewModel.this._isChildPagesPanelVisible.setValue(new ChildPagesPanelVisibilityState(r6, false));
                    this.I$0 = r6;
                    this.label = 3;
                    if (BuildersKt.withContext(ChildPagesViewModel.this.ioDispatcher, new AnonymousClass2(ChildPagesViewModel.this, null), this) != coroutine_suspended) {
                        r1 = r6;
                        discoverabilityManager = ChildPagesViewModel.this.discoverabilityManager;
                        if (discoverabilityManager != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    throw new KotlinNothingValueException();
                }
                int i2 = this.I$0;
                ResultKt.throwOnFailure(obj);
                r1 = i2;
                discoverabilityManager = ChildPagesViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null || (r11 = discoverabilityManager.getNextDiscovery()) == null) {
                    return Unit.INSTANCE;
                }
                final ChildPagesViewModel childPagesViewModel = ChildPagesViewModel.this;
                this.I$0 = r1;
                this.label = 4;
            }
            mutableLiveData.setValue(obj);
            ChildPagesViewModel.this._childPagesNavigationState.setValue(this.$navigationState);
            this.L$0 = null;
            this.label = 2;
            if (DelayKt.delay(200L, this) != coroutine_suspended) {
                if (this.$openSidePanel) {
                }
                ChildPagesViewModel.this._isChildPagesPanelVisible.setValue(new ChildPagesPanelVisibilityState(r6, false));
                this.I$0 = r6;
                this.label = 3;
                if (BuildersKt.withContext(ChildPagesViewModel.this.ioDispatcher, new AnonymousClass2(ChildPagesViewModel.this, null), this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/editing/ChildPage;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA5_2_4}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImmutableList<? extends ChildPage>>, Object> {
            final /* synthetic */ ChildPagesNavigationState $navigationState;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPagesNavigationState childPagesNavigationState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$navigationState = childPagesNavigationState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$navigationState, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ImmutableList<? extends ChildPage>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super ImmutableList<ChildPage>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ImmutableList<ChildPage>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = ChildPagesViewModel.computeChildPages$default(this.this$0, this.$navigationState.getSelectedPageId(), null, this, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ExtensionsKt.toImmutableList((Iterable) obj);
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$bindPaginatedContainer$3$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ChildPagesViewModel childPagesViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.this$0.thumbnailGenerator;
                    if (iChildPageThumbnailGenerator == null) {
                        return null;
                    }
                    if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                        throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                    }
                    ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                    if (childPageThumbnailGeneratorNewRef == null) {
                        return null;
                    }
                    ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                    try {
                        childPageThumbnailGenerator.cleanOldThumbnails();
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                        return unit;
                    } finally {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final void unbindPaginatedContainer() {
        if (this.paginatedContainer == null) {
            return;
        }
        stopThumbnailsAutoUpdate();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63491(null), 3, null);
        IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.thumbnailGenerator;
        if (iChildPageThumbnailGenerator != null) {
            this.thumbnailGenerator = null;
            iChildPageThumbnailGenerator.removeListener(this.thumbnailListener);
            iChildPageThumbnailGenerator.stop();
            iChildPageThumbnailGenerator.delete();
        }
        IPaginatedContainer iPaginatedContainer = this.paginatedContainer;
        if (iPaginatedContainer != null) {
            this.paginatedContainer = null;
            iPaginatedContainer.removeListener(this.childPageListener);
            iPaginatedContainer.delete();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$unbindPaginatedContainer$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$unbindPaginatedContainer$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63491(Continuation<? super C63491> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63491(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChildPagesViewModel.this._childPages.setValue(ExtensionsKt.persistentListOf());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void startThumbnailsAutoUpdate() {
        if (Duration.m15883isPositiveimpl(this.thumbnailUpdatePeriod) && this.thumbnailAutoUpdateTask == null) {
            this.thumbnailAutoUpdateTask = this.thumbnailUpdateScheduler.scheduleWithFixedDelay(new Runnable() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ChildPagesViewModel.startThumbnailsAutoUpdate$lambda$0(this.f$0);
                }
            }, 0L, Duration.m15867getInWholeMillisecondsimpl(this.thumbnailUpdatePeriod), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startThumbnailsAutoUpdate$lambda$0(ChildPagesViewModel childPagesViewModel) {
        Set set;
        ImmutableList<ChildPage> value;
        if (childPagesViewModel.thumbnailAutoUpdateTask == null) {
            return;
        }
        synchronized (childPagesViewModel) {
            set = CollectionsKt.toSet(childPagesViewModel.staleChildPageIds);
            childPagesViewModel.staleChildPageIds.clear();
        }
        if (set.isEmpty() || (value = childPagesViewModel._childPages.getValue()) == null) {
            return;
        }
        ImmutableList<ChildPage> immutableList = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
        Iterator<ChildPage> it = immutableList.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(childPagesViewModel), null, null, new ChildPagesViewModel$startThumbnailsAutoUpdate$1$1(childPagesViewModel, ExtensionsKt.toImmutableList(arrayList), null), 3, null);
                return;
            }
            ChildPage next = it.next();
            if (childPagesViewModel.thumbnailAutoUpdateTask == null) {
                return;
            }
            if (set.contains(next.getId())) {
                IChildPageThumbnailGenerator iChildPageThumbnailGenerator = childPagesViewModel.thumbnailGenerator;
                if (iChildPageThumbnailGenerator != null) {
                    if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                        throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                    }
                    ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                    if (childPageThumbnailGeneratorNewRef != null) {
                        ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                        try {
                            File thumbnailFile = ChildPagesViewModelKt.getThumbnailFile(childPageThumbnailGenerator, next.getId());
                            String absolutePath = thumbnailFile != null ? thumbnailFile.getAbsolutePath() : null;
                            AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                            str = absolutePath;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                AutoCloseableKt.closeFinally(childPageThumbnailGenerator, th);
                                throw th2;
                            }
                        }
                    }
                }
                next = ChildPage.copy$default(next, null, false, 0, 0, 0, 0, null, str, false, null, 895, null);
            }
            arrayList.add(next);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$cleanOldThumbnails$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$cleanOldThumbnails$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TypedValues.MotionType.TYPE_DRAW_PATH}, m1615s = {}, m1616v = 2)
    static final class C63201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63201(Continuation<? super C63201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$cleanOldThumbnails$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$cleanOldThumbnails$1$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
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
                    IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.this$0.thumbnailGenerator;
                    if (iChildPageThumbnailGenerator != null) {
                        if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                            throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                        }
                        ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                        if (childPageThumbnailGeneratorNewRef != null) {
                            ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                            try {
                                childPageThumbnailGenerator.cleanOldThumbnails();
                                Unit unit = Unit.INSTANCE;
                                AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                            } finally {
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(ChildPagesViewModel.this.ioDispatcher, new AnonymousClass1(ChildPagesViewModel.this, null), this) == coroutine_suspended) {
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

    public final void cleanOldThumbnails() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63201(null), 3, null);
    }

    private final void stopThumbnailsAutoUpdate() {
        ScheduledFuture<?> scheduledFuture = this.thumbnailAutoUpdateTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.thumbnailAutoUpdateTask = null;
    }

    public final List<ChildPageAction> getPageActions(ChildPage childPage) {
        AutoCloseable autoCloseableNewRef;
        List<ChildPageAction> listBuildChildPageActionItems;
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "getPageActions", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.getPageActions.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        IPaginatedContainer iPaginatedContainer = this.paginatedContainer;
        if (iPaginatedContainer != null) {
            if (iPaginatedContainer instanceof NotebookManager) {
                autoCloseableNewRef = NotebookManager.newRef((NotebookManager) iPaginatedContainer);
            } else {
                if (!(iPaginatedContainer instanceof PDFManager)) {
                    throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                }
                autoCloseableNewRef = PDFManager.newRef((PDFManager) iPaginatedContainer);
            }
            List<PageAction> list = null;
            if (autoCloseableNewRef != null) {
                AutoCloseable autoCloseable = autoCloseableNewRef;
                try {
                    List<PageAction> listPageActions = ((IPaginatedContainer) autoCloseable).pageActions(childPage.getId());
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    list = listPageActions;
                } finally {
                }
            }
            if (list != null && (listBuildChildPageActionItems = ChildPagesViewModelKt.buildChildPageActionItems(list)) != null) {
                return listBuildChildPageActionItems;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ void selectPage$default(ChildPagesViewModel childPagesViewModel, ChildPage childPage, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        childPagesViewModel.selectPage(childPage, z);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectPage$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$selectPage$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {626}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {631}, m1615s = {}, m1616v = 2)
    static final class C63432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        final /* synthetic */ boolean $userAction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63432(ChildPage childPage, boolean z, Continuation<? super C63432> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.$userAction = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63432(this.$childPage, this.$userAction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectPage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$selectPage$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            final /* synthetic */ boolean $userAction;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
                this.$userAction = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, this.$userAction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer == null) {
                    return null;
                }
                ChildPage childPage = this.$childPage;
                boolean z = this.$userAction;
                if (paginatedContainer instanceof NotebookManager) {
                    autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                } else {
                    if (!(paginatedContainer instanceof PDFManager)) {
                        throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                    }
                    autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                }
                if (autoCloseableNewRef == null) {
                    return null;
                }
                AutoCloseable autoCloseable = autoCloseableNewRef;
                try {
                    ((IPaginatedContainer) autoCloseable).selectPage(childPage.getId(), z);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return unit;
                } finally {
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoCloseable autoCloseableNewRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, this.$userAction, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            IPaginatedContainer paginatedContainer = ChildPagesViewModel.this.getPaginatedContainer();
            if (paginatedContainer != null) {
                ChildPage childPage = this.$childPage;
                ChildPagesViewModel childPagesViewModel = ChildPagesViewModel.this;
                boolean z = this.$userAction;
                if (paginatedContainer instanceof NotebookManager) {
                    autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                } else {
                    if (!(paginatedContainer instanceof PDFManager)) {
                        throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                    }
                    autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                }
                if (autoCloseableNewRef != null) {
                    AutoCloseable autoCloseable = autoCloseableNewRef;
                    try {
                        if (Intrinsics.areEqual(((IPaginatedContainer) autoCloseable).selectedPage(), childPage.getId())) {
                            MutableLiveData mutableLiveData = childPagesViewModel._childPagesNavigationState;
                            ChildPagesNavigationState childPagesNavigationState = (ChildPagesNavigationState) childPagesViewModel._childPagesNavigationState.getValue();
                            mutableLiveData.setValue(childPagesNavigationState != null ? ChildPagesNavigationState.copy$default(childPagesNavigationState, null, 0, z, 0, false, false, 59, null) : null);
                        }
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                    } finally {
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void selectPage(ChildPage childPage, boolean userAction) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "selectPage", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.selectPage.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63432(childPage, userAction, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectPageAt$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63441 extends FunctionReferenceImpl implements Function0<String> {
        C63441(Object obj) {
            super(0, obj, Integer.TYPE, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return String.valueOf(((Number) this.receiver).intValue());
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectPageAt$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$selectPageAt$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {643}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {651}, m1615s = {}, m1616v = 2)
    static final class C63452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNumber;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63452(int i, Continuation<? super C63452> continuation) {
            super(2, continuation);
            this.$pageNumber = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63452(this.$pageNumber, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectPageAt$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$selectPageAt$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $pageNumber;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$pageNumber = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$pageNumber, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    int i = this.$pageNumber;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            String strPageAt = iPaginatedContainer.pageAt(i);
                            if (ChildPagesViewModelKt.isValidChildPageId(iPaginatedContainer, strPageAt)) {
                                iPaginatedContainer.selectPage(strPageAt, true);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$pageNumber, null), this) == coroutine_suspended) {
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

    public final void selectPageAt(int pageNumber) {
        TechnicalLoggerExt.logAction(this.logger, TAG, "selectPageAt", new C63441(Integer.valueOf(pageNumber)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63452(pageNumber, null), 3, null);
    }

    public static /* synthetic */ void insertPage$default(ChildPagesViewModel childPagesViewModel, ChildPage childPage, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        childPagesViewModel.insertPage(childPage, z);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$insertPage$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$insertPage$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {657}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {665}, m1615s = {}, m1616v = 2)
    static final class C63332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $afterPage;
        final /* synthetic */ ChildPage $childPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63332(ChildPage childPage, boolean z, Continuation<? super C63332> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.$afterPage = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63332(this.$childPage, this.$afterPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$insertPage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$insertPage$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $afterPage;
            final /* synthetic */ ChildPage $childPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
                this.$afterPage = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, this.$afterPage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage = this.$childPage;
                    boolean z = this.$afterPage;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            String strCreatePage = iPaginatedContainer.createPage(childPage.getId(), z);
                            if (ChildPagesViewModelKt.isValidChildPageId(iPaginatedContainer, strCreatePage)) {
                                iPaginatedContainer.selectPage(strCreatePage, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, this.$afterPage, null), this) == coroutine_suspended) {
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

    public final void insertPage(ChildPage childPage, boolean afterPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "insertPageAfter", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.insertPage.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63332(childPage, afterPage, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$duplicatePage$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$duplicatePage$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {671}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {679}, m1615s = {}, m1616v = 2)
    static final class C63292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63292(ChildPage childPage, Continuation<? super C63292> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63292(this.$childPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$duplicatePage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$duplicatePage$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage = this.$childPage;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            String strDuplicatePage = iPaginatedContainer.duplicatePage(childPage.getId(), true);
                            if (ChildPagesViewModelKt.isValidChildPageId(iPaginatedContainer, strDuplicatePage)) {
                                iPaginatedContainer.selectPage(strDuplicatePage, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, null), this) == coroutine_suspended) {
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

    public final void duplicatePage(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "duplicateChildPage", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.duplicatePage.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63292(childPage, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$deletePage$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$deletePage$2", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {686}, m1612m = "invokeSuspend", m1613n = {"pages"}, m1614nl = {TypedValues.TransitionType.TYPE_TRANSITION_FLAGS}, m1615s = {"L$0"}, m1616v = 2)
    static final class C63232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63232(ChildPage childPage, Continuation<? super C63232> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63232(this.$childPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ImmutableList immutableList = (ImmutableList) ChildPagesViewModel.this._childPages.getValue();
                if (immutableList == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(immutableList);
                this.label = 1;
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(immutableList, this.$childPage, ChildPagesViewModel.this, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$deletePage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$deletePage$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            final /* synthetic */ ImmutableList<ChildPage> $pages;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ImmutableList<ChildPage> immutableList, ChildPage childPage, ChildPagesViewModel childPagesViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$pages = immutableList;
                this.$childPage = childPage;
                this.this$0 = childPagesViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$pages, this.$childPage, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ChildPage next;
                ChildPage childPage;
                AutoCloseable autoCloseableNewRef;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ImmutableList<ChildPage> immutableList = this.$pages;
                ChildPage childPage2 = this.$childPage;
                Iterator<ChildPage> it = immutableList.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(it.next().getId(), childPage2.getId())) {
                        break;
                    }
                    i++;
                }
                Iterator<ChildPage> it2 = this.$pages.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (next.isActive()) {
                        break;
                    }
                }
                ChildPage childPage3 = next;
                if (Intrinsics.areEqual(childPage3 != null ? childPage3.getId() : null, this.$childPage.getId())) {
                    ImmutableList<ChildPage> immutableList2 = this.$pages;
                    ImmutableList<ChildPage> immutableList3 = immutableList2;
                    int i2 = i + 1;
                    childPage = (i2 < 0 || i2 >= immutableList3.size()) ? (ChildPage) CollectionsKt.getOrNull(immutableList2, i - 1) : immutableList3.get(i2);
                } else {
                    childPage = childPage3;
                }
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage4 = this.$childPage;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            iPaginatedContainer.removePage(childPage4.getId());
                            if (childPage != null) {
                                childPage3 = childPage;
                            }
                            if (childPage3 != null) {
                                iPaginatedContainer.selectPage(childPage3.getId(), false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void deletePage(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "deletePage", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.deletePage.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63232(childPage, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$deletePages$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$deletePages$2", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {717}, m1612m = "invokeSuspend", m1613n = {"pages"}, m1614nl = {PDFACompliance.e_PDFA7_3_9}, m1615s = {"L$0"}, m1616v = 2)
    static final class C63242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ChildPage> $childPages;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63242(List<ChildPage> list, Continuation<? super C63242> continuation) {
            super(2, continuation);
            this.$childPages = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63242(this.$childPages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ImmutableList immutableList = (ImmutableList) ChildPagesViewModel.this._childPages.getValue();
                ImmutableList immutableList2 = immutableList;
                if (immutableList2 != null && !immutableList2.isEmpty()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(immutableList);
                    this.label = 1;
                    if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(immutableList, this.$childPages, ChildPagesViewModel.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$deletePages$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$deletePages$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<ChildPage> $childPages;
            final /* synthetic */ ImmutableList<ChildPage> $pages;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ImmutableList<ChildPage> immutableList, List<ChildPage> list, ChildPagesViewModel childPagesViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$pages = immutableList;
                this.$childPages = list;
                this.this$0 = childPagesViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$pages, this.$childPages, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i;
                ChildPage next;
                AutoCloseable autoCloseableNewRef;
                ChildPage next2;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ImmutableList<ChildPage> immutableList = this.$pages;
                List<ChildPage> list = this.$childPages;
                Iterator<ChildPage> it = immutableList.iterator();
                int i2 = 0;
                while (true) {
                    i = -1;
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(it.next().getId(), ((ChildPage) CollectionsKt.first((List) list)).getId())) {
                        break;
                    }
                    i2++;
                }
                ImmutableList<ChildPage> immutableList2 = this.$pages;
                List<ChildPage> list2 = this.$childPages;
                Iterator<ChildPage> it2 = immutableList2.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(it2.next().getId(), ((ChildPage) CollectionsKt.last((List) list2)).getId())) {
                        i = i3;
                        break;
                    }
                    i3++;
                }
                Iterator<ChildPage> it3 = this.$pages.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    if (next.isActive()) {
                        break;
                    }
                }
                ChildPage childPage = next;
                if (CollectionsKt.contains(this.$childPages, childPage)) {
                    ImmutableList<ChildPage> immutableList3 = this.$pages;
                    ImmutableList<ChildPage> immutableList4 = immutableList3;
                    int i4 = i + 1;
                    childPage = (i4 < 0 || i4 >= immutableList4.size()) ? (ChildPage) CollectionsKt.getOrNull(immutableList3, i2 - 1) : immutableList4.get(i4);
                }
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    List<ChildPage> list3 = this.$childPages;
                    ImmutableList<ChildPage> immutableList5 = this.$pages;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            List<ChildPage> list4 = list3;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                            Iterator<T> it4 = list4.iterator();
                            while (it4.hasNext()) {
                                arrayList.add(((ChildPage) it4.next()).getId());
                            }
                            iPaginatedContainer.removePages(arrayList);
                            if (childPage == null) {
                                Iterator<ChildPage> it5 = immutableList5.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        next2 = null;
                                        break;
                                    }
                                    next2 = it5.next();
                                    if (!list3.contains(next2)) {
                                        break;
                                    }
                                }
                                childPage = next2;
                            }
                            if (childPage != null) {
                                iPaginatedContainer.selectPage(childPage.getId(), false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String deletePages$lambda$0(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChildPage) it.next()).getId());
        }
        return arrayList.toString();
    }

    public final void deletePages(final List<ChildPage> childPages) {
        Intrinsics.checkNotNullParameter(childPages, "childPages");
        TechnicalLoggerExt.logAction(this.logger, TAG, "deletePages", new Function0() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChildPagesViewModel.deletePages$lambda$0(childPages);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63242(childPages, null), 3, null);
    }

    public final void movePageUp(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "movePageUp", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.movePageUp.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        ImmutableList<ChildPage> value = getChildPages().getValue();
        if (value == null) {
            return;
        }
        Iterator<ChildPage> it = value.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), childPage.getId())) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i - 1;
        if (i2 < 0 || i2 >= value.size()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63382(childPage, value.get(i2), value, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageUp$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageUp$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {749}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {758}, m1615s = {}, m1616v = 2)
    static final class C63382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        final /* synthetic */ ImmutableList<ChildPage> $pages;
        final /* synthetic */ ChildPage $pivotPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63382(ChildPage childPage, ChildPage childPage2, ImmutableList<ChildPage> immutableList, Continuation<? super C63382> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.$pivotPage = childPage2;
            this.$pages = immutableList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63382(this.$childPage, this.$pivotPage, this.$pages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageUp$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageUp$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            final /* synthetic */ ImmutableList<ChildPage> $pages;
            final /* synthetic */ ChildPage $pivotPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, ChildPage childPage2, ImmutableList<ChildPage> immutableList, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
                this.$pivotPage = childPage2;
                this.$pages = immutableList;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, this.$pivotPage, this.$pages, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                ChildPage next;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage = this.$childPage;
                    ChildPage childPage2 = this.$pivotPage;
                    ImmutableList<ChildPage> immutableList = this.$pages;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            iPaginatedContainer.movePage(childPage.getId(), childPage2.getId(), false);
                            Iterator<ChildPage> it = immutableList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                if (next.isActive()) {
                                    break;
                                }
                            }
                            ChildPage childPage3 = next;
                            String id = childPage3 != null ? childPage3.getId() : null;
                            if (Intrinsics.areEqual(id, childPage.getId())) {
                                iPaginatedContainer.selectPage(id, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, this.$pivotPage, this.$pages, null), this) == coroutine_suspended) {
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

    public final void movePageDown(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "movePageDown", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.movePageDown.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        ImmutableList<ChildPage> value = getChildPages().getValue();
        if (value == null) {
            return;
        }
        Iterator<ChildPage> it = value.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), childPage.getId())) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        if (i2 < 0 || i2 >= value.size()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63362(childPage, value.get(i2), value, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageDown$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageDown$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {769}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {778}, m1615s = {}, m1616v = 2)
    static final class C63362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        final /* synthetic */ ImmutableList<ChildPage> $pages;
        final /* synthetic */ ChildPage $pivotPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63362(ChildPage childPage, ChildPage childPage2, ImmutableList<ChildPage> immutableList, Continuation<? super C63362> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.$pivotPage = childPage2;
            this.$pages = immutableList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63362(this.$childPage, this.$pivotPage, this.$pages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageDown$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageDown$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            final /* synthetic */ ImmutableList<ChildPage> $pages;
            final /* synthetic */ ChildPage $pivotPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, ChildPage childPage2, ImmutableList<ChildPage> immutableList, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
                this.$pivotPage = childPage2;
                this.$pages = immutableList;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, this.$pivotPage, this.$pages, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                ChildPage next;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage = this.$childPage;
                    ChildPage childPage2 = this.$pivotPage;
                    ImmutableList<ChildPage> immutableList = this.$pages;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            iPaginatedContainer.movePage(childPage.getId(), childPage2.getId(), true);
                            Iterator<ChildPage> it = immutableList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                if (next.isActive()) {
                                    break;
                                }
                            }
                            ChildPage childPage3 = next;
                            String id = childPage3 != null ? childPage3.getId() : null;
                            if (Intrinsics.areEqual(id, childPage.getId())) {
                                iPaginatedContainer.selectPage(id, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, this.$pivotPage, this.$pages, null), this) == coroutine_suspended) {
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
    public static final String movePageAt$lambda$0(ChildPage childPage, int i) {
        return "move " + childPage.getId() + " at position=" + i;
    }

    public final void movePageAt(final ChildPage childPage, final int toPosition) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "movePageAt", new Function0() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChildPagesViewModel.movePageAt$lambda$0(childPage, toPosition);
            }
        });
        ImmutableList<ChildPage> value = getChildPages().getValue();
        if (value == null) {
            return;
        }
        if (toPosition < 0 || toPosition > value.size()) {
            throw new IllegalArgumentException(("Target position is invalid " + toPosition + " (size: " + value.size() + ")").toString());
        }
        Iterator<ChildPage> it = value.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), childPage.getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i == toPosition) {
            return;
        }
        boolean z = toPosition == value.size();
        if (toPosition == value.size()) {
            toPosition--;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63343(childPage, value.get(toPosition), z, value, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageAt$3 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageAt$3", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {793}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {802}, m1615s = {}, m1616v = 2)
    static final class C63343 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $afterPivot;
        final /* synthetic */ ChildPage $childPage;
        final /* synthetic */ ImmutableList<ChildPage> $pages;
        final /* synthetic */ ChildPage $pivotPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63343(ChildPage childPage, ChildPage childPage2, boolean z, ImmutableList<ChildPage> immutableList, Continuation<? super C63343> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.$pivotPage = childPage2;
            this.$afterPivot = z;
            this.$pages = immutableList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63343(this.$childPage, this.$pivotPage, this.$afterPivot, this.$pages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63343) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$movePageAt$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$movePageAt$3$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $afterPivot;
            final /* synthetic */ ChildPage $childPage;
            final /* synthetic */ ImmutableList<ChildPage> $pages;
            final /* synthetic */ ChildPage $pivotPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ChildPagesViewModel childPagesViewModel, ChildPage childPage, ChildPage childPage2, boolean z, ImmutableList<ChildPage> immutableList, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
                this.$pivotPage = childPage2;
                this.$afterPivot = z;
                this.$pages = immutableList;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$childPage, this.$pivotPage, this.$afterPivot, this.$pages, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AutoCloseable autoCloseableNewRef;
                ChildPage next;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                if (paginatedContainer != null) {
                    ChildPage childPage = this.$childPage;
                    ChildPage childPage2 = this.$pivotPage;
                    boolean z = this.$afterPivot;
                    ImmutableList<ChildPage> immutableList = this.$pages;
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                            iPaginatedContainer.movePage(childPage.getId(), childPage2.getId(), z);
                            Iterator<ChildPage> it = immutableList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                if (next.isActive()) {
                                    break;
                                }
                            }
                            ChildPage childPage3 = next;
                            String id = childPage3 != null ? childPage3.getId() : null;
                            if (Intrinsics.areEqual(id, childPage.getId())) {
                                iPaginatedContainer.selectPage(id, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                        } finally {
                        }
                    }
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
                if (BuildersKt.withContext(ChildPagesViewModel.this.workDispatcher, new AnonymousClass1(ChildPagesViewModel.this, this.$childPage, this.$pivotPage, this.$afterPivot, this.$pages, null), this) == coroutine_suspended) {
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

    public final void requestThumbnail(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        TechnicalLoggerExt.logAction(this.logger, TAG, "requestThumbnail", new PropertyReference0Impl(childPage) { // from class: com.myscript.nebo.editing.ChildPagesViewModel.requestThumbnail.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ChildPage) this.receiver).getId();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63402(childPage, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$requestThumbnail$2 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$requestThumbnail$2", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {823}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {833}, m1615s = {}, m1616v = 2)
    static final class C63402 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        int label;
        final /* synthetic */ ChildPagesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63402(ChildPage childPage, ChildPagesViewModel childPagesViewModel, Continuation<? super C63402> continuation) {
            super(2, continuation);
            this.$childPage = childPage;
            this.this$0 = childPagesViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63402(this.$childPage, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63402) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                File file = null;
                if (this.$childPage.isCorrupted()) {
                    ImmutableList immutableList = (ImmutableList) this.this$0._childPages.getValue();
                    if (immutableList == null) {
                        return Unit.INSTANCE;
                    }
                    IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.this$0.thumbnailGenerator;
                    if (iChildPageThumbnailGenerator != null) {
                        ChildPage childPage = this.$childPage;
                        if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                            throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                        }
                        ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                        if (childPageThumbnailGeneratorNewRef != null) {
                            ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                            try {
                                File thumbnailFile = ChildPagesViewModelKt.getThumbnailFile(childPageThumbnailGenerator, childPage.getId());
                                AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                                file = thumbnailFile;
                            } finally {
                            }
                        }
                        if (file != null) {
                            ChildPagesViewModel childPagesViewModel = this.this$0;
                            ChildPage childPage2 = this.$childPage;
                            MutableLiveData mutableLiveData = childPagesViewModel._childPages;
                            ImmutableList immutableList2 = immutableList;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList2, 10));
                            Iterator<E> it = immutableList2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Intrinsics.areEqual(childPage2.getId(), ((ChildPage) it.next()).getId()) ? ChildPage.copy$default(childPage2, null, false, 0, 0, 0, 0, null, file.getAbsolutePath(), false, null, 895, null) : childPage2);
                            }
                            mutableLiveData.setValue(ExtensionsKt.toImmutableList(arrayList));
                        }
                    }
                } else {
                    this.label = 1;
                    if (BuildersKt.withContext(this.this$0.workDispatcher, new AnonymousClass3(this.this$0, this.$childPage, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$requestThumbnail$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$requestThumbnail$2$3", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChildPage $childPage;
            int label;
            final /* synthetic */ ChildPagesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(ChildPagesViewModel childPagesViewModel, ChildPage childPage, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = childPagesViewModel;
                this.$childPage = childPage;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$childPage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.this$0.thumbnailGenerator;
                        if (iChildPageThumbnailGenerator != null) {
                            ChildPage childPage = this.$childPage;
                            if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
                                throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
                            }
                            ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
                            if (childPageThumbnailGeneratorNewRef != null) {
                                ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
                                try {
                                    Boxing.boxBoolean(childPageThumbnailGenerator.generateThumbnail(childPage.getId(), false));
                                    AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
                                } finally {
                                }
                            }
                        }
                    } catch (RuntimeException unused) {
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        stopThumbnailsAutoUpdate();
        IChildPageThumbnailGenerator iChildPageThumbnailGenerator = this.thumbnailGenerator;
        if (iChildPageThumbnailGenerator != null) {
            this.thumbnailGenerator = null;
            iChildPageThumbnailGenerator.removeListener(this.thumbnailListener);
            iChildPageThumbnailGenerator.stop();
            iChildPageThumbnailGenerator.delete();
        }
        IPaginatedContainer iPaginatedContainer = this.paginatedContainer;
        if (iPaginatedContainer != null) {
            this.paginatedContainer = null;
            iPaginatedContainer.removeListener(this.childPageListener);
            iPaginatedContainer.delete();
        }
        super.onCleared();
    }

    public final void setBackgroundColor(PageKey pageKey, int color) {
        IPaginatedContainer iPaginatedContainer;
        AutoCloseable autoCloseableNewRef;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (!getCanConfigureBackground() || (iPaginatedContainer = this.paginatedContainer) == null) {
            return;
        }
        if (iPaginatedContainer instanceof NotebookManager) {
            autoCloseableNewRef = NotebookManager.newRef((NotebookManager) iPaginatedContainer);
        } else {
            if (!(iPaginatedContainer instanceof PDFManager)) {
                throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
            }
            autoCloseableNewRef = PDFManager.newRef((PDFManager) iPaginatedContainer);
        }
        if (autoCloseableNewRef != null) {
            AutoCloseable autoCloseable = autoCloseableNewRef;
            try {
                ((IPaginatedContainer) autoCloseable).setPageBackgroundColor(pageKey.uuid(), color);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(autoCloseable, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th2;
                }
            }
        }
    }

    public final void setBackgroundPattern(PageKey pageKey, BackgroundPattern pattern) {
        IPaginatedContainer iPaginatedContainer;
        AutoCloseable autoCloseableNewRef;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (!getCanConfigureBackground() || (iPaginatedContainer = this.paginatedContainer) == null) {
            return;
        }
        if (iPaginatedContainer instanceof NotebookManager) {
            autoCloseableNewRef = NotebookManager.newRef((NotebookManager) iPaginatedContainer);
        } else {
            if (!(iPaginatedContainer instanceof PDFManager)) {
                throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
            }
            autoCloseableNewRef = PDFManager.newRef((PDFManager) iPaginatedContainer);
        }
        if (autoCloseableNewRef != null) {
            AutoCloseable autoCloseable = autoCloseableNewRef;
            try {
                ((IPaginatedContainer) autoCloseable).setPageBackgroundPattern(pageKey.uuid(), pattern);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(autoCloseable, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th2;
                }
            }
        }
    }

    public final void togglePageSelection(ChildPage childPage) {
        ChildPage next;
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        if (this.selectedPageIds.isEmpty()) {
            toggleSelectionMode(true);
        }
        ImmutableList<ChildPage> value = this._childPages.getValue();
        if (value == null) {
            return;
        }
        Iterator<ChildPage> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(next.getId(), childPage.getId())) {
                    break;
                }
            }
        }
        ChildPage childPage2 = next;
        if (childPage2 == null) {
            return;
        }
        if (!this.selectedPageIds.add(childPage2.getId())) {
            this.selectedPageIds.remove(childPage2.getId());
        }
        if (Intrinsics.areEqual((Object) isSelectionMode().getValue(), (Object) true) && this.selectedPageIds.isEmpty()) {
            toggleSelectionMode(false);
            return;
        }
        if (Intrinsics.areEqual((Object) isSelectionMode().getValue(), (Object) false) && !this.selectedPageIds.isEmpty()) {
            toggleSelectionMode(true);
        }
        ImmutableList<ChildPage> value2 = this._childPages.getValue();
        if (value2 == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63471(value2, childPage, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$togglePageSelection$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$togglePageSelection$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChildPage $childPage;
        final /* synthetic */ ImmutableList<ChildPage> $pages;
        int label;

        /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$togglePageSelection$1$WhenMappings */
        /* JADX INFO: compiled from: ChildPagesViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SelectionState.values().length];
                try {
                    iArr[SelectionState.NOT_SELECTABLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SelectionState.UNSELECTED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SelectionState.SELECTED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63471(ImmutableList<ChildPage> immutableList, ChildPage childPage, Continuation<? super C63471> continuation) {
            super(2, continuation);
            this.$pages = immutableList;
            this.$childPage = childPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63471(this.$pages, this.$childPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SelectionState selectionState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = ChildPagesViewModel.this._childPages;
                ImmutableList<ChildPage> immutableList = this.$pages;
                ChildPage childPage = this.$childPage;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
                for (ChildPage childPageCopy$default : immutableList) {
                    if (Intrinsics.areEqual(childPageCopy$default.getId(), childPage.getId())) {
                        int i = WhenMappings.$EnumSwitchMapping$0[childPageCopy$default.getSelectionState().ordinal()];
                        if (i == 1 || i == 2) {
                            selectionState = SelectionState.SELECTED;
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            selectionState = SelectionState.UNSELECTED;
                        }
                        childPageCopy$default = ChildPage.copy$default(childPageCopy$default, null, false, 0, 0, 0, 0, null, null, false, selectionState, FrameMetricsAggregator.EVERY_DURATION, null);
                    }
                    arrayList.add(childPageCopy$default);
                }
                mutableLiveData.setValue(ExtensionsKt.toImmutableList(arrayList));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleSelectionMode(boolean activated) {
        if (Intrinsics.areEqual(isSelectionMode().getValue(), Boolean.valueOf(activated))) {
            return;
        }
        if (!activated) {
            this.selectedPageIds.clear();
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63481(activated, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$toggleSelectionMode$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$toggleSelectionMode$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $activated;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63481(boolean z, Continuation<? super C63481> continuation) {
            super(2, continuation);
            this.$activated = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63481(this.$activated, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ImmutableList immutableList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChildPagesViewModel.this._isSelectionMode.setValue(Boxing.boxBoolean(this.$activated));
                ImmutableList immutableList2 = (ImmutableList) ChildPagesViewModel.this._childPages.getValue();
                MutableLiveData mutableLiveData = ChildPagesViewModel.this._childPages;
                if (immutableList2 != null) {
                    ImmutableList immutableList3 = immutableList2;
                    ChildPagesViewModel childPagesViewModel = ChildPagesViewModel.this;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList3, 10));
                    Iterator<E> it = immutableList3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ChildPage.copy$default((ChildPage) it.next(), null, false, 0, 0, 0, 0, null, null, false, Intrinsics.areEqual(childPagesViewModel.isSelectionMode().getValue(), Boxing.boxBoolean(true)) ? SelectionState.UNSELECTED : SelectionState.NOT_SELECTABLE, FrameMetricsAggregator.EVERY_DURATION, null));
                    }
                    immutableList = ExtensionsKt.toImmutableList(arrayList);
                } else {
                    immutableList = null;
                }
                mutableLiveData.setValue(immutableList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void selectAllPages() {
        ImmutableList<ChildPage> value;
        if (Intrinsics.areEqual((Object) isSelectionMode().getValue(), (Object) false) || (value = this._childPages.getValue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63411(value, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$selectAllPages$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$selectAllPages$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImmutableList<ChildPage> $childPages;
        int label;
        final /* synthetic */ ChildPagesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63411(ImmutableList<ChildPage> immutableList, ChildPagesViewModel childPagesViewModel, Continuation<? super C63411> continuation) {
            super(2, continuation);
            this.$childPages = immutableList;
            this.this$0 = childPagesViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63411(this.$childPages, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImmutableList<ChildPage> immutableList = this.$childPages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
            Iterator<ChildPage> it = immutableList.iterator();
            while (it.hasNext()) {
                arrayList.add(ChildPage.copy$default(it.next(), null, false, 0, 0, 0, 0, null, null, false, SelectionState.SELECTED, FrameMetricsAggregator.EVERY_DURATION, null));
            }
            ChildPagesViewModel childPagesViewModel = this.this$0;
            Set set = childPagesViewModel.selectedPageIds;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((ChildPage) it2.next()).getId());
            }
            set.addAll(arrayList3);
            childPagesViewModel._childPages.setValue(ExtensionsKt.toImmutableList(arrayList2));
            return Unit.INSTANCE;
        }
    }

    public final void deleteSelectedPages() {
        ImmutableList<ChildPage> value;
        if (Intrinsics.areEqual((Object) isSelectionMode().getValue(), (Object) false) || (value = this._childPages.getValue()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ChildPage childPage : value) {
            if (childPage.getSelectionState() == SelectionState.SELECTED) {
                arrayList.add(childPage);
            }
        }
        deletePages(arrayList);
        toggleSelectionMode(false);
    }

    public final void deselectAllPages() {
        ImmutableList<ChildPage> value;
        if (Intrinsics.areEqual((Object) isSelectionMode().getValue(), (Object) false) || (value = this._childPages.getValue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63251(value, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$deselectAllPages$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$deselectAllPages$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImmutableList<ChildPage> $childPages;
        int label;
        final /* synthetic */ ChildPagesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63251(ImmutableList<ChildPage> immutableList, ChildPagesViewModel childPagesViewModel, Continuation<? super C63251> continuation) {
            super(2, continuation);
            this.$childPages = immutableList;
            this.this$0 = childPagesViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63251(this.$childPages, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImmutableList<ChildPage> immutableList = this.$childPages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
            Iterator<ChildPage> it = immutableList.iterator();
            while (it.hasNext()) {
                arrayList.add(ChildPage.copy$default(it.next(), null, false, 0, 0, 0, 0, null, null, false, SelectionState.UNSELECTED, FrameMetricsAggregator.EVERY_DURATION, null));
            }
            ImmutableList immutableList2 = ExtensionsKt.toImmutableList(arrayList);
            ChildPagesViewModel childPagesViewModel = this.this$0;
            childPagesViewModel.selectedPageIds.clear();
            childPagesViewModel._childPages.setValue(immutableList2);
            return Unit.INSTANCE;
        }
    }

    public final boolean areAllPagesSelected() {
        ImmutableList<ChildPage> value = this._childPages.getValue();
        if (value == null) {
            return false;
        }
        ImmutableList<ChildPage> immutableList = value;
        if ((immutableList instanceof Collection) && immutableList.isEmpty()) {
            return true;
        }
        Iterator<ChildPage> it = immutableList.iterator();
        while (it.hasNext()) {
            if (it.next().getSelectionState() != SelectionState.SELECTED) {
                return false;
            }
        }
        return true;
    }

    public final List<PageKey> selectedPagesKeys() {
        ImmutableList<ChildPage> value = this._childPages.getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((ChildPage) obj).getSelectionState() == SelectionState.SELECTED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(PageKey.createKeyFromUuid(((ChildPage) it.next()).getId()));
        }
        return arrayList3;
    }

    public final List<String> selectedPagesIds() {
        ImmutableList<ChildPage> value = this._childPages.getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((ChildPage) obj).getSelectionState() == SelectionState.SELECTED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ChildPage) it.next()).getId());
        }
        return arrayList3;
    }

    public final List<Integer> selectedPagesIndexes() {
        List<com.myscript.snt.dms.PageProperties> listPages;
        IPaginatedContainer iPaginatedContainer = this.paginatedContainer;
        ArrayList arrayList = null;
        if (iPaginatedContainer != null && (listPages = iPaginatedContainer.pages()) != null) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj : listPages) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Integer numValueOf = this.selectedPageIds.contains(((com.myscript.snt.dms.PageProperties) obj).getPageId()) ? Integer.valueOf(i) : null;
                if (numValueOf != null) {
                    arrayList2.add(numValueOf);
                }
                i = i2;
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$dismissCurrentTooltip$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$dismissCurrentTooltip$1", m1609f = "ChildPagesViewModel.kt", m1610i = {0, 0, 0, 0}, m1611l = {983}, m1612m = "invokeSuspend", m1613n = {"tooltip", "state", "$i$a$-let-ChildPagesViewModel$dismissCurrentTooltip$1$1", "$i$a$-let-ChildPagesViewModel$dismissCurrentTooltip$1$1$1"}, m1614nl = {984}, m1615s = {"L$0", "L$1", "I$0", "I$1"}, m1616v = 2)
    static final class C63271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        C63271(Continuation<? super C63271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DiscoverabilityManager discoverabilityManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TooltipUIState tooltipUIState = (TooltipUIState) ChildPagesViewModel.this._discoveryTooltip.getValue();
                if (tooltipUIState != null) {
                    ChildPagesViewModel childPagesViewModel = ChildPagesViewModel.this;
                    IDiscoverableFeature iDiscoverableFeatureFromTooltipState = EditingDiscoverableFeature.INSTANCE.fromTooltipState(tooltipUIState);
                    if (iDiscoverableFeatureFromTooltipState != null && (discoverabilityManager = childPagesViewModel.discoverabilityManager) != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(tooltipUIState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeatureFromTooltipState);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (discoverabilityManager.discover(iDiscoverableFeatureFromTooltipState, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
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

    public final void dismissCurrentTooltip() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63271(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$discover$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$discover$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {991}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {992}, m1615s = {}, m1616v = 2)
    static final class C63261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63261(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C63261> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChildPagesViewModel.this.new C63261(this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = ChildPagesViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.discover(this.$feature, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public final void discover(IDiscoverableFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C63261(feature, null), 2, null);
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPagesViewModel$Companion;", "", "<init>", "()V", "TAG", "", "CHILD_PAGES_PANEL_OPEN_KEY", "getCHILD_PAGES_PANEL_OPEN_KEY$annotations", "IdentityColorInversionPolicy", "Lcom/myscript/atk/core/IdentityColorInversionPolicy;", "confirmStructuralChange", "", TtmlNode.ANNOTATION_POSITION_BEFORE, "", "Lcom/myscript/nebo/editing/ChildPage;", TtmlNode.ANNOTATION_POSITION_AFTER, "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCHILD_PAGES_PANEL_OPEN_KEY$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean confirmStructuralChange(List<ChildPage> before, List<ChildPage> after) {
            Intrinsics.checkNotNullParameter(after, "after");
            if (before == null || before.size() != after.size()) {
                return true;
            }
            int size = before.size();
            for (int i = 0; i < size; i++) {
                if (!Intrinsics.areEqual(before.get(i).getId(), after.get(i).getId())) {
                    return true;
                }
            }
            return false;
        }

        public final ViewModelProvider.Factory getFactory() {
            return ChildPagesViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ChildPagesViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        DisplayMetrics displayMetrics = applicationRequireApplication.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        ThumbnailImageCreator thumbnailImageCreator = new ThumbnailImageCreator(displayMetrics, new File(applicationRequireApplication.getCacheDir(), "thumbnail_image_cache"));
        Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        TechnicalLogger technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) applicationRequireApplication).provideTechnicalLogger();
        UserProfileManager userProfileManagerProvideUserProfileManager = ((UserProfileManager.Provider) applicationRequireApplication).provideUserProfileManager();
        DiscoverabilityManager discoverabilityManagerProvideEditingDiscoverabilityManager = ((DiscoverabilityManager.Provider) applicationRequireApplication).provideEditingDiscoverabilityManager();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationRequireApplication);
        Intrinsics.checkNotNull(defaultSharedPreferences);
        return new ChildPagesViewModel(thumbnailImageCreator, userProfileManagerProvideUserProfileManager, discoverabilityManagerProvideEditingDiscoverabilityManager, defaultSharedPreferences, null, null, null, null, 0L, technicalLoggerProvideTechnicalLogger, 496, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(ChildPagesViewModel.class), new Function1() { // from class: com.myscript.nebo.editing.ChildPagesViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
