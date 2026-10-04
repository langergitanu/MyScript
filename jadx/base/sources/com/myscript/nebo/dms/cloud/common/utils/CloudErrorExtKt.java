package com.myscript.nebo.dms.cloud.common.utils;

import com.myscript.snt.dms.CloudError;
import com.myscript.snt.dms.CloudErrorType;
import java.io.IOException;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudErrorExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"asCloudError", "Lcom/myscript/snt/dms/CloudError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getAsCloudError", "(Ljava/lang/Exception;)Lcom/myscript/snt/dms/CloudError;", "asException", "getAsException", "(Lcom/myscript/snt/dms/CloudError;)Ljava/lang/Exception;", "dms-cloud-common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloudErrorExtKt {

    /* JADX INFO: compiled from: CloudErrorExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloudErrorType.values().length];
            try {
                iArr[CloudErrorType.INVALID_ARGUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloudErrorType.UNSUPPORTED_CLOUD_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloudErrorType.ALREADY_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CloudErrorType.NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CloudErrorType.ACTION_CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final CloudError getAsCloudError(Exception exc) {
        CloudErrorType cloudErrorType;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof CloudError) {
            return (CloudError) exc;
        }
        if (exc instanceof IllegalArgumentException) {
            cloudErrorType = CloudErrorType.INVALID_ARGUMENT;
        } else {
            boolean z = exc instanceof IllegalStateException;
            if (z && Intrinsics.areEqual(exc.getMessage(), "Unsupported Cloud Version")) {
                cloudErrorType = CloudErrorType.UNSUPPORTED_CLOUD_VERSION;
            } else if (z) {
                cloudErrorType = CloudErrorType.ALREADY_EXISTS;
            } else if (exc instanceof NoSuchElementException) {
                cloudErrorType = CloudErrorType.NOT_FOUND;
            } else {
                cloudErrorType = ((exc instanceof IOException) && Intrinsics.areEqual(exc.getMessage(), "Canceled")) ? CloudErrorType.ACTION_CANCELED : CloudErrorType.ACTION_FAILED;
            }
        }
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        return new CloudError(cloudErrorType, message);
    }

    public static final Exception getAsException(CloudError cloudError) {
        Intrinsics.checkNotNullParameter(cloudError, "<this>");
        CloudErrorType errorId = cloudError.getErrorId();
        int i = errorId == null ? -1 : WhenMappings.$EnumSwitchMapping$0[errorId.ordinal()];
        if (i == 1) {
            return new IllegalArgumentException(cloudError.getMessage());
        }
        if (i == 2) {
            return new IllegalStateException("Unsupported Cloud Version");
        }
        if (i == 3) {
            return new IllegalStateException(cloudError.getMessage());
        }
        if (i == 4) {
            return new NoSuchElementException(cloudError.getMessage());
        }
        if (i == 5) {
            return new IOException("Canceled");
        }
        return new RuntimeException(cloudError.getMessage());
    }
}
