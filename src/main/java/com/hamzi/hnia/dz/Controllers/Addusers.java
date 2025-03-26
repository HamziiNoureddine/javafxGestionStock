package com.hamzi.hnia.dz.Controllers;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;
import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.ModelsFX.UsersFX;
import com.hamzi.hnia.dz.Services.rolesService;
import com.hamzi.hnia.dz.Services.usersService;
import com.hamzi.hnia.dz.Utils.DialogUtil;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import javafx.util.Duration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static javafx.application.Application.launch;

@Component
public class Addusers implements Initializable {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField pseudo;

    @FXML
    private TextField email;

    @FXML
    private PasswordField motdepasse;

    @FXML
    private PasswordField retaperpasse;

    @FXML
    private CheckBox Admin;

    @FXML
    private CheckBox Utilisateur;

    @FXML
    private CheckBox Ajout;

    @FXML
    private CheckBox Modifier;

    @FXML
    private CheckBox Supprimer;

    @FXML
    private Button addButton;

    @FXML
    private FontAwesomeIconView passEYE;
    @FXML
    private FontAwesomeIconView repassEYE;
    @FXML
    private FontAwesomeIconView passEYES;
    @FXML
    private FontAwesomeIconView repassEYES;

    @FXML
    private Label pseudoError;
    @FXML
    private Label emailError;
    @FXML
    private Label passwordError;
    @FXML
    private Label retapError;

    @FXML
    private Label roleError;

    Map<Label,String> validationMessage =new HashMap<>();

    Integer selectedRows;
    Integer filtredRows;
    @FXML
    private TableView<UsersFX> listUserTable;


    @FXML
    private TableColumn<UsersFX,String> pseudoCell;


    @FXML
    private TableColumn<UsersFX,String> emailCells;
    @FXML
    private TableColumn<UsersFX,String>  roleCell;

    @FXML
    private TableColumn<UsersFX, Void> optionCells;
    @FXML
    private TextField viewpassText;

    @FXML
    private TextField viewrepassText;

    @FXML
    private TextField rechercher;

    private final  Map<Label,String> validateMessage = new HashMap<>();
    private final List<String> listRoles = new ArrayList<>();

    private final ObservableList<UsersFX> obsListUsers = FXCollections.observableArrayList();


    private final usersService userService;
    private final PasswordEncoder passwordEncoder;
    private final rolesService roleService;
    private  Users user;
    private ObservableList<UsersFX> filteredUsers=FXCollections.observableArrayList();

