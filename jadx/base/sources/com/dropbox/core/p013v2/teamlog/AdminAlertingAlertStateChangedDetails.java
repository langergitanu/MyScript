package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminAlertCategoryEnum;
import com.dropbox.core.p013v2.teamlog.AdminAlertGeneralStateEnum;
import com.dropbox.core.p013v2.teamlog.AdminAlertSeverityEnum;
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
public class AdminAlertingAlertStateChangedDetails {

    @Nonnull
    protected final AdminAlertCategoryEnum alertCategory;

    @Nonnull
    protected final String alertInstanceId;

    @Nonnull
    protected final String alertName;

    @Nonnull
    protected final AdminAlertSeverityEnum alertSeverity;

    @Nonnull
    protected final AdminAlertGeneralStateEnum newValue;

    @Nonnull
    protected final AdminAlertGeneralStateEnum previousValue;

    public AdminAlertingAlertStateChangedDetails(@Nonnull String str, @Nonnull AdminAlertSeverityEnum adminAlertSeverityEnum, @Nonnull AdminAlertCategoryEnum adminAlertCategoryEnum, @Nonnull String str2, @Nonnull AdminAlertGeneralStateEnum adminAlertGeneralStateEnum, @Nonnull AdminAlertGeneralStateEnum adminAlertGeneralStateEnum2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'alertName' is null");
        }
        this.alertName = str;
        if (adminAlertSeverityEnum == null) {
            throw new IllegalArgumentException("Required value for 'alertSeverity' is null");
        }
        this.alertSeverity = adminAlertSeverityEnum;
        if (adminAlertCategoryEnum == null) {
            throw new IllegalArgumentException("Required value for 'alertCategory' is null");
        }
        this.alertCategory = adminAlertCategoryEnum;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'alertInstanceId' is null");
        }
        this.alertInstanceId = str2;
        if (adminAlertGeneralStateEnum == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = adminAlertGeneralStateEnum;
        if (adminAlertGeneralStateEnum2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = adminAlertGeneralStateEnum2;
    }

    @Nonnull
    public String getAlertName() {
        return this.alertName;
    }

    @Nonnull
    public AdminAlertSeverityEnum getAlertSeverity() {
        return this.alertSeverity;
    }

    @Nonnull
    public AdminAlertCategoryEnum getAlertCategory() {
        return this.alertCategory;
    }

    @Nonnull
    public String getAlertInstanceId() {
        return this.alertInstanceId;
    }

    @Nonnull
    public AdminAlertGeneralStateEnum getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public AdminAlertGeneralStateEnum getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.alertName, this.alertSeverity, this.alertCategory, this.alertInstanceId, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        AdminAlertSeverityEnum adminAlertSeverityEnum;
        AdminAlertSeverityEnum adminAlertSeverityEnum2;
        AdminAlertCategoryEnum adminAlertCategoryEnum;
        AdminAlertCategoryEnum adminAlertCategoryEnum2;
        String str;
        String str2;
        AdminAlertGeneralStateEnum adminAlertGeneralStateEnum;
        AdminAlertGeneralStateEnum adminAlertGeneralStateEnum2;
        AdminAlertGeneralStateEnum adminAlertGeneralStateEnum3;
        AdminAlertGeneralStateEnum adminAlertGeneralStateEnum4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AdminAlertingAlertStateChangedDetails adminAlertingAlertStateChangedDetails = (AdminAlertingAlertStateChangedDetails) obj;
        String str3 = this.alertName;
        String str4 = adminAlertingAlertStateChangedDetails.alertName;
        return (str3 == str4 || str3.equals(str4)) && ((adminAlertSeverityEnum = this.alertSeverity) == (adminAlertSeverityEnum2 = adminAlertingAlertStateChangedDetails.alertSeverity) || adminAlertSeverityEnum.equals(adminAlertSeverityEnum2)) && (((adminAlertCategoryEnum = this.alertCategory) == (adminAlertCategoryEnum2 = adminAlertingAlertStateChangedDetails.alertCategory) || adminAlertCategoryEnum.equals(adminAlertCategoryEnum2)) && (((str = this.alertInstanceId) == (str2 = adminAlertingAlertStateChangedDetails.alertInstanceId) || str.equals(str2)) && (((adminAlertGeneralStateEnum = this.previousValue) == (adminAlertGeneralStateEnum2 = adminAlertingAlertStateChangedDetails.previousValue) || adminAlertGeneralStateEnum.equals(adminAlertGeneralStateEnum2)) && ((adminAlertGeneralStateEnum3 = this.newValue) == (adminAlertGeneralStateEnum4 = adminAlertingAlertStateChangedDetails.newValue) || adminAlertGeneralStateEnum3.equals(adminAlertGeneralStateEnum4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AdminAlertingAlertStateChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AdminAlertingAlertStateChangedDetails adminAlertingAlertStateChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("alert_name");
            StoneSerializers.string().serialize(adminAlertingAlertStateChangedDetails.alertName, jsonGenerator);
            jsonGenerator.writeFieldName("alert_severity");
            AdminAlertSeverityEnum.Serializer.INSTANCE.serialize(adminAlertingAlertStateChangedDetails.alertSeverity, jsonGenerator);
            jsonGenerator.writeFieldName("alert_category");
            AdminAlertCategoryEnum.Serializer.INSTANCE.serialize(adminAlertingAlertStateChangedDetails.alertCategory, jsonGenerator);
            jsonGenerator.writeFieldName("alert_instance_id");
            StoneSerializers.string().serialize(adminAlertingAlertStateChangedDetails.alertInstanceId, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            AdminAlertGeneralStateEnum.Serializer.INSTANCE.serialize(adminAlertingAlertStateChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            AdminAlertGeneralStateEnum.Serializer.INSTANCE.serialize(adminAlertingAlertStateChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AdminAlertingAlertStateChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                AdminAlertSeverityEnum adminAlertSeverityEnumDeserialize = null;
                AdminAlertCategoryEnum adminAlertCategoryEnumDeserialize = null;
                String strDeserialize2 = null;
                AdminAlertGeneralStateEnum adminAlertGeneralStateEnumDeserialize = null;
                AdminAlertGeneralStateEnum adminAlertGeneralStateEnumDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("alert_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("alert_severity".equals(currentName)) {
                        adminAlertSeverityEnumDeserialize = AdminAlertSeverityEnum.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("alert_category".equals(currentName)) {
                        adminAlertCategoryEnumDeserialize = AdminAlertCategoryEnum.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("alert_instance_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        adminAlertGeneralStateEnumDeserialize = AdminAlertGeneralStateEnum.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        adminAlertGeneralStateEnumDeserialize2 = AdminAlertGeneralStateEnum.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"alert_name\" missing.");
                }
                if (adminAlertSeverityEnumDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"alert_severity\" missing.");
                }
                if (adminAlertCategoryEnumDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"alert_category\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"alert_instance_id\" missing.");
                }
                if (adminAlertGeneralStateEnumDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (adminAlertGeneralStateEnumDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                AdminAlertingAlertStateChangedDetails adminAlertingAlertStateChangedDetails = new AdminAlertingAlertStateChangedDetails(strDeserialize, adminAlertSeverityEnumDeserialize, adminAlertCategoryEnumDeserialize, strDeserialize2, adminAlertGeneralStateEnumDeserialize, adminAlertGeneralStateEnumDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(adminAlertingAlertStateChangedDetails, adminAlertingAlertStateChangedDetails.toStringMultiline());
                return adminAlertingAlertStateChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
