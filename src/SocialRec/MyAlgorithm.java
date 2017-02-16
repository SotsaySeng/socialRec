/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

/**
 *
 * @author SocialRec
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
        
        Double [] userWeight = AgentPref.weigthExtract(0);
        Double wTime = userWeight[0];
        Double wCost = userWeight[1];
        Double wDelay = userWeight[2];
        Double wWalk = userWeight[3];
        //social friendly
        Double wCongestion = 0.25;
        Double wAccident = 0.25;
        Double wPollution = 0.25;
        Double wTrafficCon = 0.25;
        List<String> items = Item.getRoute();
        List<Double>  utilityValues = new ArrayList<>();
        List<Double>  testFastest = new ArrayList<>();
        List<String>  utilitySocials = new ArrayList<>();
        List<Double>  totalUtilityList = new ArrayList<>();
        Map idUtilityValue = new HashMap();
        Map idUtilitySocial = new HashMap();
        Map totalUtilityWithId = new HashMap();
        Map ItemDetails = new HashMap();
        
        /*for(int i=0 ;i< items.size();i++)
                {
                    //personal
                    String vId = items.get(i).getId();
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
                    //fastest test
                    testFastest.add(vTravelTime);
//add to persoanl list and map with id
                    utilityValues.add(utilityValue);
                    idUtilityValue.put(vId, utilityValue);
                    //add to social list and map with id
                    utilitySocials.add(String.valueOf(utilitySocial));
                    idUtilitySocial.put(vId, utilitySocial);
                    //combine
                    
                    Double totalUtility = (utilityValue*0.75)+(utilitySocial*0.25);
                    totalUtilityList.add(totalUtility);
                    totalUtilityWithId.put(vId, totalUtility);
                    // item detail
                    ItemDetails.put(vId, items.get(i));
                  
                }
*/
                //rank
                System.out.println(items);
                //System.out.println(utilityValues);
                //System.out.println(totalUtilityList);
                //System.out.println(testFastest);
                //System.out.println(totalUtilityWithId);
                //List<String> topN = topNKeys((HashMap<String, Double>) totalUtilityWithId, 5);
               //
               /*Collections.reverse(topN);
                for (int i=0; i < topN.size(); i++) {
                    System.out.println(ItemDetails.get(topN.get(i)));
                }
                // spearman
		double n = totalUtilityList.size();
                Double e = new SpearmansCorrelation().correlation(toDoubleArray(utilityValues),toDoubleArray(totalUtilityList));
                List<Double> rewards = rewardCalculate(utilityValues, totalUtilityList);
                System.out.println(rewards);
                //double[] rank = RankingAlgorithm.rank(toDoubleArray(utilityValues));
		//double corr = Spearman.getCorrelation(utilityValues, totalUtilityList);
		//double pvalue = Spearman.getPvalue(e, n);
		//System.out.println("corr   = "+ corr);
		//System.out.println("pvalue = "+ pvalue);
                //end spearman
                //System.out.println("User weight ="+userWeight[0]+","+userWeight[1]+","+userWeight[2]+","+userWeight[3]);
                //System.out.println(e);
                
                //System.out.println(idUtilityValue);
                //System.out.println(totalUtilityWithId);
                //System.out.println(result);
                //System.out.println(entriesSortedByValues(idUtilityValue));
                //System.out.println(entriesSortedByValues(totalUtilityWithId));
                //System.out.println(ItemDetails);
                //System.out.println(ItemDetails.get(1));
                //idUtilityValue.entrySet().toArray();
                
                //S
*/

    }
    //Reward caluculate
    public static List<Double> rewardCalculate(List<Double> listX,List<Double> listY) {
                int[] rankPersonal = getRanksArray(toDoubleArray(listX));
                int[] rankSocial = getRanksArray(toDoubleArray(listY));
                List<Double>  rewards = new ArrayList<>();
                 for (int i = 0; i < rankPersonal.length; i++) {
                    double balancedValue;
                    double reward;
                    if(rankPersonal[i]>rankSocial[i]){
                        balancedValue = listY.get(i)- listX.get(i);
                        reward = Math.abs(balancedValue);
                                }
                    else{
                        reward=0;
                    }
                    rewards.add(reward);
                 }
                 return rewards;
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
    
    // ranking list
    public static int[] getRanksArray(double[] array) {
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
    //convert to double
    public static double[] toDoubleArray(List<Double> list) {
       double[] arr = new double[list.size()];
       for (int i=0; i < list.size(); i++) {
          arr[i] = list.get(i);
       }
       return arr;
    } 
    //top n
    public static List<String> topNKeys(final HashMap<String, Double> map, int n) {
        PriorityQueue<String> topN = new PriorityQueue<String>(n, new Comparator<String>() {
        public int compare(String s1, String s2) {
            return Double.compare(map.get(s1), map.get(s2));
        }
        });

        for(String key:map.keySet()){
            if (topN.size() < n)
                topN.add(key);
            else if (map.get(topN.peek()) < map.get(key)) {
            topN.poll();
            topN.add(key);
        }
    }
    return (List) Arrays.asList(topN.toArray());
    }
} 

