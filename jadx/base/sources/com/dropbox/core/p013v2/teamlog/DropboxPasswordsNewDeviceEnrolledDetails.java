package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class DropboxPasswordsNewDeviceEnrolledDetails {
    protected final boolean isFirstDevice;

    @Nonnull
    protected final String platform;

    public DropboxPasswordsNewDeviceEnrolledDetails(boolean z, @Nonnull String str) {
        this.isFirstDevice = z;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = str;
    }

    public boolean getIsFirstDevice() {
        return this.isFirstDevice;
    }

    @Nonnull
    public String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.isFirstDevice), this.platform});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            DropboxPasswordsNewDeviceEnrolledDetails dropboxPasswordsNewDeviceEnrolledDetails = (DropboxPasswordsNewDeviceEnrolledDetails) obj;
            if (this.isFirstDevice == dropboxPasswordsNewDeviceEnrolledDetails.isFirstDevice && ((str = this.platform) == (str2 = dropboxPasswordsNewDeviceEnrolledDetails.platform) || str.equals(str2))) {
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

    static class Serializer extends StructSerializer<DropboxPasswordsNewDeviceEnrolledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DropboxPasswordsNewDeviceEnrolledDetails dropboxPasswordsNewDeviceEnrolledDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("is_first_device");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(dropboxPasswordsNewDeviceEnrolledDetails.isFirstDevice), jsonGenerator);
            jsonGenerator.writeFieldName(DeviceDimensionProvider.KEY_PLATFORM);
            StoneSerializers.string().serialize(dropboxPasswordsNewDeviceEnrolledDetails.platform, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DropboxPasswordsNewDeviceEnrolledDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_first_device".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if (DeviceDimensionProvider.KEY_PLATFORM.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_first_device\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"platform\" missing.");
                }
                DropboxPasswordsNewDeviceEnrolledDetails dropboxPasswordsNewDeviceEnrolledDetails = new DropboxPasswordsNewDeviceEnrolledDetails(boolDeserialize.booleanValue(), strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(dropboxPasswordsNewDeviceEnrolledDetails, dropboxPasswordsNewDeviceEnrolledDetails.toStringMultiline());
                return dropboxPasswordsNewDeviceEnrolledDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
