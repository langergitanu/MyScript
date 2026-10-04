package com.myscript.nebo.grid;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.core.INeboFileImporter;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.NeboFileImporter;
import com.myscript.nebo.dms.core.PageManager;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.nebo.dms.util.ImportController;
import com.myscript.nebo.grid.DisplayMode;
import com.myscript.nebo.grid.EmptyState;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.PageState;
import com.myscript.nebo.grid.SearchState;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.purchase.FreePeriodState;
import com.myscript.nebo.purchase.FreePeriodStatus;
import com.myscript.nebo.purchase.FreePeriodType;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.RenewalOfferState;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.storage.AvailableSpaceProvider;
import com.myscript.nebo.storage.AvailableSpaceProviderImpl;
import com.myscript.nebo.storage.StorageState;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b6*\u0004;{\u0080\u0001\b\u0007\u0018\u0000 \u008c\u00022\u00020\u0001:\b\u0089\u0002\u008a\u0002\u008b\u0002\u008c\u0002B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\t\u0010£\u0001\u001a\u00020SH\u0002J\u0011\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010¦\u0001\u001a\u00020>J\b\u0010§\u0001\u001a\u00030¥\u0001J\u0007\u0010¬\u0001\u001a\u00020]J\u0013\u0010\u00ad\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u000206H\u0002J\u0011\u0010¯\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u000206J\b\u0010°\u0001\u001a\u00030¥\u0001JK\u0010±\u0001\u001a\u00030¥\u00012\t\b\u0002\u0010²\u0001\u001a\u00020]2\u000b\b\u0002\u0010³\u0001\u001a\u0004\u0018\u00010\u001c2!\u0010´\u0001\u001a\u001c\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030¥\u00010¶\u0001\u0012\u0007\u0012\u0005\u0018\u00010·\u00010µ\u0001H\u0002¢\u0006\u0003\u0010¸\u0001J\u001b\u0010¹\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u0002062\b\u0010º\u0001\u001a\u00030\u0092\u0001J\u001a\u0010¹\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u0002062\u0007\u0010¦\u0001\u001a\u00020>J \u0010»\u0001\u001a\u00030¥\u00012\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002060+2\u0007\u0010¦\u0001\u001a\u00020>J\u001d\u0010½\u0001\u001a\u00030¥\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010¦\u0001\u001a\u00020>H\u0007J(\u0010À\u0001\u001a\u00030¥\u00012\u000e\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010+2\u000e\u0010Â\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010+J\u001a\u0010Ã\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u0002062\u0007\u0010Ä\u0001\u001a\u00020\u001cJ\u0011\u0010Å\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u000206J\u001b\u0010Å\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u0002062\b\u0010º\u0001\u001a\u00030\u0092\u0001J\u0007\u0010Æ\u0001\u001a\u00020]J\u0018\u0010Ç\u0001\u001a\u00030¥\u00012\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0+H\u0002J\u0018\u0010È\u0001\u001a\u00030¥\u00012\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0+H\u0002J\u0011\u0010É\u0001\u001a\u00030¥\u0001H\u0082@¢\u0006\u0003\u0010Ê\u0001J\u0015\u0010Ë\u0001\u001a\u00030¥\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020]H\u0007J \u0010Í\u0001\u001a\u00030¥\u00012\u0014\u0010Î\u0001\u001a\u000f\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002060µ\u0001H\u0002JL\u0010Ï\u0001\u001a\u00030¥\u00012\u0007\u0010Ð\u0001\u001a\u00020\u001c2\u0007\u0010Ñ\u0001\u001a\u00020\u001c2\u0010\b\u0001\u0010Ò\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010+2\b\u0010Ó\u0001\u001a\u00030Ô\u00012\n\b\u0001\u0010Õ\u0001\u001a\u00030\u0092\u00012\b\u0010Ö\u0001\u001a\u00030×\u0001J0\u0010Ø\u0001\u001a\u00030¥\u00012\u0007\u0010Ð\u0001\u001a\u00020\u001c2\u0007\u0010Ñ\u0001\u001a\u00020\u001c2\n\b\u0001\u0010Õ\u0001\u001a\u00030\u0092\u00012\b\u0010Ö\u0001\u001a\u00030×\u0001J&\u0010Ù\u0001\u001a\u00030¥\u00012\u0007\u0010Ð\u0001\u001a\u00020\u001c2\u0007\u0010Ñ\u0001\u001a\u00020\u001c2\n\b\u0001\u0010Õ\u0001\u001a\u00030\u0092\u0001J\u0017\u0010Ú\u0001\u001a\u00030¥\u00012\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002060+J\u0012\u0010Û\u0001\u001a\u00020]2\u0007\u0010®\u0001\u001a\u000206H\u0002J\u0012\u0010Ü\u0001\u001a\u0004\u0018\u00010e2\u0007\u0010®\u0001\u001a\u000206J\n\u0010Ý\u0001\u001a\u00030¥\u0001H\u0017J\n\u0010Þ\u0001\u001a\u00030¥\u0001H\u0002J\u0010\u0010ß\u0001\u001a\u00020]2\u0007\u0010à\u0001\u001a\u00020\u001cJ\b\u0010á\u0001\u001a\u00030¥\u0001J\n\u0010â\u0001\u001a\u00030¥\u0001H\u0002J\b\u0010ã\u0001\u001a\u00030¥\u0001J\u0015\u0010ä\u0001\u001a\u00030¥\u00012\t\b\u0002\u0010å\u0001\u001a\u00020]H\u0007J\b\u0010æ\u0001\u001a\u00030¥\u0001J\b\u0010ç\u0001\u001a\u00030¥\u0001J\b\u0010è\u0001\u001a\u00030¥\u0001J\u0007\u0010é\u0001\u001a\u00020]J\u0011\u0010ê\u0001\u001a\u00030¥\u00012\u0007\u0010ë\u0001\u001a\u00020]J$\u0010ì\u0001\u001a\u00030¥\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u001c2\u0007\u0010í\u0001\u001a\u00020>J\b\u0010î\u0001\u001a\u00030¥\u0001J\b\u0010ï\u0001\u001a\u00030¥\u0001J\u0011\u0010ð\u0001\u001a\u00030¥\u00012\u0007\u0010®\u0001\u001a\u000206J\u001a\u0010ñ\u0001\u001a\u00030¥\u00012\u0007\u0010ò\u0001\u001a\u00020]H\u0082@¢\u0006\u0003\u0010ó\u0001J\u0011\u0010ô\u0001\u001a\u00030¥\u00012\u0007\u0010ò\u0001\u001a\u00020]J\u0011\u0010õ\u0001\u001a\u00030¥\u00012\u0007\u0010ö\u0001\u001a\u00020]J\u0011\u0010÷\u0001\u001a\u00030¥\u00012\u0007\u0010ø\u0001\u001a\u00020]J\u0011\u0010ù\u0001\u001a\u00030¥\u00012\u0007\u0010ú\u0001\u001a\u00020eJ\u0012\u0010û\u0001\u001a\u00030¥\u00012\b\u0010ü\u0001\u001a\u00030\u0099\u0001J\u0012\u0010ý\u0001\u001a\u00030¥\u00012\b\u0010þ\u0001\u001a\u00030\u009b\u0001J\b\u0010ÿ\u0001\u001a\u00030¥\u0001J\u0014\u0010\u0080\u0002\u001a\u00030¥\u00012\b\u0010ü\u0001\u001a\u00030\u0099\u0001H\u0002J\n\u0010\u0081\u0002\u001a\u00030\u0099\u0001H\u0002J\u0014\u0010\u0082\u0002\u001a\u00030¥\u00012\b\u0010þ\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010\u0083\u0002\u001a\u00030\u009b\u00012\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u0012\u0010\u0084\u0002\u001a\u00020]2\u0007\u0010®\u0001\u001a\u000206H\u0002J\b\u0010\u0085\u0002\u001a\u00030¥\u0001J\t\u0010\u0086\u0002\u001a\u00020\rH\u0002J\b\u0010\u0087\u0002\u001a\u00030¥\u0001J\b\u0010\u0088\u0002\u001a\u00030¥\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0+0'8F¢\u0006\u0006\u001a\u0004\b,\u0010)R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00104\u001a\b\u0012\u0004\u0012\u000206058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u00101\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R*\u0010?\u001a\u0004\u0018\u00010>2\b\u0010=\u001a\u0004\u0018\u00010>8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b@\u00101\u001a\u0004\bA\u0010BR\u0016\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060'8F¢\u0006\u0006\u001a\u0004\bE\u0010)R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020J0I¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0017\u0010M\u001a\b\u0012\u0004\u0012\u0002060I¢\u0006\b\n\u0000\u001a\u0004\bN\u0010LR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020P0I¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010LR\u001c\u0010R\u001a\u0010\u0012\f\u0012\n T*\u0004\u0018\u00010S0S0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020S0'8F¢\u0006\u0006\u001a\u0004\bV\u0010)R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020X0I¢\u0006\b\n\u0000\u001a\u0004\bY\u0010LR\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\\\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\b\\\u0010^R\u000e\u0010_\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010`\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\b`\u0010^R\u0014\u0010a\u001a\u00020]8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010^R\u0013\u0010b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\bc\u0010dR2\u0010f\u001a\b\u0012\u0004\u0012\u00020e0+2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020e0+8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bg\u00101\u001a\u0004\bh\u00103R\u0011\u0010i\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\bi\u0010^R\u0014\u0010j\u001a\u00020]8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010^R\u001e\u0010l\u001a\u00020]2\u0006\u0010=\u001a\u00020]@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010^R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u0002060+8F¢\u0006\u0006\u001a\u0004\bo\u00103R*\u0010p\u001a\b\u0012\u0004\u0012\u00020e0.2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020e0.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u00103R\u001e\u0010r\u001a\u00020]2\u0006\u0010=\u001a\u00020]@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\br\u0010^R\u001e\u0010s\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bt\u0010uR\u0014\u0010v\u001a\b\u0012\u0004\u0012\u00020w0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010x\u001a\b\u0012\u0004\u0012\u00020w0'8F¢\u0006\u0006\u001a\u0004\by\u0010)R\u0010\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0004\n\u0002\u0010|R\u000e\u0010}\u001a\u00020~X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u007f\u001a\u00030\u0080\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0081\u0001R\u0016\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010'8F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010)R\u0016\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010'8F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010)R \u0010\u008a\u0001\u001a\u00020]2\u0006\u0010=\u001a\u00020]@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010^R\u000f\u0010\u008b\u0001\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u008c\u0001\u001a\u0012\u0012\u000e\u0012\f T*\u0005\u0018\u00010\u008d\u00010\u008d\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010'8F¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010)R\u001e\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u0001X\u0082\u0004¢\u0006\t\n\u0000\u0012\u0005\b\u0093\u0001\u00101R\u0019\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020]0I¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010LR\u0019\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020]0I¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010LR\u0010\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u009d\u0001\u001a\u00020]8F¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010^R\u0010\u0010\u009f\u0001\u001a\u00030 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¡\u0001\u001a\u00030¢\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010¨\u0001\u001a\u00020]8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010^R\u0016\u0010ª\u0001\u001a\u00020]8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010^¨\u0006\u008d\u0002"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel;", "Landroidx/lifecycle/ViewModel;", "pageRepository", "Lcom/myscript/nebo/dms/core/PageManager;", "availableSpaceProvider", "Lcom/myscript/nebo/storage/AvailableSpaceProvider;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "defaultDisplayMode", "Lcom/myscript/nebo/grid/DisplayMode;", "sharedPreferences", "Landroid/content/SharedPreferences;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "pdfImporter", "Lcom/myscript/nebo/grid/IPdfImporter;", "neboFileImporter", "Lcom/myscript/nebo/dms/core/INeboFileImporter;", "searchController", "Lcom/myscript/nebo/dms/search/DMSSearchController;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "languageProvider", "Lkotlin/Function0;", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "workDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/PageManager;Lcom/myscript/nebo/storage/AvailableSpaceProvider;Lcom/myscript/nebo/account/UserProfileManager;Lcom/myscript/nebo/purchase/ISubscriptionRepository;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/grid/DisplayMode;Landroid/content/SharedPreferences;Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/grid/IPdfImporter;Lcom/myscript/nebo/dms/core/INeboFileImporter;Lcom/myscript/nebo/dms/search/DMSSearchController;Lcom/myscript/nebo/log/TechnicalLogger;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_searchGridState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/grid/SearchGridState;", "searchGridState", "Landroidx/lifecycle/LiveData;", "getSearchGridState", "()Landroidx/lifecycle/LiveData;", "history", "", "getHistory", "searchHits", "", "Lcom/myscript/nebo/grid/SearchHit;", "getSearchHits$annotations", "()V", "getSearchHits", "()Ljava/util/List;", "titleMatchedKeys", "", "Lcom/myscript/snt/core/PageKey;", "getTitleMatchedKeys$annotations", "getTitleMatchedKeys", "()Ljava/util/Set;", "onSearchUpdate", "com/myscript/nebo/grid/GridViewModel$onSearchUpdate$1", "Lcom/myscript/nebo/grid/GridViewModel$onSearchUpdate$1;", "value", "Lcom/myscript/snt/core/NotebookKey;", "openedNotebookKey", "getOpenedNotebookKey$annotations", "getOpenedNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "_openPageKey", "openPageKey", "getOpenPageKey", "pageState", "Lcom/myscript/nebo/grid/PageState;", "openPageEvent", "Lcom/myscript/android/utils/SingleLiveEvent;", "Lcom/myscript/nebo/grid/GridViewModel$OpenPageEvent;", "getOpenPageEvent", "()Lcom/myscript/android/utils/SingleLiveEvent;", "scrollToPageEvent", "getScrollToPageEvent", "tooRecentNoteEvent", "Ljava/lang/Void;", "getTooRecentNoteEvent", "_folderUIState", "Lcom/myscript/nebo/grid/FolderUIState;", "kotlin.jvm.PlatformType", "folderUIState", "getFolderUIState", "missingLanguageEvent", "Lcom/myscript/nebo/grid/GridViewModel$MissingLanguageEvent;", "getMissingLanguageEvent", "folderState", "Lcom/myscript/nebo/grid/FolderState;", "isFolderLoaded", "", "()Z", "folderName", "isSearchModeActive", "isSearchProcessing", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "Lcom/myscript/nebo/dms/core/model/PageModel;", "pages", "getPages$annotations", "getPages", "isEmpty", "hasCorrupted", "getHasCorrupted", "canExport", "getCanExport", "selectedPageKeys", "getSelectedPageKeys", "selectedPages", "getSelectedPages", "isSelectionMode", "currentDisplayMode", "setCurrentDisplayMode", "(Lcom/myscript/nebo/grid/DisplayMode;)V", "_searchState", "Lcom/myscript/nebo/grid/SearchState;", "searchState", "getSearchState", "folderListener", "com/myscript/nebo/grid/GridViewModel$folderListener$1", "Lcom/myscript/nebo/grid/GridViewModel$folderListener$1;", "paidUserStatusListener", "Lcom/myscript/nebo/account/FeatureAccessListener;", "pageListener", "com/myscript/nebo/grid/GridViewModel$pageListener$1", "Lcom/myscript/nebo/grid/GridViewModel$pageListener$1;", "_storageState", "Lcom/myscript/nebo/storage/StorageState;", "storageState", "getStorageState", "_importState", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "importState", "getImportState", "isBeingModified", "isViewAvailable", "_gridBannerState", "Lcom/myscript/nebo/grid/GridBannerState;", "gridBannerState", "getGridBannerState", "renewalOfferBannerHours", "Lkotlinx/coroutines/flow/Flow;", "", "getRenewalOfferBannerHours$annotations", "showPaywallEvent", "getShowPaywallEvent", "showSignIn", "getShowSignIn", "sorting", "Lcom/myscript/nebo/grid/Sort;", "ordering", "Lcom/myscript/nebo/grid/Order;", "isSortMenuOpen", "allowDraggingPages", "getAllowDraggingPages", "thumbnailListener", "Lcom/myscript/snt/core/IThumbnailerNotificationListener;", "preferencesChangedListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "computeFolderUIState", "openFolder", "", "notebookKey", "closeFolder", "canModify", "getCanModify", "canOpenPage", "getCanOpenPage", "isPageOpened", "updateOpenPageKey", "pageKey", "openPage", "closePage", "editNotebook", "showAsUpdating", "analyticsOriginEvent", "editLogic", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "movePage", "newPosition", "movePages", "pageKeys", "importNeboFile", "requestedUri", "Landroid/net/Uri;", "importDocuments", "nebos", "pdfs", "updatePageTitle", "title", "duplicatePage", "hasNotebookOpen", "bindPageListeners", "unbindPageListeners", "updatePages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadFolder", "firstLoad", "addNote", "logic", "addNotebook", "name", "lang", "coverColors", "paperSize", "Lcom/myscript/snt/core/PaperSize;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "addBoard", "addDocument", "moveToTrash", "isPageInNotebook", "getPage", "onCleared", "filter", FirebaseAnalytics.Event.SEARCH, "label", "stopSearch", "updateSearchHits", "openSearch", "closeSearch", "forceCompleteClose", "clearResults", "clearHistory", "refreshStorageState", "hasStoragePopupBeenShown", "setStoragePopupSeen", "hasBeenSeen", "importAsPdf", "targetNotebookKey", "selectAll", "deselectAll", "togglePageSelection", "activatePagesSelectionModeInternal", RemoteConfigComponent.ACTIVATE_FILE_NAME, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activatePagesSelectionMode", "setIsBeingModified", "modified", "setViewAvailable", "available", "requestThumbnail", "pageModel", "setSorting", "sort", "setSortingOrder", "order", "toggleSortMenu", "setPreferredSort", "getPreferredSort", "setPreferredOrder", "getPreferredOrder", "isLanguageAvailable", "toggleNotesDisplayMode", "getPreferredDisplayMode", "installedLanguagesUpdated", "onBannerActionButtonClicked", "OpenPageEvent", "MissingLanguageEvent", "ImportStateUI", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridViewModel extends ViewModel {
    public static final ViewModelProvider.Factory Factory;
    private static final String PREF_ALPHABETICAL_SORT_ORDER_KEY = "PREF_ALPHABETICAL_SORT_ORDER_KEY";
    private static final String PREF_CREATION_SORT_ORDER_KEY = "PREF_CREATION_SORT_ORDER_KEY";
    private static final String PREF_MODIFICATION_SORT_ORDER_KEY = "PREF_MODIFICATION_SORT_ORDER_KEY";
    private static final String PREF_SORT_KEY = "PREF_SORT_KEY";
    private static boolean hasStoragePopupBeenShown;
    private final MutableLiveData<FolderUIState> _folderUIState;
    private final MutableLiveData<GridBannerState> _gridBannerState;
    private final MutableLiveData<ImportStateUI> _importState;
    private final MutableLiveData<PageKey> _openPageKey;
    private final MutableLiveData<SearchGridState> _searchGridState;
    private final MutableLiveData<SearchState> _searchState;
    private final MutableLiveData<StorageState> _storageState;
    private final AvailableSpaceProvider availableSpaceProvider;
    private boolean canExport;
    private DisplayMode currentDisplayMode;
    private final DisplayMode defaultDisplayMode;
    private final GridViewModel$folderListener$1 folderListener;
    private String folderName;
    private FolderState folderState;
    private final CoroutineDispatcher ioDispatcher;
    private boolean isBeingModified;
    private boolean isSelectionMode;
    private boolean isSortMenuOpen;
    private boolean isViewAvailable;
    private final Function0<String> languageProvider;
    private final TechnicalLogger logger;
    private final CoroutineDispatcher mainDispatcher;
    private final SingleLiveEvent<MissingLanguageEvent> missingLanguageEvent;
    private final INeboFileImporter neboFileImporter;
    private final NeboNetworkStateRepository networkStateRepository;
    private final GridViewModel$onSearchUpdate$1 onSearchUpdate;
    private final SingleLiveEvent<OpenPageEvent> openPageEvent;
    private NotebookKey openedNotebookKey;
    private Order ordering;
    private final GridViewModel$pageListener$1 pageListener;
    private final PageManager pageRepository;
    private PageState pageState;
    private List<PageModel> pages;
    private final FeatureAccessListener paidUserStatusListener;
    private final IPdfImporter pdfImporter;
    private final SharedPreferences.OnSharedPreferenceChangeListener preferencesChangedListener;
    private final Flow<Integer> renewalOfferBannerHours;
    private final SingleLiveEvent<PageKey> scrollToPageEvent;
    private final DMSSearchController searchController;
    private final List<SearchHit> searchHits;
    private List<PageModel> selectedPages;
    private final SharedPreferences sharedPreferences;
    private final SingleLiveEvent<Boolean> showPaywallEvent;
    private final SingleLiveEvent<Boolean> showSignIn;
    private Sort sorting;
    private final ISubscriptionRepository subscriptionRepository;
    private final IThumbnailerNotificationListener thumbnailListener;
    private final Set<PageKey> titleMatchedKeys;
    private final SingleLiveEvent<Void> tooRecentNoteEvent;
    private final UserData userData;
    private final UserProfileManager userProfileManager;
    private final CoroutineDispatcher workDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Sort.values().length];
            try {
                iArr[Sort.CreationDate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Sort.ModificationDate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Sort.Alphabetical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Sort.Manual.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$updatePages$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel", m1609f = "GridViewModel.kt", m1610i = {0, 0}, m1611l = {1011}, m1612m = "updatePages", m1613n = {"notebookKey", "$i$a$-let-GridViewModel$updatePages$2"}, m1614nl = {1021}, m1615s = {"L$0", "I$0"}, m1616v = 2)
    static final class C65251 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C65251(Continuation<? super C65251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GridViewModel.this.updatePages(this);
        }
    }

    @Deprecated(message = "Notebook properties should be accessed by observing `notebookState`")
    public static /* synthetic */ void getOpenedNotebookKey$annotations() {
    }

    public static /* synthetic */ void getPages$annotations() {
    }

    private static /* synthetic */ void getRenewalOfferBannerHours$annotations() {
    }

    public static /* synthetic */ void getSearchHits$annotations() {
    }

    public static /* synthetic */ void getTitleMatchedKeys$annotations() {
    }

    public final void closeSearch() {
        closeSearch$default(this, false, 1, null);
    }

    public final void reloadFolder() {
        reloadFolder$default(this, false, 1, null);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.myscript.nebo.grid.GridViewModel$onSearchUpdate$1] */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.myscript.nebo.grid.GridViewModel$folderListener$1] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.myscript.nebo.grid.GridViewModel$pageListener$1] */
    public GridViewModel(PageManager pageRepository, AvailableSpaceProvider availableSpaceProvider, UserProfileManager userProfileManager, ISubscriptionRepository subscriptionRepository, NeboNetworkStateRepository networkStateRepository, DisplayMode defaultDisplayMode, SharedPreferences sharedPreferences, UserData userData, IPdfImporter iPdfImporter, INeboFileImporter iNeboFileImporter, DMSSearchController dMSSearchController, TechnicalLogger technicalLogger, Function0<String> languageProvider, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(pageRepository, "pageRepository");
        Intrinsics.checkNotNullParameter(availableSpaceProvider, "availableSpaceProvider");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(defaultDisplayMode, "defaultDisplayMode");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(languageProvider, "languageProvider");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.pageRepository = pageRepository;
        this.availableSpaceProvider = availableSpaceProvider;
        this.userProfileManager = userProfileManager;
        this.subscriptionRepository = subscriptionRepository;
        this.networkStateRepository = networkStateRepository;
        this.defaultDisplayMode = defaultDisplayMode;
        this.sharedPreferences = sharedPreferences;
        this.userData = userData;
        this.pdfImporter = iPdfImporter;
        this.neboFileImporter = iNeboFileImporter;
        this.searchController = dMSSearchController;
        this.logger = technicalLogger;
        this.languageProvider = languageProvider;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.workDispatcher = workDispatcher;
        this._searchGridState = new MutableLiveData<>(null);
        this.searchHits = new ArrayList();
        this.titleMatchedKeys = new LinkedHashSet();
        ?? r2 = new DMSSearchController.IGridSearch() { // from class: com.myscript.nebo.grid.GridViewModel$onSearchUpdate$1
            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStarted(String rootPath) {
                Intrinsics.checkNotNullParameter(rootPath, "rootPath");
                this.this$0.updateSearchHits();
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEnded(int hitCount) {
                this.this$0.updateSearchHits();
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedPage(PageKey pageKey, int hitCount) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                if (hitCount > 0) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$onSearchUpdate$1$onSearchEndedPage$1(this.this$0, pageKey, hitCount, null), 2, null);
                }
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStartedFolder(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1(this.this$0, notebookKey, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedFolder(NotebookKey notebookKey, int hitCount) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$onSearchUpdate$1$onSearchEndedFolder$1(this.this$0, notebookKey, hitCount, null), 2, null);
                this.this$0.updateSearchHits();
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchInterrupted() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$onSearchUpdate$1$onSearchInterrupted$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onTitleMatch(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$onSearchUpdate$1$onTitleMatch$1(this.this$0, pageKey, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onClearResults() {
                this.this$0._searchGridState.postValue(null);
                this.this$0.getSearchHits().clear();
                this.this$0.getTitleMatchedKeys().clear();
            }
        };
        this.onSearchUpdate = r2;
        this._openPageKey = new MutableLiveData<>();
        this.pageState = PageState.Idle.INSTANCE;
        this.openPageEvent = new SingleLiveEvent<>();
        this.scrollToPageEvent = new SingleLiveEvent<>();
        this.tooRecentNoteEvent = new SingleLiveEvent<>();
        this._folderUIState = new MutableLiveData<>(new FolderUIState(null, null, null, false, false, false, null, null, null, false, null, null, 4095, null));
        this.missingLanguageEvent = new SingleLiveEvent<>();
        this.folderState = FolderState.Unloaded;
        this.folderName = "";
        this.pages = CollectionsKt.emptyList();
        this.selectedPages = new ArrayList();
        this.currentDisplayMode = DisplayMode.Grid.INSTANCE;
        this._searchState = new MutableLiveData<>();
        this.folderListener = new LibraryRepository.FolderListener() { // from class: com.myscript.nebo.grid.GridViewModel$folderListener$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.FolderListener
            public void onFolderUpdated(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                GridViewModel.reloadFolder$default(this.this$0, false, 1, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.FolderListener
            public void onFolderDeleted(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                if (Intrinsics.areEqual(notebookKey, this.this$0.getOpenedNotebookKey())) {
                    this.this$0.closeFolder();
                }
            }
        };
        FeatureAccessListener featureAccessListener = new FeatureAccessListener() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda4
            @Override // com.myscript.nebo.account.FeatureAccessListener
            public final void featuresAccessChanged(Map map) {
                GridViewModel.paidUserStatusListener$lambda$0(this.f$0, map);
            }
        };
        this.paidUserStatusListener = featureAccessListener;
        this.pageListener = new LibraryRepository.PageListener() { // from class: com.myscript.nebo.grid.GridViewModel$pageListener$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUpdated(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                GridViewModel.reloadFolder$default(this.this$0, false, 1, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageDeleted(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                GridViewModel.reloadFolder$default(this.this$0, false, 1, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUUIDReset(PageKey previousKey, PageKey newKey) {
                Intrinsics.checkNotNullParameter(previousKey, "previousKey");
                Intrinsics.checkNotNullParameter(newKey, "newKey");
                if (Intrinsics.areEqual(this.this$0._openPageKey.getValue(), previousKey)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new GridViewModel$pageListener$1$onPageUUIDReset$1(this.this$0, newKey, null), 2, null);
                }
            }
        };
        this._storageState = new MutableLiveData<>(new StorageState.Good(0L, 1, null));
        this._importState = new MutableLiveData<>(ImportStateUI.Idle.INSTANCE);
        this.isViewAvailable = true;
        this._gridBannerState = new MutableLiveData<>(new GridBannerState(false, null, false, 0, 0, 31, null));
        final StateFlow<RenewalOfferState> renewalOfferState = subscriptionRepository.getRenewalOfferState();
        this.renewalOfferBannerHours = FlowKt.transformLatest(new Flow<RenewalOfferState>() { // from class: com.myscript.nebo.grid.GridViewModel$special$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super RenewalOfferState> flowCollector, Continuation continuation) {
                Object objCollect = renewalOfferState.collect(new C65172(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$special$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final class C65172<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$special$$inlined$map$1$2", m1609f = "GridViewModel.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {50}, m1612m = "emit", m1613n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m1614nl = {49}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C65172.this.emit(null, this);
                    }
                }

                public C65172(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        RenewalOfferState renewalOfferState = (RenewalOfferState) obj;
                        if (!renewalOfferState.getActive()) {
                            renewalOfferState = null;
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(renewalOfferState, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, new GridViewModel$special$$inlined$flatMapLatest$1(null));
        this.showPaywallEvent = new SingleLiveEvent<>();
        this.showSignIn = new SingleLiveEvent<>();
        this.sorting = Sort.Alphabetical;
        this.ordering = Order.Ascending;
        IThumbnailerNotificationListener iThumbnailerNotificationListener = new IThumbnailerNotificationListener() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda5
            @Override // com.myscript.snt.core.IThumbnailerNotificationListener
            public final void thumbnailCreated(PageKey pageKey, String str, boolean z) {
                GridViewModel.thumbnailListener$lambda$0(this.f$0, pageKey, str, z);
            }
        };
        this.thumbnailListener = iThumbnailerNotificationListener;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda6
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                GridViewModel.preferencesChangedListener$lambda$0(this.f$0, sharedPreferences2, str);
            }
        };
        this.preferencesChangedListener = onSharedPreferenceChangeListener;
        if (dMSSearchController != null) {
            dMSSearchController.addDMSSearchListener((DMSSearchController.IGridSearch) r2);
        }
        GridViewModel gridViewModel = this;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(gridViewModel), mainDispatcher, null, new C64852(null), 2, null);
        refreshStorageState();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(gridViewModel), null, null, new C64863(null), 3, null);
        userProfileManager.addFeatureAccessListener(featureAccessListener);
        pageRepository.addThumbnailListener(iThumbnailerNotificationListener);
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public /* synthetic */ GridViewModel(PageManager pageManager, AvailableSpaceProvider availableSpaceProvider, UserProfileManager userProfileManager, ISubscriptionRepository iSubscriptionRepository, NeboNetworkStateRepository neboNetworkStateRepository, DisplayMode displayMode, SharedPreferences sharedPreferences, UserData userData, IPdfImporter iPdfImporter, INeboFileImporter iNeboFileImporter, DMSSearchController dMSSearchController, TechnicalLogger technicalLogger, Function0 function0, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageManager, availableSpaceProvider, userProfileManager, iSubscriptionRepository, neboNetworkStateRepository, (i & 32) != 0 ? DisplayMode.Grid.INSTANCE : displayMode, sharedPreferences, (i & 128) != 0 ? null : userData, (i & 256) != 0 ? null : iPdfImporter, (i & 512) != 0 ? null : iNeboFileImporter, (i & 1024) != 0 ? null : dMSSearchController, (i & 2048) != 0 ? null : technicalLogger, (i & 4096) != 0 ? new Function0() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GridViewModel._init_$lambda$0();
            }
        } : function0, (i & 8192) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 16384) != 0 ? Dispatchers.getIO() : coroutineDispatcher2, (i & 32768) != 0 ? Dispatchers.getDefault() : coroutineDispatcher3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        return "en_US";
    }

    public final LiveData<SearchGridState> getSearchGridState() {
        return this._searchGridState;
    }

    public final LiveData<List<String>> getHistory() {
        MutableLiveData<List<String>> history;
        DMSSearchController dMSSearchController = this.searchController;
        return (dMSSearchController == null || (history = dMSSearchController.getHistory()) == null) ? new MutableLiveData() : history;
    }

    public final List<SearchHit> getSearchHits() {
        return this.searchHits;
    }

    public final Set<PageKey> getTitleMatchedKeys() {
        return this.titleMatchedKeys;
    }

    public final NotebookKey getOpenedNotebookKey() {
        return this.openedNotebookKey;
    }

    public final LiveData<PageKey> getOpenPageKey() {
        return Transformations.distinctUntilChanged(this._openPageKey);
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$OpenPageEvent;", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "contentType", "", "<init>", "(Lcom/myscript/snt/core/PageKey;Ljava/lang/String;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getContentType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class OpenPageEvent {
        public static final int $stable = 8;
        private final String contentType;
        private final PageKey pageKey;

        public static /* synthetic */ OpenPageEvent copy$default(OpenPageEvent openPageEvent, PageKey pageKey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                pageKey = openPageEvent.pageKey;
            }
            if ((i & 2) != 0) {
                str = openPageEvent.contentType;
            }
            return openPageEvent.copy(pageKey, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageKey getPageKey() {
            return this.pageKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContentType() {
            return this.contentType;
        }

        public final OpenPageEvent copy(PageKey pageKey, String contentType) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return new OpenPageEvent(pageKey, contentType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenPageEvent)) {
                return false;
            }
            OpenPageEvent openPageEvent = (OpenPageEvent) other;
            return Intrinsics.areEqual(this.pageKey, openPageEvent.pageKey) && Intrinsics.areEqual(this.contentType, openPageEvent.contentType);
        }

        public int hashCode() {
            return (this.pageKey.hashCode() * 31) + this.contentType.hashCode();
        }

        public String toString() {
            return "OpenPageEvent(pageKey=" + this.pageKey + ", contentType=" + this.contentType + ")";
        }

        public OpenPageEvent(PageKey pageKey, String contentType) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            this.pageKey = pageKey;
            this.contentType = contentType;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final PageKey getPageKey() {
            return this.pageKey;
        }
    }

    public final SingleLiveEvent<OpenPageEvent> getOpenPageEvent() {
        return this.openPageEvent;
    }

    public final SingleLiveEvent<PageKey> getScrollToPageEvent() {
        return this.scrollToPageEvent;
    }

    public final SingleLiveEvent<Void> getTooRecentNoteEvent() {
        return this.tooRecentNoteEvent;
    }

    public final LiveData<FolderUIState> getFolderUIState() {
        return this._folderUIState;
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$MissingLanguageEvent;", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "languageTag", "", "<init>", "(Lcom/myscript/snt/core/PageKey;Ljava/lang/String;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getLanguageTag", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class MissingLanguageEvent {
        public static final int $stable = 8;
        private final String languageTag;
        private final PageKey pageKey;

        public static /* synthetic */ MissingLanguageEvent copy$default(MissingLanguageEvent missingLanguageEvent, PageKey pageKey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                pageKey = missingLanguageEvent.pageKey;
            }
            if ((i & 2) != 0) {
                str = missingLanguageEvent.languageTag;
            }
            return missingLanguageEvent.copy(pageKey, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageKey getPageKey() {
            return this.pageKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLanguageTag() {
            return this.languageTag;
        }

        public final MissingLanguageEvent copy(PageKey pageKey, String languageTag) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            return new MissingLanguageEvent(pageKey, languageTag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingLanguageEvent)) {
                return false;
            }
            MissingLanguageEvent missingLanguageEvent = (MissingLanguageEvent) other;
            return Intrinsics.areEqual(this.pageKey, missingLanguageEvent.pageKey) && Intrinsics.areEqual(this.languageTag, missingLanguageEvent.languageTag);
        }

        public int hashCode() {
            return (this.pageKey.hashCode() * 31) + this.languageTag.hashCode();
        }

        public String toString() {
            return "MissingLanguageEvent(pageKey=" + this.pageKey + ", languageTag=" + this.languageTag + ")";
        }

        public MissingLanguageEvent(PageKey pageKey, String languageTag) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            this.pageKey = pageKey;
            this.languageTag = languageTag;
        }

        public final String getLanguageTag() {
            return this.languageTag;
        }

        public final PageKey getPageKey() {
            return this.pageKey;
        }
    }

    public final SingleLiveEvent<MissingLanguageEvent> getMissingLanguageEvent() {
        return this.missingLanguageEvent;
    }

    public final boolean isFolderLoaded() {
        FolderUIState value = this._folderUIState.getValue();
        return value != null && value.getFolderState() == FolderState.Loaded && Intrinsics.areEqual(value.getNotebookKey(), this.openedNotebookKey);
    }

    public final boolean isSearchModeActive() {
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            return dMSSearchController.isSearchModeActive();
        }
        return false;
    }

    private final boolean isSearchProcessing() {
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            return dMSSearchController.isSearchProcessing();
        }
        return false;
    }

    public final String getSearchQuery() {
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            return dMSSearchController.getSearchQuery();
        }
        return null;
    }

    public final List<PageModel> getPages() {
        return this.pages;
    }

    public final boolean isEmpty() {
        return this.pages.isEmpty();
    }

    private final boolean getHasCorrupted() {
        List<PageModel> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((PageModel) it.next()).isCorrupted()) {
                return true;
            }
        }
        return false;
    }

    public final boolean getCanExport() {
        return this.canExport;
    }

    public final List<PageKey> getSelectedPageKeys() {
        List<PageModel> list = this.selectedPages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PageModel) it.next()).getPageKey());
        }
        return arrayList;
    }

    public final List<PageModel> getSelectedPages() {
        return this.selectedPages;
    }

    /* JADX INFO: renamed from: isSelectionMode, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentDisplayMode(DisplayMode displayMode) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, displayMode.getName());
        editorEdit.apply();
        this.currentDisplayMode = displayMode;
    }

    public final LiveData<SearchState> getSearchState() {
        return this._searchState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void paidUserStatusListener$lambda$0(GridViewModel gridViewModel, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(gridViewModel), null, null, new GridViewModel$paidUserStatusListener$1$1(gridViewModel, null), 3, null);
    }

    public final LiveData<StorageState> getStorageState() {
        return this._storageState;
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "", "showProgress", "", "<init>", "(Z)V", "getShowProgress", "()Z", "Idle", "Importing", "Success", "Failure", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Idle;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Importing;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Success;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class ImportStateUI {
        public static final int $stable = 0;
        private final boolean showProgress;

        public /* synthetic */ ImportStateUI(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Idle;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Idle extends ImportStateUI {
            public static final int $stable = 0;
            public static final Idle INSTANCE = new Idle();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Idle)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 194969434;
            }

            public String toString() {
                return "Idle";
            }

            private Idle() {
                super(false, 1, null);
            }
        }

        private ImportStateUI(boolean z) {
            this.showProgress = z;
        }

        public /* synthetic */ ImportStateUI(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, null);
        }

        public final boolean getShowProgress() {
            return this.showProgress;
        }

        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Importing;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Importing extends ImportStateUI {
            public static final int $stable = 0;
            public static final Importing INSTANCE = new Importing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Importing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -695383465;
            }

            public String toString() {
                return "Importing";
            }

            private Importing() {
                super(true, null);
            }
        }

        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Success;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Success extends ImportStateUI {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1992815939;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(false, 1, null);
            }
        }

        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "<init>", "()V", "InvalidUri", "TooRecent", "Unknown", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$InvalidUri;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$TooRecent;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$Unknown;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static abstract class Failure extends ImportStateUI {
            public static final int $stable = 0;

            public /* synthetic */ Failure(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: compiled from: GridViewModel.kt */
            @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$InvalidUri;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* data */ class InvalidUri extends Failure {
                public static final int $stable = 0;
                public static final InvalidUri INSTANCE = new InvalidUri();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof InvalidUri)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 1513451519;
                }

                public String toString() {
                    return "InvalidUri";
                }

                private InvalidUri() {
                    super(null);
                }
            }

            private Failure() {
                super(false, 1, null);
            }

            /* JADX INFO: compiled from: GridViewModel.kt */
            @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$TooRecent;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* data */ class TooRecent extends Failure {
                public static final int $stable = 0;
                public static final TooRecent INSTANCE = new TooRecent();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof TooRecent)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 1723568005;
                }

                public String toString() {
                    return "TooRecent";
                }

                private TooRecent() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: GridViewModel.kt */
            @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure$Unknown;", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI$Failure;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* data */ class Unknown extends Failure {
                public static final int $stable = 0;
                public static final Unknown INSTANCE = new Unknown();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Unknown)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -706425728;
                }

                public String toString() {
                    return "Unknown";
                }

                private Unknown() {
                    super(null);
                }
            }
        }
    }

    public final LiveData<ImportStateUI> getImportState() {
        return this._importState;
    }

    /* JADX INFO: renamed from: isBeingModified, reason: from getter */
    public final boolean getIsBeingModified() {
        return this.isBeingModified;
    }

    public final LiveData<GridBannerState> getGridBannerState() {
        return this._gridBannerState;
    }

    public final SingleLiveEvent<Boolean> getShowPaywallEvent() {
        return this.showPaywallEvent;
    }

    public final SingleLiveEvent<Boolean> getShowSignIn() {
        return this.showSignIn;
    }

    public final boolean getAllowDraggingPages() {
        return this.sorting == Sort.Manual;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void thumbnailListener$lambda$0(GridViewModel gridViewModel, PageKey pageKey, String str, boolean z) {
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(gridViewModel), null, null, new GridViewModel$thumbnailListener$1$1(gridViewModel, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preferencesChangedListener$lambda$0(GridViewModel gridViewModel, SharedPreferences sharedPreferences, String str) {
        DisplayMode.Grid displayMode$default;
        if (str != null && str.hashCode() == -1908392395 && str.equals(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY)) {
            String string = gridViewModel.sharedPreferences.getString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, DisplayMode.Grid.INSTANCE.getName());
            if (string == null || (displayMode$default = DisplayMode.toDisplayMode$default(DisplayMode.Grid.INSTANCE, string, null, 1, null)) == null) {
                displayMode$default = DisplayMode.Grid.INSTANCE;
            }
            gridViewModel.setCurrentDisplayMode(displayMode$default);
            gridViewModel._folderUIState.setValue(gridViewModel.computeFolderUIState());
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64852(Continuation<? super C64852> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64852(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GridViewModel gridViewModel = GridViewModel.this;
            gridViewModel.sorting = gridViewModel.getPreferredSort();
            GridViewModel gridViewModel2 = GridViewModel.this;
            gridViewModel2.ordering = gridViewModel2.getPreferredOrder(gridViewModel2.sorting);
            GridViewModel gridViewModel3 = GridViewModel.this;
            gridViewModel3.setCurrentDisplayMode(gridViewModel3.getPreferredDisplayMode());
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            GridViewModel.this._searchState.setValue(SearchState.Closed.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$3 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$3", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {577}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {580}, m1615s = {}, m1616v = 2)
    static final class C64863 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64863(Continuation<? super C64863> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64863(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64863) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.combine(GridViewModel.this.userProfileManager.isPaidSubscriber(), FlowLiveDataConversions.asFlow(GridViewModel.this.networkStateRepository.getNeboNetworkState()), GridViewModel.this.subscriptionRepository.getFreePeriodState(), GridViewModel.this.subscriptionRepository.isConfigured(), GridViewModel.this.renewalOfferBannerHours, new AnonymousClass1(null));
                final GridViewModel gridViewModel = GridViewModel.this;
                this.label = 1;
                if (flowCombine.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.GridViewModel.3.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((GridBannerState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(GridBannerState gridBannerState, Continuation<? super Unit> continuation) {
                        gridViewModel._gridBannerState.setValue(gridBannerState);
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

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/grid/GridBannerState;", "isPaidSubscriber", "", "neboNetworkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "freePeriodState", "Lcom/myscript/nebo/purchase/FreePeriodState;", "isConfigured", "renewalOfferHours", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$3$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function6<Boolean, NeboNetworkState, FreePeriodState, Boolean, Integer, Continuation<? super GridBannerState>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(6, continuation);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, NeboNetworkState neboNetworkState, FreePeriodState freePeriodState, Boolean bool2, Integer num, Continuation<? super GridBannerState> continuation) {
                return invoke(bool.booleanValue(), neboNetworkState, freePeriodState, bool2.booleanValue(), num.intValue(), continuation);
            }

            public final Object invoke(boolean z, NeboNetworkState neboNetworkState, FreePeriodState freePeriodState, boolean z2, int i, Continuation<? super GridBannerState> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = z;
                anonymousClass1.L$0 = neboNetworkState;
                anonymousClass1.L$1 = freePeriodState;
                anonymousClass1.Z$1 = z2;
                anonymousClass1.I$0 = i;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                boolean z;
                UserStatus userStatus;
                boolean z2 = this.Z$0;
                NeboNetworkState neboNetworkState = (NeboNetworkState) this.L$0;
                FreePeriodState freePeriodState = (FreePeriodState) this.L$1;
                boolean z3 = this.Z$1;
                int i = this.I$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                boolean z4 = true;
                boolean z5 = freePeriodState.getStatus() == FreePeriodStatus.Active && freePeriodState.getType() == FreePeriodType.OEMOffer;
                if (z5) {
                    long jM13345getRemainingDaysUwyO8pc = freePeriodState.m13345getRemainingDaysUwyO8pc();
                    Duration.Companion companion = Duration.INSTANCE;
                    z = Duration.m15855compareToLRDsOJo(jM13345getRemainingDaysUwyO8pc, DurationKt.toDuration(7, DurationUnit.DAYS)) <= 0;
                }
                boolean z6 = i > 0 && !z2;
                if (!z6 && (!z3 || ((z5 || z2) && (z2 || !z)))) {
                    z4 = false;
                }
                if (z6) {
                    userStatus = UserStatus.RenewalOffer;
                } else if (freePeriodState.getStatus() == FreePeriodStatus.Active) {
                    userStatus = UserStatus.Trial;
                } else if (z2) {
                    userStatus = UserStatus.Premium;
                } else {
                    userStatus = UserStatus.Freemium;
                }
                return new GridBannerState(z4, userStatus, neboNetworkState instanceof NeboNetworkState.Connected, (int) Duration.m15864getInWholeDaysimpl(freePeriodState.m13345getRemainingDaysUwyO8pc()), i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FolderUIState computeFolderUIState() {
        boolean z;
        ArrayList arrayList;
        FolderState folderState;
        boolean z2;
        EmptyState.NotEmpty emptySearch;
        EnumEntries<Order> entries;
        int i;
        int i2;
        long lastModificationDate;
        List<PageModel> filteredPages;
        Object next;
        List<PageModel> list = this.selectedPages;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((PageModel) it.next()).isCorrupted()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        int size = this.selectedPages.size();
        SearchState value = this._searchState.getValue();
        SearchState.Searching searching = value instanceof SearchState.Searching ? (SearchState.Searching) value : null;
        if (searching != null && (filteredPages = searching.getFilteredPages()) != null) {
            List<PageModel> list2 = filteredPages;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (PageModel pageModel : list2) {
                Iterator<T> it2 = this.selectedPages.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (Intrinsics.areEqual(((PageModel) next).getPageKey(), pageModel.getPageKey())) {
                        break;
                    }
                }
                arrayList2.add(PageModel.copy$default(pageModel, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, next != null ? SelectionState.SELECTED : SelectionState.UNSELECTED, null, 12582911, null));
            }
            arrayList = arrayList2;
        } else {
            arrayList = this.pages;
        }
        List<PageModel> list3 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (PageModel pageModel2 : list3) {
            boolean z3 = !isLanguageAvailable(pageModel2.getPageKey());
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.sorting.ordinal()];
            if (i3 == 1) {
                i = C6079R.string.note_item_creation_date_prefix;
            } else if (i3 == 2) {
                i = C6079R.string.note_item_modification_date_prefix;
            } else {
                i2 = 0;
                if (WhenMappings.$EnumSwitchMapping$0[this.sorting.ordinal()] != 1) {
                    lastModificationDate = pageModel2.getCreationDate();
                } else {
                    lastModificationDate = pageModel2.getLastModificationDate();
                }
                arrayList3.add(PageModel.copy$default(pageModel2, null, null, false, false, false, false, lastModificationDate, i2, 0L, 0L, 0L, null, null, z3, null, null, 0, 0, null, 0, false, false, null, null, 16768831, null));
            }
            i2 = i;
            if (WhenMappings.$EnumSwitchMapping$0[this.sorting.ordinal()] != 1) {
            }
            arrayList3.add(PageModel.copy$default(pageModel2, null, null, false, false, false, false, lastModificationDate, i2, 0L, 0L, 0L, null, null, z3, null, null, 0, 0, null, 0, false, false, null, null, 16768831, null));
        }
        ArrayList arrayListSortedWith = arrayList3;
        boolean z4 = this.folderState == FolderState.Loaded;
        boolean zIsEmpty = this.pages.isEmpty();
        boolean z5 = isSearchModeActive() && this.searchHits.isEmpty() && arrayListSortedWith.isEmpty();
        boolean z6 = this.openedNotebookKey == null;
        boolean z7 = !z6 && z4 && z5;
        boolean z8 = !z6 && !z7 && z4 && zIsEmpty;
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.sorting.ordinal()];
        if (i4 == 1) {
            arrayListSortedWith = CollectionsKt.sortedWith(arrayListSortedWith, PageModel.INSTANCE.getCreationDateComparator());
        } else if (i4 == 2) {
            arrayListSortedWith = CollectionsKt.sortedWith(arrayListSortedWith, PageModel.INSTANCE.getModificationDateComparator());
        } else if (i4 == 3) {
            arrayListSortedWith = CollectionsKt.sortedWith(arrayListSortedWith, PageModel.INSTANCE.getAlphabeticalComparator());
        }
        if (this.ordering == Order.Descending) {
            arrayListSortedWith = CollectionsKt.asReversed(arrayListSortedWith);
        }
        List list4 = arrayListSortedWith;
        NotebookKey notebookKey = this.openedNotebookKey;
        String str = this.folderName;
        boolean canModify = getCanModify();
        boolean canOpenPage = getCanOpenPage();
        boolean z9 = this.folderState == FolderState.Loading || this.folderState == FolderState.Updating;
        FolderState folderState2 = this.folderState;
        boolean z10 = this.isSelectionMode;
        if (size != 1 || z) {
            folderState = folderState2;
            z2 = false;
        } else {
            folderState = folderState2;
            z2 = true;
        }
        PageManager pageManager = this.pageRepository;
        List<PageModel> list5 = this.selectedPages;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        Iterator<T> it3 = list5.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((PageModel) it3.next()).getPageKey());
        }
        SelectionModeState selectionModeState = new SelectionModeState(z10, z2, pageManager.canExport(arrayList4), size > 0, size > 0, size < this.pages.size(), size == 1 && !z, size > 0, size == 1 && !z, size);
        if (z6) {
            emptySearch = EmptyState.NoFolder.INSTANCE;
        } else if (z8) {
            emptySearch = EmptyState.EmptyFolder.INSTANCE;
        } else if (z7) {
            String searchQuery = getSearchQuery();
            if (searchQuery == null) {
                searchQuery = "";
            }
            emptySearch = new EmptyState.EmptySearch(searchQuery, this.folderName);
        } else {
            emptySearch = EmptyState.NotEmpty.INSTANCE;
        }
        EmptyState emptyState = emptySearch;
        boolean hasCorrupted = getHasCorrupted();
        Sort sort = this.sorting;
        Order order = this.ordering;
        if (WhenMappings.$EnumSwitchMapping$0[sort.ordinal()] == 4) {
            entries = CollectionsKt.emptyList();
        } else {
            entries = Order.getEntries();
        }
        return new FolderUIState(notebookKey, str, list4, canModify, canOpenPage, z9, folderState, selectionModeState, emptyState, hasCorrupted, new SortState(sort, entries, order, this.isSortMenuOpen), this.currentDisplayMode);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$openFolder$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$openFolder$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {675}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {677}, m1615s = {}, m1616v = 2)
    static final class C65051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotebookKey $notebookKey;
        int label;
        final /* synthetic */ GridViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65051(NotebookKey notebookKey, GridViewModel gridViewModel, Continuation<? super C65051> continuation) {
            super(2, continuation);
            this.$notebookKey = notebookKey;
            this.this$0 = gridViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C65051(this.$notebookKey, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$notebookKey, this.this$0.getOpenedNotebookKey())) {
                    this.label = 1;
                    if (this.this$0.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.openedNotebookKey = this.$notebookKey;
            DMSSearchController dMSSearchController = this.this$0.searchController;
            if (dMSSearchController != null) {
                dMSSearchController.setNotebook(this.this$0.getOpenedNotebookKey());
            }
            if (this.this$0._openPageKey.getValue() != 0) {
                this.this$0.closePage();
            }
            if (this.this$0.getSearchState().getValue() instanceof SearchState.Open) {
                GridViewModel.closeSearch$default(this.this$0, false, 1, null);
            }
            FolderUIState folderUIState = (FolderUIState) this.this$0._folderUIState.getValue();
            if ((folderUIState != null ? folderUIState.getFolderState() : null) != FolderState.Unloaded) {
                this.this$0.folderState = FolderState.Unloaded;
                this.this$0.pages = CollectionsKt.emptyList();
                this.this$0._folderUIState.setValue(this.this$0.computeFolderUIState());
            }
            this.this$0.pageRepository.addFolderListener(this.$notebookKey, this.this$0.folderListener);
            this.this$0.reloadFolder(true);
            return Unit.INSTANCE;
        }
    }

    public final void openFolder(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65051(notebookKey, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$closeFolder$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$closeFolder$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64891(Continuation<? super C64891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotebookKey openedNotebookKey = GridViewModel.this.getOpenedNotebookKey();
            if (openedNotebookKey != null) {
                GridViewModel gridViewModel = GridViewModel.this;
                gridViewModel.pageRepository.removeFolderListener(openedNotebookKey, gridViewModel.folderListener);
                gridViewModel.unbindPageListeners(gridViewModel.getPages());
            }
            GridViewModel.this.closePage();
            GridViewModel.this.openedNotebookKey = null;
            FolderUIState folderUIState = (FolderUIState) GridViewModel.this._folderUIState.getValue();
            if ((folderUIState != null ? folderUIState.getFolderState() : null) != FolderState.Unloaded) {
                GridViewModel.this.folderState = FolderState.Unloaded;
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            }
            return Unit.INSTANCE;
        }
    }

    public final void closeFolder() {
        if (this.openedNotebookKey == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64891(null), 2, null);
    }

    private final boolean getCanModify() {
        return (!hasNotebookOpen() || ((getSearchState().getValue() instanceof SearchState.Open) || isSearchModeActive()) || this.isSelectionMode || !getCanOpenPage() || this.isBeingModified || isPageOpened() || !this.isViewAvailable) ? false : true;
    }

    private final boolean getCanOpenPage() {
        return this.folderState == FolderState.Loaded && this.pageState.canOpenPage();
    }

    public final boolean isPageOpened() {
        PageState pageState = this.pageState;
        return (pageState instanceof PageState.Opened) || (pageState instanceof PageState.Opening);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOpenPageKey(PageKey pageKey) {
        if (getCanOpenPage()) {
            this._openPageKey.setValue(pageKey);
        }
        if (this.pageState.matches(pageKey)) {
            return;
        }
        this.pageState = new PageState.Opening(pageKey);
        PageModel page = this.pageRepository.getPage(pageKey);
        if (page == null) {
            closePage();
            return;
        }
        if (!page.isSupported()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65221(null), 3, null);
            this.tooRecentNoteEvent.call();
            return;
        }
        if (!this.pageRepository.isLanguageAvailable(pageKey)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65232(pageKey, page, null), 3, null);
            return;
        }
        String strContentType = Page.contentType((PageType) Objects.requireNonNull(page.getPageType()));
        if (this.pageState.matches(pageKey)) {
            this.pageState = new PageState.Opened(pageKey);
            this.pageRepository.saveOpenedNote(pageKey);
        }
        if (Intrinsics.areEqual(getSearchState().getValue(), SearchState.Open.INSTANCE)) {
            closeSearch(true);
        }
        SingleLiveEvent<OpenPageEvent> singleLiveEvent = this.openPageEvent;
        Intrinsics.checkNotNull(strContentType);
        singleLiveEvent.setValue(new OpenPageEvent(pageKey, strContentType));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$updateOpenPageKey$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$updateOpenPageKey$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65221(Continuation<? super C65221> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65221(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._openPageKey.setValue(null);
                GridViewModel.this.pageRepository.clearOpenedNote();
                GridViewModel.this.pageState = PageState.Idle.INSTANCE;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$updateOpenPageKey$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$updateOpenPageKey$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageModel $page;
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65232(PageKey pageKey, PageModel pageModel, Continuation<? super C65232> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$page = pageModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65232(this.$pageKey, this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._openPageKey.setValue(null);
                GridViewModel.this.pageState = PageState.Idle.INSTANCE;
                GridViewModel.this.getMissingLanguageEvent().setValue(new MissingLanguageEvent(this.$pageKey, this.$page.getLanguageTag()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$openPage$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$openPage$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65061(PageKey pageKey, Continuation<? super C65061> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65061(this.$pageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this.updateOpenPageKey(this.$pageKey);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void openPage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65061(pageKey, null), 2, null);
    }

    public final void closePage() {
        if (!(this.pageState instanceof PageState.Idle)) {
            this.pageState = PageState.Idle.INSTANCE;
            this.pageRepository.clearOpenedNote();
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64901(null), 2, null);
        reloadFolder$default(this, false, 1, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$closePage$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$closePage$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64901(Continuation<? super C64901> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64901(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._openPageKey.setValue(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ void editNotebook$default(GridViewModel gridViewModel, boolean z, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        gridViewModel.editNotebook(z, str, function1);
    }

    private final void editNotebook(boolean showAsUpdating, String analyticsOriginEvent, Function1<? super Continuation<? super Unit>, ? extends Object> editLogic) {
        FolderUIState value = getFolderUIState().getValue();
        if (value == null || value.getFolderState() != FolderState.Loaded || value.getNotebookKey() == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64941(showAsUpdating, this, editLogic, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$editNotebook$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$editNotebook$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {814, 821, 821, 821}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {820, PDFACompliance.e_PDFA8_2_2, PDFACompliance.e_PDFA8_2_2, PDFACompliance.e_PDFA8_2_2}, m1615s = {}, m1616v = 2)
    static final class C64941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $editLogic;
        final /* synthetic */ boolean $showAsUpdating;
        Object L$0;
        int label;
        final /* synthetic */ GridViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64941(boolean z, GridViewModel gridViewModel, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C64941> continuation) {
            super(2, continuation);
            this.$showAsUpdating = z;
            this.this$0 = gridViewModel;
            this.$editLogic = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C64941(this.$showAsUpdating, this.this$0, this.$editLogic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
        
            if (r8.this$0.updatePages(r8) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c9, code lost:
        
            if (r8.this$0.updatePages(r8) != r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception unused) {
                this.this$0.folderState = FolderState.Loaded;
                this.label = 3;
            } catch (Throwable th2) {
                this.this$0.folderState = FolderState.Loaded;
                this.L$0 = th2;
                this.label = 4;
                if (this.this$0.updatePages(this) != coroutine_suspended) {
                    th = th2;
                }
                return coroutine_suspended;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$showAsUpdating) {
                    this.this$0.folderState = FolderState.Updating;
                    this.this$0._folderUIState.setValue(this.this$0.computeFolderUIState());
                }
                this.label = 1;
                if (BuildersKt.withContext(this.this$0.workDispatcher, new AnonymousClass1(this.$editLogic, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2 || i == 3) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._folderUIState.setValue(this.this$0.computeFolderUIState());
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0._folderUIState.setValue(this.this$0.computeFolderUIState());
                throw th;
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.folderState = FolderState.Loaded;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$editNotebook$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$editNotebook$1$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {815}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {816}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Continuation<? super Unit>, Object> $editLogic;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$editLogic = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$editLogic, continuation);
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
                    Function1<Continuation<? super Unit>, Object> function1 = this.$editLogic;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$movePage$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$movePage$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {829}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {830}, m1615s = {}, m1616v = 2)
    static final class C65001 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $newPosition;
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65001(PageKey pageKey, int i, Continuation<? super C65001> continuation) {
            super(1, continuation);
            this.$pageKey = pageKey;
            this.$newPosition = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C65001(this.$pageKey, this.$newPosition, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C65001) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.movePage(this.$pageKey, this.$newPosition);
            return Unit.INSTANCE;
        }
    }

    public final void movePage(PageKey pageKey, int newPosition) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        editNotebook$default(this, false, null, new C65001(pageKey, newPosition, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$movePage$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$movePage$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {836}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {837}, m1615s = {}, m1616v = 2)
    static final class C65012 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ NotebookKey $notebookKey;
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65012(PageKey pageKey, NotebookKey notebookKey, Continuation<? super C65012> continuation) {
            super(1, continuation);
            this.$pageKey = pageKey;
            this.$notebookKey = notebookKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C65012(this.$pageKey, this.$notebookKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C65012) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.movePage(this.$pageKey, this.$notebookKey);
            return Unit.INSTANCE;
        }
    }

    public final void movePage(PageKey pageKey, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        editNotebook$default(this, false, null, new C65012(pageKey, notebookKey, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$movePages$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$movePages$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {843}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {844}, m1615s = {}, m1616v = 2)
    static final class C65021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ NotebookKey $notebookKey;
        final /* synthetic */ List<PageKey> $pageKeys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C65021(List<? extends PageKey> list, NotebookKey notebookKey, Continuation<? super C65021> continuation) {
            super(1, continuation);
            this.$pageKeys = list;
            this.$notebookKey = notebookKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C65021(this.$pageKeys, this.$notebookKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C65021) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.movePages(this.$pageKeys, this.$notebookKey);
            return Unit.INSTANCE;
        }
    }

    public final void movePages(List<? extends PageKey> pageKeys, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        editNotebook$default(this, false, null, new C65021(pageKeys, notebookKey, null), 3, null);
    }

    public final void importNeboFile(Uri requestedUri, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(requestedUri, "requestedUri");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        closeSearch$default(this, false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64971(notebookKey, requestedUri, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importNeboFile$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importNeboFile$1", m1609f = "GridViewModel.kt", m1610i = {0}, m1611l = {856}, m1612m = "invokeSuspend", m1613n = {"beforeKeys"}, m1614nl = {883}, m1615s = {"L$0"}, m1616v = 2)
    static final class C64971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotebookKey $notebookKey;
        final /* synthetic */ Uri $requestedUri;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64971(NotebookKey notebookKey, Uri uri, Continuation<? super C64971> continuation) {
            super(2, continuation);
            this.$notebookKey = notebookKey;
            this.$requestedUri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64971(this.$notebookKey, this.$requestedUri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Set set;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<PageModel> pages = GridViewModel.this.getPages();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
                Iterator<T> it = pages.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PageModel) it.next()).getPageKey());
                }
                Set set2 = CollectionsKt.toSet(arrayList);
                GridViewModel.this._importState.setValue(ImportStateUI.Importing.INSTANCE);
                this.L$0 = set2;
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(GridViewModel.this.workDispatcher, new GridViewModel$importNeboFile$1$importResult$1(GridViewModel.this, this.$requestedUri, this.$notebookKey, null), this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                set = set2;
                obj = objWithContext;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                set = (Set) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ImportStateUI importStateUI = (ImportStateUI) obj;
            GridViewModel.this._importState.setValue(importStateUI);
            if (Intrinsics.areEqual(this.$notebookKey, GridViewModel.this.getOpenedNotebookKey())) {
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            } else {
                GridViewModel.this.openFolder(this.$notebookKey);
            }
            if (Intrinsics.areEqual(importStateUI, ImportStateUI.Success.INSTANCE)) {
                List<PageModel> pages2 = GridViewModel.this.getPages();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages2, 10));
                Iterator<T> it2 = pages2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((PageModel) it2.next()).getPageKey());
                }
                Set setMinus = SetsKt.minus(CollectionsKt.toSet(arrayList2), (Iterable) set);
                if (setMinus.size() == 1) {
                    GridViewModel.this.updateOpenPageKey((PageKey) CollectionsKt.first(setMinus));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void importDocuments(List<? extends Uri> nebos, List<? extends Uri> pdfs) {
        int size;
        Intrinsics.checkNotNullParameter(nebos, "nebos");
        Intrinsics.checkNotNullParameter(pdfs, "pdfs");
        NotebookKey notebookKey = this.openedNotebookKey;
        if (notebookKey == null || (size = nebos.size() + pdfs.size()) == 0) {
            return;
        }
        if (size == 1) {
            if (nebos.size() == 1) {
                importNeboFile(nebos.get(0), notebookKey);
                return;
            } else {
                importAsPdf(pdfs.get(0), this.languageProvider.invoke(), notebookKey);
                return;
            }
        }
        closeSearch$default(this, false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64961(pdfs, nebos, notebookKey, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importDocuments$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importDocuments$1", m1609f = "GridViewModel.kt", m1610i = {0, 0, 1, 1, 1, 1, 2, 2, 3, 4}, m1611l = {925, 929, 943, 959, 959}, m1612m = "invokeSuspend", m1613n = {"beforeKeys", "uri", "beforeKeys", "uri", "result", "file", "beforeKeys", "uri", "beforeKeys", "beforeKeys"}, m1614nl = {926, 933, 954, 960, 960}, m1615s = {"L$0", "L$2", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$0", "L$0"}, m1616v = 2)
    static final class C64961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $nebos;
        final /* synthetic */ NotebookKey $notebookKey;
        final /* synthetic */ List<Uri> $pdfs;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64961(List<? extends Uri> list, List<? extends Uri> list2, NotebookKey notebookKey, Continuation<? super C64961> continuation) {
            super(2, continuation);
            this.$pdfs = list;
            this.$nebos = list2;
            this.$notebookKey = notebookKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64961(this.$pdfs, this.$nebos, this.$notebookKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0254  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e2 A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #6 {all -> 0x008d, blocks: (B:84:0x01d6, B:78:0x019c, B:80:0x01a2, B:81:0x01a8, B:87:0x01da, B:89:0x01e2, B:69:0x017b, B:39:0x00dc, B:41:0x00e2, B:42:0x00e8, B:73:0x0184, B:75:0x018c, B:77:0x0195, B:26:0x0083), top: B:119:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x011d A[Catch: Exception -> 0x017e, all -> 0x026b, TryCatch #1 {Exception -> 0x017e, blocks: (B:46:0x0119, B:48:0x011d, B:51:0x0123), top: B:121:0x0119 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0195 A[Catch: all -> 0x008d, TryCatch #6 {all -> 0x008d, blocks: (B:84:0x01d6, B:78:0x019c, B:80:0x01a2, B:81:0x01a8, B:87:0x01da, B:89:0x01e2, B:69:0x017b, B:39:0x00dc, B:41:0x00e2, B:42:0x00e8, B:73:0x0184, B:75:0x018c, B:77:0x0195, B:26:0x0083), top: B:119:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01a2 A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #6 {all -> 0x008d, blocks: (B:84:0x01d6, B:78:0x019c, B:80:0x01a2, B:81:0x01a8, B:87:0x01da, B:89:0x01e2, B:69:0x017b, B:39:0x00dc, B:41:0x00e2, B:42:0x00e8, B:73:0x0184, B:75:0x018c, B:77:0x0195, B:26:0x0083), top: B:119:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01e8  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x022e A[LOOP:1: B:96:0x0228->B:98:0x022e, LOOP_END] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x015d -> B:58:0x015f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0168 -> B:62:0x016a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x017f -> B:73:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x01d2 -> B:127:0x01d6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0090
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 750
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.grid.GridViewModel.C64961.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importDocuments$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/core/PageKey;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importDocuments$1$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageKey>, Object> {
            final /* synthetic */ File $file;
            final /* synthetic */ NotebookKey $notebookKey;
            int label;
            final /* synthetic */ GridViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GridViewModel gridViewModel, NotebookKey notebookKey, File file, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = gridViewModel;
                this.$notebookKey = notebookKey;
                this.$file = file;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$notebookKey, this.$file, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PageKey> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return this.this$0.pageRepository.importAsPdf(this.$notebookKey, this.$file, (String) this.this$0.languageProvider.invoke());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importDocuments$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importDocuments$1$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ NotebookKey $notebookKey;
            final /* synthetic */ Uri $uri;
            int label;
            final /* synthetic */ GridViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(GridViewModel gridViewModel, Uri uri, NotebookKey notebookKey, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = gridViewModel;
                this.$uri = uri;
                this.$notebookKey = notebookKey;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$uri, this.$notebookKey, continuation);
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
                    INeboFileImporter iNeboFileImporter = this.this$0.neboFileImporter;
                    ImportController.ImportResult importResultImportNeboFile = iNeboFileImporter != null ? iNeboFileImporter.importNeboFile(this.$uri) : null;
                    File file = importResultImportNeboFile != null ? importResultImportNeboFile.file : null;
                    if (importResultImportNeboFile != null && importResultImportNeboFile.isSuccess() && file != null) {
                        try {
                            this.this$0.pageRepository.importNeboFile(file, this.$notebookKey);
                        } finally {
                            file.delete();
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$updatePageTitle$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$updatePageTitle$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {972}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {973}, m1615s = {}, m1616v = 2)
    static final class C65241 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ String $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65241(PageKey pageKey, String str, Continuation<? super C65241> continuation) {
            super(1, continuation);
            this.$pageKey = pageKey;
            this.$title = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C65241(this.$pageKey, this.$title, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C65241) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.updateNoteName(this.$pageKey, this.$title);
            return Unit.INSTANCE;
        }
    }

    public final void updatePageTitle(PageKey pageKey, String title) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(title, "title");
        editNotebook$default(this, false, null, new C65241(pageKey, title, null), 3, null);
    }

    public final void duplicatePage(PageKey pageKey) {
        List<PageModel> pages;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        FolderUIState value = getFolderUIState().getValue();
        if (value == null || (pages = value.getPages()) == null) {
            return;
        }
        Iterator<PageModel> it = pages.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getPageKey(), pageKey)) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        if (i2 >= 0) {
            duplicatePage(pageKey, i2);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$duplicatePage$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$duplicatePage$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {988}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {989}, m1615s = {}, m1616v = 2)
    static final class C64932 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $newPosition;
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64932(PageKey pageKey, int i, Continuation<? super C64932> continuation) {
            super(1, continuation);
            this.$pageKey = pageKey;
            this.$newPosition = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C64932(this.$pageKey, this.$newPosition, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C64932) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.duplicatePage(this.$pageKey, this.$newPosition);
            return Unit.INSTANCE;
        }
    }

    public final void duplicatePage(PageKey pageKey, int newPosition) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        editNotebook$default(this, false, "duplicate_page", new C64932(pageKey, newPosition, null), 1, null);
    }

    public final boolean hasNotebookOpen() {
        return this.openedNotebookKey != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindPageListeners(List<PageModel> pages) {
        Iterator<T> it = pages.iterator();
        while (it.hasNext()) {
            this.pageRepository.addPageListener(((PageModel) it.next()).getPageKey(), this.pageListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unbindPageListeners(List<PageModel> pages) {
        Iterator<T> it = pages.iterator();
        while (it.hasNext()) {
            this.pageRepository.removePageListener(((PageModel) it.next()).getPageKey(), this.pageListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updatePages(Continuation<? super Unit> continuation) {
        C65251 c65251;
        if (continuation instanceof C65251) {
            c65251 = (C65251) continuation;
            if ((c65251.label & Integer.MIN_VALUE) != 0) {
                c65251.label -= Integer.MIN_VALUE;
            } else {
                c65251 = new C65251(continuation);
            }
        }
        Object obj = c65251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c65251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NotebookKey notebookKey = this.openedNotebookKey;
            if (notebookKey != null) {
                CoroutineDispatcher coroutineDispatcher = this.workDispatcher;
                GridViewModel$updatePages$2$1 gridViewModel$updatePages$2$1 = new GridViewModel$updatePages$2$1(this, notebookKey, null);
                c65251.L$0 = SpillingKt.nullOutSpilledVariable(notebookKey);
                c65251.I$0 = 0;
                c65251.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, gridViewModel$updatePages$2$1, c65251) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c65251.I$0;
        ResultKt.throwOnFailure(obj);
        if (isSearchModeActive()) {
            filter();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$reloadFolder$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$reloadFolder$1", m1609f = "GridViewModel.kt", m1610i = {0, 0}, m1611l = {1039}, m1612m = "invokeSuspend", m1613n = {"notebookKey", AIQuizConstants.NOTEBOOK}, m1614nl = {1040}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C65091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $firstLoad;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65091(boolean z, Continuation<? super C65091> continuation) {
            super(2, continuation);
            this.$firstLoad = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65091(this.$firstLoad, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GridViewModel gridViewModel;
            FolderState folderState;
            GridViewModel gridViewModel2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!GridViewModel.this.isPageOpened()) {
                    GridViewModel.this.folderState = this.$firstLoad ? FolderState.Loading : FolderState.Updating;
                    GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                    NotebookKey openedNotebookKey = GridViewModel.this.getOpenedNotebookKey();
                    FolderModel folder = (openedNotebookKey == null || !openedNotebookKey.isValid()) ? null : GridViewModel.this.pageRepository.getFolder(openedNotebookKey);
                    gridViewModel = GridViewModel.this;
                    if (openedNotebookKey == null || folder == null) {
                        gridViewModel.openedNotebookKey = null;
                        GridViewModel gridViewModel3 = GridViewModel.this;
                        gridViewModel3.unbindPageListeners(gridViewModel3.getPages());
                        GridViewModel.this.pages = CollectionsKt.emptyList();
                        folderState = FolderState.Unloaded;
                        gridViewModel.folderState = folderState;
                        GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                    } else {
                        gridViewModel.folderName = folder.getName();
                        GridViewModel.this.folderState = this.$firstLoad ? FolderState.Loading : FolderState.Updating;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(openedNotebookKey);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(folder);
                        this.L$2 = gridViewModel;
                        this.label = 1;
                        if (GridViewModel.this.updatePages(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        gridViewModel2 = gridViewModel;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gridViewModel2 = (GridViewModel) this.L$2;
            ResultKt.throwOnFailure(obj);
            folderState = FolderState.Loaded;
            gridViewModel = gridViewModel2;
            gridViewModel.folderState = folderState;
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void reloadFolder$default(GridViewModel gridViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        gridViewModel.reloadFolder(z);
    }

    public final void reloadFolder(boolean firstLoad) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65091(firstLoad, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$addNote$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$addNote$1", m1609f = "GridViewModel.kt", m1610i = {0, 0, 1, 1, 2, 2}, m1611l = {1060, 1068, 1068}, m1612m = "invokeSuspend", m1613n = {"it", "$i$a$-let-GridViewModel$addNote$1$1", "it", "$i$a$-let-GridViewModel$addNote$1$1", "it", "$i$a$-let-GridViewModel$addNote$1$1"}, m1614nl = {1064, 1069, 1069}, m1615s = {"L$1", "I$0", "L$1", "I$0", "L$1", "I$0"}, m1616v = 2)
    static final class C64881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<NotebookKey, PageKey> $logic;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64881(Function1<? super NotebookKey, ? extends PageKey> function1, Continuation<? super C64881> continuation) {
            super(2, continuation);
            this.$logic = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64881(this.$logic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            GridViewModel gridViewModel;
            int i;
            NotebookKey notebookKey;
            Throwable th;
            GridViewModel gridViewModel2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                NotebookKey openedNotebookKey = GridViewModel.this.getOpenedNotebookKey();
                if (openedNotebookKey != null) {
                    gridViewModel = GridViewModel.this;
                    Function1<NotebookKey, PageKey> function1 = this.$logic;
                    gridViewModel.folderState = FolderState.Updating;
                    gridViewModel._folderUIState.setValue(gridViewModel.computeFolderUIState());
                    i = 0;
                    try {
                        CoroutineDispatcher coroutineDispatcher = gridViewModel.workDispatcher;
                        GridViewModel$addNote$1$1$newPageKey$1 gridViewModel$addNote$1$1$newPageKey$1 = new GridViewModel$addNote$1$1$newPageKey$1(function1, openedNotebookKey, null);
                        this.L$0 = gridViewModel;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(openedNotebookKey);
                        this.I$0 = 0;
                        this.label = 1;
                        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, gridViewModel$addNote$1$1$newPageKey$1, this);
                        if (objWithContext != coroutine_suspended) {
                            notebookKey = openedNotebookKey;
                            obj = objWithContext;
                            gridViewModel.updateOpenPageKey((PageKey) obj);
                            gridViewModel.folderState = FolderState.Loaded;
                            this.L$0 = gridViewModel;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(notebookKey);
                            this.I$0 = i;
                            this.label = 2;
                            if (gridViewModel.updatePages(this) != coroutine_suspended) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        notebookKey = openedNotebookKey;
                        gridViewModel.folderState = FolderState.Loaded;
                        this.L$0 = gridViewModel;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(notebookKey);
                        this.L$2 = th;
                        this.I$0 = i;
                        this.label = 3;
                        if (gridViewModel.updatePages(this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    gridViewModel2 = (GridViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    gridViewModel2._folderUIState.setValue(gridViewModel2.computeFolderUIState());
                    return Unit.INSTANCE;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$2;
                gridViewModel = (GridViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                gridViewModel._folderUIState.setValue(gridViewModel.computeFolderUIState());
                throw th;
            }
            int i3 = this.I$0;
            notebookKey = (NotebookKey) this.L$1;
            GridViewModel gridViewModel3 = (GridViewModel) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i3;
                gridViewModel = gridViewModel3;
            } catch (Throwable th3) {
                th = th3;
                i = i3;
                gridViewModel = gridViewModel3;
                gridViewModel.folderState = FolderState.Loaded;
                this.L$0 = gridViewModel;
                this.L$1 = SpillingKt.nullOutSpilledVariable(notebookKey);
                this.L$2 = th;
                this.I$0 = i;
                this.label = 3;
                if (gridViewModel.updatePages(this) != coroutine_suspended) {
                    th = th;
                    gridViewModel._folderUIState.setValue(gridViewModel.computeFolderUIState());
                    throw th;
                }
                return coroutine_suspended;
            }
            try {
                gridViewModel.updateOpenPageKey((PageKey) obj);
                gridViewModel.folderState = FolderState.Loaded;
                this.L$0 = gridViewModel;
                this.L$1 = SpillingKt.nullOutSpilledVariable(notebookKey);
                this.I$0 = i;
                this.label = 2;
                if (gridViewModel.updatePages(this) != coroutine_suspended) {
                    gridViewModel2 = gridViewModel;
                    gridViewModel2._folderUIState.setValue(gridViewModel2.computeFolderUIState());
                    return Unit.INSTANCE;
                }
            } catch (Throwable th4) {
                th = th4;
                gridViewModel.folderState = FolderState.Loaded;
                this.L$0 = gridViewModel;
                this.L$1 = SpillingKt.nullOutSpilledVariable(notebookKey);
                this.L$2 = th;
                this.I$0 = i;
                this.label = 3;
                if (gridViewModel.updatePages(this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    private final void addNote(Function1<? super NotebookKey, ? extends PageKey> logic) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64881(logic, null), 3, null);
    }

    public final void addNotebook(final String name, final String lang, final List<Integer> coverColors, final PaperSize paperSize, final int backgroundColor, final BackgroundPattern backgroundPattern) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        addNote(new Function1() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridViewModel.addNotebook$lambda$0(this.f$0, name, lang, coverColors, paperSize, backgroundColor, backgroundPattern, (NotebookKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageKey addNotebook$lambda$0(GridViewModel gridViewModel, String str, String str2, List list, PaperSize paperSize, int i, BackgroundPattern backgroundPattern, NotebookKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PageKey pageKeyAddPaginatedContainer = gridViewModel.pageRepository.addPaginatedContainer(it, str, str2, list, paperSize, i, backgroundPattern);
        if (pageKeyAddPaginatedContainer != null) {
            return pageKeyAddPaginatedContainer;
        }
        throw new IllegalStateException("Error while adding notebook".toString());
    }

    public final void addBoard(final String name, final String lang, final int backgroundColor, final BackgroundPattern backgroundPattern) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        addNote(new Function1() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridViewModel.addBoard$lambda$0(this.f$0, name, lang, backgroundColor, backgroundPattern, (NotebookKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageKey addBoard$lambda$0(GridViewModel gridViewModel, String str, String str2, int i, BackgroundPattern backgroundPattern, NotebookKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PageKey pageKeyAddBoard = gridViewModel.pageRepository.addBoard(it, str, str2, i, backgroundPattern);
        if (pageKeyAddBoard != null) {
            return pageKeyAddBoard;
        }
        throw new IllegalStateException("Error while adding board".toString());
    }

    public final void addDocument(final String name, final String lang, final int backgroundColor) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        addNote(new Function1() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridViewModel.addDocument$lambda$0(this.f$0, name, lang, backgroundColor, (NotebookKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageKey addDocument$lambda$0(GridViewModel gridViewModel, String str, String str2, int i, NotebookKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PageKey pageKeyAddDocument = gridViewModel.pageRepository.addDocument(it, str, str2, i);
        if (pageKeyAddDocument != null) {
            return pageKeyAddDocument;
        }
        throw new IllegalStateException("Error while adding document".toString());
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$moveToTrash$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$moveToTrash$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1098}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1099}, m1615s = {}, m1616v = 2)
    static final class C65031 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PageKey> $pageKeys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C65031(List<? extends PageKey> list, Continuation<? super C65031> continuation) {
            super(1, continuation);
            this.$pageKeys = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return GridViewModel.this.new C65031(this.$pageKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C65031) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this.pageRepository.movePagesToTrash(this.$pageKeys);
            return Unit.INSTANCE;
        }
    }

    public final void moveToTrash(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        editNotebook$default(this, false, null, new C65031(pageKeys, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPageInNotebook(PageKey pageKey) {
        List<PageModel> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((PageModel) it.next()).getPageKey(), pageKey)) {
                return true;
            }
        }
        return false;
    }

    public final PageModel getPage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return this.pageRepository.getPage(pageKey);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.pageRepository.removeThumbnailListener(this.thumbnailListener);
        this.userProfileManager.removeFeatureAccessListener(this.paidUserStatusListener);
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            dMSSearchController.removeDMSSearchListener(this.onSearchUpdate);
        }
        this.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.preferencesChangedListener);
        super.onCleared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filter() {
        PageModel pageModelCopy$default;
        Object next;
        List<SearchHit> list = this.searchHits;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            PageKey pageKey = ((SearchHit) obj).getPageKey();
            Object obj2 = linkedHashMap.get(pageKey);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(pageKey, obj2);
            }
            ((List) obj2).add(obj);
        }
        Set<PageKey> setPlus = SetsKt.plus(linkedHashMap.keySet(), (Iterable) this.titleMatchedKeys);
        ArrayList arrayList = new ArrayList();
        for (PageKey pageKey2 : setPlus) {
            Iterator<T> it = this.pages.iterator();
            while (true) {
                pageModelCopy$default = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.areEqual(((PageModel) next).getPageKey(), pageKey2)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            PageModel pageModel = (PageModel) next;
            if (pageModel != null) {
                List list2 = (List) linkedHashMap.get(pageKey2);
                int hitCount = 0;
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        hitCount += ((SearchHit) it2.next()).getHitCount();
                    }
                }
                pageModelCopy$default = PageModel.copy$default(pageModel, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, hitCount, this.titleMatchedKeys.contains(pageKey2), false, null, null, 15204351, null);
            }
            if (pageModelCopy$default != null) {
                arrayList.add(pageModelCopy$default);
            }
        }
        this._searchState.setValue(new SearchState.Searching(arrayList));
    }

    public final boolean search(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        if (isSearchProcessing()) {
            return false;
        }
        String str = label;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65111(label, null), 3, null);
            return true;
        }
        closeSearch$default(this, false, 1, null);
        return false;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$search$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$search$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $label;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65111(String str, Continuation<? super C65111> continuation) {
            super(2, continuation);
            this.$label = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65111(this.$label, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._searchState.setValue(new SearchState.Searching(null, 1, null));
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                DMSSearchController dMSSearchController = GridViewModel.this.searchController;
                if (dMSSearchController != null) {
                    dMSSearchController.setSearchType(DMSSearchController.SearchType.GRID);
                }
                DMSSearchController dMSSearchController2 = GridViewModel.this.searchController;
                if (dMSSearchController2 != null) {
                    dMSSearchController2.search(this.$label, GridViewModel.this.getOpenedNotebookKey());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$stopSearch$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$stopSearch$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65181(Continuation<? super C65181> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65181(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._searchState.setValue(SearchState.Closed.INSTANCE);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void stopSearch() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65181(null), 3, null);
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            dMSSearchController.stopSearch();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$updateSearchHits$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$updateSearchHits$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65261(Continuation<? super C65261> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65261(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<PageModel> filteredPages;
            List mutableList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                T value = GridViewModel.this._searchState.getValue();
                SearchState.Searching searching = value instanceof SearchState.Searching ? (SearchState.Searching) value : null;
                if (searching != null && (filteredPages = searching.getFilteredPages()) != null && (mutableList = CollectionsKt.toMutableList((Collection) filteredPages)) != null) {
                    DMSSearchController dMSSearchController = GridViewModel.this.searchController;
                    if (dMSSearchController != null && dMSSearchController.isSearchModeActive()) {
                        List list = mutableList;
                        GridViewModel gridViewModel = GridViewModel.this;
                        if ((list instanceof Collection) && list.isEmpty()) {
                            GridViewModel.this._searchState.setValue(new SearchState.Searching(null, 1, null));
                        } else {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (gridViewModel.isPageInNotebook(((PageModel) it.next()).getPageKey())) {
                                    break;
                                }
                            }
                            GridViewModel.this._searchState.setValue(new SearchState.Searching(null, 1, null));
                        }
                    }
                    GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSearchHits() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65261(null), 2, null);
    }

    public final void openSearch() {
        if (this._searchState.getValue() instanceof SearchState.Open) {
            return;
        }
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            dMSSearchController.openSearch();
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65071(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$openSearch$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$openSearch$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65071(Continuation<? super C65071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._searchState.setValue(SearchState.Open.INSTANCE);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void closeSearch$default(GridViewModel gridViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        gridViewModel.closeSearch(z);
    }

    public final void closeSearch(boolean forceCompleteClose) {
        if (getSearchState().getValue() instanceof SearchState.Closed) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64911(forceCompleteClose, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$closeSearch$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$closeSearch$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceCompleteClose;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64911(boolean z, Continuation<? super C64911> continuation) {
            super(2, continuation);
            this.$forceCompleteClose = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64911(this.$forceCompleteClose, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchState searchState;
            String searchQuery;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = GridViewModel.this._searchState;
                if (this.$forceCompleteClose || (searchQuery = GridViewModel.this.getSearchQuery()) == null || searchQuery.length() == 0) {
                    DMSSearchController dMSSearchController = GridViewModel.this.searchController;
                    if (dMSSearchController != null) {
                        dMSSearchController.closeSearch();
                    }
                    searchState = SearchState.Closed.INSTANCE;
                } else {
                    DMSSearchController dMSSearchController2 = GridViewModel.this.searchController;
                    if (dMSSearchController2 != null) {
                        dMSSearchController2.stopSearch();
                    }
                    searchState = SearchState.Open.INSTANCE;
                }
                mutableLiveData.setValue(searchState);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void clearResults() {
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            dMSSearchController.clearResults();
        }
    }

    public final void clearHistory() {
        DMSSearchController dMSSearchController = this.searchController;
        if (dMSSearchController != null) {
            dMSSearchController.clearHistory();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$refreshStorageState$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$refreshStorageState$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1222}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1223}, m1615s = {}, m1616v = 2)
    static final class C65081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65081(Continuation<? super C65081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GridViewModel.this.availableSpaceProvider.getAvailableSpace(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            StorageState storageStateFromSpace = StorageState.INSTANCE.fromSpace(((Number) obj).longValue(), GridViewModel.this.availableSpaceProvider.getCriticalThreshold(), GridViewModel.this.availableSpaceProvider.getLowThreshold());
            TechnicalLoggerExt.setStorageStateKeyValues(GridViewModel.this.logger, storageStateFromSpace);
            GridViewModel.this._storageState.setValue(storageStateFromSpace);
            return Unit.INSTANCE;
        }
    }

    public final void refreshStorageState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65081(null), 2, null);
    }

    public final boolean hasStoragePopupBeenShown() {
        return hasStoragePopupBeenShown;
    }

    public final void setStoragePopupSeen(boolean hasBeenSeen) {
        hasStoragePopupBeenShown = hasBeenSeen;
    }

    public final void importAsPdf(Uri requestedUri, String lang, NotebookKey targetNotebookKey) {
        Intrinsics.checkNotNullParameter(requestedUri, "requestedUri");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(targetNotebookKey, "targetNotebookKey");
        closeSearch$default(this, false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64951(targetNotebookKey, requestedUri, lang, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importAsPdf$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importAsPdf$1", m1609f = "GridViewModel.kt", m1610i = {1, 1, 2, 2, 2}, m1611l = {1244, 1261, 1265}, m1612m = "invokeSuspend", m1613n = {"importResult", "pdfFile", "importResult", "pdfFile", "pageKey"}, m1614nl = {1248, 1264, 1266}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C64951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $lang;
        final /* synthetic */ Uri $requestedUri;
        final /* synthetic */ NotebookKey $targetNotebookKey;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64951(NotebookKey notebookKey, Uri uri, String str, Continuation<? super C64951> continuation) {
            super(2, continuation);
            this.$targetNotebookKey = notebookKey;
            this.$requestedUri = uri;
            this.$lang = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64951(this.$targetNotebookKey, this.$requestedUri, this.$lang, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ImportController.ImportResult importResult;
            MutableLiveData mutableLiveData;
            Object obj2;
            FolderState folderState;
            Throwable th;
            File file;
            MutableLiveData mutableLiveData2;
            File file2;
            PageKey pageKey;
            PageKey pageKey2;
            MutableLiveData mutableLiveData3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._importState.setValue(ImportStateUI.Importing.INSTANCE);
                this.label = 1;
                obj = BuildersKt.withContext(GridViewModel.this.ioDispatcher, new GridViewModel$importAsPdf$1$importResult$1(GridViewModel.this, this.$requestedUri, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableLiveData3 = (MutableLiveData) this.L$4;
                    mutableLiveData = (MutableLiveData) this.L$3;
                    pageKey2 = (PageKey) this.L$2;
                    file = (File) this.L$1;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                            GridViewModel.this.updateOpenPageKey(pageKey2);
                            obj2 = (ImportStateUI) ImportStateUI.Success.INSTANCE;
                            file.delete();
                            mutableLiveData = mutableLiveData3;
                        } catch (Exception unused) {
                            GridViewModel.reloadFolder$default(GridViewModel.this, false, 1, null);
                            obj2 = (ImportStateUI) ImportStateUI.Failure.Unknown.INSTANCE;
                            file.delete();
                        }
                        mutableLiveData.setValue(obj2);
                        GridViewModel.this._importState.setValue(ImportStateUI.Idle.INSTANCE);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        file.delete();
                        throw th;
                    }
                }
                mutableLiveData = (MutableLiveData) this.L$3;
                mutableLiveData2 = (MutableLiveData) this.L$2;
                file2 = (File) this.L$1;
                importResult = (ImportController.ImportResult) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    pageKey = (PageKey) obj;
                    GridViewModel.this.folderState = FolderState.Loaded;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(importResult);
                    this.L$1 = file2;
                    this.L$2 = pageKey;
                    this.L$3 = mutableLiveData2;
                    this.L$4 = mutableLiveData;
                    this.label = 3;
                } catch (Exception unused2) {
                    mutableLiveData = mutableLiveData2;
                    file = file2;
                    GridViewModel.reloadFolder$default(GridViewModel.this, false, 1, null);
                    obj2 = (ImportStateUI) ImportStateUI.Failure.Unknown.INSTANCE;
                    file.delete();
                } catch (Throwable th3) {
                    th = th3;
                    file = file2;
                    file.delete();
                    throw th;
                }
                if (GridViewModel.this.updatePages(this) != coroutine_suspended) {
                    pageKey2 = pageKey;
                    mutableLiveData3 = mutableLiveData;
                    mutableLiveData = mutableLiveData2;
                    file = file2;
                    GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                    GridViewModel.this.updateOpenPageKey(pageKey2);
                    obj2 = (ImportStateUI) ImportStateUI.Success.INSTANCE;
                    file.delete();
                    mutableLiveData = mutableLiveData3;
                    mutableLiveData.setValue(obj2);
                    GridViewModel.this._importState.setValue(ImportStateUI.Idle.INSTANCE);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            ResultKt.throwOnFailure(obj);
            importResult = (ImportController.ImportResult) obj;
            File file3 = importResult != null ? importResult.file : null;
            mutableLiveData = GridViewModel.this._importState;
            if (importResult != null && importResult.isSuccess() && file3 != null) {
                GridViewModel gridViewModel = GridViewModel.this;
                if (!Intrinsics.areEqual(this.$targetNotebookKey, gridViewModel.getOpenedNotebookKey())) {
                    GridViewModel.this.openedNotebookKey = this.$targetNotebookKey;
                    folderState = FolderState.Loading;
                } else {
                    folderState = FolderState.Updating;
                }
                gridViewModel.folderState = folderState;
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                try {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(importResult);
                    this.L$1 = file3;
                    this.L$2 = mutableLiveData;
                    this.L$3 = mutableLiveData;
                    this.label = 2;
                    obj = BuildersKt.withContext(GridViewModel.this.workDispatcher, new GridViewModel$importAsPdf$1$pageKey$1(GridViewModel.this, this.$targetNotebookKey, file3, this.$lang, null), this);
                    if (obj != coroutine_suspended) {
                        mutableLiveData2 = mutableLiveData;
                        file2 = file3;
                        pageKey = (PageKey) obj;
                        GridViewModel.this.folderState = FolderState.Loaded;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(importResult);
                        this.L$1 = file2;
                        this.L$2 = pageKey;
                        this.L$3 = mutableLiveData2;
                        this.L$4 = mutableLiveData;
                        this.label = 3;
                        if (GridViewModel.this.updatePages(this) != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception unused3) {
                    file = file3;
                    GridViewModel.reloadFolder$default(GridViewModel.this, false, 1, null);
                    obj2 = (ImportStateUI) ImportStateUI.Failure.Unknown.INSTANCE;
                    file.delete();
                } catch (Throwable th4) {
                    th = th4;
                    file = file3;
                    file.delete();
                    throw th;
                }
            } else {
                obj2 = (ImportStateUI) ImportStateUI.Failure.Unknown.INSTANCE;
                mutableLiveData.setValue(obj2);
                GridViewModel.this._importState.setValue(ImportStateUI.Idle.INSTANCE);
                return Unit.INSTANCE;
            }
        }
    }

    public final void selectAll() {
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.SELECTED, null, 12582911, null));
        }
        List<PageModel> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.selectedPages = mutableList;
        List<PageModel> list2 = mutableList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(PageModel.copy$default((PageModel) it2.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, null, ViewCompat.MEASURED_SIZE_MASK, null));
        }
        this.pages = arrayList2;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65123(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$selectAll$3 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$selectAll$3", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65123 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65123(Continuation<? super C65123> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65123(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65123) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void deselectAll() {
        this.selectedPages.clear();
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.UNSELECTED, null, 12582911, null));
        }
        this.pages = arrayList;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64922(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$deselectAll$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$deselectAll$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64922(Continuation<? super C64922> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64922(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64922) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void togglePageSelection(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            PageModel pageModelCopy$default = (PageModel) it.next();
            if (Intrinsics.areEqual(pageModelCopy$default.getPageKey(), pageKey)) {
                if (pageModelCopy$default.getSelectionState() != SelectionState.SELECTED) {
                    this.selectedPages.add(pageModelCopy$default);
                    pageModelCopy$default = PageModel.copy$default(pageModelCopy$default, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.SELECTED, null, 12582911, null);
                } else {
                    List<PageModel> list2 = this.selectedPages;
                    List<PageModel> list3 = list2;
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (Intrinsics.areEqual(((PageModel) next).getPageKey(), pageKey)) {
                            obj = next;
                            break;
                        }
                    }
                    TypeIntrinsics.asMutableCollection(list3).remove(obj);
                    pageModelCopy$default = PageModel.copy$default(pageModelCopy$default, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.UNSELECTED, null, 12582911, null);
                }
            }
            arrayList.add(pageModelCopy$default);
        }
        this.pages = arrayList;
        if (!this.isSelectionMode && !this.selectedPages.isEmpty()) {
            this.isSelectionMode = true;
        } else if (this.isSelectionMode && this.selectedPages.isEmpty()) {
            this.isSelectionMode = false;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65202(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$togglePageSelection$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$togglePageSelection$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65202 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65202(Continuation<? super C65202> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65202(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65202) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object activatePagesSelectionModeInternal(boolean z, Continuation<? super Unit> continuation) {
        if (this.isSelectionMode != z) {
            this.isSelectionMode = z;
            if (!z) {
                this.selectedPages.clear();
            }
            Object objUpdatePages = updatePages(continuation);
            return objUpdatePages == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatePages : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$activatePagesSelectionMode$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$activatePagesSelectionMode$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1336}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1337}, m1615s = {}, m1616v = 2)
    static final class C64871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $activate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64871(boolean z, Continuation<? super C64871> continuation) {
            super(2, continuation);
            this.$activate = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64871(this.$activate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GridViewModel.this.activatePagesSelectionModeInternal(this.$activate, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            return Unit.INSTANCE;
        }
    }

    public final void activatePagesSelectionMode(boolean activate) {
        if (this.isSelectionMode != activate) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64871(activate, null), 3, null);
        }
    }

    public final void setIsBeingModified(boolean modified) {
        this.isBeingModified = modified;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65131(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setIsBeingModified$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setIsBeingModified$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1347}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1350}, m1615s = {}, m1616v = 2)
    static final class C65131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65131(Continuation<? super C65131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (GridViewModel.this.getIsBeingModified()) {
                    this.label = 1;
                    if (GridViewModel.this.activatePagesSelectionModeInternal(false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            return Unit.INSTANCE;
        }
    }

    public final void setViewAvailable(boolean available) {
        this.isViewAvailable = available;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65161(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setViewAvailable$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setViewAvailable$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65161(Continuation<? super C65161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void requestThumbnail(PageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        if (pageModel.isEmpty()) {
            return;
        }
        PageKey pageKey = pageModel.getPageKey();
        File file = new File(this.pageRepository.getThumbnailPath(pageModel.getPageKey(), pageModel.getLastModificationDate()));
        File file2 = file.isFile() ? file : null;
        if (file2 != null) {
            List<PageModel> list = this.pages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PageModel pageModelCopy$default : list) {
                if (Intrinsics.areEqual(pageModelCopy$default.getPageKey(), pageKey)) {
                    pageModelCopy$default = PageModel.copy$default(pageModelCopy$default, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, file2, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null);
                }
                arrayList.add(pageModelCopy$default);
            }
            this.pages = arrayList;
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65102(null), 3, null);
            return;
        }
        this.pageRepository.createThumbnail(pageKey);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$requestThumbnail$2 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$requestThumbnail$2", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65102(Continuation<? super C65102> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65102(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setSorting(Sort sort) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        this.sorting = sort;
        this.ordering = getPreferredOrder(sort);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65141(sort, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setSorting$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setSorting$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1387}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1390}, m1615s = {}, m1616v = 2)
    static final class C65141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Sort $sort;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65141(Sort sort, Continuation<? super C65141> continuation) {
            super(2, continuation);
            this.$sort = sort;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65141(this.$sort, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setSorting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setSorting$1$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Sort $sort;
            int label;
            final /* synthetic */ GridViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GridViewModel gridViewModel, Sort sort, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = gridViewModel;
                this.$sort = sort;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$sort, continuation);
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
                    this.this$0.setPreferredSort(this.$sort);
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
                if (BuildersKt.withContext(GridViewModel.this.ioDispatcher, new AnonymousClass1(GridViewModel.this, this.$sort, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            return Unit.INSTANCE;
        }
    }

    public final void setSortingOrder(Order order) {
        Intrinsics.checkNotNullParameter(order, "order");
        this.ordering = order;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65151(order, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setSortingOrder$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setSortingOrder$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {1398}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1402}, m1615s = {}, m1616v = 2)
    static final class C65151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Order $order;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65151(Order order, Continuation<? super C65151> continuation) {
            super(2, continuation);
            this.$order = order;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65151(this.$order, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$setSortingOrder$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: GridViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$setSortingOrder$1$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Order $order;
            int label;
            final /* synthetic */ GridViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GridViewModel gridViewModel, Order order, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = gridViewModel;
                this.$order = order;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$order, continuation);
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
                    this.this$0.setPreferredOrder(this.$order);
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
                if (BuildersKt.withContext(GridViewModel.this.ioDispatcher, new AnonymousClass1(GridViewModel.this, this.$order, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$toggleSortMenu$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$toggleSortMenu$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65211(Continuation<? super C65211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleSortMenu() {
        this.isSortMenuOpen = !this.isSortMenuOpen;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65211(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreferredSort(Sort sort) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(PREF_SORT_KEY, sort.name());
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sort getPreferredSort() {
        String string = this.sharedPreferences.getString(PREF_SORT_KEY, "Manual");
        return Sort.valueOf(string != null ? string : "Manual");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreferredOrder(Order order) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$0[this.sorting.ordinal()];
        if (i == 1) {
            str = PREF_CREATION_SORT_ORDER_KEY;
        } else if (i == 2) {
            str = PREF_MODIFICATION_SORT_ORDER_KEY;
        } else if (i != 3) {
            return;
        } else {
            str = PREF_ALPHABETICAL_SORT_ORDER_KEY;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(str, order.name());
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[PHI: r3
      0x0037: PHI (r3v6 java.lang.String) = (r3v4 java.lang.String), (r3v8 java.lang.String), (r3v10 java.lang.String) binds: [B:16:0x0034, B:13:0x0029, B:10:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Order getPreferredOrder(Sort sorting) {
        String string;
        int i = WhenMappings.$EnumSwitchMapping$0[sorting.ordinal()];
        String str = "Ascending";
        if (i == 1) {
            string = this.sharedPreferences.getString(PREF_CREATION_SORT_ORDER_KEY, "Ascending");
            if (string != null) {
            }
        } else if (i == 2) {
            str = "Descending";
            string = this.sharedPreferences.getString(PREF_MODIFICATION_SORT_ORDER_KEY, "Descending");
            if (string != null) {
            }
        } else if (i == 3 && (string = this.sharedPreferences.getString(PREF_ALPHABETICAL_SORT_ORDER_KEY, "Ascending")) != null) {
            str = string;
        }
        return Order.valueOf(str);
    }

    private final boolean isLanguageAvailable(PageKey pageKey) {
        return this.pageRepository.isLanguageAvailable(pageKey);
    }

    public final void toggleNotesDisplayMode() {
        setCurrentDisplayMode(this.currentDisplayMode instanceof DisplayMode.Grid ? DisplayMode.List.INSTANCE : DisplayMode.Grid.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65191(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$toggleNotesDisplayMode$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$toggleNotesDisplayMode$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65191(Continuation<? super C65191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DisplayMode getPreferredDisplayMode() {
        return DisplayMode.Grid.INSTANCE.toDisplayMode(this.sharedPreferences.getString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, null), this.defaultDisplayMode);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$installedLanguagesUpdated$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$installedLanguagesUpdated$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64991(Continuation<? super C64991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C64991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GridViewModel.this._folderUIState.setValue(GridViewModel.this.computeFolderUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void installedLanguagesUpdated() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64991(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$onBannerActionButtonClicked$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$onBannerActionButtonClicked$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65041(Continuation<? super C65041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GridViewModel.this.new C65041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GridViewModel.this.getShowPaywallEvent().setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    public final void onBannerActionButtonClicked() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65041(null), 2, null);
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewModel$Companion;", "", "<init>", "()V", "hasStoragePopupBeenShown", "", GridViewModel.PREF_SORT_KEY, "", GridViewModel.PREF_ALPHABETICAL_SORT_ORDER_KEY, GridViewModel.PREF_CREATION_SORT_ORDER_KEY, GridViewModel.PREF_MODIFICATION_SORT_ORDER_KEY, "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final GridViewModel Companion$Factory$lambda$0$0(CreationExtras initializer) {
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
            final LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository();
            TechnicalLogger technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) applicationRequireApplication).provideTechnicalLogger();
            PdfImporter pdfImporter = new PdfImporter(applicationRequireApplication, libraryRepositoryProvideLibraryRepository.getWorkingDirectory());
            NeboFileImporter neboFileImporter = new NeboFileImporter(applicationRequireApplication, libraryRepositoryProvideLibraryRepository.getWorkingDirectory());
            UserProfileManager userProfileManagerProvideUserProfileManager = ((UserProfileManager.Provider) applicationRequireApplication).provideUserProfileManager();
            ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository = ((ISubscriptionRepository.Provider) applicationRequireApplication).provideSubscriptionRepository();
            NeboNetworkStateRepository neboNetworkStateRepositoryProvideNeboNetworkStateRepository = ((NeboNetworkStateRepositoryProvider) applicationRequireApplication).provideNeboNetworkStateRepository();
            Application application = applicationRequireApplication;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
            DisplayMode displayMode = applicationRequireApplication.getResources().getBoolean(C6079R.bool.side_panel_fullscreen) ? DisplayMode.List.INSTANCE : DisplayMode.Grid.INSTANCE;
            ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
            UserData userDataProvideUserData = ((UserData.Provider) componentCallbacks2RequireApplication).provideUserData();
            AvailableSpaceProviderImpl availableSpaceProviderImpl = new AvailableSpaceProviderImpl(application);
            DMSSearchController searchController = libraryRepositoryProvideLibraryRepository.getSearchController();
            Intrinsics.checkNotNull(defaultSharedPreferences);
            return new GridViewModel(libraryRepositoryProvideLibraryRepository, availableSpaceProviderImpl, userProfileManagerProvideUserProfileManager, iSubscriptionRepositoryProvideSubscriptionRepository, neboNetworkStateRepositoryProvideNeboNetworkStateRepository, displayMode, defaultSharedPreferences, userDataProvideUserData, pdfImporter, neboFileImporter, searchController, technicalLoggerProvideTechnicalLogger, new Function0() { // from class: com.myscript.nebo.grid.GridViewModel$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return libraryRepositoryProvideLibraryRepository.getLastChosenLanguage();
                }
            }, null, null, null, 57344, null);
        }
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(GridViewModel.class), new Function1() { // from class: com.myscript.nebo.grid.GridViewModel$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridViewModel.Companion.Companion$Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
