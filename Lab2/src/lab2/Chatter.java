package lab2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Chatter extends Application {
	private double width=900, height=600;
	private String title="Chatter";
	private Color background=Color.LIGHTPINK;
	private BorderPane root;
	private ObservableList<String> connections;
	private Alert alert;
	private TextArea chatBox;
	private TextField textField;
	
	@Override
	public void init() throws Exception{
		connections= FXCollections.<String>observableArrayList("Matilda","Peter","Dana", "Smith");
		root = new BorderPane();
		root.setTop(createOptionsBar());
		root.setRight(createFriendList());
		root.setCenter(createChatBox());
		root.setBottom(createStatusBar());		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// Alert is initialized in start because it must be created on JavaFX thread
		alert = new Alert( AlertType.INFORMATION);
		// scene holds all JavaFX components that need to be displayed in Stage
		Scene scene = new Scene( root, width, height, background);
		primaryStage.setScene( scene);
		primaryStage.setTitle(title);
		// when escape key is pressed close the application
		primaryStage.addEventHandler( KeyEvent.KEY_RELEASED, ( KeyEvent event) -> {
			if( KeyCode.ESCAPE == event.getCode()){
				primaryStage.hide();
			}
		});
		// display the JavaFX application
		primaryStage.show();
		// this is to make the textField active as application starts.
		textField.requestFocus();
	}
	
	@Override
	public void stop() throws Exception{	
	}
	
	private  Region createFriendList() {
		ListView<String> listView=new ListView<>(connections);
		return listView;
	}
	
	private Region createChatBox() {
		chatBox=new TextArea();
		chatBox.setEditable(false);
		return chatBox;
	}
	
	private Region createOptionsBar() {
		MenuItem save = new MenuItem("Save");
		SeparatorMenuItem sepFile = new SeparatorMenuItem();
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(( ActionEvent e) -> Platform.exit());
		
		MenuItem info = new MenuItem("Info");
		info.setOnAction(e -> {
		    alert.setTitle( "Information");
		    alert.setHeaderText( "Developer");
		    alert.setContentText( "Min Li li000611@algonquinlive.com");
		    alert.show();
		 });
			
		Menu file = new Menu("File");
		file.getItems().addAll(save,sepFile,exit);

		Menu help = new Menu("Help");
		help.getItems().addAll(info);
		
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(file, help);
		
		return menuBar;	
	}
	
	
	   private Region createStatusBar() {
		   textField=new TextField();
		   textField.setPrefHeight(50);
		   
		   Button send =new Button("Send");
		   send.setPrefHeight(50);
		   	   
		   EventHandler <ActionEvent> postChat = e->{
		   //Create a StringBuilder called builder and pass to it System.lineSeparator().  
		   StringBuilder builder=new StringBuilder(System.lineSeparator());
		     
		   //get a formatter to display current time in a nice format.
		   DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT);
		   //get current time
		   LocalDateTime localTime = LocalDateTime.now();
		   //convert time to string
		   String time = localTime.format( formatter);
		   
		   builder.append(time);
		   builder.append(">>");
		   builder.append(textField.getText());
		   
		   chatBox.appendText(builder.toString());
		   textField.clear();	   
		   };
		   
		   textField.setOnAction(postChat);
		   send.setOnAction(postChat);
		   HBox.setHgrow( textField, Priority.ALWAYS);
		   Label status=new Label("Status: unknown");
		   
		   VBox vbox=new VBox();
		   vbox.getChildren().addAll(
				   new ToolBar(textField,send),
				   new ToolBar(status));
		   
		   return vbox;  
		   
	   }
	   
	   public static void main(String[] args) {
		   launch(args);	   
	   }

}
