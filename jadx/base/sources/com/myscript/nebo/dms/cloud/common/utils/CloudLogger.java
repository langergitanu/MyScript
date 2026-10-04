package com.myscript.nebo.dms.cloud.common.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: CloudLogger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/cloud/common/utils/CloudLogger;", "", "logMessage", "", "message", "", "logError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "dms-cloud-common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CloudLogger {
    void logError(Exception exception);

    void logMessage(String message);
}
