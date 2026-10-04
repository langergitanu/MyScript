package com.revenuecat.purchases.p036ui.revenuecatui.data;

import android.app.Activity;
import android.os.LocaleList;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowExitOffer;
import com.revenuecat.purchases.common.workflows.WorkflowResolution;
import com.revenuecat.purchases.common.workflows.WorkflowScreen;
import com.revenuecat.purchases.common.workflows.WorkflowScreenType;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.common.workflows.events.WorkflowEvent;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallPurchaseLogicParams;
import com.revenuecat.purchases.p036ui.revenuecatui.ProductChange;
import com.revenuecat.purchases.p036ui.revenuecatui.PurchaseLogicResult;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallProductIdentifierKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.WebCheckoutUrlResolverKt;
import com.revenuecat.purchases.p036ui.revenuecatui.strings.PaywallValidationErrorStrings;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.NavigationDirection;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.WorkflowNavigator;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.WorkflowScreenMapper;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.ExitOffer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000È\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\n\u008e\u0002\u008f\u0002\u0090\u0002\u0091\u0002\u0092\u0002Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015JT\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u0002022\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010y2\b\b\u0002\u0010z\u001a\u00020\fH\u0002J:\u0010{\u001a\u00020q2\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.2\u0006\u0010|\u001a\u0002022\u0006\u0010}\u001a\u00020\fH\u0002JF\u0010~\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020K2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010C2\u0006\u0010>\u001a\u00020?2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u0001002\f\b\u0002\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u00020qH\u0002J\t\u0010\u0085\u0001\u001a\u00020qH\u0016J\t\u0010\u0086\u0001\u001a\u00020qH\u0002J\u0015\u0010\u0087\u0001\u001a\u00020q2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J>\u0010\u008c\u0001\u001a\u00020 2\u0006\u0010r\u001a\u0002022\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.2\t\u0010\u0081\u0001\u001a\u0004\u0018\u000100H\u0002J\u000b\u0010\u008d\u0001\u001a\u0004\u0018\u00010GH\u0002J\t\u0010\u008e\u0001\u001a\u00020qH\u0002J\u001f\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u00012\u0006\u0010\u007f\u001a\u00020KH\u0002J\t\u0010\u0092\u0001\u001a\u00020qH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u001dH\u0002J\u0015\u0010\u0094\u0001\u001a\u0004\u0018\u00010C2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020\fH\u0016J2\u0010\u0098\u0001\u001a\u00020q2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0096@¢\u0006\u0003\u0010\u009f\u0001J\u0010\u0010 \u0001\u001a\u00020qH\u0096@¢\u0006\u0003\u0010¡\u0001J\u001c\u0010¢\u0001\u001a\u00020q2\u0007\u0010£\u0001\u001a\u00020C2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020qH\u0016J\u001a\u0010§\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020*2\u0007\u0010¨\u0001\u001a\u00020CH\u0002J\u0012\u0010©\u0001\u001a\u00020q2\u0007\u0010ª\u0001\u001a\u00020CH\u0016J\t\u0010«\u0001\u001a\u00020qH\u0016J\t\u0010¬\u0001\u001a\u00020qH\u0016J\t\u0010\u00ad\u0001\u001a\u00020qH\u0016J\u0012\u0010®\u0001\u001a\u00020q2\u0007\u0010¯\u0001\u001a\u00020`H\u0016J2\u0010°\u0001\u001a\u00020q2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0082@¢\u0006\u0003\u0010\u009f\u0001J>\u0010±\u0001\u001a\u00020q2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010²\u0001\u001a\u00030\u009c\u00012\f\b\u0002\u0010³\u0001\u001a\u0005\u0018\u00010´\u00012\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0082@¢\u0006\u0003\u0010·\u0001J2\u0010¸\u0001\u001a\u00020q2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0082@¢\u0006\u0003\u0010»\u0001J\u0010\u0010¼\u0001\u001a\u00020qH\u0082@¢\u0006\u0003\u0010¡\u0001J+\u0010½\u0001\u001a\u00020q2\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.H\u0002J\t\u0010¾\u0001\u001a\u00020qH\u0016J\u0013\u0010¿\u0001\u001a\u00020\f2\b\u0010À\u0001\u001a\u00030Á\u0001H\u0002J,\u0010Â\u0001\u001a\u00020q2\u0007\u0010Ã\u0001\u001a\u00020C2\u0006\u0010\u007f\u001a\u00020K2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010,H\u0082@¢\u0006\u0003\u0010Å\u0001J%\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020K2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010,H\u0082@¢\u0006\u0003\u0010É\u0001J\u0015\u0010Ê\u0001\u001a\u00020q2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\t\u0010Ë\u0001\u001a\u00020qH\u0002J\u001a\u0010Ì\u0001\u001a\u00020q2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010Í\u0001\u001a\u00020\fH\u0016J\t\u0010Î\u0001\u001a\u00020qH\u0016J\u001b\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010À\u0001\u001a\u00030Á\u0001H\u0082@¢\u0006\u0003\u0010Ñ\u0001J\t\u0010Ò\u0001\u001a\u00020qH\u0016J1\u0010Ó\u0001\u001a\u00020q2\u001f\u0010Ô\u0001\u001a\u001a\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020q0Õ\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010\u000eH\u0082@¢\u0006\u0003\u0010×\u0001J\u0013\u0010Ø\u0001\u001a\u00020q2\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0016J+\u0010Û\u0001\u001a\u00020q2\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.H\u0002J3\u0010Ü\u0001\u001a\u00020q2\u0006\u0010s\u001a\u00020*2\u0006\u0010u\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010t\u001a\u000207H\u0000¢\u0006\u0003\bÝ\u0001J\u0013\u0010Þ\u0001\u001a\u00020q2\b\u0010ß\u0001\u001a\u00030à\u0001H\u0002J\u0013\u0010á\u0001\u001a\u00020q2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016J\t\u0010ä\u0001\u001a\u00020qH\u0002J\t\u0010å\u0001\u001a\u00020qH\u0002J\u001c\u0010æ\u0001\u001a\u00020q2\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010é\u0001\u001a\u00020CH\u0016J\t\u0010ê\u0001\u001a\u00020qH\u0002J\t\u0010ë\u0001\u001a\u00020qH\u0002J\t\u0010ì\u0001\u001a\u00020qH\u0016J\u001c\u0010í\u0001\u001a\u00020q2\b\u0010î\u0001\u001a\u00030\u009c\u00012\u0007\u0010ï\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010ð\u0001\u001a\u00020q2\b\u0010î\u0001\u001a\u00030\u009c\u0001H\u0002J\u001c\u0010ñ\u0001\u001a\u00020q2\u0006\u0010r\u001a\u0002022\t\u0010ò\u0001\u001a\u0004\u0018\u00010CH\u0002J'\u0010ó\u0001\u001a\u00020q2\t\u0010ô\u0001\u001a\u0004\u0018\u0001022\u0007\u0010õ\u0001\u001a\u0002022\b\u0010ö\u0001\u001a\u00030÷\u0001H\u0002J%\u0010ø\u0001\u001a\u00020q2\u0006\u0010r\u001a\u0002022\b\u0010w\u001a\u0004\u0018\u00010C2\b\u0010ö\u0001\u001a\u00030÷\u0001H\u0002J\u0012\u0010ù\u0001\u001a\u00020q2\u0007\u0010â\u0001\u001a\u000209H\u0002J\u000f\u0010ú\u0001\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010û\u0001\u001a\u00020q2\t\u0010ü\u0001\u001a\u0004\u0018\u00010KH\u0002J\t\u0010ý\u0001\u001a\u00020qH\u0002J\u001a\u0010þ\u0001\u001a\u00020q2\b\u0010À\u0001\u001a\u00030Á\u0001H\u0082@¢\u0006\u0003\u0010Ñ\u0001J\t\u0010ÿ\u0001\u001a\u00020qH\u0002J#\u0010\u0080\u0002\u001a\u0004\u0018\u00010C2\u0006\u0010r\u001a\u0002022\u0006\u0010s\u001a\u00020*2\u0006\u0010u\u001a\u00020,H\u0002J\t\u0010\u0081\u0002\u001a\u00020\fH\u0002J0\u0010\u008d\u0001\u001a\u0004\u0018\u00010G*\u00020k2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010C2\t\u0010¨\u0001\u001a\u0004\u0018\u00010C2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010CH\u0002J1\u0010\u008d\u0001\u001a\u0004\u0018\u00010G*\u00030\u0083\u00022\t\u0010Ã\u0001\u001a\u0004\u0018\u00010C2\t\u0010¨\u0001\u001a\u0004\u0018\u00010C2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010CH\u0002J\u000e\u0010\u0084\u0002\u001a\u00030\u008b\u0001*\u00020GH\u0002J!\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u008b\u0001*\u00020k2\u0006\u0010>\u001a\u00020?2\u0007\u0010\u0086\u0002\u001a\u00020\fH\u0002J+\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u008b\u0001*\u00030\u0083\u00022\u0006\u0010>\u001a\u00020?2\u0007\u0010\u0088\u0002\u001a\u00020\u001d2\u0007\u0010\u0086\u0002\u001a\u00020\fH\u0002J\r\u0010\u0089\u0002\u001a\u000209*\u000209H\u0002J\u000e\u0010\u008a\u0002\u001a\u00030\u008b\u0002*\u00020\u001dH\u0002J\u0015\u0010\u008c\u0002\u001a\u00020\f*\u0002022\u0006\u0010s\u001a\u00020*H\u0002J\r\u0010\u008d\u0002\u001a\u00020G*\u00020GH\u0002R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\u0004\u0018\u00010K8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010&R\u0016\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0010\u0010Z\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020 0\\8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u000e\u0010_\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u0010&R\u001a\u0010i\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020k0jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010m\u001a\u00020.*\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006\u0093\u0002"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "preview", "productChangeCalculator", "Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Landroidx/compose/material3/ColorScheme;ZLkotlin/jvm/functions/Function1;ZLcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_actionError", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/PurchasesError;", "_actionInProgress", "_colorScheme", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_lastLocaleList", "Landroidx/core/os/LocaleListCompat;", "_purchaseCompleted", "_state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "_workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "actionError", "Landroidx/compose/runtime/State;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "getActionInProgress", "currentWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "currentWorkflowOfferings", "Lcom/revenuecat/purchases/Offerings;", "currentWorkflowPresentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "currentWorkflowStateStore", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "currentWorkflowStep", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "getCurrentWorkflowStep", "()Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "currentWorkflowStepTracksPaywallEvents", "currentWorkflowUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "exitOfferData", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getMode", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "paywallEventTraceId", "", "getPaywallEventTraceId", "()Ljava/lang/String;", "paywallPresentationData", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "preWarmJob", "Lkotlinx/coroutines/Job;", "preloadedExitOffering", "Lcom/revenuecat/purchases/Offering;", "getPreloadedExitOffering$revenuecatui_defaultsRelease", "()Lcom/revenuecat/purchases/Offering;", "purchaseCompleted", "getPurchaseCompleted", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "shouldReloadStateOnNextPresentation", "shouldTriggerExitOfferForCurrentStep", "getShouldTriggerExitOfferForCurrentStep", "()Z", "standaloneStateStore", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "transitionIdCounter", "", "updateStateJob", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "workflowCompletedInSession", "workflowNavigator", "Lcom/revenuecat/purchases/ui/revenuecatui/workflow/WorkflowNavigator;", "workflowState", "getWorkflowState", "workflowStepStateCache", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "workflowTraceId", "presentedOfferingContextOrDefault", "getPresentedOfferingContextOrDefault", "(Lcom/revenuecat/purchases/Offering;)Lcom/revenuecat/purchases/PresentedOfferingContext;", "buildStateFromStep", "", "step", Keys.WORKFLOW, "uiConfig", "offerings", "presentedOfferingContext", "fromStepId", "navigationDirection", "Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "shouldApplyState", "buildWorkflowStates", "currentStep", "isNewWorkflowImpression", "calculateState", "offering", "storefrontCountryCode", "stateStore", "workflowScreen", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "cancelStateUpdate", "clearActionError", "clearWorkflowState", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "computePresentationFingerprint", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$PaywallPresentationFingerprint;", "computeStateForStep", "createEventData", "endPresentationSession", "extractDefaultCustomVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "finishAction", "getCurrentLocaleList", "getWebCheckoutUrl", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "handleBackNavigation", "handlePackagePurchase", "activity", "Landroid/app/Activity;", "pkg", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleWorkflowAction", "componentId", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "invalidateCustomerInfoCache", "isTerminalStep", "stepId", "notifyUrlOpened", ImagesContract.URL, "notifyWebCheckoutOpened", "onPaywallDismissed", "onPaywallPresented", "onTransitionComplete", "transitionId", "performPackagePurchase", "performPurchase", "packageToPurchase", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lcom/revenuecat/purchases/models/SubscriptionOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performPurchaseIfNecessary", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRestore", "preWarmWorkflowStepCache", "preloadExitOffering", "presentInjectedWorkflowIfNeeded", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "presentWorkflow", "workflowId", "preloadedOfferings", "(Ljava/lang/String;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/Offerings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentWorkflowOrResolveFallback", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome;", "workflowOffering", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/Offerings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseSelectedPackage", "rebuildWorkflowStepStates", "refreshStateIfColorsChanged", "isDark", "refreshStateIfLocaleChanged", "resolveOfferingSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ResolvedOfferingSelection;", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restorePurchases", "runExclusiveAction", "block", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectPackage", "packageToSelect", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "startWorkflowPresentation", "startWorkflowPresentationFromResult", "startWorkflowPresentationFromResult$revenuecatui_defaultsRelease", "track", "eventType", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "trackComponentInteraction", "data", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "trackCurrentWorkflowAbandoned", "trackCurrentWorkflowStepCompleted", "trackExitOffer", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "trackPaywallCancel", "trackPaywallClose", "trackPaywallImpressionIfNeeded", "trackPaywallPurchaseError", "rcPackage", "error", "trackPaywallPurchaseInitiated", "trackWorkflowStepCompleted", "toStepId", "trackWorkflowStepNavigation", "fromStep", "toStep", "entryReason", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowStepEntryReason;", "trackWorkflowStepStarted", "updateExitOfferData", "updateOptions", "updatePaywallState", "currentOffering", "updateState", "updateStateFromOffering", "validateState", "validateStep", "verifyNoActionInProgressOrStartAction", "traceId", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "presentationFingerprint", "presentationFingerprintComponents", "darkMode", "presentationFingerprintLegacy", "localeList", "resolveIfNeeded", "toFrameworkLocaleList", "Landroid/os/LocaleList;", "tracksPaywallEvents", "withCurrentWorkflowMetadata", "ExitOfferData", "PaywallPresentationFingerprint", "ResolvedOfferingSelection", "WorkflowOutcome", "WorkflowStepEntryReason", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallViewModelImpl extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<ColorScheme> _colorScheme;
    private final MutableStateFlow<LocaleListCompat> _lastLocaleList;
    private final MutableState<Boolean> _purchaseCompleted;
    private final MutableStateFlow<PaywallState> _state;
    private final MutableState<WorkflowPaywallUiState> _workflowState;
    private final CoroutineDispatcher backgroundDispatcher;
    private PublishedWorkflow currentWorkflow;
    private Offerings currentWorkflowOfferings;
    private PresentedOfferingContext currentWorkflowPresentedOfferingContext;
    private PaywallStateStore currentWorkflowStateStore;
    private boolean currentWorkflowStepTracksPaywallEvents;
    private UiConfig currentWorkflowUiConfig;
    private ExitOfferData exitOfferData;
    private boolean isDarkMode;
    private PaywallOptions options;
    private PaywallEvent.Data paywallPresentationData;
    private Job preWarmJob;
    private final ProductChangeCalculator productChangeCalculator;
    private final PurchasesType purchases;
    private final ResourceProvider resourceProvider;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;
    private boolean shouldReloadStateOnNextPresentation;
    private PaywallStateStore standaloneStateStore;
    private int transitionIdCounter;
    private Job updateStateJob;
    private final VariableDataProvider variableDataProvider;
    private boolean workflowCompletedInSession;
    private WorkflowNavigator workflowNavigator;
    private final Map<String, PaywallState.Loaded.Components> workflowStepStateCache;
    private String workflowTraceId;

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", m1609f = "PaywallViewModel.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4}, m1611l = {1840, PDFACompliance.e_PDFA7_2_3, 742, 745, 791}, m1612m = "performPurchase", m1613n = {"this", "activity", "packageToPurchase", "productChangeConfig", "subscriptionOption", "this", "activity", "packageToPurchase", "subscriptionOption", "this", "packageToPurchase", "this", "packageToPurchase", "this", "packageToPurchase"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class C81481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C81481(Continuation<? super C81481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.performPurchase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performRestore$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", m1609f = "PaywallViewModel.kt", m1610i = {0, 1, 1, 2, 3, 4}, m1611l = {1840, 584, 585, 587, PDFACompliance.e_PDFA6_2_1}, m1612m = "performRestore", m1613n = {"this", "this", "customRestoreHandler", "this", "this", "this"}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0"})
    static final class C81491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C81491(Continuation<? super C81491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.performRestore(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$presentWorkflowOrResolveFallback$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", m1609f = "PaywallViewModel.kt", m1610i = {0, 0, 0, 1}, m1611l = {923, 926}, m1612m = "presentWorkflowOrResolveFallback", m1613n = {"this", "workflowOffering", "preloadedOfferings", "this"}, m1615s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C81521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C81521(Continuation<? super C81521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.presentWorkflowOrResolveFallback(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$resolveOfferingSelection$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", m1609f = "PaywallViewModel.kt", m1610i = {0, 1}, m1611l = {981, 995, 1008}, m1612m = "resolveOfferingSelection", m1613n = {"offeringSelection", "offeringSelection"}, m1615s = {"L$0", "L$0"})
    static final class C81541 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C81541(Continuation<? super C81541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.resolveOfferingSelection(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateStateFromOffering$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", m1609f = "PaywallViewModel.kt", m1610i = {0, 1, 1, 1}, m1611l = {848, 858}, m1612m = "updateStateFromOffering", m1613n = {"this", "this", "selectedOffering", "offeringsForExitOfferLookup"}, m1615s = {"L$0", "L$0", "L$1", "L$2"})
    static final class C81581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C81581(Continuation<? super C81581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.updateStateFromOffering(null, this);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return this.resourceProvider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesImpl purchasesImpl, PaywallOptions paywallOptions, ColorScheme colorScheme, boolean z, Function1 function1, boolean z2, ProductChangeCalculator productChangeCalculator, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        PurchasesType purchasesImpl2 = (i & 2) != 0 ? new PurchasesImpl(null, 1, 0 == true ? 1 : 0) : purchasesImpl;
        this(resourceProvider, purchasesImpl2, paywallOptions, colorScheme, z, function1, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? new ProductChangeCalculator(purchasesImpl2) : productChangeCalculator, (i & 256) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesType purchases, PaywallOptions options, ColorScheme colorScheme, boolean z, Function1<? super CustomerInfo, Boolean> function1, boolean z2, ProductChangeCalculator productChangeCalculator, CoroutineDispatcher backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(productChangeCalculator, "productChangeCalculator");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.resourceProvider = resourceProvider;
        this.purchases = purchases;
        this.options = options;
        this.isDarkMode = z;
        this.shouldDisplayBlock = function1;
        this.productChangeCalculator = productChangeCalculator;
        this.backgroundDispatcher = backgroundDispatcher;
        this.variableDataProvider = new VariableDataProvider(getResourceProvider(), z2);
        this._state = StateFlowKt.MutableStateFlow(PaywallState.Loading.INSTANCE);
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._purchaseCompleted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._workflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.workflowTraceId = string;
        this._lastLocaleList = StateFlowKt.MutableStateFlow(getCurrentLocaleList());
        this._colorScheme = StateFlowKt.MutableStateFlow(colorScheme);
        this.currentWorkflowUiConfig = PaywallOptionsKt.emptyUiConfig();
        this.currentWorkflowStepTracksPaywallEvents = true;
        this.workflowStepStateCache = new LinkedHashMap();
        this.exitOfferData = new ExitOfferData.Loading(false, 1, null);
        updateState();
        validateState();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.asStateFlow(this._state);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this._purchaseCompleted;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<WorkflowPaywallUiState> getWorkflowState() {
        return this._workflowState;
    }

    public final Offering getPreloadedExitOffering$revenuecatui_defaultsRelease() {
        ExitOfferData exitOfferData = this.exitOfferData;
        ExitOfferData.Configured configured = exitOfferData instanceof ExitOfferData.Configured ? (ExitOfferData.Configured) exitOfferData : null;
        if (configured != null) {
            return configured.getPreloadedOffering();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallListener getListener() {
        return this.options.getListener();
    }

    private final PaywallMode getMode() {
        return this.options.getMode();
    }

    private final PaywallPurchaseLogic getPurchaseLogic() {
        return this.options.getPurchaseLogic();
    }

    private final String getPaywallEventTraceId() {
        String str = this.workflowTraceId;
        if (this.currentWorkflow != null) {
            return str;
        }
        return null;
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowStepEntryReason;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "START", "FORWARD", "BACK", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private enum WorkflowStepEntryReason {
        START(TtmlNode.START),
        FORWARD("forward"),
        BACK("back");

        private final String value;

        WorkflowStepEntryReason(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0007\b\tJ\b\u0010\u0006\u001a\u00020\u0000H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData;", "", "preloadRequested", "", "getPreloadRequested", "()Z", "withPreloadRequested", "Configured", "Loading", "Unavailable", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Configured;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Unavailable;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private interface ExitOfferData {
        boolean getPreloadRequested();

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData;", "preloadRequested", "", "(Z)V", "getPreloadRequested", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Loading implements ExitOfferData {
            public static final int $stable = 0;
            private final boolean preloadRequested;

            public Loading() {
                this(false, 1, null);
            }

            public static /* synthetic */ Loading copy$default(Loading loading, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = loading.preloadRequested;
                }
                return loading.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getPreloadRequested() {
                return this.preloadRequested;
            }

            public final Loading copy(boolean preloadRequested) {
                return new Loading(preloadRequested);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && this.preloadRequested == ((Loading) other).preloadRequested;
            }

            public int hashCode() {
                return Boolean.hashCode(this.preloadRequested);
            }

            public String toString() {
                return "Loading(preloadRequested=" + this.preloadRequested + ')';
            }

            public Loading(boolean z) {
                this.preloadRequested = z;
            }

            public /* synthetic */ Loading(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.ExitOfferData
            public boolean getPreloadRequested() {
                return this.preloadRequested;
            }
        }

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Unavailable;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData;", "preloadRequested", "", "(Z)V", "getPreloadRequested", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Unavailable implements ExitOfferData {
            public static final int $stable = 0;
            private final boolean preloadRequested;

            public Unavailable() {
                this(false, 1, null);
            }

            public static /* synthetic */ Unavailable copy$default(Unavailable unavailable, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = unavailable.preloadRequested;
                }
                return unavailable.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getPreloadRequested() {
                return this.preloadRequested;
            }

            public final Unavailable copy(boolean preloadRequested) {
                return new Unavailable(preloadRequested);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Unavailable) && this.preloadRequested == ((Unavailable) other).preloadRequested;
            }

            public int hashCode() {
                return Boolean.hashCode(this.preloadRequested);
            }

            public String toString() {
                return "Unavailable(preloadRequested=" + this.preloadRequested + ')';
            }

            public Unavailable(boolean z) {
                this.preloadRequested = z;
            }

            public /* synthetic */ Unavailable(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.ExitOfferData
            public boolean getPreloadRequested() {
                return this.preloadRequested;
            }
        }

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData$Configured;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ExitOfferData;", "offeringId", "", "offerings", "Lcom/revenuecat/purchases/Offerings;", "triggeringWorkflowStepId", "preloadRequested", "", "preloadedOffering", "Lcom/revenuecat/purchases/Offering;", "(Ljava/lang/String;Lcom/revenuecat/purchases/Offerings;Ljava/lang/String;ZLcom/revenuecat/purchases/Offering;)V", "getOfferingId", "()Ljava/lang/String;", "getOfferings", "()Lcom/revenuecat/purchases/Offerings;", "getPreloadRequested", "()Z", "getPreloadedOffering", "()Lcom/revenuecat/purchases/Offering;", "getTriggeringWorkflowStepId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Configured implements ExitOfferData {
            public static final int $stable = 8;
            private final String offeringId;
            private final Offerings offerings;
            private final boolean preloadRequested;
            private final Offering preloadedOffering;
            private final String triggeringWorkflowStepId;

            public static /* synthetic */ Configured copy$default(Configured configured, String str, Offerings offerings, String str2, boolean z, Offering offering, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = configured.offeringId;
                }
                if ((i & 2) != 0) {
                    offerings = configured.offerings;
                }
                if ((i & 4) != 0) {
                    str2 = configured.triggeringWorkflowStepId;
                }
                if ((i & 8) != 0) {
                    z = configured.preloadRequested;
                }
                if ((i & 16) != 0) {
                    offering = configured.preloadedOffering;
                }
                Offering offering2 = offering;
                String str3 = str2;
                return configured.copy(str, offerings, str3, z, offering2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getOfferingId() {
                return this.offeringId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Offerings getOfferings() {
                return this.offerings;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTriggeringWorkflowStepId() {
                return this.triggeringWorkflowStepId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getPreloadRequested() {
                return this.preloadRequested;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Offering getPreloadedOffering() {
                return this.preloadedOffering;
            }

            public final Configured copy(String offeringId, Offerings offerings, String triggeringWorkflowStepId, boolean preloadRequested, Offering preloadedOffering) {
                Intrinsics.checkNotNullParameter(offeringId, "offeringId");
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                return new Configured(offeringId, offerings, triggeringWorkflowStepId, preloadRequested, preloadedOffering);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Configured)) {
                    return false;
                }
                Configured configured = (Configured) other;
                return Intrinsics.areEqual(this.offeringId, configured.offeringId) && Intrinsics.areEqual(this.offerings, configured.offerings) && Intrinsics.areEqual(this.triggeringWorkflowStepId, configured.triggeringWorkflowStepId) && this.preloadRequested == configured.preloadRequested && Intrinsics.areEqual(this.preloadedOffering, configured.preloadedOffering);
            }

            public int hashCode() {
                int iHashCode = ((this.offeringId.hashCode() * 31) + this.offerings.hashCode()) * 31;
                String str = this.triggeringWorkflowStepId;
                int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.preloadRequested)) * 31;
                Offering offering = this.preloadedOffering;
                return iHashCode2 + (offering != null ? offering.hashCode() : 0);
            }

            public String toString() {
                return "Configured(offeringId=" + this.offeringId + ", offerings=" + this.offerings + ", triggeringWorkflowStepId=" + this.triggeringWorkflowStepId + ", preloadRequested=" + this.preloadRequested + ", preloadedOffering=" + this.preloadedOffering + ')';
            }

            public Configured(String offeringId, Offerings offerings, String str, boolean z, Offering offering) {
                Intrinsics.checkNotNullParameter(offeringId, "offeringId");
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                this.offeringId = offeringId;
                this.offerings = offerings;
                this.triggeringWorkflowStepId = str;
                this.preloadRequested = z;
                this.preloadedOffering = offering;
            }

            public /* synthetic */ Configured(String str, Offerings offerings, String str2, boolean z, Offering offering, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, offerings, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : offering);
            }

            public final String getOfferingId() {
                return this.offeringId;
            }

            public final Offerings getOfferings() {
                return this.offerings;
            }

            public final String getTriggeringWorkflowStepId() {
                return this.triggeringWorkflowStepId;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.ExitOfferData
            public boolean getPreloadRequested() {
                return this.preloadRequested;
            }

            public final Offering getPreloadedOffering() {
                return this.preloadedOffering;
            }
        }

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static ExitOfferData withPreloadRequested(ExitOfferData exitOfferData) {
                return ExitOfferData.super.withPreloadRequested();
            }
        }

        default ExitOfferData withPreloadRequested() {
            if (this instanceof Loading) {
                return ((Loading) this).copy(true);
            }
            if (this instanceof Unavailable) {
                return ((Unavailable) this).copy(true);
            }
            if (this instanceof Configured) {
                return Configured.copy$default((Configured) this, null, null, null, true, null, 23, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$PaywallPresentationFingerprint;", "", "paywallIdentifier", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "paywallRevision", "", "displayMode", "localeIdentifier", "darkMode", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;ILjava/lang/String;Ljava/lang/String;Z)V", "getDarkMode", "()Z", "getDisplayMode", "()Ljava/lang/String;", "getLocaleIdentifier", "getPaywallIdentifier", "getPaywallRevision", "()I", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final /* data */ class PaywallPresentationFingerprint {
        private final boolean darkMode;
        private final String displayMode;
        private final String localeIdentifier;
        private final String paywallIdentifier;
        private final int paywallRevision;
        private final PresentedOfferingContext presentedOfferingContext;

        public static /* synthetic */ PaywallPresentationFingerprint copy$default(PaywallPresentationFingerprint paywallPresentationFingerprint, String str, PresentedOfferingContext presentedOfferingContext, int i, String str2, String str3, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = paywallPresentationFingerprint.paywallIdentifier;
            }
            if ((i2 & 2) != 0) {
                presentedOfferingContext = paywallPresentationFingerprint.presentedOfferingContext;
            }
            if ((i2 & 4) != 0) {
                i = paywallPresentationFingerprint.paywallRevision;
            }
            if ((i2 & 8) != 0) {
                str2 = paywallPresentationFingerprint.displayMode;
            }
            if ((i2 & 16) != 0) {
                str3 = paywallPresentationFingerprint.localeIdentifier;
            }
            if ((i2 & 32) != 0) {
                z = paywallPresentationFingerprint.darkMode;
            }
            String str4 = str3;
            boolean z2 = z;
            return paywallPresentationFingerprint.copy(str, presentedOfferingContext, i, str2, str4, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final PaywallPresentationFingerprint copy(String paywallIdentifier, PresentedOfferingContext presentedOfferingContext, int paywallRevision, String displayMode, String localeIdentifier, boolean darkMode) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new PaywallPresentationFingerprint(paywallIdentifier, presentedOfferingContext, paywallRevision, displayMode, localeIdentifier, darkMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaywallPresentationFingerprint)) {
                return false;
            }
            PaywallPresentationFingerprint paywallPresentationFingerprint = (PaywallPresentationFingerprint) other;
            return Intrinsics.areEqual(this.paywallIdentifier, paywallPresentationFingerprint.paywallIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, paywallPresentationFingerprint.presentedOfferingContext) && this.paywallRevision == paywallPresentationFingerprint.paywallRevision && Intrinsics.areEqual(this.displayMode, paywallPresentationFingerprint.displayMode) && Intrinsics.areEqual(this.localeIdentifier, paywallPresentationFingerprint.localeIdentifier) && this.darkMode == paywallPresentationFingerprint.darkMode;
        }

        public int hashCode() {
            String str = this.paywallIdentifier;
            return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31) + Boolean.hashCode(this.darkMode);
        }

        public String toString() {
            return "PaywallPresentationFingerprint(paywallIdentifier=" + this.paywallIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", paywallRevision=" + this.paywallRevision + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ')';
        }

        public PaywallPresentationFingerprint(String str, PresentedOfferingContext presentedOfferingContext, int i, String displayMode, String localeIdentifier, boolean z) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.paywallIdentifier = str;
            this.presentedOfferingContext = presentedOfferingContext;
            this.paywallRevision = i;
            this.displayMode = displayMode;
            this.localeIdentifier = localeIdentifier;
            this.darkMode = z;
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$ResolvedOfferingSelection;", "", "selectedOffering", "Lcom/revenuecat/purchases/Offering;", "offeringsForExitOfferLookup", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/Offerings;)V", "getOfferingsForExitOfferLookup", "()Lcom/revenuecat/purchases/Offerings;", "getSelectedOffering", "()Lcom/revenuecat/purchases/Offering;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final /* data */ class ResolvedOfferingSelection {
        private final Offerings offeringsForExitOfferLookup;
        private final Offering selectedOffering;

        public static /* synthetic */ ResolvedOfferingSelection copy$default(ResolvedOfferingSelection resolvedOfferingSelection, Offering offering, Offerings offerings, int i, Object obj) {
            if ((i & 1) != 0) {
                offering = resolvedOfferingSelection.selectedOffering;
            }
            if ((i & 2) != 0) {
                offerings = resolvedOfferingSelection.offeringsForExitOfferLookup;
            }
            return resolvedOfferingSelection.copy(offering, offerings);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Offering getSelectedOffering() {
            return this.selectedOffering;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Offerings getOfferingsForExitOfferLookup() {
            return this.offeringsForExitOfferLookup;
        }

        public final ResolvedOfferingSelection copy(Offering selectedOffering, Offerings offeringsForExitOfferLookup) {
            return new ResolvedOfferingSelection(selectedOffering, offeringsForExitOfferLookup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResolvedOfferingSelection)) {
                return false;
            }
            ResolvedOfferingSelection resolvedOfferingSelection = (ResolvedOfferingSelection) other;
            return Intrinsics.areEqual(this.selectedOffering, resolvedOfferingSelection.selectedOffering) && Intrinsics.areEqual(this.offeringsForExitOfferLookup, resolvedOfferingSelection.offeringsForExitOfferLookup);
        }

        public int hashCode() {
            Offering offering = this.selectedOffering;
            int iHashCode = (offering == null ? 0 : offering.hashCode()) * 31;
            Offerings offerings = this.offeringsForExitOfferLookup;
            return iHashCode + (offerings != null ? offerings.hashCode() : 0);
        }

        public String toString() {
            return "ResolvedOfferingSelection(selectedOffering=" + this.selectedOffering + ", offeringsForExitOfferLookup=" + this.offeringsForExitOfferLookup + ')';
        }

        public ResolvedOfferingSelection(Offering offering, Offerings offerings) {
            this.selectedOffering = offering;
            this.offeringsForExitOfferLookup = offerings;
        }

        public final Offering getSelectedOffering() {
            return this.selectedOffering;
        }

        public final Offerings getOfferingsForExitOfferLookup() {
            return this.offeringsForExitOfferLookup;
        }
    }

    public final void updateOptions(PaywallOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z = this.options.hashCode() != options.hashCode();
        this.options = options;
        if (z) {
            updateState();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        LocaleListCompat currentLocaleList = getCurrentLocaleList();
        if (Intrinsics.areEqual(this._lastLocaleList.getValue(), currentLocaleList)) {
            return;
        }
        this._lastLocaleList.setValue(currentLocaleList);
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Components) {
            LocaleList frameworkLocaleList = toFrameworkLocaleList(currentLocaleList);
            PaywallState.Loaded.Components.update$default((PaywallState.Loaded.Components) value, frameworkLocaleList, null, null, 6, null);
            Iterator<T> it = this.workflowStepStateCache.values().iterator();
            while (it.hasNext()) {
                PaywallState.Loaded.Components.update$default((PaywallState.Loaded.Components) it.next(), frameworkLocaleList, null, null, 6, null);
            }
            return;
        }
        updateState();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDark) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        if (this.isDarkMode != isDark) {
            this.isDarkMode = isDark;
        }
        if (Intrinsics.areEqual(this._colorScheme.getValue(), colorScheme)) {
            return;
        }
        this._colorScheme.setValue(colorScheme);
        if (this.workflowNavigator != null) {
            rebuildWorkflowStepStates();
        } else {
            updateState();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Legacy) {
            ((PaywallState.Loaded.Legacy) value).selectPackage(packageToSelect);
        } else {
            Logger.INSTANCE.m1584e("Unexpected state trying to select package: " + value);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult result) {
        Logger.INSTANCE.m1583d("Paywalls: Close paywall initiated");
        trackCurrentWorkflowStepCompleted();
        if (!this.workflowCompletedInSession) {
            trackCurrentWorkflowAbandoned();
        }
        trackPaywallClose();
        Offering preloadedExitOffering$revenuecatui_defaultsRelease = (this._purchaseCompleted.getValue().booleanValue() || !getShouldTriggerExitOfferForCurrentStep()) ? null : getPreloadedExitOffering$revenuecatui_defaultsRelease();
        if (preloadedExitOffering$revenuecatui_defaultsRelease != null) {
            trackExitOffer(ExitOfferType.DISMISS, preloadedExitOffering$revenuecatui_defaultsRelease.getIdentifier());
        }
        endPresentationSession();
        Function2<Offering, PaywallResult, Unit> dismissRequestWithExitOffering$revenuecatui_defaultsRelease = this.options.getDismissRequestWithExitOffering$revenuecatui_defaultsRelease();
        if (dismissRequestWithExitOffering$revenuecatui_defaultsRelease != null) {
            dismissRequestWithExitOffering$revenuecatui_defaultsRelease.invoke(preloadedExitOffering$revenuecatui_defaultsRelease, result);
        } else {
            this.options.getDismissRequest().invoke();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallPresented() {
        if (this.shouldReloadStateOnNextPresentation) {
            this.shouldReloadStateOnNextPresentation = false;
            updateState();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallDismissed() {
        if (this.shouldReloadStateOnNextPresentation) {
            cancelStateUpdate();
            this._state.setValue(PaywallState.Loading.INSTANCE);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        this.exitOfferData = resolveIfNeeded(this.exitOfferData.withPreloadRequested());
    }

    private final void cancelStateUpdate() {
        Job job = this.updateStateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void clearWorkflowState() {
        Job job = this.preWarmJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.preWarmJob = null;
        this.workflowNavigator = null;
        this.currentWorkflow = null;
        this.currentWorkflowOfferings = null;
        this.currentWorkflowPresentedOfferingContext = null;
        this.currentWorkflowStepTracksPaywallEvents = true;
        this.workflowStepStateCache.clear();
        this.currentWorkflowStateStore = null;
        this._workflowState.setValue(null);
        this.workflowCompletedInSession = false;
    }

    private final void endPresentationSession() {
        cancelStateUpdate();
        this.paywallPresentationData = null;
        this.standaloneStateStore = null;
        clearWorkflowState();
        this.shouldReloadStateOnNextPresentation = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateExitOfferData(ExitOfferData data) {
        if (this.exitOfferData.getPreloadRequested()) {
            data = data.withPreloadRequested();
        }
        this.exitOfferData = resolveIfNeeded(data);
    }

    private final ExitOfferData resolveIfNeeded(ExitOfferData exitOfferData) {
        if (!(exitOfferData instanceof ExitOfferData.Configured) || !exitOfferData.getPreloadRequested()) {
            return exitOfferData;
        }
        ExitOfferData.Configured configured = (ExitOfferData.Configured) exitOfferData;
        if (configured.getPreloadedOffering() != null) {
            return exitOfferData;
        }
        Offering offering = configured.getOfferings().get(configured.getOfferingId());
        if (offering == null) {
            Logger.INSTANCE.m1587w("Paywalls: Exit offering '" + configured.getOfferingId() + "' not found in available offerings.");
        }
        return ExitOfferData.Configured.copy$default(configured, null, null, null, false, offering, 15, null);
    }

    private final boolean getShouldTriggerExitOfferForCurrentStep() {
        ExitOfferData exitOfferData = this.exitOfferData;
        if (exitOfferData instanceof ExitOfferData.Configured) {
            String triggeringWorkflowStepId = ((ExitOfferData.Configured) exitOfferData).getTriggeringWorkflowStepId();
            if (triggeringWorkflowStepId != null) {
                WorkflowPaywallUiState value = this._workflowState.getValue();
                if (!Intrinsics.areEqual(value != null ? value.getCurrentStepId() : null, triggeringWorkflowStepId)) {
                    return false;
                }
            }
            return true;
        }
        if (exitOfferData instanceof ExitOfferData.Loading ? true : exitOfferData instanceof ExitOfferData.Unavailable) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        PaywallState value = getState().getValue();
        PaywallState.Loaded.Components components = value instanceof PaywallState.Loaded.Components ? (PaywallState.Loaded.Components) value : null;
        if (components == null) {
            Logger.INSTANCE.m1584e("Web checkout URL can only be constructed for loaded Components paywalls");
            return null;
        }
        return WebCheckoutUrlResolverKt.resolveWebCheckoutUrlForInteraction(components, launchWebCheckout);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyWebCheckoutOpened() {
        PaywallListener listener = getListener();
        if (listener != null) {
            listener.onWebCheckoutOpened();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyUrlOpened(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        PaywallListener listener = getListener();
        if (listener != null) {
            listener.onUrlOpened(url);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81531(activity, null), 3, null);
        } else {
            Logger.INSTANCE.m1584e("Activity is null, not initiating package purchase");
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {477}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C81531(Activity activity, Continuation<? super C81531> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C81531(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModel.handlePackagePurchase$default(PaywallViewModelImpl.this, this.$activity, null, null, this, 4, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {483}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C81551(Continuation<? super C81551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C81551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModelImpl.this.handleRestorePurchases(this) == coroutine_suspended) {
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

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81551(null), 3, null);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        if (this.shouldReloadStateOnNextPresentation) {
            return;
        }
        boolean z = this.currentWorkflow != null;
        if (z && !this.currentWorkflowStepTracksPaywallEvents) {
            this.paywallPresentationData = null;
            return;
        }
        PaywallPresentationFingerprint paywallPresentationFingerprintComputePresentationFingerprint = computePresentationFingerprint();
        if (paywallPresentationFingerprintComputePresentationFingerprint == null) {
            return;
        }
        PaywallEvent.Data data = this.paywallPresentationData;
        if (Intrinsics.areEqual(data != null ? presentationFingerprint(data) : null, paywallPresentationFingerprintComputePresentationFingerprint)) {
            this.paywallPresentationData = withCurrentWorkflowMetadata(data);
            return;
        }
        if (data != null) {
            if (!z) {
                track(PaywallEventType.CLOSE);
            }
            this.paywallPresentationData = null;
        }
        PaywallEvent.Data dataCreateEventData = createEventData();
        if (dataCreateEventData == null) {
            return;
        }
        this.paywallPresentationData = dataCreateEventData;
        track(PaywallEventType.IMPRESSION);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.m1584e("Paywall event data is null, not tracking exit offer event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, exitOfferType, exitOfferingIdentifier, null, null, null, null, null, null, null, 65151, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.EXIT_OFFER, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        PaywallEvent.Data data2 = this.paywallPresentationData;
        if (data2 == null) {
            if (this.currentWorkflow == null || this.currentWorkflowStepTracksPaywallEvents) {
                Logger.INSTANCE.m1584e("Paywall event data is null, not tracking paywall component interaction");
                return;
            }
            return;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), data2, PaywallEventType.COMPONENT_INTERACTION, data));
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$2 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$2", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {557}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81472 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C81472(Continuation<? super C81472> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C81472(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C81472) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModelImpl.this.performRestore(this) == coroutine_suspended) {
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

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        Object objRunExclusiveAction = runExclusiveAction(new C81472(null), continuation);
        return objRunExclusiveAction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunExclusiveAction : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01dc, code lost:
    
        if (r0 == r5) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0173 A[Catch: PurchasesException -> 0x0060, TryCatch #1 {PurchasesException -> 0x0060, blocks: (B:16:0x0041, B:71:0x0157, B:73:0x0173, B:74:0x0176, B:76:0x017a, B:78:0x0186, B:21:0x0052, B:94:0x01df, B:96:0x01e7, B:98:0x01f3, B:24:0x005b, B:89:0x01cb, B:91:0x01d1, B:99:0x020c, B:101:0x0210, B:103:0x0214, B:105:0x021c), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d1 A[Catch: PurchasesException -> 0x0060, TryCatch #1 {PurchasesException -> 0x0060, blocks: (B:16:0x0041, B:71:0x0157, B:73:0x0173, B:74:0x0176, B:76:0x017a, B:78:0x0186, B:21:0x0052, B:94:0x01df, B:96:0x01e7, B:98:0x01f3, B:24:0x005b, B:89:0x01cb, B:91:0x01d1, B:99:0x020c, B:101:0x0210, B:103:0x0214, B:105:0x021c), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020c A[Catch: PurchasesException -> 0x0060, TryCatch #1 {PurchasesException -> 0x0060, blocks: (B:16:0x0041, B:71:0x0157, B:73:0x0173, B:74:0x0176, B:76:0x017a, B:78:0x0186, B:21:0x0052, B:94:0x01df, B:96:0x01e7, B:98:0x01f3, B:24:0x005b, B:89:0x01cb, B:91:0x01d1, B:99:0x020c, B:101:0x0210, B:103:0x0214, B:105:0x021c), top: B:119:0x0031 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performRestore(Continuation<? super Unit> continuation) {
        C81491 c81491;
        PaywallListener listener;
        Unit unit;
        PaywallViewModelImpl paywallViewModelImpl;
        PaywallViewModelImpl$performRestore$customRestoreHandler$1$1 paywallViewModelImpl$performRestore$customRestoreHandler$1$1;
        int i;
        Function2 function2;
        PaywallViewModelImpl paywallViewModelImpl2;
        PaywallViewModelImpl paywallViewModelImpl3;
        PaywallViewModelImpl paywallViewModelImpl4;
        PurchaseLogicResult purchaseLogicResult;
        PurchasesError errorDetails;
        PaywallListener listener2;
        Function1<CustomerInfo, Boolean> function1;
        PaywallViewModelImpl paywallViewModelImpl5 = "Unsupported purchase completion type: ";
        if (continuation instanceof C81491) {
            c81491 = (C81491) continuation;
            if ((c81491.label & Integer.MIN_VALUE) != 0) {
                c81491.label -= Integer.MIN_VALUE;
            } else {
                c81491 = new C81491(continuation);
            }
        }
        Object objAwaitRestore = c81491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c81491.label;
        try {
        } catch (PurchasesException e) {
            e = e;
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitRestore);
            c81491.L$0 = this;
            c81491.label = 1;
            C81491 c814912 = c81491;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c814912), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Logger.INSTANCE.m1583d("Restore Purchases Initiated… waiting for listener.onRestoreInitiated to proceed.");
            PaywallListener listener3 = getListener();
            if (listener3 != null) {
                listener3.onRestoreInitiated(new Resumable() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performRestore$shouldResume$1$1
                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable
                    public final void resume(boolean z) {
                        CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, Boolean.valueOf(z));
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, Boxing.boxBoolean(true));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c814912);
            }
            if (result != coroutine_suspended) {
                objAwaitRestore = result;
                paywallViewModelImpl = this;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            paywallViewModelImpl = (PaywallViewModelImpl) c81491.L$0;
            ResultKt.throwOnFailure(objAwaitRestore);
        } else if (i2 == 2) {
            function2 = (Function2) c81491.L$1;
            paywallViewModelImpl2 = (PaywallViewModelImpl) c81491.L$0;
            try {
                ResultKt.throwOnFailure(objAwaitRestore);
                c81491.L$0 = paywallViewModelImpl2;
                c81491.L$1 = null;
                c81491.label = 3;
                objAwaitRestore = function2.invoke((CustomerInfo) objAwaitRestore, c81491);
                if (objAwaitRestore != coroutine_suspended) {
                    paywallViewModelImpl4 = paywallViewModelImpl2;
                    purchaseLogicResult = (PurchaseLogicResult) objAwaitRestore;
                    if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                    }
                }
                return coroutine_suspended;
            } catch (PurchasesException e2) {
                e = e2;
                paywallViewModelImpl5 = paywallViewModelImpl2;
                Logger.INSTANCE.m1584e("Error restoring purchases: " + e);
                listener = paywallViewModelImpl5.getListener();
                if (listener != null) {
                    listener.onRestoreError(e.getError());
                }
                paywallViewModelImpl5._actionError.setValue(e.getError());
            }
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    paywallViewModelImpl4 = (PaywallViewModelImpl) c81491.L$0;
                    ResultKt.throwOnFailure(objAwaitRestore);
                    CustomerInfo customerInfo = (CustomerInfo) objAwaitRestore;
                    paywallViewModelImpl4.workflowCompletedInSession = true;
                    Function1<CustomerInfo, Boolean> function12 = paywallViewModelImpl4.shouldDisplayBlock;
                    if (function12 != null && !function12.invoke(customerInfo).booleanValue()) {
                        paywallViewModelImpl4._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                        Logger.INSTANCE.m1583d("Dismissing paywall after restore since display condition has not been met");
                        paywallViewModelImpl4.closePaywall(new PaywallResult.Restored(customerInfo));
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                paywallViewModelImpl3 = (PaywallViewModelImpl) c81491.L$0;
                ResultKt.throwOnFailure(objAwaitRestore);
                CustomerInfo customerInfo2 = (CustomerInfo) objAwaitRestore;
                Logger.INSTANCE.m1586i("Restore purchases successful: " + customerInfo2);
                paywallViewModelImpl3.workflowCompletedInSession = true;
                listener2 = paywallViewModelImpl3.getListener();
                if (listener2 != null) {
                    listener2.onRestoreCompleted(customerInfo2);
                }
                function1 = paywallViewModelImpl3.shouldDisplayBlock;
                if (function1 != null && !function1.invoke(customerInfo2).booleanValue()) {
                    paywallViewModelImpl3._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                    Logger.INSTANCE.m1583d("Dismissing paywall after restore since display condition has not been met");
                    paywallViewModelImpl3.trackCurrentWorkflowStepCompleted();
                    paywallViewModelImpl3.endPresentationSession();
                    paywallViewModelImpl3.options.getDismissRequest().invoke();
                }
                return Unit.INSTANCE;
            }
            paywallViewModelImpl4 = (PaywallViewModelImpl) c81491.L$0;
            ResultKt.throwOnFailure(objAwaitRestore);
            purchaseLogicResult = (PurchaseLogicResult) objAwaitRestore;
            if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                if (!(purchaseLogicResult instanceof PurchaseLogicResult.Cancellation) && (purchaseLogicResult instanceof PurchaseLogicResult.Error) && (errorDetails = ((PurchaseLogicResult.Error) purchaseLogicResult).getErrorDetails()) != null) {
                    paywallViewModelImpl4._actionError.setValue(errorDetails);
                }
                return Unit.INSTANCE;
            }
            PurchasesType purchasesType = paywallViewModelImpl4.purchases;
            c81491.L$0 = paywallViewModelImpl4;
            c81491.label = 4;
            objAwaitRestore = purchasesType.awaitSyncPurchases(c81491);
        }
        boolean zBooleanValue = ((Boolean) objAwaitRestore).booleanValue();
        Logger.INSTANCE.m1583d("Restore Purchases gate complete. The SDK **" + (zBooleanValue ? "will" : "will not") + "** attempt to restore purchases.");
        if (!zBooleanValue) {
            return Unit.INSTANCE;
        }
        try {
            PaywallPurchaseLogic purchaseLogic = paywallViewModelImpl.getPurchaseLogic();
            paywallViewModelImpl$performRestore$customRestoreHandler$1$1 = purchaseLogic != null ? new PaywallViewModelImpl$performRestore$customRestoreHandler$1$1(purchaseLogic) : null;
            i = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl.purchases.getPurchasesAreCompletedBy().ordinal()];
        } catch (PurchasesException e3) {
            e = e3;
            paywallViewModelImpl5 = paywallViewModelImpl;
            Logger.INSTANCE.m1584e("Error restoring purchases: " + e);
            listener = paywallViewModelImpl5.getListener();
            if (listener != null) {
            }
            paywallViewModelImpl5._actionError.setValue(e.getError());
        }
        if (i != 1) {
            if (i != 2) {
                Logger.INSTANCE.m1584e("Unsupported purchase completion type: " + paywallViewModelImpl.purchases.getPurchasesAreCompletedBy());
                return Unit.INSTANCE;
            }
            PaywallListener listener4 = paywallViewModelImpl.getListener();
            if (listener4 != null) {
                listener4.onRestoreStarted();
            }
            if (paywallViewModelImpl$performRestore$customRestoreHandler$1$1 != null) {
                Logger.INSTANCE.m1587w("myAppPurchaseLogic expected be null when purchases.purchasesAreCompletedBy is .REVENUECAT.\nmyAppPurchaseLogic.performRestore will not be executed.");
            }
            PurchasesType purchasesType2 = paywallViewModelImpl.purchases;
            c81491.L$0 = paywallViewModelImpl;
            c81491.label = 5;
            objAwaitRestore = purchasesType2.awaitRestore(c81491);
            if (objAwaitRestore != coroutine_suspended) {
                paywallViewModelImpl3 = paywallViewModelImpl;
                CustomerInfo customerInfo22 = (CustomerInfo) objAwaitRestore;
                Logger.INSTANCE.m1586i("Restore purchases successful: " + customerInfo22);
                paywallViewModelImpl3.workflowCompletedInSession = true;
                listener2 = paywallViewModelImpl3.getListener();
                if (listener2 != null) {
                }
                function1 = paywallViewModelImpl3.shouldDisplayBlock;
                if (function1 != null) {
                    paywallViewModelImpl3._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                    Logger.INSTANCE.m1583d("Dismissing paywall after restore since display condition has not been met");
                    paywallViewModelImpl3.trackCurrentWorkflowStepCompleted();
                    paywallViewModelImpl3.endPresentationSession();
                    paywallViewModelImpl3.options.getDismissRequest().invoke();
                }
                return Unit.INSTANCE;
            }
        } else {
            if (paywallViewModelImpl$performRestore$customRestoreHandler$1$1 == null) {
                throw new IllegalStateException("myAppPurchaseLogic must not be null when purchases.purchasesAreCompletedBy is PurchasesAreCompletedBy.MY_APP".toString());
            }
            PurchasesType purchasesType3 = paywallViewModelImpl.purchases;
            c81491.L$0 = paywallViewModelImpl;
            c81491.L$1 = paywallViewModelImpl$performRestore$customRestoreHandler$1$1;
            c81491.label = 2;
            Object objAwaitCustomerInfo$default = PurchasesType.awaitCustomerInfo$default(purchasesType3, null, c81491, 1, null);
            if (objAwaitCustomerInfo$default != coroutine_suspended) {
                function2 = paywallViewModelImpl$performRestore$customRestoreHandler$1$1;
                objAwaitRestore = objAwaitCustomerInfo$default;
                paywallViewModelImpl2 = paywallViewModelImpl;
                c81491.L$0 = paywallViewModelImpl2;
                c81491.L$1 = null;
                c81491.label = 3;
                objAwaitRestore = function2.invoke((CustomerInfo) objAwaitRestore, c81491);
                if (objAwaitRestore != coroutine_suspended) {
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handlePackagePurchase$2 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handlePackagePurchase$2", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {652}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81462 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Package $pkg;
        final /* synthetic */ ResolvedOffer $resolvedOffer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C81462(Activity activity, Package r3, ResolvedOffer resolvedOffer, Continuation<? super C81462> continuation) {
            super(1, continuation);
            this.$activity = activity;
            this.$pkg = r3;
            this.$resolvedOffer = resolvedOffer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C81462(this.$activity, this.$pkg, this.$resolvedOffer, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C81462) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModelImpl.this.performPackagePurchase(this.$activity, this.$pkg, this.$resolvedOffer, this) == coroutine_suspended) {
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

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handlePackagePurchase(Activity activity, Package r8, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        Object objRunExclusiveAction = runExclusiveAction(new C81462(activity, r8, resolvedOffer, null), continuation);
        return objRunExclusiveAction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunExclusiveAction : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPackagePurchase(Activity activity, Package r10, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo;
        PaywallComponentsData dataOrNull;
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Legacy) {
            Object objPerformPurchase$default = performPurchase$default(this, activity, ((PaywallState.Loaded.Legacy) value).getSelectedPackage().getValue().getRcPackage(), null, null, continuation, 4, null);
            return objPerformPurchase$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformPurchase$default : Unit.INSTANCE;
        }
        if (value instanceof PaywallState.Loaded.Components) {
            if (r10 != null) {
                selectedPackageInfo = new PaywallState.Loaded.Components.SelectedPackageInfo(r10, resolvedOffer, r10.getIdentifier(), PackageExtensionsKt.calculateOfferEligibility(resolvedOffer, r10));
            } else {
                selectedPackageInfo = ((PaywallState.Loaded.Components) value).getSelectedPackageInfo();
            }
            Offering.PaywallComponents paywallComponents = ((PaywallState.Loaded.Components) value).getOffering().getPaywallComponents();
            Object objPerformPurchaseIfNecessary = performPurchaseIfNecessary(activity, selectedPackageInfo, (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) ? null : dataOrNull.getProductChangeConfig(), continuation);
            return objPerformPurchaseIfNecessary == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformPurchaseIfNecessary : Unit.INSTANCE;
        }
        if (value instanceof PaywallState.Error ? true : value instanceof PaywallState.Loading) {
            Logger.INSTANCE.m1584e("Unexpected state trying to purchase package: " + value);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPurchaseIfNecessary(Activity activity, PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, ProductChangeConfig productChangeConfig, Continuation<? super Unit> continuation) {
        if (selectedPackageInfo == null) {
            Logger.INSTANCE.m1587w("Ignoring purchase request as no package is selected");
            return Unit.INSTANCE;
        }
        Package rcPackage = selectedPackageInfo.getRcPackage();
        ResolvedOffer resolvedOffer = selectedPackageInfo.getResolvedOffer();
        Object objPerformPurchase = performPurchase(activity, rcPackage, productChangeConfig, resolvedOffer != null ? resolvedOffer.getSubscriptionOption() : null, continuation);
        return objPerformPurchase == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformPurchase : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0262, code lost:
    
        if (r2 == r6) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:77:0x01e6, B:79:0x01fa, B:80:0x0205, B:21:0x0060, B:96:0x0265, B:24:0x006f, B:91:0x024f, B:93:0x0255, B:97:0x0283, B:99:0x0287, B:100:0x028b, B:102:0x028f, B:104:0x0297), top: B:123:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021b A[Catch: PurchasesException -> 0x02ac, TRY_ENTER, TryCatch #2 {PurchasesException -> 0x02ac, blocks: (B:55:0x013a, B:57:0x013e, B:61:0x0153, B:62:0x016d, B:64:0x0173, B:65:0x0176, B:67:0x017c, B:69:0x0185, B:72:0x019a, B:73:0x01cd, B:70:0x0193, B:82:0x021b, B:85:0x0223, B:87:0x0234, B:106:0x02a0, B:107:0x02ab, B:50:0x011e, B:52:0x0123), top: B:124:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0255 A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:77:0x01e6, B:79:0x01fa, B:80:0x0205, B:21:0x0060, B:96:0x0265, B:24:0x006f, B:91:0x024f, B:93:0x0255, B:97:0x0283, B:99:0x0287, B:100:0x028b, B:102:0x028f, B:104:0x0297), top: B:123:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0283 A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:77:0x01e6, B:79:0x01fa, B:80:0x0205, B:21:0x0060, B:96:0x0265, B:24:0x006f, B:91:0x024f, B:93:0x0255, B:97:0x0283, B:99:0x0287, B:100:0x028b, B:102:0x028f, B:104:0x0297), top: B:123:0x0033 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performPurchase(Activity activity, Package r19, ProductChangeConfig productChangeConfig, SubscriptionOption subscriptionOption, Continuation<? super Unit> continuation) {
        C81481 c81481;
        ProductChangeConfig productChangeConfig2;
        int i;
        Unit unit;
        Package r10;
        SubscriptionOption subscriptionOption2;
        PaywallViewModelImpl paywallViewModelImpl;
        Activity activity2;
        ProductChangeInfo productChangeInfo;
        int i2;
        Package r3;
        PaywallViewModelImpl paywallViewModelImpl2;
        PaywallViewModelImpl paywallViewModelImpl3;
        PurchaseLogicResult purchaseLogicResult;
        PurchasesError errorDetails;
        PaywallListener listener;
        Package r32 = "Performing product change from ";
        PaywallViewModelImpl paywallViewModelImpl4 = "Unsupported purchase completion type: ";
        if (continuation instanceof C81481) {
            c81481 = (C81481) continuation;
            if ((c81481.label & Integer.MIN_VALUE) != 0) {
                c81481.label -= Integer.MIN_VALUE;
            } else {
                c81481 = new C81481(continuation);
            }
        }
        Object objCalculateProductChangeInfo = c81481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c81481.label;
        try {
        } catch (PurchasesException e) {
            e = e;
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            c81481.L$0 = this;
            c81481.L$1 = activity;
            c81481.L$2 = r19;
            productChangeConfig2 = productChangeConfig;
            c81481.L$3 = productChangeConfig2;
            c81481.L$4 = subscriptionOption;
            c81481.label = 1;
            C81481 c814812 = c81481;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c814812), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            i = 1;
            PaywallListener listener2 = getListener();
            if (listener2 != null) {
                listener2.onPurchasePackageInitiated(r19, new Resumable() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$shouldResume$1$1
                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable
                    public final void resume(boolean z) {
                        CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, Boolean.valueOf(z));
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, Boxing.boxBoolean(true));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c814812);
            }
            if (result != coroutine_suspended) {
                r10 = r19;
                subscriptionOption2 = subscriptionOption;
                paywallViewModelImpl = this;
                activity2 = activity;
                objCalculateProductChangeInfo = result;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            subscriptionOption2 = (SubscriptionOption) c81481.L$4;
            productChangeConfig2 = (ProductChangeConfig) c81481.L$3;
            r10 = (Package) c81481.L$2;
            activity2 = (Activity) c81481.L$1;
            paywallViewModelImpl = (PaywallViewModelImpl) c81481.L$0;
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            i = 1;
        } else {
            if (i3 == 2) {
                subscriptionOption2 = (SubscriptionOption) c81481.L$3;
                Package r7 = (Package) c81481.L$2;
                activity2 = (Activity) c81481.L$1;
                PaywallViewModelImpl paywallViewModelImpl5 = (PaywallViewModelImpl) c81481.L$0;
                try {
                    ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                    paywallViewModelImpl = paywallViewModelImpl5;
                    i = 1;
                    r10 = r7;
                    productChangeInfo = (ProductChangeInfo) objCalculateProductChangeInfo;
                    i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl.purchases.getPurchasesAreCompletedBy().ordinal()];
                } catch (PurchasesException e2) {
                    e = e2;
                    r32 = r7;
                    paywallViewModelImpl4 = paywallViewModelImpl5;
                    if (e.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
                        paywallViewModelImpl4.trackPaywallCancel();
                        PaywallListener listener3 = paywallViewModelImpl4.getListener();
                        if (listener3 != null) {
                            listener3.onPurchaseCancelled();
                        }
                    } else {
                        paywallViewModelImpl4.trackPaywallPurchaseError(r32, e.getError());
                        PaywallListener listener4 = paywallViewModelImpl4.getListener();
                        if (listener4 != null) {
                            listener4.onPurchaseError(e.getError());
                        }
                        paywallViewModelImpl4._actionError.setValue(e.getError());
                    }
                }
                if (i2 == i) {
                    PaywallPurchaseLogic purchaseLogic = paywallViewModelImpl.getPurchaseLogic();
                    if (purchaseLogic == null) {
                        throw new IllegalStateException("myAppPurchaseLogic must not be null when purchases.purchasesAreCompletedBy is PurchasesAreCompletedBy.MY_APP".toString());
                    }
                    PaywallPurchaseLogicParams paywallPurchaseLogicParams = new PaywallPurchaseLogicParams(r10, productChangeInfo != null ? new ProductChange(productChangeInfo.getOldProductId(), productChangeInfo.getReplacementMode()) : null, subscriptionOption2);
                    c81481.L$0 = paywallViewModelImpl;
                    c81481.L$1 = r10;
                    c81481.L$2 = null;
                    c81481.L$3 = null;
                    c81481.L$4 = null;
                    c81481.label = 3;
                    objCalculateProductChangeInfo = purchaseLogic.performPurchase(activity2, paywallPurchaseLogicParams, c81481);
                    if (objCalculateProductChangeInfo != coroutine_suspended) {
                        r3 = r10;
                        paywallViewModelImpl2 = paywallViewModelImpl;
                        purchaseLogicResult = (PurchaseLogicResult) objCalculateProductChangeInfo;
                        if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                        }
                    }
                } else {
                    if (i2 != 2) {
                        Logger.INSTANCE.m1584e("Unsupported purchase completion type: " + paywallViewModelImpl.purchases.getPurchasesAreCompletedBy());
                        return Unit.INSTANCE;
                    }
                    PaywallListener listener5 = paywallViewModelImpl.getListener();
                    if (listener5 != null) {
                        listener5.onPurchaseStarted(r10);
                    }
                    if (paywallViewModelImpl.getPurchaseLogic() != null) {
                        Logger.INSTANCE.m1584e("myAppPurchaseLogic expected to be null when purchases.purchasesAreCompletedBy is .REVENUECAT. \nmyAppPurchaseLogic.performPurchase will not be executed.");
                    }
                    PurchaseParams.Builder builderPresentedOfferingContext = subscriptionOption2 != null ? new PurchaseParams.Builder(activity2, subscriptionOption2).presentedOfferingContext(r10.getPresentedOfferingContext()) : new PurchaseParams.Builder(activity2, r10);
                    if (productChangeInfo != null) {
                        Logger.INSTANCE.m1583d("Performing product change from " + productChangeInfo.getOldProductId() + " with mode " + productChangeInfo.getReplacementMode());
                        builderPresentedOfferingContext.oldProductId(productChangeInfo.getOldProductId()).replacementMode(productChangeInfo.getReplacementMode());
                    }
                    PurchasesType purchasesType = paywallViewModelImpl.purchases;
                    c81481.L$0 = paywallViewModelImpl;
                    c81481.L$1 = r10;
                    c81481.L$2 = null;
                    c81481.L$3 = null;
                    c81481.L$4 = null;
                    c81481.label = 5;
                    objCalculateProductChangeInfo = purchasesType.awaitPurchase(builderPresentedOfferingContext, c81481);
                    if (objCalculateProductChangeInfo != coroutine_suspended) {
                        paywallViewModelImpl3 = paywallViewModelImpl;
                        PurchaseResult purchaseResult = (PurchaseResult) objCalculateProductChangeInfo;
                        paywallViewModelImpl3._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                        paywallViewModelImpl3.workflowCompletedInSession = true;
                        listener = paywallViewModelImpl3.getListener();
                        if (listener != null) {
                        }
                        Logger.INSTANCE.m1583d("Dismissing paywall after purchase");
                        paywallViewModelImpl3.trackCurrentWorkflowStepCompleted();
                        paywallViewModelImpl3.endPresentationSession();
                        paywallViewModelImpl3.options.getDismissRequest().invoke();
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    paywallViewModelImpl2 = (PaywallViewModelImpl) c81481.L$0;
                    ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                    paywallViewModelImpl2._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                    paywallViewModelImpl2.workflowCompletedInSession = true;
                    Logger.INSTANCE.m1583d("Dismissing paywall after purchase");
                    paywallViewModelImpl2.closePaywall(new PaywallResult.Purchased((CustomerInfo) objCalculateProductChangeInfo));
                    return Unit.INSTANCE;
                }
                if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                paywallViewModelImpl3 = (PaywallViewModelImpl) c81481.L$0;
                ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                PurchaseResult purchaseResult2 = (PurchaseResult) objCalculateProductChangeInfo;
                paywallViewModelImpl3._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                paywallViewModelImpl3.workflowCompletedInSession = true;
                listener = paywallViewModelImpl3.getListener();
                if (listener != null) {
                    listener.onPurchaseCompleted(purchaseResult2.getCustomerInfo(), purchaseResult2.getStoreTransaction());
                }
                Logger.INSTANCE.m1583d("Dismissing paywall after purchase");
                paywallViewModelImpl3.trackCurrentWorkflowStepCompleted();
                paywallViewModelImpl3.endPresentationSession();
                paywallViewModelImpl3.options.getDismissRequest().invoke();
                return Unit.INSTANCE;
            }
            r3 = (Package) c81481.L$1;
            paywallViewModelImpl2 = (PaywallViewModelImpl) c81481.L$0;
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            purchaseLogicResult = (PurchaseLogicResult) objCalculateProductChangeInfo;
            if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                if (purchaseLogicResult instanceof PurchaseLogicResult.Cancellation) {
                    paywallViewModelImpl2.trackPaywallCancel();
                } else if ((purchaseLogicResult instanceof PurchaseLogicResult.Error) && (errorDetails = ((PurchaseLogicResult.Error) purchaseLogicResult).getErrorDetails()) != null) {
                    paywallViewModelImpl2.trackPaywallPurchaseError(r3, errorDetails);
                    paywallViewModelImpl2._actionError.setValue(errorDetails);
                }
                return Unit.INSTANCE;
            }
            PurchasesType purchasesType2 = paywallViewModelImpl2.purchases;
            c81481.L$0 = paywallViewModelImpl2;
            c81481.L$1 = r3;
            c81481.label = 4;
            objCalculateProductChangeInfo = purchasesType2.awaitSyncPurchases(c81481);
        }
        if (!((Boolean) objCalculateProductChangeInfo).booleanValue()) {
            Logger.INSTANCE.m1583d("Purchase cancelled listener.onPurchasePackageInitiated returned false");
            return Unit.INSTANCE;
        }
        try {
            paywallViewModelImpl.trackPaywallPurchaseInitiated(r10);
            if (productChangeConfig2 == null) {
                productChangeInfo = null;
                i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl.purchases.getPurchasesAreCompletedBy().ordinal()];
                if (i2 == i) {
                }
                return coroutine_suspended;
            }
            ProductChangeCalculator productChangeCalculator = paywallViewModelImpl.productChangeCalculator;
            c81481.L$0 = paywallViewModelImpl;
            c81481.L$1 = activity2;
            c81481.L$2 = r10;
            c81481.L$3 = subscriptionOption2;
            c81481.L$4 = null;
            c81481.label = 2;
            objCalculateProductChangeInfo = productChangeCalculator.calculateProductChangeInfo(r10, productChangeConfig2, c81481);
            if (objCalculateProductChangeInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            productChangeInfo = (ProductChangeInfo) objCalculateProductChangeInfo;
            i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl.purchases.getPurchasesAreCompletedBy().ordinal()];
            if (i2 == i) {
            }
            return coroutine_suspended;
        } catch (PurchasesException e3) {
            e = e3;
            r32 = r10;
            paywallViewModelImpl4 = paywallViewModelImpl;
            if (e.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
            }
        }
    }

    static /* synthetic */ Object performPurchase$default(PaywallViewModelImpl paywallViewModelImpl, Activity activity, Package r8, ProductChangeConfig productChangeConfig, SubscriptionOption subscriptionOption, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            productChangeConfig = null;
        }
        return paywallViewModelImpl.performPurchase(activity, r8, productChangeConfig, subscriptionOption, continuation);
    }

    private final void validateState() {
        if (this.purchases.getPurchasesAreCompletedBy() == PurchasesAreCompletedBy.MY_APP && this.options.getPurchaseLogic() == null) {
            this._state.setValue(new PaywallState.Error("myAppPurchaseLogic is null, but is required when purchases.purchasesAreCompletedBy is .MY_APP. App purchases will not be successful."));
        }
    }

    private final void updateState() {
        if (this.shouldReloadStateOnNextPresentation) {
            return;
        }
        cancelStateUpdate();
        this.updateStateJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81571(null), 3, null);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {832}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C81571(Continuation<? super C81571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C81571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PaywallViewModelImpl paywallViewModelImpl = PaywallViewModelImpl.this;
                    this.label = 1;
                    if (paywallViewModelImpl.updateStateFromOffering(paywallViewModelImpl.options.getOfferingSelection(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (PurchasesException e) {
                PaywallViewModelImpl.this.updateExitOfferData(new ExitOfferData.Unavailable(false, i2, null));
                PaywallViewModelImpl.this._state.setValue(new PaywallState.Error("Error " + e.getCode().getCode() + ": " + e.getCode().getDescription()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateStateFromOffering(OfferingSelection offeringSelection, Continuation<? super Unit> continuation) throws PurchasesException {
        C81581 c81581;
        PaywallViewModelImpl paywallViewModelImpl;
        Offering selectedOffering;
        Offerings offerings;
        PaywallViewModelImpl paywallViewModelImpl2;
        Offerings offerings2;
        Offering offering;
        DefaultConstructorMarker defaultConstructorMarker;
        String offeringId;
        ExitOfferData.Unavailable unavailable;
        Offering.PaywallComponents paywallComponents;
        PaywallComponentsData dataOrNull;
        ExitOffers exitOffers;
        ExitOffer dismiss;
        WorkflowOutcome workflowOutcome;
        if (continuation instanceof C81581) {
            c81581 = (C81581) continuation;
            if ((c81581.label & Integer.MIN_VALUE) != 0) {
                c81581.label -= Integer.MIN_VALUE;
            } else {
                c81581 = new C81581(continuation);
            }
        }
        Object objResolveOfferingSelection = c81581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81581.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveOfferingSelection);
            if (presentInjectedWorkflowIfNeeded(offeringSelection)) {
                return Unit.INSTANCE;
            }
            c81581.L$0 = this;
            c81581.label = 1;
            objResolveOfferingSelection = resolveOfferingSelection(offeringSelection, c81581);
            if (objResolveOfferingSelection != coroutine_suspended) {
                paywallViewModelImpl = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            offerings2 = (Offerings) c81581.L$2;
            offering = (Offering) c81581.L$1;
            paywallViewModelImpl2 = (PaywallViewModelImpl) c81581.L$0;
            ResultKt.throwOnFailure(objResolveOfferingSelection);
            workflowOutcome = (WorkflowOutcome) objResolveOfferingSelection;
            if (!Intrinsics.areEqual(workflowOutcome, WorkflowOutcome.Presented.INSTANCE)) {
                return Unit.INSTANCE;
            }
            if (workflowOutcome instanceof WorkflowOutcome.Fallback) {
                WorkflowOutcome.Fallback fallback = (WorkflowOutcome.Fallback) workflowOutcome;
                selectedOffering = fallback.getOffering();
                offerings = fallback.getOfferings();
                paywallViewModelImpl = paywallViewModelImpl2;
            } else {
                offerings = offerings2;
                paywallViewModelImpl = paywallViewModelImpl2;
                selectedOffering = offering;
            }
            defaultConstructorMarker = null;
            offeringId = (selectedOffering != null || (paywallComponents = selectedOffering.getPaywallComponents()) == null || (dataOrNull = paywallComponents.getDataOrNull()) == null || (exitOffers = dataOrNull.getExitOffers()) == null || (dismiss = exitOffers.getDismiss()) == null) ? null : dismiss.getOfferingId();
            if (offeringId == null && offerings != null) {
                unavailable = new ExitOfferData.Configured(offeringId, offerings, null, false, null, 28, null);
            } else {
                unavailable = new ExitOfferData.Unavailable(false, i2, defaultConstructorMarker);
            }
            paywallViewModelImpl.updateExitOfferData(unavailable);
            paywallViewModelImpl.updatePaywallState(selectedOffering);
            return Unit.INSTANCE;
        }
        paywallViewModelImpl = (PaywallViewModelImpl) c81581.L$0;
        ResultKt.throwOnFailure(objResolveOfferingSelection);
        ResolvedOfferingSelection resolvedOfferingSelection = (ResolvedOfferingSelection) objResolveOfferingSelection;
        selectedOffering = resolvedOfferingSelection.getSelectedOffering();
        Offerings offeringsForExitOfferLookup = resolvedOfferingSelection.getOfferingsForExitOfferLookup();
        if (selectedOffering != null && selectedOffering.getPaywall() == null) {
            c81581.L$0 = paywallViewModelImpl;
            c81581.L$1 = selectedOffering;
            c81581.L$2 = offeringsForExitOfferLookup;
            c81581.label = 2;
            Object objPresentWorkflowOrResolveFallback = paywallViewModelImpl.presentWorkflowOrResolveFallback(selectedOffering, offeringsForExitOfferLookup, c81581);
            if (objPresentWorkflowOrResolveFallback != coroutine_suspended) {
                paywallViewModelImpl2 = paywallViewModelImpl;
                offerings2 = offeringsForExitOfferLookup;
                objResolveOfferingSelection = objPresentWorkflowOrResolveFallback;
                offering = selectedOffering;
                workflowOutcome = (WorkflowOutcome) objResolveOfferingSelection;
                if (!Intrinsics.areEqual(workflowOutcome, WorkflowOutcome.Presented.INSTANCE)) {
                }
            }
            return coroutine_suspended;
        }
        offerings = offeringsForExitOfferLookup;
        defaultConstructorMarker = null;
        if (selectedOffering != null) {
        }
        if (offeringId == null) {
            unavailable = new ExitOfferData.Unavailable(false, i2, defaultConstructorMarker);
        }
        paywallViewModelImpl.updateExitOfferData(unavailable);
        paywallViewModelImpl.updatePaywallState(selectedOffering);
        return Unit.INSTANCE;
    }

    private final boolean presentInjectedWorkflowIfNeeded(OfferingSelection offeringSelection) {
        Map mapEmptyMap;
        PublishedWorkflow injectedWorkflow = this.options.getInjectedWorkflow();
        if (injectedWorkflow == null) {
            return false;
        }
        Offering offering = offeringSelection.getOffering();
        if (offering == null) {
            Logger.INSTANCE.m1587w("Paywalls: injectedWorkflow set without a concrete Offering (use setOffering); workflow screens may fail to resolve their packages.");
        }
        if (offering == null || (mapEmptyMap = MapsKt.mapOf(TuplesKt.m1606to(offering.getIdentifier(), offering))) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        startWorkflowPresentation(injectedWorkflow, this.options.getInjectedWorkflowUiConfig(), new Offerings(offering, mapEmptyMap), offering != null ? offering.getPresentedOfferingContext() : null);
        return true;
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome;", "", "Fallback", "Presented", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome$Fallback;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome$Presented;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private interface WorkflowOutcome {

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome$Presented;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Presented implements WorkflowOutcome {
            public static final int $stable = 0;
            public static final Presented INSTANCE = new Presented();

            private Presented() {
            }
        }

        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome$Fallback;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl$WorkflowOutcome;", "offering", "Lcom/revenuecat/purchases/Offering;", "offerings", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/Offerings;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "getOfferings", "()Lcom/revenuecat/purchases/Offerings;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Fallback implements WorkflowOutcome {
            public static final int $stable = 8;
            private final Offering offering;
            private final Offerings offerings;

            public static /* synthetic */ Fallback copy$default(Fallback fallback, Offering offering, Offerings offerings, int i, Object obj) {
                if ((i & 1) != 0) {
                    offering = fallback.offering;
                }
                if ((i & 2) != 0) {
                    offerings = fallback.offerings;
                }
                return fallback.copy(offering, offerings);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Offering getOffering() {
                return this.offering;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Offerings getOfferings() {
                return this.offerings;
            }

            public final Fallback copy(Offering offering, Offerings offerings) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                return new Fallback(offering, offerings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fallback)) {
                    return false;
                }
                Fallback fallback = (Fallback) other;
                return Intrinsics.areEqual(this.offering, fallback.offering) && Intrinsics.areEqual(this.offerings, fallback.offerings);
            }

            public int hashCode() {
                int iHashCode = this.offering.hashCode() * 31;
                Offerings offerings = this.offerings;
                return iHashCode + (offerings == null ? 0 : offerings.hashCode());
            }

            public String toString() {
                return "Fallback(offering=" + this.offering + ", offerings=" + this.offerings + ')';
            }

            public Fallback(Offering offering, Offerings offerings) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                this.offering = offering;
                this.offerings = offerings;
            }

            public final Offering getOffering() {
                return this.offering;
            }

            public final Offerings getOfferings() {
                return this.offerings;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        if (r7.presentWorkflow(r2, r8, r9, r0) == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object presentWorkflowOrResolveFallback(Offering offering, Offerings offerings, Continuation<? super WorkflowOutcome> continuation) throws PurchasesException {
        C81521 c81521;
        Object obj;
        Offerings offerings2;
        Offering offering2;
        PaywallViewModelImpl paywallViewModelImpl;
        if (continuation instanceof C81521) {
            c81521 = (C81521) continuation;
            if ((c81521.label & Integer.MIN_VALUE) != 0) {
                c81521.label -= Integer.MIN_VALUE;
            } else {
                c81521 = new C81521(continuation);
            }
        }
        Object obj2 = c81521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81521.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                PurchasesType purchasesType = this.purchases;
                String identifier = offering.getIdentifier();
                c81521.L$0 = this;
                c81521.L$1 = offering;
                c81521.L$2 = offerings;
                c81521.label = 1;
                Object objResolveWorkflow = purchasesType.resolveWorkflow(identifier, c81521);
                if (objResolveWorkflow != coroutine_suspended) {
                    obj = objResolveWorkflow;
                    offerings2 = offerings;
                    offering2 = offering;
                    paywallViewModelImpl = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                return WorkflowOutcome.Presented.INSTANCE;
            }
            Offerings offerings3 = (Offerings) c81521.L$2;
            Offering offering3 = (Offering) c81521.L$1;
            PaywallViewModelImpl paywallViewModelImpl2 = (PaywallViewModelImpl) c81521.L$0;
            ResultKt.throwOnFailure(obj2);
            offering2 = offering3;
            paywallViewModelImpl = paywallViewModelImpl2;
            obj = obj2;
            offerings2 = offerings3;
            WorkflowResolution workflowResolution = (WorkflowResolution) obj;
            if (workflowResolution instanceof WorkflowResolution.Found) {
                String workflowId = ((WorkflowResolution.Found) workflowResolution).getWorkflowId();
                c81521.L$0 = paywallViewModelImpl;
                c81521.L$1 = null;
                c81521.L$2 = null;
                c81521.label = 2;
            } else {
                if (Intrinsics.areEqual(workflowResolution, WorkflowResolution.NoWorkflow.INSTANCE)) {
                    paywallViewModelImpl.clearWorkflowState();
                    return new WorkflowOutcome.Fallback(offering2, offerings2);
                }
                if (!Intrinsics.areEqual(workflowResolution, WorkflowResolution.Unavailable.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.INSTANCE.m1587w("Paywalls: Workflows topic unavailable for offering '" + offering2.getIdentifier() + "' (transient failure). Falling back to the default paywall.");
                paywallViewModelImpl.clearWorkflowState();
                return new WorkflowOutcome.Fallback(offering2, offerings2);
            }
        } catch (PurchasesException e) {
            offering.clearWorkflowState();
            throw e;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$presentWorkflow$2 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$presentWorkflow$2", m1609f = "PaywallViewModel.kt", m1610i = {0, 0, 1}, m1611l = {966, 967, 968}, m1612m = "invokeSuspend", m1613n = {"uiConfigDeferred", "offeringsDeferred", "offeringsDeferred"}, m1615s = {"L$0", "L$1", "L$0"})
    static final class C81512 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offering $offering;
        final /* synthetic */ Offerings $preloadedOfferings;
        final /* synthetic */ String $workflowId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C81512(Offering offering, String str, Offerings offerings, Continuation<? super C81512> continuation) {
            super(2, continuation);
            this.$offering = offering;
            this.$workflowId = str;
            this.$preloadedOfferings = offerings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C81512 c81512 = PaywallViewModelImpl.this.new C81512(this.$offering, this.$workflowId, this.$preloadedOfferings, continuation);
            c81512.L$0 = obj;
            return c81512;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81512) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Deferred deferred;
            Deferred deferred2;
            PaywallViewModelImpl paywallViewModelImpl;
            PublishedWorkflow publishedWorkflow;
            PaywallViewModelImpl paywallViewModelImpl2;
            Object objAwait;
            UiConfig uiConfig;
            PaywallViewModelImpl paywallViewModelImpl3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1(PaywallViewModelImpl.this, this.$workflowId, null), 3, null);
                Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PaywallViewModelImpl$presentWorkflow$2$uiConfigDeferred$1(PaywallViewModelImpl.this, null), 3, null);
                Deferred deferredAsync$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1(this.$preloadedOfferings, PaywallViewModelImpl.this, null), 3, null);
                PaywallViewModelImpl paywallViewModelImpl4 = PaywallViewModelImpl.this;
                this.L$0 = deferredAsync$default2;
                this.L$1 = deferredAsync$default3;
                this.L$2 = paywallViewModelImpl4;
                this.label = 1;
                obj = deferredAsync$default.await(this);
                if (obj != coroutine_suspended) {
                    deferred = deferredAsync$default3;
                    deferred2 = deferredAsync$default2;
                    paywallViewModelImpl = paywallViewModelImpl4;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    uiConfig = (UiConfig) this.L$2;
                    publishedWorkflow = (PublishedWorkflow) this.L$1;
                    paywallViewModelImpl3 = (PaywallViewModelImpl) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    paywallViewModelImpl3.startWorkflowPresentation(publishedWorkflow, uiConfig, (Offerings) obj, this.$offering.getPresentedOfferingContext());
                    return Unit.INSTANCE;
                }
                publishedWorkflow = (PublishedWorkflow) this.L$2;
                paywallViewModelImpl2 = (PaywallViewModelImpl) this.L$1;
                deferred = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                UiConfig uiConfig2 = (UiConfig) obj;
                this.L$0 = paywallViewModelImpl2;
                this.L$1 = publishedWorkflow;
                this.L$2 = uiConfig2;
                this.label = 3;
                objAwait = deferred.await(this);
                if (objAwait != coroutine_suspended) {
                    uiConfig = uiConfig2;
                    obj = objAwait;
                    paywallViewModelImpl3 = paywallViewModelImpl2;
                    paywallViewModelImpl3.startWorkflowPresentation(publishedWorkflow, uiConfig, (Offerings) obj, this.$offering.getPresentedOfferingContext());
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            paywallViewModelImpl = (PaywallViewModelImpl) this.L$2;
            deferred = (Deferred) this.L$1;
            deferred2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            PublishedWorkflow publishedWorkflow2 = (PublishedWorkflow) obj;
            this.L$0 = deferred;
            this.L$1 = paywallViewModelImpl;
            this.L$2 = publishedWorkflow2;
            this.label = 2;
            Object objAwait2 = deferred2.await(this);
            if (objAwait2 != coroutine_suspended) {
                PaywallViewModelImpl paywallViewModelImpl5 = paywallViewModelImpl;
                publishedWorkflow = publishedWorkflow2;
                obj = objAwait2;
                paywallViewModelImpl2 = paywallViewModelImpl5;
                UiConfig uiConfig22 = (UiConfig) obj;
                this.L$0 = paywallViewModelImpl2;
                this.L$1 = publishedWorkflow;
                this.L$2 = uiConfig22;
                this.label = 3;
                objAwait = deferred.await(this);
                if (objAwait != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object presentWorkflow(String str, Offering offering, Offerings offerings, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C81512(offering, str, offerings, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bf, code lost:
    
        if (r9 == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f6, code lost:
    
        if (r9 == r1) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveOfferingSelection(OfferingSelection offeringSelection, Continuation<? super ResolvedOfferingSelection> continuation) {
        C81541 c81541;
        PaywallComponentsData dataOrNull;
        ExitOffers exitOffers;
        ExitOffer dismiss;
        if (continuation instanceof C81541) {
            c81541 = (C81541) continuation;
            if ((c81541.label & Integer.MIN_VALUE) != 0) {
                c81541.label -= Integer.MIN_VALUE;
            } else {
                c81541 = new C81541(continuation);
            }
        }
        Object objAwaitOfferings = c81541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81541.label;
        Offerings offerings = null;
        offerings = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAwaitOfferings);
                if (offeringSelection instanceof OfferingSelection.OfferingType) {
                    Offering.PaywallComponents paywallComponents = ((OfferingSelection.OfferingType) offeringSelection).getOfferingType().getPaywallComponents();
                    if (((paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null || (exitOffers = dataOrNull.getExitOffers()) == null || (dismiss = exitOffers.getDismiss()) == null) ? null : dismiss.getOfferingId()) != null) {
                        PurchasesType purchasesType = this.purchases;
                        c81541.L$0 = offeringSelection;
                        c81541.label = 1;
                        objAwaitOfferings = purchasesType.awaitOfferings(c81541);
                        if (objAwaitOfferings == coroutine_suspended) {
                        }
                        offerings = (Offerings) objAwaitOfferings;
                    }
                } else if (offeringSelection instanceof OfferingSelection.IdAndPresentedOfferingContext) {
                    PurchasesType purchasesType2 = this.purchases;
                    c81541.L$0 = offeringSelection;
                    c81541.label = 2;
                    objAwaitOfferings = purchasesType2.awaitOfferings(c81541);
                } else {
                    if (!(offeringSelection instanceof OfferingSelection.None)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    PurchasesType purchasesType3 = this.purchases;
                    c81541.label = 3;
                    objAwaitOfferings = purchasesType3.awaitOfferings(c81541);
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objAwaitOfferings);
                    Offerings offerings2 = (Offerings) objAwaitOfferings;
                    return new ResolvedOfferingSelection(offerings2.getCurrent(), offerings2);
                }
                offeringSelection = (OfferingSelection) c81541.L$0;
                ResultKt.throwOnFailure(objAwaitOfferings);
                Offerings offerings3 = (Offerings) objAwaitOfferings;
                OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = (OfferingSelection.IdAndPresentedOfferingContext) offeringSelection;
                PresentedOfferingContext presentedOfferingContext = idAndPresentedOfferingContext.getPresentedOfferingContext();
                Offering current = offerings3.get(idAndPresentedOfferingContext.getOfferingId());
                if (current == null) {
                    current = offerings3.getCurrent();
                }
                if (presentedOfferingContext != null) {
                    Offering offeringCopy = current != null ? current.copy(presentedOfferingContext) : null;
                    if (offeringCopy != null) {
                        current = offeringCopy;
                    }
                }
                return new ResolvedOfferingSelection(current, offerings3);
            }
            offeringSelection = (OfferingSelection) c81541.L$0;
            ResultKt.throwOnFailure(objAwaitOfferings);
            offerings = (Offerings) objAwaitOfferings;
        } catch (PurchasesException e) {
            Logger.INSTANCE.m1587w("Paywalls: Failed to fetch offerings for exit offer preloading: " + e.getMessage());
        }
        return new ResolvedOfferingSelection(((OfferingSelection.OfferingType) offeringSelection).getOfferingType(), offerings);
    }

    private final void updatePaywallState(Offering currentOffering) {
        if (currentOffering == null) {
            this._state.setValue(new PaywallState.Error("You do not have a current offering configured in the RevenueCat dashboard."));
            return;
        }
        PaywallStateStore paywallStateStore = this.standaloneStateStore;
        if (paywallStateStore == null) {
            paywallStateStore = new PaywallStateStore(MapsKt.emptyMap());
            this.standaloneStateStore = paywallStateStore;
        }
        this._state.setValue(calculateState$default(this, currentOffering, this._colorScheme.getValue(), this.purchases.getStorefrontCountryCode(), this.options.getMode(), paywallStateStore, null, 32, null));
    }

    /* JADX INFO: renamed from: startWorkflowPresentationFromResult$revenuecatui_defaultsRelease$default */
    public static /* synthetic */ void m1582x34553ba3(PaywallViewModelImpl paywallViewModelImpl, PublishedWorkflow publishedWorkflow, Offerings offerings, PresentedOfferingContext presentedOfferingContext, UiConfig uiConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            uiConfig = PaywallOptionsKt.emptyUiConfig();
        }
        paywallViewModelImpl.startWorkflowPresentationFromResult$revenuecatui_defaultsRelease(publishedWorkflow, offerings, presentedOfferingContext, uiConfig);
    }

    public final void startWorkflowPresentationFromResult$revenuecatui_defaultsRelease(PublishedWorkflow workflow, Offerings offerings, PresentedOfferingContext presentedOfferingContext, UiConfig uiConfig) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        cancelStateUpdate();
        startWorkflowPresentation(workflow, uiConfig, offerings, presentedOfferingContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startWorkflowPresentation(PublishedWorkflow workflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext) {
        ExitOfferData.Unavailable unavailable;
        WorkflowStep workflowStep = workflow.getSteps().get(workflow.getInitialStepId());
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 1;
        boolean z = false;
        if (workflowStep == null) {
            updateExitOfferData(new ExitOfferData.Unavailable(z, i, defaultConstructorMarker));
            this._state.setValue(new PaywallState.Error("Initial step '" + workflow.getInitialStepId() + "' not found in workflow '" + workflow.getId() + '\''));
            return;
        }
        trackCurrentWorkflowStepCompleted();
        this.currentWorkflow = workflow;
        this.currentWorkflowUiConfig = uiConfig;
        this.currentWorkflowOfferings = offerings;
        this.currentWorkflowPresentedOfferingContext = presentedOfferingContext;
        this.workflowNavigator = new WorkflowNavigator(workflow);
        WorkflowExitOffer dismissExitOffer = workflow.getDismissExitOffer();
        if (dismissExitOffer != null) {
            unavailable = new ExitOfferData.Configured(dismissExitOffer.getOfferingId(), offerings, dismissExitOffer.getStepId(), false, null, 24, null);
        } else {
            unavailable = new ExitOfferData.Unavailable(z, i, defaultConstructorMarker);
        }
        updateExitOfferData(unavailable);
        String singleStepFallbackId = workflow.getSingleStepFallbackId();
        if (singleStepFallbackId != null && workflow.getSteps().get(singleStepFallbackId) == null) {
            Logger.INSTANCE.m1587w("Workflow singleStepFallbackId '" + singleStepFallbackId + "' not found in steps");
        }
        buildWorkflowStates(workflow, uiConfig, offerings, presentedOfferingContext, workflowStep, true);
    }

    private final void rebuildWorkflowStepStates() {
        Offerings offerings;
        WorkflowNavigator workflowNavigator;
        WorkflowStep currentStep;
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        if (publishedWorkflow == null || (offerings = this.currentWorkflowOfferings) == null || (workflowNavigator = this.workflowNavigator) == null || (currentStep = workflowNavigator.getCurrentStep()) == null) {
            return;
        }
        buildWorkflowStates(publishedWorkflow, this.currentWorkflowUiConfig, offerings, this.currentWorkflowPresentedOfferingContext, currentStep, false);
    }

    private final void buildWorkflowStates(PublishedWorkflow workflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, WorkflowStep currentStep, boolean isNewWorkflowImpression) {
        Job job = this.preWarmJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.workflowStepStateCache.clear();
        this._workflowState.setValue(null);
        if (isNewWorkflowImpression) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            this.workflowTraceId = string;
            this.currentWorkflowStateStore = new PaywallStateStore(MapsKt.emptyMap());
        }
        String singleStepFallbackId = workflow.getSingleStepFallbackId();
        WorkflowStep workflowStep = singleStepFallbackId != null ? workflow.getSteps().get(singleStepFallbackId) : null;
        if (workflowStep != null && !Intrinsics.areEqual(workflowStep.getId(), currentStep.getId())) {
            buildStateFromStep$default(this, workflowStep, workflow, uiConfig, offerings, presentedOfferingContext, null, null, false, 96, null);
        }
        buildStateFromStep$default(this, currentStep, workflow, uiConfig, offerings, presentedOfferingContext, null, null, false, 224, null);
        if (isNewWorkflowImpression && this._workflowState.getValue() != null) {
            trackWorkflowStepStarted(currentStep, null, WorkflowStepEntryReason.START);
        }
        preWarmWorkflowStepCache(workflow, uiConfig, offerings, presentedOfferingContext);
    }

    static /* synthetic */ void buildStateFromStep$default(PaywallViewModelImpl paywallViewModelImpl, WorkflowStep workflowStep, PublishedWorkflow publishedWorkflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, String str, NavigationDirection navigationDirection, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            str = null;
        }
        if ((i & 64) != 0) {
            navigationDirection = null;
        }
        if ((i & 128) != 0) {
            z = true;
        }
        paywallViewModelImpl.buildStateFromStep(workflowStep, publishedWorkflow, uiConfig, offerings, presentedOfferingContext, str, navigationDirection, z);
    }

    private final void buildStateFromStep(WorkflowStep step, PublishedWorkflow workflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, String fromStepId, NavigationDirection navigationDirection, boolean shouldApplyState) {
        PaywallState.Loaded.Components componentsComputeStateForStep;
        WorkflowPendingTransition workflowPendingTransition;
        WorkflowStep currentWorkflowStep;
        PaywallState.Loaded.Components components;
        PaywallState.Loaded.Components components2 = this.workflowStepStateCache.get(step.getId());
        if (components2 != null) {
            componentsComputeStateForStep = components2;
        } else {
            componentsComputeStateForStep = computeStateForStep(step, workflow, uiConfig, offerings, presentedOfferingContext, this.currentWorkflowStateStore);
        }
        if (components2 == null && (componentsComputeStateForStep instanceof PaywallState.Loaded.Components)) {
            this.workflowStepStateCache.put(step.getId(), (PaywallState.Loaded.Components) componentsComputeStateForStep);
        }
        boolean z = componentsComputeStateForStep instanceof PaywallState.Loaded.Components;
        if (z) {
            String singleStepFallbackId = workflow.getSingleStepFallbackId();
            PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (singleStepFallbackId == null || (components = this.workflowStepStateCache.get(singleStepFallbackId)) == null) ? null : components.getSelectedPackageInfo();
            if (selectedPackageInfo != null) {
                ((PaywallState.Loaded.Components) componentsComputeStateForStep).setDefaultPackage$revenuecatui_defaultsRelease(selectedPackageInfo);
            }
        }
        if (shouldApplyState) {
            this.currentWorkflowStepTracksPaywallEvents = z && tracksPaywallEvents(step, workflow);
            if (fromStepId == null || navigationDirection == null) {
                workflowPendingTransition = null;
            } else {
                int i = this.transitionIdCounter + 1;
                this.transitionIdCounter = i;
                workflowPendingTransition = new WorkflowPendingTransition(fromStepId, navigationDirection, i);
            }
            if (!z && (currentWorkflowStep = getCurrentWorkflowStep()) != null) {
                trackWorkflowStepCompleted(currentWorkflowStep, null);
            }
            this._workflowState.setValue(z ? new WorkflowPaywallUiState(step.getId(), MapsKt.toMap(this.workflowStepStateCache), workflowPendingTransition) : null);
            this._state.setValue(componentsComputeStateForStep);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onTransitionComplete(int transitionId) {
        WorkflowPendingTransition pendingTransition;
        WorkflowPaywallUiState value = this._workflowState.getValue();
        if (value == null || (pendingTransition = value.getPendingTransition()) == null || pendingTransition.getId() != transitionId) {
            return;
        }
        this._workflowState.setValue(WorkflowPaywallUiState.copy$default(value, null, null, null, 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallState computeStateForStep(WorkflowStep step, PublishedWorkflow workflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, PaywallStateStore stateStore) {
        Offering offeringCopy;
        String screenId = step.getScreenId();
        if (screenId == null) {
            return new PaywallState.Error("Step '" + step.getId() + "' has no screen_id in workflow '" + workflow.getId() + '\'');
        }
        WorkflowScreen workflowScreen = workflow.getScreens().get(screenId);
        if (workflowScreen == null) {
            return new PaywallState.Error("Screen '" + screenId + "' not found in workflow '" + workflow.getId() + '\'');
        }
        String offeringIdentifier = workflowScreen.getOfferingIdentifier();
        if (offeringIdentifier == null) {
            return new PaywallState.Error("Screen '" + screenId + "' has no offering_id in workflow '" + workflow.getId() + '\'');
        }
        Offering offering = offerings.get(offeringIdentifier);
        if (offering == null) {
            return new PaywallState.Error("Offering '" + offeringIdentifier + "' not found for screen '" + screenId + '\'');
        }
        Offering offering2 = new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), offering.getAvailablePackages(), null, WorkflowScreenMapper.INSTANCE.toPaywallComponents(workflowScreen, screenId, uiConfig), offering.getWebCheckoutURL(), 16, null);
        if (presentedOfferingContext == null || (offeringCopy = offering2.copy(presentedOfferingContext)) == null) {
            offeringCopy = offering2;
        }
        return calculateState(offeringCopy, this._colorScheme.getValue(), this.purchases.getStorefrontCountryCode(), this.options.getMode(), stateStore, new WorkflowScreenContext(workflow.getId(), step.getId(), step.getType(), step.getStepScreenType()));
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preWarmWorkflowStepCache$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preWarmWorkflowStepCache$1", m1609f = "PaywallViewModel.kt", m1610i = {0}, m1611l = {1295}, m1612m = "invokeSuspend", m1613n = {"stepId"}, m1615s = {"L$1"})
    static final class C81501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offerings $offerings;
        final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
        final /* synthetic */ PaywallStateStore $stateStore;
        final /* synthetic */ UiConfig $uiConfig;
        final /* synthetic */ PublishedWorkflow $workflow;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PaywallViewModelImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C81501(PublishedWorkflow publishedWorkflow, PaywallViewModelImpl paywallViewModelImpl, PaywallStateStore paywallStateStore, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, Continuation<? super C81501> continuation) {
            super(2, continuation);
            this.$workflow = publishedWorkflow;
            this.this$0 = paywallViewModelImpl;
            this.$stateStore = paywallStateStore;
            this.$uiConfig = uiConfig;
            this.$offerings = offerings;
            this.$presentedOfferingContext = presentedOfferingContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C81501(this.$workflow, this.this$0, this.$stateStore, this.$uiConfig, this.$offerings, this.$presentedOfferingContext, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0080 -> B:16:0x0083). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Iterator<Map.Entry<String, WorkflowStep>> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$workflow.getSteps().entrySet().iterator();
                while (it.hasNext()) {
                }
                MutableState mutableState = this.this$0._workflowState;
                WorkflowPaywallUiState workflowPaywallUiState = (WorkflowPaywallUiState) this.this$0._workflowState.getValue();
                mutableState.setValue(workflowPaywallUiState != null ? WorkflowPaywallUiState.copy$default(workflowPaywallUiState, null, MapsKt.toMap(this.this$0.workflowStepStateCache), null, 5, null) : null);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String key = (String) this.L$1;
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            PaywallState paywallState = (PaywallState) obj;
            if (this.$stateStore != this.this$0.currentWorkflowStateStore) {
                if ((paywallState instanceof PaywallState.Loaded.Components) && !this.this$0.workflowStepStateCache.containsKey(key)) {
                    this.this$0.workflowStepStateCache.put(key, paywallState);
                    PaywallState.Loaded.Components components = (PaywallState.Loaded.Components) paywallState;
                    PaywallViewModelImpl paywallViewModelImpl = this.this$0;
                    PaywallState.Loaded.Components.update$default(components, paywallViewModelImpl.toFrameworkLocaleList((LocaleListCompat) paywallViewModelImpl._lastLocaleList.getValue()), null, null, 6, null);
                    String singleStepFallbackId = this.$workflow.getSingleStepFallbackId();
                    if (singleStepFallbackId != null) {
                        PaywallState.Loaded.Components components2 = (PaywallState.Loaded.Components) this.this$0.workflowStepStateCache.get(singleStepFallbackId);
                        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components2 != null ? components2.getSelectedPackageInfo() : null;
                        if (selectedPackageInfo != null) {
                            components.setDefaultPackage$revenuecatui_defaultsRelease(selectedPackageInfo);
                        }
                    }
                }
                while (it.hasNext()) {
                    Map.Entry<String, WorkflowStep> next = it.next();
                    key = next.getKey();
                    WorkflowStep value = next.getValue();
                    if (!this.this$0.workflowStepStateCache.containsKey(key)) {
                        this.L$0 = it;
                        this.L$1 = key;
                        this.label = 1;
                        obj = BuildersKt.withContext(this.this$0.backgroundDispatcher, new PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1(this.this$0, value, this.$workflow, this.$uiConfig, this.$offerings, this.$presentedOfferingContext, this.$stateStore, null), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PaywallState paywallState2 = (PaywallState) obj;
                        if (this.$stateStore != this.this$0.currentWorkflowStateStore) {
                            return Unit.INSTANCE;
                        }
                    }
                }
                MutableState mutableState2 = this.this$0._workflowState;
                WorkflowPaywallUiState workflowPaywallUiState2 = (WorkflowPaywallUiState) this.this$0._workflowState.getValue();
                mutableState2.setValue(workflowPaywallUiState2 != null ? WorkflowPaywallUiState.copy$default(workflowPaywallUiState2, null, MapsKt.toMap(this.this$0.workflowStepStateCache), null, 5, null) : null);
                return Unit.INSTANCE;
            }
        }
    }

    private final void preWarmWorkflowStepCache(PublishedWorkflow workflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext) {
        this.preWarmJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81501(workflow, this, this.currentWorkflowStateStore, uiConfig, offerings, presentedOfferingContext, null), 3, null);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType) {
        PublishedWorkflow publishedWorkflow;
        Offerings offerings;
        WorkflowStep workflowStepPeekTriggerStep;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowNavigator workflowNavigator = this.workflowNavigator;
        if (workflowNavigator == null || (publishedWorkflow = this.currentWorkflow) == null || (offerings = this.currentWorkflowOfferings) == null || (workflowStepPeekTriggerStep = workflowNavigator.peekTriggerStep(componentId, triggerType)) == null) {
            return;
        }
        String strValidateStep = validateStep(workflowStepPeekTriggerStep, publishedWorkflow, offerings);
        if (strValidateStep != null) {
            Logger.INSTANCE.m1584e("Cannot navigate to step '" + workflowStepPeekTriggerStep.getId() + "': " + strValidateStep);
            return;
        }
        WorkflowStep currentStep = workflowNavigator.getCurrentStep();
        String id = currentStep != null ? currentStep.getId() : null;
        WorkflowStep workflowStepTriggerAction = workflowNavigator.triggerAction(componentId, triggerType);
        if (workflowStepTriggerAction == null) {
            Logger.INSTANCE.m1584e("triggerAction returned null after peekTriggerStep succeeded — this is a bug");
        } else {
            buildStateFromStep$default(this, workflowStepTriggerAction, publishedWorkflow, this.currentWorkflowUiConfig, offerings, this.currentWorkflowPresentedOfferingContext, id, NavigationDirection.FORWARD, false, 128, null);
            trackWorkflowStepNavigation(currentStep, workflowStepTriggerAction, WorkflowStepEntryReason.FORWARD);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public boolean handleBackNavigation() {
        PublishedWorkflow publishedWorkflow;
        Offerings offerings;
        WorkflowStep peekBackStep;
        WorkflowNavigator workflowNavigator = this.workflowNavigator;
        if (workflowNavigator == null || !workflowNavigator.getCanNavigateBack() || (publishedWorkflow = this.currentWorkflow) == null || (offerings = this.currentWorkflowOfferings) == null || (peekBackStep = workflowNavigator.getPeekBackStep()) == null) {
            return false;
        }
        String strValidateStep = validateStep(peekBackStep, publishedWorkflow, offerings);
        if (strValidateStep != null) {
            Logger.INSTANCE.m1584e("Cannot navigate back to step '" + peekBackStep.getId() + "': " + strValidateStep);
            return false;
        }
        WorkflowStep currentStep = workflowNavigator.getCurrentStep();
        String id = currentStep != null ? currentStep.getId() : null;
        WorkflowStep workflowStepNavigateBack = workflowNavigator.navigateBack();
        if (workflowStepNavigateBack == null) {
            Logger.INSTANCE.m1584e("navigateBack returned null after canNavigateBack was true — this is a bug");
            return false;
        }
        buildStateFromStep$default(this, workflowStepNavigateBack, publishedWorkflow, this.currentWorkflowUiConfig, offerings, this.currentWorkflowPresentedOfferingContext, id, NavigationDirection.BACKWARD, false, 128, null);
        trackWorkflowStepNavigation(currentStep, workflowStepNavigateBack, WorkflowStepEntryReason.BACK);
        return true;
    }

    private final void trackWorkflowStepNavigation(WorkflowStep fromStep, WorkflowStep toStep, WorkflowStepEntryReason entryReason) {
        if (this._workflowState.getValue() == null) {
            return;
        }
        if (fromStep != null) {
            trackWorkflowStepCompleted(fromStep, toStep.getId());
        }
        trackWorkflowStepStarted(toStep, fromStep != null ? fromStep.getId() : null, entryReason);
    }

    private final void trackWorkflowStepStarted(WorkflowStep step, String fromStepId, WorkflowStepEntryReason entryReason) {
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        if (publishedWorkflow == null) {
            return;
        }
        PurchasesType purchasesType = this.purchases;
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        purchasesType.track(new WorkflowEvent.StepStarted(new WorkflowEvent.CreationData(uuidRandomUUID, new Date()), publishedWorkflow.getId(), step.getId(), this.workflowTraceId, fromStepId, entryReason.getValue(), Boolean.valueOf(Intrinsics.areEqual(step.getId(), publishedWorkflow.getInitialStepId())), Boolean.valueOf(isTerminalStep(publishedWorkflow, step.getId()))));
    }

    private final void trackWorkflowStepCompleted(WorkflowStep step, String toStepId) {
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        if (publishedWorkflow == null) {
            return;
        }
        PurchasesType purchasesType = this.purchases;
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        purchasesType.track(new WorkflowEvent.StepCompleted(new WorkflowEvent.CreationData(uuidRandomUUID, new Date()), publishedWorkflow.getId(), step.getId(), this.workflowTraceId, toStepId, Boolean.valueOf(Intrinsics.areEqual(step.getId(), publishedWorkflow.getInitialStepId())), Boolean.valueOf(isTerminalStep(publishedWorkflow, step.getId()))));
    }

    private final boolean isTerminalStep(PublishedWorkflow workflow, String stepId) {
        WorkflowStep workflowStep = workflow.getSteps().get(stepId);
        if (workflowStep == null) {
            return false;
        }
        Collection<WorkflowTriggerAction> collectionValues = workflowStep.getTriggerActions().values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            return true;
        }
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            if (((WorkflowTriggerAction) it.next()) instanceof WorkflowTriggerAction.Step) {
                return false;
            }
        }
        return true;
    }

    private final WorkflowStep getCurrentWorkflowStep() {
        String currentStepId;
        PublishedWorkflow publishedWorkflow;
        Map<String, WorkflowStep> steps;
        WorkflowPaywallUiState value = this._workflowState.getValue();
        if (value == null || (currentStepId = value.getCurrentStepId()) == null || (publishedWorkflow = this.currentWorkflow) == null || (steps = publishedWorkflow.getSteps()) == null) {
            return null;
        }
        return steps.get(currentStepId);
    }

    private final void trackCurrentWorkflowStepCompleted() {
        WorkflowStep currentWorkflowStep = getCurrentWorkflowStep();
        if (currentWorkflowStep != null) {
            trackWorkflowStepCompleted(currentWorkflowStep, null);
        }
    }

    private final void trackCurrentWorkflowAbandoned() {
        WorkflowStep currentWorkflowStep;
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        if (publishedWorkflow == null || (currentWorkflowStep = getCurrentWorkflowStep()) == null) {
            return;
        }
        PurchasesType purchasesType = this.purchases;
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        purchasesType.track(new WorkflowEvent.Close(new WorkflowEvent.CreationData(uuidRandomUUID, new Date()), publishedWorkflow.getId(), currentWorkflowStep.getId(), this.workflowTraceId, Boolean.valueOf(Intrinsics.areEqual(currentWorkflowStep.getId(), publishedWorkflow.getInitialStepId())), Boolean.valueOf(isTerminalStep(publishedWorkflow, currentWorkflowStep.getId()))));
    }

    private final String validateStep(WorkflowStep step, PublishedWorkflow workflow, Offerings offerings) {
        String screenId = step.getScreenId();
        if (screenId == null) {
            return "Step '" + step.getId() + "' has no screen_id in workflow '" + workflow.getId() + '\'';
        }
        WorkflowScreen workflowScreen = workflow.getScreens().get(screenId);
        if (workflowScreen == null) {
            return "Screen '" + screenId + "' not found in workflow '" + workflow.getId() + '\'';
        }
        String offeringIdentifier = workflowScreen.getOfferingIdentifier();
        if (offeringIdentifier == null) {
            return "Screen '" + screenId + "' has no offering_id in workflow '" + workflow.getId() + '\'';
        }
        if (offerings.get(offeringIdentifier) == null) {
            return "Offering '" + offeringIdentifier + "' not found for screen '" + screenId + '\'';
        }
        return null;
    }

    private final boolean tracksPaywallEvents(WorkflowStep workflowStep, PublishedWorkflow publishedWorkflow) {
        List<String> stepScreenType = workflowStep.getStepScreenType();
        return stepScreenType == null ? Intrinsics.areEqual(workflowStep.getId(), publishedWorkflow.getSingleStepFallbackId()) : stepScreenType.contains(WorkflowScreenType.PAYWALL);
    }

    private final LocaleListCompat getCurrentLocaleList() {
        String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
        if (preferredUILocaleOverride == null) {
            LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault()");
            return localeListCompat;
        }
        try {
            LocaleListCompat localeListCompatCreate = LocaleListCompat.create(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride));
            Intrinsics.checkNotNullExpressionValue(localeListCompatCreate, "create(locale)");
            return localeListCompatCreate;
        } catch (IllegalArgumentException e) {
            Logger.INSTANCE.m1585e("Invalid preferred locale format: " + preferredUILocaleOverride + ". Using system default.", e);
            LocaleListCompat localeListCompat2 = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat2, "{\n            Logger.e(\"…at.getDefault()\n        }");
            return localeListCompat2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocaleList toFrameworkLocaleList(LocaleListCompat localeListCompat) {
        int size = localeListCompat.size();
        Locale[] localeArr = new Locale[size];
        for (int i = 0; i < size; i++) {
            Locale locale = localeListCompat.get(i);
            Intrinsics.checkNotNull(locale);
            localeArr[i] = locale;
        }
        return new LocaleList((Locale[]) Arrays.copyOf(localeArr, size));
    }

    static /* synthetic */ PaywallState calculateState$default(PaywallViewModelImpl paywallViewModelImpl, Offering offering, ColorScheme colorScheme, String str, PaywallMode paywallMode, PaywallStateStore paywallStateStore, WorkflowScreenContext workflowScreenContext, int i, Object obj) {
        if ((i & 16) != 0) {
            paywallStateStore = null;
        }
        if ((i & 32) != 0) {
            workflowScreenContext = null;
        }
        return paywallViewModelImpl.calculateState(offering, colorScheme, str, paywallMode, paywallStateStore, workflowScreenContext);
    }

    private final PaywallState calculateState(Offering offering, ColorScheme colorScheme, String storefrontCountryCode, PaywallMode mode, PaywallStateStore stateStore, WorkflowScreenContext workflowScreen) {
        if (offering.getAvailablePackages().isEmpty()) {
            return new PaywallState.Error("No packages available");
        }
        PaywallValidationResult.Legacy legacyValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, colorScheme, getResourceProvider());
        if ((legacyValidatedPaywall instanceof PaywallValidationResult.Components) && !PaywallModeKt.isFullScreen(mode)) {
            legacyValidatedPaywall = OfferingToStateMapperKt.fallbackPaywall(offering, colorScheme, getResourceProvider(), PaywallValidationError.InvalidModeForComponentsPaywall.INSTANCE);
        }
        NonEmptyList<PaywallValidationError> errors = legacyValidatedPaywall.getErrors();
        if (errors != null) {
            Iterator<PaywallValidationError> it = errors.iterator();
            while (it.hasNext()) {
                Logger.INSTANCE.m1584e(it.next().associatedErrorString(offering));
            }
            Logger.INSTANCE.m1584e(PaywallValidationErrorStrings.DISPLAYING_DEFAULT);
        }
        if (legacyValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) legacyValidatedPaywall;
            return OfferingToStateMapperKt.toLegacyPaywallState(offering, this.variableDataProvider, mode, legacy.getDisplayablePaywall(), legacy.getTemplate(), this.options.getShouldDisplayDismissButton(), storefrontCountryCode, legacy.getWarning());
        }
        if (!(legacyValidatedPaywall instanceof PaywallValidationResult.Components)) {
            throw new NoWhenBranchMatchedException();
        }
        return OfferingToStateMapperKt.toComponentsPaywallState(offering, (PaywallValidationResult.Components) legacyValidatedPaywall, storefrontCountryCode, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.calculateState.2
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date();
            }
        }, this.purchases, workflowScreen, this.options.getCustomVariables(), extractDefaultCustomVariables(offering), stateStore, this._actionInProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runExclusiveAction(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        if (verifyNoActionInProgressOrStartAction()) {
            return Unit.INSTANCE;
        }
        Object objJoin = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81562(function1, this, null), 3, null).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$runExclusiveAction$2 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$runExclusiveAction$2", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {1598}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ PaywallViewModelImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C81562(Function1<? super Continuation<? super Unit>, ? extends Object> function1, PaywallViewModelImpl paywallViewModelImpl, Continuation<? super C81562> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.this$0 = paywallViewModelImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C81562(this.$block, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$block;
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
                this.this$0.finishAction();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.this$0.finishAction();
                throw th;
            }
        }
    }

    private final boolean verifyNoActionInProgressOrStartAction() {
        if (this._actionInProgress.getValue().booleanValue()) {
            Logger.INSTANCE.m1583d("Ignoring purchase or restore because there already is an action in progress");
            return true;
        }
        this._actionInProgress.setValue(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAction() {
        this._actionInProgress.setValue(false);
    }

    private final void trackPaywallClose() {
        if (this.paywallPresentationData != null) {
            track(PaywallEventType.CLOSE);
        }
    }

    private final void trackPaywallPurchaseInitiated(Package rcPackage) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.m1584e("Paywall event data is null, not tracking purchase initiated event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, rcPackage.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(rcPackage.getProduct()), null, null, null, null, null, 63999, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_INITIATED, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    private final void trackPaywallPurchaseError(Package rcPackage, PurchasesError error) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.m1584e("Paywall event data is null, not tracking purchase error event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, rcPackage.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(rcPackage.getProduct()), Integer.valueOf(error.getCode().getCode()), error.getMessage(), null, null, null, 57855, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_ERROR, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    private final void trackPaywallCancel() {
        track(PaywallEventType.CANCEL);
    }

    private final void track(PaywallEventType eventType) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.m1584e("Paywall event data is null, not tracking event " + eventType);
            return;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), data, eventType, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    private final PaywallEvent.Data createEventData() {
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        String id = publishedWorkflow != null ? publishedWorkflow.getId() : null;
        WorkflowPaywallUiState value = this._workflowState.getValue();
        String currentStepId = value != null ? value.getCurrentStepId() : null;
        String paywallEventTraceId = getPaywallEventTraceId();
        PaywallState value2 = getState().getValue();
        if (value2 instanceof PaywallState.Loaded.Legacy) {
            return createEventData((PaywallState.Loaded.Legacy) value2, id, currentStepId, paywallEventTraceId);
        }
        if (value2 instanceof PaywallState.Loaded.Components) {
            return createEventData((PaywallState.Loaded.Components) value2, id, currentStepId, paywallEventTraceId);
        }
        if (value2 instanceof PaywallState.Error ? true : value2 instanceof PaywallState.Loading) {
            Logger.INSTANCE.m1584e("Unexpected state trying to create event data: " + value2);
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Legacy legacy, String str, String str2, String str3) {
        PaywallComponentsData dataOrNull;
        int revision;
        String str4;
        PaywallComponentsData dataOrNull2;
        String id;
        Offering offering = legacy.getOffering();
        PaywallData paywall = legacy.getOffering().getPaywall();
        String id2 = null;
        if (paywall != null) {
            revision = paywall.getRevision();
        } else {
            Offering.PaywallComponents paywallComponents = legacy.getOffering().getPaywallComponents();
            if (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) {
                Logger.INSTANCE.m1584e("Null paywall revision trying to create event data");
                return null;
            }
            revision = dataOrNull.getRevision();
        }
        int i = revision;
        PaywallData paywall2 = legacy.getOffering().getPaywall();
        if (paywall2 == null || (id = paywall2.getId()) == null) {
            Offering.PaywallComponents paywallComponents2 = legacy.getOffering().getPaywallComponents();
            if (paywallComponents2 != null && (dataOrNull2 = paywallComponents2.getDataOrNull()) != null) {
                id2 = dataOrNull2.getId();
            }
            str4 = id2;
        } else {
            str4 = id;
        }
        Locale locale = this._lastLocaleList.getValue().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        PresentedOfferingContext presentedOfferingContextOrDefault = getPresentedOfferingContextOrDefault(offering);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = locale.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        return new PaywallEvent.Data(str4, presentedOfferingContextOrDefault, i, uuidRandomUUID, lowerCase, string, this.isDarkMode, null, null, null, null, null, null, str, str2, str3, 8064, null);
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Components components, String str, String str2, String str3) {
        PaywallComponentsData dataOrNull;
        Offering offering = components.getOffering();
        Offering.PaywallComponents paywallComponents = components.getOffering().getPaywallComponents();
        if (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) {
            Logger.INSTANCE.m1584e("Null paywall revision trying to create event data");
            return null;
        }
        String id = dataOrNull.getId();
        PresentedOfferingContext presentedOfferingContextOrDefault = getPresentedOfferingContextOrDefault(offering);
        int revision = dataOrNull.getRevision();
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new PaywallEvent.Data(id, presentedOfferingContextOrDefault, revision, uuidRandomUUID, lowerCase, components.getLocale().toString(), this.isDarkMode, null, null, null, null, null, null, str, str2, str3, 8064, null);
    }

    private final PaywallPresentationFingerprint computePresentationFingerprint() {
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Legacy) {
            return presentationFingerprintLegacy((PaywallState.Loaded.Legacy) value, getMode(), this._lastLocaleList.getValue(), this.isDarkMode);
        }
        if (value instanceof PaywallState.Loaded.Components) {
            return presentationFingerprintComponents((PaywallState.Loaded.Components) value, getMode(), this.isDarkMode);
        }
        if (value instanceof PaywallState.Error ? true : value instanceof PaywallState.Loading) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PaywallPresentationFingerprint presentationFingerprintLegacy(PaywallState.Loaded.Legacy legacy, PaywallMode paywallMode, LocaleListCompat localeListCompat, boolean z) {
        PaywallComponentsData dataOrNull;
        int revision;
        String str;
        PaywallComponentsData dataOrNull2;
        String id;
        PaywallData paywall = legacy.getOffering().getPaywall();
        String id2 = null;
        if (paywall != null) {
            revision = paywall.getRevision();
        } else {
            Offering.PaywallComponents paywallComponents = legacy.getOffering().getPaywallComponents();
            if (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) {
                return null;
            }
            revision = dataOrNull.getRevision();
        }
        int i = revision;
        PaywallData paywall2 = legacy.getOffering().getPaywall();
        if (paywall2 == null || (id = paywall2.getId()) == null) {
            Offering.PaywallComponents paywallComponents2 = legacy.getOffering().getPaywallComponents();
            if (paywallComponents2 != null && (dataOrNull2 = paywallComponents2.getDataOrNull()) != null) {
                id2 = dataOrNull2.getId();
            }
            str = id2;
        } else {
            str = id;
        }
        Locale locale = localeListCompat.get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        PresentedOfferingContext presentedOfferingContextOrDefault = getPresentedOfferingContextOrDefault(legacy.getOffering());
        String lowerCase = paywallMode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = locale.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        return new PaywallPresentationFingerprint(str, presentedOfferingContextOrDefault, i, lowerCase, string, z);
    }

    private final PaywallPresentationFingerprint presentationFingerprintComponents(PaywallState.Loaded.Components components, PaywallMode paywallMode, boolean z) {
        PaywallComponentsData dataOrNull;
        Offering.PaywallComponents paywallComponents = components.getOffering().getPaywallComponents();
        if (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) {
            return null;
        }
        String id = dataOrNull.getId();
        PresentedOfferingContext presentedOfferingContextOrDefault = getPresentedOfferingContextOrDefault(components.getOffering());
        int revision = dataOrNull.getRevision();
        String lowerCase = paywallMode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new PaywallPresentationFingerprint(id, presentedOfferingContextOrDefault, revision, lowerCase, components.getLocale().toString(), z);
    }

    private final PaywallPresentationFingerprint presentationFingerprint(PaywallEvent.Data data) {
        return new PaywallPresentationFingerprint(data.getPaywallIdentifier(), data.getPresentedOfferingContext(), data.getPaywallRevision(), data.getDisplayMode(), data.getLocaleIdentifier(), data.getDarkMode());
    }

    private final PaywallEvent.Data withCurrentWorkflowMetadata(PaywallEvent.Data data) {
        PublishedWorkflow publishedWorkflow = this.currentWorkflow;
        String id = publishedWorkflow != null ? publishedWorkflow.getId() : null;
        WorkflowPaywallUiState value = this._workflowState.getValue();
        String currentStepId = value != null ? value.getCurrentStepId() : null;
        String paywallEventTraceId = getPaywallEventTraceId();
        return (Intrinsics.areEqual(data.getWorkflowId(), id) && Intrinsics.areEqual(data.getStepId(), currentStepId) && Intrinsics.areEqual(data.getTraceId(), paywallEventTraceId)) ? data : PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, null, null, null, null, id, currentStepId, paywallEventTraceId, 8191, null);
    }

    private final Map<String, CustomVariableValue> extractDefaultCustomVariables(Offering offering) {
        UiConfig uiConfig;
        Map customVariables;
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents == null || (uiConfig = paywallComponents.getUiConfig()) == null || (customVariables = uiConfig.getCustomVariables()) == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(customVariables.size()));
        for (Map.Entry entry : customVariables.entrySet()) {
            linkedHashMap.put(entry.getKey(), CustomVariableValue.INSTANCE.from(((UiConfig.CustomVariableDefinition) entry.getValue()).getDefaultValue()));
        }
        return linkedHashMap;
    }

    private final PresentedOfferingContext getPresentedOfferingContextOrDefault(Offering offering) {
        PresentedOfferingContext presentedOfferingContext = offering.getPresentedOfferingContext();
        return presentedOfferingContext == null ? new PresentedOfferingContext(offering.getIdentifier()) : presentedOfferingContext;
    }
}
