package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeLinkedAppError;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class RevokeLinkedAppStatus {

    @Nullable
    protected final RevokeLinkedAppError errorType;
    protected final boolean success;

    public RevokeLinkedAppStatus(boolean z, @Nullable RevokeLinkedAppError revokeLinkedAppError) {
        this.success = z;
        this.errorType = revokeLinkedAppError;
    }

    public RevokeLinkedAppStatus(boolean z) {
        this(z, null);
    }

    public boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public RevokeLinkedAppError getErrorType() {
        return this.errorType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.success), this.errorType});
    }

    public boolean equals(Object obj) {
        RevokeLinkedAppError revokeLinkedAppError;
        RevokeLinkedAppError revokeLinkedAppError2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RevokeLinkedAppStatus revokeLinkedAppStatus = (RevokeLinkedAppStatus) obj;
            if (this.success == revokeLinkedAppStatus.success && ((revokeLinkedAppError = this.errorType) == (revokeLinkedAppError2 = revokeLinkedAppStatus.errorType) || (revokeLinkedAppError != null && revokeLinkedAppError.equals(revokeLinkedAppError2)))) {
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

    static class Serializer extends StructSerializer<RevokeLinkedAppStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeLinkedAppStatus revokeLinkedAppStatus, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
            StoneSerializers.boolean_().serialize(Boolean.valueOf(revokeLinkedAppStatus.success), jsonGenerator);
            if (revokeLinkedAppStatus.errorType != null) {
                jsonGenerator.writeFieldName("error_type");
                StoneSerializers.nullable(RevokeLinkedAppError.Serializer.INSTANCE).serialize(revokeLinkedAppStatus.errorType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeLinkedAppStatus deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                RevokeLinkedAppError revokeLinkedAppError = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.SUCCESS.equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("error_type".equals(currentName)) {
                        revokeLinkedAppError = (RevokeLinkedAppError) StoneSerializers.nullable(RevokeLinkedAppError.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"success\" missing.");
                }
                RevokeLinkedAppStatus revokeLinkedAppStatus = new RevokeLinkedAppStatus(boolDeserialize.booleanValue(), revokeLinkedAppError);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeLinkedAppStatus, revokeLinkedAppStatus.toStringMultiline());
                return revokeLinkedAppStatus;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
