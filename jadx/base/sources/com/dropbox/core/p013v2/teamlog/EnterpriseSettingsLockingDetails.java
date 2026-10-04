package com.dropbox.core.p013v2.teamlog;

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
public class EnterpriseSettingsLockingDetails {

    @Nonnull
    protected final String newSettingsPageLockingState;

    @Nonnull
    protected final String previousSettingsPageLockingState;

    @Nonnull
    protected final String settingsPageName;

    @Nonnull
    protected final String teamName;

    public EnterpriseSettingsLockingDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'settingsPageName' is null");
        }
        this.settingsPageName = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'previousSettingsPageLockingState' is null");
        }
        this.previousSettingsPageLockingState = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'newSettingsPageLockingState' is null");
        }
        this.newSettingsPageLockingState = str4;
    }

    @Nonnull
    public String getTeamName() {
        return this.teamName;
    }

    @Nonnull
    public String getSettingsPageName() {
        return this.settingsPageName;
    }

    @Nonnull
    public String getPreviousSettingsPageLockingState() {
        return this.previousSettingsPageLockingState;
    }

    @Nonnull
    public String getNewSettingsPageLockingState() {
        return this.newSettingsPageLockingState;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamName, this.settingsPageName, this.previousSettingsPageLockingState, this.newSettingsPageLockingState});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EnterpriseSettingsLockingDetails enterpriseSettingsLockingDetails = (EnterpriseSettingsLockingDetails) obj;
        String str7 = this.teamName;
        String str8 = enterpriseSettingsLockingDetails.teamName;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.settingsPageName) == (str2 = enterpriseSettingsLockingDetails.settingsPageName) || str.equals(str2)) && (((str3 = this.previousSettingsPageLockingState) == (str4 = enterpriseSettingsLockingDetails.previousSettingsPageLockingState) || str3.equals(str4)) && ((str5 = this.newSettingsPageLockingState) == (str6 = enterpriseSettingsLockingDetails.newSettingsPageLockingState) || str5.equals(str6)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<EnterpriseSettingsLockingDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(EnterpriseSettingsLockingDetails enterpriseSettingsLockingDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_name");
            StoneSerializers.string().serialize(enterpriseSettingsLockingDetails.teamName, jsonGenerator);
            jsonGenerator.writeFieldName("settings_page_name");
            StoneSerializers.string().serialize(enterpriseSettingsLockingDetails.settingsPageName, jsonGenerator);
            jsonGenerator.writeFieldName("previous_settings_page_locking_state");
            StoneSerializers.string().serialize(enterpriseSettingsLockingDetails.previousSettingsPageLockingState, jsonGenerator);
            jsonGenerator.writeFieldName("new_settings_page_locking_state");
            StoneSerializers.string().serialize(enterpriseSettingsLockingDetails.newSettingsPageLockingState, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public EnterpriseSettingsLockingDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("settings_page_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_settings_page_locking_state".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_settings_page_locking_state".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"settings_page_name\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_settings_page_locking_state\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_settings_page_locking_state\" missing.");
                }
                EnterpriseSettingsLockingDetails enterpriseSettingsLockingDetails = new EnterpriseSettingsLockingDetails(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(enterpriseSettingsLockingDetails, enterpriseSettingsLockingDetails.toStringMultiline());
                return enterpriseSettingsLockingDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
