package Assignment8_000813104;

/**
 * This class is the main class which use to create paint screen.
 * And use to create shapes with using various events
 *
 * @Author Abhay PAnchal
 *
 * 000813104
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
     * Use this template to create Apps with Graphical User Interfaces.
     *
     * @author Sam Scott
     */
    public class Paint extends Application {

        // TODO: Instance Variables for View Components and Model
        private GraphicsContext gc,dragGc;//Graphic context for gc and gradGc
        private double x,y;
        private double x1,y1;
        private int shape;
        private TextField txtWidth;
        private Button btnRectangle,btnOval,btnUndo,btnClear,btnReset;//Buttons for oval, rectangle , undo , clear and reset
        private Label lblShape,lblCreateShape,lblColor,lblWidth,lblStrokeColor; //Labels
        private Color color = Color.BLACK;//Default color for oval and rectangle
        private ColorPicker cp,strokeColor;
        private ArrayList<Shape>shapeArrayList;//Default array list for shapes
        // TODO: Private Event Handlers and Helper Methods

    /**
     * btn Press Handler
     * @param me
     */
    private void btnMouseHandler(MouseEvent me){
        x= me.getX();
        y=me.getY();
    }

    /**
     * Btn Rectangle Handler
     * @param e
     */
    private void btnRectangleHandler(ActionEvent e){
        shape = 1;
        lblCreateShape = new Label("you are Creating Rectangle");
    }

    /**
     * Btn Oval Handler
     * @param e
     */
    private void btnOvalHandler(ActionEvent e){
        shape = 2;
        lblCreateShape = new Label("You are creating Oval");
    }

    /**
     * Drag Even Handler For both shapes oval and Rectangle
     * @param me
     */

    private void dragHandler(MouseEvent me){
        dragGc.clearRect(150,0,850,800);
        //For Exception handling
        if(me.getX()>1000||me.getY()>800||me.getX()<150){//Error message if you drag outside canvas
            new Alert (Alert.AlertType.ERROR, "Sorry, That's Out Of Canvas").showAndWait();
        }else{
            int width = 0;
            try{
                width = Integer.parseInt(txtWidth.getText());
            }catch (NumberFormatException ne){
                new Alert(Alert.AlertType.ERROR,"Invalid Width").showAndWait();//Error message for invalid Width
            }
            if(shape==1){
                x1= me.getX();
                y1= me.getY();

                Rectangle rectangle = new Rectangle(x,y,x1,y1,width,strokeColor.getValue());//Drawing Rectangle While Dragging on Canvas
                rectangle.draw(dragGc);
            }else if(shape == 2){
                x1= me.getX();
                y1=me.getY();
                int r= 0;

                Oval oval = new Oval(x,y,x1,y1,r,cp.getValue());//Drawing oval while dragging on canvas
                oval.draw(dragGc);
            }
        }
    }

    /**
     * Mouse Release Handler
     * @param me
     */

    private void releaseHandler(MouseEvent me){
        int wid = Integer.parseInt(txtWidth.getText());
        x1=me.getX();
        y1=me.getY();

        if(shape==1){
            Rectangle rectangle = new Rectangle(x,y,x1,y1,wid,cp.getValue());//Displaying Rectangle
            shapeArrayList.add(rectangle);// Adding in the ArrayList
            gc.setFill(Color.LIGHTGOLDENRODYELLOW);
            gc.setStroke(strokeColor.getValue());
            gc.fillRect(150,0,850,800);
            dragGc.clearRect(150,0,850,800);
        }else if(shape==2){
            int r =0;
            Oval oval = new Oval(x,y,x1,y1,r,strokeColor.getValue());//Displaying Oval
            shapeArrayList.add(oval);//Adding in The Array list
            gc.strokeOval(x,y,r,r);
            gc.setStroke(strokeColor.getValue());
            gc.setFill(cp.getValue());
            dragGc.clearRect(150,0,850,800);
        }

        for(Shape s: shapeArrayList){
            s.draw(gc);
        }//Array List
    }

    /**
     * Clear Method to Clear The Whole Canvas
     * @param e
     */
    public void Clear(ActionEvent e){
        dragGc.clearRect(150,0,850,800);
        shapeArrayList.clear();
        for(Shape s2: shapeArrayList){
            s2.draw(gc);
        }
        gc.clearRect(150,0,850,800);
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.fillRect(150,0,850,800);
    }

    /**
     * Undo Method to undo the shapes from canvas
     *
     * You just need to click on the canvas after pressing the button to perform the action
     * @param e
     */

    public void Undo(ActionEvent e){
        shapeArrayList.remove(shapeArrayList.size()-1);

        if(shapeArrayList.size()==0){
            new Alert (Alert.AlertType.ERROR, "Canvas is clear Now").showAndWait();
        }

    }

    /**
     * Reset Method to reset every Data
     * @param e
     */
    public void Reset(ActionEvent e){
        refresh();
    }

    public void refresh(){
        txtWidth = new TextField("5");
        cp = new ColorPicker();
        strokeColor = new ColorPicker();
    }


        /**
         * This is where you create your components and the model and add event
         * handlers.
         *
         * @param stage The main stage
         * @throws Exception
         */
        @Override
        public void start(Stage stage) throws Exception {
            Pane root = new Pane();
            Scene scene = new Scene(root, 1000, 800); // set the size here
            stage.setTitle("Assignment 8(Paint)"); // set the window title here
            stage.setScene(scene);
            // TODO: Add your GUI-building code here

            // 1. Create the model
            // 2. Create the GUI components
            Canvas canvas = new Canvas(850,800);//new Canvas for Drawing shapes
            canvas.relocate(150,0);
            Canvas canvas2 = new Canvas(850,800);//new Canvas for Dragging shapes
            canvas2.relocate(150,0);

            lblShape = new Label("Select a Shape");

            btnRectangle = new Button("Rectangle");
            btnOval = new Button("Oval");
            lblCreateShape = new Label();

            lblColor = new Label("Color Picker");
            cp = new ColorPicker();

            lblStrokeColor = new Label("Stroke Color");
            strokeColor = new ColorPicker();

            lblWidth = new Label("Stroke Width");
            txtWidth = new TextField("5");

            btnUndo = new Button("Undo");
            btnClear = new Button("Clear");
            btnReset = new Button("Reset");

            shapeArrayList = new ArrayList<>();//Array List

            // 3. Add components to the root
            root.getChildren().addAll(canvas,canvas2,lblShape,btnRectangle,btnOval,lblCreateShape,lblColor,cp,lblWidth,txtWidth,btnUndo,btnClear,btnReset,lblStrokeColor,strokeColor);

            // 4. Configure the components (colors, fonts, size, location)
            lblShape.relocate(20,0);
            btnRectangle.relocate(5,30);
            btnOval.relocate(100,30);
            btnRectangle.setPrefSize(90,20);
            btnOval.setPrefSize(90,20);
            lblCreateShape.relocate(0,50);

            lblColor.relocate(5,170);
            lblStrokeColor.relocate(5,70);
            cp.relocate(5,200);
            strokeColor.relocate(5,100);

            lblWidth.relocate(0,265);
            txtWidth.relocate(5,285);
            txtWidth.setPrefSize(50,20);

            btnUndo.setPrefSize(60,20);
            btnUndo.relocate(5,320);

            btnClear.setPrefSize(60,20);
            btnClear.relocate(5,360);

            btnReset.setPrefSize(60,20);
            btnReset.relocate(5,400);

            //Graphics Contexts
            gc = canvas.getGraphicsContext2D();
            dragGc = canvas2.getGraphicsContext2D();
            gc.setFill(Color.LIGHTGOLDENRODYELLOW);
            gc.fillRect(150,0,850,800);

            // 5. Add Event Handlers and do final setup
            /**
             * Event Handlers
             */
            canvas2.addEventHandler(MouseEvent.MOUSE_PRESSED,this::btnMouseHandler);

            canvas2.addEventHandler(MouseEvent.MOUSE_RELEASED,this::releaseHandler);

            canvas2.addEventHandler(MouseEvent.MOUSE_DRAGGED,this::dragHandler);

            btnOval.setOnAction(this::btnOvalHandler);

            btnRectangle.setOnAction(this::btnRectangleHandler);

            btnClear.setOnAction(this::Clear);

            btnUndo.setOnAction(this::Undo);

            btnReset.setOnAction(this::Reset);
            // 6. Show the stage
            stage.show();
        }

        /**
         * Make no changes here.
         *
         * @param args unused
         */
        public static void main(String[] args) {
            launch(args);
        }
    }


