package si.um.feri.jee.ins.ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import si.um.feri.jee.ins.vao.Claim;
import si.um.feri.jee.ins.vao.InsurancePolicy;

@LocalBean
@Stateless
public class Claims {

    /**
     * Sedan 5%
     * Sports 0.5%
     * Utility 0.2%
     *
     * First owner 5%; not first owner 8%
     *
     * March, May 10%
     * Jul, Nov, Dec 6%
     * Other months 8%
     *
     * Last week of policy & glasses 50%
     * Last week of policy & lights 40%
     * Last week of policy & vandalism 30%
     */
    public double detectPossibleFraud(InsurancePolicy ip, Claim c) {


        return 0.0;
    }

}
