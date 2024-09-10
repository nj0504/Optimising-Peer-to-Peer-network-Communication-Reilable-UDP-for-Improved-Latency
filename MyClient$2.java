// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

class MyClient$2 extends WindowAdapter {
   MyClient$2(final MyClient var1) {
      this.this$0 = var1;
   }

   public void windowClosing(WindowEvent var1) {
      if (this.this$0.s != null) {
         JOptionPane.showMessageDialog(this.this$0.chatWindow, "u r logged out right now. ", "Exit", 1);
         this.this$0.logoutSession();
      }

      System.exit(0);
   }
}
