package com.myscript.nebo.userdict.p035ui;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, m1599d2 = {"asUserDictionaryItems", "", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "", "user-dictionary_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryViewModelKt {
    public static final List<UserDictionaryItem> asUserDictionaryItems(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collator collator = Collator.getInstance(Locale.getDefault());
        Intrinsics.checkNotNull(collator);
        final Collator collator2 = collator;
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryViewModelKt$asUserDictionaryItems$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return collator2.compare((String) t, (String) t2);
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(new UserDictionaryItem((String) it.next()));
        }
        return arrayList;
    }
}
