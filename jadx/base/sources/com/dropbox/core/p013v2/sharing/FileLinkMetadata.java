package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkPermissions;
import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;
import com.dropbox.core.p013v2.sharing.TeamMemberInfo;
import com.dropbox.core.p013v2.users.Team;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class FileLinkMetadata extends SharedLinkMetadata {

    @Nonnull
    protected final Date clientModified;

    @Nonnull
    protected final String rev;

    @Nonnull
    protected final Date serverModified;
    protected final long size;

    public FileLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions, @Nonnull Date date, @Nonnull Date date2, @Nonnull String str3, long j, @Nullable String str4, @Nullable Date date3, @Nullable String str5, @Nullable TeamMemberInfo teamMemberInfo, @Nullable Team team) {
        super(str, str2, linkPermissions, str4, date3, str5, teamMemberInfo, team);
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'clientModified' is null");
        }
        this.clientModified = LangUtil.truncateMillis(date);
        if (date2 == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = LangUtil.truncateMillis(date2);
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (str3.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", str3)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = str3;
        this.size = j;
    }

    public FileLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions, @Nonnull Date date, @Nonnull Date date2, @Nonnull String str3, long j) {
        this(str, str2, linkPermissions, date, date2, str3, j, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nonnull
    public LinkPermissions getLinkPermissions() {
        return this.linkPermissions;
    }

    @Nonnull
    public Date getClientModified() {
        return this.clientModified;
    }

    @Nonnull
    public Date getServerModified() {
        return this.serverModified;
    }

    @Nonnull
    public String getRev() {
        return this.rev;
    }

    public long getSize() {
        return this.size;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nullable
    public String getId() {
        return this.f737id;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nullable
    public TeamMemberInfo getTeamMemberInfo() {
        return this.teamMemberInfo;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    @Nullable
    public Team getContentOwnerTeamInfo() {
        return this.contentOwnerTeamInfo;
    }

    public static Builder newBuilder(String str, String str2, LinkPermissions linkPermissions, Date date, Date date2, String str3, long j) {
        return new Builder(str, str2, linkPermissions, date, date2, str3, j);
    }

    public static class Builder extends SharedLinkMetadata.Builder {
        protected final Date clientModified;
        protected final String rev;
        protected final Date serverModified;
        protected final long size;

        protected Builder(String str, String str2, LinkPermissions linkPermissions, Date date, Date date2, String str3, long j) {
            super(str, str2, linkPermissions);
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'clientModified' is null");
            }
            this.clientModified = LangUtil.truncateMillis(date);
            if (date2 == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = LangUtil.truncateMillis(date2);
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (str3.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str3)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = str3;
            this.size = j;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public Builder withId(String str) {
            super.withId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public Builder withExpires(Date date) {
            super.withExpires(date);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public Builder withPathLower(String str) {
            super.withPathLower(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public Builder withTeamMemberInfo(TeamMemberInfo teamMemberInfo) {
            super.withTeamMemberInfo(teamMemberInfo);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public Builder withContentOwnerTeamInfo(Team team) {
            super.withContentOwnerTeamInfo(team);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedLinkMetadata.Builder
        public FileLinkMetadata build() {
            return new FileLinkMetadata(this.url, this.name, this.linkPermissions, this.clientModified, this.serverModified, this.rev, this.size, this.f738id, this.expires, this.pathLower, this.teamMemberInfo, this.contentOwnerTeamInfo);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.clientModified, this.serverModified, this.rev, Long.valueOf(this.size)});
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public boolean equals(Object obj) {
        Date date;
        Date date2;
        Date date3;
        Date date4;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FileLinkMetadata fileLinkMetadata = (FileLinkMetadata) obj;
            if ((this.url == fileLinkMetadata.url || this.url.equals(fileLinkMetadata.url)) && ((this.name == fileLinkMetadata.name || this.name.equals(fileLinkMetadata.name)) && ((this.linkPermissions == fileLinkMetadata.linkPermissions || this.linkPermissions.equals(fileLinkMetadata.linkPermissions)) && (((date = this.clientModified) == (date2 = fileLinkMetadata.clientModified) || date.equals(date2)) && (((date3 = this.serverModified) == (date4 = fileLinkMetadata.serverModified) || date3.equals(date4)) && (((str = this.rev) == (str2 = fileLinkMetadata.rev) || str.equals(str2)) && this.size == fileLinkMetadata.size && ((this.f737id == fileLinkMetadata.f737id || (this.f737id != null && this.f737id.equals(fileLinkMetadata.f737id))) && ((this.expires == fileLinkMetadata.expires || (this.expires != null && this.expires.equals(fileLinkMetadata.expires))) && ((this.pathLower == fileLinkMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(fileLinkMetadata.pathLower))) && ((this.teamMemberInfo == fileLinkMetadata.teamMemberInfo || (this.teamMemberInfo != null && this.teamMemberInfo.equals(fileLinkMetadata.teamMemberInfo))) && (this.contentOwnerTeamInfo == fileLinkMetadata.contentOwnerTeamInfo || (this.contentOwnerTeamInfo != null && this.contentOwnerTeamInfo.equals(fileLinkMetadata.contentOwnerTeamInfo))))))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLinkMetadata fileLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("file", jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(fileLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(fileLinkMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            LinkPermissions.Serializer.INSTANCE.serialize(fileLinkMetadata.linkPermissions, jsonGenerator);
            jsonGenerator.writeFieldName("client_modified");
            StoneSerializers.timestamp().serialize(fileLinkMetadata.clientModified, jsonGenerator);
            jsonGenerator.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(fileLinkMetadata.serverModified, jsonGenerator);
            jsonGenerator.writeFieldName("rev");
            StoneSerializers.string().serialize(fileLinkMetadata.rev, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            StoneSerializers.uInt64().serialize(Long.valueOf(fileLinkMetadata.size), jsonGenerator);
            if (fileLinkMetadata.f737id != null) {
                jsonGenerator.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLinkMetadata.f737id, jsonGenerator);
            }
            if (fileLinkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(fileLinkMetadata.expires, jsonGenerator);
            }
            if (fileLinkMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLinkMetadata.pathLower, jsonGenerator);
            }
            if (fileLinkMetadata.teamMemberInfo != null) {
                jsonGenerator.writeFieldName("team_member_info");
                StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).serialize(fileLinkMetadata.teamMemberInfo, jsonGenerator);
            }
            if (fileLinkMetadata.contentOwnerTeamInfo != null) {
                jsonGenerator.writeFieldName("content_owner_team_info");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(fileLinkMetadata.contentOwnerTeamInfo, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FileLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("file".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                LinkPermissions linkPermissionsDeserialize = null;
                Date dateDeserialize = null;
                Date dateDeserialize2 = null;
                String strDeserialize3 = null;
                String str = null;
                Date date = null;
                String str2 = null;
                TeamMemberInfo teamMemberInfo = null;
                Team team = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("link_permissions".equals(currentName)) {
                        linkPermissionsDeserialize = LinkPermissions.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("client_modified".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("server_modified".equals(currentName)) {
                        dateDeserialize2 = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("rev".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("size".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (ClientCookie.EXPIRES_ATTR.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("path_lower".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team_member_info".equals(currentName)) {
                        teamMemberInfo = (TeamMemberInfo) StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("content_owner_team_info".equals(currentName)) {
                        team = (Team) StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (linkPermissionsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"link_permissions\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_modified\" missing.");
                }
                if (dateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"server_modified\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"rev\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"size\" missing.");
                }
                FileLinkMetadata fileLinkMetadata = new FileLinkMetadata(strDeserialize, strDeserialize2, linkPermissionsDeserialize, dateDeserialize, dateDeserialize2, strDeserialize3, lDeserialize.longValue(), str, date, str2, teamMemberInfo, team);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLinkMetadata, fileLinkMetadata.toStringMultiline());
                return fileLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
