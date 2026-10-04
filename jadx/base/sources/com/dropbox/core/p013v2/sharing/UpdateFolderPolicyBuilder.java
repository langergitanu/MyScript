package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.UpdateFolderPolicyArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateFolderPolicyBuilder {
    private final UpdateFolderPolicyArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    UpdateFolderPolicyBuilder(DbxUserSharingRequests dbxUserSharingRequests, UpdateFolderPolicyArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public UpdateFolderPolicyBuilder withMemberPolicy(MemberPolicy memberPolicy) {
        this._builder.withMemberPolicy(memberPolicy);
        return this;
    }

    public UpdateFolderPolicyBuilder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
        this._builder.withAclUpdatePolicy(aclUpdatePolicy);
        return this;
    }

    public UpdateFolderPolicyBuilder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
        this._builder.withViewerInfoPolicy(viewerInfoPolicy);
        return this;
    }

    public UpdateFolderPolicyBuilder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
        this._builder.withSharedLinkPolicy(sharedLinkPolicy);
        return this;
    }

    public UpdateFolderPolicyBuilder withLinkSettings(LinkSettings linkSettings) {
        this._builder.withLinkSettings(linkSettings);
        return this;
    }

    public UpdateFolderPolicyBuilder withActions(List<FolderAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public SharedFolderMetadata start() throws DbxException {
        return this._client.updateFolderPolicy(this._builder.build());
    }
}
