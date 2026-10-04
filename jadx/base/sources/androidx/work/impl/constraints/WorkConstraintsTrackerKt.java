package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BaseConstraintController;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedControllerPre28;
import androidx.work.impl.constraints.controllers.NetworkMeteredControllerPre28;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingControllerPre28;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredControllerPre28;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.yalantis.ucrop.UCrop;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007\"\u0013\u0010\u0012\u001a\u00070\u0013¢\u0006\u0002\b\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000*$\b\u0002\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u001b"}, m1599d2 = {"OnConstraintState", "Lkotlin/Function1;", "Landroidx/work/impl/constraints/ConstraintsState;", "", "listen", "Lkotlinx/coroutines/Job;", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "spec", "Landroidx/work/impl/model/WorkSpec;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "createControllers", "", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "trackers", "Landroidx/work/impl/constraints/trackers/Trackers;", "TAG", "", "Lorg/jspecify/annotations/NonNull;", "NetworkRequestConstraintController", "Landroidx/work/impl/constraints/NetworkRequestConstraintController;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "DefaultNetworkRequestTimeoutMs", "", "work-runtime_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WorkConstraintsTrackerKt {
    private static final long DefaultNetworkRequestTimeoutMs = 1000;
    private static final String TAG;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1 */
    /* JADX INFO: compiled from: WorkConstraintsTracker.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", m1609f = "WorkConstraintsTracker.kt", m1610i = {}, m1611l = {UCrop.REQUEST_CROP}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C29751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnConstraintsStateChangedListener $listener;
        final /* synthetic */ WorkSpec $spec;
        final /* synthetic */ WorkConstraintsTracker $this_listen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29751(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, Continuation<? super C29751> continuation) {
            super(2, continuation);
            this.$this_listen = workConstraintsTracker;
            this.$spec = workSpec;
            this.$listener = onConstraintsStateChangedListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29751(this.$this_listen, this.$spec, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<ConstraintsState> flowTrack = this.$this_listen.track(this.$spec);
                final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
                final WorkSpec workSpec = this.$spec;
                this.label = 1;
                if (flowTrack.collect(new FlowCollector() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt.listen.1.1
                    public final Object emit(ConstraintsState constraintsState, Continuation<? super Unit> continuation) {
                        onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ConstraintsState) obj2, (Continuation<? super Unit>) continuation);
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

    public static final Job listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec spec, CoroutineDispatcher dispatcher, OnConstraintsStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(workConstraintsTracker, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new C29751(workConstraintsTracker, spec, listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ConstraintController> createControllers(Trackers trackers) {
        List<ConstraintController> listMutableListOf = CollectionsKt.mutableListOf(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()));
        if (Build.VERSION.SDK_INT >= 28) {
            listMutableListOf.add(NetworkRequestConstraintController(trackers.getContext()));
            return listMutableListOf;
        }
        ConstraintTracker<NetworkState> networkStateTracker = trackers.getNetworkStateTracker();
        Intrinsics.checkNotNull(networkStateTracker);
        listMutableListOf.addAll(CollectionsKt.listOf((Object[]) new BaseConstraintController[]{new NetworkConnectedControllerPre28(networkStateTracker), new NetworkUnmeteredControllerPre28(trackers.getNetworkStateTracker()), new NetworkNotRoamingControllerPre28(trackers.getNetworkStateTracker()), new NetworkMeteredControllerPre28(trackers.getNetworkStateTracker())}));
        return listMutableListOf;
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(...)");
        TAG = strTagWithPrefix;
    }

    public static final NetworkRequestConstraintController NetworkRequestConstraintController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0L, 2, null);
    }
}
