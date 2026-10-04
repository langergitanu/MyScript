package com.myscript.nebo.dms.core.model;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.Collection;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001<B)\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0012\u0012\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\rJ\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020)J\u0012\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0003J\u0010\u00102\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010\u0003J\u0014\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u0000H\u0096\u0082\u0004J\n\u00105\u001a\u00020)H\u0096\u0080\u0004J\u0014\u00106\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000107H\u0096\u0082\u0004J\n\u00108\u001a\u00020\u0013H\u0096\u0080\u0004J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0017J\b\u0010:\u001a\u00020\tH\u0017J\b\u0010;\u001a\u00020\u0013H\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010,\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b/\u0010\u001f¨\u0006="}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/CollectionModel;", "", "Lcom/bignerdranch/expandablerecyclerview/model/Parent;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "collection", "Lcom/myscript/snt/dms/Collection;", "children", "", "hasTrashedChildren", "", "<init>", "(Lcom/myscript/snt/dms/Collection;Ljava/util/List;Z)V", "collectionModel", "(Lcom/myscript/nebo/dms/core/model/CollectionModel;)V", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "getCollectionKey", "()Lcom/myscript/snt/core/CollectionKey;", "name", "", "getName", "()Ljava/lang/String;", "value", "", "folderModels", "setFolderModels", "(Ljava/util/List;)V", "folders", "getFolders", "()Ljava/util/List;", "isExpanded", "()Z", "setExpanded", "(Z)V", "isSearch", "setSearch", "isTrashed", "clearNotebooks", "", "getFolder", FirebaseAnalytics.Param.INDEX, "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "notebookCount", "getNotebookCount", "()I", "isEmpty", "addNotebookItem", "folderModel", "removeFolderItem", "compareTo", "other", "hashCode", "equals", "", "toString", "getChildList", "isInitiallyExpanded", "getKey", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionModel implements Comparable<CollectionModel>, Parent<FolderModel> {
    private final CollectionKey collectionKey;
    private List<FolderModel> folderModels;
    private boolean isExpanded;
    private boolean isSearch;
    private final boolean isTrashed;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ CollectionModel(CollectionModel collectionModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(collectionModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollectionModel(Collection collection, List<FolderModel> children) {
        this(collection, children, false, 4, null);
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(children, "children");
    }

    @JvmStatic
    public static final CollectionModel copy(CollectionModel collectionModel) {
        return INSTANCE.copy(collectionModel);
    }

    public final CollectionKey getCollectionKey() {
        return this.collectionKey;
    }

    public final String getName() {
        return this.name;
    }

    private final void setFolderModels(List<FolderModel> list) {
        this.folderModels.clear();
        this.folderModels.addAll(list);
        CollectionsKt.sort(this.folderModels);
    }

    public final List<FolderModel> getFolders() {
        return this.folderModels;
    }

    /* JADX INFO: renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    /* JADX INFO: renamed from: isSearch, reason: from getter */
    public final boolean getIsSearch() {
        return this.isSearch;
    }

    public final void setSearch(boolean z) {
        this.isSearch = z;
    }

    /* JADX INFO: renamed from: isTrashed, reason: from getter */
    public final boolean getIsTrashed() {
        return this.isTrashed;
    }

    public CollectionModel(Collection collection, List<FolderModel> children, boolean z) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(children, "children");
        this.folderModels = new ArrayList();
        CollectionKey key = collection.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
        this.collectionKey = key;
        String name = collection.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.name = name;
        setFolderModels(CollectionsKt.toMutableList((java.util.Collection) children));
        boolean z2 = true;
        this.isExpanded = collection.isTrashed() || z;
        this.isSearch = false;
        if (!collection.isTrashed() && !z) {
            z2 = false;
        }
        this.isTrashed = z2;
    }

    public /* synthetic */ CollectionModel(Collection collection, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, list, (i & 4) != 0 ? false : z);
    }

    private CollectionModel(CollectionModel collectionModel) {
        this.folderModels = new ArrayList();
        this.collectionKey = collectionModel.collectionKey;
        this.name = collectionModel.name;
        setFolderModels(CollectionsKt.toMutableList((java.util.Collection) collectionModel.folderModels));
        this.isExpanded = collectionModel.isExpanded;
        this.isSearch = collectionModel.isSearch;
        this.isTrashed = collectionModel.isTrashed;
    }

    public final void clearNotebooks() {
        this.folderModels.clear();
    }

    public final FolderModel getFolder(int index) {
        return (FolderModel) CollectionsKt.getOrNull(this.folderModels, index);
    }

    public final FolderModel getFolder(NotebookKey notebookKey) {
        Object next;
        Iterator<T> it = this.folderModels.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((FolderModel) next).getNotebookKey(), notebookKey)) {
                break;
            }
        }
        return (FolderModel) next;
    }

    public final int getNotebookCount() {
        return this.folderModels.size();
    }

    public final boolean isEmpty() {
        return this.folderModels.isEmpty();
    }

    public final int addNotebookItem(FolderModel folderModel) {
        if (folderModel == null || this.folderModels.contains(folderModel)) {
            return -1;
        }
        this.folderModels.add(folderModel);
        CollectionsKt.sort(this.folderModels);
        return this.folderModels.indexOf(folderModel);
    }

    public final void removeFolderItem(FolderModel folderModel) {
        if (folderModel != null) {
            this.folderModels.remove(folderModel);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(CollectionModel other) {
        if (other == null) {
            return 1;
        }
        return Collator.getInstance().compare(this.name, other.name);
    }

    public int hashCode() {
        return this.collectionKey.hashCode();
    }

    public boolean equals(Object other) {
        CollectionKey collectionKey = this.collectionKey;
        CollectionModel collectionModel = other instanceof CollectionModel ? (CollectionModel) other : null;
        return Intrinsics.areEqual(collectionKey, collectionModel != null ? collectionModel.collectionKey : null);
    }

    public String toString() {
        return this.name;
    }

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    @Deprecated(message = "this is part of the {@link Parent} UI data model and shouldn't exposed by business logic model.")
    public List<FolderModel> getChildList() {
        return this.folderModels;
    }

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    @Deprecated(message = "this is part of the {@link Parent} UI data model and shouldn't exposed by business logic model.")
    public boolean isInitiallyExpanded() {
        return this.isExpanded;
    }

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    @Deprecated(message = "this is part of the {@link Parent} UI data model and shouldn't exposed by business logic model.")
    public String getKey() {
        String strSerialize = this.collectionKey.serialize();
        Intrinsics.checkNotNullExpressionValue(strSerialize, "serialize(...)");
        return strSerialize;
    }

    /* JADX INFO: compiled from: CollectionModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/CollectionModel$Companion;", "", "<init>", "()V", "copy", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "collectionModel", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CollectionModel copy(CollectionModel collectionModel) {
            Intrinsics.checkNotNullParameter(collectionModel, "collectionModel");
            return new CollectionModel(collectionModel, (DefaultConstructorMarker) null);
        }
    }
}
