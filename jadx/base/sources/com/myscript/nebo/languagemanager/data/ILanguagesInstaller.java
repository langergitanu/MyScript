package com.myscript.nebo.languagemanager.data;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LanguagesInstaller.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/data/ILanguagesInstaller;", "", "installLanguages", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pendingLanguagesToInstall", "", "", "getPendingLanguagesToInstall", "()Ljava/util/List;", "destroy", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ILanguagesInstaller {
    void destroy();

    List<String> getPendingLanguagesToInstall();

    void installLanguages(CoroutineScope coroutineScope);
}
