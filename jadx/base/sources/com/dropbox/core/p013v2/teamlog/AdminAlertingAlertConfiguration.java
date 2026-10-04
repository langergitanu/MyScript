package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminAlertingAlertSensitivity;
import com.dropbox.core.p013v2.teamlog.AdminAlertingAlertStatePolicy;
import com.dropbox.core.p013v2.teamlog.RecipientsConfiguration;
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
public class AdminAlertingAlertConfiguration {

    @Nullable
    protected final AdminAlertingAlertStatePolicy alertState;

    @Nullable
    protected final String excludedFileExtensions;

    @Nullable
    protected final RecipientsConfiguration recipientsSettings;

    @Nullable
    protected final AdminAlertingAlertSensitivity sensitivityLevel;

    @Nullable
    protected final String text;

    public AdminAlertingAlertConfiguration(@Nullable AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy, @Nullable AdminAlertingAlertSensitivity adminAlertingAlertSensitivity, @Nullable RecipientsConfiguration recipientsConfiguration, @Nullable String str, @Nullable String str2) {
        this.alertState = adminAlertingAlertStatePolicy;
        this.sensitivityLevel = adminAlertingAlertSensitivity;
        this.recipientsSettings = recipientsConfiguration;
        this.text = str;
        this.excludedFileExtensions = str2;
    }

    public AdminAlertingAlertConfiguration() {
        this(null, null, null, null, null);
    }

    @Nullable
    public AdminAlertingAlertStatePolicy getAlertState() {
        return this.alertState;
    }

    @Nullable
    public AdminAlertingAlertSensitivity getSensitivityLevel() {
        return this.sensitivityLevel;
    }

    @Nullable
    public RecipientsConfiguration getRecipientsSettings() {
        return this.recipientsSettings;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    @Nullable
    public String getExcludedFileExtensions() {
        return this.excludedFileExtensions;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected AdminAlertingAlertStatePolicy alertState = null;
        protected AdminAlertingAlertSensitivity sensitivityLevel = null;
        protected RecipientsConfiguration recipientsSettings = null;
        protected String text = null;
        protected String excludedFileExtensions = null;

        protected Builder() {
        }

        public Builder withAlertState(AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy) {
            this.alertState = adminAlertingAlertStatePolicy;
            return this;
        }

        public Builder withSensitivityLevel(AdminAlertingAlertSensitivity adminAlertingAlertSensitivity) {
            this.sensitivityLevel = adminAlertingAlertSensitivity;
            return this;
        }

        public Builder withRecipientsSettings(RecipientsConfiguration recipientsConfiguration) {
            this.recipientsSettings = recipientsConfiguration;
            return this;
        }

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withExcludedFileExtensions(String str) {
            this.excludedFileExtensions = str;
            return this;
        }

        public AdminAlertingAlertConfiguration build() {
            return new AdminAlertingAlertConfiguration(this.alertState, this.sensitivityLevel, this.recipientsSettings, this.text, this.excludedFileExtensions);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.alertState, this.sensitivityLevel, this.recipientsSettings, this.text, this.excludedFileExtensions});
    }

    public boolean equals(Object obj) {
        AdminAlertingAlertSensitivity adminAlertingAlertSensitivity;
        AdminAlertingAlertSensitivity adminAlertingAlertSensitivity2;
        RecipientsConfiguration recipientsConfiguration;
        RecipientsConfiguration recipientsConfiguration2;
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AdminAlertingAlertConfiguration adminAlertingAlertConfiguration = (AdminAlertingAlertConfiguration) obj;
        AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy = this.alertState;
        AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy2 = adminAlertingAlertConfiguration.alertState;
        return (adminAlertingAlertStatePolicy == adminAlertingAlertStatePolicy2 || (adminAlertingAlertStatePolicy != null && adminAlertingAlertStatePolicy.equals(adminAlertingAlertStatePolicy2))) && ((adminAlertingAlertSensitivity = this.sensitivityLevel) == (adminAlertingAlertSensitivity2 = adminAlertingAlertConfiguration.sensitivityLevel) || (adminAlertingAlertSensitivity != null && adminAlertingAlertSensitivity.equals(adminAlertingAlertSensitivity2))) && (((recipientsConfiguration = this.recipientsSettings) == (recipientsConfiguration2 = adminAlertingAlertConfiguration.recipientsSettings) || (recipientsConfiguration != null && recipientsConfiguration.equals(recipientsConfiguration2))) && (((str = this.text) == (str2 = adminAlertingAlertConfiguration.text) || (str != null && str.equals(str2))) && ((str3 = this.excludedFileExtensions) == (str4 = adminAlertingAlertConfiguration.excludedFileExtensions) || (str3 != null && str3.equals(str4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AdminAlertingAlertConfiguration> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AdminAlertingAlertConfiguration adminAlertingAlertConfiguration, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (adminAlertingAlertConfiguration.alertState != null) {
                jsonGenerator.writeFieldName("alert_state");
                StoneSerializers.nullable(AdminAlertingAlertStatePolicy.Serializer.INSTANCE).serialize(adminAlertingAlertConfiguration.alertState, jsonGenerator);
            }
            if (adminAlertingAlertConfiguration.sensitivityLevel != null) {
                jsonGenerator.writeFieldName("sensitivity_level");
                StoneSerializers.nullable(AdminAlertingAlertSensitivity.Serializer.INSTANCE).serialize(adminAlertingAlertConfiguration.sensitivityLevel, jsonGenerator);
            }
            if (adminAlertingAlertConfiguration.recipientsSettings != null) {
                jsonGenerator.writeFieldName("recipients_settings");
                StoneSerializers.nullableStruct(RecipientsConfiguration.Serializer.INSTANCE).serialize(adminAlertingAlertConfiguration.recipientsSettings, jsonGenerator);
            }
            if (adminAlertingAlertConfiguration.text != null) {
                jsonGenerator.writeFieldName("text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(adminAlertingAlertConfiguration.text, jsonGenerator);
            }
            if (adminAlertingAlertConfiguration.excludedFileExtensions != null) {
                jsonGenerator.writeFieldName("excluded_file_extensions");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(adminAlertingAlertConfiguration.excludedFileExtensions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AdminAlertingAlertConfiguration deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy = null;
                AdminAlertingAlertSensitivity adminAlertingAlertSensitivity = null;
                RecipientsConfiguration recipientsConfiguration = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("alert_state".equals(currentName)) {
                        adminAlertingAlertStatePolicy = (AdminAlertingAlertStatePolicy) StoneSerializers.nullable(AdminAlertingAlertStatePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("sensitivity_level".equals(currentName)) {
                        adminAlertingAlertSensitivity = (AdminAlertingAlertSensitivity) StoneSerializers.nullable(AdminAlertingAlertSensitivity.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("recipients_settings".equals(currentName)) {
                        recipientsConfiguration = (RecipientsConfiguration) StoneSerializers.nullableStruct(RecipientsConfiguration.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("text".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("excluded_file_extensions".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                AdminAlertingAlertConfiguration adminAlertingAlertConfiguration = new AdminAlertingAlertConfiguration(adminAlertingAlertStatePolicy, adminAlertingAlertSensitivity, recipientsConfiguration, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(adminAlertingAlertConfiguration, adminAlertingAlertConfiguration.toStringMultiline());
                return adminAlertingAlertConfiguration;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
