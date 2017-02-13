/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yyang
 */
public class UserAgent extends Agent{
    private AgentPref pref;
   
    public static Map userAgentSelection (Map recommendedItems) {
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
}
