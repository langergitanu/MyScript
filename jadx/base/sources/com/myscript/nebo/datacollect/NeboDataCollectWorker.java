package com.myscript.nebo.datacollect;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.datacollect.NeboDataCollectDateStore;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.shared.datacollect.DataCollect;
import com.myscript.shared.datacollect.DataCollectAnalyticsEvents;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSFilter;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NeboDataCollectWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$JF\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0082@¢\u0006\u0002\u0010/JF\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0082@¢\u0006\u0002\u0010/J^\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0082@¢\u0006\u0002\u0010;J\u0018\u0010<\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00106\u001a\u00020,H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u000209H\u0002R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 ¨\u0006B"}, m1599d2 = {"Lcom/myscript/nebo/datacollect/NeboDataCollectWorker;", "Landroidx/work/CoroutineWorker;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "libraryRepository$delegate", "Lkotlin/Lazy;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "getUserData", "()Lcom/myscript/nebo/sso/model/UserData;", "userData$delegate", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "getSubscriptionRepository", "()Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "subscriptionRepository$delegate", "dataCollect", "Lcom/myscript/shared/datacollect/DataCollect;", "getDataCollect", "()Lcom/myscript/shared/datacollect/DataCollect;", "dataCollect$delegate", "neboDataCollectDateStore", "Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore;", "getNeboDataCollectDateStore", "()Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore;", "neboDataCollectDateStore$delegate", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectNotebook", "", AIQuizConstants.NOTEBOOK, "Lcom/myscript/nebo/dms/core/model/PageModel;", "repo", "dateStore", "ssoId", "", "appVersion", "userStatus", "(Lcom/myscript/nebo/dms/core/model/PageModel;Lcom/myscript/shared/datacollect/DataCollect;Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/datacollect/NeboDataCollectDateStore;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectPage", "page", "exportAndSend", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "uuid", "title", "lastModificationDate", "", "creationDate", "(Lcom/myscript/snt/core/PageKey;Ljava/lang/String;Ljava/lang/String;JJLcom/myscript/shared/datacollect/DataCollect;Lcom/myscript/nebo/dms/core/LibraryRepository;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeFileName", "logSyncAnalytics", "", "filesProcessed", "startTime", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboDataCollectWorker extends CoroutineWorker {
    private static final String TAG = "DataCollectWorker";
    public static final String UNIQUE_WORK_NAME = "NeboDataCollectUpload";
    private static final String USER_STATUS_PAID = "paid";
    private static final String USER_STATUS_TRIAL = "trial";

    /* JADX INFO: renamed from: dataCollect$delegate, reason: from kotlin metadata */
    private final Lazy dataCollect;

    /* JADX INFO: renamed from: libraryRepository$delegate, reason: from kotlin metadata */
    private final Lazy libraryRepository;

    /* JADX INFO: renamed from: neboDataCollectDateStore$delegate, reason: from kotlin metadata */
    private final Lazy neboDataCollectDateStore;

    /* JADX INFO: renamed from: subscriptionRepository$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionRepository;

    /* JADX INFO: renamed from: userData$delegate, reason: from kotlin metadata */
    private final Lazy userData;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.datacollect.NeboDataCollectWorker$collectNotebook$1 */
    /* JADX INFO: compiled from: NeboDataCollectWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.datacollect.NeboDataCollectWorker", m1609f = "NeboDataCollectWorker.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {107, 111, GapComposerKt.nodeKey}, m1612m = "collectNotebook", m1613n = {AIQuizConstants.NOTEBOOK, "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "subPages", "$this$any$iv", "element$iv", "it", "$i$f$any", "$i$a$-any-NeboDataCollectWorker$collectNotebook$hasChanged$1", AIQuizConstants.NOTEBOOK, "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "subPages", "hasChanged", "lastModDate", AIQuizConstants.NOTEBOOK, "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "subPages", "$this$forEach$iv", "element$iv", "it", "hasChanged", "lastModDate", FirebaseAnalytics.Param.SUCCESS, "$i$f$forEach", "$i$a$-forEach-NeboDataCollectWorker$collectNotebook$2"}, m1614nl = {PsExtractor.VIDEO_STREAM_MASK, 124, PDFACompliance.e_PDFA2_4_3}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "J$0", "Z$0", "I$1", "I$2"}, m1616v = 2)
    static final class C61871 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C61871(Continuation<? super C61871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboDataCollectWorker.this.collectNotebook(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.datacollect.NeboDataCollectWorker$collectPage$1 */
    /* JADX INFO: compiled from: NeboDataCollectWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.datacollect.NeboDataCollectWorker", m1609f = "NeboDataCollectWorker.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {140, PDFACompliance.e_PDFA1_4_2, 155}, m1612m = "collectPage", m1613n = {"page", "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "uuid", "page", "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "uuid", "page", "dataCollect", "repo", "dateStore", "ssoId", "appVersion", "userStatus", "uuid", FirebaseAnalytics.Param.SUCCESS}, m1614nl = {PDFACompliance.e_PDFA1_4_2, 155, 156}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, m1616v = 2)
    static final class C61881 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C61881(Continuation<? super C61881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboDataCollectWorker.this.collectPage(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.datacollect.NeboDataCollectWorker$doWork$1 */
    /* JADX INFO: compiled from: NeboDataCollectWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.datacollect.NeboDataCollectWorker", m1609f = "NeboDataCollectWorker.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {59, 72, 74}, m1612m = "doWork", m1613n = {"dataCollect", "libraryRepository", "userData", "dataCollectDateStore", "ssoId", "startTime", "filesProcessed", "dataCollect", "libraryRepository", "userData", "dataCollectDateStore", "ssoId", "userStatus", "appVersion", "collections", "collection", "folder", "pages", "page", "startTime", "filesProcessed", "hasSubscribed", "dataCollect", "libraryRepository", "userData", "dataCollectDateStore", "ssoId", "userStatus", "appVersion", "collections", "collection", "folder", "pages", "page", "startTime", "filesProcessed", "hasSubscribed"}, m1614nl = {60, 74, 80}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$11", "L$12", "L$14", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$11", "L$12", "L$14", "J$0", "I$0", "I$1"}, m1616v = 2)
    static final class C61891 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C61891(Continuation<? super C61891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboDataCollectWorker.this.doWork(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.datacollect.NeboDataCollectWorker$exportAndSend$1 */
    /* JADX INFO: compiled from: NeboDataCollectWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.datacollect.NeboDataCollectWorker", m1609f = "NeboDataCollectWorker.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {193}, m1612m = "exportAndSend", m1613n = {"pageKey", "uuid", "title", "dataCollect", "repo", "ssoId", "appVersion", "userStatus", "workDir", "exported", "uploadFile", "lastModificationDate", "creationDate"}, m1614nl = {203}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "J$1"}, m1616v = 2)
    static final class C61901 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C61901(Continuation<? super C61901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboDataCollectWorker.this.exportAndSend(null, null, null, 0L, 0L, null, null, null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NeboDataCollectWorker(Context application, WorkerParameters workerParams) {
        super(application, workerParams);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.libraryRepository = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.datacollect.NeboDataCollectWorker$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboDataCollectWorker.libraryRepository_delegate$lambda$0(this.f$0);
            }
        });
        this.userData = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.datacollect.NeboDataCollectWorker$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboDataCollectWorker.userData_delegate$lambda$0(this.f$0);
            }
        });
        this.subscriptionRepository = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.datacollect.NeboDataCollectWorker$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboDataCollectWorker.subscriptionRepository_delegate$lambda$0(this.f$0);
            }
        });
        this.dataCollect = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.datacollect.NeboDataCollectWorker$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboDataCollectWorker.dataCollect_delegate$lambda$0(this.f$0);
            }
        });
        this.neboDataCollectDateStore = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.datacollect.NeboDataCollectWorker$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboDataCollectWorker.neboDataCollectDateStore_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final LibraryRepository getLibraryRepository() {
        return (LibraryRepository) this.libraryRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LibraryRepository libraryRepository_delegate$lambda$0(NeboDataCollectWorker neboDataCollectWorker) {
        Object applicationContext = neboDataCollectWorker.getApplicationContext();
        LibraryRepository.Provider provider = applicationContext instanceof LibraryRepository.Provider ? (LibraryRepository.Provider) applicationContext : null;
        if (provider != null) {
            return provider.provideLibraryRepository();
        }
        return null;
    }

    private final UserData getUserData() {
        return (UserData) this.userData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserData userData_delegate$lambda$0(NeboDataCollectWorker neboDataCollectWorker) {
        Object applicationContext = neboDataCollectWorker.getApplicationContext();
        UserData.Provider provider = applicationContext instanceof UserData.Provider ? (UserData.Provider) applicationContext : null;
        if (provider != null) {
            return provider.provideUserData();
        }
        return null;
    }

    private final ISubscriptionRepository getSubscriptionRepository() {
        return (ISubscriptionRepository) this.subscriptionRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISubscriptionRepository subscriptionRepository_delegate$lambda$0(NeboDataCollectWorker neboDataCollectWorker) {
        Object applicationContext = neboDataCollectWorker.getApplicationContext();
        ISubscriptionRepository.Provider provider = applicationContext instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) applicationContext : null;
        if (provider != null) {
            return provider.provideSubscriptionRepository();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataCollect dataCollect_delegate$lambda$0(NeboDataCollectWorker neboDataCollectWorker) {
        Object applicationContext = neboDataCollectWorker.getApplicationContext();
        DataCollect.Provider provider = applicationContext instanceof DataCollect.Provider ? (DataCollect.Provider) applicationContext : null;
        if (provider != null) {
            return provider.provideDataCollect();
        }
        return null;
    }

    private final DataCollect getDataCollect() {
        return (DataCollect) this.dataCollect.getValue();
    }

    private final NeboDataCollectDateStore getNeboDataCollectDateStore() {
        return (NeboDataCollectDateStore) this.neboDataCollectDateStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NeboDataCollectDateStore neboDataCollectDateStore_delegate$lambda$0(NeboDataCollectWorker neboDataCollectWorker) {
        Object applicationContext = neboDataCollectWorker.getApplicationContext();
        NeboDataCollectDateStore.Provider provider = applicationContext instanceof NeboDataCollectDateStore.Provider ? (NeboDataCollectDateStore.Provider) applicationContext : null;
        if (provider != null) {
            return provider.provideDataCollectDateStore();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0304, code lost:
    
        r16 = r11;
        r11 = r2;
        r9.L$0 = r3;
        r9.L$1 = r4;
        r9.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17);
        r9.L$3 = r5;
        r9.L$4 = r6;
        r9.L$5 = r8;
        r9.L$6 = r7;
        r9.L$7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19);
        r9.L$8 = r11;
        r9.L$9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21);
        r9.L$10 = r13;
        r9.L$11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20);
        r9.L$12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18);
        r9.L$13 = r12;
        r9.L$14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23);
        r9.J$0 = r14;
        r9.I$0 = r0;
        r9.I$1 = r16 == true ? 1 : 0;
        r9.I$2 = r0;
        r16 = r0;
        r9.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0350, code lost:
    
        r1 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0354, code lost:
    
        r2 = r1.collectPage(r23, r3, r4, r5, r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0358, code lost:
    
        if (r2 != r10) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x035b, code lost:
    
        r25 = r17;
        r17 = r2;
        r2 = r11;
        r11 = r16 == true ? 1 : 0;
        r24 = r21;
        r21 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r16;
        r16 = r25;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022e A[Catch: Exception -> 0x014e, CancellationException -> 0x0151, TryCatch #3 {CancellationException -> 0x0151, Exception -> 0x014e, blocks: (B:14:0x0085, B:90:0x036c, B:71:0x027f, B:73:0x0285, B:86:0x0354, B:68:0x023c, B:70:0x0242, B:65:0x0228, B:67:0x022e, B:93:0x03a9, B:19:0x0104, B:22:0x0145, B:59:0x0207, B:64:0x021c, B:52:0x01d8, B:54:0x01e3, B:56:0x01e9), top: B:100:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0242 A[Catch: Exception -> 0x014e, CancellationException -> 0x0151, TryCatch #3 {CancellationException -> 0x0151, Exception -> 0x014e, blocks: (B:14:0x0085, B:90:0x036c, B:71:0x027f, B:73:0x0285, B:86:0x0354, B:68:0x023c, B:70:0x0242, B:65:0x0228, B:67:0x022e, B:93:0x03a9, B:19:0x0104, B:22:0x0145, B:59:0x0207, B:64:0x021c, B:52:0x01d8, B:54:0x01e3, B:56:0x01e9), top: B:100:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0285 A[Catch: Exception -> 0x014e, CancellationException -> 0x0151, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x0151, Exception -> 0x014e, blocks: (B:14:0x0085, B:90:0x036c, B:71:0x027f, B:73:0x0285, B:86:0x0354, B:68:0x023c, B:70:0x0242, B:65:0x0228, B:67:0x022e, B:93:0x03a9, B:19:0x0104, B:22:0x0145, B:59:0x0207, B:64:0x021c, B:52:0x01d8, B:54:0x01e3, B:56:0x01e9), top: B:100:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03a9 A[Catch: Exception -> 0x014e, CancellationException -> 0x0151, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x0151, Exception -> 0x014e, blocks: (B:14:0x0085, B:90:0x036c, B:71:0x027f, B:73:0x0285, B:86:0x0354, B:68:0x023c, B:70:0x0242, B:65:0x0228, B:67:0x022e, B:93:0x03a9, B:19:0x0104, B:22:0x0145, B:59:0x0207, B:64:0x021c, B:52:0x01d8, B:54:0x01e3, B:56:0x01e9), top: B:100:0x002b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x022e -> B:68:0x023c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0242 -> B:71:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x035b -> B:90:0x036c). Please report as a decompilation issue!!! */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) throws Throwable {
        C61891 c61891;
        DataCollect dataCollect;
        LibraryRepository libraryRepository;
        UserData userData;
        NeboDataCollectDateStore neboDataCollectDateStore;
        String login;
        long jCurrentTimeMillis;
        boolean zBooleanValue;
        int i;
        StateFlow<Boolean> hasSubscribed;
        Object objFirst;
        String str;
        String str2;
        List<CollectionModel> collectionModels;
        Iterator<CollectionModel> it;
        int i2;
        Iterator<FolderModel> it2;
        FolderModel next;
        List<PageModel> list;
        int iIntValue;
        CollectionModel collectionModel;
        String str3;
        LibraryRepository libraryRepository2;
        String str4;
        NeboDataCollectDateStore neboDataCollectDateStore2;
        C61891 c618912;
        Iterator<CollectionModel> it3;
        UserData userData2;
        String str5;
        int i3;
        DataCollect dataCollect2;
        Iterator<PageModel> it4;
        String str6;
        Iterator<FolderModel> it5;
        List<CollectionModel> list2;
        long j;
        NeboDataCollectWorker neboDataCollectWorker = this;
        if (continuation instanceof C61891) {
            c61891 = (C61891) continuation;
            if ((c61891.label & Integer.MIN_VALUE) != 0) {
                c61891.label -= Integer.MIN_VALUE;
            } else {
                c61891 = neboDataCollectWorker.new C61891(continuation);
            }
        }
        Object obj = c61891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c61891.label;
        String str7 = "success(...)";
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                dataCollect = neboDataCollectWorker.getDataCollect();
                if (dataCollect == null) {
                    Log.e(TAG, "applicationContext does not implement DataCollect.Provider");
                    ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure, "failure(...)");
                    return resultFailure;
                }
                libraryRepository = neboDataCollectWorker.getLibraryRepository();
                if (libraryRepository == null) {
                    Log.e(TAG, "applicationContext does not implement LibraryRepository.Provider");
                    ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure2, "failure(...)");
                    return resultFailure2;
                }
                userData = neboDataCollectWorker.getUserData();
                if (userData == null) {
                    Log.e(TAG, "applicationContext does not implement UserData.Provider");
                    ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure3, "failure(...)");
                    return resultFailure3;
                }
                neboDataCollectDateStore = neboDataCollectWorker.getNeboDataCollectDateStore();
                if (neboDataCollectDateStore == null) {
                    Log.e(TAG, "applicationContext does not implement NeboDataCollectDateStore.Provider");
                    ListenableWorker.Result resultFailure4 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure4, "failure(...)");
                    return resultFailure4;
                }
                login = userData.getLogin();
                if (StringsKt.isBlank(login)) {
                    ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
                    return resultSuccess;
                }
                if (!userData.isNotesSharingActivated()) {
                    ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(resultSuccess2, "success(...)");
                    return resultSuccess2;
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                ISubscriptionRepository subscriptionRepository = neboDataCollectWorker.getSubscriptionRepository();
                zBooleanValue = false;
                i2 = 0;
                if (subscriptionRepository == null || (hasSubscribed = subscriptionRepository.getHasSubscribed()) == null) {
                    i = 0;
                    str = !zBooleanValue ? USER_STATUS_PAID : "trial";
                    str2 = "7.4.3.17964";
                    collectionModels = libraryRepository.getCollectionModels(DMSFilter.ACTIVE);
                    it = collectionModels.iterator();
                    if (it.hasNext()) {
                    }
                } else {
                    c61891.L$0 = dataCollect;
                    c61891.L$1 = libraryRepository;
                    c61891.L$2 = SpillingKt.nullOutSpilledVariable(userData);
                    c61891.L$3 = neboDataCollectDateStore;
                    c61891.L$4 = login;
                    c61891.J$0 = jCurrentTimeMillis;
                    c61891.I$0 = 0;
                    c61891.label = 1;
                    objFirst = FlowKt.first(hasSubscribed, c61891);
                    if (objFirst == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i4 == 1) {
                int i5 = c61891.I$0;
                long j2 = c61891.J$0;
                login = (String) c61891.L$4;
                neboDataCollectDateStore = (NeboDataCollectDateStore) c61891.L$3;
                userData = (UserData) c61891.L$2;
                libraryRepository = (LibraryRepository) c61891.L$1;
                dataCollect = (DataCollect) c61891.L$0;
                ResultKt.throwOnFailure(obj);
                jCurrentTimeMillis = j2;
                i2 = i5;
                objFirst = obj;
            } else if (i4 == 2) {
                int i6 = c61891.I$2;
                int i7 = c61891.I$1;
                int i8 = c61891.I$0;
                long j3 = c61891.J$0;
                Iterator<PageModel> it6 = (Iterator) c61891.L$13;
                List<PageModel> list3 = (List) c61891.L$12;
                FolderModel folderModel = (FolderModel) c61891.L$11;
                Iterator<FolderModel> it7 = (Iterator) c61891.L$10;
                CollectionModel collectionModel2 = (CollectionModel) c61891.L$9;
                Iterator<CollectionModel> it8 = (Iterator) c61891.L$8;
                List<CollectionModel> list4 = (List) c61891.L$7;
                String str8 = (String) c61891.L$6;
                String str9 = (String) c61891.L$5;
                String str10 = (String) c61891.L$4;
                NeboDataCollectDateStore neboDataCollectDateStore3 = (NeboDataCollectDateStore) c61891.L$3;
                UserData userData3 = (UserData) c61891.L$2;
                LibraryRepository libraryRepository3 = (LibraryRepository) c61891.L$1;
                DataCollect dataCollect3 = (DataCollect) c61891.L$0;
                ResultKt.throwOnFailure(obj);
                str5 = str8;
                dataCollect2 = dataCollect3;
                userData2 = userData3;
                str6 = "success(...)";
                it5 = it7;
                c618912 = c61891;
                it3 = it8;
                it4 = it6;
                str4 = str10;
                next = folderModel;
                str3 = str9;
                list2 = list4;
                j = j3;
                neboDataCollectDateStore2 = neboDataCollectDateStore3;
                libraryRepository2 = libraryRepository3;
                collectionModel = collectionModel2;
                i3 = i7;
                iIntValue = i6 + ((Number) obj).intValue();
                list = list3;
                neboDataCollectWorker = this;
                while (it4.hasNext()) {
                }
                int i9 = iIntValue;
                int i10 = i3;
                String str11 = str3;
                libraryRepository = libraryRepository2;
                str = str11;
                String str12 = str4;
                neboDataCollectDateStore = neboDataCollectDateStore2;
                login = str12;
                long j4 = j;
                str2 = str5;
                userData = userData2;
                it = it3;
                jCurrentTimeMillis = j4;
                c61891 = c618912;
                i = i9;
                collectionModels = list2;
                CollectionModel next2 = collectionModel;
                dataCollect = dataCollect2;
                it2 = it5;
                str7 = str6;
                zBooleanValue = i10 == true ? 1 : 0;
                if (!it2.hasNext()) {
                }
            } else {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i11 = c61891.I$2;
                int i12 = c61891.I$1;
                int i13 = c61891.I$0;
                long j5 = c61891.J$0;
                Iterator<PageModel> it9 = (Iterator) c61891.L$13;
                List<PageModel> list5 = (List) c61891.L$12;
                FolderModel folderModel2 = (FolderModel) c61891.L$11;
                Iterator<FolderModel> it10 = (Iterator) c61891.L$10;
                CollectionModel collectionModel3 = (CollectionModel) c61891.L$9;
                Iterator<CollectionModel> it11 = (Iterator) c61891.L$8;
                List<CollectionModel> list6 = (List) c61891.L$7;
                Object obj2 = obj;
                String str13 = (String) c61891.L$6;
                String str14 = (String) c61891.L$5;
                String str15 = (String) c61891.L$4;
                NeboDataCollectDateStore neboDataCollectDateStore4 = (NeboDataCollectDateStore) c61891.L$3;
                UserData userData4 = (UserData) c61891.L$2;
                LibraryRepository libraryRepository4 = (LibraryRepository) c61891.L$1;
                DataCollect dataCollect4 = (DataCollect) c61891.L$0;
                ResultKt.throwOnFailure(obj2);
                it4 = it9;
                str5 = str13;
                list = list5;
                str3 = str14;
                list2 = list6;
                CollectionModel collectionModel4 = collectionModel3;
                UserData userData5 = userData4;
                str6 = "success(...)";
                it5 = it10;
                j = j5;
                str4 = str15;
                LibraryRepository libraryRepository5 = libraryRepository4;
                next = folderModel2;
                c618912 = c61891;
                it3 = it11;
                i3 = i12;
                DataCollect dataCollect5 = dataCollect4;
                iIntValue = i11 + ((Number) obj2).intValue();
                dataCollect2 = dataCollect5;
                libraryRepository2 = libraryRepository5;
                userData2 = userData5;
                neboDataCollectDateStore2 = neboDataCollectDateStore4;
                collectionModel = collectionModel4;
                while (it4.hasNext()) {
                    PageModel next3 = it4.next();
                    if (!next3.isContainer()) {
                        break;
                    }
                    try {
                        c618912.L$0 = dataCollect2;
                        c618912.L$1 = libraryRepository2;
                        c618912.L$2 = SpillingKt.nullOutSpilledVariable(userData2);
                        c618912.L$3 = neboDataCollectDateStore2;
                        c618912.L$4 = str4;
                        c618912.L$5 = str3;
                        c618912.L$6 = str5;
                        c618912.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        c618912.L$8 = it3;
                        c618912.L$9 = SpillingKt.nullOutSpilledVariable(collectionModel);
                        c618912.L$10 = it5;
                        c618912.L$11 = SpillingKt.nullOutSpilledVariable(next);
                        c618912.L$12 = SpillingKt.nullOutSpilledVariable(list);
                        c618912.L$13 = it4;
                        c618912.L$14 = SpillingKt.nullOutSpilledVariable(next3);
                        c618912.J$0 = j;
                        c618912.I$0 = iIntValue;
                        c618912.I$1 = i3;
                        c618912.I$2 = iIntValue;
                        c618912.label = 2;
                        int i14 = i3;
                        Iterator<CollectionModel> it12 = it3;
                        Object objCollectNotebook = collectNotebook(next3, dataCollect2, libraryRepository2, neboDataCollectDateStore2, str4, str5, str3, c618912);
                        if (objCollectNotebook == coroutine_suspended) {
                            break;
                        }
                        List<PageModel> list7 = list;
                        int i15 = iIntValue;
                        it3 = it12;
                        i3 = i14 == true ? 1 : 0;
                        iIntValue = i15 + ((Number) objCollectNotebook).intValue();
                        list = list7;
                        neboDataCollectWorker = this;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        AnalyticsController.logException(new IllegalStateException("DataCollectWorker failed", e));
                        ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
                        Intrinsics.checkNotNullExpressionValue(resultRetry, "retry(...)");
                        return resultRetry;
                    }
                    return coroutine_suspended;
                }
                int i92 = iIntValue;
                int i102 = i3;
                String str112 = str3;
                libraryRepository = libraryRepository2;
                str = str112;
                String str122 = str4;
                neboDataCollectDateStore = neboDataCollectDateStore2;
                login = str122;
                long j42 = j;
                str2 = str5;
                userData = userData2;
                it = it3;
                jCurrentTimeMillis = j42;
                c61891 = c618912;
                i = i92;
                collectionModels = list2;
                CollectionModel next22 = collectionModel;
                dataCollect = dataCollect2;
                it2 = it5;
                str7 = str6;
                zBooleanValue = i102 == true ? 1 : 0;
                if (!it2.hasNext()) {
                    next = it2.next();
                    int i16 = i;
                    List<PageModel> pages = libraryRepository.getPages(next.getNotebookKey());
                    Iterator<PageModel> it13 = pages.iterator();
                    CollectionModel collectionModel5 = next22;
                    list = pages;
                    iIntValue = i16;
                    collectionModel = collectionModel5;
                    LibraryRepository libraryRepository6 = libraryRepository;
                    str3 = str;
                    libraryRepository2 = libraryRepository6;
                    NeboDataCollectDateStore neboDataCollectDateStore5 = neboDataCollectDateStore;
                    str4 = login;
                    neboDataCollectDateStore2 = neboDataCollectDateStore5;
                    DataCollect dataCollect6 = dataCollect;
                    c618912 = c61891;
                    it3 = it;
                    userData2 = userData;
                    str5 = str2;
                    long j6 = jCurrentTimeMillis;
                    i3 = zBooleanValue ? 1 : 0;
                    dataCollect2 = dataCollect6;
                    it4 = it13;
                    str6 = str7;
                    it5 = it2;
                    list2 = collectionModels;
                    j = j6;
                    while (it4.hasNext()) {
                    }
                    int i922 = iIntValue;
                    int i1022 = i3;
                    String str1122 = str3;
                    libraryRepository = libraryRepository2;
                    str = str1122;
                    String str1222 = str4;
                    neboDataCollectDateStore = neboDataCollectDateStore2;
                    login = str1222;
                    long j422 = j;
                    str2 = str5;
                    userData = userData2;
                    it = it3;
                    jCurrentTimeMillis = j422;
                    c61891 = c618912;
                    i = i922;
                    collectionModels = list2;
                    CollectionModel next222 = collectionModel;
                    dataCollect = dataCollect2;
                    it2 = it5;
                    str7 = str6;
                    zBooleanValue = i1022 == true ? 1 : 0;
                    if (!it2.hasNext()) {
                        if (it.hasNext()) {
                            next222 = it.next();
                            it2 = next222.getFolders().iterator();
                            if (!it2.hasNext()) {
                            }
                        } else {
                            neboDataCollectWorker.logSyncAnalytics(i, jCurrentTimeMillis);
                            ListenableWorker.Result resultSuccess3 = ListenableWorker.Result.success();
                            Intrinsics.checkNotNullExpressionValue(resultSuccess3, str7);
                            return resultSuccess3;
                        }
                    }
                }
            }
            int i17 = i2;
            zBooleanValue = ((Boolean) objFirst).booleanValue();
            i = i17;
            if (!zBooleanValue) {
            }
            str2 = "7.4.3.17964";
            collectionModels = libraryRepository.getCollectionModels(DMSFilter.ACTIVE);
            it = collectionModels.iterator();
            if (it.hasNext()) {
            }
        } catch (CancellationException e3) {
            throw e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.myscript.nebo.datacollect.NeboDataCollectWorker] */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x01b7 -> B:30:0x01c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x035e -> B:65:0x0364). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectNotebook(PageModel pageModel, DataCollect dataCollect, LibraryRepository libraryRepository, NeboDataCollectDateStore neboDataCollectDateStore, String str, String str2, String str3, Continuation<? super Integer> continuation) throws Throwable {
        C61871 c61871;
        LibraryRepository libraryRepository2;
        String str4;
        String str5;
        List<PageModel> list;
        C61871 c618712;
        Iterable iterable;
        Iterator it;
        int i;
        PageModel pageModel2;
        DataCollect dataCollect2;
        NeboDataCollectDateStore neboDataCollectDateStore2;
        String str6;
        PageModel pageModel3;
        DataCollect dataCollect3;
        String str7;
        String str8;
        String str9;
        List<PageModel> list2;
        Object obj;
        LibraryRepository libraryRepository3;
        int i2;
        NeboDataCollectDateStore neboDataCollectDateStore3;
        Long lBoxLong;
        String str10;
        C61871 c618713;
        Object obj2;
        long j;
        String str11;
        String str12;
        int i3;
        List<PageModel> list3;
        PageModel pageModel4;
        Object obj3;
        DataCollect dataCollect4;
        String str13;
        LibraryRepository libraryRepository4;
        NeboDataCollectDateStore neboDataCollectDateStore4;
        boolean zBooleanValue;
        boolean z;
        long j2;
        String str14;
        String str15;
        Iterable iterable2;
        Iterator it2;
        List<PageModel> list4;
        String str16;
        int i4;
        int i5;
        ?? r3;
        if (continuation instanceof C61871) {
            c61871 = (C61871) continuation;
            if ((c61871.label & Integer.MIN_VALUE) != 0) {
                c61871.label -= Integer.MIN_VALUE;
            } else {
                c61871 = new C61871(continuation);
            }
        }
        Object obj4 = c61871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c61871.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj4);
            libraryRepository2 = libraryRepository;
            List<PageModel> pages = libraryRepository2.getPages(pageModel.getPageKey());
            List<PageModel> list5 = pages;
            if ((list5 instanceof Collection) && list5.isEmpty()) {
                pageModel3 = pageModel;
                dataCollect3 = dataCollect;
                str7 = str;
                str8 = str2;
                str9 = str3;
                list2 = pages;
                obj = coroutine_suspended;
                libraryRepository3 = libraryRepository2;
                i2 = 0;
                neboDataCollectDateStore3 = neboDataCollectDateStore;
                if (i2 == 0) {
                }
            } else {
                str4 = str2;
                str5 = str3;
                list = pages;
                c618712 = c61871;
                iterable = list5;
                it = list5.iterator();
                i = 0;
                pageModel2 = pageModel;
                dataCollect2 = dataCollect;
                neboDataCollectDateStore2 = neboDataCollectDateStore;
                str6 = str;
                if (it.hasNext()) {
                }
            }
        } else if (i6 == 1) {
            long j3 = c61871.J$0;
            int i7 = c61871.I$1;
            int i8 = c61871.I$0;
            Object obj5 = c61871.L$10;
            Iterator it3 = (Iterator) c61871.L$9;
            Iterable iterable3 = (Iterable) c61871.L$8;
            List<PageModel> list6 = (List) c61871.L$7;
            String str17 = (String) c61871.L$6;
            String str18 = (String) c61871.L$5;
            String str19 = (String) c61871.L$4;
            NeboDataCollectDateStore neboDataCollectDateStore5 = (NeboDataCollectDateStore) c61871.L$3;
            LibraryRepository libraryRepository5 = (LibraryRepository) c61871.L$2;
            DataCollect dataCollect5 = (DataCollect) c61871.L$1;
            PageModel pageModel5 = (PageModel) c61871.L$0;
            ResultKt.throwOnFailure(obj4);
            c618712 = c61871;
            dataCollect2 = dataCollect5;
            str4 = str18;
            Object lastCollectDate = obj4;
            List<PageModel> list7 = list6;
            it = it3;
            str5 = str17;
            pageModel3 = pageModel5;
            NeboDataCollectDateStore neboDataCollectDateStore6 = neboDataCollectDateStore5;
            int i9 = 1;
            obj = coroutine_suspended;
            Iterable iterable4 = iterable3;
            i = i8;
            if (j3 <= ((Number) lastCollectDate).longValue()) {
                i2 = i9;
                dataCollect3 = dataCollect2;
                neboDataCollectDateStore3 = neboDataCollectDateStore6;
                str8 = str4;
                c61871 = c618712;
                str7 = str19;
                list2 = list7;
                libraryRepository3 = libraryRepository5;
                str9 = str5;
                if (i2 == 0) {
                    return Boxing.boxInt(0);
                }
                Iterator it4 = list2.iterator();
                if (it4.hasNext()) {
                    lBoxLong = Boxing.boxLong(((PageModel) it4.next()).getLastModificationDate());
                    while (it4.hasNext()) {
                        Long lBoxLong2 = Boxing.boxLong(((PageModel) it4.next()).getLastModificationDate());
                        if (lBoxLong.compareTo(lBoxLong2) < 0) {
                            lBoxLong = lBoxLong2;
                        }
                    }
                } else {
                    lBoxLong = null;
                }
                Long l = lBoxLong;
                long jLongValue = l != null ? l.longValue() : pageModel3.getLastModificationDate();
                PageKey pageKey = pageModel3.getPageKey();
                String strUuid = pageModel3.getPageKey().uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                String title = pageModel3.getTitle();
                long creationDate = pageModel3.getCreationDate();
                c61871.L$0 = SpillingKt.nullOutSpilledVariable(pageModel3);
                c61871.L$1 = SpillingKt.nullOutSpilledVariable(dataCollect3);
                c61871.L$2 = SpillingKt.nullOutSpilledVariable(libraryRepository3);
                c61871.L$3 = neboDataCollectDateStore3;
                c61871.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                c61871.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c61871.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                c61871.L$7 = list2;
                c61871.L$8 = null;
                c61871.L$9 = null;
                c61871.L$10 = null;
                c61871.L$11 = null;
                c61871.I$0 = i2;
                c61871.J$0 = jLongValue;
                c61871.label = 2;
                NeboDataCollectDateStore neboDataCollectDateStore7 = neboDataCollectDateStore3;
                str10 = "uuid(...)";
                long j4 = jLongValue;
                int i10 = i2;
                Object obj6 = obj;
                c618713 = c61871;
                obj2 = obj6;
                List<PageModel> list8 = list2;
                Object objExportAndSend = exportAndSend(pageKey, strUuid, title, j4, creationDate, dataCollect3, libraryRepository3, str7, str8, str9, c618713);
                if (objExportAndSend == obj2) {
                    return obj2;
                }
                j = j4;
                str11 = str8;
                str12 = str9;
                i3 = i10;
                list3 = list8;
                pageModel4 = pageModel3;
                obj3 = objExportAndSend;
                dataCollect4 = dataCollect3;
                str13 = str7;
                libraryRepository4 = libraryRepository3;
                neboDataCollectDateStore4 = neboDataCollectDateStore7;
                zBooleanValue = ((Boolean) obj3).booleanValue();
                r3 = zBooleanValue;
                if (zBooleanValue) {
                }
                return Boxing.boxInt(r3);
            }
            neboDataCollectDateStore2 = neboDataCollectDateStore6;
            iterable = iterable4;
            libraryRepository2 = libraryRepository5;
            str6 = str19;
            coroutine_suspended = obj;
            list = list7;
            pageModel2 = pageModel3;
            if (it.hasNext()) {
                pageModel3 = pageModel2;
                obj = coroutine_suspended;
                dataCollect3 = dataCollect2;
                neboDataCollectDateStore3 = neboDataCollectDateStore2;
                str7 = str6;
                str8 = str4;
                c61871 = c618712;
                list2 = list;
                i2 = 0;
                libraryRepository3 = libraryRepository2;
                str9 = str5;
                if (i2 == 0) {
                }
            } else {
                Object next = it.next();
                PageModel pageModel6 = (PageModel) next;
                long lastModificationDate = pageModel6.getLastModificationDate();
                Iterable iterable5 = iterable;
                String strUuid2 = pageModel6.getPageKey().uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid2, "uuid(...)");
                c618712.L$0 = pageModel2;
                c618712.L$1 = dataCollect2;
                c618712.L$2 = libraryRepository2;
                c618712.L$3 = neboDataCollectDateStore2;
                c618712.L$4 = str6;
                c618712.L$5 = str4;
                c618712.L$6 = str5;
                c618712.L$7 = list;
                pageModel3 = pageModel2;
                c618712.L$8 = SpillingKt.nullOutSpilledVariable(iterable5);
                c618712.L$9 = it;
                c618712.L$10 = SpillingKt.nullOutSpilledVariable(next);
                c618712.L$11 = SpillingKt.nullOutSpilledVariable(pageModel6);
                c618712.I$0 = i;
                c618712.I$1 = 0;
                c618712.J$0 = lastModificationDate;
                i9 = 1;
                c618712.label = 1;
                lastCollectDate = neboDataCollectDateStore2.getLastCollectDate(strUuid2, c618712);
                obj = coroutine_suspended;
                if (lastCollectDate == obj) {
                    return obj;
                }
                list7 = list;
                str19 = str6;
                libraryRepository5 = libraryRepository2;
                iterable4 = iterable5;
                neboDataCollectDateStore6 = neboDataCollectDateStore2;
                j3 = lastModificationDate;
                if (j3 <= ((Number) lastCollectDate).longValue()) {
                }
            }
        } else {
            if (i6 == 2) {
                obj3 = obj4;
                j = c61871.J$0;
                int i11 = c61871.I$0;
                list3 = (List) c61871.L$7;
                str12 = (String) c61871.L$6;
                str11 = (String) c61871.L$5;
                str13 = (String) c61871.L$4;
                neboDataCollectDateStore4 = (NeboDataCollectDateStore) c61871.L$3;
                libraryRepository4 = (LibraryRepository) c61871.L$2;
                dataCollect4 = (DataCollect) c61871.L$1;
                pageModel4 = (PageModel) c61871.L$0;
                ResultKt.throwOnFailure(obj3);
                i3 = i11;
                c618713 = c61871;
                obj2 = coroutine_suspended;
                str10 = "uuid(...)";
                zBooleanValue = ((Boolean) obj3).booleanValue();
                r3 = zBooleanValue;
                if (zBooleanValue) {
                    List<PageModel> list9 = list3;
                    Iterator it5 = list9.iterator();
                    List<PageModel> list10 = list3;
                    z = zBooleanValue ? 1 : 0;
                    j2 = j;
                    str14 = str11;
                    str15 = str13;
                    iterable2 = list9;
                    it2 = it5;
                    list4 = list10;
                    str16 = str12;
                    i4 = i3;
                    i5 = 0;
                    if (it2.hasNext()) {
                    }
                }
                return Boxing.boxInt(r3);
            }
            if (i6 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i12 = c61871.I$2;
            int i13 = c61871.I$1;
            z = c61871.Z$0;
            long j5 = c61871.J$0;
            i4 = c61871.I$0;
            Object obj7 = c61871.L$10;
            Iterator it6 = (Iterator) c61871.L$9;
            Iterable iterable6 = (Iterable) c61871.L$8;
            List<PageModel> list11 = (List) c61871.L$7;
            String str20 = (String) c61871.L$6;
            str14 = (String) c61871.L$5;
            str15 = (String) c61871.L$4;
            NeboDataCollectDateStore neboDataCollectDateStore8 = (NeboDataCollectDateStore) c61871.L$3;
            LibraryRepository libraryRepository6 = (LibraryRepository) c61871.L$2;
            DataCollect dataCollect6 = (DataCollect) c61871.L$1;
            PageModel pageModel7 = (PageModel) c61871.L$0;
            ResultKt.throwOnFailure(obj4);
            i5 = i13;
            String str21 = "uuid(...)";
            it2 = it6;
            list4 = list11;
            str16 = str20;
            libraryRepository4 = libraryRepository6;
            pageModel4 = pageModel7;
            c618713 = c61871;
            obj2 = coroutine_suspended;
            j2 = j5;
            iterable2 = iterable6;
            neboDataCollectDateStore4 = neboDataCollectDateStore8;
            dataCollect4 = dataCollect6;
            str10 = str21;
            if (it2.hasNext()) {
                Object next2 = it2.next();
                PageModel pageModel8 = (PageModel) next2;
                String str22 = str14;
                String strUuid3 = pageModel8.getPageKey().uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid3, str10);
                String str23 = str15;
                Iterable iterable7 = iterable2;
                long lastModificationDate2 = pageModel8.getLastModificationDate();
                str21 = str10;
                c618713.L$0 = SpillingKt.nullOutSpilledVariable(pageModel4);
                c618713.L$1 = SpillingKt.nullOutSpilledVariable(dataCollect4);
                c618713.L$2 = SpillingKt.nullOutSpilledVariable(libraryRepository4);
                c618713.L$3 = neboDataCollectDateStore4;
                c618713.L$4 = SpillingKt.nullOutSpilledVariable(str23);
                c618713.L$5 = SpillingKt.nullOutSpilledVariable(str22);
                c618713.L$6 = SpillingKt.nullOutSpilledVariable(str16);
                c618713.L$7 = SpillingKt.nullOutSpilledVariable(list4);
                c618713.L$8 = SpillingKt.nullOutSpilledVariable(iterable7);
                c618713.L$9 = it2;
                c618713.L$10 = SpillingKt.nullOutSpilledVariable(next2);
                c618713.L$11 = SpillingKt.nullOutSpilledVariable(pageModel8);
                c618713.I$0 = i4;
                c618713.J$0 = j2;
                c618713.Z$0 = z;
                c618713.I$1 = i5;
                c618713.I$2 = 0;
                c618713.label = 3;
                if (neboDataCollectDateStore4.setLastCollectDate(strUuid3, lastModificationDate2, c618713) == obj2) {
                    return obj2;
                }
                str14 = str22;
                str15 = str23;
                iterable2 = iterable7;
                str10 = str21;
                if (it2.hasNext()) {
                    r3 = z ? 1 : 0;
                    return Boxing.boxInt(r3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectPage(PageModel pageModel, DataCollect dataCollect, LibraryRepository libraryRepository, NeboDataCollectDateStore neboDataCollectDateStore, String str, String str2, String str3, Continuation<? super Integer> continuation) throws Throwable {
        C61881 c61881;
        NeboDataCollectWorker neboDataCollectWorker;
        long lastModificationDate;
        DataCollect dataCollect2;
        LibraryRepository libraryRepository2;
        String str4;
        String str5;
        String str6;
        Object lastCollectDate;
        NeboDataCollectDateStore neboDataCollectDateStore2;
        PageModel pageModel2;
        String str7;
        Object obj;
        int i;
        C61881 c618812;
        NeboDataCollectDateStore neboDataCollectDateStore3;
        LibraryRepository libraryRepository3;
        String str8;
        String str9;
        PageModel pageModel3;
        boolean zBooleanValue;
        boolean z;
        ?? r1;
        if (continuation instanceof C61881) {
            c61881 = (C61881) continuation;
            if ((c61881.label & Integer.MIN_VALUE) != 0) {
                c61881.label -= Integer.MIN_VALUE;
                neboDataCollectWorker = this;
            } else {
                neboDataCollectWorker = this;
                c61881 = neboDataCollectWorker.new C61881(continuation);
            }
        }
        Object obj2 = c61881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c61881.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            String strUuid = pageModel.getPageKey().uuid();
            lastModificationDate = pageModel.getLastModificationDate();
            Intrinsics.checkNotNull(strUuid);
            c61881.L$0 = pageModel;
            dataCollect2 = dataCollect;
            c61881.L$1 = dataCollect2;
            libraryRepository2 = libraryRepository;
            c61881.L$2 = libraryRepository2;
            c61881.L$3 = neboDataCollectDateStore;
            str4 = str;
            c61881.L$4 = str4;
            str5 = str2;
            c61881.L$5 = str5;
            str6 = str3;
            c61881.L$6 = str6;
            c61881.L$7 = strUuid;
            c61881.J$0 = lastModificationDate;
            c61881.label = 1;
            lastCollectDate = neboDataCollectDateStore.getLastCollectDate(strUuid, c61881);
            if (lastCollectDate == coroutine_suspended) {
                return coroutine_suspended;
            }
            neboDataCollectDateStore2 = neboDataCollectDateStore;
            pageModel2 = pageModel;
            str7 = strUuid;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = c61881.Z$0;
                    ResultKt.throwOnFailure(obj2);
                    r1 = z;
                    return Boxing.boxInt(r1);
                }
                String str10 = (String) c61881.L$7;
                String str11 = (String) c61881.L$6;
                str9 = (String) c61881.L$5;
                str8 = (String) c61881.L$4;
                neboDataCollectDateStore3 = (NeboDataCollectDateStore) c61881.L$3;
                libraryRepository3 = (LibraryRepository) c61881.L$2;
                dataCollect2 = (DataCollect) c61881.L$1;
                pageModel3 = (PageModel) c61881.L$0;
                ResultKt.throwOnFailure(obj2);
                c618812 = c61881;
                obj = coroutine_suspended;
                str6 = str11;
                str7 = str10;
                i = 3;
                zBooleanValue = ((Boolean) obj2).booleanValue();
                r1 = zBooleanValue;
                if (zBooleanValue) {
                    Intrinsics.checkNotNull(str7);
                    long lastModificationDate2 = pageModel3.getLastModificationDate();
                    c618812.L$0 = SpillingKt.nullOutSpilledVariable(pageModel3);
                    c618812.L$1 = SpillingKt.nullOutSpilledVariable(dataCollect2);
                    c618812.L$2 = SpillingKt.nullOutSpilledVariable(libraryRepository3);
                    c618812.L$3 = SpillingKt.nullOutSpilledVariable(neboDataCollectDateStore3);
                    c618812.L$4 = SpillingKt.nullOutSpilledVariable(str8);
                    c618812.L$5 = SpillingKt.nullOutSpilledVariable(str9);
                    c618812.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                    c618812.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                    c618812.Z$0 = zBooleanValue;
                    c618812.label = i;
                    if (neboDataCollectDateStore3.setLastCollectDate(str7, lastModificationDate2, c618812) == obj) {
                        return obj;
                    }
                    z = zBooleanValue ? 1 : 0;
                    r1 = z;
                }
                return Boxing.boxInt(r1);
            }
            long j = c61881.J$0;
            String str12 = (String) c61881.L$7;
            String str13 = (String) c61881.L$6;
            String str14 = (String) c61881.L$5;
            String str15 = (String) c61881.L$4;
            NeboDataCollectDateStore neboDataCollectDateStore4 = (NeboDataCollectDateStore) c61881.L$3;
            LibraryRepository libraryRepository4 = (LibraryRepository) c61881.L$2;
            DataCollect dataCollect3 = (DataCollect) c61881.L$1;
            PageModel pageModel4 = (PageModel) c61881.L$0;
            ResultKt.throwOnFailure(obj2);
            str7 = str12;
            pageModel2 = pageModel4;
            str6 = str13;
            lastCollectDate = obj2;
            neboDataCollectDateStore2 = neboDataCollectDateStore4;
            libraryRepository2 = libraryRepository4;
            str4 = str15;
            dataCollect2 = dataCollect3;
            str5 = str14;
            lastModificationDate = j;
        }
        if (lastModificationDate <= ((Number) lastCollectDate).longValue()) {
            return Boxing.boxInt(0);
        }
        PageKey pageKey = pageModel2.getPageKey();
        Intrinsics.checkNotNull(str7);
        String title = pageModel2.getTitle();
        long lastModificationDate3 = pageModel2.getLastModificationDate();
        long creationDate = pageModel2.getCreationDate();
        c61881.L$0 = pageModel2;
        c61881.L$1 = SpillingKt.nullOutSpilledVariable(dataCollect2);
        c61881.L$2 = SpillingKt.nullOutSpilledVariable(libraryRepository2);
        c61881.L$3 = neboDataCollectDateStore2;
        c61881.L$4 = SpillingKt.nullOutSpilledVariable(str4);
        c61881.L$5 = SpillingKt.nullOutSpilledVariable(str5);
        c61881.L$6 = SpillingKt.nullOutSpilledVariable(str6);
        c61881.L$7 = str7;
        c61881.label = 2;
        C61881 c618813 = c61881;
        obj = coroutine_suspended;
        PageModel pageModel5 = pageModel2;
        i = 3;
        Object objExportAndSend = neboDataCollectWorker.exportAndSend(pageKey, str7, title, lastModificationDate3, creationDate, dataCollect2, libraryRepository2, str4, str5, str6, c618813);
        c618812 = c618813;
        if (objExportAndSend == obj) {
            return obj;
        }
        neboDataCollectDateStore3 = neboDataCollectDateStore2;
        obj2 = objExportAndSend;
        libraryRepository3 = libraryRepository2;
        str8 = str4;
        str9 = str5;
        pageModel3 = pageModel5;
        zBooleanValue = ((Boolean) obj2).booleanValue();
        r1 = zBooleanValue;
        if (zBooleanValue) {
        }
        return Boxing.boxInt(r1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x014b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:43:0x014b */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x014e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:44:0x014e */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0152: MOVE (r2 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:46:0x0152 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.myscript.shared.datacollect.DataCollect, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.myscript.nebo.dms.core.LibraryRepository, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object exportAndSend(PageKey pageKey, String str, String str2, long j, long j2, DataCollect dataCollect, LibraryRepository libraryRepository, String str3, String str4, String str5, Continuation<? super Boolean> continuation) throws Throwable {
        C61901 c61901;
        Object obj;
        Object obj2;
        if (continuation instanceof C61901) {
            c61901 = (C61901) continuation;
            if ((c61901.label & Integer.MIN_VALUE) != 0) {
                c61901.label -= Integer.MIN_VALUE;
            } else {
                c61901 = new C61901(continuation);
            }
        }
        C61901 c619012 = c61901;
        Object objSendFileForDataCollect = c619012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? file = c619012.label;
        boolean zBooleanValue = false;
        try {
            try {
                if (file == 0) {
                    ResultKt.throwOnFailure(objSendFileForDataCollect);
                    file = new File(getApplicationContext().getCacheDir(), "datacollect_export_" + str);
                    FilesKt.deleteRecursively(file);
                    file.mkdirs();
                    try {
                        File fileExportPageAsNebo = libraryRepository.exportPageAsNebo(pageKey, file);
                        try {
                            if (fileExportPageAsNebo != null && fileExportPageAsNebo.exists()) {
                                File file2 = new File((File) file, safeFileName(str2, str) + ".iink");
                                if (!Intrinsics.areEqual(fileExportPageAsNebo.getAbsolutePath(), file2.getAbsolutePath())) {
                                    FilesKt.copyTo$default(fileExportPageAsNebo, file2, true, 0, 4, null);
                                }
                                c619012.L$0 = SpillingKt.nullOutSpilledVariable(pageKey);
                                c619012.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                c619012.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                c619012.L$3 = SpillingKt.nullOutSpilledVariable(dataCollect);
                                c619012.L$4 = SpillingKt.nullOutSpilledVariable(libraryRepository);
                                c619012.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                                c619012.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                                c619012.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                                c619012.L$8 = file;
                                c619012.L$9 = SpillingKt.nullOutSpilledVariable(fileExportPageAsNebo);
                                c619012.L$10 = SpillingKt.nullOutSpilledVariable(file2);
                                c619012.J$0 = j;
                                c619012.J$1 = j2;
                                c619012.label = 1;
                                objSendFileForDataCollect = dataCollect.sendFileForDataCollect(file2, str3, str4, str, j, str2, str5, j2, c619012);
                                if (objSendFileForDataCollect == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                file = file;
                            }
                            Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                            FilesKt.deleteRecursively(file);
                            return boolBoxBoolean;
                        } catch (CancellationException e) {
                            throw e;
                        } catch (Exception unused) {
                            file = obj2;
                        } catch (Throwable th) {
                            th = th;
                            file = obj;
                            FilesKt.deleteRecursively(file);
                            throw th;
                        }
                    } catch (CancellationException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    if (file != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j3 = c619012.J$1;
                    long j4 = c619012.J$0;
                    File file3 = (File) c619012.L$8;
                    ResultKt.throwOnFailure(objSendFileForDataCollect);
                    file = file3;
                }
                zBooleanValue = ((Boolean) objSendFileForDataCollect).booleanValue();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (CancellationException e3) {
            throw e3;
        } catch (Exception unused3) {
        }
        FilesKt.deleteRecursively(file);
        return Boxing.boxBoolean(zBooleanValue);
    }

    private final String safeFileName(String title, String uuid) {
        String string = StringsKt.trim((CharSequence) new Regex("[^\\p{L}\\p{N} ._-]").replace(title, "_")).toString();
        if (!StringsKt.isBlank(string)) {
            uuid = string;
        }
        return uuid;
    }

    private final void logSyncAnalytics(int filesProcessed, long startTime) {
        if (filesProcessed > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - startTime;
            Bundle bundle = new Bundle();
            bundle.putString("count", DataCollectAnalyticsEvents.INSTANCE.computeFileCountBucket(filesProcessed));
            bundle.putString("time", DataCollectAnalyticsEvents.INSTANCE.computeDurationBucket(jCurrentTimeMillis));
            AnalyticsController.logAnalytics(DataCollectAnalyticsEvents.COLLECT_DURATION, bundle);
        }
    }
}
