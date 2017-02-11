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
        System.out.println(userWeight[0]+","+userWeight[1]+","+userWeight[2]+","+userWeight[3]);
        //List<Double> items = Item.getRoute();
    }
}
