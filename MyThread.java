// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class MyThread implements Runnable {
   Socket s;
   ArrayList al;
   ArrayList users;
   String username;

   MyThread(Socket var1, ArrayList var2, ArrayList var3) {
      this.s = var1;
      this.al = var2;
      this.users = var3;

      try {
         DataInputStream var4 = new DataInputStream(var1.getInputStream());
         this.username = var4.readUTF();
         var2.add(var1);
         var3.add(this.username);
         String var10001 = this.username;
         this.tellEveryOne("****** " + var10001 + " Logged in at " + String.valueOf(new Date()) + " ******");
         this.sendNewUserList();
      } catch (Exception var5) {
         System.err.println("MyThread constructor  " + String.valueOf(var5));
      }

   }

   public void run() {
      try {
         DataInputStream var2 = new DataInputStream(this.s.getInputStream());

         while(true) {
            String var1 = var2.readUTF();
            if (var1.toLowerCase().equals("@@logoutme@@:")) {
               DataOutputStream var3 = new DataOutputStream(this.s.getOutputStream());
               var3.writeUTF("@@logoutme@@:");
               var3.flush();
               this.users.remove(this.username);
               String var10001 = this.username;
               this.tellEveryOne("****** " + var10001 + " Logged out at " + String.valueOf(new Date()) + " ******");
               this.sendNewUserList();
               this.al.remove(this.s);
               this.s.close();
               break;
            }

            this.tellEveryOne(this.username + " said:  : " + var1);
         }
      } catch (Exception var4) {
         System.out.println("MyThread Run" + String.valueOf(var4));
      }

   }

   public void sendNewUserList() {
      this.tellEveryOne("updateuserslist:" + this.users.toString());
   }

   public void tellEveryOne(String var1) {
      Iterator var2 = this.al.iterator();

      while(var2.hasNext()) {
         try {
            Socket var3 = (Socket)var2.next();
            DataOutputStream var4 = new DataOutputStream(var3.getOutputStream());
            var4.writeUTF(var1);
            var4.flush();
         } catch (Exception var5) {
            System.err.println("TellEveryOne " + String.valueOf(var5));
         }
      }

   }
}
