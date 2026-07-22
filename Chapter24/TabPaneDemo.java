import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.geometry.Side; 
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
    @Override 
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        // Tab 1: Line
        Tab tab1 = new Tab("Line");
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Line(10, 10, 80, 80));
        tab1.setContent(pane1);
        
        // Tab 2: Rectangle
        Tab tab2 = new Tab("Rectangle");
        StackPane pane2 = new StackPane();
        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT); // Prevent solid black fill
        pane2.getChildren().add(rectangle);
        tab2.setContent(pane2);
        
        // Tab 3: Circle
        Tab tab3 = new Tab("Circle");
        StackPane pane3 = new StackPane();
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        pane3.getChildren().add(circle);
        tab3.setContent(pane3);
        
        // Tab 4: Ellipse
        Tab tab4 = new Tab("Ellipse");
        StackPane pane4 = new StackPane();
        Ellipse ellipse = new Ellipse(10, 10, 100, 80);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.TRANSPARENT);
        pane4.getChildren().add(ellipse);
        tab4.setContent(pane4);
        
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

        // Radio buttons setup
        RadioButton rbTop = new RadioButton("Top");
        RadioButton rbRight = new RadioButton("Right");
        RadioButton rbBottom = new RadioButton("Bottom");
        RadioButton rbLeft = new RadioButton("Left");
        
        ToggleGroup group = new ToggleGroup();
        rbTop.setToggleGroup(group);
        rbLeft.setToggleGroup(group);
        rbBottom.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        rbTop.setSelected(true);

        // Action listeners to make the buttons change the tab placement
        rbTop.setOnAction(e -> tabPane.setSide(Side.TOP));
        rbRight.setOnAction(e -> tabPane.setSide(Side.RIGHT));
        rbBottom.setOnAction(e -> tabPane.setSide(Side.BOTTOM));
        rbLeft.setOnAction(e -> tabPane.setSide(Side.LEFT));

        // Bottom control pane
        HBox paneForButtons = new HBox(20);
        paneForButtons.getChildren().addAll(rbTop, rbRight, rbBottom, rbLeft);
        paneForButtons.setAlignment(Pos.CENTER); // Fixed spelling typo
        paneForButtons.setStyle("-fx-border-color:green");

        // Main layout pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(tabPane);
        borderPane.setBottom(paneForButtons);

        // Scene must hold the borderPane, not just the tabPane
        Scene scene = new Scene(borderPane, 400, 350); 
        primaryStage.setTitle("DisplayFigure"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}