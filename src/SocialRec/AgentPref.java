/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.List;

/**
 *
 * @author SocialRec
 */
public class AgentPref {
    //function extract weight from user preference
    public static Double[] weigthExtract (int userId){
        List<UserDetail> users = InputReader.readUserDetailFromCSV(); //read from CSV
        String rCost = users.get(userId).getCostWeight();
        String rTime = users.get(userId).getTimeWeight();
        String rDelay = users.get(userId).getDelayWeight();
        String rWalk = users.get(userId).getWalkWeight();
        double wCost;
        double wTime;
        double wDelay;
        double wWalk;
        double total = Double.parseDouble(rCost)+Double.parseDouble(rTime)+Double.parseDouble(rDelay)+Double.parseDouble(rWalk);
        wCost=Integer.parseInt(rCost)/total;
        wTime = Integer.parseInt(rTime)/total;
        wDelay = Integer.parseInt(rDelay)/total;
        wWalk = Integer.parseInt(rWalk)/total;
        return new Double[] {wCost,wTime,wDelay,wWalk};
    }
}
