package com.zipcodewilmington.arrayutility;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<K> {

    K obj;

    List<K> object;


    public ArrayUtility(K[] inputArray) {
        object = new ArrayList<>(Arrays.asList(inputArray));

    }

    public Integer countDuplicatesInMerge(K[] arrayToMerge, K valueToEvaluate) {
        List<K> arrayToMergeNow = new ArrayList<>(Arrays.asList(arrayToMerge));


        object.addAll(arrayToMergeNow);

        int countA = Collections.frequency(object, valueToEvaluate);

        return countA;
    }

    public Object[] removeValue(K valueToRemove) {
        for(int i = 0; i<object.size(); i++) {
            object.remove(valueToRemove);
        }

         Object[] names =  object.toArray();

         return names;
    }

    public K getMostCommonFromMerge(K[] arrayToMerge) {

        List<K> arrayToMergeNow = new ArrayList<>(Arrays.asList(arrayToMerge));
//        List<K> arrayToA = new ArrayList<>();


        /// First step is to merge and look and compare .equals(K)



        K maxCount = null;
        Object element_Having_max_freq = 0;

        object.addAll(arrayToMergeNow);


        return object.stream().reduce(BinaryOperator.maxBy(((o1, o2) -> Collections.frequency(object, o1) - Collections.frequency(object, o2)))).orElse(null);
        // Stream is going put object identity to the array
        // reduce is going add up the identity if they are the same
        // BinaryOperator.maxBy sets the variables to be used as comparators for the objects in the arrayList
        // Collections.frequency returns the total amount of the object in the object list
        // Example, object 1105 set as o1 - object 1101 set as o2

    }


    public Integer getNumberOfOccurrences(K valueToEvaluate) {
        return  Collections.frequency(object, valueToEvaluate);
    }
}
