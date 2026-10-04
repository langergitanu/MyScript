package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminEmailRemindersPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class AdminEmailRemindersChangedDetails {

    @Nonnull
    protected final AdminEmailRemindersPolicy newValue;

    @Nonnull
    protected final AdminEmailRemindersPolicy previousValue;

    public AdminEmailRemindersChangedDetails(@Nonnull AdminEmailRemindersPolicy adminEmailRemindersPolicy, @Nonnull AdminEmailRemindersPolicy adminEmailRemindersPolicy2) {
        if (adminEmailRemindersPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = adminEmailRemindersPolicy;
        if (adminEmailRemindersPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = adminEmailRemindersPolicy2;
    }

    @Nonnull
    public AdminEmailRemindersPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public AdminEmailRemindersPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        AdminEmailRemindersPolicy adminEmailRemindersPolicy;
        AdminEmailRemindersPolicy adminEmailRemindersPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AdminEmailRemindersChangedDetails adminEmailRemindersChangedDetails = (AdminEmailRemindersChangedDetails) obj;
        AdminEmailRemindersPolicy adminEmailRemindersPolicy3 = this.newValue;
        AdminEmailRemindersPolicy adminEmailRemindersPolicy4 = adminEmailRemindersChangedDetails.newValue;
        return (adminEmailRemindersPolicy3 == adminEmailRemindersPolicy4 || adminEmailRemindersPolicy3.equals(adminEmailRemindersPolicy4)) && ((adminEmailRemindersPolicy = this.previousValue) == (adminEmailRemindersPolicy2 = adminEmailRemindersChangedDetails.previousValue) || adminEmailRemindersPolicy.equals(adminEmailRemindersPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AdminEmailRemindersChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AdminEmailRemindersChangedDetails adminEmailRemindersChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            AdminEmailRemindersPolicy.Serializer.INSTANCE.serialize(adminEmailRemindersChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            AdminEmailRemindersPolicy.Serializer.INSTANCE.serialize(adminEmailRemindersChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AdminEmailRemindersChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AdminEmailRemindersPolicy adminEmailRemindersPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminEmailRemindersPolicy adminEmailRemindersPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        adminEmailRemindersPolicyDeserialize = AdminEmailRemindersPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        adminEmailRemindersPolicyDeserialize2 = AdminEmailRemindersPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (adminEmailRemindersPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (adminEmailRemindersPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                AdminEmailRemindersChangedDetails adminEmailRemindersChangedDetails = new AdminEmailRemindersChangedDetails(adminEmailRemindersPolicyDeserialize, adminEmailRemindersPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(adminEmailRemindersChangedDetails, adminEmailRemindersChangedDetails.toStringMultiline());
                return adminEmailRemindersChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
