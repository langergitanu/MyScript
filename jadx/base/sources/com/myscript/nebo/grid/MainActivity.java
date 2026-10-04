package com.myscript.nebo.grid;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ClipDescription;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.C0028R;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import com.google.android.material.C4627R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.myscript.android.utils.ActivityExtKt;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.ViewExt;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.MainActivityDetailFragment;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.NeboBaseActivity;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.Shortcut;
import com.myscript.nebo.UserSessionManager;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.backup.BackupRestoreViewModel;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.common.utils.PopupUtils;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.DragPageClipDataHelper;
import com.myscript.nebo.dms.core.FolderPropertiesValidatorKt;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.dialog.CollectionDialog;
import com.myscript.nebo.dms.dialog.FolderPickerDialog;
import com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment;
import com.myscript.nebo.dms.event.CollectionMoreMenuEvent;
import com.myscript.nebo.dms.event.NotebookMoreMenuEvent;
import com.myscript.nebo.dms.expandlist.NotebookItemViewHolder;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.editing.ThumbnailImageCreator;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.freemium.FreemiumLimitationDialogKt;
import com.myscript.nebo.freemium.FreemiumLimitationDialogState;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.freemium.FreemiumLimitationViewModelKt;
import com.myscript.nebo.freemium.PromotionController;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.MainActivity;
import com.myscript.nebo.grid.MainViewFragment;
import com.myscript.nebo.grid.Screen;
import com.myscript.nebo.help.BackupReminderDialog;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.migration.ILenovoMigrationController;
import com.myscript.nebo.note.NoteType;
import com.myscript.nebo.note.p030ui.NoteCreationDialogFragment;
import com.myscript.nebo.p034ui.compose.DataCollectDialogKt;
import com.myscript.nebo.p034ui.compose.LenovoMigrationOnboardingKt;
import com.myscript.nebo.p034ui.compose.OEMOffersKt;
import com.myscript.nebo.p034ui.compose.RenewalOfferKt;
import com.myscript.nebo.purchase.PaywallKt;
import com.myscript.nebo.purchase.PaywallViewModel;
import com.myscript.nebo.sidenavigation.SidePanelFragment;
import com.myscript.nebo.sso.IHelpUsConsumer;
import com.myscript.nebo.trash.p033ui.TrashDiscoverabilityDialogKt;
import com.myscript.nebo.trash.p033ui.TrashedPagesFragment;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.CrossSellDialog;
import com.myscript.nebo.whatsnew.CrossSellFilter;
import com.myscript.nebo.whatsnew.CrossSellOrigin;
import com.myscript.nebo.whatsnew.FancyWhatsNew;
import com.myscript.nebo.whatsnew.FancyWhatsNewData;
import com.myscript.nebo.whatsnew.FancyWhatsNewDialog;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSFilter;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.squareup.otto.Subscribe;
import com.survicate.surveys.TextRecallingManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ÷\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002÷\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010[\u001a\u00020Y2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020YH\u0002J\u001a\u0010_\u001a\u00020Y2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010c\u001a\u00020Y2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020Y2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020Y2\u0006\u0010j\u001a\u00020\u0012H\u0002J\u0010\u0010k\u001a\u00020Y2\u0006\u0010l\u001a\u00020\u0012H\u0002J\u0010\u0010m\u001a\u00020Y2\u0006\u0010n\u001a\u00020oH\u0002J+\u0010p\u001a\u00020Y2\u0006\u0010q\u001a\u00020r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020]0t2\u0006\u0010u\u001a\u00020vH\u0016¢\u0006\u0002\u0010wJ\u000e\u0010x\u001a\u00020Y2\u0006\u0010y\u001a\u00020zJ\b\u0010{\u001a\u00020YH\u0002J\b\u0010|\u001a\u00020YH\u0002J\b\u0010}\u001a\u00020YH\u0002J\u000e\u0010~\u001a\u00020Y2\u0006\u0010\u007f\u001a\u00020zJ\u0012\u0010\u0080\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020\u0012H\u0002J\u0007\u0010\u0082\u0001\u001a\u00020YJ\u0019\u0010\u0083\u0001\u001a\u00020Y2\u000e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020z0\u0085\u0001H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020Y2\u0006\u0010\u007f\u001a\u00020z2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020Y2\u0007\u0010n\u001a\u00030\u0089\u0001H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020Y2\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0016J\u0019\u0010\u008c\u0001\u001a\u00020Y2\u000e\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0085\u0001H\u0016J\t\u0010\u008e\u0001\u001a\u00020YH\u0016J\u001c\u0010\u008f\u0001\u001a\u00020Y2\u0011\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u0085\u0001H\u0002J\u0013\u0010\u0092\u0001\u001a\u00020\u00122\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020Y2\u0007\u0010\u0096\u0001\u001a\u00020UH\u0014J\u0013\u0010\u0097\u0001\u001a\u00020\u00122\b\u0010\u0093\u0001\u001a\u00030\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020YH\u0002J\u001b\u0010\u009a\u0001\u001a\u00020Y2\u0007\u0010\u009b\u0001\u001a\u00020]2\u0007\u0010\u009c\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u009d\u0001\u001a\u00020YH\u0014J\t\u0010\u009e\u0001\u001a\u00020YH\u0016J\t\u0010\u009f\u0001\u001a\u00020YH\u0014J\t\u0010 \u0001\u001a\u00020YH\u0014J\t\u0010¡\u0001\u001a\u00020YH\u0014J\t\u0010¢\u0001\u001a\u00020YH\u0014J\u0012\u0010£\u0001\u001a\u00020Y2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0014J\u001c\u0010¥\u0001\u001a\u00020\u00122\u0007\u0010¦\u0001\u001a\u00020r2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\t\u0010¨\u0001\u001a\u00020YH\u0002J\u0014\u0010©\u0001\u001a\u00020Y2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010ª\u0001\u001a\u00020Y2\u000b\b\u0002\u0010«\u0001\u001a\u0004\u0018\u00010\u0010J\u0007\u0010¬\u0001\u001a\u00020YJ\u0012\u0010\u00ad\u0001\u001a\u00020Y2\t\u0010®\u0001\u001a\u0004\u0018\u00010\fJ\t\u0010¯\u0001\u001a\u00020YH\u0002J\u0014\u0010°\u0001\u001a\u00020Y2\t\u0010±\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u001b\u0010²\u0001\u001a\u00020Y2\u0007\u0010\u009b\u0001\u001a\u00020]2\u0007\u0010³\u0001\u001a\u00020\u000eH\u0002J\u001b\u0010´\u0001\u001a\u00020Y2\u0007\u0010\u009b\u0001\u001a\u00020]2\u0007\u0010³\u0001\u001a\u00020\u000eH\u0002J\u001b\u0010µ\u0001\u001a\u00020Y2\u0006\u0010D\u001a\u00020E2\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\u0013\u0010¸\u0001\u001a\u00020Y2\b\u0010\u0093\u0001\u001a\u00030¹\u0001H\u0007J\u0013\u0010º\u0001\u001a\u00020Y2\b\u0010\u0093\u0001\u001a\u00030»\u0001H\u0007J\t\u0010¼\u0001\u001a\u00020YH\u0002J\u0013\u0010½\u0001\u001a\u00020\u00122\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u0012\u0010À\u0001\u001a\u00020Y2\u0007\u0010Á\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020Y2\u0007\u0010Á\u0001\u001a\u00020\u0010H\u0002J\t\u0010È\u0001\u001a\u00020YH\u0016J\t\u0010É\u0001\u001a\u00020YH\u0002J\t\u0010Ê\u0001\u001a\u00020YH\u0016J\u001a\u0010Î\u0001\u001a\u00020Y2\u000f\u0010Ï\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u0085\u0001H\u0016J\u0012\u0010Ñ\u0001\u001a\u00020Y2\u0007\u0010Ò\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010Ó\u0001\u001a\u00020Y2\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0016J\u001b\u0010Ó\u0001\u001a\u00020Y2\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010Ô\u0001\u001a\u00020\u0012H\u0002J\t\u0010Õ\u0001\u001a\u00020YH\u0016J\u0012\u0010Ö\u0001\u001a\u00020Y2\u0007\u0010×\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010Ù\u0001\u001a\u00020Y2\u0007\u0010Ú\u0001\u001a\u00020\u0012H\u0002J\u0012\u0010Û\u0001\u001a\u00020Y2\u0007\u0010Ò\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010Ü\u0001\u001a\u00020\u00122\t\u0010Ý\u0001\u001a\u0004\u0018\u00010<2\b\u0010\u0093\u0001\u001a\u00030Þ\u0001H\u0002J\t\u0010ß\u0001\u001a\u00020YH\u0016J\u001c\u0010à\u0001\u001a\u00020Y2\b\u0010á\u0001\u001a\u00030Ð\u00012\u0007\u0010â\u0001\u001a\u00020\fH\u0016J\u0011\u0010ã\u0001\u001a\u00020Y2\u0006\u0010l\u001a\u00020\u0012H\u0002J\t\u0010ä\u0001\u001a\u00020YH\u0016J\t\u0010å\u0001\u001a\u00020YH\u0016J\t\u0010æ\u0001\u001a\u00020YH\u0016J\t\u0010ç\u0001\u001a\u00020YH\u0016J+\u0010è\u0001\u001a\u00020Y2\u000f\u0010é\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u0085\u00012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u0085\u0001H\u0016J\t\u0010ë\u0001\u001a\u00020YH\u0007J\t\u0010ì\u0001\u001a\u00020YH\u0016J\t\u0010í\u0001\u001a\u00020YH\u0002J\t\u0010î\u0001\u001a\u00020YH\u0002J\t\u0010ï\u0001\u001a\u00020YH\u0002J\t\u0010ð\u0001\u001a\u00020YH\u0002J\t\u0010ñ\u0001\u001a\u00020\u0012H\u0016J\t\u0010ò\u0001\u001a\u00020YH\u0016J\u001c\u0010ó\u0001\u001a\u00020Y2\b\u0010ô\u0001\u001a\u00030õ\u00012\u0007\u0010ö\u0001\u001a\u00020\u0012H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b6\u00107R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010§\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0t0TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Â\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0017\u0010Ä\u0001\u001a\u00020\u00128BX\u0082\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Ã\u0001R\u0017\u0010Å\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Ã\u0001R\u0017\u0010Æ\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ã\u0001R\u0017\u0010Ç\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010Ã\u0001R\u0019\u0010Ë\u0001\u001a\u0004\u0018\u00010]8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0017\u0010Ø\u0001\u001a\u00020\u00128BX\u0082\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ã\u0001¨\u0006ø\u0001²\u0006\u000b\u0010ù\u0001\u001a\u00020\u0012X\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/grid/MainActivity;", "Lcom/myscript/nebo/NeboBaseActivity;", "Lcom/myscript/nebo/sidenavigation/SidePanelFragment$Callback;", "Lcom/myscript/nebo/grid/MainViewFragment$ActionListener;", "Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncCallback;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Lcom/myscript/nebo/sso/IHelpUsConsumer;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "openedMenuNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "openedMenuNotebookState", "Landroid/os/Bundle;", "openedMenuCollectionKey", "Lcom/myscript/snt/core/CollectionKey;", "isFromFreshInstall", "", "importRequestData", "Lcom/myscript/nebo/grid/ImportRequestData;", "libraryViewModel", "Lcom/myscript/nebo/dms/core/LibraryViewModel;", "getLibraryViewModel", "()Lcom/myscript/nebo/dms/core/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getLanguageViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "languageViewModel$delegate", "mainViewModel", "Lcom/myscript/nebo/grid/MainViewModel;", "getMainViewModel", "()Lcom/myscript/nebo/grid/MainViewModel;", "mainViewModel$delegate", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "getGridViewModel", "()Lcom/myscript/nebo/grid/GridViewModel;", "gridViewModel$delegate", "paywallViewModel", "Lcom/myscript/nebo/purchase/PaywallViewModel;", "getPaywallViewModel", "()Lcom/myscript/nebo/purchase/PaywallViewModel;", "paywallViewModel$delegate", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "backupRestoreViewModel", "Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "getBackupRestoreViewModel", "()Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "backupRestoreViewModel$delegate", "contentLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "sidePanel", "Landroid/view/View;", "onLayoutChangedListener", "Landroid/view/View$OnLayoutChangeListener;", "paywallView", "Landroidx/compose/ui/platform/ComposeView;", "showPaywallDialog", "Landroidx/compose/runtime/MutableState;", "loadingProgress", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "notesFragment", "Lcom/myscript/nebo/grid/MainViewFragment;", "sidePanelFragment", "Lcom/myscript/nebo/sidenavigation/SidePanelFragment;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "navIcon", "Landroid/graphics/drawable/Drawable;", "composeDialogHost", "oemOfferHost", "renewalOfferHost", "dataCollectHost", "lenovoMigrationHost", "loginActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "menuProvider", "Landroidx/core/view/MenuProvider;", "onCreate", "", "savedInstanceState", "onShowPaywall", "origin", "", "showPaywallAtPromotionStart", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", SubscriberAttributeKt.JSON_NAME_KEY, "onSidePanelUpdated", "sidePanelState", "Lcom/myscript/nebo/grid/SidePanelState;", "onCurrentScreenChanged", "screen", "Lcom/myscript/nebo/grid/Screen;", "onSearchActiveUpdate", "isSearchActive", "onSyncCanceledOverCellular", "canceled", "onLibraryUpdate", "state", "Lcom/myscript/nebo/dms/core/LibraryViewModel$State;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "handleNeboFileImport", "uri", "Landroid/net/Uri;", "handleNeboFileImportRequest", "onDiscardSearch", "handleBackupImportRequest", "importBackup", "requestedUri", "handlePdfImportRequest", "importFromOutSide", "launchImport", "importDocuments", "uris", "", "importPdf", "targetNotebookKey", "onPdfImportStateChanged", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "onFolderClicked", "notebookKey", "moveToTrash", "notebookKeys", "onUpdateRequired", "onPagesUpdated", "pageModels", "Lcom/myscript/nebo/dms/core/model/PageModel;", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onNewIntent", "intent", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "dispatchImportRequest", "onTargetFolderSelectionResult", "requestKey", "resultBundle", "onDestroy", "onBackPressed", "onStart", "onResume", "onPause", "onStop", "onSaveInstanceState", "outState", "onKeyShortcut", "keyCode", "getDocuments", "showFileImportErrorDialog", "onOpenedFolderChange", "requestNewFolderDialog", "targetCollectionKey", "requestNewCollectionDialog", "requestFolderMenuEdit", "folderKey", "showTooRecentFileErrorDialog", "requestSyncNotebookItemPopup", "clickedNotebookKey", "onCollectionOperationResult", "resultData", "onFolderEditorResult", "popupMenuCreated", "popupInfo", "Lcom/myscript/nebo/common/utils/PopupUtils$PopupInfoSaveInstanceState;", "onNotebookMoreMenuEvent", "Lcom/myscript/nebo/dms/event/NotebookMoreMenuEvent;", "onCollectionItemMoreMenuEvent", "Lcom/myscript/nebo/dms/event/CollectionMoreMenuEvent;", "resetPopupMenu", "onPopupMenuItemClick", "item", "Landroid/view/MenuItem;", "requestCollectionItemEdit", "collectionKey", "isCloudConnected", "()Z", "isSyncable", "isAutoSyncEnabled", "isSearching", "isLastSyncActionAUserAction", "close", "stopSelection", "onStartDraggingPage", "searchLabel", "getSearchLabel", "()Ljava/lang/String;", "onExport", "pageKeys", "Lcom/myscript/snt/core/PageKey;", "setLoadingEnabled", "enabled", "onSyncRequested", "openFolderAfter", "resumeSync", "onDMSSelectionChanged", "isSelectionMode", "isSidePanelOpen", "animateSidePanel", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "setContentOverlayEnabled", "onDrag", "v", "Landroid/view/DragEvent;", "closeSearchIfNotStarted", "movePage", "pageKey", "newNotebookKey", "onLanguageDownloadCanceledOverCellular", "onSync", "onCancelSync", "onEnableCellular", "onConnect", "onConflictedPageCopies", "duplicatedPageKeys", "duplicatedPageKeys2", "closeCurrentNotebook", "onSyncTextClicked", "displayAutoSyncInformationDialogIfCloudConnected", "showTrashDiscoverabilityIfNeeded", "showBackupReminderIfNeeded", "maybeShowCrossSell", "canShowHelpUsDialog", "showHelpUsDialog", "openCloudDisconnectedDialog", "cloudProviderType", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "clientInitialized", "Companion", "app_standardRelease", "showMigration"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MainActivity extends NeboBaseActivity implements SidePanelFragment.Callback, MainViewFragment.ActionListener, LibraryViewModel.SyncCallback, SharedPreferences.OnSharedPreferenceChangeListener, IHelpUsConsumer {
    private static final String COLLECTION_ITEM_MORE_MENU = "COLLECTION_ITEM_MORE_MENU";
    public static final String EXTRA_FROM_FRESH_INSTALL = "EXTRA_FROM_FRESH_INSTALL";
    private static final int IMPORT_NEBO_FILE_PERMISSION_REQUEST_CODE = 10;
    private static final int IMPORT_PDF_FROM_NEBO_PERMISSION_REQUEST_CODE = 11;
    private static final int IMPORT_PDF_FROM_OUTSIDE_PERMISSION_REQUEST_CODE = 12;
    public static final String IMPORT_REQUEST_DATA_FROM_INTENT = "IMPORT_REQUEST_DATA_FROM_INTENT";
    public static final String LAST_PROMOTIONAL_CAMPAIGN_FOR_WHICH_PAYWALL_WAS_DISPLAYED = "LAST_PROMOTIONAL_CAMPAIGN_FOR_WHICH_PAYWALL_WAS_DISPLAYED";
    private static final String NOTEBOOK_ITEM_MORE_MENU = "NOTEBOOK_ITEM_MORE_MENU";
    private static final String TAG = "MainActivity";

    /* JADX INFO: renamed from: backupRestoreViewModel$delegate, reason: from kotlin metadata */
    private final Lazy backupRestoreViewModel;
    private ComposeView composeDialogHost;
    private ConstraintLayout contentLayout;
    private ComposeView dataCollectHost;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;

    /* JADX INFO: renamed from: gridViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gridViewModel;
    private ImportRequestData importRequestData;
    private boolean isFromFreshInstall;

    /* JADX INFO: renamed from: languageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy languageViewModel;
    private ComposeView lenovoMigrationHost;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    private View loadingProgress;
    private TechnicalLogger logger;

    /* JADX INFO: renamed from: mainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainViewModel;
    private Drawable navIcon;
    private MainViewFragment notesFragment;
    private ComposeView oemOfferHost;
    private View.OnLayoutChangeListener onLayoutChangedListener;
    private CollectionKey openedMenuCollectionKey;
    private NotebookKey openedMenuNotebookKey;
    private Bundle openedMenuNotebookState;
    private ComposeView paywallView;

    /* JADX INFO: renamed from: paywallViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paywallViewModel;
    private PopupMenu popupMenu;
    private ComposeView renewalOfferHost;
    private View sidePanel;
    private SidePanelFragment sidePanelFragment;
    private Toolbar toolbar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final MutableState<Boolean> showPaywallDialog = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final ActivityResultLauncher<Intent> loginActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda20
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "it");
        }
    });
    private final MenuProvider menuProvider = new MenuProvider() { // from class: com.myscript.nebo.grid.MainActivity$menuProvider$1
        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            if (menuItem.getItemId() != 16908332) {
                return false;
            }
            this.this$0.getMainViewModel().toggleSidePanel();
            return true;
        }
    };
    private final ActivityResultLauncher<String[]> getDocuments = registerForActivityResult(new ActivityResultContracts.OpenMultipleDocuments(), new ActivityResultCallback() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda21
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.getDocuments$lambda$0(this.f$0, (List) obj);
        }
    });

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ImportableKind.values().length];
            try {
                iArr[ImportableKind.NEBO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImportableKind.PDF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImportableKind.UNSUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CloudManager.CloudProviderType.values().length];
            try {
                iArr2[CloudManager.CloudProviderType.Dropbox.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CloudManager.CloudProviderType.GDrive.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @JvmStatic
    public static final Intent newIntent(Activity activity) {
        return INSTANCE.newIntent(activity);
    }

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onCancelSync() {
    }

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onSyncTextClicked() {
    }

    public MainActivity() {
        final MainActivity mainActivity = this;
        final Function0 function0 = null;
        this.libraryViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LibraryViewModel.Factory;
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.languageViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.languageViewModel_delegate$lambda$0(this.f$0);
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.mainViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainViewModel.Factory;
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.gridViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GridViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GridViewModel.Factory;
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.paywallViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaywallViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.paywallViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.freemiumLimitationViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.backupRestoreViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(BackupRestoreViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.backupRestoreViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.MainActivity$special$$inlined$viewModels$default$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    private final LanguageViewModel getLanguageViewModel() {
        return (LanguageViewModel) this.languageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory languageViewModel_delegate$lambda$0(MainActivity mainActivity) {
        ComponentCallbacks2 application = mainActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider");
        List<String> listProvideSuggestedLanguages = ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages();
        Configuration configuration = mainActivity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        return new LanguageViewModel.Factory(new LanguageNameHelper(LocaleExt.getPrimaryLocale(configuration)), listProvideSuggestedLanguages);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel.getValue();
    }

    private final GridViewModel getGridViewModel() {
        return (GridViewModel) this.gridViewModel.getValue();
    }

    private final PaywallViewModel getPaywallViewModel() {
        return (PaywallViewModel) this.paywallViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory paywallViewModel_delegate$lambda$0() {
        return new PaywallViewModel.Factory();
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory backupRestoreViewModel_delegate$lambda$0() {
        return BackupRestoreViewModel.INSTANCE.getFactory();
    }

    private final BackupRestoreViewModel getBackupRestoreViewModel() {
        return (BackupRestoreViewModel) this.backupRestoreViewModel.getValue();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ImportRequestData importRequestDataFromIntent;
        PageKey lastOpenedNoteKey;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        if (getLibraryRepository().getDisplayMetrics() == null) {
            DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(this);
            getLibraryRepository().setDisplayMetrics(fixedDisplayMetrics);
            LibraryRepository libraryRepository = getLibraryRepository();
            Intrinsics.checkNotNull(fixedDisplayMetrics);
            libraryRepository.setThumbnailImageRequester(new ThumbnailImageCreator(fixedDisplayMetrics, new File(getCacheDir(), "thumbnail_image_cache")));
        }
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        this.logger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
        ComponentCallbacks2 application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        final ApplicationState applicationStateProvideApplicationState = ((IApplicationStateProvider) application2).provideApplicationState();
        Bundle extras = savedInstanceState == null ? getIntent().getExtras() : savedInstanceState;
        this.isFromFreshInstall = extras != null ? extras.getBoolean(EXTRA_FROM_FRESH_INSTALL) : false;
        if (savedInstanceState == null || (importRequestDataFromIntent = ImportRequestData.fromBundle(savedInstanceState.getBundle(IMPORT_REQUEST_DATA_FROM_INTENT))) == null) {
            Intent intent = getIntent();
            importRequestDataFromIntent = intent != null ? ImportRequestData.fromIntent(this, intent) : null;
        }
        this.importRequestData = importRequestDataFromIntent;
        MainActivity mainActivity = this;
        ActivityExtKt.setFragmentResultListener(mainActivity, FolderPickerDialog.PDF_IMPORT_REQUEST_KEY, new C65403(this));
        ActivityExtKt.setFragmentResultListener(mainActivity, FolderPickerDialog.NEBO_FILE_IMPORT_REQUEST_KEY, new C65444(this));
        ActivityExtKt.setFragmentResultListener(mainActivity, ExportDialog.REQUEST_KEY, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$2(this.f$0, (String) obj, (Bundle) obj2);
            }
        });
        ActivityExtKt.setFragmentResultListener(mainActivity, CollectionDialog.REQUEST_KEY_NEW, new C65456(this));
        ActivityExtKt.setFragmentResultListener(mainActivity, CollectionDialog.REQUEST_KEY_EDIT, new C65467(this));
        ActivityExtKt.setFragmentResultListener(mainActivity, FolderEditorDialogFragment.REQUEST_KEY, new C65478(this));
        setContentView(C6079R.layout.main_activity);
        findDebugView();
        ComponentCallbacks2 application3 = getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
        MainActivity mainActivity2 = this;
        ((ColorPolicyRepositoryProvider) application3).provideColorPolicyRepository().getColorPolicy().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$3(this.f$0, (IColorInversionPolicy) obj);
            }
        }));
        addMenuProvider(this.menuProvider);
        View viewFindViewById = findViewById(C6079R.id.main_fragment_layout);
        viewFindViewById.setOnDragListener(new View.OnDragListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda28
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return this.f$0.onDrag(view, dragEvent);
            }
        });
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExt.configureForEdgeToEdge(viewFindViewById);
        this.contentLayout = (ConstraintLayout) findViewById(C6079R.id.main_activity_side_by_side_layout);
        this.sidePanel = findViewById(C6079R.id.main_activity_side_panel);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C6079R.dimen.elevation_toolbar);
        View view = this.sidePanel;
        if (view != null) {
            view.setElevation(dimensionPixelSize + 1);
            ViewExt.configureForEdgeToEdge(view);
        }
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda29
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                MainActivity.onCreate$lambda$5(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.onLayoutChangedListener = onLayoutChangeListener;
        ConstraintLayout constraintLayout = this.contentLayout;
        if (constraintLayout != null) {
            constraintLayout.addOnLayoutChangeListener(onLayoutChangeListener);
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), C6079R.drawable.ic_menu_burger, getTheme());
        if (drawable != null) {
            drawable.setAlpha(255);
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(C4627R.attr.colorOnSurface, typedValue, true);
            drawable.setTint(typedValue.data);
        } else {
            drawable = null;
        }
        this.navIcon = drawable;
        this.paywallView = (ComposeView) findViewById(C6079R.id.main_activity_paywall);
        this.loadingProgress = findViewById(C6079R.id.main_activity_loading_progress);
        View viewFindViewById2 = findViewById(C6079R.id.main_activity_content_overlay);
        viewFindViewById2.setVisibility(8);
        viewFindViewById2.setOnClickListener(null);
        getLibraryViewModel().getOpenNotebookKey().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653214(this)));
        getLibraryViewModel().getState().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653315(this)));
        getLibraryViewModel().isSearchActive().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653416(this)));
        getLibraryViewModel().addSyncCallback(this);
        getLibraryViewModel().getSyncCanceledOverCellularNotification().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$7(this.f$0, (Boolean) obj);
            }
        }));
        getLibraryViewModel().getCloudTokenExpiredNotification().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$8(this.f$0, (Boolean) obj);
            }
        }));
        getLanguageViewModel().getDownloadCanceledOverCellularNotification().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$9(this.f$0, (Boolean) obj);
            }
        }));
        getGridViewModel().getFolderUIState().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$10(this.f$0, (FolderUIState) obj);
            }
        }));
        getGridViewModel().getImportState().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653521(this)));
        if (savedInstanceState == null && this.importRequestData == null) {
            NotebookKey lastOpenedFolderKey = getLibraryRepository().getLastOpenedFolderKey();
            if (lastOpenedFolderKey != null) {
                getGridViewModel().openFolder(lastOpenedFolderKey);
            }
            if (!applicationStateProvideApplicationState.requiresWhatsNew() && (lastOpenedNoteKey = getLibraryRepository().getLastOpenedNoteKey()) != null) {
                getGridViewModel().openPage(lastOpenedNoteKey);
            }
        }
        getMainViewModel().deviceConfigurationChanged(getResources().getBoolean(C6079R.bool.side_panel_side_by_side), savedInstanceState == null);
        getBackupRestoreViewModel().addBackupRestoreListener(getMainViewModel().getBackupRestoreListener());
        getMainViewModel().getScreen().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653624(this)));
        getMainViewModel().getSidePanelState().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new C653725(this)));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity2), null, null, new C653826(null), 3, null);
        invalidateOptionsMenu();
        displayAutoSyncInformationDialogIfCloudConnected();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        final FancyWhatsNewData pdfOptimizationWhatsNewData = FancyWhatsNew.getPdfOptimizationWhatsNewData();
        if (applicationStateProvideApplicationState.requiresWhatsNew()) {
            FancyWhatsNewDialog fancyWhatsNewDialogNewInstance = FancyWhatsNewDialog.INSTANCE.newInstance(pdfOptimizationWhatsNewData);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            fancyWhatsNewDialogNewInstance.show(supportFragmentManager);
        }
        ActivityExtKt.setFragmentResultListener(mainActivity, FancyWhatsNewDialog.REQUEST_KEY, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$12(applicationStateProvideApplicationState, pdfOptimizationWhatsNewData, this, (String) obj, (Bundle) obj2);
            }
        });
        this.composeDialogHost = (ComposeView) findViewById(C6079R.id.main_activity_compose_dialog_host);
        this.oemOfferHost = (ComposeView) findViewById(C6079R.id.main_activity_oem_offer);
        this.renewalOfferHost = (ComposeView) findViewById(C6079R.id.main_activity_renewal_offer);
        this.dataCollectHost = (ComposeView) findViewById(C6079R.id.data_collect_dialog);
        this.lenovoMigrationHost = (ComposeView) findViewById(C6079R.id.main_activity_lenovo_migration);
        getFreemiumLimitationViewModel().getFreemiumLimitationDialogState().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.onCreate$lambda$13(this.f$0, (FreemiumLimitationDialogState) obj);
            }
        }));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity2), null, null, new C653929(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity2), null, null, new C654130(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity2), null, null, new C654231(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity2), null, null, new C654332(null), 3, null);
        ComposeView composeView = this.lenovoMigrationHost;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-627129900, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$14(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$3 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C65403 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
        C65403(Object obj) {
            super(2, obj, MainActivity.class, "onTargetFolderSelectionResult", "onTargetFolderSelectionResult(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
            invoke2(str, bundle);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((MainActivity) this.receiver).onTargetFolderSelectionResult(p0, p1);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$4 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C65444 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
        C65444(Object obj) {
            super(2, obj, MainActivity.class, "onTargetFolderSelectionResult", "onTargetFolderSelectionResult(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
            invoke2(str, bundle);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((MainActivity) this.receiver).onTargetFolderSelectionResult(p0, p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(MainActivity mainActivity, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getInt("RESULT_KEY") == 0) {
            mainActivity.stopSelection();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$6 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C65456 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
        C65456(Object obj) {
            super(2, obj, MainActivity.class, "onCollectionOperationResult", "onCollectionOperationResult(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
            invoke2(str, bundle);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((MainActivity) this.receiver).onCollectionOperationResult(p0, p1);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$7 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C65467 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
        C65467(Object obj) {
            super(2, obj, MainActivity.class, "onCollectionOperationResult", "onCollectionOperationResult(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
            invoke2(str, bundle);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((MainActivity) this.receiver).onCollectionOperationResult(p0, p1);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$8 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C65478 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
        C65478(Object obj) {
            super(2, obj, MainActivity.class, "onFolderEditorResult", "onFolderEditorResult(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
            invoke2(str, bundle);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((MainActivity) this.receiver).onFolderEditorResult(p0, p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(MainActivity mainActivity, IColorInversionPolicy iColorInversionPolicy) {
        LibraryRepository libraryRepository = mainActivity.getLibraryRepository();
        Intrinsics.checkNotNull(iColorInversionPolicy);
        libraryRepository.updateColorPolicy(iColorInversionPolicy, DarkModeUtils.isDarkMode((Activity) mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(MainActivity mainActivity, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7 - i5;
        int i10 = i3 - i;
        View view2 = mainActivity.sidePanel;
        ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        if (i9 == i10 || layoutParams == null) {
            return;
        }
        boolean z = mainActivity.getResources().getBoolean(C6079R.bool.side_panel_fullscreen);
        layoutParams.width = z ? i10 : mainActivity.getResources().getDimensionPixelSize(C6079R.dimen.side_panel_width);
        if (z && mainActivity.getMainViewModel().getIsSidePanelOpen()) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(mainActivity.contentLayout);
            constraintSet.setGuidelineBegin(C6079R.id.main_activity_sidepanel_guideline, i10);
            constraintSet.applyTo(mainActivity.contentLayout);
        }
        View view3 = mainActivity.sidePanel;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$14 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653214 extends FunctionReferenceImpl implements Function1<NotebookKey, Unit> {
        C653214(Object obj) {
            super(1, obj, MainActivity.class, "onOpenedFolderChange", "onOpenedFolderChange(Lcom/myscript/snt/core/NotebookKey;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotebookKey notebookKey) {
            invoke2(notebookKey);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotebookKey notebookKey) {
            ((MainActivity) this.receiver).onOpenedFolderChange(notebookKey);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$15 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653315 extends FunctionReferenceImpl implements Function1<LibraryViewModel.State, Unit> {
        C653315(Object obj) {
            super(1, obj, MainActivity.class, "onLibraryUpdate", "onLibraryUpdate(Lcom/myscript/nebo/dms/core/LibraryViewModel$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LibraryViewModel.State state) {
            invoke2(state);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LibraryViewModel.State p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainActivity) this.receiver).onLibraryUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$16 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653416 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C653416(Object obj) {
            super(1, obj, MainActivity.class, "onSearchActiveUpdate", "onSearchActiveUpdate(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((MainActivity) this.receiver).onSearchActiveUpdate(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7(MainActivity mainActivity, Boolean bool) {
        if (bool != null) {
            mainActivity.onSyncCanceledOverCellular(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$8(MainActivity mainActivity, Boolean bool) {
        if (bool != null) {
            mainActivity.onCloudTokenExpired(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9(MainActivity mainActivity, Boolean bool) {
        if (bool != null) {
            mainActivity.onLanguageDownloadCanceledOverCellular(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$21 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653521 extends FunctionReferenceImpl implements Function1<GridViewModel.ImportStateUI, Unit> {
        C653521(Object obj) {
            super(1, obj, MainActivity.class, "onPdfImportStateChanged", "onPdfImportStateChanged(Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GridViewModel.ImportStateUI importStateUI) {
            invoke2(importStateUI);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GridViewModel.ImportStateUI p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainActivity) this.receiver).onPdfImportStateChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10(MainActivity mainActivity, FolderUIState folderUIState) {
        mainActivity.onPagesUpdated(folderUIState.getPages());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$24 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653624 extends FunctionReferenceImpl implements Function1<Screen, Unit> {
        C653624(Object obj) {
            super(1, obj, MainActivity.class, "onCurrentScreenChanged", "onCurrentScreenChanged(Lcom/myscript/nebo/grid/Screen;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Screen screen) {
            invoke2(screen);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Screen p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainActivity) this.receiver).onCurrentScreenChanged(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$25 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C653725 extends FunctionReferenceImpl implements Function1<SidePanelState, Unit> {
        C653725(Object obj) {
            super(1, obj, MainActivity.class, "onSidePanelUpdated", "onSidePanelUpdated(Lcom/myscript/nebo/grid/SidePanelState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SidePanelState sidePanelState) {
            invoke2(sidePanelState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SidePanelState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainActivity) this.receiver).onSidePanelUpdated(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$26 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$26", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_8_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {390}, m1615s = {}, m1616v = 2)
    static final class C653826 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C653826(Continuation<? super C653826> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C653826(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C653826) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$26$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$26$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {382}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainActivity mainActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
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
                    StateFlow<String> paywallOrigin = this.this$0.getMainViewModel().getPaywallOrigin();
                    final MainActivity mainActivity = this.this$0;
                    this.label = 1;
                    if (paywallOrigin.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.MainActivity.onCreate.26.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((String) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(String str, Continuation<? super Unit> continuation) {
                            if (str != null) {
                                mainActivity.onShowPaywall(str);
                            } else {
                                mainActivity.showPaywallDialog.setValue(Boxing.boxBoolean(false));
                            }
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(MainActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(MainActivity.this, null), this) == coroutine_suspended) {
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
    public static final Unit onCreate$lambda$12(ApplicationState applicationState, FancyWhatsNewData fancyWhatsNewData, MainActivity mainActivity, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        applicationState.setWhatsNewNumber(108);
        if (Intrinsics.areEqual(fancyWhatsNewData.getTag(), result.getString("RESULT_KEY", null))) {
            NoteCreationDialogFragment noteCreationDialogFragmentNewInstance = NoteCreationDialogFragment.INSTANCE.newInstance(NoteType.Notebook);
            FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            noteCreationDialogFragmentNewInstance.show(supportFragmentManager);
        } else {
            mainActivity.showPaywallAtPromotionStart();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13(final MainActivity mainActivity, final FreemiumLimitationDialogState freemiumLimitationDialogState) {
        ComposeView composeView = mainActivity.composeDialogHost;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1729182853, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$13$0(freemiumLimitationDialogState, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13$0(FreemiumLimitationDialogState freemiumLimitationDialogState, final MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:MainActivity.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729182853, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:423)");
            }
            if (freemiumLimitationDialogState.isDialogVisible()) {
                composer.startReplaceGroup(248691903);
                ComposerKt.sourceInformation(composer, "425@20997L75,430@21196L165,434@21408L115,428@21093L452");
                final String originForAnalytics = FreemiumLimitationViewModelKt.getOriginForAnalytics(freemiumLimitationDialogState.getTrigger());
                NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.FreemiumModalDisplay;
                ComposerKt.sourceInformationMarkerStart(composer, -407615952, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChanged = composer.changed(originForAnalytics);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivity.onCreate$lambda$13$0$0$0(originForAnalytics, (Bundle) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                neboFirebaseEvent.log((Function1<? super Bundle, Unit>) objRememberedValue);
                Intrinsics.checkNotNull(freemiumLimitationDialogState);
                ComposerKt.sourceInformationMarkerStart(composer, -407609494, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(mainActivity) | composer.changed(originForAnalytics);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.onCreate$lambda$13$0$1$0(this.f$0, originForAnalytics);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -407602760, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(mainActivity);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.onCreate$lambda$13$0$2$0(this.f$0);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FreemiumLimitationDialogKt.FreemiumLimitationDialog(freemiumLimitationDialogState, function0, (Function0) objRememberedValue3, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(249373841);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13$0$0$0(String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13$0$1$0(MainActivity mainActivity, String str) {
        mainActivity.getFreemiumLimitationViewModel().closeFreemiumLimitationDialog();
        mainActivity.onShowPaywall(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$13$0$2$0(MainActivity mainActivity) {
        mainActivity.getFreemiumLimitationViewModel().closeFreemiumLimitationDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$29 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$29", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {446}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C653929 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C653929(Continuation<? super C653929> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C653929(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C653929) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$29$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ MainActivity this$0;

            AnonymousClass1(MainActivity mainActivity) {
                this.this$0 = mainActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((OEMOfferDialogState) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final OEMOfferDialogState oEMOfferDialogState, Continuation<? super Unit> continuation) {
                ComposeView composeView = this.this$0.oemOfferHost;
                if (composeView != null) {
                    final MainActivity mainActivity = this.this$0;
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-92991608, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$29$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainActivity.C653929.AnonymousClass1.emit$lambda$0(oEMOfferDialogState, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0(OEMOfferDialogState oEMOfferDialogState, final MainActivity mainActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C449@21890L91,452@22019L91,447@21799L333:MainActivity.kt#egc4u2");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-92991608, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:447)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 829381635, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(mainActivity);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$29$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C653929.AnonymousClass1.emit$lambda$0$0$0(mainActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 829385763, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(mainActivity);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$29$1$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C653929.AnonymousClass1.emit$lambda$0$1$0(mainActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    OEMOffersKt.OEMOfferDialog(oEMOfferDialogState, function0, (Function0) objRememberedValue2, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().onOEMOfferDismissed();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$1$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().onOEMOfferDismissed();
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
                if (MainActivity.this.getMainViewModel().getOemOfferDialogState().collect(new AnonymousClass1(MainActivity.this), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$30 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$30", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {462}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C654130 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C654130(Continuation<? super C654130> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C654130(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C654130) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$30$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ MainActivity this$0;

            AnonymousClass1(MainActivity mainActivity) {
                this.this$0 = mainActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final boolean z, Continuation<? super Unit> continuation) {
                ComposeView composeView = this.this$0.renewalOfferHost;
                if (composeView != null) {
                    final MainActivity mainActivity = this.this$0;
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1645512453, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$30$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainActivity.C654130.AnonymousClass1.emit$lambda$0(z, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0(boolean z, final MainActivity mainActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C465@22444L96,468@22578L97,463@22348L349:MainActivity.kt#egc4u2");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1645512453, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:463)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 789506277, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(mainActivity);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$30$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C654130.AnonymousClass1.emit$lambda$0$0$0(mainActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 789510566, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(mainActivity);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$30$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C654130.AnonymousClass1.emit$lambda$0$1$0(mainActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    RenewalOfferKt.RenewalOfferDialog(z, function0, (Function0) objRememberedValue2, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().onRenewalOfferCtaClicked();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$1$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().dismissRenewalOfferDialog();
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
                if (MainActivity.this.getMainViewModel().getRenewalOfferDialogVisible().collect(new AnonymousClass1(MainActivity.this), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$31 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$31", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {478}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C654231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C654231(Continuation<? super C654231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C654231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C654231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$31$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ MainActivity this$0;

            AnonymousClass1(MainActivity mainActivity) {
                this.this$0 = mainActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final boolean z, Continuation<? super Unit> continuation) {
                ComposeView composeView = this.this$0.dataCollectHost;
                if (composeView != null) {
                    final MainActivity mainActivity = this.this$0;
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1203757958, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$31$1$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainActivity.C654231.AnonymousClass1.emit$lambda$0(z, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0(final boolean z, final MainActivity mainActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C479@22915L456,479@22905L466:MainActivity.kt#egc4u2");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1203757958, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:479)");
                    }
                    ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(-456417010, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$31$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainActivity.C654231.AnonymousClass1.emit$lambda$0$0(z, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0(boolean z, final MainActivity mainActivity, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C482@23048L183,486@23279L44,480@22941L408:MainActivity.kt#egc4u2");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-456417010, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:480)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -530077979, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(mainActivity);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$31$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C654231.AnonymousClass1.emit$lambda$0$0$0$0(mainActivity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -530070726, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(mainActivity);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$31$1$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.C654231.AnonymousClass1.emit$lambda$0$0$1$0(mainActivity);
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
            public static final Unit emit$lambda$0$0$0$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().dismissDataCollectDialog();
                mainActivity.getSsoManager().saveShareMyNotesSetting(true, null);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0$0$1$0(MainActivity mainActivity) {
                mainActivity.getMainViewModel().dismissDataCollectDialog();
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
                if (MainActivity.this.getMainViewModel().getDataCollectVisible().collect(new AnonymousClass1(MainActivity.this), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$32 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onCreate$32", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {495}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C654332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C654332(Continuation<? super C654332> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C654332(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C654332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onCreate$32$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ MainActivity this$0;

            AnonymousClass1(MainActivity mainActivity) {
                this.this$0 = mainActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                if (z) {
                    MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(this.this$0).setTitle(C6079R.string.billing_unavailable_dialog_title).setMessage(C6079R.string.billing_unavailable_dialog_message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$32$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    final MainActivity mainActivity = this.this$0;
                    positiveButton.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.grid.MainActivity$onCreate$32$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            MainActivity.C654332.AnonymousClass1.emit$lambda$1(mainActivity, dialogInterface);
                        }
                    }).show();
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$1(MainActivity mainActivity, DialogInterface dialogInterface) {
                mainActivity.getMainViewModel().dismissBillingUnavailableDialog();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.getMainViewModel().getBillingUnavailableDialogVisible().collect(new AnonymousClass1(MainActivity.this), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14(final MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C507@24161L29,508@24213L541,508@24203L551:MainActivity.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627129900, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous> (MainActivity.kt:507)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(mainActivity.getMainViewModel().getShowLenovoMigration(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(-806007476, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$14$1(stateCollectAsStateWithLifecycle, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$1(State state, final MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C511@24375L10,512@24467L10,513@24496L244,509@24231L509:MainActivity.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806007476, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:509)");
            }
            boolean zOnCreate$lambda$14$0 = onCreate$lambda$14$0(state);
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.0f, 2, null);
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(400, 0, null, 6, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1479065962, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(MainActivity.onCreate$lambda$14$1$0$0(((Integer) obj).intValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EnterTransition enterTransitionPlus = enterTransitionFadeIn$default.plus(EnterExitTransitionKt.slideInVertically(tweenSpecTween$default, (Function1) objRememberedValue));
            ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null);
            TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(300, 0, null, 6, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1479063018, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(MainActivity.onCreate$lambda$14$1$1$0(((Integer) obj).intValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedVisibilityKt.AnimatedVisibility(zOnCreate$lambda$14$0, (Modifier) null, enterTransitionPlus, exitTransitionFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default2, (Function1) objRememberedValue2)), (String) null, ComposableLambdaKt.rememberComposableLambda(-520562828, true, new Function3() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivity.onCreate$lambda$14$1$2(this.f$0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int onCreate$lambda$14$1$0$0(int i) {
        return i / 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int onCreate$lambda$14$1$1$0(int i) {
        return i / 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$1$2(final MainActivity mainActivity, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C516@24654L46,514@24518L204:MainActivity.kt#egc4u2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-520562828, i, -1, "com.myscript.nebo.grid.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:514)");
        }
        ILenovoMigrationController migrationController = mainActivity.getMainViewModel().getMigrationController();
        ComposerKt.sourceInformationMarkerStart(composer, -2044666270, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(mainActivity);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivity.onCreate$lambda$14$1$2$0$0(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LenovoMigrationOnboardingKt.LenovoMigrationOnboarding(migrationController, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$1$2$0$0(MainActivity mainActivity) {
        mainActivity.getMainViewModel().onLenovoMigrationDismissed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShowPaywall(final String origin) {
        this.showPaywallDialog.setValue(true);
        ComposeView composeView = this.paywallView;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(163014754, true, new Function2() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onShowPaywall$lambda$0(this.f$0, origin, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowPaywall$lambda$0(final MainActivity mainActivity, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C531@25088L70,534@25190L118,527@24906L416:MainActivity.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163014754, i, -1, "com.myscript.nebo.grid.MainActivity.onShowPaywall.<anonymous> (MainActivity.kt:527)");
            }
            boolean zBooleanValue = mainActivity.showPaywallDialog.getValue().booleanValue();
            PaywallViewModel paywallViewModel = mainActivity.getPaywallViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, 2038362280, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.onShowPaywall$lambda$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2038365592, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(mainActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.onShowPaywall$lambda$0$1$0(this.f$0);
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
    public static final Unit onShowPaywall$lambda$0$0$0(MainActivity mainActivity) {
        mainActivity.getMainViewModel().dismissPaywall();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowPaywall$lambda$0$1$0(MainActivity mainActivity) {
        mainActivity.getMainViewModel().onPurchased();
        mainActivity.getMainViewModel().dismissPaywall();
        return Unit.INSTANCE;
    }

    private final void showPaywallAtPromotionStart() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.freemium.PromotionController.Provider");
        PromotionController promotionControllerProvidePromotionController = ((PromotionController.Provider) application).providePromotionController();
        ComponentCallbacks2 application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.account.UserProfileManager.Provider");
        UserProfileManager userProfileManagerProvideUserProfileManager = ((UserProfileManager.Provider) application2).provideUserProfileManager();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean zAreEqual = Intrinsics.areEqual(defaultSharedPreferences.getString(LAST_PROMOTIONAL_CAMPAIGN_FOR_WHICH_PAYWALL_WAS_DISPLAYED, ""), promotionControllerProvidePromotionController.promotionalCampaignId());
        boolean zHasFeatureAccess = userProfileManagerProvideUserProfileManager.hasFeatureAccess(Feature.UnlimitedPages);
        if (this.isFromFreshInstall || zHasFeatureAccess || !promotionControllerProvidePromotionController.isPromotionalCampaign() || zAreEqual) {
            return;
        }
        Intrinsics.checkNotNull(defaultSharedPreferences);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putString(LAST_PROMOTIONAL_CAMPAIGN_FOR_WHICH_PAYWALL_WAS_DISPLAYED, promotionControllerProvidePromotionController.promotionalCampaignId());
        editorEdit.apply();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        if (key == null) {
            return;
        }
        if (Intrinsics.areEqual(key, getString(C6079R.string.pref_cloudsync_dropbox_key)) || Intrinsics.areEqual(key, getString(C6079R.string.pref_cloudsync_gdrive_key))) {
            displayAutoSyncInformationDialogIfCloudConnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSidePanelUpdated(SidePanelState sidePanelState) {
        setContentOverlayEnabled(sidePanelState.getShowContentOverlay());
        animateSidePanel(sidePanelState.isSidePanelOpen());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCurrentScreenChanged(Screen screen) {
        Pair pairM1606to;
        if (screen instanceof Screen.Notebooks) {
            MainViewFragment mainViewFragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainViewFragment.TAG);
            if (mainViewFragmentFindFragmentByTag == null) {
                MainViewFragment mainViewFragmentNewInstance = MainViewFragment.newInstance();
                Intrinsics.checkNotNullExpressionValue(mainViewFragmentNewInstance, "newInstance(...)");
                mainViewFragmentFindFragmentByTag = mainViewFragmentNewInstance;
            }
            this.notesFragment = mainViewFragmentFindFragmentByTag instanceof MainViewFragment ? (MainViewFragment) mainViewFragmentFindFragmentByTag : null;
            pairM1606to = TuplesKt.m1606to(mainViewFragmentFindFragmentByTag, MainViewFragment.TAG);
        } else {
            if (!(screen instanceof Screen.Trash)) {
                throw new NoWhenBranchMatchedException();
            }
            getGridViewModel().activatePagesSelectionMode(false);
            TrashedPagesFragment trashedPagesFragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TrashedPagesFragment.TAG);
            if (trashedPagesFragmentFindFragmentByTag == null) {
                trashedPagesFragmentFindFragmentByTag = TrashedPagesFragment.INSTANCE.newInstance();
            }
            pairM1606to = TuplesKt.m1606to(trashedPagesFragmentFindFragmentByTag, TrashedPagesFragment.TAG);
        }
        Fragment fragment = (Fragment) pairM1606to.component1();
        String str = (String) pairM1606to.component2();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(C6079R.id.main_fragment_layout, fragment, str);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchActiveUpdate(boolean isSearchActive) {
        SidePanelFragment sidePanelFragment = this.sidePanelFragment;
        if (sidePanelFragment == null || !sidePanelFragment.isAdded()) {
            return;
        }
        if (isSearchActive) {
            SidePanelFragment sidePanelFragment2 = this.sidePanelFragment;
            if (sidePanelFragment2 != null) {
                sidePanelFragment2.onShowSearch();
                return;
            }
            return;
        }
        SidePanelFragment sidePanelFragment3 = this.sidePanelFragment;
        if (sidePanelFragment3 != null) {
            sidePanelFragment3.onHideSearch();
        }
    }

    private final void onSyncCanceledOverCellular(boolean canceled) {
        if (canceled) {
            displayNetworkOperationCanceledOverCellularPopup(C6079R.string.pref_network_popup_cellular_message_from_cloud_sync);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLibraryUpdate(LibraryViewModel.State state) {
        if (this.isFromFreshInstall || (state instanceof LibraryViewModel.State.Unloaded)) {
            return;
        }
        dispatchImportRequest();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        int i = 0;
        if (ArraysKt.contains(grantResults, -1)) {
            if (getResources().getBoolean(C6079R.bool.show_debug_message)) {
                ArrayList arrayList = new ArrayList();
                int length = permissions.length;
                int i2 = 0;
                while (i < length) {
                    String str = permissions[i];
                    int i3 = i2 + 1;
                    if (grantResults[i2] == -1) {
                        arrayList.add(str);
                    }
                    i++;
                    i2 = i3;
                }
                Toast.makeText(this, "Permission(s) denied:\n" + CollectionsKt.joinToString$default(arrayList, TextRecallingManager.ANSWER_SEPARATOR, null, null, 0, null, null, 62, null), 1).show();
            }
            return;
        }
        switch (requestCode) {
            case 10:
                handleNeboFileImportRequest();
                break;
            case 11:
                handlePdfImportRequest(false);
                break;
            case 12:
                handlePdfImportRequest(true);
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$handleNeboFileImport$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$handleNeboFileImport$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65281(Continuation<? super C65281> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65281(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainActivity.this.handleNeboFileImportRequest();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void handleNeboFileImport(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.importRequestData = ImportRequestData.fromUri(uri);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C65281(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNeboFileImportRequest() {
        ImportRequestData importRequestData = this.importRequestData;
        if (importRequestData == null) {
            return;
        }
        if ((!Intrinsics.areEqual("file", importRequestData.getUri().getScheme()) || PlatformUtils.checkAndAskForPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 10)) && getSupportFragmentManager().findFragmentByTag(FolderPickerDialog.TAG) == null) {
            FolderPickerDialog.Companion companion = FolderPickerDialog.INSTANCE;
            Uri uri = importRequestData.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
            FolderPickerDialog importNeboFile = companion.toImportNeboFile(uri);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            importNeboFile.show(supportFragmentManager);
        }
    }

    private final void onDiscardSearch() {
        MainViewFragment mainViewFragment;
        if (!(getMainViewModel().getScreen().getValue() instanceof Screen.Notebooks) || (mainViewFragment = this.notesFragment) == null) {
            return;
        }
        mainViewFragment.onDiscardSearch();
    }

    private final void handleBackupImportRequest() {
        ImportRequestData importRequestData = this.importRequestData;
        if (importRequestData == null) {
            return;
        }
        Uri uri = importRequestData.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
        this.importRequestData = null;
        importBackup(uri);
    }

    public final void importBackup(final Uri requestedUri) {
        Intrinsics.checkNotNullParameter(requestedUri, "requestedUri");
        SidePanelFragment sidePanelFragment = this.sidePanelFragment;
        if (sidePanelFragment != null && !sidePanelFragment.isAdded()) {
            getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.myscript.nebo.grid.MainActivity.importBackup.1
                @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
                public void onFragmentCreated(FragmentManager fm, Fragment fragment, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(fm, "fm");
                    Intrinsics.checkNotNullParameter(fragment, "fragment");
                    super.onFragmentCreated(fm, fragment, savedInstanceState);
                    if (fragment == MainActivity.this.sidePanelFragment) {
                        fm.unregisterFragmentLifecycleCallbacks(this);
                        MainActivity.this.importBackup(requestedUri);
                    }
                }
            }, false);
            return;
        }
        onDiscardSearch();
        SidePanelFragment sidePanelFragment2 = this.sidePanelFragment;
        if (sidePanelFragment2 != null) {
            sidePanelFragment2.showBackupSettingsFragmentForRestore(requestedUri);
        }
    }

    private final void handlePdfImportRequest(boolean importFromOutSide) {
        ImportRequestData importRequestData = this.importRequestData;
        if (importRequestData == null) {
            return;
        }
        final Uri uri = importRequestData.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
        int i = importFromOutSide ? 12 : 11;
        if (!Intrinsics.areEqual("file", uri.getScheme()) || PlatformUtils.checkAndAskForPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, i)) {
            if (importFromOutSide) {
                getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_OPENING_AN_EXTERNAL_PDF, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.handlePdfImportRequest$lambda$0(this.f$0, uri);
                    }
                });
                return;
            }
            String mimeType = importRequestData.getMimeType(this);
            this.importRequestData = null;
            NotebookKey openedNotebookKey = getGridViewModel().getOpenedNotebookKey();
            if (openedNotebookKey != null) {
                String[] MIMETYPES_FOR_PDF_IMPORT = ImportRequestData.MIMETYPES_FOR_PDF_IMPORT;
                Intrinsics.checkNotNullExpressionValue(MIMETYPES_FOR_PDF_IMPORT, "MIMETYPES_FOR_PDF_IMPORT");
                boolean zAreEqual = false;
                for (String str : MIMETYPES_FOR_PDF_IMPORT) {
                    zAreEqual |= Intrinsics.areEqual(str, mimeType);
                }
                if (zAreEqual) {
                    importPdf(uri, openedNotebookKey);
                } else {
                    showFileImportErrorDialog();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePdfImportRequest$lambda$0(MainActivity mainActivity, Uri uri) {
        if (mainActivity.getSupportFragmentManager().findFragmentByTag(FolderPickerDialog.TAG) == null) {
            FolderPickerDialog importPdf = FolderPickerDialog.INSTANCE.toImportPdf(uri);
            FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            importPdf.show(supportFragmentManager);
        }
        return Unit.INSTANCE;
    }

    public final void launchImport() {
        try {
            ActivityResultLauncher<String[]> activityResultLauncher = this.getDocuments;
            String[] MIMETYPES_FOR_IMPORT = ImportRequestData.MIMETYPES_FOR_IMPORT;
            Intrinsics.checkNotNullExpressionValue(MIMETYPES_FOR_IMPORT, "MIMETYPES_FOR_IMPORT");
            activityResultLauncher.launch(MIMETYPES_FOR_IMPORT);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "Couldn't find an app to pick files on your device", 1).show();
        }
    }

    private final void importDocuments(List<? extends Uri> uris) {
        if (uris.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (Uri uri : uris) {
            int i = WhenMappings.$EnumSwitchMapping$0[ImportableDocumentKt.classifyImportableDocument(this, uri).ordinal()];
            if (i == 1) {
                arrayList.add(uri);
            } else if (i == 2) {
                arrayList2.add(uri);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return;
        }
        if (!arrayList2.isEmpty()) {
            getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_IMPORT_AS_PDF_BUTTON, new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivity.importDocuments$lambda$1(this.f$0, arrayList, arrayList2);
                }
            });
        } else {
            getGridViewModel().importDocuments(arrayList, CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit importDocuments$lambda$1(MainActivity mainActivity, List list, List list2) {
        mainActivity.getGridViewModel().importDocuments(list, list2);
        return Unit.INSTANCE;
    }

    private final void importPdf(Uri requestedUri, NotebookKey targetNotebookKey) {
        getGridViewModel().importAsPdf(requestedUri, getLibraryRepository().getLastChosenLanguage(), targetNotebookKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPdfImportStateChanged(GridViewModel.ImportStateUI state) {
        setLoadingEnabled(state.getShowProgress());
        if (state instanceof GridViewModel.ImportStateUI.Failure.InvalidUri) {
            ConstraintLayout constraintLayout = this.contentLayout;
            if (constraintLayout != null) {
                Snackbar.make(constraintLayout, C6208R.string.open_folder_from_external_app_error, 0).show();
                return;
            }
            return;
        }
        if (state instanceof GridViewModel.ImportStateUI.Failure.TooRecent) {
            showTooRecentFileErrorDialog();
            return;
        }
        if (state instanceof GridViewModel.ImportStateUI.Failure) {
            showFileImportErrorDialog();
        } else if (!Intrinsics.areEqual(state, GridViewModel.ImportStateUI.Idle.INSTANCE) && !Intrinsics.areEqual(state, GridViewModel.ImportStateUI.Importing.INSTANCE) && !Intrinsics.areEqual(state, GridViewModel.ImportStateUI.Success.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void onFolderClicked(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        FolderModel folder = getLibraryRepository().getFolder(notebookKey);
        if (folder == null) {
            onSyncRequested(notebookKey, true);
        } else if (folder.isSupported()) {
            LibraryViewModel.openFolder$default(getLibraryViewModel(), notebookKey, false, 2, null);
        } else {
            showTooRecentFileErrorDialog();
        }
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void moveToTrash(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        getLibraryViewModel().moveToTrash(notebookKeys);
        showTrashDiscoverabilityIfNeeded();
    }

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onUpdateRequired() {
        PlatformUtils.openPlayStore(this);
    }

    private final void onPagesUpdated(List<PageModel> pageModels) {
        if (pageModels == null) {
            getLibraryViewModel().closeFolder();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 111 && event.getAction() == 0) {
            ActivityResultCaller activityResultCallerFindFragmentById = getSupportFragmentManager().findFragmentById(C6079R.id.main_fragment_layout);
            if ((activityResultCallerFindFragmentById instanceof MainActivityDetailFragment) && ((MainActivityDetailFragment) activityResultCallerFindFragmentById).onShortcut(Shortcut.ESCAPE)) {
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        this.importRequestData = ImportRequestData.fromIntent(this, intent);
        dispatchImportRequest();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getToolType(event.getActionIndex()) == 2) {
            MainActivity mainActivity = this;
            if (!CommonUtils.isActivePenMode(mainActivity)) {
                CommonUtils.saveActivePenMode(mainActivity, true);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private final void dispatchImportRequest() {
        ImportRequestData importRequestData = this.importRequestData;
        if (importRequestData == null) {
            return;
        }
        MainActivity mainActivity = this;
        String mimeType = importRequestData.getMimeType(mainActivity);
        if (mimeType != null) {
            String[] MIMETYPES_FOR_PDF_IMPORT = ImportRequestData.MIMETYPES_FOR_PDF_IMPORT;
            Intrinsics.checkNotNullExpressionValue(MIMETYPES_FOR_PDF_IMPORT, "MIMETYPES_FOR_PDF_IMPORT");
            if (ArraysKt.contains(MIMETYPES_FOR_PDF_IMPORT, mimeType)) {
                handlePdfImportRequest(true);
                return;
            }
        }
        if (mimeType == null || !ClipDescription.compareMimeTypes(mimeType, ImportRequestData.APPLICATION_MIMETYPE)) {
            return;
        }
        String strResolveFileName = ImportRequestData.resolveFileName(importRequestData.getUri(), mainActivity, "", mimeType);
        Intrinsics.checkNotNullExpressionValue(strResolveFileName, "resolveFileName(...)");
        if (FolderPropertiesValidatorKt.hasNeboExtension(strResolveFileName)) {
            if (getLibraryRepository().isEmpty()) {
                this.importRequestData = null;
                CollectionDialog collectionDialogNewInstance = CollectionDialog.INSTANCE.newInstance(CollectionDialog.TAG_NEW, null);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                DialogFragmentExt.showAtMostOnce(collectionDialogNewInstance, supportFragmentManager, CollectionDialog.TAG_NEW);
                return;
            }
            handleNeboFileImportRequest();
            return;
        }
        if (StringsKt.endsWith$default(strResolveFileName, ".nebobackup", false, 2, (Object) null)) {
            handleBackupImportRequest();
        } else {
            this.importRequestData = null;
            showFileImportErrorDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTargetFolderSelectionResult(String requestKey, Bundle resultBundle) {
        ImportRequestData importRequestData = this.importRequestData;
        Uri uri = importRequestData != null ? importRequestData.getUri() : null;
        this.importRequestData = null;
        int i = resultBundle.getInt("RESULT_KEY");
        if (i != 0) {
            if (i != 2) {
                return;
            }
            new MaterialAlertDialogBuilder(this).setTitle(C6079R.string.import_external_file_error_dialog_title).setMessage(C6079R.string.import_external_file_error_dialog_missing_folder).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).show();
            return;
        }
        FolderPickerDialog.Result Result = FolderPickerDialog.INSTANCE.Result(resultBundle);
        if (Result instanceof FolderPickerDialog.Result.PdfImport) {
            FolderPickerDialog.Result.PdfImport pdfImport = (FolderPickerDialog.Result.PdfImport) Result;
            NotebookKey notebookKey = pdfImport.getNotebookKey();
            if (Intrinsics.areEqual(uri, pdfImport.getPdfUri()) && notebookKey != null && notebookKey.isValid()) {
                importPdf(uri, notebookKey);
                return;
            }
            return;
        }
        if (Result instanceof FolderPickerDialog.Result.NeboFileImport) {
            FolderPickerDialog.Result.NeboFileImport neboFileImport = (FolderPickerDialog.Result.NeboFileImport) Result;
            NotebookKey notebookKey2 = neboFileImport.getNotebookKey();
            if (Intrinsics.areEqual(uri, neboFileImport.getNeboFileUri()) && notebookKey2 != null && notebookKey2.isValid()) {
                getGridViewModel().importNeboFile(uri, notebookKey2);
                return;
            }
            return;
        }
        if (!(Result instanceof FolderPickerDialog.Result.PagesMove)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        getLibraryViewModel().removeSyncCallback(this);
        getBackupRestoreViewModel().removeBackupRestoreListener(getMainViewModel().getBackupRestoreListener());
        this.notesFragment = null;
        this.sidePanelFragment = null;
        ConstraintLayout constraintLayout = this.contentLayout;
        if (constraintLayout != null) {
            constraintLayout.removeOnLayoutChangeListener(this.onLayoutChangedListener);
        }
        this.onLayoutChangedListener = null;
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
        removeMenuProvider(this.menuProvider);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SidePanelFragment sidePanelFragment = this.sidePanelFragment;
        if (sidePanelFragment != null && !sidePanelFragment.hasNestedNavigation() && getMainViewModel().getIsSidePanelOpen()) {
            MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), false, false, 2, null);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(SidePanelFragment.TAG);
        SidePanelFragment sidePanelFragmentNewInstance = fragmentFindFragmentByTag instanceof SidePanelFragment ? (SidePanelFragment) fragmentFindFragmentByTag : null;
        if (sidePanelFragmentNewInstance == null) {
            sidePanelFragmentNewInstance = SidePanelFragment.Companion.newInstance();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(C6079R.id.main_activity_side_panel, sidePanelFragmentNewInstance, SidePanelFragment.TAG);
            fragmentTransactionBeginTransaction.commit();
        }
        this.sidePanelFragment = sidePanelFragmentNewInstance;
        getGridViewModel().refreshStorageState();
        showBackupReminderIfNeeded();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            MainThreadBus.eventBus.register(this);
        } catch (IllegalArgumentException e) {
            AnalyticsController.logException(e);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65491(null), 3, null);
        maybeShowCrossSell();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onResume$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onResume$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {966}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {967}, m1615s = {}, m1616v = 2)
    static final class C65491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65491(Continuation<? super C65491> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65491(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.getMainViewModel().updatePremiumStatus(this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        try {
            MainThreadBus.eventBus.unregister(this);
        } catch (IllegalArgumentException e) {
            AnalyticsController.logException(e);
        }
        super.onPause();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.popupMenu != null) {
            resetPopupMenu();
        }
        super.onStop();
    }

    @Override // com.myscript.nebo.NeboBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putParcelable(getString(C6079R.string.first_intent), getFirstLaunchingIntent());
        outState.putBoolean(EXTRA_FROM_FRESH_INSTALL, this.isFromFreshInstall);
        ImportRequestData importRequestData = this.importRequestData;
        outState.putBundle(IMPORT_REQUEST_DATA_FROM_INTENT, importRequestData != null ? importRequestData.getBundle() : null);
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zIsAltPressed = event.isAltPressed();
        boolean zIsMetaPressed = event.isMetaPressed();
        if (!zIsAltPressed && !zIsMetaPressed) {
            boolean zIsCtrlPressed = event.isCtrlPressed();
            boolean zIsShiftPressed = event.isShiftPressed();
            if (!zIsCtrlPressed || zIsShiftPressed || keyCode != 34) {
                return false;
            }
            ActivityResultCaller activityResultCallerFindFragmentById = getSupportFragmentManager().findFragmentById(C6079R.id.main_fragment_layout);
            if (activityResultCallerFindFragmentById instanceof MainActivityDetailFragment) {
                return ((MainActivityDetailFragment) activityResultCallerFindFragmentById).onShortcut(Shortcut.SEARCH);
            }
            return false;
        }
        return super.onKeyShortcut(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDocuments$lambda$0(MainActivity mainActivity, List uris) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        mainActivity.importDocuments(uris);
    }

    private final void showFileImportErrorDialog() {
        new MaterialAlertDialogBuilder(this).setTitle(C6079R.string.import_external_file_error_dialog_title).setMessage(C6079R.string.import_external_file_error_dialog_message).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(C6079R.string.import_external_file_error_dialog_support_action, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showFileImportErrorDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFileImportErrorDialog$lambda$0(MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        if (PlatformUtils.openUrl(mainActivity, C6079R.string.backup_support_url)) {
            return;
        }
        Log.d(TAG, "Can't open support url");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOpenedFolderChange(final NotebookKey notebookKey) {
        FolderModel folder;
        if (getGridViewModel().isPageOpened()) {
            return;
        }
        if (notebookKey != null && (folder = getLibraryRepository().getFolder(notebookKey)) != null) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger = null;
            }
            TechnicalLoggerExt.logAction(technicalLogger, TAG, "Open notebook", new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return notebookKey.uuid();
                }
            });
            TechnicalLogger technicalLogger2 = this.logger;
            if (technicalLogger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger2 = null;
            }
            TechnicalLoggerExt.setNotebookKeyValues(technicalLogger2, folder);
        }
        NotebookKey openedNotebookKey = getGridViewModel().getOpenedNotebookKey();
        if (notebookKey != null && !Intrinsics.areEqual(notebookKey, openedNotebookKey)) {
            stopSelection();
        }
        if (notebookKey != null) {
            FolderModel folder2 = getLibraryRepository().getFolder(notebookKey);
            if (folder2 != null) {
                TechnicalLogger technicalLogger3 = this.logger;
                if (technicalLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger3 = null;
                }
                TechnicalLoggerExt.logAction(technicalLogger3, TAG, "Open folder", new Function0() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return notebookKey.uuid();
                    }
                });
                TechnicalLogger technicalLogger4 = this.logger;
                if (technicalLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    technicalLogger4 = null;
                }
                TechnicalLoggerExt.setNotebookKeyValues(technicalLogger4, folder2);
            }
            getGridViewModel().openFolder(notebookKey);
        } else {
            getGridViewModel().closeFolder();
        }
        SidePanelFragment sidePanelFragment = this.sidePanelFragment;
        if (sidePanelFragment != null) {
            sidePanelFragment.onNotebookOpenChanged(notebookKey);
        }
        if (getLibraryViewModel().getOpenedByUser() && !getMainViewModel().getIsSideBySide()) {
            MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), false, false, 2, null);
        }
        invalidateOptionsMenu();
    }

    public static /* synthetic */ void requestNewFolderDialog$default(MainActivity mainActivity, CollectionKey collectionKey, int i, Object obj) {
        if ((i & 1) != 0) {
            collectionKey = null;
        }
        mainActivity.requestNewFolderDialog(collectionKey);
    }

    public final void requestNewFolderDialog(CollectionKey targetCollectionKey) {
        if (targetCollectionKey == null && (targetCollectionKey = getLibraryRepository().getCollectionKeyFromNotebookKey(getLibraryRepository().getLastOpenedFolderKey())) == null) {
            CollectionModel collectionModel = (CollectionModel) CollectionsKt.firstOrNull((List) getLibraryRepository().getCollectionModels(DMSFilter.ACTIVE));
            targetCollectionKey = collectionModel != null ? collectionModel.getCollectionKey() : null;
        }
        if (targetCollectionKey != null) {
            FolderEditorDialogFragment.INSTANCE.toCreate(targetCollectionKey, ResourcesCompat.getColor(getResources(), C6183R.color.default_notebook_cover_color, getTheme())).show(getSupportFragmentManager(), FolderEditorDialogFragment.TAG);
        }
    }

    public final void requestNewCollectionDialog() {
        CollectionDialog.INSTANCE.newInstance(CollectionDialog.REQUEST_KEY_NEW, null).show(getSupportFragmentManager(), CollectionDialog.TAG_NEW);
    }

    public final void requestFolderMenuEdit(NotebookKey folderKey) {
        FolderModel folder;
        CollectionKey collectionKeyFromNotebookKey;
        if (folderKey == null || (folder = getLibraryRepository().getFolder(folderKey)) == null || (collectionKeyFromNotebookKey = getLibraryRepository().getCollectionKeyFromNotebookKey(folderKey)) == null) {
            return;
        }
        FolderEditorDialogFragment.INSTANCE.toEdit(folderKey, collectionKeyFromNotebookKey, folder.getColor()).show(getSupportFragmentManager(), FolderEditorDialogFragment.TAG);
    }

    private final void showTooRecentFileErrorDialog() {
        new MaterialAlertDialogBuilder(this).setTitle(C6079R.string.too_recent_content_alert_dialog_title).setMessage(C6079R.string.too_recent_file_alert_dialog_message).setPositiveButton(C6079R.string.too_recent_content_alert_dialog_check_for_update_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda40
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showTooRecentFileErrorDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6079R.string.too_recent_content_alert_dialog_check_later_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda41
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTooRecentFileErrorDialog$lambda$0(MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        PlatformUtils.openPlayStore(mainActivity);
    }

    private final void requestSyncNotebookItemPopup(NotebookKey clickedNotebookKey) {
        if (getCloudManager().isCloudConnected()) {
            if (getLibraryRepository().getHasForwardCompatibilityIssue()) {
                openForwardCompatibilityIssueDialog();
                return;
            }
            closeSearchIfNotStarted();
            LibraryRepository libraryRepository = getLibraryRepository();
            Intrinsics.checkNotNull(clickedNotebookKey);
            libraryRepository.syncFolder(clickedNotebookKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCollectionOperationResult(String requestKey, Bundle resultData) {
        String string = resultData.getString(CollectionDialog.COLLECTION_KEY_KEY);
        CollectionKey collectionKeyDeserialize = string != null ? CollectionKey.deserialize(string) : null;
        String string2 = resultData.getString(CollectionDialog.COLLECTION_NAME_KEY);
        if (Intrinsics.areEqual(CollectionDialog.REQUEST_KEY_EDIT, requestKey) && collectionKeyDeserialize != null && string2 != null) {
            getLibraryViewModel().renameCollection(collectionKeyDeserialize, string2);
        } else {
            if (!Intrinsics.areEqual(CollectionDialog.REQUEST_KEY_NEW, requestKey) || string2 == null) {
                return;
            }
            getLibraryViewModel().createCollection(string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFolderEditorResult(String requestKey, Bundle resultData) {
        FolderEditorDialogFragment.Result Result = FolderEditorDialogFragment.INSTANCE.Result(resultData);
        if (Result instanceof FolderEditorDialogFragment.Result.Create) {
            FolderEditorDialogFragment.Result.Create create = (FolderEditorDialogFragment.Result.Create) Result;
            getLibraryViewModel().createFolder(create.getCollectionKey(), create.getFolderName(), create.getColor());
        } else {
            if (!(Result instanceof FolderEditorDialogFragment.Result.Edit)) {
                throw new NoWhenBranchMatchedException();
            }
            stopSelection();
            FolderEditorDialogFragment.Result.Edit edit = (FolderEditorDialogFragment.Result.Edit) Result;
            getLibraryViewModel().editFolder(edit.getFolderKey(), edit.getCollectionKey(), edit.getFolderName(), edit.getColor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void popupMenuCreated(PopupMenu popupMenu, PopupUtils.PopupInfoSaveInstanceState popupInfo) {
        boolean z;
        boolean z2;
        String str = popupInfo.popupKey;
        boolean z3 = true;
        if (Intrinsics.areEqual(str, NOTEBOOK_ITEM_MORE_MENU)) {
            if (!isSyncable()) {
                z = false;
                if (isSearching()) {
                    z2 = false;
                    if (isSearching()) {
                        z3 = false;
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_sync).setEnabled(z);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_edit).setEnabled(z2);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_delete).setEnabled(z3);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_sync).setVisible(getCloudManager().isCloudConnected());
                    } else {
                        Bundle bundle = this.openedMenuNotebookState;
                        if (!(bundle != null ? bundle.getBoolean(NotebookItemViewHolder.MORE_MENU_IS_DELETABLE, false) : false)) {
                        }
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_sync).setEnabled(z);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_edit).setEnabled(z2);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_delete).setEnabled(z3);
                        popupMenu.getMenu().findItem(C6208R.id.notebook_item_more_menu_sync).setVisible(getCloudManager().isCloudConnected());
                    }
                } else {
                    Bundle bundle2 = this.openedMenuNotebookState;
                    if (bundle2 != null ? bundle2.getBoolean(NotebookItemViewHolder.MORE_MENU_IS_EDITABLE, false) : false) {
                        z2 = true;
                    }
                    if (isSearching()) {
                    }
                }
            } else {
                Bundle bundle3 = this.openedMenuNotebookState;
                if (bundle3 != null ? bundle3.getBoolean(NotebookItemViewHolder.MORE_MENU_IS_SYNCABLE, false) : false) {
                    z = true;
                }
                if (isSearching()) {
                }
            }
        } else if (Intrinsics.areEqual(str, COLLECTION_ITEM_MORE_MENU)) {
            popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_recover).setVisible(false);
            popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_new_folder).setVisible(true);
        }
        resetPopupMenu();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda39
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.onPopupMenuItemClick(menuItem);
            }
        });
        this.popupMenu = popupMenu;
    }

    @Subscribe
    public final void onNotebookMoreMenuEvent(NotebookMoreMenuEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        PopupUtils.launchPopupMenu(this, NOTEBOOK_ITEM_MORE_MENU, C6208R.menu.notebook_item_more_menu, GravityCompat.START, C0028R.attr.actionOverflowMenuStyle, event.f1361x, event.f1362y, true, new MainActivity$$ExternalSyntheticLambda42(this));
        this.openedMenuNotebookKey = event.notebookKey;
        this.openedMenuNotebookState = event.menuState;
    }

    @Subscribe
    public final void onCollectionItemMoreMenuEvent(CollectionMoreMenuEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        PopupUtils.launchPopupMenu(this, COLLECTION_ITEM_MORE_MENU, C6208R.menu.collection_item_more_menu, GravityCompat.START, C0028R.attr.actionOverflowMenuStyle, event.f1359x, event.f1360y, true, new MainActivity$$ExternalSyntheticLambda42(this));
        this.openedMenuCollectionKey = event.item;
        closeSearchIfNotStarted();
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
        CollectionKey collectionKey;
        List<? extends NotebookKey> listListOf;
        int itemId = item.getItemId();
        if (itemId == C6208R.id.notebook_item_more_menu_edit) {
            NotebookKey notebookKey = this.openedMenuNotebookKey;
            if (notebookKey != null) {
                requestFolderMenuEdit(notebookKey);
            }
        } else if (itemId == C6208R.id.notebook_item_more_menu_delete) {
            NotebookKey notebookKey2 = this.openedMenuNotebookKey;
            if (notebookKey2 != null && (listListOf = CollectionsKt.listOf(notebookKey2)) != null) {
                moveToTrash(listListOf);
            }
        } else if (itemId == C6208R.id.notebook_item_more_menu_sync) {
            NotebookKey notebookKey3 = this.openedMenuNotebookKey;
            if (notebookKey3 != null) {
                requestSyncNotebookItemPopup(notebookKey3);
            }
        } else if (itemId == C6208R.id.collection_item_more_menu_edit) {
            CollectionKey collectionKey2 = this.openedMenuCollectionKey;
            if (collectionKey2 != null) {
                requestCollectionItemEdit(collectionKey2);
            }
        } else if (itemId == C6208R.id.collection_item_more_menu_delete) {
            CollectionKey collectionKey3 = this.openedMenuCollectionKey;
            if (collectionKey3 != null) {
                moveToTrash(collectionKey3);
            }
        } else if (itemId == C6208R.id.collection_item_more_menu_new_folder && (collectionKey = this.openedMenuCollectionKey) != null) {
            requestNewFolderDialog(collectionKey);
        }
        this.openedMenuNotebookKey = null;
        this.openedMenuNotebookState = null;
        return true;
    }

    private final void requestCollectionItemEdit(CollectionKey collectionKey) {
        if (getLibraryRepository().getCollection(collectionKey) != null) {
            CollectionDialog.INSTANCE.newInstance(CollectionDialog.REQUEST_KEY_EDIT, collectionKey).show(getFragmentManager(), CollectionDialog.TAG_EDIT);
        }
    }

    private final void moveToTrash(CollectionKey collectionKey) {
        getLibraryViewModel().moveToTrash(collectionKey);
        showTrashDiscoverabilityIfNeeded();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public boolean isCloudConnected() {
        return getCloudManager().isCloudConnected() && getCloudManager().isCloudBound();
    }

    private final boolean isSyncable() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        NeboNetworkState value = ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().getValue();
        return (value != null ? value.isDataTransferAllowed() : false) && !isSearching() && isCloudConnected() && !getCloudManager().getHasForwardCompatibilityIssue();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public boolean isAutoSyncEnabled() {
        return getLibraryRepository().getIsAutoSyncEnabled();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public boolean isSearching() {
        return getGridViewModel().isSearchModeActive();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public boolean isLastSyncActionAUserAction() {
        return getLibraryRepository().isLastSyncActionAUserAction();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void close() {
        MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), false, false, 2, null);
    }

    private final void stopSelection() {
        SidePanelFragment sidePanelFragment = this.sidePanelFragment;
        if (sidePanelFragment != null) {
            sidePanelFragment.stopSelection();
        }
    }

    @Override // com.myscript.nebo.grid.MainViewFragment.ActionListener
    public void onStartDraggingPage() {
        stopSelection();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public String getSearchLabel() {
        return getGridViewModel().getSearchQuery();
    }

    @Override // com.myscript.nebo.grid.MainViewFragment.ActionListener
    public void onExport(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        if (FeatureHelper.checkFeatureAvailable(this, C6079R.bool.export_enabled)) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                technicalLogger = null;
            }
            TechnicalLoggerExt.logPagesDetails(technicalLogger, TAG, "Export pages", pageKeys, getGridViewModel().getSelectedPages());
            ExportDialog exportDialogNewInstance$default = ExportDialog.Companion.newInstance$default(ExportDialog.INSTANCE, pageKeys, (List) null, (String) null, 6, (Object) null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            exportDialogNewInstance$default.show(supportFragmentManager);
        }
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void setLoadingEnabled(boolean enabled) {
        View view = this.loadingProgress;
        if (view != null) {
            view.setVisibility(enabled ? 0 : 8);
        }
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void onSyncRequested(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        onSyncRequested(notebookKey, false);
    }

    private final void onSyncRequested(NotebookKey notebookKey, boolean openFolderAfter) {
        getLibraryRepository().syncFolder(notebookKey);
        if (openFolderAfter) {
            getLibraryViewModel().openFolder(notebookKey, true);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$resumeSync$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$resumeSync$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {1315}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1316}, m1615s = {}, m1616v = 2)
    static final class C65511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65511(Continuation<? super C65511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65511(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.getAutoSyncTimerManager().triggerResumeSync(this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void resumeSync() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65511(null), 3, null);
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void onDMSSelectionChanged(boolean isSelectionMode) {
        MainViewFragment mainViewFragment;
        if (getMainViewModel().getIsSideBySide() && getMainViewModel().getIsSidePanelOpen()) {
            setContentOverlayEnabled(isSelectionMode);
        }
        if (!(getMainViewModel().getScreen().getValue() instanceof Screen.Notebooks) || (mainViewFragment = this.notesFragment) == null) {
            return;
        }
        mainViewFragment.finishSelectionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSidePanelOpen() {
        return ((Guideline) findViewById(C6079R.id.main_activity_sidepanel_guideline)).getRight() > 0;
    }

    private final void animateSidePanel(boolean open) {
        SidePanelFragment sidePanelFragment;
        TransitionManager.endTransitions(this.contentLayout);
        boolean z = getResources().getBoolean(C6079R.bool.side_panel_fullscreen);
        final boolean z2 = getResources().getBoolean(C6079R.bool.side_panel_side_by_side);
        Guideline guideline = (Guideline) findViewById(C6079R.id.main_activity_sidepanel_guideline);
        ChangeBounds changeBounds = new ChangeBounds();
        if (z || !z2) {
            changeBounds.excludeChildren(C6079R.id.main_fragment_layout, true);
        }
        changeBounds.addListener(new TransitionListenerAdapter() { // from class: com.myscript.nebo.grid.MainActivity.animateSidePanel.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                View view;
                Intrinsics.checkNotNullParameter(transition, "transition");
                if (MainActivity.this.isSidePanelOpen() || (view = MainActivity.this.sidePanel) == null) {
                    return;
                }
                view.setVisibility(4);
            }
        });
        final boolean z3 = !open;
        View view = this.sidePanel;
        if (view != null) {
            view.post(new Runnable() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.animateSidePanel$lambda$0(this.f$0, z3, z2);
                }
            });
        }
        View view2 = this.sidePanel;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.contentLayout);
        ConstraintLayout constraintLayout = this.contentLayout;
        Intrinsics.checkNotNull(constraintLayout);
        TransitionManager.beginDelayedTransition(constraintLayout, changeBounds);
        float dimension = getResources().getDimension(C6079R.dimen.side_panel_width);
        float measuredWidth = this.sidePanel != null ? r6.getMeasuredWidth() : 0.0f;
        if (z && measuredWidth > 0.0f) {
            dimension = measuredWidth;
        }
        if ((!open ? 0 : (int) dimension) != guideline.getRight()) {
            if (z2) {
                constraintSet.setGuidelineBegin(C6079R.id.main_activity_grid_guideline, !open ? 0 : (int) dimension);
            }
            constraintSet.setGuidelineBegin(C6079R.id.main_activity_sidepanel_guideline, open ? (int) dimension : 0);
            constraintSet.applyTo(this.contentLayout);
            SidePanelFragment sidePanelFragment2 = this.sidePanelFragment;
            if (sidePanelFragment2 != null) {
                sidePanelFragment2.stopSelection();
            }
        }
        if (!open || (sidePanelFragment = this.sidePanelFragment) == null) {
            return;
        }
        sidePanelFragment.onSidePanelOpened();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateSidePanel$lambda$0(MainActivity mainActivity, boolean z, boolean z2) {
        ActivityResultCaller activityResultCallerFindFragmentById = mainActivity.getSupportFragmentManager().findFragmentById(C6079R.id.main_fragment_layout);
        if (activityResultCallerFindFragmentById instanceof MainActivityDetailFragment) {
            Toolbar toolbar = ((MainActivityDetailFragment) activityResultCallerFindFragmentById).getToolbar();
            mainActivity.toolbar = toolbar;
            if (toolbar != null) {
                Drawable drawable = mainActivity.navIcon;
                if (!z && z2) {
                    drawable = null;
                }
                toolbar.setNavigationIcon(drawable);
            }
            Drawable drawable2 = mainActivity.navIcon;
            if (drawable2 != null) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofInt("alpha", z ? 0 : 255, z ? 255 : 0);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(drawable2, propertyValuesHolderArr);
                objectAnimatorOfPropertyValuesHolder.setTarget(drawable2);
                objectAnimatorOfPropertyValuesHolder.setDuration(mainActivity.getResources().getInteger(R.integer.config_longAnimTime));
                objectAnimatorOfPropertyValuesHolder.start();
            }
        }
    }

    private final void setContentOverlayEnabled(final boolean enabled) {
        final View viewFindViewById = findViewById(C6079R.id.main_activity_content_overlay);
        if (enabled) {
            viewFindViewById.setAlpha(0.0f);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.setContentOverlayEnabled$lambda$0(viewFindViewById, this, view);
                }
            });
        } else {
            viewFindViewById.setAlpha(1.0f);
            viewFindViewById.setOnClickListener(null);
        }
        viewFindViewById.animate().alpha((float) Math.abs(viewFindViewById.getAlpha() - 1.0f)).setListener(new AnimatorListenerAdapter() { // from class: com.myscript.nebo.grid.MainActivity.setContentOverlayEnabled.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (enabled) {
                    return;
                }
                viewFindViewById.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setContentOverlayEnabled$lambda$0(View view, MainActivity mainActivity, View view2) {
        view.setOnClickListener(null);
        MainViewModel.requestSidePanelVisibility$default(mainActivity.getMainViewModel(), false, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        if (action == 1) {
            ClipDescription clipDescription = event.getClipDescription();
            if (clipDescription != null) {
                return clipDescription.hasMimeType(DragPageClipDataHelper.DRAG_PAGE_MIME);
            }
            return false;
        }
        if (action != 2) {
            return false;
        }
        if (event.getX() < ScreenUtils.dpToPx(this, 48.0f)) {
            MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), true, false, 2, null);
        }
        return true;
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void closeSearchIfNotStarted() {
        MainViewFragment mainViewFragment;
        MainViewFragment mainViewFragment2;
        if (!(getMainViewModel().getScreen().getValue() instanceof Screen.Notebooks) || (mainViewFragment = this.notesFragment) == null || !mainViewFragment.isAdded() || (mainViewFragment2 = this.notesFragment) == null) {
            return;
        }
        mainViewFragment2.closeSearchIfNotStarted();
    }

    @Override // com.myscript.nebo.sidenavigation.SidePanelFragment.Callback
    public void movePage(PageKey pageKey, NotebookKey newNotebookKey) {
        MainViewFragment mainViewFragment;
        MainViewFragment mainViewFragment2;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(newNotebookKey, "newNotebookKey");
        if ((getMainViewModel().getScreen().getValue() instanceof Screen.Notebooks) && (mainViewFragment = this.notesFragment) != null && mainViewFragment.isAdded() && (mainViewFragment2 = this.notesFragment) != null) {
            mainViewFragment2.stopLongPressTimer();
        }
        getGridViewModel().movePage(pageKey, newNotebookKey);
    }

    private final void onLanguageDownloadCanceledOverCellular(boolean canceled) {
        if (canceled) {
            displayNetworkOperationCanceledOverCellularPopup(C6079R.string.pref_network_popup_cellular_message_from_language_download);
        }
    }

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onSync() {
        closeSearchIfNotStarted();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65501(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onSync$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onSync$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {1472}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1473}, m1615s = {}, m1616v = 2)
    static final class C65501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65501(Continuation<? super C65501> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65501(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.getAutoSyncTimerManager().triggerSyncNow(this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onEnableCellular() {
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
        ((NeboApplication) application).provideNeboNetworkStateRepository().setDownloadOverCellularEnabled(true);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65481(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onEnableCellular$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onEnableCellular$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {1485}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1486}, m1615s = {}, m1616v = 2)
    static final class C65481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65481(Continuation<? super C65481> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65481(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.getAutoSyncTimerManager().triggerSyncNow(this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onConnect() {
        SidePanelFragment sidePanelFragment;
        SidePanelFragment sidePanelFragment2 = this.sidePanelFragment;
        if (sidePanelFragment2 != null && sidePanelFragment2.isAdded() && (sidePanelFragment = this.sidePanelFragment) != null) {
            sidePanelFragment.showSyncSettingsFragment();
        }
        int i = WhenMappings.$EnumSwitchMapping$1[getCloudManager().getConnectedProvider().ordinal()];
        if (i == 1) {
            dropboxSignIn();
        } else {
            if (i != 2) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65311(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onConnect$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onConnect$1", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {1497}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C65311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65311(Continuation<? super C65311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.m12802driveManualSignInIoAF18A(this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.dms.core.LibraryViewModel.SyncCallback
    public void onConflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2) {
        Intrinsics.checkNotNullParameter(duplicatedPageKeys, "duplicatedPageKeys");
        Intrinsics.checkNotNullParameter(duplicatedPageKeys2, "duplicatedPageKeys2");
        List<? extends PageKey> list = duplicatedPageKeys;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (getLibraryRepository().getPaginatedContainerFromPageKey((PageKey) it.next()) == null) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C65302(duplicatedPageKeys, null), 3, null);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainActivity$onConflictedPageCopies$2 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainActivity$onConflictedPageCopies$2", m1609f = "MainActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PageKey> $duplicatedPageKeys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C65302(List<? extends PageKey> list, Continuation<? super C65302> continuation) {
            super(2, continuation);
            this.$duplicatedPageKeys = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C65302(this.$duplicatedPageKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            new MaterialAlertDialogBuilder(MainActivity.this).setTitle(C6208R.string.sync_page_conflict_title).setMessage((CharSequence) MainActivity.this.getResources().getQuantityString(C6208R.plurals.sync_note_conflict_message, this.$duplicatedPageKeys.size(), Boxing.boxInt(this.$duplicatedPageKeys.size()))).setPositiveButton(C6183R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainActivity$onConflictedPageCopies$2$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
            return Unit.INSTANCE;
        }
    }

    public final void closeCurrentNotebook() {
        getGridViewModel().closeFolder();
    }

    private final void displayAutoSyncInformationDialogIfCloudConnected() {
        if (isCloudConnected()) {
            MainActivity mainActivity = this;
            if (NewFeatureVisibilityHelper.hasFeatureBeenDiscovered(mainActivity, NewFeatureVisibilityHelper.Key.AUTO_SYNC)) {
                return;
            }
            View viewInflate = LayoutInflater.from(mainActivity).inflate(C6079R.layout.autosync_announcement_dialog, (ViewGroup) null);
            Intrinsics.checkNotNull(viewInflate);
            viewInflate.setVisibility(getResources().getBoolean(C6079R.bool.auto_sync_show_illustration) ? 0 : 8);
            new MaterialAlertDialogBuilder(mainActivity).setTitle(C6079R.string.auto_sync_alert_dialog_title).setView(viewInflate).setCancelable(false).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return MainActivity.displayAutoSyncInformationDialogIfCloudConnected$lambda$0(dialogInterface, i, keyEvent);
                }
            }).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.grid.MainActivity$$ExternalSyntheticLambda12
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.displayAutoSyncInformationDialogIfCloudConnected$lambda$1(this.f$0, dialogInterface);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean displayAutoSyncInformationDialogIfCloudConnected$lambda$0(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        dialogInterface.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayAutoSyncInformationDialogIfCloudConnected$lambda$1(MainActivity mainActivity, DialogInterface dialogInterface) {
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(mainActivity, NewFeatureVisibilityHelper.Key.AUTO_SYNC, false, 2, null);
    }

    private final void showTrashDiscoverabilityIfNeeded() {
        if (NewFeatureVisibilityHelper.hasFeatureBeenDiscovered(this, NewFeatureVisibilityHelper.Key.TRASH)) {
            return;
        }
        TrashDiscoverabilityDialogKt.showTrashDiscoverabilityDialog(this);
    }

    private final void showBackupReminderIfNeeded() {
        if (getMainViewModel().shouldShowBackupReminder()) {
            BackupReminderDialog backupReminderDialogNewInstance = BackupReminderDialog.INSTANCE.newInstance();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            backupReminderDialogNewInstance.show(supportFragmentManager);
        }
    }

    private final void maybeShowCrossSell() {
        Object objM14499constructorimpl;
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        ApplicationState applicationStateProvideApplicationState = ((IApplicationStateProvider) application).provideApplicationState();
        ComponentCallbacks2 application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.UserSessionManager.Provider");
        UserSessionManager userSessionManagerProvideUserSessionManager = ((UserSessionManager.Provider) application2).provideUserSessionManager();
        ComponentCallbacks2 application3 = getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.CrossSellFilter.Provider");
        CrossSellFilter crossSellFilterProvideCrossSellFilter = ((CrossSellFilter.Provider) application3).provideCrossSellFilter();
        boolean z = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            MainActivity mainActivity = this;
            objM14499constructorimpl = Result.m14499constructorimpl(getPackageManager().getPackageInfo("com.myscript.math", 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        boolean zM14506isSuccessimpl = Result.m14506isSuccessimpl(objM14499constructorimpl);
        PreRatingFilterState value = getMainViewModel().getShowPreRating().getValue();
        boolean z2 = value != null && value.getShow();
        if (!applicationStateProvideApplicationState.requiresWhatsNew() && !getMainViewModel().shouldShowBackupReminder() && !z2) {
            z = true;
        }
        CrossSellOrigin crossSellOriginResolveOrigin = crossSellFilterProvideCrossSellFilter.resolveOrigin(userSessionManagerProvideUserSessionManager.getSessionCount(), zM14506isSuccessimpl, z);
        if (crossSellOriginResolveOrigin != null) {
            crossSellFilterProvideCrossSellFilter.onDisplayed();
            CrossSellDialog.INSTANCE.newInstance(crossSellOriginResolveOrigin.getOrigin()).show(getFragmentManager());
        }
    }

    @Override // com.myscript.nebo.sso.IHelpUsConsumer
    public boolean canShowHelpUsDialog() {
        return !RetailMode.INSTANCE.isEnabled();
    }

    @Override // com.myscript.nebo.sso.IHelpUsConsumer
    public void showHelpUsDialog() {
        getMainViewModel().showDataCollectDialog();
    }

    @Override // com.myscript.nebo.NeboBaseActivity
    protected void openCloudDisconnectedDialog(CloudManager.CloudProviderType cloudProviderType, boolean clientInitialized) {
        SidePanelFragment sidePanelFragment;
        Intrinsics.checkNotNullParameter(cloudProviderType, "cloudProviderType");
        SidePanelFragment sidePanelFragment2 = this.sidePanelFragment;
        if (sidePanelFragment2 != null && sidePanelFragment2.isAdded() && (sidePanelFragment = this.sidePanelFragment) != null) {
            sidePanelFragment.showSyncSettingsFragment();
        }
        super.openCloudDisconnectedDialog(cloudProviderType, clientInitialized);
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/grid/MainActivity$Companion;", "", "<init>", "()V", "TAG", "", MainActivity.EXTRA_FROM_FRESH_INSTALL, MainActivity.LAST_PROMOTIONAL_CAMPAIGN_FOR_WHICH_PAYWALL_WAS_DISPLAYED, MainActivity.IMPORT_REQUEST_DATA_FROM_INTENT, MainActivity.NOTEBOOK_ITEM_MORE_MENU, MainActivity.COLLECTION_ITEM_MORE_MENU, "IMPORT_NEBO_FILE_PERMISSION_REQUEST_CODE", "", "IMPORT_PDF_FROM_NEBO_PERMISSION_REQUEST_CODE", "IMPORT_PDF_FROM_OUTSIDE_PERMISSION_REQUEST_CODE", "newIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return new Intent(activity, (Class<?>) MainActivity.class);
            }
            Intent intent2 = new Intent(intent);
            intent2.setClass(activity, MainActivity.class);
            return intent2;
        }
    }

    private static final boolean onCreate$lambda$14$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
