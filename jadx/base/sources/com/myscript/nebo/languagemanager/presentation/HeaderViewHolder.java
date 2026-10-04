package com.myscript.nebo.languagemanager.presentation;

import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.languagemanager.C6611R;
import com.myscript.nebo.languagemanager.databinding.ItemHeaderBinding;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.myscript.nebo.languagemanager.presentation.model.SectionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/myscript/nebo/languagemanager/databinding/ItemHeaderBinding;", "<init>", "(Lcom/myscript/nebo/languagemanager/databinding/ItemHeaderBinding;)V", "bind", "", "section", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Section;", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeaderViewHolder extends RecyclerView.ViewHolder {
    private final ItemHeaderBinding binding;

    /* JADX INFO: compiled from: LanguageAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            try {
                iArr[SectionType.SUGGESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SectionType.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SectionType.AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderViewHolder(ItemHeaderBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(LanguageManagerItem.Section section) {
        int i;
        Intrinsics.checkNotNullParameter(section, "section");
        int i2 = WhenMappings.$EnumSwitchMapping$0[section.getSectionType().ordinal()];
        if (i2 == 1) {
            i = C6611R.plurals.resourcemanager_suggested_section_title;
        } else if (i2 == 2) {
            i = C6611R.plurals.resourcemanager_installed_section_title;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = C6611R.plurals.resourcemanager_available_section_title;
        }
        this.binding.txtHeaderTitle.setText(this.itemView.getContext().getResources().getQuantityString(i, section.getNumber(), Integer.valueOf(section.getNumber())));
    }
}
