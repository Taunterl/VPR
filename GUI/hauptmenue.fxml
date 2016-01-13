<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.text.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>
<?import java.lang.*?>
<?import javafx.scene.control.*?>

<VBox maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1" fx:controller="HauptmenueController">
   <children>
      <Label alignment="CENTER" text="Klasse auswählen" />
      <HBox prefHeight="27.0" prefWidth="600.0">
         <children>
            <ChoiceBox fx:id="klasseAuswaehlenBox" prefWidth="150.0" />
            <Button fx:id="starButton" mnemonicParsing="false" onAction="#starClicked" text="*" />
            <Button fx:id="plusButton" mnemonicParsing="false" onAction="#plusClicked" text="+" />
            <Button fx:id="minusButton" mnemonicParsing="false" onAction="#minusClicked" text="-" />
            <Button fx:id="uebersichtButton" mnemonicParsing="false" onAction="#uebersichtClicked" text="Übersicht" />
         </children>
      </HBox>
      <VBox prefHeight="200.0" prefWidth="100.0">
         <children>
            <Label text="RandomGuy" />
            <HBox alignment="CENTER">
               <children>
                  <Button fx:id="chooseStudentButton" mnemonicParsing="false" onAction="#chooseStudentClicked" text="Zufälligen Studierenden auswählen" />
               </children>
            </HBox>
            <HBox prefHeight="100.0" prefWidth="200.0">
               <children>
                  <ImageView fx:id="studentImage" fitHeight="150.0" fitWidth="158.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../Bilder/Ugly-boy.jpg" />
                     </image>
                  </ImageView>
                  <VBox alignment="CENTER" prefHeight="150.0" prefWidth="63.0">
                     <children>
                        <Label text="Name:" />
                        <Label text="Klasse:" />
                     </children>
                  </VBox>
                  <VBox alignment="CENTER_LEFT" prefHeight="150.0" prefWidth="81.0">
                     <children>
                        <Label fx:id="studentName" text="Max Mustermann">
                           <font>
                              <Font size="10.0" />
                           </font></Label>
                        <Label fx:id="classID" prefHeight="21.0" prefWidth="94.0" text="ibw2h14a">
                           <font>
                              <Font size="12.0" />
                           </font></Label>
                     </children>
                  </VBox>
                  <VBox alignment="CENTER" prefHeight="153.0" prefWidth="100.0">
                     <children>
                        <Button fx:id="gotoTableButton" mnemonicParsing="false" onAction="#gotoTableClicked" prefHeight="31.0" prefWidth="120.0" text="Zur Tabelle" />
                     </children>
                  </VBox>
               </children>
            </HBox>
         </children>
      </VBox>
      <VBox prefHeight="163.0" prefWidth="600.0">
         <children>
            <Label text="Gruppe erstellen" />
            <ToolBar prefHeight="49.0" prefWidth="600.0">
              <items>
                  <RadioButton fx:id="gruppenGroesseRadion" mnemonicParsing="false" onAction="#gruppenGroesseClicked" text="Gruppengröße" />
                  <TextField fx:id="gruppenGroesseText" onAction="#addGruppenGroesse" prefHeight="25.0" prefWidth="131.0" />
                <Button fx:id="gruppenWuerfelnButton" mnemonicParsing="false" onAction="#gruppenWuerfelnClicked" text="Gruppen würfeln" />
              </items>
            </ToolBar>
            <ToolBar prefHeight="40.0" prefWidth="200.0">
              <items>
                  <RadioButton fx:id="gruppenAnzahlRadio" mnemonicParsing="false" onAction="#gruppenAnzahlClicked" text="Gruppenanzahl" />
                  <TextField />
                <Button fx:id="aufgabenZuteilenButton" mnemonicParsing="false" onAction="#aufgabenZuteilenClicked" text="Aufgaben zuteilen" />
              </items>
            </ToolBar>
            <ToolBar prefHeight="65.0" prefWidth="600.0">
              <items>
                <Button fx:id="beendenButton" mnemonicParsing="false" onAction="#beendenButtonClicked" text="Beenden" />
              </items>
            </ToolBar>
         </children>
      </VBox>
   </children>
</VBox>
