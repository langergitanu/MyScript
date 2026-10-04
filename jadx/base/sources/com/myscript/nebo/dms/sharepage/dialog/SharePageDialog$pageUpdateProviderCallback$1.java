package com.myscript.nebo.dms.sharepage.dialog;

import android.widget.TextView;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.dialog.SharePageDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharePageDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"com/myscript/nebo/dms/sharepage/dialog/SharePageDialog$pageUpdateProviderCallback$1", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageDialog$PageUpdateProviderCallback;", "onPageUpdated", "", "pageTitle", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharePageDialog$pageUpdateProviderCallback$1 implements SharePageDialog.PageUpdateProviderCallback {
    final /* synthetic */ SharePageDialog this$0;

    SharePageDialog$pageUpdateProviderCallback$1(SharePageDialog sharePageDialog) {
        this.this$0 = sharePageDialog;
    }

    @Override // com.myscript.nebo.dms.sharepage.dialog.SharePageDialog.PageUpdateProviderCallback
    public void onPageUpdated(final String pageTitle) {
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        TextView textView = this.this$0.pageTitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageTitleView");
            textView = null;
        }
        final SharePageDialog sharePageDialog = this.this$0;
        textView.post(new Runnable() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageDialog$pageUpdateProviderCallback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SharePageDialog$pageUpdateProviderCallback$1.onPageUpdated$lambda$0(sharePageDialog, pageTitle);
            }
        });
        this.this$0.loadThumbnail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageUpdated$lambda$0(SharePageDialog sharePageDialog, String str) {
        if (sharePageDialog.isAdded()) {
            TextView textView = sharePageDialog.pageTitleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitleView");
                textView = null;
            }
            String string = str;
            if (string.length() == 0) {
                string = sharePageDialog.getString(C6280R.string.untitled);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            textView.setText(string);
        }
    }
}
