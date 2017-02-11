/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialRec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author yyang
 */
public interface Algorithm {
    public Map<UserAgent,List<Item>> run();
}
