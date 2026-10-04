package com.myscript.nebo.dms.edit_new_folder;

import com.myscript.nebo.dms.core.FolderPropertiesValidator;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class FolderEditorViewModel$Factory$create$1 extends FunctionReferenceImpl implements Function2<CollectionKey, String, FolderPropertiesValidator.Status> {
    FolderEditorViewModel$Factory$create$1(Object obj) {
        super(2, obj, LibraryRepository.class, "validateFolder", "validateFolder(Lcom/myscript/snt/core/CollectionKey;Ljava/lang/String;)Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final FolderPropertiesValidator.Status invoke(CollectionKey collectionKey, String p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((LibraryRepository) this.receiver).validateFolder(collectionKey, p1);
    }
}
