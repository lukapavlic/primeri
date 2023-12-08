package si.um.feri.jee.ins.ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import si.um.feri.jee.ins.vao.Claim;
import si.um.feri.jee.ins.vao.InsurancePolicy;

@LocalBean
@Stateless
public class Claims {

    public double detectPossibleFraud(InsurancePolicy ip, Claim c) {

        return 0.0;
    }

}
