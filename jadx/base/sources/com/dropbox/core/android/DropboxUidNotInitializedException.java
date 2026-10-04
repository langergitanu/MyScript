package com.dropbox.core.android;

import com.dropbox.core.DbxException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DropboxUidNotInitializedException.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m1599d2 = {"Lcom/dropbox/core/android/DropboxUidNotInitializedException;", "Lcom/dropbox/core/DbxException;", "message", "", "(Ljava/lang/String;)V", "Companion", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class DropboxUidNotInitializedException extends DbxException {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: DropboxUidNotInitializedException.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"Lcom/dropbox/core/android/DropboxUidNotInitializedException$Companion;", "", "()V", "serialVersionUID", "", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DropboxUidNotInitializedException(String str) {
        super(str);
    }
}
