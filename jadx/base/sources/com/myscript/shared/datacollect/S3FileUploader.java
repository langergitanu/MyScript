package com.myscript.shared.datacollect;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.smithy.kotlin.runtime.content.ByteStreamJVMKt;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.Closeable;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: S3FileUploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ@\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0096B¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/shared/datacollect/S3FileUploader;", "Lcom/myscript/shared/datacollect/FileUploader;", "s3ClientConfig", "Lcom/myscript/shared/datacollect/S3ClientConfig;", "project", "", DeviceDimensionProvider.KEY_PLATFORM, "<init>", "(Lcom/myscript/shared/datacollect/S3ClientConfig;Ljava/lang/String;Ljava/lang/String;)V", "client", "Laws/sdk/kotlin/services/s3/S3Client;", "invoke", "Lkotlin/Result;", "", "file", "Ljava/io/File;", SigningManager.POST_PARAMS_ALGORITHM, "ssoId", "userStatus", "uuid", "invoke-hUnOzRk", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3FileUploader implements FileUploader {
    private final S3Client client;
    private final String platform;
    private final String project;
    private final S3ClientConfig s3ClientConfig;

    public S3FileUploader(S3ClientConfig s3ClientConfig, String project, String platform) {
        Intrinsics.checkNotNullParameter(s3ClientConfig, "s3ClientConfig");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.s3ClientConfig = s3ClientConfig;
        this.project = project;
        this.platform = platform;
        this.client = (S3Client) S3Client.INSTANCE.invoke(new Function1() { // from class: com.myscript.shared.datacollect.S3FileUploader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return S3FileUploader.client$lambda$0(this.f$0, (S3Client.Config.Builder) obj);
            }
        });
    }

    public /* synthetic */ S3FileUploader(S3ClientConfig s3ClientConfig, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(s3ClientConfig, str, (i & 4) != 0 ? "Android" : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit client$lambda$0(S3FileUploader s3FileUploader, S3Client.Config.Builder S3Client) {
        Intrinsics.checkNotNullParameter(S3Client, "$this$S3Client");
        S3Client.setRegion(s3FileUploader.s3ClientConfig.getRegion());
        S3Client.setCredentialsProvider(s3FileUploader.s3ClientConfig.getCredentials());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // com.myscript.shared.datacollect.FileUploader
    /* JADX INFO: renamed from: invoke-hUnOzRk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo13527invokehUnOzRk(final File file, final String str, final String str2, final String str3, final String str4, Continuation<? super Result<Unit>> continuation) {
        S3FileUploader$invoke$1 s3FileUploader$invoke$1;
        Throwable th;
        Closeable closeable;
        if (continuation instanceof S3FileUploader$invoke$1) {
            s3FileUploader$invoke$1 = (S3FileUploader$invoke$1) continuation;
            if ((s3FileUploader$invoke$1.label & Integer.MIN_VALUE) != 0) {
                s3FileUploader$invoke$1.label -= Integer.MIN_VALUE;
            } else {
                s3FileUploader$invoke$1 = new S3FileUploader$invoke$1(this, continuation);
            }
        }
        Object obj = s3FileUploader$invoke$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = s3FileUploader$invoke$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Result.Companion companion = Result.INSTANCE;
                S3FileUploader s3FileUploader = this;
                S3Client s3Client = this.client;
                try {
                    S3Client s3Client2 = s3Client;
                    PutObjectRequest putObjectRequestInvoke = PutObjectRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.shared.datacollect.S3FileUploader$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return S3FileUploader.invoke_hUnOzRk$lambda$0$0$0(this.f$0, file, str2, str, str3, str4, (PutObjectRequest.Builder) obj2);
                        }
                    });
                    s3FileUploader$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable(file);
                    s3FileUploader$invoke$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    s3FileUploader$invoke$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    s3FileUploader$invoke$1.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    s3FileUploader$invoke$1.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                    s3FileUploader$invoke$1.L$5 = SpillingKt.nullOutSpilledVariable(this);
                    s3FileUploader$invoke$1.L$6 = s3Client;
                    s3FileUploader$invoke$1.L$7 = SpillingKt.nullOutSpilledVariable(s3Client2);
                    s3FileUploader$invoke$1.I$0 = 0;
                    s3FileUploader$invoke$1.I$1 = 0;
                    s3FileUploader$invoke$1.label = 1;
                    if (s3Client2.putObject(putObjectRequestInvoke, s3FileUploader$invoke$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = s3Client;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = s3Client;
                    throw th;
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m14499constructorimpl(ResultKt.createFailure(th3));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = s3FileUploader$invoke$1.I$1;
            int i3 = s3FileUploader$invoke$1.I$0;
            closeable = (Closeable) s3FileUploader$invoke$1.L$6;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                try {
                    throw th;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th5;
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(closeable, null);
        return Result.m14499constructorimpl(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke_hUnOzRk$lambda$0$0$0(S3FileUploader s3FileUploader, File file, String str, String str2, String str3, String str4, PutObjectRequest.Builder PutObjectRequest) {
        Intrinsics.checkNotNullParameter(PutObjectRequest, "$this$PutObjectRequest");
        PutObjectRequest.setBucket(s3FileUploader.s3ClientConfig.getBucketName());
        PutObjectRequest.setKey(s3FileUploader.s3ClientConfig.getObjectKeyPath() + DomExceptionUtils.SEPARATOR + file.getName());
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        mapCreateMapBuilder.put("filename", name);
        mapCreateMapBuilder.put("userId", str);
        mapCreateMapBuilder.put(SigningManager.POST_PARAMS_ALGORITHM, str2);
        mapCreateMapBuilder.put("project", s3FileUploader.project);
        mapCreateMapBuilder.put(DeviceDimensionProvider.KEY_PLATFORM, s3FileUploader.platform);
        mapCreateMapBuilder.put("paidStatus", str3);
        if (str4 != null) {
            mapCreateMapBuilder.put("uuid", str4);
        }
        PutObjectRequest.setMetadata(MapsKt.build(mapCreateMapBuilder));
        PutObjectRequest.setBody(ByteStreamJVMKt.asByteStream$default(file, 0L, 0L, 3, (Object) null));
        return Unit.INSTANCE;
    }
}
