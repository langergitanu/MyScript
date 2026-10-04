package org.joda.time.p057tz;

import java.util.Set;
import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes9.dex */
public interface Provider {
    Set<String> getAvailableIDs();

    DateTimeZone getZone(String str);
}
