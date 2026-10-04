package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminConsoleAppPermission;
import com.dropbox.core.p013v2.teamlog.AdminConsoleAppPolicy;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class AppPermissionsChangedDetails {

    @Nullable
    protected final String appName;

    @Nonnull
    protected final AdminConsoleAppPolicy newValue;

    @Nullable
    protected final AdminConsoleAppPermission permission;

    @Nonnull
    protected final AdminConsoleAppPolicy previousValue;

    public AppPermissionsChangedDetails(@Nonnull AdminConsoleAppPolicy adminConsoleAppPolicy, @Nonnull AdminConsoleAppPolicy adminConsoleAppPolicy2, @Nullable String str, @Nullable AdminConsoleAppPermission adminConsoleAppPermission) {
        this.appName = str;
        this.permission = adminConsoleAppPermission;
        if (adminConsoleAppPolicy == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = adminConsoleAppPolicy;
        if (adminConsoleAppPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = adminConsoleAppPolicy2;
    }

    public AppPermissionsChangedDetails(@Nonnull AdminConsoleAppPolicy adminConsoleAppPolicy, @Nonnull AdminConsoleAppPolicy adminConsoleAppPolicy2) {
        this(adminConsoleAppPolicy, adminConsoleAppPolicy2, null, null);
    }

    @Nonnull
    public AdminConsoleAppPolicy getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public AdminConsoleAppPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public String getAppName() {
        return this.appName;
    }

    @Nullable
    public AdminConsoleAppPermission getPermission() {
        return this.permission;
    }

    public static Builder newBuilder(AdminConsoleAppPolicy adminConsoleAppPolicy, AdminConsoleAppPolicy adminConsoleAppPolicy2) {
        return new Builder(adminConsoleAppPolicy, adminConsoleAppPolicy2);
    }

    public static class Builder {
        protected String appName;
        protected final AdminConsoleAppPolicy newValue;
        protected AdminConsoleAppPermission permission;
        protected final AdminConsoleAppPolicy previousValue;

        protected Builder(AdminConsoleAppPolicy adminConsoleAppPolicy, AdminConsoleAppPolicy adminConsoleAppPolicy2) {
            if (adminConsoleAppPolicy == null) {
                throw new IllegalArgumentException("Required value for 'previousValue' is null");
            }
            this.previousValue = adminConsoleAppPolicy;
            if (adminConsoleAppPolicy2 == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = adminConsoleAppPolicy2;
            this.appName = null;
            this.permission = null;
        }

        public Builder withAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder withPermission(AdminConsoleAppPermission adminConsoleAppPermission) {
            this.permission = adminConsoleAppPermission;
            return this;
        }

        public AppPermissionsChangedDetails build() {
            return new AppPermissionsChangedDetails(this.previousValue, this.newValue, this.appName, this.permission);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.appName, this.permission, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        AdminConsoleAppPolicy adminConsoleAppPolicy;
        AdminConsoleAppPolicy adminConsoleAppPolicy2;
        String str;
        String str2;
        AdminConsoleAppPermission adminConsoleAppPermission;
        AdminConsoleAppPermission adminConsoleAppPermission2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AppPermissionsChangedDetails appPermissionsChangedDetails = (AppPermissionsChangedDetails) obj;
        AdminConsoleAppPolicy adminConsoleAppPolicy3 = this.previousValue;
        AdminConsoleAppPolicy adminConsoleAppPolicy4 = appPermissionsChangedDetails.previousValue;
        return (adminConsoleAppPolicy3 == adminConsoleAppPolicy4 || adminConsoleAppPolicy3.equals(adminConsoleAppPolicy4)) && ((adminConsoleAppPolicy = this.newValue) == (adminConsoleAppPolicy2 = appPermissionsChangedDetails.newValue) || adminConsoleAppPolicy.equals(adminConsoleAppPolicy2)) && (((str = this.appName) == (str2 = appPermissionsChangedDetails.appName) || (str != null && str.equals(str2))) && ((adminConsoleAppPermission = this.permission) == (adminConsoleAppPermission2 = appPermissionsChangedDetails.permission) || (adminConsoleAppPermission != null && adminConsoleAppPermission.equals(adminConsoleAppPermission2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AppPermissionsChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AppPermissionsChangedDetails appPermissionsChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            AdminConsoleAppPolicy.Serializer.INSTANCE.serialize(appPermissionsChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            AdminConsoleAppPolicy.Serializer.INSTANCE.serialize(appPermissionsChangedDetails.newValue, jsonGenerator);
            if (appPermissionsChangedDetails.appName != null) {
                jsonGenerator.writeFieldName("app_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(appPermissionsChangedDetails.appName, jsonGenerator);
            }
            if (appPermissionsChangedDetails.permission != null) {
                jsonGenerator.writeFieldName("permission");
                StoneSerializers.nullable(AdminConsoleAppPermission.Serializer.INSTANCE).serialize(appPermissionsChangedDetails.permission, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AppPermissionsChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AdminConsoleAppPolicy adminConsoleAppPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminConsoleAppPolicy adminConsoleAppPolicyDeserialize2 = null;
                String str = null;
                AdminConsoleAppPermission adminConsoleAppPermission = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        adminConsoleAppPolicyDeserialize = AdminConsoleAppPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        adminConsoleAppPolicyDeserialize2 = AdminConsoleAppPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("app_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("permission".equals(currentName)) {
                        adminConsoleAppPermission = (AdminConsoleAppPermission) StoneSerializers.nullable(AdminConsoleAppPermission.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (adminConsoleAppPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (adminConsoleAppPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                AppPermissionsChangedDetails appPermissionsChangedDetails = new AppPermissionsChangedDetails(adminConsoleAppPolicyDeserialize, adminConsoleAppPolicyDeserialize2, str, adminConsoleAppPermission);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(appPermissionsChangedDetails, appPermissionsChangedDetails.toStringMultiline());
                return appPermissionsChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
