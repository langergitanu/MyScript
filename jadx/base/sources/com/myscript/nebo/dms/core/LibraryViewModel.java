package com.myscript.nebo.dms.core;

import android.content.ComponentCallbacks2;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.OngoingProgress;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSSyncState;
import com.myscript.snt.dms.SyncProgress;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008f\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b*\u0003imy\b\u0007\u0018\u0000 \u009d\u00012\u00020\u0001:\n\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u0002062\b\b\u0002\u0010]\u001a\u00020=H\u0007J\u0006\u0010^\u001a\u00020[J\u000e\u0010_\u001a\u00020[2\u0006\u0010`\u001a\u00020\u0018J\u000e\u0010a\u001a\u00020[2\u0006\u0010`\u001a\u00020\u0018J\b\u0010k\u001a\u00020[H\u0002J\u0006\u0010}\u001a\u00020[J\u0018\u0010~\u001a\u00020[2\u000e\b\u0002\u0010\u007f\u001a\b\u0012\u0004\u0012\u0002020)H\u0002J\u0007\u0010\u0080\u0001\u001a\u00020=J\u0011\u0010\u0081\u0001\u001a\u00020[2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u001b\u0010\u0084\u0001\u001a\u00020[2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0011\u0010\u0087\u0001\u001a\u00020[2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J&\u0010\u0088\u0001\u001a\u00020[2\b\u0010\u0089\u0001\u001a\u00030\u0086\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cJ/\u0010\u008b\u0001\u001a\u00020[2\u0007\u0010\u0085\u0001\u001a\u0002062\b\u0010\u0089\u0001\u001a\u00030\u0086\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cJ\u0010\u0010\u0087\u0001\u001a\u00020[2\u0007\u0010\u0085\u0001\u001a\u000206J\u0016\u0010\u0087\u0001\u001a\u00020[2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u0002060)J\t\u0010\u008d\u0001\u001a\u00020[H\u0002J\t\u0010\u008e\u0001\u001a\u00020[H\u0017J\u0010\u0010\u008f\u0001\u001a\u00020[2\u0007\u0010\u0090\u0001\u001a\u00020\u000eJ\u0007\u0010\u0091\u0001\u001a\u00020[J\u0010\u0010\u0092\u0001\u001a\u00020[2\u0007\u0010\u0093\u0001\u001a\u00020=J\u001d\u0010\u0094\u0001\u001a\u00020[2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0082@¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0%8F¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020.0%8F¢\u0006\u0006\u001a\u0004\b0\u0010'R\u0017\u00101\u001a\b\u0012\u0004\u0012\u0002020)8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060%8F¢\u0006\u0006\u001a\u0004\b8\u0010'R\u0016\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0%8F¢\u0006\u0006\u001a\u0004\b;\u0010'R\u001e\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020=@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R \u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001c0B0\"X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001c0B0%8F¢\u0006\u0006\u001a\u0004\bD\u0010'R\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001c\u0010I\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010=0=0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020=0%8F¢\u0006\u0006\u001a\u0004\bK\u0010'R\u001c\u0010L\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010=0=0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020=0%8F¢\u0006\u0006\u001a\u0004\bM\u0010'R\u0010\u0010N\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\b\u0012\u0004\u0012\u0002060\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bQ\u0010@R\u001a\u0010R\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010@\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u00020c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010jR\u0010\u0010l\u001a\u00020mX\u0082\u0004¢\u0006\u0004\n\u0002\u0010nR\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020=0p¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020u0tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020=0p¢\u0006\b\n\u0000\u001a\u0004\bw\u0010rR\u0010\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0004\n\u0002\u0010zR\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "discoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "featureTooltipUIState", "Lkotlin/Function1;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "ioDispatcher", "workDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/account/UserProfileManager;Lcom/myscript/nebo/discoverability/DiscoverabilityManager;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "syncCallbacks", "", "Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncCallback;", "syncState", "Lcom/myscript/snt/dms/DMSSyncState;", "syncStateNotebookCount", "", "syncFailureReason", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;", "syncToolbarProgress", "Lcom/myscript/nebo/common/OngoingProgress;", "_syncToolbarUIState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncToolbarUIState;", "syncToolbarUIState", "Landroidx/lifecycle/LiveData;", "getSyncToolbarUIState", "()Landroidx/lifecycle/LiveData;", "_notebookSyncUIStates", "", "Lcom/myscript/nebo/dms/core/LibraryViewModel$NotebookSyncUIState;", "notebookSyncUIStates", "getNotebookSyncUIStates", "_state", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "state", "getState", "collections", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "getCollections", "()Ljava/util/List;", "_openNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "openNotebookKey", "getOpenNotebookKey", "_discoveryTooltip", "discoveryTooltip", "getDiscoveryTooltip", "value", "", "openedByUser", "getOpenedByUser", "()Z", "_searchHits", "", "searchHits", "getSearchHits", "notebookHits", "Lkotlin/Pair;", "getNotebookHits", "()Lkotlin/Pair;", "_isSearchProcessing", "kotlin.jvm.PlatformType", "isSearchProcessing", "_isSearchActive", "isSearchActive", "currentSearchedNotebookKey", "titleMatchedFolders", "hasCloudProvider", "getHasCloudProvider", "hasSeenOutdatedDialog", "getHasSeenOutdatedDialog", "setHasSeenOutdatedDialog", "(Z)V", "lastSyncStartTime", "", "collapseToolbarJob", "Lkotlinx/coroutines/Job;", "openFolder", "", "notebookKey", "byUser", "closeFolder", "addSyncCallback", "callback", "removeSyncCallback", "onSyncUpdate", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "getOnSyncUpdate$annotations", "()V", "getOnSyncUpdate", "()Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "onSearchUpdate", "com/myscript/nebo/dms/core/LibraryViewModel$onSearchUpdate$1", "Lcom/myscript/nebo/dms/core/LibraryViewModel$onSearchUpdate$1;", "clearResults", "onLibraryUpdate", "com/myscript/nebo/dms/core/LibraryViewModel$onLibraryUpdate$1", "Lcom/myscript/nebo/dms/core/LibraryViewModel$onLibraryUpdate$1;", "syncCanceledOverCellularNotification", "Lcom/myscript/android/utils/SingleLiveEvent;", "getSyncCanceledOverCellularNotification", "()Lcom/myscript/android/utils/SingleLiveEvent;", "onNetworkUpdate", "Landroidx/lifecycle/Observer;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "cloudTokenExpiredNotification", "getCloudTokenExpiredNotification", "onCloudExpired", "com/myscript/nebo/dms/core/LibraryViewModel$onCloudExpired$1", "Lcom/myscript/nebo/dms/core/LibraryViewModel$onCloudExpired$1;", "onFeatureAccessChanged", "Lcom/myscript/nebo/account/FeatureAccessListener;", "refreshSyncState", "filter", "collectionModels", "isSearching", "createCollection", "name", "", "renameCollection", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/CollectionKey;", "moveToTrash", "createFolder", "collection", "color", "editFolder", UserMetadata.KEYDATA_FILENAME, "updateSyncToolbarUIState", "onCleared", "discover", "feature", "dismissCurrentTooltip", "setCurrentTooltipVisible", "visible", "collapseToolbar", TtmlNode.ANNOTATION_POSITION_AFTER, "Lkotlin/time/Duration;", "collapseToolbar-VtjQ1oo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "SyncCallback", "SyncToolbarUIState", "NotebookSyncUIState", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LibraryViewModel extends ViewModel {
    public static final ViewModelProvider.Factory Factory;
    private static final long HIDE_SYNC_PROGRESS_TOOLBAR_AFTER_DELAY;
    private MutableLiveData<TooltipUIState> _discoveryTooltip;
    private final MutableLiveData<Boolean> _isSearchActive;
    private final MutableLiveData<Boolean> _isSearchProcessing;
    private final MutableLiveData<List<NotebookSyncUIState>> _notebookSyncUIStates;
    private final MutableLiveData<NotebookKey> _openNotebookKey;
    private final MutableLiveData<Map<NotebookKey, Integer>> _searchHits;
    private final MutableLiveData<State> _state;
    private final MutableLiveData<SyncToolbarUIState> _syncToolbarUIState;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final SingleLiveEvent<Boolean> cloudTokenExpiredNotification;
    private Job collapseToolbarJob;
    private NotebookKey currentSearchedNotebookKey;
    private final DiscoverabilityManager discoverabilityManager;
    private final Function1<IDiscoverableFeature, TooltipUIState> featureTooltipUIState;
    private boolean hasSeenOutdatedDialog;
    private final CoroutineContext ioDispatcher;
    private long lastSyncStartTime;
    private final CoroutineContext mainDispatcher;
    private final NeboNetworkStateRepository networkStateRepository;
    private final LibraryViewModel$onCloudExpired$1 onCloudExpired;
    private final FeatureAccessListener onFeatureAccessChanged;
    private final LibraryViewModel$onLibraryUpdate$1 onLibraryUpdate;
    private final Observer<NeboNetworkState> onNetworkUpdate;
    private final LibraryViewModel$onSearchUpdate$1 onSearchUpdate;
    private final LibraryRepository.SyncListener onSyncUpdate;
    private boolean openedByUser;
    private final LibraryRepository repository;
    private final Set<SyncCallback> syncCallbacks;
    private final SingleLiveEvent<Boolean> syncCanceledOverCellularNotification;
    private LibraryRepository.SyncFailureReason syncFailureReason;
    private DMSSyncState syncState;
    private int syncStateNotebookCount;
    private OngoingProgress syncToolbarProgress;
    private final Set<NotebookKey> titleMatchedFolders;
    private final UserProfileManager userProfileManager;
    private final CoroutineContext workDispatcher;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J$\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncCallback;", "", "onSync", "", "onCancelSync", "onEnableCellular", "onConnect", "onUpdateRequired", "onConflictedPageCopies", "duplicatedPageKeys", "", "Lcom/myscript/snt/core/PageKey;", "duplicatedPageKeys2", "onSyncTextClicked", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface SyncCallback {
        void onCancelSync();

        void onConflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2);

        void onConnect();

        void onEnableCellular();

        void onSync();

        void onSyncTextClicked();

        void onUpdateRequired();
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMSSyncState.values().length];
            try {
                iArr[DMSSyncState.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DMSSyncState.REFRESH_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DMSSyncState.NEED_SYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DMSSyncState.SYNCING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DMSSyncState.SYNC_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DMSSyncState.UP_TO_DATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DMSSyncState.OUTDATED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DMSSyncState.CLOUD_DISABLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DMSSyncState.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TooltipUIState _init_$lambda$0(IDiscoverableFeature it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    public static /* synthetic */ void getOnSyncUpdate$annotations() {
    }

    public final void openFolder(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        openFolder$default(this, notebookKey, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.myscript.nebo.dms.core.LibraryViewModel$onSearchUpdate$1] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.myscript.nebo.dms.core.LibraryViewModel$onLibraryUpdate$1] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.myscript.nebo.dms.core.LibraryViewModel$onCloudExpired$1] */
    public LibraryViewModel(LibraryRepository repository, IAutoSyncTimerManager autoSyncTimerManager, NeboNetworkStateRepository networkStateRepository, UserProfileManager userProfileManager, DiscoverabilityManager discoverabilityManager, Function1<? super IDiscoverableFeature, TooltipUIState> featureTooltipUIState, CoroutineContext mainDispatcher, CoroutineContext ioDispatcher, CoroutineContext workDispatcher) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(featureTooltipUIState, "featureTooltipUIState");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.repository = repository;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.networkStateRepository = networkStateRepository;
        this.userProfileManager = userProfileManager;
        this.discoverabilityManager = discoverabilityManager;
        this.featureTooltipUIState = featureTooltipUIState;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.workDispatcher = workDispatcher;
        this.syncCallbacks = new LinkedHashSet();
        this.syncState = DMSSyncState.NONE;
        this.syncFailureReason = LibraryRepository.SyncFailureReason.UNKNOWN;
        this._syncToolbarUIState = new MutableLiveData<>();
        this._notebookSyncUIStates = new MutableLiveData<>();
        this._state = new MutableLiveData<>();
        this._openNotebookKey = new MutableLiveData<>();
        this._discoveryTooltip = new MutableLiveData<>(null);
        this._searchHits = new MutableLiveData<>(new LinkedHashMap());
        this._isSearchProcessing = new MutableLiveData<>(false);
        this._isSearchActive = new MutableLiveData<>(false);
        this.titleMatchedFolders = new LinkedHashSet();
        this.lastSyncStartTime = -1L;
        LibraryRepository.SyncListener syncListener = new LibraryRepository.SyncListener() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$onSyncUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void conflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2s) {
                Intrinsics.checkNotNullParameter(duplicatedPageKeys, "duplicatedPageKeys");
                Intrinsics.checkNotNullParameter(duplicatedPageKeys2s, "duplicatedPageKeys2s");
                Iterator it = this.this$0.syncCallbacks.iterator();
                while (it.hasNext()) {
                    ((LibraryViewModel.SyncCallback) it.next()).onConflictedPageCopies(duplicatedPageKeys, duplicatedPageKeys2s);
                }
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncStateChanged(DMSSyncState state, int impactedFolderCount, LibraryRepository.SyncFailureReason failureReason) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(failureReason, "failureReason");
                if (state != DMSSyncState.SYNCING && state != DMSSyncState.REFRESHING) {
                    this.this$0.syncToolbarProgress = null;
                }
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$syncStateChanged$1(this.this$0, state, impactedFolderCount, failureReason, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(int amountDone, int totalAmount) {
                this.this$0.syncToolbarProgress = new OngoingProgress(amountDone, totalAmount);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$syncProgress$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(NotebookKey folderSyncing, int amountDone, int totalAmount) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$syncProgress$2(this.this$0, folderSyncing, amountDone, totalAmount, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncPrepareProgress(int amountDone, int totalAmount) {
                this.this$0.syncToolbarProgress = new OngoingProgress(amountDone, totalAmount);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$syncPrepareProgress$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void refreshProgress(int amountDone, int totalAmount) {
                this.this$0.syncToolbarProgress = new OngoingProgress(amountDone, totalAmount);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$refreshProgress$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void autoSyncSettingChanged() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSyncUpdate$1$autoSyncSettingChanged$1(this.this$0, null), 2, null);
            }
        };
        this.onSyncUpdate = syncListener;
        ?? r11 = new DMSSearchController.IGridSearch() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$onSearchUpdate$1
            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStarted(String rootPath) {
                Intrinsics.checkNotNullParameter(rootPath, "rootPath");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onSearchStarted$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEnded(int hitCount) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onSearchEnded$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedPage(PageKey pageKey, int hitCount) {
                NotebookKey notebookKey;
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                if (hitCount <= 0 || (notebookKey = this.this$0.currentSearchedNotebookKey) == null) {
                    return;
                }
                LibraryViewModel libraryViewModel = this.this$0;
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), libraryViewModel.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onSearchEndedPage$1$1(libraryViewModel, notebookKey, hitCount, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStartedFolder(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                this.this$0.currentSearchedNotebookKey = notebookKey;
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedFolder(NotebookKey notebookKey, int hitCount) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                this.this$0.currentSearchedNotebookKey = null;
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onTitleMatch(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                NotebookKey notebookKey = this.this$0.currentSearchedNotebookKey;
                if (notebookKey != null) {
                    LibraryViewModel libraryViewModel = this.this$0;
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), libraryViewModel.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onTitleMatch$1$1(libraryViewModel, notebookKey, null), 2, null);
                }
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchInterrupted() {
                this.this$0.currentSearchedNotebookKey = null;
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onSearchInterrupted$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onClearResults() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onSearchUpdate$1$onClearResults$1(this.this$0, null), 2, null);
            }
        };
        this.onSearchUpdate = r11;
        ?? r12 = new LibraryRepository.ModelChangedListener() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$onLibraryUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onCollectionsLoaded() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onFolderUpdated(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                FolderModel folder = this.this$0.repository.getFolder(notebookKey);
                if ((folder != null ? folder.getSyncProgress() : null) == SyncProgress.NONE) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1(this.this$0, notebookKey, null), 2, null);
                }
            }
        };
        this.onLibraryUpdate = r12;
        this.syncCanceledOverCellularNotification = new SingleLiveEvent<>();
        this.onNetworkUpdate = new Observer() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryViewModel.onNetworkUpdate$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        };
        this.cloudTokenExpiredNotification = new SingleLiveEvent<>();
        ?? r13 = new LibraryRepository.CloudTokenExpirationListener() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$onCloudExpired$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.CloudTokenExpirationListener
            public void onCloudTokenExpired() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onCloudExpired$1$onCloudTokenExpired$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.CloudTokenExpirationListener
            public void onValidCloudToken() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new LibraryViewModel$onCloudExpired$1$onValidCloudToken$1(this.this$0, null), 2, null);
            }
        };
        this.onCloudExpired = r13;
        FeatureAccessListener featureAccessListener = new FeatureAccessListener() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda9
            @Override // com.myscript.nebo.account.FeatureAccessListener
            public final void featuresAccessChanged(Map map) {
                LibraryViewModel.onFeatureAccessChanged$lambda$0(this.f$0, map);
            }
        };
        this.onFeatureAccessChanged = featureAccessListener;
        LibraryViewModel libraryViewModel = this;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), mainDispatcher, null, new C62352(null), 2, null);
        this.syncState = repository.getDmsSyncState();
        repository.addModelChangedListener((LibraryRepository.ModelChangedListener) r12);
        repository.addSyncListener(syncListener);
        repository.getSearchController().addDMSSearchListener((DMSSearchController.IGridSearch) r11);
        repository.addCloudTokenExpirationListener((LibraryRepository.CloudTokenExpirationListener) r13);
        userProfileManager.addFeatureAccessListener(featureAccessListener);
        r12.onCollectionsLoaded();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), mainDispatcher, null, new C62363(null), 2, null);
    }

    public /* synthetic */ LibraryViewModel(LibraryRepository libraryRepository, IAutoSyncTimerManager iAutoSyncTimerManager, NeboNetworkStateRepository neboNetworkStateRepository, UserProfileManager userProfileManager, DiscoverabilityManager discoverabilityManager, Function1 function1, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, iAutoSyncTimerManager, neboNetworkStateRepository, userProfileManager, (i & 16) != 0 ? null : discoverabilityManager, (i & 32) != 0 ? new Function1() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryViewModel._init_$lambda$0((IDiscoverableFeature) obj);
            }
        } : function1, (i & 64) != 0 ? Dispatchers.getMain() : coroutineContext, (i & 128) != 0 ? Dispatchers.getIO() : coroutineContext2, (i & 256) != 0 ? Dispatchers.getDefault() : coroutineContext3);
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "", "<init>", "()V", "Loaded", "Unloaded", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State$Loaded;", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State$Unloaded;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: LibraryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$State$Loaded;", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "collections", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "filteredCollections", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getCollections", "()Ljava/util/List;", "getFilteredCollections", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Loaded extends State {
            public static final int $stable = 8;
            private final List<CollectionModel> collections;
            private final List<CollectionModel> filteredCollections;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<CollectionModel> collections, List<CollectionModel> filteredCollections) {
                super(null);
                Intrinsics.checkNotNullParameter(collections, "collections");
                Intrinsics.checkNotNullParameter(filteredCollections, "filteredCollections");
                this.collections = collections;
                this.filteredCollections = filteredCollections;
            }

            public /* synthetic */ Loaded(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i & 2) != 0 ? list : list2);
            }

            public final List<CollectionModel> getCollections() {
                return this.collections;
            }

            public final List<CollectionModel> getFilteredCollections() {
                return this.filteredCollections;
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: LibraryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$State$Unloaded;", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Unloaded extends State {
            public static final int $stable = 0;
            public static final Unloaded INSTANCE = new Unloaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Unloaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -270050923;
            }

            public String toString() {
                return "Unloaded";
            }

            private Unloaded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\t\u0012\b\b\u0001\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J¹\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0003\u0010\u000f\u001a\u00020\t2\b\b\u0003\u0010\u0010\u001a\u00020\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0003HÆ\u0001J\u0014\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020\tHÖ\u0081\u0004J\n\u0010B\u001a\u00020\rHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001b¨\u0006C"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncToolbarUIState;", "", "isVisible", "", "animateVisibilityChange", "hideAfterDelay", "syncStartTime", "", "statusResourceId", "", "statusPluralsResourceId", "statusDetailsResourceId", "statusDetailsText", "", "numberOfNotebookToSync", "iconResourceId", "buttonTextResourceId", "onButtonClick", "Lkotlin/Function0;", "", "onTextClick", "isProgressVisible", "progress", "Lcom/myscript/nebo/common/OngoingProgress;", "isStatusColorRed", "<init>", "(ZZZJIIILjava/lang/String;IIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLcom/myscript/nebo/common/OngoingProgress;Z)V", "()Z", "getAnimateVisibilityChange", "getHideAfterDelay", "getSyncStartTime", "()J", "getStatusResourceId", "()I", "getStatusPluralsResourceId", "getStatusDetailsResourceId", "getStatusDetailsText", "()Ljava/lang/String;", "getNumberOfNotebookToSync", "getIconResourceId", "getButtonTextResourceId", "getOnButtonClick", "()Lkotlin/jvm/functions/Function0;", "getOnTextClick", "getProgress", "()Lcom/myscript/nebo/common/OngoingProgress;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SyncToolbarUIState {
        public static final int $stable = 8;
        private final boolean animateVisibilityChange;
        private final int buttonTextResourceId;
        private final boolean hideAfterDelay;
        private final int iconResourceId;
        private final boolean isProgressVisible;
        private final boolean isStatusColorRed;
        private final boolean isVisible;
        private final int numberOfNotebookToSync;
        private final Function0<Unit> onButtonClick;
        private final Function0<Unit> onTextClick;
        private final OngoingProgress progress;
        private final int statusDetailsResourceId;
        private final String statusDetailsText;
        private final int statusPluralsResourceId;
        private final int statusResourceId;
        private final long syncStartTime;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SyncToolbarUIState copy$default(SyncToolbarUIState syncToolbarUIState, boolean z, boolean z2, boolean z3, long j, int i, int i2, int i3, String str, int i4, int i5, int i6, Function0 function0, Function0 function02, boolean z4, OngoingProgress ongoingProgress, boolean z5, int i7, Object obj) {
            boolean z6 = (i7 & 1) != 0 ? syncToolbarUIState.isVisible : z;
            return syncToolbarUIState.copy(z6, (i7 & 2) != 0 ? syncToolbarUIState.animateVisibilityChange : z2, (i7 & 4) != 0 ? syncToolbarUIState.hideAfterDelay : z3, (i7 & 8) != 0 ? syncToolbarUIState.syncStartTime : j, (i7 & 16) != 0 ? syncToolbarUIState.statusResourceId : i, (i7 & 32) != 0 ? syncToolbarUIState.statusPluralsResourceId : i2, (i7 & 64) != 0 ? syncToolbarUIState.statusDetailsResourceId : i3, (i7 & 128) != 0 ? syncToolbarUIState.statusDetailsText : str, (i7 & 256) != 0 ? syncToolbarUIState.numberOfNotebookToSync : i4, (i7 & 512) != 0 ? syncToolbarUIState.iconResourceId : i5, (i7 & 1024) != 0 ? syncToolbarUIState.buttonTextResourceId : i6, (i7 & 2048) != 0 ? syncToolbarUIState.onButtonClick : function0, (i7 & 4096) != 0 ? syncToolbarUIState.onTextClick : function02, (i7 & 8192) != 0 ? syncToolbarUIState.isProgressVisible : z4, (i7 & 16384) != 0 ? syncToolbarUIState.progress : ongoingProgress, (i7 & 32768) != 0 ? syncToolbarUIState.isStatusColorRed : z5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final int getIconResourceId() {
            return this.iconResourceId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final int getButtonTextResourceId() {
            return this.buttonTextResourceId;
        }

        public final Function0<Unit> component12() {
            return this.onButtonClick;
        }

        public final Function0<Unit> component13() {
            return this.onTextClick;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getIsProgressVisible() {
            return this.isProgressVisible;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final OngoingProgress getProgress() {
            return this.progress;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final boolean getIsStatusColorRed() {
            return this.isStatusColorRed;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAnimateVisibilityChange() {
            return this.animateVisibilityChange;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHideAfterDelay() {
            return this.hideAfterDelay;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getSyncStartTime() {
            return this.syncStartTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getStatusResourceId() {
            return this.statusResourceId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getStatusPluralsResourceId() {
            return this.statusPluralsResourceId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getStatusDetailsResourceId() {
            return this.statusDetailsResourceId;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getStatusDetailsText() {
            return this.statusDetailsText;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getNumberOfNotebookToSync() {
            return this.numberOfNotebookToSync;
        }

        public final SyncToolbarUIState copy(boolean isVisible, boolean animateVisibilityChange, boolean hideAfterDelay, long syncStartTime, int statusResourceId, int statusPluralsResourceId, int statusDetailsResourceId, String statusDetailsText, int numberOfNotebookToSync, int iconResourceId, int buttonTextResourceId, Function0<Unit> onButtonClick, Function0<Unit> onTextClick, boolean isProgressVisible, OngoingProgress progress, boolean isStatusColorRed) {
            Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
            Intrinsics.checkNotNullParameter(onTextClick, "onTextClick");
            return new SyncToolbarUIState(isVisible, animateVisibilityChange, hideAfterDelay, syncStartTime, statusResourceId, statusPluralsResourceId, statusDetailsResourceId, statusDetailsText, numberOfNotebookToSync, iconResourceId, buttonTextResourceId, onButtonClick, onTextClick, isProgressVisible, progress, isStatusColorRed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SyncToolbarUIState)) {
                return false;
            }
            SyncToolbarUIState syncToolbarUIState = (SyncToolbarUIState) other;
            return this.isVisible == syncToolbarUIState.isVisible && this.animateVisibilityChange == syncToolbarUIState.animateVisibilityChange && this.hideAfterDelay == syncToolbarUIState.hideAfterDelay && this.syncStartTime == syncToolbarUIState.syncStartTime && this.statusResourceId == syncToolbarUIState.statusResourceId && this.statusPluralsResourceId == syncToolbarUIState.statusPluralsResourceId && this.statusDetailsResourceId == syncToolbarUIState.statusDetailsResourceId && Intrinsics.areEqual(this.statusDetailsText, syncToolbarUIState.statusDetailsText) && this.numberOfNotebookToSync == syncToolbarUIState.numberOfNotebookToSync && this.iconResourceId == syncToolbarUIState.iconResourceId && this.buttonTextResourceId == syncToolbarUIState.buttonTextResourceId && Intrinsics.areEqual(this.onButtonClick, syncToolbarUIState.onButtonClick) && Intrinsics.areEqual(this.onTextClick, syncToolbarUIState.onTextClick) && this.isProgressVisible == syncToolbarUIState.isProgressVisible && Intrinsics.areEqual(this.progress, syncToolbarUIState.progress) && this.isStatusColorRed == syncToolbarUIState.isStatusColorRed;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((Boolean.hashCode(this.isVisible) * 31) + Boolean.hashCode(this.animateVisibilityChange)) * 31) + Boolean.hashCode(this.hideAfterDelay)) * 31) + Long.hashCode(this.syncStartTime)) * 31) + Integer.hashCode(this.statusResourceId)) * 31) + Integer.hashCode(this.statusPluralsResourceId)) * 31) + Integer.hashCode(this.statusDetailsResourceId)) * 31;
            String str = this.statusDetailsText;
            int iHashCode2 = (((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.numberOfNotebookToSync)) * 31) + Integer.hashCode(this.iconResourceId)) * 31) + Integer.hashCode(this.buttonTextResourceId)) * 31) + this.onButtonClick.hashCode()) * 31) + this.onTextClick.hashCode()) * 31) + Boolean.hashCode(this.isProgressVisible)) * 31;
            OngoingProgress ongoingProgress = this.progress;
            return ((iHashCode2 + (ongoingProgress != null ? ongoingProgress.hashCode() : 0)) * 31) + Boolean.hashCode(this.isStatusColorRed);
        }

        public String toString() {
            return "SyncToolbarUIState(isVisible=" + this.isVisible + ", animateVisibilityChange=" + this.animateVisibilityChange + ", hideAfterDelay=" + this.hideAfterDelay + ", syncStartTime=" + this.syncStartTime + ", statusResourceId=" + this.statusResourceId + ", statusPluralsResourceId=" + this.statusPluralsResourceId + ", statusDetailsResourceId=" + this.statusDetailsResourceId + ", statusDetailsText=" + this.statusDetailsText + ", numberOfNotebookToSync=" + this.numberOfNotebookToSync + ", iconResourceId=" + this.iconResourceId + ", buttonTextResourceId=" + this.buttonTextResourceId + ", onButtonClick=" + this.onButtonClick + ", onTextClick=" + this.onTextClick + ", isProgressVisible=" + this.isProgressVisible + ", progress=" + this.progress + ", isStatusColorRed=" + this.isStatusColorRed + ")";
        }

        public SyncToolbarUIState(boolean z, boolean z2, boolean z3, long j, int i, int i2, int i3, String str, int i4, int i5, int i6, Function0<Unit> onButtonClick, Function0<Unit> onTextClick, boolean z4, OngoingProgress ongoingProgress, boolean z5) {
            Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
            Intrinsics.checkNotNullParameter(onTextClick, "onTextClick");
            this.isVisible = z;
            this.animateVisibilityChange = z2;
            this.hideAfterDelay = z3;
            this.syncStartTime = j;
            this.statusResourceId = i;
            this.statusPluralsResourceId = i2;
            this.statusDetailsResourceId = i3;
            this.statusDetailsText = str;
            this.numberOfNotebookToSync = i4;
            this.iconResourceId = i5;
            this.buttonTextResourceId = i6;
            this.onButtonClick = onButtonClick;
            this.onTextClick = onTextClick;
            this.isProgressVisible = z4;
            this.progress = ongoingProgress;
            this.isStatusColorRed = z5;
        }

        public /* synthetic */ SyncToolbarUIState(boolean z, boolean z2, boolean z3, long j, int i, int i2, int i3, String str, int i4, int i5, int i6, Function0 function0, Function0 function02, boolean z4, OngoingProgress ongoingProgress, boolean z5, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, z3, (i7 & 8) != 0 ? -1L : j, i, i2, i3, (i7 & 128) != 0 ? null : str, i4, i5, i6, function0, function02, z4, (i7 & 16384) != 0 ? null : ongoingProgress, (i7 & 32768) != 0 ? false : z5);
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public final boolean getAnimateVisibilityChange() {
            return this.animateVisibilityChange;
        }

        public final boolean getHideAfterDelay() {
            return this.hideAfterDelay;
        }

        public final long getSyncStartTime() {
            return this.syncStartTime;
        }

        public final int getStatusResourceId() {
            return this.statusResourceId;
        }

        public final int getStatusPluralsResourceId() {
            return this.statusPluralsResourceId;
        }

        public final int getStatusDetailsResourceId() {
            return this.statusDetailsResourceId;
        }

        public final String getStatusDetailsText() {
            return this.statusDetailsText;
        }

        public final int getNumberOfNotebookToSync() {
            return this.numberOfNotebookToSync;
        }

        public final int getIconResourceId() {
            return this.iconResourceId;
        }

        public final int getButtonTextResourceId() {
            return this.buttonTextResourceId;
        }

        public final Function0<Unit> getOnButtonClick() {
            return this.onButtonClick;
        }

        public final Function0<Unit> getOnTextClick() {
            return this.onTextClick;
        }

        public final boolean isProgressVisible() {
            return this.isProgressVisible;
        }

        public final OngoingProgress getProgress() {
            return this.progress;
        }

        public final boolean isStatusColorRed() {
            return this.isStatusColorRed;
        }
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryViewModel$NotebookSyncUIState;", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "amountDone", "", "totalAmount", "<init>", "(Lcom/myscript/snt/core/NotebookKey;II)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "getAmountDone", "()I", "getTotalAmount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NotebookSyncUIState {
        public static final int $stable = 8;
        private final int amountDone;
        private final NotebookKey notebookKey;
        private final int totalAmount;

        public static /* synthetic */ NotebookSyncUIState copy$default(NotebookSyncUIState notebookSyncUIState, NotebookKey notebookKey, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                notebookKey = notebookSyncUIState.notebookKey;
            }
            if ((i3 & 2) != 0) {
                i = notebookSyncUIState.amountDone;
            }
            if ((i3 & 4) != 0) {
                i2 = notebookSyncUIState.totalAmount;
            }
            return notebookSyncUIState.copy(notebookKey, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAmountDone() {
            return this.amountDone;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalAmount() {
            return this.totalAmount;
        }

        public final NotebookSyncUIState copy(NotebookKey notebookKey, int amountDone, int totalAmount) {
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            return new NotebookSyncUIState(notebookKey, amountDone, totalAmount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotebookSyncUIState)) {
                return false;
            }
            NotebookSyncUIState notebookSyncUIState = (NotebookSyncUIState) other;
            return Intrinsics.areEqual(this.notebookKey, notebookSyncUIState.notebookKey) && this.amountDone == notebookSyncUIState.amountDone && this.totalAmount == notebookSyncUIState.totalAmount;
        }

        public int hashCode() {
            return (((this.notebookKey.hashCode() * 31) + Integer.hashCode(this.amountDone)) * 31) + Integer.hashCode(this.totalAmount);
        }

        public String toString() {
            return "NotebookSyncUIState(notebookKey=" + this.notebookKey + ", amountDone=" + this.amountDone + ", totalAmount=" + this.totalAmount + ")";
        }

        public NotebookSyncUIState(NotebookKey notebookKey, int i, int i2) {
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            this.notebookKey = notebookKey;
            this.amountDone = i;
            this.totalAmount = i2;
        }

        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }

        public final int getAmountDone() {
            return this.amountDone;
        }

        public final int getTotalAmount() {
            return this.totalAmount;
        }
    }

    public final LiveData<SyncToolbarUIState> getSyncToolbarUIState() {
        return this._syncToolbarUIState;
    }

    public final LiveData<List<NotebookSyncUIState>> getNotebookSyncUIStates() {
        return this._notebookSyncUIStates;
    }

    public final LiveData<State> getState() {
        return this._state;
    }

    public final List<CollectionModel> getCollections() {
        List<CollectionModel> collections;
        State value = getState().getValue();
        State.Loaded loaded = value instanceof State.Loaded ? (State.Loaded) value : null;
        return (loaded == null || (collections = loaded.getCollections()) == null) ? CollectionsKt.emptyList() : collections;
    }

    public final LiveData<NotebookKey> getOpenNotebookKey() {
        return this._openNotebookKey;
    }

    public final LiveData<TooltipUIState> getDiscoveryTooltip() {
        return this._discoveryTooltip;
    }

    public final boolean getOpenedByUser() {
        return this.openedByUser;
    }

    public final LiveData<Map<NotebookKey, Integer>> getSearchHits() {
        return this._searchHits;
    }

    public final Pair<Integer, Integer> getNotebookHits() {
        Collection<Integer> collectionValues;
        Map<NotebookKey, Integer> value = getSearchHits().getValue();
        int iSumOfInt = 0;
        Integer numValueOf = Integer.valueOf(value != null ? value.size() : 0);
        Map<NotebookKey, Integer> value2 = getSearchHits().getValue();
        if (value2 != null && (collectionValues = value2.values()) != null) {
            iSumOfInt = CollectionsKt.sumOfInt(collectionValues);
        }
        return new Pair<>(numValueOf, Integer.valueOf(iSumOfInt));
    }

    public final LiveData<Boolean> isSearchProcessing() {
        return this._isSearchProcessing;
    }

    public final LiveData<Boolean> isSearchActive() {
        return this._isSearchActive;
    }

    public final boolean getHasCloudProvider() {
        return this.repository.getHasCloudProvider();
    }

    public final boolean getHasSeenOutdatedDialog() {
        return this.hasSeenOutdatedDialog;
    }

    public final void setHasSeenOutdatedDialog(boolean z) {
        this.hasSeenOutdatedDialog = z;
    }

    public static /* synthetic */ void openFolder$default(LibraryViewModel libraryViewModel, NotebookKey notebookKey, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        libraryViewModel.openFolder(notebookKey, z);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$openFolder$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$openFolder$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotebookKey $notebookKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62411(NotebookKey notebookKey, Continuation<? super C62411> continuation) {
            super(2, continuation);
            this.$notebookKey = notebookKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62411(this.$notebookKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LibraryViewModel.this.repository.setLastOpenedFolderKey(this.$notebookKey);
                LibraryViewModel.this._openNotebookKey.setValue(this.$notebookKey);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void openFolder(NotebookKey notebookKey, boolean byUser) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        this.openedByUser = byUser;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C62411(notebookKey, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$closeFolder$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$closeFolder$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62371(Continuation<? super C62371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LibraryViewModel.this.repository.setLastOpenedFolderKey(null);
                LibraryViewModel.this._openNotebookKey.setValue(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeFolder() {
        this.openedByUser = false;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C62371(null), 2, null);
    }

    public final void addSyncCallback(SyncCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.syncCallbacks.add(callback);
    }

    public final void removeSyncCallback(SyncCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.syncCallbacks.remove(callback);
    }

    public final LibraryRepository.SyncListener getOnSyncUpdate() {
        return this.onSyncUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearResults() {
        Map<NotebookKey, Integer> value = this._searchHits.getValue();
        if (value != null) {
            value.clear();
        }
        MutableLiveData<Map<NotebookKey, Integer>> mutableLiveData = this._searchHits;
        mutableLiveData.setValue(mutableLiveData.getValue());
        this.titleMatchedFolders.clear();
    }

    public final SingleLiveEvent<Boolean> getSyncCanceledOverCellularNotification() {
        return this.syncCanceledOverCellularNotification;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNetworkUpdate$lambda$0(LibraryViewModel libraryViewModel, NeboNetworkState networkState) {
        Intrinsics.checkNotNullParameter(networkState, "networkState");
        if (libraryViewModel.repository.getHasCloudProvider()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), null, null, new LibraryViewModel$onNetworkUpdate$1$1(libraryViewModel, null), 3, null);
        }
        libraryViewModel.updateSyncToolbarUIState();
        if (networkState.isDataTransferAllowed() || !libraryViewModel.repository.isCloudSyncOngoing()) {
            return;
        }
        libraryViewModel.autoSyncTimerManager.cancelSync();
        if (!(networkState instanceof NeboNetworkState.Connected) || ((NeboNetworkState.Connected) networkState).isEnabled()) {
            return;
        }
        libraryViewModel.syncCanceledOverCellularNotification.setValue(true);
    }

    public final SingleLiveEvent<Boolean> getCloudTokenExpiredNotification() {
        return this.cloudTokenExpiredNotification;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFeatureAccessChanged$lambda$0(LibraryViewModel libraryViewModel, Map access) {
        Intrinsics.checkNotNullParameter(access, "access");
        if (access.containsKey(Feature.CloudSync)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), libraryViewModel.mainDispatcher, null, new LibraryViewModel$onFeatureAccessChanged$1$1(libraryViewModel, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$2 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$2", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62352 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62352(Continuation<? super C62352> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62352(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LibraryViewModel.this._state.setValue(State.Unloaded.INSTANCE);
                LibraryViewModel.this.getSyncCanceledOverCellularNotification().setValue(Boxing.boxBoolean(false));
                LibraryViewModel.this.getCloudTokenExpiredNotification().setValue(Boxing.boxBoolean(false));
                LibraryViewModel.this.networkStateRepository.getNeboNetworkState().observeForever(LibraryViewModel.this.onNetworkUpdate);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$refreshSyncState$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$refreshSyncState$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {426}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {427}, m1615s = {}, m1616v = 2)
    static final class C62421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62421(Continuation<? super C62421> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62421(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LibraryViewModel.this.autoSyncTimerManager.triggerRefreshNow(this) == coroutine_suspended) {
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

    public final void refreshSyncState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62421(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void filter$default(LibraryViewModel libraryViewModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = libraryViewModel.getCollections();
        }
        libraryViewModel.filter(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filter(List<CollectionModel> collectionModels) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        if (this.repository.getSearchController().isSearchModeActive()) {
            for (CollectionModel collectionModel : collectionModels) {
                CollectionModel collectionModelCopy = CollectionModel.INSTANCE.copy(collectionModel);
                Iterator<T> it = collectionModel.getFolders().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FolderModel folderModel = (FolderModel) it.next();
                    Map<NotebookKey, Integer> value = this._searchHits.getValue();
                    int iIntValue = (value == null || (num = value.get(folderModel.getNotebookKey())) == null) ? 0 : num.intValue();
                    boolean z = iIntValue > 0;
                    boolean zContains = this.titleMatchedFolders.contains(folderModel.getNotebookKey());
                    collectionModelCopy.removeFolderItem(folderModel);
                    if (z || zContains) {
                        collectionModelCopy.addNotebookItem(FolderModel.copy$default(folderModel, null, false, false, false, 0L, null, 0, null, null, false, iIntValue, false, 0, 0, null, false, 64511, null));
                    }
                }
                if (!collectionModelCopy.isEmpty()) {
                    collectionModelCopy.setSearch(true);
                    arrayList.add(collectionModelCopy);
                }
            }
        }
        this._state.setValue(new State.Loaded(getCollections(), arrayList));
    }

    public final boolean isSearching() {
        return this.repository.getSearchController().isSearchModeActive() || this.repository.getSearchController().isSearchProcessing();
    }

    public final void createCollection(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.repository.createCollection(name);
    }

    public final void renameCollection(CollectionKey key, String name) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        this.repository.renameCollection(key, name);
    }

    public final void moveToTrash(CollectionKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.repository.moveCollectionToTrash(key);
    }

    public final void createFolder(CollectionKey collection, String name, int color) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(name, "name");
        NotebookKey notebookKeyCreateFolder = this.repository.createFolder(collection, name, color);
        if (notebookKeyCreateFolder != null) {
            this.repository.setLastOpenedFolderKey(notebookKeyCreateFolder);
            openFolder$default(this, notebookKeyCreateFolder, false, 2, null);
        }
    }

    public final void editFolder(NotebookKey key, CollectionKey collection, String name, int color) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(name, "name");
        this.repository.editFolder(key, name, collection, color);
    }

    public final void moveToTrash(NotebookKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.repository.moveToTrash(key);
    }

    public final void moveToTrash(List<? extends NotebookKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.repository.moveFoldersToTrash(keys);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01fd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateSyncToolbarUIState() {
        int i;
        Function0 function0;
        int i2;
        Function0 function02;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        String str;
        Function0 function03;
        int i7;
        int i8;
        Function0 function04;
        int i9;
        String str2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Function0 function05;
        boolean z2;
        boolean z3;
        boolean z4;
        Job job;
        SyncToolbarUIState value;
        OngoingProgress ongoingProgress;
        Function0 function06 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        Function0 function07 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        boolean isAutoSyncEnabled = this.repository.getIsAutoSyncEnabled();
        NeboNetworkState value2 = this.networkStateRepository.getNeboNetworkState().getValue();
        if (!this.repository.getHasCloudProvider() && !(value2 instanceof NeboNetworkState.Offline)) {
            i13 = C6208R.string.sync_header_unsigned;
            i14 = C6208R.string.sync_header_enable;
            function05 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LibraryViewModel.updateSyncToolbarUIState$lambda$2(this.f$0);
                }
            };
        } else {
            if (value2 instanceof NeboNetworkState.Offline) {
                i12 = C6208R.string.sync_header_offline;
                i11 = C6208R.drawable.ic_cloud_disabled_outline;
            } else if ((value2 instanceof NeboNetworkState.Connected) && !((NeboNetworkState.Connected) value2).isEnabled()) {
                i13 = C6208R.string.sync_header_cellular;
                i14 = C6208R.string.sync_header_enable;
                function05 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LibraryViewModel.updateSyncToolbarUIState$lambda$3(this.f$0);
                    }
                };
            } else {
                if ((isAutoSyncEnabled && (this.syncState == DMSSyncState.NEED_SYNC || this.syncState == DMSSyncState.SYNCING || this.syncState == DMSSyncState.REFRESHING)) || (!isAutoSyncEnabled && (this.syncState == DMSSyncState.SYNCING || this.syncState == DMSSyncState.REFRESHING))) {
                    this.lastSyncStartTime = System.currentTimeMillis();
                } else if (this.syncState != DMSSyncState.UP_TO_DATE && this.syncState != DMSSyncState.REFRESHING) {
                    this.lastSyncStartTime = -1L;
                }
                switch (WhenMappings.$EnumSwitchMapping$0[this.syncState.ordinal()]) {
                    case 1:
                        i = C6208R.string.sync_header_refreshing;
                        function02 = function06;
                        function03 = function07;
                        i2 = i;
                        i4 = 0;
                        i5 = i4;
                        i6 = i5;
                        i3 = i6;
                        z = i3;
                        str = null;
                        break;
                    case 2:
                        int i15 = C6208R.string.sync_header_refresh_failed;
                        int i16 = C6208R.string.sync_header_retry_button;
                        Function0 function08 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LibraryViewModel.updateSyncToolbarUIState$lambda$4(this.f$0);
                            }
                        };
                        function0 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LibraryViewModel.updateSyncToolbarUIState$lambda$5(this.f$0);
                            }
                        };
                        i2 = i15;
                        function02 = function08;
                        i3 = i16;
                        i4 = 0;
                        i5 = 0;
                        i6 = i5;
                        z = i6;
                        str = null;
                        function03 = function0;
                        break;
                    case 3:
                        if (isAutoSyncEnabled) {
                            i7 = C6208R.plurals.sync_header_folders_syncing;
                            function02 = function06;
                            function03 = function07;
                            i4 = i7;
                            i2 = 0;
                            i5 = 0;
                            i6 = i5;
                            i3 = i6;
                            z = i3;
                            str = null;
                        } else {
                            int i17 = C6208R.plurals.sync_header_folders_to_sync;
                            int i18 = C6208R.string.sync_header_sync_button;
                            Function0 function09 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LibraryViewModel.updateSyncToolbarUIState$lambda$6(this.f$0);
                                }
                            };
                            function0 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LibraryViewModel.updateSyncToolbarUIState$lambda$7(this.f$0);
                                }
                            };
                            i3 = i18;
                            function02 = function09;
                            i4 = i17;
                            i2 = 0;
                            i5 = 0;
                            i6 = i5;
                            z = i6;
                            str = null;
                            function03 = function0;
                        }
                        break;
                    case 4:
                        if (isAutoSyncEnabled) {
                            i = C6208R.string.sync_header_refreshing;
                            function02 = function06;
                            function03 = function07;
                            i2 = i;
                            i4 = 0;
                            i5 = i4;
                            i6 = i5;
                            i3 = i6;
                            z = i3;
                            str = null;
                        } else {
                            i7 = C6208R.plurals.sync_header_folders_syncing;
                            function02 = function06;
                            function03 = function07;
                            i4 = i7;
                            i2 = 0;
                            i5 = 0;
                            i6 = i5;
                            i3 = i6;
                            z = i3;
                            str = null;
                        }
                        break;
                    case 5:
                        if (this.syncFailureReason == LibraryRepository.SyncFailureReason.INSUFFICIENT_STORAGE) {
                            i8 = C6208R.string.sync_header_storage_full;
                            int i19 = C6208R.string.sync_header_storage_full_details;
                            String cloudProviderName = this.repository.getCloudProviderName();
                            i9 = C6208R.string.sync_header_retry_button;
                            i10 = i19;
                            function04 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LibraryViewModel.updateSyncToolbarUIState$lambda$8(this.f$0);
                                }
                            };
                            str2 = cloudProviderName;
                        } else {
                            i8 = C6208R.string.sync_header_sync_failed;
                            int i20 = C6208R.string.sync_header_retry_button;
                            function04 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LibraryViewModel.updateSyncToolbarUIState$lambda$9(this.f$0);
                                }
                            };
                            i9 = i20;
                            str2 = null;
                            function07 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LibraryViewModel.updateSyncToolbarUIState$lambda$10(this.f$0);
                                }
                            };
                            i10 = 0;
                        }
                        i2 = i8;
                        function03 = function07;
                        function02 = function04;
                        z = 1;
                        i4 = 0;
                        i6 = 0;
                        i5 = i10;
                        i3 = i9;
                        str = str2;
                        break;
                    case 6:
                        int i21 = C6208R.string.sync_header_uptodate;
                        i11 = C6208R.drawable.ic_cloud_check_outline;
                        function02 = function06;
                        i2 = i21;
                        function03 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LibraryViewModel.updateSyncToolbarUIState$lambda$11(this.f$0);
                            }
                        };
                        i4 = 0;
                        i5 = 0;
                        i3 = 0;
                        z = 0;
                        str = null;
                        i6 = i11;
                        break;
                    case 7:
                        i12 = C6208R.string.sync_header_outdated;
                        i11 = C6208R.drawable.ic_cloud_disabled_outline;
                        break;
                    case 8:
                        i13 = C6208R.string.sync_header_unsigned;
                        i14 = C6208R.string.sync_header_enable;
                        function05 = new Function0() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LibraryViewModel.updateSyncToolbarUIState$lambda$12(this.f$0);
                            }
                        };
                        break;
                    default:
                        function02 = function06;
                        function03 = function07;
                        i2 = 0;
                        i4 = 0;
                        i5 = i4;
                        i6 = i5;
                        i3 = i6;
                        z = i3;
                        str = null;
                        break;
                }
                switch (WhenMappings.$EnumSwitchMapping$0[this.syncState.ordinal()]) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        z2 = true;
                        break;
                    case 3:
                        z2 = isAutoSyncEnabled;
                        break;
                    case 6:
                    default:
                        z2 = false;
                        break;
                }
                z3 = this.repository.getHasCloudProvider() && (value2 instanceof NeboNetworkState.Connected) && ((NeboNetworkState.Connected) value2).isEnabled();
                boolean z5 = z3 && isAutoSyncEnabled;
                boolean z6 = this.syncState == DMSSyncState.UP_TO_DATE && this.lastSyncStartTime != -1;
                if (!z3 || (ongoingProgress = this.syncToolbarProgress) == null) {
                    z4 = false;
                } else {
                    int max = ongoingProgress.getMax();
                    int progress = ongoingProgress.getProgress();
                    if (1 <= progress && progress < max) {
                        z4 = true;
                    }
                }
                boolean z7 = this.userProfileManager.hasFeatureAccess(Feature.CloudSync) && (!z5 || z6 || z2 || !z3) && Intrinsics.areEqual((Object) isSearchActive().getValue(), (Object) false);
                boolean z8 = z7 && this.syncState == DMSSyncState.UP_TO_DATE;
                job = this.collapseToolbarJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.collapseToolbarJob = null;
                MutableLiveData<SyncToolbarUIState> mutableLiveData = this._syncToolbarUIState;
                boolean zAreEqual = Intrinsics.areEqual((Object) isSearchActive().getValue(), (Object) false);
                long j = this.lastSyncStartTime;
                long jCoerceAtLeast = j != -1 ? RangesKt.coerceAtLeast(j, 0L) : -1L;
                int i22 = this.syncStateNotebookCount;
                OngoingProgress ongoingProgress2 = this.syncToolbarProgress;
                mutableLiveData.setValue(new SyncToolbarUIState(z7, zAreEqual, z8, jCoerceAtLeast, i2, i4, i5, str, i22, i6, i3, function02, function03, z4, ongoingProgress2 != null ? OngoingProgress.copy$default(ongoingProgress2, 0, 0, 3, null) : null, z));
                value = this._syncToolbarUIState.getValue();
                if (value != null) {
                    if (!value.isVisible() || !value.getHideAfterDelay() || value.getSyncStartTime() == -1) {
                        value = null;
                    }
                    if (value != null) {
                        this.collapseToolbarJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.workDispatcher, null, new LibraryViewModel$updateSyncToolbarUIState$13$1(this, null), 2, null);
                        return;
                    }
                    return;
                }
                return;
            }
            function02 = function06;
            function03 = function07;
            i2 = i12;
            i4 = 0;
            i5 = 0;
            i3 = 0;
            z = 0;
            str = null;
            i6 = i11;
            switch (WhenMappings.$EnumSwitchMapping$0[this.syncState.ordinal()]) {
            }
            if (this.repository.getHasCloudProvider()) {
            }
            if (z3) {
            }
            if (this.syncState == DMSSyncState.UP_TO_DATE) {
            }
            if (z3) {
                z4 = false;
            }
            if (this.userProfileManager.hasFeatureAccess(Feature.CloudSync)) {
            }
            if (z7) {
            }
            job = this.collapseToolbarJob;
            if (job != null) {
            }
            this.collapseToolbarJob = null;
            MutableLiveData<SyncToolbarUIState> mutableLiveData2 = this._syncToolbarUIState;
            boolean zAreEqual2 = Intrinsics.areEqual((Object) isSearchActive().getValue(), (Object) false);
            long j2 = this.lastSyncStartTime;
            if (j2 != -1) {
            }
            int i222 = this.syncStateNotebookCount;
            OngoingProgress ongoingProgress22 = this.syncToolbarProgress;
            mutableLiveData2.setValue(new SyncToolbarUIState(z7, zAreEqual2, z8, jCoerceAtLeast, i2, i4, i5, str, i222, i6, i3, function02, function03, z4, ongoingProgress22 != null ? OngoingProgress.copy$default(ongoingProgress22, 0, 0, 3, null) : null, z));
            value = this._syncToolbarUIState.getValue();
            if (value != null) {
            }
        }
        i2 = i13;
        function03 = function07;
        i3 = i14;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        z = 0;
        str = null;
        function02 = function05;
        switch (WhenMappings.$EnumSwitchMapping$0[this.syncState.ordinal()]) {
        }
        if (this.repository.getHasCloudProvider()) {
        }
        if (z3) {
        }
        if (this.syncState == DMSSyncState.UP_TO_DATE) {
        }
        if (z3) {
        }
        if (this.userProfileManager.hasFeatureAccess(Feature.CloudSync)) {
        }
        if (z7) {
        }
        job = this.collapseToolbarJob;
        if (job != null) {
        }
        this.collapseToolbarJob = null;
        MutableLiveData<SyncToolbarUIState> mutableLiveData22 = this._syncToolbarUIState;
        boolean zAreEqual22 = Intrinsics.areEqual((Object) isSearchActive().getValue(), (Object) false);
        long j22 = this.lastSyncStartTime;
        if (j22 != -1) {
        }
        int i2222 = this.syncStateNotebookCount;
        OngoingProgress ongoingProgress222 = this.syncToolbarProgress;
        mutableLiveData22.setValue(new SyncToolbarUIState(z7, zAreEqual22, z8, jCoerceAtLeast, i2, i4, i5, str, i2222, i6, i3, function02, function03, z4, ongoingProgress222 != null ? OngoingProgress.copy$default(ongoingProgress222, 0, 0, 3, null) : null, z));
        value = this._syncToolbarUIState.getValue();
        if (value != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$2(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onConnect();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$3(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onEnableCellular();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$4(LibraryViewModel libraryViewModel) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), null, null, new LibraryViewModel$updateSyncToolbarUIState$3$1(libraryViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$5(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onSyncTextClicked();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$6(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onSync();
        }
        libraryViewModel.discover(GridDiscoverableFeature.SyncButtonFeature.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$7(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onSyncTextClicked();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$8(LibraryViewModel libraryViewModel) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), null, null, new LibraryViewModel$updateSyncToolbarUIState$7$1(libraryViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$9(LibraryViewModel libraryViewModel) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(libraryViewModel), null, null, new LibraryViewModel$updateSyncToolbarUIState$8$1(libraryViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$10(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onSyncTextClicked();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$11(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onSyncTextClicked();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSyncToolbarUIState$lambda$12(LibraryViewModel libraryViewModel) {
        Iterator<T> it = libraryViewModel.syncCallbacks.iterator();
        while (it.hasNext()) {
            ((SyncCallback) it.next()).onConnect();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.networkStateRepository.getNeboNetworkState().removeObserver(this.onNetworkUpdate);
        this.repository.removeModelChangedListener(this.onLibraryUpdate);
        this.repository.removeSyncListener(this.onSyncUpdate);
        this.repository.getSearchController().removeDMSSearchListener(this.onSearchUpdate);
        this.repository.removeCloudTokenExpirationListener(this.onCloudExpired);
        this.userProfileManager.removeFeatureAccessListener(this.onFeatureAccessChanged);
        this.syncCallbacks.clear();
        super.onCleared();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$discover$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$discover$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {691}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {692}, m1615s = {}, m1616v = 2)
    static final class C62381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62381(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C62381> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62381(this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = LibraryViewModel.this.discoverabilityManager;
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C62381(feature, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$dismissCurrentTooltip$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$dismissCurrentTooltip$1", m1609f = "LibraryViewModel.kt", m1610i = {0, 0, 0, 0}, m1611l = {699}, m1612m = "invokeSuspend", m1613n = {"tooltip", "state", "$i$a$-let-LibraryViewModel$dismissCurrentTooltip$1$1", "$i$a$-let-LibraryViewModel$dismissCurrentTooltip$1$1$1"}, m1614nl = {700}, m1615s = {"L$0", "L$1", "I$0", "I$1"}, m1616v = 2)
    static final class C62391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        C62391(Continuation<? super C62391> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DiscoverabilityManager discoverabilityManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TooltipUIState tooltipUIState = (TooltipUIState) LibraryViewModel.this._discoveryTooltip.getValue();
                if (tooltipUIState != null) {
                    LibraryViewModel libraryViewModel = LibraryViewModel.this;
                    IDiscoverableFeature iDiscoverableFeatureFromTooltipState = GridDiscoverableFeature.INSTANCE.fromTooltipState(tooltipUIState);
                    if (iDiscoverableFeatureFromTooltipState != null && (discoverabilityManager = libraryViewModel.discoverabilityManager) != null) {
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C62391(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$setCurrentTooltipVisible$1 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$setCurrentTooltipVisible$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62431(boolean z, Continuation<? super C62431> continuation) {
            super(2, continuation);
            this.$visible = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62431(this.$visible, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = LibraryViewModel.this._discoveryTooltip;
                TooltipUIState tooltipUIState = (TooltipUIState) LibraryViewModel.this._discoveryTooltip.getValue();
                mutableLiveData.setValue(tooltipUIState != null ? TooltipUIState.copy$default(tooltipUIState, 0, 0, null, 0, null, this.$visible, null, null, 223, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setCurrentTooltipVisible(boolean visible) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C62431(visible, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: collapseToolbar-VtjQ1oo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12967collapseToolbarVtjQ1oo(long j, Continuation<? super Unit> continuation) {
        LibraryViewModel$collapseToolbar$1 libraryViewModel$collapseToolbar$1;
        if (continuation instanceof LibraryViewModel$collapseToolbar$1) {
            libraryViewModel$collapseToolbar$1 = (LibraryViewModel$collapseToolbar$1) continuation;
            if ((libraryViewModel$collapseToolbar$1.label & Integer.MIN_VALUE) != 0) {
                libraryViewModel$collapseToolbar$1.label -= Integer.MIN_VALUE;
            } else {
                libraryViewModel$collapseToolbar$1 = new LibraryViewModel$collapseToolbar$1(this, continuation);
            }
        }
        Object obj = libraryViewModel$collapseToolbar$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryViewModel$collapseToolbar$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            libraryViewModel$collapseToolbar$1.J$0 = j;
            libraryViewModel$collapseToolbar$1.label = 1;
            if (DelayKt.m16008delayVtjQ1oo(j, libraryViewModel$collapseToolbar$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = libraryViewModel$collapseToolbar$1.J$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        j = libraryViewModel$collapseToolbar$1.J$0;
        ResultKt.throwOnFailure(obj);
        CoroutineContext coroutineContext = this.mainDispatcher;
        LibraryViewModel$collapseToolbar$2 libraryViewModel$collapseToolbar$2 = new LibraryViewModel$collapseToolbar$2(this, null);
        libraryViewModel$collapseToolbar$1.J$0 = j;
        libraryViewModel$collapseToolbar$1.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.LibraryViewModel$3 */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$3", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {728}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA7_3_3}, m1615s = {}, m1616v = 2)
    static final class C62363 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62363(Continuation<? super C62363> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryViewModel.this.new C62363(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62363) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StateFlow<IDiscoverableFeature> nextDiscovery;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = LibraryViewModel.this.discoverabilityManager;
                if (discoverabilityManager == null || (nextDiscovery = discoverabilityManager.getNextDiscovery()) == null) {
                    return Unit.INSTANCE;
                }
                final LibraryViewModel libraryViewModel = LibraryViewModel.this;
                this.label = 1;
                if (nextDiscovery.collect(new FlowCollector() { // from class: com.myscript.nebo.dms.core.LibraryViewModel.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((IDiscoverableFeature) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) {
                        TooltipUIState tooltipUIState;
                        MutableLiveData mutableLiveData = libraryViewModel._discoveryTooltip;
                        TooltipUIState tooltipUIState2 = null;
                        if (iDiscoverableFeature != null && (tooltipUIState = (TooltipUIState) libraryViewModel.featureTooltipUIState.invoke(iDiscoverableFeature)) != null) {
                            Object userData = tooltipUIState.getUserData();
                            if ((userData instanceof GridDiscoverableFeature.DiscoverableFeatureDestination ? (GridDiscoverableFeature.DiscoverableFeatureDestination) userData : null) == GridDiscoverableFeature.DiscoverableFeatureDestination.DMS_LIST_FRAGMENT) {
                                tooltipUIState2 = tooltipUIState;
                            }
                        }
                        mutableLiveData.setValue(tooltipUIState2);
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
            throw new KotlinNothingValueException();
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        HIDE_SYNC_PROGRESS_TOOLBAR_AFTER_DELAY = DurationKt.toDuration(2000, DurationUnit.MILLISECONDS);
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function1() { // from class: com.myscript.nebo.dms.core.LibraryViewModel$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LibraryViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new LibraryViewModel(((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository(), ((IAutoSyncTimerManager.Provider) componentCallbacks2RequireApplication).provideAutoSyncTimerManager(), ((NeboNetworkStateRepositoryProvider) componentCallbacks2RequireApplication).provideNeboNetworkStateRepository(), ((UserProfileManager.Provider) componentCallbacks2RequireApplication).provideUserProfileManager(), ((DiscoverabilityManager.Provider) componentCallbacks2RequireApplication).provideGridDiscoverabilityManager(), ((TooltipUIState.Provider) componentCallbacks2RequireApplication).provideFeatureToTooltipState(), null, null, null, 448, null);
    }
}
