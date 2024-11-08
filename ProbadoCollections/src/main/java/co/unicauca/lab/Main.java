package co.unicauca.lab;

import co.unicauca.lab.collection.CollectionAdaptee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args) {
        List list = new ArrayList();
        CollectionAdaptee c = new CollectionAdaptee(list);

        c.add(7);
        c.add(8);
        c.add(9);

       c.unmodifiableCollection();
       try{
           c.add(12);
       }catch (UnsupportedOperationException e){
           System.out.println("Esta colección no puede ser modificada");
       }

        System.out.println("La colección esta vacía: "+c.isEmpty());

    }
}