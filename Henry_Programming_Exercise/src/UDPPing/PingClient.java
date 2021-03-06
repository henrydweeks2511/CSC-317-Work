/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPPing;

import java.io.*;
import java.net.*;

public class PingClient
{
   public static void main(String args[]) throws Exception
   {
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
      
      DatagramSocket MyClientSocket = new DatagramSocket();
      
      InetAddress IPAddress = InetAddress.getByName("localhost");
      
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
              IPAddress, 9876);
      
      MyClientSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      
      MyClientSocket.receive(receivePacket);
      
      String modifiedSentence = new String(receivePacket.getData());
      
      System.out.println("FROM SERVER:" + modifiedSentence);
      
      MyClientSocket.close();
   }
}
