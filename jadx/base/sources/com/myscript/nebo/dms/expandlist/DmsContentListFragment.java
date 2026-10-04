package com.myscript.nebo.dms.expandlist;

import android.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.DragNotebookClipDataHelper;
import com.myscript.nebo.dms.DragPageClipDataHelper;
import com.myscript.nebo.dms.NotebookDragShadowBuilder;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.event.OnDMSSyncStateChangedEvent;
import com.myscript.nebo.dms.expandlist.DmsAdapter;
import com.myscript.nebo.dms.views.SearchBar;
import com.myscript.nebo.dms.views.SyncToolbar;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSSyncState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.squareup.otto.Subscribe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DmsContentListFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000ë\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005*\u0001R\b\u0007\u0018\u0000 Í\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004Ì\u0001Í\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J&\u0010X\u001a\u0004\u0018\u00010J2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u001a\u0010]\u001a\u00020U2\u0006\u0010^\u001a\u00020J2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010_\u001a\u00020U2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J\b\u0010b\u001a\u00020UH\u0016J\b\u0010c\u001a\u00020UH\u0016J\b\u0010d\u001a\u00020UH\u0016J\u0010\u0010e\u001a\u00020U2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010e\u001a\u00020U2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020UH\u0002J\b\u0010k\u001a\u00020UH\u0016J\u0010\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020nH\u0002J\u0016\u0010o\u001a\u00020U2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020r0qH\u0002J\u0010\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020uH\u0002J\u0016\u0010v\u001a\u00020U2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020x0qH\u0002J\u0006\u0010y\u001a\u00020UJ\u0012\u0010z\u001a\u00020U2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\b\u0010}\u001a\u00020UH\u0002J\u0010\u0010~\u001a\u00020U2\b\u0010\u007f\u001a\u0004\u0018\u00010|J\u0011\u0010\u0080\u0001\u001a\u00020U2\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020U2\u0007\u0010\u0082\u0001\u001a\u00020AH\u0016J\t\u0010\u0083\u0001\u001a\u00020UH\u0016J\u0013\u0010\u0084\u0001\u001a\u00020U2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u0087\u0001\u001a\u00020U2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0007J\u0012\u0010\u008a\u0001\u001a\u00020U2\u0007\u0010\u008b\u0001\u001a\u00020:H\u0002J\u001a\u0010\u008c\u0001\u001a\u00020:2\u0006\u0010^\u001a\u00020J2\u0007\u0010\u008d\u0001\u001a\u00020AH\u0016J\t\u0010\u008e\u0001\u001a\u00020UH\u0002J\u001d\u0010\u008f\u0001\u001a\u00020:2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001d\u0010\u0094\u0001\u001a\u00020:2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001d\u0010\u0095\u0001\u001a\u00020:2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010\u0098\u0001\u001a\u00020U2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020U2\u0007\u0010\u009a\u0001\u001a\u00020(H\u0016J\b\u00109\u001a\u00020:H\u0016J\t\u0010\u009e\u0001\u001a\u00020UH\u0002J\t\u0010\u009f\u0001\u001a\u00020UH\u0002J\u0012\u0010 \u0001\u001a\u00020U2\u0007\u0010\u008d\u0001\u001a\u00020AH\u0016J\u0012\u0010¡\u0001\u001a\u00020U2\u0007\u0010\u008d\u0001\u001a\u00020AH\u0016J\t\u0010¢\u0001\u001a\u00020:H\u0016J\b\u0010?\u001a\u00020:H\u0016J\u001c\u0010£\u0001\u001a\u00020:2\u0007\u0010¤\u0001\u001a\u0002042\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u001c\u0010§\u0001\u001a\u00020U2\u0007\u0010¤\u0001\u001a\u0002042\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0012\u0010¨\u0001\u001a\u00020U2\u0007\u0010©\u0001\u001a\u00020:H\u0016J\u001d\u0010ª\u0001\u001a\u00020U2\b\u0010«\u0001\u001a\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0002J\u001c\u0010®\u0001\u001a\u00020:2\u0007\u0010¯\u0001\u001a\u00020J2\b\u0010\u0088\u0001\u001a\u00030°\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00020U2\b\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0002J\u001d\u0010²\u0001\u001a\u00020:2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0003J\u0012\u0010µ\u0001\u001a\u00020U2\u0007\u0010¶\u0001\u001a\u00020:H\u0002J\u0012\u0010·\u0001\u001a\u00020U2\u0007\u0010¶\u0001\u001a\u00020:H\u0002J\u001f\u0010º\u0001\u001a\u00020:2\t\u0010»\u0001\u001a\u0004\u0018\u00010|2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010¾\u0001\u001a\u00020U2\u0007\u0010¿\u0001\u001a\u00020:H\u0002J\u0013\u0010À\u0001\u001a\u00020U2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010Á\u0001\u001a\u00020:2\b\u0010Â\u0001\u001a\u00030\u0097\u0001H\u0016J\u0012\u0010Ã\u0001\u001a\u00020U2\u0007\u0010Ä\u0001\u001a\u00020:H\u0002J\u0012\u0010Å\u0001\u001a\u00020U2\u0007\u0010Æ\u0001\u001a\u00020:H\u0002J\u001f\u0010Ç\u0001\u001a\u00020U2\u0014\u0010È\u0001\u001a\u000f\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020(0É\u0001H\u0002J\u0010\u0010Ê\u0001\u001a\u00020U2\u0007\u0010Ë\u0001\u001a\u00020:R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\u00020\u00128BX\u0083\u0084\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020MX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0004\n\u0002\u0010SR\u001a\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020|0q8F¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0016\u0010¸\u0001\u001a\u00020(8CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010*R\u0013\u0010¼\u0001\u001a\u00020(8G¢\u0006\u0007\u001a\u0005\b½\u0001\u0010*¨\u0006Î\u0001"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/dms/expandlist/DmsAdapter$Callback;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Lcom/myscript/android/utils/NestedFragment;", "Lcom/myscript/android/utils/SelectionMode$Callback;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "getLibraryRepository$annotations", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "libraryRepository$delegate", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "getAutoSyncTimerManager", "()Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "autoSyncTimerManager$delegate", "libraryViewModel", "Lcom/myscript/nebo/dms/core/LibraryViewModel;", "getLibraryViewModel", "()Lcom/myscript/nebo/dms/core/LibraryViewModel;", "libraryViewModel$delegate", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "dmsAdapter", "Lcom/myscript/nebo/dms/expandlist/DmsAdapter;", "searchBar", "Lcom/myscript/nebo/dms/views/SearchBar;", "syncToolbar", "Lcom/myscript/nebo/dms/views/SyncToolbar;", "dmsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "callback", "Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment$Callback;", "isEmptySelectionEnabled", "", "lastTouchPoint", "Landroid/graphics/PointF;", "isPageDragging", "isNotebookDragging", "isDragConfirmed", "draggedNotebook", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "hoveredCollectionKey", "Lcom/myscript/snt/core/CollectionKey;", "handler", "Landroid/os/Handler;", "currentHoveredCollectionKey", "expandCollectionRunnable", "Ljava/lang/Runnable;", "emptyState", "Landroid/view/View;", "emptySearch", "emptySearchText", "Landroid/widget/TextView;", "discoverabilityTooltip", "Landroidx/compose/ui/platform/ComposeView;", "syncButton", "onGlobalLayoutListener", "com/myscript/nebo/dms/expandlist/DmsContentListFragment$onGlobalLayoutListener$1", "Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment$onGlobalLayoutListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "updateTooltip", "tooltipUIState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "onStart", "onStop", "onDestroyView", "onAttach", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "onAttachInternal", "onDetach", "onSyncToolbarUpdate", "syncToolbarUIState", "Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncToolbarUIState;", "onNotebookSyncStatesUpdate", "notebookSyncUIStates", "", "Lcom/myscript/nebo/dms/core/LibraryViewModel$NotebookSyncUIState;", "onStateUpdate", "state", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "setupAdapter", "collectionModels", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "refresh", "selectNotebook", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "showDmsOutdatedAlert", "onNotebookOpenChange", "updatedNotebookKey", "openNotebookCollection", "onFolderClicked", AIQuizConstants.NOTEBOOK, "onRefresh", "onNetworkStatusUpdate", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "onDMSSyncStateChangedEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/myscript/nebo/dms/event/OnDMSSyncStateChangedEvent;", "updateRefreshingState", "byUser", "onFolderDrag", "folderModel", "startSelectionMode", "onCreateSelectionMode", "mode", "Lcom/myscript/android/utils/SelectionMode;", "menu", "Landroid/view/Menu;", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroySelectionMode", "onSelectionUpdated", "selectedItems", "selection", "getSelection", "()Ljava/util/List;", "selectAll", "clearSelection", "onSyncRequested", "onSyncCancelRequested", "doesCurrentNetworkProvideDownload", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "setCollectionDraggedOn", "x", "", "y", "handleDmsDragging", "v", "Landroid/view/DragEvent;", "setNotebookDraggedOn", "setPageDropped", "clipData", "Landroid/content/ClipData;", "setEmptyState", "enabled", "setEmptySearch", "collectionCount", "getCollectionCount", "isPageDroppable", "draggedNotebookKey", "notebookCount", "getNotebookCount", "setDragConfirmed", "confirmed", "onPrepareOptionsMenu", "onMenuItemClicked", "menuItem", "onSearchStateUpdate", "isSearchActive", "onSearchProcessingUpdate", "isSearchProcessing", "onSearchHitsUpdate", "hits", "", "setCurrentTooltipVisible", "visible", "Callback", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DmsContentListFragment extends Fragment implements DmsAdapter.Callback, SwipeRefreshLayout.OnRefreshListener, RecyclerView.OnItemTouchListener, NestedFragment, SelectionMode.Callback {
    public static final String TAG = "DmsContentListFragment";
    private Callback callback;
    private CollectionKey currentHoveredCollectionKey;
    private ComposeView discoverabilityTooltip;
    private RecyclerView dmsRecyclerView;
    private FolderModel draggedNotebook;
    private View emptySearch;
    private TextView emptySearchText;
    private View emptyState;
    private CollectionKey hoveredCollectionKey;
    private boolean isDragConfirmed;
    private boolean isEmptySelectionEnabled;
    private boolean isNotebookDragging;
    private boolean isPageDragging;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    private Navigator navigator;
    private NeboNetworkStateRepository networkStateRepository;
    private SearchBar searchBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView syncButton;
    private SyncToolbar syncToolbar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DmsContentListFragment.logger_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: libraryRepository$delegate, reason: from kotlin metadata */
    private final Lazy libraryRepository = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DmsContentListFragment.libraryRepository_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: autoSyncTimerManager$delegate, reason: from kotlin metadata */
    private final Lazy autoSyncTimerManager = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DmsContentListFragment.autoSyncTimerManager_delegate$lambda$0(this.f$0);
        }
    });
    private final DmsAdapter dmsAdapter = new DmsAdapter(this);
    private final PointF lastTouchPoint = new PointF();
    private Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable expandCollectionRunnable = new Runnable() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            DmsContentListFragment.expandCollectionRunnable$lambda$0(this.f$0);
        }
    };
    private final DmsContentListFragment$onGlobalLayoutListener$1 onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onGlobalLayoutListener$1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            DmsContentListFragment dmsContentListFragment = this.this$0;
            dmsContentListFragment.updateTooltip(dmsContentListFragment.getLibraryViewModel().getDiscoveryTooltip().getValue());
        }
    };

    @Deprecated(message = "Repository shouldn't be used directly from UI layer but through ViewModel")
    private static /* synthetic */ void getLibraryRepository$annotations() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.myscript.nebo.dms.expandlist.DmsContentListFragment$onGlobalLayoutListener$1] */
    public DmsContentListFragment() {
        final DmsContentListFragment dmsContentListFragment = this;
        final Function0 function0 = null;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(dmsContentListFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return dmsContentListFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? dmsContentListFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LibraryViewModel.Factory;
            }
        });
    }

    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0007H&J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH&¨\u0006\u001bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment$Callback;", "", "onNewFolderRequested", "", "onNewCollectionRequested", "onEditSelection", "selectedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "onSyncRequested", "folderModel", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "isAutoSyncEnabled", "", "isSidePanelOpen", "isCloudConnected", "isSyncToolbarEnabled", "getSearchLabel", "", "movePage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "newNotebookKey", "onFolderClicked", "notebookKey", "moveToTrash", "notebookKeys", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        String getSearchLabel();

        boolean isAutoSyncEnabled();

        boolean isCloudConnected();

        boolean isSidePanelOpen();

        default boolean isSyncToolbarEnabled() {
            return true;
        }

        void movePage(PageKey pageKey, NotebookKey newNotebookKey);

        void moveToTrash(List<? extends NotebookKey> notebookKeys);

        void onEditSelection(NotebookKey selectedNotebookKey);

        void onFolderClicked(NotebookKey notebookKey);

        void onNewCollectionRequested();

        void onNewFolderRequested();

        void onSyncRequested(FolderModel folderModel);

        /* JADX INFO: compiled from: DmsContentListFragment.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static boolean isSyncToolbarEnabled(Callback callback) {
                return Callback.super.isSyncToolbarEnabled();
            }
        }
    }

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(DmsContentListFragment dmsContentListFragment) {
        ComponentCallbacks2 application = dmsContentListFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    private final LibraryRepository getLibraryRepository() {
        return (LibraryRepository) this.libraryRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LibraryRepository libraryRepository_delegate$lambda$0(DmsContentListFragment dmsContentListFragment) {
        ComponentCallbacks2 application = dmsContentListFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return ((LibraryRepository.Provider) application).provideLibraryRepository();
    }

    private final IAutoSyncTimerManager getAutoSyncTimerManager() {
        return (IAutoSyncTimerManager) this.autoSyncTimerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAutoSyncTimerManager autoSyncTimerManager_delegate$lambda$0(DmsContentListFragment dmsContentListFragment) {
        ComponentCallbacks2 application = dmsContentListFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.IAutoSyncTimerManager.Provider");
        return ((IAutoSyncTimerManager.Provider) application).provideAutoSyncTimerManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        Boolean value = getLibraryViewModel().isSearchActive().getValue();
        return value != null ? value.booleanValue() : false ? C6208R.string.search_toolbar_title : C6208R.string.dms_notes_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return C6208R.menu.dms_menu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandCollectionRunnable$lambda$0(DmsContentListFragment dmsContentListFragment) {
        CollectionKey collectionKey = dmsContentListFragment.currentHoveredCollectionKey;
        if (collectionKey != null) {
            dmsContentListFragment.dmsAdapter.expandCollection(collectionKey);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        this.networkStateRepository = ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository();
        this.isEmptySelectionEnabled = false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Callback callback;
        Callback callback2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6208R.layout.dms_list_content, container, false);
        SyncToolbar syncToolbar = (SyncToolbar) viewInflate.findViewById(C6208R.id.sync_toolbar);
        Intrinsics.checkNotNull(syncToolbar);
        SyncToolbar syncToolbar2 = syncToolbar;
        Callback callback3 = this.callback;
        syncToolbar2.setVisibility((callback3 == null || callback3.isSyncToolbarEnabled()) && (callback = this.callback) != null && !callback.isCloudConnected() && (callback2 = this.callback) != null && !callback2.isAutoSyncEnabled() ? 0 : 8);
        this.syncToolbar = syncToolbar;
        this.searchBar = (SearchBar) viewInflate.findViewById(C6208R.id.search_bar);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6208R.id.dms_recycler_view);
        recyclerView.setAdapter(this.dmsAdapter);
        recyclerView.addOnItemTouchListener(this);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setChangeDuration(0L);
        }
        recyclerView.setOnDragListener(new View.OnDragListener() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return this.f$0.handleDmsDragging(view, dragEvent);
            }
        });
        this.dmsRecyclerView = recyclerView;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(C6208R.id.dms_list_content_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        int[] intArray = swipeRefreshLayout.getResources().getIntArray(C6208R.array.dms_cover_colors);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(intArray, intArray.length));
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.colorBackgroundFloating, typedValue, true);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(typedValue.data);
        this.swipeRefreshLayout = swipeRefreshLayout;
        View viewFindViewById = viewInflate.findViewById(C6208R.id.dms_list_no_notebooks);
        this.emptyState = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = viewInflate.findViewById(C6208R.id.dms_list_search_no_results);
        this.emptySearch = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.emptySearchText = (TextView) viewInflate.findViewById(C6208R.id.dms_list_search_no_results_text);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getLibraryViewModel().getState().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62621(this)));
        Callback callback = this.callback;
        if (callback == null || callback.isSyncToolbarEnabled()) {
            getLibraryViewModel().getSyncToolbarUIState().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62632(this)));
        }
        getLibraryViewModel().isSearchActive().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62643(this)));
        getLibraryViewModel().isSearchProcessing().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62654(this)));
        getLibraryViewModel().getSearchHits().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62665(this)));
        getLibraryViewModel().getNotebookSyncUIStates().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62676(this)));
        NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
        if (neboNetworkStateRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepository = null;
        }
        neboNetworkStateRepository.getNeboNetworkState().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62687(this)));
        View viewFindViewById = view.findViewById(C6208R.id.discoverability_tooltip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.discoverabilityTooltip = (ComposeView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(C6208R.id.view_dms_navigation_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.syncButton = (TextView) viewFindViewById2;
        getLibraryViewModel().getDiscoveryTooltip().observe(getViewLifecycleOwner(), new DmsContentListFragment$sam$androidx_lifecycle_Observer$0(new C62698(this)));
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$1 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62621 extends FunctionReferenceImpl implements Function1<LibraryViewModel.State, Unit> {
        C62621(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onStateUpdate", "onStateUpdate(Lcom/myscript/nebo/dms/core/LibraryViewModel$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LibraryViewModel.State state) {
            invoke2(state);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LibraryViewModel.State p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DmsContentListFragment) this.receiver).onStateUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$2 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62632 extends FunctionReferenceImpl implements Function1<LibraryViewModel.SyncToolbarUIState, Unit> {
        C62632(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onSyncToolbarUpdate", "onSyncToolbarUpdate(Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncToolbarUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LibraryViewModel.SyncToolbarUIState syncToolbarUIState) {
            invoke2(syncToolbarUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LibraryViewModel.SyncToolbarUIState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DmsContentListFragment) this.receiver).onSyncToolbarUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$3 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62643 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C62643(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onSearchStateUpdate", "onSearchStateUpdate(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((DmsContentListFragment) this.receiver).onSearchStateUpdate(z);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$4 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62654 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C62654(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onSearchProcessingUpdate", "onSearchProcessingUpdate(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((DmsContentListFragment) this.receiver).onSearchProcessingUpdate(z);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$5 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62665 extends FunctionReferenceImpl implements Function1<Map<NotebookKey, ? extends Integer>, Unit> {
        C62665(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onSearchHitsUpdate", "onSearchHitsUpdate(Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<NotebookKey, ? extends Integer> map) {
            invoke2((Map<NotebookKey, Integer>) map);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<NotebookKey, Integer> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DmsContentListFragment) this.receiver).onSearchHitsUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$6 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62676 extends FunctionReferenceImpl implements Function1<List<? extends LibraryViewModel.NotebookSyncUIState>, Unit> {
        C62676(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onNotebookSyncStatesUpdate", "onNotebookSyncStatesUpdate(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends LibraryViewModel.NotebookSyncUIState> list) {
            invoke2((List<LibraryViewModel.NotebookSyncUIState>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<LibraryViewModel.NotebookSyncUIState> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DmsContentListFragment) this.receiver).onNotebookSyncStatesUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$7 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62687 extends FunctionReferenceImpl implements Function1<NeboNetworkState, Unit> {
        C62687(Object obj) {
            super(1, obj, DmsContentListFragment.class, "onNetworkStatusUpdate", "onNetworkStatusUpdate(Lcom/myscript/nebo/common/network/NeboNetworkState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NeboNetworkState neboNetworkState) {
            invoke2(neboNetworkState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NeboNetworkState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DmsContentListFragment) this.receiver).onNetworkStatusUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$onViewCreated$8 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62698 extends FunctionReferenceImpl implements Function1<TooltipUIState, Unit> {
        C62698(Object obj) {
            super(1, obj, DmsContentListFragment.class, "updateTooltip", "updateTooltip(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TooltipUIState tooltipUIState) {
            invoke2(tooltipUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TooltipUIState tooltipUIState) {
            ((DmsContentListFragment) this.receiver).updateTooltip(tooltipUIState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public final void updateTooltip(com.myscript.nebo.discoverability.p024ui.TooltipUIState r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            java.lang.Object r3 = r1.getUserData()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            boolean r4 = r3 instanceof com.myscript.nebo.dms.discoverability.GridDiscoverableFeature.DiscoverableFeatureDestination
            if (r4 == 0) goto L14
            com.myscript.nebo.dms.discoverability.GridDiscoverableFeature$DiscoverableFeatureDestination r3 = (com.myscript.nebo.dms.discoverability.GridDiscoverableFeature.DiscoverableFeatureDestination) r3
            goto L15
        L14:
            r3 = r2
        L15:
            com.myscript.nebo.dms.discoverability.GridDiscoverableFeature$DiscoverableFeatureDestination r4 = com.myscript.nebo.dms.discoverability.GridDiscoverableFeature.DiscoverableFeatureDestination.DMS_LIST_FRAGMENT
            if (r3 != r4) goto L1b
            r5 = r1
            goto L1c
        L1b:
            r5 = r2
        L1c:
            com.myscript.nebo.dms.discoverability.GridDiscoverableFeature$Companion r3 = com.myscript.nebo.dms.discoverability.GridDiscoverableFeature.INSTANCE
            com.myscript.nebo.discoverability.IDiscoverableFeature r1 = r3.fromTooltipState(r1)
            boolean r1 = r1 instanceof com.myscript.nebo.dms.discoverability.GridDiscoverableFeature.SyncButtonFeature
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L5f
            android.widget.TextView r1 = r0.syncButton
            java.lang.String r6 = "syncButton"
            if (r1 != 0) goto L32
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r2
        L32:
            android.view.View r1 = (android.view.View) r1
            int[] r1 = com.myscript.android.utils.ViewExt.getLocationInWindow(r1)
            android.graphics.Rect r7 = new android.graphics.Rect
            r8 = r1[r3]
            r9 = r1[r4]
            android.widget.TextView r10 = r0.syncButton
            if (r10 != 0) goto L46
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r10 = r2
        L46:
            int r10 = r10.getWidth()
            int r10 = r10 + r8
            r1 = r1[r4]
            android.widget.TextView r11 = r0.syncButton
            if (r11 != 0) goto L55
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r11 = r2
        L55:
            int r6 = r11.getHeight()
            int r1 = r1 + r6
            r7.<init>(r8, r9, r10, r1)
            r1 = r7
            goto L60
        L5f:
            r1 = r2
        L60:
            com.myscript.android.utils.ComposeViewManager r6 = com.myscript.android.utils.ComposeViewManager.INSTANCE
            androidx.compose.ui.platform.ComposeView r7 = r0.discoverabilityTooltip
            if (r7 != 0) goto L6c
            java.lang.String r7 = "discoverabilityTooltip"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r2
        L6c:
            com.myscript.nebo.discoverability.ui.compose.TooltipComposableProviderImpl r8 = new com.myscript.nebo.discoverability.ui.compose.TooltipComposableProviderImpl
            if (r5 == 0) goto L96
            com.myscript.nebo.dms.expandlist.DmsContentListFragment$Callback r2 = r0.callback
            if (r2 == 0) goto L7c
            boolean r2 = r2.isSidePanelOpen()
            if (r2 != r4) goto L7c
            r11 = r4
            goto L7d
        L7c:
            r11 = r3
        L7d:
            r14 = 223(0xdf, float:3.12E-43)
            r15 = 0
            r2 = r6
            r6 = 0
            r3 = r7
            r7 = 0
            r4 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r16 = r3
            r3 = r2
            r2 = r16
            com.myscript.nebo.discoverability.ui.TooltipUIState r5 = com.myscript.nebo.discoverability.p024ui.TooltipUIState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r7 = r2
            r2 = r5
            goto L98
        L96:
            r3 = r6
            r4 = r8
        L98:
            com.myscript.nebo.dms.expandlist.DmsContentListFragment$updateTooltip$1 r5 = new com.myscript.nebo.dms.expandlist.DmsContentListFragment$updateTooltip$1
            com.myscript.nebo.dms.core.LibraryViewModel r6 = r0.getLibraryViewModel()
            r5.<init>(r6)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r4.<init>(r2, r1, r5)
            r8 = r4
            com.myscript.android.utils.ComposeViewManager$ComposableProvider r8 = (com.myscript.android.utils.ComposeViewManager.ComposableProvider) r8
            r3.setComposableContent(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.dms.expandlist.DmsContentListFragment.updateTooltip(com.myscript.nebo.discoverability.ui.TooltipUIState):void");
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.expandlist.DmsContentListFragment$updateTooltip$1 */
    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62731 extends FunctionReferenceImpl implements Function0<Unit> {
        C62731(Object obj) {
            super(0, obj, LibraryViewModel.class, "dismissCurrentTooltip", "dismissCurrentTooltip()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((LibraryViewModel) this.receiver).dismissCurrentTooltip();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainThreadBus.eventBus.register(this);
        if (getLibraryViewModel().isSearching() && this.dmsAdapter.getItemCount() == 0) {
            setEmptySearch(true);
        }
        updateRefreshingState(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        MainThreadBus.eventBus.unregister(this);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = getView();
        ViewTreeObserver viewTreeObserver = view != null ? view.getViewTreeObserver() : null;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
        this.syncToolbar = null;
        RecyclerView recyclerView = this.dmsRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.dmsRecyclerView = null;
        this.swipeRefreshLayout = null;
        this.emptySearch = null;
        this.emptyState = null;
        this.emptySearchText = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        onAttachInternal();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        onAttachInternal();
    }

    private final void onAttachInternal() {
        try {
            this.callback = (Callback) getParentFragment();
        } catch (ClassCastException unused) {
            Log.e(TAG, "Parent fragment should implement " + Callback.class.getSimpleName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.callback = null;
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSyncToolbarUpdate(LibraryViewModel.SyncToolbarUIState syncToolbarUIState) {
        SyncToolbar syncToolbar = this.syncToolbar;
        if (syncToolbar != null) {
            syncToolbar.update(syncToolbarUIState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNotebookSyncStatesUpdate(List<LibraryViewModel.NotebookSyncUIState> notebookSyncUIStates) {
        for (LibraryViewModel.NotebookSyncUIState notebookSyncUIState : notebookSyncUIStates) {
            this.dmsAdapter.setNotebookSyncProgress(notebookSyncUIState.getNotebookKey(), notebookSyncUIState.getAmountDone(), notebookSyncUIState.getTotalAmount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStateUpdate(LibraryViewModel.State state) {
        if (state instanceof LibraryViewModel.State.Loaded) {
            setupAdapter(((LibraryViewModel.State.Loaded) state).getFilteredCollections());
        }
    }

    private final void setupAdapter(List<CollectionModel> collectionModels) {
        boolean zIsSearching = getLibraryViewModel().isSearching();
        boolean zIsEmpty = collectionModels.isEmpty();
        boolean z = false;
        setEmptySearch(zIsEmpty && zIsSearching);
        if (zIsEmpty && !zIsSearching) {
            z = true;
        }
        setEmptyState(z);
        this.dmsAdapter.setParentList(collectionModels, true);
        Navigator navigator = getNavigator();
        if (navigator != null) {
            navigator.invalidateOptionsMenu();
        }
        selectNotebook(getLibraryViewModel().getOpenNotebookKey().getValue());
    }

    public final void refresh() {
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        getLibraryViewModel().refreshSyncState();
        if (getLibraryRepository().getDmsSyncState() == DMSSyncState.OUTDATED) {
            showDmsOutdatedAlert();
        }
    }

    private final void selectNotebook(NotebookKey notebookKey) {
        this.dmsAdapter.openNotebook(notebookKey);
        if (notebookKey != null) {
            openNotebookCollection(notebookKey);
        }
    }

    private final void showDmsOutdatedAlert() {
        getLibraryViewModel().setHasSeenOutdatedDialog(true);
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6208R.string.sync_header_paused).setMessage(C6208R.string.sync_dialog_message_outdated).setPositiveButton(C6208R.string.sync_dialog_positive_outdated, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DmsContentListFragment.showDmsOutdatedAlert$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6208R.string.sync_dialog_negative_outdated, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.DmsContentListFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDmsOutdatedAlert$lambda$0(DmsContentListFragment dmsContentListFragment, DialogInterface dialogInterface, int i) {
        PlatformUtils.openPlayStore(dmsContentListFragment.requireContext());
    }

    public final void onNotebookOpenChange(NotebookKey updatedNotebookKey) {
        selectNotebook(updatedNotebookKey);
    }

    private final void openNotebookCollection(NotebookKey notebookKey) {
        RecyclerView recyclerView;
        CollectionKey collectionKeyFromNotebookKey = getLibraryRepository().getCollectionKeyFromNotebookKey(notebookKey);
        int flatChildPosition = this.dmsAdapter.getFlatChildPosition(collectionKeyFromNotebookKey, notebookKey);
        if (flatChildPosition > 0 && (recyclerView = this.dmsRecyclerView) != null) {
            recyclerView.scrollToPosition(flatChildPosition);
        }
        this.dmsAdapter.expandCollection(collectionKeyFromNotebookKey);
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public void onFolderClicked(FolderModel notebook) {
        Intrinsics.checkNotNullParameter(notebook, "notebook");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onFolderClicked(notebook.getNotebookKey());
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNetworkStatusUpdate(NeboNetworkState networkState) {
        updateRefreshingState(false);
        this.dmsAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public final void onDMSSyncStateChangedEvent(OnDMSSyncStateChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        onSelectionUpdated(getSelection().size());
        updateRefreshingState(event.mUserAction);
    }

    private final void updateRefreshingState(boolean byUser) {
        if (this.swipeRefreshLayout == null) {
            return;
        }
        DMSSyncState dmsSyncState = getLibraryRepository().getDmsSyncState();
        Callback callback = this.callback;
        if (callback != null) {
            callback.isAutoSyncEnabled();
        }
        Callback callback2 = this.callback;
        boolean z = false;
        boolean zIsCloudConnected = callback2 != null ? callback2.isCloudConnected() : false;
        boolean z2 = DMSSyncState.SYNCING != dmsSyncState;
        boolean hasForwardCompatibilityIssue = getLibraryRepository().getHasForwardCompatibilityIssue();
        if (dmsSyncState == DMSSyncState.OUTDATED && !getLibraryViewModel().getHasSeenOutdatedDialog()) {
            showDmsOutdatedAlert();
        }
        boolean z3 = zIsCloudConnected && doesCurrentNetworkProvideDownload() && z2 && !getLibraryViewModel().isSearching() && !hasForwardCompatibilityIssue;
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(z3);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        if (swipeRefreshLayout2 != null) {
            if (dmsSyncState == DMSSyncState.REFRESHING && byUser) {
                z = true;
            }
            swipeRefreshLayout2.setRefreshing(z);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public boolean onFolderDrag(View view, FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(folderModel, "folderModel");
        if (getLibraryViewModel().isSearching() || getLibraryRepository().isCloudSyncOngoing()) {
            return false;
        }
        Point point = new Point((int) (this.lastTouchPoint.x - view.getX()), (int) (this.lastTouchPoint.y - view.getY()));
        this.draggedNotebook = folderModel;
        view.setTag(folderModel.getNotebookKey());
        return NotebookDragShadowBuilder.startDrag(view, DragNotebookClipDataHelper.getNotebookClipData(folderModel.getNotebookKey()), point);
    }

    private final void startSelectionMode() {
        this.isEmptySelectionEnabled = true;
        Navigator navigator = getNavigator();
        if (navigator != null) {
            navigator.startSelectionMode();
        }
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.isEmptySelectionEnabled = true;
        mode.getMenuInflater().inflate(C6208R.menu.notebook_selection_menu, menu);
        this.dmsAdapter.notifyDataSetChanged();
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        int size = getSelection().size();
        boolean zIsSearching = getLibraryViewModel().isSearching();
        boolean zIsCloudSyncOngoing = getLibraryRepository().isCloudSyncOngoing();
        FolderModel item = size == 1 ? this.dmsAdapter.getItem(getSelection().get(0)) : null;
        boolean zIsSupported = item != null ? item.isSupported() : false;
        MenuItem menuItemFindItem = menu.findItem(C6208R.id.notebook_edit_selection);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled((zIsSearching || zIsCloudSyncOngoing || !zIsSupported) ? false : true);
        }
        MenuItem menuItemFindItem2 = menu.findItem(C6208R.id.notebook_delete_selection);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled((size <= 0 || zIsSearching || zIsCloudSyncOngoing) ? false : true);
        }
        MenuItem menuItemFindItem3 = menu.findItem(C6208R.id.notebook_select_all);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(size < getNotebookCount());
        }
        MenuItem menuItemFindItem4 = menu.findItem(C6208R.id.notebook_unselect_all);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setEnabled(size > 0);
        }
        mode.setTitle(getResources().getQuantityString(C6208R.plurals.folder_selected_count, size, Integer.valueOf(size)));
        return false;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        Callback callback;
        Callback callback2;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(item, "item");
        List<NotebookKey> selection = getSelection();
        boolean z = selection.size() == 1;
        int itemId = item.getItemId();
        if (itemId == C6208R.id.notebook_edit_selection) {
            if (z && (callback2 = this.callback) != null) {
                callback2.onEditSelection(selection.get(0));
            }
        } else if (itemId == C6208R.id.notebook_delete_selection) {
            if (!selection.isEmpty() && (callback = this.callback) != null) {
                callback.moveToTrash(selection);
            }
        } else if (itemId == C6208R.id.notebook_select_all) {
            selectAll();
        } else if (itemId == C6208R.id.notebook_unselect_all) {
            clearSelection();
        }
        return false;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.isEmptySelectionEnabled = false;
        clearSelection();
        this.dmsAdapter.notifyDataSetChanged();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public void onSelectionUpdated(int selectedItems) {
        Navigator navigator = getNavigator();
        if (navigator == null) {
            return;
        }
        boolean zHasSelectionMode = navigator.hasSelectionMode();
        if (selectedItems > 0 && !zHasSelectionMode) {
            navigator.startSelectionMode();
        } else if (selectedItems == 0 && zHasSelectionMode) {
            navigator.stopSelectionMode();
        } else {
            this.isEmptySelectionEnabled = false;
            navigator.invalidateSelectionMode();
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    /* JADX INFO: renamed from: isEmptySelectionEnabled, reason: from getter */
    public boolean getIsEmptySelectionEnabled() {
        return this.isEmptySelectionEnabled;
    }

    public final List<NotebookKey> getSelection() {
        List<NotebookKey> selection = this.dmsAdapter.getSelection();
        Intrinsics.checkNotNullExpressionValue(selection, "getSelection(...)");
        return selection;
    }

    private final void selectAll() {
        this.dmsAdapter.selectAll();
    }

    private final void clearSelection() {
        this.dmsAdapter.clearSelection();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public void onSyncRequested(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "folderModel");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSyncRequested(folderModel);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public void onSyncCancelRequested(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "folderModel");
        getAutoSyncTimerManager().cancelSync(folderModel.getNotebookKey());
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    public boolean doesCurrentNetworkProvideDownload() {
        NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
        if (neboNetworkStateRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepository = null;
        }
        NeboNetworkState value = neboNetworkStateRepository.getNeboNetworkState().getValue();
        return value != null && value.isDataTransferAllowed();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsAdapter.Callback
    /* JADX INFO: renamed from: isDragConfirmed, reason: from getter */
    public boolean getIsDragConfirmed() {
        return this.isDragConfirmed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        this.lastTouchPoint.set(e.getX(), e.getY());
        return false;
    }

    private final void setCollectionDraggedOn(float x, float y) {
        RecyclerView recyclerView;
        NotebookItemViewHolder notebookItemViewHolder;
        FolderModel notebook;
        CollectionKey collectionKeyFromNotebookKey;
        if (y >= 0.0f && (recyclerView = this.dmsRecyclerView) != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            float fMmToPx = ScreenUtils.mmToPx(getContext(), 10.0f);
            boolean z = y < ((float) recyclerView.getTop()) + fMmToPx;
            boolean z2 = y > ((float) recyclerView.getBottom()) - fMmToPx;
            if (z) {
                linearLayoutManager.scrollToPosition((int) Math.max(linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            } else if (z2) {
                double dFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1;
                RecyclerView recyclerView2 = this.dmsRecyclerView;
                Intrinsics.checkNotNull(recyclerView2);
                Intrinsics.checkNotNull(recyclerView2.getAdapter());
                linearLayoutManager.scrollToPosition((int) Math.min(dFindLastCompletelyVisibleItemPosition, r2.getItemCount() - 1));
            }
            this.hoveredCollectionKey = null;
            int childCount = recyclerView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i);
                boolean z3 = ((float) childAt.getTop()) < y && ((float) childAt.getBottom()) > y && ((float) childAt.getLeft()) < x && ((float) childAt.getRight()) > x;
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                if (childViewHolder instanceof CollectionItemViewHolder) {
                    CollectionModel collection = ((CollectionItemViewHolder) childViewHolder).getCollection();
                    if (z3 && collection != null) {
                        if (!Intrinsics.areEqual(collection.getCollectionKey(), this.currentHoveredCollectionKey)) {
                            this.currentHoveredCollectionKey = null;
                            this.handler.removeCallbacks(this.expandCollectionRunnable);
                            if (!collection.getIsExpanded()) {
                                this.currentHoveredCollectionKey = collection.getCollectionKey();
                                this.handler.postDelayed(this.expandCollectionRunnable, 500L);
                            }
                        }
                        LibraryRepository libraryRepository = getLibraryRepository();
                        FolderModel folderModel = this.draggedNotebook;
                        if (!Intrinsics.areEqual(collection.getCollectionKey(), libraryRepository.getCollectionKeyFromNotebookKey(folderModel != null ? folderModel.getNotebookKey() : null))) {
                            this.hoveredCollectionKey = collection.getCollectionKey();
                            break;
                        }
                    }
                    i++;
                } else {
                    if ((childViewHolder instanceof NotebookItemViewHolder) && z3) {
                        this.currentHoveredCollectionKey = null;
                        this.handler.removeCallbacks(this.expandCollectionRunnable);
                        CollectionKey collectionKeyFromNotebookKey2 = getLibraryRepository().getCollectionKeyFromNotebookKey(((NotebookItemViewHolder) childViewHolder).getNotebook().getNotebookKey());
                        LibraryRepository libraryRepository2 = getLibraryRepository();
                        FolderModel folderModel2 = this.draggedNotebook;
                        if (!Intrinsics.areEqual(collectionKeyFromNotebookKey2, libraryRepository2.getCollectionKeyFromNotebookKey(folderModel2 != null ? folderModel2.getNotebookKey() : null))) {
                            this.hoveredCollectionKey = collectionKeyFromNotebookKey2;
                            break;
                        }
                    }
                    i++;
                }
            }
            int childCount2 = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(i2));
                if (childViewHolder2 instanceof CollectionItemViewHolder) {
                    CollectionItemViewHolder collectionItemViewHolder = (CollectionItemViewHolder) childViewHolder2;
                    CollectionModel collection2 = collectionItemViewHolder.getCollection();
                    if (collection2 != null) {
                        collectionItemViewHolder.setDraggedOn(Intrinsics.areEqual(this.hoveredCollectionKey, collection2.getCollectionKey()));
                    }
                } else if ((childViewHolder2 instanceof NotebookItemViewHolder) && (notebook = (notebookItemViewHolder = (NotebookItemViewHolder) childViewHolder2).getNotebook()) != null && (collectionKeyFromNotebookKey = getLibraryRepository().getCollectionKeyFromNotebookKey(notebook.getNotebookKey())) != null) {
                    notebookItemViewHolder.setNotebookDraggedOn(Intrinsics.areEqual(this.hoveredCollectionKey, collectionKeyFromNotebookKey));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleDmsDragging(View v, DragEvent event) {
        FolderModel folderModel;
        CollectionKey collectionKey;
        switch (event.getAction()) {
            case 1:
                ClipDescription clipDescription = event.getClipDescription();
                this.isPageDragging = clipDescription != null ? clipDescription.hasMimeType(DragPageClipDataHelper.DRAG_PAGE_MIME) : false;
                this.isNotebookDragging = clipDescription != null ? clipDescription.hasMimeType(DragNotebookClipDataHelper.DRAG_NOTEBOOK_MIME) : false;
                if (!this.isPageDragging) {
                    TechnicalLogger logger = getLogger();
                    FolderModel folderModel2 = this.draggedNotebook;
                    logger.logTrace("[DmsContentListFragment] Notebook drag started " + (folderModel2 != null ? folderModel2.getNotebookKey() : null));
                }
                return this.isPageDragging || this.isNotebookDragging;
            case 2:
                if (this.isPageDragging) {
                    setNotebookDraggedOn(event.getY());
                    return true;
                }
                if (!this.isNotebookDragging) {
                    return false;
                }
                float fDpToPx = ScreenUtils.dpToPx(getContext(), 48.0f);
                int[] iArr = new int[2];
                RecyclerView recyclerView = this.dmsRecyclerView;
                if (recyclerView != null) {
                    recyclerView.getLocationInWindow(iArr);
                }
                if (Math.abs((event.getY() - this.lastTouchPoint.y) - iArr[1]) > fDpToPx || Math.abs((event.getX() - this.lastTouchPoint.x) - iArr[0]) > fDpToPx) {
                    setDragConfirmed(true);
                }
                setCollectionDraggedOn(event.getX(), event.getY());
                return true;
            case 3:
                if (this.isPageDragging) {
                    ClipData clipData = event.getClipData();
                    Intrinsics.checkNotNullExpressionValue(clipData, "getClipData(...)");
                    if (setPageDropped(clipData, event.getY()) && this.callback != null) {
                        return true;
                    }
                } else {
                    if (!this.isNotebookDragging || (folderModel = this.draggedNotebook) == null || (collectionKey = this.hoveredCollectionKey) == null) {
                        return false;
                    }
                    getLogger().logTrace("[DmsContentListFragment] Folder drag dropped " + folderModel.getNotebookKey());
                    clearSelection();
                    getLibraryViewModel().editFolder(folderModel.getNotebookKey(), collectionKey, folderModel.getName(), folderModel.getColor());
                    this.dmsAdapter.expandCollection(collectionKey);
                    return true;
                }
                return false;
            case 4:
                if (this.isNotebookDragging) {
                    TechnicalLogger logger2 = getLogger();
                    FolderModel folderModel3 = this.draggedNotebook;
                    logger2.logTrace("[DmsContentListFragment] Notebook drag ended " + (folderModel3 != null ? folderModel3.getNotebookKey() : null));
                    RecyclerView recyclerView2 = this.dmsRecyclerView;
                    if (recyclerView2 == null) {
                        return false;
                    }
                    int childCount = recyclerView2.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        RecyclerView.ViewHolder childViewHolder = recyclerView2.getChildViewHolder(recyclerView2.getChildAt(i));
                        if (childViewHolder instanceof CollectionItemViewHolder) {
                            ((CollectionItemViewHolder) childViewHolder).setDraggedOn(false);
                        } else if (childViewHolder instanceof NotebookItemViewHolder) {
                            NotebookItemViewHolder notebookItemViewHolder = (NotebookItemViewHolder) childViewHolder;
                            notebookItemViewHolder.setNotebookDraggedOn(false);
                            if (Intrinsics.areEqual(notebookItemViewHolder.getNotebook(), this.draggedNotebook)) {
                                notebookItemViewHolder.onDragStopped();
                            }
                        }
                    }
                    setDragConfirmed(false);
                    this.draggedNotebook = null;
                    this.hoveredCollectionKey = null;
                    this.isNotebookDragging = false;
                    return true;
                }
                if (this.isPageDragging) {
                    this.dmsAdapter.notifyDataSetChanged();
                    this.isPageDragging = false;
                }
                return false;
            case 5:
                if (this.isPageDragging) {
                    this.dmsAdapter.notifyDataSetChanged();
                } else {
                    TechnicalLogger logger3 = getLogger();
                    FolderModel folderModel4 = this.draggedNotebook;
                    logger3.logTrace("[DmsContentListFragment] Notebook drag entered " + (folderModel4 != null ? folderModel4.getNotebookKey() : null));
                }
                return true;
            case 6:
                if (this.isPageDragging) {
                    this.dmsAdapter.notifyDataSetChanged();
                    this.currentHoveredCollectionKey = null;
                    this.handler.removeCallbacks(this.expandCollectionRunnable);
                    setNotebookDraggedOn(-1.0f);
                    return true;
                }
                if (this.isNotebookDragging) {
                    TechnicalLogger logger4 = getLogger();
                    FolderModel folderModel5 = this.draggedNotebook;
                    logger4.logTrace("[DmsContentListFragment] Notebook drag exited " + (folderModel5 != null ? folderModel5.getNotebookKey() : null));
                    if (this.draggedNotebook != null) {
                        setDragConfirmed(true);
                    }
                    return true;
                }
            default:
                return false;
        }
    }

    private final void setNotebookDraggedOn(float y) {
        RecyclerView recyclerView;
        CollectionModel collection;
        if (y >= 0.0f && (recyclerView = this.dmsRecyclerView) != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            float fMmToPx = ScreenUtils.mmToPx(getContext(), 10.0f);
            boolean z = y < ((float) recyclerView.getTop()) + fMmToPx;
            boolean z2 = y > ((float) recyclerView.getBottom()) - fMmToPx;
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (z) {
                linearLayoutManager.scrollToPosition(RangesKt.coerceAtLeast(iFindFirstCompletelyVisibleItemPosition - 1, 0));
            } else if (z2) {
                linearLayoutManager.scrollToPosition(RangesKt.coerceAtMost(iFindLastCompletelyVisibleItemPosition + 1, this.dmsAdapter.getItemCount() - 1));
            }
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                boolean z3 = ((float) childAt.getTop()) < y && ((float) childAt.getBottom()) > y;
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                if (childViewHolder instanceof NotebookItemViewHolder) {
                    if (z3) {
                        this.currentHoveredCollectionKey = null;
                        this.handler.removeCallbacks(this.expandCollectionRunnable);
                    }
                    ((NotebookItemViewHolder) childViewHolder).setDraggedOn(z3);
                } else if (childViewHolder instanceof CollectionItemViewHolder) {
                    if (z3 && (collection = ((CollectionItemViewHolder) childViewHolder).getCollection()) != null && !Intrinsics.areEqual(collection.getCollectionKey(), this.currentHoveredCollectionKey)) {
                        this.currentHoveredCollectionKey = null;
                        this.handler.removeCallbacks(this.expandCollectionRunnable);
                        if (!collection.getIsExpanded()) {
                            this.currentHoveredCollectionKey = collection.getCollectionKey();
                            this.handler.postDelayed(this.expandCollectionRunnable, 500L);
                        }
                    }
                } else if (z3) {
                    this.currentHoveredCollectionKey = null;
                    this.handler.removeCallbacks(this.expandCollectionRunnable);
                }
            }
        }
    }

    private final boolean setPageDropped(ClipData clipData, float y) {
        Callback callback;
        PageKey pageKey = DragPageClipDataHelper.getPageKey(clipData);
        RecyclerView recyclerView = this.dmsRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        int childCount = recyclerView.getChildCount();
        FolderModel notebook = null;
        for (int i = 0; i < childCount; i++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if ((childViewHolder instanceof NotebookItemViewHolder) && r6.getTop() < y && r6.getBottom() > y) {
                notebook = ((NotebookItemViewHolder) childViewHolder).getNotebook();
            }
        }
        LibraryRepository libraryRepository = getLibraryRepository();
        Intrinsics.checkNotNull(pageKey);
        NotebookKey notebookKeyFromPageKey = libraryRepository.getNotebookKeyFromPageKey(pageKey);
        if (!isPageDroppable(notebookKeyFromPageKey, notebook) || notebook == null || (callback = this.callback) == null) {
            return false;
        }
        if (callback != null) {
            callback.movePage(pageKey, notebook.getNotebookKey());
        }
        getLogger().logTrace("Page " + pageKey.uuid() + " from notebook " + (notebookKeyFromPageKey != null ? notebookKeyFromPageKey.uuid() : null) + " dropped into notebook " + notebook.getNotebookKey().uuid());
        return true;
    }

    private final void setEmptyState(boolean enabled) {
        View view;
        View view2 = this.emptyState;
        if (view2 != null) {
            view2.setVisibility(enabled ? 0 : 8);
        }
        if (!enabled || (view = this.emptySearch) == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void setEmptySearch(boolean enabled) {
        String searchLabel;
        View view = this.emptySearch;
        if (view != null) {
            view.setVisibility(enabled ? 0 : 8);
        }
        if (enabled) {
            Callback callback = this.callback;
            if (callback == null || (searchLabel = callback.getSearchLabel()) == null) {
                searchLabel = "";
            }
            TextView textView = this.emptySearchText;
            if (textView != null) {
                textView.setText(getString(C6208R.string.dms_list_search_no_results_subtext, searchLabel));
            }
            View view2 = this.emptyState;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Deprecated(message = "Should rely on business logic data model from {@link com.myscript.nebo.dms.core.LibraryRepository}")
    private final int getCollectionCount() {
        return this.dmsAdapter.getParentList().size();
    }

    private final boolean isPageDroppable(NotebookKey draggedNotebookKey, FolderModel notebook) {
        if (notebook != null && notebook.isValid() && notebook.isSupported()) {
            return Intrinsics.areEqual(draggedNotebookKey, notebook.getNotebookKey());
        }
        return false;
    }

    @Deprecated(message = "Should rely on business logic data model from {@link com.myscript.nebo.dms.core.LibraryRepository}")
    public final int getNotebookCount() {
        List<CollectionModel> parentList = this.dmsAdapter.getParentList();
        Intrinsics.checkNotNullExpressionValue(parentList, "getParentList(...)");
        Iterator<T> it = parentList.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((CollectionModel) it.next()).getChildList().size();
        }
        return size;
    }

    private final void setDragConfirmed(boolean confirmed) {
        this.isDragConfirmed = confirmed;
        if (confirmed) {
            clearSelection();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.myscript.android.utils.NestedFragment
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (menu.hasVisibleItems()) {
            MenuItem menuItemFindItem = menu.findItem(C6208R.id.side_panel_add);
            if (menuItemFindItem != null) {
                menuItemFindItem.setEnabled(!getLibraryViewModel().isSearching());
            }
            MenuItem menuItemFindItem2 = menu.findItem(C6208R.id.dms_fab_more_menu_new_notebook);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setEnabled(getCollectionCount() > 0);
            }
            MenuItem menuItemFindItem3 = menu.findItem(C6208R.id.side_panel_select);
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setEnabled(getNotebookCount() > 0);
            }
        }
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == C6208R.id.dms_fab_more_menu_new_notebook) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onNewFolderRequested();
            }
            return true;
        }
        if (itemId == C6208R.id.dms_fab_more_menu_new_folder) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onNewCollectionRequested();
            }
            return true;
        }
        if (itemId != C6208R.id.side_panel_select) {
            return false;
        }
        startSelectionMode();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchStateUpdate(boolean isSearchActive) {
        SearchBar searchBar = this.searchBar;
        if (searchBar != null) {
            searchBar.setVisibility(isSearchActive ? 0 : 8);
        }
        updateRefreshingState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchProcessingUpdate(boolean isSearchProcessing) {
        SearchBar searchBar = this.searchBar;
        if (searchBar != null) {
            searchBar.showProgress(isSearchProcessing);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchHitsUpdate(Map<NotebookKey, Integer> hits) {
        Pair<Integer, Integer> notebookHits = getLibraryViewModel().getNotebookHits();
        SearchBar searchBar = this.searchBar;
        if (searchBar != null) {
            searchBar.setSearchResult(notebookHits.getFirst().intValue(), notebookHits.getSecond().intValue());
        }
    }

    public final void setCurrentTooltipVisible(boolean visible) {
        getLibraryViewModel().setCurrentTooltipVisible(visible);
    }

    /* JADX INFO: compiled from: DmsContentListFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DmsContentListFragment newInstance() {
            return new DmsContentListFragment();
        }
    }
}
