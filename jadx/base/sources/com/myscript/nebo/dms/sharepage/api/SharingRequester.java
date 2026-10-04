package com.myscript.nebo.dms.sharepage.api;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.myscript.nebo.dms.sharepage.amazon.S3Client;
import com.myscript.nebo.dms.sharepage.api.SharingRequester;
import com.myscript.nebo.dms.sharepage.api.entity.AddUsersPayload;
import com.myscript.nebo.dms.sharepage.api.entity.ContactModel;
import com.myscript.nebo.dms.sharepage.api.entity.OptionsPayload;
import com.myscript.nebo.dms.sharepage.api.entity.PagePayload;
import com.myscript.nebo.dms.sharepage.api.entity.PublishResult;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.ISharePageManagerRequester;
import com.myscript.snt.dms.SharePage;
import com.myscript.snt.dms.SharePageOptions;
import com.myscript.snt.dms.SharePageRequestResultCode;
import com.myscript.snt.dms.SharePageResult;
import com.myscript.snt.dms.SharePageState;
import com.myscript.snt.dms.SharePageUser;
import com.myscript.snt.dms.SharePageUserRight;
import com.myscript.snt.dms.SharePageVisibility;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: SharingRequester.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0003)*+B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J&\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00172\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/SharingRequester;", "Lcom/myscript/snt/dms/ISharePageManagerRequester;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "httpClient", "Lokhttp3/OkHttpClient;", "backendUrl", "", "callback", "Lcom/myscript/nebo/dms/sharepage/api/SharingRequester$Callback;", "<init>", "(Lcom/myscript/nebo/sso/model/UserData;Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/SharingRequester$Callback;)V", "sharePageApi", "Lcom/myscript/nebo/dms/sharepage/api/SharePageApi;", "sharePage", "", "Lcom/myscript/snt/dms/SharePage;", "tempSharingPagePath", "pageFinalName", "hashFile", "pageKey", "Lcom/myscript/snt/core/PageKey;", "loadSharedPages", "", "lastFetchedTimestampMicroSeconds", "", "pageInfos", "uuid", "disableSharing", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "removedPageShared", "addPageSharedUsers", "users", "Lcom/myscript/snt/dms/SharePageUser;", "message", "removePageSharedUser", "user", "updatePageSharedUser", "changePageSharedVisibilty", "newVisibility", "Lcom/myscript/snt/dms/SharePageVisibility;", "Cancelable", "Callback", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharingRequester implements ISharePageManagerRequester {
    private static final String TAG = "SharingRequester";
    private final Callback callback;
    private final SharePageApi sharePageApi;
    private final UserData userData;

    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/SharingRequester$Callback;", "", "onUploadStarted", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "totalSize", "", "callback", "Lcom/myscript/nebo/dms/sharepage/api/SharingRequester$Cancelable;", "onSharePageProgress", "progress", "onSharePageDone", "sharePageResult", "Lcom/myscript/snt/dms/SharePageResult;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onSharePageDone(PageKey pageKey, SharePageResult sharePageResult);

        void onSharePageProgress(PageKey pageKey, float progress, float totalSize);

        void onUploadStarted(PageKey pageKey, float totalSize, Cancelable callback);
    }

    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/SharingRequester$Cancelable;", "", "cancel", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Cancelable {
        void cancel();
    }

    public SharingRequester(UserData userData, OkHttpClient httpClient, String backendUrl, Callback callback) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendUrl, "backendUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userData = userData;
        this.callback = callback;
        this.sharePageApi = SharePageApi.INSTANCE.build(httpClient, backendUrl);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$sharePage$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$sharePage$1", m1609f = "SharingRequester.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {64}, m1615s = {}, m1616v = 2)
    static final class C62901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $hashFile;
        final /* synthetic */ String $pageFinalName;
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ SharePage $sharePage;
        final /* synthetic */ String $tempSharingPagePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62901(SharePage sharePage, PageKey pageKey, String str, String str2, String str3, Continuation<? super C62901> continuation) {
            super(2, continuation);
            this.$sharePage = sharePage;
            this.$pageKey = pageKey;
            this.$tempSharingPagePath = str;
            this.$pageFinalName = str2;
            this.$hashFile = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharingRequester.this.new C62901(this.$sharePage, this.$pageKey, this.$tempSharingPagePath, this.$pageFinalName, this.$hashFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objPublishPage;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharePageApi sharePageApi = SharingRequester.this.sharePageApi;
                long jCreationDate = this.$sharePage.creationDate();
                long jLastModificationDate = this.$sharePage.lastModificationDate();
                long jMetadataModificationDate = this.$sharePage.metadataModificationDate();
                String strTitle = this.$sharePage.title();
                String strPageType = this.$sharePage.pageType();
                Intrinsics.checkNotNullExpressionValue(strPageType, "pageType(...)");
                String strSignature = this.$sharePage.signature();
                Intrinsics.checkNotNullExpressionValue(strSignature, "signature(...)");
                String strUuid = this.$sharePage.uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                this.label = 1;
                objPublishPage = sharePageApi.publishPage(new PagePayload(jCreationDate, jLastModificationDate, jMetadataModificationDate, "", strTitle, strPageType, strSignature, strUuid), this);
                if (objPublishPage == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objPublishPage = obj;
            }
            Response response = (Response) objPublishPage;
            if (!response.isSuccessful()) {
                SharePageResult sharePageResult = new SharePageResult();
                sharePageResult.setIsSuccess(false);
                sharePageResult.setReturnCode(response.code() == 401 ? SharePageRequestResultCode.NOT_OWNER_ERROR : SharePageRequestResultCode.GENERIC_ERROR);
                SharingRequester.this.callback.onSharePageDone(this.$pageKey, sharePageResult);
                return Unit.INSTANCE;
            }
            if (response.code() != 201) {
                SharePageResult sharePageResult2 = new SharePageResult();
                sharePageResult2.setIsSuccess(true);
                sharePageResult2.setReturnCode(SharePageRequestResultCode.OK);
                SharingRequester.this.callback.onSharePageDone(this.$pageKey, sharePageResult2);
                return Unit.INSTANCE;
            }
            SharingRequester sharingRequester = SharingRequester.this;
            SharePage sharePage = this.$sharePage;
            SharePageVisibility sharePageVisibilityVisibility = sharePage.options().visibility();
            Intrinsics.checkNotNullExpressionValue(sharePageVisibilityVisibility, "visibility(...)");
            if (sharingRequester.changePageSharedVisibilty(sharePage, sharePageVisibilityVisibility) != SharePageRequestResultCode.OK) {
                SharePageResult sharePageResult3 = new SharePageResult();
                sharePageResult3.setIsSuccess(false);
                sharePageResult3.setReturnCode(SharePageRequestResultCode.GENERIC_ERROR);
                SharingRequester.this.callback.onSharePageDone(this.$pageKey, sharePageResult3);
                return Unit.INSTANCE;
            }
            Object objBody = response.body();
            Intrinsics.checkNotNull(objBody);
            final PublishResult publishResult = (PublishResult) objBody;
            final S3Client s3Client = new S3Client(publishResult.s3UploadParameters);
            File file = new File(this.$tempSharingPagePath);
            Callback callback = SharingRequester.this.callback;
            PageKey pageKey = this.$sharePage.pageKey();
            float length = file.length();
            final SharingRequester sharingRequester2 = SharingRequester.this;
            final PageKey pageKey2 = this.$pageKey;
            callback.onUploadStarted(pageKey, length, new Cancelable() { // from class: com.myscript.nebo.dms.sharepage.api.SharingRequester$sharePage$1$$ExternalSyntheticLambda0
                @Override // com.myscript.nebo.dms.sharepage.api.SharingRequester.Cancelable
                public final void cancel() {
                    SharingRequester.C62901.invokeSuspend$lambda$3(s3Client, sharingRequester2, pageKey2);
                }
            });
            S3Client.CollectMetadata collectMetadata = new S3Client.CollectMetadata();
            SharingRequester sharingRequester3 = SharingRequester.this;
            String str = this.$hashFile;
            collectMetadata.userLogin = sharingRequester3.userData.getLogin();
            collectMetadata.shareWithMyscript = sharingRequester3.userData.isNotesSharingActivated();
            collectMetadata.contentSha256 = str;
            String str2 = this.$tempSharingPagePath;
            String strUuid2 = this.$sharePage.uuid();
            Intrinsics.checkNotNullExpressionValue(strUuid2, "uuid(...)");
            String strTitle2 = this.$sharePage.title();
            Intrinsics.checkNotNullExpressionValue(strTitle2, "title(...)");
            String str3 = this.$pageFinalName;
            final SharingRequester sharingRequester4 = SharingRequester.this;
            final SharePage sharePage2 = this.$sharePage;
            final PageKey pageKey3 = this.$pageKey;
            s3Client.upload(str2, strUuid2, strTitle2, str3, collectMetadata, new S3Client.UploadListener() { // from class: com.myscript.nebo.dms.sharepage.api.SharingRequester.sharePage.1.2
                @Override // com.myscript.nebo.dms.sharepage.amazon.S3Client.UploadListener
                public void onProgress(long bytesCurrent, long bytesTotal) {
                    float f = bytesTotal;
                    float f2 = bytesCurrent / f;
                    sharingRequester4.callback.onSharePageProgress(sharePage2.pageKey(), f2, f);
                    String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f2 * 100)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    Log.d(SharingRequester.TAG, "bytesCurrent: " + bytesCurrent + " bytesTotal: " + bytesTotal + " " + str4 + "%");
                }

                @Override // com.myscript.nebo.dms.sharepage.amazon.S3Client.UploadListener
                public void onError() {
                    SharePageResult sharePageResult4 = new SharePageResult();
                    sharePageResult4.setIsSuccess(false);
                    sharingRequester4.callback.onSharePageDone(pageKey3, sharePageResult4);
                }

                @Override // com.myscript.nebo.dms.sharepage.amazon.S3Client.UploadListener
                public void onComplete() {
                    SharePageResult sharePageResult4 = new SharePageResult();
                    PublishResult publishResult2 = publishResult;
                    sharePageResult4.setIsSuccess(true);
                    sharePageResult4.setUploadedDateMicroSeconds(publishResult2.getPublicationTimestamp() * ((long) 1000));
                    String str4 = publishResult2.url;
                    Intrinsics.checkNotNull(str4);
                    sharePageResult4.setSharedLink(str4);
                    sharingRequester4.callback.onSharePageDone(pageKey3, sharePageResult4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3(S3Client s3Client, SharingRequester sharingRequester, PageKey pageKey) {
            s3Client.cancel();
            sharingRequester.callback.onSharePageDone(pageKey, new SharePageResult());
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public void sharePage(SharePage sharePage, String tempSharingPagePath, String pageFinalName, String hashFile, PageKey pageKey) throws InterruptedException {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        Intrinsics.checkNotNullParameter(tempSharingPagePath, "tempSharingPagePath");
        Intrinsics.checkNotNullParameter(pageFinalName, "pageFinalName");
        Intrinsics.checkNotNullParameter(hashFile, "hashFile");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        BuildersKt__BuildersKt.runBlocking$default(null, new C62901(sharePage, pageKey, tempSharingPagePath, pageFinalName, hashFile, null), 1, null);
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public List<SharePage> loadSharedPages(long lastFetchedTimestampMicroSeconds) {
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$pageInfos$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/dms/SharePage;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$pageInfos$1", m1609f = "SharingRequester.kt", m1610i = {}, m1611l = {154}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {155}, m1615s = {}, m1616v = 2)
    static final class C62871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharePage>, Object> {
        final /* synthetic */ String $uuid;
        int label;

        /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$pageInfos$1$WhenMappings */
        /* JADX INFO: compiled from: SharingRequester.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            static {
                int[] iArr = new int[ContactModel.Permission.values().length];
                try {
                    iArr[ContactModel.Permission.READ.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[PagePayload.Visibility.values().length];
                try {
                    iArr2[PagePayload.Visibility.PRIVATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr2[PagePayload.Visibility.PUBLIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[PagePayload.Status.values().length];
                try {
                    iArr3[PagePayload.Status.READY.ordinal()] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$2 = iArr3;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62871(String str, Continuation<? super C62871> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharingRequester.this.new C62871(this.$uuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharePage> continuation) {
            return ((C62871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SharePageVisibility sharePageVisibility;
            SharePageState sharePageState;
            SharePageUserRight sharePageUserRight;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SharingRequester.this.sharePageApi.getPage(this.$uuid, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                PagePayload pagePayload = (PagePayload) obj;
                PagePayload.Owner owner = pagePayload.owner;
                if (!Intrinsics.areEqual(owner != null ? owner.login : null, SharingRequester.this.userData.getLogin())) {
                    return SharePage.createEmptySharePage(this.$uuid);
                }
                SharePageOptions sharePageOptions = new SharePageOptions();
                List<ContactModel> list = pagePayload.contacts;
                if (list != null) {
                    List<ContactModel> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (ContactModel contactModel : list2) {
                        String str = contactModel.email;
                        String str2 = contactModel.name;
                        if (str2 == null) {
                            str2 = "";
                        }
                        SharePageUser sharePageUser = new SharePageUser(str, str2);
                        ContactModel.Permission permission = contactModel.permission;
                        if ((permission == null ? -1 : WhenMappings.$EnumSwitchMapping$0[permission.ordinal()]) == 1) {
                            sharePageUserRight = SharePageUserRight.READ;
                        } else {
                            sharePageUserRight = SharePageUserRight.DISABLE;
                        }
                        sharePageUser.setUserRight(sharePageUserRight);
                        arrayList.add(sharePageUser);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sharePageOptions.addUser((SharePageUser) it.next());
                    }
                }
                PagePayload.Visibility visibility = pagePayload.visibility;
                int i2 = visibility == null ? -1 : WhenMappings.$EnumSwitchMapping$1[visibility.ordinal()];
                if (i2 == 1) {
                    sharePageVisibility = SharePageVisibility.PRIVATE;
                } else if (i2 == 2) {
                    sharePageVisibility = SharePageVisibility.PUBLIC;
                } else {
                    sharePageVisibility = SharePageVisibility.NONE;
                }
                sharePageOptions.setVisibility(sharePageVisibility);
                PagePayload.Status status = pagePayload.status;
                if ((status != null ? WhenMappings.$EnumSwitchMapping$2[status.ordinal()] : -1) == 1) {
                    sharePageState = SharePageState.UP_TO_DATE;
                } else {
                    sharePageState = SharePageState.UNPUBLISHED;
                }
                SharePageState sharePageState2 = sharePageState;
                String str3 = pagePayload.uuid;
                String str4 = pagePayload.signature;
                long publicationTimestamp = pagePayload.getPublicationTimestamp() * ((long) 1000);
                Long l = pagePayload.metadata.lastMetadataModificationDate;
                Intrinsics.checkNotNull(l);
                long jLongValue = l.longValue();
                String str5 = pagePayload.self;
                Intrinsics.checkNotNull(str5);
                PagePayload.Status status2 = pagePayload.status;
                Intrinsics.checkNotNull(status2);
                SharePage sharePageCreateRemoteSharePage = SharePage.createRemoteSharePage(str3, str4, publicationTimestamp, jLongValue, str5, false, sharePageOptions, status2.name());
                sharePageCreateRemoteSharePage.setState(sharePageState2);
                return sharePageCreateRemoteSharePage;
            } catch (Exception e) {
                if ((e instanceof HttpException) && ((HttpException) e).code() == 404) {
                    return SharePage.createDeletedSharePage(this.$uuid);
                }
                return SharePage.createEmptySharePage(this.$uuid);
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePage pageInfos(String uuid) throws InterruptedException {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Object objRunBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C62871(uuid, null), 1, null);
        Intrinsics.checkNotNull(objRunBlocking$default);
        return (SharePage) objRunBlocking$default;
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode disableSharing(SharePage sharePage) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        return SharePageRequestResultCode.GENERIC_ERROR;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$removedPageShared$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$removedPageShared$1", m1609f = "SharingRequester.kt", m1610i = {}, m1611l = {215}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {216}, m1615s = {}, m1616v = 2)
    static final class C62891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharePageRequestResultCode>, Object> {
        final /* synthetic */ SharePage $sharePage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62891(SharePage sharePage, Continuation<? super C62891> continuation) {
            super(2, continuation);
            this.$sharePage = sharePage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharingRequester.this.new C62891(this.$sharePage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharePageRequestResultCode> continuation) {
            return ((C62891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharePageApi sharePageApi = SharingRequester.this.sharePageApi;
                    String strUuid = this.$sharePage.uuid();
                    Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                    this.label = 1;
                    if (sharePageApi.deletePage(strUuid, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return SharePageRequestResultCode.OK;
            } catch (Exception unused) {
                return SharePageRequestResultCode.GENERIC_ERROR;
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode removedPageShared(SharePage sharePage) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        return (SharePageRequestResultCode) BuildersKt__BuildersKt.runBlocking$default(null, new C62891(sharePage, null), 1, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$addPageSharedUsers$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$addPageSharedUsers$1", m1609f = "SharingRequester.kt", m1610i = {0}, m1611l = {229}, m1612m = "invokeSuspend", m1613n = {"contacts"}, m1614nl = {230}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharePageRequestResultCode>, Object> {
        final /* synthetic */ String $message;
        final /* synthetic */ SharePage $sharePage;
        final /* synthetic */ List<SharePageUser> $users;
        Object L$0;
        int label;
        final /* synthetic */ SharingRequester this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C62851(List<? extends SharePageUser> list, SharingRequester sharingRequester, SharePage sharePage, String str, Continuation<? super C62851> continuation) {
            super(2, continuation);
            this.$users = list;
            this.this$0 = sharingRequester;
            this.$sharePage = sharePage;
            this.$message = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62851(this.$users, this.this$0, this.$sharePage, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharePageRequestResultCode> continuation) {
            return ((C62851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<SharePageUser> list = this.$users;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (((SharePageUser) obj2).userRight() == SharePageUserRight.READ) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList<SharePageUser> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (SharePageUser sharePageUser : arrayList2) {
                        String strEmail = sharePageUser.email();
                        Intrinsics.checkNotNullExpressionValue(strEmail, "email(...)");
                        arrayList3.add(new ContactModel(strEmail, sharePageUser.name(), ContactModel.Permission.READ));
                    }
                    ArrayList arrayList4 = arrayList3;
                    SharePageApi sharePageApi = this.this$0.sharePageApi;
                    String strUuid = this.$sharePage.uuid();
                    Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList4);
                    this.label = 1;
                    if (sharePageApi.addUsersToPage(strUuid, new AddUsersPayload(arrayList4, this.$message), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return SharePageRequestResultCode.OK;
            } catch (Exception unused) {
                return SharePageRequestResultCode.GENERIC_ERROR;
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode addPageSharedUsers(SharePage sharePage, List<? extends SharePageUser> users, String message) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(message, "message");
        return (SharePageRequestResultCode) BuildersKt__BuildersKt.runBlocking$default(null, new C62851(users, this, sharePage, message, null), 1, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$removePageSharedUser$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$removePageSharedUser$1", m1609f = "SharingRequester.kt", m1610i = {}, m1611l = {PsExtractor.VIDEO_STREAM_MASK}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_4_1}, m1615s = {}, m1616v = 2)
    static final class C62881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharePageRequestResultCode>, Object> {
        final /* synthetic */ SharePage $sharePage;
        final /* synthetic */ SharePageUser $user;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62881(SharePage sharePage, SharePageUser sharePageUser, Continuation<? super C62881> continuation) {
            super(2, continuation);
            this.$sharePage = sharePage;
            this.$user = sharePageUser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharingRequester.this.new C62881(this.$sharePage, this.$user, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharePageRequestResultCode> continuation) {
            return ((C62881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharePageApi sharePageApi = SharingRequester.this.sharePageApi;
                    String strUuid = this.$sharePage.uuid();
                    Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                    String strEmail = this.$user.email();
                    Intrinsics.checkNotNullExpressionValue(strEmail, "email(...)");
                    this.label = 1;
                    if (sharePageApi.removeUsersFromPage(strUuid, strEmail, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return SharePageRequestResultCode.OK;
            } catch (Exception unused) {
                return SharePageRequestResultCode.GENERIC_ERROR;
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode removePageSharedUser(SharePage sharePage, SharePageUser user) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        Intrinsics.checkNotNullParameter(user, "user");
        return (SharePageRequestResultCode) BuildersKt__BuildersKt.runBlocking$default(null, new C62881(sharePage, user, null), 1, null);
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode updatePageSharedUser(SharePage sharePage, SharePageUser user) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        Intrinsics.checkNotNullParameter(user, "user");
        return SharePageRequestResultCode.GENERIC_ERROR;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$changePageSharedVisibilty$1 */
    /* JADX INFO: compiled from: SharingRequester.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.api.SharingRequester$changePageSharedVisibilty$1", m1609f = "SharingRequester.kt", m1610i = {0}, m1611l = {260}, m1612m = "invokeSuspend", m1613n = {"visibility"}, m1614nl = {PDFACompliance.e_PDFA2_6_1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharePageRequestResultCode>, Object> {
        final /* synthetic */ SharePageVisibility $newVisibility;
        final /* synthetic */ SharePage $sharePage;
        Object L$0;
        int label;
        final /* synthetic */ SharingRequester this$0;

        /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.api.SharingRequester$changePageSharedVisibilty$1$WhenMappings */
        /* JADX INFO: compiled from: SharingRequester.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SharePageVisibility.values().length];
                try {
                    iArr[SharePageVisibility.PUBLIC.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62861(SharePageVisibility sharePageVisibility, SharingRequester sharingRequester, SharePage sharePage, Continuation<? super C62861> continuation) {
            super(2, continuation);
            this.$newVisibility = sharePageVisibility;
            this.this$0 = sharingRequester;
            this.$sharePage = sharePage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62861(this.$newVisibility, this.this$0, this.$sharePage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharePageRequestResultCode> continuation) {
            return ((C62861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PagePayload.Visibility visibility;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (WhenMappings.$EnumSwitchMapping$0[this.$newVisibility.ordinal()] == 1) {
                        visibility = PagePayload.Visibility.PUBLIC;
                    } else {
                        visibility = PagePayload.Visibility.PRIVATE;
                    }
                    SharePageApi sharePageApi = this.this$0.sharePageApi;
                    String strUuid = this.$sharePage.uuid();
                    Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(visibility);
                    this.label = 1;
                    if (sharePageApi.changePageVisibility(strUuid, new OptionsPayload(visibility), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return SharePageRequestResultCode.OK;
            } catch (Exception unused) {
                return SharePageRequestResultCode.GENERIC_ERROR;
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerRequester
    public SharePageRequestResultCode changePageSharedVisibilty(SharePage sharePage, SharePageVisibility newVisibility) {
        Intrinsics.checkNotNullParameter(sharePage, "sharePage");
        Intrinsics.checkNotNullParameter(newVisibility, "newVisibility");
        return (SharePageRequestResultCode) BuildersKt__BuildersKt.runBlocking$default(null, new C62861(newVisibility, this, sharePage, null), 1, null);
    }
}
