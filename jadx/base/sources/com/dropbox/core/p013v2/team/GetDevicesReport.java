package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DevicesActive;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class GetDevicesReport extends BaseDfbReport {

    @Nonnull
    protected final DevicesActive active1Day;

    @Nonnull
    protected final DevicesActive active28Day;

    @Nonnull
    protected final DevicesActive active7Day;

    public GetDevicesReport(@Nonnull String str, @Nonnull DevicesActive devicesActive, @Nonnull DevicesActive devicesActive2, @Nonnull DevicesActive devicesActive3) {
        super(str);
        if (devicesActive == null) {
            throw new IllegalArgumentException("Required value for 'active1Day' is null");
        }
        this.active1Day = devicesActive;
        if (devicesActive2 == null) {
            throw new IllegalArgumentException("Required value for 'active7Day' is null");
        }
        this.active7Day = devicesActive2;
        if (devicesActive3 == null) {
            throw new IllegalArgumentException("Required value for 'active28Day' is null");
        }
        this.active28Day = devicesActive3;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    @Nonnull
    public String getStartDate() {
        return this.startDate;
    }

    @Nonnull
    public DevicesActive getActive1Day() {
        return this.active1Day;
    }

    @Nonnull
    public DevicesActive getActive7Day() {
        return this.active7Day;
    }

    @Nonnull
    public DevicesActive getActive28Day() {
        return this.active28Day;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.active1Day, this.active7Day, this.active28Day});
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public boolean equals(Object obj) {
        DevicesActive devicesActive;
        DevicesActive devicesActive2;
        DevicesActive devicesActive3;
        DevicesActive devicesActive4;
        DevicesActive devicesActive5;
        DevicesActive devicesActive6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetDevicesReport getDevicesReport = (GetDevicesReport) obj;
        return (this.startDate == getDevicesReport.startDate || this.startDate.equals(getDevicesReport.startDate)) && ((devicesActive = this.active1Day) == (devicesActive2 = getDevicesReport.active1Day) || devicesActive.equals(devicesActive2)) && (((devicesActive3 = this.active7Day) == (devicesActive4 = getDevicesReport.active7Day) || devicesActive3.equals(devicesActive4)) && ((devicesActive5 = this.active28Day) == (devicesActive6 = getDevicesReport.active28Day) || devicesActive5.equals(devicesActive6)));
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetDevicesReport> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetDevicesReport getDevicesReport, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
            StoneSerializers.string().serialize(getDevicesReport.startDate, jsonGenerator);
            jsonGenerator.writeFieldName("active_1_day");
            DevicesActive.Serializer.INSTANCE.serialize(getDevicesReport.active1Day, jsonGenerator);
            jsonGenerator.writeFieldName("active_7_day");
            DevicesActive.Serializer.INSTANCE.serialize(getDevicesReport.active7Day, jsonGenerator);
            jsonGenerator.writeFieldName("active_28_day");
            DevicesActive.Serializer.INSTANCE.serialize(getDevicesReport.active28Day, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetDevicesReport deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DevicesActive devicesActiveDeserialize = null;
                DevicesActive devicesActiveDeserialize2 = null;
                DevicesActive devicesActiveDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("active_1_day".equals(currentName)) {
                        devicesActiveDeserialize = DevicesActive.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("active_7_day".equals(currentName)) {
                        devicesActiveDeserialize2 = DevicesActive.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("active_28_day".equals(currentName)) {
                        devicesActiveDeserialize3 = DevicesActive.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                if (devicesActiveDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"active_1_day\" missing.");
                }
                if (devicesActiveDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"active_7_day\" missing.");
                }
                if (devicesActiveDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"active_28_day\" missing.");
                }
                GetDevicesReport getDevicesReport = new GetDevicesReport(strDeserialize, devicesActiveDeserialize, devicesActiveDeserialize2, devicesActiveDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getDevicesReport, getDevicesReport.toStringMultiline());
                return getDevicesReport;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
