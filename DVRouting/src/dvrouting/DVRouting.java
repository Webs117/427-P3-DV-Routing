/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvrouting;
import java.io.*;
import java.net.*;
/**
 *
 * @author Adam
 */
public class DVRouting {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */

    
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        
        //holds direct link cost info of active neighbors
        String[][] links = new String[2][4];
        
        String routerLabel;
        int routerPortNum;
        
        System.out.print("Insert router info: ");
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        
        //Read router information from user
        String routerInfo = inFromUser.readLine();
        
        //Remove white space
        String routerInfoTrim = routerInfo.replaceAll("\\s+","");
        
        //First character is routerLabel
        routerLabel = routerInfoTrim.substring(0,1);
        
        //Port number must be 4 chars 
        String routerPortNumStr = routerInfoTrim.substring(1,5);
        routerPortNum = Integer.parseInt(routerPortNumStr);
        
        
        System.out.println("router name: " + routerLabel);    
        System.out.println("router port number: " + routerPortNum);
        
        boolean listening = true;
        
        //create UDP socket to listen to 
        DatagramSocket UDPclientSocket = new DatagramSocket(routerPortNum);
        
        while(listening == true){
            if(){
            
            }else{
                //DV update 
            }
        }
        
        
        
        
        
        //inital link input
       // while
    }
    
}
