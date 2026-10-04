package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.IdentifierType;
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

/* JADX INFO: loaded from: classes5.dex */
public class ExternalUserLogInfo {

    @Nonnull
    protected final IdentifierType identifierType;

    @Nonnull
    protected final String userIdentifier;

    public ExternalUserLogInfo(@Nonnull String str, @Nonnull IdentifierType identifierType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'userIdentifier' is null");
        }
        this.userIdentifier = str;
        if (identifierType == null) {
            throw new IllegalArgumentException("Required value for 'identifierType' is null");
        }
        this.identifierType = identifierType;
    }

    @Nonnull
    public String getUserIdentifier() {
        return this.userIdentifier;
    }

    @Nonnull
    public IdentifierType getIdentifierType() {
        return this.identifierType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.userIdentifier, this.identifierType});
    }

    public boolean equals(Object obj) {
        IdentifierType identifierType;
        IdentifierType identifierType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExternalUserLogInfo externalUserLogInfo = (ExternalUserLogInfo) obj;
        String str = this.userIdentifier;
        String str2 = externalUserLogInfo.userIdentifier;
        return (str == str2 || str.equals(str2)) && ((identifierType = this.identifierType) == (identifierType2 = externalUserLogInfo.identifierType) || identifierType.equals(identifierType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExternalUserLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExternalUserLogInfo externalUserLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user_identifier");
            StoneSerializers.string().serialize(externalUserLogInfo.userIdentifier, jsonGenerator);
            jsonGenerator.writeFieldName("identifier_type");
            IdentifierType.Serializer.INSTANCE.serialize(externalUserLogInfo.identifierType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExternalUserLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                IdentifierType identifierTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user_identifier".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("identifier_type".equals(currentName)) {
                        identifierTypeDeserialize = IdentifierType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_identifier\" missing.");
                }
                if (identifierTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"identifier_type\" missing.");
                }
                ExternalUserLogInfo externalUserLogInfo = new ExternalUserLogInfo(strDeserialize, identifierTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(externalUserLogInfo, externalUserLogInfo.toStringMultiline());
                return externalUserLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
