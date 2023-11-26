package MementoTest;

import java.util.ArrayList;

public class Walker {
    private int currentX, currentY; //현재 위치
    private int targetX, targetY;   //목표 위치
    private ArrayList<String> actionList = new ArrayList<String>(); //시작 좌표에서 모굪 좌표로 가기 위해 어떤 행동을 해야하는지 행동을 저장하는 리스트 상하좌우

    public Walker(int currentX, int currentY, int targetX, int targetY){
        this.currentX = currentX;
        this.currentY = currentY;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public double new_distance(){
        return Math.sqrt(Math.pow(currentX - targetX, 2) + Math.pow(currentX - targetX, 2));
    }

    public double walk(String action){
        actionList.add(action);
        if(action.equals("UP")){
            currentY += 1;
        }
        else if(action.equals("DOWN")){
            currentY -= 1;
        }
        else if(action.equals("LEFT")){
            currentX -= 1;
        }
        else if(action.equals("RIGHT")){
            currentX += 1;
        }
        return new_distance();
    }
    public class Memento{
        private int x, y;
        private ArrayList<String> actionList;
        private Memento() {}
    }

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.x = this.currentX;
        memento.y = this.currentY;
        memento.actionList = (ArrayList<String>)this.actionList.clone(); //깊은 복사. 워커의 액션리스트가 변해도 모멘토의 액션리스트가 변하지 않게 하기 위함
        return memento;
    }

    public void restoreMemento(Memento memento){
        this.currentX = memento.x;
        this.currentY = memento.y;
        this.actionList = (ArrayList<String>)memento.actionList.clone(); //역시 깊은 복사.
    }

    @Override
    public String toString(){
        return actionList.toString();
    }
}
