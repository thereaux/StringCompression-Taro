import javax.lang.model.element.Name;
import java.util.ArrayList;

/**
 * Created by Dan on 9/19/17.
 * Program searches and returns relevant values
 * On my Honor: DT
 */

import java.util.Collection;
import java.util.NoSuchElementException;

public class ArrayDictionary<E,T> {

    private ArrayList<E> keys;
    private ArrayList<T> values;
    private int size;

//if contains() == false then add it to the arrays

    //constructors
    public ArrayDictionary(){
        keys = new ArrayList<E>();
        values = new ArrayList<T>();
    }

    public ArrayDictionary(E key, T value){
        keys = new ArrayList<E>();
        keys.add(key);
        values = new ArrayList<T>();
        values.add(value);
    }

    //add an key-value pair to the dictionary
    //if the key is already in the dictionary, then you should replace the current value with the new value
    public void put(E key, T value){

        if(keys.contains(key) == false){
            keys.add(key);
            values.add(value);
        } else {
            int keyIndex = keys.indexOf(key);
            values.set(keyIndex, value);
        }

    }

    //get the value associated with a given key
    public T get(E key){
    int keyIndex = keys.indexOf(key);
    return values.get(keyIndex);
    }

    //remove a key-value pair and return its value
    public T remove(E key){
        if(keys.contains(key)){
            int keyIndex = keys.indexOf(key);
            keys.remove(keyIndex);
            T temp = values.get(keyIndex);
            values.remove(keyIndex);
            return temp;
        } else {
            throw new NoSuchElementException();
        }
    }

    //returns true if the given key has an associated value
    public boolean contains(E key){
    if(keys.indexOf(key) > 0){
        return true;
    } else return false;

    }

    //returns true if the dictionary is empty
    public boolean isEmpty(){
       return keys.isEmpty();
    }

    //returns the number of key-value pairs in the dictionary
    public int size(){
        return keys.size();
    }

    //returns a Collection¹ of key-value pairs
    public Collection<E> keys(){

        ArrayList<E> fakeKeys = (ArrayList)keys.clone();
        //deep copy
        for (int i = 0; i < keys.size(); i++){
            fakeKeys.add(keys.get(i));
        }
        return fakeKeys;

    }

    //returns a Collection of values
    public Collection<T>  values(){

        ArrayList<T> fakeValues = (ArrayList)values.clone();
        //deep copy
        for (int i = 0; i < values.size(); i++){
            fakeValues.add(values.get(i));
        }

        return fakeValues;
    }

    public String toString() {
        if (this == null) {
            return "[]";
        } else {
            String output = "";
            output += this.keys() + " " + this.values();
            System.out.println(this.keys());
            return output;
        }
    }



//Driver
    public static void main(String[] args) {

        ArrayDictionary ad = new ArrayDictionary();
        // ArrayDictionary ad = new ArrayDictionary("Name", "Dan");

        //ad.put("Age","12");

//        Collection valuesCollection = ad.values;
//
//        Collection keysCollection = ad.keys;
//
//        System.out.println("Keys Collection = "+keysCollection);
//
//        System.out.println("Values Collection = "+valuesCollection);
//
//        System.out.println("Contains \"Age\" should be true = "+ad.contains("Age"));
//
//        System.out.println("Age get should return 12 = "+ad.get("Age"));
//
//        System.out.println("Remove Name should return Dan = "+ad.remove("Name"));2
//
//        // /shouldn't work -- throw and error
//        //System.out.println("Remove Animal should return Dan = "+ad.remove("Animal"));
//
//        System.out.println("Size should be 1 = "+ad.size());
//
//        System.out.println("Is Empty should be false = "+ad.isEmpty());
//
//        System.out.println("Remove Age should return Dan = "+ad.remove("Age"));
//
//        System.out.println("Is Empty should be true = "+ad.isEmpty());
        System.out.println(ad.toString());



    }


}
