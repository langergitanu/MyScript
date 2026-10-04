package com.myscript.nebo.dms.sharepage.dialog;

import android.content.Context;
import android.text.format.Formatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.dialog.Result;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.ISharePageManagerUIListener;
import com.myscript.snt.dms.SharePage;
import com.myscript.snt.dms.SharePageListenerTask;
import com.myscript.snt.dms.SharePageOptions;
import com.myscript.snt.dms.SharePageRequestResultCode;
import com.myscript.snt.dms.SharePageResult;
import com.myscript.snt.dms.SharePageState;
import com.myscript.snt.dms.SharePageUser;
import com.myscript.snt.dms.SharePageVisibility;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SinglePageUIController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cJ\u0018\u0010\u001d\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010#\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016J\u001c\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001c\u0010,\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SinglePageUIController;", "Lcom/myscript/snt/dms/ISharePageManagerUIListener;", "<init>", "()V", "sharePage", "Lcom/myscript/snt/dms/SharePage;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/dms/sharepage/dialog/SinglePageUIController$PageUpdatedListener;", "setUpdatedListener", "", "reset", "getProgress", "", "isUploading", "", "isOperationInProgress", "getState", "Lcom/myscript/snt/dms/SharePageState;", "getSharedLink", "", "isPublished", "getPageTitle", "getStatusLabel", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "isOutdated", "isPrivateSharing", "getContactList", "", "onSharedPagesLoaded", "sharedPages", "", "onSharedPageInfosLoaded", "sharedPage", "onSharedPageInfosUpdated", "onSharedPagesStatusChanged", "onSharedPagesSharedRemoved", "requestResultCode", "Lcom/myscript/snt/dms/SharePageRequestResultCode;", "onSharedPageError", "task", "Lcom/myscript/snt/dms/SharePageListenerTask;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "onSharedPageSuccessful", "onSharedPagesUploadProgressed", "onPageShared", "sharePageResult", "Lcom/myscript/snt/dms/SharePageResult;", "PageUpdatedListener", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SinglePageUIController implements ISharePageManagerUIListener {
    private PageUpdatedListener listener;
    private SharePage sharePage;

    /* JADX INFO: compiled from: SinglePageUIController.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SinglePageUIController$PageUpdatedListener;", "", "onPageUpdated", "", "result", "Lcom/myscript/nebo/dms/sharepage/dialog/Result;", "onSharedPageSuccessful", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface PageUpdatedListener {
        void onPageUpdated(Result result);

        void onSharedPageSuccessful();
    }

    /* JADX INFO: compiled from: SinglePageUIController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SharePageState.values().length];
            try {
                iArr[SharePageState.UPLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SharePageState.SHARING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SharePageState.REFRESHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SharePageState.UP_TO_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SharePageState.OUTDATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SharePageState.DELETED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SharePageState.UNPUBLISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPagesLoaded(List<SharePage> sharedPages) {
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPagesSharedRemoved(SharePageRequestResultCode requestResultCode, SharePage sharePage) {
    }

    public final void setUpdatedListener(PageUpdatedListener listener) {
        this.listener = listener;
    }

    public final void reset() {
        this.sharePage = null;
    }

    public final int getProgress() {
        SharePage sharePage = this.sharePage;
        return (int) ((sharePage != null ? sharePage.uploadProgress() : 0.0f) * 100.0f);
    }

    public final boolean isUploading() {
        return getState() == SharePageState.UPLOADING;
    }

    public final boolean isOperationInProgress() {
        int i = WhenMappings.$EnumSwitchMapping$0[getState().ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    private final SharePageState getState() {
        SharePageState sharePageStateState;
        SharePage sharePage = this.sharePage;
        return (sharePage == null || (sharePageStateState = sharePage.state()) == null) ? SharePageState.UNPUBLISHED : sharePageStateState;
    }

    public final String getSharedLink() {
        String strSharedLink;
        SharePage sharePage = this.sharePage;
        return (sharePage == null || (strSharedLink = sharePage.sharedLink()) == null) ? "" : strSharedLink;
    }

    public final boolean isPublished() {
        int i = WhenMappings.$EnumSwitchMapping$0[getState().ordinal()];
        return i == 4 || i == 5;
    }

    public final String getPageTitle() {
        String strTitle;
        SharePage sharePage = this.sharePage;
        return (sharePage == null || (strTitle = sharePage.title()) == null) ? "" : strTitle;
    }

    public final String getStatusLabel(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.$EnumSwitchMapping$0[getState().ordinal()]) {
            case 1:
                SharePage sharePage = this.sharePage;
                long jPageFileSize = (long) (sharePage != null ? sharePage.pageFileSize() : 0.0f);
                String fileSize = Formatter.formatFileSize(context, jPageFileSize);
                SharePage sharePage2 = this.sharePage;
                String string2 = context.getString(C6280R.string.share_page_publish_publish_progress, Formatter.formatFileSize(context, (long) ((sharePage2 != null ? sharePage2.uploadProgress() : 0.0f) * jPageFileSize)), fileSize);
                Intrinsics.checkNotNull(string2);
                return string2;
            case 2:
                String string3 = context.getString(C6280R.string.share_page_status_publishing);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 3:
                String string4 = context.getString(C6280R.string.share_page_fetching_data);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 4:
                SharePage sharePage3 = this.sharePage;
                if ((sharePage3 != null ? Long.valueOf(sharePage3.lastModificationDate()) : null) != null) {
                    SharePage sharePage4 = this.sharePage;
                    Intrinsics.checkNotNull(sharePage4);
                    string = CommonUtils.formatTimestampToString(context, sharePage4.lastModificationDate());
                } else {
                    string = context.getString(C6280R.string.share_page_status_published);
                }
                Intrinsics.checkNotNull(string);
                return string;
            case 5:
                String string5 = context.getString(C6280R.string.share_page_status_outdated);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = context.getString(C6280R.string.share_page_status_deleted);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = context.getString(C6280R.string.share_page_status_unpublished);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isOutdated() {
        return getState() == SharePageState.OUTDATED;
    }

    public final boolean isPrivateSharing() {
        SharePageOptions sharePageOptionsOptions;
        SharePage sharePage = this.sharePage;
        return ((sharePage == null || (sharePageOptionsOptions = sharePage.options()) == null) ? null : sharePageOptionsOptions.visibility()) == SharePageVisibility.PRIVATE;
    }

    public final List<String> getContactList() {
        SharePageOptions sharePageOptionsOptions;
        List<SharePageUser> listSharePageUsers;
        if (!isPrivateSharing()) {
            return CollectionsKt.emptyList();
        }
        SharePage sharePage = this.sharePage;
        if (sharePage == null || (sharePageOptionsOptions = sharePage.options()) == null || (listSharePageUsers = sharePageOptionsOptions.sharePageUsers()) == null) {
            return CollectionsKt.emptyList();
        }
        List<SharePageUser> list = listSharePageUsers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SharePageUser) it.next()).email());
        }
        return arrayList;
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPageInfosLoaded(SharePage sharedPage) {
        this.sharePage = sharedPage;
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            pageUpdatedListener.onPageUpdated(Result.UpdateUI.INSTANCE);
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPageInfosUpdated(SharePage sharedPage) {
        this.sharePage = sharedPage;
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            pageUpdatedListener.onPageUpdated(Result.UpdateUI.INSTANCE);
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPagesStatusChanged(List<SharePage> sharedPages) {
        SharePage sharePage;
        if (sharedPages == null || (sharePage = (SharePage) CollectionsKt.firstOrNull((List) sharedPages)) == null) {
            return;
        }
        String strUuid = sharePage.uuid();
        SharePage sharePage2 = this.sharePage;
        if (Intrinsics.areEqual(strUuid, sharePage2 != null ? sharePage2.uuid() : null)) {
            this.sharePage = sharePage;
            PageUpdatedListener pageUpdatedListener = this.listener;
            if (pageUpdatedListener != null) {
                pageUpdatedListener.onPageUpdated(Result.UpdateUI.INSTANCE);
            }
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPageError(SharePageListenerTask task, SharePageRequestResultCode requestResultCode, PageKey pageKey) {
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            pageUpdatedListener.onPageUpdated(Result.Error.Generic.INSTANCE);
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPageSuccessful(SharePageListenerTask task, SharePage sharePage) {
        this.sharePage = sharePage;
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            pageUpdatedListener.onPageUpdated(Result.UpdateUI.INSTANCE);
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onSharedPagesUploadProgressed(SharePage sharePage) {
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            pageUpdatedListener.onPageUpdated(Result.UpdateUI.INSTANCE);
        }
    }

    @Override // com.myscript.snt.dms.ISharePageManagerUIListener
    public void onPageShared(SharePageResult sharePageResult, SharePage sharePage) {
        Result.Error.Generic generic;
        this.sharePage = sharePage;
        PageUpdatedListener pageUpdatedListener = this.listener;
        if (pageUpdatedListener != null) {
            if (sharePageResult == null || !sharePageResult.getIsSuccess()) {
                generic = (sharePageResult != null ? sharePageResult.getReturnCode() : null) == SharePageRequestResultCode.NOT_OWNER_ERROR ? Result.Error.NotOwner.INSTANCE : Result.Error.Generic.INSTANCE;
            } else {
                generic = Result.UpdateUI.INSTANCE;
            }
            pageUpdatedListener.onPageUpdated(generic);
            if (sharePageResult == null || !sharePageResult.getIsSuccess()) {
                return;
            }
            pageUpdatedListener.onSharedPageSuccessful();
        }
    }
}
