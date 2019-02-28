import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

class DotComBust{
    //生命并初始化变量
    private GameHelper helper=new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses=0;

    //创建3个DotCom对象并指派名称并置入ArrayList
    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pet.com");
        DotCom two=new DotCom();
        two.setName("eToys.com");
        DotCom three =new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        //列出简短提示
        System.out.println("Your goalis to sink three dot com.");
        System.out.println("Pets.com,eToys.com,Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for(DotCom dotComToSet:dotComsList){    //对list中的每一个DotCom重复一次
            ArrayList<String> newLocation = helper.placeDotCom(3);//要求DotCom的位置
            dotComToSet.setLocationCells(newLocation);//调用这个DotCom的setter方法来指派刚去的的位置
        }
    }
    private void startPlaying(){
        while(!dotComsList.isEmpty()){    //判断DotCom的list是否为空
            String userGuess=helper.getUserInput("Enter a guess");  //取得玩家输入
            checkUserGuess(userGuess);   //调用checkUserGuess方法
        }
        finishGame();//调用finishGame方法
    }
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result="miss";

        for(DotCom dotComToTest:dotComsList){
            result=dotComToTest.checkYourself(userGuess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("All Dot Coms are dead! your stocer is now worthless.");
        if(numOfGuesses<=18){
            System.out.println("It only took you "+numOfGuesses+" guesses.");
            System.out.println(" You got out beforeyour options sank.");
        }
        else{
            System.out.println("Took you long enough. "+numOfGuesses+" guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
    public static void main(String [] args){
        DotComBust game=new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
class DotCom{
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }

    public void setName(String n){
        name=n;
    }

    public String checkYourself(String userInput){
        String result ="miss";
        int index = locationCells.indexOf(userInput);
        if(index>=0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result="kill";
                System.out.println("Ouch! You sunk "+name+"   : ( ");
            }
            else{
                result="hit";
            }
        }
        return result;
    }
}
class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int comCount = 0;
    private int[] grid = new int[gridSize];

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    } else {
                        success = false;
                    }
                }
            }
            x = 0;
            int row = 0;
            int column = 0;

            while (x < comSize) {
                grid[coords[x]] = 1;
                row = (int) (coords[x] / gridLength);
                column = coords[x] % gridLength;
                temp = String.valueOf(alphabet.charAt(column));

                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
            }
        }
        return alphaCells;
    }
}