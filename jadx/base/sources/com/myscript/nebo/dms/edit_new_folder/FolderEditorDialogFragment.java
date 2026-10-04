package com.myscript.nebo.dms.edit_new_folder;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0028R;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.DialogUtilsKt;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel;
import com.myscript.nebo.dms.p026ui.compose.FolderActionPaneKt;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.DMSFilter;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "folderEditorAction", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;", "folderName", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "color", "", "folderKey", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "folderEditorViewModel", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel;", "getFolderEditorViewModel", "()Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel;", "folderEditorViewModel$delegate", "Lkotlin/Lazy;", "getTheme", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", "submit", "Result", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderEditorDialogFragment extends DialogFragment {
    public static final String ARGUMENTS_COLLECTION_KEY = "ARGUMENTS_COLLECTION_KEY";
    public static final String ARGUMENTS_COLOR_KEY = "ARGUMENTS_COLOR_KEY";
    public static final String ARGUMENTS_EDITOR_ACTION = "ARGUMENTS_EDITOR_ACTION";
    public static final String ARGUMENTS_FOLDER_KEY = "ARGUMENTS_FOLDER_KEY";
    public static final String REQUEST_KEY = "FolderEditorDialogFragment_REQUEST_KEY";
    public static final String RESULT_COLLECTION_KEY = "RESULT_COLLECTION_KEY";
    public static final String RESULT_COLOR = "RESULT_COLOR";
    public static final String RESULT_FOLDER_KEY = "RESULT_FOLDER_KEY";
    public static final String RESULT_FOLDER_NAME = "RESULT_FOLDER_NAME";
    public static final String TAG = "FolderEditorDialogFragment";
    private CollectionKey collectionKey = new CollectionKey();
    private int color;
    private FolderEditorAction folderEditorAction;

    /* JADX INFO: renamed from: folderEditorViewModel$delegate, reason: from kotlin metadata */
    private final Lazy folderEditorViewModel;
    private String folderKey;
    private String folderName;
    private LibraryRepository libraryRepository;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FolderEditorAction.values().length];
            try {
                iArr[FolderEditorAction.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FolderEditorAction.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final Result Result(Bundle bundle) {
        return INSTANCE.Result(bundle);
    }

    @JvmStatic
    public static final FolderEditorDialogFragment toCreate(CollectionKey collectionKey, int i) {
        return INSTANCE.toCreate(collectionKey, i);
    }

    @JvmStatic
    public static final FolderEditorDialogFragment toEdit(NotebookKey notebookKey, CollectionKey collectionKey, int i) {
        return INSTANCE.toEdit(notebookKey, collectionKey, i);
    }

    public FolderEditorDialogFragment() {
        final FolderEditorDialogFragment folderEditorDialogFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FolderEditorDialogFragment.folderEditorViewModel_delegate$lambda$0();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return folderEditorDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$special$$inlined$viewModels$default$2
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
        this.folderEditorViewModel = FragmentViewModelLazyKt.createViewModelLazy(folderEditorDialogFragment, Reflection.getOrCreateKotlinClass(FolderEditorViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$special$$inlined$viewModels$default$4
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

    /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result;", "", "<init>", "()V", "folderName", "", "getFolderName", "()Ljava/lang/String;", "color", "", "getColor", "()I", "Create", "Edit", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result$Create;", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result$Edit;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Result {
        public static final int $stable = 0;
        private final int color;
        private final String folderName;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
            this.folderName = "";
        }

        public String getFolderName() {
            return this.folderName;
        }

        public int getColor() {
            return this.color;
        }

        /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result$Create;", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result;", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "folderName", "", "color", "", "<init>", "(Lcom/myscript/snt/core/CollectionKey;Ljava/lang/String;I)V", "getCollectionKey", "()Lcom/myscript/snt/core/CollectionKey;", "getFolderName", "()Ljava/lang/String;", "getColor", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Create extends Result {
            public static final int $stable = 8;
            private final CollectionKey collectionKey;
            private final int color;
            private final String folderName;

            public static /* synthetic */ Create copy$default(Create create, CollectionKey collectionKey, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    collectionKey = create.collectionKey;
                }
                if ((i2 & 2) != 0) {
                    str = create.folderName;
                }
                if ((i2 & 4) != 0) {
                    i = create.color;
                }
                return create.copy(collectionKey, str, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionKey getCollectionKey() {
                return this.collectionKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getFolderName() {
                return this.folderName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Create copy(CollectionKey collectionKey, String folderName, int color) {
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                return new Create(collectionKey, folderName, color);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Create)) {
                    return false;
                }
                Create create = (Create) other;
                return Intrinsics.areEqual(this.collectionKey, create.collectionKey) && Intrinsics.areEqual(this.folderName, create.folderName) && this.color == create.color;
            }

            public int hashCode() {
                return (((this.collectionKey.hashCode() * 31) + this.folderName.hashCode()) * 31) + Integer.hashCode(this.color);
            }

            public String toString() {
                return "Create(collectionKey=" + this.collectionKey + ", folderName=" + this.folderName + ", color=" + this.color + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Create(CollectionKey collectionKey, String folderName, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                this.collectionKey = collectionKey;
                this.folderName = folderName;
                this.color = i;
            }

            public final CollectionKey getCollectionKey() {
                return this.collectionKey;
            }

            @Override // com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.Result
            public String getFolderName() {
                return this.folderName;
            }

            @Override // com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.Result
            public int getColor() {
                return this.color;
            }
        }

        /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
        @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result$Edit;", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result;", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "folderKey", "Lcom/myscript/snt/core/NotebookKey;", "folderName", "", "color", "", "<init>", "(Lcom/myscript/snt/core/CollectionKey;Lcom/myscript/snt/core/NotebookKey;Ljava/lang/String;I)V", "getCollectionKey", "()Lcom/myscript/snt/core/CollectionKey;", "getFolderKey", "()Lcom/myscript/snt/core/NotebookKey;", "getFolderName", "()Ljava/lang/String;", "getColor", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Edit extends Result {
            public static final int $stable = 8;
            private final CollectionKey collectionKey;
            private final int color;
            private final NotebookKey folderKey;
            private final String folderName;

            public static /* synthetic */ Edit copy$default(Edit edit, CollectionKey collectionKey, NotebookKey notebookKey, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    collectionKey = edit.collectionKey;
                }
                if ((i2 & 2) != 0) {
                    notebookKey = edit.folderKey;
                }
                if ((i2 & 4) != 0) {
                    str = edit.folderName;
                }
                if ((i2 & 8) != 0) {
                    i = edit.color;
                }
                return edit.copy(collectionKey, notebookKey, str, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionKey getCollectionKey() {
                return this.collectionKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final NotebookKey getFolderKey() {
                return this.folderKey;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getFolderName() {
                return this.folderName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Edit copy(CollectionKey collectionKey, NotebookKey folderKey, String folderName, int color) {
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(folderKey, "folderKey");
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                return new Edit(collectionKey, folderKey, folderName, color);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Edit)) {
                    return false;
                }
                Edit edit = (Edit) other;
                return Intrinsics.areEqual(this.collectionKey, edit.collectionKey) && Intrinsics.areEqual(this.folderKey, edit.folderKey) && Intrinsics.areEqual(this.folderName, edit.folderName) && this.color == edit.color;
            }

            public int hashCode() {
                return (((((this.collectionKey.hashCode() * 31) + this.folderKey.hashCode()) * 31) + this.folderName.hashCode()) * 31) + Integer.hashCode(this.color);
            }

            public String toString() {
                return "Edit(collectionKey=" + this.collectionKey + ", folderKey=" + this.folderKey + ", folderName=" + this.folderName + ", color=" + this.color + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Edit(CollectionKey collectionKey, NotebookKey folderKey, String folderName, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(folderKey, "folderKey");
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                this.collectionKey = collectionKey;
                this.folderKey = folderKey;
                this.folderName = folderName;
                this.color = i;
            }

            public final CollectionKey getCollectionKey() {
                return this.collectionKey;
            }

            public final NotebookKey getFolderKey() {
                return this.folderKey;
            }

            @Override // com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.Result
            public String getFolderName() {
                return this.folderName;
            }

            @Override // com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.Result
            public int getColor() {
                return this.color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory folderEditorViewModel_delegate$lambda$0() {
        return new FolderEditorViewModel.Factory(null, null, null, null, 0, 31, null);
    }

    private final FolderEditorViewModel getFolderEditorViewModel() {
        return (FolderEditorViewModel) this.folderEditorViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        String name;
        String string;
        FolderEditorAction folderEditorActionValueOf;
        String string2;
        CollectionKey collectionKeyDeserialize;
        FolderEditorAction folderEditorAction;
        String str;
        String string3;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        LibraryRepository libraryRepository = null;
        Object application = activity != null ? activity.getApplication() : null;
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        this.libraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        this.folderEditorAction = FolderEditorAction.CREATE;
        Bundle arguments = getArguments();
        this.folderKey = arguments != null ? arguments.getString(ARGUMENTS_FOLDER_KEY) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string3 = arguments2.getString(ARGUMENTS_FOLDER_KEY)) != null) {
            LibraryRepository libraryRepository2 = this.libraryRepository;
            if (libraryRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
                libraryRepository2 = null;
            }
            NotebookKey notebookKeyDeserialize = NotebookKey.deserialize(string3);
            Intrinsics.checkNotNullExpressionValue(notebookKeyDeserialize, "deserialize(...)");
            FolderModel folder = libraryRepository2.getFolder(notebookKeyDeserialize);
            name = folder != null ? folder.getName() : null;
            if (name == null) {
            }
        } else {
            name = "";
        }
        this.folderName = name;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string = arguments3.getString(ARGUMENTS_EDITOR_ACTION)) == null || (folderEditorActionValueOf = FolderEditorAction.valueOf(string)) == null) {
            throw new IllegalStateException("Missing folder create edit argument".toString());
        }
        this.folderEditorAction = folderEditorActionValueOf;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string2 = arguments4.getString(ARGUMENTS_COLLECTION_KEY)) == null || (collectionKeyDeserialize = CollectionKey.deserialize(string2)) == null) {
            throw new IllegalStateException("Missing collectionKey argument".toString());
        }
        this.collectionKey = collectionKeyDeserialize;
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            throw new IllegalStateException("Missing color argument".toString());
        }
        this.color = arguments5.getInt(ARGUMENTS_COLOR_KEY);
        FolderEditorViewModel folderEditorViewModel = getFolderEditorViewModel();
        FolderEditorAction folderEditorAction2 = this.folderEditorAction;
        if (folderEditorAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("folderEditorAction");
            folderEditorAction = null;
        } else {
            folderEditorAction = folderEditorAction2;
        }
        String str2 = this.folderName;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("folderName");
            str = null;
        } else {
            str = str2;
        }
        CollectionKey collectionKey = this.collectionKey;
        LibraryRepository libraryRepository3 = this.libraryRepository;
        if (libraryRepository3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
        } else {
            libraryRepository = libraryRepository3;
        }
        List<CollectionModel> collectionModels = libraryRepository.getCollectionModels(DMSFilter.ACTIVE);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collectionModels, 10)), 16));
        for (CollectionModel collectionModel : collectionModels) {
            linkedHashMap.put(collectionModel.getCollectionKey(), collectionModel.getName());
        }
        folderEditorViewModel.update(folderEditorAction, str, collectionKey, linkedHashMap, this.color);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6208R.layout.folder_creation_dialog, container);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        final ComposeView composeView = (ComposeView) viewInflate;
        DialogFragmentExt.allowWindowToBeResizedWithVirtualKeyboard(this);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        composeView.setViewCompositionStrategy(new ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner));
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(897627376, true, new Function2() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FolderEditorDialogFragment.onCreateView$lambda$0$0(composeView, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(ComposeView composeView, final FolderEditorDialogFragment folderEditorDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@4176L524,99@4076L624:FolderEditorDialogFragment.kt#yume5a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897627376, i, -1, "com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.onCreateView.<anonymous>.<anonymous> (FolderEditorDialogFragment.kt:99)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-505779592, true, new Function2() { // from class: com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderEditorDialogFragment.onCreateView$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(FolderEditorDialogFragment folderEditorDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4344L37,103@4433L36,104@4521L39,105@4601L8,106@4651L9,100@4198L484:FolderEditorDialogFragment.kt#yume5a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-505779592, i, -1, "com.myscript.nebo.dms.edit_new_folder.FolderEditorDialogFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (FolderEditorDialogFragment.kt:100)");
            }
            FolderEditorViewModel folderEditorViewModel = folderEditorDialogFragment.getFolderEditorViewModel();
            FolderEditorViewModel folderEditorViewModel2 = folderEditorDialogFragment.getFolderEditorViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -722878051, "CC(remember):FolderEditorDialogFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(folderEditorViewModel2);
            FolderEditorDialogFragment$onCreateView$1$1$1$1$1 folderEditorDialogFragment$onCreateView$1$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || folderEditorDialogFragment$onCreateView$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderEditorDialogFragment$onCreateView$1$1$1$1$1RememberedValue = new FolderEditorDialogFragment$onCreateView$1$1$1$1$1(folderEditorViewModel2);
                composer.updateRememberedValue(folderEditorDialogFragment$onCreateView$1$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function1 = (Function1) ((KFunction) folderEditorDialogFragment$onCreateView$1$1$1$1$1RememberedValue);
            FolderEditorViewModel folderEditorViewModel3 = folderEditorDialogFragment.getFolderEditorViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -722875204, "CC(remember):FolderEditorDialogFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(folderEditorViewModel3);
            FolderEditorDialogFragment$onCreateView$1$1$1$2$1 folderEditorDialogFragment$onCreateView$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || folderEditorDialogFragment$onCreateView$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderEditorDialogFragment$onCreateView$1$1$1$2$1RememberedValue = new FolderEditorDialogFragment$onCreateView$1$1$1$2$1(folderEditorViewModel3);
                composer.updateRememberedValue(folderEditorDialogFragment$onCreateView$1$1$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function12 = (Function1) ((KFunction) folderEditorDialogFragment$onCreateView$1$1$1$2$1RememberedValue);
            FolderEditorViewModel folderEditorViewModel4 = folderEditorDialogFragment.getFolderEditorViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -722872385, "CC(remember):FolderEditorDialogFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(folderEditorViewModel4);
            FolderEditorDialogFragment$onCreateView$1$1$1$3$1 folderEditorDialogFragment$onCreateView$1$1$1$3$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance3 || folderEditorDialogFragment$onCreateView$1$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderEditorDialogFragment$onCreateView$1$1$1$3$1RememberedValue = new FolderEditorDialogFragment$onCreateView$1$1$1$3$1(folderEditorViewModel4);
                composer.updateRememberedValue(folderEditorDialogFragment$onCreateView$1$1$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function13 = (Function1) ((KFunction) folderEditorDialogFragment$onCreateView$1$1$1$3$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -722869856, "CC(remember):FolderEditorDialogFragment.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(folderEditorDialogFragment);
            FolderEditorDialogFragment$onCreateView$1$1$1$4$1 folderEditorDialogFragment$onCreateView$1$1$1$4$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance4 || folderEditorDialogFragment$onCreateView$1$1$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderEditorDialogFragment$onCreateView$1$1$1$4$1RememberedValue = new FolderEditorDialogFragment$onCreateView$1$1$1$4$1(folderEditorDialogFragment);
                composer.updateRememberedValue(folderEditorDialogFragment$onCreateView$1$1$1$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) folderEditorDialogFragment$onCreateView$1$1$1$4$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -722868255, "CC(remember):FolderEditorDialogFragment.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(folderEditorDialogFragment);
            FolderEditorDialogFragment$onCreateView$1$1$1$5$1 folderEditorDialogFragment$onCreateView$1$1$1$5$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance5 || folderEditorDialogFragment$onCreateView$1$1$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderEditorDialogFragment$onCreateView$1$1$1$5$1RememberedValue = new FolderEditorDialogFragment$onCreateView$1$1$1$5$1(folderEditorDialogFragment);
                composer.updateRememberedValue(folderEditorDialogFragment$onCreateView$1$1$1$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FolderActionPaneKt.FolderActionPane(folderEditorViewModel, function1, function12, function13, function0, (Function0) ((KFunction) folderEditorDialogFragment$onCreateView$1$1$1$5$1RememberedValue), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void submit() {
        FolderEditorState value = getFolderEditorViewModel().getState().getValue();
        if (value != null) {
            FolderEditorAction folderEditorAction = this.folderEditorAction;
            if (folderEditorAction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("folderEditorAction");
                folderEditorAction = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[folderEditorAction.ordinal()];
            if (i == 1) {
                Bundle bundle = new Bundle();
                bundle.putString(ARGUMENTS_EDITOR_ACTION, "CREATE");
                bundle.putString(RESULT_FOLDER_NAME, StringsKt.trim((CharSequence) value.getFolderName()).toString());
                bundle.putString(RESULT_COLLECTION_KEY, value.getCollectionKey().serialize());
                bundle.putInt(RESULT_COLOR, value.getFolderColor());
                Unit unit = Unit.INSTANCE;
                FragmentKt.setFragmentResult(this, REQUEST_KEY, bundle);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(ARGUMENTS_EDITOR_ACTION, "EDIT");
                bundle2.putString(RESULT_FOLDER_KEY, this.folderKey);
                bundle2.putString(RESULT_FOLDER_NAME, StringsKt.trim((CharSequence) value.getFolderName()).toString());
                bundle2.putString(RESULT_COLLECTION_KEY, value.getCollectionKey().serialize());
                bundle2.putInt(RESULT_COLOR, value.getFolderColor());
                Unit unit2 = Unit.INSTANCE;
                FragmentKt.setFragmentResult(this, REQUEST_KEY, bundle2);
            }
        }
        dismiss();
    }

    /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007J&\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", FolderEditorDialogFragment.ARGUMENTS_FOLDER_KEY, FolderEditorDialogFragment.ARGUMENTS_EDITOR_ACTION, FolderEditorDialogFragment.ARGUMENTS_COLLECTION_KEY, FolderEditorDialogFragment.ARGUMENTS_COLOR_KEY, FolderEditorDialogFragment.RESULT_FOLDER_KEY, FolderEditorDialogFragment.RESULT_FOLDER_NAME, FolderEditorDialogFragment.RESULT_COLLECTION_KEY, FolderEditorDialogFragment.RESULT_COLOR, "toCreate", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment;", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "color", "", "toEdit", "folderKey", "Lcom/myscript/snt/core/NotebookKey;", "Result", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorDialogFragment$Result;", "bundle", "Landroid/os/Bundle;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FolderEditorAction.values().length];
                try {
                    iArr[FolderEditorAction.CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FolderEditorAction.EDIT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FolderEditorDialogFragment toCreate(CollectionKey collectionKey, int color) {
            FolderEditorDialogFragment folderEditorDialogFragment = new FolderEditorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FolderEditorDialogFragment.ARGUMENTS_EDITOR_ACTION, "CREATE");
            bundle.putString(FolderEditorDialogFragment.ARGUMENTS_COLLECTION_KEY, collectionKey != null ? collectionKey.serialize() : null);
            bundle.putInt(FolderEditorDialogFragment.ARGUMENTS_COLOR_KEY, color);
            folderEditorDialogFragment.setArguments(bundle);
            return folderEditorDialogFragment;
        }

        @JvmStatic
        public final FolderEditorDialogFragment toEdit(NotebookKey folderKey, CollectionKey collectionKey, int color) {
            FolderEditorDialogFragment folderEditorDialogFragment = new FolderEditorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FolderEditorDialogFragment.ARGUMENTS_EDITOR_ACTION, "EDIT");
            bundle.putString(FolderEditorDialogFragment.ARGUMENTS_COLLECTION_KEY, collectionKey != null ? collectionKey.serialize() : null);
            bundle.putString(FolderEditorDialogFragment.ARGUMENTS_FOLDER_KEY, folderKey != null ? folderKey.serialize() : null);
            bundle.putInt(FolderEditorDialogFragment.ARGUMENTS_COLOR_KEY, color);
            folderEditorDialogFragment.setArguments(bundle);
            return folderEditorDialogFragment;
        }

        @JvmStatic
        public final Result Result(Bundle bundle) {
            FolderEditorAction folderEditorActionValueOf;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(FolderEditorDialogFragment.ARGUMENTS_EDITOR_ACTION);
            if (string == null || (folderEditorActionValueOf = FolderEditorAction.valueOf(string)) == null) {
                throw new IllegalStateException("Missing folder create edit action".toString());
            }
            int i = WhenMappings.$EnumSwitchMapping$0[folderEditorActionValueOf.ordinal()];
            if (i == 1) {
                String string2 = bundle.getString(FolderEditorDialogFragment.RESULT_COLLECTION_KEY);
                if (string2 == null) {
                    throw new IllegalStateException("Missing collection key result".toString());
                }
                CollectionKey collectionKeyDeserialize = CollectionKey.deserialize(string2);
                Intrinsics.checkNotNullExpressionValue(collectionKeyDeserialize, "deserialize(...)");
                String string3 = bundle.getString(FolderEditorDialogFragment.RESULT_FOLDER_NAME);
                if (string3 != null) {
                    return new Result.Create(collectionKeyDeserialize, string3, bundle.getInt(FolderEditorDialogFragment.RESULT_COLOR));
                }
                throw new IllegalStateException("Missing folder name result".toString());
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String string4 = bundle.getString(FolderEditorDialogFragment.RESULT_FOLDER_KEY);
            if (string4 == null) {
                throw new IllegalStateException("Missing folder key result".toString());
            }
            NotebookKey notebookKeyDeserialize = NotebookKey.deserialize(string4);
            Intrinsics.checkNotNullExpressionValue(notebookKeyDeserialize, "deserialize(...)");
            String string5 = bundle.getString(FolderEditorDialogFragment.RESULT_COLLECTION_KEY);
            if (string5 == null) {
                throw new IllegalStateException("Missing collection key result".toString());
            }
            CollectionKey collectionKeyDeserialize2 = CollectionKey.deserialize(string5);
            Intrinsics.checkNotNullExpressionValue(collectionKeyDeserialize2, "deserialize(...)");
            String string6 = bundle.getString(FolderEditorDialogFragment.RESULT_FOLDER_NAME);
            if (string6 != null) {
                return new Result.Edit(collectionKeyDeserialize2, notebookKeyDeserialize, string6, bundle.getInt(FolderEditorDialogFragment.RESULT_COLOR));
            }
            throw new IllegalStateException("Missing folder name result".toString());
        }
    }
}
