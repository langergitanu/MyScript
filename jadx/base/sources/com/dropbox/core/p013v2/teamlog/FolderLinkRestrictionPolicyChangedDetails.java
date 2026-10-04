package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FolderLinkRestrictionPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class FolderLinkRestrictionPolicyChangedDetails {

    @Nonnull
    protected final FolderLinkRestrictionPolicy newValue;

    @Nonnull
    protected final FolderLinkRestrictionPolicy previousValue;

    public FolderLinkRestrictionPolicyChangedDetails(@Nonnull FolderLinkRestrictionPolicy folderLinkRestrictionPolicy, @Nonnull FolderLinkRestrictionPolicy folderLinkRestrictionPolicy2) {
        if (folderLinkRestrictionPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = folderLinkRestrictionPolicy;
        if (folderLinkRestrictionPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = folderLinkRestrictionPolicy2;
    }

    @Nonnull
    public FolderLinkRestrictionPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public FolderLinkRestrictionPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FolderLinkRestrictionPolicy folderLinkRestrictionPolicy;
        FolderLinkRestrictionPolicy folderLinkRestrictionPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderLinkRestrictionPolicyChangedDetails folderLinkRestrictionPolicyChangedDetails = (FolderLinkRestrictionPolicyChangedDetails) obj;
        FolderLinkRestrictionPolicy folderLinkRestrictionPolicy3 = this.newValue;
        FolderLinkRestrictionPolicy folderLinkRestrictionPolicy4 = folderLinkRestrictionPolicyChangedDetails.newValue;
        return (folderLinkRestrictionPolicy3 == folderLinkRestrictionPolicy4 || folderLinkRestrictionPolicy3.equals(folderLinkRestrictionPolicy4)) && ((folderLinkRestrictionPolicy = this.previousValue) == (folderLinkRestrictionPolicy2 = folderLinkRestrictionPolicyChangedDetails.previousValue) || folderLinkRestrictionPolicy.equals(folderLinkRestrictionPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderLinkRestrictionPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderLinkRestrictionPolicyChangedDetails folderLinkRestrictionPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FolderLinkRestrictionPolicy.Serializer.INSTANCE.serialize(folderLinkRestrictionPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            FolderLinkRestrictionPolicy.Serializer.INSTANCE.serialize(folderLinkRestrictionPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderLinkRestrictionPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FolderLinkRestrictionPolicy folderLinkRestrictionPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FolderLinkRestrictionPolicy folderLinkRestrictionPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        folderLinkRestrictionPolicyDeserialize = FolderLinkRestrictionPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        folderLinkRestrictionPolicyDeserialize2 = FolderLinkRestrictionPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (folderLinkRestrictionPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (folderLinkRestrictionPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                FolderLinkRestrictionPolicyChangedDetails folderLinkRestrictionPolicyChangedDetails = new FolderLinkRestrictionPolicyChangedDetails(folderLinkRestrictionPolicyDeserialize, folderLinkRestrictionPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderLinkRestrictionPolicyChangedDetails, folderLinkRestrictionPolicyChangedDetails.toStringMultiline());
                return folderLinkRestrictionPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
