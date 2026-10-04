package com.myscript.nebo.languagemanager.util;

import com.myscript.atk.resourcemanager.Language;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAvailabilityComparator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/util/LanguageAvailabilityComparator;", "Ljava/util/Comparator;", "Lcom/myscript/atk/resourcemanager/Language;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "l1", "l2", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageAvailabilityComparator implements Comparator<Language> {
    public static final LanguageAvailabilityComparator INSTANCE = new LanguageAvailabilityComparator();

    private LanguageAvailabilityComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Language l1, Language l2) {
        Intrinsics.checkNotNullParameter(l1, "l1");
        Intrinsics.checkNotNullParameter(l2, "l2");
        boolean zIsAvailable = l1.isAvailable();
        if (zIsAvailable == l2.isAvailable()) {
            return l1.getDisplayName().compareTo(l2.getDisplayName());
        }
        return zIsAvailable ? -1 : 1;
    }
}
