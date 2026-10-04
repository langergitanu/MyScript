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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GroupDeleteDetails {

    @Nullable
    protected final Boolean isCompanyManaged;

    public GroupDeleteDetails(@Nullable Boolean bool) {
        this.isCompanyManaged = bool;
    }

    public GroupDeleteDetails() {
        this(null);
    }

    @Nullable
    public Boolean getIsCompanyManaged() {
        return this.isCompanyManaged;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.isCompanyManaged});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Boolean bool = this.isCompanyManaged;
        Boolean bool2 = ((GroupDeleteDetails) obj).isCompanyManaged;
        return bool == bool2 || (bool != null && bool.equals(bool2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupDeleteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupDeleteDetails groupDeleteDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (groupDeleteDetails.isCompanyManaged != null) {
                jsonGenerator.writeFieldName("is_company_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(groupDeleteDetails.isCompanyManaged, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupDeleteDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean bool = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_company_managed".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                GroupDeleteDetails groupDeleteDetails = new GroupDeleteDetails(bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupDeleteDetails, groupDeleteDetails.toStringMultiline());
                return groupDeleteDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
