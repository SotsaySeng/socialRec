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
public class TradAlgorithm implements Algorithm{

    @Override
    public Map<UserAgent,List<Item>> run() {
        //implement traditional algorithm
        int userAgent = 1;
        Double [] userWeight = AgentPref.weigthExtract(userAgent);
        Double wTime = userWeight[0];
        Double wCost = userWeight[1];
        Double wDelay = userWeight[2];
        Double wWalk = userWeight[3];
        
        List<TravelRoute> items = Item.getRoute();
        List<String>  utilityValues = new ArrayList<>();
        
        Map idUtilityValue = new HashMap();
        //Map<UserAgent,List<Item>> itemList = new HashMap();
        for(int i=0 ;i< items.size();i++)
                {
                    //personal
                    Double vId = Double.parseDouble(items.get(i).getId());
                    Double vTravelTime = Double.parseDouble(items.get(i).getTravelTime());
                    Double vTravelCost = Double.parseDouble(items.get(i).getTravelCost());
                    Double vDelay = Double.parseDouble(items.get(i).getDelay());
                    Double vWalk = Double.parseDouble(items.get(i).getWalk());
                    //calculate personal 
                    Double utilityValue = (wTime*vTravelTime)+(wCost*vTravelCost)+
                                            (wDelay*vDelay)+(wWalk*vWalk);
                    //add to persoanl list and map with id
                    utilityValues.add(String.valueOf(utilityValue));
                    idUtilityValue.put(vId, utilityValue);
                }
                
        //itemList.put(UserAgent,idUtilityValue);
        return idUtilityValue;
    }
    
}
