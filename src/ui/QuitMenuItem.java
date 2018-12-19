package ui;
import javax.swing.*;
public final class QuitMenuItem extends JMenuItem
{
  private final DrawingApp drawingApp;

  public QuitMenuItem (DrawingApp drawingApp)
  {
    super("Quit");
    this.drawingApp = drawingApp;
    /* Example of Action listener
     *    @Override
    	public void actionPerformed(ActionEvent e) {

       if("exit".equals(e.getActionCommand())){

         int dialogButton = JOptionPane.YES_NO_OPTION;
         JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Laberynth First?","Warning",dialogButton);

         if(dialogButton == JOptionPane.YES_OPTION){
            System.exit(NORMAL);
         }

    }
     * 
     * 
     * 
     * */
    
  }
  
}
