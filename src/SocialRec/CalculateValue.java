/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.List;

/**
 *
 * @author DV6
 */
public class CalculateValue {
   private int rId;
   private Double utilityValue;
   private Double utilitySocial;
   private Double totalUtility;

        public CalculateValue(int rId, Double utilityValue, Double utilitySocial,Double totalUtility) {
        this.rId=rId;
        this.utilityValue = utilityValue;
        this.utilitySocial = utilitySocial;
        this.totalUtility = totalUtility;
        }

	public int getRId() {
		return rId;
	}
	public void setRId(int rId) {
		this.rId = rId;
	}
        public Double getUtilityValue() {
		return utilityValue;
	}
	public void setUtilityValue(Double utilityValue) {
		this.utilityValue = utilityValue;
	}
        
        public Double getUtilitySocial() {
		return utilitySocial;
	}
	public void setUtilitySocial(Double utilitySocial) {
		this.utilitySocial = utilitySocial;
	}
        public Double getYotalUtility() {
		return totalUtility;
	}
	public void setTotalUtility(Double totalUtility) {
		this.totalUtility = totalUtility;
	}
}
