package com.myscript.nebo.languagemanager.presentation;

import androidx.recyclerview.widget.DiffUtil;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"LANGUAGE_DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "getLANGUAGE_DIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "language-manager_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageAdapterKt {
    private static final DiffUtil.ItemCallback<LanguageManagerItem> LANGUAGE_DIFF_CALLBACK = new DiffUtil.ItemCallback<LanguageManagerItem>() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageAdapterKt$LANGUAGE_DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(LanguageManagerItem oldItem, LanguageManagerItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getType() == 0 && newItem.getType() == 0) {
                return true;
            }
            if (oldItem.getType() == 1 && newItem.getType() == 1) {
                return ((LanguageManagerItem.Section) oldItem).getSectionType() == ((LanguageManagerItem.Section) newItem).getSectionType();
            }
            if (oldItem.getType() == 2 && newItem.getType() == 2) {
                return Intrinsics.areEqual(((LanguageManagerItem.Lang) oldItem).getKey(), ((LanguageManagerItem.Lang) newItem).getKey());
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(LanguageManagerItem oldItem, LanguageManagerItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getType() == 0 && newItem.getType() == 0) {
                return true;
            }
            if (oldItem.getType() == 1 && newItem.getType() == 1) {
                return ((LanguageManagerItem.Section) oldItem).getNumber() == ((LanguageManagerItem.Section) newItem).getNumber();
            }
            if (oldItem.getType() == 2 && newItem.getType() == 2) {
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) oldItem;
                LanguageManagerItem.Lang lang2 = (LanguageManagerItem.Lang) newItem;
                if (lang.getProgress() == lang2.getProgress() && lang.getMax() == lang2.getMax() && lang.isDownloadable() == lang2.isDownloadable() && lang.isUpToDate() == lang2.isUpToDate() && lang.getPending() == lang2.getPending() && lang.getInstalled() == lang2.getInstalled() && lang.isSelected() == lang2.isSelected()) {
                    return true;
                }
            }
            return false;
        }
    };

    public static final DiffUtil.ItemCallback<LanguageManagerItem> getLANGUAGE_DIFF_CALLBACK() {
        return LANGUAGE_DIFF_CALLBACK;
    }
}
