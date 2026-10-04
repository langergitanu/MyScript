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

/* JADX INFO: loaded from: classes5.dex */
public class ResellerLogInfo {

    @Nonnull
    protected final String resellerEmail;

    @Nonnull
    protected final String resellerName;

    public ResellerLogInfo(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'resellerName' is null");
        }
        this.resellerName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'resellerEmail' is null");
        }
        if (str2.length() > 255) {
            throw new IllegalArgumentException("String 'resellerEmail' is longer than 255");
        }
        this.resellerEmail = str2;
    }

    @Nonnull
    public String getResellerName() {
        return this.resellerName;
    }

    @Nonnull
    public String getResellerEmail() {
        return this.resellerEmail;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.resellerName, this.resellerEmail});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ResellerLogInfo resellerLogInfo = (ResellerLogInfo) obj;
        String str3 = this.resellerName;
        String str4 = resellerLogInfo.resellerName;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.resellerEmail) == (str2 = resellerLogInfo.resellerEmail) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ResellerLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ResellerLogInfo resellerLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("reseller_name");
            StoneSerializers.string().serialize(resellerLogInfo.resellerName, jsonGenerator);
            jsonGenerator.writeFieldName("reseller_email");
            StoneSerializers.string().serialize(resellerLogInfo.resellerEmail, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ResellerLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("reseller_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("reseller_email".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"reseller_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"reseller_email\" missing.");
                }
                ResellerLogInfo resellerLogInfo = new ResellerLogInfo(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(resellerLogInfo, resellerLogInfo.toStringMultiline());
                return resellerLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
