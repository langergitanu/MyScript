package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserResendResult;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ResendVerificationEmailResult {

    @Nonnull
    protected final List<UserResendResult> results;

    public ResendVerificationEmailResult(@Nonnull List<UserResendResult> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'results' is null");
        }
        Iterator<UserResendResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'results' is null");
            }
        }
        this.results = list;
    }

    @Nonnull
    public List<UserResendResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.results});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserResendResult> list = this.results;
        List<UserResendResult> list2 = ((ResendVerificationEmailResult) obj).results;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ResendVerificationEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ResendVerificationEmailResult resendVerificationEmailResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("results");
            StoneSerializers.list(UserResendResult.Serializer.INSTANCE).serialize(resendVerificationEmailResult.results, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ResendVerificationEmailResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
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
                    if ("results".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserResendResult.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"results\" missing.");
                }
                ResendVerificationEmailResult resendVerificationEmailResult = new ResendVerificationEmailResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(resendVerificationEmailResult, resendVerificationEmailResult.toStringMultiline());
                return resendVerificationEmailResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
