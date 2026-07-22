import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddNewRowDemo extends Application {
    @Override 
    public void start(Stage primaryStage) {
        TableView<Country> tableView = new TableView<>();
        ObservableList<Country> data = FXCollections.observableArrayList(
            //American countries
            new Country("USA", "Washington DC", 280, true),
            new Country("Canada", "Ottawa", 32, true),
             // Asian Countries
            new Country("Japan", "Tokyo", 125.0, true),
            new Country("South Korea", "Seoul", 51.0, true),
    
            // African Countries
            new Country("D.R.Congo", "Kinshasa", 85.0, true),
            new Country("Kenya", "Nairobi", 55.0, true),
    
            // European Countries
            new Country("United Kingdom", "London", 67.0, true),
            new Country("France", "Paris", 68.0, true)

        );
        tableView.setItems(data);

        // Define columns
        TableColumn<Country, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setMinWidth(100);
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Country, String> capitalColumn = new TableColumn<>("Capital");
        capitalColumn.setMinWidth(100);
        capitalColumn.setCellValueFactory(new PropertyValueFactory<>("capital"));

        TableColumn<Country, Double> populationColumn = new TableColumn<>("Population (million)");
        populationColumn.setMinWidth(120);
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));

        TableColumn<Country, Boolean> democraticColumn = new TableColumn<>("Is Democratic?");
        democraticColumn.setMinWidth(100);
        democraticColumn.setCellValueFactory(new PropertyValueFactory<>("democratic"));

        tableView.getColumns().addAll(countryColumn, capitalColumn, populationColumn, democraticColumn);

        //  Delete Button
        Button btDeleteRow = new Button("Delete Selected Row");
        HBox topPane = new HBox();
        topPane.setAlignment(Pos.CENTER);
        topPane.setStyle("-fx-padding: 5;");
        topPane.getChildren().add(btDeleteRow);

        // Action for Delete Button
        btDeleteRow.setOnAction(e -> {
            Country selectedItem = tableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                tableView.getItems().remove(selectedItem);
            }
        });

        //  Add Row Interface
        FlowPane flowPane = new FlowPane(3, 3);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setStyle("-fx-padding: 5;");
        
        TextField tfCountry = new TextField();
        TextField tfCapital = new TextField();
        TextField tfPopulation = new TextField();
        CheckBox chkDemocratic = new CheckBox("Is democratic?");
        Button btAddRow = new Button("Add new row");

        tfCountry.setPrefColumnCount(5);
        tfCapital.setPrefColumnCount(5);
        tfPopulation.setPrefColumnCount(5);

        flowPane.getChildren().addAll(
            new Label("Country: "), tfCountry, 
            new Label("Capital: "), tfCapital, 
            new Label("Population: "), tfPopulation, 
            chkDemocratic, btAddRow
        );

        // Action for Add Button
        btAddRow.setOnAction(e -> {
            try {
                data.add(new Country(
                    tfCountry.getText(), 
                    tfCapital.getText(), 
                    Double.parseDouble(tfPopulation.getText()), 
                    chkDemocratic.isSelected()
                ));
                tfCountry.clear();
                tfCapital.clear();
                tfPopulation.clear();
                chkDemocratic.setSelected(false);
            } catch (NumberFormatException ex) {
                // Prevent crash if non-numeric string is typed into population
                System.out.println("Invalid population entry.");
            }
        });

        // Layout Assembly
        BorderPane pane = new BorderPane();
        pane.setTop(topPane);
        pane.setCenter(tableView);
        pane.setBottom(flowPane);

        Scene scene = new Scene(pane, 550, 300);
        primaryStage.setTitle("Exercise31_22"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    }

    public static class Country {
        private final SimpleStringProperty country;
        private final SimpleStringProperty capital;
        private final SimpleDoubleProperty population;
        private final SimpleBooleanProperty democratic;

        public Country(String country, String capital, double population, boolean democratic) {
            this.country = new SimpleStringProperty(country);
            this.capital = new SimpleStringProperty(capital);
            this.population = new SimpleDoubleProperty(population);
            this.democratic = new SimpleBooleanProperty(democratic);
        }

        public String getCountry() { return country.get(); }
        public void setCountry(String country) { this.country.set(country); }

        public String getCapital() { return capital.get(); }
        public void setCapital(String capital) { this.capital.set(capital); }

        public double getPopulation() { return population.get(); }
        public void setPopulation(double population) { this.population.set(population); }

        public boolean isDemocratic() { return democratic.get(); }
        public void setDemocratic(boolean democratic) { this.democratic.set(democratic); }
    }

    public static void main(String[] args) {
        launch(args);
    }
}