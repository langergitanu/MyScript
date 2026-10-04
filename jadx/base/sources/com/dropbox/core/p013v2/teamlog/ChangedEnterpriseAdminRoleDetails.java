package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FedAdminRole;
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
public class ChangedEnterpriseAdminRoleDetails {

    @Nonnull
    protected final FedAdminRole newValue;

    @Nonnull
    protected final FedAdminRole previousValue;

    @Nonnull
    protected final String teamName;

    public ChangedEnterpriseAdminRoleDetails(@Nonnull FedAdminRole fedAdminRole, @Nonnull FedAdminRole fedAdminRole2, @Nonnull String str) {
        if (fedAdminRole == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = fedAdminRole;
        if (fedAdminRole2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fedAdminRole2;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = str;
    }

    @Nonnull
    public FedAdminRole getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public FedAdminRole getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public String getTeamName() {
        return this.teamName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue, this.teamName});
    }

    public boolean equals(Object obj) {
        FedAdminRole fedAdminRole;
        FedAdminRole fedAdminRole2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ChangedEnterpriseAdminRoleDetails changedEnterpriseAdminRoleDetails = (ChangedEnterpriseAdminRoleDetails) obj;
        FedAdminRole fedAdminRole3 = this.previousValue;
        FedAdminRole fedAdminRole4 = changedEnterpriseAdminRoleDetails.previousValue;
        return (fedAdminRole3 == fedAdminRole4 || fedAdminRole3.equals(fedAdminRole4)) && ((fedAdminRole = this.newValue) == (fedAdminRole2 = changedEnterpriseAdminRoleDetails.newValue) || fedAdminRole.equals(fedAdminRole2)) && ((str = this.teamName) == (str2 = changedEnterpriseAdminRoleDetails.teamName) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ChangedEnterpriseAdminRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ChangedEnterpriseAdminRoleDetails changedEnterpriseAdminRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            FedAdminRole.Serializer.INSTANCE.serialize(changedEnterpriseAdminRoleDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            FedAdminRole.Serializer.INSTANCE.serialize(changedEnterpriseAdminRoleDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("team_name");
            StoneSerializers.string().serialize(changedEnterpriseAdminRoleDetails.teamName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ChangedEnterpriseAdminRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FedAdminRole fedAdminRoleDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FedAdminRole fedAdminRoleDeserialize2 = null;
                String strDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        fedAdminRoleDeserialize = FedAdminRole.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        fedAdminRoleDeserialize2 = FedAdminRole.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("team_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fedAdminRoleDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (fedAdminRoleDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_name\" missing.");
                }
                ChangedEnterpriseAdminRoleDetails changedEnterpriseAdminRoleDetails = new ChangedEnterpriseAdminRoleDetails(fedAdminRoleDeserialize, fedAdminRoleDeserialize2, strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(changedEnterpriseAdminRoleDetails, changedEnterpriseAdminRoleDetails.toStringMultiline());
                return changedEnterpriseAdminRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
