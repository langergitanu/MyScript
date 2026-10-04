package com.myscript.snt.dms;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ICloudDriveInterface {
    CloudFileIdRev createFile(CloudCreateFileRequest cloudCreateFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, boolean z);

    BatchResult createFiles(SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler);

    String createFolder(CloudCreateFolderRequest cloudCreateFolderRequest);

    BatchResult createFolders(SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler);

    void deleteFile(CloudFile cloudFile);

    void deleteFolder(CloudFile cloudFile);

    void downloadFile(CloudFileRequest cloudFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler);

    BatchResult downloadFiles(SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler);

    boolean exists(String str);

    String getId(String str);

    String getProfileId();

    String getRevision(CloudFile cloudFile);

    String getV1RootPath();

    String getV2RootPath();

    void initializeV2();

    boolean isCloudEnabled();

    boolean isV2Initialized();

    List<CloudFileData> list(CloudFile cloudFile, boolean z);

    String uploadFile(CloudUploadFileRequest cloudUploadFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler);

    BatchResult uploadFiles(SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler);
}
