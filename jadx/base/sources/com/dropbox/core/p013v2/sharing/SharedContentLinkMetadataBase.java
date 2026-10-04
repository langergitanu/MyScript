package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.AudienceRestrictingSharedFolder;
import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.LinkPermission;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SharedContentLinkMetadataBase {

    @Nullable
    protected final AccessLevel accessLevel;

    @Nonnull
    protected final List<LinkAudience> audienceOptions;

    @Nullable
    protected final AudienceRestrictingSharedFolder audienceRestrictingSharedFolder;

    @Nonnull
    protected final LinkAudience currentAudience;

    @Nullable
    protected final Date expiry;

    @Nonnull
    protected final List<LinkPermission> linkPermissions;
    protected final boolean passwordProtected;

    public SharedContentLinkMetadataBase(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z, @Nullable AccessLevel accessLevel, @Nullable AudienceRestrictingSharedFolder audienceRestrictingSharedFolder, @Nullable Date date) {
        this.accessLevel = accessLevel;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'audienceOptions' is null");
        }
        Iterator<LinkAudience> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
            }
        }
        this.audienceOptions = list;
        this.audienceRestrictingSharedFolder = audienceRestrictingSharedFolder;
        if (linkAudience == null) {
            throw new IllegalArgumentException("Required value for 'currentAudience' is null");
        }
        this.currentAudience = linkAudience;
        this.expiry = LangUtil.truncateMillis(date);
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
        }
        Iterator<LinkPermission> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'linkPermissions' is null");
            }
        }
        this.linkPermissions = list2;
        this.passwordProtected = z;
    }

    public SharedContentLinkMetadataBase(@Nonnull List<LinkAudience> list, @Nonnull LinkAudience linkAudience, @Nonnull List<LinkPermission> list2, boolean z) {
        this(list, linkAudience, list2, z, null, null, null);
    }

    @Nonnull
    public List<LinkAudience> getAudienceOptions() {
        return this.audienceOptions;
    }

    @Nonnull
    public LinkAudience getCurrentAudience() {
        return this.currentAudience;
    }

    @Nonnull
    public List<LinkPermission> getLinkPermissions() {
        return this.linkPermissions;
    }

    public boolean getPasswordProtected() {
        return this.passwordProtected;
    }

    @Nullable
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    @Nullable
    public AudienceRestrictingSharedFolder getAudienceRestrictingSharedFolder() {
        return this.audienceRestrictingSharedFolder;
    }

    @Nullable
    public Date getExpiry() {
        return this.expiry;
    }

    public static Builder newBuilder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z) {
        return new Builder(list, linkAudience, list2, z);
    }

    public static class Builder {
        protected AccessLevel accessLevel;
        protected final List<LinkAudience> audienceOptions;
        protected AudienceRestrictingSharedFolder audienceRestrictingSharedFolder;
        protected final LinkAudience currentAudience;
        protected Date expiry;
        protected final List<LinkPermission> linkPermissions;
        protected final boolean passwordProtected;

        protected Builder(List<LinkAudience> list, LinkAudience linkAudience, List<LinkPermission> list2, boolean z) {
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'audienceOptions' is null");
            }
            Iterator<LinkAudience> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
                }
            }
            this.audienceOptions = list;
            if (linkAudience == null) {
                throw new IllegalArgumentException("Required value for 'currentAudience' is null");
            }
            this.currentAudience = linkAudience;
            if (list2 == null) {
                throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
            }
            Iterator<LinkPermission> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'linkPermissions' is null");
                }
            }
            this.linkPermissions = list2;
            this.passwordProtected = z;
            this.accessLevel = null;
            this.audienceRestrictingSharedFolder = null;
            this.expiry = null;
        }

        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder withAudienceRestrictingSharedFolder(AudienceRestrictingSharedFolder audienceRestrictingSharedFolder) {
            this.audienceRestrictingSharedFolder = audienceRestrictingSharedFolder;
            return this;
        }

        public Builder withExpiry(Date date) {
            this.expiry = LangUtil.truncateMillis(date);
            return this;
        }

        public SharedContentLinkMetadataBase build() {
            return new SharedContentLinkMetadataBase(this.audienceOptions, this.currentAudience, this.linkPermissions, this.passwordProtected, this.accessLevel, this.audienceRestrictingSharedFolder, this.expiry);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessLevel, this.audienceOptions, this.audienceRestrictingSharedFolder, this.currentAudience, this.expiry, this.linkPermissions, Boolean.valueOf(this.passwordProtected)});
    }

    public boolean equals(Object obj) {
        SharedContentLinkMetadataBase sharedContentLinkMetadataBase;
        List<LinkAudience> list;
        List<LinkAudience> list2;
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        List<LinkPermission> list3;
        List<LinkPermission> list4;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        AudienceRestrictingSharedFolder audienceRestrictingSharedFolder;
        AudienceRestrictingSharedFolder audienceRestrictingSharedFolder2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.audienceOptions) == (list2 = (sharedContentLinkMetadataBase = (SharedContentLinkMetadataBase) obj).audienceOptions) || list.equals(list2)) && (((linkAudience = this.currentAudience) == (linkAudience2 = sharedContentLinkMetadataBase.currentAudience) || linkAudience.equals(linkAudience2)) && (((list3 = this.linkPermissions) == (list4 = sharedContentLinkMetadataBase.linkPermissions) || list3.equals(list4)) && this.passwordProtected == sharedContentLinkMetadataBase.passwordProtected && (((accessLevel = this.accessLevel) == (accessLevel2 = sharedContentLinkMetadataBase.accessLevel) || (accessLevel != null && accessLevel.equals(accessLevel2))) && (((audienceRestrictingSharedFolder = this.audienceRestrictingSharedFolder) == (audienceRestrictingSharedFolder2 = sharedContentLinkMetadataBase.audienceRestrictingSharedFolder) || (audienceRestrictingSharedFolder != null && audienceRestrictingSharedFolder.equals(audienceRestrictingSharedFolder2))) && ((date = this.expiry) == (date2 = sharedContentLinkMetadataBase.expiry) || (date != null && date.equals(date2)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<SharedContentLinkMetadataBase> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentLinkMetadataBase sharedContentLinkMetadataBase, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("audience_options");
            StoneSerializers.list(LinkAudience.Serializer.INSTANCE).serialize(sharedContentLinkMetadataBase.audienceOptions, jsonGenerator);
            jsonGenerator.writeFieldName("current_audience");
            LinkAudience.Serializer.INSTANCE.serialize(sharedContentLinkMetadataBase.currentAudience, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            StoneSerializers.list(LinkPermission.Serializer.INSTANCE).serialize(sharedContentLinkMetadataBase.linkPermissions, jsonGenerator);
            jsonGenerator.writeFieldName("password_protected");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedContentLinkMetadataBase.passwordProtected), jsonGenerator);
            if (sharedContentLinkMetadataBase.accessLevel != null) {
                jsonGenerator.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedContentLinkMetadataBase.accessLevel, jsonGenerator);
            }
            if (sharedContentLinkMetadataBase.audienceRestrictingSharedFolder != null) {
                jsonGenerator.writeFieldName("audience_restricting_shared_folder");
                StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).serialize(sharedContentLinkMetadataBase.audienceRestrictingSharedFolder, jsonGenerator);
            }
            if (sharedContentLinkMetadataBase.expiry != null) {
                jsonGenerator.writeFieldName("expiry");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedContentLinkMetadataBase.expiry, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentLinkMetadataBase deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                SharedContentLinkMetadataBase sharedContentLinkMetadataBase = new SharedContentLinkMetadataBase(list, linkAudienceDeserialize, list2, boolDeserialize.booleanValue(), accessLevel, audienceRestrictingSharedFolder, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentLinkMetadataBase, sharedContentLinkMetadataBase.toStringMultiline());
                return sharedContentLinkMetadataBase;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
