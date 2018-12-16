package com.netcracker.sorter.generics;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShakerSortT<T> implements IMySortableT<T>{
	
	private static Logger log = LogManager.getLogger(ShakerSortT.class);
	
    public void sort(T[] mas, Comparator<T> comparator, int counter) {
    	log.info("Sort type: shaker");
        boolean wasSwapped;
        T temp;
        do {
            wasSwapped=false;
            for (int i = 0; i < counter - 2; i++) {
                if (comparator.compare((T)mas[i], (T)mas[i + 1])>=1) {
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                    wasSwapped=true;
                }
            }

            if(!wasSwapped) break;

            wasSwapped=false;
            for (int j = counter-2; j >= 0; j--) {
                if(comparator.compare((T)mas[j],(T)mas[j+1])>=1){
                    temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]=temp;
                    wasSwapped=true;
                }
            }

        } while(wasSwapped);
    }
}
