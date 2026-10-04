package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeDeviceSessionError;
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
public class RevokeDeviceSessionStatus {

    @Nullable
    protected final RevokeDeviceSessionError errorType;
    protected final boolean success;

    public RevokeDeviceSessionStatus(boolean z, @Nullable RevokeDeviceSessionError revokeDeviceSessionError) {
        this.success = z;
        this.errorType = revokeDeviceSessionError;
    }

    public RevokeDeviceSessionStatus(boolean z) {
        this(z, null);
    }

    public boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public RevokeDeviceSessionError getErrorType() {
        return this.errorType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.success), this.errorType});
    }

    public boolean equals(Object obj) {
        RevokeDeviceSessionError revokeDeviceSessionError;
        RevokeDeviceSessionError revokeDeviceSessionError2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RevokeDeviceSessionStatus revokeDeviceSessionStatus = (RevokeDeviceSessionStatus) obj;
            if (this.success == revokeDeviceSessionStatus.success && ((revokeDeviceSessionError = this.errorType) == (revokeDeviceSessionError2 = revokeDeviceSessionStatus.errorType) || (revokeDeviceSessionError != null && revokeDeviceSessionError.equals(revokeDeviceSessionError2)))) {
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

    static class Serializer extends StructSerializer<RevokeDeviceSessionStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeDeviceSessionStatus revokeDeviceSessionStatus, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
            StoneSerializers.boolean_().serialize(Boolean.valueOf(revokeDeviceSessionStatus.success), jsonGenerator);
            if (revokeDeviceSessionStatus.errorType != null) {
                jsonGenerator.writeFieldName("error_type");
                StoneSerializers.nullable(RevokeDeviceSessionError.Serializer.INSTANCE).serialize(revokeDeviceSessionStatus.errorType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeDeviceSessionStatus deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                RevokeDeviceSessionError revokeDeviceSessionError = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.SUCCESS.equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("error_type".equals(currentName)) {
                        revokeDeviceSessionError = (RevokeDeviceSessionError) StoneSerializers.nullable(RevokeDeviceSessionError.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"success\" missing.");
                }
                RevokeDeviceSessionStatus revokeDeviceSessionStatus = new RevokeDeviceSessionStatus(boolDeserialize.booleanValue(), revokeDeviceSessionError);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeDeviceSessionStatus, revokeDeviceSessionStatus.toStringMultiline());
                return revokeDeviceSessionStatus;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
