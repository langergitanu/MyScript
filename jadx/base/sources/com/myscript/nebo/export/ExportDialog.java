package com.myscript.nebo.export;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.myscript.atk.core.MimeType;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.utils.DisplayMetricsExtKt;
import com.myscript.nebo.export.ExportViewModel;
import com.myscript.snt.core.OptionState;
import com.myscript.snt.core.PageKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExportDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001'\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020%H\u0016J\u0012\u0010.\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00107\u001a\u00020*H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020*H\u0016J\u000e\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0002J\u001a\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010\u00142\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020*H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006K"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "exportType", "Lcom/myscript/atk/core/MimeType;", "boxId", "", "exportViewModel", "Lcom/myscript/nebo/export/ExportViewModel;", "getExportViewModel", "()Lcom/myscript/nebo/export/ExportViewModel;", "exportViewModel$delegate", "Lkotlin/Lazy;", "exportConfigurationLayout", "Landroid/view/View;", "exportTypeSpinner", "Landroid/widget/Spinner;", "exportOptionsCategory", "includeAnnotationOptionSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "includeBackgroundColorOptionSwitch", "includeBackgroundPatternOptionSwitch", "flattenOptionSwitch", "combineAsOneDocumentOptionSwitch", "fileNameCategory", "fileNameContainer", "Lcom/google/android/material/textfield/TextInputLayout;", "fileNameLayout", "Lcom/google/android/material/textfield/TextInputEditText;", "exportButton", "Landroid/widget/Button;", "exportProgressLayout", "cancelButton", "exportDescriptionView", "Landroid/widget/TextView;", "result", "", "onMimeTypeSelectedListener", "com/myscript/nebo/export/ExportDialog$onMimeTypeSelectedListener$1", "Lcom/myscript/nebo/export/ExportDialog$onMimeTypeSelectedListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStop", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "onStateUpdate", "state", "Lcom/myscript/nebo/export/ExportViewModel$State;", "updateOptionVisibility", "optionSwitch", "option", "Lcom/myscript/snt/core/OptionState;", "updateFileNameOption", "nameOption", "Lcom/myscript/nebo/export/ExportViewModel$FileNameOption;", "onDestroyView", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExportDialog extends DialogFragment {
    public static final String BOX_ID_KEY = "BOX_ID_KEY";
    public static final int CANCELED_RESULT_CODE = 1;
    public static final int ERROR_RESULT_CODE = 2;
    public static final int EXPORTED_RESULT_CODE = 0;
    public static final String EXPORT_TYPE_KEY = "EXPORT_TYPE_KEY";
    private static final String PAGES_INDEX = "PAGES_INDEX";
    private static final String PAGES_KEY = "PAGES_KEY";
    public static final String REQUEST_KEY = "ExportDialog_REQUEST_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";
    public static final String TAG = "ExportDialog";
    private static final int UNDEFINED_RESULT_CODE = -1;
    private String boxId;
    private Button cancelButton;
    private SwitchCompat combineAsOneDocumentOptionSwitch;
    private Button exportButton;
    private View exportConfigurationLayout;
    private TextView exportDescriptionView;
    private View exportOptionsCategory;
    private View exportProgressLayout;
    private MimeType exportType;
    private Spinner exportTypeSpinner;

    /* JADX INFO: renamed from: exportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy exportViewModel;
    private View fileNameCategory;
    private TextInputLayout fileNameContainer;
    private TextInputEditText fileNameLayout;
    private SwitchCompat flattenOptionSwitch;
    private SwitchCompat includeAnnotationOptionSwitch;
    private SwitchCompat includeBackgroundColorOptionSwitch;
    private SwitchCompat includeBackgroundPatternOptionSwitch;
    private final ExportDialog$onMimeTypeSelectedListener$1 onMimeTypeSelectedListener;
    private int result;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ExportDialog.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OptionState.values().length];
            try {
                iArr[OptionState.NotAvailable.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OptionState.On.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OptionState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final ExportDialog newInstance(PageKey pageKey) {
        return INSTANCE.newInstance(pageKey);
    }

    @JvmStatic
    public static final ExportDialog newInstance(PageKey pageKey, String str) {
        return INSTANCE.newInstance(pageKey, str);
    }

    @JvmStatic
    public static final ExportDialog newInstance(PageKey pageKey, String str, MimeType mimeType) {
        return INSTANCE.newInstance(pageKey, str, mimeType);
    }

    @JvmStatic
    public static final ExportDialog newInstance(List<? extends PageKey> list) {
        return INSTANCE.newInstance(list);
    }

    @JvmStatic
    public static final ExportDialog newInstance(List<? extends PageKey> list, List<Integer> list2) {
        return INSTANCE.newInstance(list, list2);
    }

    @JvmStatic
    public static final ExportDialog newInstance(List<? extends PageKey> list, List<Integer> list2, String str) {
        return INSTANCE.newInstance(list, list2, str);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.myscript.nebo.export.ExportDialog$onMimeTypeSelectedListener$1] */
    public ExportDialog() {
        final ExportDialog exportDialog = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportDialog.exportViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.export.ExportDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return exportDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.export.ExportDialog$special$$inlined$viewModels$default$2
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
        this.exportViewModel = FragmentViewModelLazyKt.createViewModelLazy(exportDialog, Reflection.getOrCreateKotlinClass(ExportViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.export.ExportDialog$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.export.ExportDialog$special$$inlined$viewModels$default$4
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
        this.result = -1;
        this.onMimeTypeSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.myscript.nebo.export.ExportDialog$onMimeTypeSelectedListener$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                this.this$0.getExportViewModel().setExportMimeType(this.this$0.getExportViewModel().getAvailableMimeTypes().get(position));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExportViewModel getExportViewModel() {
        return (ExportViewModel) this.exportViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory exportViewModel_delegate$lambda$0(ExportDialog exportDialog) {
        Bundle arguments = exportDialog.getArguments();
        String[] stringArray = arguments != null ? arguments.getStringArray(PAGES_KEY) : null;
        if (stringArray == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String[] strArr = stringArray;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(PageKey.deserialize(str));
        }
        ArrayList arrayList2 = arrayList;
        Bundle arguments2 = exportDialog.getArguments();
        int[] intArray = arguments2 != null ? arguments2.getIntArray(PAGES_INDEX) : null;
        Context contextRequireContext = exportDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return ExportViewModel.INSTANCE.Factory(arrayList2, intArray != null ? ArraysKt.toList(intArray) : null, DisplayMetricsExtKt.getFixedDisplayMetrics(contextRequireContext));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String[] stringArray = arguments != null ? arguments.getStringArray(PAGES_KEY) : null;
        if (stringArray == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String[] strArr = stringArray;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(PageKey.deserialize(str));
        }
        ArrayList arrayList2 = arrayList;
        Bundle arguments2 = getArguments();
        this.boxId = arguments2 != null ? arguments2.getString(BOX_ID_KEY) : null;
        Bundle arguments3 = getArguments();
        Serializable serializable = arguments3 != null ? arguments3.getSerializable(EXPORT_TYPE_KEY) : null;
        MimeType mimeType = serializable instanceof MimeType ? (MimeType) serializable : null;
        this.exportType = mimeType;
        String str2 = this.boxId;
        if (str2 != null) {
            if (mimeType != null && mimeType == MimeType.PPTX) {
                ExportViewModel exportViewModel = getExportViewModel();
                Object objFirst = CollectionsKt.first((List<? extends Object>) arrayList2);
                Intrinsics.checkNotNullExpressionValue(objFirst, "first(...)");
                exportViewModel.exportToPowerPoint((PageKey) objFirst, str2);
                return;
            }
            dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6079R.style.BaseDialogTheme;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setTitle(getExportViewModel().getExportTitle());
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int position = 0;
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6079R.layout.export_dialog_layout, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.exportConfigurationLayout = viewInflate.findViewById(C6079R.id.export_dialog_configuration_container);
        Spinner spinner = (Spinner) viewInflate.findViewById(C6079R.id.export_type);
        this.exportTypeSpinner = spinner;
        if (spinner != null) {
            List<MimeType> availableMimeTypes = getExportViewModel().getAvailableMimeTypes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availableMimeTypes, 10));
            Iterator<T> it = availableMimeTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(getString(ExportHelperKt.getStringRes((MimeType) it.next())));
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), C6079R.layout.export_type_spinner_item, C6079R.id.export_type_label, arrayList);
            position = arrayAdapter.getPosition(getString(ExportHelperKt.getStringRes(getExportViewModel().getCurrentMimeType())));
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        Spinner spinner2 = this.exportTypeSpinner;
        if (spinner2 != null) {
            spinner2.setSelection(position);
        }
        this.exportOptionsCategory = viewInflate.findViewById(C6079R.id.export_options_category);
        this.includeAnnotationOptionSwitch = (SwitchCompat) viewInflate.findViewById(C6079R.id.export_annotation_options);
        this.includeBackgroundColorOptionSwitch = (SwitchCompat) viewInflate.findViewById(C6079R.id.export_background_color_options);
        this.includeBackgroundPatternOptionSwitch = (SwitchCompat) viewInflate.findViewById(C6079R.id.export_background_pattern_options);
        this.flattenOptionSwitch = (SwitchCompat) viewInflate.findViewById(C6079R.id.export_flatten_options);
        this.combineAsOneDocumentOptionSwitch = (SwitchCompat) viewInflate.findViewById(C6079R.id.export_combine_options);
        this.fileNameCategory = viewInflate.findViewById(C6079R.id.export_filename_category);
        this.fileNameContainer = (TextInputLayout) viewInflate.findViewById(C6079R.id.export_filename_container);
        this.fileNameLayout = (TextInputEditText) viewInflate.findViewById(C6079R.id.export_filename);
        this.exportProgressLayout = viewInflate.findViewById(C6079R.id.export_dialog_progress_container);
        this.exportDescriptionView = (TextView) viewInflate.findViewById(C6079R.id.export_description);
        this.exportButton = (Button) viewInflate.findViewById(C6079R.id.export_button);
        this.cancelButton = (Button) viewInflate.findViewById(C6079R.id.cancel_button);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ExportViewModel exportViewModel = getExportViewModel();
        ExportDialog exportDialog = this;
        exportViewModel.getState().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$0(this.f$0, (ExportViewModel.State) obj);
            }
        }));
        exportViewModel.getIncludeAnnotationsOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$1(this.f$0, (OptionState) obj);
            }
        }));
        exportViewModel.getIncludeBackgroundColorOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$2(this.f$0, (OptionState) obj);
            }
        }));
        exportViewModel.getIncludeBackgroundPatternOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$3(this.f$0, (OptionState) obj);
            }
        }));
        exportViewModel.getFlattenOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$4(this.f$0, (OptionState) obj);
            }
        }));
        exportViewModel.getCombineAsOneDocumentOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$5(this.f$0, (OptionState) obj);
            }
        }));
        exportViewModel.getFileNameOption().observe(exportDialog, new ExportDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExportDialog.onViewCreated$lambda$0$6(this.f$0, (ExportViewModel.FileNameOption) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(ExportDialog exportDialog, ExportViewModel.State state) {
        Intrinsics.checkNotNull(state);
        exportDialog.onStateUpdate(state);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$1(ExportDialog exportDialog, OptionState optionState) {
        SwitchCompat switchCompat = exportDialog.includeAnnotationOptionSwitch;
        Intrinsics.checkNotNull(optionState);
        exportDialog.updateOptionVisibility(switchCompat, optionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$2(ExportDialog exportDialog, OptionState optionState) {
        SwitchCompat switchCompat = exportDialog.includeBackgroundColorOptionSwitch;
        Intrinsics.checkNotNull(optionState);
        exportDialog.updateOptionVisibility(switchCompat, optionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3(ExportDialog exportDialog, OptionState optionState) {
        SwitchCompat switchCompat = exportDialog.includeBackgroundPatternOptionSwitch;
        Intrinsics.checkNotNull(optionState);
        exportDialog.updateOptionVisibility(switchCompat, optionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$4(ExportDialog exportDialog, OptionState optionState) {
        SwitchCompat switchCompat = exportDialog.flattenOptionSwitch;
        Intrinsics.checkNotNull(optionState);
        exportDialog.updateOptionVisibility(switchCompat, optionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$5(ExportDialog exportDialog, OptionState optionState) {
        SwitchCompat switchCompat = exportDialog.combineAsOneDocumentOptionSwitch;
        Intrinsics.checkNotNull(optionState);
        exportDialog.updateOptionVisibility(switchCompat, optionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$6(ExportDialog exportDialog, ExportViewModel.FileNameOption fileNameOption) {
        Intrinsics.checkNotNull(fileNameOption);
        exportDialog.updateFileNameOption(fileNameOption);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Spinner spinner = this.exportTypeSpinner;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this.onMimeTypeSelectedListener);
        }
        final SwitchCompat switchCompat = this.includeAnnotationOptionSwitch;
        if (switchCompat != null) {
            switchCompat.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$0$0(this.f$0, switchCompat, view);
                }
            });
        }
        final SwitchCompat switchCompat2 = this.flattenOptionSwitch;
        if (switchCompat2 != null) {
            switchCompat2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$1$0(this.f$0, switchCompat2, view);
                }
            });
        }
        final SwitchCompat switchCompat3 = this.includeBackgroundColorOptionSwitch;
        if (switchCompat3 != null) {
            switchCompat3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$2$0(this.f$0, switchCompat3, view);
                }
            });
        }
        final SwitchCompat switchCompat4 = this.includeBackgroundPatternOptionSwitch;
        if (switchCompat4 != null) {
            switchCompat4.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$3$0(this.f$0, switchCompat4, view);
                }
            });
        }
        final SwitchCompat switchCompat5 = this.combineAsOneDocumentOptionSwitch;
        if (switchCompat5 != null) {
            switchCompat5.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$4$0(this.f$0, switchCompat5, view);
                }
            });
        }
        TextInputEditText textInputEditText = this.fileNameLayout;
        if (textInputEditText != null) {
            textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.myscript.nebo.export.ExportDialog$onStart$$inlined$doOnTextChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence text, int start, int before, int count) {
                    String string;
                    ExportViewModel exportViewModel = this.this$0.getExportViewModel();
                    if (text == null || (string = text.toString()) == null) {
                        string = "";
                    }
                    exportViewModel.setName(string);
                    TextInputLayout textInputLayout = this.this$0.fileNameContainer;
                    if (textInputLayout != null) {
                        textInputLayout.setHelperText(this.this$0.getString(C6079R.string.export_as, this.this$0.getExportViewModel().getFileName()));
                    }
                }
            });
        }
        Button button = this.exportButton;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$6(this.f$0, view);
                }
            });
        }
        Button button2 = this.cancelButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.export.ExportDialog$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportDialog.onStart$lambda$7(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0$0(ExportDialog exportDialog, SwitchCompat switchCompat, View view) {
        exportDialog.getExportViewModel().includeAnnotations(switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$1$0(ExportDialog exportDialog, SwitchCompat switchCompat, View view) {
        exportDialog.getExportViewModel().flatten(switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$2$0(ExportDialog exportDialog, SwitchCompat switchCompat, View view) {
        exportDialog.getExportViewModel().includeBackgroundColor(switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$3$0(ExportDialog exportDialog, SwitchCompat switchCompat, View view) {
        exportDialog.getExportViewModel().includeBackgroundPattern(switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$4$0(ExportDialog exportDialog, SwitchCompat switchCompat, View view) {
        exportDialog.getExportViewModel().combineAsOneDocument(switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$6(ExportDialog exportDialog, View view) {
        exportDialog.result = 0;
        ComponentCallbacks2 application = exportDialog.requireActivity().getApplication();
        UserProfileManager.Provider provider = application instanceof UserProfileManager.Provider ? (UserProfileManager.Provider) application : null;
        exportDialog.getExportViewModel().export(!((provider != null ? provider.provideUserProfileManager() : null) != null ? r2.hasAccessToAllFeatures() : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$7(ExportDialog exportDialog, View view) {
        exportDialog.result = 1;
        exportDialog.getExportViewModel().cancelExport();
        exportDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.result == -1) {
            this.result = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_KEY", this.result);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this, REQUEST_KEY, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        SwitchCompat switchCompat = this.includeAnnotationOptionSwitch;
        if (switchCompat != null) {
            switchCompat.setOnClickListener(null);
        }
        SwitchCompat switchCompat2 = this.flattenOptionSwitch;
        if (switchCompat2 != null) {
            switchCompat2.setOnClickListener(null);
        }
        SwitchCompat switchCompat3 = this.combineAsOneDocumentOptionSwitch;
        if (switchCompat3 != null) {
            switchCompat3.setOnClickListener(null);
        }
        Button button = this.exportButton;
        if (button != null) {
            button.setOnClickListener(null);
        }
        Button button2 = this.cancelButton;
        if (button2 != null) {
            button2.setOnClickListener(null);
        }
        Spinner spinner = this.exportTypeSpinner;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(null);
        }
        super.onStop();
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.show(manager, TAG);
    }

    private final void onStateUpdate(ExportViewModel.State state) {
        if (state instanceof ExportViewModel.State.Started) {
            View view = this.exportConfigurationLayout;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.exportProgressLayout;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            Button button = this.exportButton;
            if (button != null) {
                button.setVisibility(8);
                return;
            }
            return;
        }
        if (state instanceof ExportViewModel.State.Progress) {
            String string = getResources().getString(C6079R.string.export_description, state.getOutputFileName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            TextView textView = this.exportDescriptionView;
            if (textView != null) {
                textView.setText(string);
                return;
            }
            return;
        }
        if (state instanceof ExportViewModel.State.Done) {
            Intent intent = state.getIntent();
            if (intent != null) {
                startActivity(intent);
                ExportHelper.onExportDisplayed();
            }
            dismiss();
            return;
        }
        if (!(state instanceof ExportViewModel.State.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Log.e(TAG, state.getMessage(), state.getException());
        this.result = 2;
        dismiss();
    }

    private final void updateOptionVisibility(SwitchCompat optionSwitch, OptionState option) {
        SwitchCompat switchCompat;
        SwitchCompat switchCompat2;
        int i = 8;
        if (optionSwitch != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[option.ordinal()];
            if (i2 == 1) {
                optionSwitch.setVisibility(8);
            } else if (i2 == 2) {
                optionSwitch.setVisibility(0);
                optionSwitch.setChecked(true);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                optionSwitch.setVisibility(0);
                optionSwitch.setChecked(false);
            }
        }
        View view = this.exportOptionsCategory;
        if (view != null) {
            SwitchCompat switchCompat3 = this.includeAnnotationOptionSwitch;
            if ((switchCompat3 != null && switchCompat3.isShown()) || (((switchCompat = this.flattenOptionSwitch) != null && switchCompat.isShown()) || ((switchCompat2 = this.combineAsOneDocumentOptionSwitch) != null && switchCompat2.isShown()))) {
                i = 0;
            }
            view.setVisibility(i);
        }
    }

    private final void updateFileNameOption(ExportViewModel.FileNameOption nameOption) {
        int i = WhenMappings.$EnumSwitchMapping$0[nameOption.getOptionState().ordinal()] == 1 ? 8 : 0;
        View view = this.fileNameCategory;
        if (view != null) {
            view.setVisibility(i);
        }
        TextInputEditText textInputEditText = this.fileNameLayout;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(i);
            String name = nameOption.getName();
            if (!StringsKt.isBlank(name)) {
                textInputEditText.setText(name, TextView.BufferType.NORMAL);
            }
        }
        TextInputLayout textInputLayout = this.fileNameContainer;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(i);
            textInputLayout.setHelperTextEnabled(i == 0);
            textInputLayout.setHelperText(getString(C6079R.string.export_as, getExportViewModel().getFileName()));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.exportConfigurationLayout = null;
        this.exportTypeSpinner = null;
        this.exportOptionsCategory = null;
        this.includeAnnotationOptionSwitch = null;
        this.flattenOptionSwitch = null;
        this.combineAsOneDocumentOptionSwitch = null;
        this.fileNameCategory = null;
        this.fileNameLayout = null;
        this.exportButton = null;
        this.exportProgressLayout = null;
        this.cancelButton = null;
        this.exportDescriptionView = null;
        super.onDestroyView();
    }

    /* JADX INFO: compiled from: ExportDialog.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J4\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportDialog$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", "RESULT_KEY", "UNDEFINED_RESULT_CODE", "", "EXPORTED_RESULT_CODE", "CANCELED_RESULT_CODE", "ERROR_RESULT_CODE", ExportDialog.PAGES_KEY, ExportDialog.PAGES_INDEX, ExportDialog.BOX_ID_KEY, ExportDialog.EXPORT_TYPE_KEY, "newInstance", "Lcom/myscript/nebo/export/ExportDialog;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "boxId", "exportType", "Lcom/myscript/atk/core/MimeType;", "", "pageIndexes", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ExportDialog newInstance(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return newInstance$default(this, pageKey, (String) null, (MimeType) null, 6, (Object) null);
        }

        @JvmStatic
        public final ExportDialog newInstance(PageKey pageKey, String str) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return newInstance$default(this, pageKey, str, (MimeType) null, 4, (Object) null);
        }

        @JvmStatic
        public final ExportDialog newInstance(List<? extends PageKey> pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return newInstance$default(this, pageKey, (List) null, (String) null, 6, (Object) null);
        }

        @JvmStatic
        public final ExportDialog newInstance(List<? extends PageKey> pageKey, List<Integer> list) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return newInstance$default(this, pageKey, list, (String) null, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ ExportDialog newInstance$default(Companion companion, PageKey pageKey, String str, MimeType mimeType, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                mimeType = null;
            }
            return companion.newInstance(pageKey, str, mimeType);
        }

        @JvmStatic
        public final ExportDialog newInstance(PageKey pageKey, String boxId, MimeType exportType) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            ExportDialog exportDialog = new ExportDialog();
            Bundle bundle = new Bundle();
            bundle.putStringArray(ExportDialog.PAGES_KEY, new String[]{pageKey.serialize()});
            bundle.putString(ExportDialog.BOX_ID_KEY, boxId);
            bundle.putSerializable(ExportDialog.EXPORT_TYPE_KEY, exportType);
            exportDialog.setArguments(bundle);
            return exportDialog;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExportDialog newInstance$default(Companion companion, List list, List list2, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                list2 = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.newInstance((List<? extends PageKey>) list, (List<Integer>) list2, str);
        }

        @JvmStatic
        public final ExportDialog newInstance(List<? extends PageKey> pageKey, List<Integer> pageIndexes, String boxId) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            ExportDialog exportDialog = new ExportDialog();
            Bundle bundle = new Bundle();
            List<? extends PageKey> list = pageKey;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((PageKey) it.next()).serialize());
            }
            bundle.putStringArray(ExportDialog.PAGES_KEY, (String[]) arrayList.toArray(new String[0]));
            if (pageIndexes != null) {
                bundle.putIntArray(ExportDialog.PAGES_INDEX, CollectionsKt.toIntArray(pageIndexes));
            }
            bundle.putString(ExportDialog.BOX_ID_KEY, boxId);
            exportDialog.setArguments(bundle);
            return exportDialog;
        }
    }
}
