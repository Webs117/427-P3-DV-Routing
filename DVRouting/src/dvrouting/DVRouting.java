/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvrouting;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import Bell.*;
import java.util.Arrays;
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
         ArrayList<ArrayList<String>> neighborLinks = new ArrayList<ArrayList<String>>();
         
         
        ArrayList<ArrayList<String>> neighborPorts = new ArrayList<ArrayList<String>>();
        
        //routing table 
        ArrayList<ArrayList<String>> routerTable = new ArrayList<ArrayList<String>>();
        
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
            byte[] inPacketData = new byte[2048];
            
            
            DatagramPacket inDatagram = new DatagramPacket(inPacketData, inPacketData.length);
            UDPclientSocket.receive(inDatagram);
            
            
            //remove empty spaces after aliceline from packet data byte array
            byte[] packetData = inDatagram.getData();     
            int trimPos = getEmptySlots(packetData); 
            byte[] trimPacketData = Arrays.copyOfRange(packetData, 0, trimPos);
            
            String packetStr = new String(trimPacketData);
            
            // # special character 
            if(trimPacketData[0] == 35){
                //inital link packet or liink cost change 
                
                //split intial link cost information by ,
                String linkSplit = "[,]";
                
                
                String[] controlPacketStr = packetStr.split(linkSplit);
                
                
                
                
                
                //When links update compare routerLink table with routerBV table 
                
            }else{
                //DV update 
            }
        }
        
        
        
        
        
        //inital link input
    }
    
    //Functions needed
    
    //Convert string into 2d array list
    public static ArrayList<ArrayList<String>> convertStrTo2D(String str){
        
        ArrayList<ArrayList<String>> final2d = new ArrayList<ArrayList<String>>();
        
        //split rows by -
        String splitTag = "[-]";
        
        //split individual row by spaces
        String lineTag = "[ ]+";
                
        String[] tableStr = str.split(splitTag);
        
        for(int i = 0; i < tableStr.length; i++ ){
            //split array by spaces 
            String temp[] = tableStr[i].split(lineTag);
            ArrayList<String> tempArr = new ArrayList<String>();
            
            for(int j =0; j < temp.length; j++){
                tempArr.add(j,temp[j]);
            }
            final2d.add(i,tempArr);
        }
        
        return final2d;
    }
    //Convert 2d array list into one string 
    public static String convertArrToStr(ArrayList<ArrayList<String>> twoArr){
        String finalStr = "";
        
        for(int i = 0; i < twoArr.size(); i++){
            
            String temp = "";
            
            for(int j = 0; j < twoArr.get(i).size(); j++){
                //include space for parser
                temp = temp + twoArr.get(i).get(j) + " ";
            }
            
            //include - character for parser 
            finalStr = finalStr + temp + "-";
        }
        
        return finalStr;
    }
    
    //print router table 
    public static void print2D(ArrayList<ArrayList<String>> twoArr){
        
        System.out.println("- - - - -");
        for(int i = 0; i < twoArr.size(); i++){
    
            for(int j = 0; j < twoArr.get(i).size(); j++){
                if(j== twoArr.get(i).size() - 1){
                    System.out.print(twoArr.get(i).get(j) + "\n");
                }else{
                    System.out.print(twoArr.get(i).get(j) + " ");
                }  
            }      
        }
        System.out.println("- - - - -");
        
    }
    
    //Assumes first empty slot signals rest of array is empty 
    //Finds position of first empty slot
    public static int getEmptySlots(byte[] arr){
        int position = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                //found end of numbers
                //break 
                i = arr.length;
            }else{

                position += 1;
            }
        }
        return position;
    }  
    
    
    
    
    public static String convertStrArrToStr(String[] arr){
      
        StringBuilder builder = new StringBuilder();
        for(String s : arr) {
            builder.append(s);
        }
        return builder.toString();
        
    }
    
}
