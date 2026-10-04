package com.myscript.nebo.inspector;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.C0028R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.nebo.inspector.State;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: NeboInspectorActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J\b\u0010'\u001a\u00020\u001bH\u0014J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u001dH\u0014J\b\u0010*\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboInspectorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "filesAdapter", "Lcom/myscript/nebo/inspector/NeboFilesAdapter;", "filesViewModel", "Lcom/myscript/nebo/inspector/NeboFilesViewModel;", "getFilesViewModel", "()Lcom/myscript/nebo/inspector/NeboFilesViewModel;", "filesViewModel$delegate", "Lkotlin/Lazy;", "informationDetailToggle", "Landroid/view/View;", "informationDetailToggleIcon", "Landroid/widget/ImageView;", "informationLabel", "filesReload", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "filesEmptyState", "filesList", "Landroidx/recyclerview/widget/RecyclerView;", "stats", "Landroid/widget/TextView;", "restoredCount", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onPrepareOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "onStop", "onSaveInstanceState", "outState", "onSupportNavigateUp", "onReloadNeboFiles", "onShareInformation", "onCopyDetails", "onToggleDetails", "onRestoreNeboFiles", "onClearAllNeboFiles", "currentDatalogFilePath", "", "datalogLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onExportDatalog", "currentDumpedCloudFilePath", "dumpCloudLauncher", "onDumpV1", "onExportCloudOperationsLog", "Companion", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboInspectorActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SAVED_CURRENT_DATALOG_FILE_PATH = "EXTRA_SAVED_CURRENT_DATALOG_FILE_PATH";
    private static final String EXTRA_SAVED_CURRENT_DUMPED_CLOUD_FILE_PATH = "EXTRA_SAVED_CURRENT_DUMPED_CLOUD_FILE_PATH";
    private static final String RESTORATION_COLLECTION_NAME = "__RESTORED_NEBO__";
    private static final String RESTORED_CONTENT_COUNT_KEY = "RESTORED_CONTENT_COUNT_KEY";
    private String currentDatalogFilePath;
    private String currentDumpedCloudFilePath;
    private View filesEmptyState;
    private RecyclerView filesList;
    private SwipeRefreshLayout filesReload;

    /* JADX INFO: renamed from: filesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy filesViewModel;
    private View informationDetailToggle;
    private ImageView informationDetailToggleIcon;
    private View informationLabel;
    private int restoredCount;
    private TextView stats;
    private final NeboFilesAdapter filesAdapter = new NeboFilesAdapter();
    private final ActivityResultLauncher<Intent> datalogLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            NeboInspectorActivity.datalogLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> dumpCloudLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda2
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            NeboInspectorActivity.dumpCloudLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });

    public NeboInspectorActivity() {
        final NeboInspectorActivity neboInspectorActivity = this;
        final Function0 function0 = null;
        this.filesViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NeboFilesViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return neboInspectorActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboInspectorActivity.filesViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? neboInspectorActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NeboFilesViewModel getFilesViewModel() {
        return (NeboFilesViewModel) this.filesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory filesViewModel_delegate$lambda$0() {
        return NeboFilesViewModel.INSTANCE.getFactory();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C6609R.layout.inspector_activity);
        this.currentDumpedCloudFilePath = savedInstanceState != null ? savedInstanceState.getString(EXTRA_SAVED_CURRENT_DUMPED_CLOUD_FILE_PATH) : null;
        this.currentDatalogFilePath = savedInstanceState != null ? savedInstanceState.getString(EXTRA_SAVED_CURRENT_DATALOG_FILE_PATH) : null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
        TextView textView = (TextView) findViewById(C6609R.id.inspector_files_explanation);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinksClickable(true);
        this.informationDetailToggle = findViewById(C6609R.id.inspector_info_detail_toggle);
        this.informationDetailToggleIcon = (ImageView) findViewById(C6609R.id.inspector_info_detail_toggle_icon);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        InspectorInformation inspectorInformation = new InspectorInformation(application, CollectionsKt.emptyList(), getFilesViewModel().getStats());
        View viewFindViewById = findViewById(C6609R.id.inspector_info);
        TextView textView2 = (TextView) viewFindViewById;
        textView2.setMovementMethod(new ScrollingMovementMethod());
        NeboInspectorActivity neboInspectorActivity = this;
        LifecycleOwnerKt.getLifecycleScope(neboInspectorActivity).launchWhenCreated(new NeboInspectorActivity$onCreate$3$1(textView2, inspectorInformation, null));
        this.informationLabel = viewFindViewById;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(C6609R.id.inspector_files_reload);
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        swipeRefreshLayout.setColorSchemeColors(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorAccent));
        this.filesReload = swipeRefreshLayout;
        this.filesEmptyState = findViewById(C6609R.id.inspector_files_empty_state);
        RecyclerView recyclerView = (RecyclerView) findViewById(C6609R.id.inspector_files_list);
        recyclerView.setAdapter(this.filesAdapter);
        this.filesList = recyclerView;
        this.stats = (TextView) findViewById(C6609R.id.inspector_dms_stats);
        getFilesViewModel().getState().observe(neboInspectorActivity, new NeboInspectorActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboInspectorActivity.onCreate$lambda$5(this.f$0, (State) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(NeboInspectorActivity neboInspectorActivity, State state) {
        SwipeRefreshLayout swipeRefreshLayout = neboInspectorActivity.filesReload;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(state instanceof State.Loading);
        }
        if ((state instanceof State.Loading) || (state instanceof State.Empty)) {
            View view = neboInspectorActivity.filesEmptyState;
            if (view != null) {
                view.setVisibility(0);
            }
            RecyclerView recyclerView = neboInspectorActivity.filesList;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        } else {
            if (!(state instanceof State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            View view2 = neboInspectorActivity.filesEmptyState;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            RecyclerView recyclerView2 = neboInspectorActivity.filesList;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
        }
        TextView textView = neboInspectorActivity.stats;
        if (textView != null) {
            Stats stats = state.getStats();
            textView.setText(neboInspectorActivity.getString(C6609R.string.inspector_dms_stats, new Object[]{Integer.valueOf(stats.getCollectionsCount()), Integer.valueOf(stats.getNotebooksCount()), Integer.valueOf(stats.getPagesCount())}));
        }
        neboInspectorActivity.filesAdapter.submitList(state.getFiles());
        neboInspectorActivity.invalidateOptionsMenu();
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean zOnCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C6609R.menu.inspector_files_menu, menu);
        return zOnCreateOptionsMenu;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            MenuItem menuItemFindItem = menu.findItem(C6609R.id.inspector_files_clear_all);
            if (menuItemFindItem != null) {
                menuItemFindItem.setEnabled(!getFilesViewModel().isEmpty());
            }
            MenuItem menuItemFindItem2 = menu.findItem(C6609R.id.inspector_files_restore);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setEnabled(!getFilesViewModel().isEmpty());
            }
            MenuItem menuItemFindItem3 = menu.findItem(C6609R.id.inspector_sync_export_datalog);
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setEnabled(getFilesViewModel().isCloudConnected());
            }
            MenuItem menuItemFindItem4 = menu.findItem(C6609R.id.inspector_sync_dump_v1);
            if (menuItemFindItem4 != null) {
                menuItemFindItem4.setEnabled(getFilesViewModel().isCloudConnected());
            }
            MenuItem menuItemFindItem5 = menu.findItem(C6609R.id.inspector_sync_export_cloud_operations_log);
            if (menuItemFindItem5 != null) {
                menuItemFindItem5.setEnabled(getFilesViewModel().isCloudConnected());
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == C6609R.id.inspector_files_share_info) {
            onShareInformation();
            return true;
        }
        if (itemId == C6609R.id.inspector_files_restore) {
            onRestoreNeboFiles();
            return true;
        }
        if (itemId == C6609R.id.inspector_files_clear_all) {
            onClearAllNeboFiles();
            return true;
        }
        if (itemId == C6609R.id.inspector_sync_export_datalog) {
            onExportDatalog();
            return true;
        }
        if (itemId == C6609R.id.inspector_sync_dump_v1) {
            onDumpV1();
            return true;
        }
        if (itemId != C6609R.id.inspector_sync_export_cloud_operations_log) {
            return super.onOptionsItemSelected(item);
        }
        onExportCloudOperationsLog();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        View view = this.informationDetailToggle;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.onToggleDetails();
                }
            });
        }
        View view2 = this.informationLabel;
        if (view2 != null) {
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view3) {
                    return NeboInspectorActivity.onStart$lambda$1(this.f$0, view3);
                }
            });
        }
        SwipeRefreshLayout swipeRefreshLayout = this.filesReload;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda6
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    this.f$0.onReloadNeboFiles();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onStart$lambda$1(NeboInspectorActivity neboInspectorActivity, View view) {
        return neboInspectorActivity.onCopyDetails();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        View view = this.informationDetailToggle;
        if (view != null) {
            view.setOnClickListener(null);
        }
        View view2 = this.informationLabel;
        if (view2 != null) {
            view2.setOnLongClickListener(null);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.filesReload;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(null);
        }
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(EXTRA_SAVED_CURRENT_DUMPED_CLOUD_FILE_PATH, this.currentDumpedCloudFilePath);
        outState.putString(EXTRA_SAVED_CURRENT_DATALOG_FILE_PATH, this.currentDatalogFilePath);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onReloadNeboFiles() {
        getFilesViewModel().reload();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onShareInformation$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onShareInformation$1", m1609f = "NeboInspectorActivity.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_6}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {190}, m1615s = {}, m1616v = 2)
    static final class C66081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66081(Continuation<? super C66081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboInspectorActivity.this.new C66081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getDefault(), new NeboInspectorActivity$onShareInformation$1$json$1(NeboInspectorActivity.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (String) obj);
            NeboInspectorActivity neboInspectorActivity = NeboInspectorActivity.this;
            neboInspectorActivity.startActivity(Intent.createChooser(intent, neboInspectorActivity.getString(C6609R.string.inspector_files_share_sheet_title)));
            return Unit.INSTANCE;
        }
    }

    private final void onShareInformation() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new C66081(null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onCopyDetails$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onCopyDetails$1", m1609f = "NeboInspectorActivity.kt", m1610i = {}, m1611l = {202}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {206}, m1615s = {}, m1616v = 2)
    static final class C66031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66031(Continuation<? super C66031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboInspectorActivity.this.new C66031(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getDefault(), new NeboInspectorActivity$onCopyDetails$1$json$1(NeboInspectorActivity.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object systemService = NeboInspectorActivity.this.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(NeboInspectorActivity.this.getString(C6609R.string.inspector_app_details_section_title), (String) obj));
            Toast.makeText(NeboInspectorActivity.this, C6609R.string.inspector_app_details_copied_to_clipboard, 1).show();
            return Unit.INSTANCE;
        }
    }

    private final boolean onCopyDetails() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new C66031(null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onToggleDetails() {
        View view = this.informationLabel;
        if (view != null) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), view.isShown() ? C6609R.drawable.ic_arrow_down_to_up : C6609R.drawable.ic_arrow_up_to_down, getTheme());
            ImageView imageView = this.informationDetailToggleIcon;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
            if (animatable != null) {
                animatable.start();
            }
            view.setVisibility(view.isShown() ? 8 : 0);
        }
    }

    private final void onRestoreNeboFiles() {
        NeboFilesViewModel.restoreCurrentState$default(getFilesViewModel(), RESTORATION_COLLECTION_NAME + new SimpleDateFormat("yyyy-MM-dd HHmmss", Locale.US).format(Long.valueOf(System.currentTimeMillis())), null, new Function1() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboInspectorActivity.onRestoreNeboFiles$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRestoreNeboFiles$lambda$1(NeboInspectorActivity neboInspectorActivity, int i) {
        neboInspectorActivity.restoredCount += i;
        Intent intent = new Intent();
        intent.putExtra(RESTORED_CONTENT_COUNT_KEY, neboInspectorActivity.restoredCount);
        Unit unit = Unit.INSTANCE;
        neboInspectorActivity.setResult(-1, intent);
        Toast.makeText(neboInspectorActivity, neboInspectorActivity.getResources().getQuantityString(C6609R.plurals.inspector_files_restoration_done, i, Integer.valueOf(i)), 1).show();
        return Unit.INSTANCE;
    }

    private final void onClearAllNeboFiles() {
        new MaterialAlertDialogBuilder(this).setMessage(C6609R.string.inspector_files_clear_all_dialog_confirmation).setPositiveButton(C6609R.string.inspector_files_clear_all_dialog_confirm_action, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.inspector.NeboInspectorActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NeboInspectorActivity.onClearAllNeboFiles$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClearAllNeboFiles$lambda$0(NeboInspectorActivity neboInspectorActivity, DialogInterface dialogInterface, int i) {
        neboInspectorActivity.getFilesViewModel().clearCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void datalogLauncher$lambda$0(NeboInspectorActivity neboInspectorActivity, ActivityResult it) {
        Uri data;
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        Intent data2 = it.getData();
        if (data2 != null && (data = data2.getData()) != null && (str = neboInspectorActivity.currentDatalogFilePath) != null) {
            File file = new File(str);
            OutputStream fileInputStream = new FileInputStream(file);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                OutputStream outputStreamOpenOutputStream = neboInspectorActivity.getContentResolver().openOutputStream(data);
                if (outputStreamOpenOutputStream != null) {
                    fileInputStream = outputStreamOpenOutputStream;
                    try {
                        Long.valueOf(ByteStreamsKt.copyTo$default(fileInputStream2, fileInputStream, 0, 2, null));
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                }
                CloseableKt.closeFinally(fileInputStream, null);
                file.delete();
            } finally {
            }
        }
        neboInspectorActivity.currentDatalogFilePath = null;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onExportDatalog$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onExportDatalog$1", m1609f = "NeboInspectorActivity.kt", m1610i = {0}, m1611l = {277}, m1612m = "invokeSuspend", m1613n = {"progressDialog"}, m1614nl = {278}, m1615s = {"L$0"}, m1616v = 2)
    static final class C66071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C66071(Continuation<? super C66071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboInspectorActivity.this.new C66071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProgressDialog progressDialog;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProgressDialog progressDialog2 = new ProgressDialog(NeboInspectorActivity.this);
                progressDialog2.setMessage(NeboInspectorActivity.this.getString(C6609R.string.inspector_sync_export_datalog));
                progressDialog2.setCancelable(false);
                progressDialog2.setCanceledOnTouchOutside(false);
                progressDialog2.show();
                this.L$0 = progressDialog2;
                this.label = 1;
                Object objExportDatalog = NeboInspectorActivity.this.getFilesViewModel().exportDatalog(this);
                if (objExportDatalog == coroutine_suspended) {
                    return coroutine_suspended;
                }
                progressDialog = progressDialog2;
                obj = objExportDatalog;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                progressDialog = (ProgressDialog) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            String str = (String) obj;
            progressDialog.dismiss();
            if (!StringsKt.isBlank(str)) {
                NeboInspectorActivity.this.currentDatalogFilePath = str;
                ActivityResultLauncher activityResultLauncher = NeboInspectorActivity.this.datalogLauncher;
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.setType("application/*");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.TITLE", new File(str).getName());
                activityResultLauncher.launch(intent);
            } else {
                new MaterialAlertDialogBuilder(NeboInspectorActivity.this).setMessage(C6609R.string.inspector_sync_export_datalog_error_message).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
            }
            return Unit.INSTANCE;
        }
    }

    private final void onExportDatalog() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new C66071(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dumpCloudLauncher$lambda$0(NeboInspectorActivity neboInspectorActivity, ActivityResult it) {
        Uri data;
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        Intent data2 = it.getData();
        if (data2 != null && (data = data2.getData()) != null && (str = neboInspectorActivity.currentDumpedCloudFilePath) != null) {
            File file = new File(str);
            OutputStream fileInputStream = new FileInputStream(file);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                OutputStream outputStreamOpenOutputStream = neboInspectorActivity.getContentResolver().openOutputStream(data);
                if (outputStreamOpenOutputStream != null) {
                    fileInputStream = outputStreamOpenOutputStream;
                    try {
                        Long.valueOf(ByteStreamsKt.copyTo$default(fileInputStream2, fileInputStream, 0, 2, null));
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                }
                CloseableKt.closeFinally(fileInputStream, null);
                file.delete();
            } finally {
            }
        }
        neboInspectorActivity.currentDumpedCloudFilePath = null;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onDumpV1$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onDumpV1$1", m1609f = "NeboInspectorActivity.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA3_2_1}, m1612m = "invokeSuspend", m1613n = {"progressDialog"}, m1614nl = {PDFACompliance.e_PDFA3_2_2}, m1615s = {"L$0"}, m1616v = 2)
    static final class C66051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C66051(Continuation<? super C66051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboInspectorActivity.this.new C66051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProgressDialog progressDialog;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProgressDialog progressDialog2 = new ProgressDialog(NeboInspectorActivity.this);
                progressDialog2.setMessage(NeboInspectorActivity.this.getString(C6609R.string.inspector_sync_dump_v1));
                progressDialog2.setCancelable(false);
                progressDialog2.setCanceledOnTouchOutside(false);
                progressDialog2.show();
                this.L$0 = progressDialog2;
                this.label = 1;
                Object objDumpCloudV1 = NeboInspectorActivity.this.getFilesViewModel().dumpCloudV1(this);
                if (objDumpCloudV1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                progressDialog = progressDialog2;
                obj = objDumpCloudV1;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                progressDialog = (ProgressDialog) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            String str = (String) obj;
            progressDialog.dismiss();
            if (!StringsKt.isBlank(str)) {
                NeboInspectorActivity.this.currentDumpedCloudFilePath = str;
                ActivityResultLauncher activityResultLauncher = NeboInspectorActivity.this.dumpCloudLauncher;
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.setType("application/*");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.TITLE", new File(str).getName());
                activityResultLauncher.launch(intent);
            } else {
                new MaterialAlertDialogBuilder(NeboInspectorActivity.this).setMessage(C6609R.string.inspector_sync_dump_v1_error_message).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
            }
            return Unit.INSTANCE;
        }
    }

    private final void onDumpV1() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new C66051(null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onExportCloudOperationsLog$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onExportCloudOperationsLog$1", m1609f = "NeboInspectorActivity.kt", m1610i = {0}, m1611l = {348}, m1612m = "invokeSuspend", m1613n = {"progressDialog"}, m1614nl = {349}, m1615s = {"L$0"}, m1616v = 2)
    static final class C66061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C66061(Continuation<? super C66061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboInspectorActivity.this.new C66061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProgressDialog progressDialog;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProgressDialog progressDialog2 = new ProgressDialog(NeboInspectorActivity.this);
                progressDialog2.setMessage(NeboInspectorActivity.this.getString(C6609R.string.inspector_sync_export_cloud_operations_log));
                progressDialog2.setCancelable(false);
                progressDialog2.setCanceledOnTouchOutside(false);
                progressDialog2.show();
                this.L$0 = progressDialog2;
                this.label = 1;
                Object objExportCloudOperationsLog = NeboInspectorActivity.this.getFilesViewModel().exportCloudOperationsLog(this);
                if (objExportCloudOperationsLog == coroutine_suspended) {
                    return coroutine_suspended;
                }
                progressDialog = progressDialog2;
                obj = objExportCloudOperationsLog;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                progressDialog = (ProgressDialog) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            progressDialog.dismiss();
            Object systemService = NeboInspectorActivity.this.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(NeboInspectorActivity.this.getString(C6609R.string.inspector_sync_export_cloud_operations_log_title), (String) obj));
            return Unit.INSTANCE;
        }
    }

    private final void onExportCloudOperationsLog() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new C66061(null));
    }

    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboInspectorActivity$Companion;", "", "<init>", "()V", "RESTORATION_COLLECTION_NAME", "", NeboInspectorActivity.RESTORED_CONTENT_COUNT_KEY, NeboInspectorActivity.EXTRA_SAVED_CURRENT_DUMPED_CLOUD_FILE_PATH, NeboInspectorActivity.EXTRA_SAVED_CURRENT_DATALOG_FILE_PATH, "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "hasRestoredContent", "", "data", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) NeboInspectorActivity.class);
        }

        public final boolean hasRestoredContent(Intent data) {
            return data != null && data.getIntExtra(NeboInspectorActivity.RESTORED_CONTENT_COUNT_KEY, 0) > 0;
        }
    }
}
