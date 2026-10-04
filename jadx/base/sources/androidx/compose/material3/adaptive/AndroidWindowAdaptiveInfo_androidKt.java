package androidx.compose.material3.adaptive;

import android.content.Context;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.WindowInfo;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AndroidWindowAdaptiveInfo.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u000f\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\u0006\u001a\u0019\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"currentWindowAdaptiveInfo", "Landroidx/compose/material3/adaptive/WindowAdaptiveInfo;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/adaptive/WindowAdaptiveInfo;", "currentWindowDpSizeDeprecated", "Landroidx/compose/ui/unit/DpSize;", "currentWindowDpSize", "(Landroidx/compose/runtime/Composer;I)J", "currentWindowSizeDeprecated", "Landroidx/compose/ui/unit/IntSize;", "currentWindowSize", "collectFoldingFeaturesAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/window/layout/FoldingFeature;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "adaptive"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class AndroidWindowAdaptiveInfo_androidKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common source set, maintained for binary compatibility.")
    public static final /* synthetic */ WindowAdaptiveInfo currentWindowAdaptiveInfo(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2003129230, "C(currentWindowAdaptiveInfo)37@1428L32:AndroidWindowAdaptiveInfo.android.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2003129230, i, -1, "androidx.compose.material3.adaptive.currentWindowAdaptiveInfo (AndroidWindowAdaptiveInfo.android.kt:37)");
        }
        WindowAdaptiveInfo windowAdaptiveInfoCurrentWindowAdaptiveInfo = WindowAdaptiveInfoKt.currentWindowAdaptiveInfo(false, composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowAdaptiveInfoCurrentWindowAdaptiveInfo;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common source set, maintained for binary compatibility.")
    public static final /* synthetic */ long currentWindowDpSize(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2075694585, "C(currentWindowDpSizeDeprecated)52@1890L7:AndroidWindowAdaptiveInfo.android.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2075694585, i, -1, "androidx.compose.material3.adaptive.currentWindowDpSizeDeprecated (AndroidWindowAdaptiveInfo.android.kt:52)");
        }
        composer.startReplaceGroup(-1877662387);
        ComposerKt.sourceInformation(composer, "*52@1901L19");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jMo2189toDpSizekrfVVM = ((Density) objConsume).mo2189toDpSizekrfVVM(IntSizeKt.m11200toSizeozmzZPI(WindowAdaptiveInfoKt.currentWindowSize(composer, 0)));
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jMo2189toDpSizekrfVVM;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common source set, maintained for binary compatibility.")
    public static final /* synthetic */ long currentWindowSize(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1927257502, "C(currentWindowSizeDeprecated)66@2439L7:AndroidWindowAdaptiveInfo.android.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1927257502, i, -1, "androidx.compose.material3.adaptive.currentWindowSizeDeprecated (AndroidWindowAdaptiveInfo.android.kt:66)");
        }
        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localWindowInfo);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jMo10138getContainerSizeYbymL2g = ((WindowInfo) objConsume).mo10138getContainerSizeYbymL2g();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jMo10138getContainerSizeYbymL2g;
    }

    public static final State<List<FoldingFeature>> collectFoldingFeaturesAsState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -883534959, "C(collectFoldingFeaturesAsState)75@2722L7,76@2741L196,81@2947L27:AndroidWindowAdaptiveInfo.android.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-883534959, i, -1, "androidx.compose.material3.adaptive.collectFoldingFeaturesAsState (AndroidWindowAdaptiveInfo.android.kt:74)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 1326433333, "CC(remember):AndroidWindowAdaptiveInfo.android.kt#9igjgp");
        boolean zChanged = composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final Flow<WindowLayoutInfo> flowWindowLayoutInfo = WindowInfoTracker.INSTANCE.getOrCreate(context).windowLayoutInfo(context);
            objRememberedValue = (Flow) new Flow<List<? extends FoldingFeature>>() { // from class: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1

                /* JADX INFO: renamed from: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
                    @DebugMetadata(m1608c = "androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2", m1609f = "AndroidWindowAdaptiveInfo.android.kt", m1610i = {}, m1611l = {219}, m1612m = "emit", m1613n = {}, m1615s = {})
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
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
                            List<DisplayFeature> displayFeatures = ((WindowLayoutInfo) obj).getDisplayFeatures();
                            ArrayList arrayList = new ArrayList();
                            for (T t : displayFeatures) {
                                if (t instanceof FoldingFeature) {
                                    arrayList.add(t);
                                }
                            }
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FoldingFeature>> flowCollector, Continuation continuation) {
                    Object objCollect = flowWindowLayoutInfo.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<List<FoldingFeature>> stateCollectAsState = SnapshotStateKt.collectAsState((Flow) objRememberedValue, CollectionsKt.emptyList(), null, composer, 48, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCollectAsState;
    }
}
