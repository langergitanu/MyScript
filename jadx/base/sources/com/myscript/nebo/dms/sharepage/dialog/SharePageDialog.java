package com.myscript.nebo.dms.sharepage.dialog;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.Group;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.SharePageController;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import com.myscript.nebo.dms.sharepage.contacts.p025ui.SharePageInvitePeopleDialogFragment;
import com.myscript.nebo.dms.sharepage.dialog.Result;
import com.myscript.nebo.dms.sharepage.dialog.SharePageInvitedContactAdapter;
import com.myscript.nebo.dms.sharepage.dialog.SinglePageUIController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.SharePageUser;
import com.myscript.snt.dms.SharePageUserRight;
import com.myscript.snt.dms.SharePageVisibility;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: SharePageDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f*\u0001<\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006ijklmnB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000202J\b\u00106\u001a\u000204H\u0002J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000204H\u0016J\b\u0010>\u001a\u000204H\u0016J\u001a\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010A\u001a\u000204H\u0002J\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u000204H\u0016J\u0010\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u000eJ\u0010\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020FH\u0002J\b\u0010K\u001a\u000204H\u0002J\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u000204H\u0016J\b\u0010P\u001a\u000204H\u0002J\b\u0010Q\u001a\u000204H\u0002J\b\u0010R\u001a\u000204H\u0003J\u0010\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u000eH\u0002J\b\u0010U\u001a\u000204H\u0002J\b\u0010V\u001a\u000204H\u0002J\u0006\u0010W\u001a\u000204J\u0006\u0010X\u001a\u000204J\u0006\u0010Y\u001a\u000204J\u0006\u0010Z\u001a\u000204J\u0010\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u000202H\u0016J\u000e\u0010]\u001a\u0002042\u0006\u0010^\u001a\u00020\u000eJ\u0006\u0010_\u001a\u00020FJ\u001e\u0010`\u001a\u0002042\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020\u000eH\u0016J\u0010\u0010e\u001a\u0002042\u0006\u0010f\u001a\u00020\u000eH\u0016J\u0010\u0010g\u001a\u0002042\u0006\u0010h\u001a\u00020FH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=¨\u0006o"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Callback;", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$Callback;", "Lcom/myscript/nebo/dms/sharepage/dialog/SinglePageUIController$PageUpdatedListener;", "<init>", "()V", "sharePageController", "Lcom/myscript/nebo/dms/sharepage/SharePageController;", "callback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$Callback;", "singlePageUIController", "Lcom/myscript/nebo/dms/sharepage/dialog/SinglePageUIController;", "pageTitle", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "thumbnailPath", "noInternetInfo", "Landroid/widget/TextView;", "thumbnail", "Landroid/widget/ImageView;", "thumbnailProgress", "Landroid/widget/ProgressBar;", "pageTitleView", "publishStatus", "publishProgress", "publishCancel", "Landroid/widget/ImageButton;", "publishButton", "Landroid/widget/Button;", "unpublishButton", "shareButton", "invitePeopleButton", "privateAccessGroup", "Landroidx/constraintlayout/widget/Group;", "privateSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "privateSummary", "contactListView", "Landroidx/recyclerview/widget/RecyclerView;", "contactListAdapter", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupFrom", "", "bundle", "loadThumbnail", "onAttach", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "onDetach", "pageUpdateProviderCallback", "com/myscript/nebo/dms/sharepage/dialog/SharePageDialog$pageUpdateProviderCallback$1", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$pageUpdateProviderCallback$1;", "onStart", "onViewCreated", "view", "displayThumbnail", "expand", "onStop", "onPrivateChanged", "isChecked", "", "onThumbnailReady", ClientCookie.PATH_ATTR, "setPrivateCheckedSilent", "checked", "unpublish", "onPageUpdated", "result", "Lcom/myscript/nebo/dms/sharepage/dialog/Result;", "onSharedPageSuccessful", "resetUI", "setFetching", "updateUI", "shareLink", "pageLink", "showSignIn", "showConsent", "showInvitePeople", "learnMoreRequested", "publishRequested", "unpublishRequested", "onSaveInstanceState", "outState", "publishSucceeded", "uuid", "loadPageInfo", "onPeopleInvited", "contactList", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "message", "removeAccess", "email", "changeVisibility", "isPrivate", "ThumbnailCallback", "PageUpdateProvider", "PageUpdateProviderCallback", "Callback", "ImageLoader", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharePageDialog extends BottomSheetDialogFragment implements SharePageInvitePeopleDialogFragment.Callback, SharePageInvitedContactAdapter.Callback, SinglePageUIController.PageUpdatedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHARE_PAGE_INFO_PAGE_KEY = "SHARE_PAGE_INFO_PAGE_KEY";
    private static final String SHARE_PAGE_INFO_PAGE_TITLE = "SHARE_PAGE_INFO_PAGE_TITLE";
    private static final String SHARE_PAGE_INFO_THUMBNAIL_PATH = "SHARE_PAGE_INFO_THUMBNAIL_PATH";
    public static final String TAG = "SharePageDialog";
    private static final boolean USER_CONSENT_CHECK_ENABLED = false;
    private Callback callback;
    private SharePageInvitedContactAdapter contactListAdapter;
    private RecyclerView contactListView;
    private Button invitePeopleButton;
    private TextView noInternetInfo;
    private PageKey pageKey;
    private String pageTitle;
    private TextView pageTitleView;
    private SharePageDialog$pageUpdateProviderCallback$1 pageUpdateProviderCallback = new SharePageDialog$pageUpdateProviderCallback$1(this);
    private Group privateAccessGroup;
    private TextView privateSummary;
    private SwitchCompat privateSwitch;
    private Button publishButton;
    private ImageButton publishCancel;
    private ProgressBar publishProgress;
    private TextView publishStatus;
    private Button shareButton;
    private SharePageController sharePageController;
    private SinglePageUIController singlePageUIController;
    private ImageView thumbnail;
    private String thumbnailPath;
    private ProgressBar thumbnailProgress;
    private Button unpublishButton;

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0016À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$Callback;", "", "resetUUID", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "usesFullscreenDialog", "", "hasValidUserAccount", "hasCloudUserConsent", "setCloudUserConsent", "signInRequested", "getSharePageController", "Lcom/myscript/nebo/dms/sharepage/SharePageController;", "requestThumbnail", "callback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ThumbnailCallback;", "getPageUpdateProvider", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProvider;", "getImageLoader", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ImageLoader;", "onSharedPageSuccessful", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        ImageLoader getImageLoader();

        PageUpdateProvider getPageUpdateProvider();

        SharePageController getSharePageController();

        boolean hasCloudUserConsent();

        boolean hasValidUserAccount();

        void onSharedPageSuccessful();

        boolean requestThumbnail(PageKey pageKey, ThumbnailCallback callback);

        void resetUUID(PageKey pageKey);

        void setCloudUserConsent();

        void signInRequested();

        boolean usesFullscreenDialog();
    }

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ImageLoader;", "", "loadInto", "", "imagePath", "", "imageView", "Landroid/widget/ImageView;", "completionListener", "Ljava/lang/Runnable;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ImageLoader {
        void loadInto(String imagePath, ImageView imageView, Runnable completionListener);
    }

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProvider;", "", "setCallback", "", "callback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProviderCallback;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface PageUpdateProvider {
        void setCallback(PageUpdateProviderCallback callback);
    }

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProviderCallback;", "", "onPageUpdated", "", "pageTitle", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface PageUpdateProviderCallback {
        void onPageUpdated(String pageTitle);
    }

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$ThumbnailCallback;", "", "onThumbnailAvailable", "", "thumbnailPath", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ThumbnailCallback {
        void onThumbnailAvailable(String thumbnailPath);
    }

    @JvmStatic
    public static final SharePageDialog newInstance(PageKey pageKey, String str) {
        return INSTANCE.newInstance(pageKey, str);
    }

    public final void publishSucceeded(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6280R.layout.share_page_publish, container, false);
        if (savedInstanceState == null && (savedInstanceState = getArguments()) == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        setupFrom(savedInstanceState);
        View viewFindViewById = viewInflate.findViewById(C6280R.id.share_page_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        this.pageTitleView = textView;
        SharePageInvitedContactAdapter sharePageInvitedContactAdapter = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageTitleView");
            textView = null;
        }
        String str = this.pageTitle;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageTitle");
            str = null;
        }
        String string = str;
        if (string.length() == 0) {
            string = getString(C6280R.string.untitled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        textView.setText(string);
        View viewFindViewById2 = viewInflate.findViewById(C6280R.id.share_page_no_internet);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.noInternetInfo = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C6280R.id.share_page_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.thumbnail = (ImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C6280R.id.share_page_thumbnail_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.thumbnailProgress = (ProgressBar) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C6280R.id.share_page_publish_status);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.publishStatus = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C6280R.id.share_page_publish_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.publishProgress = (ProgressBar) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(C6280R.id.share_page_cancel_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.publishCancel = (ImageButton) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(C6280R.id.share_page_publish_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.publishButton = (Button) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(C6280R.id.share_page_unpublish_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.unpublishButton = (Button) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(C6280R.id.share_page_share_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.shareButton = (Button) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(C6280R.id.share_page_contact_list);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.contactListView = (RecyclerView) viewFindViewById11;
        this.contactListAdapter = new SharePageInvitedContactAdapter(new ArrayList(), this);
        RecyclerView recyclerView = this.contactListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactListView");
            recyclerView = null;
        }
        SharePageInvitedContactAdapter sharePageInvitedContactAdapter2 = this.contactListAdapter;
        if (sharePageInvitedContactAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactListAdapter");
        } else {
            sharePageInvitedContactAdapter = sharePageInvitedContactAdapter2;
        }
        recyclerView.setAdapter(sharePageInvitedContactAdapter);
        View viewFindViewById12 = viewInflate.findViewById(C6280R.id.share_page_invite_people);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.invitePeopleButton = (Button) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(C6280R.id.share_page_publish_private_switch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.privateSwitch = (SwitchCompat) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(C6280R.id.share_page_private_access_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.privateAccessGroup = (Group) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(C6280R.id.share_page_private_access_summary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.privateSummary = (TextView) viewFindViewById15;
        return viewInflate;
    }

    public final void setupFrom(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString(SHARE_PAGE_INFO_PAGE_TITLE, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.pageTitle = string;
        PageKey pageKeyDeserialize = PageKey.deserialize(bundle.getString(SHARE_PAGE_INFO_PAGE_KEY, ""));
        Intrinsics.checkNotNullExpressionValue(pageKeyDeserialize, "deserialize(...)");
        this.pageKey = pageKeyDeserialize;
        String string2 = bundle.getString(SHARE_PAGE_INFO_THUMBNAIL_PATH, "");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.thumbnailPath = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadThumbnail() {
        View view;
        Callback callback = this.callback;
        if (callback != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            if (callback.requestThumbnail(pageKey, new ThumbnailCallback() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.loadThumbnail.1
                @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.ThumbnailCallback
                public void onThumbnailAvailable(String thumbnailPath) {
                    Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
                    SharePageDialog.this.onThumbnailReady(thumbnailPath);
                }
            }) || (view = getView()) == null) {
                return;
            }
            view.post(new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    SharePageDialog.loadThumbnail$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadThumbnail$lambda$0(SharePageDialog sharePageDialog) {
        if (sharePageDialog.isAdded()) {
            ProgressBar progressBar = sharePageDialog.thumbnailProgress;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailProgress");
                progressBar = null;
            }
            progressBar.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        PageUpdateProvider pageUpdateProvider;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof Callback) {
            Callback callback = (Callback) context;
            this.callback = callback;
            SharePageController sharePageController = callback != null ? callback.getSharePageController() : null;
            this.sharePageController = sharePageController;
            this.singlePageUIController = sharePageController != null ? sharePageController.getSingleSharePageUIController() : null;
            Callback callback2 = this.callback;
            if (callback2 == null || (pageUpdateProvider = callback2.getPageUpdateProvider()) == null) {
                return;
            }
            pageUpdateProvider.setCallback(this.pageUpdateProviderCallback);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        PageUpdateProvider pageUpdateProvider;
        Callback callback = this.callback;
        if (callback != null && (pageUpdateProvider = callback.getPageUpdateProvider()) != null) {
            pageUpdateProvider.setCallback(null);
        }
        this.singlePageUIController = null;
        this.callback = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        displayThumbnail();
        expand();
        Button button = this.publishButton;
        ImageButton imageButton = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.publishRequested();
            }
        });
        Button button2 = this.unpublishButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unpublishButton");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.unpublish();
            }
        });
        Button button3 = this.invitePeopleButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("invitePeopleButton");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showInvitePeople();
            }
        });
        SwitchCompat switchCompat = this.privateSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharePageDialog.onStart$lambda$3(this.f$0, compoundButton, z);
            }
        });
        ImageButton imageButton2 = this.publishCancel;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishCancel");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SharePageDialog.onStart$lambda$4(this.f$0, view);
            }
        });
        Callback callback = this.callback;
        if (callback != null && !callback.hasValidUserAccount()) {
            resetUI();
            showSignIn();
            return;
        }
        SinglePageUIController singlePageUIController = this.singlePageUIController;
        if (singlePageUIController != null) {
            singlePageUIController.reset();
        }
        SinglePageUIController singlePageUIController2 = this.singlePageUIController;
        if (singlePageUIController2 != null) {
            singlePageUIController2.setUpdatedListener(this);
        }
        if (loadPageInfo()) {
            setFetching();
        } else {
            updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$3(SharePageDialog sharePageDialog, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        sharePageDialog.onPrivateChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$4(SharePageDialog sharePageDialog, View view) {
        SharePageController sharePageController = sharePageDialog.sharePageController;
        if (sharePageController != null) {
            sharePageController.cancelCurrentUpload();
        }
        sharePageDialog.updateUI();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().observe(getViewLifecycleOwner(), new SharePageDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharePageDialog.onViewCreated$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(SharePageDialog sharePageDialog, NeboNetworkState neboNetworkState) {
        if (neboNetworkState.isDataTransferAllowed()) {
            if (sharePageDialog.loadPageInfo()) {
                sharePageDialog.setFetching();
            } else {
                sharePageDialog.updateUI();
            }
        } else {
            SharePageController sharePageController = sharePageDialog.sharePageController;
            if (sharePageController != null) {
                sharePageController.cancelCurrentUpload();
            }
            sharePageDialog.updateUI();
        }
        return Unit.INSTANCE;
    }

    private final void displayThumbnail() {
        if (isAdded()) {
            String str = this.thumbnailPath;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailPath");
                str = null;
            }
            if (str.length() > 0) {
                String str3 = this.thumbnailPath;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailPath");
                } else {
                    str2 = str3;
                }
                onThumbnailReady(str2);
                return;
            }
            loadThumbnail();
        }
    }

    private final void expand() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(view2);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Button button = this.publishButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishButton");
            button = null;
        }
        button.setOnClickListener(null);
        Button button2 = this.unpublishButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unpublishButton");
            button2 = null;
        }
        button2.setOnClickListener(null);
        Button button3 = this.invitePeopleButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("invitePeopleButton");
            button3 = null;
        }
        button3.setOnClickListener(null);
        SwitchCompat switchCompat = this.privateSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(null);
        SinglePageUIController singlePageUIController = this.singlePageUIController;
        if (singlePageUIController != null) {
            singlePageUIController.setUpdatedListener(null);
        }
        super.onStop();
    }

    private final void onPrivateChanged(boolean isChecked) {
        changeVisibility(isChecked);
    }

    public final void onThumbnailReady(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.thumbnailPath = path;
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    SharePageDialog.onThumbnailReady$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onThumbnailReady$lambda$0(final SharePageDialog sharePageDialog) {
        Callback callback;
        ImageLoader imageLoader;
        if (!sharePageDialog.isAdded() || (callback = sharePageDialog.callback) == null || (imageLoader = callback.getImageLoader()) == null) {
            return;
        }
        String str = sharePageDialog.thumbnailPath;
        ImageView imageView = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailPath");
            str = null;
        }
        ImageView imageView2 = sharePageDialog.thumbnail;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView2;
        }
        imageLoader.loadInto(str, imageView, new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SharePageDialog.onThumbnailReady$lambda$0$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onThumbnailReady$lambda$0$0(SharePageDialog sharePageDialog) {
        ProgressBar progressBar = sharePageDialog.thumbnailProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailProgress");
            progressBar = null;
        }
        progressBar.setVisibility(8);
    }

    private final void setPrivateCheckedSilent(boolean checked) {
        SwitchCompat switchCompat = this.privateSwitch;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(null);
        SwitchCompat switchCompat3 = this.privateSwitch;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
            switchCompat3 = null;
        }
        switchCompat3.setChecked(checked);
        SwitchCompat switchCompat4 = this.privateSwitch;
        if (switchCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
        } else {
            switchCompat2 = switchCompat4;
        }
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda19
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharePageDialog.setPrivateCheckedSilent$lambda$0(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPrivateCheckedSilent$lambda$0(SharePageDialog sharePageDialog, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        sharePageDialog.onPrivateChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unpublish() {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6280R.string.unpublish_dialog_title).setMessage(C6280R.string.unpublish_dialog_message).setPositiveButton(C6280R.string.unpublish_dialog_positive, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.unpublishRequested();
            }
        }).setNegativeButton(C6280R.string.unpublish_dialog_negative, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SinglePageUIController.PageUpdatedListener
    public void onPageUpdated(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(result, Result.UpdateUI.INSTANCE)) {
            View view = getView();
            if (view != null) {
                view.post(new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.updateUI();
                    }
                });
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(result, Result.Error.NotOwner.INSTANCE)) {
            Callback callback = this.callback;
            if (callback != null) {
                PageKey pageKey = this.pageKey;
                PageKey pageKey2 = null;
                if (pageKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                    pageKey = null;
                }
                callback.resetUUID(pageKey);
                SharePageController sharePageController = this.sharePageController;
                if (sharePageController != null) {
                    PageKey pageKey3 = this.pageKey;
                    if (pageKey3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                    } else {
                        pageKey2 = pageKey3;
                    }
                    sharePageController.sharePage(pageKey2);
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(result, Result.Error.Generic.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (isAdded()) {
            requireView().post(new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    SharePageDialog.onPageUpdated$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageUpdated$lambda$2(SharePageDialog sharePageDialog) {
        Toast.makeText(sharePageDialog.getContext(), "An error occurred", 1).show();
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SinglePageUIController.PageUpdatedListener
    public void onSharedPageSuccessful() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSharedPageSuccessful();
        }
    }

    private final void resetUI() {
        TextView textView = this.publishStatus;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishStatus");
            textView = null;
        }
        textView.setText("");
        Button button = this.publishButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishButton");
            button = null;
        }
        button.setVisibility(8);
        Button button2 = this.shareButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            button2 = null;
        }
        button2.setVisibility(8);
        Button button3 = this.unpublishButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unpublishButton");
            button3 = null;
        }
        button3.setVisibility(8);
        Group group = this.privateAccessGroup;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privateAccessGroup");
            group = null;
        }
        group.setVisibility(8);
        Button button4 = this.invitePeopleButton;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("invitePeopleButton");
            button4 = null;
        }
        button4.setVisibility(8);
        RecyclerView recyclerView = this.contactListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactListView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        ProgressBar progressBar = this.publishProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        ImageButton imageButton = this.publishCancel;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishCancel");
            imageButton = null;
        }
        imageButton.setVisibility(8);
        TextView textView3 = this.noInternetInfo;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noInternetInfo");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(8);
    }

    private final void setFetching() {
        if (isAdded()) {
            resetUI();
            TextView textView = this.publishStatus;
            ProgressBar progressBar = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishStatus");
                textView = null;
            }
            textView.setText(getString(C6280R.string.share_page_fetching_data));
            ProgressBar progressBar2 = this.publishProgress;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
                progressBar2 = null;
            }
            progressBar2.setVisibility(0);
            ProgressBar progressBar3 = this.publishProgress;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
            } else {
                progressBar = progressBar3;
            }
            progressBar.setIndeterminate(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        final SinglePageUIController singlePageUIController;
        if (isAdded() && (singlePageUIController = this.singlePageUIController) != null) {
            final boolean zIsPublished = singlePageUIController.isPublished();
            boolean zIsOutdated = singlePageUIController.isOutdated();
            boolean zIsPrivateSharing = singlePageUIController.isPrivateSharing();
            boolean zIsOperationInProgress = singlePageUIController.isOperationInProgress();
            ComponentCallbacks2 application = requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
            NeboNetworkState value = ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().getValue();
            boolean zIsDataTransferAllowed = value != null ? value.isDataTransferAllowed() : false;
            TextView textView = this.noInternetInfo;
            ImageButton imageButton = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noInternetInfo");
                textView = null;
            }
            textView.setVisibility(!zIsDataTransferAllowed ? 0 : 8);
            TextView textView2 = this.noInternetInfo;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noInternetInfo");
                textView2 = null;
            }
            textView2.setText(getString(!zIsDataTransferAllowed ? C6280R.string.share_page_disabled_cellular_label : C6280R.string.share_page_no_internet_label));
            TextView textView3 = this.publishStatus;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishStatus");
                textView3 = null;
            }
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            textView3.setText(singlePageUIController.getStatusLabel(contextRequireContext));
            String pageTitle = singlePageUIController.getPageTitle();
            if (pageTitle.length() == 0 && (pageTitle = this.pageTitle) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitle");
                pageTitle = null;
            }
            String str = pageTitle;
            TextView textView4 = this.pageTitleView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitleView");
                textView4 = null;
            }
            String string = str;
            if (string.length() == 0) {
                string = getString(C6280R.string.untitled);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            textView4.setText(string);
            Button button = this.publishButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishButton");
                button = null;
            }
            button.setVisibility(!zIsOperationInProgress ? 0 : 8);
            Button button2 = this.publishButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishButton");
                button2 = null;
            }
            button2.setEnabled((!zIsPublished || zIsOutdated) && zIsDataTransferAllowed);
            Button button3 = this.publishButton;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishButton");
                button3 = null;
            }
            button3.setText(getString(!zIsPublished ? C6280R.string.share_page_publish : C6280R.string.share_page_update));
            Button button4 = this.shareButton;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareButton");
                button4 = null;
            }
            button4.setVisibility(zIsPublished ? 0 : 8);
            Button button5 = this.shareButton;
            if (button5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareButton");
                button5 = null;
            }
            button5.setEnabled(zIsDataTransferAllowed);
            Button button6 = this.shareButton;
            if (button6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareButton");
                button6 = null;
            }
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SharePageDialog.updateUI$lambda$2(singlePageUIController, zIsPublished, this, view);
                }
            });
            Button button7 = this.unpublishButton;
            if (button7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unpublishButton");
                button7 = null;
            }
            button7.setVisibility(zIsPublished ? 0 : 8);
            Button button8 = this.unpublishButton;
            if (button8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unpublishButton");
                button8 = null;
            }
            button8.setEnabled(zIsDataTransferAllowed);
            Group group = this.privateAccessGroup;
            if (group == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateAccessGroup");
                group = null;
            }
            group.setVisibility(zIsPublished ? 0 : 8);
            setPrivateCheckedSilent(zIsPrivateSharing);
            SwitchCompat switchCompat = this.privateSwitch;
            if (switchCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateSwitch");
                switchCompat = null;
            }
            switchCompat.setEnabled(zIsDataTransferAllowed);
            TextView textView5 = this.privateSummary;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateSummary");
                textView5 = null;
            }
            textView5.setText(getString(zIsPrivateSharing ? C6280R.string.share_note_private_summary_on : C6280R.string.share_note_private_summary_off));
            boolean z = zIsPublished && zIsPrivateSharing;
            Button button9 = this.invitePeopleButton;
            if (button9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("invitePeopleButton");
                button9 = null;
            }
            button9.setVisibility(z ? 0 : 8);
            Button button10 = this.invitePeopleButton;
            if (button10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("invitePeopleButton");
                button10 = null;
            }
            button10.setEnabled(zIsDataTransferAllowed);
            List<String> contactList = singlePageUIController.getContactList();
            SharePageInvitedContactAdapter sharePageInvitedContactAdapter = this.contactListAdapter;
            if (sharePageInvitedContactAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactListAdapter");
                sharePageInvitedContactAdapter = null;
            }
            sharePageInvitedContactAdapter.setList(contactList);
            RecyclerView recyclerView = this.contactListView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactListView");
                recyclerView = null;
            }
            recyclerView.setVisibility(z && !contactList.isEmpty() ? 0 : 8);
            SharePageInvitedContactAdapter sharePageInvitedContactAdapter2 = this.contactListAdapter;
            if (sharePageInvitedContactAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactListAdapter");
                sharePageInvitedContactAdapter2 = null;
            }
            sharePageInvitedContactAdapter2.setDeleteDisabled(!zIsDataTransferAllowed);
            ProgressBar progressBar = this.publishProgress;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
                progressBar = null;
            }
            progressBar.setVisibility(zIsOperationInProgress ? 0 : 8);
            ProgressBar progressBar2 = this.publishProgress;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
                progressBar2 = null;
            }
            progressBar2.setIndeterminate(!singlePageUIController.isUploading());
            ProgressBar progressBar3 = this.publishProgress;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgress");
                progressBar3 = null;
            }
            progressBar3.setProgress(singlePageUIController.getProgress());
            ImageButton imageButton2 = this.publishCancel;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishCancel");
            } else {
                imageButton = imageButton2;
            }
            imageButton.setVisibility(singlePageUIController.isUploading() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$2(SinglePageUIController singlePageUIController, boolean z, SharePageDialog sharePageDialog, View view) {
        String sharedLink = singlePageUIController.getSharedLink();
        if (z && URLUtil.isValidUrl(singlePageUIController.getSharedLink())) {
            sharePageDialog.shareLink(sharedLink);
        }
    }

    private final void shareLink(String pageLink) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", pageLink);
        startActivity(Intent.createChooser(intent, getString(C6280R.string.share_page_share_link_app_chooser_title)));
    }

    private final void showSignIn() {
        new MaterialAlertDialogBuilder(requireContext()).setMessage(C6280R.string.share_page_unsigned_explanation).setPositiveButton(C6280R.string.share_page_sign_in, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SharePageDialog.showSignIn$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6280R.string.share_page_cancel, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.dismiss();
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSignIn$lambda$0(SharePageDialog sharePageDialog, DialogInterface dialogInterface, int i) {
        Callback callback = sharePageDialog.callback;
        if (callback != null) {
            callback.signInRequested();
        }
    }

    private final void showConsent() {
        new MaterialAlertDialogBuilder(requireContext()).setMessage(C6280R.string.share_page_consent_explanation).setPositiveButton(C6280R.string.share_page_accept, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SharePageDialog.showConsent$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6280R.string.share_page_decline, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.dismiss();
            }
        }).setNeutralButton(C6280R.string.share_page_learn_more, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SharePageDialog.showConsent$lambda$2(this.f$0, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConsent$lambda$0(SharePageDialog sharePageDialog, DialogInterface dialogInterface, int i) {
        Callback callback = sharePageDialog.callback;
        if (callback != null) {
            callback.setCloudUserConsent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConsent$lambda$2(SharePageDialog sharePageDialog, DialogInterface dialogInterface, int i) {
        sharePageDialog.learnMoreRequested();
        sharePageDialog.dismiss();
    }

    public final void showInvitePeople() {
        SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragmentNewInstance = SharePageInvitePeopleDialogFragment.INSTANCE.newInstance();
        sharePageInvitePeopleDialogFragmentNewInstance.setCallback(this);
        sharePageInvitePeopleDialogFragmentNewInstance.show(getChildFragmentManager(), SharePageInvitePeopleDialogFragment.TAG);
    }

    public final void learnMoreRequested() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(getString(C6280R.string.privacy_policy_url)));
        startActivity(intent);
    }

    public final void publishRequested() {
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            sharePageController.sharePage(pageKey);
        }
    }

    public final void unpublishRequested() {
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            sharePageController.removeSharePage(pageKey);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        PageKey pageKey = this.pageKey;
        if (pageKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageKey");
            pageKey = null;
        }
        outState.putString(SHARE_PAGE_INFO_PAGE_KEY, pageKey.serialize());
        String str = this.thumbnailPath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailPath");
            str = null;
        }
        outState.putString(SHARE_PAGE_INFO_THUMBNAIL_PATH, str);
        SinglePageUIController singlePageUIController = this.singlePageUIController;
        if (singlePageUIController != null && singlePageUIController.isPublished()) {
            SinglePageUIController singlePageUIController2 = this.singlePageUIController;
            outState.putString(SHARE_PAGE_INFO_PAGE_TITLE, singlePageUIController2 != null ? singlePageUIController2.getPageTitle() : null);
        } else {
            String str2 = this.pageTitle;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitle");
            } else {
                str = str2;
            }
            outState.putString(SHARE_PAGE_INFO_PAGE_TITLE, str);
        }
        super.onSaveInstanceState(outState);
    }

    public final boolean loadPageInfo() {
        PageKey pageKey = this.pageKey;
        PageKey pageKey2 = null;
        if (pageKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageKey");
            pageKey = null;
        }
        if (!pageKey.isValid()) {
            return false;
        }
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController == null) {
            return true;
        }
        PageKey pageKey3 = this.pageKey;
        if (pageKey3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageKey");
        } else {
            pageKey2 = pageKey3;
        }
        sharePageController.loadPageInfos(pageKey2);
        return true;
    }

    @Override // com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment.Callback
    public void onPeopleInvited(List<ContactItem> contactList, String message) {
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(message, "message");
        List<ContactItem> list = contactList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SharePageUser sharePageUser = new SharePageUser(((ContactItem) it.next()).getEmail());
            sharePageUser.setUserRight(SharePageUserRight.READ);
            arrayList.add(sharePageUser);
        }
        ArrayList arrayList2 = arrayList;
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            sharePageController.addUsers(pageKey, arrayList2, message);
        }
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageInvitedContactAdapter.Callback
    public void removeAccess(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            sharePageController.removeUser(pageKey, email);
        }
    }

    private final void changeVisibility(boolean isPrivate) {
        SharePageController sharePageController = this.sharePageController;
        if (sharePageController != null) {
            PageKey pageKey = this.pageKey;
            if (pageKey == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageKey");
                pageKey = null;
            }
            sharePageController.changeVisibility(pageKey, isPrivate ? SharePageVisibility.PRIVATE : SharePageVisibility.PUBLIC);
        }
    }

    /* JADX INFO: compiled from: SharePageDialog.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$Companion;", "", "<init>", "()V", "TAG", "", "USER_CONSENT_CHECK_ENABLED", "", SharePageDialog.SHARE_PAGE_INFO_PAGE_TITLE, SharePageDialog.SHARE_PAGE_INFO_PAGE_KEY, SharePageDialog.SHARE_PAGE_INFO_THUMBNAIL_PATH, "newInstance", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "pageTitle", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SharePageDialog newInstance(PageKey pageKey, String pageTitle) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
            SharePageDialog sharePageDialog = new SharePageDialog();
            Bundle bundle = new Bundle();
            bundle.putString(SharePageDialog.SHARE_PAGE_INFO_PAGE_KEY, pageKey.serialize());
            bundle.putString(SharePageDialog.SHARE_PAGE_INFO_PAGE_TITLE, pageTitle);
            sharePageDialog.setArguments(bundle);
            return sharePageDialog;
        }
    }
}
