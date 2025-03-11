package com.hamzi.hnia.dz.Controllers;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;
import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.ModelsFX.UsersFX;
import com.hamzi.hnia.dz.Services.rolesService;
import com.hamzi.hnia.dz.Services.usersService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    private TableView<UsersFX> listUserTable;


    @FXML
    private TableColumn<UsersFX,String> pseudoCell;

    @FXML
    private TableColumn<UsersFX,String> emailCells;
    @FXML
    private TableColumn<UsersFX,String>  roleCell;

    @FXML
    private TableColumn<Node, Button> optionCells;


    private final  Map<Label,String> validateMessage = new HashMap<>();
    private final List<String> listRoles = new ArrayList<>();

    private final ObservableList<UsersFX> obsListUsers = FXCollections.observableArrayList();


    private final usersService userService;
    private final PasswordEncoder passwordEncoder;
    private final rolesService roleService;
    private  Users user;

    public Addusers(usersService userService, PasswordEncoder passwordEncoder, rolesService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        if(user != null)
            user = null;
        listRoles.clear();

         obsListUsers.clear();
        listRoles.add("Utilisateur");
        reloadListUsers();

        pseudoCell.setCellValueFactory(new PropertyValueFactory<>("Username"));
        emailCells.setCellValueFactory(new PropertyValueFactory<>("Email"));
        roleCell.setCellValueFactory(new PropertyValueFactory<>("Roles"));
        listUserTable.setItems(obsListUsers);
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


        List<Roles> roleListe = new ArrayList<>();
        listRoles.forEach(roles->{
            Roles role = roleService.getRolesByDesignation(RolesType.valueOf(roles));
            roleListe.add(role);
        });
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

       user =  userService.getuserByUsername(pseudoCell.getCellData(selectedRows));
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
        listUserTable.setItems(obsListUsers);

    }

@FXML
private void modifUser(ActionEvent event ){
       validateMessage.clear();
       clearLabelMessage();
       setValidationMessage();
    if(!validateMessage.isEmpty())
        return;


    List<Roles> roleListe = new ArrayList<>();
       listRoles.forEach(roles->{

        Roles role = roleService.getRolesByDesignation(RolesType.valueOf(roles));
        roleListe.add(role);
    });
       user.setRoles(roleListe);
       user.setUsername(pseudo.getText());
       user.setEmail(email.getText());
       if(!motdepasse.getText().isEmpty())
           user.setPassword(passwordEncoder.encode((motdepasse.getText())));
      Users userModif =  userService.addUser(user);
    System.out.println(userModif);
         reloadListUsers();

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
        System.out.println("validation is executed.....................");
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




        }
        }
    }





