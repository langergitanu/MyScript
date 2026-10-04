package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessInheritance;
import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.FolderPermission;
import com.dropbox.core.p013v2.sharing.FolderPolicy;
import com.dropbox.core.p013v2.sharing.SharedContentLinkMetadata;
import com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase;
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
public class SharedFolderMetadata extends SharedFolderMetadataBase {

    @Nonnull
    protected final AccessInheritance accessInheritance;

    @Nullable
    protected final SharedContentLinkMetadata linkMetadata;

    @Nonnull
    protected final String name;

    @Nullable
    protected final List<FolderPermission> permissions;

    @Nonnull
    protected final FolderPolicy policy;

    @Nonnull
    protected final String previewUrl;

    @Nonnull
    protected final String sharedFolderId;

    @Nonnull
    protected final Date timeInvited;

    public SharedFolderMetadata(@Nonnull AccessLevel accessLevel, boolean z, boolean z2, @Nonnull String str, @Nonnull FolderPolicy folderPolicy, @Nonnull String str2, @Nonnull String str3, @Nonnull Date date, @Nullable List<String> list, @Nullable Team team, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SharedContentLinkMetadata sharedContentLinkMetadata, @Nullable List<FolderPermission> list2, @Nonnull AccessInheritance accessInheritance) {
        super(accessLevel, z, z2, list, team, str4, str5, str6, str7);
        this.linkMetadata = sharedContentLinkMetadata;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        if (list2 != null) {
            Iterator<FolderPermission> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = list2;
        if (folderPolicy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = folderPolicy;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'previewUrl' is null");
        }
        this.previewUrl = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str3)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str3;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'timeInvited' is null");
        }
        this.timeInvited = LangUtil.truncateMillis(date);
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
    }

    public SharedFolderMetadata(@Nonnull AccessLevel accessLevel, boolean z, boolean z2, @Nonnull String str, @Nonnull FolderPolicy folderPolicy, @Nonnull String str2, @Nonnull String str3, @Nonnull Date date) {
        this(accessLevel, z, z2, str, folderPolicy, str2, str3, date, null, null, null, null, null, null, null, null, AccessInheritance.INHERIT);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public boolean getIsInsideTeamFolder() {
        return this.isInsideTeamFolder;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public boolean getIsTeamFolder() {
        return this.isTeamFolder;
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

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public Date getTimeInvited() {
        return this.timeInvited;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public List<String> getOwnerDisplayNames() {
        return this.ownerDisplayNames;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public Team getOwnerTeam() {
        return this.ownerTeam;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public String getPathDisplay() {
        return this.pathDisplay;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    @Nullable
    public String getParentFolderName() {
        return this.parentFolderName;
    }

    @Nullable
    public SharedContentLinkMetadata getLinkMetadata() {
        return this.linkMetadata;
    }

    @Nullable
    public List<FolderPermission> getPermissions() {
        return this.permissions;
    }

    @Nonnull
    public AccessInheritance getAccessInheritance() {
        return this.accessInheritance;
    }

    public static Builder newBuilder(AccessLevel accessLevel, boolean z, boolean z2, String str, FolderPolicy folderPolicy, String str2, String str3, Date date) {
        return new Builder(accessLevel, z, z2, str, folderPolicy, str2, str3, date);
    }

    public static class Builder extends SharedFolderMetadataBase.Builder {
        protected AccessInheritance accessInheritance;
        protected SharedContentLinkMetadata linkMetadata;
        protected final String name;
        protected List<FolderPermission> permissions;
        protected final FolderPolicy policy;
        protected final String previewUrl;
        protected final String sharedFolderId;
        protected final Date timeInvited;

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public /* bridge */ /* synthetic */ SharedFolderMetadataBase.Builder withOwnerDisplayNames(List list) {
            return withOwnerDisplayNames((List<String>) list);
        }

        protected Builder(AccessLevel accessLevel, boolean z, boolean z2, String str, FolderPolicy folderPolicy, String str2, String str3, Date date) {
            super(accessLevel, z, z2);
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str;
            if (folderPolicy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = folderPolicy;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'previewUrl' is null");
            }
            this.previewUrl = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str3)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str3;
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'timeInvited' is null");
            }
            this.timeInvited = LangUtil.truncateMillis(date);
            this.linkMetadata = null;
            this.permissions = null;
            this.accessInheritance = AccessInheritance.INHERIT;
        }

        public Builder withLinkMetadata(SharedContentLinkMetadata sharedContentLinkMetadata) {
            this.linkMetadata = sharedContentLinkMetadata;
            return this;
        }

        public Builder withPermissions(List<FolderPermission> list) {
            if (list != null) {
                Iterator<FolderPermission> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'permissions' is null");
                    }
                }
            }
            this.permissions = list;
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

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withOwnerDisplayNames(List<String> list) {
            super.withOwnerDisplayNames(list);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withOwnerTeam(Team team) {
            super.withOwnerTeam(team);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withParentSharedFolderId(String str) {
            super.withParentSharedFolderId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withPathDisplay(String str) {
            super.withPathDisplay(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withPathLower(String str) {
            super.withPathLower(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public Builder withParentFolderName(String str) {
            super.withParentFolderName(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.SharedFolderMetadataBase.Builder
        public SharedFolderMetadata build() {
            return new SharedFolderMetadata(this.accessType, this.isInsideTeamFolder, this.isTeamFolder, this.name, this.policy, this.previewUrl, this.sharedFolderId, this.timeInvited, this.ownerDisplayNames, this.ownerTeam, this.parentSharedFolderId, this.pathDisplay, this.pathLower, this.parentFolderName, this.linkMetadata, this.permissions, this.accessInheritance);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.linkMetadata, this.name, this.permissions, this.policy, this.previewUrl, this.sharedFolderId, this.timeInvited, this.accessInheritance});
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public boolean equals(Object obj) {
        String str;
        String str2;
        FolderPolicy folderPolicy;
        FolderPolicy folderPolicy2;
        String str3;
        String str4;
        String str5;
        String str6;
        Date date;
        Date date2;
        SharedContentLinkMetadata sharedContentLinkMetadata;
        SharedContentLinkMetadata sharedContentLinkMetadata2;
        List<FolderPermission> list;
        List<FolderPermission> list2;
        AccessInheritance accessInheritance;
        AccessInheritance accessInheritance2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SharedFolderMetadata sharedFolderMetadata = (SharedFolderMetadata) obj;
            if ((this.accessType == sharedFolderMetadata.accessType || this.accessType.equals(sharedFolderMetadata.accessType)) && this.isInsideTeamFolder == sharedFolderMetadata.isInsideTeamFolder && this.isTeamFolder == sharedFolderMetadata.isTeamFolder && (((str = this.name) == (str2 = sharedFolderMetadata.name) || str.equals(str2)) && (((folderPolicy = this.policy) == (folderPolicy2 = sharedFolderMetadata.policy) || folderPolicy.equals(folderPolicy2)) && (((str3 = this.previewUrl) == (str4 = sharedFolderMetadata.previewUrl) || str3.equals(str4)) && (((str5 = this.sharedFolderId) == (str6 = sharedFolderMetadata.sharedFolderId) || str5.equals(str6)) && (((date = this.timeInvited) == (date2 = sharedFolderMetadata.timeInvited) || date.equals(date2)) && ((this.ownerDisplayNames == sharedFolderMetadata.ownerDisplayNames || (this.ownerDisplayNames != null && this.ownerDisplayNames.equals(sharedFolderMetadata.ownerDisplayNames))) && ((this.ownerTeam == sharedFolderMetadata.ownerTeam || (this.ownerTeam != null && this.ownerTeam.equals(sharedFolderMetadata.ownerTeam))) && ((this.parentSharedFolderId == sharedFolderMetadata.parentSharedFolderId || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(sharedFolderMetadata.parentSharedFolderId))) && ((this.pathDisplay == sharedFolderMetadata.pathDisplay || (this.pathDisplay != null && this.pathDisplay.equals(sharedFolderMetadata.pathDisplay))) && ((this.pathLower == sharedFolderMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(sharedFolderMetadata.pathLower))) && ((this.parentFolderName == sharedFolderMetadata.parentFolderName || (this.parentFolderName != null && this.parentFolderName.equals(sharedFolderMetadata.parentFolderName))) && (((sharedContentLinkMetadata = this.linkMetadata) == (sharedContentLinkMetadata2 = sharedFolderMetadata.linkMetadata) || (sharedContentLinkMetadata != null && sharedContentLinkMetadata.equals(sharedContentLinkMetadata2))) && (((list = this.permissions) == (list2 = sharedFolderMetadata.permissions) || (list != null && list.equals(list2))) && ((accessInheritance = this.accessInheritance) == (accessInheritance2 = sharedFolderMetadata.accessInheritance) || accessInheritance.equals(accessInheritance2)))))))))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.SharedFolderMetadataBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderMetadata sharedFolderMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(sharedFolderMetadata.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("is_inside_team_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedFolderMetadata.isInsideTeamFolder), jsonGenerator);
            jsonGenerator.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharedFolderMetadata.isTeamFolder), jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(sharedFolderMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(sharedFolderMetadata.policy, jsonGenerator);
            jsonGenerator.writeFieldName("preview_url");
            StoneSerializers.string().serialize(sharedFolderMetadata.previewUrl, jsonGenerator);
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(sharedFolderMetadata.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("time_invited");
            StoneSerializers.timestamp().serialize(sharedFolderMetadata.timeInvited, jsonGenerator);
            if (sharedFolderMetadata.ownerDisplayNames != null) {
                jsonGenerator.writeFieldName("owner_display_names");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharedFolderMetadata.ownerDisplayNames, jsonGenerator);
            }
            if (sharedFolderMetadata.ownerTeam != null) {
                jsonGenerator.writeFieldName("owner_team");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(sharedFolderMetadata.ownerTeam, jsonGenerator);
            }
            if (sharedFolderMetadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadata.parentSharedFolderId, jsonGenerator);
            }
            if (sharedFolderMetadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadata.pathDisplay, jsonGenerator);
            }
            if (sharedFolderMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadata.pathLower, jsonGenerator);
            }
            if (sharedFolderMetadata.parentFolderName != null) {
                jsonGenerator.writeFieldName("parent_folder_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderMetadata.parentFolderName, jsonGenerator);
            }
            if (sharedFolderMetadata.linkMetadata != null) {
                jsonGenerator.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).serialize(sharedFolderMetadata.linkMetadata, jsonGenerator);
            }
            if (sharedFolderMetadata.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).serialize(sharedFolderMetadata.permissions, jsonGenerator);
            }
            jsonGenerator.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(sharedFolderMetadata.accessInheritance, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccessLevel accessLevelDeserialize = null;
                String strDeserialize = null;
                FolderPolicy folderPolicyDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                Date dateDeserialize = null;
                List list = null;
                Team team = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                SharedContentLinkMetadata sharedContentLinkMetadata = null;
                List list2 = null;
                AccessInheritance accessInheritanceDeserialize = AccessInheritance.INHERIT;
                Boolean boolDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("is_inside_team_folder".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("is_team_folder".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("policy".equals(currentName)) {
                        folderPolicyDeserialize = FolderPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("preview_url".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("shared_folder_id".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("time_invited".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
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
                    } else if ("link_metadata".equals(currentName)) {
                        sharedContentLinkMetadata = (SharedContentLinkMetadata) StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("access_inheritance".equals(currentName)) {
                        accessInheritanceDeserialize = AccessInheritance.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (folderPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"policy\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"preview_url\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"time_invited\" missing.");
                }
                SharedFolderMetadata sharedFolderMetadata = new SharedFolderMetadata(accessLevelDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), strDeserialize, folderPolicyDeserialize, strDeserialize2, strDeserialize3, dateDeserialize, list, team, str, str2, str3, str4, sharedContentLinkMetadata, list2, accessInheritanceDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderMetadata, sharedFolderMetadata.toStringMultiline());
                return sharedFolderMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
