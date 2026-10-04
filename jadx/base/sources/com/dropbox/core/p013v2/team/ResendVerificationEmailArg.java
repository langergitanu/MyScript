package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSecondaryEmailsArg;
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
class ResendVerificationEmailArg {

    @Nonnull
    protected final List<UserSecondaryEmailsArg> emailsToResend;

    public ResendVerificationEmailArg(@Nonnull List<UserSecondaryEmailsArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'emailsToResend' is null");
        }
        Iterator<UserSecondaryEmailsArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'emailsToResend' is null");
            }
        }
        this.emailsToResend = list;
    }

    @Nonnull
    public List<UserSecondaryEmailsArg> getEmailsToResend() {
        return this.emailsToResend;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.emailsToResend});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserSecondaryEmailsArg> list = this.emailsToResend;
        List<UserSecondaryEmailsArg> list2 = ((ResendVerificationEmailArg) obj).emailsToResend;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ResendVerificationEmailArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ResendVerificationEmailArg resendVerificationEmailArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("emails_to_resend");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(resendVerificationEmailArg.emailsToResend, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ResendVerificationEmailArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("emails_to_resend".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"emails_to_resend\" missing.");
                }
                ResendVerificationEmailArg resendVerificationEmailArg = new ResendVerificationEmailArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(resendVerificationEmailArg, resendVerificationEmailArg.toStringMultiline());
                return resendVerificationEmailArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
