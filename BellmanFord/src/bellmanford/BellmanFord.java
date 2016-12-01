/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bellmanford;
//import BellmanFord.*;
/**
 *
 * @author aggiacca
 */

import java.util.ArrayList;

public class BellmanFord{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       ArrayList<ArrayList<String>> test1 = new ArrayList<ArrayList<String>>();
       ArrayList<ArrayList<String>> test2 = new ArrayList<ArrayList<String>>();
      
       ArrayList<String> temp = new ArrayList<String>();
      
       //set row 1 of test case host
       temp.add("A");
       temp.add("B");
       temp.add("6");
       temp.add("1");
       temp.add("B");
       test1.add(temp);
       
       //set row 2 of test case host
       temp = new ArrayList<String>();
       temp.add("A");
       temp.add("C");
       temp.add("3");
       temp.add("1");
       temp.add("C");
       test1.add(temp);
       
       
       //set row 1 of test case neighbor
       temp = new ArrayList<String>();
       temp.add("C");
       temp.add("D");
       temp.add("7");
       temp.add("1");
       temp.add("D");
       test2.add(temp);
       
       //set row 2 of test case neighbor   
       temp = new ArrayList<String>();
       temp.add("C");
       temp.add("B");
       temp.add("1");
       temp.add("1");
       temp.add("B");
       test2.add(temp);
       
       //print host and neighbor before algorithm
       for (int i = 0; i < test1.size(); i++)
       {    for (int j = 0; j < test1.get(i).size(); j++)
               System.out.print(test1.get(i).get(j));
            System.out.println();
       }
       for (int i = 0; i < test2.size(); i++)
       {    for (int j = 0; j < test2.get(i).size(); j++)
               System.out.print(test2.get(i).get(j));
            System.out.println();
       }
       
       test1 = BellmanFordEval(test1,test2);
       
       System.out.println();
       
       for (int i = 0; i < test1.size(); i++)
       {
           for (int j = 0; j < test1.get(i).size(); j++)
               System.out.print(test1.get(i).get(j));
            System.out.println();
       }
 
    }
    
    
     public static ArrayList<ArrayList<String>> BellmanFordEval(ArrayList<ArrayList<String>> host, ArrayList<ArrayList<String>> neighbor){
             
        ArrayList<String> temp = new ArrayList<String>();
        
        int distToNeighbor = -1;
        
        for (int i = 0; i < host.size(); i++)
            if (host.get(i).get(1) == neighbor.get(0).get(0))
                distToNeighbor = Integer.parseInt(host.get(i).get(2));
        
        // iterate through nieghbors distance vector
        for (int i = 0; i < neighbor.size(); i++)
        {       
         
            int pos = -1;
            
            // find position of neighbor entry in host table
            for (int j = 0; j < host.size(); j++)
            {    // find which row is the neighbors row
                if (host.get(j).get(1) == neighbor.get(i).get(1))
                    pos = j;
            }
            
            // do not add host node to host node table
            if (neighbor.get(i).get(1) != host.get(0).get(0))
            {   
                // destination from neighbor is not in host table
                if (pos == -1)
                {
                    // add new entry to host table
                    temp.add(host.get(0).get(0));
                    temp.add(neighbor.get(i).get(1));
                    temp.add(Integer.toString(distToNeighbor + Integer.parseInt(neighbor.get(i).get(2))));
                    temp.add(Integer.toString(1 + Integer.parseInt(neighbor.get(i).get(3))));
                    temp.add(neighbor.get(0).get(0));
                    host.add(temp);

                    //reset temp
                    temp = new ArrayList<String>();
                }   

                if (pos >= 0)
                {    // if dist to neighbor + dist to other is less than known distance from host to other
                    if (distToNeighbor + Integer.parseInt(neighbor.get(i).get(2)) < Integer.parseInt(host.get(pos).get(2)))
                    {   
                        host.get(pos).set(2, Integer.toString(distToNeighbor + Integer.parseInt(neighbor.get(i).get(2))));
                        host.get(pos).set(3, Integer.toString(1 + Integer.parseInt(neighbor.get(i).get(3))));
                        host.get(pos).set(4, neighbor.get(0).get(0));
                    }
                }
            }
        }
                
        return host;         
            
    }       
}
    
//}
/*
public class BellmanFordthing {
    
    //constructor
    public BellmanFordthing(){  
        
    
    }
  */  
    //main bellman ford algorithm 
   
//}
