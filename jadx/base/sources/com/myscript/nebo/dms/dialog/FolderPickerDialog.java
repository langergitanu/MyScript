package com.myscript.nebo.dms.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleCompat;
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
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.dialog.SimpleDMSViewModel;
import com.myscript.nebo.dms.expandlist.DmsSimpleAdapter;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: FolderPickerDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0003?@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u001fH\u0016J\b\u00102\u001a\u00020\u001fH\u0016J\b\u00103\u001a\u00020\u001fH\u0016J\u0016\u00104\u001a\u00020\u001f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u001fH\u0002J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dmsViewModel", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel;", "getDmsViewModel", "()Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel;", "dmsViewModel$delegate", "Lkotlin/Lazy;", "requestKey", "", "config", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config;", "dmsAdapter", "Lcom/myscript/nebo/dms/expandlist/DmsSimpleAdapter;", "result", "", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "searchView", "Landroidx/appcompat/widget/SearchView;", "dmsList", "Landroidx/recyclerview/widget/RecyclerView;", "dmsListEmptyState", "Landroid/view/View;", "dmsListEmptyStateSubtitle", "Landroid/widget/TextView;", "negativeButton", "positiveButton", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onViewCreated", "view", "onFilterUpdate", "label", "onStart", "onStop", "onDestroyView", "onCollectionsUpdated", "collections", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "onFolderClicked", "folder", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "onImport", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Config", "Result", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderPickerDialog extends DialogFragment {
    public static final int CANCELED_RESULT_CODE = 1;
    public static final int FOLDER_SELECTED_RESULT_CODE = 0;
    public static final String MOVE_PAGES_REQUEST_KEY = "FolderPickerDialog_MOVE_PAGES_REQUEST_KEY";
    public static final String NEBO_FILE_IMPORT_REQUEST_KEY = "FolderPickerDialog_NEBO_FILE_IMPORT_REQUEST_KEY";
    private static final String NEBO_FILE_URI_ARG = "NEBO_FILE_URI_ARG";
    public static final int NO_FOLDER_RESULT_CODE = 2;
    private static final String PAGE_KEYS_ARG = "PAGE_KEYS_ARG";
    public static final String PDF_IMPORT_REQUEST_KEY = "FolderPickerDialog_PDF_IMPORT_REQUEST_KEY";
    private static final String PDF_URI_ARG = "PDF_URI_ARG";
    private static final String REQUEST_KEY_ARG = "REQUEST_KEY_ARG";
    public static final String RESULT_KEY = "RESULT_KEY";
    public static final String SELECTED_FOLDER_KEY = "SELECTED_FOLDER_KEY";
    public static final String TAG = "FolderPickerDialog";
    private static final int UNDEFINED_RESULT_CODE = -1;
    private Config config;
    private DmsSimpleAdapter dmsAdapter;
    private RecyclerView dmsList;
    private View dmsListEmptyState;
    private TextView dmsListEmptyStateSubtitle;

    /* JADX INFO: renamed from: dmsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dmsViewModel;
    private View negativeButton;
    private View positiveButton;
    private String requestKey;
    private int result;
    private SearchView searchView;
    private Toolbar toolbar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final Result Result(Bundle bundle) {
        return INSTANCE.Result(bundle);
    }

    @JvmStatic
    public static final FolderPickerDialog toImportNeboFile(Uri uri) {
        return INSTANCE.toImportNeboFile(uri);
    }

    @JvmStatic
    public static final FolderPickerDialog toImportPdf(Uri uri) {
        return INSTANCE.toImportPdf(uri);
    }

    @JvmStatic
    public static final FolderPickerDialog toMovePages(List<? extends PageKey> list) {
        return INSTANCE.toMovePages(list);
    }

    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config;", "", "emptyStateLabelRes", "", "primaryActionLabelRes", "<init>", "(II)V", "getEmptyStateLabelRes", "()I", "getPrimaryActionLabelRes", "ImportPdf", "ImportNeboFile", "MovePages", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$ImportNeboFile;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$ImportPdf;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$MovePages;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static abstract class Config {
        private final int emptyStateLabelRes;
        private final int primaryActionLabelRes;

        public /* synthetic */ Config(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2);
        }

        private Config(int i, int i2) {
            this.emptyStateLabelRes = i;
            this.primaryActionLabelRes = i2;
        }

        public final int getEmptyStateLabelRes() {
            return this.emptyStateLabelRes;
        }

        public final int getPrimaryActionLabelRes() {
            return this.primaryActionLabelRes;
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$ImportPdf;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class ImportPdf extends Config {
            public static final int $stable = 0;
            public static final ImportPdf INSTANCE = new ImportPdf();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImportPdf)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1570370537;
            }

            public String toString() {
                return "ImportPdf";
            }

            private ImportPdf() {
                super(C6208R.string.notebook_picker_empty_state_subtitle_no_folder, C6208R.string.notebook_picker_action_import, null);
            }
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$ImportNeboFile;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class ImportNeboFile extends Config {
            public static final int $stable = 0;
            public static final ImportNeboFile INSTANCE = new ImportNeboFile();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImportNeboFile)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -707973303;
            }

            public String toString() {
                return "ImportNeboFile";
            }

            private ImportNeboFile() {
                super(0, C6208R.string.notebook_picker_action_import, null);
            }
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config$MovePages;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class MovePages extends Config {
            public static final int $stable = 0;
            public static final MovePages INSTANCE = new MovePages();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MovePages)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1462006961;
            }

            public String toString() {
                return "MovePages";
            }

            private MovePages() {
                super(0, C6208R.string.notebook_picker_action_move, null);
            }
        }
    }

    public FolderPickerDialog() {
        final FolderPickerDialog folderPickerDialog = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FolderPickerDialog.dmsViewModel_delegate$lambda$0();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return folderPickerDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$special$$inlined$viewModels$default$2
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
        this.dmsViewModel = FragmentViewModelLazyKt.createViewModelLazy(folderPickerDialog, Reflection.getOrCreateKotlinClass(SimpleDMSViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$special$$inlined$viewModels$default$4
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
    }

    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result;", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Lcom/myscript/snt/core/NotebookKey;)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "PdfImport", "NeboFileImport", "PagesMove", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$NeboFileImport;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$PagesMove;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$PdfImport;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Result {
        public static final int $stable = 8;
        private final NotebookKey notebookKey;

        public /* synthetic */ Result(NotebookKey notebookKey, DefaultConstructorMarker defaultConstructorMarker) {
            this(notebookKey);
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$PdfImport;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result;", "pdfUri", "Landroid/net/Uri;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Landroid/net/Uri;Lcom/myscript/snt/core/NotebookKey;)V", "getPdfUri", "()Landroid/net/Uri;", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class PdfImport extends Result {
            public static final int $stable = 8;
            private final NotebookKey notebookKey;
            private final Uri pdfUri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PdfImport(Uri pdfUri, NotebookKey notebookKey) {
                super(notebookKey, null);
                Intrinsics.checkNotNullParameter(pdfUri, "pdfUri");
                this.pdfUri = pdfUri;
                this.notebookKey = notebookKey;
            }

            @Override // com.myscript.nebo.dms.dialog.FolderPickerDialog.Result
            public NotebookKey getNotebookKey() {
                return this.notebookKey;
            }

            public final Uri getPdfUri() {
                return this.pdfUri;
            }
        }

        private Result(NotebookKey notebookKey) {
            this.notebookKey = notebookKey;
        }

        public NotebookKey getNotebookKey() {
            return this.notebookKey;
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$NeboFileImport;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result;", "neboFileUri", "Landroid/net/Uri;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Landroid/net/Uri;Lcom/myscript/snt/core/NotebookKey;)V", "getNeboFileUri", "()Landroid/net/Uri;", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class NeboFileImport extends Result {
            public static final int $stable = 8;
            private final Uri neboFileUri;
            private final NotebookKey notebookKey;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NeboFileImport(Uri neboFileUri, NotebookKey notebookKey) {
                super(notebookKey, null);
                Intrinsics.checkNotNullParameter(neboFileUri, "neboFileUri");
                this.neboFileUri = neboFileUri;
                this.notebookKey = notebookKey;
            }

            public final Uri getNeboFileUri() {
                return this.neboFileUri;
            }

            @Override // com.myscript.nebo.dms.dialog.FolderPickerDialog.Result
            public NotebookKey getNotebookKey() {
                return this.notebookKey;
            }
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result$PagesMove;", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result;", "pageKeys", "", "Lcom/myscript/snt/core/PageKey;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Ljava/util/List;Lcom/myscript/snt/core/NotebookKey;)V", "getPageKeys", "()Ljava/util/List;", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class PagesMove extends Result {
            public static final int $stable = 8;
            private final NotebookKey notebookKey;
            private final List<PageKey> pageKeys;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public PagesMove(List<? extends PageKey> pageKeys, NotebookKey notebookKey) {
                super(notebookKey, null);
                Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
                this.pageKeys = pageKeys;
                this.notebookKey = notebookKey;
            }

            @Override // com.myscript.nebo.dms.dialog.FolderPickerDialog.Result
            public NotebookKey getNotebookKey() {
                return this.notebookKey;
            }

            public final List<PageKey> getPageKeys() {
                return this.pageKeys;
            }
        }
    }

    private final SimpleDMSViewModel getDmsViewModel() {
        return (SimpleDMSViewModel) this.dmsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory dmsViewModel_delegate$lambda$0() {
        return SimpleDMSViewModel.INSTANCE.getFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        Config.ImportNeboFile importNeboFile;
        String str;
        super.onCreate(savedInstanceState);
        String string = requireArguments().getString(REQUEST_KEY_ARG);
        if (string == null) {
            throw new IllegalArgumentException("Missing request key".toString());
        }
        this.requestKey = string;
        String str2 = null;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestKey");
            string = null;
        }
        int iHashCode = string.hashCode();
        if (iHashCode == -91486536) {
            if (string.equals(NEBO_FILE_IMPORT_REQUEST_KEY)) {
                importNeboFile = Config.ImportNeboFile.INSTANCE;
                this.config = importNeboFile;
                this.dmsAdapter = new DmsSimpleAdapter(new C62442(this), null, null, null, 14, null);
                setStyle(2, getTheme());
                return;
            }
            str = this.requestKey;
            if (str == null) {
            }
            throw new IllegalArgumentException("Unsupported request key " + str2);
        }
        if (iHashCode == 741636833) {
            if (string.equals(MOVE_PAGES_REQUEST_KEY)) {
                importNeboFile = Config.MovePages.INSTANCE;
                this.config = importNeboFile;
                this.dmsAdapter = new DmsSimpleAdapter(new C62442(this), null, null, null, 14, null);
                setStyle(2, getTheme());
                return;
            }
            str = this.requestKey;
            if (str == null) {
            }
            throw new IllegalArgumentException("Unsupported request key " + str2);
        }
        if (iHashCode == 889860829 && string.equals(PDF_IMPORT_REQUEST_KEY)) {
            importNeboFile = Config.ImportPdf.INSTANCE;
            this.config = importNeboFile;
            this.dmsAdapter = new DmsSimpleAdapter(new C62442(this), null, null, null, 14, null);
            setStyle(2, getTheme());
            return;
        }
        str = this.requestKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestKey");
        } else {
            str2 = str;
        }
        throw new IllegalArgumentException("Unsupported request key " + str2);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dialog.FolderPickerDialog$onCreate$2 */
    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62442 extends FunctionReferenceImpl implements Function1<FolderModel, Unit> {
        C62442(Object obj) {
            super(1, obj, FolderPickerDialog.class, "onFolderClicked", "onFolderClicked(Lcom/myscript/nebo/dms/core/model/FolderModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderModel folderModel) {
            invoke2(folderModel);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderModel p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FolderPickerDialog) this.receiver).onFolderClicked(p0);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_Dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Menu menu;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6208R.layout.folder_picker_dialog, container, false);
        Toolbar toolbar = (Toolbar) viewInflate.findViewById(C6208R.id.folder_picker_dialog_toolbar);
        Config config = null;
        if (!toolbar.getResources().getBoolean(C6208R.bool.dms_fullscreen_dialog)) {
            toolbar.setNavigationIcon((Drawable) null);
        }
        toolbar.setTitle(C6208R.string.notebook_picker_dialog_title);
        this.toolbar = toolbar;
        MenuItem menuItemFindItem = (toolbar == null || (menu = toolbar.getMenu()) == null) ? null : menu.findItem(C6208R.id.folder_picker_toolbar_filter);
        View actionView = menuItemFindItem != null ? menuItemFindItem.getActionView() : null;
        SearchView searchView = actionView instanceof SearchView ? (SearchView) actionView : null;
        if (searchView != null) {
            searchView.setMaxWidth(Integer.MAX_VALUE);
        } else {
            searchView = null;
        }
        this.searchView = searchView;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6208R.id.folder_picker_list);
        DmsSimpleAdapter dmsSimpleAdapter = this.dmsAdapter;
        if (dmsSimpleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dmsAdapter");
            dmsSimpleAdapter = null;
        }
        recyclerView.setAdapter(dmsSimpleAdapter);
        this.dmsList = recyclerView;
        this.dmsListEmptyState = viewInflate.findViewById(C6208R.id.folder_picker_list_empty_state);
        TextView textView = (TextView) viewInflate.findViewById(C6208R.id.folder_picker_list_empty_state_subtitle);
        Intrinsics.checkNotNull(textView);
        TextView textView2 = textView;
        Config config2 = this.config;
        if (config2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            config2 = null;
        }
        textView2.setVisibility(config2.getEmptyStateLabelRes() != 0 ? 0 : 8);
        Config config3 = this.config;
        if (config3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            config3 = null;
        }
        if (config3.getEmptyStateLabelRes() != 0) {
            Config config4 = this.config;
            if (config4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                config4 = null;
            }
            textView.setText(config4.getEmptyStateLabelRes());
        } else {
            textView.setText((CharSequence) null);
        }
        this.dmsListEmptyStateSubtitle = textView;
        this.negativeButton = viewInflate.findViewById(C6208R.id.folder_picker_negative_button);
        View viewFindViewById = viewInflate.findViewById(C6208R.id.folder_picker_positive_button);
        Button button = (Button) viewFindViewById;
        Config config5 = this.config;
        if (config5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        } else {
            config = config5;
        }
        button.setText(config.getPrimaryActionLabelRes());
        this.positiveButton = viewFindViewById;
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return FolderPickerDialog.onCreateDialog$lambda$0$0(dialogOnCreateDialog, dialogInterface, i, keyEvent);
            }
        });
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

    public final void show(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        DialogFragmentExt.showAtMostOnce(this, fragmentManager, TAG);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewExt.configureForEdgeToEdge(view);
        FolderPickerDialog folderPickerDialog = this;
        getDmsViewModel().getState().observe(folderPickerDialog, new FolderPickerDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FolderPickerDialog.onViewCreated$lambda$0(this.f$0, (SimpleDMSViewModel.DMSState) obj);
            }
        }));
        getDmsViewModel().getSelectedFolder().observe(folderPickerDialog, new FolderPickerDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FolderPickerDialog.onViewCreated$lambda$1(this.f$0, (NotebookKey) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(FolderPickerDialog folderPickerDialog, SimpleDMSViewModel.DMSState dMSState) {
        int i;
        if (dMSState instanceof SimpleDMSViewModel.DMSState.NoFolder) {
            i = 2;
        } else {
            if (!(dMSState instanceof SimpleDMSViewModel.DMSState.Loading)) {
                if (!(dMSState instanceof SimpleDMSViewModel.DMSState.Ready)) {
                    throw new NoWhenBranchMatchedException();
                }
                folderPickerDialog.onCollectionsUpdated(((SimpleDMSViewModel.DMSState.Ready) dMSState).getCollections());
            }
            i = -1;
        }
        folderPickerDialog.result = i;
        if (i != 0 && i != -1) {
            folderPickerDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(FolderPickerDialog folderPickerDialog, NotebookKey notebookKey) {
        View view = folderPickerDialog.positiveButton;
        if (view != null) {
            view.setEnabled(notebookKey != null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFilterUpdate(String label) {
        getDmsViewModel().filter(label);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
        }
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$onStart$2$1
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String label) {
                    Intrinsics.checkNotNullParameter(label, "label");
                    this.this$0.onFilterUpdate(label);
                    return true;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String label) {
                    Intrinsics.checkNotNullParameter(label, "label");
                    this.this$0.onFilterUpdate(label);
                    return true;
                }
            });
            searchView.setOnSearchClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FolderPickerDialog.onStart$lambda$1$0(this.f$0, view);
                }
            });
        }
        View view = this.negativeButton;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.dismiss();
                }
            });
        }
        View view2 = this.positiveButton;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.dialog.FolderPickerDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.onImport();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$1$0(FolderPickerDialog folderPickerDialog, View view) {
        folderPickerDialog.getDmsViewModel().selectFolder(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(null);
        }
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.setOnQueryTextListener(null);
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setOnSearchClickListener(null);
        }
        View view = this.negativeButton;
        if (view != null) {
            view.setOnClickListener(null);
        }
        View view2 = this.positiveButton;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toolbar = null;
        this.searchView = null;
        RecyclerView recyclerView = this.dmsList;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.dmsList = null;
        this.dmsListEmptyState = null;
        this.dmsListEmptyStateSubtitle = null;
        this.negativeButton = null;
        this.positiveButton = null;
        super.onDestroyView();
    }

    private final void onCollectionsUpdated(List<CollectionModel> collections) {
        TextView textView;
        DmsSimpleAdapter dmsSimpleAdapter = this.dmsAdapter;
        DmsSimpleAdapter dmsSimpleAdapter2 = null;
        if (dmsSimpleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dmsAdapter");
            dmsSimpleAdapter = null;
        }
        dmsSimpleAdapter.setParentList(collections, true);
        DmsSimpleAdapter dmsSimpleAdapter3 = this.dmsAdapter;
        if (dmsSimpleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dmsAdapter");
        } else {
            dmsSimpleAdapter2 = dmsSimpleAdapter3;
        }
        boolean z = dmsSimpleAdapter2.getItemCount() > 0;
        View view = this.dmsListEmptyState;
        if (view != null) {
            view.setVisibility(!z ? 0 : 8);
        }
        RecyclerView recyclerView = this.dmsList;
        if (recyclerView != null) {
            recyclerView.setVisibility(z ? 0 : 8);
        }
        if (z || (textView = this.dmsListEmptyStateSubtitle) == null) {
            return;
        }
        textView.setText(C6208R.string.notebook_picker_empty_state_subtitle_no_folder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFolderClicked(FolderModel folder) {
        getDmsViewModel().selectFolder(folder.getNotebookKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onImport() {
        this.result = 0;
        dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDismiss(DialogInterface dialog) {
        String strSerialize;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.result == -1) {
            this.result = 1;
        }
        NotebookKey value = getDmsViewModel().getSelectedFolder().getValue();
        String str = null;
        if (value == null) {
            strSerialize = null;
        } else {
            if (this.result != 0) {
                value = null;
            }
            if (value != null) {
                strSerialize = value.serialize();
            }
        }
        Config config = this.config;
        if (config == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            config = null;
        }
        if (Intrinsics.areEqual(config, Config.ImportPdf.INSTANCE)) {
            FolderPickerDialog folderPickerDialog = this;
            String str2 = this.requestKey;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestKey");
                str2 = null;
            }
            Bundle bundle = new Bundle();
            String str3 = this.requestKey;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestKey");
            } else {
                str = str3;
            }
            bundle.putString(REQUEST_KEY_ARG, str);
            Uri uri = (Uri) BundleCompat.getParcelable(requireArguments(), PDF_URI_ARG, Uri.class);
            if (uri == null) {
                throw new IllegalStateException("Missing PDF Uri PDF_URI_ARG".toString());
            }
            bundle.putParcelable(PDF_URI_ARG, uri);
            bundle.putString(SELECTED_FOLDER_KEY, strSerialize);
            Unit unit = Unit.INSTANCE;
            FragmentKt.setFragmentResult(folderPickerDialog, str2, bundle);
            return;
        }
        if (Intrinsics.areEqual(config, Config.ImportNeboFile.INSTANCE)) {
            FolderPickerDialog folderPickerDialog2 = this;
            String str4 = this.requestKey;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestKey");
                str4 = null;
            }
            Bundle bundle2 = new Bundle();
            String str5 = this.requestKey;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestKey");
            } else {
                str = str5;
            }
            bundle2.putString(REQUEST_KEY_ARG, str);
            Uri uri2 = (Uri) BundleCompat.getParcelable(requireArguments(), NEBO_FILE_URI_ARG, Uri.class);
            if (uri2 == null) {
                throw new IllegalStateException("Missing PDF Uri NEBO_FILE_URI_ARG".toString());
            }
            bundle2.putParcelable(NEBO_FILE_URI_ARG, uri2);
            bundle2.putString(SELECTED_FOLDER_KEY, strSerialize);
            Unit unit2 = Unit.INSTANCE;
            FragmentKt.setFragmentResult(folderPickerDialog2, str4, bundle2);
            return;
        }
        if (!Intrinsics.areEqual(config, Config.MovePages.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        FolderPickerDialog folderPickerDialog3 = this;
        String str6 = this.requestKey;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestKey");
            str6 = null;
        }
        Bundle bundle3 = new Bundle();
        ArrayList<String> stringArrayList = requireArguments().getStringArrayList(PAGE_KEYS_ARG);
        if (stringArrayList == null) {
            throw new IllegalArgumentException("Missing page keys PAGE_KEYS_ARG".toString());
        }
        String str7 = this.requestKey;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestKey");
        } else {
            str = str7;
        }
        bundle3.putString(REQUEST_KEY_ARG, str);
        bundle3.putStringArrayList(PAGE_KEYS_ARG, stringArrayList);
        bundle3.putString(SELECTED_FOLDER_KEY, strSerialize);
        Unit unit3 = Unit.INSTANCE;
        FragmentKt.setFragmentResult(folderPickerDialog3, str6, bundle3);
    }

    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0016\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Companion;", "", "<init>", "()V", "TAG", "", "PDF_IMPORT_REQUEST_KEY", "NEBO_FILE_IMPORT_REQUEST_KEY", "MOVE_PAGES_REQUEST_KEY", FolderPickerDialog.SELECTED_FOLDER_KEY, FolderPickerDialog.REQUEST_KEY_ARG, FolderPickerDialog.PDF_URI_ARG, FolderPickerDialog.NEBO_FILE_URI_ARG, FolderPickerDialog.PAGE_KEYS_ARG, "RESULT_KEY", "UNDEFINED_RESULT_CODE", "", "FOLDER_SELECTED_RESULT_CODE", "CANCELED_RESULT_CODE", "NO_FOLDER_RESULT_CODE", "toImportPdf", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog;", "pdfUri", "Landroid/net/Uri;", "toImportNeboFile", "neboFileUri", "toMovePages", "pageKeys", "", "Lcom/myscript/snt/core/PageKey;", "Result", "Lcom/myscript/nebo/dms/dialog/FolderPickerDialog$Result;", "bundle", "Landroid/os/Bundle;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FolderPickerDialog toImportPdf(Uri pdfUri) {
            Intrinsics.checkNotNullParameter(pdfUri, "pdfUri");
            FolderPickerDialog folderPickerDialog = new FolderPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putString(FolderPickerDialog.REQUEST_KEY_ARG, FolderPickerDialog.PDF_IMPORT_REQUEST_KEY);
            bundle.putParcelable(FolderPickerDialog.PDF_URI_ARG, pdfUri);
            folderPickerDialog.setArguments(bundle);
            return folderPickerDialog;
        }

        @JvmStatic
        public final FolderPickerDialog toImportNeboFile(Uri neboFileUri) {
            Intrinsics.checkNotNullParameter(neboFileUri, "neboFileUri");
            FolderPickerDialog folderPickerDialog = new FolderPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putString(FolderPickerDialog.REQUEST_KEY_ARG, FolderPickerDialog.NEBO_FILE_IMPORT_REQUEST_KEY);
            bundle.putParcelable(FolderPickerDialog.NEBO_FILE_URI_ARG, neboFileUri);
            folderPickerDialog.setArguments(bundle);
            return folderPickerDialog;
        }

        @JvmStatic
        public final FolderPickerDialog toMovePages(List<? extends PageKey> pageKeys) {
            Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
            ArrayList arrayList = new ArrayList();
            for (Object obj : pageKeys) {
                if (((PageKey) obj).isValid()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((PageKey) it.next()).serialize());
            }
            FolderPickerDialog folderPickerDialog = new FolderPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putString(FolderPickerDialog.REQUEST_KEY_ARG, FolderPickerDialog.MOVE_PAGES_REQUEST_KEY);
            bundle.putStringArrayList(FolderPickerDialog.PAGE_KEYS_ARG, new ArrayList<>(arrayList3));
            folderPickerDialog.setArguments(bundle);
            return folderPickerDialog;
        }

        @JvmStatic
        public final Result Result(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(FolderPickerDialog.REQUEST_KEY_ARG);
            if (string == null) {
                throw new IllegalArgumentException("Missing request key".toString());
            }
            String string2 = bundle.getString(FolderPickerDialog.SELECTED_FOLDER_KEY);
            NotebookKey notebookKeyDeserialize = string2 != null ? NotebookKey.deserialize(string2) : null;
            int iHashCode = string.hashCode();
            if (iHashCode != -91486536) {
                if (iHashCode != 741636833) {
                    if (iHashCode == 889860829 && string.equals(FolderPickerDialog.PDF_IMPORT_REQUEST_KEY)) {
                        Uri uri = (Uri) BundleCompat.getParcelable(bundle, FolderPickerDialog.PDF_URI_ARG, Uri.class);
                        if (uri == null) {
                            throw new IllegalStateException("Missing PDF URI".toString());
                        }
                        return new Result.PdfImport(uri, notebookKeyDeserialize);
                    }
                } else if (string.equals(FolderPickerDialog.MOVE_PAGES_REQUEST_KEY)) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(FolderPickerDialog.PAGE_KEYS_ARG);
                    if (stringArrayList == null) {
                        throw new IllegalStateException("Missing page keys".toString());
                    }
                    ArrayList<String> arrayList = stringArrayList;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(PageKey.deserialize((String) it.next()));
                    }
                    return new Result.PagesMove(arrayList2, notebookKeyDeserialize);
                }
            } else if (string.equals(FolderPickerDialog.NEBO_FILE_IMPORT_REQUEST_KEY)) {
                Uri uri2 = (Uri) BundleCompat.getParcelable(bundle, FolderPickerDialog.NEBO_FILE_URI_ARG, Uri.class);
                if (uri2 == null) {
                    throw new IllegalStateException("Missing Nebo file URI".toString());
                }
                return new Result.NeboFileImport(uri2, notebookKeyDeserialize);
            }
            throw new IllegalArgumentException("Unsupported request key " + string);
        }
    }
}
