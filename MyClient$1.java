// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

class MyClient$1 extends FocusAdapter {
   MyClient$1(final MyClient var1) {
      this.this$0 = var1;
   }

   public void focusGained(FocusEvent var1) {
      this.this$0.txtMessage.selectAll();
   }
}
