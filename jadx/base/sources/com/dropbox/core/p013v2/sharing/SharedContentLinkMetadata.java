package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.AudienceExceptions;
import com.dropbox.core.p013v2.sharing.AudienceRestrictingSharedFolder;
import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.LinkPermission;
import com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SharedContentLinkMetadata extends SharedContentLinkMetadataBase {

    @Nullable
    protected final AudienceExceptions audienceExceptions;

    @Nonnull
    protected final String url;

    public SharedContentLinkMetadata(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z, @Nonnull String str, @Nullable AccessLevel accessLevel, @Nullable AudienceRestrictingSharedFolder audienceRestrictingSharedFolder, @Nullable Date date, @Nullable AudienceExceptions audienceExceptions) {
        super(list, linkAudience, list2, z, accessLevel, audienceRestrictingSharedFolder, date);
        this.audienceExceptions = audienceExceptions;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
    }

    public SharedContentLinkMetadata(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z, @Nonnull String str) {
        this(list, linkAudience, list2, z, str, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nonnull
    public List<LinkAudience> getAudienceOptions() {
        return this.audienceOptions;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nonnull
    public LinkAudience getCurrentAudience() {
        return this.currentAudience;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nonnull
    public List<LinkPermission> getLinkPermissions() {
        return this.linkPermissions;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public boolean getPasswordProtected() {
        return this.passwordProtected;
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nullable
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nullable
    public AudienceRestrictingSharedFolder getAudienceRestrictingSharedFolder() {
        return this.audienceRestrictingSharedFolder;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    @Nullable
    public Date getExpiry() {
        return this.expiry;
    }

    @Nullable
    public AudienceExceptions getAudienceExceptions() {
        return this.audienceExceptions;
    }

    public static Builder newBuilder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z, String str) {
        return new Builder(list, linkAudience, list2, z, str);
    }

    public static class Builder extends SharedContentLinkMetadataBase.Builder {
        protected AudienceExceptions audienceExceptions;
        protected final String url;

        protected Builder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z, String str) {
            super(list, linkAudience, list2, z);
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = str;
            this.audienceExceptions = null;
        }

        public Builder withAudienceExceptions(AudienceExceptions audienceExceptions) {
            this.audienceExceptions = audienceExceptions;
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedContentLinkMetadataBase.Builder
        public Builder withAccessLevel(AccessLevel accessLevel) {
            super.withAccessLevel(accessLevel);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedContentLinkMetadataBase.Builder
        public Builder withAudienceRestrictingSharedFolder(AudienceRestrictingSharedFolder audienceRestrictingSharedFolder) {
            super.withAudienceRestrictingSharedFolder(audienceRestrictingSharedFolder);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedContentLinkMetadataBase.Builder
        public Builder withExpiry(Date date) {
            super.withExpiry(date);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedContentLinkMetadataBase.Builder
        public SharedContentLinkMetadata build() {
            return new SharedContentLinkMetadata(this.audienceOptions, this.currentAudience, this.linkPermissions, this.passwordProtected, this.url, this.accessLevel, this.audienceRestrictingSharedFolder, this.expiry, this.audienceExceptions);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.audienceExceptions, this.url});
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public boolean equals(Object obj) {
        String str;
        String str2;
        AudienceExceptions audienceExceptions;
        AudienceExceptions audienceExceptions2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SharedContentLinkMetadata sharedContentLinkMetadata = (SharedContentLinkMetadata) obj;
            if ((this.audienceOptions == sharedContentLinkMetadata.audienceOptions || this.audienceOptions.equals(sharedContentLinkMetadata.audienceOptions)) && ((this.currentAudience == sharedContentLinkMetadata.currentAudience || this.currentAudience.equals(sharedContentLinkMetadata.currentAudience)) && ((this.linkPermissions == sharedContentLinkMetadata.linkPermissions || this.linkPermissions.equals(sharedContentLinkMetadata.linkPermissions)) && this.passwordProtected == sharedContentLinkMetadata.passwordProtected && (((str = this.url) == (str2 = sharedContentLinkMetadata.url) || str.equals(str2)) && ((this.accessLevel == sharedContentLinkMetadata.accessLevel || (this.accessLevel != null && this.accessLevel.equals(sharedContentLinkMetadata.accessLevel))) && ((this.audienceRestrictingSharedFolder == sharedContentLinkMetadata.audienceRestrictingSharedFolder || (this.audienceRestrictingSharedFolder != null && this.audienceRestrictingSharedFolder.equals(sharedContentLinkMetadata.audienceRestrictingSharedFolder))) && ((this.expiry == sharedContentLinkMetadata.expiry || (this.expiry != null && this.expiry.equals(sharedContentLinkMetadata.expiry))) && ((audienceExceptions = this.audienceExceptions) == (audienceExceptions2 = sharedContentLinkMetadata.audienceExceptions) || (audienceExceptions != null && audienceExceptions.equals(audienceExceptions2)))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentLinkMetadata sharedContentLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("audience_options");
            StoneSerializers.list(LinkAudience.Serializer.INSTANCE).serialize(sharedContentLinkMetadata.audienceOptions, jsonGenerator);
            jsonGenerator.writeFieldName("current_audience");
            LinkAudience.Serializer.INSTANCE.serialize(sharedContentLinkMetadata.currentAudience, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            StoneSerializers.list(LinkPermission.Serializer.INSTANCE).serialize(sharedContentLinkMetadata.linkPermissions, jsonGenerator);
            jsonGenerator.writeFieldName("password_protected");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedContentLinkMetadata.passwordProtected), jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(sharedContentLinkMetadata.url, jsonGenerator);
            if (sharedContentLinkMetadata.accessLevel != null) {
                jsonGenerator.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedContentLinkMetadata.accessLevel, jsonGenerator);
            }
            if (sharedContentLinkMetadata.audienceRestrictingSharedFolder != null) {
                jsonGenerator.writeFieldName("audience_restricting_shared_folder");
                StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).serialize(sharedContentLinkMetadata.audienceRestrictingSharedFolder, jsonGenerator);
            }
            if (sharedContentLinkMetadata.expiry != null) {
                jsonGenerator.writeFieldName("expiry");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedContentLinkMetadata.expiry, jsonGenerator);
            }
            if (sharedContentLinkMetadata.audienceExceptions != null) {
                jsonGenerator.writeFieldName("audience_exceptions");
                StoneSerializers.nullableStruct(AudienceExceptions.Serializer.INSTANCE).serialize(sharedContentLinkMetadata.audienceExceptions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                LinkAudience linkAudienceDeserialize = null;
                List list2 = null;
                String strDeserialize = null;
                AccessLevel accessLevel = null;
                AudienceRestrictingSharedFolder audienceRestrictingSharedFolder = null;
                Date date = null;
                AudienceExceptions audienceExceptions = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("audience_options".equals(currentName)) {
                        list = (List) StoneSerializers.list(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("current_audience".equals(currentName)) {
                        linkAudienceDeserialize = LinkAudience.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("link_permissions".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(LinkPermission.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("password_protected".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("audience_restricting_shared_folder".equals(currentName)) {
                        audienceRestrictingSharedFolder = (AudienceRestrictingSharedFolder) StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("expiry".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("audience_exceptions".equals(currentName)) {
                        audienceExceptions = (AudienceExceptions) StoneSerializers.nullableStruct(AudienceExceptions.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"audience_options\" missing.");
                }
                if (linkAudienceDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"current_audience\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"link_permissions\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"password_protected\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                SharedContentLinkMetadata sharedContentLinkMetadata = new SharedContentLinkMetadata(list, linkAudienceDeserialize, list2, boolDeserialize.booleanValue(), strDeserialize, accessLevel, audienceRestrictingSharedFolder, date, audienceExceptions);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentLinkMetadata, sharedContentLinkMetadata.toStringMultiline());
                return sharedContentLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
