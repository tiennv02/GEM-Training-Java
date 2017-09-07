public class Drawing {

    private Shape sh;

    public Drawing(){}

    public Drawing(Shape sh){
        this.sh=sh;
    }

    //khởi động
    public void prepairing(){
        System.out.println("Welcome!");
    }

    //Quyết định shape là gì?
//    Shape sh = new Circle();
    public void setShape(Shape sh){
        this.sh = sh;
    }

    public void drawDrawing(){
        sh.drawH();
    }
}
