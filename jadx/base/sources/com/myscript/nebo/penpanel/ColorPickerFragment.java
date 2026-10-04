package com.myscript.nebo.penpanel;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.DialogUtilsKt;
import com.myscript.nebo.penpanel.ColorCircle;
import com.myscript.nebo.penpanel.databinding.ColorPickerDialogFragmentBinding;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolbarConfigurationExt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ColorPickerFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u001c\u001a\u00020\u0013J&\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010&\u001a\u00020\u00132\b\b\u0001\u0010'\u001a\u00020\u001aH\u0002J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\u0010\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPickerFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "isReadOnly", "", "colorPickerViewModel", "Lcom/myscript/nebo/penpanel/ColorPickerViewModel;", "getColorPickerViewModel", "()Lcom/myscript/nebo/penpanel/ColorPickerViewModel;", "colorPickerViewModel$delegate", "Lkotlin/Lazy;", "colorPickerListener", "Lcom/myscript/nebo/penpanel/ColorPickerActionListener;", "viewBinding", "Lcom/myscript/nebo/penpanel/databinding/ColorPickerDialogFragmentBinding;", "anchorView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "uiStateChanged", "colorPickerUIState", "Lcom/myscript/nebo/penpanel/ColorPickerUIState;", "getTheme", "", "setAnchorView", "configureDialogAppearance", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCreateDialog", "Landroid/app/Dialog;", "pickedColorChanged", "color", "configureMenu", "menu", "Landroid/view/Menu;", "onMenuItemClicked", "item", "Landroid/view/MenuItem;", "onStart", "onStop", "onDestroyView", "setColorPickerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPickerFragment extends DialogFragment {
    private static final String COLOR_PICKER_CAN_INVERT = "COLOR_PICKER_CAN_INVERT";
    private static final String COLOR_PICKER_COLOR = "COLOR_PICKER_COLOR";
    private static final String COLOR_PICKER_IS_READ_ONLY = "COLOR_PICKER_IS_READ_ONLY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ColorPickerFragment";
    private View anchorView;
    private ColorPickerActionListener colorPickerListener;

    /* JADX INFO: renamed from: colorPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy colorPickerViewModel;
    private boolean isReadOnly;
    private ColorPickerDialogFragmentBinding viewBinding;

    public ColorPickerFragment() {
        final ColorPickerFragment colorPickerFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ColorPickerFragment.colorPickerViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return colorPickerFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$special$$inlined$viewModels$default$2
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
        this.colorPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(colorPickerFragment, Reflection.getOrCreateKotlinClass(ColorPickerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$special$$inlined$viewModels$default$4
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ColorPickerViewModel getColorPickerViewModel() {
        return (ColorPickerViewModel) this.colorPickerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory colorPickerViewModel_delegate$lambda$0(ColorPickerFragment colorPickerFragment) {
        Bundle bundleRequireArguments = colorPickerFragment.requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        return new ColorPickerViewModelFactory(bundleRequireArguments.getInt(COLOR_PICKER_COLOR, 0), bundleRequireArguments.getBoolean(COLOR_PICKER_IS_READ_ONLY), bundleRequireArguments.getBoolean(COLOR_PICKER_CAN_INVERT));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(2, getTheme());
        this.isReadOnly = requireArguments().getBoolean(COLOR_PICKER_IS_READ_ONLY);
    }

    private final void uiStateChanged(ColorPickerUIState colorPickerUIState) {
        ColorPickerDialogFragmentBinding colorPickerDialogFragmentBinding = this.viewBinding;
        if (colorPickerDialogFragmentBinding == null) {
            return;
        }
        boolean zIsEnabled = colorPickerUIState.isEnabled();
        ColorCircle colorCircle = colorPickerDialogFragmentBinding.colorCircle;
        if (colorCircle != null) {
            colorCircle.setEnabled(zIsEnabled);
            colorCircle.setColorLeft(colorPickerUIState.getInitialColor());
            colorCircle.setColorRight(colorPickerUIState.getCurrentColor());
            colorCircle.setThumbColor(colorPickerUIState.getHue());
        }
        ColorSeekBar colorSeekBar = colorPickerDialogFragmentBinding.saturationSeekbar;
        if (colorSeekBar != null) {
            colorSeekBar.setEnabled(zIsEnabled);
            colorSeekBar.setMax(colorPickerUIState.getSaturationMaxValue());
            colorSeekBar.setStartColor(colorPickerUIState.getSaturationStartColor());
            colorSeekBar.setEndColor(colorPickerUIState.getSaturationEndColor());
            colorSeekBar.setThumbColor(colorPickerUIState.getSaturationThumbColor());
        }
        ColorSeekBar colorSeekBar2 = colorPickerDialogFragmentBinding.brightnessSeekbar;
        if (colorSeekBar2 != null) {
            colorSeekBar2.setEnabled(zIsEnabled);
            colorSeekBar2.setMax(colorPickerUIState.getBrightnessMaxValue());
            colorSeekBar2.setStartColor(colorPickerUIState.getBrightnessStartColor());
            colorSeekBar2.setEndColor(colorPickerUIState.getBrightnessEndColor());
            colorSeekBar2.setThumbColor(colorPickerUIState.getBrightnessThumbColor());
        }
        if (colorPickerUIState.getShouldSetProgress()) {
            ColorCircle colorCircle2 = colorPickerDialogFragmentBinding.colorCircle;
            if (colorCircle2 != null) {
                colorCircle2.setCurrentHue(colorPickerUIState.getHue());
            }
            ColorSeekBar colorSeekBar3 = colorPickerDialogFragmentBinding.saturationSeekbar;
            if (colorSeekBar3 != null) {
                colorSeekBar3.setProgress(colorPickerUIState.getSaturationCurrentValue());
            }
            ColorSeekBar colorSeekBar4 = colorPickerDialogFragmentBinding.brightnessSeekbar;
            if (colorSeekBar4 != null) {
                colorSeekBar4.setProgress(colorPickerUIState.getBrightnessCurrentValue());
            }
        }
        TextView textView = colorPickerDialogFragmentBinding.colorAccuracyDisclaimer;
        if (textView != null) {
            textView.setVisibility(colorPickerUIState.getShowColorAccuracyDisclaimer() ? 0 : 8);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    public final void setAnchorView(View anchorView) {
        this.anchorView = anchorView;
    }

    public final void configureDialogAppearance() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        View view = this.anchorView;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            window.setGravity(8388659);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = iArr[0];
            attributes.y = iArr[1];
            attributes.windowAnimations = getTheme();
            window.setAttributes(attributes);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MaterialToolbar materialToolbar;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ColorPickerDialogFragmentBinding colorPickerDialogFragmentBindingInflate = ColorPickerDialogFragmentBinding.inflate(inflater, container, false);
        this.viewBinding = colorPickerDialogFragmentBindingInflate;
        if (colorPickerDialogFragmentBindingInflate == null || (materialToolbar = colorPickerDialogFragmentBindingInflate.colorPickerToolbar) == null) {
            materialToolbar = null;
        } else if (!materialToolbar.getResources().getBoolean(C6693R.bool.pen_toolbar_fullscreen_dialog)) {
            materialToolbar.setNavigationIcon((Drawable) null);
        }
        configureMenu(materialToolbar != null ? materialToolbar.getMenu() : null);
        configureDialogAppearance();
        ColorPickerDialogFragmentBinding colorPickerDialogFragmentBinding = this.viewBinding;
        return colorPickerDialogFragmentBinding != null ? colorPickerDialogFragmentBinding.getRoot() : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getColorPickerViewModel().getColorPickerUIState().observe(getViewLifecycleOwner(), new ColorPickerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ColorPickerFragment.onViewCreated$lambda$0(this.f$0, (ColorPickerUIState) obj);
            }
        }));
        getColorPickerViewModel().getPickedColor().observe(getViewLifecycleOwner(), new ColorPickerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ColorPickerFragment.onViewCreated$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(ColorPickerFragment colorPickerFragment, ColorPickerUIState colorPickerUIState) {
        Intrinsics.checkNotNullParameter(colorPickerUIState, "colorPickerUIState");
        colorPickerFragment.uiStateChanged(colorPickerUIState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(ColorPickerFragment colorPickerFragment, int i) {
        colorPickerFragment.pickedColorChanged(i);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(dialogOnCreateDialog);
        DialogUtilsKt.configureForEdgeToEdge(dialogOnCreateDialog);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    private final void pickedColorChanged(int color) {
        ColorPickerActionListener colorPickerActionListener = this.colorPickerListener;
        if (colorPickerActionListener != null) {
            colorPickerActionListener.colorChanged(color);
        }
    }

    private final void configureMenu(Menu menu) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        if (menu != null && (menuItemFindItem2 = menu.findItem(C6693R.id.color_picker_delete_action)) != null) {
            menuItemFindItem2.setEnabled(!this.isReadOnly);
        }
        if (menu == null || (menuItemFindItem = menu.findItem(C6693R.id.color_picker_duplicate_action)) == null) {
            return;
        }
        menuItemFindItem.setEnabled(!this.isReadOnly);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onMenuItemClicked(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == C6693R.id.color_picker_delete_action) {
            ColorPickerActionListener colorPickerActionListener = this.colorPickerListener;
            if (colorPickerActionListener != null) {
                colorPickerActionListener.colorRemoved();
            }
            return true;
        }
        if (itemId != C6693R.id.color_picker_duplicate_action) {
            return false;
        }
        ColorPickerActionListener colorPickerActionListener2 = this.colorPickerListener;
        if (colorPickerActionListener2 != null) {
            colorPickerActionListener2.colorDuplicated();
        }
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ColorPickerDialogFragmentBinding colorPickerDialogFragmentBinding = this.viewBinding;
        if (colorPickerDialogFragmentBinding == null) {
            return;
        }
        ColorCircle colorCircle = colorPickerDialogFragmentBinding.colorCircle;
        if (colorCircle != null) {
            colorCircle.setColorListener(new ColorCircle.ColorCircleListener() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment.onStart.1
                @Override // com.myscript.nebo.penpanel.ColorCircle.ColorCircleListener
                public void hueChanged(float hue) {
                    ColorPickerFragment.this.getColorPickerViewModel().hueChanged(hue);
                }

                @Override // com.myscript.nebo.penpanel.ColorCircle.ColorCircleListener
                public void resetColor() {
                    ColorPickerFragment.this.getColorPickerViewModel().resetColor();
                }
            });
        }
        ColorSeekBar colorSeekBar = colorPickerDialogFragmentBinding.brightnessSeekbar;
        if (colorSeekBar != null) {
            colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment.onStart.2
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                    ColorPickerFragment.this.getColorPickerViewModel().brightnessChanged(value);
                }
            });
        }
        ColorSeekBar colorSeekBar2 = colorPickerDialogFragmentBinding.saturationSeekbar;
        if (colorSeekBar2 != null) {
            colorSeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment.onStart.3
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                    ColorPickerFragment.this.getColorPickerViewModel().saturationChanged(value);
                }
            });
        }
        colorPickerDialogFragmentBinding.colorPickerToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        colorPickerDialogFragmentBinding.colorPickerToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.myscript.nebo.penpanel.ColorPickerFragment$$ExternalSyntheticLambda3
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.onMenuItemClicked(menuItem);
            }
        });
        super.onStart();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        ColorPickerDialogFragmentBinding colorPickerDialogFragmentBinding = this.viewBinding;
        if (colorPickerDialogFragmentBinding == null) {
            return;
        }
        colorPickerDialogFragmentBinding.colorPickerToolbar.setNavigationOnClickListener(null);
        colorPickerDialogFragmentBinding.colorPickerToolbar.setOnMenuItemClickListener(null);
        ColorSeekBar colorSeekBar = colorPickerDialogFragmentBinding.saturationSeekbar;
        if (colorSeekBar != null) {
            colorSeekBar.setOnSeekBarChangeListener(null);
        }
        ColorSeekBar colorSeekBar2 = colorPickerDialogFragmentBinding.brightnessSeekbar;
        if (colorSeekBar2 != null) {
            colorSeekBar2.setOnSeekBarChangeListener(null);
        }
        ColorCircle colorCircle = colorPickerDialogFragmentBinding.colorCircle;
        if (colorCircle != null) {
            colorCircle.setColorListener(null);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.colorPickerListener = null;
        this.viewBinding = null;
        super.onDestroyView();
    }

    public final void setColorPickerListener(ColorPickerActionListener listener) {
        this.colorPickerListener = listener;
    }

    /* JADX INFO: compiled from: ColorPickerFragment.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPickerFragment$Companion;", "", "<init>", "()V", "TAG", "", ColorPickerFragment.COLOR_PICKER_COLOR, ColorPickerFragment.COLOR_PICKER_IS_READ_ONLY, ColorPickerFragment.COLOR_PICKER_CAN_INVERT, "newInstance", "Lcom/myscript/nebo/penpanel/ColorPickerFragment;", "editedColor", "", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "isReadOnly", "", "canInvertColor", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ColorPickerFragment newInstance(int editedColor, ToolConfiguration toolConfiguration, boolean isReadOnly, boolean canInvertColor) {
            Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
            Bundle bundleAsBundle = ToolbarConfigurationExt.asBundle(toolConfiguration);
            bundleAsBundle.putInt(ColorPickerFragment.COLOR_PICKER_COLOR, editedColor);
            bundleAsBundle.putBoolean(ColorPickerFragment.COLOR_PICKER_IS_READ_ONLY, isReadOnly);
            bundleAsBundle.putBoolean(ColorPickerFragment.COLOR_PICKER_CAN_INVERT, canInvertColor);
            ColorPickerFragment colorPickerFragment = new ColorPickerFragment();
            colorPickerFragment.setArguments(bundleAsBundle);
            return colorPickerFragment;
        }
    }
}
