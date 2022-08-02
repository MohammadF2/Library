package com.example.javafxproject;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Drivar extends Application {

    static FileWriter cdr;
    static FileWriter mdr;

    {
        try {
            cdr = new FileWriter("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\Customer.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mdr = new FileWriter("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\Media.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage stage) throws IOException {
        MediaRental z = new MediaRental();
        Stage mediaStage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\ii.png"));
        Image customerBI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\tt.png");
        ImageView customerBIV = new ImageView(customerBI);
        Image mediaBI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\mm.png");
        ImageView mediaBIV = new ImageView(mediaBI);
        Image rentBI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\rr.png");
        ImageView rentBIV = new ImageView(rentBI);
        Image addI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\add.png");
        ImageView addIV = new ImageView(addI);
        ImageView addIVG = new ImageView(addI);
        ImageView addIVV = new ImageView(addI);
        ImageView addIVA = new ImageView(addI);
        Image removeI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\remove.png");
        ImageView removeIV = new ImageView(removeI);
        ImageView removeIVG = new ImageView(removeI);
        ImageView removeIVV = new ImageView(removeI);
        ImageView removeIVA = new ImageView(removeI);
        ImageView removeIVR = new ImageView(removeI);
        Image editI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\edit.png");
        ImageView editIV = new ImageView(editI);
        ImageView editIVG = new ImageView(editI);
        Image searchI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\search.png");
        ImageView searchIV = new ImageView(searchI);
        ImageView searchIVG = new ImageView(searchI);
        ImageView searchIVV = new ImageView(searchI);
        ImageView searchIVA = new ImageView(searchI);
        Image REFI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\photo.png");
        ImageView REFIV = new ImageView(REFI);
        Image BackI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\back.png");
        ImageView BackIV = new ImageView(BackI);
        ImageView BackIVG = new ImageView(BackI);
        ImageView BackIVV = new ImageView(BackI);
        ImageView BackIVA = new ImageView(BackI);
        ImageView BackIVR = new ImageView(BackI);
        Image returnI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\rrtt.png");
        ImageView returnIV = new ImageView(returnI);

        // File Area
        File customerData = new File("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\Customer.txt");
        File mediaData = new File("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\Media.txt");

        if (customerData.exists() == false) {
            System.out.println("Error: Customer Data file dosn't exists");
        }
        if (mediaData.exists() == false) {
            System.out.println("Error: media data file dosn't exists");
        }

        Scanner cd = new Scanner(customerData);
        Scanner md = new Scanner(mediaData);
        String [] u;
        if (customerData.length() > 0) {
            try {
                while (cd.hasNextLine()) {
                    u = cd.nextLine().split(" : ");
                    z.addCustomer(u[0], u[1], u[2], u[3],u[4]);
                }
                System.out.println("All customer data was loaded successfully");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Warning: customer data file is empty");
            }
        } else {
            System.out.println("Warning: customer data file is empty");
        }

        if (mediaData.length() > 0) {
            try {
                while (md.hasNextLine()) {
                    u = md.nextLine().split(" : ");
                    if (u[0].equals("Game")) {
                        z.addGame(u[1], Integer.parseInt(u[2]), Double.parseDouble(u[3]), u[4]);
                        System.out.println(u[0]);
                    } else if (u[0].equals("Movie")) {
                        z.addMovie(u[1], Integer.parseInt(u[2]), u[3],u[4]);
                    } else if (u[0].equals("Album")) {
                        z.addAlbum(u[1], Integer.parseInt(u[2]), u[3], u[4],u[5]);
                    }
                }
                System.out.println("All media data was loaded successfully");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Warning: media data file is empty");
            }
        } else {
            System.out.println("Warning: media data file is empty");
        }



        TextField MRTF1 = new TextField("Media Rental System");
        MRTF1.setEditable(false);
        // Main menu code
        GridPane MainMenuGp = new GridPane();
            MainMenuGp.setHgap(30);
            MainMenuGp.setVgap(20);
            Button CustomerMenuB = new Button("Customer", customerBIV);
            Button MediaMenuB = new Button("Meida     ", mediaBIV);
            Button RentMenuB = new Button("Rent        ", rentBIV);
            MainMenuGp.add(CustomerMenuB, 0,0);
            MainMenuGp.add(MediaMenuB, 0,1);
            MainMenuGp.add(RentMenuB, 0,2);
            MainMenuGp.add(REFIV, 1,1);
            MainMenuGp.add(MRTF1,1,2);
            MainMenuGp.setPadding(new Insets(15,15,15,15));
        // end of main menu code

        // Customer menu code
        GridPane CustomerMenuGp = new GridPane();
            CustomerMenuGp.setVgap(20);
            CustomerMenuGp.setHgap(30);
            TextField CustomerIdTF = new TextField();
            TextField CustomerNameTF = new TextField();
            TextField CustomerAddressTF = new TextField();
            TextField CustomermobileTF = new TextField();
            Button AddCustomerB = new Button("Add", addIV);
            Button RemoveCustomerB = new Button("Remove", removeIV);
            Button findCustomerB = new Button("Find",searchIV);
            Button BackCB = new Button("Back",BackIV);
            CustomerMenuGp.add(new Label("Customer ID:"), 0,0);
            CustomerMenuGp.add(CustomerIdTF, 1,0);
            CustomerMenuGp.add(new Label("Customer Name:"), 0,1);
            CustomerMenuGp.add(CustomerNameTF,1,1);CustomerMenuGp.add(new Label("Customer Address:"),0,2);
            CustomerMenuGp.add(CustomerAddressTF,1,2);
            CustomerMenuGp.add(new Label("Customer Mobile:"),0,3);
            CustomerMenuGp.add(CustomermobileTF,1,3);
            CustomerMenuGp.add(new Label("Customer Plan"),0,4);
            RadioButton unlimatedRB = new RadioButton("Unlimited");
            RadioButton limitedRB = new RadioButton("Limited");
            limitedRB.setSelected(true);
            ToggleGroup ctg = new ToggleGroup();
            unlimatedRB.setToggleGroup(ctg);
            limitedRB.setToggleGroup(ctg);
            HBox limHB = new HBox();
            limHB.setSpacing(20);
            limHB.getChildren().addAll(unlimatedRB,limitedRB);
            CustomerMenuGp.add(limHB,1,4);
            HBox customerHB = new HBox();
            customerHB.setSpacing(20);
            customerHB.getChildren().addAll(findCustomerB,AddCustomerB,RemoveCustomerB,BackCB);
            CustomerMenuGp.add(customerHB,1,5);
            CustomerMenuGp.setPadding(new Insets(15,15,15,15));

            Label ErrorStats = new Label("");
            ErrorStats.setTextFill(Color.web("#ff0000", 0.8));
            Label CTAL = new Label("Customer Data:");
            TextArea CustomerDataPTA = new TextArea();
            CustomerDataPTA.setEditable(false);
            CustomerMenuGp.add(ErrorStats,1,6);
            CustomerMenuGp.add(CustomerDataPTA,1,7);
            CustomerMenuGp.add(CTAL,0,7);
            CustomerDataPTA.setText("=====================Customers information=====================\n" + z.getAllCustomersInfo());


        // end of customer menu code

        // main media menu code
        GridPane MediaMenuMGBM = new GridPane();
            MediaMenuMGBM.setVgap(20);
            MediaMenuMGBM.setHgap(30);
            TextField MediaTitleTF = new TextField();
            TextField MediaNFCTF = new TextField(); // number of copies
            TextField MediaCodeTF = new TextField();
            RadioButton GameRB = new RadioButton("Game");
            GameRB.setSelected(true);
            RadioButton MovieRB = new RadioButton("Movie");
            RadioButton AlbumRB = new RadioButton("Album");
            HBox MediaChoice = new HBox();
            MediaChoice.setSpacing(10);
            MediaChoice.getChildren().addAll(new Label("           "),GameRB,MovieRB,AlbumRB);
            ToggleGroup MediaChoiceTG = new ToggleGroup();
            GameRB.setToggleGroup(MediaChoiceTG);
            MovieRB.setToggleGroup(MediaChoiceTG);
            AlbumRB.setToggleGroup(MediaChoiceTG);
            VBox mediaMenuVB = new VBox();
            Button mediaOkB = new Button("OK");
            mediaMenuVB.setSpacing(20);
            mediaMenuVB.setAlignment(Pos.CENTER);
            mediaMenuVB.getChildren().addAll(new Label("Please choose the media type then click OK"), MediaChoice,mediaOkB);
            Scene mediaSceneM = new Scene(mediaMenuVB,300,100);
            // end of main media menu code
            // Game menu code
        GridPane MediaMenuMGBG = new GridPane();
            MediaMenuMGBG.setVgap(20);
            MediaMenuMGBG.setHgap(30);
            TextField MediaTitleGTF = new TextField();
            TextField MediaNFCGTF = new TextField(); // number of copies
            TextField MediaCodeGTF = new TextField();
            TextField GameWaightB = new TextField();
            Button AddGB = new Button("Add",addIVG);
            Button RemoveGameB = new Button("Remove", removeIVG);
            Button findGameB = new Button("Find",searchIVG);
            MediaMenuMGBG.add(new Label("Game Title:"),0,0);
            MediaMenuMGBG.add(MediaTitleGTF,1,0);
            MediaMenuMGBG.add(new Label("game code:"),0,1);
            MediaMenuMGBG.add(MediaCodeGTF,1,1);
            MediaMenuMGBG.add(new Label("Game number of copies:"),0,2);
            MediaMenuMGBG.add(MediaNFCGTF,1,2);
            MediaMenuMGBG.add(new Label("Game Waight:"),0,3);
            MediaMenuMGBG.add(GameWaightB,1,3);
            Button backGB = new Button("Back",BackIVG);
            HBox ButtonGRow = new HBox();
            ButtonGRow.setSpacing(20);
            ButtonGRow.getChildren().addAll(findGameB,AddGB,RemoveGameB,backGB);
            MediaMenuMGBG.add(ButtonGRow,1,4);
            MediaMenuMGBG.setPadding(new Insets(15,15,15,15));
            Scene GameMenuS = new Scene(MediaMenuMGBG,700,480);

            Label GameStatsL = new Label();
            GameStatsL.setTextFill(Color.web("#ff0000", 0.8));
            TextArea GameTA = new TextArea();
            GameTA.setText("=====================Game information=====================\n" + z.gameData());
            GameTA.setEditable(false);
            MediaMenuMGBG.add(new Label("Game Data:"),0,6);
            MediaMenuMGBG.add(GameStatsL,1,5);
            MediaMenuMGBG.add(GameTA,1,6);

            //end of game menu code
            // Movie menu code
        GridPane MediaMenuMGBV = new GridPane();
            MediaMenuMGBV.setVgap(20);
            MediaMenuMGBV.setHgap(30);
            MediaMenuMGBV.setPadding(new Insets(15,15,15,15));
            MediaMenuMGBV.add(new Label("Movie Title:"),0,0);
            MediaMenuMGBV.add(MediaTitleTF,1,0);
            MediaMenuMGBV.add(new Label("Movie Code:"),0,1);
            MediaMenuMGBV.add(MediaCodeTF,1,1);
            MediaMenuMGBV.add(new Label("Movie number of copies:"),0,2);
            MediaMenuMGBV.add(MediaNFCTF,1,2);
            MediaMenuMGBV.add(new Label("Movie Rating:"),0,3);
            RadioButton DRRB = new RadioButton("DR");
            DRRB.setSelected(true);
            RadioButton ACRB = new RadioButton("AC");
            RadioButton HRRB = new RadioButton("HR");
            HBox mediaRating = new HBox();
            mediaRating.setSpacing(10);
            mediaRating.getChildren().addAll(DRRB,HRRB,ACRB);
            ToggleGroup mtg = new ToggleGroup();
            DRRB.setToggleGroup(mtg);
            ACRB.setToggleGroup(mtg);
            HRRB.setToggleGroup(mtg);
            MediaMenuMGBV.add(mediaRating,1,3);
            Button backMB = new Button("Back",BackIVV);
            Button AddMovieB = new Button("Add",addIVV);
            Button RemoveMovieB = new Button("Remove",removeIVV);
            Button SearchMovieB = new Button("Search",searchIVG);
            HBox ButtomMRow = new HBox();
            ButtomMRow.setSpacing(20);
            ButtomMRow.getChildren().addAll(SearchMovieB,RemoveMovieB,AddMovieB,backMB);
            MediaMenuMGBV.add(ButtomMRow,1,4);
            TextArea MovieTA = new TextArea();
            MovieTA.setEditable(false);
            Label movieSL = new Label();
            movieSL.setTextFill(Color.web("#ff0000", 0.8));
            MediaMenuMGBV.add(movieSL,1,5);
            MediaMenuMGBV.add(new Label("Movie Data:"),0,6);
            MediaMenuMGBV.add(MovieTA,1,6);
            MovieTA.setText("=====================Movie information=====================\n" + z.movieData());
            Scene MovieS = new Scene(MediaMenuMGBV,700,480);
            // end on movie menu code
            // Album code
        GridPane MediaMenuMGBA = new GridPane();
            MediaMenuMGBA.setVgap(20);
            MediaMenuMGBA.setHgap(30);
            MediaMenuMGBA.setPadding(new Insets(15,15,15,15));
            Button addAlbumB = new Button("Add",addIVA);
            Button removeAlbumB = new Button("Remove",removeIVA);
            Button searchAlbumB = new Button("Search",searchIVA);
            Button backAlbumB = new Button("Back",BackIVA);
            TextField AlbumTitleTF = new TextField();
            TextField AlbumCodeTF = new TextField();
            TextField AlubumArtistTF = new TextField();
            TextField AlbumSongsTF = new TextField();
            TextField numberOCTF = new TextField();
            Label albumSL = new Label();
            albumSL.setTextFill(Color.web("#ff0000", 0.8));
            TextArea albumTA = new TextArea();
            albumTA.setEditable(false);
            albumTA.setText("=====================Album information=====================\n" + z.albumData());
            MediaMenuMGBA.add(new Label("Album Title:"),0,0);
            MediaMenuMGBA.add(AlbumTitleTF,1,0);
            MediaMenuMGBA.add(new Label("Album code:"),0,1);
            MediaMenuMGBA.add(AlbumCodeTF,1,1);
            MediaMenuMGBA.add(new Label("Album number of copies:"),0,2);
            MediaMenuMGBA.add(numberOCTF,1,2);
            MediaMenuMGBA.add(new Label("Album artist:"),0,3);
            MediaMenuMGBA.add(AlubumArtistTF,1,3);
            MediaMenuMGBA.add(new Label("Album songs:"),0,4);
            MediaMenuMGBA.add(AlbumSongsTF,1,4);
            HBox albumHB = new HBox();
            albumHB.setSpacing(20);
            albumHB.getChildren().addAll(searchAlbumB,addAlbumB,removeAlbumB,backAlbumB);
            MediaMenuMGBA.add(albumHB,1,5);
            MediaMenuMGBA.add(albumSL,1,6);
            MediaMenuMGBA.add(new Label("Album's Data:"),0,7);
            MediaMenuMGBA.add(albumTA,1,7);
            Scene albumScene = new Scene(MediaMenuMGBA,700,480);
            // end of Album code
            // rent code
        GridPane rentPage = new GridPane();
            Image addtocartI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\addtocart.png");
            ImageView addtocartIV = new ImageView(addtocartI);
            Image chechoutI = new Image("C:\\Users\\fajoo\\OneDrive\\Desktop\\photos\\checkout.png");
            ImageView checkoutIV = new ImageView(chechoutI);
            rentPage.setVgap(20);
            rentPage.setHgap(30);
            rentPage.setPadding(new Insets(15,15,15,15));
            TextField customerIDTF = new TextField();
            TextArea CustomerDataTA = new TextArea();
            CustomerDataTA.setEditable(false);
            TextField MediaCodeRTF = new TextField();
            TextArea MediaDataRTA = new TextArea();
            MediaDataRTA.setEditable(false);
            Button AddToCartB = new Button("Add to cart",addtocartIV);
            Button checkoutB = new Button("Process cart",checkoutIV);
            Button backRB = new Button("Back",BackIVR);
            Button ReturnB = new Button("Return media",returnIV);
            Button RemoveFCB = new Button("Remove from cart:", removeIVR);
            Label rentSL = new Label();
            rentSL.setTextFill(Color.web("#ff0000", 0.8));
            HBox rentHB = new HBox();
            rentHB.setSpacing(20);
            rentHB.getChildren().addAll(AddToCartB,RemoveFCB,checkoutB,ReturnB,backRB);
            rentPage.add(new Label("Cutomer ID:"),0,0);
            rentPage.add(customerIDTF,1,0);
            rentPage.add(new Label("Customer Data"),0,1);
            rentPage.add(CustomerDataTA,1,1);
            rentPage.add(new Label("Media Code"),0,2);
            rentPage.add(MediaCodeRTF,1,2);
            rentPage.add(new Label("Media Data"),0,3);
            rentPage.add(MediaDataRTA,1,3);
            rentPage.add(rentHB,1,4);
            rentPage.add(rentSL,1,5);
            Scene rentS = new Scene(rentPage,850,480);
            // end of rent code


        Scene mainMenuScene = new Scene(MainMenuGp, 700, 480);
        Scene customerMenuScene = new Scene(CustomerMenuGp, 700, 480);





        BackCB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        backGB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        backMB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        backAlbumB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        backGB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        CustomerMenuB.setOnAction(e -> {
            stage.setScene(customerMenuScene);
        });

        MediaMenuB.setOnAction(e -> {
            mediaStage.setScene(mediaSceneM);
            mediaStage.show();
        });

        mediaOkB.setOnAction(e -> {
            if (GameRB.isSelected()){
                stage.setScene(GameMenuS);
                mediaStage.close();
            } else if (MovieRB.isSelected()){
                stage.setScene(MovieS);
                mediaStage.close();
            } else if (AlbumRB.isSelected()){
                stage.setScene(albumScene);
                mediaStage.close();
            }
        });

        RentMenuB.setOnAction(e -> {
            stage.setScene(rentS);
        });

        backRB.setOnAction(e -> {
            stage.setScene(mainMenuScene);
        });

        AddCustomerB.setOnAction(e -> {
            if (CustomerNameTF.getText().equals("") == true || CustomerIdTF.getText().equals("") == true || CustomerAddressTF.getText().equals("") == true || CustomermobileTF.getText().equals("") == true) {
                ErrorStats.setText("Error: All the Data are important please fill all the text fields");
            } else {
                if (z.checkID(CustomerIdTF.getText()) == false) {
                    ErrorStats.setText("Error: Id already exists");
                } else {
                    String plan = "";
                    if (unlimatedRB.isSelected() == true) {
                        plan = "UNLIMITED";
                    } else if (limitedRB.isSelected() == true) {
                        plan = "LIMITED";
                    }
                    z.addCustomer(CustomerNameTF.getText(), CustomerAddressTF.getText(), plan, CustomerIdTF.getText(), CustomermobileTF.getText());
                    try {
                        cdr.write(CustomerNameTF.getText() + " : " + CustomerAddressTF.getText() + " : " + plan + " : " + CustomerIdTF.getText() + " : " + CustomermobileTF.getText() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    ErrorStats.setText("A customer was add successfully");
                    CustomerNameTF.setText("");
                    CustomerIdTF.setText("");
                    CustomerAddressTF.setText("");
                    CustomermobileTF.setText("");
                }
            }
            CustomerDataPTA.setText("=====================Customers information=====================\n" + z.getAllCustomersInfo());

        });

        RemoveCustomerB.setOnAction(e -> {
            if (CustomerIdTF.getText().equals("") == true){
                ErrorStats.setText("Error: An id is needed to remove");
            } else {
                if (z.removeCustomer(CustomerIdTF.getText()) == true){
                    ErrorStats.setText("customer id: " + CustomerIdTF.getText() + " was removed!!!");
                } else {
                    ErrorStats.setText("Error: Customer id dose not exists");
                }
            }
            CustomerDataPTA.setText("=====================Customers information=====================\n" + z.getAllCustomersInfo());
        });

        findCustomerB.setOnAction(e -> {
            if (z.findCustomer(CustomerIdTF.getText()) == -1){
                ErrorStats.setText("Error: id dose not exists");
                CustomerDataPTA.setText("=====================Customers information=====================\n" + z.getAllCustomersInfo());
            } else {
                int x = z.findCustomer(CustomerIdTF.getText());
                ErrorStats.setText("customer id: " + CustomerIdTF.getText() + " was found!!!");
                CustomerDataPTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
            }
        });

        // start of game buttons code
        AddGB.setOnAction(e -> {
            if (MediaTitleGTF.getText().equals("") == true || MediaNFCGTF.getText().equals("") == true || MediaCodeGTF.getText().equals("") == true || GameWaightB.getText().equals("") == true){
                GameStatsL.setText("Error: All the Data are important please fill all the text fields");
            } else {
                if (z.mediacheackcode(MediaCodeGTF.getText()) == true){
                    z.addGame(MediaTitleGTF.getText(),Integer.parseInt(MediaNFCGTF.getText()),Double.parseDouble(GameWaightB.getText()),MediaCodeGTF.getText());
                    try {
                        mdr.write("Game : " + MediaTitleGTF.getText() + " : " + MediaNFCGTF.getText()+ " : "+GameWaightB.getText()+ " : " +MediaCodeGTF.getText()+ "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    GameStatsL.setText("A game was added");
                    MediaTitleGTF.setText("");
                    MediaNFCGTF.setText("");
                    MediaCodeGTF.setText("");
                    GameWaightB.setText("");
                } else {
                    GameStatsL.setText("Error: Game code already exists");
                }

            }
            GameTA.setText("=====================Game information=====================\n" + z.gameData());
        });


        customerIDTF.setOnAction(e -> {
            CustomerDataTA.setText(z.findCustomerData(customerIDTF.getText()));
        });

        RemoveGameB.setOnAction(e -> {
            if (MediaCodeGTF.getText().equals("") == true){
                GameStatsL.setText("Error: Please enter an id");
            } else {
                if (z.removeMedia(MediaCodeGTF.getText()) == true)
                    GameStatsL.setText("The game was removed");
                else
                    GameStatsL.setText("Error: ID dose not exists");
            }
            GameTA.setText("=====================Game information=====================\n" + z.gameData());
        });

        findGameB.setOnAction(e -> {
            if (MediaCodeGTF.getText().equals("") == true){
                GameStatsL.setText("Error: Please enter an id");
                GameTA.setText("=====================Game information=====================\n" + z.gameData());
            } else {
                if (z.findMedia(MediaCodeGTF.getText()) > -1)
                    GameTA.setText("=====================Game information=====================\n" + z.getMedia().get(z.findMedia(MediaCodeGTF.getText())).toString());
                else {
                    GameStatsL.setText("Error: Wrong id");
                    GameTA.setText("=====================Game information=====================\n" + z.gameData());
                }

            }
        });
        // end of game button code
        // movie button code
        AddMovieB.setOnAction(e -> {
            if (MediaTitleTF.getText().equals("") || MediaCodeTF.getText().equals("") || MediaNFCTF.getText().equals("")){
                movieSL.setText("Error: All the Data are important please fill all the text fields");
            } else {
                if (z.mediacheackcode(MediaCodeTF.getText()) == true){
                    if (ACRB.isSelected()) {
                        z.addMovie(MediaTitleTF.getText(), Integer.parseInt(MediaNFCTF.getText()), "AC", MediaCodeTF.getText());
                        try {
                            mdr.write("Movie : " + MediaTitleTF.getText() + " : " + MediaNFCTF.getText() + " : AC : " + MediaCodeTF.getText() + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else if (DRRB.isSelected()) {
                        z.addMovie(MediaTitleTF.getText(), Integer.parseInt(MediaNFCTF.getText()), "DR", MediaCodeTF.getText());
                        try {
                            mdr.write("Movie : " + MediaTitleTF.getText() + " : " + MediaNFCTF.getText() + " : DR : " + MediaCodeTF.getText() + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else if (HRRB.isSelected()) {
                        z.addMovie(MediaTitleTF.getText(), Integer.parseInt(MediaNFCTF.getText()), "HR", MediaCodeTF.getText());
                        try {
                            mdr.write("Movie : " + MediaTitleTF.getText() + " : " + MediaNFCTF.getText() + " : HR : " + MediaCodeTF.getText() + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    movieSL.setText("A movie was added");
                    MediaTitleTF.setText("");
                    MediaCodeTF.setText("");
                    MediaNFCTF.setText("");
                }
                movieSL.setText("The code already exists");
            }
            MovieTA.setText("=====================Movie information=====================\n" + z.movieData());
        });
        RemoveMovieB.setOnAction( e -> {
            if (MediaCodeTF.getText().equals("")){
                movieSL.setText("Error: An id is required to remove a Movie");
            } else {
                if (z.removeMedia(MediaCodeTF.getText()))
                    movieSL.setText("A Movie was removed");
                else
                    movieSL.setText("Error: There is no media with that id");
            }
            MovieTA.setText("=====================Game information=====================\n" + z.movieData());
        });

        SearchMovieB.setOnAction(e -> {
            if (MediaCodeTF.getText().equals("") == true){
                movieSL.setText("Error: Please enter an id");
                MovieTA.setText("=====================Game information=====================\n" + z.movieData());
            } else {
                if (z.findMedia(MediaCodeTF.getText()) > -1)
                    MovieTA.setText("=====================Game information=====================\n" + z.getMedia().get(z.findMedia(MediaCodeTF.getText())).toString());
                else {
                    movieSL.setText("Error: Wrong id");
                    MovieTA.setText("=====================Game information=====================\n" + z.movieData());
                }

            }
        });
        // end of movie buttons code
        // Album buttons code
        addAlbumB.setOnAction(e -> {
            if (AlbumTitleTF.getText().equals("") || AlbumCodeTF.getText().equals("") || AlubumArtistTF.getText().equals("") || AlbumSongsTF.getText().equals("") || numberOCTF.getText().equals("")){
                albumSL.setText("Error: All the Data are important please fill all the text fields");
            } else {
                if (z.mediacheackcode(AlbumCodeTF.getText()) == true){
                    z.addAlbum(AlbumTitleTF.getText(),Integer.parseInt(numberOCTF.getText()),AlubumArtistTF.getText(),AlbumSongsTF.getText(),AlbumCodeTF.getText());
                    try {
                        mdr.write("Album : " + AlbumTitleTF.getText() + " : " + numberOCTF.getText() + " : " + AlubumArtistTF.getText() + " : " + AlbumSongsTF.getText() + " : " + AlbumCodeTF.getText() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    addAlbumB.setText("");
                    removeAlbumB.setText("");
                    searchAlbumB.setText("");
                    backAlbumB.setText("");
                }
                albumSL.setText("Error: id is already exists");
            }
            albumTA.setText("=====================Album information=====================\n" + z.albumData());
        });

        removeAlbumB.setOnAction(e -> {
            if (AlbumCodeTF.getText().equals("")){
                albumSL.setText("Error: An id is required to remove a Album");
            } else {
                if (z.removeMedia(AlbumCodeTF.getText()))
                    albumSL.setText("An album was removed");
                else
                    albumSL.setText("Error: There is no media with that id");
            }
            albumTA.setText("=====================Album information=====================\n" + z.albumData());
        });


        searchAlbumB.setOnAction( e -> {
            if (AlbumCodeTF.getText().equals("") == true){
                albumSL.setText("Error: Please enter an id");
                albumTA.setText("=====================Album information=====================\n" + z.albumData());
            } else {
                if (z.findMedia(AlbumCodeTF.getText()) > -1)
                    albumTA.setText("=====================Album information=====================\n" + z.getMedia().get(z.findMedia(AlbumCodeTF.getText())).toString());
                else {
                    albumSL.setText("Error: Wrong id");
                    albumTA.setText("=====================Album information=====================\n" + z.albumData());
                }

            }
        });

        customerIDTF.setOnAction(e -> {
            if (z.findCustomer(customerIDTF.getText()) == -1){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: id dose not exists");
            } else {
                int x = z.findCustomer(customerIDTF.getText());
                rentSL.setText("");
                CustomerDataTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
            }
        });

        MediaCodeRTF.setOnAction(e -> {
            if (MediaCodeRTF.getText().equals("") == true){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please enter media code");
            } else {
                if (z.findMedia(MediaCodeRTF.getText()) > -1) {
                    rentSL.setText("");
                    MediaDataRTA.setText("=====================media information=====================\n" + z.getMedia().get(z.findMedia(MediaCodeRTF.getText())).toString());
                }
                else {
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: Wrong media code");
                }

            }
        });

        AddToCartB.setOnAction(e -> {
            if (customerIDTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the customer id section");
            } else if (MediaCodeRTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the media code section");
            } else {
                int result = z.addToCart(customerIDTF.getText(), MediaCodeRTF.getText());
                if (result == -1) {
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: This customer is not in our database");
                } else if (result == -2) {
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: This media is not in our database");
                } else if (result == -3) {
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: You already have this media in your cart");
                } else if (result == 1) {
                    rentSL.setTextFill(Color.web("#00A813", 0.8));
                    rentSL.setText("The media was added to your cart");
                    int x = z.findCustomer(customerIDTF.getText());
                    CustomerDataTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
                }
            }
        });

        RemoveFCB.setOnAction(e -> {
            if (customerIDTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the customer id section");
            } else if (MediaCodeRTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the media code section");
            } else {
                int result = z.removeFromCart(customerIDTF.getText(),MediaCodeRTF.getText());
                if (result == 1){
                    rentSL.setTextFill(Color.web("#00A813", 0.8));
                    rentSL.setText("The media was removed to your cart");
                    int x = z.findCustomer(customerIDTF.getText());
                    CustomerDataTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
                } else if (result == -1){
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: Something went wrong");
                }
            }
        });
        checkoutB.setOnAction(e -> {
            if (customerIDTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the customer id section");
            } else {
                String data;
                data = z.processRequests(customerIDTF.getText());
                if (data.equals("")){
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: Customer cart is empty");
                } else {
                    rentSL.setTextFill(Color.web("#00A813", 0.8));
                    rentSL.setText("All done");
                    MediaDataRTA.setText(data);
                    int x = z.findCustomer(customerIDTF.getText());
                    CustomerDataTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
                }
            }
        });

        ReturnB.setOnAction(e -> {
            int customerPlace = -1;


            if (customerIDTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the customer id section");
            } else if (MediaCodeRTF.getText().equals("")){
                rentSL.setTextFill(Color.web("#ff0000", 0.8));
                rentSL.setText("Error: Please fill the media code section");
            } else {
                boolean returnS = z.returnMedia(customerIDTF.getText(),MediaCodeRTF.getText());
                if (returnS == true){
                    rentSL.setTextFill(Color.web("#00A813", 0.8));
                    rentSL.setText("All done");
                    MediaDataRTA.setText("Customer: [" + z.getCustomerName(customerIDTF.getText()) + "] returned: [" + z.findMediaName(MediaCodeRTF.getText()) + "]");
                } else {
                    rentSL.setTextFill(Color.web("#ff0000", 0.8));
                    rentSL.setText("Error: Something wrong happened");
                }
                int x = z.findCustomer(customerIDTF.getText());
                CustomerDataTA.setText("=====================Customers information=====================\n" + z.getCustomer().get(x).toString());
            }

        });


        stage.setTitle("Media Rental System");
        stage.setScene(mainMenuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        try {
            mdr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            cdr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}