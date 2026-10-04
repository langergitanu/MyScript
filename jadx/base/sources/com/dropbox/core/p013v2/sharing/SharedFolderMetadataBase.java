package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.users.Team;
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
public class SharedFolderMetadataBase {

    @Nonnull
    protected final AccessLevel accessType;
    protected final boolean isInsideTeamFolder;
    protected final boolean isTeamFolder;

    @Nullable
    protected final List<String> ownerDisplayNames;

    @Nullable
    protected final Team ownerTeam;

    @Nullable
    protected final String parentFolderName;

    @Nullable
    protected final String parentSharedFolderId;

    @Nullable
    protected final String pathDisplay;

    @Nullable
    protected final String pathLower;

    public SharedFolderMetadataBase(@Nonnull AccessLevel accessLevel, boolean z, boolean z2, @Nullable List<String> list, @Nullable Team team, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessLevel;
        this.isInsideTeamFolder = z;
        this.isTeamFolder = z2;
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
        if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = str;
        this.pathDisplay = str2;
        this.pathLower = str3;
        this.parentFolderName = str4;
    }

    public SharedFolderMetadataBase(@Nonnull AccessLevel accessLevel, boolean z, boolean z2) {
        this(accessLevel, z, z2, null, null, null, null, null, null);
    }

    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    public boolean getIsInsideTeamFolder() {
        return this.isInsideTeamFolder;
    }

    public boolean getIsTeamFolder() {
        return this.isTeamFolder;
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
    public String getParentFolderName() {
        return this.parentFolderName;
    }

    public static Builder newBuilder(AccessLevel accessLevel, boolean z, boolean z2) {
        return new Builder(accessLevel, z, z2);
    }

    public static class Builder {
        protected final AccessLevel accessType;
        protected final boolean isInsideTeamFolder;
        protected final boolean isTeamFolder;
        protected List<String> ownerDisplayNames;
        protected Team ownerTeam;
        protected String parentFolderName;
        protected String parentSharedFolderId;
        protected String pathDisplay;
        protected String pathLower;

        protected Builder(AccessLevel accessLevel, boolean z, boolean z2) {
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessLevel;
            this.isInsideTeamFolder = z;
            this.isTeamFolder = z2;
            this.ownerDisplayNames = null;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
            this.pathDisplay = null;
            this.pathLower = null;
            this.parentFolderName = null;
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

        public Builder withParentFolderName(String str) {
            this.parentFolderName = str;
            return this;
        }

        public SharedFolderMetadataBase build() {
            return new SharedFolderMetadataBase(this.accessType, this.isInsideTeamFolder, this.isTeamFolder, this.ownerDisplayNames, this.ownerTeam, this.parentSharedFolderId, this.pathDisplay, this.pathLower, this.parentFolderName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessType, Boolean.valueOf(this.isInsideTeamFolder), Boolean.valueOf(this.isTeamFolder), this.ownerDisplayNames, this.ownerTeam, this.parentSharedFolderId, this.pathDisplay, this.pathLower, this.parentFolderName});
    }

    public boolean equals(Object obj) {
        SharedFolderMetadataBase sharedFolderMetadataBase;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        List<String> list;
        List<String> list2;
        Team team;
        Team team2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((accessLevel = this.accessType) == (accessLevel2 = (sharedFolderMetadataBase = (SharedFolderMetadataBase) obj).accessType) || accessLevel.equals(accessLevel2)) && this.isInsideTeamFolder == sharedFolderMetadataBase.isInsideTeamFolder && this.isTeamFolder == sharedFolderMetadataBase.isTeamFolder && (((list = this.ownerDisplayNames) == (list2 = sharedFolderMetadataBase.ownerDisplayNames) || (list != null && list.equals(list2))) && (((team = this.ownerTeam) == (team2 = sharedFolderMetadataBase.ownerTeam) || (team != null && team.equals(team2))) && (((str = this.parentSharedFolderId) == (str2 = sharedFolderMetadataBase.parentSharedFolderId) || (str != null && str.equals(str2))) && (((str3 = this.pathDisplay) == (str4 = sharedFolderMetadataBase.pathDisplay) || (str3 != null && str3.equals(str4))) && (((str5 = this.pathLower) == (str6 = sharedFolderMetadataBase.pathLower) || (str5 != null && str5.equals(str6))) && ((str7 = this.parentFolderName) == (str8 = sharedFolderMetadataBase.parentFolderName) || (str7 != null && str7.equals(str8))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<SharedFolderMetadataBase> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderMetadataBase sharedFolderMetadataBase, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(sharedFolderMetadataBase.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("is_inside_team_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedFolderMetadataBase.isInsideTeamFolder), jsonGenerator);
            jsonGenerator.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedFolderMetadataBase.isTeamFolder), jsonGenerator);
            if (sharedFolderMetadataBase.ownerDisplayNames != null) {
                jsonGenerator.writeFieldName("owner_display_names");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharedFolderMetadataBase.ownerDisplayNames, jsonGenerator);
            }
            if (sharedFolderMetadataBase.ownerTeam != null) {
                jsonGenerator.writeFieldName("owner_team");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(sharedFolderMetadataBase.ownerTeam, jsonGenerator);
            }
            if (sharedFolderMetadataBase.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadataBase.parentSharedFolderId, jsonGenerator);
            }
            if (sharedFolderMetadataBase.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadataBase.pathDisplay, jsonGenerator);
            }
            if (sharedFolderMetadataBase.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadataBase.pathLower, jsonGenerator);
            }
            if (sharedFolderMetadataBase.parentFolderName != null) {
                jsonGenerator.writeFieldName("parent_folder_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadataBase.parentFolderName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderMetadataBase deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize2 = null;
                AccessLevel accessLevelDeserialize = null;
                List list = null;
                Team team = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("is_inside_team_folder".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("is_team_folder".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
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
                    } else if ("parent_folder_name".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_inside_team_folder\" missing.");
                }
                if (boolDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_team_folder\" missing.");
                }
                SharedFolderMetadataBase sharedFolderMetadataBase = new SharedFolderMetadataBase(accessLevelDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), list, team, str, str2, str3, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderMetadataBase, sharedFolderMetadataBase.toStringMultiline());
                return sharedFolderMetadataBase;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
