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
 * @author yyang
 */
public class Item {
    public static List<Double> getRoute (){
    List<TravelRoute> routes = InputReader.readTravelRouteFromCSV();
    List<String>  items = new ArrayList<>();
    //Get travel time from route list
    List<String>  travelTimes = new ArrayList<String>();
        for(TravelRoute travelTime : routes ){
            travelTimes.add(travelTime.getTravelTime());
        }
    List<Double> norTravelTimes = itemNormalization(travelTimes);
    //end with return norValue
    
    
    return norTravelTimes;
    
    }
    
    public static List<Double> itemNormalization (List<String> itemColumn){
        List<Double>  normalisedColumn = new ArrayList<>();
        double max =Double.parseDouble(Collections.max(itemColumn));
        double min =Double.parseDouble(Collections.min(itemColumn));
          
            for(int i=0 ;i< itemColumn.size();i++)
                {
                    double value = Double.parseDouble(itemColumn.get(i));
                    value= (5+1)-(1+(value-min)*(5-1)/(max-min));
                    normalisedColumn.add(value);
                }
         
        return normalisedColumn; //return items
    
    }
}
