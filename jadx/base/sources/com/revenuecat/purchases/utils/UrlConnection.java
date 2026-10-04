package com.revenuecat.purchases.utils;

import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlConnectionFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/UrlConnection;", "", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "responseCode", "", "getResponseCode", "()I", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface UrlConnection {
    void disconnect();

    InputStream getInputStream();

    int getResponseCode();
}
