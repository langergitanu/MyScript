package com.myscript.nebo.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import com.myscript.nebo.clipboard.ClipboardContentProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickDocumentContract.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/common/PickDocumentContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "<init>", "()V", "parseResult", "resultCode", "", "intent", "Landroid/content/Intent;", "createIntent", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PickDocumentContract extends ActivityResultContract<String[], Uri> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Uri parseResult(int resultCode, Intent intent) {
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, String[] input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType(ClipboardContentProvider.ALL_FILTER);
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", input);
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            intent.setAction("android.intent.action.GET_CONTENT");
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                intent.setAction("android.intent.action.PICK");
                return intent;
            }
        }
        return intent;
    }
}