    public Addusers(usersService userService, PasswordEncoder passwordEncoder, rolesService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeViewpassText();
        if (user != null)
            user = null;
        listRoles.clear();

        obsListUsers.clear();
        listRoles.add("Utilisateur");
        reloadListUsers();

        pseudoCell.setCellValueFactory(new PropertyValueFactory<>("Username"));
        emailCells.setCellValueFactory(new PropertyValueFactory<>("Email"));
        roleCell.setCellValueFactory(new PropertyValueFactory<>("Roles"));

        optionCells.setCellFactory(createDeleteButtonCellFactory(listUserTable) );




       // listUserTable.setItems(obsListUsers);
        searchUser();

//        rechercher.textProperty().addListener(( observableValue,  odlValue, newValue)->{
//
//                if(!newValue.isEmpty()) {
//                    searchUser();
//                }else {
//                    listUserTable.setItems(obsListUsers);
//                    listUserTable.refresh();
//                };
//            });


        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), rootPane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    @FXML
    public void addUser(ActionEvent event){
        validateMessage.clear();
        clearLabelMessage();
        setValidationMessage();
        if(!validateMessage.isEmpty())
                return;


        List<Roles> roleListe = extractSelectedRoles();
        Users user =new Users();
        user.setUsername(pseudo.getText());
        user.setPassword(passwordEncoder.encode(motdepasse.getText()));
        user.setEmail(email.getText());
        user.setRoles(roleListe);
        Users users = userService.addUser(user);
        UsersFX usersFX = new UsersFX(users);
        obsListUsers.add(usersFX);

    }
    @FXML
    public void addRoles(ActionEvent event){
       if ( ((CheckBox)event.getSource()).isSelected()){
          listRoles.add(((CheckBox) event.getSource()).getText());
           System.out.println(listRoles);
       }else{
           listRoles.remove(((CheckBox) event.getSource()).getText());
           System.out.println(listRoles);
       }
    }
    public void getSelected(){
      clearControlle();
      clearLabelMessage();
      selectedRows = listUserTable.getSelectionModel().getSelectedIndex();

        if (selectedRows < 0) return;
        user =  userService.getuserByUsername(pseudoCell.getCellData(selectedRows));
        System.out.println(filteredUsers.size() +" : "+ obsListUsers.size());
        if(!filteredUsers.isEmpty()){
            System.out.println("is inferieur");
            filtredRows  = listUserTable.getSelectionModel().getSelectedIndex();
            selectedRows = obsListUsers.indexOf(obsListUsers.stream()
                    .filter(usersFX -> usersFX.getUsername().equals(user.getUsername()))
                    .findFirst().orElse(null));

            System.out.println(selectedRows + " : "+filtredRows);
        }

       listRoles.clear();
       Utilisateur.setSelected(false);
       Admin.setSelected(false);
       Ajout.setSelected(false);
       Modifier.setSelected(false);
       Supprimer.setSelected(false);
       user.getRoles().forEach(roles -> {


              if (Admin.getText().equals(roles.getDesignationRole().name()) ){
                  Admin.setSelected(true);
                  listRoles.add("Admin");
              }

              else if (Utilisateur.getText().equals(roles.getDesignationRole().name())) {
                  Utilisateur.setSelected(true);
                  listRoles.add("Utilisateur");
              }  else if (Ajout.getText().equals(roles.getDesignationRole().name())) {
                  Ajout.setSelected(true);
                  listRoles.add("Ajout");
              } else if (Modifier.getText().equals(roles.getDesignationRole().name())) {
                  Modifier.setSelected(true);
                  listRoles.add("Modifier");
              }  else if (Supprimer.getText().equals(roles.getDesignationRole().name())) {
                  Supprimer.setSelected(true);
                  listRoles.add("Supprimer");
              }
       });

        pseudo.setText(user.getUsername());
        email.setText(user.getEmail()!=null?user.getEmail():"");
        Integer codeUser = user.getCodeUser();

      //  listUserTable.setItems(obsListUsers);

    }

@FXML
private void modifUser(ActionEvent event ){
    System.out.println(selectedRows);
       validateMessage.clear();
       clearLabelMessage();
       setValidationMessage();
    if(!validateMessage.isEmpty())
        return;


    List<Roles> roleListe = extractSelectedRoles();
       user.setRoles(roleListe);
       user.setUsername(pseudo.getText());
       user.setEmail(email.getText());
       if(!motdepasse.getText().isEmpty())
           user.setPassword(passwordEncoder.encode((motdepasse.getText())));
      Users userModif =  userService.addUser(user);
    if (selectedRows == null || selectedRows < 0) return;
       obsListUsers.set(selectedRows,new UsersFX(userModif));
//       if(!filteredUsers.isEmpty()){
//          // filteredUsers.set(filtredRows,new UsersFX(userModif));
//           rechercher.clear();
//           listUserTable.setItems(obsListUsers);
//           listUserTable.getSelectionModel().select(selectedRows);
//
//       }

     }
public void reloadListUsers(){
    obsListUsers.clear();
    List<UsersFX> usersFx = new ArrayList<>();
    List<Users> listusers = userService.listUsers();

    listusers.forEach(users -> {

        UsersFX user = new UsersFX(users);
        obsListUsers.add(user);
    });
}


public void searchUser() {
//    String searchValue = rechercher.getText().trim().toLowerCase();
//
//    if (searchValue.isEmpty()) {
//        System.out.println("searchValue is Empty");
//     // Restore full list if search is empty
//        return;
//    }
//
//// Filter the list and update TableView
//    filteredUsers = obsListUsers.stream()
//                .filter(user ->
//                        user.getUsername().toLowerCase().contains(searchValue) ||
//                                user.getEmail().toLowerCase().contains(searchValue) ||
//                                user.getRoles().toLowerCase().contains(searchValue)
//                )
//                .collect(Collectors.toCollection(FXCollections::observableArrayList));
//
//
//        listUserTable.setItems(filteredUsers);
    FilteredList<UsersFX> filteredList = new FilteredList<>(obsListUsers, p -> true);
    filteredUsers = filteredList;

    // Search Field


    // Bind filtering logic to searchField text
    filteredList.predicateProperty().bind(Bindings.createObjectBinding(() ->
                    user ->  {
                        String filter = rechercher.getText().toLowerCase();
                        if (filter.isEmpty()) return true; // Show all if empty

                        return user.getUsername().toLowerCase().contains(filter) ||
                                user.getEmail().toLowerCase().contains(filter) ||
                                user.getRoles().toLowerCase().contains(filter);
                    },
            rechercher.textProperty()
    ));

    listUserTable.setItems(filteredList);


}
public void setValidationMessage(){
       if(pseudo.getText().isEmpty() || pseudo.getText().length() < 5)
            validateMessage.put(pseudoError,"Ce champ est obligatoire et doit contenir au minimum 5 caractères.");
        else{ pseudoError.setVisible(false);}

        if(email != null) {
            Matcher matcher = pattern.matcher(email.getText());
            if (!matcher.matches())
                validateMessage.put(emailError, "Ce champ doit respecter le format *****@*****");
            else {
                emailError.setVisible(false);
            }
        }
         if( user== null ) {
             if (motdepasse.getText().isEmpty() || motdepasse.getText().length() < 8)
                 validateMessage.put(passwordError, "Ce champ est obligatoire et doit contenir au minimum 8 caractères.");
             else {
                 passwordError.setVisible(false);
             }
         }
    if( user== null ) {
        if (retaperpasse.getText().isEmpty() || retaperpasse.getText().length() < 5)
         validateMessage.put(retapError, "Ce champ est obligatoire et doit contenir au minimum 5 caractères.");
        else if (!motdepasse.getText().equals(retaperpasse.getText())) {
            validateMessage.put(retapError, "le mot de passe ne correspond pas.");
        } else {
            retapError.setVisible(false);
        }
    }else {
        if (!motdepasse.getText().equals(retaperpasse.getText())) {
            validateMessage.put(retapError, "le mot de passe ne correspond pas.");
        } else {
            retapError.setVisible(false);
        }
    }
    if (listRoles.isEmpty() )
        validateMessage.put(roleError,"Ce champ est obligatoire vous devez selectionner au minimum 1 Role.");
    else{ roleError.setVisible(false);}
      //  addButton.setDisable(!validateMessage.isEmpty());

    if(!validateMessage.isEmpty()){
        validateMessage.forEach((key,value)->{
            key.setStyle("""
                        -fx-background-color: rgba(255, 0, 0, 0.3); \
                         -fx-text-fill: orange; /* Text color */
                            -fx-padding: 1px 5px; /* Padding for spacing */
                            -fx-border-color: red; /* Border matching text */
                            -fx-border-width: 1px;\s
                            -fx-border-radius: 5px; /* Rounded border */""");
            key.setText(value);
            key.setVisible(true);

        });


    }

    }

