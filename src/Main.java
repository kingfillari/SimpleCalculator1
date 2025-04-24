import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField display = new TextField();
    private String currentInput = "";
    private double result = 0;
    private String operator = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        display.setEditable(false);
        display.setStyle("-fx-font-size: 20px;");

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        // Add display to the top of the grid
        grid.add(display, 0, 0, 4, 1);

        // Button text
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};

        int row = 1, col = 0;

        // Create buttons and add event handlers
        for (String text : buttons) {
            Button button = new Button(text);
            button.setMinSize(60, 60); // Ensure buttons are big enough
            button.setStyle("-fx-font-size: 20px;");
            button.setOnAction(e -> handleButtonClick(text));
            grid.add(button, col++, row);

            // Move to next row if there are 4 buttons in the current row
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        // Create the scene and show the stage
        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "C":
                currentInput = "";
                result = 0;
                operator = "";
                break;
            case "=":
                calculateResult();
                currentInput = String.valueOf(result);
                operator = "";
                break;
            default:
                if ("0123456789".contains(text)) {
                    currentInput += text;
                } else {
                    if (!currentInput.isEmpty()) {
                        result = Double.parseDouble(currentInput);
                        currentInput = "";
                    }
                    operator = text;
                }
        }
        display.setText(currentInput);
    }

    private void calculateResult() {
        if (operator.isEmpty() || currentInput.isEmpty()) return;

        double currentNumber = Double.parseDouble(currentInput);
        switch (operator) {
            case "+":
                result += currentNumber;
                break;
            case "-":
                result -= currentNumber;
                break;
            case "*":
                result *= currentNumber;
                break;
            case "/":
                if (currentNumber != 0) {
                    result /= currentNumber;
                } else {
                    display.setText("Error");
                    result = 0;
                    return;
                }
                break;
        }
    }
}
