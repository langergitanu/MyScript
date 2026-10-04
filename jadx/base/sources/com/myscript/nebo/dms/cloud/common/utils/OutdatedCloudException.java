package com.myscript.nebo.dms.cloud.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutdatedCloudException.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/cloud/common/utils/OutdatedCloudException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "dms-cloud-common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OutdatedCloudException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutdatedCloudException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
