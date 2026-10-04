package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminAlertingAlertConfiguration;
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
public class AdminAlertingChangedAlertConfigDetails {

    @Nonnull
    protected final String alertName;

    @Nonnull
    protected final AdminAlertingAlertConfiguration newAlertConfig;

    @Nonnull
    protected final AdminAlertingAlertConfiguration previousAlertConfig;

    public AdminAlertingChangedAlertConfigDetails(@Nonnull String str, @Nonnull AdminAlertingAlertConfiguration adminAlertingAlertConfiguration, @Nonnull AdminAlertingAlertConfiguration adminAlertingAlertConfiguration2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'alertName' is null");
        }
        this.alertName = str;
        if (adminAlertingAlertConfiguration == null) {
            throw new IllegalArgumentException("Required value for 'previousAlertConfig' is null");
        }
        this.previousAlertConfig = adminAlertingAlertConfiguration;
        if (adminAlertingAlertConfiguration2 == null) {
            throw new IllegalArgumentException("Required value for 'newAlertConfig' is null");
        }
        this.newAlertConfig = adminAlertingAlertConfiguration2;
    }

    @Nonnull
    public String getAlertName() {
        return this.alertName;
    }

    @Nonnull
    public AdminAlertingAlertConfiguration getPreviousAlertConfig() {
        return this.previousAlertConfig;
    }

    @Nonnull
    public AdminAlertingAlertConfiguration getNewAlertConfig() {
        return this.newAlertConfig;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.alertName, this.previousAlertConfig, this.newAlertConfig});
    }

    public boolean equals(Object obj) {
        AdminAlertingAlertConfiguration adminAlertingAlertConfiguration;
        AdminAlertingAlertConfiguration adminAlertingAlertConfiguration2;
        AdminAlertingAlertConfiguration adminAlertingAlertConfiguration3;
        AdminAlertingAlertConfiguration adminAlertingAlertConfiguration4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AdminAlertingChangedAlertConfigDetails adminAlertingChangedAlertConfigDetails = (AdminAlertingChangedAlertConfigDetails) obj;
        String str = this.alertName;
        String str2 = adminAlertingChangedAlertConfigDetails.alertName;
        return (str == str2 || str.equals(str2)) && ((adminAlertingAlertConfiguration = this.previousAlertConfig) == (adminAlertingAlertConfiguration2 = adminAlertingChangedAlertConfigDetails.previousAlertConfig) || adminAlertingAlertConfiguration.equals(adminAlertingAlertConfiguration2)) && ((adminAlertingAlertConfiguration3 = this.newAlertConfig) == (adminAlertingAlertConfiguration4 = adminAlertingChangedAlertConfigDetails.newAlertConfig) || adminAlertingAlertConfiguration3.equals(adminAlertingAlertConfiguration4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AdminAlertingChangedAlertConfigDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AdminAlertingChangedAlertConfigDetails adminAlertingChangedAlertConfigDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("alert_name");
            StoneSerializers.string().serialize(adminAlertingChangedAlertConfigDetails.alertName, jsonGenerator);
            jsonGenerator.writeFieldName("previous_alert_config");
            AdminAlertingAlertConfiguration.Serializer.INSTANCE.serialize(adminAlertingChangedAlertConfigDetails.previousAlertConfig, jsonGenerator);
            jsonGenerator.writeFieldName("new_alert_config");
            AdminAlertingAlertConfiguration.Serializer.INSTANCE.serialize(adminAlertingChangedAlertConfigDetails.newAlertConfig, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AdminAlertingChangedAlertConfigDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminAlertingAlertConfiguration adminAlertingAlertConfigurationDeserialize = null;
                AdminAlertingAlertConfiguration adminAlertingAlertConfigurationDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("alert_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_alert_config".equals(currentName)) {
                        adminAlertingAlertConfigurationDeserialize = AdminAlertingAlertConfiguration.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_alert_config".equals(currentName)) {
                        adminAlertingAlertConfigurationDeserialize2 = AdminAlertingAlertConfiguration.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"alert_name\" missing.");
                }
                if (adminAlertingAlertConfigurationDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_alert_config\" missing.");
                }
                if (adminAlertingAlertConfigurationDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_alert_config\" missing.");
                }
                AdminAlertingChangedAlertConfigDetails adminAlertingChangedAlertConfigDetails = new AdminAlertingChangedAlertConfigDetails(strDeserialize, adminAlertingAlertConfigurationDeserialize, adminAlertingAlertConfigurationDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(adminAlertingChangedAlertConfigDetails, adminAlertingChangedAlertConfigDetails.toStringMultiline());
                return adminAlertingChangedAlertConfigDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
