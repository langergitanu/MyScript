package com.myscript.nebo.languagemanager.presentation;

import android.content.ComponentCallbacks2;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.location.LocationRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl;
import com.myscript.nebo.languagemanager.domain.LanguageRepository;
import com.myscript.nebo.languagemanager.presentation.model.GroupingKey;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItemKt;
import com.myscript.nebo.languagemanager.presentation.model.SectionType;
import com.myscript.nebo.languagemanager.util.LanguageExtKt;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: LanguageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n*\u0001&\u0018\u00002\u00020\u0001:\u0001JB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\bJ\u000e\u00100\u001a\u00020-2\u0006\u0010/\u001a\u00020\bJ\u000e\u00101\u001a\u00020-2\u0006\u0010/\u001a\u00020\bJ\b\u00102\u001a\u00020-H\u0002J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0007H\u0002J\u0006\u00106\u001a\u00020-J\u0006\u00107\u001a\u00020-J\u000e\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020$J\u000e\u0010<\u001a\u00020-2\u0006\u0010;\u001a\u00020$J\u000e\u0010=\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\u0017JD\u0010?\u001a\u00020-2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00172\b\b\u0002\u0010E\u001a\u00020\u00172\b\b\u0002\u0010F\u001a\u00020\u0017H\u0002J\b\u0010G\u001a\u00020-H\u0014J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010I\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00170\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006K"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "Landroidx/lifecycle/ViewModel;", "languageRepository", "Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;", "languageNameHelper", "Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "suggestedLanguageKeys", "", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;Ljava/util/List;Lkotlinx/coroutines/CoroutineDispatcher;)V", "rawData", "", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "_languages", "Landroidx/lifecycle/MutableLiveData;", "languages", "Landroidx/lifecycle/LiveData;", "getLanguages", "()Landroidx/lifecycle/LiveData;", "_isError", "", "isError", "_showSpinner", "kotlin.jvm.PlatformType", "showSpinner", "getShowSpinner", "_languagesToUpdate", "languagesToUpdate", "getLanguagesToUpdate", "installedLanguageKeys", "getInstalledLanguageKeys", "()Ljava/util/List;", "downloadCallbacks", "Lcom/myscript/atk/resourcemanager/GlobalDownloadsCallback;", "onLanguageUpdate", "com/myscript/nebo/languagemanager/presentation/LanguageViewModel$onLanguageUpdate$1", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel$onLanguageUpdate$1;", "downloadCanceledOverCellularNotification", "Lcom/myscript/android/utils/SingleLiveEvent;", "getDownloadCanceledOverCellularNotification", "()Lcom/myscript/android/utils/SingleLiveEvent;", "loadLanguages", "", "removeLanguage", "languageKey", "download", "cancelDownload", "updateAll", "sortList", "list", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "onSearchOpened", "onSearchClosed", FirebaseAnalytics.Event.SEARCH, "label", "addDownloadCallback", "callback", "removeDownloadCallback", "isLanguageAvailable", "areLanguagesReady", "updateListItem", "progress", "", "max", "available", "isUpToDate", "suggested", "selected", "onCleared", "filteredLanguages", SearchIntents.EXTRA_QUERY, "Factory", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _isError;
    private final MutableLiveData<List<LanguageManagerItem>> _languages;
    private final MutableLiveData<List<String>> _languagesToUpdate;
    private final MutableLiveData<Boolean> _showSpinner;
    private final List<GlobalDownloadsCallback> downloadCallbacks;
    private final SingleLiveEvent<Boolean> downloadCanceledOverCellularNotification;
    private final LanguageNameHelper languageNameHelper;
    private final LanguageRepository languageRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final LanguageViewModel$onLanguageUpdate$1 onLanguageUpdate;
    private final List<LanguageManagerItem> rawData;
    private final List<String> suggestedLanguageKeys;

    /* JADX WARN: Type inference failed for: r2v9, types: [com.myscript.nebo.languagemanager.presentation.LanguageViewModel$onLanguageUpdate$1] */
    public LanguageViewModel(LanguageRepository languageRepository, LanguageNameHelper languageNameHelper, List<String> suggestedLanguageKeys, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(languageRepository, "languageRepository");
        Intrinsics.checkNotNullParameter(languageNameHelper, "languageNameHelper");
        Intrinsics.checkNotNullParameter(suggestedLanguageKeys, "suggestedLanguageKeys");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.languageRepository = languageRepository;
        this.languageNameHelper = languageNameHelper;
        this.suggestedLanguageKeys = suggestedLanguageKeys;
        this.mainDispatcher = mainDispatcher;
        this.rawData = new ArrayList();
        this._languages = new MutableLiveData<>(CollectionsKt.emptyList());
        this._isError = new MutableLiveData<>();
        this._showSpinner = new MutableLiveData<>(false);
        this._languagesToUpdate = new MutableLiveData<>();
        this.downloadCallbacks = new ArrayList();
        ?? r2 = new GlobalDownloadsCallback() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$onLanguageUpdate$1
            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadCanceled(Language language) {
                Intrinsics.checkNotNullParameter(language, "language");
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadError(Language language, Exception exception) {
                Intrinsics.checkNotNullParameter(language, "language");
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadStart(Language language) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                List<LanguageManagerItem> value = this.this$0.getLanguages().getValue();
                if (value != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : value) {
                        if (obj instanceof LanguageManagerItem.Lang) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
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
                    LanguageViewModel.updateListItem$default(this.this$0, language.getLanguageKey(), 1, 100, lang.getInstalled(), lang.isUpToDate(), this.this$0.suggestedLanguageKeys.contains(language.getLanguageKey()), false, 64, null);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadProgress(Language language, int max, int progress) {
                Object next;
                Intrinsics.checkNotNullParameter(language, "language");
                List<LanguageManagerItem> value = this.this$0.getLanguages().getValue();
                if (value != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : value) {
                        if (obj instanceof LanguageManagerItem.Lang) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (Intrinsics.areEqual(((LanguageManagerItem.Lang) next).getKey(), language.getLanguageKey())) {
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
                    LanguageViewModel.updateListItem$default(this.this$0, language.getLanguageKey(), progress, max, lang.getInstalled(), lang.isUpToDate(), this.this$0.suggestedLanguageKeys.contains(language.getLanguageKey()), false, 64, null);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadSuccess(Language language) {
                Intrinsics.checkNotNullParameter(language, "language");
                LanguageViewModel.updateListItem$default(this.this$0, language.getLanguageKey(), -1, -1, true, true, this.this$0.suggestedLanguageKeys.contains(language.getLanguageKey()), false, 64, null);
                MutableLiveData mutableLiveData = this.this$0._languagesToUpdate;
                List list = (List) this.this$0._languagesToUpdate.getValue();
                mutableLiveData.setValue(list != null ? CollectionsKt.minus(list, language.getLanguageKey()) : null);
            }
        };
        this.onLanguageUpdate = r2;
        SingleLiveEvent<Boolean> singleLiveEvent = new SingleLiveEvent<>();
        this.downloadCanceledOverCellularNotification = singleLiveEvent;
        addDownloadCallback((GlobalDownloadsCallback) r2);
        loadLanguages();
        singleLiveEvent.setValue(false);
    }

    public /* synthetic */ LanguageViewModel(LanguageRepository languageRepository, LanguageNameHelper languageNameHelper, List list, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(languageRepository, languageNameHelper, list, (i & 8) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    public final LiveData<List<LanguageManagerItem>> getLanguages() {
        return this._languages;
    }

    public final LiveData<Boolean> isError() {
        return this._isError;
    }

    public final LiveData<Boolean> getShowSpinner() {
        return this._showSpinner;
    }

    public final LiveData<List<String>> getLanguagesToUpdate() {
        return this._languagesToUpdate;
    }

    public final List<String> getInstalledLanguageKeys() {
        List<LanguageManagerItem> value = getLanguages().getValue();
        if (value == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (obj instanceof LanguageManagerItem.Lang) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((LanguageManagerItem.Lang) obj2).getInstalled()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((LanguageManagerItem.Lang) it.next()).getKey());
        }
        return arrayList4;
    }

    public final SingleLiveEvent<Boolean> getDownloadCanceledOverCellularNotification() {
        return this.downloadCanceledOverCellularNotification;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1 */
    /* JADX INFO: compiled from: LanguageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {LocationRequest.PRIORITY_NO_POWER}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA1_2_1}, m1615s = {}, m1616v = 2)
    static final class C66201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66201(Continuation<? super C66201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageViewModel.this.new C66201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM16058catch = FlowKt.m16058catch(FlowKt.onCompletion(FlowKt.onStart(LanguageViewModel.this.languageRepository.getLanguages(), new AnonymousClass1(LanguageViewModel.this, null)), new AnonymousClass2(LanguageViewModel.this, null)), new AnonymousClass3(LanguageViewModel.this, null));
                final LanguageViewModel languageViewModel = LanguageViewModel.this;
                this.label = 1;
                if (flowM16058catch.collect(new FlowCollector() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel.loadLanguages.1.4
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<Language>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<Language> list, Continuation<? super Unit> continuation) {
                        LanguageNameHelper languageNameHelper = languageViewModel.languageNameHelper;
                        List<Language> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Language) it.next()).getLanguageKey());
                        }
                        languageNameHelper.buildLanguagesInfo(CollectionsKt.toMutableList((Collection) arrayList));
                        LanguageViewModel languageViewModel2 = languageViewModel;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (Language language : list2) {
                            arrayList2.add(LanguageExtKt.toLang(language, LanguageNameHelper.getDisplayLanguage$default(languageViewModel2.languageNameHelper, language.getLanguageKey(), false, null, 6, null), languageViewModel2.languageRepository.canDownload(), languageViewModel2.suggestedLanguageKeys.contains(language.getLanguageKey())));
                        }
                        List listSortList = languageViewModel.sortList(arrayList2);
                        languageViewModel.rawData.clear();
                        CollectionsKt.addAll(languageViewModel.rawData, listSortList);
                        languageViewModel._languages.setValue(listSortList);
                        MutableLiveData mutableLiveData = languageViewModel._languagesToUpdate;
                        ArrayList arrayList3 = new ArrayList();
                        for (T t : list2) {
                            if (Intrinsics.areEqual(((Language) t).isUpToDate(), Boxing.boxBoolean(false))) {
                                arrayList3.add(t);
                            }
                        }
                        ArrayList arrayList4 = arrayList3;
                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                        Iterator<T> it2 = arrayList4.iterator();
                        while (it2.hasNext()) {
                            arrayList5.add(((Language) it2.next()).getLanguageKey());
                        }
                        mutableLiveData.setValue(arrayList5);
                        languageViewModel.updateAll();
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

        /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$1", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Language>>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LanguageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LanguageViewModel languageViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = languageViewModel;
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
                    this.this$0._showSpinner.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;", "it", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$2", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Language>>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LanguageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LanguageViewModel languageViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = languageViewModel;
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
                    this.this$0._showSpinner.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;", "it", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$loadLanguages$1$3", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Language>>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LanguageViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(LanguageViewModel languageViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.this$0 = languageViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Language>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super List<Language>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super List<Language>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new AnonymousClass3(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._isError.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void loadLanguages() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66201(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$removeLanguage$1 */
    /* JADX INFO: compiled from: LanguageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$removeLanguage$1", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $languageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66211(String str, Continuation<? super C66211> continuation) {
            super(2, continuation);
            this.$languageKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageViewModel.this.new C66211(this.$languageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LanguageViewModel.this.languageRepository.removeLanguage(this.$languageKey);
                LanguageViewModel languageViewModel = LanguageViewModel.this;
                LanguageViewModel.updateListItem$default(languageViewModel, this.$languageKey, -1, -1, false, true, languageViewModel.suggestedLanguageKeys.contains(this.$languageKey), false, 64, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void removeLanguage(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C66211(languageKey, null), 2, null);
    }

    public final void download(String languageKey) {
        Object next;
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        List<LanguageManagerItem> value = this._languages.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (obj instanceof LanguageManagerItem.Lang) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
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
        if ((lang.getInstalled() && lang.isUpToDate()) || lang.isDownloadOnGoing() || lang.getPending()) {
            return;
        }
        this.languageRepository.downloadLanguage(lang.getKey());
    }

    public final void cancelDownload(String languageKey) {
        Object next;
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.languageRepository.cancelDownloadLanguage(languageKey);
        List<LanguageManagerItem> value = this._languages.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (obj instanceof LanguageManagerItem.Lang) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
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
        updateListItem$default(this, languageKey, -1, -1, lang.getInstalled(), lang.isUpToDate(), this.suggestedLanguageKeys.contains(languageKey), false, 64, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$updateAll$1 */
    /* JADX INFO: compiled from: LanguageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$updateAll$1", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {154}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {163}, m1615s = {}, m1616v = 2)
    static final class C66231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66231(Continuation<? super C66231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageViewModel.this.new C66231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<NeboNetworkState> neboNetworkDataState = LanguageViewModel.this.languageRepository.getNeboNetworkDataState();
                final LanguageViewModel languageViewModel = LanguageViewModel.this;
                this.label = 1;
                if (neboNetworkDataState.collect(new FlowCollector() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel.updateAll.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((NeboNetworkState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(NeboNetworkState neboNetworkState, Continuation<? super Unit> continuation) {
                        List list = (List) languageViewModel._languagesToUpdate.getValue();
                        if (list == null) {
                            return Unit.INSTANCE;
                        }
                        if (!neboNetworkState.isDataTransferAllowed()) {
                            if (languageViewModel.languageRepository.isDownloading()) {
                                LanguageViewModel languageViewModel2 = languageViewModel;
                                Iterator<T> it = list.iterator();
                                while (it.hasNext()) {
                                    languageViewModel2.cancelDownload((String) it.next());
                                }
                                languageViewModel.getDownloadCanceledOverCellularNotification().setValue(Boxing.boxBoolean((neboNetworkState instanceof NeboNetworkState.Connected) && !((NeboNetworkState.Connected) neboNetworkState).isEnabled()));
                            }
                        } else {
                            LanguageViewModel languageViewModel3 = languageViewModel;
                            Iterator<T> it2 = list.iterator();
                            while (it2.hasNext()) {
                                languageViewModel3.download((String) it2.next());
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAll() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66231(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LanguageManagerItem> sortList(List<LanguageManagerItem.Lang> list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            GroupingKey groupingKey = LanguageManagerItemKt.toGroupingKey((LanguageManagerItem.Lang) obj);
            Object obj2 = linkedHashMap.get(groupingKey);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(groupingKey, obj2);
            }
            ((List) obj2).add(obj);
        }
        arrayList.add(LanguageManagerItem.Explanation.INSTANCE);
        GroupingKey groupingKey2 = new GroupingKey(true, false, false);
        GroupingKey groupingKey3 = new GroupingKey(false, true, false);
        GroupingKey groupingKey4 = new GroupingKey(false, false, true);
        SectionType sectionType = SectionType.INSTALLED;
        List list2 = (List) linkedHashMap.get(groupingKey2);
        arrayList.add(new LanguageManagerItem.Section(sectionType, list2 != null ? list2.size() : 0));
        List list3 = (List) linkedHashMap.get(groupingKey2);
        List<LanguageManagerItem.Lang> listSortedWith = list3 != null ? CollectionsKt.sortedWith(list3, new Comparator() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$sortList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((LanguageManagerItem.Lang) t).getLabel(), ((LanguageManagerItem.Lang) t2).getLabel());
            }
        }) : null;
        if (listSortedWith != null) {
            for (LanguageManagerItem.Lang lang : listSortedWith) {
                arrayList.add(new LanguageManagerItem.Lang(lang.getKey(), lang.getLabel(), true, lang.isUpToDate(), this.languageRepository.canDownload(), lang.getProgress(), lang.getMax(), false, false, lang.isSelected(), RendererCapabilities.DECODER_SUPPORT_MASK, null));
            }
        }
        if (!this.suggestedLanguageKeys.isEmpty()) {
            SectionType sectionType2 = SectionType.SUGGESTED;
            List list4 = (List) linkedHashMap.get(groupingKey3);
            arrayList.add(new LanguageManagerItem.Section(sectionType2, list4 != null ? list4.size() : 0));
            List list5 = (List) linkedHashMap.get(groupingKey3);
            List<LanguageManagerItem.Lang> listSortedWith2 = list5 != null ? CollectionsKt.sortedWith(list5, new Comparator() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$sortList$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((LanguageManagerItem.Lang) t).getLabel(), ((LanguageManagerItem.Lang) t2).getLabel());
                }
            }) : null;
            if (listSortedWith2 != null) {
                for (LanguageManagerItem.Lang lang2 : listSortedWith2) {
                    arrayList.add(new LanguageManagerItem.Lang(lang2.getKey(), lang2.getLabel(), false, lang2.isUpToDate(), this.languageRepository.canDownload(), lang2.getProgress(), lang2.getMax(), false, true, false, 640, null));
                }
            }
        }
        SectionType sectionType3 = SectionType.AVAILABLE;
        List list6 = (List) linkedHashMap.get(groupingKey4);
        arrayList.add(new LanguageManagerItem.Section(sectionType3, list6 != null ? list6.size() : 0));
        List list7 = (List) linkedHashMap.get(groupingKey4);
        List<LanguageManagerItem.Lang> listSortedWith3 = list7 != null ? CollectionsKt.sortedWith(list7, new Comparator() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$sortList$$inlined$sortedBy$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((LanguageManagerItem.Lang) t).getLabel(), ((LanguageManagerItem.Lang) t2).getLabel());
            }
        }) : null;
        if (listSortedWith3 != null) {
            for (LanguageManagerItem.Lang lang3 : listSortedWith3) {
                arrayList.add(new LanguageManagerItem.Lang(lang3.getKey(), lang3.getLabel(), false, lang3.isUpToDate(), this.languageRepository.canDownload(), lang3.getProgress(), lang3.getMax(), false, false, false, 896, null));
            }
        }
        return arrayList;
    }

    public final void onSearchOpened() {
        Object next;
        ArrayList arrayList;
        List<LanguageManagerItem> value = this._languages.getValue();
        if (value == null) {
            return;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((LanguageManagerItem) next) instanceof LanguageManagerItem.Explanation) {
                    break;
                }
            }
        }
        LanguageManagerItem languageManagerItem = (LanguageManagerItem) next;
        if (languageManagerItem == null) {
            return;
        }
        List<LanguageManagerItem> value2 = this._languages.getValue();
        if (value2 == null || (arrayList = CollectionsKt.toMutableList((Collection) value2)) == null) {
            arrayList = new ArrayList();
        }
        arrayList.remove(languageManagerItem);
        this._languages.setValue(arrayList);
    }

    public final void onSearchClosed() {
        LanguageManagerItem.Explanation explanation = LanguageManagerItem.Explanation.INSTANCE;
        List<LanguageManagerItem> value = this._languages.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!value.contains(explanation)) {
            arrayList.add(explanation);
        }
        arrayList.addAll(value);
        this._languages.setValue(arrayList);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.presentation.LanguageViewModel$search$1 */
    /* JADX INFO: compiled from: LanguageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.presentation.LanguageViewModel$search$1", m1609f = "LanguageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $label;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66221(String str, Continuation<? super C66221> continuation) {
            super(2, continuation);
            this.$label = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageViewModel.this.new C66221(this.$label, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LanguageViewModel.this._languages.setValue(LanguageViewModel.this.filteredLanguages(this.$label));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void search(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C66221(label, null), 2, null);
    }

    public final void addDownloadCallback(GlobalDownloadsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.downloadCallbacks.add(callback);
        this.languageRepository.addGlobalDownloadCallback(callback);
    }

    public final void removeDownloadCallback(GlobalDownloadsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.downloadCallbacks.remove(callback);
        this.languageRepository.removeGlobalDownloadCallback(callback);
    }

    public final boolean isLanguageAvailable(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        return getInstalledLanguageKeys().contains(languageKey);
    }

    public final boolean areLanguagesReady() {
        if (getLanguages().getValue() != null) {
            return !r0.isEmpty();
        }
        return false;
    }

    static /* synthetic */ void updateListItem$default(LanguageViewModel languageViewModel, String str, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z3 = false;
        }
        if ((i3 & 64) != 0) {
            z4 = false;
        }
        languageViewModel.updateListItem(str, i, i2, z, z2, z3, z4);
    }

    private final void updateListItem(String languageKey, int progress, int max, boolean available, boolean isUpToDate, boolean suggested, boolean selected) {
        Object next;
        List<LanguageManagerItem> value = this._languages.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (obj instanceof LanguageManagerItem.Lang) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
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
        int iIndexOf = value.indexOf(lang);
        LanguageManagerItem.Lang langCopy$default = LanguageManagerItem.Lang.copy$default(lang, null, null, false, false, false, 0, 0, false, false, false, 1023, null);
        langCopy$default.setProgress(progress);
        langCopy$default.setMax(max);
        langCopy$default.setInstalled(available);
        langCopy$default.setUpToDate(isUpToDate);
        langCopy$default.setSuggested(suggested);
        langCopy$default.setSelected(selected);
        List mutableList = CollectionsKt.toMutableList((Collection) value);
        mutableList.set(iIndexOf, langCopy$default);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : mutableList) {
            if (obj2 instanceof LanguageManagerItem.Lang) {
                arrayList2.add(obj2);
            }
        }
        List<LanguageManagerItem> listSortList = sortList(arrayList2);
        this.rawData.clear();
        this.rawData.addAll(listSortList);
        this._languages.setValue(listSortList);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        Iterator<T> it = this.downloadCallbacks.iterator();
        while (it.hasNext()) {
            this.languageRepository.removeGlobalDownloadCallback((GlobalDownloadsCallback) it.next());
        }
        this.languageRepository.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LanguageManagerItem> filteredLanguages(String query) {
        if (StringsKt.isBlank(query)) {
            return this.rawData;
        }
        String lowerCase = query.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        List<LanguageManagerItem> list = this.rawData;
        ArrayList<LanguageManagerItem.Lang> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof LanguageManagerItem.Lang) {
                arrayList2.add(obj);
            }
        }
        for (LanguageManagerItem.Lang lang : arrayList2) {
            if (this.languageNameHelper.isFilteredLanguageAccepted(lowerCase, lang.getKey())) {
                arrayList.add(lang);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: LanguageViewModel.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "languageNameHelper", "Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "suggestedLanguageKeys", "", "", "<init>", "(Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;Ljava/util/List;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        private final LanguageNameHelper languageNameHelper;
        private final List<String> suggestedLanguageKeys;

        public Factory(LanguageNameHelper languageNameHelper, List<String> suggestedLanguageKeys) {
            Intrinsics.checkNotNullParameter(languageNameHelper, "languageNameHelper");
            Intrinsics.checkNotNullParameter(suggestedLanguageKeys, "suggestedLanguageKeys");
            this.languageNameHelper = languageNameHelper;
            this.suggestedLanguageKeys = suggestedLanguageKeys;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
            return (T) super.create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
            return (T) super.create(kClass, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (modelClass.isAssignableFrom(LanguageViewModel.class)) {
                ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(extras);
                Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.atk.resourcemanager.ResourceManager.Provider");
                ResourceManager resourceManagerProvideResourceManager = ((ResourceManager.Provider) componentCallbacks2RequireApplication).provideResourceManager();
                Intrinsics.checkNotNullExpressionValue(resourceManagerProvideResourceManager, "provideResourceManager(...)");
                return new LanguageViewModel(new LanguageRepositoryImpl(resourceManagerProvideResourceManager, ((NeboNetworkStateRepositoryProvider) componentCallbacks2RequireApplication).provideNeboNetworkStateRepository()), this.languageNameHelper, this.suggestedLanguageKeys, null, 8, null);
            }
            throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
        }
    }
}
