package com.myscript.nebo.dms.dropbox;

import com.dropbox.core.p013v2.files.DeletedMetadata;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.FolderMetadata;
import com.dropbox.core.p013v2.files.GetMetadataErrorException;
import com.myscript.snt.dms.CloudFileData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropboxCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\u0004*\u00060\nj\u0002`\u000b\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e¨\u0006\u000f"}, m1599d2 = {"toFileMetadata", "Lcom/dropbox/core/v2/files/FileMetadata;", "Lcom/dropbox/core/v2/files/Metadata;", "isFolder", "", "toFolderMetadata", "Lcom/dropbox/core/v2/files/FolderMetadata;", "toDeletedMetadata", "Lcom/dropbox/core/v2/files/DeletedMetadata;", "isNotFound", "Ljava/lang/Exception;", "Lkotlin/Exception;", "parent", "", "Lcom/myscript/snt/dms/CloudFileData;", "dms-dropbox_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DropboxCallbackKt {
    public static final FileMetadata toFileMetadata(com.dropbox.core.p013v2.files.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "<this>");
        if (metadata instanceof FileMetadata) {
            return (FileMetadata) metadata;
        }
        return null;
    }

    public static final boolean isFolder(com.dropbox.core.p013v2.files.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "<this>");
        return metadata instanceof FolderMetadata;
    }

    public static final FolderMetadata toFolderMetadata(com.dropbox.core.p013v2.files.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "<this>");
        if (metadata instanceof FolderMetadata) {
            return (FolderMetadata) metadata;
        }
        return null;
    }

    public static final DeletedMetadata toDeletedMetadata(com.dropbox.core.p013v2.files.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "<this>");
        if (metadata instanceof DeletedMetadata) {
            return (DeletedMetadata) metadata;
        }
        return null;
    }

    public static final boolean isNotFound(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        return (exc instanceof GetMetadataErrorException) && ((GetMetadataErrorException) exc).errorValue.getPathValue().isNotFound();
    }

    public static final String parent(CloudFileData cloudFileData) {
        Intrinsics.checkNotNullParameter(cloudFileData, "<this>");
        return new File(cloudFileData.path()).getParent();
    }
}
