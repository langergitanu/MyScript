package com.myscript.nebo.languagemanager.util;

import android.content.res.Resources;
import android.util.Log;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.utils.Latest;
import com.myscript.atk.resourcemanager.utils.LatestParser;
import com.myscript.atk.resourcemanager.utils.Version;
import com.myscript.snt.core.LanguageManager;
import com.myscript.snt.core.LocaleInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageListUtil.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005H\u0002J*\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\"j\b\u0012\u0004\u0012\u00020\u000b`#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/util/LanguageListUtil;", "", "latestInfoFile", "Ljava/io/File;", "confPaths", "", "", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "languages", "", "Lcom/myscript/atk/resourcemanager/Language;", "languagesLock", "isLanguageListBuildSuccess", "", "localLatest", "Lcom/myscript/atk/resourcemanager/utils/Latest;", "downloadFolder", "languageNameHelper", "Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "getLanguageNameHelper", "()Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "getLanguages", "buildList", "", "buildVersionsInfo", "Lcom/myscript/atk/resourcemanager/utils/Version;", "Language", "languageKey", "displayName", "version", "isAvailable", "buildLanguagesList", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Companion", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageListUtil {
    private static final String CONF_DIRNAME = "conf";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LanguageListUtil";
    private final List<String> confPaths;
    private File downloadFolder;
    private boolean isLanguageListBuildSuccess;
    private final LanguageNameHelper languageNameHelper;
    private final Map<String, Language> languages;
    private final Object languagesLock;
    private final File latestInfoFile;
    private Latest localLatest;

    @JvmStatic
    public static final List<String> buildInstalledLanguages(List<String> list) {
        return INSTANCE.buildInstalledLanguages(list);
    }

    @JvmStatic
    public static final boolean isLanguageAvailable(String str, List<String> list) {
        return INSTANCE.isLanguageAvailable(str, list);
    }

    @JvmStatic
    public static final boolean isMultipleCountriesLanguage(List<String> list, String str) {
        return INSTANCE.isMultipleCountriesLanguage(list, str);
    }

    public LanguageListUtil(File latestInfoFile, List<String> confPaths) {
        Intrinsics.checkNotNullParameter(latestInfoFile, "latestInfoFile");
        Intrinsics.checkNotNullParameter(confPaths, "confPaths");
        this.latestInfoFile = latestInfoFile;
        this.confPaths = confPaths;
        this.languages = new LinkedHashMap();
        this.languagesLock = new Object();
        Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNull(locale);
        this.languageNameHelper = new LanguageNameHelper(locale);
    }

    public final LanguageNameHelper getLanguageNameHelper() {
        return this.languageNameHelper;
    }

    public final List<Language> getLanguages() {
        List<Language> list;
        if (!this.isLanguageListBuildSuccess) {
            Log.w(TAG, "Language List was not build or not succeeded yet. Call buildList() first!");
            return CollectionsKt.emptyList();
        }
        synchronized (this.languagesLock) {
            list = CollectionsKt.toList(this.languages.values());
        }
        return list;
    }

    private final int buildList() {
        Set<String> setEmptySet;
        Log.d(TAG, "buildList...");
        try {
            Latest latest = new LatestParser().parse(FilesKt.readText$default(this.latestInfoFile, null, 1, null));
            this.localLatest = latest;
            if (latest == null || (setEmptySet = latest.getLanguages()) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            if (setEmptySet.isEmpty()) {
                Log.e(TAG, "Latest.json does not have language list... Abandoned building language list");
                this.isLanguageListBuildSuccess = false;
                return -3;
            }
            this.languageNameHelper.buildLanguagesInfo(setEmptySet);
            List<Version> listBuildVersionsInfo = buildVersionsInfo();
            if (listBuildVersionsInfo == null) {
                Log.e(TAG, "context or conf folder paths are not set correctly... Abandoned building language list");
                this.isLanguageListBuildSuccess = false;
                return -4;
            }
            synchronized (this.languagesLock) {
                this.languages.clear();
                for (String str : setEmptySet) {
                    if (!Language.INSTANCE.isSpecialResources(str)) {
                        this.languages.put(str, Language(str, LanguageNameHelper.getDisplayLanguage$default(this.languageNameHelper, str, false, null, 6, null), null, false));
                    }
                }
                for (Version version : listBuildVersionsInfo) {
                    List listListConfFiles = LanguageListUtilKt.listConfFiles(new File(new File(this.downloadFolder, version.toString()), CONF_DIRNAME));
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListConfFiles, 10));
                    Iterator it = listListConfFiles.iterator();
                    while (it.hasNext()) {
                        arrayList.add(FilesKt.getNameWithoutExtension((File) it.next()));
                    }
                    Language.Companion companion = Language.INSTANCE;
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (!companion.isSpecialResources((String) obj)) {
                            arrayList2.add(obj);
                        }
                    }
                    for (String str2 : arrayList2) {
                        if (this.languages.containsKey(str2)) {
                            this.languages.put(str2, Language(str2, LanguageNameHelper.getDisplayLanguage$default(this.languageNameHelper, str2, false, null, 6, null), version, true));
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            this.isLanguageListBuildSuccess = true;
            return this.languages.size();
        } catch (Exception e) {
            Log.e(TAG, "Parsing latest.json file failed... Abandoned building language list", e);
            this.isLanguageListBuildSuccess = false;
            return -2;
        }
    }

    private final List<Version> buildVersionsInfo() {
        ArrayList arrayList = new ArrayList();
        if (!this.latestInfoFile.isFile()) {
            return null;
        }
        File parentFile = this.latestInfoFile.getParentFile();
        Iterator<String> it = this.confPaths.iterator();
        boolean z = false;
        while (it.hasNext()) {
            File parentFile2 = new File(it.next()).getParentFile();
            if (parentFile2 != null && parentFile != null && LanguageListUtilKt.isAncestorOf(parentFile, parentFile2)) {
                try {
                    arrayList.add(new Version(parentFile2.getName()));
                    if (!z || this.downloadFolder == null) {
                        this.downloadFolder = parentFile2.getParentFile();
                        z = true;
                    }
                } catch (IllegalArgumentException e) {
                    Log.e(TAG, "Wrong version folder path in building version list: " + parentFile2, e);
                }
            }
        }
        CollectionsKt.sort(arrayList);
        return CollectionsKt.toList(arrayList);
    }

    private final Language Language(String languageKey, String displayName, Version version, boolean isAvailable) {
        Boolean boolValueOf = null;
        if (version != null) {
            Latest latest = this.localLatest;
            boolValueOf = Boolean.valueOf(version.compareTo(latest != null ? latest.getVersion() : null) >= 0);
        }
        return new Language(languageKey, displayName, isAvailable, boolValueOf);
    }

    public final List<Language> buildLanguagesList(Comparator<Language> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        buildList();
        List<Language> languages = getLanguages();
        Collections.sort(languages, comparator);
        return languages;
    }

    /* JADX INFO: compiled from: LanguageListUtil.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0007J\u001e\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/util/LanguageListUtil$Companion;", "", "<init>", "()V", "TAG", "", "CONF_DIRNAME", "buildInstalledLanguages", "", "confPath", "isLanguageAvailable", "", "languageTag", "isMultipleCountriesLanguage", "languages", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<String> buildInstalledLanguages(List<String> confPath) {
            Intrinsics.checkNotNullParameter(confPath, "confPath");
            ArrayList arrayList = new ArrayList();
            for (Object obj : confPath) {
                if (new File((String) obj).isDirectory()) {
                    arrayList.add(obj);
                }
            }
            LanguageManager languageManager = new LanguageManager(arrayList);
            try {
                List<LocaleInfo> listAvailableLanguages = languageManager.availableLanguages();
                Intrinsics.checkNotNullExpressionValue(listAvailableLanguages, "availableLanguages(...)");
                List<LocaleInfo> list = listAvailableLanguages;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((LocaleInfo) it.next()).getName());
                }
                return arrayList2;
            } finally {
                languageManager.delete();
            }
        }

        @JvmStatic
        public final boolean isLanguageAvailable(String languageTag, List<String> confPath) {
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            Intrinsics.checkNotNullParameter(confPath, "confPath");
            return buildInstalledLanguages(confPath).contains(languageTag);
        }

        @JvmStatic
        public final boolean isMultipleCountriesLanguage(List<String> languages, String languageTag) {
            int i;
            Intrinsics.checkNotNullParameter(languages, "languages");
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            String str = StringsKt.substringBefore$default(languageTag, '_', (String) null, 2, (Object) null) + "_";
            Set set = CollectionsKt.toSet(languages);
            if ((set instanceof Collection) && set.isEmpty()) {
                i = 0;
            } else {
                Iterator it = set.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (StringsKt.startsWith$default((String) it.next(), str, false, 2, (Object) null) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            return i > 1;
        }
    }
}
