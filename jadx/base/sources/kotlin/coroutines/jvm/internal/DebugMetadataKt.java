package kotlin.coroutines.jvm.internal;

import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0081\u0080\u0004¢\u0006\u0002\b\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0082\u0080\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0082\u0080\u0004\u001a\u001b\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t*\u00020\u0002H\u0081\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a\u000e\u0010\u000e\u001a\u00020\u0007*\u00020\u0002H\u0081\u0080\u0004\"\u000f\u0010\f\u001a\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\r\u001a\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", "", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION_1_3", "COROUTINES_DEBUG_METADATA_VERSION_2_2", "getNextLineNumber", "kotlin-stdlib"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION_1_3 = 1;
    private static final int COROUTINES_DEBUG_METADATA_VERSION_2_2 = 2;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null || debugMetadataAnnotation.m1616v() < 1) {
            return null;
        }
        int label = getLabel(baseContinuationImpl);
        int i = label < 0 ? -1 : debugMetadataAnnotation.m1611l()[label];
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
        return new StackTraceElement(moduleName == null ? debugMetadataAnnotation.m1608c() : moduleName + JsonPointer.SEPARATOR + debugMetadataAnnotation.m1608c(), debugMetadataAnnotation.m1612m(), debugMetadataAnnotation.m1609f(), i);
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        if (baseContinuationImpl instanceof TailCallBaseContinuationImpl) {
            return 0;
        }
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null || debugMetadataAnnotation.m1616v() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int label = getLabel(baseContinuationImpl);
        int[] iArrM1610i = debugMetadataAnnotation.m1610i();
        int length = iArrM1610i.length;
        for (int i = 0; i < length; i++) {
            if (iArrM1610i[i] == label) {
                arrayList.add(debugMetadataAnnotation.m1615s()[i]);
                arrayList.add(debugMetadataAnnotation.m1613n()[i]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final int getNextLineNumber(BaseContinuationImpl baseContinuationImpl) {
        int label;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation != null && debugMetadataAnnotation.m1616v() >= 2 && (label = getLabel(baseContinuationImpl)) >= 0 && label < debugMetadataAnnotation.m1614nl().length) {
            return debugMetadataAnnotation.m1614nl()[label];
        }
        return -1;
    }
}