    public void clearLabelMessage(){
        pseudoError.setText("");
        pseudoError.setVisible(false);
        emailError.setText("");
        emailError.setVisible(false);
        passwordError.setText("");
        passwordError.setVisible(false);
        retapError.setText("");
        retapError.setVisible(false);
        roleError.setText("");
        roleError.setVisible(false);
    }

    public void clearControlle(){
        if(user!=null)
            user = null;
        pseudo.setText("");
        email.setText("");
        motdepasse.setText("");
        retaperpasse.setText("");
    }
   @FXML
    public void viewPassword(MouseEvent event){
       System.out.println("Clicked fontawesomeiconview");


       if( event.getSource() == passEYES ) {
            passEYES.setVisible(false);
            viewpassText.setVisible(true);
            viewpassText.setManaged(true);
            passEYE.setVisible(true);



        } else if (event.getSource() == passEYE) {
           passEYES.setVisible(true);
           viewpassText.setVisible(false);
           viewpassText.setManaged(false);
           passEYE.setVisible(false);
       } else if ( event.getSource() == repassEYES) {
           repassEYES.setVisible(false);
           viewrepassText.setVisible(true);
           viewrepassText.setManaged(true);
           repassEYE.setVisible(true);
       } else if (event.getSource() == repassEYE) {
           repassEYES.setVisible(true);
           viewrepassText.setVisible(false);
           viewrepassText.setManaged(false);
           repassEYE.setVisible(false);
       }
   }

