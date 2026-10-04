package org.ejml.dense.row.linsol.p052qr;

import org.ejml.dense.block.linsol.p046qr.QrHouseHolderSolver_DDRB;
import org.ejml.dense.row.linsol.LinearSolver_DDRB_to_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrBlock64_DDRM extends LinearSolver_DDRB_to_DDRM {
    public LinearSolverQrBlock64_DDRM() {
        super(new QrHouseHolderSolver_DDRB());
    }
}
