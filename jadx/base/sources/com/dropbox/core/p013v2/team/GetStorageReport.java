package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.StorageBucket;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class GetStorageReport extends BaseDfbReport {

    @Nonnull
    protected final List<List<StorageBucket>> memberStorageMap;

    @Nonnull
    protected final List<Long> sharedFolders;

    @Nonnull
    protected final List<Long> sharedUsage;

    @Nonnull
    protected final List<Long> totalUsage;

    @Nonnull
    protected final List<Long> unsharedUsage;

    public GetStorageReport(@Nonnull String str, @Nonnull List<Long> list, @Nonnull List<Long> list2, @Nonnull List<Long> list3, @Nonnull List<Long> list4, @Nonnull List<List<StorageBucket>> list5) {
        super(str);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'totalUsage' is null");
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'totalUsage' is null");
            }
        }
        this.totalUsage = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'sharedUsage' is null");
        }
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'sharedUsage' is null");
            }
        }
        this.sharedUsage = list2;
        if (list3 == null) {
            throw new IllegalArgumentException("Required value for 'unsharedUsage' is null");
        }
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            if (it3.next() == null) {
                throw new IllegalArgumentException("An item in list 'unsharedUsage' is null");
            }
        }
        this.unsharedUsage = list3;
        if (list4 == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolders' is null");
        }
        Iterator<Long> it4 = list4.iterator();
        while (it4.hasNext()) {
            if (it4.next() == null) {
                throw new IllegalArgumentException("An item in list 'sharedFolders' is null");
            }
        }
        this.sharedFolders = list4;
        if (list5 == null) {
            throw new IllegalArgumentException("Required value for 'memberStorageMap' is null");
        }
        for (List<StorageBucket> list6 : list5) {
            if (list6 == null) {
                throw new IllegalArgumentException("An item in list 'memberStorageMap' is null");
            }
            Iterator<StorageBucket> it5 = list6.iterator();
            while (it5.hasNext()) {
                if (it5.next() == null) {
                    throw new IllegalArgumentException("An item in listan item in list 'memberStorageMap' is null");
                }
            }
        }
        this.memberStorageMap = list5;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    @Nonnull
    public String getStartDate() {
        return this.startDate;
    }

    @Nonnull
    public List<Long> getTotalUsage() {
        return this.totalUsage;
    }

    @Nonnull
    public List<Long> getSharedUsage() {
        return this.sharedUsage;
    }

    @Nonnull
    public List<Long> getUnsharedUsage() {
        return this.unsharedUsage;
    }

    @Nonnull
    public List<Long> getSharedFolders() {
        return this.sharedFolders;
    }

    @Nonnull
    public List<List<StorageBucket>> getMemberStorageMap() {
        return this.memberStorageMap;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.totalUsage, this.sharedUsage, this.unsharedUsage, this.sharedFolders, this.memberStorageMap});
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public boolean equals(Object obj) {
        List<Long> list;
        List<Long> list2;
        List<Long> list3;
        List<Long> list4;
        List<Long> list5;
        List<Long> list6;
        List<Long> list7;
        List<Long> list8;
        List<List<StorageBucket>> list9;
        List<List<StorageBucket>> list10;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetStorageReport getStorageReport = (GetStorageReport) obj;
        return (this.startDate == getStorageReport.startDate || this.startDate.equals(getStorageReport.startDate)) && ((list = this.totalUsage) == (list2 = getStorageReport.totalUsage) || list.equals(list2)) && (((list3 = this.sharedUsage) == (list4 = getStorageReport.sharedUsage) || list3.equals(list4)) && (((list5 = this.unsharedUsage) == (list6 = getStorageReport.unsharedUsage) || list5.equals(list6)) && (((list7 = this.sharedFolders) == (list8 = getStorageReport.sharedFolders) || list7.equals(list8)) && ((list9 = this.memberStorageMap) == (list10 = getStorageReport.memberStorageMap) || list9.equals(list10)))));
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetStorageReport> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetStorageReport getStorageReport, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
            StoneSerializers.string().serialize(getStorageReport.startDate, jsonGenerator);
            jsonGenerator.writeFieldName("total_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getStorageReport.totalUsage, jsonGenerator);
            jsonGenerator.writeFieldName("shared_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getStorageReport.sharedUsage, jsonGenerator);
            jsonGenerator.writeFieldName("unshared_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getStorageReport.unsharedUsage, jsonGenerator);
            jsonGenerator.writeFieldName("shared_folders");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getStorageReport.sharedFolders, jsonGenerator);
            jsonGenerator.writeFieldName("member_storage_map");
            StoneSerializers.list(StoneSerializers.list(StorageBucket.Serializer.INSTANCE)).serialize(getStorageReport.memberStorageMap, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetStorageReport deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                List list = null;
                List list2 = null;
                List list3 = null;
                List list4 = null;
                List list5 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("total_usage".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("shared_usage".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("unshared_usage".equals(currentName)) {
                        list3 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("shared_folders".equals(currentName)) {
                        list4 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("member_storage_map".equals(currentName)) {
                        list5 = (List) StoneSerializers.list(StoneSerializers.list(StorageBucket.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"total_usage\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_usage\" missing.");
                }
                if (list3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"unshared_usage\" missing.");
                }
                if (list4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folders\" missing.");
                }
                if (list5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_storage_map\" missing.");
                }
                GetStorageReport getStorageReport = new GetStorageReport(strDeserialize, list, list2, list3, list4, list5);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getStorageReport, getStorageReport.toStringMultiline());
                return getStorageReport;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
