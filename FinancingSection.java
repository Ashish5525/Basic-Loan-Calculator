package Project1_AshishSurapuraju;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FinancingSection extends GridPane {

	private Label fi;
	private Label basePrice;
	private Label downPayment;
	private Label salesTax;
	static TextField bp;
	static TextField dp;
	static TextField st;

	public FinancingSection() {
		fi = new Label("Financing Information");
		fi.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		basePrice = new Label("Base Price:$ ");

		downPayment = new Label("Down Payment:$ ");

		salesTax = new Label("Sales Tax:% ");

		bp = new TextField("0.0");
		dp = new TextField("0.0");
		st = new TextField("7.0");

		add(basePrice, 0, 1);
		add(downPayment, 0, 2);
		add(salesTax, 0, 3);
		add(bp, 1, 1);
		add(dp, 1, 2);
		add(st, 1, 3);

		setPadding(new Insets(16, 5, 42, 2));
		setVgap(10);
		setStyle("-fx-border-color:black");

	}

	public static void reset() {
		bp.setText("0.0");
		dp.setText("0.0");
		st.setText("7.0");
	}

}
