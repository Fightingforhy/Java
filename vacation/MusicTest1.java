import javax.sound.midi.*;
public class MusicTest1{
    public void play(){
        try{
            Sequencer sequencer=MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer");
        }catch(MidiUnavailableException ex){
            System.out.println("Bummer");
        }
    }
    //public void takeRisk() throws BadException{
      //  if (abandoAllHope){
        //    throw new BadException();
       // }
   // }
  //  public void CrosssFingers(){
      //  try{
        //    anObject.takeRisk();
       // }catch (BadException ex){
       //     System.out.println("Aaargh!");
        //    ex.printStackTrace();
      //  }
   // }
    public static void main(String[] args){
        MusicTest1 mt=new MusicTest1();
        mt.play();
    }
}