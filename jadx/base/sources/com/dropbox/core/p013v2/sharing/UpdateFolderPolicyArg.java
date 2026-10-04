package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AclUpdatePolicy;
import com.dropbox.core.p013v2.sharing.FolderAction;
import com.dropbox.core.p013v2.sharing.LinkSettings;
import com.dropbox.core.p013v2.sharing.MemberPolicy;
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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class UpdateFolderPolicyArg {

    @Nullable
    protected final AclUpdatePolicy aclUpdatePolicy;

    @Nullable
    protected final List<FolderAction> actions;

    @Nullable
    protected final LinkSettings linkSettings;

    @Nullable
    protected final MemberPolicy memberPolicy;

    @Nonnull
    protected final String sharedFolderId;

    @Nullable
    protected final SharedLinkPolicy sharedLinkPolicy;

    @Nullable
    protected final ViewerInfoPolicy viewerInfoPolicy;

    public UpdateFolderPolicyArg(@Nonnull String str, @Nullable MemberPolicy memberPolicy, @Nullable AclUpdatePolicy aclUpdatePolicy, @Nullable ViewerInfoPolicy viewerInfoPolicy, @Nullable SharedLinkPolicy sharedLinkPolicy, @Nullable LinkSettings linkSettings, @Nullable List<FolderAction> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
        this.memberPolicy = memberPolicy;
        this.aclUpdatePolicy = aclUpdatePolicy;
        this.viewerInfoPolicy = viewerInfoPolicy;
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.linkSettings = linkSettings;
        if (list != null) {
            Iterator<FolderAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = list;
    }

    public UpdateFolderPolicyArg(@Nonnull String str) {
        this(str, null, null, null, null, null, null);
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nullable
    public MemberPolicy getMemberPolicy() {
        return this.memberPolicy;
    }

    @Nullable
    public AclUpdatePolicy getAclUpdatePolicy() {
        return this.aclUpdatePolicy;
    }

    @Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return this.viewerInfoPolicy;
    }

    @Nullable
    public SharedLinkPolicy getSharedLinkPolicy() {
        return this.sharedLinkPolicy;
    }

    @Nullable
    public LinkSettings getLinkSettings() {
        return this.linkSettings;
    }

    @Nullable
    public List<FolderAction> getActions() {
        return this.actions;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected AclUpdatePolicy aclUpdatePolicy;
        protected List<FolderAction> actions;
        protected LinkSettings linkSettings;
        protected MemberPolicy memberPolicy;
        protected final String sharedFolderId;
        protected SharedLinkPolicy sharedLinkPolicy;
        protected ViewerInfoPolicy viewerInfoPolicy;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str;
            this.memberPolicy = null;
            this.aclUpdatePolicy = null;
            this.viewerInfoPolicy = null;
            this.sharedLinkPolicy = null;
            this.linkSettings = null;
            this.actions = null;
        }

        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            return this;
        }

        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }

        public Builder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
            this.viewerInfoPolicy = viewerInfoPolicy;
            return this;
        }

        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        public Builder withLinkSettings(LinkSettings linkSettings) {
            this.linkSettings = linkSettings;
            return this;
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

        public UpdateFolderPolicyArg build() {
            return new UpdateFolderPolicyArg(this.sharedFolderId, this.memberPolicy, this.aclUpdatePolicy, this.viewerInfoPolicy, this.sharedLinkPolicy, this.linkSettings, this.actions);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderId, this.memberPolicy, this.aclUpdatePolicy, this.viewerInfoPolicy, this.sharedLinkPolicy, this.linkSettings, this.actions});
    }

    public boolean equals(Object obj) {
        MemberPolicy memberPolicy;
        MemberPolicy memberPolicy2;
        AclUpdatePolicy aclUpdatePolicy;
        AclUpdatePolicy aclUpdatePolicy2;
        ViewerInfoPolicy viewerInfoPolicy;
        ViewerInfoPolicy viewerInfoPolicy2;
        SharedLinkPolicy sharedLinkPolicy;
        SharedLinkPolicy sharedLinkPolicy2;
        LinkSettings linkSettings;
        LinkSettings linkSettings2;
        List<FolderAction> list;
        List<FolderAction> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UpdateFolderPolicyArg updateFolderPolicyArg = (UpdateFolderPolicyArg) obj;
        String str = this.sharedFolderId;
        String str2 = updateFolderPolicyArg.sharedFolderId;
        return (str == str2 || str.equals(str2)) && ((memberPolicy = this.memberPolicy) == (memberPolicy2 = updateFolderPolicyArg.memberPolicy) || (memberPolicy != null && memberPolicy.equals(memberPolicy2))) && (((aclUpdatePolicy = this.aclUpdatePolicy) == (aclUpdatePolicy2 = updateFolderPolicyArg.aclUpdatePolicy) || (aclUpdatePolicy != null && aclUpdatePolicy.equals(aclUpdatePolicy2))) && (((viewerInfoPolicy = this.viewerInfoPolicy) == (viewerInfoPolicy2 = updateFolderPolicyArg.viewerInfoPolicy) || (viewerInfoPolicy != null && viewerInfoPolicy.equals(viewerInfoPolicy2))) && (((sharedLinkPolicy = this.sharedLinkPolicy) == (sharedLinkPolicy2 = updateFolderPolicyArg.sharedLinkPolicy) || (sharedLinkPolicy != null && sharedLinkPolicy.equals(sharedLinkPolicy2))) && (((linkSettings = this.linkSettings) == (linkSettings2 = updateFolderPolicyArg.linkSettings) || (linkSettings != null && linkSettings.equals(linkSettings2))) && ((list = this.actions) == (list2 = updateFolderPolicyArg.actions) || (list != null && list.equals(list2)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UpdateFolderPolicyArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UpdateFolderPolicyArg updateFolderPolicyArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(updateFolderPolicyArg.sharedFolderId, jsonGenerator);
            if (updateFolderPolicyArg.memberPolicy != null) {
                jsonGenerator.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(updateFolderPolicyArg.memberPolicy, jsonGenerator);
            }
            if (updateFolderPolicyArg.aclUpdatePolicy != null) {
                jsonGenerator.writeFieldName("acl_update_policy");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(updateFolderPolicyArg.aclUpdatePolicy, jsonGenerator);
            }
            if (updateFolderPolicyArg.viewerInfoPolicy != null) {
                jsonGenerator.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(updateFolderPolicyArg.viewerInfoPolicy, jsonGenerator);
            }
            if (updateFolderPolicyArg.sharedLinkPolicy != null) {
                jsonGenerator.writeFieldName("shared_link_policy");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(updateFolderPolicyArg.sharedLinkPolicy, jsonGenerator);
            }
            if (updateFolderPolicyArg.linkSettings != null) {
                jsonGenerator.writeFieldName("link_settings");
                StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).serialize(updateFolderPolicyArg.linkSettings, jsonGenerator);
            }
            if (updateFolderPolicyArg.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).serialize(updateFolderPolicyArg.actions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UpdateFolderPolicyArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                MemberPolicy memberPolicy = null;
                AclUpdatePolicy aclUpdatePolicy = null;
                ViewerInfoPolicy viewerInfoPolicy = null;
                SharedLinkPolicy sharedLinkPolicy = null;
                LinkSettings linkSettings = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member_policy".equals(currentName)) {
                        memberPolicy = (MemberPolicy) StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("acl_update_policy".equals(currentName)) {
                        aclUpdatePolicy = (AclUpdatePolicy) StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("viewer_info_policy".equals(currentName)) {
                        viewerInfoPolicy = (ViewerInfoPolicy) StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("shared_link_policy".equals(currentName)) {
                        sharedLinkPolicy = (SharedLinkPolicy) StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("link_settings".equals(currentName)) {
                        linkSettings = (LinkSettings) StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("actions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                UpdateFolderPolicyArg updateFolderPolicyArg = new UpdateFolderPolicyArg(strDeserialize, memberPolicy, aclUpdatePolicy, viewerInfoPolicy, sharedLinkPolicy, linkSettings, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(updateFolderPolicyArg, updateFolderPolicyArg.toStringMultiline());
                return updateFolderPolicyArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
