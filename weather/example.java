package example;

import java.util.*;

public class Example {
  public void computeScore(String type, Double score, Double sum) {
    Map<String, Double> map = new HashMap<String, Double>(){
      {
        put("type1", 0.1);
        put("type1", 0.2);
        put("type1", 0.3);
        put("type1", 0.4);
        put("type1", 0.5);
        put("type1", 0.6);
        put("type1", 0.7);
      }
    };
    if (map.containsKey(type)) {
      sum += score * map.get(type);
    }
  }
}
