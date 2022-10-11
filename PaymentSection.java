package Project1_AshishSurapuraju;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PaymentSection extends GridPane {

	private Label pi;
	private Label totalLoanAmount;
	private Label monthlyPayment;
	private Label totalPayment;
	static Label tlAmount;
	static Label mpAmount;
	static Label tpAmount;

	public PaymentSection() {
		pi = new Label("Payment Information");
		pi.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		totalLoanAmount = new Label("Total Loan Amount$: ");

		monthlyPayment = new Label("monthly Payment$: ");

		totalPayment = new Label("Total Payment$: ");

		tlAmount = new Label("0.0");

		mpAmount = new Label("0.0");

		tpAmount = new Label("0.0");

		add(pi, 0, 0);
		add(totalLoanAmount, 0, 1);
		add(monthlyPayment, 0, 2);
		add(totalPayment, 0, 3);
		add(tlAmount, 1, 1);
		add(mpAmount, 1, 2);
		add(tpAmount, 1, 3);
		setVgap(15);
		setPadding(new Insets(0, 0, 24, 2));
		setStyle("-fx-border-color:black");
	}

	public static void reset() {
		tlAmount.setText("0.0");
		mpAmount.setText("0.0");
		tpAmount.setText("0.0");
	}

}
