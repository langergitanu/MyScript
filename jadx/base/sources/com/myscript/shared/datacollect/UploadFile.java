package com.myscript.shared.datacollect;

import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFile.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0086B¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/shared/datacollect/UploadFile;", "", "uploader", "Lcom/myscript/shared/datacollect/FileUploader;", "<init>", "(Lcom/myscript/shared/datacollect/FileUploader;)V", "invoke", "Lkotlin/Result;", "", "file", "Ljava/io/File;", SigningManager.POST_PARAMS_ALGORITHM, "", "ssoId", "userStatus", "uuid", "invoke-hUnOzRk", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UploadFile {
    private final FileUploader uploader;

    public UploadFile(FileUploader uploader) {
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        this.uploader = uploader;
    }

    /* JADX INFO: renamed from: invoke-hUnOzRk$default, reason: not valid java name */
    public static /* synthetic */ Object m13533invokehUnOzRk$default(UploadFile uploadFile, File file, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = null;
        }
        return uploadFile.m13534invokehUnOzRk(file, str, str2, str3, str4, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: invoke-hUnOzRk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m13534invokehUnOzRk(File file, String str, String str2, String str3, String str4, Continuation<? super Result<Unit>> continuation) {
        UploadFile$invoke$1 uploadFile$invoke$1;
        if (continuation instanceof UploadFile$invoke$1) {
            uploadFile$invoke$1 = (UploadFile$invoke$1) continuation;
            if ((uploadFile$invoke$1.label & Integer.MIN_VALUE) != 0) {
                uploadFile$invoke$1.label -= Integer.MIN_VALUE;
            } else {
                uploadFile$invoke$1 = new UploadFile$invoke$1(this, continuation);
            }
        }
        UploadFile$invoke$1 uploadFile$invoke$12 = uploadFile$invoke$1;
        Object obj = uploadFile$invoke$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = uploadFile$invoke$12.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = uploadFile$invoke$12.I$0;
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        File file2 = file.exists() ? file : null;
        if (file2 != null) {
            FileUploader fileUploader = this.uploader;
            uploadFile$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(file);
            uploadFile$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(str);
            uploadFile$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            uploadFile$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable(str3);
            uploadFile$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable(str4);
            uploadFile$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable(file2);
            uploadFile$invoke$12.I$0 = 0;
            uploadFile$invoke$12.label = 1;
            Object objMo13527invokehUnOzRk = fileUploader.mo13527invokehUnOzRk(file, str, str2, str3, str4, uploadFile$invoke$12);
            return objMo13527invokehUnOzRk == coroutine_suspended ? coroutine_suspended : objMo13527invokehUnOzRk;
        }
        Result.Companion companion = Result.INSTANCE;
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return Result.m14499constructorimpl(ResultKt.createFailure(new FilePathNotExists(path)));
    }
}
