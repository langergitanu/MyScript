package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.LegalHoldPolicy;
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
public class LegalHoldsListPoliciesResult {

    @Nonnull
    protected final List<LegalHoldPolicy> policies;

    public LegalHoldsListPoliciesResult(@Nonnull List<LegalHoldPolicy> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'policies' is null");
        }
        Iterator<LegalHoldPolicy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'policies' is null");
            }
        }
        this.policies = list;
    }

    @Nonnull
    public List<LegalHoldPolicy> getPolicies() {
        return this.policies;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.policies});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<LegalHoldPolicy> list = this.policies;
        List<LegalHoldPolicy> list2 = ((LegalHoldsListPoliciesResult) obj).policies;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsListPoliciesResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsListPoliciesResult legalHoldsListPoliciesResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("policies");
            StoneSerializers.list(LegalHoldPolicy.Serializer.INSTANCE).serialize(legalHoldsListPoliciesResult.policies, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsListPoliciesResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("policies".equals(currentName)) {
                        list = (List) StoneSerializers.list(LegalHoldPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"policies\" missing.");
                }
                LegalHoldsListPoliciesResult legalHoldsListPoliciesResult = new LegalHoldsListPoliciesResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsListPoliciesResult, legalHoldsListPoliciesResult.toStringMultiline());
                return legalHoldsListPoliciesResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
