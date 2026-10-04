package com.myscript.nebo.languagemanager.util;

import com.myscript.atk.resourcemanager.Language;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, m1599d2 = {"toLang", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "Lcom/myscript/atk/resourcemanager/Language;", "displayLanguage", "", "canDownLoad", "", "suggested", "language-manager_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageExtKt {
    public static final LanguageManagerItem.Lang toLang(Language language, String displayLanguage, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(language, "<this>");
        Intrinsics.checkNotNullParameter(displayLanguage, "displayLanguage");
        String languageKey = language.getLanguageKey();
        boolean zIsAvailable = language.isAvailable();
        Boolean boolIsUpToDate = language.isUpToDate();
        return new LanguageManagerItem.Lang(languageKey, displayLanguage, zIsAvailable, boolIsUpToDate != null ? boolIsUpToDate.booleanValue() : true, z, 0, 0, false, z2, false, PDFACompliance.e_PDFA7_3_6, null);
    }
}
