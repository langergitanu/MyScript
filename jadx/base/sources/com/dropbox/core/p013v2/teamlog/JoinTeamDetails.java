package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FolderLogInfo;
import com.dropbox.core.p013v2.teamlog.LinkedDeviceLogInfo;
import com.dropbox.core.p013v2.teamlog.UserLinkedAppLogInfo;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class JoinTeamDetails {

    @Nullable
    protected final Boolean hasLinkedApps;

    @Nullable
    protected final Boolean hasLinkedDevices;

    @Nullable
    protected final Boolean hasLinkedSharedFolders;

    @Nonnull
    protected final List<UserLinkedAppLogInfo> linkedApps;

    @Nonnull
    protected final List<LinkedDeviceLogInfo> linkedDevices;

    @Nonnull
    protected final List<FolderLogInfo> linkedSharedFolders;

    @Nullable
    protected final Boolean wasLinkedAppsTruncated;

    @Nullable
    protected final Boolean wasLinkedDevicesTruncated;

    @Nullable
    protected final Boolean wasLinkedSharedFoldersTruncated;

    public JoinTeamDetails(@Nonnull List<UserLinkedAppLogInfo> list, @Nonnull List<LinkedDeviceLogInfo> list2, @Nonnull List<FolderLogInfo> list3, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'linkedApps' is null");
        }
        Iterator<UserLinkedAppLogInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'linkedApps' is null");
            }
        }
        this.linkedApps = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'linkedDevices' is null");
        }
        Iterator<LinkedDeviceLogInfo> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'linkedDevices' is null");
            }
        }
        this.linkedDevices = list2;
        if (list3 == null) {
            throw new IllegalArgumentException("Required value for 'linkedSharedFolders' is null");
        }
        Iterator<FolderLogInfo> it3 = list3.iterator();
        while (it3.hasNext()) {
            if (it3.next() == null) {
                throw new IllegalArgumentException("An item in list 'linkedSharedFolders' is null");
            }
        }
        this.linkedSharedFolders = list3;
        this.wasLinkedAppsTruncated = bool;
        this.wasLinkedDevicesTruncated = bool2;
        this.wasLinkedSharedFoldersTruncated = bool3;
        this.hasLinkedApps = bool4;
        this.hasLinkedDevices = bool5;
        this.hasLinkedSharedFolders = bool6;
    }

    public JoinTeamDetails(@Nonnull List<UserLinkedAppLogInfo> list, @Nonnull List<LinkedDeviceLogInfo> list2, @Nonnull List<FolderLogInfo> list3) {
        this(list, list2, list3, null, null, null, null, null, null);
    }

    @Nonnull
    public List<UserLinkedAppLogInfo> getLinkedApps() {
        return this.linkedApps;
    }

    @Nonnull
    public List<LinkedDeviceLogInfo> getLinkedDevices() {
        return this.linkedDevices;
    }

    @Nonnull
    public List<FolderLogInfo> getLinkedSharedFolders() {
        return this.linkedSharedFolders;
    }

    @Nullable
    public Boolean getWasLinkedAppsTruncated() {
        return this.wasLinkedAppsTruncated;
    }

    @Nullable
    public Boolean getWasLinkedDevicesTruncated() {
        return this.wasLinkedDevicesTruncated;
    }

    @Nullable
    public Boolean getWasLinkedSharedFoldersTruncated() {
        return this.wasLinkedSharedFoldersTruncated;
    }

    @Nullable
    public Boolean getHasLinkedApps() {
        return this.hasLinkedApps;
    }

    @Nullable
    public Boolean getHasLinkedDevices() {
        return this.hasLinkedDevices;
    }

    @Nullable
    public Boolean getHasLinkedSharedFolders() {
        return this.hasLinkedSharedFolders;
    }

    public static Builder newBuilder(List<UserLinkedAppLogInfo> list, List<LinkedDeviceLogInfo> list2, List<FolderLogInfo> list3) {
        return new Builder(list, list2, list3);
    }

    public static class Builder {
        protected Boolean hasLinkedApps;
        protected Boolean hasLinkedDevices;
        protected Boolean hasLinkedSharedFolders;
        protected final List<UserLinkedAppLogInfo> linkedApps;
        protected final List<LinkedDeviceLogInfo> linkedDevices;
        protected final List<FolderLogInfo> linkedSharedFolders;
        protected Boolean wasLinkedAppsTruncated;
        protected Boolean wasLinkedDevicesTruncated;
        protected Boolean wasLinkedSharedFoldersTruncated;

        protected Builder(List<UserLinkedAppLogInfo> list, List<LinkedDeviceLogInfo> list2, List<FolderLogInfo> list3) {
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'linkedApps' is null");
            }
            Iterator<UserLinkedAppLogInfo> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'linkedApps' is null");
                }
            }
            this.linkedApps = list;
            if (list2 == null) {
                throw new IllegalArgumentException("Required value for 'linkedDevices' is null");
            }
            Iterator<LinkedDeviceLogInfo> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'linkedDevices' is null");
                }
            }
            this.linkedDevices = list2;
            if (list3 == null) {
                throw new IllegalArgumentException("Required value for 'linkedSharedFolders' is null");
            }
            Iterator<FolderLogInfo> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (it3.next() == null) {
                    throw new IllegalArgumentException("An item in list 'linkedSharedFolders' is null");
                }
            }
            this.linkedSharedFolders = list3;
            this.wasLinkedAppsTruncated = null;
            this.wasLinkedDevicesTruncated = null;
            this.wasLinkedSharedFoldersTruncated = null;
            this.hasLinkedApps = null;
            this.hasLinkedDevices = null;
            this.hasLinkedSharedFolders = null;
        }

        public Builder withWasLinkedAppsTruncated(Boolean bool) {
            this.wasLinkedAppsTruncated = bool;
            return this;
        }

        public Builder withWasLinkedDevicesTruncated(Boolean bool) {
            this.wasLinkedDevicesTruncated = bool;
            return this;
        }

        public Builder withWasLinkedSharedFoldersTruncated(Boolean bool) {
            this.wasLinkedSharedFoldersTruncated = bool;
            return this;
        }

        public Builder withHasLinkedApps(Boolean bool) {
            this.hasLinkedApps = bool;
            return this;
        }

        public Builder withHasLinkedDevices(Boolean bool) {
            this.hasLinkedDevices = bool;
            return this;
        }

        public Builder withHasLinkedSharedFolders(Boolean bool) {
            this.hasLinkedSharedFolders = bool;
            return this;
        }

        public JoinTeamDetails build() {
            return new JoinTeamDetails(this.linkedApps, this.linkedDevices, this.linkedSharedFolders, this.wasLinkedAppsTruncated, this.wasLinkedDevicesTruncated, this.wasLinkedSharedFoldersTruncated, this.hasLinkedApps, this.hasLinkedDevices, this.hasLinkedSharedFolders);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.linkedApps, this.linkedDevices, this.linkedSharedFolders, this.wasLinkedAppsTruncated, this.wasLinkedDevicesTruncated, this.wasLinkedSharedFoldersTruncated, this.hasLinkedApps, this.hasLinkedDevices, this.hasLinkedSharedFolders});
    }

    public boolean equals(Object obj) {
        List<LinkedDeviceLogInfo> list;
        List<LinkedDeviceLogInfo> list2;
        List<FolderLogInfo> list3;
        List<FolderLogInfo> list4;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        JoinTeamDetails joinTeamDetails = (JoinTeamDetails) obj;
        List<UserLinkedAppLogInfo> list5 = this.linkedApps;
        List<UserLinkedAppLogInfo> list6 = joinTeamDetails.linkedApps;
        return (list5 == list6 || list5.equals(list6)) && ((list = this.linkedDevices) == (list2 = joinTeamDetails.linkedDevices) || list.equals(list2)) && (((list3 = this.linkedSharedFolders) == (list4 = joinTeamDetails.linkedSharedFolders) || list3.equals(list4)) && (((bool = this.wasLinkedAppsTruncated) == (bool2 = joinTeamDetails.wasLinkedAppsTruncated) || (bool != null && bool.equals(bool2))) && (((bool3 = this.wasLinkedDevicesTruncated) == (bool4 = joinTeamDetails.wasLinkedDevicesTruncated) || (bool3 != null && bool3.equals(bool4))) && (((bool5 = this.wasLinkedSharedFoldersTruncated) == (bool6 = joinTeamDetails.wasLinkedSharedFoldersTruncated) || (bool5 != null && bool5.equals(bool6))) && (((bool7 = this.hasLinkedApps) == (bool8 = joinTeamDetails.hasLinkedApps) || (bool7 != null && bool7.equals(bool8))) && (((bool9 = this.hasLinkedDevices) == (bool10 = joinTeamDetails.hasLinkedDevices) || (bool9 != null && bool9.equals(bool10))) && ((bool11 = this.hasLinkedSharedFolders) == (bool12 = joinTeamDetails.hasLinkedSharedFolders) || (bool11 != null && bool11.equals(bool12)))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<JoinTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(JoinTeamDetails joinTeamDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("linked_apps");
            StoneSerializers.list(UserLinkedAppLogInfo.Serializer.INSTANCE).serialize(joinTeamDetails.linkedApps, jsonGenerator);
            jsonGenerator.writeFieldName("linked_devices");
            StoneSerializers.list(LinkedDeviceLogInfo.Serializer.INSTANCE).serialize(joinTeamDetails.linkedDevices, jsonGenerator);
            jsonGenerator.writeFieldName("linked_shared_folders");
            StoneSerializers.list(FolderLogInfo.Serializer.INSTANCE).serialize(joinTeamDetails.linkedSharedFolders, jsonGenerator);
            if (joinTeamDetails.wasLinkedAppsTruncated != null) {
                jsonGenerator.writeFieldName("was_linked_apps_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.wasLinkedAppsTruncated, jsonGenerator);
            }
            if (joinTeamDetails.wasLinkedDevicesTruncated != null) {
                jsonGenerator.writeFieldName("was_linked_devices_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.wasLinkedDevicesTruncated, jsonGenerator);
            }
            if (joinTeamDetails.wasLinkedSharedFoldersTruncated != null) {
                jsonGenerator.writeFieldName("was_linked_shared_folders_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.wasLinkedSharedFoldersTruncated, jsonGenerator);
            }
            if (joinTeamDetails.hasLinkedApps != null) {
                jsonGenerator.writeFieldName("has_linked_apps");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.hasLinkedApps, jsonGenerator);
            }
            if (joinTeamDetails.hasLinkedDevices != null) {
                jsonGenerator.writeFieldName("has_linked_devices");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.hasLinkedDevices, jsonGenerator);
            }
            if (joinTeamDetails.hasLinkedSharedFolders != null) {
                jsonGenerator.writeFieldName("has_linked_shared_folders");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(joinTeamDetails.hasLinkedSharedFolders, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public JoinTeamDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                List list3 = null;
                Boolean bool = null;
                Boolean bool2 = null;
                Boolean bool3 = null;
                Boolean bool4 = null;
                Boolean bool5 = null;
                Boolean bool6 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("linked_apps".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserLinkedAppLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("linked_devices".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(LinkedDeviceLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("linked_shared_folders".equals(currentName)) {
                        list3 = (List) StoneSerializers.list(FolderLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("was_linked_apps_truncated".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("was_linked_devices_truncated".equals(currentName)) {
                        bool2 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("was_linked_shared_folders_truncated".equals(currentName)) {
                        bool3 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("has_linked_apps".equals(currentName)) {
                        bool4 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("has_linked_devices".equals(currentName)) {
                        bool5 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("has_linked_shared_folders".equals(currentName)) {
                        bool6 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"linked_apps\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"linked_devices\" missing.");
                }
                if (list3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"linked_shared_folders\" missing.");
                }
                JoinTeamDetails joinTeamDetails = new JoinTeamDetails(list, list2, list3, bool, bool2, bool3, bool4, bool5, bool6);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(joinTeamDetails, joinTeamDetails.toStringMultiline());
                return joinTeamDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
