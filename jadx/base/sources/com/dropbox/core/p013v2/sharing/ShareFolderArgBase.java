package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessInheritance;
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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class ShareFolderArgBase {

    @Nonnull
    protected final AccessInheritance accessInheritance;

    @Nullable
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final boolean forceAsync;

    @Nullable
    protected final MemberPolicy memberPolicy;

    @Nonnull
    protected final String path;

    @Nullable
    protected final SharedLinkPolicy sharedLinkPolicy;

    @Nullable
    protected final ViewerInfoPolicy viewerInfoPolicy;

    public ShareFolderArgBase(@Nonnull String str, @Nullable AclUpdatePolicy aclUpdatePolicy, boolean z, @Nullable MemberPolicy memberPolicy, @Nullable SharedLinkPolicy sharedLinkPolicy, @Nullable ViewerInfoPolicy viewerInfoPolicy, @Nonnull AccessInheritance accessInheritance) {
        this.aclUpdatePolicy = aclUpdatePolicy;
        this.forceAsync = z;
        this.memberPolicy = memberPolicy;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.viewerInfoPolicy = viewerInfoPolicy;
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
    }

    public ShareFolderArgBase(@Nonnull String str) {
        this(str, null, false, null, null, null, AccessInheritance.INHERIT);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nullable
    public AclUpdatePolicy getAclUpdatePolicy() {
        return this.aclUpdatePolicy;
    }

    public boolean getForceAsync() {
        return this.forceAsync;
    }

    @Nullable
    public MemberPolicy getMemberPolicy() {
        return this.memberPolicy;
    }

    @Nullable
    public SharedLinkPolicy getSharedLinkPolicy() {
        return this.sharedLinkPolicy;
    }

    @Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return this.viewerInfoPolicy;
    }

    @Nonnull
    public AccessInheritance getAccessInheritance() {
        return this.accessInheritance;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected AccessInheritance accessInheritance;
        protected AclUpdatePolicy aclUpdatePolicy;
        protected boolean forceAsync;
        protected MemberPolicy memberPolicy;
        protected final String path;
        protected SharedLinkPolicy sharedLinkPolicy;
        protected ViewerInfoPolicy viewerInfoPolicy;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.aclUpdatePolicy = null;
            this.forceAsync = false;
            this.memberPolicy = null;
            this.sharedLinkPolicy = null;
            this.viewerInfoPolicy = null;
            this.accessInheritance = AccessInheritance.INHERIT;
        }

        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }

        public Builder withForceAsync(Boolean bool) {
            if (bool != null) {
                this.forceAsync = bool.booleanValue();
                return this;
            }
            this.forceAsync = false;
            return this;
        }

        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            return this;
        }

        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        public Builder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
            this.viewerInfoPolicy = viewerInfoPolicy;
            return this;
        }

        public Builder withAccessInheritance(AccessInheritance accessInheritance) {
            if (accessInheritance != null) {
                this.accessInheritance = accessInheritance;
                return this;
            }
            this.accessInheritance = AccessInheritance.INHERIT;
            return this;
        }

        public ShareFolderArgBase build() {
            return new ShareFolderArgBase(this.path, this.aclUpdatePolicy, this.forceAsync, this.memberPolicy, this.sharedLinkPolicy, this.viewerInfoPolicy, this.accessInheritance);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aclUpdatePolicy, Boolean.valueOf(this.forceAsync), this.memberPolicy, this.path, this.sharedLinkPolicy, this.viewerInfoPolicy, this.accessInheritance});
    }

    public boolean equals(Object obj) {
        ShareFolderArgBase shareFolderArgBase;
        String str;
        String str2;
        AclUpdatePolicy aclUpdatePolicy;
        AclUpdatePolicy aclUpdatePolicy2;
        MemberPolicy memberPolicy;
        MemberPolicy memberPolicy2;
        SharedLinkPolicy sharedLinkPolicy;
        SharedLinkPolicy sharedLinkPolicy2;
        ViewerInfoPolicy viewerInfoPolicy;
        ViewerInfoPolicy viewerInfoPolicy2;
        AccessInheritance accessInheritance;
        AccessInheritance accessInheritance2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (shareFolderArgBase = (ShareFolderArgBase) obj).path) || str.equals(str2)) && (((aclUpdatePolicy = this.aclUpdatePolicy) == (aclUpdatePolicy2 = shareFolderArgBase.aclUpdatePolicy) || (aclUpdatePolicy != null && aclUpdatePolicy.equals(aclUpdatePolicy2))) && this.forceAsync == shareFolderArgBase.forceAsync && (((memberPolicy = this.memberPolicy) == (memberPolicy2 = shareFolderArgBase.memberPolicy) || (memberPolicy != null && memberPolicy.equals(memberPolicy2))) && (((sharedLinkPolicy = this.sharedLinkPolicy) == (sharedLinkPolicy2 = shareFolderArgBase.sharedLinkPolicy) || (sharedLinkPolicy != null && sharedLinkPolicy.equals(sharedLinkPolicy2))) && (((viewerInfoPolicy = this.viewerInfoPolicy) == (viewerInfoPolicy2 = shareFolderArgBase.viewerInfoPolicy) || (viewerInfoPolicy != null && viewerInfoPolicy.equals(viewerInfoPolicy2))) && ((accessInheritance = this.accessInheritance) == (accessInheritance2 = shareFolderArgBase.accessInheritance) || accessInheritance.equals(accessInheritance2))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<ShareFolderArgBase> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShareFolderArgBase shareFolderArgBase, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(shareFolderArgBase.path, jsonGenerator);
            if (shareFolderArgBase.aclUpdatePolicy != null) {
                jsonGenerator.writeFieldName("acl_update_policy");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(shareFolderArgBase.aclUpdatePolicy, jsonGenerator);
            }
            jsonGenerator.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(shareFolderArgBase.forceAsync), jsonGenerator);
            if (shareFolderArgBase.memberPolicy != null) {
                jsonGenerator.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(shareFolderArgBase.memberPolicy, jsonGenerator);
            }
            if (shareFolderArgBase.sharedLinkPolicy != null) {
                jsonGenerator.writeFieldName("shared_link_policy");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(shareFolderArgBase.sharedLinkPolicy, jsonGenerator);
            }
            if (shareFolderArgBase.viewerInfoPolicy != null) {
                jsonGenerator.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(shareFolderArgBase.viewerInfoPolicy, jsonGenerator);
            }
            jsonGenerator.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(shareFolderArgBase.accessInheritance, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShareFolderArgBase deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ShareFolderArgBase shareFolderArgBase = new ShareFolderArgBase(strDeserialize, aclUpdatePolicy, boolDeserialize.booleanValue(), memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritanceDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(shareFolderArgBase, shareFolderArgBase.toStringMultiline());
                return shareFolderArgBase;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
