package com.myscript.nebo.penpanel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.myscript.atk.core.ContentTypes;
import com.myscript.nebo.penpanel.ToolOptionState;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolConfigurationViewModel;", "Landroidx/lifecycle/ViewModel;", "initialToolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "contentType", "", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lcom/myscript/snt/core/ToolConfiguration;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "toolConfiguration", "_dialogState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/penpanel/DialogState;", "kotlin.jvm.PlatformType", "dialogState", "Landroidx/lifecycle/LiveData;", "getDialogState", "()Landroidx/lifecycle/LiveData;", "rawToolOptions", "", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "_toolOptions", "toolOptions", "getToolOptions", "_currentToolConfiguration", "currentToolConfiguration", "getCurrentToolConfiguration", "updateToolOptions", "setToolOption", "", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "selectThickness", "value", "", "toolConfigurationChanged", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolConfigurationViewModel extends ViewModel {
    private final MutableLiveData<ToolConfiguration> _currentToolConfiguration;
    private final MutableLiveData<DialogState> _dialogState;
    private final MutableLiveData<List<ToolOptionState>> _toolOptions;
    private final ToolConfiguration initialToolConfiguration;
    private final CoroutineContext mainDispatcher;
    private final List<ToolOptionState> rawToolOptions;
    private final ToolConfiguration toolConfiguration;

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolType.values().length];
            try {
                iArr[ToolType.Pen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Highlighter.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolType.Lasso.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ToolConfigurationViewModel(ToolConfiguration initialToolConfiguration, String contentType, CoroutineContext mainDispatcher) {
        List<ToolOptionState> listListOf;
        Intrinsics.checkNotNullParameter(initialToolConfiguration, "initialToolConfiguration");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.initialToolConfiguration = initialToolConfiguration;
        this.mainDispatcher = mainDispatcher;
        ToolConfiguration toolConfiguration = new ToolConfiguration(initialToolConfiguration.getType(), initialToolConfiguration.getColor2(), initialToolConfiguration.getThicknessRatio());
        toolConfiguration.setState(initialToolConfiguration.getState());
        ToolType type = initialToolConfiguration.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            String property = initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER);
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER, property.length() == 0 ? ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_DEFAULT : property);
        } else if (i == 2) {
            String property2 = initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY);
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY, property2.length() == 0 ? ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_DEFAULT : property2);
        } else if (i == 3) {
            String property3 = initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY);
            Intrinsics.checkNotNull(property3);
            if (property3.length() > 0) {
                toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, property3);
            }
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR, initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR));
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR, initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR));
        } else if (i == 4) {
            String property4 = initialToolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE);
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE, property4.length() == 0 ? ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_DEFAULT : property4);
        }
        this.toolConfiguration = toolConfiguration;
        this._dialogState = new MutableLiveData<>(DialogState.INSTANCE.from(toolConfiguration));
        ToolType type2 = toolConfiguration.getType();
        int i2 = type2 != null ? WhenMappings.$EnumSwitchMapping$0[type2.ordinal()] : -1;
        if (i2 == 1) {
            listListOf = CollectionsKt.listOf((Object[]) new ToolOptionState.Brush[]{ToolOptionState.Brush.Felt.INSTANCE, ToolOptionState.Brush.Fountain.INSTANCE, ToolOptionState.Brush.Calligraphic.INSTANCE});
        } else if (i2 == 2) {
            listListOf = CollectionsKt.listOf((Object[]) new ToolOptionState.EraserPolicy[]{ToolOptionState.EraserPolicy.Stroke.INSTANCE, ToolOptionState.EraserPolicy.Precise.INSTANCE});
        } else if (i2 != 3) {
            if (i2 == 4) {
                listListOf = CollectionsKt.listOf((Object[]) new ToolOptionState.LassoShape[]{ToolOptionState.LassoShape.Polygon.INSTANCE, ToolOptionState.LassoShape.Rectangle.INSTANCE});
            } else {
                listListOf = CollectionsKt.emptyList();
            }
        } else if (Intrinsics.areEqual(contentType, ContentTypes.RAW_CONTENT) || Intrinsics.areEqual(contentType, ContentTypes.PDF)) {
            listListOf = CollectionsKt.listOf((Object[]) new ToolOptionState.HighLighterPolicy[]{ToolOptionState.HighLighterPolicy.Sketch.INSTANCE, ToolOptionState.HighLighterPolicy.Smart.INSTANCE});
        } else {
            listListOf = CollectionsKt.emptyList();
        }
        this.rawToolOptions = listListOf;
        this._toolOptions = new MutableLiveData<>();
        this._currentToolConfiguration = new MutableLiveData<>(toolConfiguration);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), mainDispatcher, null, new C67031(null), 2, null);
    }

    public /* synthetic */ ToolConfigurationViewModel(ToolConfiguration toolConfiguration, String str, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(toolConfiguration, str, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    public final LiveData<DialogState> getDialogState() {
        return this._dialogState;
    }

    public final LiveData<List<ToolOptionState>> getToolOptions() {
        return this._toolOptions;
    }

    public final LiveData<ToolConfiguration> getCurrentToolConfiguration() {
        return this._currentToolConfiguration;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationViewModel$1 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolConfigurationViewModel$1", m1609f = "ToolConfigurationDialogFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67031(Continuation<? super C67031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolConfigurationViewModel.this.new C67031(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ToolConfigurationViewModel.this._toolOptions.setValue(ToolConfigurationViewModel.this.updateToolOptions());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ToolOptionState> updateToolOptions() {
        List<ToolOptionState> list = this.rawToolOptions;
        for (ToolOptionState toolOptionState : list) {
            if (toolOptionState instanceof ToolOptionState.Brush) {
                ((ToolOptionState.Brush) toolOptionState).setColor(this.toolConfiguration.getColor2());
            }
            toolOptionState.setSelected(Intrinsics.areEqual(this.toolConfiguration.getProperty(toolOptionState.getToolOption().getPropertyKey()), toolOptionState.getToolOption().getPropertyValue()));
        }
        return list;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationViewModel$setToolOption$1 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolConfigurationViewModel$setToolOption$1", m1609f = "ToolConfigurationDialogFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67051(Continuation<? super C67051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolConfigurationViewModel.this.new C67051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ToolConfigurationViewModel.this._toolOptions.setValue(ToolConfigurationViewModel.this.updateToolOptions());
                ToolConfigurationViewModel.this._currentToolConfiguration.setValue(ToolConfigurationViewModel.this.toolConfiguration);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setToolOption(ToolOption toolOption) {
        Intrinsics.checkNotNullParameter(toolOption, "toolOption");
        this.toolConfiguration.setProperty(toolOption.getPropertyKey(), toolOption.getPropertyValue());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67051(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationViewModel$selectThickness$1 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolConfigurationViewModel$selectThickness$1", m1609f = "ToolConfigurationDialogFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67041(Continuation<? super C67041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolConfigurationViewModel.this.new C67041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ToolConfigurationViewModel.this._currentToolConfiguration.setValue(ToolConfigurationViewModel.this.toolConfiguration);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void selectThickness(float value) {
        this.toolConfiguration.setThicknessRatio(value);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67041(null), 2, null);
    }

    public final boolean toolConfigurationChanged() {
        return !Intrinsics.areEqual(this.toolConfiguration, this.initialToolConfiguration);
    }
}
