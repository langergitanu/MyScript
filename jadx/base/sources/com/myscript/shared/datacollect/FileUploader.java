package com.myscript.shared.datacollect;

import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FileUploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH¦B¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/FileUploader;", "", "invoke", "Lkotlin/Result;", "", "file", "Ljava/io/File;", SigningManager.POST_PARAMS_ALGORITHM, "", "ssoId", "userStatus", "uuid", "invoke-hUnOzRk", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface FileUploader {
    /* JADX INFO: renamed from: invoke-hUnOzRk, reason: not valid java name */
    Object mo13527invokehUnOzRk(File file, String str, String str2, String str3, String str4, Continuation<? super Result<Unit>> continuation);

    /* JADX INFO: compiled from: FileUploader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: invoke-hUnOzRk$default, reason: not valid java name */
    static /* synthetic */ Object m13526invokehUnOzRk$default(FileUploader fileUploader, File file, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke-hUnOzRk");
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        return fileUploader.mo13527invokehUnOzRk(file, str, str2, str3, str4, continuation);
    }
}
