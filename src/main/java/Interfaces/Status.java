package Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface Status {
    String NEW = "NEW";
    String CAR_IN_PRODUCTION = "CAR_IN_PRODUCTION";
    String CAR_READY = "CAR_READY";
    String ORDER_PICKED = "ORDER_PICKED";
    String ORDER_CANCELED = "ORDER_CANCELED";
    String WARRANTY_CLAIM = "WARRANTY_CLAIM";
    String WARRANTY_POSITIVE = "WARRANTY_POSITIVE";
    String WARRANTY_NEGATIVE = "WARRANTY_NEGATIVE";

    default List<String> getFields(){
        List<String> list = new ArrayList<>();
        list.add(NEW);
        list.add(CAR_IN_PRODUCTION);
        list.add(CAR_READY);
        list.add(ORDER_PICKED);
        list.add(ORDER_CANCELED);
        list.add(WARRANTY_CLAIM);
        list.add(WARRANTY_POSITIVE);
        list.add(WARRANTY_NEGATIVE);
        return list;
    }

}
