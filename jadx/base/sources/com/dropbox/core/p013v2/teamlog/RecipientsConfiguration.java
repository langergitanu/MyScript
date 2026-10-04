package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AlertRecipientsSettingType;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class RecipientsConfiguration {

    @Nullable
    protected final List<String> emails;

    @Nullable
    protected final List<String> groups;

    @Nullable
    protected final AlertRecipientsSettingType recipientSettingType;

    public RecipientsConfiguration(@Nullable AlertRecipientsSettingType alertRecipientsSettingType, @Nullable List<String> list, @Nullable List<String> list2) {
        this.recipientSettingType = alertRecipientsSettingType;
        if (list != null) {
            for (String str : list) {
                if (str == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
                if (str.length() > 255) {
                    throw new IllegalArgumentException("Stringan item in list 'emails' is longer than 255");
                }
            }
        }
        this.emails = list;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'groups' is null");
                }
            }
        }
        this.groups = list2;
    }

    public RecipientsConfiguration() {
        this(null, null, null);
    }

    @Nullable
    public AlertRecipientsSettingType getRecipientSettingType() {
        return this.recipientSettingType;
    }

    @Nullable
    public List<String> getEmails() {
        return this.emails;
    }

    @Nullable
    public List<String> getGroups() {
        return this.groups;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected AlertRecipientsSettingType recipientSettingType = null;
        protected List<String> emails = null;
        protected List<String> groups = null;

        protected Builder() {
        }

        public Builder withRecipientSettingType(AlertRecipientsSettingType alertRecipientsSettingType) {
            this.recipientSettingType = alertRecipientsSettingType;
            return this;
        }

        public Builder withEmails(List<String> list) {
            if (list != null) {
                for (String str : list) {
                    if (str == null) {
                        throw new IllegalArgumentException("An item in list 'emails' is null");
                    }
                    if (str.length() > 255) {
                        throw new IllegalArgumentException("Stringan item in list 'emails' is longer than 255");
                    }
                }
            }
            this.emails = list;
            return this;
        }

        public Builder withGroups(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'groups' is null");
                    }
                }
            }
            this.groups = list;
            return this;
        }

        public RecipientsConfiguration build() {
            return new RecipientsConfiguration(this.recipientSettingType, this.emails, this.groups);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.recipientSettingType, this.emails, this.groups});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        RecipientsConfiguration recipientsConfiguration = (RecipientsConfiguration) obj;
        AlertRecipientsSettingType alertRecipientsSettingType = this.recipientSettingType;
        AlertRecipientsSettingType alertRecipientsSettingType2 = recipientsConfiguration.recipientSettingType;
        return (alertRecipientsSettingType == alertRecipientsSettingType2 || (alertRecipientsSettingType != null && alertRecipientsSettingType.equals(alertRecipientsSettingType2))) && ((list = this.emails) == (list2 = recipientsConfiguration.emails) || (list != null && list.equals(list2))) && ((list3 = this.groups) == (list4 = recipientsConfiguration.groups) || (list3 != null && list3.equals(list4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RecipientsConfiguration> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RecipientsConfiguration recipientsConfiguration, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (recipientsConfiguration.recipientSettingType != null) {
                jsonGenerator.writeFieldName("recipient_setting_type");
                StoneSerializers.nullable(AlertRecipientsSettingType.Serializer.INSTANCE).serialize(recipientsConfiguration.recipientSettingType, jsonGenerator);
            }
            if (recipientsConfiguration.emails != null) {
                jsonGenerator.writeFieldName("emails");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(recipientsConfiguration.emails, jsonGenerator);
            }
            if (recipientsConfiguration.groups != null) {
                jsonGenerator.writeFieldName("groups");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(recipientsConfiguration.groups, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RecipientsConfiguration deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AlertRecipientsSettingType alertRecipientsSettingType = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("recipient_setting_type".equals(currentName)) {
                        alertRecipientsSettingType = (AlertRecipientsSettingType) StoneSerializers.nullable(AlertRecipientsSettingType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("emails".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else if ("groups".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                RecipientsConfiguration recipientsConfiguration = new RecipientsConfiguration(alertRecipientsSettingType, list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(recipientsConfiguration, recipientsConfiguration.toStringMultiline());
                return recipientsConfiguration;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
