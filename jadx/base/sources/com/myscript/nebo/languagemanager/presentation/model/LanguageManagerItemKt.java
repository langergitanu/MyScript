package com.myscript.nebo.languagemanager.presentation.model;

import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageManagerItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"toGroupingKey", "Lcom/myscript/nebo/languagemanager/presentation/model/GroupingKey;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "language-manager_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageManagerItemKt {
    public static final GroupingKey toGroupingKey(LanguageManagerItem.Lang lang) {
        Intrinsics.checkNotNullParameter(lang, "<this>");
        return new GroupingKey(lang.getInstalled(), lang.getSuggested() && !lang.getInstalled(), (lang.getInstalled() || lang.getSuggested()) ? false : true);
    }
}
