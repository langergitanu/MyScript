package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.users.UserFeature;
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
class UserFeaturesGetValuesBatchArg {

    @Nonnull
    protected final List<UserFeature> features;

    public UserFeaturesGetValuesBatchArg(@Nonnull List<UserFeature> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'features' is null");
        }
        Iterator<UserFeature> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'features' is null");
            }
        }
        this.features = list;
    }

    @Nonnull
    public List<UserFeature> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.features});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserFeature> list = this.features;
        List<UserFeature> list2 = ((UserFeaturesGetValuesBatchArg) obj).features;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserFeaturesGetValuesBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserFeaturesGetValuesBatchArg userFeaturesGetValuesBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("features");
            StoneSerializers.list(UserFeature.Serializer.INSTANCE).serialize(userFeaturesGetValuesBatchArg.features, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserFeaturesGetValuesBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("features".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserFeature.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"features\" missing.");
                }
                UserFeaturesGetValuesBatchArg userFeaturesGetValuesBatchArg = new UserFeaturesGetValuesBatchArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userFeaturesGetValuesBatchArg, userFeaturesGetValuesBatchArg.toStringMultiline());
                return userFeaturesGetValuesBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
