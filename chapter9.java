package com.company;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

class BiCycle{
    private float size, chain, tire_size;

    BiCycle(){}
    BiCycle(Map<String, Float> m1)
    {
        if(m1.containsKey("size")){
            this.size=m1.get("size");

        } else{
            this.size=0;
        }

        if(m1.containsKey("chain")){
            this.chain=m1.get("chain");

        } else{
            this.chain= defaultChain();
        }

        if(m1.containsKey("tire_size")){
            this.tire_size=m1.get("tire_size");

        } else{
            this.tire_size=defaultTireSize();
        }

    }



    int  localSpares() { return 2;}
    float defaultTireSize(){ return (float)20.0;}
    float defaultChain(){ return  (float)20.0;}

}


class RoadBike extends BiCycle {
    private float tape_c;

    RoadBike(){}


    int localSpares()

    {
    return 2;
    }


    float defaultTireSize(){ return (float)23.0;}

    float defaultChain(){ return  (float)20.0;}


}

interface TestClass {
    void localSparesTest();
}


class BiCycleTestClass implements TestClass {

    public void localSparesTest(){

        BiCycle tmp = mock(BiCycle.class);
        when(tmp.localSpares()).thenReturn(2);
        tmp.localSpares();
        verify(tmp).localSpares();
    }
}

class RoadBikeTestClass  implements  TestClass{
    public void localSparesTest(){

        BiCycle tmp = mock(BiCycle.class);
        when(tmp.localSpares()).thenReturn(2);
        tmp.localSpares();
        verify(tmp).localSpares();
    }

}
public class test_4 {

    public static void main(String args[]){
        BiCycle c1=new BiCycle();
        TestClass t1=new BiCycleTestClass();
        t1.localSparesTest();
    }
}