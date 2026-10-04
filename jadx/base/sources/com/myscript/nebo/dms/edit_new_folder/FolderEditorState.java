package com.myscript.nebo.dms.edit_new_folder;

import com.myscript.nebo.dms.C6208R;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableMap;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.PersistentMap;

/* JADX INFO: compiled from: FolderEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\f\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003Jk\u0010'\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\f2\b\b\u0003\u0010\r\u001a\u00020\u00032\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0001J\u0014\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorState;", "", "dialogTitle", "", "dialogConfirmTitle", "isActionAllowed", "", "folderName", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "collectionNames", "Lkotlinx/collections/immutable/ImmutableMap;", "folderColor", "folderColors", "Lkotlinx/collections/immutable/ImmutableList;", "<init>", "(IIZLjava/lang/String;Lcom/myscript/snt/core/CollectionKey;Lkotlinx/collections/immutable/ImmutableMap;ILkotlinx/collections/immutable/ImmutableList;)V", "getDialogTitle", "()I", "getDialogConfirmTitle", "()Z", "getFolderName", "()Ljava/lang/String;", "getCollectionKey", "()Lcom/myscript/snt/core/CollectionKey;", "getCollectionNames", "()Lkotlinx/collections/immutable/ImmutableMap;", "getFolderColor", "getFolderColors", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FolderEditorState {
    public static final int $stable = 8;
    private final CollectionKey collectionKey;
    private final ImmutableMap<CollectionKey, String> collectionNames;
    private final int dialogConfirmTitle;
    private final int dialogTitle;
    private final int folderColor;
    private final ImmutableList<Integer> folderColors;
    private final String folderName;
    private final boolean isActionAllowed;

    public FolderEditorState() {
        this(0, 0, false, null, null, null, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FolderEditorState copy$default(FolderEditorState folderEditorState, int i, int i2, boolean z, String str, CollectionKey collectionKey, ImmutableMap immutableMap, int i3, ImmutableList immutableList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = folderEditorState.dialogTitle;
        }
        if ((i4 & 2) != 0) {
            i2 = folderEditorState.dialogConfirmTitle;
        }
        if ((i4 & 4) != 0) {
            z = folderEditorState.isActionAllowed;
        }
        if ((i4 & 8) != 0) {
            str = folderEditorState.folderName;
        }
        if ((i4 & 16) != 0) {
            collectionKey = folderEditorState.collectionKey;
        }
        if ((i4 & 32) != 0) {
            immutableMap = folderEditorState.collectionNames;
        }
        if ((i4 & 64) != 0) {
            i3 = folderEditorState.folderColor;
        }
        if ((i4 & 128) != 0) {
            immutableList = folderEditorState.folderColors;
        }
        int i5 = i3;
        ImmutableList immutableList2 = immutableList;
        CollectionKey collectionKey2 = collectionKey;
        ImmutableMap immutableMap2 = immutableMap;
        return folderEditorState.copy(i, i2, z, str, collectionKey2, immutableMap2, i5, immutableList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDialogTitle() {
        return this.dialogTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDialogConfirmTitle() {
        return this.dialogConfirmTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsActionAllowed() {
        return this.isActionAllowed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CollectionKey getCollectionKey() {
        return this.collectionKey;
    }

    public final ImmutableMap<CollectionKey, String> component6() {
        return this.collectionNames;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getFolderColor() {
        return this.folderColor;
    }

    public final ImmutableList<Integer> component8() {
        return this.folderColors;
    }

    public final FolderEditorState copy(int dialogTitle, int dialogConfirmTitle, boolean isActionAllowed, String folderName, CollectionKey collectionKey, ImmutableMap<CollectionKey, String> collectionNames, int folderColor, ImmutableList<Integer> folderColors) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(collectionNames, "collectionNames");
        Intrinsics.checkNotNullParameter(folderColors, "folderColors");
        return new FolderEditorState(dialogTitle, dialogConfirmTitle, isActionAllowed, folderName, collectionKey, collectionNames, folderColor, folderColors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderEditorState)) {
            return false;
        }
        FolderEditorState folderEditorState = (FolderEditorState) other;
        return this.dialogTitle == folderEditorState.dialogTitle && this.dialogConfirmTitle == folderEditorState.dialogConfirmTitle && this.isActionAllowed == folderEditorState.isActionAllowed && Intrinsics.areEqual(this.folderName, folderEditorState.folderName) && Intrinsics.areEqual(this.collectionKey, folderEditorState.collectionKey) && Intrinsics.areEqual(this.collectionNames, folderEditorState.collectionNames) && this.folderColor == folderEditorState.folderColor && Intrinsics.areEqual(this.folderColors, folderEditorState.folderColors);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.dialogTitle) * 31) + Integer.hashCode(this.dialogConfirmTitle)) * 31) + Boolean.hashCode(this.isActionAllowed)) * 31) + this.folderName.hashCode()) * 31) + this.collectionKey.hashCode()) * 31) + this.collectionNames.hashCode()) * 31) + Integer.hashCode(this.folderColor)) * 31) + this.folderColors.hashCode();
    }

    public String toString() {
        return "FolderEditorState(dialogTitle=" + this.dialogTitle + ", dialogConfirmTitle=" + this.dialogConfirmTitle + ", isActionAllowed=" + this.isActionAllowed + ", folderName=" + this.folderName + ", collectionKey=" + this.collectionKey + ", collectionNames=" + this.collectionNames + ", folderColor=" + this.folderColor + ", folderColors=" + this.folderColors + ")";
    }

    public FolderEditorState(int i, int i2, boolean z, String folderName, CollectionKey collectionKey, ImmutableMap<CollectionKey, String> collectionNames, int i3, ImmutableList<Integer> folderColors) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(collectionNames, "collectionNames");
        Intrinsics.checkNotNullParameter(folderColors, "folderColors");
        this.dialogTitle = i;
        this.dialogConfirmTitle = i2;
        this.isActionAllowed = z;
        this.folderName = folderName;
        this.collectionKey = collectionKey;
        this.collectionNames = collectionNames;
        this.folderColor = i3;
        this.folderColors = folderColors;
    }

    public /* synthetic */ FolderEditorState(int i, int i2, boolean z, String str, CollectionKey collectionKey, PersistentMap persistentMap, int i3, PersistentList persistentList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? C6208R.string.dialog_new_folder_title : i, (i4 & 2) != 0 ? C6208R.string.action_create_notebook : i2, (i4 & 4) != 0 ? false : z, (i4 & 8) != 0 ? "" : str, (i4 & 16) != 0 ? new CollectionKey() : collectionKey, (i4 & 32) != 0 ? ExtensionsKt.persistentMapOf() : persistentMap, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) != 0 ? FolderEditorViewModelKt.colors : persistentList);
    }

    public final int getDialogTitle() {
        return this.dialogTitle;
    }

    public final int getDialogConfirmTitle() {
        return this.dialogConfirmTitle;
    }

    public final boolean isActionAllowed() {
        return this.isActionAllowed;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final CollectionKey getCollectionKey() {
        return this.collectionKey;
    }

    public final ImmutableMap<CollectionKey, String> getCollectionNames() {
        return this.collectionNames;
    }

    public final int getFolderColor() {
        return this.folderColor;
    }

    public final ImmutableList<Integer> getFolderColors() {
        return this.folderColors;
    }
}
