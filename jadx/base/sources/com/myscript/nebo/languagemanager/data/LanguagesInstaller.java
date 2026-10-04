package com.myscript.nebo.languagemanager.data;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.languagemanager.domain.LanguageRepository;
import com.myscript.nebo.languagemanager.util.LocaleListUtilKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: LanguagesInstaller.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/data/LanguagesInstaller;", "Lcom/myscript/nebo/languagemanager/data/ILanguagesInstaller;", "languageRepository", "Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;", "languagesToInstall", "", "Ljava/util/Locale;", "<init>", "(Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;Ljava/util/List;)V", "pendingLanguagesToInstall", "", "", "getPendingLanguagesToInstall", "()Ljava/util/List;", "downloadCallback", "com/myscript/nebo/languagemanager/data/LanguagesInstaller$downloadCallback$1", "Lcom/myscript/nebo/languagemanager/data/LanguagesInstaller$downloadCallback$1;", "installLanguages", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fallbackLanguageKey", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "destroy", "Companion", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguagesInstaller implements ILanguagesInstaller {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LanguagesInstaller$downloadCallback$1 downloadCallback;
    private final LanguageRepository languageRepository;
    private final List<String> pendingLanguagesToInstall;

    @JvmStatic
    public static final LanguagesInstaller build(Application application) {
        return INSTANCE.build(application);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.myscript.nebo.languagemanager.data.LanguagesInstaller$downloadCallback$1] */
    public LanguagesInstaller(LanguageRepository languageRepository, List<Locale> languagesToInstall) {
        Intrinsics.checkNotNullParameter(languageRepository, "languageRepository");
        Intrinsics.checkNotNullParameter(languagesToInstall, "languagesToInstall");
        this.languageRepository = languageRepository;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(LocaleListUtilKt.getAsLanguageKeys(languagesToInstall));
        this.pendingLanguagesToInstall = arrayList;
        ?? r3 = new GlobalDownloadsCallback() { // from class: com.myscript.nebo.languagemanager.data.LanguagesInstaller$downloadCallback$1
            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadError(Language language, Exception exception) {
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadProgress(Language language, int max, int progress) {
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadStart(Language language) {
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadSuccess(Language language) {
                TypeIntrinsics.asMutableCollection(this.this$0.getPendingLanguagesToInstall()).remove(language != null ? language.getLanguageKey() : null);
                if (this.this$0.getPendingLanguagesToInstall().isEmpty()) {
                    this.this$0.languageRepository.removeGlobalDownloadCallback(this);
                }
            }

            @Override // com.myscript.atk.resourcemanager.GlobalDownloadsCallback
            public void onLanguageDownloadCanceled(Language language) {
                TypeIntrinsics.asMutableCollection(this.this$0.getPendingLanguagesToInstall()).remove(language != null ? language.getLanguageKey() : null);
                if (this.this$0.getPendingLanguagesToInstall().isEmpty()) {
                    this.this$0.languageRepository.removeGlobalDownloadCallback(this);
                }
            }
        };
        this.downloadCallback = r3;
        languageRepository.addGlobalDownloadCallback((GlobalDownloadsCallback) r3);
    }

    @Override // com.myscript.nebo.languagemanager.data.ILanguagesInstaller
    public List<String> getPendingLanguagesToInstall() {
        return this.pendingLanguagesToInstall;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguagesInstaller$installLanguages$1 */
    /* JADX INFO: compiled from: LanguagesInstaller.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguagesInstaller$installLanguages$1", m1609f = "LanguagesInstaller.kt", m1610i = {}, m1611l = {63}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA8_1}, m1615s = {}, m1616v = 2)
    static final class C66161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66161(Continuation<? super C66161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguagesInstaller.this.new C66161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<Language>> languages = LanguagesInstaller.this.languageRepository.getLanguages();
                final LanguagesInstaller languagesInstaller = LanguagesInstaller.this;
                this.label = 1;
                if (languages.collect(new FlowCollector() { // from class: com.myscript.nebo.languagemanager.data.LanguagesInstaller.installLanguages.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<Language>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<Language> list, Continuation<? super Unit> continuation) {
                        T next;
                        for (String str : languagesInstaller.getPendingLanguagesToInstall()) {
                            List<Language> list2 = list;
                            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((Language) it.next()).getLanguageKey(), str)) {
                                        for (Language language : list2) {
                                            if (Intrinsics.areEqual(language.getLanguageKey(), str)) {
                                                if (!language.isAvailable()) {
                                                    languagesInstaller.languageRepository.downloadLanguage(language.getLanguageKey());
                                                }
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                }
                            }
                            String strFallbackLanguageKey = languagesInstaller.fallbackLanguageKey((String) CollectionsKt.first(StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null)));
                            Iterator<T> it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = (T) null;
                                    break;
                                }
                                next = it2.next();
                                if (Intrinsics.areEqual(((Language) next).getLanguageKey(), strFallbackLanguageKey)) {
                                    break;
                                }
                            }
                            Language language2 = next;
                            if (language2 != null && !language2.isAvailable()) {
                                languagesInstaller.languageRepository.downloadLanguage(language2.getLanguageKey());
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

    @Override // com.myscript.nebo.languagemanager.data.ILanguagesInstaller
    public void installLanguages(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C66161(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String fallbackLanguageKey(String languageCode) {
        switch (languageCode.hashCode()) {
            case 3109:
                return !languageCode.equals("af") ? "en_US" : "af_ZA";
            case 3139:
                return !languageCode.equals("be") ? "en_US" : "be_BY";
            case 3141:
                return !languageCode.equals("bg") ? "en_US" : "bg_BG";
            case 3153:
                return !languageCode.equals(CmcdConfiguration.KEY_BUFFER_STARVATION) ? "en_US" : "bs_BA";
            case 3166:
                return !languageCode.equals("ca") ? "en_US" : "ca_ES";
            case 3184:
                return !languageCode.equals("cs") ? "en_US" : "cs_CZ";
            case 3197:
                return !languageCode.equals("da") ? "en_US" : "da_DK";
            case 3201:
                return !languageCode.equals("de") ? "en_US" : "de_DE";
            case 3239:
                return !languageCode.equals("el") ? "en_US" : "el_GR";
            case 3241:
                languageCode.equals("en");
                return "en_US";
            case 3246:
                return !languageCode.equals("es") ? "en_US" : "es_ES";
            case 3247:
                return !languageCode.equals("et") ? "en_US" : "et_EE";
            case 3248:
                return !languageCode.equals("eu") ? "en_US" : "eu_ES";
            case 3267:
                return !languageCode.equals("fi") ? "en_US" : "fi_FI";
            case 3276:
                return !languageCode.equals("fr") ? "en_US" : "fr_FR";
            case 3290:
                return !languageCode.equals("ga") ? "en_US" : "ga_IE";
            case 3301:
                return !languageCode.equals("gl") ? "en_US" : "gl_ES";
            case 3338:
                return !languageCode.equals("hr") ? "en_US" : "hr_HR";
            case 3341:
                return !languageCode.equals("hu") ? "en_US" : "hu_HU";
            case 3345:
                return !languageCode.equals("hy") ? "en_US" : "hy_AM";
            case 3355:
                return !languageCode.equals("id") ? "en_US" : "id_ID";
            case 3370:
                return !languageCode.equals("is") ? "en_US" : "is_IS";
            case 3371:
                return !languageCode.equals("it") ? "en_US" : "it_IT";
            case 3383:
                return !languageCode.equals("ja") ? "en_US" : "ja_JP";
            case 3414:
                return !languageCode.equals("ka") ? "en_US" : "ka_GE";
            case 3424:
                return !languageCode.equals("kk") ? "en_US" : "kk_KZ";
            case 3428:
                return !languageCode.equals("ko") ? "en_US" : "ko_KR";
            case 3464:
                return !languageCode.equals("lt") ? "en_US" : "lt_LT";
            case 3466:
                return !languageCode.equals("lv") ? "en_US" : "lv_LV";
            case 3482:
                return !languageCode.equals("mg") ? "en_US" : "mg_MG";
            case 3486:
                return !languageCode.equals("mk") ? "en_US" : "mk_MK";
            case 3489:
                return !languageCode.equals("mn") ? "en_US" : "ms_MY";
            case 3518:
                return !languageCode.equals("nl") ? "en_US" : "nl_NL";
            case 3521:
                return !languageCode.equals("no") ? "en_US" : "no_NO";
            case 3580:
                return !languageCode.equals("pl") ? "en_US" : "pl_PL";
            case 3588:
                return !languageCode.equals("pt") ? "en_US" : "pt_PT";
            case 3645:
                return !languageCode.equals("ro") ? "en_US" : "ro_RO";
            case 3651:
                return !languageCode.equals("ru") ? "en_US" : "ru_RU";
            case 3672:
                return !languageCode.equals("sk") ? "en_US" : "sk_SK";
            case 3673:
                return !languageCode.equals("sl") ? "en_US" : "sl_SI";
            case 3678:
                return !languageCode.equals("sq") ? "en_US" : "sq_AL";
            case 3679:
                return !languageCode.equals("sr") ? "en_US" : "sr_Latn_RS";
            case 3683:
                return !languageCode.equals("sv") ? "en_US" : "sv_SE";
            case 3684:
                return !languageCode.equals("sw") ? "en_US" : "sw_TZ";
            case 3710:
                return !languageCode.equals("tr") ? "en_US" : "tr_TR";
            case 3712:
                return !languageCode.equals(TtmlNode.TAG_TT) ? "en_US" : "tt_RU";
            case 3734:
                return !languageCode.equals("uk") ? "en_US" : "uk_UA";
            case 3763:
                return !languageCode.equals("vi") ? "en_US" : "vi_VN";
            case 3886:
                return !languageCode.equals("zh") ? "en_US" : "zh_CN";
            case 98368:
                return !languageCode.equals("ceb") ? "en_US" : "ceb_PH";
            case 101385:
                return !languageCode.equals("fil") ? "en_US" : "fil_PH";
            default:
                return "en_US";
        }
    }

    @Override // com.myscript.nebo.languagemanager.data.ILanguagesInstaller
    public void destroy() {
        this.languageRepository.destroy();
    }

    /* JADX INFO: compiled from: LanguagesInstaller.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/data/LanguagesInstaller$Companion;", "", "<init>", "()V", "build", "Lcom/myscript/nebo/languagemanager/data/LanguagesInstaller;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final LanguagesInstaller build(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            ResourceManager resourceManagerProvideResourceManager = ((ResourceManager.Provider) application).provideResourceManager();
            Intrinsics.checkNotNullExpressionValue(resourceManagerProvideResourceManager, "provideResourceManager(...)");
            return new LanguagesInstaller(new LanguageRepositoryImpl(resourceManagerProvideResourceManager, ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository()), LocaleListUtilKt.getDeviceLocales(application));
        }
    }
}
