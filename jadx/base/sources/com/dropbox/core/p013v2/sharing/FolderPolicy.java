package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AclUpdatePolicy;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FolderPolicy {

    @Nonnull
    protected final AclUpdatePolicy aclUpdatePolicy;

    @Nullable
    protected final MemberPolicy memberPolicy;

    @Nullable
    protected final MemberPolicy resolvedMemberPolicy;

    @Nonnull
    protected final SharedLinkPolicy sharedLinkPolicy;

    @Nullable
    protected final ViewerInfoPolicy viewerInfoPolicy;

    public FolderPolicy(@Nonnull AclUpdatePolicy aclUpdatePolicy, @Nonnull SharedLinkPolicy sharedLinkPolicy, @Nullable MemberPolicy memberPolicy, @Nullable MemberPolicy memberPolicy2, @Nullable ViewerInfoPolicy viewerInfoPolicy) {
        this.memberPolicy = memberPolicy;
        this.resolvedMemberPolicy = memberPolicy2;
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
        }
        this.aclUpdatePolicy = aclUpdatePolicy;
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
        }
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.viewerInfoPolicy = viewerInfoPolicy;
    }

    public FolderPolicy(@Nonnull AclUpdatePolicy aclUpdatePolicy, @Nonnull SharedLinkPolicy sharedLinkPolicy) {
        this(aclUpdatePolicy, sharedLinkPolicy, null, null, null);
    }

    @Nonnull
    public AclUpdatePolicy getAclUpdatePolicy() {
        return this.aclUpdatePolicy;
    }

    @Nonnull
    public SharedLinkPolicy getSharedLinkPolicy() {
        return this.sharedLinkPolicy;
    }

    @Nullable
    public MemberPolicy getMemberPolicy() {
        return this.memberPolicy;
    }

    @Nullable
    public MemberPolicy getResolvedMemberPolicy() {
        return this.resolvedMemberPolicy;
    }

    @Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return this.viewerInfoPolicy;
    }

    public static Builder newBuilder(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
        return new Builder(aclUpdatePolicy, sharedLinkPolicy);
    }

    public static class Builder {
        protected final AclUpdatePolicy aclUpdatePolicy;
        protected MemberPolicy memberPolicy;
        protected MemberPolicy resolvedMemberPolicy;
        protected final SharedLinkPolicy sharedLinkPolicy;
        protected ViewerInfoPolicy viewerInfoPolicy;

        protected Builder(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
            if (aclUpdatePolicy == null) {
                throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
            }
            this.aclUpdatePolicy = aclUpdatePolicy;
            if (sharedLinkPolicy == null) {
                throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
            }
            this.sharedLinkPolicy = sharedLinkPolicy;
            this.memberPolicy = null;
            this.resolvedMemberPolicy = null;
            this.viewerInfoPolicy = null;
        }

        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            return this;
        }

        public Builder withResolvedMemberPolicy(MemberPolicy memberPolicy) {
            this.resolvedMemberPolicy = memberPolicy;
            return this;
        }

        public Builder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
            this.viewerInfoPolicy = viewerInfoPolicy;
            return this;
        }

        public FolderPolicy build() {
            return new FolderPolicy(this.aclUpdatePolicy, this.sharedLinkPolicy, this.memberPolicy, this.resolvedMemberPolicy, this.viewerInfoPolicy);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.memberPolicy, this.resolvedMemberPolicy, this.aclUpdatePolicy, this.sharedLinkPolicy, this.viewerInfoPolicy});
    }

    public boolean equals(Object obj) {
        SharedLinkPolicy sharedLinkPolicy;
        SharedLinkPolicy sharedLinkPolicy2;
        MemberPolicy memberPolicy;
        MemberPolicy memberPolicy2;
        MemberPolicy memberPolicy3;
        MemberPolicy memberPolicy4;
        ViewerInfoPolicy viewerInfoPolicy;
        ViewerInfoPolicy viewerInfoPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderPolicy folderPolicy = (FolderPolicy) obj;
        AclUpdatePolicy aclUpdatePolicy = this.aclUpdatePolicy;
        AclUpdatePolicy aclUpdatePolicy2 = folderPolicy.aclUpdatePolicy;
        return (aclUpdatePolicy == aclUpdatePolicy2 || aclUpdatePolicy.equals(aclUpdatePolicy2)) && ((sharedLinkPolicy = this.sharedLinkPolicy) == (sharedLinkPolicy2 = folderPolicy.sharedLinkPolicy) || sharedLinkPolicy.equals(sharedLinkPolicy2)) && (((memberPolicy = this.memberPolicy) == (memberPolicy2 = folderPolicy.memberPolicy) || (memberPolicy != null && memberPolicy.equals(memberPolicy2))) && (((memberPolicy3 = this.resolvedMemberPolicy) == (memberPolicy4 = folderPolicy.resolvedMemberPolicy) || (memberPolicy3 != null && memberPolicy3.equals(memberPolicy4))) && ((viewerInfoPolicy = this.viewerInfoPolicy) == (viewerInfoPolicy2 = folderPolicy.viewerInfoPolicy) || (viewerInfoPolicy != null && viewerInfoPolicy.equals(viewerInfoPolicy2)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderPolicy folderPolicy, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("acl_update_policy");
            AclUpdatePolicy.Serializer.INSTANCE.serialize(folderPolicy.aclUpdatePolicy, jsonGenerator);
            jsonGenerator.writeFieldName("shared_link_policy");
            SharedLinkPolicy.Serializer.INSTANCE.serialize(folderPolicy.sharedLinkPolicy, jsonGenerator);
            if (folderPolicy.memberPolicy != null) {
                jsonGenerator.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(folderPolicy.memberPolicy, jsonGenerator);
            }
            if (folderPolicy.resolvedMemberPolicy != null) {
                jsonGenerator.writeFieldName("resolved_member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(folderPolicy.resolvedMemberPolicy, jsonGenerator);
            }
            if (folderPolicy.viewerInfoPolicy != null) {
                jsonGenerator.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(folderPolicy.viewerInfoPolicy, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderPolicy deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AclUpdatePolicy aclUpdatePolicyDeserialize = null;
                SharedLinkPolicy sharedLinkPolicyDeserialize = null;
                MemberPolicy memberPolicy = null;
                MemberPolicy memberPolicy2 = null;
                ViewerInfoPolicy viewerInfoPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("acl_update_policy".equals(currentName)) {
                        aclUpdatePolicyDeserialize = AclUpdatePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_link_policy".equals(currentName)) {
                        sharedLinkPolicyDeserialize = SharedLinkPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("member_policy".equals(currentName)) {
                        memberPolicy = (MemberPolicy) StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("resolved_member_policy".equals(currentName)) {
                        memberPolicy2 = (MemberPolicy) StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("viewer_info_policy".equals(currentName)) {
                        viewerInfoPolicy = (ViewerInfoPolicy) StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (aclUpdatePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"acl_update_policy\" missing.");
                }
                if (sharedLinkPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_link_policy\" missing.");
                }
                FolderPolicy folderPolicy = new FolderPolicy(aclUpdatePolicyDeserialize, sharedLinkPolicyDeserialize, memberPolicy, memberPolicy2, viewerInfoPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderPolicy, folderPolicy.toStringMultiline());
                return folderPolicy;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
