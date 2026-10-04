package com.myscript.nebo.dms.gdrive.api;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.About;
import com.google.api.services.drive.model.User;
import com.myscript.nebo.dms.cloud.common.api.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetInfo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"getAccountInfo", "Lcom/myscript/nebo/dms/cloud/common/api/AccountInfo;", "Lcom/google/api/services/drive/Drive;", "dms-gdrive_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetInfoKt {
    public static final AccountInfo getAccountInfo(Drive drive) {
        About.StorageQuota storageQuota;
        Long usageInDrive;
        About.StorageQuota storageQuota2;
        Long limit;
        User user;
        Intrinsics.checkNotNullParameter(drive, "<this>");
        About aboutExecute = drive.about().get().setFields2("user(displayName, emailAddress), storageQuota(limit, usage, usageInDrive, usageInDriveTrash)").execute();
        String emailAddress = null;
        if (aboutExecute == null) {
            aboutExecute = null;
        }
        if (aboutExecute != null && (user = aboutExecute.getUser()) != null) {
            emailAddress = user.getEmailAddress();
        }
        String str = emailAddress;
        long jLongValue = 0;
        long jLongValue2 = (aboutExecute == null || (storageQuota2 = aboutExecute.getStorageQuota()) == null || (limit = storageQuota2.getLimit()) == null) ? 0L : limit.longValue();
        if (aboutExecute != null && (storageQuota = aboutExecute.getStorageQuota()) != null && (usageInDrive = storageQuota.getUsageInDrive()) != null) {
            jLongValue = usageInDrive.longValue();
        }
        return new AccountInfo(str, jLongValue2, jLongValue);
    }
}
