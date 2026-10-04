package org.ejml.dense.row.linsol.p052qr;

import org.ejml.dense.block.linsol.p046qr.QrHouseHolderSolver_FDRB;
import org.ejml.dense.row.linsol.LinearSolver_FDRB_to_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrBlock64_FDRM extends LinearSolver_FDRB_to_FDRM {
    public LinearSolverQrBlock64_FDRM() {
        super(new QrHouseHolderSolver_FDRB());
    }
}
