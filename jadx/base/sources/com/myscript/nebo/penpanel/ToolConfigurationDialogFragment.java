package com.myscript.nebo.penpanel;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.card.MaterialCardView;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.android.utils.DialogUtilsKt;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.common.ColorPolicyRepository;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.common.utils.DisplayMetricsExtKt;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.penpanel.InkTestView;
import com.myscript.nebo.penpanel.databinding.ToolconfigurationDialogBinding;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfigurationExt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001d\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\fH\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010+\u001a\u00020 2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u00106\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u00107\u001a\u00020 H\u0002J\u0012\u00108\u001a\u0002092\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010:\u001a\u00020 H\u0016J\b\u0010;\u001a\u00020 H\u0016J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0016J\u001a\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020C2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006E"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolConfigurationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/myscript/nebo/penpanel/AnchoredDialogFragment;", "<init>", "()V", "toolConfigurationViewModel", "Lcom/myscript/nebo/penpanel/ToolConfigurationViewModel;", "getToolConfigurationViewModel", "()Lcom/myscript/nebo/penpanel/ToolConfigurationViewModel;", "toolConfigurationViewModel$delegate", "Lkotlin/Lazy;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "shouldInvertColor", "", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "colorPolicy", "Lcom/myscript/nebo/common/ColorPolicyRepository;", "getColorPolicy", "()Lcom/myscript/nebo/common/ColorPolicyRepository;", "colorPolicy$delegate", "anchor", "Landroid/view/View;", "binding", "Lcom/myscript/nebo/penpanel/databinding/ToolconfigurationDialogBinding;", "inkTestView", "Lcom/myscript/nebo/penpanel/InkTestView;", "writingListener", "com/myscript/nebo/penpanel/ToolConfigurationDialogFragment$writingListener$1", "Lcom/myscript/nebo/penpanel/ToolConfigurationDialogFragment$writingListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onToolOptionsUpdate", "toolOptionStates", "", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "onDialogStateUpdate", "dialogState", "Lcom/myscript/nebo/penpanel/DialogState;", "onToolConfigurationUpdate", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "onToolOptionClicked", "onThicknessClicked", "updateDialogPosition", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onStop", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "onDestroy", "showAt", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolConfigurationDialogFragment extends DialogFragment implements AnchoredDialogFragment {
    private static final String CONTENT_TYPE = "CONTENT_TYPE";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_WRITING_KEY = "IS_WRITING_KEY";
    private static final String PAGE_BACKGROUND_COLOR = "PAGE_BACKGROUND_COLOR";
    public static final String REQUEST_KEY = "ToolConfigurationDialogFragment_REQUEST_KEY";
    public static final String RESULT_WRITING_KEY = "ToolConfigurationDialogFragment_RESULT_WRITING_KEY";
    public static final String TAG = "ToolConfigurationDialogFragment";
    private View anchor;
    private int backgroundColor;
    private ToolconfigurationDialogBinding binding;

    /* JADX INFO: renamed from: colorPolicy$delegate, reason: from kotlin metadata */
    private final Lazy colorPolicy;
    private InkTestView inkTestView;
    private boolean shouldInvertColor;

    /* JADX INFO: renamed from: toolConfigurationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy toolConfigurationViewModel;
    private ViewTransform viewTransform;
    private final ToolConfigurationDialogFragment$writingListener$1 writingListener;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$writingListener$1] */
    public ToolConfigurationDialogFragment() {
        final ToolConfigurationDialogFragment toolConfigurationDialogFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolConfigurationDialogFragment.toolConfigurationViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return toolConfigurationDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.toolConfigurationViewModel = FragmentViewModelLazyKt.createViewModelLazy(toolConfigurationDialogFragment, Reflection.getOrCreateKotlinClass(ToolConfigurationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
        this.shouldInvertColor = true;
        this.colorPolicy = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolConfigurationDialogFragment.colorPolicy_delegate$lambda$0(this.f$0);
            }
        });
        this.writingListener = new InkTestView.WritingListener() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$writingListener$1
            @Override // com.myscript.nebo.penpanel.InkTestView.WritingListener
            public void onWritingStarted() {
                ToolConfigurationDialogFragment toolConfigurationDialogFragment2 = this.this$0;
                Bundle bundle = new Bundle();
                bundle.putBoolean(ToolConfigurationDialogFragment.IS_WRITING_KEY, true);
                Unit unit = Unit.INSTANCE;
                FragmentKt.setFragmentResult(toolConfigurationDialogFragment2, ToolConfigurationDialogFragment.RESULT_WRITING_KEY, bundle);
            }

            @Override // com.myscript.nebo.penpanel.InkTestView.WritingListener
            public void onWritingStopped() {
                ToolConfigurationDialogFragment toolConfigurationDialogFragment2 = this.this$0;
                Bundle bundle = new Bundle();
                bundle.putBoolean(ToolConfigurationDialogFragment.IS_WRITING_KEY, false);
                Unit unit = Unit.INSTANCE;
                FragmentKt.setFragmentResult(toolConfigurationDialogFragment2, ToolConfigurationDialogFragment.RESULT_WRITING_KEY, bundle);
            }
        };
    }

    private final ToolConfigurationViewModel getToolConfigurationViewModel() {
        return (ToolConfigurationViewModel) this.toolConfigurationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory toolConfigurationViewModel_delegate$lambda$0(ToolConfigurationDialogFragment toolConfigurationDialogFragment) {
        Bundle arguments = toolConfigurationDialogFragment.getArguments();
        String string = arguments != null ? arguments.getString(CONTENT_TYPE) : null;
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Bundle arguments2 = toolConfigurationDialogFragment.getArguments();
        ToolConfiguration toolConfigurationAsToolConfiguration = arguments2 != null ? ToolbarConfigurationExt.asToolConfiguration(arguments2, string) : null;
        if (toolConfigurationAsToolConfiguration == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return new ToolConfigurationViewModelFactory(toolConfigurationAsToolConfiguration, string);
    }

    private final ColorPolicyRepository getColorPolicy() {
        return (ColorPolicyRepository) this.colorPolicy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorPolicyRepository colorPolicy_delegate$lambda$0(ToolConfigurationDialogFragment toolConfigurationDialogFragment) {
        ComponentCallbacks2 application = toolConfigurationDialogFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
        return ((ColorPolicyRepositoryProvider) application).provideColorPolicyRepository();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(2, getTheme());
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        DisplayMetrics fixedDisplayMetrics = DisplayMetricsExtKt.getFixedDisplayMetrics(fragmentActivityRequireActivity);
        this.viewTransform = new ViewTransform(fixedDisplayMetrics.xdpi, fixedDisplayMetrics.ydpi);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        if (bundleRequireArguments.getString(CONTENT_TYPE) == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        this.shouldInvertColor = !Intrinsics.areEqual(r0, ContentTypes.PDF);
        int iResolveBackgroundColor = bundleRequireArguments.getInt(PAGE_BACKGROUND_COLOR);
        if (this.shouldInvertColor) {
            iResolveBackgroundColor = PageBackgroundUtilsKt.resolveBackgroundColor(iResolveBackgroundColor, DarkModeUtils.isDarkMode(this));
        }
        this.backgroundColor = iResolveBackgroundColor;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout root;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ToolconfigurationDialogBinding toolconfigurationDialogBindingInflate = ToolconfigurationDialogBinding.inflate(LayoutInflater.from(requireActivity()), container, false);
        if (!getResources().getBoolean(C6693R.bool.pen_toolbar_fullscreen_dialog)) {
            toolconfigurationDialogBindingInflate.toolconfigurationToolbar.setNavigationIcon((Drawable) null);
        }
        toolconfigurationDialogBindingInflate.toolconfigurationTestHerePanel.setCardBackgroundColor(this.backgroundColor);
        this.binding = toolconfigurationDialogBindingInflate;
        this.inkTestView = (toolconfigurationDialogBindingInflate == null || (root = toolconfigurationDialogBindingInflate.getRoot()) == null) ? null : (InkTestView) root.findViewById(C6693R.id.toolconfiguration_ink_test_view);
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        return toolconfigurationDialogBinding != null ? toolconfigurationDialogBinding.getRoot() : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getToolConfigurationViewModel().getDialogState().observe(getViewLifecycleOwner(), new C6702xc8130a3(new C66941(this)));
        getToolConfigurationViewModel().getToolOptions().observe(getViewLifecycleOwner(), new C6702xc8130a3(new C66952(this)));
        getToolConfigurationViewModel().getCurrentToolConfiguration().observe(getViewLifecycleOwner(), new C6702xc8130a3(new C66963(this)));
        updateDialogPosition();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$onViewCreated$1 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66941 extends FunctionReferenceImpl implements Function1<DialogState, Unit> {
        C66941(Object obj) {
            super(1, obj, ToolConfigurationDialogFragment.class, "onDialogStateUpdate", "onDialogStateUpdate(Lcom/myscript/nebo/penpanel/DialogState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DialogState dialogState) {
            invoke2(dialogState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DialogState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ToolConfigurationDialogFragment) this.receiver).onDialogStateUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$onViewCreated$2 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66952 extends FunctionReferenceImpl implements Function1<List<? extends ToolOptionState>, Unit> {
        C66952(Object obj) {
            super(1, obj, ToolConfigurationDialogFragment.class, "onToolOptionsUpdate", "onToolOptionsUpdate(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ToolOptionState> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ToolOptionState> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ToolConfigurationDialogFragment) this.receiver).onToolOptionsUpdate(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$onViewCreated$3 */
    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66963 extends FunctionReferenceImpl implements Function1<ToolConfiguration, Unit> {
        C66963(Object obj) {
            super(1, obj, ToolConfigurationDialogFragment.class, "onToolConfigurationUpdate", "onToolConfigurationUpdate(Lcom/myscript/snt/core/ToolConfiguration;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ToolConfiguration toolConfiguration) {
            invoke2(toolConfiguration);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ToolConfiguration p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ToolConfigurationDialogFragment) this.receiver).onToolConfigurationUpdate(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onToolOptionsUpdate(List<? extends ToolOptionState> toolOptionStates) {
        LinearLayout linearLayout;
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        if (toolconfigurationDialogBinding == null || (linearLayout = toolconfigurationDialogBinding.toolconfigurationOptionsButtons) == null) {
            return;
        }
        linearLayout.setVisibility(!toolOptionStates.isEmpty() ? 0 : 8);
        if (linearLayout.getChildCount() == 0) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(requireActivity());
            for (ToolOptionState toolOptionState : toolOptionStates) {
                View viewInflate = layoutInflaterFrom.inflate(C6693R.layout.stroker_button_view, (ViewGroup) linearLayout, false);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) viewInflate;
                Drawable drawable = ResourcesCompat.getDrawable(textView.getResources(), toolOptionState.getToolOption().getIconRes(), textView.getContext().getTheme());
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                textView.setText(toolOptionState.getToolOption().getLabelRes());
                int iInvertColor = this.shouldInvertColor ? getColorPolicy().invertColor(toolOptionState.getColor()) : toolOptionState.getColor();
                LayerDrawable layerDrawable = drawable instanceof LayerDrawable ? (LayerDrawable) drawable : null;
                Drawable drawableFindDrawableByLayerId = layerDrawable != null ? layerDrawable.findDrawableByLayerId(C6693R.id.tool_colored_layer) : null;
                if (drawableFindDrawableByLayerId != null) {
                    drawableFindDrawableByLayerId.setTint(iInvertColor);
                }
                textView.setSelected(toolOptionState.getIsSelected());
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
                textView.setTag(toolOptionState.getToolOption());
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.onToolOptionClicked(view);
                    }
                });
                linearLayout.addView(textView);
            }
            return;
        }
        for (ToolOptionState toolOptionState2 : toolOptionStates) {
            TextView textView2 = (TextView) linearLayout.findViewWithTag(toolOptionState2.getToolOption());
            if (textView2 != null) {
                textView2.setSelected(toolOptionState2.getIsSelected());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDialogStateUpdate(DialogState dialogState) {
        Toolbar toolbar;
        MaterialCardView materialCardView;
        LinearLayout linearLayout;
        Toolbar toolbar2;
        int titleRes = dialogState.getTitleRes();
        if (titleRes != 0) {
            ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
            if (toolconfigurationDialogBinding != null && (toolbar2 = toolconfigurationDialogBinding.toolconfigurationToolbar) != null) {
                toolbar2.setTitle(titleRes);
            }
        } else {
            ToolconfigurationDialogBinding toolconfigurationDialogBinding2 = this.binding;
            if (toolconfigurationDialogBinding2 != null && (toolbar = toolconfigurationDialogBinding2.toolconfigurationToolbar) != null) {
                toolbar.setTitle((CharSequence) null);
            }
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding3 = this.binding;
        if (toolconfigurationDialogBinding3 != null && (linearLayout = toolconfigurationDialogBinding3.toolconfigurationThicknessButtons) != null) {
            List<ThicknessPill> thicknesses = dialogState.getThicknesses();
            linearLayout.setVisibility(!thicknesses.isEmpty() ? 0 : 8);
            if (linearLayout.getChildCount() == 0) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(requireActivity());
                for (ThicknessPill thicknessPill : thicknesses) {
                    View viewInflate = layoutInflaterFrom.inflate(C6693R.layout.thickness_pill_view, (ViewGroup) linearLayout, false);
                    Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ImageView");
                    ImageView imageView = (ImageView) viewInflate;
                    imageView.setImageResource(thicknessPill.getIconRes());
                    imageView.setTag(thicknessPill);
                    imageView.setOnClickListener(new ToolConfigurationDialogFragment$$ExternalSyntheticLambda0(this));
                    linearLayout.addView(imageView);
                }
            }
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding4 = this.binding;
        if (toolconfigurationDialogBinding4 == null || (materialCardView = toolconfigurationDialogBinding4.toolconfigurationTestHerePanel) == null) {
            return;
        }
        materialCardView.setVisibility(dialogState.getShowTestArea() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onToolConfigurationUpdate(ToolConfiguration toolConfiguration) {
        int iInvertColor;
        LinearLayout linearLayout;
        if (toolConfiguration.getType() == ToolType.Highlighter && Intrinsics.areEqual(toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR), ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE)) {
            iInvertColor = 0;
        } else {
            iInvertColor = this.shouldInvertColor ? getColorPolicy().invertColor(toolConfiguration.getColor2()) : toolConfiguration.getColor2();
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        if (toolconfigurationDialogBinding != null && (linearLayout = toolconfigurationDialogBinding.toolconfigurationThicknessButtons) != null) {
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    ThicknessPill thicknessPill = tag instanceof ThicknessPill ? (ThicknessPill) tag : null;
                    childAt.setSelected(Intrinsics.areEqual(thicknessPill != null ? Float.valueOf(thicknessPill.getThicknessRatio()) : null, toolConfiguration.getThicknessRatio()));
                }
            }
        }
        InkTestView inkTestView = this.inkTestView;
        if (inkTestView != null) {
            inkTestView.setInkStroking(ToolbarConfigurationExt.getStroker(toolConfiguration));
            inkTestView.setInkColor(iInvertColor);
            ViewTransform viewTransform = this.viewTransform;
            if (viewTransform == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewTransform");
                viewTransform = null;
            }
            inkTestView.setInkWidth(ToolbarConfigurationExt.getInkThicknessForScreen$default(toolConfiguration, viewTransform, null, 2, null));
        }
        FragmentKt.setFragmentResult(this, REQUEST_KEY, ToolbarConfigurationExt.asBundle(toolConfiguration));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onToolOptionClicked(View view) {
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof ToolOption) {
            getToolConfigurationViewModel().setToolOption((ToolOption) tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onThicknessClicked(View view) {
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof ThicknessPill) {
            getToolConfigurationViewModel().selectThickness(((ThicknessPill) tag).getThicknessRatio());
        }
    }

    private final void updateDialogPosition() {
        Window window;
        View view;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null || (view = this.anchor) == null) {
            return;
        }
        window.clearFlags(2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.gravity = 8388659;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        layoutParams.x = iArr[0];
        layoutParams.y = iArr[1] - view.getHeight();
        window.setAttributes(layoutParams);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return ToolConfigurationDialogFragment.onCreateDialog$lambda$0$0(dialogOnCreateDialog, dialogInterface, i, keyEvent);
            }
        });
        Intrinsics.checkNotNull(dialogOnCreateDialog);
        DialogUtilsKt.configureForEdgeToEdge(dialogOnCreateDialog);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0$0(Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        LinearLayout linearLayout;
        Sequence<View> children;
        Toolbar toolbar;
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        if (toolconfigurationDialogBinding != null && (toolbar = toolconfigurationDialogBinding.toolconfigurationToolbar) != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.ToolConfigurationDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding2 = this.binding;
        if (toolconfigurationDialogBinding2 != null && (linearLayout = toolconfigurationDialogBinding2.toolconfigurationThicknessButtons) != null && (children = ViewGroupKt.getChildren(linearLayout)) != null) {
            Iterator<View> it = children.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(new ToolConfigurationDialogFragment$$ExternalSyntheticLambda0(this));
            }
        }
        InkTestView inkTestView = this.inkTestView;
        if (inkTestView != null) {
            inkTestView.setWritingListener(this.writingListener);
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        LinearLayout linearLayout;
        Sequence<View> children;
        LinearLayout linearLayout2;
        Sequence<View> children2;
        Toolbar toolbar;
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        if (toolconfigurationDialogBinding != null && (toolbar = toolconfigurationDialogBinding.toolconfigurationToolbar) != null) {
            toolbar.setNavigationOnClickListener(null);
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding2 = this.binding;
        if (toolconfigurationDialogBinding2 != null && (linearLayout2 = toolconfigurationDialogBinding2.toolconfigurationOptionsButtons) != null && (children2 = ViewGroupKt.getChildren(linearLayout2)) != null) {
            Iterator<View> it = children2.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding3 = this.binding;
        if (toolconfigurationDialogBinding3 != null && (linearLayout = toolconfigurationDialogBinding3.toolconfigurationThicknessButtons) != null && (children = ViewGroupKt.getChildren(linearLayout)) != null) {
            Iterator<View> it2 = children.iterator();
            while (it2.hasNext()) {
                it2.next().setOnClickListener(null);
            }
        }
        InkTestView inkTestView = this.inkTestView;
        if (inkTestView != null) {
            inkTestView.setWritingListener(null);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        LinearLayout linearLayout;
        Sequence<View> children;
        LinearLayout linearLayout2;
        Sequence<View> children2;
        Toolbar toolbar;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ToolconfigurationDialogBinding toolconfigurationDialogBinding = this.binding;
        if (toolconfigurationDialogBinding != null && (toolbar = toolconfigurationDialogBinding.toolconfigurationToolbar) != null) {
            toolbar.setNavigationOnClickListener(null);
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding2 = this.binding;
        if (toolconfigurationDialogBinding2 != null && (linearLayout2 = toolconfigurationDialogBinding2.toolconfigurationOptionsButtons) != null && (children2 = ViewGroupKt.getChildren(linearLayout2)) != null) {
            Iterator<View> it = children2.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
        }
        ToolconfigurationDialogBinding toolconfigurationDialogBinding3 = this.binding;
        if (toolconfigurationDialogBinding3 == null || (linearLayout = toolconfigurationDialogBinding3.toolconfigurationThicknessButtons) == null || (children = ViewGroupKt.getChildren(linearLayout)) == null) {
            return;
        }
        Iterator<View> it2 = children.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.binding = null;
        this.inkTestView = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.anchor = null;
        super.onDestroy();
    }

    @Override // com.myscript.nebo.penpanel.AnchoredDialogFragment
    public void showAt(FragmentManager fragmentManager, View anchor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.anchor = anchor;
        if (isAdded()) {
            updateDialogPosition();
        } else {
            show(fragmentManager, TAG);
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolConfigurationDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", "RESULT_WRITING_KEY", ToolConfigurationDialogFragment.IS_WRITING_KEY, ToolConfigurationDialogFragment.PAGE_BACKGROUND_COLOR, ToolConfigurationDialogFragment.CONTENT_TYPE, "newInstance", "Lcom/myscript/nebo/penpanel/ToolConfigurationDialogFragment;", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "contentType", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToolConfigurationDialogFragment newInstance(ToolConfiguration toolConfiguration, int backgroundColor, String contentType) {
            Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            ToolConfigurationDialogFragment toolConfigurationDialogFragment = new ToolConfigurationDialogFragment();
            Bundle bundleAsBundle = ToolbarConfigurationExt.asBundle(toolConfiguration);
            bundleAsBundle.putInt(ToolConfigurationDialogFragment.PAGE_BACKGROUND_COLOR, backgroundColor);
            bundleAsBundle.putString(ToolConfigurationDialogFragment.CONTENT_TYPE, contentType);
            toolConfigurationDialogFragment.setArguments(bundleAsBundle);
            return toolConfigurationDialogFragment;
        }
    }
}