   public void initializeViewpassText(){
       viewpassText.setManaged(false);
       viewpassText.setVisible(false);
       viewpassText.textProperty().bindBidirectional(motdepasse.textProperty());
       passEYE.setVisible(false);
       viewrepassText.setManaged(false);
       viewrepassText.setVisible(false);
       viewrepassText.textProperty().bindBidirectional(retaperpasse.textProperty());
       repassEYE.setVisible(false);
   }
    private List<Roles> extractSelectedRoles() {
        return listRoles.stream()
                .map(role -> roleService.getRolesByDesignation(RolesType.valueOf(role)))
                .collect(Collectors.toList());
    }

    private Callback<TableColumn<UsersFX, Void>, TableCell<UsersFX, Void>> createDeleteButtonCellFactory(TableView<UsersFX> tableView) {
        return param -> new TableCell<UsersFX, Void>() {
            private final Button deleteButton = new Button();

            {
                double imageSize = 40;
                // Create FontAwesome delete icon
                 FontAwesomeIconView deleteIcon = new FontAwesomeIconView();
                 deleteIcon.setGlyphName("TRASH");
                 deleteIcon.setFill(Color.color(1,1,1));
                 deleteIcon.setSize("25");
             //   deleteIcon.setFitWidth(imageSize);
//                Rectangle clip = new Rectangle(imageSize, imageSize);
//                clip.setArcWidth(5 * 2); // Apply horizontal corner radius
//                clip.setArcHeight(5 * 2); // Apply vertical corner radius
//                deleteIcon.setClip(clip); // Apply circular clip to image
              //  deleteIcon.setStyle("-fx-fill: white; -fx-font-size: 16px;");
                deleteButton.setGraphic(deleteIcon);
                deleteButton.setStyle(
                        "-fx-background-color: transparent; " +  // No background
                                "-fx-border-color: transparent; " +      // No border
                                "-fx-padding: 0; " +                     // Remove padding
                                "-fx-cursor: hand;"                      // Set cursor to hand on hover
                );

                // Handle delete button click
                deleteButton.setOnAction(event -> {
                   boolean yes = DialogUtil.showConfirmationDialog(Alert.AlertType.CONFIRMATION,"Confirmer","Estvous sur de vouloir supprimer");
                   if(yes) {
                       UsersFX userFx = getTableView().getItems().get(getIndex());
                       Users userDel = userService.getuserByUsername(userFx.getUsername());
                       userService.supprimeUtilisateur(userDel);
                       DialogUtil.showConfirmationDialog(Alert.AlertType.INFORMATION,"Information","Suppression Efectué avec succès");
                       getTableView().getItems().remove(userFx);
                       if (!filteredUsers.isEmpty()) {


                           selectedRows = obsListUsers.indexOf(obsListUsers.stream()
                                   .filter(usersFX -> usersFX.getUsername().equals(userDel.getUsername()))
                                   .findFirst().orElse(null));

                           System.out.println(selectedRows + " : " + filtredRows);

                           // filteredUsers.set(filtredRows,new UsersFX(userModif));
                           obsListUsers.remove((int) selectedRows);
                           rechercher.clear();
                           listUserTable.setItems(obsListUsers);
                           listUserTable.refresh();

                       }
                   }else{
                       DialogUtil.showConfirmationDialog(Alert.AlertType.INFORMATION,"Information","Vous avez Annuler la supprission de cet Utilisateur");
                   }

                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);  // Hide button in empty rows
                } else {
                    setGraphic(deleteButton);
                }
            }




        };
    }
    }







