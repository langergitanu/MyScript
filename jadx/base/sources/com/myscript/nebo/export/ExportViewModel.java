package com.myscript.nebo.export;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.DisplayMetrics;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.common.MimeTypes;
import com.myscript.android.utils.AssetManagerExt;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.NullableStringSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.TypesetListener;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.utils.NameUtils;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.editing.BlockRenderer;
import com.myscript.nebo.export.ExportViewModel;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.snt.core.ExportController;
import com.myscript.snt.core.ExportOptions;
import com.myscript.snt.core.IExportControllerDelegate;
import com.myscript.snt.core.OptionState;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ExportViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 \u007f2\u00020\u0001:\u0003}~\u007fBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010h\u001a\u00020i2\u000e\b\u0002\u0010j\u001a\b\u0012\u0004\u0012\u00020i0kH\u0002J\u000e\u0010l\u001a\u00020i2\u0006\u0010m\u001a\u00020@J\b\u0010n\u001a\u00020iH\u0002J\u000e\u0010o\u001a\u00020i2\u0006\u0010p\u001a\u00020\u0014J\u0010\u0010q\u001a\u00020i2\b\b\u0002\u0010r\u001a\u00020\u001cJ\u0016\u0010s\u001a\u00020i2\u0006\u0010t\u001a\u00020\b2\u0006\u0010u\u001a\u00020\u0014J\u0006\u0010v\u001a\u00020iJ\u000e\u0010w\u001a\u00020i2\u0006\u0010x\u001a\u00020\u001cJ\u000e\u0010y\u001a\u00020i2\u0006\u0010x\u001a\u00020\u001cJ\u000e\u0010z\u001a\u00020i2\u0006\u0010x\u001a\u00020\u001cJ\u000e\u0010{\u001a\u00020i2\u0006\u0010x\u001a\u00020\u001cJ\u000e\u0010|\u001a\u00020i2\u0006\u0010x\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010$\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R+\u0010(\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R+\u0010,\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010#\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R+\u00100\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010#\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u000e\u00104\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u001fR\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00078F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0017\"\u0004\bH\u0010\u0019R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020K0M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0M8F¢\u0006\u0006\u001a\u0004\bS\u0010OR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020Q0M8F¢\u0006\u0006\u001a\u0004\bV\u0010OR\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020Q0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Q0M8F¢\u0006\u0006\u001a\u0004\bY\u0010OR\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020Q0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020Q0M8F¢\u0006\u0006\u001a\u0004\b\\\u0010OR\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020Q0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020Q0M8F¢\u0006\u0006\u001a\u0004\b_\u0010OR\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020a0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020a0M8F¢\u0006\u0006\u001a\u0004\bc\u0010OR$\u0010d\u001a\u0018\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020\u001c0ej\u0002`gX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel;", "Landroidx/lifecycle/AndroidViewModel;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "pageKeys", "", "Lcom/myscript/snt/core/PageKey;", "pageIndexes", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Ljava/util/List;Ljava/util/List;Landroid/util/DisplayMetrics;Lcom/myscript/nebo/log/TechnicalLogger;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "<set-?>", "", "exportTypePreference", "getExportTypePreference", "()Ljava/lang/String;", "setExportTypePreference", "(Ljava/lang/String;)V", "exportTypePreference$delegate", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "", "combineAsOneDocumentPreference", "getCombineAsOneDocumentPreference", "()Z", "setCombineAsOneDocumentPreference", "(Z)V", "combineAsOneDocumentPreference$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "flattenPreference", "getFlattenPreference", "setFlattenPreference", "flattenPreference$delegate", "includeAnnotationsPreference", "getIncludeAnnotationsPreference", "setIncludeAnnotationsPreference", "includeAnnotationsPreference$delegate", "includeBackgroundColorPreference", "getIncludeBackgroundColorPreference", "setIncludeBackgroundColorPreference", "includeBackgroundColorPreference$delegate", "includeBackgroundPatternPreference", "getIncludeBackgroundPatternPreference", "setIncludeBackgroundPatternPreference", "includeBackgroundPatternPreference$delegate", "pageCount", "hideFilename", "getHideFilename", "fileName", "", "getFileName", "()Ljava/lang/CharSequence;", "blockRenderer", "Lcom/myscript/nebo/editing/BlockRenderer;", "exportController", "Lcom/myscript/snt/core/ExportController;", "availableMimeTypes", "Lcom/myscript/atk/core/MimeType;", "getAvailableMimeTypes", "()Ljava/util/List;", "currentMimeType", "getCurrentMimeType", "()Lcom/myscript/atk/core/MimeType;", "exportTitle", "getExportTitle", "setExportTitle", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/export/ExportViewModel$State;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "_includeAnnotationsOption", "Lcom/myscript/snt/core/OptionState;", "includeAnnotationsOption", "getIncludeAnnotationsOption", "_includeBackgroundColorOption", "includeBackgroundColorOption", "getIncludeBackgroundColorOption", "_includeBackgroundPatternOption", "includeBackgroundPatternOption", "getIncludeBackgroundPatternOption", "_flattenOption", "flattenOption", "getFlattenOption", "_combineAsOneDocumentOption", "combineAsOneDocumentOption", "getCombineAsOneDocumentOption", "_fileNameOption", "Lcom/myscript/nebo/export/ExportViewModel$FileNameOption;", "fileNameOption", "getFileNameOption", "onExportProgress", "Lkotlin/Function2;", "", "Lcom/myscript/nebo/export/ExportProgressDelegate;", "updateExportOptions", "", "updateLogic", "Lkotlin/Function0;", "setExportMimeType", "selectedMimeType", "applyPreferences", "setName", "name", ExportViewModel.EXPORT_DIR_NAME, "showWatermark", "exportToPowerPoint", "pageKey", "boxId", "cancelExport", "combineAsOneDocument", "value", "flatten", "includeAnnotations", "includeBackgroundColor", "includeBackgroundPattern", "State", "FileNameOption", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExportViewModel extends AndroidViewModel {
    private static final String EXPORT_DIR_NAME = "export";
    private static final String EXPORT_PREFERENCE_COMBINE_AS_ONE_DOCUMENT = "EXPORT_PREFERENCE_COMBINE_AS_ONE_DOCUMENT";
    private static final String EXPORT_PREFERENCE_CONTENT_TYPE = "EXPORT_PREFERENCE_CONTENT_TYPE";
    private static final String EXPORT_PREFERENCE_FLATTEN = "EXPORT_PREFERENCE_FLATTEN";
    private static final String EXPORT_PREFERENCE_INCLUDE_ANNOTATIONS = "EXPORT_PREFERENCE_INCLUDE_ANNOTATIONS";
    private static final String EXPORT_PREFERENCE_INCLUDE_BACKGROUND_COLOR = "EXPORT_PREFERENCE_INCLUDE_BACKGROUND_COLOR";
    private static final String EXPORT_PREFERENCE_INCLUDE_BACKGROUND_PATTERN = "EXPORT_PREFERENCE_INCLUDE_BACKGROUND_PATTERN";
    private static final String EXPORT_SHARED_PREF_NAME = "com.myscript.nebo.export.preferences";
    public static final String TAG = "ExportViewModel";
    private final MutableLiveData<OptionState> _combineAsOneDocumentOption;
    private final MutableLiveData<FileNameOption> _fileNameOption;
    private final MutableLiveData<OptionState> _flattenOption;
    private final MutableLiveData<OptionState> _includeAnnotationsOption;
    private final MutableLiveData<OptionState> _includeBackgroundColorOption;
    private final MutableLiveData<OptionState> _includeBackgroundPatternOption;
    private final MutableLiveData<State> _state;
    private final BlockRenderer blockRenderer;

    /* JADX INFO: renamed from: combineAsOneDocumentPreference$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty combineAsOneDocumentPreference;
    private final DisplayMetrics displayMetrics;
    private ExportController exportController;
    public String exportTitle;

    /* JADX INFO: renamed from: exportTypePreference$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty exportTypePreference;

    /* JADX INFO: renamed from: flattenPreference$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty flattenPreference;

    /* JADX INFO: renamed from: includeAnnotationsPreference$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty includeAnnotationsPreference;

    /* JADX INFO: renamed from: includeBackgroundColorPreference$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty includeBackgroundColorPreference;

    /* JADX INFO: renamed from: includeBackgroundPatternPreference$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty includeBackgroundPatternPreference;
    private final LibraryRepository libraryRepository;
    private final TechnicalLogger logger;
    private final Function2<Float, Float, Boolean> onExportProgress;
    private int pageCount;
    private final SharedPreferences sharedPreferences;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(ExportViewModel.class, "exportTypePreference", "getExportTypePreference()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(ExportViewModel.class, "combineAsOneDocumentPreference", "getCombineAsOneDocumentPreference()Z", 0), new MutablePropertyReference1Impl(ExportViewModel.class, "flattenPreference", "getFlattenPreference()Z", 0), new MutablePropertyReference1Impl(ExportViewModel.class, "includeAnnotationsPreference", "getIncludeAnnotationsPreference()Z", 0), new MutablePropertyReference1Impl(ExportViewModel.class, "includeBackgroundColorPreference", "getIncludeBackgroundColorPreference()Z", 0), new MutablePropertyReference1Impl(ExportViewModel.class, "includeBackgroundPatternPreference", "getIncludeBackgroundPatternPreference()Z", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setName$lambda$0(String str) {
        return str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExportViewModel(final Application application, LibraryRepository libraryRepository, List<? extends PageKey> pageKeys, List<Integer> list, DisplayMetrics displayMetrics, TechnicalLogger logger) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.libraryRepository = libraryRepository;
        this.displayMetrics = displayMetrics;
        this.logger = logger;
        SharedPreferences sharedPreferences = application.getSharedPreferences(EXPORT_SHARED_PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        this.exportTypePreference = SharedPreferencesExtKt.nullableStringPref(sharedPreferences, EXPORT_PREFERENCE_CONTENT_TYPE, null);
        this.combineAsOneDocumentPreference = SharedPreferencesExtKt.booleanPref(sharedPreferences, EXPORT_PREFERENCE_COMBINE_AS_ONE_DOCUMENT, false);
        this.flattenPreference = SharedPreferencesExtKt.booleanPref(sharedPreferences, EXPORT_PREFERENCE_FLATTEN, true);
        this.includeAnnotationsPreference = SharedPreferencesExtKt.booleanPref(sharedPreferences, EXPORT_PREFERENCE_INCLUDE_ANNOTATIONS, true);
        this.includeBackgroundColorPreference = SharedPreferencesExtKt.booleanPref(sharedPreferences, EXPORT_PREFERENCE_INCLUDE_BACKGROUND_COLOR, false);
        this.includeBackgroundPatternPreference = SharedPreferencesExtKt.booleanPref(sharedPreferences, EXPORT_PREFERENCE_INCLUDE_BACKGROUND_PATTERN, false);
        BlockRenderer blockRenderer = new BlockRenderer(displayMetrics, application.getCacheDir());
        this.blockRenderer = blockRenderer;
        this._state = new MutableLiveData<>();
        this._includeAnnotationsOption = new MutableLiveData<>();
        this._includeBackgroundColorOption = new MutableLiveData<>();
        this._includeBackgroundPatternOption = new MutableLiveData<>();
        this._flattenOption = new MutableLiveData<>();
        this._combineAsOneDocumentOption = new MutableLiveData<>();
        this._fileNameOption = new MutableLiveData<>();
        this.onExportProgress = new Function2() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(ExportViewModel.onExportProgress$lambda$0(this.f$0, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        };
        ExportController exportControllerCreateExportController = libraryRepository.createExportController(pageKeys, blockRenderer, new TypesetListener(displayMetrics), new ViewTransform(displayMetrics.xdpi, displayMetrics.ydpi), CollectionsKt.emptyList());
        this.exportController = exportControllerCreateExportController;
        if (list != null) {
            exportControllerCreateExportController.setPdfPageIndexesFilter(list);
        }
        this.exportController.setExportDelegate(new IExportControllerDelegate() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda9
            @Override // com.myscript.snt.core.IExportControllerDelegate
            public final String getFilename(String str) {
                return ExportViewModel._init_$lambda$1(application, str);
            }
        });
        int iPagesToExportCount = (int) this.exportController.pagesToExportCount();
        this.pageCount = iPagesToExportCount;
        if (iPagesToExportCount > 1) {
            String string = application.getString(C6079R.string.export_dialog_title_several_notes, new Object[]{Integer.valueOf(this.pageCount)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            setExportTitle(string);
        } else if (iPagesToExportCount == 1) {
            String pageTitle = libraryRepository.getPageTitle((PageKey) CollectionsKt.firstOrNull((List) pageKeys));
            String str = pageTitle;
            String string2 = application.getString(C6079R.string.export_dialog_title, new Object[]{(str == null || StringsKt.isBlank(str)) ? application.getString(C6079R.string.untitled_page) : pageTitle});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            setExportTitle(string2);
        }
        String exportTypePreference = getExportTypePreference();
        MimeType mimeType = exportTypePreference != null ? ExportHelperKt.toMimeType(exportTypePreference) : null;
        if (mimeType != null && getAvailableMimeTypes().contains(mimeType)) {
            this.exportController.setExportMimeType(mimeType);
        }
        applyPreferences();
        updateExportOptions$default(this, null, 1, null);
    }

    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B=\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0004\u0017\u0018\u0019\u001a¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$State;", "", "outputFileName", "", "intent", "Landroid/content/Intent;", "message", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Exception;)V", "getOutputFileName", "()Ljava/lang/String;", "getIntent", "()Landroid/content/Intent;", "getMessage", "getException", "()Ljava/lang/Exception;", "Started", "Progress", "Error", "Done", "Lcom/myscript/nebo/export/ExportViewModel$State$Done;", "Lcom/myscript/nebo/export/ExportViewModel$State$Error;", "Lcom/myscript/nebo/export/ExportViewModel$State$Progress;", "Lcom/myscript/nebo/export/ExportViewModel$State$Started;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class State {
        public static final int $stable = 8;
        private final Exception exception;
        private final Intent intent;
        private final String message;
        private final String outputFileName;

        public /* synthetic */ State(String str, Intent intent, String str2, Exception exc, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, intent, str2, exc);
        }

        /* JADX INFO: compiled from: ExportViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$State$Started;", "Lcom/myscript/nebo/export/ExportViewModel$State;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Started extends State {
            public static final Started INSTANCE = new Started();
            public static final int $stable = 8;

            private Started() {
                super(null, null, null, null, 15, null);
            }
        }

        private State(String str, Intent intent, String str2, Exception exc) {
            this.outputFileName = str;
            this.intent = intent;
            this.message = str2;
            this.exception = exc;
        }

        public /* synthetic */ State(String str, Intent intent, String str2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : intent, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : exc, null);
        }

        public final Exception getException() {
            return this.exception;
        }

        public Intent getIntent() {
            return this.intent;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getOutputFileName() {
            return this.outputFileName;
        }

        /* JADX INFO: compiled from: ExportViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$State$Progress;", "Lcom/myscript/nebo/export/ExportViewModel$State;", "fileName", "", "<init>", "(Ljava/lang/String;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Progress extends State {
            public static final int $stable = 8;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String fileName) {
                super(fileName, null, null, null, 14, null);
                Intrinsics.checkNotNullParameter(fileName, "fileName");
            }
        }

        /* JADX INFO: compiled from: ExportViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$State$Error;", "Lcom/myscript/nebo/export/ExportViewModel$State;", "message", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;Ljava/lang/Exception;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Error extends State {
            public static final int $stable = 8;

            /* JADX WARN: Multi-variable type inference failed */
            public Error() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message, Exception exc) {
                super(null, null, message, exc, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }

            public /* synthetic */ Error(String str, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : exc);
            }
        }

        /* JADX INFO: compiled from: ExportViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$State$Done;", "Lcom/myscript/nebo/export/ExportViewModel$State;", "intent", "Landroid/content/Intent;", "<init>", "(Landroid/content/Intent;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Done extends State {
            public static final int $stable = 8;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Done(Intent intent) {
                super(null, intent, null, null, 12, null);
                Intrinsics.checkNotNullParameter(intent, "intent");
            }
        }
    }

    private final String getExportTypePreference() {
        return this.exportTypePreference.getValue((Object) this, $$delegatedProperties[0]);
    }

    private final void setExportTypePreference(String str) {
        this.exportTypePreference.setValue2((Object) this, $$delegatedProperties[0], str);
    }

    private final boolean getCombineAsOneDocumentPreference() {
        return this.combineAsOneDocumentPreference.getValue((Object) this, $$delegatedProperties[1]).booleanValue();
    }

    private final void setCombineAsOneDocumentPreference(boolean z) {
        this.combineAsOneDocumentPreference.setValue(this, $$delegatedProperties[1], z);
    }

    private final boolean getFlattenPreference() {
        return this.flattenPreference.getValue((Object) this, $$delegatedProperties[2]).booleanValue();
    }

    private final void setFlattenPreference(boolean z) {
        this.flattenPreference.setValue(this, $$delegatedProperties[2], z);
    }

    private final boolean getIncludeAnnotationsPreference() {
        return this.includeAnnotationsPreference.getValue((Object) this, $$delegatedProperties[3]).booleanValue();
    }

    private final void setIncludeAnnotationsPreference(boolean z) {
        this.includeAnnotationsPreference.setValue(this, $$delegatedProperties[3], z);
    }

    private final boolean getIncludeBackgroundColorPreference() {
        return this.includeBackgroundColorPreference.getValue((Object) this, $$delegatedProperties[4]).booleanValue();
    }

    private final void setIncludeBackgroundColorPreference(boolean z) {
        this.includeBackgroundColorPreference.setValue(this, $$delegatedProperties[4], z);
    }

    private final boolean getIncludeBackgroundPatternPreference() {
        return this.includeBackgroundPatternPreference.getValue((Object) this, $$delegatedProperties[5]).booleanValue();
    }

    private final void setIncludeBackgroundPatternPreference(boolean z) {
        this.includeBackgroundPatternPreference.setValue(this, $$delegatedProperties[5], z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHideFilename() {
        ExportOptions exportOptions = this.exportController.exportOptions();
        return (this.pageCount == 1 && exportOptions.getCombineAsOneDocument() == OptionState.On) || exportOptions.getCurrentMimeType() == MimeType.TEXT;
    }

    public final CharSequence getFileName() {
        String strFilename = this.exportController.filename();
        Intrinsics.checkNotNullExpressionValue(strFilename, "filename(...)");
        return strFilename;
    }

    public final List<MimeType> getAvailableMimeTypes() {
        ArrayList arrayList = new ArrayList();
        SWIGVectorMimeType availableMimeTypes = this.exportController.exportOptions().getAvailableMimeTypes();
        Intrinsics.checkNotNullExpressionValue(availableMimeTypes, "getAvailableMimeTypes(...)");
        for (MimeType mimeType : availableMimeTypes) {
            Intrinsics.checkNotNull(mimeType);
            arrayList.add(mimeType);
        }
        return arrayList;
    }

    public final MimeType getCurrentMimeType() {
        MimeType currentMimeType = this.exportController.exportOptions().getCurrentMimeType();
        Intrinsics.checkNotNullExpressionValue(currentMimeType, "getCurrentMimeType(...)");
        return currentMimeType;
    }

    public final String getExportTitle() {
        String str = this.exportTitle;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exportTitle");
        return null;
    }

    public final void setExportTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.exportTitle = str;
    }

    public final LiveData<State> getState() {
        return this._state;
    }

    public final LiveData<OptionState> getIncludeAnnotationsOption() {
        return this._includeAnnotationsOption;
    }

    public final LiveData<OptionState> getIncludeBackgroundColorOption() {
        return this._includeBackgroundColorOption;
    }

    public final LiveData<OptionState> getIncludeBackgroundPatternOption() {
        return this._includeBackgroundPatternOption;
    }

    public final LiveData<OptionState> getFlattenOption() {
        return this._flattenOption;
    }

    public final LiveData<OptionState> getCombineAsOneDocumentOption() {
        return this._combineAsOneDocumentOption;
    }

    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$FileNameOption;", "", "optionState", "Lcom/myscript/snt/core/OptionState;", "name", "", "<init>", "(Lcom/myscript/snt/core/OptionState;Ljava/lang/String;)V", "getOptionState", "()Lcom/myscript/snt/core/OptionState;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class FileNameOption {
        public static final int $stable = 0;
        private final String name;
        private final OptionState optionState;

        public static /* synthetic */ FileNameOption copy$default(FileNameOption fileNameOption, OptionState optionState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                optionState = fileNameOption.optionState;
            }
            if ((i & 2) != 0) {
                str = fileNameOption.name;
            }
            return fileNameOption.copy(optionState, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final OptionState getOptionState() {
            return this.optionState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final FileNameOption copy(OptionState optionState, String name) {
            Intrinsics.checkNotNullParameter(optionState, "optionState");
            Intrinsics.checkNotNullParameter(name, "name");
            return new FileNameOption(optionState, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileNameOption)) {
                return false;
            }
            FileNameOption fileNameOption = (FileNameOption) other;
            return this.optionState == fileNameOption.optionState && Intrinsics.areEqual(this.name, fileNameOption.name);
        }

        public int hashCode() {
            return (this.optionState.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "FileNameOption(optionState=" + this.optionState + ", name=" + this.name + ")";
        }

        public FileNameOption(OptionState optionState, String name) {
            Intrinsics.checkNotNullParameter(optionState, "optionState");
            Intrinsics.checkNotNullParameter(name, "name");
            this.optionState = optionState;
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }

        public final OptionState getOptionState() {
            return this.optionState;
        }
    }

    public final LiveData<FileNameOption> getFileNameOption() {
        return this._fileNameOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onExportProgress$lambda$0(ExportViewModel exportViewModel, float f, float f2) {
        return CoroutineScopeKt.isActive(ViewModelKt.getViewModelScope(exportViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1(Application application, String str) {
        Intrinsics.checkNotNull(str);
        return !StringsKt.isBlank(str) ? NameUtils.cleanName$default(str, 60, null, 4, null) : application.getString(C6079R.string.untitled_page);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.export.ExportViewModel$updateExportOptions$2 */
    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.export.ExportViewModel$updateExportOptions$2", m1609f = "ExportViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $updateLogic;
        int label;
        final /* synthetic */ ExportViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64612(Function0<Unit> function0, ExportViewModel exportViewModel, Continuation<? super C64612> continuation) {
            super(2, continuation);
            this.$updateLogic = function0;
            this.this$0 = exportViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C64612(this.$updateLogic, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64612) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$updateLogic.invoke();
            final ExportOptions exportOptions = this.this$0.exportController.exportOptions();
            ExportViewModel exportViewModel = this.this$0;
            exportViewModel._includeAnnotationsOption.setValue(exportOptions.getIncludeAnnotations());
            exportViewModel._includeBackgroundColorOption.setValue(exportOptions.getIncludeBackgroundColor());
            exportViewModel._includeBackgroundPatternOption.setValue(exportOptions.getIncludeBackgroundPattern());
            exportViewModel._flattenOption.setValue(exportOptions.getFlatten());
            exportViewModel._combineAsOneDocumentOption.setValue(exportOptions.getCombineAsOneDocument());
            OptionState nameOption = exportViewModel.getHideFilename() ? OptionState.NotAvailable : exportOptions.getNameOption();
            MutableLiveData mutableLiveData = exportViewModel._fileNameOption;
            Intrinsics.checkNotNull(nameOption);
            String name = exportOptions.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            mutableLiveData.setValue(new FileNameOption(nameOption, name));
            TechnicalLoggerExt.logAction(exportViewModel.logger, ExportViewModel.TAG, "updateExportOptions", new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$updateExportOptions$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ExportViewModel.C64612.invokeSuspend$lambda$0$0(exportOptions);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$0(ExportOptions exportOptions) {
            return "update export options combine=" + exportOptions.getCombineAsOneDocument().name() + " flatten=" + exportOptions.getFlatten().name() + " annotations=" + exportOptions.getIncludeAnnotations().name();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateExportOptions$default(ExportViewModel exportViewModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        exportViewModel.updateExportOptions(function0);
    }

    private final void updateExportOptions(Function0<Unit> updateLogic) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C64612(updateLogic, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setExportMimeType$lambda$0(MimeType mimeType) {
        return "mimeType=" + mimeType.name();
    }

    public final void setExportMimeType(final MimeType selectedMimeType) {
        Intrinsics.checkNotNullParameter(selectedMimeType, "selectedMimeType");
        TechnicalLoggerExt.logAction(this.logger, TAG, "setExportMimeType", new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.setExportMimeType$lambda$0(selectedMimeType);
            }
        });
        this.exportController.setExportMimeType(selectedMimeType);
        setExportTypePreference(ExportHelperKt.getContentType(selectedMimeType));
        applyPreferences();
        updateExportOptions$default(this, null, 1, null);
    }

    private final void applyPreferences() {
        if (this.exportController.exportOptions().getFlatten() != OptionState.NotAvailable) {
            flatten(getFlattenPreference());
        }
        if (this.exportController.exportOptions().getIncludeAnnotations() != OptionState.NotAvailable) {
            includeAnnotations(getIncludeAnnotationsPreference());
        }
        if (this.exportController.exportOptions().getIncludeBackgroundColor() != OptionState.NotAvailable) {
            includeBackgroundColor(getIncludeBackgroundColorPreference());
        }
        if (this.exportController.exportOptions().getIncludeBackgroundPattern() != OptionState.NotAvailable) {
            includeBackgroundPattern(getIncludeBackgroundPatternPreference());
        }
        if (this.exportController.exportOptions().getCombineAsOneDocument() != OptionState.NotAvailable) {
            combineAsOneDocument(getCombineAsOneDocumentPreference());
        }
    }

    public final void setName(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TechnicalLoggerExt.logAction(this.logger, TAG, "setName", new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.setName$lambda$0(name);
            }
        });
        this.exportController.setName(name);
    }

    public static /* synthetic */ void export$default(ExportViewModel exportViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        exportViewModel.export(z);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.export.ExportViewModel$export$1 */
    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.export.ExportViewModel$export$1", m1609f = "ExportViewModel.kt", m1610i = {}, m1611l = {275}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_9_1}, m1615s = {}, m1616v = 2)
    static final class C64581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Application $application;
        final /* synthetic */ boolean $showWatermark;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64581(boolean z, Application application, Continuation<? super C64581> continuation) {
            super(2, continuation);
            this.$showWatermark = z;
            this.$application = application;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExportViewModel.this.new C64581(this.$showWatermark, this.$application, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Object error;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String str = null;
            boolean z = false;
            boolean z2 = false;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ExportViewModel.this._state.setValue(State.Started.INSTANCE);
                if (ExportViewModel.this.getCurrentMimeType() == MimeType.PDF && this.$showWatermark) {
                    File file = new File(this.$application.getCacheDir(), "watermark.png");
                    if (!file.exists()) {
                        AssetManager assets = this.$application.getAssets();
                        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                        AssetManagerExt.copyAsset(assets, "images/PDF-Watermark.png", file);
                    }
                    ExportViewModel.this.exportController.setWatermarkData(file.getAbsolutePath(), this.$application.getString(C6079R.string.ms_notes_watermark_url));
                }
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new ExportViewModel$export$1$resultFiles$1(this.$application, ExportViewModel.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MutableLiveData mutableLiveData = ExportViewModel.this._state;
            List list = (List) obj;
            if (!list.isEmpty()) {
                error = new State.Done(ExportHelper.getExportIntent(this.$application, ExportViewModel.this.getCurrentMimeType(), list));
            } else {
                error = new State.Error(str, z2 ? 1 : 0, 3, z ? 1 : 0);
            }
            mutableLiveData.setValue(error);
            return Unit.INSTANCE;
        }
    }

    public final void export(boolean showWatermark) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C64581(showWatermark, getApplication(), null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.export.ExportViewModel$exportToPowerPoint$1 */
    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.export.ExportViewModel$exportToPowerPoint$1", m1609f = "ExportViewModel.kt", m1610i = {1, 1}, m1611l = {305, 314}, m1612m = "invokeSuspend", m1613n = {"fileName", MimeTypes.BASE_TYPE_APPLICATION}, m1614nl = {311, PDFACompliance.e_PDFA3_3_2}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C64591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $boxId;
        final /* synthetic */ PageKey $pageKey;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64591(String str, PageKey pageKey, Continuation<? super C64591> continuation) {
            super(2, continuation);
            this.$boxId = str;
            this.$pageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExportViewModel.this.new C64591(this.$boxId, this.$pageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0091, code lost:
        
            if (r11 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ExportViewModel.this._state.setValue(State.Started.INSTANCE);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new ExportViewModel$exportToPowerPoint$1$fileName$1(this.$boxId, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ExportViewModel.this._state.setValue((State) obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            String str = (String) obj;
            ExportViewModel.this._state.setValue(new State.Progress(str));
            Application application = ExportViewModel.this.getApplication();
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.L$1 = SpillingKt.nullOutSpilledVariable(application);
            this.label = 2;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ExportViewModel$exportToPowerPoint$1$state$1(application, str, this.$pageKey, ExportViewModel.this, this.$boxId, null), this);
        }
    }

    public final void exportToPowerPoint(PageKey pageKey, String boxId) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(boxId, "boxId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C64591(boxId, pageKey, null), 2, null);
    }

    public final void cancelExport() {
        TechnicalLoggerExt.logAction$default(this.logger, TAG, "cancel", null, 4, null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
    }

    public final void combineAsOneDocument(final boolean value) {
        updateExportOptions(new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.combineAsOneDocument$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit combineAsOneDocument$lambda$0(ExportViewModel exportViewModel, boolean z) {
        exportViewModel.exportController.combineAsOneDocument(z);
        exportViewModel.setCombineAsOneDocumentPreference(z);
        return Unit.INSTANCE;
    }

    public final void flatten(final boolean value) {
        updateExportOptions(new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.flatten$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit flatten$lambda$0(ExportViewModel exportViewModel, boolean z) {
        exportViewModel.exportController.flatten(z);
        exportViewModel.setFlattenPreference(z);
        return Unit.INSTANCE;
    }

    public final void includeAnnotations(final boolean value) {
        updateExportOptions(new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.includeAnnotations$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit includeAnnotations$lambda$0(ExportViewModel exportViewModel, boolean z) {
        exportViewModel.exportController.includeAnnotations(z);
        exportViewModel.setIncludeAnnotationsPreference(z);
        return Unit.INSTANCE;
    }

    public final void includeBackgroundColor(final boolean value) {
        updateExportOptions(new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.includeBackgroundColor$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit includeBackgroundColor$lambda$0(ExportViewModel exportViewModel, boolean z) {
        exportViewModel.exportController.includeBackgroundColor(z);
        exportViewModel.setIncludeBackgroundColorPreference(z);
        return Unit.INSTANCE;
    }

    public final void includeBackgroundPattern(final boolean value) {
        updateExportOptions(new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel.includeBackgroundPattern$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit includeBackgroundPattern$lambda$0(ExportViewModel exportViewModel, boolean z) {
        exportViewModel.exportController.includeBackgroundPattern(z);
        exportViewModel.setIncludeBackgroundPatternPreference(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportViewModel$Companion;", "", "<init>", "()V", "TAG", "", "EXPORT_DIR_NAME", "EXPORT_SHARED_PREF_NAME", ExportViewModel.EXPORT_PREFERENCE_CONTENT_TYPE, ExportViewModel.EXPORT_PREFERENCE_COMBINE_AS_ONE_DOCUMENT, ExportViewModel.EXPORT_PREFERENCE_FLATTEN, ExportViewModel.EXPORT_PREFERENCE_INCLUDE_ANNOTATIONS, ExportViewModel.EXPORT_PREFERENCE_INCLUDE_BACKGROUND_COLOR, ExportViewModel.EXPORT_PREFERENCE_INCLUDE_BACKGROUND_PATTERN, "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "pageKeys", "", "Lcom/myscript/snt/core/PageKey;", "pageIndexes", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final ExportViewModel Factory$lambda$0$0(List list, List list2, DisplayMetrics displayMetrics, CreationExtras initializer) {
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
            return new ExportViewModel(applicationRequireApplication, ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository(), list, list2, displayMetrics, ((TechnicalLoggerProvider) applicationRequireApplication).provideTechnicalLogger());
        }

        public final ViewModelProvider.Factory Factory(final List<? extends PageKey> pageKeys, final List<Integer> pageIndexes, final DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(ExportViewModel.class), new Function1() { // from class: com.myscript.nebo.export.ExportViewModel$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExportViewModel.Companion.Factory$lambda$0$0(pageKeys, pageIndexes, displayMetrics, (CreationExtras) obj);
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }
    }
}
