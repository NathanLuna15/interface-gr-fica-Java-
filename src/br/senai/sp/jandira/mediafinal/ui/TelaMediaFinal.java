package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaMediaFinal extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setTitle("Media do aluno");

        //painel primcipal (root)
        BorderPane root = new BorderPane();

        //criar o label com o titulo da tela
        Label titulo = new Label();
        titulo.setText("Escola SENAI \"prof. vicente Amato\"");
        titulo.setStyle("-fx-font-size: 22; -fx-text-fill:white");
        titulo.setPadding(new Insets(10, 0, 10, 10));

        HBox painelSuperior = new HBox();
        painelSuperior.getChildren().addAll(titulo);
        painelSuperior.setStyle("-fx-background-color: #1a58c9");

        //formulario
        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(10, 20, 10, 10));
        Label lblNome = new Label("Nome do aluno");
        Label lblNota1 = new Label("Nota 1");
        Label lblNota2 = new Label("Nota 2");
        Label lblNota3 = new Label("Nota 3");
        Label lblNota4 = new Label("Nota 4");
        TextField tfNomeAluno = new TextField();
        TextField tfNome1 = new TextField();
        TextField tfNome2 = new TextField();
        TextField tfNome3 = new TextField();
        TextField tfNome4 = new TextField();

        painelFormulario.getChildren().addAll(
                lblNome,tfNomeAluno,
                lblNota1,tfNome1,
                lblNota2,tfNome2,
                lblNota3,tfNome3,
                lblNota4,tfNome4
        );

        //Botão
        VBox painelBotao = new VBox();
        painelBotao.setStyle("-fx-background-color: #1a58c9");
        painelBotao.setPadding(new Insets(10));
        painelBotao.setSpacing(15);
        Button btCaucularMedia = new Button("calcular media");
        btCaucularMedia.setPrefWidth(150);
        btCaucularMedia.setPrefHeight(70);
        Button btLimpar = new Button("Linpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(70);
         Button btSair = new Button("Sair");
         btSair.setPrefWidth(150);
         btSair.setPrefHeight(70);
         painelBotao.getChildren().addAll(
                 btCaucularMedia,
                 btLimpar,
                 btSair
         );

         //Resultado
         VBox painelResultado = new VBox();
        painelResultado.setStyle("-fx-background-color: #386dcf");
         Label lblResultado = new Label("Resultado");
         Label lblNomeResultado = new Label("Nome");
         Label lblMedia = new Label("Media");
         Label lblsitua = new Label("Situação");
         painelResultado.getChildren().addAll(
                 lblResultado,
                 lblNomeResultado,
                 lblMedia,
                 lblsitua
         );





        root.setTop(painelSuperior);
        root.setCenter(painelFormulario);
        root.setRight(painelBotao);
        root.setBottom(painelResultado);


        //obijeto cena
        Scene scene = new Scene(root);

        stage.setScene(scene);


        stage.show();
    }
}
