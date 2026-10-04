package com.myscript.nebo.grid;

import android.content.ContextWrapper;
import android.content.res.Configuration;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.grid.DownloadLanguageViewModel;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0015\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/grid/DownloadLanguageViewModel;", "Landroidx/lifecycle/ViewModel;", "languageTag", "", "resourceManager", "Lcom/myscript/atk/resourcemanager/ResourceManager;", "languageNameHelper", "Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/lang/String;Lcom/myscript/atk/resourcemanager/ResourceManager;Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;Ljava/util/Locale;)V", "languageDisplayName", "_downloadUIState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/grid/LanguageDownloadUIState;", "downloadUIState", "Landroidx/lifecycle/LiveData;", "getDownloadUIState", "()Landroidx/lifecycle/LiveData;", "downloadCallback", "com/myscript/nebo/grid/DownloadLanguageViewModel$downloadCallback$1", "Lcom/myscript/nebo/grid/DownloadLanguageViewModel$downloadCallback$1;", "onCleared", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DownloadLanguageViewModel extends ViewModel {
    private final MutableLiveData<LanguageDownloadUIState> _downloadUIState;
    private final DownloadLanguageViewModel$downloadCallback$1 downloadCallback;
    private final String languageDisplayName;
    private final LanguageNameHelper languageNameHelper;
    private final String languageTag;
    private final Locale locale;
    private final ResourceManager resourceManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r7v3, types: [com.myscript.nebo.grid.DownloadLanguageViewModel$downloadCallback$1] */
    public DownloadLanguageViewModel(String languageTag, ResourceManager resourceManager, LanguageNameHelper languageNameHelper, Locale locale) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(languageNameHelper, "languageNameHelper");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.languageTag = languageTag;
        this.resourceManager = resourceManager;
        this.languageNameHelper = languageNameHelper;
        this.locale = locale;
        this.languageDisplayName = languageNameHelper.getDisplayLanguage(languageTag, true, locale);
        this._downloadUIState = new MutableLiveData<>();
        ?? r7 = new GlobalDownloadsCallback() { // from class: com.myscript.nebo.grid.DownloadLanguageViewModel$downloadCallback$1
            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadCanceled(Language language) {
                Intrinsics.checkNotNullParameter(language, "language");
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadStart(Language language) {
                Intrinsics.checkNotNullParameter(language, "language");
                if (Intrinsics.areEqual(language.getLanguageKey(), this.this$0.languageTag)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new C6481xc6eb26e6(this.this$0, null), 3, null);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadProgress(Language language, int max, int progress) {
                Intrinsics.checkNotNullParameter(language, "language");
                if (Intrinsics.areEqual(language.getLanguageKey(), this.this$0.languageTag)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new C6480xc23459a3(this.this$0, progress, max, null), 3, null);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadSuccess(Language language) {
                Intrinsics.checkNotNullParameter(language, "language");
                if (Intrinsics.areEqual(language.getLanguageKey(), this.this$0.languageTag)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new C6482x70237c87(this.this$0, null), 3, null);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadError(Language language, Exception exception) {
                Intrinsics.checkNotNullParameter(language, "language");
                if (Intrinsics.areEqual(language.getLanguageKey(), this.this$0.languageTag)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new C6479xdfd8630c(this.this$0, null), 3, null);
                }
            }
        };
        this.downloadCallback = r7;
        resourceManager.addDownloadsCallback((GlobalDownloadsCallback) r7);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C64781(null), 2, null);
    }

    public final LiveData<LanguageDownloadUIState> getDownloadUIState() {
        return this._downloadUIState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.DownloadLanguageViewModel$1 */
    /* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.DownloadLanguageViewModel$1", m1609f = "DownloadLanguageDialogFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64781(Continuation<? super C64781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadLanguageViewModel.this.new C64781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DownloadLanguageViewModel.this.resourceManager.downloadLanguage(new Language(DownloadLanguageViewModel.this.languageTag, null, false, null, 14, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.resourceManager.removeDownloadsCallback(this.downloadCallback);
    }

    /* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/grid/DownloadLanguageViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "languageTag", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DownloadLanguageViewModel Factory$lambda$0$0(String str, CreationExtras initializer) {
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.atk.resourcemanager.ResourceManager.Provider");
            ResourceManager resourceManagerProvideResourceManager = ((ResourceManager.Provider) objRequireApplication).provideResourceManager();
            Intrinsics.checkNotNullExpressionValue(resourceManagerProvideResourceManager, "provideResourceManager(...)");
            Configuration configuration = ((ContextWrapper) objRequireApplication).getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            Locale primaryLocale = LocaleExt.getPrimaryLocale(configuration);
            return new DownloadLanguageViewModel(str, resourceManagerProvideResourceManager, new LanguageNameHelper(primaryLocale), primaryLocale);
        }

        public final ViewModelProvider.Factory Factory(final String languageTag) {
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(DownloadLanguageViewModel.class), new Function1() { // from class: com.myscript.nebo.grid.DownloadLanguageViewModel$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DownloadLanguageViewModel.Companion.Factory$lambda$0$0(languageTag, (CreationExtras) obj);
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }
    }
}
