package Project1_AshishSurapuraju;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoanTermSection extends GridPane {

	private Label lT;
	private static RadioButton twentyFour;
	private static RadioButton thirtySix;
	private static RadioButton fourtyEight;
	private static RadioButton sixty;

	public LoanTermSection() {
		ToggleGroup tg = new ToggleGroup();

		lT = new Label("Loan Term");
		lT.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		twentyFour = new RadioButton("24");
		twentyFour.setSelected(true);
		twentyFour.setToggleGroup(tg);

		thirtySix = new RadioButton("36");
		thirtySix.setToggleGroup(tg);

		fourtyEight = new RadioButton("48");
		fourtyEight.setToggleGroup(tg);

		sixty = new RadioButton("60");
		sixty.setToggleGroup(tg);

		add(lT, 0, 0);
		add(twentyFour, 0, 1);
		add(thirtySix, 0, 2);
		add(fourtyEight, 0, 3);
		add(sixty, 0, 4);
		setVgap(10);
		setPadding(new Insets(0, 0, 10, 10));
		setStyle("-fx-border-color:black");

	}

	public static void reset() {
		twentyFour.setSelected(true);
	}

	public static double getRate() {
		double rate = 0;

		if (twentyFour.isSelected()) {
			rate = 7.0;
		}
		if (thirtySix.isSelected()) {
			rate = 6.0;
		}
		if (fourtyEight.isSelected()) {
			rate = 5.5;
		}
		if (sixty.isSelected()) {
			rate = 5;
		}
		return rate;
	}

	public static int getMonths() {
		int months = 0;

		if (twentyFour.isSelected()) {
			months = 24;
		}
		if (thirtySix.isSelected()) {
			months = 36;
		}
		if (fourtyEight.isSelected()) {
			months = 48;
		}
		if (sixty.isSelected()) {
			months = 60;
		}

		return months;

	}
}
