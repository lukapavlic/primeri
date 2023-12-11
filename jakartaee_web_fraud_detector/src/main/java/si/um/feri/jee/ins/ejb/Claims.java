package si.um.feri.jee.ins.ejb;

import si.um.feri.jee.ins.jsf.vao.ClaimVao;
import si.um.feri.jee.ins.jsf.vao.PolicyVao;
import si.um.feri.jee.ins.vao.Codes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class Claims {

    private static Logger log=Logger.getLogger(Claims.class.getName());

    public static double FRAUD_PROBABILITY_SEDAN_CAR=0.05;
    public static double FRAUD_PROBABILITY_SPORTS_CAR=0.005;
    public static double FRAUD_PROBABILITY_UTILITY_CAR=0.02;
    public static double FRAUD_PROBABILITY_FIRST_OWNER=0.08;


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
    public static double detectPossibleFraud(PolicyVao ip, ClaimVao c) {

        log.info("Fraud?");
        log.info(""+ip);
        log.info(""+c);

        double currentProbability=0.0;
        if (ip.getCarType().equals(Codes.CAR_TYPE_SEDAN)) {
            currentProbability+=FRAUD_PROBABILITY_SEDAN_CAR;
            log.info("Sedan "+FRAUD_PROBABILITY_SEDAN_CAR);
        }
        if (ip.getCarType().equals(Codes.CAR_TYPE_SPORTS)) {
            currentProbability+=FRAUD_PROBABILITY_SPORTS_CAR;
            log.info("Sports car "+FRAUD_PROBABILITY_SPORTS_CAR);
        }
        if (ip.getCarType().equals(Codes.CAR_TYPE_UTILITY)) {
            currentProbability+=FRAUD_PROBABILITY_UTILITY_CAR;
            log.info("Utility car "+FRAUD_PROBABILITY_UTILITY_CAR);
        }

        if (ip.isFirstCarOwner()) {
            currentProbability+=FRAUD_PROBABILITY_FIRST_OWNER;
            log.info("First owner "+FRAUD_PROBABILITY_FIRST_OWNER);
        }

        if (
                c.getDate().contains(".03.")||
                c.getDate().contains(".05.")) {
            currentProbability+=0.1;
            log.info("May, March 0.1");
        }
        if (
                c.getDate().contains(".07.")||
                c.getDate().contains(".11.")||
                c.getDate().contains(".12.")) {
            currentProbability+=0.06;
            log.info("Jul, Nov, Dec 0.06");
        }
        if (
                c.getDate().contains(".01.")||
                c.getDate().contains(".02.")||
                c.getDate().contains(".04.")||
                c.getDate().contains(".06.")||
                c.getDate().contains(".08.")||
                c.getDate().contains(".09.")||
                c.getDate().contains(".10")) {
            currentProbability+=0.08;
            log.info("Other dates 0.08");
        }


        LocalDate claimDate=LocalDate.parse(c.getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate policyTillDate=LocalDate.parse(ip.getValidTillDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        if (ChronoUnit.DAYS.between(claimDate,policyTillDate)<8) {
            if (c.getClaimType().equals(Codes.CLAIM_GLASSES)) {
                currentProbability+=0.5;
                log.info("Last week glasses 0.5");
            }
            if (c.getClaimType().equals(Codes.CLAIM_LIGHTS)) {
                currentProbability+=0.4;
                log.info("Last week lights 0.4");
            }
            if (c.getClaimType().equals(Codes.CLAIM_VANDALISM)) {
                currentProbability+=0.3;
                log.info("Last week vandalism 0.3");
            }
        }

        return currentProbability;
    }

}
