package Project1_AshishSurapuraju;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OptionsSection extends GridPane {

	private final static int autoTrans = 1800;
	private final static int antiBrake = 1200;
	private final static int sun = 800;
	private final static int nav = 1350;
	private final static int aud = 1550;
	private Label pwo;
	private static CheckBox auto;
	private static CheckBox abs;
	private static CheckBox sunRoof;
	private static CheckBox navigation;
	private static CheckBox audio;

	public OptionsSection() {
		pwo = new Label("Price with Options");
		pwo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		auto = new CheckBox("Automatic Transmission: $1800");

		abs = new CheckBox("AntiLock Brake: $1200");

		abs.setSelected(true);

		sunRoof = new CheckBox("Sun Roof: $800");

		navigation = new CheckBox("Navigation System: $1350");

		audio = new CheckBox("Audio Package: $1550");

		add(pwo, 0, 0);
		add(auto, 0, 1);
		add(abs, 0, 2);
		add(sunRoof, 0, 3);
		add(navigation, 0, 4);
		add(audio, 0, 5);
		setPadding(new Insets(0, 0, 11, 10));
		setVgap(10);
		setStyle("-fx-border-color:black");
	}

	public static void reset() {

		abs.setSelected(true);
		auto.setSelected(false);
		sunRoof.setSelected(false);
		navigation.setSelected(false);
		audio.setSelected(false);
	}

	public static int sumCost() {
		int cost = 0;

		if (auto.isSelected()) {
			cost += autoTrans;
		}
		if (abs.isSelected()) {
			cost += antiBrake;
		}
		if (sunRoof.isSelected()) {
			cost += sun;
		}
		if (navigation.isSelected()) {
			cost += nav;
		}
		if (audio.isSelected()) {
			cost += aud;
		}
		return cost;
	}

}
