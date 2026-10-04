package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessInheritance;
import com.dropbox.core.p013v2.sharing.AclUpdatePolicy;
import com.dropbox.core.p013v2.sharing.FolderAction;
import com.dropbox.core.p013v2.sharing.LinkSettings;
import com.dropbox.core.p013v2.sharing.MemberPolicy;
import com.dropbox.core.p013v2.sharing.ShareFolderArgBase;
import com.dropbox.core.p013v2.sharing.SharedLinkPolicy;
import com.dropbox.core.p013v2.sharing.ViewerInfoPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class ShareFolderArg extends ShareFolderArgBase {

    @Nullable
    protected final List<FolderAction> actions;

    @Nullable
    protected final LinkSettings linkSettings;

    public ShareFolderArg(@Nonnull String str, @Nullable AclUpdatePolicy aclUpdatePolicy, boolean z, @Nullable MemberPolicy memberPolicy, @Nullable SharedLinkPolicy sharedLinkPolicy, @Nullable ViewerInfoPolicy viewerInfoPolicy, @Nonnull AccessInheritance accessInheritance, @Nullable List<FolderAction> list, @Nullable LinkSettings linkSettings) {
        super(str, aclUpdatePolicy, z, memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritance);
        if (list != null) {
            Iterator<FolderAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = list;
        this.linkSettings = linkSettings;
    }

    public ShareFolderArg(@Nonnull String str) {
        this(str, null, false, null, null, null, AccessInheritance.INHERIT, null, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nullable
    public AclUpdatePolicy getAclUpdatePolicy() {
        return this.aclUpdatePolicy;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    public boolean getForceAsync() {
        return this.forceAsync;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nullable
    public MemberPolicy getMemberPolicy() {
        return this.memberPolicy;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nullable
    public SharedLinkPolicy getSharedLinkPolicy() {
        return this.sharedLinkPolicy;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return this.viewerInfoPolicy;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    @Nonnull
    public AccessInheritance getAccessInheritance() {
        return this.accessInheritance;
    }

    @Nullable
    public List<FolderAction> getActions() {
        return this.actions;
    }

    @Nullable
    public LinkSettings getLinkSettings() {
        return this.linkSettings;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends ShareFolderArgBase.Builder {
        protected List<FolderAction> actions;
        protected LinkSettings linkSettings;

        protected Builder(String str) {
            super(str);
            this.actions = null;
            this.linkSettings = null;
        }

        public Builder withActions(List<FolderAction> list) {
            if (list != null) {
                Iterator<FolderAction> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = list;
            return this;
        }

        public Builder withLinkSettings(LinkSettings linkSettings) {
            this.linkSettings = linkSettings;
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            super.withAclUpdatePolicy(aclUpdatePolicy);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withForceAsync(Boolean bool) {
            super.withForceAsync(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            super.withMemberPolicy(memberPolicy);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            super.withSharedLinkPolicy(sharedLinkPolicy);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
            super.withViewerInfoPolicy(viewerInfoPolicy);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public Builder withAccessInheritance(AccessInheritance accessInheritance) {
            super.withAccessInheritance(accessInheritance);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ShareFolderArgBase.Builder
        public ShareFolderArg build() {
            return new ShareFolderArg(this.path, this.aclUpdatePolicy, this.forceAsync, this.memberPolicy, this.sharedLinkPolicy, this.viewerInfoPolicy, this.accessInheritance, this.actions, this.linkSettings);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.actions, this.linkSettings});
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    public boolean equals(Object obj) {
        List<FolderAction> list;
        List<FolderAction> list2;
        LinkSettings linkSettings;
        LinkSettings linkSettings2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ShareFolderArg shareFolderArg = (ShareFolderArg) obj;
            if ((this.path == shareFolderArg.path || this.path.equals(shareFolderArg.path)) && ((this.aclUpdatePolicy == shareFolderArg.aclUpdatePolicy || (this.aclUpdatePolicy != null && this.aclUpdatePolicy.equals(shareFolderArg.aclUpdatePolicy))) && this.forceAsync == shareFolderArg.forceAsync && ((this.memberPolicy == shareFolderArg.memberPolicy || (this.memberPolicy != null && this.memberPolicy.equals(shareFolderArg.memberPolicy))) && ((this.sharedLinkPolicy == shareFolderArg.sharedLinkPolicy || (this.sharedLinkPolicy != null && this.sharedLinkPolicy.equals(shareFolderArg.sharedLinkPolicy))) && ((this.viewerInfoPolicy == shareFolderArg.viewerInfoPolicy || (this.viewerInfoPolicy != null && this.viewerInfoPolicy.equals(shareFolderArg.viewerInfoPolicy))) && ((this.accessInheritance == shareFolderArg.accessInheritance || this.accessInheritance.equals(shareFolderArg.accessInheritance)) && (((list = this.actions) == (list2 = shareFolderArg.actions) || (list != null && list.equals(list2))) && ((linkSettings = this.linkSettings) == (linkSettings2 = shareFolderArg.linkSettings) || (linkSettings != null && linkSettings.equals(linkSettings2)))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.ShareFolderArgBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShareFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShareFolderArg shareFolderArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(shareFolderArg.path, jsonGenerator);
            if (shareFolderArg.aclUpdatePolicy != null) {
                jsonGenerator.writeFieldName("acl_update_policy");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(shareFolderArg.aclUpdatePolicy, jsonGenerator);
            }
            jsonGenerator.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(shareFolderArg.forceAsync), jsonGenerator);
            if (shareFolderArg.memberPolicy != null) {
                jsonGenerator.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(shareFolderArg.memberPolicy, jsonGenerator);
            }
            if (shareFolderArg.sharedLinkPolicy != null) {
                jsonGenerator.writeFieldName("shared_link_policy");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(shareFolderArg.sharedLinkPolicy, jsonGenerator);
            }
            if (shareFolderArg.viewerInfoPolicy != null) {
                jsonGenerator.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(shareFolderArg.viewerInfoPolicy, jsonGenerator);
            }
            jsonGenerator.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(shareFolderArg.accessInheritance, jsonGenerator);
            if (shareFolderArg.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).serialize(shareFolderArg.actions, jsonGenerator);
            }
            if (shareFolderArg.linkSettings != null) {
                jsonGenerator.writeFieldName("link_settings");
                StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).serialize(shareFolderArg.linkSettings, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShareFolderArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                String strDeserialize = null;
                AclUpdatePolicy aclUpdatePolicy = null;
                MemberPolicy memberPolicy = null;
                SharedLinkPolicy sharedLinkPolicy = null;
                ViewerInfoPolicy viewerInfoPolicy = null;
                List list = null;
                LinkSettings linkSettings = null;
                AccessInheritance accessInheritanceDeserialize = AccessInheritance.INHERIT;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("acl_update_policy".equals(currentName)) {
                        aclUpdatePolicy = (AclUpdatePolicy) StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("force_async".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("member_policy".equals(currentName)) {
                        memberPolicy = (MemberPolicy) StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("shared_link_policy".equals(currentName)) {
                        sharedLinkPolicy = (SharedLinkPolicy) StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("viewer_info_policy".equals(currentName)) {
                        viewerInfoPolicy = (ViewerInfoPolicy) StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("access_inheritance".equals(currentName)) {
                        accessInheritanceDeserialize = AccessInheritance.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("actions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("link_settings".equals(currentName)) {
                        linkSettings = (LinkSettings) StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ShareFolderArg shareFolderArg = new ShareFolderArg(strDeserialize, aclUpdatePolicy, boolDeserialize.booleanValue(), memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritanceDeserialize, list, linkSettings);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(shareFolderArg, shareFolderArg.toStringMultiline());
                return shareFolderArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
