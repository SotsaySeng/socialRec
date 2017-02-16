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
    public static List<TravelRoute> getRoute (){
    //read from CSV
    List<TravelRoute> routes = InputReader.readTravelRouteFromCSV();

//    List<String>  items = new ArrayList<>();

        List<String>  items = new ArrayList<>();

    //Get travel time from route list
    List<String>  travelTimes = new ArrayList<String>();
        for(TravelRoute travelTime : routes ){
            travelTimes.add(travelTime.getTravelTime());
        }
        itemNormalization(routes);

        
//    List<String> norTravelTimes = itemNormalization(travelTimes);
//    //end with return norValue
//    //Get travel cost from route list
//    List<String>  travelCosts = new ArrayList<String>();
//        for(TravelRoute travelCost : routes ){
//            travelCosts.add(travelCost.getTravelCost());
//        }
//    List<String> norTravelCosts = itemNormalization(travelCosts);
//    //end with return norValue
//    //Get delay from route list
//    List<String>  delays = new ArrayList<String>();
//        for(TravelRoute delay : routes ){
//            delays.add(delay.getDelay());
//        }
//    List<String> norDelays = itemNormalization(delays);
//    //end with return norValue
//    //Get walk time from route list
//    List<String>  walkTimes = new ArrayList<String>();
//        for(TravelRoute walkTime : routes ){
//            walkTimes.add(walkTime.getWalk());
//        }
//    List<String> norWalkTime = itemNormalization(walkTimes);
//    //create items list
//            for(int i =  0; i < travelTimes.size(); i++){
//                items.add(norTravelTimes.get(i));
//                items.add(norTravelCosts.get(i));
//                items.add(norDelays.get(i));
//                items.add(norWalkTime.get(i));
//            }
//
//        return items;
        return routes;
    }

    public static void itemNormalization (List<TravelRoute> travelRoutes){
        //normalize travel time
        double[] minMaxTravelTime = getMinMaxTravelTime(travelRoutes);
        double[] minMaxTravelCost = getMinMaxTravelCost(travelRoutes);
        double[] minMaxTravelDelay = getMinMaxDelay(travelRoutes);
        double[] minMaxTravelWalk = getMinMaxWalk(travelRoutes);
        for (TravelRoute route : travelRoutes) {
            double normlTravelTime = itemNormalization(Double.parseDouble(route.getTravelTime()), minMaxTravelTime[0], minMaxTravelTime[1]);
            route.setTravelTime(String.valueOf(normlTravelTime));

            double normlTravelCost = itemNormalization(Double.parseDouble(route.getTravelCost()), minMaxTravelCost[0], minMaxTravelCost[1]);
            route.setTravelCost(String.valueOf(normlTravelCost));

            double normalDelay = itemNormalization(Double.parseDouble(route.getDelay()), minMaxTravelDelay[0], minMaxTravelDelay[1]);
            route.setDelay(String.valueOf(normalDelay));

            double normalWalk = itemNormalization(Double.parseDouble(route.getWalk()), minMaxTravelWalk[0], minMaxTravelWalk[1]);
            route.setWalk(String.valueOf(normalWalk));
        }
    }

    private static double[] getMinMaxTravelTime(List<TravelRoute> travelRoutes){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(TravelRoute route : travelRoutes){
            double travelTime = Double.parseDouble(route.getTravelTime());
            if(travelTime < min){
                min = travelTime;
            }
            if(travelTime > max){
                max = travelTime;
            }
        }
        return new double[]{min,max};
    }

    private static double[] getMinMaxTravelCost(List<TravelRoute> travelRoutes){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(TravelRoute route : travelRoutes){
            double travelCost = Double.parseDouble(route.getTravelCost());
            if(travelCost < min){
                min = travelCost;
            }
            if(travelCost > max){
                max = travelCost;
            }
        }
        return new double[]{min,max};
    }

    private static double[] getMinMaxDelay(List<TravelRoute> travelRoutes){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(TravelRoute route : travelRoutes){
            double delay = Double.parseDouble(route.getDelay());
            if(delay < min){
                min = delay;
            }
            if(delay > max){
                max = delay;
            }
        }
        return new double[]{min,max};
    }

    private static double[] getMinMaxWalk(List<TravelRoute> travelRoutes){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(TravelRoute route : travelRoutes){
            double walk = Double.parseDouble(route.getWalk());
            if(walk < min){
                min = walk;
            }
            if(walk > max){
                max = walk;
            }
        }
        return new double[]{min,max};
    }

    private static double itemNormalization (double oriVale,double min,double max){
            double normvalue= (5+1)-(1+(oriVale-min)*(5-1)/(max-min));
            return normvalue;

    }

//    public static List<String> itemNormalization (List<String> itemColumn){
//        List<String>  normalisedColumn = new ArrayList<>();
//        double max =Double.parseDouble(Collections.max(itemColumn));
//        double min =Double.parseDouble(Collections.min(itemColumn));
//
//            for(int i=0 ;i< itemColumn.size();i++)
//                {
//                    double value = Double.parseDouble(itemColumn.get(i));
//                    value= (5+1)-(1+(value-min)*(5-1)/(max-min));
//                    normalisedColumn.add(String.valueOf(value));
//                }
//
//        return normalisedColumn; //return items
//
//    }
}
