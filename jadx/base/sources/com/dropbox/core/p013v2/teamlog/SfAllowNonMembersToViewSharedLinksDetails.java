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
public class SfAllowNonMembersToViewSharedLinksDetails {

    @Nonnull
    protected final String originalFolderName;

    @Nullable
    protected final String sharedFolderType;
    protected final long targetAssetIndex;

    public SfAllowNonMembersToViewSharedLinksDetails(long j, @Nonnull String str, @Nullable String str2) {
        this.targetAssetIndex = j;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = str;
        this.sharedFolderType = str2;
    }

    public SfAllowNonMembersToViewSharedLinksDetails(long j, @Nonnull String str) {
        this(j, str, null);
    }

    public long getTargetAssetIndex() {
        return this.targetAssetIndex;
    }

    @Nonnull
    public String getOriginalFolderName() {
        return this.originalFolderName;
    }

    @Nullable
    public String getSharedFolderType() {
        return this.sharedFolderType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.targetAssetIndex), this.originalFolderName, this.sharedFolderType});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SfAllowNonMembersToViewSharedLinksDetails sfAllowNonMembersToViewSharedLinksDetails = (SfAllowNonMembersToViewSharedLinksDetails) obj;
            if (this.targetAssetIndex == sfAllowNonMembersToViewSharedLinksDetails.targetAssetIndex && (((str = this.originalFolderName) == (str2 = sfAllowNonMembersToViewSharedLinksDetails.originalFolderName) || str.equals(str2)) && ((str3 = this.sharedFolderType) == (str4 = sfAllowNonMembersToViewSharedLinksDetails.sharedFolderType) || (str3 != null && str3.equals(str4))))) {
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

    static class Serializer extends StructSerializer<SfAllowNonMembersToViewSharedLinksDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SfAllowNonMembersToViewSharedLinksDetails sfAllowNonMembersToViewSharedLinksDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(sfAllowNonMembersToViewSharedLinksDetails.targetAssetIndex), jsonGenerator);
            jsonGenerator.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(sfAllowNonMembersToViewSharedLinksDetails.originalFolderName, jsonGenerator);
            if (sfAllowNonMembersToViewSharedLinksDetails.sharedFolderType != null) {
                jsonGenerator.writeFieldName("shared_folder_type");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sfAllowNonMembersToViewSharedLinksDetails.sharedFolderType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SfAllowNonMembersToViewSharedLinksDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("target_asset_index".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("original_folder_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("shared_folder_type".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                SfAllowNonMembersToViewSharedLinksDetails sfAllowNonMembersToViewSharedLinksDetails = new SfAllowNonMembersToViewSharedLinksDetails(lDeserialize.longValue(), strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sfAllowNonMembersToViewSharedLinksDetails, sfAllowNonMembersToViewSharedLinksDetails.toStringMultiline());
                return sfAllowNonMembersToViewSharedLinksDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
