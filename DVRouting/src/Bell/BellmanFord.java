/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bell;
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
                        host.get(pos).set(4, neighbor.get(0).get(0));
                        
                        if (host.get(0).get(0) == neighbor.get(0).get(0))
                             host.get(pos).set(3, neighbor.get(i).get(3));
                        else
                             host.get(pos).set(3, Integer.toString(1 + Integer.parseInt(neighbor.get(i).get(3))));
                    }
                }
            }
        }
                
        return host;         
            
    }       
}
    

