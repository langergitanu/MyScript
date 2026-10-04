package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SfExternalInviteWarnDetails {

    @Nullable
    protected final String newSharingPermission;

    @Nonnull
    protected final String originalFolderName;

    @Nullable
    protected final String previousSharingPermission;
    protected final long targetAssetIndex;

    public SfExternalInviteWarnDetails(long j, @Nonnull String str, @Nullable String str2, @Nullable String str3) {
        this.targetAssetIndex = j;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = str;
        this.newSharingPermission = str2;
        this.previousSharingPermission = str3;
    }

    public SfExternalInviteWarnDetails(long j, @Nonnull String str) {
        this(j, str, null, null);
    }

    public long getTargetAssetIndex() {
        return this.targetAssetIndex;
    }

    @Nonnull
    public String getOriginalFolderName() {
        return this.originalFolderName;
    }

    @Nullable
    public String getNewSharingPermission() {
        return this.newSharingPermission;
    }

    @Nullable
    public String getPreviousSharingPermission() {
        return this.previousSharingPermission;
    }

    public static Builder newBuilder(long j, String str) {
        return new Builder(j, str);
    }

    public static class Builder {
        protected String newSharingPermission;
        protected final String originalFolderName;
        protected String previousSharingPermission;
        protected final long targetAssetIndex;

        protected Builder(long j, String str) {
            this.targetAssetIndex = j;
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
            }
            this.originalFolderName = str;
            this.newSharingPermission = null;
            this.previousSharingPermission = null;
        }

        public Builder withNewSharingPermission(String str) {
            this.newSharingPermission = str;
            return this;
        }

        public Builder withPreviousSharingPermission(String str) {
            this.previousSharingPermission = str;
            return this;
        }

        public SfExternalInviteWarnDetails build() {
            return new SfExternalInviteWarnDetails(this.targetAssetIndex, this.originalFolderName, this.newSharingPermission, this.previousSharingPermission);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.targetAssetIndex), this.originalFolderName, this.newSharingPermission, this.previousSharingPermission});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SfExternalInviteWarnDetails sfExternalInviteWarnDetails = (SfExternalInviteWarnDetails) obj;
            if (this.targetAssetIndex == sfExternalInviteWarnDetails.targetAssetIndex && (((str = this.originalFolderName) == (str2 = sfExternalInviteWarnDetails.originalFolderName) || str.equals(str2)) && (((str3 = this.newSharingPermission) == (str4 = sfExternalInviteWarnDetails.newSharingPermission) || (str3 != null && str3.equals(str4))) && ((str5 = this.previousSharingPermission) == (str6 = sfExternalInviteWarnDetails.previousSharingPermission) || (str5 != null && str5.equals(str6)))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SfExternalInviteWarnDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SfExternalInviteWarnDetails sfExternalInviteWarnDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(sfExternalInviteWarnDetails.targetAssetIndex), jsonGenerator);
            jsonGenerator.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(sfExternalInviteWarnDetails.originalFolderName, jsonGenerator);
            if (sfExternalInviteWarnDetails.newSharingPermission != null) {
                jsonGenerator.writeFieldName("new_sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sfExternalInviteWarnDetails.newSharingPermission, jsonGenerator);
            }
            if (sfExternalInviteWarnDetails.previousSharingPermission != null) {
                jsonGenerator.writeFieldName("previous_sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sfExternalInviteWarnDetails.previousSharingPermission, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SfExternalInviteWarnDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("target_asset_index".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("original_folder_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_sharing_permission".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_sharing_permission".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"target_asset_index\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"original_folder_name\" missing.");
                }
                SfExternalInviteWarnDetails sfExternalInviteWarnDetails = new SfExternalInviteWarnDetails(lDeserialize.longValue(), strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sfExternalInviteWarnDetails, sfExternalInviteWarnDetails.toStringMultiline());
                return sfExternalInviteWarnDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
