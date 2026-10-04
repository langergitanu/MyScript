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
public class SfTeamJoinFromOobLinkDetails {

    @Nonnull
    protected final String originalFolderName;

    @Nullable
    protected final String sharingPermission;
    protected final long targetAssetIndex;

    @Nullable
    protected final String tokenKey;

    public SfTeamJoinFromOobLinkDetails(long j, @Nonnull String str, @Nullable String str2, @Nullable String str3) {
        this.targetAssetIndex = j;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = str;
        this.tokenKey = str2;
        this.sharingPermission = str3;
    }

    public SfTeamJoinFromOobLinkDetails(long j, @Nonnull String str) {
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
    public String getTokenKey() {
        return this.tokenKey;
    }

    @Nullable
    public String getSharingPermission() {
        return this.sharingPermission;
    }

    public static Builder newBuilder(long j, String str) {
        return new Builder(j, str);
    }

    public static class Builder {
        protected final String originalFolderName;
        protected String sharingPermission;
        protected final long targetAssetIndex;
        protected String tokenKey;

        protected Builder(long j, String str) {
            this.targetAssetIndex = j;
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
            }
            this.originalFolderName = str;
            this.tokenKey = null;
            this.sharingPermission = null;
        }

        public Builder withTokenKey(String str) {
            this.tokenKey = str;
            return this;
        }

        public Builder withSharingPermission(String str) {
            this.sharingPermission = str;
            return this;
        }

        public SfTeamJoinFromOobLinkDetails build() {
            return new SfTeamJoinFromOobLinkDetails(this.targetAssetIndex, this.originalFolderName, this.tokenKey, this.sharingPermission);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.targetAssetIndex), this.originalFolderName, this.tokenKey, this.sharingPermission});
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
            SfTeamJoinFromOobLinkDetails sfTeamJoinFromOobLinkDetails = (SfTeamJoinFromOobLinkDetails) obj;
            if (this.targetAssetIndex == sfTeamJoinFromOobLinkDetails.targetAssetIndex && (((str = this.originalFolderName) == (str2 = sfTeamJoinFromOobLinkDetails.originalFolderName) || str.equals(str2)) && (((str3 = this.tokenKey) == (str4 = sfTeamJoinFromOobLinkDetails.tokenKey) || (str3 != null && str3.equals(str4))) && ((str5 = this.sharingPermission) == (str6 = sfTeamJoinFromOobLinkDetails.sharingPermission) || (str5 != null && str5.equals(str6)))))) {
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

    static class Serializer extends StructSerializer<SfTeamJoinFromOobLinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SfTeamJoinFromOobLinkDetails sfTeamJoinFromOobLinkDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(sfTeamJoinFromOobLinkDetails.targetAssetIndex), jsonGenerator);
            jsonGenerator.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(sfTeamJoinFromOobLinkDetails.originalFolderName, jsonGenerator);
            if (sfTeamJoinFromOobLinkDetails.tokenKey != null) {
                jsonGenerator.writeFieldName("token_key");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sfTeamJoinFromOobLinkDetails.tokenKey, jsonGenerator);
            }
            if (sfTeamJoinFromOobLinkDetails.sharingPermission != null) {
                jsonGenerator.writeFieldName("sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sfTeamJoinFromOobLinkDetails.sharingPermission, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SfTeamJoinFromOobLinkDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("token_key".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("sharing_permission".equals(currentName)) {
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
                SfTeamJoinFromOobLinkDetails sfTeamJoinFromOobLinkDetails = new SfTeamJoinFromOobLinkDetails(lDeserialize.longValue(), strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sfTeamJoinFromOobLinkDetails, sfTeamJoinFromOobLinkDetails.toStringMultiline());
                return sfTeamJoinFromOobLinkDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
