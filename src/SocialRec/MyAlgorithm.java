/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



/**
 *
 * @author yyang
 */
public class MyAlgorithm implements Algorithm{

    @Override
    public Map<UserAgent,List<Item>> run() {
        //implement my alogrithm
        return null;
    }
    
    public static void main(String[] args) {
        /*Map<String,String> map = new HashMap<>();
        map.put("a", "b");
        map.put("b", "c");
        System.out.println(map);
        System.out.println(map.get("a"));
        System.out.println(map.get("c"));
        */
        
        Double [] userWeight = AgentPref.weigthExtract(1);
        Double wTime = userWeight[0];
        Double wCost = userWeight[1];
        Double wDelay = userWeight[2];
        Double wWalk = userWeight[3];
        //social friendly
        Double wCongestion = 0.25;
        Double wAccident = 0.25;
        Double wPollution = 0.25;
        Double wTrafficCon = 0.25;
        List<TravelRoute> items = Item.getRoute();
        List<String>  utilityValues = new ArrayList<>();
        List<String>  utilitySocials = new ArrayList<>();
        List<String>  totalUtilityList = new ArrayList<>();
        Map idUtilityValue = new HashMap();
        Map idUtilitySocial = new HashMap();
        Map totalUtilityWithId = new HashMap();
        
        for(int i=0 ;i< items.size();i++)
                {
                    //personal
                    int vId = Integer.parseInt(items.get(i).getId());
                    Double vTravelTime = Double.parseDouble(items.get(i).getTravelTime());
                    Double vTravelCost = Double.parseDouble(items.get(i).getTravelCost());
                    Double vDelay = Double.parseDouble(items.get(i).getDelay());
                    Double vWalk = Double.parseDouble(items.get(i).getWalk());
                    //social
                    Double vCongestion = Double.parseDouble(items.get(i).getCongestion());
                    Double vAccident = Double.parseDouble(items.get(i).getAccident());
                    Double vPollution = Double.parseDouble(items.get(i).getPollution());
                    Double vTrafficCon = Double.parseDouble(items.get(i).getTrafficCon());
                    //calculate personal 
                    Double utilityValue = (wTime*vTravelTime)+(wCost*vTravelCost)+
                                            (wDelay*vDelay)+(wWalk*vWalk);
                    //calculate social
                    Double utilitySocial= (wCongestion*vCongestion)+(wAccident*vAccident)+
                                            (wPollution*vPollution)+(wTrafficCon*vTrafficCon);
                    //add to persoanl list and map with id
                    utilityValues.add(String.valueOf(utilityValue));
                    idUtilityValue.put(vId, utilityValue);
                    //add to social list and map with id
                    utilitySocials.add(String.valueOf(utilitySocial));
                    idUtilitySocial.put(vId, utilitySocial);
                    //combine
                    
                    Double totalUtility = (utilityValue*0.75)+(utilitySocial*0.25);
                    totalUtilityList.add(String.valueOf(totalUtility));
                    totalUtilityWithId.put(vId, totalUtility);
                    
                  
                }
                //rank
                //System.out.println(idUtilityValue.get(1));
                //System.out.println(result);
                System.out.println(entriesSortedByValues(idUtilityValue));
                System.out.println(entriesSortedByValues(totalUtilityWithId));
                //idUtilityValue.entrySet().toArray();
                
                //System.out.println(rankWithId.get(2));

    }
    //sort
    public static <K,V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

            List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

            Collections.sort(sortedEntries, 
                new Comparator<Entry<K,V>>() {
                @Override
                public int compare(Entry<K,V> e1, Entry<K,V> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            }
         );

        return sortedEntries;
    }
    
    // ranking
    public static int[] getRanksArray(int[] array) {
        int[] result = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                int count = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] > array[i]) {
                     count++;
                }
             }
            result[i] = count + 1;
        }
        return result;
}
} 

