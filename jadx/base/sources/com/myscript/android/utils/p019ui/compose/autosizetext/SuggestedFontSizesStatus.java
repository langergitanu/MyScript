package com.myscript.android.utils.p019ui.compose.autosizetext;

import androidx.compose.p004ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AutoSizeText.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m1599d2 = {"Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;", "", "<init>", "(Ljava/lang/String;I)V", "VALID", "INVALID", "UNKNOWN", "Companion", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SuggestedFontSizesStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SuggestedFontSizesStatus[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final SuggestedFontSizesStatus VALID = new SuggestedFontSizesStatus("VALID", 0);
    public static final SuggestedFontSizesStatus INVALID = new SuggestedFontSizesStatus("INVALID", 1);
    public static final SuggestedFontSizesStatus UNKNOWN = new SuggestedFontSizesStatus("UNKNOWN", 2);

    private static final /* synthetic */ SuggestedFontSizesStatus[] $values() {
        return new SuggestedFontSizesStatus[]{VALID, INVALID, UNKNOWN};
    }

    public static EnumEntries<SuggestedFontSizesStatus> getEntries() {
        return $ENTRIES;
    }

    public static SuggestedFontSizesStatus valueOf(String str) {
        return (SuggestedFontSizesStatus) Enum.valueOf(SuggestedFontSizesStatus.class, str);
    }

    public static SuggestedFontSizesStatus[] values() {
        return (SuggestedFontSizesStatus[]) $VALUES.clone();
    }

    private SuggestedFontSizesStatus(String str, int i) {
    }

    static {
        SuggestedFontSizesStatus[] suggestedFontSizesStatusArr$values = $values();
        $VALUES = suggestedFontSizesStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(suggestedFontSizesStatusArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: AutoSizeText.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus$Companion;", "", "<init>", "()V", "suggestedFontSizesStatus", "Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;", "", "Landroidx/compose/ui/unit/TextUnit;", "getSuggestedFontSizesStatus", "(Ljava/util/List;)Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;", "validSuggestedFontSizes", "getValidSuggestedFontSizes", "(Ljava/util/List;)Ljava/util/List;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SuggestedFontSizesStatus getSuggestedFontSizesStatus(List<TextUnit> list) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            List<TextUnit> list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (!TextUnit.m11214isSpimpl(list.get(i).getPackedValue())) {
                            break;
                        }
                        i++;
                    } else if (Intrinsics.areEqual(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.myscript.android.utils.ui.compose.autosizetext.SuggestedFontSizesStatus$Companion$special$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Float.valueOf(TextUnit.m11211getValueimpl(((TextUnit) t).getPackedValue())), Float.valueOf(TextUnit.m11211getValueimpl(((TextUnit) t2).getPackedValue())));
                        }
                    }), list)) {
                        return SuggestedFontSizesStatus.VALID;
                    }
                }
            }
            return SuggestedFontSizesStatus.INVALID;
        }

        public final List<TextUnit> getValidSuggestedFontSizes(List<TextUnit> list) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TextUnit textUnit = list.get(i);
                    if (TextUnit.m11214isSpimpl(textUnit.getPackedValue())) {
                        arrayList.add(textUnit);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.isEmpty()) {
                    arrayList2 = null;
                }
                if (arrayList2 != null) {
                    return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.myscript.android.utils.ui.compose.autosizetext.SuggestedFontSizesStatus$Companion$special$$inlined$sortedBy$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Float.valueOf(TextUnit.m11211getValueimpl(((TextUnit) t).getPackedValue())), Float.valueOf(TextUnit.m11211getValueimpl(((TextUnit) t2).getPackedValue())));
                        }
                    });
                }
            }
            return null;
        }
    }
}
