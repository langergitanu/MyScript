package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AppLogInfo;
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
public class AppLinkTeamDetails {

    @Nonnull
    protected final AppLogInfo appInfo;

    public AppLinkTeamDetails(@Nonnull AppLogInfo appLogInfo) {
        if (appLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'appInfo' is null");
        }
        this.appInfo = appLogInfo;
    }

    @Nonnull
    public AppLogInfo getAppInfo() {
        return this.appInfo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.appInfo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AppLogInfo appLogInfo = this.appInfo;
        AppLogInfo appLogInfo2 = ((AppLinkTeamDetails) obj).appInfo;
        return appLogInfo == appLogInfo2 || appLogInfo.equals(appLogInfo2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AppLinkTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AppLinkTeamDetails appLinkTeamDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("app_info");
            AppLogInfo.Serializer.INSTANCE.serialize(appLinkTeamDetails.appInfo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AppLinkTeamDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AppLogInfo appLogInfoDeserialize = null;
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
                    if ("app_info".equals(currentName)) {
                        appLogInfoDeserialize = AppLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (appLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"app_info\" missing.");
                }
                AppLinkTeamDetails appLinkTeamDetails = new AppLinkTeamDetails(appLogInfoDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(appLinkTeamDetails, appLinkTeamDetails.toStringMultiline());
                return appLinkTeamDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
