package com.myscript.shared.datacollect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myscript.shared.datacollect.DataCollect;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlin.sequences.SequencesKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: DataCollect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002\u001f B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJN\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010JJ\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollect;", "Lcom/myscript/shared/datacollect/IDataCollect;", "cacheProvider", "Lcom/myscript/shared/datacollect/ICacheProvider;", "s3Uploader", "Lcom/myscript/shared/datacollect/S3Uploader;", "telemetry", "Lcom/myscript/shared/datacollect/IDataCollectTelemetry;", "project", "", DeviceDimensionProvider.KEY_PLATFORM, "<init>", "(Lcom/myscript/shared/datacollect/ICacheProvider;Lcom/myscript/shared/datacollect/S3Uploader;Lcom/myscript/shared/datacollect/IDataCollectTelemetry;Ljava/lang/String;Ljava/lang/String;)V", "sendFileForDataCollect", "", "file", "Ljava/io/File;", "ssoId", "appVersion", "uuid", "lastModificationDate", "", "title", "userStatus", "creationDate", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "calculateSHA256", "buildZipToCollect", "Provider", "Companion", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DataCollect implements IDataCollect {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ICacheProvider cacheProvider;
    private final Gson gson;
    private final String platform;
    private final String project;
    private final S3Uploader s3Uploader;
    private final IDataCollectTelemetry telemetry;

    /* JADX INFO: compiled from: DataCollect.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollect$Provider;", "", "provideDataCollect", "Lcom/myscript/shared/datacollect/DataCollect;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        DataCollect provideDataCollect();
    }

    /* JADX INFO: renamed from: com.myscript.shared.datacollect.DataCollect$sendFileForDataCollect$1 */
    /* JADX INFO: compiled from: DataCollect.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.shared.datacollect.DataCollect", m1609f = "DataCollect.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {124}, m1612m = "sendFileForDataCollect", m1613n = {"file", "ssoId", "appVersion", "uuid", "title", "userStatus", "zipToCollect", "lastModificationDate", "creationDate"}, m1614nl = {WebSocketProtocol.PAYLOAD_SHORT}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1"}, m1616v = 2)
    static final class C69121 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C69121(Continuation<? super C69121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataCollect.this.sendFileForDataCollect(null, null, null, null, 0L, null, null, 0L, this);
        }
    }

    public DataCollect(ICacheProvider cacheProvider, S3Uploader s3Uploader, IDataCollectTelemetry telemetry, String project, String platform) {
        Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
        Intrinsics.checkNotNullParameter(s3Uploader, "s3Uploader");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.cacheProvider = cacheProvider;
        this.s3Uploader = s3Uploader;
        this.telemetry = telemetry;
        this.project = project;
        this.platform = platform;
        this.gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }

    public /* synthetic */ DataCollect(ICacheProvider iCacheProvider, S3Uploader s3Uploader, IDataCollectTelemetry iDataCollectTelemetry, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iCacheProvider, s3Uploader, iDataCollectTelemetry, str, (i & 16) != 0 ? "Android" : str2);
    }

    /* JADX INFO: compiled from: DataCollect.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0086\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2D\b\u0002\u0010\r\u001a>\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000e2\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00140\u0016¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollect$Companion;", "", "<init>", "()V", "create", "Lcom/myscript/shared/datacollect/DataCollect;", "httpClient", "Lokhttp3/OkHttpClient;", "backendUrl", "", "cacheDir", "Ljava/io/File;", "project", "onEvent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "eventName", "", "params", "", "onException", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final File create$lambda$2(File file) {
            return file;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataCollect create$default(Companion companion, OkHttpClient okHttpClient, String str, File file, String str2, Function2 function2, Function1 function1, int i, Object obj) {
            if ((i & 16) != 0) {
                function2 = new Function2() { // from class: com.myscript.shared.datacollect.DataCollect$Companion$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DataCollect.Companion.create$lambda$0((String) obj2, (Map) obj3);
                    }
                };
            }
            Function2 function22 = function2;
            if ((i & 32) != 0) {
                function1 = new Function1() { // from class: com.myscript.shared.datacollect.DataCollect$Companion$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DataCollect.Companion.create$lambda$1((Exception) obj2);
                    }
                };
            }
            return companion.create(okHttpClient, str, file, str2, function22, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit create$lambda$0(String str, Map map) {
            Intrinsics.checkNotNullParameter(str, "<unused var>");
            Intrinsics.checkNotNullParameter(map, "<unused var>");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit create$lambda$1(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "<unused var>");
            return Unit.INSTANCE;
        }

        public final DataCollect create(OkHttpClient httpClient, String backendUrl, final File cacheDir, String project, final Function2<? super String, ? super Map<String, String>, Unit> onEvent, final Function1<? super Exception, Unit> onException) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            Intrinsics.checkNotNullParameter(backendUrl, "backendUrl");
            Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
            Intrinsics.checkNotNullParameter(project, "project");
            Intrinsics.checkNotNullParameter(onEvent, "onEvent");
            Intrinsics.checkNotNullParameter(onException, "onException");
            DataCollectApi dataCollectApiBuild = DataCollectApi.INSTANCE.build(httpClient, backendUrl);
            IDataCollectTelemetry iDataCollectTelemetry = new IDataCollectTelemetry() { // from class: com.myscript.shared.datacollect.DataCollect$Companion$create$telemetry$1
                @Override // com.myscript.shared.datacollect.IDataCollectTelemetry
                public void logEvent(String eventName, Map<String, String> params) {
                    Intrinsics.checkNotNullParameter(eventName, "eventName");
                    Intrinsics.checkNotNullParameter(params, "params");
                    onEvent.invoke(eventName, params);
                }

                @Override // com.myscript.shared.datacollect.IDataCollectTelemetry
                public void logException(Exception exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    onException.invoke(exception);
                }
            };
            return new DataCollect(new ICacheProvider() { // from class: com.myscript.shared.datacollect.DataCollect$Companion$$ExternalSyntheticLambda0
                @Override // com.myscript.shared.datacollect.ICacheProvider
                public final File getCacheDir() {
                    return DataCollect.Companion.create$lambda$2(cacheDir);
                }
            }, new S3Uploader(new DataCollect$Companion$create$credentialProvider$1(dataCollectApiBuild), iDataCollectTelemetry, project, null, 8, null), iDataCollectTelemetry, project, null, 16, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // com.myscript.shared.datacollect.IDataCollect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendFileForDataCollect(File file, String str, String str2, String str3, long j, String str4, String str5, long j2, Continuation<? super Boolean> continuation) {
        C69121 c69121;
        File file2;
        if (continuation instanceof C69121) {
            c69121 = (C69121) continuation;
            if ((c69121.label & Integer.MIN_VALUE) != 0) {
                c69121.label -= Integer.MIN_VALUE;
            } else {
                c69121 = new C69121(continuation);
            }
        }
        C69121 c691212 = c69121;
        Object objUploadFile$default = c691212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c691212.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUploadFile$default);
                if (!file.isFile()) {
                    return Boxing.boxBoolean(false);
                }
                File fileBuildZipToCollect = buildZipToCollect(file, str, str2, str3, j, str4, str5, j2);
                if (fileBuildZipToCollect == null) {
                    this.telemetry.logEvent(DataCollectAnalyticsEvents.COLLECT_FAILED, MapsKt.mapOf(TuplesKt.m1606to("type", DataCollectAnalyticsEvents.COLLECT_ZIP_CREATION_ERROR)));
                    return Boxing.boxBoolean(false);
                }
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileBuildZipToCollect));
                try {
                    final ZipInputStream zipInputStream2 = zipInputStream;
                    System.out.println((Object) ("DataCollect: ZIP=" + fileBuildZipToCollect.getName() + " entries=" + SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(new Function0() { // from class: com.myscript.shared.datacollect.DataCollect$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return zipInputStream2.getNextEntry();
                        }
                    }), new Function1() { // from class: com.myscript.shared.datacollect.DataCollect$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DataCollect.sendFileForDataCollect$lambda$0$1((ZipEntry) obj);
                        }
                    }))));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipInputStream, null);
                    S3Uploader s3Uploader = this.s3Uploader;
                    c691212.L$0 = SpillingKt.nullOutSpilledVariable(file);
                    c691212.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c691212.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    c691212.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    c691212.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                    c691212.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                    c691212.L$6 = fileBuildZipToCollect;
                    c691212.J$0 = j;
                    c691212.J$1 = j2;
                    c691212.label = 1;
                    objUploadFile$default = S3Uploader.uploadFile$default(s3Uploader, fileBuildZipToCollect, str, str5, null, str3, c691212, 8, null);
                    if (objUploadFile$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    file2 = fileBuildZipToCollect;
                } finally {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j3 = c691212.J$1;
                long j4 = c691212.J$0;
                file2 = (File) c691212.L$6;
                ResultKt.throwOnFailure(objUploadFile$default);
            }
            boolean zBooleanValue = ((Boolean) objUploadFile$default).booleanValue();
            if (zBooleanValue) {
                IDataCollectTelemetry.logEvent$default(this.telemetry, DataCollectAnalyticsEvents.COLLECT_SUCCEED, null, 2, null);
            } else {
                this.telemetry.logEvent(DataCollectAnalyticsEvents.COLLECT_FAILED, MapsKt.mapOf(TuplesKt.m1606to("type", DataCollectAnalyticsEvents.COLLECT_SEND_FAILED)));
            }
            file2.delete();
            return Boxing.boxBoolean(zBooleanValue);
        } catch (Exception e) {
            this.telemetry.logException(new IllegalStateException("DataCollect: DC upload failed: \n" + e));
            this.telemetry.logEvent(DataCollectAnalyticsEvents.COLLECT_FAILED, MapsKt.mapOf(TuplesKt.m1606to("type", "crash")));
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendFileForDataCollect$lambda$0$1(ZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    public final String calculateSHA256(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return ZipUtils.INSTANCE.calculateSHA256(file);
    }

    private final File buildZipToCollect(File file, String ssoId, String appVersion, String uuid, long lastModificationDate, String title, String userStatus, long creationDate) {
        String str = this.platform;
        String str2 = this.project;
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String strCalculateSHA256 = calculateSHA256(file);
        if (strCalculateSHA256 == null) {
            strCalculateSHA256 = "";
        }
        String json = this.gson.toJson(new DataCollectUserData(language, str2, str, appVersion, ssoId, strCalculateSHA256, uuid, lastModificationDate, creationDate, title, userStatus));
        File file2 = new File(this.cacheProvider.getCacheDir(), "datacollect");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, "metadata_" + uuid + ".json");
        try {
            FileWriter fileWriter = new FileWriter(file3);
            try {
                fileWriter.write(json);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileWriter, null);
                File fileCreateZipArchive = ZipUtils.INSTANCE.createZipArchive(this.cacheProvider.getCacheDir(), CollectionsKt.listOf((Object[]) new File[]{file, file3}), "datacollect_" + uuid + "_" + lastModificationDate + ".zip");
                file3.delete();
                return fileCreateZipArchive;
            } finally {
            }
        } catch (IOException unused) {
            this.telemetry.logEvent(DataCollectAnalyticsEvents.COLLECT_FAILED, MapsKt.mapOf(TuplesKt.m1606to("type", DataCollectAnalyticsEvents.COLLECT_METADATA_JSON_ERROR)));
            return null;
        }
    }
}
