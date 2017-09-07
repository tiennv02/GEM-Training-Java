public class main {
    public static void main (String [] args){

        Drawing dr = new Drawing(null);
        dr.prepairing();

        //Factory method
        Shape shape = new Circle();

        dr.setShape(shape);
        dr.drawDrawing();
    }
}
