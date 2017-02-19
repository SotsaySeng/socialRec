/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import static SocialRec.Spearman.SC;
import static SocialRec.Spearman.toDoubleArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

/**
 *
 * @author SocialRec
 */
public class UserAgent extends Agent{
    private AgentPref pref;
    
    public static Map userAgentUtilityFunction (Map recommendedItems) {
        List<String>  utilityValues = new ArrayList<>();
        Map idPersoanlUtilityValue = new HashMap();
        
        for(int i=0 ;i< recommendedItems.size();i++)
                {
                    //personal
                    Double vPersonalValue = Double.parseDouble((String) recommendedItems.get(i));
                    Double vId = Double.parseDouble((String) recommendedItems.getOrDefault(i, vPersonalValue));
                    Double vReward = Double.parseDouble((String) recommendedItems.getOrDefault(i, vPersonalValue));
                    //calculate personal and reward 
                    Double utilityValueReward = vPersonalValue+vReward;
                    //add to persoanl list and map with id
                    utilityValues.add(String.valueOf(utilityValueReward));
                    idPersoanlUtilityValue.put(vId, utilityValueReward);
                }
        return idPersoanlUtilityValue;
                
    }
    public static Integer changeStatus (Double cor) {
        double statusThreshold = 0.6;
        int agentStatus = 1;
        if (cor>statusThreshold){
            agentStatus = 1;
        
        } else {
            agentStatus = 0;
        }
        return agentStatus;    
    }
    public static Double calculateRankCo(List<Double> X, List<Double> Y) {
        SpearmansCorrelation SC = new SpearmansCorrelation();
        double[] xArray = toDoubleArray(X);
        double[] yArray = toDoubleArray(Y);
        double corr = SC.correlation(xArray, yArray);
       
        return corr;
    }
}
