package org.ejml.simple;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.ops.ConvertDMatrixStruct;

/* JADX INFO: loaded from: classes9.dex */
public class UtilSimpleMatrix {
    public static SimpleMatrix convertSimple(DMatrixRBlock dMatrixRBlock) {
        return SimpleMatrix.wrap(ConvertDMatrixStruct.convert(dMatrixRBlock, (DMatrixRMaj) null));
    }
}
