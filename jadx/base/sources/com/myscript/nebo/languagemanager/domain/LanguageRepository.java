package com.myscript.nebo.languagemanager.domain;

import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.nebo.common.network.NeboNetworkState;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: LanguageRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;", "", "neboNetworkDataState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "getNeboNetworkDataState", "()Lkotlinx/coroutines/flow/Flow;", "getLanguages", "", "Lcom/myscript/atk/resourcemanager/Language;", "getInstalledLanguages", "removeLanguage", "", "languageKey", "", "downloadLanguage", "cancelDownloadLanguage", "canDownload", "", "isDownloading", "addGlobalDownloadCallback", "callback", "Lcom/myscript/atk/resourcemanager/GlobalDownloadsCallback;", "removeGlobalDownloadCallback", "destroy", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LanguageRepository {
    void addGlobalDownloadCallback(GlobalDownloadsCallback callback);

    boolean canDownload();

    void cancelDownloadLanguage(String languageKey);

    void destroy();

    void downloadLanguage(String languageKey);

    Flow<List<Language>> getInstalledLanguages();

    Flow<List<Language>> getLanguages();

    Flow<NeboNetworkState> getNeboNetworkDataState();

    boolean isDownloading();

    void removeGlobalDownloadCallback(GlobalDownloadsCallback callback);

    void removeLanguage(String languageKey);
}
