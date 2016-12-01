/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dv.control;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 *
 * @author aggiacca
 */
public class DVControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String input;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        //open UDP socket 
        DatagramSocket UDPserverSocket = new DatagramSocket(6789);
        
        System.out.println("Functions:");
        System.out.println("-Link");
        System.out.println("-Quit \n");
        System.out.print("Query: ");
        
        input = inFromUser.readLine();
        
        while(input.equals("quit") == false ){
            
            if(input.equals("Link")){
                String linkInput;
                String finalStr;
                byte[] finalStrData = new byte[2048];
                InetAddress routerIp = InetAddress.getLocalHost();
                
                
                System.out.print("Insert Link: ");
                
                linkInput = inFromUser.readLine();
                
                //Remove white spaces 
                String linkInputTrim = linkInput.replaceAll("\\s+","");
                
                String linkNode1 = linkInputTrim.substring(0,1);
                String linkNode2 = linkInputTrim.substring(5,6);
                
                String routerPortNum1Str = linkInputTrim.substring(1,5);
                String routerPortNum2Str = linkInputTrim.substring(6,10);
                String linkCostStr = linkInputTrim.substring(10,11);
                
                int routerPortNum1 = Integer.parseInt(routerPortNum1Str);
                int routerPortNum2 = Integer.parseInt(routerPortNum2Str);
                
                
               
                
                finalStr = "#" + linkNode1 + linkNode2 + linkCostStr;
                
                finalStrData = finalStr.getBytes();
                
                DatagramPacket linkUpdateNode1 = new DatagramPacket(finalStrData, finalStrData.length, routerIp, routerPortNum1);
                DatagramPacket linkUpdateNode2 = new DatagramPacket(finalStrData, finalStrData.length, routerIp, routerPortNum2);
                
                UDPserverSocket.send(linkUpdateNode1);
                UDPserverSocket.send(linkUpdateNode2);
                
                
                
            }else{
                
            }
            
            System.out.print("Query: ");
            input = inFromUser.readLine();
        }
        
    }
    
}
