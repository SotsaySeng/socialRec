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
    public List<Double> getRoute (){
    List<TravelRoute> routes = InputReader.readTravelRouteFromCSV();
    List<String>  travelTimes = new ArrayList<String>();
        routes.forEach((travelTime) -> {
           travelTimes.add(routes.get(0).getTravelTime());});
    List<Double>  items = new ArrayList<Double>();
    double max =Double.parseDouble(Collections.max(travelTimes));
    double min =Double.parseDouble(Collections.min(travelTimes));
          for(int i=0 ;i< travelTimes.size();i++)
        {
           double value = Double.parseDouble(travelTimes.get(i));
           value= (5+1)-(1+(value-min)*(5-1)/(max-min));
           items.add(value);
        }
          
    
    return items; //return items
    }
}
