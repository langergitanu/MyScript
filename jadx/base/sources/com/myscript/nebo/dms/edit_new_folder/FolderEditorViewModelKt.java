package com.myscript.nebo.dms.edit_new_folder;

import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.core.FolderPropertiesValidator;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: FolderEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"colors", "Lkotlinx/collections/immutable/PersistentList;", "", "isActionAllowed", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "folderName", "", "validate", "Lkotlin/Function2;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "dms_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderEditorViewModelKt {
    private static final PersistentList<Integer> colors = ExtensionsKt.persistentListOf(Integer.valueOf(C6183R.color.coverColorPurple), Integer.valueOf(C6183R.color.coverColorMagenta), Integer.valueOf(C6183R.color.coverColorCobalt), Integer.valueOf(C6183R.color.coverColorCyan), Integer.valueOf(C6183R.color.coverColorEmerald), Integer.valueOf(C6183R.color.coverColorOlive), Integer.valueOf(C6183R.color.coverColorCorn), Integer.valueOf(C6183R.color.coverColorOrange), Integer.valueOf(C6183R.color.coverColorRaspberry));

    public static final boolean isActionAllowed(CollectionKey collectionKey, String folderName, Function2<? super CollectionKey, ? super String, ? extends FolderPropertiesValidator.Status> validate) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(validate, "validate");
        return validate.invoke(collectionKey, folderName) instanceof FolderPropertiesValidator.Status.Valid;
    }
}
