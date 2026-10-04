package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.ExpectedSharedContentLinkMetadata;
import com.dropbox.core.p013v2.sharing.FilePermission;
import com.dropbox.core.p013v2.sharing.FolderPolicy;
import com.dropbox.core.p013v2.sharing.SharedContentLinkMetadata;
import com.dropbox.core.p013v2.users.Team;
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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SharedFileMetadata {

    @Nullable
    protected final AccessLevel accessType;

    @Nullable
    protected final ExpectedSharedContentLinkMetadata expectedLinkMetadata;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f732id;

    @Nullable
    protected final SharedContentLinkMetadata linkMetadata;

    @Nonnull
    protected final String name;

    @Nullable
    protected final List<String> ownerDisplayNames;

    @Nullable
    protected final Team ownerTeam;

    @Nullable
    protected final String parentSharedFolderId;

    @Nullable
    protected final String pathDisplay;

    @Nullable
    protected final String pathLower;

    @Nullable
    protected final List<FilePermission> permissions;

    @Nonnull
    protected final FolderPolicy policy;

    @Nonnull
    protected final String previewUrl;

    @Nullable
    protected final Date timeInvited;

    public SharedFileMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull FolderPolicy folderPolicy, @Nonnull String str3, @Nullable AccessLevel accessLevel, @Nullable ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata, @Nullable SharedContentLinkMetadata sharedContentLinkMetadata, @Nullable List<String> list, @Nullable Team team, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<FilePermission> list2, @Nullable Date date) {
        this.accessType = accessLevel;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 4) {
            throw new IllegalArgumentException("String 'id' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f732id = str;
        this.expectedLinkMetadata = expectedSharedContentLinkMetadata;
        this.linkMetadata = sharedContentLinkMetadata;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'ownerDisplayNames' is null");
                }
            }
        }
        this.ownerDisplayNames = list;
        this.ownerTeam = team;
        if (str4 != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str4)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = str4;
        this.pathDisplay = str5;
        this.pathLower = str6;
        if (list2 != null) {
            Iterator<FilePermission> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = list2;
        if (folderPolicy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = folderPolicy;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'previewUrl' is null");
        }
        this.previewUrl = str3;
        this.timeInvited = LangUtil.truncateMillis(date);
    }

    public SharedFileMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull FolderPolicy folderPolicy, @Nonnull String str3) {
        this(str, str2, folderPolicy, str3, null, null, null, null, null, null, null, null, null, null);
    }

    @Nonnull
    public String getId() {
        return this.f732id;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public FolderPolicy getPolicy() {
        return this.policy;
    }

    @Nonnull
    public String getPreviewUrl() {
        return this.previewUrl;
    }

    @Nullable
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Nullable
    public ExpectedSharedContentLinkMetadata getExpectedLinkMetadata() {
        return this.expectedLinkMetadata;
    }

    @Nullable
    public SharedContentLinkMetadata getLinkMetadata() {
        return this.linkMetadata;
    }

    @Nullable
    public List<String> getOwnerDisplayNames() {
        return this.ownerDisplayNames;
    }

    @Nullable
    public Team getOwnerTeam() {
        return this.ownerTeam;
    }

    @Nullable
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Nullable
    public String getPathDisplay() {
        return this.pathDisplay;
    }

    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Nullable
    public List<FilePermission> getPermissions() {
        return this.permissions;
    }

    @Nullable
    public Date getTimeInvited() {
        return this.timeInvited;
    }

    public static Builder newBuilder(String str, String str2, FolderPolicy folderPolicy, String str3) {
        return new Builder(str, str2, folderPolicy, str3);
    }

    public static class Builder {
        protected AccessLevel accessType;
        protected ExpectedSharedContentLinkMetadata expectedLinkMetadata;

        /* JADX INFO: renamed from: id */
        protected final String f733id;
        protected SharedContentLinkMetadata linkMetadata;
        protected final String name;
        protected List<String> ownerDisplayNames;
        protected Team ownerTeam;
        protected String parentSharedFolderId;
        protected String pathDisplay;
        protected String pathLower;
        protected List<FilePermission> permissions;
        protected final FolderPolicy policy;
        protected final String previewUrl;
        protected Date timeInvited;

        protected Builder(String str, String str2, FolderPolicy folderPolicy, String str3) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (str.length() < 4) {
                throw new IllegalArgumentException("String 'id' is shorter than 4");
            }
            if (!Pattern.matches("id:.+", str)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.f733id = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            if (folderPolicy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = folderPolicy;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'previewUrl' is null");
            }
            this.previewUrl = str3;
            this.accessType = null;
            this.expectedLinkMetadata = null;
            this.linkMetadata = null;
            this.ownerDisplayNames = null;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
            this.pathDisplay = null;
            this.pathLower = null;
            this.permissions = null;
            this.timeInvited = null;
        }

        public Builder withAccessType(AccessLevel accessLevel) {
            this.accessType = accessLevel;
            return this;
        }

        public Builder withExpectedLinkMetadata(ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata) {
            this.expectedLinkMetadata = expectedSharedContentLinkMetadata;
            return this;
        }

        public Builder withLinkMetadata(SharedContentLinkMetadata sharedContentLinkMetadata) {
            this.linkMetadata = sharedContentLinkMetadata;
            return this;
        }

        public Builder withOwnerDisplayNames(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'ownerDisplayNames' is null");
                    }
                }
            }
            this.ownerDisplayNames = list;
            return this;
        }

        public Builder withOwnerTeam(Team team) {
            this.ownerTeam = team;
            return this;
        }

        public Builder withParentSharedFolderId(String str) {
            if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
            this.parentSharedFolderId = str;
            return this;
        }

        public Builder withPathDisplay(String str) {
            this.pathDisplay = str;
            return this;
        }

        public Builder withPathLower(String str) {
            this.pathLower = str;
            return this;
        }

        public Builder withPermissions(List<FilePermission> list) {
            if (list != null) {
                Iterator<FilePermission> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'permissions' is null");
                    }
                }
            }
            this.permissions = list;
            return this;
        }

        public Builder withTimeInvited(Date date) {
            this.timeInvited = LangUtil.truncateMillis(date);
            return this;
        }

        public SharedFileMetadata build() {
            return new SharedFileMetadata(this.f733id, this.name, this.policy, this.previewUrl, this.accessType, this.expectedLinkMetadata, this.linkMetadata, this.ownerDisplayNames, this.ownerTeam, this.parentSharedFolderId, this.pathDisplay, this.pathLower, this.permissions, this.timeInvited);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessType, this.f732id, this.expectedLinkMetadata, this.linkMetadata, this.name, this.ownerDisplayNames, this.ownerTeam, this.parentSharedFolderId, this.pathDisplay, this.pathLower, this.permissions, this.policy, this.previewUrl, this.timeInvited});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        FolderPolicy folderPolicy;
        FolderPolicy folderPolicy2;
        String str3;
        String str4;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata;
        ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata2;
        SharedContentLinkMetadata sharedContentLinkMetadata;
        SharedContentLinkMetadata sharedContentLinkMetadata2;
        List<String> list;
        List<String> list2;
        Team team;
        Team team2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        List<FilePermission> list3;
        List<FilePermission> list4;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFileMetadata sharedFileMetadata = (SharedFileMetadata) obj;
        String str11 = this.f732id;
        String str12 = sharedFileMetadata.f732id;
        return (str11 == str12 || str11.equals(str12)) && ((str = this.name) == (str2 = sharedFileMetadata.name) || str.equals(str2)) && (((folderPolicy = this.policy) == (folderPolicy2 = sharedFileMetadata.policy) || folderPolicy.equals(folderPolicy2)) && (((str3 = this.previewUrl) == (str4 = sharedFileMetadata.previewUrl) || str3.equals(str4)) && (((accessLevel = this.accessType) == (accessLevel2 = sharedFileMetadata.accessType) || (accessLevel != null && accessLevel.equals(accessLevel2))) && (((expectedSharedContentLinkMetadata = this.expectedLinkMetadata) == (expectedSharedContentLinkMetadata2 = sharedFileMetadata.expectedLinkMetadata) || (expectedSharedContentLinkMetadata != null && expectedSharedContentLinkMetadata.equals(expectedSharedContentLinkMetadata2))) && (((sharedContentLinkMetadata = this.linkMetadata) == (sharedContentLinkMetadata2 = sharedFileMetadata.linkMetadata) || (sharedContentLinkMetadata != null && sharedContentLinkMetadata.equals(sharedContentLinkMetadata2))) && (((list = this.ownerDisplayNames) == (list2 = sharedFileMetadata.ownerDisplayNames) || (list != null && list.equals(list2))) && (((team = this.ownerTeam) == (team2 = sharedFileMetadata.ownerTeam) || (team != null && team.equals(team2))) && (((str5 = this.parentSharedFolderId) == (str6 = sharedFileMetadata.parentSharedFolderId) || (str5 != null && str5.equals(str6))) && (((str7 = this.pathDisplay) == (str8 = sharedFileMetadata.pathDisplay) || (str7 != null && str7.equals(str8))) && (((str9 = this.pathLower) == (str10 = sharedFileMetadata.pathLower) || (str9 != null && str9.equals(str10))) && (((list3 = this.permissions) == (list4 = sharedFileMetadata.permissions) || (list3 != null && list3.equals(list4))) && ((date = this.timeInvited) == (date2 = sharedFileMetadata.timeInvited) || (date != null && date.equals(date2))))))))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFileMetadata sharedFileMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(sharedFileMetadata.f732id, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(sharedFileMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(sharedFileMetadata.policy, jsonGenerator);
            jsonGenerator.writeFieldName("preview_url");
            StoneSerializers.string().serialize(sharedFileMetadata.previewUrl, jsonGenerator);
            if (sharedFileMetadata.accessType != null) {
                jsonGenerator.writeFieldName("access_type");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedFileMetadata.accessType, jsonGenerator);
            }
            if (sharedFileMetadata.expectedLinkMetadata != null) {
                jsonGenerator.writeFieldName("expected_link_metadata");
                StoneSerializers.nullableStruct(ExpectedSharedContentLinkMetadata.Serializer.INSTANCE).serialize(sharedFileMetadata.expectedLinkMetadata, jsonGenerator);
            }
            if (sharedFileMetadata.linkMetadata != null) {
                jsonGenerator.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).serialize(sharedFileMetadata.linkMetadata, jsonGenerator);
            }
            if (sharedFileMetadata.ownerDisplayNames != null) {
                jsonGenerator.writeFieldName("owner_display_names");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharedFileMetadata.ownerDisplayNames, jsonGenerator);
            }
            if (sharedFileMetadata.ownerTeam != null) {
                jsonGenerator.writeFieldName("owner_team");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(sharedFileMetadata.ownerTeam, jsonGenerator);
            }
            if (sharedFileMetadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFileMetadata.parentSharedFolderId, jsonGenerator);
            }
            if (sharedFileMetadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFileMetadata.pathDisplay, jsonGenerator);
            }
            if (sharedFileMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFileMetadata.pathLower, jsonGenerator);
            }
            if (sharedFileMetadata.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).serialize(sharedFileMetadata.permissions, jsonGenerator);
            }
            if (sharedFileMetadata.timeInvited != null) {
                jsonGenerator.writeFieldName("time_invited");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedFileMetadata.timeInvited, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFileMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                FolderPolicy folderPolicyDeserialize = null;
                String strDeserialize3 = null;
                AccessLevel accessLevel = null;
                ExpectedSharedContentLinkMetadata expectedSharedContentLinkMetadata = null;
                SharedContentLinkMetadata sharedContentLinkMetadata = null;
                List list = null;
                Team team = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                List list2 = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("policy".equals(currentName)) {
                        folderPolicyDeserialize = FolderPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("preview_url".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("access_type".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("expected_link_metadata".equals(currentName)) {
                        expectedSharedContentLinkMetadata = (ExpectedSharedContentLinkMetadata) StoneSerializers.nullableStruct(ExpectedSharedContentLinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("link_metadata".equals(currentName)) {
                        sharedContentLinkMetadata = (SharedContentLinkMetadata) StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("owner_display_names".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else if ("owner_team".equals(currentName)) {
                        team = (Team) StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("path_display".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("path_lower".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("time_invited".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (folderPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"policy\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"preview_url\" missing.");
                }
                SharedFileMetadata sharedFileMetadata = new SharedFileMetadata(strDeserialize, strDeserialize2, folderPolicyDeserialize, strDeserialize3, accessLevel, expectedSharedContentLinkMetadata, sharedContentLinkMetadata, list, team, str, str2, str3, list2, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFileMetadata, sharedFileMetadata.toStringMultiline());
                return sharedFileMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
