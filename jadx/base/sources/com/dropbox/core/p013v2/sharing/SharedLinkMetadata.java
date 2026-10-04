package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FileLinkMetadata;
import com.dropbox.core.p013v2.sharing.FolderLinkMetadata;
import com.dropbox.core.p013v2.sharing.LinkPermissions;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class SharedLinkMetadata {

    @Nullable
    protected final Team contentOwnerTeamInfo;

    @Nullable
    protected final Date expires;

    /* JADX INFO: renamed from: id */
    @Nullable
    protected final String f737id;

    @Nonnull
    protected final LinkPermissions linkPermissions;

    @Nonnull
    protected final String name;

    @Nullable
    protected final String pathLower;

    @Nullable
    protected final TeamMemberInfo teamMemberInfo;

    @Nonnull
    protected final String url;

    public SharedLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions, @Nullable String str3, @Nullable Date date, @Nullable String str4, @Nullable TeamMemberInfo teamMemberInfo, @Nullable Team team) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (str3 != null && str3.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.f737id = str3;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.expires = LangUtil.truncateMillis(date);
        this.pathLower = str4;
        if (linkPermissions == null) {
            throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
        }
        this.linkPermissions = linkPermissions;
        this.teamMemberInfo = teamMemberInfo;
        this.contentOwnerTeamInfo = team;
    }

    public SharedLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull LinkPermissions linkPermissions) {
        this(str, str2, linkPermissions, null, null, null, null, null);
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public LinkPermissions getLinkPermissions() {
        return this.linkPermissions;
    }

    @Nullable
    public String getId() {
        return this.f737id;
    }

    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Nullable
    public TeamMemberInfo getTeamMemberInfo() {
        return this.teamMemberInfo;
    }

    @Nullable
    public Team getContentOwnerTeamInfo() {
        return this.contentOwnerTeamInfo;
    }

    public static Builder newBuilder(String str, String str2, LinkPermissions linkPermissions) {
        return new Builder(str, str2, linkPermissions);
    }

    public static class Builder {
        protected Team contentOwnerTeamInfo;
        protected Date expires;

        /* JADX INFO: renamed from: id */
        protected String f738id;
        protected final LinkPermissions linkPermissions;
        protected final String name;
        protected String pathLower;
        protected TeamMemberInfo teamMemberInfo;
        protected final String url;

        protected Builder(String str, String str2, LinkPermissions linkPermissions) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            if (linkPermissions == null) {
                throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
            }
            this.linkPermissions = linkPermissions;
            this.f738id = null;
            this.expires = null;
            this.pathLower = null;
            this.teamMemberInfo = null;
            this.contentOwnerTeamInfo = null;
        }

        public Builder withId(String str) {
            if (str != null && str.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.f738id = str;
            return this;
        }

        public Builder withExpires(Date date) {
            this.expires = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withPathLower(String str) {
            this.pathLower = str;
            return this;
        }

        public Builder withTeamMemberInfo(TeamMemberInfo teamMemberInfo) {
            this.teamMemberInfo = teamMemberInfo;
            return this;
        }

        public Builder withContentOwnerTeamInfo(Team team) {
            this.contentOwnerTeamInfo = team;
            return this;
        }

        public SharedLinkMetadata build() {
            return new SharedLinkMetadata(this.url, this.name, this.linkPermissions, this.f738id, this.expires, this.pathLower, this.teamMemberInfo, this.contentOwnerTeamInfo);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.f737id, this.name, this.expires, this.pathLower, this.linkPermissions, this.teamMemberInfo, this.contentOwnerTeamInfo});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        LinkPermissions linkPermissions;
        LinkPermissions linkPermissions2;
        String str3;
        String str4;
        Date date;
        Date date2;
        String str5;
        String str6;
        TeamMemberInfo teamMemberInfo;
        TeamMemberInfo teamMemberInfo2;
        Team team;
        Team team2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkMetadata sharedLinkMetadata = (SharedLinkMetadata) obj;
        String str7 = this.url;
        String str8 = sharedLinkMetadata.url;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.name) == (str2 = sharedLinkMetadata.name) || str.equals(str2)) && (((linkPermissions = this.linkPermissions) == (linkPermissions2 = sharedLinkMetadata.linkPermissions) || linkPermissions.equals(linkPermissions2)) && (((str3 = this.f737id) == (str4 = sharedLinkMetadata.f737id) || (str3 != null && str3.equals(str4))) && (((date = this.expires) == (date2 = sharedLinkMetadata.expires) || (date != null && date.equals(date2))) && (((str5 = this.pathLower) == (str6 = sharedLinkMetadata.pathLower) || (str5 != null && str5.equals(str6))) && (((teamMemberInfo = this.teamMemberInfo) == (teamMemberInfo2 = sharedLinkMetadata.teamMemberInfo) || (teamMemberInfo != null && teamMemberInfo.equals(teamMemberInfo2))) && ((team = this.contentOwnerTeamInfo) == (team2 = sharedLinkMetadata.contentOwnerTeamInfo) || (team != null && team.equals(team2))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkMetadata sharedLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (sharedLinkMetadata instanceof FileLinkMetadata) {
                FileLinkMetadata.Serializer.INSTANCE.serialize((FileLinkMetadata) sharedLinkMetadata, jsonGenerator, z);
                return;
            }
            if (sharedLinkMetadata instanceof FolderLinkMetadata) {
                FolderLinkMetadata.Serializer.INSTANCE.serialize((FolderLinkMetadata) sharedLinkMetadata, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(sharedLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(sharedLinkMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("link_permissions");
            LinkPermissions.Serializer.INSTANCE.serialize(sharedLinkMetadata.linkPermissions, jsonGenerator);
            if (sharedLinkMetadata.f737id != null) {
                jsonGenerator.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkMetadata.f737id, jsonGenerator);
            }
            if (sharedLinkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedLinkMetadata.expires, jsonGenerator);
            }
            if (sharedLinkMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkMetadata.pathLower, jsonGenerator);
            }
            if (sharedLinkMetadata.teamMemberInfo != null) {
                jsonGenerator.writeFieldName("team_member_info");
                StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).serialize(sharedLinkMetadata.teamMemberInfo, jsonGenerator);
            }
            if (sharedLinkMetadata.contentOwnerTeamInfo != null) {
                jsonGenerator.writeFieldName("content_owner_team_info");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(sharedLinkMetadata.contentOwnerTeamInfo, jsonGenerator);
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
        public SharedLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedLinkMetadata sharedLinkMetadataDeserialize;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
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
                sharedLinkMetadataDeserialize = new SharedLinkMetadata(strDeserialize, strDeserialize2, linkPermissionsDeserialize, str, date, str2, teamMemberInfo, team);
            } else if ("".equals(tag)) {
                sharedLinkMetadataDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("file".equals(tag)) {
                sharedLinkMetadataDeserialize = FileLinkMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("folder".equals(tag)) {
                sharedLinkMetadataDeserialize = FolderLinkMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(sharedLinkMetadataDeserialize, sharedLinkMetadataDeserialize.toStringMultiline());
            return sharedLinkMetadataDeserialize;
        }
    }
}
