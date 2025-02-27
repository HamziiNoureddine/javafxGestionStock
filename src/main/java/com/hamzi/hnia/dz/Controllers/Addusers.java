package com.hamzi.hnia.dz.Controllers;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;
import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.ModelsFX.UsersFX;
import com.hamzi.hnia.dz.Services.rolesService;
import com.hamzi.hnia.dz.Services.usersService;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

@Component
public class Addusers implements Initializable {
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
    private Label pseudoError;
    @FXML
    private Label emailError;
    @FXML
    private Label passwordError;
    @FXML
    private Label retapError;

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

    public Addusers(usersService userService, PasswordEncoder passwordEncoder, rolesService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listRoles.add("Utilisateur");
        List<UsersFX> usersFx = new ArrayList<>();
        List<Users> listusers = userService.listUsers();

        listusers.forEach(users -> {
            UsersFX user = new UsersFX(users);
            obsListUsers.add(user);
        });

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
      selectedRows = listUserTable.getSelectionModel().getSelectedIndex();

       Users user =  userService.getuserByUsername(pseudoCell.getCellData(selectedRows));
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
        email.setText(user.getEmail());

        Integer codeUser = user.getCodeUser();
        listUserTable.setItems(obsListUsers);


    }
}


