package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkPermissions;
import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;
import com.dropbox.core.p013v2.sharing.TeamMemberInfo;
import com.dropbox.core.p013v2.users.Team;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class FolderLinkMetadata extends SharedLinkMetadata {
    public FolderLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions, @Nullable String str3, @Nullable Date date, @Nullable String str4, @Nullable TeamMemberInfo teamMemberInfo, @Nullable Team team) {
        super(str, str2, linkPermissions, str3, date, str4, teamMemberInfo, team);
    }

    public FolderLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions) {
        this(str, str2, linkPermissions, null, null, null, null, null);
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

    public static Builder newBuilder(String str, String str2, LinkPermissions linkPermissions) {
        return new Builder(str, str2, linkPermissions);
    }

    public static class Builder extends SharedLinkMetadata.Builder {
        protected Builder(String str, String str2, LinkPermissions linkPermissions) {
            super(str, str2, linkPermissions);
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
        public FolderLinkMetadata build() {
            return new FolderLinkMetadata(this.url, this.name, this.linkPermissions, this.f738id, this.expires, this.pathLower, this.teamMemberInfo, this.contentOwnerTeamInfo);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderLinkMetadata folderLinkMetadata = (FolderLinkMetadata) obj;
        return (this.url == folderLinkMetadata.url || this.url.equals(folderLinkMetadata.url)) && (this.name == folderLinkMetadata.name || this.name.equals(folderLinkMetadata.name)) && ((this.linkPermissions == folderLinkMetadata.linkPermissions || this.linkPermissions.equals(folderLinkMetadata.linkPermissions)) && ((this.f737id == folderLinkMetadata.f737id || (this.f737id != null && this.f737id.equals(folderLinkMetadata.f737id))) && ((this.expires == folderLinkMetadata.expires || (this.expires != null && this.expires.equals(folderLinkMetadata.expires))) && ((this.pathLower == folderLinkMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(folderLinkMetadata.pathLower))) && ((this.teamMemberInfo == folderLinkMetadata.teamMemberInfo || (this.teamMemberInfo != null && this.teamMemberInfo.equals(folderLinkMetadata.teamMemberInfo))) && (this.contentOwnerTeamInfo == folderLinkMetadata.contentOwnerTeamInfo || (this.contentOwnerTeamInfo != null && this.contentOwnerTeamInfo.equals(folderLinkMetadata.contentOwnerTeamInfo))))))));
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedLinkMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderLinkMetadata folderLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("folder", jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(folderLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(folderLinkMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            LinkPermissions.Serializer.INSTANCE.serialize(folderLinkMetadata.linkPermissions, jsonGenerator);
            if (folderLinkMetadata.f737id != null) {
                jsonGenerator.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderLinkMetadata.f737id, jsonGenerator);
            }
            if (folderLinkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(folderLinkMetadata.expires, jsonGenerator);
            }
            if (folderLinkMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderLinkMetadata.pathLower, jsonGenerator);
            }
            if (folderLinkMetadata.teamMemberInfo != null) {
                jsonGenerator.writeFieldName("team_member_info");
                StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).serialize(folderLinkMetadata.teamMemberInfo, jsonGenerator);
            }
            if (folderLinkMetadata.contentOwnerTeamInfo != null) {
                jsonGenerator.writeFieldName("content_owner_team_info");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(folderLinkMetadata.contentOwnerTeamInfo, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FolderLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("folder".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                LinkPermissions linkPermissionsDeserialize = null;
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
                FolderLinkMetadata folderLinkMetadata = new FolderLinkMetadata(strDeserialize, strDeserialize2, linkPermissionsDeserialize, str, date, str2, teamMemberInfo, team);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderLinkMetadata, folderLinkMetadata.toStringMultiline());
                return folderLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
