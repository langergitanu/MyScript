package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ISharePageManagerRequester {
    SharePageRequestResultCode addPageSharedUsers(SharePage sharePage, List<SharePageUser> list, String str);

    SharePageRequestResultCode changePageSharedVisibilty(SharePage sharePage, SharePageVisibility sharePageVisibility);

    SharePageRequestResultCode disableSharing(SharePage sharePage);

    List<SharePage> loadSharedPages(long j);

    SharePage pageInfos(String str);

    SharePageRequestResultCode removePageSharedUser(SharePage sharePage, SharePageUser sharePageUser);

    SharePageRequestResultCode removedPageShared(SharePage sharePage);

    void sharePage(SharePage sharePage, String str, String str2, String str3, PageKey pageKey);

    SharePageRequestResultCode updatePageSharedUser(SharePage sharePage, SharePageUser sharePageUser);
}
