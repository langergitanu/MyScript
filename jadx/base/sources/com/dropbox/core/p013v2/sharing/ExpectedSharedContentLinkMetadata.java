package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
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
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ExpectedSharedContentLinkMetadata extends SharedContentLinkMetadataBase {
    public ExpectedSharedContentLinkMetadata(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z, @Nullable AccessLevel accessLevel, @Nullable AudienceRestrictingSharedFolder audienceRestrictingSharedFolder, @Nullable Date date) {
        super(list, linkAudience, list2, z, accessLevel, audienceRestrictingSharedFolder, date);
    }

    public ExpectedSharedContentLinkMetadata(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z) {
        this(list, linkAudience, list2, z, null, null, null);
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

    public static Builder newBuilder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z) {
        return new Builder(list, linkAudience, list2, z);
    }

    public static class Builder extends SharedContentLinkMetadataBase.Builder {
        protected Builder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z) {
            super(list, linkAudience, list2, z);
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
        public ExpectedSharedContentLinkMetadata build() {
            return new ExpectedSharedContentLinkMetadata(this.audienceOptions, this.currentAudience, this.linkPermissions, this.passwordProtected, this.accessLevel, this.audienceRestrictingSharedFolder, this.expiry);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedContentLinkMetadataBase
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata = (ExpectedSharedContentLinkMetadata) obj;
            if ((this.audienceOptions == expectedSharedContentLinkMetadata.audienceOptions || this.audienceOptions.equals(expectedSharedContentLinkMetadata.audienceOptions)) && ((this.currentAudience == expectedSharedContentLinkMetadata.currentAudience || this.currentAudience.equals(expectedSharedContentLinkMetadata.currentAudience)) && ((this.linkPermissions == expectedSharedContentLinkMetadata.linkPermissions || this.linkPermissions.equals(expectedSharedContentLinkMetadata.linkPermissions)) && this.passwordProtected == expectedSharedContentLinkMetadata.passwordProtected && ((this.accessLevel == expectedSharedContentLinkMetadata.accessLevel || (this.accessLevel != null && this.accessLevel.equals(expectedSharedContentLinkMetadata.accessLevel))) && ((this.audienceRestrictingSharedFolder == expectedSharedContentLinkMetadata.audienceRestrictingSharedFolder || (this.audienceRestrictingSharedFolder != null && this.audienceRestrictingSharedFolder.equals(expectedSharedContentLinkMetadata.audienceRestrictingSharedFolder))) && (this.expiry == expectedSharedContentLinkMetadata.expiry || (this.expiry != null && this.expiry.equals(expectedSharedContentLinkMetadata.expiry)))))))) {
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

    static class Serializer extends StructSerializer<ExpectedSharedContentLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("audience_options");
            StoneSerializers.list(LinkAudience.Serializer.INSTANCE).serialize(expectedSharedContentLinkMetadata.audienceOptions, jsonGenerator);
            jsonGenerator.writeFieldName("current_audience");
            LinkAudience.Serializer.INSTANCE.serialize(expectedSharedContentLinkMetadata.currentAudience, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            StoneSerializers.list(LinkPermission.Serializer.INSTANCE).serialize(expectedSharedContentLinkMetadata.linkPermissions, jsonGenerator);
            jsonGenerator.writeFieldName("password_protected");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(expectedSharedContentLinkMetadata.passwordProtected), jsonGenerator);
            if (expectedSharedContentLinkMetadata.accessLevel != null) {
                jsonGenerator.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(expectedSharedContentLinkMetadata.accessLevel, jsonGenerator);
            }
            if (expectedSharedContentLinkMetadata.audienceRestrictingSharedFolder != null) {
                jsonGenerator.writeFieldName("audience_restricting_shared_folder");
                StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).serialize(expectedSharedContentLinkMetadata.audienceRestrictingSharedFolder, jsonGenerator);
            }
            if (expectedSharedContentLinkMetadata.expiry != null) {
                jsonGenerator.writeFieldName("expiry");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(expectedSharedContentLinkMetadata.expiry, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExpectedSharedContentLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                AccessLevel accessLevel = null;
                AudienceRestrictingSharedFolder audienceRestrictingSharedFolder = null;
                Date date = null;
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
                    } else if ("access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("audience_restricting_shared_folder".equals(currentName)) {
                        audienceRestrictingSharedFolder = (AudienceRestrictingSharedFolder) StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("expiry".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
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
                ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata = new ExpectedSharedContentLinkMetadata(list, linkAudienceDeserialize, list2, boolDeserialize.booleanValue(), accessLevel, audienceRestrictingSharedFolder, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(expectedSharedContentLinkMetadata, expectedSharedContentLinkMetadata.toStringMultiline());
                return expectedSharedContentLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
