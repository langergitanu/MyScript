package com.myscript.nebo.cloudsync;

import com.myscript.nebo.dms.cloud.common.utils.CloudLogger;
import com.myscript.nebo.dms.dropbox.DropboxCallback;
import com.myscript.nebo.dms.gdrive.GDriveCallback;
import com.myscript.snt.dms.DMSLogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\n"}, m1599d2 = {"com/myscript/nebo/cloudsync/CloudManagerImpl$cloudLogger$1", "Lcom/myscript/nebo/dms/cloud/common/utils/CloudLogger;", "logMessage", "", "message", "", "logError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloudManagerImpl$cloudLogger$1 implements CloudLogger {
    final /* synthetic */ CloudManagerImpl this$0;

    CloudManagerImpl$cloudLogger$1(CloudManagerImpl cloudManagerImpl) {
        this.this$0 = cloudManagerImpl;
    }

    @Override // com.myscript.nebo.dms.cloud.common.utils.CloudLogger
    public void logMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.this$0.getTechnicalLogger().logTrace(message);
    }

    @Override // com.myscript.nebo.dms.cloud.common.utils.CloudLogger
    public void logError(Exception exception) {
        DMSLogLevel dMSLogLevelErrorLevelForException;
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.this$0.getTechnicalLogger().setKeyValue("name", this.this$0.getProviderName());
        String message = exception.getMessage();
        if (message == null) {
            Throwable cause = exception.getCause();
            message = cause != null ? cause.getMessage() : null;
            if (message == null) {
                message = "";
            }
        }
        DropboxCallback dropboxCallback = this.this$0.dropboxCallback;
        if (dropboxCallback == null || (dMSLogLevelErrorLevelForException = dropboxCallback.errorLevelFromException(exception)) == null) {
            GDriveCallback gDriveCallback = this.this$0.gdriveCallback;
            dMSLogLevelErrorLevelForException = gDriveCallback != null ? gDriveCallback.errorLevelForException(exception) : DMSLogLevel.ERR;
        }
        if (dMSLogLevelErrorLevelForException != DMSLogLevel.WARNING || message.length() <= 0) {
            this.this$0.getTechnicalLogger().logError(exception);
        } else {
            this.this$0.getTechnicalLogger().logTrace(message);
        }
    }
}
