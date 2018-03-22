package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.Slider;
import javafx.geometry.Side;
import java.util.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.beans.binding.Bindings;
import javafx.scene.media.MediaView;
import javafx.beans.property.DoubleProperty;
import javafx.scene.web.WebView;


// Main method for the program
public class Main extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

       // Create a scene and place a button in the scene
        Pane pane = new Pane();
        Image image = new Image(getClass().getResource("memory2.jpg").toExternalForm());
        pane.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(200,200,false,false,false,true))));

        Label label = new Label("Memory Matching Game");
        label.setFont(Font.font("Arial",FontWeight.BOLD, FontPosture.REGULAR, 60));
        label.setTextFill(Color.WHITESMOKE);

        label.setLayoutX(150);
        label.setLayoutY(30);
        pane.getChildren().add(label);



        Button Home = new Button("Home");
        Home.setLayoutX(150);
        Home.setLayoutY(250);
        Home.setStyle("-fx-background-color: #32cd32; -fx-font-size: 16px; -fx-font-size: 1.3em; -fx-font-weight: bold; -fx-padding: 10px 24px; -fx-width: 50%; -fx-border-width: 5px; -fx-border-radius: 2px;");

        Button Game = new Button("Game");
        Game.setStyle("-fx-background-color: #00bfff;-fx-font-size: 16px; -fx-padding: 10px 24px;-fx-font-weight: bold; -fx-border-width: 5px;-fx-border-radius: 2px;");

        Game.setLayoutX(450);
        Game.setLayoutY(250);
        Button About = new Button("Author");
        About.setStyle("-fx-background-color: #e6e6fa;-fx-font-size: 16px;-fx-font-weight: bold; -fx-padding: 10px 24px; -fx-border-width: 5px; -fx-border-radius: 2px;");
        About.setLayoutX(750);
        About.setLayoutY(250);
        pane.getChildren().addAll(Home,Game,About);



        experiment exp = new experiment();
        Authorview auth = new Authorview();
        Homeview homes =new Homeview();



        // Create a scene and place it in the stage
        Scene[] scene = {new Scene(pane, 1000, 600), new Scene(exp.createcontent(), 1000, 600), new Scene(auth.authorcontent(), 1000, 600), new Scene(homes.Homeviewcontent(),1000, 600) };
        stages(primaryStage, scene[0]);
        Home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[3]);
            }
        });
        homes.Backhome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[0]);
            }
        });
        Game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[1]);
            }
        });

        About.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[2]);
            }
        });

        exp.Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[0]);
            }
        });

        auth.Back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stages(primaryStage,scene[0]);            }
        });
    }
    public class Homeview extends Parent {
        protected  Button Backhome = new Button("Back");
        public Parent Homeviewcontent(){
            Pane border = new Pane();
            Image image = new Image(getClass().getResource("memory1.png").toExternalForm());
            border.setBackground(new Background(new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, new BackgroundSize(200,200,false,false,false,true))));

            Label[] label ={new Label("About the Game"),
                            new Label("Welcome to memory matching game ! This is a simple game that requires observation and memory."),
                            new Label("You will be given a set of 8 pictures. You will have six seconds to memorize the pictures and its positions."),
                            new Label("Once the pictures are gone, you will have the option to click the tiles. If matching pictures are selected,"),
                            new Label("you will receive 10 points otherwise you lose 2 points for each click. Challenge your memory!")};

            label[0].setTranslateX(250);
            label[0].setTranslateY(150);
            label[0].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.REGULAR, 25));
            label[0].setTextFill(Color.BLACK);

            for (int i=1;i<5;++i)
            {
                label[i].setTextFill(Color.BLACK);
                label[i].setFont(Font.font("Verdana",FontWeight.BOLD, FontPosture.REGULAR, 12));
                label[i].setTranslateX(250);
                label[i].setTranslateY(200+(i*20));
            }
            Backhome.setLayoutX(800);
            Backhome.setLayoutY(550);
            Backhome.setStyle("-fx-background-color: #32cd32; -fx-font-size: 16px; -fx-font-size: 1.3em; -fx-font-weight: bold; -fx-padding: 10px 24px; -fx-width: 50%; -fx-border-width: 5px; -fx-border-radius: 2px;");

            border.getChildren().addAll(label);
            border.getChildren().add(Backhome);

           return border;
        }
    }

    public class Authorview extends Parent {
        protected  Button Back1 = new Button("Back");

        public Parent authorcontent() {
            Pane border = new Pane();
            Image image = new Image(getClass().getResource("memory1.png").toExternalForm());

            border.setBackground(new Background(new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, new BackgroundSize(200,200,false,false,false,true))));

            TextField tfMessage = new TextField("About me");
            tfMessage.setEditable(false);
            tfMessage.setStyle("-fx-text-fill: Black");
            tfMessage.setFont(Font.font("Freestyle script", 30));
            tfMessage.setLayoutX(150);
            tfMessage.setLayoutY(50);

            String s1 = "My name is Shelby Joji. I am a Senior majoring in Computational and Applied Mathematics with double minor in Data Analytics and Computer Science. This is my third year at Kennesaw State University. Besides school I am a full time critical care Respiratory Therapist working at Kennestone hospital. Also, I am a big movie fan and enjoy watching movies when I am free. I love coding and always wanting to learn more in the feild of computer science. I hope you will like my simple JavaFX program. ";
            TextArea text = new TextArea(s1);
            text.setFont(new Font("Bahnschrift Light", 15));
            text.setWrapText(true);
            text.setMaxWidth(450);
            text.setBackground(new Background(new BackgroundFill(Color.rgb(70, 90, 70), CornerRadii.EMPTY, Insets.EMPTY)));
            text.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
            text.setLayoutX(400);
            text.setLayoutY(200);
            text.setStyle(" -fx-background-color: #4CAF50; ");

            ImageView mypic =new ImageView(getClass().getResource("download.jpg").toExternalForm());
            Label lb1 = new Label(" ",mypic);
            lb1.setStyle("-fx-border-color: none; -fx-border-width: 2");
            lb1.setContentDisplay(ContentDisplay.TOP);
            lb1.setLayoutX(100);
            lb1.setLayoutY(200);
            Back1.setLayoutX(800);
            Back1.setLayoutY(550);
            Back1.setStyle("-fx-background-color: #32cd32; -fx-font-size: 16px; -fx-font-size: 1.3em; -fx-font-weight: bold; -fx-padding: 10px 24px; -fx-width: 50%; -fx-border-width: 5px; -fx-border-radius: 2px;");



            border.getChildren().addAll(lb1,tfMessage,text,Back1);

           return border;
        }


    }
    // create inner class experiment
    public class experiment extends Parent {
        private static final int num_of_pairs = 8;
        private Tile checker = null ;
        private int point = 0;
        private Label labels= new Label();

        protected Button Back = new Button("Back");

        //add images
        private Image[] matchimage = {new Image(getClass().getResource("bob.jpg").toExternalForm()),
                new Image(getClass().getResource("janet.jpg").toExternalForm()),
                new Image(getClass().getResource("dexter.jpg").toExternalForm()),
                new Image(getClass().getResource("merryboy.jpg").toExternalForm()),
                new Image(getClass().getResource("marri.jpg").toExternalForm()),
                new Image(getClass().getResource("mathew.jpg").toExternalForm()),
                new Image(getClass().getResource("tommy.jpg").toExternalForm()),
                new Image(getClass().getResource("madmaddy.jpg").toExternalForm()),
                new Image(getClass().getResource("page.jpg").toExternalForm()),
                new Image(getClass().getResource("merrygirl.jpg").toExternalForm())};

        //create content
        private Parent createcontent(){
            BackgroundPosition bkg =new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,true);
            Pane root = new Pane();
            Image image = new Image(getClass().getResource("game.jpg").toExternalForm());
            root.setBackground(new Background(new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, bkg, new BackgroundSize(200,200,false,false,false,true))));

            root.setPrefSize(1000, 600);

            Back.setLayoutX(150);
            Back.setLayoutY(450);
            Back.setStyle("-fx-background-color: #32cd32; -fx-font-size: 16px; -fx-font-size: 1.3em; -fx-font-weight: bold; -fx-padding: 10px 24px; -fx-width: 50%; -fx-border-width: 5px; -fx-border-radius: 2px;");


            // Create a label and set its properties
            Label label = new Label("Score");
            label.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 47));
            labels.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 47));
            label.setTextFill(Color.WHITESMOKE);
            labels.setTextFill(Color.WHITESMOKE);
            labels.setLayoutX(100);
            labels.setLayoutY(300);
            label.setLayoutX(90);
            label.setLayoutY(250);
            root.getChildren().add(label);

            List<Tile> tiles = new ArrayList<>();

            for(int i = 0; i < num_of_pairs; i++){
                tiles.add(new Tile(matchimage[i]));
                tiles.add(new Tile(matchimage[i]));
            }

            Collections.shuffle(tiles);

            for(int i = 0; i < tiles.size(); i++){
                Tile tile = tiles.get(i);
                tile.setTranslateX(150 * (i%4)+380);
                tile.setTranslateY(150* (i/4));
                root.getChildren().add(tile);
            }

            root.getChildren().addAll(Back, labels);
            return root;
        }



        private class Tile extends StackPane {
            private ImageView snap = new ImageView(); //snap is my imageview
            //begining tile constructor
            public Tile(Image image){

                Rectangle rect = new Rectangle(150,150);
                rect.setFill(null);
                rect.setStroke(Color.BLACK);
                rect.setStrokeWidth(5.0);
                labels.setText(Integer.toString(point));
                snap.setImage(image);
                snap.setFitHeight(250);
                snap.setFitWidth(147);
                snap.setPreserveRatio(true);

                setAlignment(Pos.CENTER);
                getChildren().addAll(rect, snap);

                //events set to happen when mouse pressed
                setOnMousePressed(e -> {

                    if (isOpen())//if tile is open ----> do nothing
                    {return ;}

                    // if checker tile is null, then checker get the reference of current tile and open tile
                    if (checker==null) {
                        checker = this;
                        open();}

                    // if checker contains something
                    else {
                        if(!compare(checker))
                        {
                            this.closelonger();
                            point=point-2;
                            this.displaypoint();
                            checker.closelonger();} //  need to close current and previous

                        else
                        {
                            checker.open();
                            this.open();
                            point=point+10;
                            this.displaypoint();
                        }

                        checker=null;
                    }

                });

                close();// by default all tiles are closed
            }
            // end of contructor

            public void displaypoint(){
                labels.setText(Integer.toString(point));
            }
            //return opacity of snap: 0 when closed and 1 when open
            public boolean isOpen(){
                return snap.getOpacity()==1;
            }


            //checking if image you clicked is same as before
//comapare current snap image is same as image refrenced in the checker
            public boolean compare(Tile check){

                return snap.getImage().equals(check.snapper().getImage());
            }


            public void open(){
                FadeTransition ft = new FadeTransition(Duration.millis(50), snap);
                ft.setToValue(1);// this is what keeps the image open --> set opacity to max
                ft.play();
            }

            public void closelonger(){
                FadeTransition ft = new FadeTransition(Duration.millis(500), snap);
                ft.setDelay(Duration.millis(150));
                ft.setFromValue(1);
                ft.setToValue(0);// this is what keeps the image open --> set opacity to max
                ft.play();
            }


            public void close(){
                FadeTransition ft = new FadeTransition(Duration.millis(5000), snap);
                ft.setDelay(Duration.millis(4999));
                ft.setToValue(0); // this is what keeps the image open --> set opacity to none
                ft.play();
            }


            public ImageView snapper(){
                return snap;
            }

        } //closing class Tile

    }//end of primary class


    public void stages(Stage primaryStage, Scene s){
        primaryStage.setTitle("MyJavaFX"); // Set the stage title
        primaryStage.setScene(s); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
