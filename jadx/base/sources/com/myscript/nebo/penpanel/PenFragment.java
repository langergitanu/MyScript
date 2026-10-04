package com.myscript.nebo.penpanel;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.atk.core.ContentTypes;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.penpanel.ToolConfigurationDialogFragment;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolState;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfigurationExt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PenFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0002qrB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u00010\u001b2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020'H\u0016J\b\u0010;\u001a\u00020'H\u0016J\b\u0010<\u001a\u00020'H\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020'H\u0002J\b\u0010C\u001a\u00020'H\u0016J\b\u0010D\u001a\u00020'H\u0002J\u0016\u0010E\u001a\u00020'2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GH\u0002J\u0016\u0010I\u001a\u00020'2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0GH\u0002J\u0010\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u0010H\u0002J\u0018\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u0010H\u0002J\b\u0010X\u001a\u00020'H\u0002J\u0012\u0010Y\u001a\u00020'2\b\b\u0001\u0010Z\u001a\u00020\u0010H\u0016J\b\u0010[\u001a\u00020'H\u0016J\b\u0010\\\u001a\u00020'H\u0016J$\u0010]\u001a\u00020'2\b\b\u0001\u0010^\u001a\u00020\u00102\u0006\u0010_\u001a\u00020`2\b\b\u0002\u0010a\u001a\u00020bH\u0002J\n\u0010c\u001a\u0004\u0018\u00010dH\u0002J\u0010\u0010e\u001a\u00020'2\u0006\u0010f\u001a\u00020dH\u0002J\b\u0010g\u001a\u00020'H\u0002J\u0010\u0010h\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\n\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0010\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020jH\u0002J\u0006\u0010m\u001a\u00020'J\u0010\u0010n\u001a\u00020'2\b\b\u0001\u0010Z\u001a\u00020\u0010J\u0010\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010_\u001a\u00020`R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/penpanel/ColorPickerActionListener;", "<init>", "()V", "callback", "Lcom/myscript/nebo/penpanel/PenFragment$Callback;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "contentType", "", "testAreaBackgroundColor", "", "toolbarViewModel", "Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "getToolbarViewModel", "()Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "toolbarViewModel$delegate", "toolsAdapter", "Lcom/myscript/nebo/penpanel/ToolListAdapter;", "toolsList", "Landroidx/recyclerview/widget/RecyclerView;", "selectedToolAnchor", "Landroid/view/View;", "colorsAdapter", "Lcom/myscript/nebo/penpanel/ColorListAdapter;", "colorsList", "colorDragHelper", "Lcom/myscript/nebo/penpanel/LinearDragHelper;", "colorPickerAnchor", "addColorButton", "colorNone", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "logAction", "", "action", "details", "logToolConfigurationState", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onColorNoneStateChanged", "colorNoneState", "Lcom/myscript/nebo/penpanel/ColorNonePill;", "onStart", "onStop", "onDestroyView", "onAttach", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "internalOnAttach", "onDetach", "displayColorSelectionErrorMessage", "onToolListChanged", "tools", "", "Lcom/myscript/nebo/penpanel/ToolPill;", "onColorListChanged", "colors", "Lcom/myscript/nebo/penpanel/ColorPill;", "scrollToColor", FirebaseAnalytics.Param.INDEX, "onToolClicked", "tool", "toolPillView", "Lcom/myscript/nebo/penpanel/ToolPillView;", "onColorClicked", "viewHolder", "Lcom/myscript/nebo/penpanel/ColorPillViewHolder;", "onColorDropped", "fromPosition", "toPosition", "onAddColorClicked", "colorChanged", "color", "colorRemoved", "colorDuplicated", "openColorPicker", "editedColor", "toolType", "Lcom/myscript/snt/core/ToolType;", "isReadOnly", "", "findColorPickerFragment", "Lcom/myscript/nebo/penpanel/ColorPickerFragment;", "setupColorPicker", "colorPickerFragment", "closeColorPicker", "openToolConfigurationDialog", "findThicknessPickerFragment", "Lcom/myscript/nebo/penpanel/ToolConfigurationDialogFragment;", "setupThicknessPickerFragment", "thicknessPickerFragment", "toggleColorPicker", "setPageBackgroundColor", "toolLocation", "Landroid/graphics/Rect;", "Callback", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PenFragment extends Fragment implements ColorPickerActionListener {
    private static final String CONTENT_TYPE_KEY = "CONTENT_TYPE_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHOW_KEYBOARD_ON_TAP_DEFAULT_VALUE_KEY = "SHOW_KEYBOARD_ON_TAP_DEFAULT_VALUE_KEY";
    private static final String SHOW_KEYBOARD_ON_TAP_PREF_KEY = "SHOW_KEYBOARD_ON_TAP_PREF_KEY";
    public static final String TAG = "PenFragment";
    private View addColorButton;
    private Callback callback;
    private View colorNone;
    private View colorPickerAnchor;
    private RecyclerView colorsList;
    private String contentType;
    private View selectedToolAnchor;
    private int testAreaBackgroundColor;

    /* JADX INFO: renamed from: toolbarViewModel$delegate, reason: from kotlin metadata */
    private final Lazy toolbarViewModel;
    private RecyclerView toolsList;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PenFragment.logger_delegate$lambda$0(this.f$0);
        }
    });
    private final ToolListAdapter toolsAdapter = new ToolListAdapter(new PenFragment$toolsAdapter$1(this));
    private final ColorListAdapter colorsAdapter = new ColorListAdapter(new PenFragment$colorsAdapter$1(this));
    private final LinearDragHelper colorDragHelper = new LinearDragHelper(0, new Function1() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(PenFragment.colorDragHelper$lambda$0((RecyclerView.ViewHolder) obj));
        }
    }, new PenFragment$colorDragHelper$2(this), 1, null);
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda7
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            PenFragment.onGlobalLayoutListener$lambda$0(this.f$0);
        }
    };

    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenFragment$Callback;", "", "onPenToolbarLayout", "", "onPenOptionsDiscovered", "toolType", "Lcom/myscript/snt/core/ToolType;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onPenOptionsDiscovered(ToolType toolType);

        void onPenToolbarLayout();
    }

    /* JADX INFO: compiled from: PenFragment.kt */
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
                iArr[ToolType.Highlighter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolType.Lasso.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final PenFragment newInstance(String str, String str2, boolean z) {
        return INSTANCE.newInstance(str, str2, z);
    }

    public PenFragment() {
        final PenFragment penFragment = this;
        final Function0 function0 = null;
        this.toolbarViewModel = FragmentViewModelLazyKt.createViewModelLazy(penFragment, Reflection.getOrCreateKotlinClass(ToolbarViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.penpanel.PenFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return penFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.penpanel.PenFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? penFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PenFragment.toolbarViewModel_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(PenFragment penFragment) {
        ComponentCallbacks2 application = penFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ToolbarViewModel getToolbarViewModel() {
        return (ToolbarViewModel) this.toolbarViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory toolbarViewModel_delegate$lambda$0(PenFragment penFragment) {
        String string = penFragment.requireArguments().getString(CONTENT_TYPE_KEY);
        if (string == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        return new ToolbarViewModelFactory(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean colorDragHelper$lambda$0(RecyclerView.ViewHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAdapterPosition() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGlobalLayoutListener$lambda$0(PenFragment penFragment) {
        Callback callback = penFragment.callback;
        if (callback != null) {
            callback.onPenToolbarLayout();
        }
    }

    static /* synthetic */ void logAction$default(PenFragment penFragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        penFragment.logAction(str, str2);
    }

    private final void logAction(String action, String details) {
        String str = details;
        getLogger().logTrace("[PenFragment] " + action + ((str == null || StringsKt.isBlank(str)) ? "" : ": " + details));
    }

    private final void logToolConfigurationState(String action, ToolConfiguration toolConfiguration) {
        ToolType type = toolConfiguration.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            logAction(action, toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER) + " " + toolConfiguration.getThicknessRatio());
            return;
        }
        if (i == 2) {
            logAction(action, String.valueOf(toolConfiguration.getThicknessRatio()));
            return;
        }
        if (i == 3) {
            logAction(action, toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY) + " " + toolConfiguration.getThicknessRatio());
        } else if (i == 4) {
            logAction(action, toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE));
        } else {
            logAction("Tool configuration changed", type.name());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = requireArguments().getString(CONTENT_TYPE_KEY);
        if (string == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.contentType = string;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6693R.layout.toolbar, container, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6693R.id.tools_list);
        recyclerView.setAdapter(this.toolsAdapter);
        this.toolsList = recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(C6693R.id.colors_list);
        recyclerView2.setAdapter(this.colorsAdapter);
        this.colorDragHelper.attachToRecyclerView(recyclerView2);
        this.colorsList = recyclerView2;
        this.addColorButton = viewInflate.findViewById(C6693R.id.action_add_color);
        this.colorNone = viewInflate.findViewById(C6693R.id.highlighter_color_none);
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.PenFragment$onViewCreated$1 */
    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66901 extends FunctionReferenceImpl implements Function1<List<? extends ToolPill>, Unit> {
        C66901(Object obj) {
            super(1, obj, PenFragment.class, "onToolListChanged", "onToolListChanged(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ToolPill> list) {
            invoke2((List<ToolPill>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ToolPill> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PenFragment) this.receiver).onToolListChanged(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getToolbarViewModel().getTools().observe(getViewLifecycleOwner(), new PenFragmentKt$sam$androidx_lifecycle_Observer$0(new C66901(this)));
        getToolbarViewModel().getColors().observe(getViewLifecycleOwner(), new PenFragmentKt$sam$androidx_lifecycle_Observer$0(new C66912(this)));
        getToolbarViewModel().getColorNone().observe(getViewLifecycleOwner(), new PenFragmentKt$sam$androidx_lifecycle_Observer$0(new C66923(this)));
        final ColorPickerFragment colorPickerFragmentFindColorPickerFragment = findColorPickerFragment();
        if (colorPickerFragmentFindColorPickerFragment != null && (recyclerView2 = this.colorsList) != null) {
            RecyclerView recyclerView3 = recyclerView2;
            if (recyclerView3.isLaidOut() && !recyclerView3.isLayoutRequested()) {
                RecyclerView recyclerView4 = this.colorsList;
                this.colorPickerAnchor = (recyclerView4 == null || (viewHolderFindViewHolderForAdapterPosition = recyclerView4.findViewHolderForAdapterPosition(getToolbarViewModel().getSelectedColorIndex())) == null) ? null : viewHolderFindViewHolderForAdapterPosition.itemView;
                setupColorPicker(colorPickerFragmentFindColorPickerFragment);
            } else {
                recyclerView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.penpanel.PenFragment$onViewCreated$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2;
                        view2.removeOnLayoutChangeListener(this);
                        PenFragment penFragment = this.this$0;
                        RecyclerView recyclerView5 = penFragment.colorsList;
                        penFragment.colorPickerAnchor = (recyclerView5 == null || (viewHolderFindViewHolderForAdapterPosition2 = recyclerView5.findViewHolderForAdapterPosition(this.this$0.getToolbarViewModel().getSelectedColorIndex())) == null) ? null : viewHolderFindViewHolderForAdapterPosition2.itemView;
                        this.this$0.setupColorPicker(colorPickerFragmentFindColorPickerFragment);
                    }
                });
            }
        }
        final ToolConfigurationDialogFragment toolConfigurationDialogFragmentFindThicknessPickerFragment = findThicknessPickerFragment();
        if (toolConfigurationDialogFragmentFindThicknessPickerFragment != null && (recyclerView = this.toolsList) != null) {
            RecyclerView recyclerView5 = recyclerView;
            if (recyclerView5.isLaidOut() && !recyclerView5.isLayoutRequested()) {
                int size = this.toolsAdapter.getCurrentList().size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        RecyclerView recyclerView6 = this.toolsList;
                        View childAt = recyclerView6 != null ? recyclerView6.getChildAt(i) : null;
                        if (childAt != null && childAt.isSelected()) {
                            this.selectedToolAnchor = childAt;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                setupThicknessPickerFragment(toolConfigurationDialogFragmentFindThicknessPickerFragment);
            } else {
                recyclerView5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.penpanel.PenFragment$onViewCreated$$inlined$doOnLayout$2
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        view2.removeOnLayoutChangeListener(this);
                        int size2 = this.this$0.toolsAdapter.getCurrentList().size();
                        int i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                RecyclerView recyclerView7 = this.this$0.toolsList;
                                View childAt2 = recyclerView7 != null ? recyclerView7.getChildAt(i2) : null;
                                if (childAt2 != null && childAt2.isSelected()) {
                                    this.this$0.selectedToolAnchor = childAt2;
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        this.this$0.setupThicknessPickerFragment(toolConfigurationDialogFragmentFindThicknessPickerFragment);
                    }
                });
            }
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.PenFragment$onViewCreated$2 */
    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66912 extends FunctionReferenceImpl implements Function1<List<? extends ColorPill>, Unit> {
        C66912(Object obj) {
            super(1, obj, PenFragment.class, "onColorListChanged", "onColorListChanged(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ColorPill> list) {
            invoke2((List<ColorPill>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ColorPill> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PenFragment) this.receiver).onColorListChanged(p0);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.PenFragment$onViewCreated$3 */
    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66923 extends FunctionReferenceImpl implements Function1<ColorNonePill, Unit> {
        C66923(Object obj) {
            super(1, obj, PenFragment.class, "onColorNoneStateChanged", "onColorNoneStateChanged(Lcom/myscript/nebo/penpanel/ColorNonePill;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ColorNonePill colorNonePill) {
            invoke2(colorNonePill);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ColorNonePill p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PenFragment) this.receiver).onColorNoneStateChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorNoneStateChanged(ColorNonePill colorNoneState) {
        View view = this.colorNone;
        if (view != null) {
            view.setVisibility(colorNoneState.isVisible() ? 0 : 8);
        }
        View view2 = this.colorNone;
        if (view2 != null) {
            view2.setSelected(colorNoneState.isSelected());
        }
        View view3 = this.colorNone;
        if (view3 != null) {
            view3.setEnabled(colorNoneState.isEnabled());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.addColorButton;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PenFragment.onStart$lambda$0(this.f$0, view2);
                }
            });
        }
        View view2 = this.colorNone;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    PenFragment.onStart$lambda$1(this.f$0, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(PenFragment penFragment, View view) {
        logAction$default(penFragment, "Add Color", null, 2, null);
        penFragment.onAddColorClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$1(PenFragment penFragment, View view) {
        penFragment.getToolbarViewModel().activateNoneColor();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        View view = this.colorNone;
        if (view != null) {
            view.setOnClickListener(null);
        }
        View view2 = this.addColorButton;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = getView();
        ViewTreeObserver viewTreeObserver = view != null ? view.getViewTreeObserver() : null;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
        RecyclerView recyclerView = this.colorsList;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.colorsList = null;
        this.colorPickerAnchor = null;
        RecyclerView recyclerView2 = this.toolsList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(null);
        }
        this.toolsList = null;
        this.selectedToolAnchor = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        internalOnAttach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        internalOnAttach();
    }

    private final void internalOnAttach() {
        KeyEventDispatcher.Component activity = getActivity();
        this.callback = activity instanceof Callback ? (Callback) activity : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.callback = null;
        super.onDetach();
    }

    private final void displayColorSelectionErrorMessage() {
        String str = this.contentType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentType");
            str = null;
        }
        if (PageController.isKeyboardCompatible(str)) {
            logAction$default(this, "Color Selection Error", null, 2, null);
            Toast.makeText(requireContext(), C6693R.string.pen_panel_color_selection_not_available, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onToolListChanged(List<ToolPill> tools) {
        ToolConfiguration toolConfigurationFindToolConfigurationByType;
        ToolType selectedToolTypeValue = getToolbarViewModel().getSelectedToolTypeValue();
        if (PenFragmentKt.isConfigurableTool(selectedToolTypeValue) && (toolConfigurationFindToolConfigurationByType = getToolbarViewModel().findToolConfigurationByType(selectedToolTypeValue)) != null && toolConfigurationFindToolConfigurationByType.getState() != ToolState.Unselected) {
            getToolbarViewModel().saveSelectedColor(toolConfigurationFindToolConfigurationByType);
        }
        this.toolsAdapter.submitList(tools);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onColorListChanged(List<ColorPill> colors) {
        RecyclerView recyclerView;
        final int selectedColorIndex = getToolbarViewModel().getSelectedColorIndex();
        boolean z = false;
        int i = -1;
        if (selectedColorIndex != -1) {
            if (this.colorsAdapter.getItemCount() != colors.size()) {
                z = true;
            } else {
                List<ColorPill> currentList = this.colorsAdapter.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                Iterator<ColorPill> it = currentList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().isSelected()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i != selectedColorIndex) {
                }
            }
        }
        this.colorsAdapter.submitList(colors);
        if (!z || (recyclerView = this.colorsList) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView2.isLaidOut() && !recyclerView2.isLayoutRequested()) {
            scrollToColor(selectedColorIndex);
        } else {
            recyclerView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.penpanel.PenFragment$onColorListChanged$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.scrollToColor(selectedColorIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToColor(int index) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2 = this.colorsList;
        RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if ((index < iFindFirstCompletelyVisibleItemPosition || index > iFindLastCompletelyVisibleItemPosition) && (recyclerView = this.colorsList) != null) {
                recyclerView.smoothScrollToPosition(index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onToolClicked(ToolConfiguration tool, ToolPillView toolPillView) {
        ToolType type = tool.getType();
        Intrinsics.checkNotNull(type);
        if (PenFragmentKt.isConfigurableTool(type) && tool.getState() == ToolState.Selected) {
            this.selectedToolAnchor = toolPillView;
            openToolConfigurationDialog(tool);
        } else {
            getToolbarViewModel().changeTool(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorClicked(ColorPillViewHolder viewHolder) {
        ColorPill colorPill = viewHolder.getColorPill();
        if (colorPill != null) {
            int adapterPosition = viewHolder.getAdapterPosition();
            if (colorPill.isSelected()) {
                this.colorPickerAnchor = viewHolder.itemView;
                ToolType selectedToolTypeValue = getToolbarViewModel().getSelectedToolTypeValue();
                Integer value = getToolbarViewModel().getSelectedColor().getValue();
                if (value != null) {
                    openColorPicker(value.intValue(), selectedToolTypeValue, adapterPosition == 0);
                    return;
                }
                return;
            }
            if (getToolbarViewModel().canSelectColor()) {
                getToolbarViewModel().selectColorAt(adapterPosition);
            } else {
                displayColorSelectionErrorMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorDropped(int fromPosition, int toPosition) {
        logAction("Color Drop", "from " + fromPosition + " to " + toPosition);
        getToolbarViewModel().moveColor(fromPosition, toPosition);
    }

    private final void onAddColorClicked() {
        if (getToolbarViewModel().canSelectColor()) {
            final int iAddColor$default = ToolbarViewModel.addColor$default(getToolbarViewModel(), 0, 1, null);
            RecyclerView recyclerView = this.colorsList;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PenFragment.onAddColorClicked$lambda$0(this.f$0, iAddColor$default);
                    }
                });
                return;
            }
            return;
        }
        displayColorSelectionErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAddColorClicked$lambda$0(PenFragment penFragment, int i) {
        if (penFragment.isAdded()) {
            penFragment.colorPickerAnchor = penFragment.addColorButton;
            openColorPicker$default(penFragment, i, penFragment.getToolbarViewModel().getSelectedToolTypeValue(), false, 4, null);
        }
    }

    @Override // com.myscript.nebo.penpanel.ColorPickerActionListener
    public void colorChanged(int color) {
        logAction$default(this, "Color Changed", null, 2, null);
        getToolbarViewModel().updateSelectedColor(color);
    }

    @Override // com.myscript.nebo.penpanel.ColorPickerActionListener
    public void colorRemoved() {
        logAction$default(this, "Color Removed", null, 2, null);
        closeColorPicker();
        getToolbarViewModel().removeSelectedColor();
    }

    @Override // com.myscript.nebo.penpanel.ColorPickerActionListener
    public void colorDuplicated() {
        RecyclerView recyclerView;
        logAction$default(this, "Color Duplicated", null, 2, null);
        closeColorPicker();
        final int iDuplicateSelectedColor = getToolbarViewModel().duplicateSelectedColor();
        if (iDuplicateSelectedColor == 0 || (recyclerView = this.colorsList) == null) {
            return;
        }
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.penpanel.PenFragment$colorDuplicated$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
                view.removeOnLayoutChangeListener(this);
                PenFragment penFragment = this.this$0;
                RecyclerView recyclerView2 = penFragment.colorsList;
                penFragment.colorPickerAnchor = (recyclerView2 == null || (viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(this.this$0.getToolbarViewModel().getSelectedColorIndex())) == null) ? null : viewHolderFindViewHolderForAdapterPosition.itemView;
                PenFragment penFragment2 = this.this$0;
                PenFragment.openColorPicker$default(penFragment2, iDuplicateSelectedColor, penFragment2.getToolbarViewModel().getSelectedToolTypeValue(), false, 4, null);
            }
        });
    }

    static /* synthetic */ void openColorPicker$default(PenFragment penFragment, int i, ToolType toolType, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        penFragment.openColorPicker(i, toolType, z);
    }

    private final void openColorPicker(int editedColor, ToolType toolType, boolean isReadOnly) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(editedColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        logAction("Open Color Picker", Literals.COMMENT_1 + str + " for " + toolType.name() + " (ro? " + isReadOnly + ")");
        ColorPickerFragment colorPickerFragmentFindColorPickerFragment = findColorPickerFragment();
        if (colorPickerFragmentFindColorPickerFragment == null) {
            if (!ToolbarConfigurationExt.isWritingTool(toolType)) {
                toolType = ToolType.Pen;
            }
            ToolConfiguration toolConfigurationFindToolConfigurationByType = getToolbarViewModel().findToolConfigurationByType(toolType);
            colorPickerFragmentFindColorPickerFragment = null;
            String str2 = null;
            if (toolConfigurationFindToolConfigurationByType != null) {
                String str3 = this.contentType;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentType");
                } else {
                    str2 = str3;
                }
                colorPickerFragmentFindColorPickerFragment = ColorPickerFragment.INSTANCE.newInstance(editedColor, toolConfigurationFindToolConfigurationByType, isReadOnly, !Intrinsics.areEqual(str2, ContentTypes.PDF));
            }
        }
        if (colorPickerFragmentFindColorPickerFragment != null) {
            setupColorPicker(colorPickerFragmentFindColorPickerFragment);
            if (colorPickerFragmentFindColorPickerFragment.isAdded()) {
                return;
            }
            colorPickerFragmentFindColorPickerFragment.showNow(getParentFragmentManager(), ColorPickerFragment.TAG);
        }
    }

    private final ColorPickerFragment findColorPickerFragment() {
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(ColorPickerFragment.TAG);
        if (fragmentFindFragmentByTag instanceof ColorPickerFragment) {
            return (ColorPickerFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupColorPicker(ColorPickerFragment colorPickerFragment) {
        colorPickerFragment.setColorPickerListener(this);
        if (getResources().getBoolean(C6693R.bool.pen_toolbar_fullscreen_dialog)) {
            return;
        }
        colorPickerFragment.setAnchorView(this.colorPickerAnchor);
        colorPickerFragment.configureDialogAppearance();
    }

    private final void closeColorPicker() {
        ColorPickerFragment colorPickerFragmentFindColorPickerFragment = findColorPickerFragment();
        if (colorPickerFragmentFindColorPickerFragment != null) {
            logAction$default(this, "Close Color Picker", null, 2, null);
            this.colorPickerAnchor = null;
            colorPickerFragmentFindColorPickerFragment.setColorPickerListener(null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.remove(colorPickerFragmentFindColorPickerFragment);
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    private final void openToolConfigurationDialog(ToolConfiguration toolConfiguration) {
        ToolType type = toolConfiguration.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            logToolConfigurationState("Open " + type.name() + " Configuration", toolConfiguration);
            ToolConfigurationDialogFragment toolConfigurationDialogFragmentFindThicknessPickerFragment = findThicknessPickerFragment();
            if (toolConfigurationDialogFragmentFindThicknessPickerFragment == null) {
                ToolConfigurationDialogFragment.Companion companion = ToolConfigurationDialogFragment.INSTANCE;
                int i2 = this.testAreaBackgroundColor;
                String str = this.contentType;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentType");
                    str = null;
                }
                toolConfigurationDialogFragmentFindThicknessPickerFragment = companion.newInstance(toolConfiguration, i2, str);
            }
            setupThicknessPickerFragment(toolConfigurationDialogFragmentFindThicknessPickerFragment);
            Callback callback = this.callback;
            if (callback != null) {
                callback.onPenOptionsDiscovered(type);
            }
        }
    }

    private final ToolConfigurationDialogFragment findThicknessPickerFragment() {
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(ToolConfigurationDialogFragment.TAG);
        if (fragmentFindFragmentByTag instanceof ToolConfigurationDialogFragment) {
            return (ToolConfigurationDialogFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupThicknessPickerFragment(ToolConfigurationDialogFragment thicknessPickerFragment) {
        FragmentKt.setFragmentResultListener(this, ToolConfigurationDialogFragment.REQUEST_KEY, new Function2() { // from class: com.myscript.nebo.penpanel.PenFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PenFragment.setupThicknessPickerFragment$lambda$0(this.f$0, (String) obj, (Bundle) obj2);
            }
        });
        View view = !getResources().getBoolean(C6693R.bool.pen_toolbar_fullscreen_dialog) ? this.selectedToolAnchor : null;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        thicknessPickerFragment.showAt(parentFragmentManager, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThicknessPickerFragment$lambda$0(PenFragment penFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ToolConfiguration toolConfigurationAsToolConfiguration$default = ToolbarConfigurationExt.asToolConfiguration$default(bundle, null, 1, null);
        penFragment.logToolConfigurationState(toolConfigurationAsToolConfiguration$default.getType().name() + " Configuration Changed", toolConfigurationAsToolConfiguration$default);
        penFragment.getToolbarViewModel().applyToolConfiguration(toolConfigurationAsToolConfiguration$default);
        return Unit.INSTANCE;
    }

    public final void toggleColorPicker() {
        if (findColorPickerFragment() != null) {
            closeColorPicker();
        } else {
            onAddColorClicked();
        }
    }

    public final void setPageBackgroundColor(int color) {
        this.testAreaBackgroundColor = color;
        getToolbarViewModel().setPageBackgroundColor(PageBackgroundUtilsKt.resolveBackgroundColor(color, false));
    }

    public final Rect toolLocation(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        RecyclerView recyclerView = this.toolsList;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return null;
        }
        List<ToolPill> currentList = this.toolsAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator<ToolPill> it = currentList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getToolConfiguration().getType() == toolType) {
                break;
            }
            i++;
        }
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(i);
        if (viewFindViewByPosition == null) {
            return null;
        }
        int[] iArr = new int[2];
        viewFindViewByPosition.getLocationInWindow(iArr);
        int i2 = iArr[0];
        return new Rect(i2, iArr[1], viewFindViewByPosition.getWidth() + i2, iArr[1] + viewFindViewByPosition.getHeight());
    }

    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenFragment$Companion;", "", "<init>", "()V", "TAG", "", PenFragment.CONTENT_TYPE_KEY, PenFragment.SHOW_KEYBOARD_ON_TAP_PREF_KEY, PenFragment.SHOW_KEYBOARD_ON_TAP_DEFAULT_VALUE_KEY, "newInstance", "Lcom/myscript/nebo/penpanel/PenFragment;", "contentType", "showKeyboardOnTapPrefKey", "showKeyboardOnTapDefaultValue", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PenFragment newInstance(String contentType, String showKeyboardOnTapPrefKey, boolean showKeyboardOnTapDefaultValue) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(showKeyboardOnTapPrefKey, "showKeyboardOnTapPrefKey");
            PenFragment penFragment = new PenFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PenFragment.CONTENT_TYPE_KEY, contentType);
            bundle.putString(PenFragment.SHOW_KEYBOARD_ON_TAP_PREF_KEY, showKeyboardOnTapPrefKey);
            bundle.putBoolean(PenFragment.SHOW_KEYBOARD_ON_TAP_DEFAULT_VALUE_KEY, showKeyboardOnTapDefaultValue);
            penFragment.setArguments(bundle);
            return penFragment;
        }
    }
}
