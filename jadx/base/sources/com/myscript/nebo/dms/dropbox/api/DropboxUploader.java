package com.myscript.nebo.dms.dropbox.api;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.dms.cloud.common.api.ProgressListener;
import com.myscript.nebo.dms.cloud.common.api.Uploader;
import com.myscript.nebo.dms.dropbox.DropboxClient;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: DropboxUploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u001c\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/DropboxUploader;", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader;", "<init>", "()V", NotificationCompat.CATEGORY_SERVICE, "Lcom/dropbox/core/v2/DbxClientV2;", "kotlin.jvm.PlatformType", "getService", "()Lcom/dropbox/core/v2/DbxClientV2;", "cancel", "", "upload", "", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadResult;", "uploadItems", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/dms/cloud/common/api/ProgressListener;", "uploadHTTP", "progressListener", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DropboxUploader extends Uploader {
    @Override // com.myscript.nebo.dms.cloud.common.api.Cancelable
    public void cancel() {
    }

    private final DbxClientV2 getService() {
        return DropboxClient.getInstance();
    }

    @Override // com.myscript.nebo.dms.cloud.common.api.Uploader
    public List<Uploader.UploadResult> upload(List<? extends Uploader.UploadItem> uploadItems, ProgressListener listener) throws JSONException, DbxException, IOException {
        Intrinsics.checkNotNullParameter(uploadItems, "uploadItems");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return uploadHTTP(uploadItems, listener);
    }

    private final List<Uploader.UploadResult> uploadHTTP(List<? extends Uploader.UploadItem> uploadItems, ProgressListener progressListener) throws JSONException, DbxException {
        UploadHTTP uploadHTTP = UploadHTTP.INSTANCE;
        DbxClientV2 service = getService();
        Intrinsics.checkNotNullExpressionValue(service, "<get-service>(...)");
        return uploadHTTP.uploadFiles(service, uploadItems, progressListener);
    }
}
