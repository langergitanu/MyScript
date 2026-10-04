package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ShareFolderArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ShareFolderBuilder {
    private final ShareFolderArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    ShareFolderBuilder(DbxUserSharingRequests dbxUserSharingRequests, ShareFolderArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ShareFolderBuilder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
        this._builder.withAclUpdatePolicy(aclUpdatePolicy);
        return this;
    }

    public ShareFolderBuilder withForceAsync(Boolean bool) {
        this._builder.withForceAsync(bool);
        return this;
    }

    public ShareFolderBuilder withMemberPolicy(MemberPolicy memberPolicy) {
        this._builder.withMemberPolicy(memberPolicy);
        return this;
    }

    public ShareFolderBuilder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
        this._builder.withSharedLinkPolicy(sharedLinkPolicy);
        return this;
    }

    public ShareFolderBuilder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
        this._builder.withViewerInfoPolicy(viewerInfoPolicy);
        return this;
    }

    public ShareFolderBuilder withAccessInheritance(AccessInheritance accessInheritance) {
        this._builder.withAccessInheritance(accessInheritance);
        return this;
    }

    public ShareFolderBuilder withActions(List<FolderAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public ShareFolderBuilder withLinkSettings(LinkSettings linkSettings) {
        this._builder.withLinkSettings(linkSettings);
        return this;
    }

    public ShareFolderLaunch start() throws DbxException {
        return this._client.shareFolder(this._builder.build());
    }
}
