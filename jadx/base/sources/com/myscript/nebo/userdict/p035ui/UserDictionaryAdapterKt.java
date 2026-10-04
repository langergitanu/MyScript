package com.myscript.nebo.userdict.p035ui;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"USER_DICTIONARY_DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "getUSER_DICTIONARY_DIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "user-dictionary_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryAdapterKt {
    private static final DiffUtil.ItemCallback<UserDictionaryItem> USER_DICTIONARY_DIFF_CALLBACK = new DiffUtil.ItemCallback<UserDictionaryItem>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryAdapterKt$USER_DICTIONARY_DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(UserDictionaryItem oldItem, UserDictionaryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(UserDictionaryItem oldItem, UserDictionaryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public static final DiffUtil.ItemCallback<UserDictionaryItem> getUSER_DICTIONARY_DIFF_CALLBACK() {
        return USER_DICTIONARY_DIFF_CALLBACK;
    }
}
