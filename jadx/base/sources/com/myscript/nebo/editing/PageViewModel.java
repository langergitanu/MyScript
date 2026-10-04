package com.myscript.nebo.editing;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.DisplayMetrics;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.provider.CredentialEntry;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ColorExt;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.BackgroundPatternExt;
import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.IMessageListener;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.atk.core.KeyboardAction;
import com.myscript.atk.core.MessageIdentifier;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.core.Settings;
import com.myscript.atk.p021ui.ActionMenuCallback;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.atk.p021ui.MenuType;
import com.myscript.atk.text.ClipboardConfiguration;
import com.myscript.atk.text.SWIGClipboard;
import com.myscript.atk.text.UserDictionary;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.ColorPolicyRepository;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.PdfOptimizationLevel;
import com.myscript.nebo.dms.core.PdfOptimizationResult;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.ImageImportState;
import com.myscript.nebo.editing.PageParam;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.nebo.featureflags.RuntimeFeatureFlagHelper;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.penpanel.KeyboardSettings;
import com.myscript.nebo.userdict.UserDictionaryInputChecker;
import com.myscript.nebo.userdict.p035ui.InputStatus;
import com.myscript.nebo.utils.EarlyAccessFeature;
import com.myscript.snt.core.CompositeBox;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.IPageStateListener;
import com.myscript.snt.core.NeboCustomTheme;
import com.myscript.snt.core.NeboEngine;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.internal.url._UrlKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0093\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001e*\u0003Q\u009c\u0001\b\u0007\u0018\u0000 \u0097\u00022\u00020\u0001:\u000e\u0091\u0002\u0092\u0002\u0093\u0002\u0094\u0002\u0095\u0002\u0096\u0002\u0097\u0002B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020XJ\u000e\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020\\J\u0007\u0010\u0095\u0001\u001a\u00020XJ\u0012\u0010\u009e\u0001\u001a\u00020X2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010>J\t\u0010 \u0001\u001a\u00020XH\u0017J\u0007\u0010¡\u0001\u001a\u00020XJ\u0007\u0010¢\u0001\u001a\u00020XJ\u001f\u0010£\u0001\u001a\u00020X2\t\b\u0002\u0010¤\u0001\u001a\u00020\u00132\t\b\u0002\u0010¥\u0001\u001a\u00020\u0013H\u0007J\u0012\u0010¦\u0001\u001a\u0004\u0018\u00010>2\u0007\u0010§\u0001\u001a\u00020>J+\u0010¨\u0001\u001a\u00020X2\b\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010«\u0001\u001a\u00020\u00132\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001J\u0007\u0010¯\u0001\u001a\u00020XJ\u0012\u0010¯\u0001\u001a\u00020X2\u0007\u0010°\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010±\u0001\u001a\u00020k2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010>J\u0011\u0010²\u0001\u001a\u00020X2\b\u0010³\u0001\u001a\u00030´\u0001J\u0012\u0010µ\u0001\u001a\u00020X2\t\b\u0001\u0010¶\u0001\u001a\u00020%J%\u0010·\u0001\u001a\n\u0012\u0005\u0012\u00030¸\u00010\u00ad\u0001*\t\u0012\u0004\u0012\u00020%0\u00ad\u00012\u0007\u0010¹\u0001\u001a\u00020%H\u0002J\u001b\u0010º\u0001\u001a\u00020X2\b\u0010»\u0001\u001a\u00030¼\u00012\b\u0010½\u0001\u001a\u00030¼\u0001J\u001b\u0010¾\u0001\u001a\u00020X2\b\u0010»\u0001\u001a\u00030¼\u00012\b\u0010½\u0001\u001a\u00030¼\u0001J\u0013\u0010¿\u0001\u001a\u00020\u00132\n\u0010À\u0001\u001a\u0005\u0018\u00010¼\u0001J\u0011\u0010Á\u0001\u001a\u00020X2\b\u0010À\u0001\u001a\u00030¼\u0001J\u0011\u0010Â\u0001\u001a\u00020\u00132\b\u0010À\u0001\u001a\u00030¼\u0001J4\u0010Ã\u0001\u001a\u00020X*\u00020\u000b2%\u0010Ä\u0001\u001a \u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\bÆ\u0001\u0012\t\bÇ\u0001\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020X0Å\u0001H\u0002J\u0017\u0010È\u0001\u001a\u00020X2\u000e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020X0Ê\u0001J \u0010Ë\u0001\u001a\u00020X2\u0015\u0010É\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020X0Å\u0001H\u0002J\u0007\u0010Ì\u0001\u001a\u00020XJ\u0007\u0010Í\u0001\u001a\u00020XJ\u0007\u0010Î\u0001\u001a\u00020XJ\u0007\u0010Ï\u0001\u001a\u00020XJ\u0011\u0010Ð\u0001\u001a\u00020\u00132\b\u0010Ñ\u0001\u001a\u00030Ò\u0001J#\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030¼\u00010\u00ad\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u0001J\u0007\u0010×\u0001\u001a\u00020XJ\u0011\u0010Ø\u0001\u001a\u00020X2\b\u0010Ù\u0001\u001a\u00030¼\u0001J%\u0010Ú\u0001\u001a\u00020X2\b\u0010Ù\u0001\u001a\u00030¼\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u0001J\u0013\u0010Û\u0001\u001a\u00020\u00132\b\u0010Ü\u0001\u001a\u00030¼\u0001H\u0002J/\u0010Ý\u0001\u001a\u00020X2\b\u0010Þ\u0001\u001a\u00030ß\u00012\u001c\u0010à\u0001\u001a\u0017\u0012\u0005\u0012\u00030â\u0001\u0012\u0005\u0012\u00030¼\u0001\u0012\u0004\u0012\u00020X0á\u0001JH\u0010Ý\u0001\u001a\u00020X2\b\u0010Þ\u0001\u001a\u00030ß\u00012\u001c\u0010à\u0001\u001a\u0017\u0012\u0005\u0012\u00030â\u0001\u0012\u0005\u0012\u00030¼\u0001\u0012\u0004\u0012\u00020X0á\u00012\u0017\b\u0002\u0010ã\u0001\u001a\u0010\u0012\u0005\u0012\u00030â\u0001\u0012\u0004\u0012\u00020X0Å\u0001J\u0011\u0010Ý\u0001\u001a\u00020X2\b\u0010Þ\u0001\u001a\u00030ß\u0001J\u001b\u0010Ý\u0001\u001a\u00020X2\b\u0010ä\u0001\u001a\u00030¼\u00012\b\u0010Ü\u0001\u001a\u00030¼\u0001J%\u0010å\u0001\u001a\u00020X2\b\u0010Þ\u0001\u001a\u00030ß\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u0001J/\u0010å\u0001\u001a\u00020X2\b\u0010æ\u0001\u001a\u00030â\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u00012\b\u0010Ü\u0001\u001a\u00030¼\u0001J\u001b\u0010ç\u0001\u001a\u00020X2\b\u0010ä\u0001\u001a\u00030¼\u00012\b\u0010Ü\u0001\u001a\u00030¼\u0001J\u0011\u0010è\u0001\u001a\u00020X2\b\u0010Ñ\u0001\u001a\u00030Ò\u0001J\u0007\u0010é\u0001\u001a\u00020\u0013J\u0007\u0010ê\u0001\u001a\u00020XJ\u001b\u0010ë\u0001\u001a\u00020X2\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u0001J%\u0010ì\u0001\u001a\u00020X2\b\u0010í\u0001\u001a\u00030¼\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030Õ\u0001J\u0007\u0010î\u0001\u001a\u00020XJ\u0007\u0010ï\u0001\u001a\u00020XJ\u0007\u0010ð\u0001\u001a\u00020XJ\u0007\u0010ñ\u0001\u001a\u00020XJ\u0007\u0010ò\u0001\u001a\u00020XJ\u0007\u0010ó\u0001\u001a\u00020XJ\u0007\u0010ô\u0001\u001a\u00020XJ\u0011\u0010õ\u0001\u001a\u00020X2\b\u0010ö\u0001\u001a\u00030¼\u0001J\u0007\u0010÷\u0001\u001a\u00020XJ\u0007\u0010ø\u0001\u001a\u00020XJ\u0013\u0010ù\u0001\u001a\u00020X2\b\u0010É\u0001\u001a\u00030ú\u0001H\u0002J\u0007\u0010û\u0001\u001a\u00020XJ\u0007\u0010ü\u0001\u001a\u00020XJ\u0007\u0010ý\u0001\u001a\u00020XJ\u0007\u0010þ\u0001\u001a\u00020XJ\u0007\u0010ÿ\u0001\u001a\u00020XJ\u0007\u0010\u0080\u0002\u001a\u00020\u0013J\u0007\u0010\u0081\u0002\u001a\u00020\u0013J\u0010\u0010\u0082\u0002\u001a\u00020X2\u0007\u0010\u0083\u0002\u001a\u00020\u0013J\u0007\u0010\u0084\u0002\u001a\u00020XJ\u0007\u0010\u0085\u0002\u001a\u00020\u0013J\u0012\u0010\u0086\u0002\u001a\u00020X2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010qJ\u0007\u0010\u0088\u0002\u001a\u00020\u0013J\u0010\u0010t\u001a\u00020X2\b\u0010\u0089\u0002\u001a\u00030Õ\u0001J\u0007\u0010\u008a\u0002\u001a\u00020XJ\u0007\u0010\u008b\u0002\u001a\u00020XJ\u0011\u0010\u008c\u0002\u001a\u00020X2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0011\u0010\u008d\u0002\u001a\u00020X2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0007\u0010\u008e\u0002\u001a\u00020XJ\u0012\u0010\u008f\u0002\u001a\u00020X2\u0007\u0010\u0090\u0002\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0$¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002030/8F¢\u0006\u0006\u001a\u0004\b5\u00101R\u001c\u00106\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00130\u00130,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00130/8F¢\u0006\u0006\u001a\u0004\b9\u00101R\u0011\u0010:\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\bB\u0010@R\u0011\u0010C\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bF\u0010ER\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bK\u0010ER\u001c\u0010L\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010M0M0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020M0/8F¢\u0006\u0006\u001a\u0004\bO\u00101R\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010RR\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020T0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020T0/8F¢\u0006\u0006\u001a\u0004\bV\u00101R&\u0010^\u001a\u00020%2\u0006\u0010]\u001a\u00020%8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010c\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010E\"\u0004\be\u0010fR\u000e\u0010g\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010h\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\bi\u0010`R\u001c\u0010j\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010k0k0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020k0/8F¢\u0006\u0006\u001a\u0004\bm\u00101R\u0014\u0010n\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010ER\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010r\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010s0s0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020s0/8F¢\u0006\u0006\u001a\u0004\bu\u00101R\u0014\u0010v\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020z0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020z0/8F¢\u0006\u0006\u001a\u0004\b|\u00101R\u0015\u0010}\u001a\u00020~8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00018F¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010/8F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u00101R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u008b\u0001\u001a\u0012\u0012\u000e\u0012\f 7*\u0005\u0018\u00010\u008c\u00010\u008c\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010/8F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u00101R\u001f\u0010\u008f\u0001\u001a\u0012\u0012\u000e\u0012\f 7*\u0005\u0018\u00010\u0090\u00010\u0090\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010/8F¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u00101R\u0016\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020X0\u0094\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001¨\u0006\u0098\u0002"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel;", "Landroidx/lifecycle/AndroidViewModel;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "repository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "clipboard", "Lcom/myscript/nebo/editing/INativeClipboardExtended;", "userDictionary", "Lcom/myscript/atk/text/UserDictionary;", "colorPolicyRepository", "Lcom/myscript/nebo/common/ColorPolicyRepository;", "imageImporter", "Lcom/myscript/nebo/editing/ImageImporter;", "keyboardSettings", "Lcom/myscript/nebo/penpanel/KeyboardSettings;", "isDarkMode", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workDispatcher", "userDictionaryDispatcher", "autoSaveScheduler", "Ljava/util/concurrent/ScheduledExecutorService;", "autoSavePeriodMs", "", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lcom/myscript/nebo/editing/INativeClipboardExtended;Lcom/myscript/atk/text/UserDictionary;Lcom/myscript/nebo/common/ColorPolicyRepository;Lcom/myscript/nebo/editing/ImageImporter;Lcom/myscript/nebo/penpanel/KeyboardSettings;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/util/concurrent/ScheduledExecutorService;J)V", "isTimeConsumingActionOngoing", "autoSaveTask", "Ljava/util/concurrent/ScheduledFuture;", "messageNotificationHandler", "Lcom/myscript/nebo/editing/MessageNotificationHandler;", "messageNotification", "Lcom/myscript/android/utils/SingleLiveEvent;", "", "getMessageNotification", "()Lcom/myscript/android/utils/SingleLiveEvent;", "messageNotificationIdentifier", "Lcom/myscript/atk/core/MessageIdentifier;", "getMessageNotificationIdentifier", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/editing/PageViewModel$State;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "_pageProperties", "Lcom/myscript/nebo/editing/PageProperties;", "pageProperties", "getPageProperties", "_activityIndicator", "kotlin.jvm.PlatformType", "activityIndicator", "getActivityIndicator", "openPageProperties", "getOpenPageProperties", "()Lcom/myscript/nebo/editing/PageProperties;", "containerPageKey", "Lcom/myscript/snt/core/PageKey;", "getContainerPageKey", "()Lcom/myscript/snt/core/PageKey;", "openPageKey", "getOpenPageKey", "showKeyboardOnTap", "getShowKeyboardOnTap", "()Z", "isActivePenEnabled", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "getCurrentToolType", "()Lcom/myscript/snt/core/ToolType;", "isCurrentToolInteracting", "_showFreemiumLimitation", "Lcom/myscript/nebo/editing/PageViewModel$FreemiumLimitationDialogState;", "showFreemiumLimitation", "getShowFreemiumLimitation", "freemiumGestureListener", "com/myscript/nebo/editing/PageViewModel$freemiumGestureListener$1", "Lcom/myscript/nebo/editing/PageViewModel$freemiumGestureListener$1;", "_pdfOptimizationUiState", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "pdfOptimizationUiState", "getPdfOptimizationUiState", "showPdfOptimizationDialog", "", "dismissPdfOptimizationDialog", "optimizePdf", FirebaseAnalytics.Param.LEVEL, "Lcom/myscript/nebo/dms/core/PdfOptimizationLevel;", "value", "tintColor", "getTintColor", "()I", "setTintColor", "(I)V", "darkMode", "getDarkMode", "setDarkMode", "(Z)V", "selectedBackgroundColorIndex", "selectedBackgroundColor", "getSelectedBackgroundColor", "_backgroundSettingsUIState", "Lcom/myscript/nebo/editing/BackgroundSettingsUIState;", "backgroundSettingsUIState", "getBackgroundSettingsUIState", "showZoomPanel", "getShowZoomPanel", "zoomController", "Lcom/myscript/nebo/editing/EditingController$ZoomController;", "_zoom", "Lcom/myscript/nebo/editing/ZoomState;", "zoom", "getZoom", "currentZoomState", "getCurrentZoomState", "()Lcom/myscript/nebo/editing/ZoomState;", "_imageImportState", "Lcom/myscript/nebo/editing/ImageImportState;", "imageImportState", "getImageImportState", "optionContext", "Lcom/myscript/snt/core/SWIGOptionContext;", "getOptionContext", "()Lcom/myscript/snt/core/SWIGOptionContext;", "pageController", "Lcom/myscript/snt/core/PageController;", "getPageController", "()Lcom/myscript/snt/core/PageController;", "_actionMenuState", "Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState;", "actionMenuState", "getActionMenuState", "onActionMenuUpdate", "Lcom/myscript/nebo/editing/ActionMenuListener;", "_pageState", "Lcom/myscript/nebo/editing/PageViewModel$PageState;", "pageState", "getPageState", "_menuCapabilities", "Lcom/myscript/nebo/editing/PageViewModel$MenuCapabilities;", "menuCapabilities", "getMenuCapabilities", "menuCapabilitiesRefresh", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "refreshMenuCapabilities", "onPageStateChange", "Lcom/myscript/snt/core/IPageStateListener;", "userDictionaryNewNativeRef", "getUserDictionaryNewNativeRef", "()Lcom/myscript/atk/text/UserDictionary;", "pageListener", "com/myscript/nebo/editing/PageViewModel$pageListener$1", "Lcom/myscript/nebo/editing/PageViewModel$pageListener$1;", "preloadPage", "pageKey", "onCleared", "startAutoSave", "stopAutoSave", "save", "temporary", "synchronous", "createSiblingPage", "sourcePageKey", "loadPage", "displayMetrics", "Landroid/util/DisplayMetrics;", "withSmartGuide", "customResources", "", "Lcom/myscript/atk/core/CustomResource;", "unloadPage", "closePage", "computeBackgroundSettingsUIState", "setBackgroundPattern", "pattern", "Lcom/myscript/atk/core/BackgroundPattern;", "setBackgroundColor", "color", "toUIModel", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "selectedIndex", "tagCorruptionInfoPage", "reason", "", "message", "tagCorruptionWarningInfoPage", "canLearnWord", "word", "forgetWord", "learnWord", "edit", "editAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "timeConsumingAction", "action", "Lkotlin/Function0;", "timeConsumingPageControllerAction", "undo", "redo", "clearAll", "convertAll", "isSpaceManagementAvailableAt", "pointerInfo", "Lcom/myscript/atk/core/PointerInfo;", "getAvailableBlockTypesAt", "x", "", "y", "convertSelection", "addBlock", "blockType", "addBlockAt", "canHandleImageMimeType", "mimeType", "addImage", "uri", "Landroid/net/Uri;", "addFn", "Lkotlin/Function2;", "Ljava/io/File;", "deleteFn", ClientCookie.PATH_ATTR, "addImageAt", "imageFile", "replaceSelectedImage", "spaceManagementAt", "canPaste", "paste", "pasteAt", "pasteTextAt", "text", "selectionAsOrderedList", "selectionAsUnorderedList", "selectionAsCheckedList", "selectionAsText", "indentSelection", "unindentSelection", "copySelection", "copyAs", "contentType", "cutSelection", "deleteSelection", "keyboardAction", "Lcom/myscript/atk/core/KeyboardAction;", "emboldenSelection", "underlineSelection", "doubleUnderlineSelection", "strikeThrough", "highlightSelection", "canConvertInlineSelection", "hasFreeformAlignmentGuides", "setFreeformAlignmentGuides", "enable", "toggleInteractionsToShowKeyboard", "canIndentInlineSelection", "setZoomController", "controller", "checkZoomNotLocked", "zoomFactor", "toggleLockZoom", "zoomLockedNotificationTakenIntoAccount", "registerPageStateListener", "unregisterPageStateListener", "hideFreemiumLimitationDialog", "setConversionEnabled", "enabled", "State", "FreemiumLimitationDialogState", "PdfOptimizationUiState", "ActionMenuState", "PageState", "MenuCapabilities", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageViewModel extends AndroidViewModel {
    private static final ClipboardConfiguration CLIPBOARD_CONFIGURATION;
    private static final DocumentTouchController.ZoomListener.ZoomFromReference DEFAULT_ZOOM_FROM_REFERENCE;
    private static final String FREEFORM_ALIGNMENT_GUIDES_KEY = "FREEFORM_ALIGNMENT_GUIDES_KEY";
    private static final long PDF_OPTIM_RESULT_VISIBLE_MS = 800;
    private static final String PREF_CONVERT_AS_TEXT_OR_MATH_PDF = "pdf.convert-as-menu";
    private static final String PREF_CONVERT_AS_TEXT_OR_MATH_RAW_CONTENT = "convert-as-menu";
    private static final String PREF_INTERACTIVITY_STRIKE_THROUGH_DOCUMENT_KEY = "gesture.strike-through.behavior";
    private static final String PREF_INTERACTIVITY_STRIKE_THROUGH_NOTE_KEY = "gesture.strike-through.behavior";
    private static final String PREF_INTERACTIVITY_STRIKE_THROUGH_PDF_KEY = "pdf.gesture.strike-through.behavior";
    private static final String PREF_INTERACTIVITY_UNDERLINE_WORDS_DOCUMENT_KEY = "gesture.underlines.behavior";
    private static final String PREF_INTERACTIVITY_UNDERLINE_WORDS_NOTE_KEY = "gesture.underlines.behavior";
    private static final String PREF_INTERACTIVITY_UNDERLINE_WORDS_PDF_KEY = "pdf.gesture.underlines.behavior";
    private static final String PREF_MATH_EARLY_ACCESS_FEATURE_KEY = "mathbonus.enable";
    private static final String PREF_PDF_AI_QUIZ = "pdf.ai.quiz.enable";
    private static final String PREF_PDF_EARLY_ACCESS_FEATURE_KEY = "pdf.pdf-bonus";
    private static final String PREF_PDF_ZOOM_WHOLE_PAGE = "pdf.fullpage.zoomout";
    private static final String PREF_RAW_CONTENT_AI_QUIZ = "raw-content.ai.quiz.enable";
    private static final String PREF_SHAPE_EARLY_ACCESS_FEATURE_KEY = "shapebonus.enable";
    private static final String PREF_TEXT_AI_QUIZ = "text.ai.quiz.enable";
    private static final String PREF_TEXT_DOCUMENT_CONTENT_AI_QUIZ = "text-document.ai.quiz.enable";
    private final MutableLiveData<ActionMenuState> _actionMenuState;
    private final MutableLiveData<Boolean> _activityIndicator;
    private final MutableLiveData<BackgroundSettingsUIState> _backgroundSettingsUIState;
    private final MutableLiveData<ImageImportState> _imageImportState;
    private final MutableLiveData<MenuCapabilities> _menuCapabilities;
    private final MutableLiveData<PageProperties> _pageProperties;
    private final MutableLiveData<PageState> _pageState;
    private final MutableLiveData<PdfOptimizationUiState> _pdfOptimizationUiState;
    private final MutableLiveData<FreemiumLimitationDialogState> _showFreemiumLimitation;
    private final MutableLiveData<State> _state;
    private final MutableLiveData<ZoomState> _zoom;
    private final long autoSavePeriodMs;
    private final ScheduledExecutorService autoSaveScheduler;
    private ScheduledFuture<?> autoSaveTask;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final INativeClipboardExtended clipboard;
    private final ColorPolicyRepository colorPolicyRepository;
    private boolean darkMode;
    private final PageViewModel$freemiumGestureListener$1 freemiumGestureListener;
    private final ImageImporter imageImporter;
    private boolean isTimeConsumingActionOngoing;
    private final KeyboardSettings keyboardSettings;
    private final CoroutineDispatcher mainDispatcher;
    private final MutableSharedFlow<Unit> menuCapabilitiesRefresh;
    private final SingleLiveEvent<Integer> messageNotification;
    private final MessageNotificationHandler messageNotificationHandler;
    private final SingleLiveEvent<MessageIdentifier> messageNotificationIdentifier;
    private final ActionMenuListener onActionMenuUpdate;
    private final IPageStateListener onPageStateChange;
    private final PageViewModel$pageListener$1 pageListener;
    private final LibraryRepository repository;
    private int selectedBackgroundColorIndex;
    private int tintColor;
    private final UserDictionary userDictionary;
    private final CoroutineDispatcher userDictionaryDispatcher;
    private final CoroutineDispatcher workDispatcher;
    private EditingController.ZoomController zoomController;
    public static final int $stable = 8;

    public final void save() {
        save$default(this, false, false, 3, null);
    }

    public final void save(boolean z) {
        save$default(this, z, false, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.myscript.nebo.editing.PageViewModel$pageListener$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.myscript.nebo.editing.PageViewModel$freemiumGestureListener$1] */
    public PageViewModel(Application application, LibraryRepository repository, IAutoSyncTimerManager autoSyncTimerManager, INativeClipboardExtended clipboard, UserDictionary userDictionary, ColorPolicyRepository colorPolicyRepository, ImageImporter imageImporter, KeyboardSettings keyboardSettings, boolean z, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workDispatcher, CoroutineDispatcher userDictionaryDispatcher, ScheduledExecutorService autoSaveScheduler, long j) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(clipboard, "clipboard");
        Intrinsics.checkNotNullParameter(userDictionary, "userDictionary");
        Intrinsics.checkNotNullParameter(colorPolicyRepository, "colorPolicyRepository");
        Intrinsics.checkNotNullParameter(imageImporter, "imageImporter");
        Intrinsics.checkNotNullParameter(keyboardSettings, "keyboardSettings");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        Intrinsics.checkNotNullParameter(userDictionaryDispatcher, "userDictionaryDispatcher");
        Intrinsics.checkNotNullParameter(autoSaveScheduler, "autoSaveScheduler");
        this.repository = repository;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.clipboard = clipboard;
        this.userDictionary = userDictionary;
        this.colorPolicyRepository = colorPolicyRepository;
        this.imageImporter = imageImporter;
        this.keyboardSettings = keyboardSettings;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this.userDictionaryDispatcher = userDictionaryDispatcher;
        this.autoSaveScheduler = autoSaveScheduler;
        this.autoSavePeriodMs = j;
        MessageNotificationHandler messageNotificationHandler = new MessageNotificationHandler(((TechnicalLoggerProvider) application).provideTechnicalLogger());
        this.messageNotificationHandler = messageNotificationHandler;
        this.messageNotification = messageNotificationHandler.getMessage$app_standardRelease();
        this.messageNotificationIdentifier = messageNotificationHandler.getMessageIdentifier$app_standardRelease();
        this._state = new MutableLiveData<>();
        this._pageProperties = new MutableLiveData<>();
        this._activityIndicator = new MutableLiveData<>(false);
        this._showFreemiumLimitation = new MutableLiveData<>(new FreemiumLimitationDialogState(false, null, 3, null == true ? 1 : 0));
        this.freemiumGestureListener = new IMessageListener() { // from class: com.myscript.nebo.editing.PageViewModel$freemiumGestureListener$1

            /* JADX INFO: compiled from: PageViewModel.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
                }
            }

            @Override // com.myscript.atk.core.IMessageListener
            public void notify(String key, List<String> message, String activeArea, String blockType, String contentType) {
            }

            @Override // com.myscript.atk.core.IMessageListener
            public void notify(String key, MessageIdentifier messageId, String activeArea, String blockType, String contentType) {
                int i = messageId == null ? -1 : WhenMappings.$EnumSwitchMapping$0[messageId.ordinal()];
                if (i == 1 || i == 2) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new PageViewModel$freemiumGestureListener$1$notify$1(this.this$0, messageId, null), 2, null);
                }
            }
        };
        this._pdfOptimizationUiState = new MutableLiveData<>(PdfOptimizationUiState.Hidden.INSTANCE);
        this.darkMode = z;
        this.selectedBackgroundColorIndex = -1;
        this._backgroundSettingsUIState = new MutableLiveData<>(new BackgroundSettingsUIState(CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        this._zoom = new MutableLiveData<>(new ZoomState(false, false, 0.0f, false, false, 31, null));
        this._imageImportState = new MutableLiveData<>(ImageImportState.Idle.INSTANCE);
        this._actionMenuState = new MutableLiveData<>(ActionMenuState.Closed.INSTANCE);
        this.onActionMenuUpdate = new ActionMenuListener(new Function4() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PageViewModel.onActionMenuUpdate$lambda$0(this.f$0, (ActionMenuEntry[]) obj, (Point) obj2, (Point) obj3, (ActionMenuCallback) obj4);
            }
        });
        boolean z3 = false;
        this._pageState = new MutableLiveData<>(new PageState(z2, false, z3, 7, defaultConstructorMarker));
        this._menuCapabilities = new MutableLiveData<>(new MenuCapabilities(z2, null, z3, false, false, false, false, 127, defaultConstructorMarker));
        this.menuCapabilitiesRefresh = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), workDispatcher, null, new C64041(null), 2, null);
        this.onPageStateChange = new PageStateListenerAdapter() { // from class: com.myscript.nebo.editing.PageViewModel$onPageStateChange$1
            @Override // com.myscript.nebo.editing.PageStateListenerAdapter, com.myscript.snt.core.IPageStateListener
            public void pageStateChanged(boolean canUndo, boolean canRedo, boolean hasContent) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new PageViewModel$onPageStateChange$1$pageStateChanged$1(this.this$0, canUndo, canRedo, hasContent, null), 2, null);
                this.this$0.refreshMenuCapabilities();
            }
        };
        this.pageListener = new LibraryRepository.PageListener() { // from class: com.myscript.nebo.editing.PageViewModel$pageListener$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUpdated(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                PageModel page = this.this$0.repository.getPage(pageKey);
                if (page == null) {
                    return;
                }
                int i = this.this$0.selectedBackgroundColorIndex;
                int backgroundColor = page.getBackgroundColor();
                int iIndexOf = PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().indexOf(Integer.valueOf(backgroundColor));
                BackgroundPattern pageBackgroundPattern = this.this$0.getOpenPageProperties().getPageBackgroundPattern();
                BackgroundPattern backgroundPattern = page.getBackgroundPattern();
                if (i == iIndexOf && pageBackgroundPattern == backgroundPattern) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new PageViewModel$pageListener$1$onPageUpdated$1(this.this$0, backgroundColor, backgroundPattern, iIndexOf, pageKey, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageDeleted(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                this.this$0.repository.removePageListener(pageKey, this);
                this.this$0.save(false, true);
                this.this$0.unloadPage(true);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUUIDReset(PageKey previousKey, PageKey newKey) {
                Intrinsics.checkNotNullParameter(previousKey, "previousKey");
                Intrinsics.checkNotNullParameter(newKey, "newKey");
                this.this$0.repository.removePageListener(previousKey, this);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new PageViewModel$pageListener$1$onPageUUIDReset$1(this.this$0, newKey, this, null), 3, null);
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PageViewModel(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager iAutoSyncTimerManager, INativeClipboardExtended iNativeClipboardExtended, UserDictionary userDictionary, ColorPolicyRepository colorPolicyRepository, ImageImporter imageImporter, KeyboardSettings keyboardSettings, boolean z, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, ScheduledExecutorService scheduledExecutorService, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        CoroutineDispatcher coroutineDispatcherFrom;
        ScheduledExecutorService scheduledExecutorService2;
        boolean z2 = (i & 256) != 0 ? false : z;
        CoroutineDispatcher main = (i & 512) != 0 ? Dispatchers.getMain() : coroutineDispatcher;
        CoroutineDispatcher coroutineDispatcher4 = (i & 1024) != 0 ? Dispatchers.getDefault() : coroutineDispatcher2;
        if ((i & 2048) != 0) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            coroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        } else {
            coroutineDispatcherFrom = coroutineDispatcher3;
        }
        if ((i & 4096) != 0) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
            scheduledExecutorService2 = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        } else {
            scheduledExecutorService2 = scheduledExecutorService;
        }
        this(application, libraryRepository, iAutoSyncTimerManager, iNativeClipboardExtended, userDictionary, colorPolicyRepository, imageImporter, keyboardSettings, z2, main, coroutineDispatcher4, coroutineDispatcherFrom, scheduledExecutorService2, (i & 8192) != 0 ? 5000L : j);
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$State;", "", "<init>", "()V", "pageKey", "Lcom/myscript/snt/core/PageKey;", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "Unloaded", "ReadyToLoad", "LoadingError", "Loaded", "Lcom/myscript/nebo/editing/PageViewModel$State$Loaded;", "Lcom/myscript/nebo/editing/PageViewModel$State$LoadingError;", "Lcom/myscript/nebo/editing/PageViewModel$State$ReadyToLoad;", "Lcom/myscript/nebo/editing/PageViewModel$State$Unloaded;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract PageKey getPageKey();

        private State() {
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$State$Unloaded;", "Lcom/myscript/nebo/editing/PageViewModel$State;", "closePage", "", "<init>", "(Z)V", "getClosePage", "()Z", "pageKey", "Lcom/myscript/snt/core/PageKey;", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Unloaded extends State {
            public static final int $stable = 8;
            private final boolean closePage;
            private final PageKey pageKey;

            public Unloaded() {
                this(false, 1, null);
            }

            public static /* synthetic */ Unloaded copy$default(Unloaded unloaded, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = unloaded.closePage;
                }
                return unloaded.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getClosePage() {
                return this.closePage;
            }

            public final Unloaded copy(boolean closePage) {
                return new Unloaded(closePage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Unloaded) && this.closePage == ((Unloaded) other).closePage;
            }

            public int hashCode() {
                return Boolean.hashCode(this.closePage);
            }

            public String toString() {
                return "Unloaded(closePage=" + this.closePage + ")";
            }

            public Unloaded(boolean z) {
                super(null);
                this.closePage = z;
            }

            public /* synthetic */ Unloaded(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean getClosePage() {
                return this.closePage;
            }

            @Override // com.myscript.nebo.editing.PageViewModel.State
            public PageKey getPageKey() {
                return this.pageKey;
            }
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$State$ReadyToLoad;", "Lcom/myscript/nebo/editing/PageViewModel$State;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "<init>", "(Lcom/myscript/snt/core/PageKey;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class ReadyToLoad extends State {
            public static final int $stable = 8;
            private final PageKey pageKey;

            public static /* synthetic */ ReadyToLoad copy$default(ReadyToLoad readyToLoad, PageKey pageKey, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageKey = readyToLoad.pageKey;
                }
                return readyToLoad.copy(pageKey);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageKey getPageKey() {
                return this.pageKey;
            }

            public final ReadyToLoad copy(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                return new ReadyToLoad(pageKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ReadyToLoad) && Intrinsics.areEqual(this.pageKey, ((ReadyToLoad) other).pageKey);
            }

            public int hashCode() {
                return this.pageKey.hashCode();
            }

            public String toString() {
                return "ReadyToLoad(pageKey=" + this.pageKey + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToLoad(PageKey pageKey) {
                super(null);
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                this.pageKey = pageKey;
            }

            @Override // com.myscript.nebo.editing.PageViewModel.State
            public PageKey getPageKey() {
                return this.pageKey;
            }
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$State$LoadingError;", "Lcom/myscript/nebo/editing/PageViewModel$State;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Lcom/myscript/snt/core/PageKey;Ljava/lang/Exception;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getError", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class LoadingError extends State {
            public static final int $stable = 8;
            private final Exception error;
            private final PageKey pageKey;

            public static /* synthetic */ LoadingError copy$default(LoadingError loadingError, PageKey pageKey, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageKey = loadingError.pageKey;
                }
                if ((i & 2) != 0) {
                    exc = loadingError.error;
                }
                return loadingError.copy(pageKey, exc);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageKey getPageKey() {
                return this.pageKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Exception getError() {
                return this.error;
            }

            public final LoadingError copy(PageKey pageKey, Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new LoadingError(pageKey, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadingError)) {
                    return false;
                }
                LoadingError loadingError = (LoadingError) other;
                return Intrinsics.areEqual(this.pageKey, loadingError.pageKey) && Intrinsics.areEqual(this.error, loadingError.error);
            }

            public int hashCode() {
                PageKey pageKey = this.pageKey;
                return ((pageKey == null ? 0 : pageKey.hashCode()) * 31) + this.error.hashCode();
            }

            public String toString() {
                return "LoadingError(pageKey=" + this.pageKey + ", error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadingError(PageKey pageKey, Exception error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.pageKey = pageKey;
                this.error = error;
            }

            @Override // com.myscript.nebo.editing.PageViewModel.State
            public PageKey getPageKey() {
                return this.pageKey;
            }

            public final Exception getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$State$Loaded;", "Lcom/myscript/nebo/editing/PageViewModel$State;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "pageControllerState", "Lcom/myscript/nebo/editing/PageControllerState;", "<init>", "(Lcom/myscript/snt/core/PageKey;Lcom/myscript/nebo/editing/PageControllerState;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getPageControllerState", "()Lcom/myscript/nebo/editing/PageControllerState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Loaded extends State {
            public static final int $stable = 8;
            private final PageControllerState pageControllerState;
            private final PageKey pageKey;

            public static /* synthetic */ Loaded copy$default(Loaded loaded, PageKey pageKey, PageControllerState pageControllerState, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageKey = loaded.pageKey;
                }
                if ((i & 2) != 0) {
                    pageControllerState = loaded.pageControllerState;
                }
                return loaded.copy(pageKey, pageControllerState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageKey getPageKey() {
                return this.pageKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PageControllerState getPageControllerState() {
                return this.pageControllerState;
            }

            public final Loaded copy(PageKey pageKey, PageControllerState pageControllerState) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                Intrinsics.checkNotNullParameter(pageControllerState, "pageControllerState");
                return new Loaded(pageKey, pageControllerState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics.areEqual(this.pageKey, loaded.pageKey) && Intrinsics.areEqual(this.pageControllerState, loaded.pageControllerState);
            }

            public int hashCode() {
                return (this.pageKey.hashCode() * 31) + this.pageControllerState.hashCode();
            }

            public String toString() {
                return "Loaded(pageKey=" + this.pageKey + ", pageControllerState=" + this.pageControllerState + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(PageKey pageKey, PageControllerState pageControllerState) {
                super(null);
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                Intrinsics.checkNotNullParameter(pageControllerState, "pageControllerState");
                this.pageKey = pageKey;
                this.pageControllerState = pageControllerState;
            }

            @Override // com.myscript.nebo.editing.PageViewModel.State
            public PageKey getPageKey() {
                return this.pageKey;
            }

            public final PageControllerState getPageControllerState() {
                return this.pageControllerState;
            }
        }
    }

    public final SingleLiveEvent<Integer> getMessageNotification() {
        return this.messageNotification;
    }

    public final SingleLiveEvent<MessageIdentifier> getMessageNotificationIdentifier() {
        return this.messageNotificationIdentifier;
    }

    public final LiveData<State> getState() {
        return this._state;
    }

    public final LiveData<PageProperties> getPageProperties() {
        return this._pageProperties;
    }

    public final LiveData<Boolean> getActivityIndicator() {
        return this._activityIndicator;
    }

    public final PageProperties getOpenPageProperties() {
        PageProperties value = this._pageProperties.getValue();
        return value == null ? new PageProperties(null, false, null, 0, null, false, 63, null) : value;
    }

    public final PageKey getContainerPageKey() {
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey != null) {
            return this.repository.getPaginatedContainerKeyFromPageKey(openPageKey);
        }
        return null;
    }

    public final PageKey getOpenPageKey() {
        State value = this._state.getValue();
        if (value != null) {
            return value.getPageKey();
        }
        return null;
    }

    public final boolean getShowKeyboardOnTap() {
        return this.keyboardSettings.getShowKeyboardOnTap();
    }

    public final boolean isActivePenEnabled() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zIsActivePenEnabled = pageController2.isActivePenEnabled();
            AutoCloseableKt.closeFinally(pageController2, null);
            return zIsActivePenEnabled;
        } finally {
        }
    }

    public final ToolType getCurrentToolType() {
        PageController pageController = getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                ToolType toolTypeCurrentToolType = pageController2.currentToolType();
                AutoCloseableKt.closeFinally(pageController2, null);
                if (toolTypeCurrentToolType != null) {
                    return toolTypeCurrentToolType;
                }
            } finally {
            }
        }
        return ToolType.None;
    }

    public final boolean isCurrentToolInteracting() {
        PageController pageController = getPageController();
        boolean z = false;
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            if (!pageController3.hasSelection()) {
                if (!pageController3.isCurrentToolPenDown()) {
                    z = true;
                }
            }
            AutoCloseableKt.closeFinally(pageController2, null);
            return z;
        } finally {
        }
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$FreemiumLimitationDialogState;", "", "show", "", WebViewMessageType.CONTEXT, "Lcom/myscript/atk/core/MessageIdentifier;", "<init>", "(ZLcom/myscript/atk/core/MessageIdentifier;)V", "getShow", "()Z", "getContext", "()Lcom/myscript/atk/core/MessageIdentifier;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class FreemiumLimitationDialogState {
        public static final int $stable = 0;
        private final MessageIdentifier context;
        private final boolean show;

        /* JADX WARN: Multi-variable type inference failed */
        public FreemiumLimitationDialogState() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FreemiumLimitationDialogState copy$default(FreemiumLimitationDialogState freemiumLimitationDialogState, boolean z, MessageIdentifier messageIdentifier, int i, Object obj) {
            if ((i & 1) != 0) {
                z = freemiumLimitationDialogState.show;
            }
            if ((i & 2) != 0) {
                messageIdentifier = freemiumLimitationDialogState.context;
            }
            return freemiumLimitationDialogState.copy(z, messageIdentifier);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MessageIdentifier getContext() {
            return this.context;
        }

        public final FreemiumLimitationDialogState copy(boolean show, MessageIdentifier context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new FreemiumLimitationDialogState(show, context);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FreemiumLimitationDialogState)) {
                return false;
            }
            FreemiumLimitationDialogState freemiumLimitationDialogState = (FreemiumLimitationDialogState) other;
            return this.show == freemiumLimitationDialogState.show && this.context == freemiumLimitationDialogState.context;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.show) * 31) + this.context.hashCode();
        }

        public String toString() {
            return "FreemiumLimitationDialogState(show=" + this.show + ", context=" + this.context + ")";
        }

        public FreemiumLimitationDialogState(boolean z, MessageIdentifier context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.show = z;
            this.context = context;
        }

        public /* synthetic */ FreemiumLimitationDialogState(boolean z, MessageIdentifier messageIdentifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MessageIdentifier.UNKNOWN_ERROR : messageIdentifier);
        }

        public final MessageIdentifier getContext() {
            return this.context;
        }

        public final boolean getShow() {
            return this.show;
        }
    }

    public final LiveData<FreemiumLimitationDialogState> getShowFreemiumLimitation() {
        return this._showFreemiumLimitation;
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "", "<init>", "()V", "Hidden", "SelectingLevel", "InProgress", "Done", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$Done;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$Hidden;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$InProgress;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$SelectingLevel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class PdfOptimizationUiState {
        public static final int $stable = 0;

        public /* synthetic */ PdfOptimizationUiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$Hidden;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Hidden extends PdfOptimizationUiState {
            public static final int $stable = 0;
            public static final Hidden INSTANCE = new Hidden();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Hidden)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -689960821;
            }

            public String toString() {
                return "Hidden";
            }

            private Hidden() {
                super(null);
            }
        }

        private PdfOptimizationUiState() {
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$SelectingLevel;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class SelectingLevel extends PdfOptimizationUiState {
            public static final int $stable = 0;
            public static final SelectingLevel INSTANCE = new SelectingLevel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectingLevel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 65020831;
            }

            public String toString() {
                return "SelectingLevel";
            }

            private SelectingLevel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$InProgress;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class InProgress extends PdfOptimizationUiState {
            public static final int $stable = 0;
            public static final InProgress INSTANCE = new InProgress();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InProgress)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1866116909;
            }

            public String toString() {
                return "InProgress";
            }

            private InProgress() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState$Done;", "Lcom/myscript/nebo/editing/PageViewModel$PdfOptimizationUiState;", "result", "Lcom/myscript/nebo/dms/core/PdfOptimizationResult;", "<init>", "(Lcom/myscript/nebo/dms/core/PdfOptimizationResult;)V", "getResult", "()Lcom/myscript/nebo/dms/core/PdfOptimizationResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Done extends PdfOptimizationUiState {
            public static final int $stable = 0;
            private final PdfOptimizationResult result;

            public static /* synthetic */ Done copy$default(Done done, PdfOptimizationResult pdfOptimizationResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    pdfOptimizationResult = done.result;
                }
                return done.copy(pdfOptimizationResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PdfOptimizationResult getResult() {
                return this.result;
            }

            public final Done copy(PdfOptimizationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new Done(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Done) && this.result == ((Done) other).result;
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "Done(result=" + this.result + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Done(PdfOptimizationResult result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final PdfOptimizationResult getResult() {
                return this.result;
            }
        }
    }

    public final LiveData<PdfOptimizationUiState> getPdfOptimizationUiState() {
        return this._pdfOptimizationUiState;
    }

    public final void showPdfOptimizationDialog() {
        this._pdfOptimizationUiState.setValue(PdfOptimizationUiState.SelectingLevel.INSTANCE);
    }

    public final void dismissPdfOptimizationDialog() {
        if (this._pdfOptimizationUiState.getValue() instanceof PdfOptimizationUiState.SelectingLevel) {
            this._pdfOptimizationUiState.setValue(PdfOptimizationUiState.Hidden.INSTANCE);
        }
    }

    public final void optimizePdf(PdfOptimizationLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey == null) {
            return;
        }
        this._pdfOptimizationUiState.setValue(PdfOptimizationUiState.InProgress.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64121(openPageKey, level, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$optimizePdf$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$optimizePdf$1", m1609f = "PageViewModel.kt", m1610i = {1, 1}, m1611l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, PDFACompliance.e_PDFA3_2_1}, m1612m = "invokeSuspend", m1613n = {"result", "doneState"}, m1614nl = {319, PDFACompliance.e_PDFA3_2_3}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C64121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PdfOptimizationLevel $level;
        final /* synthetic */ PageKey $pageKey;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64121(PageKey pageKey, PdfOptimizationLevel pdfOptimizationLevel, Continuation<? super C64121> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$level = pdfOptimizationLevel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64121(this.$pageKey, this.$level, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PdfOptimizationUiState.Done done;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(PageViewModel.this.workDispatcher, new PageViewModel$optimizePdf$1$result$1(PageViewModel.this, this.$pageKey, this.$level, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                done = (PdfOptimizationUiState.Done) this.L$1;
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(PageViewModel.this._pdfOptimizationUiState.getValue(), done)) {
                    PageViewModel.this._pdfOptimizationUiState.setValue(PdfOptimizationUiState.Hidden.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            PdfOptimizationResult pdfOptimizationResult = (PdfOptimizationResult) obj;
            PdfOptimizationUiState.Done done2 = new PdfOptimizationUiState.Done(pdfOptimizationResult);
            PageViewModel.this._pdfOptimizationUiState.setValue(done2);
            this.L$0 = SpillingKt.nullOutSpilledVariable(pdfOptimizationResult);
            this.L$1 = done2;
            this.label = 2;
            if (DelayKt.delay(PageViewModel.PDF_OPTIM_RESULT_VISIBLE_MS, this) != coroutine_suspended) {
                done = done2;
                if (Intrinsics.areEqual(PageViewModel.this._pdfOptimizationUiState.getValue(), done)) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
        String customTheme = NeboCustomTheme.getCustomTheme(i, getSelectedBackgroundColor(), this.darkMode);
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.setTheme(customTheme, false);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final void setDarkMode(boolean z) {
        this.darkMode = z;
        setBackgroundColor(getSelectedBackgroundColor());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new PageViewModel$darkMode$1(this, null), 2, null);
    }

    public final int getSelectedBackgroundColor() {
        return PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().get(RangesKt.coerceIn(this.selectedBackgroundColorIndex, (ClosedRange<Integer>) CollectionsKt.getIndices(PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS()))).intValue();
    }

    public final LiveData<BackgroundSettingsUIState> getBackgroundSettingsUIState() {
        return this._backgroundSettingsUIState;
    }

    private final boolean getShowZoomPanel() {
        PageController pageController;
        if (getContainerPageKey() != null || (pageController = getPageController()) == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zIsZoomIndicatorCompatible = pageController2.isZoomIndicatorCompatible();
            AutoCloseableKt.closeFinally(pageController2, null);
            return zIsZoomIndicatorCompatible;
        } finally {
        }
    }

    public final LiveData<ZoomState> getZoom() {
        return Transformations.distinctUntilChanged(this._zoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZoomState getCurrentZoomState() {
        ZoomState value = this._zoom.getValue();
        return value == null ? new ZoomState(false, false, 0.0f, false, false, 31, null) : value;
    }

    public final LiveData<ImageImportState> getImageImportState() {
        return this._imageImportState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SWIGOptionContext getOptionContext() {
        SWIGOptionContext sWIGOptionContext = new SWIGOptionContext(true);
        Application application = getApplication();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        String string = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_strike_through_document_key), application.getString(C6079R.string.pref_interactivity_strike_through_default_value));
        String string2 = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_strike_through_note_key), application.getString(C6079R.string.pref_interactivity_strike_through_default_value));
        String string3 = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_strike_through_pdf_key), application.getString(C6079R.string.pref_interactivity_strike_through_default_value));
        String string4 = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_underline_words_document_key), application.getString(C6079R.string.pref_interactivity_underline_words_default_value));
        String string5 = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_underline_words_note_key), application.getString(C6079R.string.pref_interactivity_underline_words_default_value));
        String string6 = defaultSharedPreferences.getString(application.getString(C6079R.string.pref_interactivity_underline_words_pdf_key), application.getString(C6079R.string.pref_interactivity_underline_words_default_value));
        String raw_content_properties_prefix = NeboEngine.getRAW_CONTENT_PROPERTIES_PREFIX();
        sWIGOptionContext.setProperty("gesture.strike-through.behavior", string);
        sWIGOptionContext.setProperty(raw_content_properties_prefix + ".gesture.strike-through.behavior", string2);
        sWIGOptionContext.setProperty("gesture.underlines.behavior", string4);
        sWIGOptionContext.setProperty(raw_content_properties_prefix + ".gesture.underlines.behavior", string5);
        sWIGOptionContext.setProperty(PREF_PDF_ZOOM_WHOLE_PAGE, "1");
        sWIGOptionContext.setProperty(PREF_INTERACTIVITY_STRIKE_THROUGH_PDF_KEY, string3);
        sWIGOptionContext.setProperty(PREF_INTERACTIVITY_UNDERLINE_WORDS_PDF_KEY, string6);
        sWIGOptionContext.setProperty(PREF_PDF_AI_QUIZ, CredentialEntry.TRUE_STRING);
        sWIGOptionContext.setProperty(PREF_TEXT_AI_QUIZ, CredentialEntry.TRUE_STRING);
        sWIGOptionContext.setProperty(PREF_RAW_CONTENT_AI_QUIZ, CredentialEntry.TRUE_STRING);
        sWIGOptionContext.setProperty(PREF_TEXT_DOCUMENT_CONTENT_AI_QUIZ, CredentialEntry.TRUE_STRING);
        sWIGOptionContext.setProperty(PREF_PDF_EARLY_ACCESS_FEATURE_KEY, String.valueOf(RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.PDF)));
        sWIGOptionContext.setProperty(PREF_MATH_EARLY_ACCESS_FEATURE_KEY, String.valueOf(RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.MATH)));
        sWIGOptionContext.setProperty(PREF_SHAPE_EARLY_ACCESS_FEATURE_KEY, String.valueOf(RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.SHAPE)));
        RuntimeFeatureFlagHelper.isFeatureEnabled(EarlyAccessFeature.TEXT);
        return sWIGOptionContext;
    }

    public final PageController getPageController() {
        State value = getState().getValue();
        State.Loaded loaded = value instanceof State.Loaded ? (State.Loaded) value : null;
        if (loaded != null) {
            return PageController.newRef(loaded.getPageControllerState().getPageController());
        }
        return null;
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState;", "", "<init>", "()V", "Closed", "Opened", "Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState$Closed;", "Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState$Opened;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class ActionMenuState {
        public static final int $stable = 0;

        public /* synthetic */ ActionMenuState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState$Closed;", "Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Closed extends ActionMenuState {
            public static final int $stable = 0;
            public static final Closed INSTANCE = new Closed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Closed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -658774195;
            }

            public String toString() {
                return "Closed";
            }

            private Closed() {
                super(null);
            }
        }

        private ActionMenuState() {
        }

        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState$Opened;", "Lcom/myscript/nebo/editing/PageViewModel$ActionMenuState;", "actionMenuEntries", "", "Lcom/myscript/atk/ui/ActionMenuEntry;", "inputPoint", "Lcom/myscript/atk/core/Point;", "menuPoint", "callback", "Lcom/myscript/atk/ui/ActionMenuCallback;", "<init>", "(Ljava/util/List;Lcom/myscript/atk/core/Point;Lcom/myscript/atk/core/Point;Lcom/myscript/atk/ui/ActionMenuCallback;)V", "getActionMenuEntries", "()Ljava/util/List;", "getInputPoint", "()Lcom/myscript/atk/core/Point;", "getMenuPoint", "getCallback", "()Lcom/myscript/atk/ui/ActionMenuCallback;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Opened extends ActionMenuState {
            public static final int $stable = 8;
            private final List<ActionMenuEntry> actionMenuEntries;
            private final ActionMenuCallback callback;
            private final Point inputPoint;
            private final Point menuPoint;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Opened copy$default(Opened opened, List list, Point point, Point point2, ActionMenuCallback actionMenuCallback, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = opened.actionMenuEntries;
                }
                if ((i & 2) != 0) {
                    point = opened.inputPoint;
                }
                if ((i & 4) != 0) {
                    point2 = opened.menuPoint;
                }
                if ((i & 8) != 0) {
                    actionMenuCallback = opened.callback;
                }
                return opened.copy(list, point, point2, actionMenuCallback);
            }

            public final List<ActionMenuEntry> component1() {
                return this.actionMenuEntries;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Point getInputPoint() {
                return this.inputPoint;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Point getMenuPoint() {
                return this.menuPoint;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final ActionMenuCallback getCallback() {
                return this.callback;
            }

            public final Opened copy(List<? extends ActionMenuEntry> actionMenuEntries, Point inputPoint, Point menuPoint, ActionMenuCallback callback) {
                Intrinsics.checkNotNullParameter(actionMenuEntries, "actionMenuEntries");
                return new Opened(actionMenuEntries, inputPoint, menuPoint, callback);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Opened)) {
                    return false;
                }
                Opened opened = (Opened) other;
                return Intrinsics.areEqual(this.actionMenuEntries, opened.actionMenuEntries) && Intrinsics.areEqual(this.inputPoint, opened.inputPoint) && Intrinsics.areEqual(this.menuPoint, opened.menuPoint) && Intrinsics.areEqual(this.callback, opened.callback);
            }

            public int hashCode() {
                int iHashCode = this.actionMenuEntries.hashCode() * 31;
                Point point = this.inputPoint;
                int iHashCode2 = (iHashCode + (point == null ? 0 : point.hashCode())) * 31;
                Point point2 = this.menuPoint;
                int iHashCode3 = (iHashCode2 + (point2 == null ? 0 : point2.hashCode())) * 31;
                ActionMenuCallback actionMenuCallback = this.callback;
                return iHashCode3 + (actionMenuCallback != null ? actionMenuCallback.hashCode() : 0);
            }

            public String toString() {
                return "Opened(actionMenuEntries=" + this.actionMenuEntries + ", inputPoint=" + this.inputPoint + ", menuPoint=" + this.menuPoint + ", callback=" + this.callback + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Opened(List<? extends ActionMenuEntry> actionMenuEntries, Point point, Point point2, ActionMenuCallback actionMenuCallback) {
                super(null);
                Intrinsics.checkNotNullParameter(actionMenuEntries, "actionMenuEntries");
                this.actionMenuEntries = actionMenuEntries;
                this.inputPoint = point;
                this.menuPoint = point2;
                this.callback = actionMenuCallback;
            }

            public final List<ActionMenuEntry> getActionMenuEntries() {
                return this.actionMenuEntries;
            }

            public final Point getInputPoint() {
                return this.inputPoint;
            }

            public final Point getMenuPoint() {
                return this.menuPoint;
            }

            public final ActionMenuCallback getCallback() {
                return this.callback;
            }
        }
    }

    public final LiveData<ActionMenuState> getActionMenuState() {
        return this._actionMenuState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionMenuUpdate$lambda$0(PageViewModel pageViewModel, ActionMenuEntry[] actionMenuEntryArr, Point point, Point point2, ActionMenuCallback actionMenuCallback) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(pageViewModel), null, null, new PageViewModel$onActionMenuUpdate$1$1(actionMenuEntryArr, pageViewModel, point, point2, actionMenuCallback, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$PageState;", "", "canUndo", "", "canRedo", "hasContent", "<init>", "(ZZZ)V", "getCanUndo", "()Z", "getCanRedo", "getHasContent", "toString", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PageState {
        public static final int $stable = 0;
        private final boolean canRedo;
        private final boolean canUndo;
        private final boolean hasContent;

        public PageState() {
            this(false, false, false, 7, null);
        }

        public static /* synthetic */ PageState copy$default(PageState pageState, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pageState.canUndo;
            }
            if ((i & 2) != 0) {
                z2 = pageState.canRedo;
            }
            if ((i & 4) != 0) {
                z3 = pageState.hasContent;
            }
            return pageState.copy(z, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCanUndo() {
            return this.canUndo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanRedo() {
            return this.canRedo;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasContent() {
            return this.hasContent;
        }

        public final PageState copy(boolean canUndo, boolean canRedo, boolean hasContent) {
            return new PageState(canUndo, canRedo, hasContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageState)) {
                return false;
            }
            PageState pageState = (PageState) other;
            return this.canUndo == pageState.canUndo && this.canRedo == pageState.canRedo && this.hasContent == pageState.hasContent;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.canUndo) * 31) + Boolean.hashCode(this.canRedo)) * 31) + Boolean.hashCode(this.hasContent);
        }

        public PageState(boolean z, boolean z2, boolean z3) {
            this.canUndo = z;
            this.canRedo = z2;
            this.hasContent = z3;
        }

        public /* synthetic */ PageState(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
        }

        public final boolean getCanUndo() {
            return this.canUndo;
        }

        public final boolean getCanRedo() {
            return this.canRedo;
        }

        public final boolean getHasContent() {
            return this.hasContent;
        }

        public String toString() {
            String[] strArr = new String[3];
            strArr[0] = this.canUndo ? "←" : "↚";
            strArr[1] = this.canRedo ? "→" : "↛";
            strArr[2] = this.hasContent ? "" : "∅";
            return StringsKt.trimEnd((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) strArr), " ", null, null, 0, null, null, 62, null)).toString();
        }
    }

    public final LiveData<PageState> getPageState() {
        return Transformations.distinctUntilChanged(this._pageState);
    }

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModel$MenuCapabilities;", "", "isTypesetAvailable", "", "addBlockTypes", "", "", "hasContentToClear", "hasContentToTypeset", "isClearAllAvailable", "isClearAllAnnotationsAvailable", "canExport", "<init>", "(ZLjava/util/Set;ZZZZZ)V", "()Z", "getAddBlockTypes", "()Ljava/util/Set;", "getHasContentToClear", "getHasContentToTypeset", "getCanExport", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class MenuCapabilities {
        public static final int $stable = 8;
        private final Set<String> addBlockTypes;
        private final boolean canExport;
        private final boolean hasContentToClear;
        private final boolean hasContentToTypeset;
        private final boolean isClearAllAnnotationsAvailable;
        private final boolean isClearAllAvailable;
        private final boolean isTypesetAvailable;

        public MenuCapabilities() {
            this(false, null, false, false, false, false, false, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MenuCapabilities copy$default(MenuCapabilities menuCapabilities, boolean z, Set set, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = menuCapabilities.isTypesetAvailable;
            }
            if ((i & 2) != 0) {
                set = menuCapabilities.addBlockTypes;
            }
            if ((i & 4) != 0) {
                z2 = menuCapabilities.hasContentToClear;
            }
            if ((i & 8) != 0) {
                z3 = menuCapabilities.hasContentToTypeset;
            }
            if ((i & 16) != 0) {
                z4 = menuCapabilities.isClearAllAvailable;
            }
            if ((i & 32) != 0) {
                z5 = menuCapabilities.isClearAllAnnotationsAvailable;
            }
            if ((i & 64) != 0) {
                z6 = menuCapabilities.canExport;
            }
            boolean z7 = z5;
            boolean z8 = z6;
            boolean z9 = z4;
            boolean z10 = z2;
            return menuCapabilities.copy(z, set, z10, z3, z9, z7, z8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsTypesetAvailable() {
            return this.isTypesetAvailable;
        }

        public final Set<String> component2() {
            return this.addBlockTypes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasContentToClear() {
            return this.hasContentToClear;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getHasContentToTypeset() {
            return this.hasContentToTypeset;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsClearAllAvailable() {
            return this.isClearAllAvailable;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsClearAllAnnotationsAvailable() {
            return this.isClearAllAnnotationsAvailable;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getCanExport() {
            return this.canExport;
        }

        public final MenuCapabilities copy(boolean isTypesetAvailable, Set<String> addBlockTypes, boolean hasContentToClear, boolean hasContentToTypeset, boolean isClearAllAvailable, boolean isClearAllAnnotationsAvailable, boolean canExport) {
            Intrinsics.checkNotNullParameter(addBlockTypes, "addBlockTypes");
            return new MenuCapabilities(isTypesetAvailable, addBlockTypes, hasContentToClear, hasContentToTypeset, isClearAllAvailable, isClearAllAnnotationsAvailable, canExport);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuCapabilities)) {
                return false;
            }
            MenuCapabilities menuCapabilities = (MenuCapabilities) other;
            return this.isTypesetAvailable == menuCapabilities.isTypesetAvailable && Intrinsics.areEqual(this.addBlockTypes, menuCapabilities.addBlockTypes) && this.hasContentToClear == menuCapabilities.hasContentToClear && this.hasContentToTypeset == menuCapabilities.hasContentToTypeset && this.isClearAllAvailable == menuCapabilities.isClearAllAvailable && this.isClearAllAnnotationsAvailable == menuCapabilities.isClearAllAnnotationsAvailable && this.canExport == menuCapabilities.canExport;
        }

        public int hashCode() {
            return (((((((((((Boolean.hashCode(this.isTypesetAvailable) * 31) + this.addBlockTypes.hashCode()) * 31) + Boolean.hashCode(this.hasContentToClear)) * 31) + Boolean.hashCode(this.hasContentToTypeset)) * 31) + Boolean.hashCode(this.isClearAllAvailable)) * 31) + Boolean.hashCode(this.isClearAllAnnotationsAvailable)) * 31) + Boolean.hashCode(this.canExport);
        }

        public String toString() {
            return "MenuCapabilities(isTypesetAvailable=" + this.isTypesetAvailable + ", addBlockTypes=" + this.addBlockTypes + ", hasContentToClear=" + this.hasContentToClear + ", hasContentToTypeset=" + this.hasContentToTypeset + ", isClearAllAvailable=" + this.isClearAllAvailable + ", isClearAllAnnotationsAvailable=" + this.isClearAllAnnotationsAvailable + ", canExport=" + this.canExport + ")";
        }

        public MenuCapabilities(boolean z, Set<String> addBlockTypes, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(addBlockTypes, "addBlockTypes");
            this.isTypesetAvailable = z;
            this.addBlockTypes = addBlockTypes;
            this.hasContentToClear = z2;
            this.hasContentToTypeset = z3;
            this.isClearAllAvailable = z4;
            this.isClearAllAnnotationsAvailable = z5;
            this.canExport = z6;
        }

        public final boolean isTypesetAvailable() {
            return this.isTypesetAvailable;
        }

        public /* synthetic */ MenuCapabilities(boolean z, Set set, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? false : z6);
        }

        public final Set<String> getAddBlockTypes() {
            return this.addBlockTypes;
        }

        public final boolean getHasContentToClear() {
            return this.hasContentToClear;
        }

        public final boolean getHasContentToTypeset() {
            return this.hasContentToTypeset;
        }

        public final boolean isClearAllAvailable() {
            return this.isClearAllAvailable;
        }

        public final boolean isClearAllAnnotationsAvailable() {
            return this.isClearAllAnnotationsAvailable;
        }

        public final boolean getCanExport() {
            return this.canExport;
        }
    }

    public final LiveData<MenuCapabilities> getMenuCapabilities() {
        return Transformations.distinctUntilChanged(this._menuCapabilities);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {488}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C64041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64041(Continuation<? super C64041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PageViewModel.this.menuCapabilitiesRefresh;
                final PageViewModel pageViewModel = PageViewModel.this;
                this.label = 1;
                if (mutableSharedFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.editing.PageViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                        MenuCapabilities menuCapabilities;
                        boolean z;
                        PageController pageController = pageViewModel.getPageController();
                        if (pageController != null) {
                            PageController pageController2 = pageController;
                            try {
                                PageController pageController3 = pageController2;
                                boolean zIsCurrentToolPenDown = pageController3.isCurrentToolPenDown();
                                boolean zIsTypesetAvailable = pageController3.isTypesetAvailable();
                                List<String> supportedAddBlockTypes = pageController3.getSupportedAddBlockTypes();
                                Intrinsics.checkNotNullExpressionValue(supportedAddBlockTypes, "getSupportedAddBlockTypes(...)");
                                Set set = CollectionsKt.toSet(supportedAddBlockTypes);
                                boolean z2 = false;
                                if (zIsCurrentToolPenDown || !pageController3.hasContentToClear()) {
                                    z = false;
                                } else {
                                    z = false;
                                    z2 = true;
                                }
                                if (!zIsCurrentToolPenDown && pageController3.hasContentToTypeset()) {
                                    z = true;
                                }
                                boolean zIsClearAllAvailable = pageController3.isClearAllAvailable();
                                boolean zIsClearAllAnnotationsAvailable = pageController3.isClearAllAnnotationsAvailable();
                                Intrinsics.checkNotNullExpressionValue(pageController3.getSupportedExportMimeTypes(), "getSupportedExportMimeTypes(...)");
                                menuCapabilities = new MenuCapabilities(zIsTypesetAvailable, set, z2, z, zIsClearAllAvailable, zIsClearAllAnnotationsAvailable, !r13.isEmpty());
                                AutoCloseableKt.closeFinally(pageController2, null);
                            } finally {
                            }
                        } else {
                            menuCapabilities = new MenuCapabilities(false, null, false, false, false, false, false, 127, null);
                        }
                        pageViewModel._menuCapabilities.postValue(menuCapabilities);
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

    public final void refreshMenuCapabilities() {
        this.menuCapabilitiesRefresh.tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserDictionary getUserDictionaryNewNativeRef() {
        if (UserDictionary.getCPtr(this.userDictionary) != 0) {
            return UserDictionary.newRef(this.userDictionary);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$preloadPage$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$preloadPage$1", m1609f = "PageViewModel.kt", m1610i = {1, 1, 1}, m1611l = {596, 629}, m1612m = "invokeSuspend", m1613n = {"page", "state", "pageProperties"}, m1614nl = {600, 634}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C64141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64141(PageKey pageKey, Continuation<? super C64141> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64141(this.$pageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x01ad, code lost:
        
            if (r5.collect(new com.myscript.nebo.editing.PageViewModel.C64141.AnonymousClass1(), r17) == r1) goto L43;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            State state;
            PageKey pageKey;
            Object objWithContext;
            Pair pairM1606to;
            int i;
            int iResolveBackgroundColor;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if ((!(PageViewModel.this._state.getValue() instanceof State.ReadyToLoad) && !(PageViewModel.this._state.getValue() instanceof State.Loaded)) || (state = (State) PageViewModel.this._state.getValue()) == null || (pageKey = state.getPageKey()) == null || !pageKey.equals(this.$pageKey)) {
                    this.label = 1;
                    objWithContext = BuildersKt.withContext(PageViewModel.this.workDispatcher, new PageViewModel$preloadPage$1$page$1(this.$pageKey, PageViewModel.this, null), this);
                    if (objWithContext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            objWithContext = obj;
            PageModel pageModel = (PageModel) objWithContext;
            if (this.$pageKey != null && pageModel != null) {
                PageType pageType = pageModel.getPageType();
                PageViewModel.this.repository.addPageListener(this.$pageKey, PageViewModel.this.pageListener);
                if (pageType == PageType.PDF) {
                    iResolveBackgroundColor = pageModel.getBackgroundColor();
                } else if (PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().contains(Boxing.boxInt(pageModel.getBackgroundColor()))) {
                    iResolveBackgroundColor = PageBackgroundUtilsKt.resolveBackgroundColor(pageModel.getBackgroundColor(), PageViewModel.this.getDarkMode());
                } else {
                    i = 0;
                    pairM1606to = TuplesKt.m1606to(new State.ReadyToLoad(this.$pageKey), new PageProperties(pageType, PageViewModel.this.repository.isSamplePage(this.$pageKey), pageModel.getPaperSize(), i, pageModel.getBackgroundPattern(), pageModel.isCorrupted()));
                }
                i = iResolveBackgroundColor;
                pairM1606to = TuplesKt.m1606to(new State.ReadyToLoad(this.$pageKey), new PageProperties(pageType, PageViewModel.this.repository.isSamplePage(this.$pageKey), pageModel.getPaperSize(), i, pageModel.getBackgroundPattern(), pageModel.isCorrupted()));
            } else {
                pairM1606to = TuplesKt.m1606to(new State.LoadingError(this.$pageKey, new IllegalArgumentException("Unable to find page: " + this.$pageKey)), new PageProperties(null, false, null, 0, null, false, 63, null));
            }
            State state2 = (State) pairM1606to.component1();
            PageProperties pageProperties = (PageProperties) pairM1606to.component2();
            PageViewModel.this.selectedBackgroundColorIndex = PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().indexOf(Boxing.boxInt(pageModel != null ? pageModel.getBackgroundColor() : 0));
            PageViewModel.this._pageProperties.setValue(pageProperties);
            PageViewModel.this._state.setValue(state2);
            PageViewModel.this._backgroundSettingsUIState.setValue(PageViewModel.this.computeBackgroundSettingsUIState(this.$pageKey));
            Flow flowAsFlow = FlowLiveDataConversions.asFlow(PageViewModel.this.colorPolicyRepository.getColorPolicy());
            final PageViewModel pageViewModel = PageViewModel.this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(pageModel);
            this.L$1 = SpillingKt.nullOutSpilledVariable(state2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(pageProperties);
            this.label = 2;
        }
    }

    public final void preloadPage(PageKey pageKey) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64141(pageKey, null), 2, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.onActionMenuUpdate.close();
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey != null) {
            this.repository.removePageListener(openPageKey, this.pageListener);
        }
        stopAutoSave();
        this.autoSaveScheduler.shutdownNow();
        save$default(this, false, false, 2, null);
        unloadPage(true);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), null, null, new C64112(null), 3, null);
        super.onCleared();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$onCleared$2 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$onCleared$2", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {649}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {ProgressIndicatorKt.SecondLineHeadDelay}, m1615s = {}, m1616v = 2)
    static final class C64112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64112(Continuation<? super C64112> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64112(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PageViewModel.this.autoSyncTimerManager.exitPageEditingMode(this) == coroutine_suspended) {
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

    public final void startAutoSave() {
        if (this.autoSavePeriodMs <= 0 || this.autoSaveTask != null) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.autoSaveScheduler;
        Runnable runnable = new Runnable() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                PageViewModel.startAutoSave$lambda$0(this.f$0);
            }
        };
        long j = this.autoSavePeriodMs;
        this.autoSaveTask = scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAutoSave$lambda$0(PageViewModel pageViewModel) {
        save$default(pageViewModel, true, false, 2, null);
        PageController pageController = pageViewModel.getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.checkForLongPage();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void stopAutoSave() {
        ScheduledFuture<?> scheduledFuture = this.autoSaveTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.autoSaveTask = null;
    }

    public static /* synthetic */ void save$default(PageViewModel pageViewModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        pageViewModel.save(z, z2);
    }

    public final void save(boolean temporary, boolean synchronous) {
        PageController pageController;
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey == null || (pageController = getPageController()) == null) {
            return;
        }
        if (!synchronous) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.workDispatcher, null, new C64151(temporary, this, openPageKey, pageController, null), 2, null);
            return;
        }
        if (this._state.getValue() instanceof State.Loaded) {
            this.repository.save(openPageKey, pageController, temporary);
        }
        pageController.delete();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$save$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$save$1", m1609f = "PageViewModel.kt", m1610i = {0, 1, 1}, m1611l = {696, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS}, m1612m = "invokeSuspend", m1613n = {"isFinalSave", "isFinalSave", "shouldSave"}, m1614nl = {699, 710}, m1615s = {"I$0", "I$0", "I$1"}, m1616v = 2)
    static final class C64151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageController $pageController;
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ boolean $temporary;
        int I$0;
        int I$1;
        int label;
        final /* synthetic */ PageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64151(boolean z, PageViewModel pageViewModel, PageKey pageKey, PageController pageController, Continuation<? super C64151> continuation) {
            super(2, continuation);
            this.$temporary = z;
            this.this$0 = pageViewModel;
            this.$pageKey = pageKey;
            this.$pageController = pageController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C64151(this.$temporary, this.this$0, this.$pageKey, this.$pageController, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        
            if (r9 == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        
            if (r9.withPageAccess(r5, new com.myscript.nebo.editing.PageViewModel.C64151.AnonymousClass1(r8.$pageController, null), r8) != r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 1;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.$temporary;
                i = !z ? 1 : 0;
                if (z) {
                    this.I$0 = i;
                    this.label = 1;
                    obj = BuildersKt.withContext(this.this$0.mainDispatcher, new PageViewModel$save$1$shouldSave$1(this.this$0, null), this);
                } else {
                    if (i3 != 0) {
                        this.this$0.repository.save(this.$pageKey, this.$pageController, this.$temporary);
                    }
                    PageAccessSerializer pageAccessSerializer = PageAccessSerializer.INSTANCE;
                    String strUuid = this.$pageKey.uuid();
                    Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue()) {
                i3 = 0;
            }
            if (i3 != 0) {
            }
            PageAccessSerializer pageAccessSerializer2 = PageAccessSerializer.INSTANCE;
            String strUuid2 = this.$pageKey.uuid();
            Intrinsics.checkNotNullExpressionValue(strUuid2, "uuid(...)");
            this.I$0 = i;
            this.I$1 = i3;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$save$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$save$1$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ PageController $pageController;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageController pageController, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$pageController = pageController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.$pageController, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pageController.delete();
                return Unit.INSTANCE;
            }
        }
    }

    public final PageKey createSiblingPage(PageKey sourcePageKey) {
        Intrinsics.checkNotNullParameter(sourcePageKey, "sourcePageKey");
        return this.repository.createSiblingPage(sourcePageKey);
    }

    public final void loadPage(DisplayMetrics displayMetrics, boolean withSmartGuide, List<? extends CustomResource> customResources) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        Intrinsics.checkNotNullParameter(customResources, "customResources");
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey == null || (this._state.getValue() instanceof State.Loaded) || Intrinsics.areEqual((Object) this._activityIndicator.getValue(), (Object) true)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64101(openPageKey, displayMetrics, withSmartGuide, customResources, getOpenPageProperties().getPageType(), null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$loadPage$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$loadPage$1", m1609f = "PageViewModel.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA7_8_2, 816}, m1612m = "invokeSuspend", m1613n = {MimeTypes.BASE_TYPE_APPLICATION, "confPath", "loader", "options", MimeTypes.BASE_TYPE_APPLICATION, "confPath", "loader", "options", "pageController", "blockRenderer", "sharedPreferences", "pageView", "$i$a$-use-PageViewModel$loadPage$1$2", "enableFreeformAlignmentGuides"}, m1614nl = {790, 818}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "L$9", "I$0", "Z$0"}, m1616v = 2)
    static final class C64101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CustomResource> $customResources;
        final /* synthetic */ DisplayMetrics $displayMetrics;
        final /* synthetic */ PageType $openPageType;
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ boolean $withSmartGuide;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64101(PageKey pageKey, DisplayMetrics displayMetrics, boolean z, List<? extends CustomResource> list, PageType pageType, Continuation<? super C64101> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$displayMetrics = displayMetrics;
            this.$withSmartGuide = z;
            this.$customResources = list;
            this.$openPageType = pageType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64101(this.$pageKey, this.$displayMetrics, this.$withSmartGuide, this.$customResources, this.$openPageType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0394 A[Catch: all -> 0x0042, TryCatch #2 {all -> 0x0042, blocks: (B:7:0x003d, B:69:0x038f, B:71:0x0394, B:74:0x039a, B:77:0x03a2, B:79:0x03a8), top: B:100:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0397  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x039a A[Catch: all -> 0x0042, TryCatch #2 {all -> 0x0042, blocks: (B:7:0x003d, B:69:0x038f, B:71:0x0394, B:74:0x039a, B:77:0x03a2, B:79:0x03a8), top: B:100:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x039f  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x03a2 A[Catch: all -> 0x0042, TryCatch #2 {all -> 0x0042, blocks: (B:7:0x003d, B:69:0x038f, B:71:0x0394, B:74:0x039a, B:77:0x03a2, B:79:0x03a8), top: B:100:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x03a7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Application application;
            List<String> listPlus;
            int i;
            SWIGOptionContext sWIGOptionContext;
            Object objLoad;
            PageLoader pageLoader;
            AutoCloseable autoCloseable;
            PageViewModel pageViewModel;
            DisplayMetrics displayMetrics;
            PageType pageType;
            PageKey pageKey;
            ComponentCallbacks2 componentCallbacks2;
            AutoCloseable autoCloseable2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                try {
                } catch (PageControllerLoadingException e) {
                    PageViewModel.this._state.setValue(new State.LoadingError(this.$pageKey, e));
                }
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(true));
                        application = PageViewModel.this.getApplication();
                        try {
                            listPlus = CollectionsKt.plus((Collection<? extends String>) ConfPathExtKt.getConfPath(application), "zip://" + application.getPackageCodePath() + "!/assets/conf");
                            if (!PageViewModel.this.repository.isLanguageAvailable(this.$pageKey)) {
                                PageViewModel.this._state.setValue(new State.LoadingError(this.$pageKey, new IllegalStateException("Language not available for " + this.$pageKey.uuid())));
                                PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                                return Unit.INSTANCE;
                            }
                            Settings.getInstance().enableGestureNN(true);
                            PageLoader pageLoader2 = new PageLoader(PageViewModel.this.workDispatcher);
                            SWIGOptionContext optionContext = PageViewModel.this.getOptionContext();
                            PageViewModel pageViewModel2 = PageViewModel.this;
                            PageKey pageKey2 = this.$pageKey;
                            String raw_content_properties_prefix = NeboEngine.getRAW_CONTENT_PROPERTIES_PREFIX();
                            if (pageViewModel2.getOpenPageProperties().isFixedPageSize()) {
                                i = 2;
                                optionContext.setProperty(raw_content_properties_prefix + "." + NeboEngine.getDIAGRAM_PROPERTY_PAGE_SIZE_DEFAULT(), PageViewModelKt.toJsonPageSize(pageViewModel2.getOpenPageProperties().getPaperSize()));
                                optionContext.setProperty(raw_content_properties_prefix + "." + NeboEngine.getDIAGRAM_PROPERTY_PAGE_SIZE_INSET_DEFAULT(), PageViewModelKt.toJson(new Float[]{Boxing.boxFloat(10.0f), Boxing.boxFloat(10.0f), Boxing.boxFloat(10.0f), Boxing.boxFloat(10.0f)}));
                                optionContext.setProperty(raw_content_properties_prefix + "." + NeboEngine.getDIAGRAM_PROPERTY_PAGE_SIZE_FIT_SCREEN_DEFAULT(), CredentialEntry.TRUE_STRING);
                            } else {
                                i = 2;
                            }
                            boolean z = pageViewModel2.repository.getPaginatedContainerKeyFromPageKey(pageKey2) != null;
                            optionContext.setProperty("scroll.restore.position.enable", String.valueOf(!z));
                            optionContext.setProperty("feature-flag.scroll.restore.default.fit-to-width.enable", String.valueOf(z || pageViewModel2.getOpenPageProperties().getPageType() == PageType.PDF));
                            optionContext.setProperty(raw_content_properties_prefix + ".convert-as-menu", CredentialEntry.TRUE_STRING);
                            optionContext.setProperty(PageViewModel.PREF_CONVERT_AS_TEXT_OR_MATH_PDF, CredentialEntry.TRUE_STRING);
                            optionContext.setProperty("freeform.selection-changed.listener", CredentialEntry.TRUE_STRING);
                            boolean z2 = application.getResources().getBoolean(C6079R.bool.is_ai_available_for_flavor) && PreferenceManager.getDefaultSharedPreferences(application).getBoolean(AIContainerViewModel.AI_ENABLED_PREFS, true);
                            optionContext.setProperty("pdf.ai.enable", String.valueOf(z2));
                            optionContext.setProperty(raw_content_properties_prefix + ".ai.enable", String.valueOf(z2));
                            if (pageViewModel2.getOpenPageProperties().getPageType() == PageType.RawContent || pageViewModel2.getOpenPageProperties().getPageType() == PageType.PDF) {
                                optionContext.setProperty("raw-content.image.crop", CredentialEntry.TRUE_STRING);
                                optionContext.setProperty("pdf.image.crop", CredentialEntry.TRUE_STRING);
                            }
                            this.L$0 = application;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(listPlus);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(pageLoader2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(optionContext);
                            this.label = 1;
                            sWIGOptionContext = optionContext;
                            objLoad = pageLoader2.load(new PageParam.ByKey(this.$pageKey, new AnonymousClass1(PageViewModel.this.repository)), this.$displayMetrics.xdpi, this.$displayMetrics.ydpi, this.$displayMetrics.scaledDensity, listPlus, this.$withSmartGuide, true, this.$customResources, sWIGOptionContext, this);
                            if (objLoad == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pageLoader = pageLoader2;
                        } catch (Exception e2) {
                            PageViewModel.this._state.setValue(new State.LoadingError(this.$pageKey, e2));
                            PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            pageViewModel = (PageViewModel) this.L$5;
                            autoCloseable2 = (AutoCloseable) this.L$4;
                            componentCallbacks2 = (Application) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                UserProfileManager.Provider provider = !(componentCallbacks2 instanceof UserProfileManager.Provider) ? (UserProfileManager.Provider) componentCallbacks2 : null;
                                UserProfileManager userProfileManagerProvideUserProfileManager = provider == null ? provider.provideUserProfileManager() : null;
                                pageViewModel.setConversionEnabled(userProfileManagerProvideUserProfileManager == null ? userProfileManagerProvideUserProfileManager.hasAccessToAllFeatures() : false);
                                Unit unit = Unit.INSTANCE;
                                AutoCloseableKt.closeFinally(autoCloseable2, null);
                                PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                autoCloseable = autoCloseable2;
                                th = th;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    AutoCloseableKt.closeFinally(autoCloseable, th);
                                    throw th3;
                                }
                            }
                        }
                        SWIGOptionContext sWIGOptionContext2 = (SWIGOptionContext) this.L$3;
                        pageLoader = (PageLoader) this.L$2;
                        List<String> list = (List) this.L$1;
                        Application application2 = (Application) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        sWIGOptionContext = sWIGOptionContext2;
                        listPlus = list;
                        i = 2;
                        application = application2;
                        objLoad = obj;
                    }
                    PageController pageController = (PageController) autoCloseable;
                    pageViewModel.messageNotificationHandler.bind(pageController);
                    pageController.addMessageListener(pageViewModel.freemiumGestureListener);
                    pageController.setClipboardConfiguration(PageViewModel.CLIPBOARD_CONFIGURATION);
                    pageController.setNativeClipboard(pageViewModel.clipboard);
                    pageController.setActionMenuListener(pageViewModel.onActionMenuUpdate);
                    BlockRenderer blockRenderer = new BlockRenderer(displayMetrics, new File(pageController.workingDirPath()));
                    pageController.setRendererListener(blockRenderer);
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
                    boolean z3 = defaultSharedPreferences.getBoolean(PageViewModel.FREEFORM_ALIGNMENT_GUIDES_KEY, true);
                    pageController.enableFreeformAligmentGuides(z3);
                    Intrinsics.checkNotNull(defaultSharedPreferences);
                    PageViewModelKt.applyMathBlockPreferences(defaultSharedPreferences, application, pageController);
                    pageController.setColorInversionPolicy(pageType != PageType.PDF ? pageViewModel.colorPolicyRepository.getColorPolicy().getValue() : new IdentityColorInversionPolicy());
                    NeboPageView neboPageView = new NeboPageView(displayMetrics, false);
                    pageViewModel._state.setValue(new State.Loaded(pageKey, PageControllerState.INSTANCE.bind(pageController, neboPageView)));
                    IAutoSyncTimerManager iAutoSyncTimerManager = pageViewModel.autoSyncTimerManager;
                    this.L$0 = application;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(listPlus);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(pageLoader);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(sWIGOptionContext);
                    this.L$4 = autoCloseable;
                    this.L$5 = pageViewModel;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(pageController);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(blockRenderer);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(defaultSharedPreferences);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(neboPageView);
                    this.I$0 = 0;
                    this.Z$0 = z3;
                    this.label = i;
                    if (iAutoSyncTimerManager.enterPageEditingMode(this) != coroutine_suspended) {
                        componentCallbacks2 = application;
                        autoCloseable2 = autoCloseable;
                        if (!(componentCallbacks2 instanceof UserProfileManager.Provider)) {
                        }
                        if (provider == null) {
                        }
                        pageViewModel.setConversionEnabled(userProfileManagerProvideUserProfileManager == null ? userProfileManagerProvideUserProfileManager.hasAccessToAllFeatures() : false);
                        Unit unit2 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    throw th;
                }
                autoCloseable = (AutoCloseable) objLoad;
                pageViewModel = PageViewModel.this;
                displayMetrics = this.$displayMetrics;
                pageType = this.$openPageType;
                pageKey = this.$pageKey;
            } catch (Throwable th5) {
                PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                throw th5;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$loadPage$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<PageKey, DisplayContext, RecoContext, SWIGOptionContext, PageControllerSanitized> {
            AnonymousClass1(Object obj) {
                super(4, obj, LibraryRepository.class, "getPageController", "getPageController(Lcom/myscript/snt/core/PageKey;Lcom/myscript/snt/core/DisplayContext;Lcom/myscript/snt/core/RecoContext;Lcom/myscript/snt/core/SWIGOptionContext;)Lcom/myscript/snt/core/PageControllerSanitized;", 0);
            }

            @Override // kotlin.jvm.functions.Function4
            public final PageControllerSanitized invoke(PageKey p0, DisplayContext p1, RecoContext p2, SWIGOptionContext p3) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullParameter(p2, "p2");
                Intrinsics.checkNotNullParameter(p3, "p3");
                return ((LibraryRepository) this.receiver).getPageController(p0, p1, p2, p3);
            }
        }
    }

    public final void unloadPage() {
        unloadPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unloadPage(boolean closePage) {
        State.Unloaded unloaded;
        State value = this._state.getValue();
        if (value == null) {
            return;
        }
        if (value instanceof State.Unloaded) {
            unloaded = new State.Unloaded(closePage);
            if (((State.Unloaded) value).getClosePage() == closePage) {
                unloaded = null;
            }
        } else if (value instanceof State.Loaded) {
            this.messageNotificationHandler.unbind();
            State.Loaded loaded = (State.Loaded) value;
            if (loaded.getPageControllerState().getIsBound()) {
                PageController pageController = loaded.getPageControllerState().getPageController();
                pageController.setNativeClipboard(null);
                pageController.setRendererListener(null);
                pageController.setActionMenuListener(null);
                pageController.removeMessageListener(this.freemiumGestureListener);
                loaded.getPageControllerState().unbind();
            }
            unloaded = new State.Unloaded(closePage);
        } else {
            if (!(value instanceof State.ReadyToLoad) && !(value instanceof State.LoadingError)) {
                throw new NoWhenBranchMatchedException();
            }
            unloaded = new State.Unloaded(closePage);
        }
        if (unloaded != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PageViewModel$unloadPage$1$1(this, unloaded, null), 3, null);
        }
    }

    public final BackgroundSettingsUIState computeBackgroundSettingsUIState(PageKey pageKey) {
        ArrayList arrayListEmptyList;
        PageModel page = pageKey != null ? this.repository.getPage(pageKey) : null;
        BackgroundPattern backgroundPattern = page != null ? page.getBackgroundPattern() : null;
        int iIndexOf = PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().indexOf(Integer.valueOf(page != null ? ColorExt.getOpaque(page.getBackgroundColor()) : 0));
        PageType pageType = page != null ? page.getPageType() : null;
        List<PageBackgroundColor> listEmptyList = (pageKey == null || pageType == null || !PageController.canConfigureBackgroundColor(Page.contentType(pageType))) ? CollectionsKt.emptyList() : toUIModel(PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS(), iIndexOf);
        if (pageKey == null || pageType == null || !PageController.canConfigureBackgroundPattern(Page.contentType(pageType))) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List<BackgroundPattern> background_patterns = PageBackgroundUtilsKt.getBACKGROUND_PATTERNS();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(background_patterns, 10));
            for (BackgroundPattern backgroundPattern2 : background_patterns) {
                arrayList.add(new PageBackgroundPattern(backgroundPattern2, backgroundPattern == backgroundPattern2));
            }
            arrayListEmptyList = arrayList;
        }
        return new BackgroundSettingsUIState(listEmptyList, arrayListEmptyList);
    }

    public final void setBackgroundPattern(BackgroundPattern pattern) {
        PageType pageType;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey == null || (pageType = getOpenPageProperties().getPageType()) == null || !PageController.canConfigureBackgroundPattern(Page.contentType(pageType))) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64161(openPageKey, pattern, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$setBackgroundPattern$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$setBackgroundPattern$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {897}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TypedValues.Custom.TYPE_REFERENCE}, m1615s = {}, m1616v = 2)
    static final class C64161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ BackgroundPattern $pattern;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64161(PageKey pageKey, BackgroundPattern backgroundPattern, Continuation<? super C64161> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$pattern = backgroundPattern;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64161(this.$pageKey, this.$pattern, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$setBackgroundPattern$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$setBackgroundPattern$1$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PageKey $pageKey;
            final /* synthetic */ BackgroundPattern $pattern;
            int label;
            final /* synthetic */ PageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageViewModel pageViewModel, PageKey pageKey, BackgroundPattern backgroundPattern, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = pageViewModel;
                this.$pageKey = pageKey;
                this.$pattern = backgroundPattern;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$pageKey, this.$pattern, continuation);
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
                    LibraryRepository libraryRepository = this.this$0.repository;
                    PageKey pageKey = this.$pageKey;
                    String string = BackgroundPatternExt.toString(this.$pattern);
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    libraryRepository.setBackgroundPattern(pageKey, string);
                    PageController pageController = this.this$0.getPageController();
                    if (pageController == null) {
                        return null;
                    }
                    PageController pageController2 = pageController;
                    try {
                        pageController2.setBackgroundPattern(this.$pattern);
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(pageController2, null);
                        return Unit.INSTANCE;
                    } finally {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(PageViewModel.this.workDispatcher, new AnonymousClass1(PageViewModel.this, this.$pageKey, this.$pattern, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PageController pageController = PageViewModel.this.getPageController();
            if (pageController != null) {
                Renderer renderer = pageController;
                try {
                    Renderer renderer2 = renderer.getRenderer();
                    if (renderer2 != null) {
                        renderer = renderer2;
                        try {
                            renderer.forceRedraw();
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(renderer, null);
                            Unit unit2 = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    AutoCloseableKt.closeFinally(renderer, null);
                } finally {
                }
            }
            PageViewModel.this._backgroundSettingsUIState.setValue(PageViewModel.this.computeBackgroundSettingsUIState(this.$pageKey));
            return Unit.INSTANCE;
        }
    }

    public final void setBackgroundColor(int color) {
        PageType pageType;
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey == null || (pageType = getOpenPageProperties().getPageType()) == null || !PageController.canConfigureBackgroundColor(Page.contentType(pageType))) {
            return;
        }
        this.repository.setBackgroundColor(openPageKey, color);
        String customTheme = NeboCustomTheme.getCustomTheme(this.tintColor, color, this.darkMode);
        PageController pageController = getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                pageController2.setTheme(customTheme, false);
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

    private final List<PageBackgroundColor> toUIModel(List<Integer> list, int i) {
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i2 = 0;
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int opaque = ColorExt.getOpaque(((Number) obj).intValue());
            arrayList.add(new PageBackgroundColor(opaque, PageBackgroundUtilsKt.resolveBackgroundColor(opaque, this.darkMode), i2 == i));
            i2 = i3;
        }
        return arrayList;
    }

    public final void tagCorruptionInfoPage(String reason, String message) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(message, "message");
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey != null) {
            this.repository.tagCorruptionInfoPage(openPageKey, reason, message);
        }
        setZoomController(null);
    }

    public final void tagCorruptionWarningInfoPage(String reason, String message) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(message, "message");
        PageKey openPageKey = getOpenPageKey();
        if (openPageKey != null) {
            this.repository.tagCorruptionWarningInfoPage(openPageKey, reason, message);
        }
        setZoomController(null);
    }

    public final boolean canLearnWord(String word) {
        List<String> labels = this.userDictionary.getLabels();
        Intrinsics.checkNotNullExpressionValue(labels, "getLabels(...)");
        return UserDictionaryInputChecker.checkInput(word, labels) instanceof InputStatus.Valid;
    }

    public final void forgetWord(final String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        edit(this.userDictionary, new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.forgetWord$lambda$0(word, (UserDictionary) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit forgetWord$lambda$0(String str, UserDictionary it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.removeLabel(str);
        return Unit.INSTANCE;
    }

    public final boolean learnWord(final String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        if (!Intrinsics.areEqual(UserDictionaryInputChecker.checkInput$default(word, null, 2, null), InputStatus.Valid.INSTANCE)) {
            return false;
        }
        edit(this.userDictionary, new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.learnWord$lambda$0(word, (UserDictionary) obj);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit learnWord$lambda$0(String str, UserDictionary it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.addLabel(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$edit$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$edit$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {972}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {979}, m1615s = {}, m1616v = 2)
    static final class C64081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<UserDictionary, Unit> $editAction;
        final /* synthetic */ UserDictionary $this_edit;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64081(Function1<? super UserDictionary, Unit> function1, UserDictionary userDictionary, Continuation<? super C64081> continuation) {
            super(2, continuation);
            this.$editAction = function1;
            this.$this_edit = userDictionary;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64081(this.$editAction, this.$this_edit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(PageViewModel.this.userDictionaryDispatcher, new AnonymousClass1(this.$editAction, this.$this_edit, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UserDictionary userDictionaryNewNativeRef = PageViewModel.this.getUserDictionaryNewNativeRef();
            if (userDictionaryNewNativeRef != null) {
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, PageViewModel.this.userDictionaryDispatcher, null, new AnonymousClass2(PageViewModel.this, userDictionaryNewNativeRef, null), 2, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$edit$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$edit$1$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<UserDictionary, Unit> $editAction;
            final /* synthetic */ UserDictionary $this_edit;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super UserDictionary, Unit> function1, UserDictionary userDictionary, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$editAction = function1;
                this.$this_edit = userDictionary;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$editAction, this.$this_edit, continuation);
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
                this.$editAction.invoke(this.$this_edit);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$edit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$edit$1$2", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserDictionary $userDictCopy;
            int label;
            final /* synthetic */ PageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PageViewModel pageViewModel, UserDictionary userDictionary, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = pageViewModel;
                this.$userDictCopy = userDictionary;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$userDictCopy, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PageController pageController = this.this$0.getPageController();
                if (pageController != null) {
                    PageController pageController2 = pageController;
                    try {
                        pageController2.reloadUserDictionary(this.$userDictCopy);
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(pageController2, null);
                    } finally {
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void edit(UserDictionary userDictionary, Function1<? super UserDictionary, Unit> function1) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64081(function1, userDictionary, null), 2, null);
    }

    public final void timeConsumingAction(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.isTimeConsumingActionOngoing) {
            return;
        }
        this.isTimeConsumingActionOngoing = true;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64181(action, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$timeConsumingAction$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$timeConsumingAction$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {1000}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1004}, m1615s = {}, m1616v = 2)
    static final class C64181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64181(Function0<Unit> function0, Continuation<? super C64181> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64181(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    if (BuildersKt.withContext(PageViewModel.this.workDispatcher, new AnonymousClass1(this.$action, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                PageViewModel.this.isTimeConsumingActionOngoing = false;
                return Unit.INSTANCE;
            } catch (Throwable th) {
                PageViewModel.this._activityIndicator.setValue(Boxing.boxBoolean(false));
                PageViewModel.this.isTimeConsumingActionOngoing = false;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$timeConsumingAction$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$timeConsumingAction$1$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $action;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$action = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$action, continuation);
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
                this.$action.invoke();
                return Unit.INSTANCE;
            }
        }
    }

    private final void timeConsumingPageControllerAction(final Function1<? super PageController, Unit> action) {
        timeConsumingAction(new Function0() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageViewModel.timeConsumingPageControllerAction$lambda$0(this.f$0, action);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit timeConsumingPageControllerAction$lambda$0(PageViewModel pageViewModel, Function1 function1) {
        PageController pageController = pageViewModel.getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                function1.invoke(pageController2);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(pageController2, null);
            } finally {
            }
        }
        return Unit.INSTANCE;
    }

    public final void undo() {
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.undo$lambda$0((PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit undo$lambda$0(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.undo();
        return Unit.INSTANCE;
    }

    public final void redo() {
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.redo$lambda$0((PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit redo$lambda$0(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.redo();
        return Unit.INSTANCE;
    }

    public final void clearAll() {
        PageController pageController = getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                if (!pageController2.hasContentToClear()) {
                    AutoCloseableKt.closeFinally(pageController2, null);
                    return;
                } else {
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController2, null);
                }
            } finally {
            }
        }
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.clearAll$lambda$1((PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearAll$lambda$1(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.clear();
        return Unit.INSTANCE;
    }

    public final void convertAll() {
        PageController pageController = getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                if (!pageController2.hasContentToTypeset()) {
                    AutoCloseableKt.closeFinally(pageController2, null);
                    return;
                } else {
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(pageController2, null);
                }
            } finally {
            }
        }
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.convertAll$lambda$1((PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertAll$lambda$1(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.convert();
        return Unit.INSTANCE;
    }

    public final boolean isSpaceManagementAvailableAt(PointerInfo pointerInfo) {
        Intrinsics.checkNotNullParameter(pointerInfo, "pointerInfo");
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zIsSpaceManagementActivable = pageController2.isSpaceManagementActivable(pointerInfo);
            AutoCloseableKt.closeFinally(pageController2, null);
            return zIsSpaceManagementActivable;
        } finally {
        }
    }

    public final List<String> getAvailableBlockTypesAt(float x, float y) {
        PageController pageController = getPageController();
        if (pageController != null) {
            PageController pageController2 = pageController;
            try {
                List<String> supportedAddBlockTypesAt = pageController2.getSupportedAddBlockTypesAt(x, y);
                AutoCloseableKt.closeFinally(pageController2, null);
                if (supportedAddBlockTypesAt != null) {
                    return supportedAddBlockTypesAt;
                }
            } finally {
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void convertSelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.convertSelection();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void addBlock(String blockType) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            if (!pageController3.getSupportedAddBlockTypes().contains(blockType)) {
                throw new IllegalArgumentException(("Unsupported block type " + blockType).toString());
            }
            CompositeBox compositeBoxCreateBlock = pageController3.createBlock(blockType);
            if (compositeBoxCreateBlock != null) {
                compositeBoxCreateBlock.delete();
                Unit unit = Unit.INSTANCE;
            }
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void addBlockAt(String blockType, float x, float y) {
        CompositeBox compositeBoxCreateBlock;
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            if (pageController3.getSupportedAddBlockTypesAt(x, y).contains(blockType) && (compositeBoxCreateBlock = pageController3.createBlock(new Point(x, y), blockType)) != null) {
                compositeBoxCreateBlock.delete();
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canHandleImageMimeType(String mimeType) {
        return Intrinsics.areEqual(mimeType, "image/jpeg") || Intrinsics.areEqual(mimeType, "image/png");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addImage$lambda$0(File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        imageFile.delete();
        return Unit.INSTANCE;
    }

    public final void addImage(Uri uri, Function2<? super File, ? super String, Unit> addFn) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(addFn, "addFn");
        addImage(uri, addFn, new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.addImage$lambda$0((File) obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$addImage$3 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$addImage$3", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {1099}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA1_10_2}, m1615s = {}, m1616v = 2)
    static final class C64053 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<File, String, Unit> $addFn;
        final /* synthetic */ Function1<File, Unit> $deleteFn;
        final /* synthetic */ Uri $uri;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64053(Uri uri, Function2<? super File, ? super String, Unit> function2, Function1<? super File, Unit> function1, Continuation<? super C64053> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.$addFn = function2;
            this.$deleteFn = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64053(this.$uri, this.$addFn, this.$deleteFn, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64053) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Exception e;
            MutableLiveData mutableLiveData2;
            ImageImportState error;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PageViewModel.this._imageImportState.setValue(new ImageImportState.Importing(this.$uri));
                MutableLiveData mutableLiveData3 = PageViewModel.this._imageImportState;
                try {
                    this.L$0 = mutableLiveData3;
                    this.L$1 = mutableLiveData3;
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(PageViewModel.this, this.$uri, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData2 = mutableLiveData3;
                    obj = objWithContext;
                    mutableLiveData = mutableLiveData2;
                } catch (Exception e2) {
                    mutableLiveData = mutableLiveData3;
                    e = e2;
                    error = new ImageImportState.Error(this.$uri, e);
                    mutableLiveData2 = mutableLiveData;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData2 = (MutableLiveData) this.L$1;
                mutableLiveData = (MutableLiveData) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    error = new ImageImportState.Error(this.$uri, e);
                    mutableLiveData2 = mutableLiveData;
                }
            }
            ImageHolder imageHolder = (ImageHolder) obj;
            File file = imageHolder.getFile();
            String mimeType = imageHolder.getMimeType();
            if (file.isFile()) {
                try {
                    if (!PageViewModel.this.canHandleImageMimeType(mimeType)) {
                        throw new IllegalArgumentException(("unsupported mime type " + mimeType).toString());
                    }
                    this.$addFn.invoke(file, mimeType);
                    ImageImportState success = new ImageImportState.Success(this.$uri, mimeType);
                    this.$deleteFn.invoke(file);
                    error = success;
                    mutableLiveData2.setValue(error);
                    PageViewModel.this._imageImportState.setValue(ImageImportState.Idle.INSTANCE);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    this.$deleteFn.invoke(file);
                    throw th;
                }
            }
            throw new IllegalArgumentException((file + " does not exist").toString());
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$addImage$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/editing/ImageHolder;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$addImage$3$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageHolder>, Object> {
            final /* synthetic */ Uri $uri;
            int label;
            final /* synthetic */ PageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageViewModel pageViewModel, Uri uri, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = pageViewModel;
                this.$uri = uri;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$uri, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageHolder> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return this.this$0.imageImporter.importImage(this.$uri);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addImage$default(PageViewModel pageViewModel, Uri uri, Function2 function2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PageViewModel.addImage$lambda$1((File) obj2);
                }
            };
        }
        pageViewModel.addImage(uri, function2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addImage$lambda$1(File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        imageFile.delete();
        return Unit.INSTANCE;
    }

    public final void addImage(Uri uri, Function2<? super File, ? super String, Unit> addFn, Function1<? super File, Unit> deleteFn) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(addFn, "addFn");
        Intrinsics.checkNotNullParameter(deleteFn, "deleteFn");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C64053(uri, addFn, deleteFn, null), 3, null);
    }

    public final void addImage(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        addImage(uri, new Function2() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PageViewModel.addImage$lambda$2(this.f$0, (File) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addImage$lambda$2(PageViewModel pageViewModel, File imageFile, String mimeType) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        String absolutePath = imageFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        pageViewModel.addImage(absolutePath, mimeType);
        return Unit.INSTANCE;
    }

    public final void addImage(String path, String mimeType) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            Boolean.valueOf(pageController2.addImage(path, mimeType));
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void addImageAt(Uri uri, final float x, final float y) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        addImage(uri, new Function2() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PageViewModel.addImageAt$lambda$0(this.f$0, x, y, (File) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addImageAt$lambda$0(PageViewModel pageViewModel, float f, float f2, File imageFile, String mimeType) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        pageViewModel.addImageAt(imageFile, f, f2, mimeType);
        return Unit.INSTANCE;
    }

    public final void addImageAt(File imageFile, float x, float y, String mimeType) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.importObjectAt(imageFile.getAbsolutePath(), mimeType, new Point(x, y));
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void replaceSelectedImage(String path, String mimeType) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.replaceSelectedImage(path, mimeType);
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void spaceManagementAt(PointerInfo pointerInfo) {
        Intrinsics.checkNotNullParameter(pointerInfo, "pointerInfo");
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            if (pageController3.isSpaceManagementActivable(pointerInfo)) {
                pageController3.spaceManagement(pointerInfo);
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final boolean canPaste() {
        if (this._state.getValue() instanceof State.Loaded) {
            return this.clipboard.canPaste();
        }
        return false;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$paste$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64131 extends FunctionReferenceImpl implements Function1<PageController, Unit> {
        public static final C64131 INSTANCE = new C64131();

        C64131() {
            super(1, PageController.class, "paste", "paste()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PageController pageController) {
            invoke2(pageController);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PageController p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            p0.paste();
        }
    }

    public final void paste() {
        timeConsumingPageControllerAction(C64131.INSTANCE);
    }

    public final void pasteAt(final float x, final float y) {
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.pasteAt$lambda$0(x, y, (PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pasteAt$lambda$0(float f, float f2, PageController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.pasteAt2(f, f2);
        return Unit.INSTANCE;
    }

    public final void pasteTextAt(final String text, final float x, final float y) {
        Intrinsics.checkNotNullParameter(text, "text");
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.pasteTextAt$lambda$0(x, y, this, text, (PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pasteTextAt$lambda$0(float f, float f2, PageViewModel pageViewModel, final String str, PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.setNativeClipboard(new INativeClipboardExtended() { // from class: com.myscript.nebo.editing.PageViewModel$pasteTextAt$1$dropClipboard$1
            @Override // com.myscript.nebo.editing.INativeClipboardExtended
            public boolean canPaste() {
                return true;
            }

            @Override // com.myscript.atk.text.INativeClipboard
            public void updateNativeClipboard(SWIGClipboard items) {
            }

            @Override // com.myscript.atk.text.INativeClipboard
            public SWIGClipboard getNativeClipboard() {
                SWIGClipboard sWIGClipboard = new SWIGClipboard();
                sWIGClipboard.put(MimeType.TEXT, str);
                return sWIGClipboard;
            }

            @Override // com.myscript.atk.text.INativeClipboard
            public SWIGVectorMimeType getClipboardMetadata() {
                SWIGVectorMimeType sWIGVectorMimeType = new SWIGVectorMimeType();
                sWIGVectorMimeType.push_back(MimeType.TEXT);
                return sWIGVectorMimeType;
            }
        });
        try {
            pageController.pasteAt2(f, f2);
            pageController.setNativeClipboard(pageViewModel.clipboard);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            pageController.setNativeClipboard(pageViewModel.clipboard);
            throw th;
        }
    }

    public final void selectionAsOrderedList() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.listify("1.", MenuType.EDIT_MENU);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void selectionAsUnorderedList() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.listify("•", MenuType.EDIT_MENU);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void selectionAsCheckedList() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.listify("☐", MenuType.EDIT_MENU);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void selectionAsText() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.textify(MenuType.EDIT_MENU);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void indentSelection() {
        keyboardAction(KeyboardAction.TABULATION);
    }

    public final void unindentSelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            pageController3.updateKeyboardModifiers(false, true, false);
            pageController3.keyboardAction(KeyboardAction.TABULATION);
            pageController3.updateKeyboardModifiers(false, false, false);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void copySelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.copy();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void copyAs(final String contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        timeConsumingPageControllerAction(new Function1() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PageViewModel.copyAs$lambda$0(contentType, (PageController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyAs$lambda$0(String str, PageController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.copyAs(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$cutSelection$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64071 extends FunctionReferenceImpl implements Function1<PageController, Unit> {
        public static final C64071 INSTANCE = new C64071();

        C64071() {
            super(1, PageController.class, "cut", "cut()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PageController pageController) {
            invoke2(pageController);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PageController p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            p0.cut();
        }
    }

    public final void cutSelection() {
        timeConsumingPageControllerAction(C64071.INSTANCE);
    }

    public final void deleteSelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.remove();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    private final void keyboardAction(KeyboardAction action) {
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.keyboardAction(action);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void emboldenSelection() {
        keyboardAction(KeyboardAction.BOLD);
    }

    public final void underlineSelection() {
        keyboardAction(KeyboardAction.UNDERLINE);
    }

    public final void doubleUnderlineSelection() {
        keyboardAction(KeyboardAction.DOUBLE_UNDERLINE);
    }

    public final void strikeThrough() {
        keyboardAction(KeyboardAction.STRIKE_THROUGH);
    }

    public final void highlightSelection() {
        keyboardAction(KeyboardAction.HIGHLIGHT);
    }

    public final boolean canConvertInlineSelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zIsConvertActionAllowed = pageController2.isConvertActionAllowed();
            AutoCloseableKt.closeFinally(pageController2, null);
            return zIsConvertActionAllowed;
        } finally {
        }
    }

    public final boolean hasFreeformAlignmentGuides() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean freeformAlignmentGuides = pageController2.getFreeformAlignmentGuides();
            AutoCloseableKt.closeFinally(pageController2, null);
            return freeformAlignmentGuides;
        } finally {
        }
    }

    public final void setFreeformAlignmentGuides(boolean enable) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean(FREEFORM_ALIGNMENT_GUIDES_KEY, enable);
        editorEdit.apply();
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.enableFreeformAligmentGuides(enable);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final void toggleInteractionsToShowKeyboard() {
        boolean showKeyboardOnTap = NeboKeyboardSettings.settings(getApplication()).getShowKeyboardOnTap();
        NeboKeyboardSettings.settings(getApplication()).setShowKeyboardOnTap(!showKeyboardOnTap);
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            pageController2.enableTapInteractionsToShowKeyboard(!showKeyboardOnTap);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    public final boolean canIndentInlineSelection() {
        PageController pageController = getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zIsIndentActionAllowed = pageController2.isIndentActionAllowed();
            AutoCloseableKt.closeFinally(pageController2, null);
            return zIsIndentActionAllowed;
        } finally {
        }
    }

    public final void setZoomController(EditingController.ZoomController controller) {
        ZoomState zoomStateCopy$default;
        if (controller != null) {
            this.zoomController = controller;
            if (getShowZoomPanel()) {
                controller.setZoomChangedListener(new EditingController.ZoomChangedListener() { // from class: com.myscript.nebo.editing.PageViewModel$$ExternalSyntheticLambda4
                    @Override // com.myscript.nebo.editing.EditingController.ZoomChangedListener
                    public final void onZoomChanged(float f, boolean z) {
                        PageViewModel.setZoomController$lambda$0(this.f$0, f, z);
                    }
                });
                zoomStateCopy$default = ZoomState.copy$default(getCurrentZoomState(), false, false, controller.currentZoom(), false, true, 11, null);
            } else {
                zoomStateCopy$default = new ZoomState(false, false, 0.0f, false, false, 31, null);
            }
        } else {
            EditingController.ZoomController zoomController = this.zoomController;
            if (zoomController != null) {
                zoomController.setZoomChangedListener(null);
            }
            this.zoomController = null;
            zoomStateCopy$default = ZoomState.copy$default(getCurrentZoomState(), false, false, 0.0f, false, false, 15, null);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64171(zoomStateCopy$default, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setZoomController$lambda$0(PageViewModel pageViewModel, float f, boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(pageViewModel), pageViewModel.mainDispatcher, null, new PageViewModel$setZoomController$zoomState$1$1(pageViewModel, f, z, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$setZoomController$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$setZoomController$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ZoomState $zoomState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64171(ZoomState zoomState, Continuation<? super C64171> continuation) {
            super(2, continuation);
            this.$zoomState = zoomState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64171(this.$zoomState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PageViewModel.this._zoom.setValue(this.$zoomState);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$checkZoomNotLocked$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$checkZoomNotLocked$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64061(Continuation<? super C64061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PageViewModel.this._zoom.setValue(ZoomState.copy$default(PageViewModel.this.getCurrentZoomState(), false, true, 0.0f, false, false, 29, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final boolean checkZoomNotLocked() {
        if (!getCurrentZoomState().getLocked()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64061(null), 2, null);
        return false;
    }

    public final void zoom(float zoomFactor) {
        EditingController.ZoomController zoomController;
        if (!checkZoomNotLocked() || (zoomController = this.zoomController) == null) {
            return;
        }
        zoomController.zoom(zoomFactor, DEFAULT_ZOOM_FROM_REFERENCE, false);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$toggleLockZoom$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$toggleLockZoom$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64191(Continuation<? super C64191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PageViewModel.this._zoom.setValue(ZoomState.copy$default(PageViewModel.this.getCurrentZoomState(), !PageViewModel.this.getCurrentZoomState().getLocked(), false, 0.0f, false, false, 30, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleLockZoom() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64191(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$zoomLockedNotificationTakenIntoAccount$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$zoomLockedNotificationTakenIntoAccount$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64201(Continuation<? super C64201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PageViewModel.this._zoom.setValue(ZoomState.copy$default(PageViewModel.this.getCurrentZoomState(), false, false, 0.0f, false, false, 29, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void zoomLockedNotificationTakenIntoAccount() {
        if (getCurrentZoomState().getNotifyLocked()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64201(null), 2, null);
        }
    }

    public final void registerPageStateListener(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.addPageStateListener(this.onPageStateChange);
        refreshMenuCapabilities();
    }

    public final void unregisterPageStateListener(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        pageController.removePageStateListener(this.onPageStateChange);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageViewModel$hideFreemiumLimitationDialog$1 */
    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$hideFreemiumLimitationDialog$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64091(Continuation<? super C64091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageViewModel.this.new C64091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FreemiumLimitationDialogState freemiumLimitationDialogState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = PageViewModel.this._showFreemiumLimitation;
                FreemiumLimitationDialogState freemiumLimitationDialogState2 = (FreemiumLimitationDialogState) PageViewModel.this._showFreemiumLimitation.getValue();
                boolean z = false;
                MessageIdentifier messageIdentifier = null;
                Object[] objArr = 0;
                if (freemiumLimitationDialogState2 == null || (freemiumLimitationDialogState = FreemiumLimitationDialogState.copy$default(freemiumLimitationDialogState2, false, null, 2, null)) == null) {
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(z, messageIdentifier, 3, objArr == true ? 1 : 0);
                }
                mutableLiveData.setValue(freemiumLimitationDialogState);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void hideFreemiumLimitationDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64091(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setConversionEnabled(boolean enabled) {
        String str = enabled ? _UrlKt.PATH_SEGMENT_ENCODE_SET_URI : "[on-hold,scratch]";
        PageController pageController = getPageController();
        if (pageController == null) {
            return;
        }
        PageController pageController2 = pageController;
        try {
            PageController pageController3 = pageController2;
            pageController3.setProperty("diagram.gesture.feature-lock", str);
            pageController3.setProperty("text-document.gesture.feature-lock", str);
            pageController3.setProperty("raw-content.gesture.feature-lock", str);
            pageController3.setProperty("pdf.gesture.feature-lock", str);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(pageController2, null);
        } finally {
        }
    }

    static {
        ClipboardConfiguration clipboardConfiguration = new ClipboardConfiguration();
        clipboardConfiguration.setExportImage(false);
        clipboardConfiguration.setExportHeader(false);
        clipboardConfiguration.setSaveInsteadOfSaveToTemp(true);
        CLIPBOARD_CONFIGURATION = clipboardConfiguration;
        DEFAULT_ZOOM_FROM_REFERENCE = DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER;
    }
}
