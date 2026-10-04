package com.myscript.nebo.onboarding;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.languagemanager.data.ILanguagesInstaller;
import com.myscript.nebo.languagemanager.domain.LanguageRepository;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.myscript.nebo.languagemanager.util.LanguageExtKt;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001#\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001aJ\u0010\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001aJ\b\u00100\u001a\u00020&H\u0002J\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R$\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u0002030\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, m1599d2 = {"Lcom/myscript/nebo/onboarding/LanguageSelectionViewModel;", "Landroidx/lifecycle/ViewModel;", "installer", "Lcom/myscript/nebo/languagemanager/data/ILanguagesInstaller;", "languageRepository", "Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;", "languageNameHelper", "Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/myscript/nebo/languagemanager/data/ILanguagesInstaller;Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/onboarding/LanguageSelectUIState;", "kotlin.jvm.PlatformType", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "rawData", "", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", SearchIntents.EXTRA_QUERY, "", "isConnected", "", "selectedLanguageKey", "getSelectedLanguageKey", "()Ljava/lang/String;", "isSearchActive", "()Z", "onLanguageUpdate", "com/myscript/nebo/onboarding/LanguageSelectionViewModel$onLanguageUpdate$1", "Lcom/myscript/nebo/onboarding/LanguageSelectionViewModel$onLanguageUpdate$1;", "onCleared", "", "loadLanguages", "loadInstalledLanguages", "selectLanguage", "languageKey", FirebaseAnalytics.Event.SEARCH, "label", "download", "cancelDownload", "removeLanguage", "refreshUIState", "filteredLanguages", "asLanguageManagerItemList", "Lcom/myscript/atk/resourcemanager/Language;", "getAsLanguageManagerItemList", "(Ljava/util/List;)Ljava/util/List;", "onboarding_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageSelectionViewModel extends ViewModel {
    private final MutableLiveData<LanguageSelectUIState> _state;
    private final ILanguagesInstaller installer;
    private boolean isConnected;
    private final LanguageNameHelper languageNameHelper;
    private final LanguageRepository languageRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final NeboNetworkStateRepository networkStateRepository;
    private final LanguageSelectionViewModel$onLanguageUpdate$1 onLanguageUpdate;
    private String query;
    private List<LanguageManagerItem.Lang> rawData;

    /* JADX WARN: Type inference failed for: r9v3, types: [com.myscript.nebo.onboarding.LanguageSelectionViewModel$onLanguageUpdate$1] */
    public LanguageSelectionViewModel(ILanguagesInstaller installer, LanguageRepository languageRepository, LanguageNameHelper languageNameHelper, NeboNetworkStateRepository networkStateRepository, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(installer, "installer");
        Intrinsics.checkNotNullParameter(languageRepository, "languageRepository");
        Intrinsics.checkNotNullParameter(languageNameHelper, "languageNameHelper");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.installer = installer;
        this.languageRepository = languageRepository;
        this.languageNameHelper = languageNameHelper;
        this.networkStateRepository = networkStateRepository;
        this.mainDispatcher = mainDispatcher;
        this._state = new MutableLiveData<>(new LanguageSelectUIState(null, false, false, false, false, 31, null));
        this.rawData = CollectionsKt.emptyList();
        ?? r9 = new GlobalDownloadsCallback() { // from class: com.myscript.nebo.onboarding.LanguageSelectionViewModel$onLanguageUpdate$1
            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadStart(Language language) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                Iterator it = this.this$0.rawData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
                            break;
                        }
                    }
                }
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                if (lang != null) {
                    lang.setPending(true);
                    this.this$0.refreshUIState();
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadProgress(Language language, int max, int progress) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                Iterator it = this.this$0.rawData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
                            break;
                        }
                    }
                }
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                if (lang != null) {
                    lang.setPending(false);
                    lang.setProgress(progress);
                    lang.setMax(max);
                    this.this$0.refreshUIState();
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadSuccess(Language language) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                Iterator it = this.this$0.rawData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
                            break;
                        }
                    }
                }
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                if (lang != null) {
                    lang.setProgress(0);
                    lang.setMax(0);
                    lang.setInstalled(true);
                    lang.setPending(false);
                    this.this$0.refreshUIState();
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadCanceled(Language language) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                Iterator it = this.this$0.rawData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
                            break;
                        }
                    }
                }
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                if (lang != null) {
                    lang.setProgress(0);
                    lang.setMax(0);
                    lang.setInstalled(false);
                    lang.setPending(false);
                    this.this$0.refreshUIState();
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadError(Language language, Exception exception) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                Iterator it = this.this$0.rawData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
                            break;
                        }
                    }
                }
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                if (lang != null) {
                    lang.setProgress(0);
                    lang.setMax(0);
                    lang.setInstalled(false);
                    lang.setPending(false);
                    this.this$0.refreshUIState();
                }
            }
        };
        this.onLanguageUpdate = r9;
        loadInstalledLanguages();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66571(null), 3, null);
        languageRepository.addGlobalDownloadCallback((GlobalDownloadsCallback) r9);
        loadLanguages();
    }

    public /* synthetic */ LanguageSelectionViewModel(ILanguagesInstaller iLanguagesInstaller, LanguageRepository languageRepository, LanguageNameHelper languageNameHelper, NeboNetworkStateRepository neboNetworkStateRepository, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iLanguagesInstaller, languageRepository, languageNameHelper, neboNetworkStateRepository, (i & 16) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    public final LiveData<LanguageSelectUIState> getState() {
        return this._state;
    }

    public final String getSelectedLanguageKey() {
        Object next;
        Iterator<T> it = this.rawData.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((LanguageManagerItem.Lang) next).isSelected()) {
                break;
            }
        }
        LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
        if (lang != null) {
            return lang.getKey();
        }
        return null;
    }

    public final boolean isSearchActive() {
        LanguageSelectUIState value = this._state.getValue();
        if (value == null) {
            return false;
        }
        return value.isSearchActive();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$1 */
    /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$1", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_2_2}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA1_3_3}, m1615s = {}, m1616v = 2)
    static final class C66571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66571(Continuation<? super C66571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageSelectionViewModel.this.new C66571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowAsFlow = FlowLiveDataConversions.asFlow(LanguageSelectionViewModel.this.networkStateRepository.getNeboNetworkState());
                final LanguageSelectionViewModel languageSelectionViewModel = LanguageSelectionViewModel.this;
                this.label = 1;
                if (flowAsFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.onboarding.LanguageSelectionViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((NeboNetworkState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(NeboNetworkState neboNetworkState, Continuation<? super Unit> continuation) {
                        languageSelectionViewModel.isConnected = neboNetworkState instanceof NeboNetworkState.Connected;
                        if (languageSelectionViewModel.isConnected) {
                            languageSelectionViewModel.installer.installLanguages(ViewModelKt.getViewModelScope(languageSelectionViewModel));
                        }
                        LanguageSelectionViewModel languageSelectionViewModel2 = languageSelectionViewModel;
                        List<LanguageManagerItem.Lang> list = languageSelectionViewModel2.rawData;
                        LanguageSelectionViewModel languageSelectionViewModel3 = languageSelectionViewModel;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (LanguageManagerItem.Lang lang : list) {
                            lang.setDownloadable(languageSelectionViewModel3.isConnected);
                            arrayList.add(lang);
                        }
                        languageSelectionViewModel2.rawData = arrayList;
                        languageSelectionViewModel.refreshUIState();
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.languageRepository.removeGlobalDownloadCallback(this.onLanguageUpdate);
        this.languageRepository.destroy();
        this.installer.destroy();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1 */
    /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {153}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {167}, m1615s = {}, m1616v = 2)
    static final class C66591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66591(Continuation<? super C66591> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageSelectionViewModel.this.new C66591(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnCompletion = FlowKt.onCompletion(FlowKt.onStart(LanguageSelectionViewModel.this.languageRepository.getLanguages(), new AnonymousClass1(LanguageSelectionViewModel.this, null)), new AnonymousClass2(LanguageSelectionViewModel.this, null));
                final LanguageSelectionViewModel languageSelectionViewModel = LanguageSelectionViewModel.this;
                this.label = 1;
                if (flowOnCompletion.collect(new FlowCollector() { // from class: com.myscript.nebo.onboarding.LanguageSelectionViewModel.loadLanguages.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<Language>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<Language> list, Continuation<? super Unit> continuation) {
                        Unit unit;
                        T next;
                        if (!list.isEmpty()) {
                            LanguageNameHelper languageNameHelper = languageSelectionViewModel.languageNameHelper;
                            List<Language> list2 = list;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Language) it.next()).getLanguageKey());
                            }
                            languageNameHelper.buildLanguagesInfo(arrayList);
                            LanguageSelectionViewModel languageSelectionViewModel2 = languageSelectionViewModel;
                            languageSelectionViewModel2.rawData = languageSelectionViewModel2.getAsLanguageManagerItemList(list);
                            List<String> pendingLanguagesToInstall = languageSelectionViewModel.installer.getPendingLanguagesToInstall();
                            LanguageSelectionViewModel languageSelectionViewModel3 = languageSelectionViewModel;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pendingLanguagesToInstall, 10));
                            for (String str : pendingLanguagesToInstall) {
                                Iterator<T> it2 = languageSelectionViewModel3.rawData.iterator();
                                while (true) {
                                    unit = null;
                                    if (!it2.hasNext()) {
                                        next = (T) null;
                                        break;
                                    }
                                    next = it2.next();
                                    LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
                                    if (Intrinsics.areEqual(lang.getKey(), str) && !lang.getInstalled() && !lang.isDownloadOnGoing()) {
                                        break;
                                    }
                                }
                                LanguageManagerItem.Lang lang2 = next;
                                if (lang2 != null) {
                                    lang2.setPending(true);
                                    unit = Unit.INSTANCE;
                                }
                                arrayList2.add(unit);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1$1", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Language>>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LanguageSelectionViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LanguageSelectionViewModel languageSelectionViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = languageSelectionViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Language>> flowCollector, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super List<Language>>) flowCollector, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super List<Language>> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshUIState();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;", "it", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadLanguages$1$2", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Language>>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LanguageSelectionViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LanguageSelectionViewModel languageSelectionViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = languageSelectionViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Language>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super List<Language>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super List<Language>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshUIState();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void loadLanguages() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66591(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadInstalledLanguages$1 */
    /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$loadInstalledLanguages$1", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_7_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {179}, m1615s = {}, m1616v = 2)
    static final class C66581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66581(Continuation<? super C66581> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageSelectionViewModel.this.new C66581(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<Language>> installedLanguages = LanguageSelectionViewModel.this.languageRepository.getInstalledLanguages();
                final LanguageSelectionViewModel languageSelectionViewModel = LanguageSelectionViewModel.this;
                this.label = 1;
                if (installedLanguages.collect(new FlowCollector() { // from class: com.myscript.nebo.onboarding.LanguageSelectionViewModel.loadInstalledLanguages.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<Language>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<Language> list, Continuation<? super Unit> continuation) {
                        LanguageNameHelper languageNameHelper = languageSelectionViewModel.languageNameHelper;
                        List<Language> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Language) it.next()).getLanguageKey());
                        }
                        languageNameHelper.buildLanguagesInfo(arrayList);
                        LanguageSelectionViewModel languageSelectionViewModel2 = languageSelectionViewModel;
                        languageSelectionViewModel2.rawData = languageSelectionViewModel2.getAsLanguageManagerItemList(list);
                        languageSelectionViewModel.refreshUIState();
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void loadInstalledLanguages() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66581(null), 3, null);
    }

    public final void selectLanguage(String languageKey) {
        Object next;
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Iterator<T> it = this.rawData.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), languageKey)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
        if (lang == null) {
            return;
        }
        if (lang.getInstalled()) {
            List<LanguageManagerItem.Lang> list = this.rawData;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (LanguageManagerItem.Lang lang2 : list) {
                lang2.setSelected(Intrinsics.areEqual(lang2.getKey(), languageKey));
                arrayList.add(lang2);
            }
            this.rawData = arrayList;
            refreshUIState();
            return;
        }
        if (lang.isDownloadOnGoing() || lang.getPending()) {
            return;
        }
        download(languageKey);
    }

    public final void search(String label) {
        if (Intrinsics.areEqual(this.query, label)) {
            return;
        }
        this.query = label;
        refreshUIState();
    }

    public final void download(String languageKey) {
        Object next;
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Iterator<T> it = this.rawData.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), languageKey)) {
                    break;
                }
            }
        }
        LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
        if (lang != null) {
            lang.setPending(true);
            refreshUIState();
            this.languageRepository.downloadLanguage(languageKey);
        }
    }

    public final void cancelDownload(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.languageRepository.cancelDownloadLanguage(languageKey);
    }

    public final void removeLanguage(String languageKey) {
        Object next;
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.languageRepository.removeLanguage(languageKey);
        Iterator<T> it = this.rawData.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), languageKey)) {
                    break;
                }
            }
        }
        LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) next;
        if (lang != null) {
            lang.setInstalled(false);
            refreshUIState();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.onboarding.LanguageSelectionViewModel$refreshUIState$1 */
    /* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.onboarding.LanguageSelectionViewModel$refreshUIState$1", m1609f = "LanguageSelectionViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66601(Continuation<? super C66601> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageSelectionViewModel.this.new C66601(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayListFilteredLanguages;
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (LanguageSelectionViewModel.this.query == null) {
                    List list = LanguageSelectionViewModel.this.rawData;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) obj2;
                        if (lang.getInstalled() || lang.getPending() || lang.isDownloadOnGoing()) {
                            arrayList.add(obj2);
                        }
                    }
                    arrayListFilteredLanguages = arrayList;
                } else {
                    LanguageSelectionViewModel languageSelectionViewModel = LanguageSelectionViewModel.this;
                    arrayListFilteredLanguages = languageSelectionViewModel.filteredLanguages(languageSelectionViewModel.query);
                }
                MutableLiveData mutableLiveData = LanguageSelectionViewModel.this._state;
                List listSortedWith = CollectionsKt.sortedWith(arrayListFilteredLanguages, new Comparator() { // from class: com.myscript.nebo.onboarding.LanguageSelectionViewModel$refreshUIState$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((LanguageManagerItem.Lang) t).getLabel(), ((LanguageManagerItem.Lang) t2).getLabel());
                    }
                });
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it = listSortedWith.iterator();
                while (it.hasNext()) {
                    arrayList2.add(LanguageManagerItem.Lang.copy$default((LanguageManagerItem.Lang) it.next(), null, null, false, false, false, 0, 0, false, false, false, 1023, null));
                }
                ArrayList arrayList3 = arrayList2;
                boolean z2 = LanguageSelectionViewModel.this.query != null;
                boolean zIsEmpty = LanguageSelectionViewModel.this.rawData.isEmpty();
                boolean z3 = !LanguageSelectionViewModel.this.isConnected;
                List list2 = LanguageSelectionViewModel.this.rawData;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    z = false;
                } else {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (((LanguageManagerItem.Lang) it2.next()).isSelected()) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                }
                mutableLiveData.setValue(new LanguageSelectUIState(arrayList3, z2, zIsEmpty, z3, z));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshUIState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C66601(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LanguageManagerItem.Lang> filteredLanguages(String query) {
        String str = query;
        if (str == null || StringsKt.isBlank(str)) {
            return this.rawData;
        }
        String lowerCase = query.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        for (LanguageManagerItem.Lang lang : this.rawData) {
            if (this.languageNameHelper.isFilteredLanguageAccepted(lowerCase, lang.getKey())) {
                arrayList.add(lang);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LanguageManagerItem.Lang> getAsLanguageManagerItemList(List<Language> list) {
        List<Language> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Language language : list2) {
            LanguageManagerItem.Lang lang = LanguageExtKt.toLang(language, LanguageNameHelper.getDisplayLanguage$default(this.languageNameHelper, language.getLanguageKey(), true, null, 4, null), this.languageRepository.canDownload(), false);
            lang.setUpToDate(true);
            arrayList.add(lang);
        }
        return arrayList;
    }
}
