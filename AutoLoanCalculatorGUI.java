package Project1_AshishSurapuraju;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AutoLoanCalculatorGUI extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Auto Loan Calculator");
		GridPane gp = new GridPane();

		gp.setStyle("-fx-border:solid; -fx-border-color:black");

//Payment Section (Top Left)		

		PaymentSection ps = new PaymentSection();
		VBox Vbox1 = new VBox(ps);
		gp.add(Vbox1, 0, 1);

//Loan Section(Top Right)
		LoanTermSection loan = new LoanTermSection();
		VBox lt = new VBox(loan);
		gp.add(lt, 1, 1);

//Financing Section(Bottom left)

		FinancingSection finance = new FinancingSection();
		VBox fin = new VBox(finance);

		Label fi = new Label("Financing Information");
		fi.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		VBox heading = new VBox(fi);
		fi.setPadding(new Insets(0, 0, 0, 3));

		gp.add(heading, 0, 2);
		gp.add(fin, 0, 2);

//Extra Options(Bottom Right)

		OptionsSection options = new OptionsSection();
		VBox os = new VBox(options);
		gp.add(os, 1, 2);

//Buttons
		Button calculate = new Button("Calculate");
		calculate.setOnAction((ActionEvent event) -> {

//Getting values
			double optionPrice = OptionsSection.sumCost();
			double interestRate = LoanTermSection.getRate() / 100;
			double basePrice = Double.parseDouble(FinancingSection.bp.getText());
			double downPayment = Double.parseDouble(FinancingSection.dp.getText());
			double salesTax = Double.parseDouble(FinancingSection.st.getText()) / 100;
			int mon = LoanTermSection.getMonths();

//Calculating Values
			double monthlyInterestrate = interestRate / 12;
			double salesTaxAmount = (basePrice - downPayment + optionPrice) * salesTax;

			double totalLoanAmount = basePrice - downPayment + optionPrice + salesTaxAmount;

			double monthlyPayment = totalLoanAmount * (monthlyInterestrate * Math.pow(1 + monthlyInterestrate, mon))
					/ (Math.pow(1 + monthlyInterestrate, mon) - 1);

			double totalPayment = monthlyPayment * mon + downPayment;

			PaymentSection.tlAmount.setText(String.format("%.2f", totalLoanAmount));
			PaymentSection.mpAmount.setText(String.format("%.2f", monthlyPayment));
			PaymentSection.tpAmount.setText(String.format("%.2f", totalPayment));

		});

//Reset Button
		Button reset = new Button("Reset");
		reset.setOnAction((ActionEvent event) -> {

			PaymentSection.reset();
			LoanTermSection.reset();
			FinancingSection.reset();
			OptionsSection.reset();

		});

//Exit button
		Button exit = new Button("Exit");
		exit.setOnAction((ActionEvent event) -> {
			System.exit(0);
		});

		HBox buttons = new HBox(10, calculate, reset, exit);
		gp.add(buttons, 1, 3);
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(0, 0, 0, 0));
		buttons.setPrefWidth(30);

		Scene s = new Scene(gp);
		primaryStage.setScene(s);
		primaryStage.show();

	}

}
