package com.myscript.nebo.dms.dialog;

import android.widget.Filter;
import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.dms.core.CollectionsManager;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.dialog.SimpleDMSViewModel;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FolderPickerDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, m1599d2 = {"com/myscript/nebo/dms/dialog/SimpleDMSViewModel$filterable$1$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "charSequence", "", "publishResults", "", "filterResults", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SimpleDMSViewModel$filterable$1$1 extends Filter {
    final /* synthetic */ SimpleDMSViewModel this$0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean performFiltering$lambda$0(FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    SimpleDMSViewModel$filterable$1$1(SimpleDMSViewModel simpleDMSViewModel) {
        this.this$0 = simpleDMSViewModel;
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        List<CollectionModel> filteredList;
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        if (charSequence.length() == 0) {
            SimpleDMSViewModel simpleDMSViewModel = this.this$0;
            filteredList = simpleDMSViewModel.getFilteredList(CollectionsManager.getCollectionModels$default(simpleDMSViewModel.repository, null, 1, null), new Function1() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$filterable$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SimpleDMSViewModel$filterable$1$1.performFiltering$lambda$0((FolderModel) obj));
                }
            });
        } else {
            String string = charSequence.toString();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            final String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            SimpleDMSViewModel simpleDMSViewModel2 = this.this$0;
            filteredList = simpleDMSViewModel2.getFilteredList(CollectionsManager.getCollectionModels$default(simpleDMSViewModel2.repository, null, 1, null), new Function1() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$filterable$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SimpleDMSViewModel$filterable$1$1.performFiltering$lambda$1(lowerCase, (FolderModel) obj));
                }
            });
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = filteredList;
        filterResults.count = filteredList.size();
        return filterResults;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean performFiltering$lambda$1(String str, FolderModel notebook) {
        Intrinsics.checkNotNullParameter(notebook, "notebook");
        String name = notebook.getName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null);
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(filterResults, "filterResults");
        if (filterResults.values != null) {
            MutableLiveData mutableLiveData = this.this$0._state;
            Object obj = filterResults.values;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.myscript.nebo.dms.core.model.CollectionModel>");
            mutableLiveData.setValue(new SimpleDMSViewModel.DMSState.Ready((List) obj));
        }
    }
}
