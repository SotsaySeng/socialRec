/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author SocialRec
 */
public class Item {
    public static List<String> getRoute (){
    //read from CSV
    List<TravelRoute> routes = InputReader.readTravelRouteFromCSV();
    
    List<String>  items = new ArrayList<>();
    //Get travel time from route list
    List<String>  travelTimes = new ArrayList<String>();
        for(TravelRoute travelTime : routes ){
            travelTimes.add(travelTime.getTravelTime());
        }
        
    List<String> norTravelTimes = itemNormalization(travelTimes);
    //end with return norValue
    //Get travel cost from route list
    List<String>  travelCosts = new ArrayList<String>();
        for(TravelRoute travelCost : routes ){
            travelCosts.add(travelCost.getTravelCost());
        }
    List<String> norTravelCosts = itemNormalization(travelCosts);
    //end with return norValue
    //Get delay from route list
    List<String>  delays = new ArrayList<String>();
        for(TravelRoute delay : routes ){
            delays.add(delay.getDelay());
        }
    List<String> norDelays = itemNormalization(delays);
    //end with return norValue
    //Get walk time from route list
    List<String>  walkTimes = new ArrayList<String>();
        for(TravelRoute walkTime : routes ){
            walkTimes.add(walkTime.getWalk());
        }
    List<String> norWalkTime = itemNormalization(walkTimes);
    //create items list
            for(int i =  0; i < travelTimes.size(); i++){
                items.add(norTravelTimes.get(i));
                items.add(norTravelCosts.get(i));
                items.add(norDelays.get(i));
                items.add(norWalkTime.get(i));
            }
            
        return items;
    }
    
    public static List<String> itemNormalization (List<String> itemColumn){
        List<String>  normalisedColumn = new ArrayList<>();
        double max =Double.parseDouble(Collections.max(itemColumn));
        double min =Double.parseDouble(Collections.min(itemColumn));
          
            for(int i=0 ;i< itemColumn.size();i++)
                {
                    double value = Double.parseDouble(itemColumn.get(i));
                    value= (5+1)-(1+(value-min)*(5-1)/(max-min));
                    normalisedColumn.add(String.valueOf(value));
                }
         
        return normalisedColumn; //return items
    
    }
}
