package com.myscript.nebo.penpanel;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.nebo.common.ColorPolicyRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ColorPickerViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0003J\u0012\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "color", "", "colorRepository", "Lcom/myscript/nebo/common/ColorPolicyRepository;", "readOnly", "", "canInvertColor", "<init>", "(ILcom/myscript/nebo/common/ColorPolicyRepository;ZZ)V", "hsv", "", "alpha", "_colorPickerUIState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/penpanel/ColorPickerUIState;", "colorPickerUIState", "Landroidx/lifecycle/LiveData;", "getColorPickerUIState", "()Landroidx/lifecycle/LiveData;", "_pickedColor", "pickedColor", "getPickedColor", "hueChanged", "", "hue", "", "saturationChanged", "saturation", "brightnessChanged", "brightness", "updateColor", "fromUserAction", "resetColor", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPickerViewModel extends ViewModel {
    private static final float SATURATION_BRIGHTNESS_MAX = 255.0f;
    private final MutableLiveData<ColorPickerUIState> _colorPickerUIState;
    private final MutableLiveData<Integer> _pickedColor;
    private final int alpha;
    private final boolean canInvertColor;
    private final int color;
    private final ColorPolicyRepository colorRepository;
    private final float[] hsv;
    private final boolean readOnly;

    public ColorPickerViewModel(int i, ColorPolicyRepository colorRepository, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(colorRepository, "colorRepository");
        this.color = i;
        this.colorRepository = colorRepository;
        this.readOnly = z;
        this.canInvertColor = z2;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(ColorUtils.setAlphaComponent(i, 255), fArr);
        this.hsv = fArr;
        this.alpha = (i >> 24) & 255;
        this._colorPickerUIState = new MutableLiveData<>();
        this._pickedColor = new MutableLiveData<>();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66831(null), 3, null);
        updateColor$default(this, false, 1, null);
    }

    public final LiveData<ColorPickerUIState> getColorPickerUIState() {
        return this._colorPickerUIState;
    }

    public final LiveData<Integer> getPickedColor() {
        return this._pickedColor;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ColorPickerViewModel$1 */
    /* JADX INFO: compiled from: ColorPickerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ColorPickerViewModel$1", m1609f = "ColorPickerViewModel.kt", m1610i = {}, m1611l = {60}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {63}, m1615s = {}, m1616v = 2)
    static final class C66831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66831(Continuation<? super C66831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ColorPickerViewModel.this.new C66831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowAsFlow = FlowLiveDataConversions.asFlow(ColorPickerViewModel.this.colorRepository.getColorPolicy());
                final ColorPickerViewModel colorPickerViewModel = ColorPickerViewModel.this;
                this.label = 1;
                if (flowAsFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.penpanel.ColorPickerViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((IColorInversionPolicy) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(IColorInversionPolicy iColorInversionPolicy, Continuation<? super Unit> continuation) {
                        ColorPickerViewModel.updateColor$default(colorPickerViewModel, false, 1, null);
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
    }

    public final void hueChanged(float hue) {
        this.hsv[0] = hue;
        updateColor(true);
    }

    public final void saturationChanged(int saturation) {
        this.hsv[1] = saturation / SATURATION_BRIGHTNESS_MAX;
        updateColor(true);
    }

    public final void brightnessChanged(int brightness) {
        this.hsv[2] = brightness / SATURATION_BRIGHTNESS_MAX;
        updateColor(true);
    }

    static /* synthetic */ void updateColor$default(ColorPickerViewModel colorPickerViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        colorPickerViewModel.updateColor(z);
    }

    private final void updateColor(boolean fromUserAction) {
        int iHSVToColor = Color.HSVToColor(this.hsv);
        ColorPickerViewModel colorPickerViewModel = this;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(colorPickerViewModel), null, null, new C66841(iHSVToColor, null), 3, null);
        int iHSVToColor2 = Color.HSVToColor(new float[]{this.hsv[0], SATURATION_BRIGHTNESS_MAX, SATURATION_BRIGHTNESS_MAX});
        float[] fArr = this.hsv;
        int iHSVToColor3 = Color.HSVToColor(new float[]{fArr[0], SATURATION_BRIGHTNESS_MAX, fArr[2]});
        int i = (int) this.hsv[0];
        int iInvertColor = this.canInvertColor ? this.colorRepository.invertColor(-1) : -1;
        int iInvertColor2 = this.canInvertColor ? this.colorRepository.invertColor(iHSVToColor2) : iHSVToColor2;
        int iInvertColor3 = this.canInvertColor ? this.colorRepository.invertColor(iHSVToColor2) : iHSVToColor2;
        int i2 = (int) (this.hsv[1] * SATURATION_BRIGHTNESS_MAX);
        int iInvertColor4 = this.canInvertColor ? this.colorRepository.invertColor(-16777216) : -16777216;
        if (this.canInvertColor) {
            iHSVToColor2 = this.colorRepository.invertColor(iHSVToColor2);
        }
        int i3 = iHSVToColor2;
        if (this.canInvertColor) {
            iHSVToColor3 = this.colorRepository.invertColor(iHSVToColor3);
        }
        int i4 = iHSVToColor3;
        int i5 = (int) (this.hsv[2] * SATURATION_BRIGHTNESS_MAX);
        boolean z = !fromUserAction;
        if (this.canInvertColor) {
            iHSVToColor = this.colorRepository.invertColor(iHSVToColor);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(colorPickerViewModel), null, null, new C66852(new ColorPickerUIState(i, iInvertColor, iInvertColor2, iInvertColor3, 255, i2, iInvertColor4, i3, i4, 255, i5, z, iHSVToColor, this.canInvertColor ? this.colorRepository.invertColor(this.color) : this.color, !this.readOnly, !(this.colorRepository.getColorPolicy().getValue() instanceof IdentityColorInversionPolicy)), null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ColorPickerViewModel$updateColor$1 */
    /* JADX INFO: compiled from: ColorPickerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ColorPickerViewModel$updateColor$1", m1609f = "ColorPickerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $currentColor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66841(int i, Continuation<? super C66841> continuation) {
            super(2, continuation);
            this.$currentColor = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ColorPickerViewModel.this.new C66841(this.$currentColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ColorPickerViewModel.this._pickedColor.setValue(Boxing.boxInt(ColorUtils.setAlphaComponent(this.$currentColor, ColorPickerViewModel.this.alpha)));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ColorPickerViewModel$updateColor$2 */
    /* JADX INFO: compiled from: ColorPickerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ColorPickerViewModel$updateColor$2", m1609f = "ColorPickerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ColorPickerUIState $newState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66852(ColorPickerUIState colorPickerUIState, Continuation<? super C66852> continuation) {
            super(2, continuation);
            this.$newState = colorPickerUIState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ColorPickerViewModel.this.new C66852(this.$newState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ColorPickerViewModel.this._colorPickerUIState.setValue(this.$newState);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void resetColor() {
        Color.colorToHSV(this.color, this.hsv);
        updateColor$default(this, false, 1, null);
    }
}
