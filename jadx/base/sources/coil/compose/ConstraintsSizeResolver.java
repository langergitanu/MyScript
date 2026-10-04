package coil.compose;

import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.exifinterface.media.ExifInterface;
import coil.size.Size;
import coil.size.SizeResolver;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConstraintsSizeResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcoil/compose/ConstraintsSizeResolver;", "Lcoil/size/SizeResolver;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "currentConstraints", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/unit/Constraints;", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "", "setConstraints-BRTryo0", "(J)V", "coil-compose-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public static final int $stable = 0;
    private final MutableStateFlow<Constraints> currentConstraints = StateFlowKt.MutableStateFlow(Constraints.m10957boximpl(UtilsKt.getZeroConstraints()));

    @Override // coil.size.SizeResolver
    public Object size(Continuation<? super Size> continuation) {
        final MutableStateFlow<Constraints> mutableStateFlow = this.currentConstraints;
        return FlowKt.first(new Flow<Size>() { // from class: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
            public static final class C38152<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2", m1609f = "ConstraintsSizeResolver.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_2_1}, m1612m = "emit", m1613n = {}, m1615s = {})
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
                        return C38152.this.emit(null, this);
                    }
                }

                public C38152(FlowCollector flowCollector) {
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
                        Size sizeM12365toSizeOrNullBRTryo0 = UtilsKt.m12365toSizeOrNullBRTryo0(((Constraints) obj).getValue());
                        if (sizeM12365toSizeOrNullBRTryo0 != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(sizeM12365toSizeOrNullBRTryo0, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
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
            public Object collect(FlowCollector<? super Size> flowCollector, Continuation continuation2) {
                Object objCollect = mutableStateFlow.collect(new C38152(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo3418measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        this.currentConstraints.setValue(Constraints.m10957boximpl(j));
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: coil.compose.ConstraintsSizeResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConstraintsSizeResolver.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: setConstraints-BRTryo0, reason: not valid java name */
    public final void m12325setConstraintsBRTryo0(long constraints) {
        this.currentConstraints.setValue(Constraints.m10957boximpl(constraints));
    }
}
